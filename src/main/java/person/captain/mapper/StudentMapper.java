package person.captain.mapper;

import org.apache.ibatis.annotations.Param;
import person.captain.pojo.Student;

import java.util.List;

public interface StudentMapper {

    List<Student> listStudent();
    List<Student> getStudent(Student student);
    List<Student> getStudentByName(String name );
    List<Student> getStudentByNameAndId(@Param("name") String name , @Param("id") int id);
    List<Student> addStudent(Student student);

//    List<Student> getStudentByNameAndId( String name , int id);

}
