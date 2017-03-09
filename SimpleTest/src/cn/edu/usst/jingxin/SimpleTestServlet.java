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
		String department=request.getParameter("department");//parameter��õ�������value
		String DeOut="";
		if(department.equals("1")) DeOut="�����ϵ";
		if(department.equals("2")) DeOut="��еϵ";
		if(department.equals("3")) DeOut="������ϵ";
		if(department.equals("4")) DeOut="��ѧϵ";
		if(department.equals("5")) DeOut="��繤��ϵ";
		
		int score=0;
		if(quest1!=null&&quest1.equals("1")) score+=25;
		if(quest2!=null&&quest2.equals("3"))  score+=25;
		if(quest3!=null&&quest3.length==2&&quest3[0].equals("1")&&quest3[1].equals("3")){//String��һ�����������
			 score+=25;
		}
		if(quest4!=null&&(quest4.equals("HttpServlet")||quest4.equals("javax.servlet.http.HttpServlet")))  score+=25;
		
		out.println("<html><head>");
		out.println("<title>���Խ��</title>");
		out.println("</head><body>");
		out.println("������"+username+"<p>");
		out.println("Ժϵ��"+DeOut+"<p>");
		out.println("��ĳɼ��ǣ�"+score);
		out.println("</body></html>");

	}

}
