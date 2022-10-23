package biz.global.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Parent {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long parent_id;

    private String firstName;
    
    private String lastName;
    
    private String password;
    
    private Boolean active_deactive = true;
    
    private LocalDate data_modified = LocalDate.now();
    private String type = "parent";
    
    @OneToOne(targetEntity = Student.class, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "student_id", name = "student_parent")
    private Student student;

    private Long student_id;
    

    public Parent() {
        super();
    }
    
    

    public Parent(String firstName, String lastName, String password, Student student) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.student = student;
        
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

  
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive_deactive() {
        return active_deactive;
    }

    public void setActive_deactive(Boolean active_deactive) {
        this.active_deactive = active_deactive;
    }

    public LocalDate getData_modified() {
        return data_modified;
    }

    public void setData_modified(LocalDate data_modified) {
        this.data_modified = data_modified;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }
    
    

}
