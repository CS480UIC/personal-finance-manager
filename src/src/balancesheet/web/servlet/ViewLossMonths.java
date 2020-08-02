package balancesheet.web.servlet;

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

import balancesheet.domain.LossMonths;
import balancesheet.service.BalanceSheetService;
import portfolio.domain.Portfolio;
import portfolio.service.PortfolioService;

/**
 * Servlet implementation class ViewLossMonths
 */
//@WebServlet("/ViewLossMonths")
public class ViewLossMonths extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewLossMonths() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String[]> paramMap = request.getParameterMap();
		String[] values = paramMap.get("user_id");
		String user_id = values[0];
				
		BalanceSheetService balancesheetservice = new BalanceSheetService();
		
		List<LossMonths> li = balancesheetservice.ViewLossMonths(user_id);
		PrintWriter out = response.getWriter();
		out.print("<table><tr><th>curr_month</th><th>curr_balance</th><th>prev_month</th><th>prev_balance</th><th>decrease</th>");
		for(int i = 0; i < li.size();i++){
			out.print("<tr><td>");
			out.println(li.get(i).getCurr_month());
			out.print("</td>");
			out.print("<td>");
			out.println(li.get(i).getCurr_balance());
			out.print("</td>");
			out.print("<td>");
			out.println(li.get(i).getPrev_month());
			out.print("</td>");
			out.print("<td>");
			out.println(li.get(i).getPrev_balance());
			out.print("</td>");
			out.print("<td>");
			out.println(li.get(i).getDecrease());
			out.print("</td>");
		}
		out.print("</table>");
	}

}
