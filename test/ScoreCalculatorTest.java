import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ScoreCalculatorTest {
    private ScoreCalculator subject = new ScoreCalculator();

    @Test
    public void whenAllGutterBalls_theScoreIsZero() {
        rollMany(20, 0);
        assertEquals(0, subject.score());
    }

    @Test
    public void whenAllCommonRolls_theScoreIsTheSumOfRolls() {
        int expected = rollRandom(20);
        assertEquals(expected, subject.score());
    }

    @Test
    public void whenThereIsASpare_itAddsPinsFromTheNextRoll() {
        subject.roll(7);
        subject.roll(3);
        subject.roll(8);
        subject.roll(0);
        int remaining = rollRandom(16);
        assertEquals(remaining + 18 + 8, subject.score());
    }

    @Test
    public void whenThereIsAStrike_itAddsPinsFromTheNextFrame() {
        subject.roll(10);
        subject.roll(4);
        subject.roll(2);
        int remaining = rollRandom(16);
        assertEquals(remaining + 16 + 6, subject.score());
    }

    @Test
    public void whenThereAreAllStrikes_theScoreIs300() {
        rollMany(12, 10);
        assertEquals(300, subject.score());
    }

    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            subject.roll(pins);
        }
    }

    private int rollRandom(int times) {
        int total = 0;
        for (int i = 0; i < times; i++) {
            int pins = new Random().nextInt(5);
            subject.roll(pins);
            total += pins;
        }
        return total;
    }

}