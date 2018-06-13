package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ListOutSaleClothBean;
import bean.ListOutUserClothBean;
import bean.SaleClothDisplayBean;
import service.ClothService;

/**
 * Servlet implementation class RegistServlet
 */
//持ち服を基に一覧表示
@WebServlet("/SaleClothDisplayServlet")
public class SaleClothDisplayServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaleClothDisplayServlet()
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
        String str = request.getParameter("narrow");
        String[] minmax = str.split("-");
        int min = Integer.parseInt(minmax[0]);
        int max = Integer.parseInt(minmax[1]);
        ClothService cs = new ClothService();
        ListOutUserClothBean ucbean = cs.userCloth("user");
        ListOutSaleClothBean rcbean = cs.getSelectedSaleCloth(clothid, min, max);


        SaleClothDisplayBean bean = new SaleClothDisplayBean();
        bean.setUserCloth(ucbean);
        bean.setSaleCloth(rcbean);

        //jspに遷移
        request.setAttribute( "bean", bean );
        RequestDispatcher disp = request.getRequestDispatcher( "/saleclothdisplay.jsp" );
        disp.forward( request, response );
        doGet( request, response );
    }

}

