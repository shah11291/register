import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Adding
 */
@WebServlet("/Adding")
public class Adding extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adding() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 response.setContentType("text/html");  
		
         PrintWriter pw = response.getWriter(); 
          
         Connection conn=null;
         String url="jdbc:mysql://localhost:3306/";
         String dbName="employee";
         String driver="com.mysql.jdbc.Driver";
		
         try{  
             // String name = request.getParameter("name");  
              String id = request.getParameter("id");  
              String mobile = request.getParameter("mobile");  
              String address = request.getParameter("address");  
              String name = request.getParameter("name");  
         
        
pw.println("m here");

             Class.forName(driver).newInstance();  
             conn = DriverManager.getConnection(url+dbName,"root", "root");
             PreparedStatement pst =(PreparedStatement) conn.prepareStatement("insert into emp(name,id,mobile,address) values(?,?,?,?)");
  
System.out.println("omg preparedst");
 pst.setString(1,name);  
pst.setString(2,id);        
pst.setString(3,mobile);
pst.setString(4,address);

int i = pst.executeUpdate();
//String  st2="insert into emp(name,id,mobile,address,) values('"+name+"','"+id+"','"+mobile+"','"+address+"')";




System.out.println("inserting");

//conn.commit(); 
String msg=" ";
if(i!=0){  
  msg="Record has been inserted";
  pw.println("<font size='6' color=blue>" + msg + "</font>");  


}  
else{  
  msg="failed to insert the data";
  pw.println("<font size='6' color=blue>" + msg + "</font>");
 }  
pst.close();
}  
catch (Exception e){  
pw.println(e);  
}  

}

}


