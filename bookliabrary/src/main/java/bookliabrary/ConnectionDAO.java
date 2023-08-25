package bookliabrary;

import java.sql.*;
public class ConnectionDAO {
private static Connection con=null;
private ConnectionDAO() {}
static
{
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
con = DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:orcl","system","lion");
}
catch(Exception e) {e.printStackTrace();}
}
public static Connection getCon() {
return con;
}
}
