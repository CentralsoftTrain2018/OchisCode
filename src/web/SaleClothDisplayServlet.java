package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ListOutUserClothBean;
import bean.ListSaleClothBean;
import bean.SaleClothDisplayBean;
import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;
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
        String minmax = request.getParameter("narrow");
        String orderStr=request.getParameter("sort");

        ClothService cs = new ClothService();
        ListOutUserClothBean ucbean = cs.userCloth("user");

        ListSaleClothBean rcbean = cs.getSelectedSaleCloth(clothid, minmax ,orderStr);

        SaleClothDisplayBean bean = new SaleClothDisplayBean();

        //デフォルトの服をセット(上)
        bean.setTopCategory( CategoryEnum.Tシャツ );
        bean.setTopColor( ColorEnum.白 );
        bean.setTopPattern( PatternEnum.無地 );
        bean.setTopSize( SizeEnum.M );
        //デフォルトの服をセット(下)
        bean.setBottomCategory( CategoryEnum.半ズボン );
        bean.setBottomColor( ColorEnum.黒 );
        bean.setBottomPattern( PatternEnum.無地 );
        bean.setBottomSize( SizeEnum.M );

        bean.setUserCloth(ucbean);
        bean.setSaleCloth(rcbean);

        //jspに遷移
        request.setAttribute( "bean", bean );
        RequestDispatcher disp = request.getRequestDispatcher( "/saleclothdisplay.jsp" );
        disp.forward( request, response );
        doGet( request, response );
    }

}

