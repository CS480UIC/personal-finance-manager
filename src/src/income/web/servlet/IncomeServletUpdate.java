package income.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
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
import user.service.UserException;

/**
 * Servlet implementation class IncomeServletUpdate
 */
//@WebServlet("/IncomeServletUpdate")
public class IncomeServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncomeServletUpdate() {
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
		//Map<String, String> form = new HashMap<String,String>();
		IncomeService incomeservice = new IncomeService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Income form = new Income();
		List<String> info = new ArrayList<String>();
		
		for(String name : paramMap.keySet()) {
			
			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}
	
//		form.setUsername(StringUtils.substring(info.get(1), 0, info.get(1).length() - 1));
		form.setIncome_id(info.get(2));
		form.setIn_date(info.get(3));
		form.setDescription(info.get(4));
		form.setAmount(info.get(5));
		form.setTags(info.get(6));
		
		try {
			incomeservice.update(form);
			
			response.sendRedirect( request.getContextPath() + "/jsps/income-expense/income-expense-main.jsp");
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
