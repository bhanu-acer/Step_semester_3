import java.util.*;
import java.util.regex.*;
abstract class Question {
    String correct, student; double points;
    Question(String correct, String student, double points) { this.correct = correct; this.student = student; this.points = points; }
    abstract double score();
}
class MCQ extends Question {
    MCQ(String correct, String student, double points) { super(correct, student, points); }
    double score() { return student.equalsIgnoreCase(correct) ? points : 0; }
}
class TF extends Question {
    TF(String correct, String student, double points) { super(correct, student, points); }
    double score() { return student.equalsIgnoreCase(correct) ? points : 0; }
}
class Essay extends Question {
    Essay(String correct, String student, double points) { super(correct, student, points); }
    double score() {
        String[] keywords = correct.split(","); int count = 0; String answer = student.toLowerCase();
        for (String word : keywords) {
            word = word.trim().toLowerCase();
            if (answer.contains(word)) count++;
        }
        if (count >= 2) return points * 0.75;
        if (count == 1) return points * 0.50;
        return 0;
    }
}
public class QG {
    static Question create(String type, String correct, String student, double points) {
        if (type.equals("MCQ")) return new MCQ(correct, student, points);
        if (type.equals("TF")) return new TF(correct, student, points);
        return new Essay(correct, student, points);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine()); double total = 0;
        Pattern pattern = Pattern.compile("^(\\S+)\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+(\\d+)$");
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine(); Matcher m = pattern.matcher(line);
            if (m.matches()) {
                String type = m.group(1); String correct = m.group(3); String student = m.group(4); double points = Double.parseDouble(m.group(5));
                Question q = create(type, correct, student, points);
                double score = q.score();
                System.out.printf("%s: %.2f%n", type, score);
                total += score;
            }
        }
        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}