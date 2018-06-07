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
import domain.JougeEnum;
import domain.PatternEnum;
import domain.SizeEnum;

/**
 * Servlet implementation class ChangeSelectClothServlet
 */
@WebServlet("/ChangeSelectClothServlet")
public class ChangeSelectClothServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeSelectClothServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //プルダウンの値を取得(文字化け対策に文字コード変更)
        request.setCharacterEncoding("utf-8");

        String colorStr = request.getParameter( "color" );
        String patternStr = request.getParameter( "pattern" );
        String categoryStr = request.getParameter( "category" );
        String sizeStr = request.getParameter( "size" );
        //TODO HIDDEN追加して値を追加
        SelectBean bean = new SelectBean();
        //プルダウンで選択された上下に応じてbeanにセットする値を変更
        if (CategoryEnum.valueOf( categoryStr ).getJouge() == JougeEnum.上)
        {
            bean.setTopCategory( CategoryEnum.valueOf( categoryStr ) );
            bean.setTopColor( ColorEnum.valueOf( colorStr ) );
            bean.setTopPattern( PatternEnum.valueOf( patternStr ) );
            bean.setTopSize( SizeEnum.valueOf( sizeStr ) );
        }
        else if(CategoryEnum.valueOf( categoryStr ).getJouge() == JougeEnum.下)
        {
            bean.setBottomCategory( CategoryEnum.valueOf( categoryStr ) );
            bean.setBottomColor( ColorEnum.valueOf( colorStr ) );
            bean.setBottomPattern( PatternEnum.valueOf( patternStr ) );
            bean.setBottomSize( SizeEnum.valueOf( sizeStr ) );
        }
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
