package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CoordinateBean;
import domain.CategoryEnum;
import domain.ColorEnum;
import domain.JougeEnum;
import domain.PatternEnum;
import domain.SizeEnum;
import service.ClothService;

/**
 * Servlet implementation class ChangeSelectClothServlet
 */
@WebServlet("/ChangeCoordinateClothServlet")
public class ChangeCoordinateClothServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeCoordinateClothServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    //シミュレーション画面の服の変更
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //プルダウンの値を取得(文字化け対策に文字コード変更)
        request.setCharacterEncoding( "utf-8" );

        String colorStr = request.getParameter( "color" );
        String patternStr = request.getParameter( "pattern" );
        String categoryStr = request.getParameter( "category" );
        String sizeStr = request.getParameter( "size" );

        CoordinateBean bean = new CoordinateBean();

        //プルダウンで選択された上下に応じてbeanにセットする値を変更
        //上の服を変更
        if (CategoryEnum.valueOf( categoryStr ).getJouge() == JougeEnum.上)
        {
            bean.setTopCategory( CategoryEnum.valueOf( categoryStr ) );
            bean.setTopColor( ColorEnum.valueOf( colorStr ) );
            bean.setTopPattern( PatternEnum.valueOf( patternStr ) );
            bean.setTopSize( SizeEnum.valueOf( sizeStr ) );
            bean.setBottomCategory( CategoryEnum.valueOf( request.getParameter( "bottomcategory" ) ) );
            bean.setBottomColor( ColorEnum.valueOf( request.getParameter( "bottomcolor" ) ) );
            bean.setBottomPattern( PatternEnum.valueOf( request.getParameter( "bottompattern" ) ) );
            bean.setBottomSize( SizeEnum.valueOf( request.getParameter( "bottomsize" ) ) );
        }

        //下の服を変更
        else if (CategoryEnum.valueOf( categoryStr ).getJouge() == JougeEnum.下)
        {
            bean.setTopCategory( CategoryEnum.valueOf( request.getParameter( "topcategory" ) ) );
            bean.setTopColor( ColorEnum.valueOf( request.getParameter( "topcolor" ) ) );
            bean.setTopPattern( PatternEnum.valueOf( request.getParameter( "toppattern" ) ) );
            bean.setTopSize( SizeEnum.valueOf( request.getParameter( "topsize" ) ) );
            bean.setBottomCategory( CategoryEnum.valueOf( categoryStr ) );
            bean.setBottomColor( ColorEnum.valueOf( colorStr ) );
            bean.setBottomPattern( PatternEnum.valueOf( patternStr ) );
            bean.setBottomSize( SizeEnum.valueOf( sizeStr ) );
        }

        ClothService cserv =new ClothService();
        bean.setUscbean(cserv.userSaleCloth("user"));

        request.setAttribute( "bean", bean );

        RequestDispatcher disp = request.getRequestDispatcher( "/coordinate.jsp" );
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
