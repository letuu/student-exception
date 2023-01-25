package pro.sky.student;

public class Student {

    //Курсовая 6 - Задача
    //Напишите пример перехвата и обработки исключения с использованием собственных исключений

    private String name;

    private boolean isHomeWorkDone;
    private boolean isCourseWorkDone;
    private boolean isTicketsLearned;

    public Student(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

        Student student = new Student("Vladimir");
        student.submitHomeWork();
//        student.submitCourseWork();
        student.learnTickets();
        try {
            student.exam();
        } catch (StudentIsNotReadyException e) {
            System.out.println(e.getMessage());
            System.out.println("\nПроверяем допуски к экзамену:\n"
                    + "Домашняя работа сдана? " + student.isHomeWorkDone
                    + "\nКурсовая работа сдана? " + student.isCourseWorkDone
                    + "\nБилеты выучены? " + student.isTicketsLearned);
        }
    }

    public void submitHomeWork() {
        System.out.println("Домашняя работа сдана!");
        this.isHomeWorkDone = true;
    }

    public void submitCourseWork() {
        System.out.println("Курсовая работа сдана!");
        this.isCourseWorkDone = true;
    }

    public void learnTickets() {
        System.out.println("Билеты выучены!");
        this.isTicketsLearned = true;
    }

    public void exam() throws StudentIsNotReadyException {
        System.out.println("Идем на экзамен?");
        if (isHomeWorkDone && isCourseWorkDone && isTicketsLearned) {
            System.out.println("Студент " + name + " готов к экзамену!");
        } else {
            throw new StudentIsNotReadyException("Студент " + name + " не допущен к экзамену! Проверьте допуски!");
        }
    }
}
