package bookliabrary;

import java.sql.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import jakarta.servlet.ServletRequest;
public class BookDAO {
public int k=0;
public int insert(BookBean bb) {
try {
Connection con =
ConnectionDAO.getCon();//Accessing the Connection
PreparedStatement ps =con.prepareStatement("insert into BookDetails42 values(?,?,?,?,?)");
ps.setString(1,bb.getCode());
ps.setString(2,bb.getName());
ps.setString(3,bb.getAuthor());
ps.setFloat(4,bb.getPrice());
ps.setInt(5, bb.getQty());
k = ps.executeUpdate();
}
catch(Exception e) {e.printStackTrace();}
return k;
}
public int delete(BookBean bb) {
try {
Connection con =
ConnectionDAO.getCon();
PreparedStatement ps =
con.prepareStatement
("delete from BookDetails42 where code=?");
ps.setString(1,bb.getCode());
k=ps.executeUpdate();
}
catch(Exception e) {e.printStackTrace();}
return k;
}
public BookBean bb=null;
public BookBean retrieve(ServletRequest req)
{
try {
Connection con =
ConnectionDAO.getCon();
PreparedStatement ps =
con.prepareStatement
("select * from BookDetails42 where code=?");
ps.setString(1, req.getParameter("code"));
ResultSet rs = ps.executeQuery();
if(rs.next()) {
bb = new BookBean();//Bean object
bb.setCode(rs.getString(1));
bb.setName(rs.getString(2));
bb.setAuthor(rs.getString(3));
bb.setPrice(rs.getFloat(4));
bb.setQty(rs.getInt(5));
}
}catch(Exception e) {e.printStackTrace();}
return bb;
}
public int update(ServletRequest req) {
try {
Connection con
=ConnectionDAO.getCon();
PreparedStatement ps =
con.prepareStatement
("update BookDetails42 set name=?,author=?,price=?,qty=? where code=?");
ps.setString(1,req.getParameter("name"));
ps.setString(2,req.getParameter("author"));
ps.setFloat(3,Float.parseFloat(req.getParameter("price")));
ps.setInt(4,Integer.parseInt(req.getParameter(
"qty")));
ps.setString(5,req.getParameter("code"));
k = ps.executeUpdate();
}catch(Exception e) {e.printStackTrace();}
return k;
}
public ArrayList<BookBean> al = new
ArrayList<BookBean>();
public ArrayList<BookBean> retrieve()
{
try {
Connection con =
ConnectionDAO.getCon();
PreparedStatement ps =
con.prepareStatement
("select * from BookDetails42");
ResultSet rs = ps.executeQuery();
while(rs.next())
{
BookBean bb = new
BookBean();//Bean object
bb.setCode(rs.getString(1));
bb.setName(rs.getString(2));
bb.setAuthor(rs.getString(3));
bb.setPrice(rs.getFloat(4));
bb.setQty(rs.getInt(5));
al.add(bb);//Adding bean to ArrayList
}//end of loop
}catch(Exception e)
{e.printStackTrace();}
return al;
}
}
