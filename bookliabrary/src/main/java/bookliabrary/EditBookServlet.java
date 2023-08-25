package bookliabrary;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditBookServlet extends GenericServlet{
public BookDAO ob=null;
public void init() throws ServletException{
ob=new BookDAO();
}
public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
{
BookBean bb = ob.retrieve(req);
PrintWriter pw = res.getWriter();
res.setContentType("text/html");
if(bb==null) {
pw.println("<h1>Invalid BookCode</h1><br>");
RequestDispatcher rd =req.getRequestDispatcher("editbook.html");
rd.include(req, res);
}
else {
pw.println("<form action='update' method='post'>");
pw.println("<input type='hidden'name='code' value='"+bb.getCode()+"'>");
pw.println("<h1>BookName:</h1><input type='text' name='name'value='"+bb.getName()+"'><br>");
pw.println("<h1>BookAuthor:</h1><input type='text' name='author'value='"+bb.getAuthor()+"'><br>");
pw.println("<h1>BookPrice:</h1><input type='text' name='price'value='"+bb.getPrice()+"'><br>");
pw.println("<h1>Quantity:</h1><inputtype='text' name='qty'value='"+bb.getQty()+"'><br></br>");
pw.println("<input type='submit'value='Update'><br>");
pw.println("</form>");
}
}
public void destroy() {
ob=null;
}
}

