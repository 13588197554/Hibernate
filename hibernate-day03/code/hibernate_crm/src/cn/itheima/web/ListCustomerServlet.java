package cn.itheima.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itheima.domain.Customer;
import cn.itheima.service.CustomerService;
import cn.itheima.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class ListCustomerServlet
 */
public class ListCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService cs = new CustomerServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 调用Service查询所有客户
		List<Customer> list = cs.getAll();
		//2 将客户列表放入request域
		request.setAttribute("list", list);
		//3 转发到list.jsp显示
		request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
