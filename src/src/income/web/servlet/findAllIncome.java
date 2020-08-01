package income.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import income.domain.Income;
import income.service.IncomeService;

/**
 * Servlet implementation class findAllIncome
 */
//@WebServlet("/findAllIncome")
public class findAllIncome extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String[]> paramMap = request.getParameterMap();
		String[] values = paramMap.get("username");
		String username = StringUtils.substring(values[0], 0, values[0].length() - 1);
		
//		HttpSession session=request.getSession(false);
		
//		String username = (String) session.getAttribute("session_user");
		IncomeService incomeservice = new IncomeService();
		try {
			request.setAttribute("IncomeList", incomeservice.findallIncome(username));
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			List<Income> li = incomeservice.findallIncome(username);
			PrintWriter out = response.getWriter();
			
			out.print("<table><tr><th>income_id</th><th>user_id</th><th>in_date</th><th>description</th><th>amount</th><th>tags</th><th>actions</th>");
			for(int i = 0; i < li.size();i++){
				out.print("<tr><td>");
				out.println(li.get(i).getIncome_id());
				out.print("</td>");
				out.print("<td>");
				out.println(li.get(i).getUser_id());
				out.print("</td>");
				out.print("<td>");
				out.println(li.get(i).getIn_date());
				out.print("</td>");
				out.print("<td>");
				out.println(li.get(i).getDescription());
				out.print("</td>");
				out.print("<td>");
				out.println(li.get(i).getAmount());
				out.print("</td>");
				out.print("<td>");
				out.println(li.get(i).getTags());
				out.print("</td>");
				out.print("<td>\n<a href=\"/edit-income.jsp\">Edit</a>\n"+ 
						"&nbsp;&nbsp;&nbsp;&nbsp;\n" + 
						"<a href=\"/delete?id=<c:out value=" +li.get(i).getIncome_id()+"/>\">Delete</a>\n"+ 
						"</td>");
				
			}
			out.print("</table>");
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
