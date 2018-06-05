package web;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import bean.UserClothBean;



/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/ListOutUserClotheServlet")
public class ListOutUserClotheServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOutUserClotheServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());


//        UserClothBean bean =new UserClothBean();
//
//        List <String> list =new ArrayList<String>();
//        list.add("白-無地-Tシャツ");
//        list.add("白-水玉-半ズボン");

//          bean.setList( list );
//          request.setAttribute( "bean", bean );

         RequestDispatcher disp = request.getRequestDispatcher("/listoutuserclothe.jsp");
         disp.forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);




    }

}
