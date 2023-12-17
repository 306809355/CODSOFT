//TASK-02
import java.util.ArrayList;
import java.util.Scanner;

class GradeCalculator {
    private int total = 0;
    private double avg = 0.0;
    ArrayList<Integer> marks = new ArrayList<>();

    public void addSubjectMark(int mark) {
        marks.add(mark);
    }

    public int calculateTotal() {
        for (int it : marks) {
            total += it;
        }
        return total;
    }

    public double calculateAverage() {
        int numberOfSubjects = marks.size();
        avg = (double) total / numberOfSubjects;
        return avg;
    }

    public String calculateGrade() {
        if (avg > 95) return "O (Outstanding)";
        else if (avg > 90) return "A+ (Excellent)";
        else if (avg > 80) return "A (Very Good)";
        else if (avg > 70) return "B+ (Good)";
        else if (avg > 60) return "B (Satisfactory)";
        else if (avg > 50) return "C (Average)";
        return "F (Fail)";
    }
}

public class Student {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeCalculator gradeCalculator = new GradeCalculator();
        
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();
        System.out.println("\n*********************************************************");
        System.out.println();

        int i = 1;
        while (i <= numberOfSubjects) {
            System.out.print("Enter the mark for subject " + i + ": ");
            int mark = scanner.nextInt();
            System.out.println();
            
            while (mark < 0 || mark > 100) {
                System.out.print("Please enter a valid mark (0-100): ");
                mark = scanner.nextInt();
                System.out.println();
            }
            
            gradeCalculator.addSubjectMark(mark);
            i++;
        }
        System.out.println("\n**********************************************************\n");
        int totalMarks = gradeCalculator.calculateTotal();
        double average = gradeCalculator.calculateAverage();
        String grade = gradeCalculator.calculateGrade();
        
        System.out.println("Total marks: " + totalMarks + "\n");
        System.out.println("Average: " + average + "\n");
        System.out.println("Grade: " + grade + "\n");

        scanner.close();
    }
}
