package web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
    //シミュレーション部分
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
       //プルダウンの値を取得(文字化け対策に文字コード変更)
        String colorStr = changeCharacterCode(request.getParameter("color"));
        String patternStr = changeCharacterCode(request.getParameter( "pattern" ));
        String categoryStr = changeCharacterCode(request.getParameter( "category" ));
        String sizeStr = changeCharacterCode(request.getParameter("size"));

        SelectBean bean = new SelectBean();
        System.out.println( "値確認" );
        System.out.println( colorStr + patternStr + categoryStr + sizeStr);

        bean.setCategory( CategoryEnum.valueOf( categoryStr ) );
        bean.setPattern( PatternEnum.valueOf( patternStr ) );
        bean.setColor( ColorEnum.valueOf( colorStr ) );
        bean.setSize( SizeEnum.valueOf( sizeStr ) );

        request.setAttribute( "bean", bean );

        RequestDispatcher disp = request.getRequestDispatcher( "/selectcloth.jsp" );
        disp.forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        doGet( request, response );

    }

    //文字化け対策に文字コードを変更
    //TODO 複数クラスで使用するため新規クラスでstaticメソッド実装検討
    private String changeCharacterCode(String str) throws UnsupportedEncodingException {
        byte[] bi = str.getBytes( "iso-8859-1" );
        String string = new String( bi, "UTF-8" );
        return string;
    }

}
