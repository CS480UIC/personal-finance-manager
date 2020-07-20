package portfolio.web.servlet;

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

import income.dao.IncomeDao;
import income.domain.Income;
import income.service.IncomeService;
import portfolio.dao.PortfolioDao;
import portfolio.domain.Portfolio;
import portfolio.service.PortfolioService;

/**
 * Servlet implementation class findAllPortfolio
 */
//@WebServlet("/findAllPortfolio")
public class findAllPortfolio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findAllPortfolio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String,String[]> paramMap = request.getParameterMap();
		String[] values = paramMap.get("username");
		String username = StringUtils.substring(values[0], 0, values[0].length() - 1);
				
		PortfolioService portfolioservice = new PortfolioService();
		
		try {
			request.setAttribute("PortfolioList", portfolioservice.findallPortfolio(username));
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			List<Portfolio> li = portfolioservice.findallPortfolio(username);
			PrintWriter out = response.getWriter();
			
			out.print("<table><tr><th>user_id</th><th>symbol</th><th>quantity</th><th>buy_price</th><th>investment</th><th>current_price</th><th>equity</th><th>actions</th>");
			for(int i = 0; i < li.size();i++){
				out.print("<tr><td>");
				out.println(li.get(i).getUser_id());
				out.print("</td>");
				out.print("<td>");
				out.println(li.get(i).getSymbol());
				out.print("</td>");
				out.print("<td>");
				out.println(li.get(i).getQuantity());
				out.print("</td>");
				out.print("<td>");
				out.println(li.get(i).getBuy_price());
				out.print("</td>");
				out.print("<td>");
				out.println(li.get(i).getInvestment());
				out.print("</td>");
				out.print("<td>");
				out.println(li.get(i).getCurrent_price());
				out.print("</td>");
				out.print("<td>");
				out.println(li.get(i).getEquity());
				out.print("</td>");
				out.print("<td>\n<a href=\"/edit-income.jsp\">Edit</a>\n"+ 
						"&nbsp;&nbsp;&nbsp;&nbsp;\n" + 
						"<a href=\"/delete?id=<c:out value=" +li.get(i).getUser_id()+"/>\">Delete</a>\n"+ 
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