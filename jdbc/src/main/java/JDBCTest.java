import java.sql.*;

public class JDBCTest {

    static {
        try {
            //注册数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.err.println(e.getStackTrace());
        }
    }

    public static void main(String[] args) {
//        executePreparedStatement("3");
//        executePreparedStatement("1 or 1=1");
        selectByStatement("1 or 1=1");
        selectByStatement("3");
    }

    public static void executePreparedStatement(String input) {

        System.out.println("\n------executePreparedStatement   studentID: " + input + "------");


        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //取得数据库连接   // todo 问题1 每次都要创建连接、释放连接造成系统资源浪费。
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mybatis", "root", "123");
            // todo 问题2 sql硬编码问题
            String sql = "select * from  student where studentID = ? ";
            //进行预编译，这里进行参数设置     // todo 问题3 preparedStatement向占有位符号传参数存在硬编码
            ps = conn.prepareStatement(sql);
            ps.setString(1, input);

            //进行编译
            rs = ps.executeQuery();

            // todo 问题4 需要对每一列进行遍历，然后自己组装为对象
            while (rs.next()) {
                String name = rs.getString("name");
                String studentIDStr = rs.getString("studentID");
                System.out.println( "name: "+name + ":" + "studentID: "+studentIDStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {//轻量级，创建和销毁rs所需要的时间和资源较小
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {//轻量级，创建和销毁rs所需要的时间和资源较小
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {//重量级，创建和销毁rs所需要的时间和资源较小
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void selectByStatement(String studentID) {

        System.out.println("\n------selectByStatement  studentID: " + studentID + "------");

        String sql = "select * from  student where studentID = ";
        Connection conn = null;
        Statement ps = null;
        ResultSet rs = null;
        try {
            //取得数据库连接
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mybatis", "root", "123");
            //进行预编译，这里进行参数设置
            ps = conn.createStatement();
            //进行编译
            rs = ps.executeQuery(sql + studentID);
            while (rs.next()) {
                String name = rs.getString("name");
                String studentIDStr = rs.getString("studentID");
                System.out.println( "name: "+name + ":" + "studentID: "+studentIDStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {//轻量级，创建和销毁rs所需要的时间和资源较小
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {//轻量级，创建和销毁rs所需要的时间和资源较小
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {//重量级，创建和销毁rs所需要的时间和资源较小
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void PreparedStatementDemo(String studentID) {

        System.out.println("------executePreparedStatement   studentID: " + studentID + "------");

        String sql = "select * from  student where id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1. 取得数据库连接
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mybatis", "root", "123");
            //2. 进行预编译，这里进行参数设置
            ps = conn.prepareStatement(sql);
            ps.setString(1, studentID);
            //3. 执行
            rs = ps.executeQuery();
            //4. 转换结果
            while (rs.next()) {
                String name = rs.getString("name");
                String studentIDStr = rs.getString("studentID");
                System.out.println( "name: "+name + ":" + "studentID: "+studentIDStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5. 关闭连接，释放资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
