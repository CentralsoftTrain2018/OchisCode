package web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
    //シミュレーション部分(初回表示)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        SelectBean bean = new SelectBean();
        //デフォルトの服をセット(上)
        bean.setTopCategory( CategoryEnum.Tシャツ );
        bean.setTopColor( ColorEnum.白 );
        bean.setTopPattern( PatternEnum.無地 );
        bean.setTopSize( SizeEnum.M );
        //デフォルトの服をセット(下)
        bean.setTopCategory( CategoryEnum.半ズボン );
        bean.setTopColor( ColorEnum.黒 );
        bean.setTopPattern( PatternEnum.無地 );
        bean.setTopSize( SizeEnum.M );
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
    private String changeCharacterCode(String str) throws UnsupportedEncodingException
    {
        byte[] bi = str.getBytes( "iso-8859-1" );
        String string = new String( bi, "UTF-8" );
        return string;
    }

}
