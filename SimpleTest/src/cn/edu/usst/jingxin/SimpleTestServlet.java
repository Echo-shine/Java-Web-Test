package cn.edu.usst.jingxin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleTestServlet
 */
@WebServlet("/SimpleTestServlet")
public class SimpleTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		//request.getContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String quest1=request.getParameter("question1");
		String quest2=request.getParameter("question2");
		String[] quest3=request.getParameterValues("question3");
		String quest4=request.getParameter("question4").trim();
		String username=request.getParameter("username");
		String department=request.getParameter("department");//parameter获得的数据是value
		String DeOut="";
		if(department.equals("1")) DeOut="计算机系";
		if(department.equals("2")) DeOut="机械系";
		if(department.equals("3")) DeOut="管理工程系";
		if(department.equals("4")) DeOut="数学系";
		if(department.equals("5")) DeOut="光电工程系";
		
		int score=0;
		if(quest1!=null&&quest1.equals("1")) score+=25;
		if(quest2!=null&&quest2.equals("3"))  score+=25;
		if(quest3!=null&&quest3.length==2&&quest3[0].equals("1")&&quest3[1].equals("3")){//String是一种特殊的数组
			 score+=25;
		}
		if(quest4!=null&&(quest4.equals("HttpServlet")||quest4.equals("javax.servlet.http.HttpServlet")))  score+=25;
		
		out.println("<html><head>");
		out.println("<title>测试结果</title>");
		out.println("</head><body>");
		out.println("姓名："+username+"<p>");
		out.println("院系："+DeOut+"<p>");
		out.println("你的成绩是："+score);
		out.println("</body></html>");

	}

}
