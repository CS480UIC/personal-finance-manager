package expense.web.servlet;

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

import expense.domain.Expense;
import expense.service.ExpenseService;
import portfolio.domain.Portfolio;
import portfolio.service.PortfolioService;

/**
 * Servlet implementation class MonthsWithoutExpense
 */
//@WebServlet("/MonthsWithoutExpense")
public class MonthsWithoutExpense extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonthsWithoutExpense() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String[]> paramMap = request.getParameterMap();
		String[] values = paramMap.get("user_id");
		String user_id = values[0];
		
		values = paramMap.get("tag");
		String tag = values[0];
				
		ExpenseService expenseservice = new ExpenseService();
		
		request.setAttribute("PortfolioList", expenseservice.MonthsWithoutExpense(user_id,tag));
		
		List<Expense> li = expenseservice.MonthsWithoutExpense(user_id,tag);
		PrintWriter out = response.getWriter();
		out.print("<table><tr><th>expense_id</th><th>user_id</th><th>months without expense</th><th>description</th><th>amount</th><th>tags</th>");
		for(int i = 0; i < li.size();i++){
			out.print("<tr><td>");
			out.println(li.get(i).getExpense_id());
			out.print("</td>");
			out.print("<td>");
			out.println(li.get(i).getUser_id());
			out.print("</td>");
			out.print("<td>");
			out.println(li.get(i).getMonth());
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
			
		}
		out.print("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
