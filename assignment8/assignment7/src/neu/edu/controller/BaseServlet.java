package neu.edu.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;


	public abstract class BaseServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#HttpServlet()
		 */
		public BaseServlet() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void init(ServletConfig config) throws ServletException {
			// TODO Auto-generated method stub
			super.init(config);
			SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());

		}

}
