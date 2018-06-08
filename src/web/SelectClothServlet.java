package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SelectBean;
import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;
import service.ClothService;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/SelectClothServlet")

//服のシミュレーション画面
public class SelectClothServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectClothServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    //シミュレーション部分(初回表示)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        SelectBean bean = new SelectBean();
        ClothService cserv =new ClothService();
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

        bean.setUscbean(cserv.userSaleCloth(1));



        request.setAttribute( "bean", bean );
        RequestDispatcher disp = request.getRequestDispatcher( "/selectcloth.jsp" );
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
