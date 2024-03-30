package homework._05;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class homework05 {
    public static void view(String result,Statement statement,int i) throws SQLException {
        ResultSet resultSet = statement.executeQuery(result);
        if(i == 0){
        while(resultSet.next()){
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String age = resultSet.getString(3);
            String college = resultSet.getString(4);
            System.out.println(id + "\t" + name +"\t" + age  + "\t" + college );
        }
        }
        else{
            while(resultSet.next()){
                if(resultSet.getString(1).equals("s00"+i)){
                    String id = resultSet.getString(1);
                    String name = resultSet.getString(2);
                    String age = resultSet.getString(3);
                    String college = resultSet.getString(4);
                    System.out.println(id + "\t" + name +"\t" + age  + "\t" + college );
                }
            }
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/homework03_mysql";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123456");
        Connection connection = DriverManager.getConnection(url, properties);
        String sql1 = "create table SDU(" +
                "SNO varchar(20)," +
                "Name varchar(10)," +
                "Age Integer," +
                "College varchar(30));";
        String sql2 = "insert into SDU values('s001','老大',20,'计算机')";
        String sql3 = "insert into SDU values('s002','老二',19,'计算机')";
        String sql4 = "insert into SDU values('s003','老三',18,'计算机')";
        String sql5 = "insert into SDU values('s004','老四',17,'计算机')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql1);
        statement.executeUpdate(sql2);
        statement.executeUpdate(sql3);
        statement.executeUpdate(sql4);
        statement.executeUpdate(sql5);
        String result = "select * from SDU";
        System.out.println("=======第一二题======");
       view(result,statement,0);
        System.out.println("=======第三题======");
        statement.executeUpdate("delete from SDU where sno = 's004' ");
        view(result,statement,0);
        System.out.println("=======第四题======");
        view(result,statement,3);
        System.out.println("=======第五题======");
        statement.executeUpdate("update SDU set College ='通信学院' where sno = 's001' ");
        view(result,statement,0);
        statement.close();
        connection.close();


    }

}
