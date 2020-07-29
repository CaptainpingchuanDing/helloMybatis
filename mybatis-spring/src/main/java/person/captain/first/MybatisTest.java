//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package person.captain.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import person.captain.pojo.Student;

public class MybatisTest {
    public MybatisTest() {
    }

    public static void main(String[] args) throws IOException {
        findStudentByName();
    }

    private static void add() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        Student student1 = new Student();
        student1.setId(4);
        student1.setStudentID(4);
        student1.setName("新增加的学生");
        session.insert("addStudent", student1);
        List<Student> listStudent = session.selectList("listStudent");
        Iterator var6 = listStudent.iterator();

        while(var6.hasNext()) {
            Student student = (Student)var6.next();
            System.out.println("ID:" + student.getId() + ",NAME:" + student.getName());
        }

        session.commit();
        session.close();
    }

    private static void delete() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        session.delete("deleteStudent", 2);
        List<Student> listStudent = session.selectList("listStudent");
        Iterator var5 = listStudent.iterator();

        while(var5.hasNext()) {
            Student student = (Student)var5.next();
            System.out.println("ID:" + student.getId() + ",NAME:" + student.getName());
        }

        session.commit();
        session.close();
    }

    private static void update() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        Student student3 = (Student)session.selectOne("getStudent", 3);
        student3.setName("修改的学生");
        session.update("updateStudent", student3);
        List<Student> listStudent = session.selectList("listStudent");
        Iterator var6 = listStudent.iterator();

        while(var6.hasNext()) {
            Student student = (Student)var6.next();
            System.out.println("ID:" + student.getId() + ",NAME:" + student.getName());
        }

        session.commit();
        session.close();
    }

    private static void findStudentByName() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        List<Student> students = session.selectList("findStudentByName", "修改");
        Iterator var5 = students.iterator();

        while(var5.hasNext()) {
            Student student = (Student)var5.next();
            System.out.println("ID:" + student.getId() + ",NAME:" + student.getName());
        }

    }
}
