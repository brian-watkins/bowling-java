import java.util.ArrayList;
import java.util.List;

public class ScoreCalculator {

    private List<Integer> rolls = new ArrayList<>();

    public void roll(int pinsDown) {
        rolls.add(pinsDown);
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int i = 0; i < 10; i++) {
            if (rolls.get(frameIndex) == 10) {
                score += 10 + rolls.get(frameIndex + 1) + rolls.get(frameIndex + 2);
                frameIndex += 1;
            }
            else if (rolls.get(frameIndex) == 0 && rolls.get(frameIndex + 1) == 10) {
                score += 10 + rolls.get(frameIndex + 2) + rolls.get(frameIndex + 3);
                frameIndex += 2;
            }
            else if (isSpareAtFrame(frameIndex)) {
                score += scoreForSpareAtFrame(frameIndex);
                frameIndex += 2;
            } else {
                score += rolls.get(frameIndex) + rolls.get(frameIndex + 1);
                frameIndex += 2;
            }
        }

        return score;
    }

    private int scoreForSpareAtFrame(int i) {
        return 10 + rolls.get(i + 2);
    }

    private boolean isSpareAtFrame(int i) {
        return rolls.get(i) + rolls.get(i + 1) == 10;
    }
}
