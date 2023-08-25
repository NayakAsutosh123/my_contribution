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
@WebServlet("/update")
public class UpdateBookServlet extends GenericServlet{
public BookDAO ob = null;
public void init() throws ServletException{
ob = new BookDAO();
}
public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException{
int k = ob.update(req);
PrintWriter pw = res.getWriter();
res.setContentType("text/html");
if(k>0) {
pw.println("<h1>Book Details Updated Successfully</h1><br>");
 RequestDispatcher rd =req.getRequestDispatcher("link.html");
 rd.include(req, res);
}
}
public void destroy() {
ob=null;
}
}
