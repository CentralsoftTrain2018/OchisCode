package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ListOutUserClothBean;
import bean.UserInfoBean;
import service.ClothService;

//import bean.UserClothBean;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/ListOutUserClotheServlet")
public class ListOutUserClotheServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOutUserClotheServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ListOutUserClothBean bean;

        ClothService cserv = new ClothService();

        HttpSession session = request.getSession();
        UserInfoBean userBean = (UserInfoBean) session.getAttribute( "userinfobean" );

        int page = Integer.parseInt(request.getParameter("page"));
        int offsetnum = 5 * (page - 1);
        String offset = " offset " + offsetnum + " ";

        bean = cserv.userCloth( userBean.getUserid(), "", " limit 5 ", offset);//userIdは定数
        bean.setPage(page);
        request.setAttribute( "bean", bean );
        RequestDispatcher disp = request.getRequestDispatcher( "/listoutusercloth.jsp" );
        disp.forward( request, response );

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet( request, response );

    }

}
