
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
import domain.PatternEnum;
import domain.SizeEnum;
import service.ClothService;

/**
 * Servlet implementation class ChangeSelectClothServlet
 */
@WebServlet("/ChangeUserSaleClothServlet")
public class ChangeUserSaleClothServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeUserSaleClothServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    //シミュレーション画面の服の変更(持ち服から)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //プルダウンの値を取得(文字化け対策に文字コード変更)
        request.setCharacterEncoding( "utf-8" );

        String topclothstr = request.getParameter( "topcloth" );
        String bottomclothstr = request.getParameter( "bottomcloth" );

        CoordinateBean bean = new CoordinateBean();

        String[] topcloth = topclothstr.split( "-" );
        String[] bottomcloth = bottomclothstr.split( "-" );
        ClothService cserv = new ClothService();
        System.out.println( bottomcloth[2] );
        //color + "-" + pattern + "-" + category + "-"+size+"\";

        //プルダウンで選択された上下に応じてbeanにセットする値を変更

        bean.setTopCategory( CategoryEnum.valueOf( topcloth[2] ) );
        bean.setTopColor( ColorEnum.valueOf( topcloth[0] ) );
        bean.setTopPattern( PatternEnum.valueOf( topcloth[1] ) );
        bean.setTopSize( SizeEnum.valueOf( topcloth[3] ) );
        bean.setBottomCategory( CategoryEnum.valueOf( bottomcloth[2] ) );
        bean.setBottomColor( ColorEnum.valueOf( bottomcloth[0] ) );
        bean.setBottomPattern( PatternEnum.valueOf( bottomcloth[1] ) );
        bean.setBottomSize( SizeEnum.valueOf( bottomcloth[3] ) );
        //TODO 持ち服を上下に分けて取得
        bean.setUscbean( cserv.userSaleCloth( "user" ) );
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
