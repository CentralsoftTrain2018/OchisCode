package web;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ListOutLinkCountBean;
import bean.SaleClothBean;
import service.ClothService;

/**
 * 管理者用クリック数確認画面に遷移
 */
@WebServlet("/ListOutLinkCountServlet")
public class ListOutLinkCountServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    //メール送信用のアカウント名とパスワード
    private static final String account = "centralochiscode";
    private static final String pass = "ochiscode";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOutLinkCountServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding( "utf-8" );
        String distAddress = request.getParameter( "address" );

        ClothService cserv = new ClothService();
        //クリック数をDBから取得
        ListOutLinkCountBean bean = cserv.getAllClothCount();

        //メールアドレスが入力されていた場合メールを送信
        if (distAddress != null)
        {
            this.sendMail( distAddress, bean );
            System.out.println( distAddress );
        }

        request.setAttribute( "bean", bean );
        //一覧画面に遷移
        RequestDispatcher disp = request.getRequestDispatcher( "/listoutlinkcount.jsp" );
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

    //集計データメール送信用メソッド
    private void sendMail(String mailAddress, ListOutLinkCountBean bean)
    {
        Properties props = new Properties();
        props.put( "mail.smtp.host", "smtp.gmail.com" );
        props.put( "mail.smtp.auth", "true" );
        props.put( "mail.smtp.port", "465" );
        props.put( "mail.smtp.socketFactory.post", "465" );
        props.put( "mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory" );

        final Message msg = new MimeMessage( Session.getDefaultInstance( props, new Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication( account, pass );
            }
        } ) );

        //送信元アドレス
        String srcAddress = account + "@gmail.com";
        //宛先アドレス
        String distAddress = mailAddress;
        System.out.println( "宛先：　" + distAddress );
        try
        {
            msg.setFrom( new InternetAddress( srcAddress ) );
            msg.setRecipients( Message.RecipientType.TO, InternetAddress.parse( distAddress ) );
            //件名
            msg.setSubject( "クリック回数データ" );
            //送信内容
            StringBuilder strb = new StringBuilder( "色,柄,カテゴリ,クリック回数\n" );
            for (SaleClothBean linebean : bean.getList())
            {
                strb.append( linebean.getColor().name() + ","
                        + linebean.getPattern().name() + ","
                        + linebean.getCategory().name() + ","
                        + linebean.getClickcount() + "\n" );
            }
            String mailText = strb.toString();

            msg.setText( mailText );
            //送信
            Transport.send( msg );
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
