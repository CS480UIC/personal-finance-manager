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

import org.apache.commons.lang3.StringUtils;

import income.domain.Income;
import income.service.IncomeService;

/**
 * Servlet implementation class FindIncomeTag
 */
//@WebServlet("/FindIncomeTag")
public class FindIncomeTag extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindIncomeTag() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String,String[]> paramMap = request.getParameterMap();
		String[] values = paramMap.get("user_id");
		String user_id = StringUtils.substring(values[0], 0, values[0].length() - 1);
		
		values = paramMap.get("income_month");
		String month = values[0];
		
		values = paramMap.get("tag");
		String tag = values[0];
		
		IncomeService incomeservice = new IncomeService();
		
		request.setAttribute("IncomeList", incomeservice.FindIncomeTag(user_id,month,tag));
		
		List<Income> li = incomeservice.FindIncomeTag(user_id,month,tag);
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
//			out.print("<td>\n<a href=\"/edit-income.jsp\">Edit</a>\n"+ 
//					"&nbsp;&nbsp;&nbsp;&nbsp;\n" + 
//					"<a href=\"/delete?id=<c:out value=" +li.get(i).getIncome_id()+"/>\">Delete</a>\n"+ 
//					"</td>");
			
		}
		out.print("</table>");
		
	}

}
