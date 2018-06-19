
package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CoordinateDisplayBean;
import bean.UserInfoBean;
import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;
import service.ClothService;
import service.CodeService;

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

    //コーデ画面の服の変更(持ち服から)
    //編集：功刀
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //プルダウンの値を取得(文字化け対策に文字コード変更)
        request.setCharacterEncoding( "utf-8" );

      //sessionでユーザの情報を取得
        HttpSession session = request.getSession();
        UserInfoBean userBean = (UserInfoBean) session.getAttribute( "userinfobean" );

        String userId = userBean.getUserid();

        //プルダウンで選択された上下服の情報を取得
        String topclothstr = request.getParameter( "topcloth" );
        String bottomclothstr = request.getParameter( "bottomcloth" );

        CoordinateDisplayBean bean = new CoordinateDisplayBean();

        //モデル変更用の値を一時的に前のモデルのデータをセット
        String[] topcloth = { request.getParameter( "topcolor" ),
                request.getParameter( "toppattern" ),
                request.getParameter( "topcategory" ),
                request.getParameter( "topsize" ) };
        String[] bottomcloth = { request.getParameter( "bottomcolor" ),
                request.getParameter( "bottompattern" ),
                request.getParameter( "bottomcategory" ),
                request.getParameter( "bottomsize" ) };

        //プルダウンからの入力があった場合に配列を上書き
        if (topclothstr!=null)
        {
            String[] topclothnew = topclothstr.split( "-" );
            System.arraycopy(topclothnew,0,topcloth,0,topclothnew.length);
        }

        if (bottomclothstr!=null)
        {
            String[] bottomclothnew = bottomclothstr.split( "-" );
            System.arraycopy(bottomclothnew,0,bottomcloth,0,bottomclothnew.length);
        }

        ClothService cserv = new ClothService();
        //プルダウンで選択された上下に応じてbeanにセットする値を変更
        bean.setTopCategory( CategoryEnum.valueOf( topcloth[2] ) );
        bean.setTopColor( ColorEnum.valueOf( topcloth[0] ) );
        bean.setTopPattern( PatternEnum.valueOf( topcloth[1] ) );
        bean.setTopSize( SizeEnum.valueOf( topcloth[3] ) );
        bean.setBottomCategory( CategoryEnum.valueOf( bottomcloth[2] ) );
        bean.setBottomColor( ColorEnum.valueOf( bottomcloth[0] ) );
        bean.setBottomPattern( PatternEnum.valueOf( bottomcloth[1] ) );
        bean.setBottomSize( SizeEnum.valueOf( bottomcloth[3] ) );

        //ユーザーの性別をセット
        bean.setSex(userBean.getSex());

        //持ち服を上下に分けて取得
        bean.setUscbean( cserv.userSaleCloth( userId ) );

        CodeService codeserv = new CodeService();
        //コーデ一覧を取得
        bean.setList(codeserv.coordinateDisplay(userId));

        request.setAttribute( "bean", bean );

        RequestDispatcher disp = request.getRequestDispatcher( "/coordinatedisplay.jsp" );
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
