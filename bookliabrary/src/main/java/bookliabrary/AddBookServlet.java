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
@WebServlet("/add")
public class AddBookServlet extends
GenericServlet{
public BookBean bb=null;
public void init() throws ServletException{
bb = new BookBean();//Creating bean object
}
public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
{
bb.setCode(req.getParameter("code"));
bb.setName(req.getParameter("name"));
bb.setAuthor(req.getParameter("author"));
bb.setPrice(Float.parseFloat(req.getParameter("price")));
bb.setQty(Integer.parseInt(req.getParameter("qty")));
int k = new BookDAO().insert(bb);
PrintWriter pw = res.getWriter();
res.setContentType("text/html");
if(k>0)
{
pw.println("<h1>Book AddedSuccessfully</h1><br>");
RequestDispatcher rd =req.getRequestDispatcher("link.html");
rd.include(req, res);
}
}
}

