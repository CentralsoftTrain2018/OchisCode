package web;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CoordinateDisplayBean;
import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;
import service.ClothService;
import service.CodeService;

/**
 * Servlet implementation class ChangeSelectClothServlet
 */
@WebServlet("/ChangeSelectCodeServlet")
public class ChangeSelectCodeServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeSelectCodeServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    //作成高田
    //コーデを選択して、コーデ画面の服の変更
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //プルダウンの値を取得(文字化け対策に文字コード変更)
        request.setCharacterEncoding( "utf-8" );
        //プルダウンで選択された上下服の情報を取得
        String clothstr = request.getParameter( "cloth" );

        CoordinateDisplayBean bean = new CoordinateDisplayBean();

        //モデル変更用の値を一時的に前のモデルのデータをセット
        String[] cloth = {
                request.getParameter( "topcolor" ),
                request.getParameter( "toppattern" ),
                request.getParameter( "topcategory" ),
                request.getParameter( "topsize" ) ,
                request.getParameter( "bottomcolor" ),
                request.getParameter( "bottompattern" ),
                request.getParameter( "bottomcategory" ),
                request.getParameter( "bottomsize" )
                };
        System.out.println(cloth);
        //プルダウンからの入力があった場合に配列を上書き
        if (clothstr!=null)
        {
            String[] topclothnew = clothstr.split( "-" );
            System.arraycopy(topclothnew,0,cloth,0,topclothnew.length);
        }

        ClothService cserv = new ClothService();
        CodeService codeserv = new CodeService();
        //プルダウンで選択された上下に応じてbeanにセットする値を変更
        //上の服

        bean.setTopColor( ColorEnum.valueOf( cloth[0] ) );
        bean.setTopPattern( PatternEnum.valueOf( cloth[1] ) );
        bean.setTopCategory( CategoryEnum.valueOf( cloth[2] ) );
        bean.setTopSize( SizeEnum.valueOf( cloth[3] ) );
        //下の服

        bean.setBottomColor( ColorEnum.valueOf( cloth[4] ) );
        bean.setBottomPattern( PatternEnum.valueOf( cloth[5] ) );
        bean.setBottomCategory( CategoryEnum.valueOf( cloth[6] ) );
        bean.setBottomSize( SizeEnum.valueOf( cloth[7] ) );

        bean.setUscbean( cserv.userSaleCloth( "user" ) );
        bean.setList(codeserv.coordinateDisplay());
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
