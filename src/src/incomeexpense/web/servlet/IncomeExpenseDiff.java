package incomeexpense.web.servlet;

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

import incomeexpense.domain.IncomeExpense;
import incomeexpense.service.IncomeExpenseService;
import income.domain.Income;
import income.service.IncomeService;

/**
 * Servlet implementation class IncomeExpenseDiff
 */
//@WebServlet("/IncomeExpenseDiff")
public class IncomeExpenseDiff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncomeExpenseDiff() {
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
		Map<String,String[]> paramMap = request.getParameterMap();
		String[] values = paramMap.get("user_id");
		String user_id = StringUtils.substring(values[0], 0, values[0].length() - 1);
		
//		values = paramMap.get("month");
//		String month = values[0];
		
		IncomeExpenseService incomeexpenseservice = new IncomeExpenseService();
		
		request.setAttribute("IncomeExpenseList", incomeexpenseservice.IncomeExpenseDiff(user_id));
		
		List<IncomeExpense> li = incomeexpenseservice.IncomeExpenseDiff(user_id);
		PrintWriter out = response.getWriter();
		
		out.print("<table><tr><th>in_amt</th><th>ex_amt</th><th>diff=in_amt-ex_amt</th><th>month</th>");
		for(int i = 0; i < li.size();i++){
			out.print("<tr><td>");
			out.println(li.get(i).getIn_amt());
			out.print("</td>");
			out.print("<td>");
			out.println(li.get(i).getEx_amt());
			out.print("</td>");
			out.print("<td>");
			out.println(li.get(i).getDiff());
			out.print("</td>");
			out.print("<td>");
			out.println(li.get(i).getMonth());
			out.print("</td>");
		}
		out.print("</table><br/>");
		out.print("<h3>NOTE: The differences are only shown for those months for which at least one entry for both, income and expense, was found.</h3>");
		
	}

}
