package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ClothBean;
import bean.ListOutRecomClothBean;
import bean.ListOutUserClothBean;
import service.ClothService;

/**
 * Servlet implementation class RegistServlet
 */
//持ち服を基に一覧表示
@WebServlet("/CoordinateSaleClothServlet")
public class CoordinateSaleClothServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoordinateSaleClothServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    //オススメ一覧表示
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int clothid = Integer.parseInt(request.getParameter("usercloth"));
        ClothService cs = new ClothService();
        ListOutUserClothBean ucbean = cs.userCloth(1);
        ListOutRecomClothBean rcbean = cs.getSelectedRecommendCloth(clothid);;

        ClothBean bean = new ClothBean();
        bean.setUsercloth(ucbean);
        bean.setRecomcloth(rcbean);

        //jspに遷移
        request.setAttribute( "bean", bean );
        RequestDispatcher disp = request.getRequestDispatcher( "/listoutsalecloth.jsp" );
        disp.forward( request, response );
        doGet( request, response );
    }

}

