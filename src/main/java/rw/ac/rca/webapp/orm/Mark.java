package rw.ac.rca.webapp.orm;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "marks")
public class Mark implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private  String courseName ;

    private  String instructorName;

    private  int averageMarks;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public int getAverageMarks() {
        return averageMarks;
    }

    public void setAverageMarks(int averageMarks) {
        this.averageMarks = averageMarks;
    }
}
