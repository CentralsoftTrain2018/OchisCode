package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ListOutUserClothBean;
import bean.ListSaleClothBean;
import bean.SaleClothDisplayBean;
import bean.UserClothBean;
import bean.UserInfoBean;
import domain.CategoryEnum;
import domain.ColorEnum;
import domain.JougeEnum;
import domain.PatternEnum;
import domain.SizeEnum;
import service.ClothService;

/**
 * Servlet implementation class RegistServlet
 */
//持ち服を基に一覧表示
@WebServlet("/SaleClothDisplayServlet")
public class SaleClothDisplayServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaleClothDisplayServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    //オススメ一覧表示
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding( "utf-8" );

      //sessionでユーザの情報を取得
        HttpSession session = request.getSession();
        UserInfoBean userBean = (UserInfoBean) session.getAttribute( "userinfobean" );

        int clothid = Integer.parseInt(request.getParameter("usercloth"));
        String minmax = request.getParameter("narrow");
        String orderStr=request.getParameter("sort");
        int page = Integer.parseInt(request.getParameter("page"));
        int offset = 9 * (page - 1);

        ClothService cs = new ClothService();
        ListOutUserClothBean ucbean = cs.userCloth(userBean.getUserid(), "", "", "");

        UserClothBean selecteduc = ucbean.getSelectedCloth(clothid);

        ListSaleClothBean rcbean = cs.getSelectedSaleCloth(clothid, minmax ,orderStr, offset);

        SaleClothDisplayBean bean = new SaleClothDisplayBean();

        bean.setTopCategory(CategoryEnum.Tシャツ);
        bean.setTopColor(ColorEnum.白);
        bean.setTopPattern(PatternEnum.無地);
        bean.setTopSize(SizeEnum.M);
        bean.setBottomCategory(CategoryEnum.半ズボン);
        bean.setBottomColor(ColorEnum.白);
        bean.setBottomPattern(PatternEnum.無地);
        bean.setBottomSize(SizeEnum.M);

        if (selecteduc.getCategory().getJouge() == JougeEnum.上) {
            bean.setTopCategory(CategoryEnum.valueOf(selecteduc.getCategory().name()));
            bean.setTopColor(ColorEnum.valueOf(selecteduc.getColor().name()));
            bean.setTopPattern(PatternEnum.valueOf(selecteduc.getPattern().name()));
        }
        else if (selecteduc.getCategory().getJouge() == JougeEnum.下) {
            bean.setBottomCategory(CategoryEnum.valueOf(selecteduc.getCategory().name()));
            bean.setBottomColor(ColorEnum.valueOf(selecteduc.getColor().name()));
            bean.setBottomPattern(PatternEnum.valueOf(selecteduc.getPattern().name()));
            bean.setBottomSize(SizeEnum.valueOf(selecteduc.getSize().name()));
        }
        bean.setUserCloth(ucbean);
        bean.setSaleCloth(rcbean);

        bean.setClothid(request.getParameter("usercloth"));
        bean.setNarrow(minmax);
        bean.setSort(orderStr);
        bean.setPage(page);
        bean.setBudget(userBean.getBudget());

        //性別を取得
        bean.setSex(userBean.getSex());

        //jspに遷移
        request.setAttribute( "bean", bean );
        RequestDispatcher disp = request.getRequestDispatcher( "/saleclothdisplay2.jsp" );
        disp.forward( request, response );
        doGet( request, response );
    }

}

