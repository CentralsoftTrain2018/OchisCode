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
 * Servlet implementation class RegistCoordinateServlet
 */
@WebServlet("/RegistCoordinateServlet")
public class RegistCoordinateServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistCoordinateServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    //コーデ登録
    //作成者：中村
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //プルダウンの値を取得(文字化け対策に文字コード変更)
        request.setCharacterEncoding( "utf-8" );

        //sessionでユーザの情報を取得
        HttpSession session = request.getSession();
        UserInfoBean userBean = (UserInfoBean) session.getAttribute( "userinfobean" );

        String userId = userBean.getUserid();

        CoordinateDisplayBean bean = new CoordinateDisplayBean();

        bean.setTopCategory( CategoryEnum.valueOf( request.getParameter( "topcategory" ) ) );
        bean.setTopColor( ColorEnum.valueOf( request.getParameter( "topcolor" ) ) );
        bean.setTopPattern( PatternEnum.valueOf( request.getParameter( "toppattern" ) ) );
        bean.setTopSize( SizeEnum.valueOf( request.getParameter( "topsize" ) ) );
        bean.setBottomCategory( CategoryEnum.valueOf( request.getParameter( "bottomcategory" ) ) );
        bean.setBottomColor( ColorEnum.valueOf( request.getParameter( "bottomcolor" ) ) );
        bean.setBottomPattern( PatternEnum.valueOf( request.getParameter( "bottompattern" ) ) );
        bean.setBottomSize( SizeEnum.valueOf( request.getParameter( "bottomsize" ) ) );

        //性別を取得
        bean.setSex(userBean.getSex());

        CodeService codeserv = new CodeService();
        //コーデ登録
        codeserv.registCoordinate( userBean.getUserid(), bean );

        ClothService cserv = new ClothService();

        //コーデ画面で必要な情報を取得
        bean.setUscbean( cserv.userSaleCloth( userId ) );
        bean.setList( codeserv.coordinateDisplay( userId ) );

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
