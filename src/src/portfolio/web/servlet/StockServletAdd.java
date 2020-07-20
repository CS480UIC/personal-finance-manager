package portfolio.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import portfolio.domain.Portfolio;
import portfolio.service.PortfolioService;
import user.service.UserException;

/**
 * Servlet implementation class StockServletAdd
 */
//@WebServlet("/StockServletAdd")
public class StockServletAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StockServletAdd() {
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
		PortfolioService portfolioservice = new PortfolioService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Portfolio form = new Portfolio();
		List<String> info = new ArrayList<String>();
		
		for(String name : paramMap.keySet()) {
			
			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}
		
		form.setUser_id(info.get(2));
		form.setSymbol(info.get(3));
		form.setQuantity(info.get(4));
		form.setBuy_price(info.get(5));
		form.setCurrent_price(info.get(6));
		
		try {
			portfolioservice.regist(form);
			
			response.sendRedirect( request.getContextPath() + "/jsps/portfolio/portfolio-main.jsp");
		} catch (ClassNotFoundException | UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
