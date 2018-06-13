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
import service.ClothService;

/**
 * Servlet implementation class RegistServlet
 */
//持ち服を基に一覧表示
@WebServlet("/ListOutSaleClothServlet")
public class ListOutSaleClothServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOutSaleClothServlet()
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
        ClothService cs = new ClothService();
        String order="clothid DESC";//並び替えのプルダウン初期値→新着順
        ListOutUserClothBean ucbean = cs.userCloth("user");
        ListSaleClothBean rcbean = cs.getSaleCloth("user", 0, 3000,order);
        SaleClothDisplayBean bean = new SaleClothDisplayBean();
        bean.setUserCloth(ucbean);
        bean.setSaleCloth(rcbean);

        //ListOutRecomClothBean bean =cs.UserCloth();

        //持ち服の表示
        //TODO 持ち服情報を取っているが、beanにまとめて次のページに送れていない。
//        ClothService cserv = new ClothService();
//        cserv.userCloth( 1 );//userId=1の持ち服情報のbeanが帰ってくる。
//        //bean2= cserv.UserCloth();

        //jspに遷移
        request.setAttribute( "bean", bean );
        RequestDispatcher disp = request.getRequestDispatcher( "/saleclothdisplay.jsp" );
        disp.forward( request, response );
        doGet( request, response );
    }
}
