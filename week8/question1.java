
import java.util.*;

interface Question {
    String getAnswer();
}

class MCQ implements Question {
    String correctAnswer;

    MCQ(String answer) {
        correctAnswer = answer;
    }

    public String getAnswer() {
        return correctAnswer;
    }
}

class Examination {
    String name;
    ArrayList<Question> questions = new ArrayList<>();

    Examination(String name) {
        this.name = name;
    }

    void addQuestion(Question q) {
        questions.add(q);
    }
}

class Attempt {
    Examination exam;
    HashMap<Integer, String> answers = new HashMap<>();
    boolean submitted = false;

    Attempt(Examination exam) {
        this.exam = exam;
    }

    void answer(int q, String ans) {
        if (submitted) {
            System.out.println("Already submitted!");
            return;
        }

        answers.put(q, ans);
        System.out.println("Question " + q + " answered with '" + ans + "'.");
    }

    void submit() {
        if (submitted) {
            System.out.println("Already submitted!");
            return;
        }

        submitted = true;
        System.out.println("Examination '" + exam.name + "' submitted successfully.");

        int score = 0;

        for (int i = 0; i < exam.questions.size(); i++) {
            if (answers.get(i + 1) != null &&
                answers.get(i + 1).equals(exam.questions.get(i).getAnswer())) {
                score++;
            }
        }

        System.out.println("Result for '" + exam.name + "' attempt: "
                + score + "/" + exam.questions.size() + " correct");
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    Attempt startExam(Examination exam) {
        System.out.println("Examination '" + exam.name
                + "' started by " + name + ".");
        return new Attempt(exam);
    }
}

public class question1 {
    public static void main(String[] args) {

        Examination exam = new Examination("Math Quiz");

        exam.addQuestion(new MCQ("A"));
        exam.addQuestion(new MCQ("B"));

        Student s = new Student("Rahul");

        Attempt a = s.startExam(exam);

        a.answer(1, "A");
        a.answer(2, "C");

        a.submit();
    }
}
