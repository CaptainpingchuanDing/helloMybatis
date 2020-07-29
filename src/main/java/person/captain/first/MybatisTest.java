package person.captain.first;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import person.captain.mapper.StudentMapper;
import person.captain.pojo.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    public static void main(String[] args) throws IOException {

        test1();
    }
    private static void  test1()throws IOException {
        // 根据 mybatis-config.xml 配置的信息得到 sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session
        SqlSession session = sqlSessionFactory.openSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);

//        List<Student> list = studentMapper.listStudent();
//        System.out.println(list);

//        Student student = new Student();
//        student.setId(4);
//        student.setName("新增加的学生");
//        List<Student> list = studentMapper.getStudent(student);
//        System.out.println(list);

        // todo mybatis sql注入
//        List<Student> list2 = studentMapper.getStudentByName("'新增加的学生' or 1=1");
//        List<Student> list2 = studentMapper.getStudentByName("'新增加的学生'");
//        System.out.println(list2);

        // todo # 和 $ 区别
        List<Student> list3 = studentMapper.getStudentByNameAndId("'新增加的学生' or 1=1", 4);
        System.out.println(list3);

        session.commit();
        session.flushStatements();
        session.close();

    }


    private static void add() throws IOException {
        // 根据 mybatis-config.xml 配置的信息得到 sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session
        SqlSession session = sqlSessionFactory.openSession();

        // 增加学生
        Student student1 = new Student();
//        student1.setId(4);
        student1.setStudentID(6);
        student1.setName("tom");
        session.insert("addStudent", student1);

        // 最后通过 session 的 selectList() 方法调用 sql 语句 listStudent
        List<Student> listStudent = session.selectList("listStudent");
        for (Student student : listStudent) {
            System.out.println("ID:" + student.getId() + ",NAME:" + student.getName());
        }

        // 提交修改
        session.commit();
        // 关闭 session
        session.close();
    }

    private static void delete() throws IOException {
        // 根据 mybatis-config.xml 配置的信息得到 sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session
        SqlSession session = sqlSessionFactory.openSession();

        // 删除学生
//        Student student2 = new Student();
//        student2.setId(1);
//        session.delete("deleteStudent", student2);

        session.delete("deleteStudent", 2);


        // 最后通过 session 的 selectList() 方法调用 sql 语句 listStudent
        List<Student> listStudent = session.selectList("listStudent");
        for (Student student : listStudent) {
            System.out.println("ID:" + student.getId() + ",NAME:" + student.getName());
        }

        // 提交修改
        session.commit();
        // 关闭 session
        session.close();
    }

    private static void update() throws IOException {
        // 根据 mybatis-config.xml 配置的信息得到 sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session
        SqlSession session = sqlSessionFactory.openSession();

        // 获取学生
        Student student3 = session.selectOne("getStudent", 3);

        // 修改学生
        student3.setName("修改的学生");
        session.update("updateStudent", student3);

        // 最后通过 session 的 selectList() 方法调用 sql 语句 listStudent
        List<Student> listStudent = session.selectList("listStudent");
        for (Student student : listStudent) {
            System.out.println("ID:" + student.getId() + ",NAME:" + student.getName());
        }

        // 提交修改
        session.commit();
        // 关闭 session
        session.close();
    }

    private static void findStudentByName() throws IOException {

        // 根据 mybatis-config.xml 配置的信息得到 sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session
        SqlSession session = sqlSessionFactory.openSession();

        // 模糊查询
        List<Student> students = session.selectList("findStudentByName", "修改");
        for (Student student : students) {
            System.out.println("ID:" + student.getId() + ",NAME:" + student.getName());
        }
    }

    public static void test() throws Exception {
        // 根据 mybatis-config.xml 配置的信息得到 sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session
        SqlSession session = sqlSessionFactory.openSession();

        // 增加学生
        Student student1 = new Student();
        student1.setId(4);
        student1.setStudentID(4);
        student1.setName("新增加的学生");
        session.insert("addStudent", student1);

        // 删除学生
        Student student2 = new Student();
        student2.setId(1);
        session.delete("deleteStudent", student2);

        // 获取学生
        Student student3 = session.selectOne("getStudent", 2);

        // 修改学生
        student3.setName("修改的学生");
        session.update("updateStudent", student3);

        // 最后通过 session 的 selectList() 方法调用 sql 语句 listStudent
        List<Student> listStudent = session.selectList("listStudent");
        for (Student student : listStudent) {
            System.out.println("ID:" + student.getId() + ",NAME:" + student.getName());
        }

        // 提交修改
        session.commit();
        // 关闭 session
        session.close();


    }
}
