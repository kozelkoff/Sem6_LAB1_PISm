package pack;

public class Student {
    String surname;
    float mark;
    int grade;

    public String getSurname() {
        return surname;
    }

    public float getMark() {
        return mark;
    }

    public int getGrade() {
        return grade;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    Student(String s, float m, int g){
        surname = s;
        mark = m;
        grade = g;
    }
}
