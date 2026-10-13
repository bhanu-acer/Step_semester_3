public class Scorecard {
    private boolean[] results;
    private int recorded;

    public Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        recorded = 0;
    }

    public void recordAnswer(boolean correct) {
        if (recorded < results.length) {
            results[recorded] = correct;
            recorded++;
        }
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < recorded; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }

    public static void main(String[] args) {
        Scorecard scorecard = new Scorecard(4);

        scorecard.recordAnswer(true);
        scorecard.recordAnswer(true);
        scorecard.recordAnswer(false);
        scorecard.recordAnswer(true);

        System.out.println("Score: " + scorecard.getScore());
    }
}