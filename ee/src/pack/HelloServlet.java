package pack;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;


public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    ArrayList<Student> students = new ArrayList<>();
    public void performTask(HttpServletRequest req, HttpServletResponse resp){
        try{

            String surnameString, markString, gradeString;
            for(int i=0; i<5; i++){
                surnameString = req.getParameter("surname"+i);
                markString = req.getParameter("mark"+i);
                gradeString = req.getParameter("grade"+i);
                float markValue = Float.parseFloat(markString);
                int gradeValue = Integer.parseInt(gradeString);

                Student student = new Student(surnameString, markValue, gradeValue);
                students.add(student);



            }
            HTMLRender(req, resp);

        }catch (Throwable e){
            e.printStackTrace();
        }
    }

   public void HTMLRender(HttpServletRequest req, HttpServletResponse resp) {
       try {
           PrintWriter out = resp.getWriter();
           resp.setContentType("text/html; charset=CP1251");

           out.println("<HTML><HEAD>");
           out.println("<TITLE>FormResponse</TITLE>");
           out.println("</HEAD><BODY>");
           out.println("<TABLE BORDER=1 ALIGN = CENTER>");
           out.println("<TR><TD COLSPAN = 3>Sorted by surname</TD></TR>");
           out.println("<TR><TD>Surname</TD><TD>Mark</TD><TD>Grade</TD></TR>");

           Collections.sort(students, new SurnameComparator());
           for(int i=0; i<5; i++){
               out.println("<TR><TD>"+students.get(i).getSurname()+"</TD>");
               out.println("<TD>"+students.get(i).getMark()+"</TD>");
               out.println("<TD>"+students.get(i).getGrade()+"</TD></TR>");
           }
           out.println("</TABLE>");

           out.println("<TABLE BORDER=1 ALIGN = CENTER>");
           out.println("<TR><TD COLSPAN = 3>Sorted by mark</TD></TR>");
           out.println("<TR><TD>Surname</TD><TD>Mark</TD><TD>Grade</TD></TR>");

           Collections.sort(students, new MarkComparator());
           for(int i=0; i<5; i++){
               out.println("<TR><TD>"+students.get(i).getSurname()+"</TD>");
               out.println("<TD>"+students.get(i).getMark()+"</TD>");
               out.println("<TD>"+students.get(i).getGrade()+"</TD></TR>");
           }
           out.println("</TABLE>");


           out.println("<TABLE BORDER=1 ALIGN = CENTER>");
           out.println("<TR><TD COLSPAN = 3>Sorted by grade</TD></TR>");
           out.println("<TR><TD>Surname</TD><TD>Mark</TD><TD>Grade</TD></TR>");

           Collections.sort(students, new GradeComparator());
           for(int i=0; i<5; i++){
               out.println("<TR><TD>"+students.get(i).getSurname()+"</TD>");
               out.println("<TD>"+students.get(i).getMark()+"</TD>");
               out.println("<TD>"+students.get(i).getGrade()+"</TD></TR>");
           }
           out.println("</TABLE>");

           out.println("</BODY></HTML>");
           out.close();
       } catch (Throwable e){
           e.printStackTrace();
       }
   }
}
