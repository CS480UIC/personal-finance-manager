package liability.web.servlet;

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
import liability.domain.Liability;
import liability.service.LiabilityService;

/**
 * Servlet implementation class findAllLiability
 */
//@WebServlet("/findAllLiability")
public class findAllLiability extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findAllLiability() {
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
		// TODO Auto-generated method stub
		Map<String,String[]> paramMap = request.getParameterMap();
		String[] values = paramMap.get("user_id");
		String user_id = values[0];
		
//				HttpSession session=request.getSession(false);
		
//				String username = (String) session.getAttribute("session_user");
		LiabilityService liabilityservice = new LiabilityService();
		try {
			request.setAttribute("LiabilityList", liabilityservice.findallLiability(user_id));
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			List<Liability> li = liabilityservice.findallLiability(user_id);
			PrintWriter out = response.getWriter();
			
			out.print("<table><tr><th>user_id</th><th>liability_name</th><th>value</th>");
			for(int i = 0; i < li.size();i++){
				out.print("<tr><td>");
				out.println(li.get(i).getUser_id());
				out.print("</td>");
				out.print("<td>");
				out.println(li.get(i).getLiability_name());
				out.print("</td>");
				out.print("<td>");
				out.println(li.get(i).getValue());
				out.print("</td>");
//				out.print("<td>\n<a href=\"/edit-income.jsp\">Edit</a>\n"+ 
//						"&nbsp;&nbsp;&nbsp;&nbsp;\n" + 
//						"<a href=\"/delete?id=<c:out value=" +li.get(i).getIncome_id()+"/>\">Delete</a>\n"+ 
//						"</td>");
				
			}
			out.print("</table>");
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
