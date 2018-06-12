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

        ListOutUserClothBean ucbean = cs.userCloth("user");
        ListOutRecomClothBean rcbean = cs.getRecommendCloth("user");;

        ClothBean bean = new ClothBean();
        bean.setUsercloth(ucbean);
        bean.setRecomcloth(rcbean);

        //ListOutRecomClothBean bean =cs.UserCloth();

        //持ち服の表示
        //TODO 持ち服情報を取っているが、beanにまとめて次のページに送れていない。
//        ClothService cserv = new ClothService();
//        cserv.userCloth( 1 );//userId=1の持ち服情報のbeanが帰ってくる。
//        //bean2= cserv.UserCloth();

        //jspに遷移
        request.setAttribute( "bean", bean );
        RequestDispatcher disp = request.getRequestDispatcher( "/listoutsalecloth.jsp" );
        disp.forward( request, response );
        doGet( request, response );
    }

}
