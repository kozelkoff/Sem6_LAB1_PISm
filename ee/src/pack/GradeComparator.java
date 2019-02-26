package pack;

import java.util.Comparator;

public class GradeComparator implements Comparator<Student> {
    public int compare(Student o1, Student o2)
    {
        if(o1.getGrade()> o2.getGrade())
            return 1;
        else if(o1.getGrade()< o2.getGrade())
            return -1;
        else
            return 0;
    }
}
