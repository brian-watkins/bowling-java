import java.util.ArrayList;
import java.util.List;

public class ScoreCalculator {

    private List<Integer> rolls = new ArrayList<>();

    public void roll(int pinsDown) {
        rolls.add(pinsDown);
    }

    public int score() {
        int score = 0;
        int frameStart = 0;
        for (int i = 0; i < 10; i++) {
            if (rolls.get(frameStart) == 10) {
                score += 10 + rolls.get(frameStart + 1) + rolls.get(frameStart + 2);
                frameStart += 1;
            }
            else if (rolls.get(frameStart) + rolls.get(frameStart + 1) == 10) {
                score += 10 + rolls.get(frameStart + 2);
                frameStart += 2;
            }
            else {
                score += rolls.get(frameStart) + rolls.get(frameStart + 1);
                frameStart += 2;
            }
        }

        return score;
    }
}
