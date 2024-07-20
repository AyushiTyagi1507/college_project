//import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 *
 * @author Ayushi
 */
//@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
//create the query
    //private static final String INSERT_QUERY="INSERT INTO webtable  VALUES(?,?,?,?)";
    
    
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        //set content type
     response.setContentType("text/html");
     //get printWriter
     PrintWriter out=response.getWriter();
     out.println("<h2>Welcome to Register Servlet</h2>");
     //read the form value
//     String name=request.getParameter("name");
//     String email = request.getParameter("email");
//     String mobile = request.getParameter("mobile");
//     String message = request.getParameter("message");
          //load the jdbc driver
          
       try
          {  
               //load the driver
              Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/studata","root"," ");
           //System.out.println("Program connected");   
               // create the prepared statement object
        PreparedStatement ps=conn.prepareStatement("insert into stutable values(?,?,?,?)");  
       String name=request.getParameter("name");
       String email = request.getParameter("email");
       String mobile = request.getParameter("mobile");
       String message = request.getParameter("message");
      ps.setString(1,name); 
      ps.setString(2,email);
      ps.setString(3,mobile);
      ps.setString(4, message);
//           
            int i= ps.executeUpdate();  
            if(i>0)  
              out.print("You are successfully registered...");  
              ps.close();
              //out.println("<h2>try</h2>");
               
          }
          catch (Exception ex)
          {
               ex.printStackTrace();
                out.println("You are not successfully registered...");
          }  
        out.close();
    }
    }


    
    
    
  
     
     
    
     

