package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ListOutUserClothBean;
import bean.ListSaleClothBean;
import bean.SaleClothDisplayBean;
import bean.UserClothBean;
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

        int clothid = Integer.parseInt(request.getParameter("usercloth"));
        String minmax = request.getParameter("narrow");
        String orderStr=request.getParameter("sort");

        ClothService cs = new ClothService();
        ListOutUserClothBean ucbean = cs.userCloth("user");
        UserClothBean selecteduc = ucbean.getSelectedCloth(clothid);

        ListSaleClothBean rcbean = cs.getSelectedSaleCloth(clothid, minmax ,orderStr);

        SaleClothDisplayBean bean = new SaleClothDisplayBean();

        if (selecteduc.getCategory().getJouge() == JougeEnum.上) {
            bean.setTopCategory(CategoryEnum.valueOf(selecteduc.getCategory().name()));
            bean.setTopColor(ColorEnum.valueOf(selecteduc.getColor().name()));
            bean.setTopPattern(PatternEnum.valueOf(selecteduc.getPattern().name()));
            bean.setTopSize(SizeEnum.valueOf(selecteduc.getSize().name()));
            bean.setBottomCategory(CategoryEnum.valueOf(request.getParameter("bottomcategory")));
            bean.setBottomColor(ColorEnum.valueOf(request.getParameter("bottomcolor")));
            bean.setBottomPattern(PatternEnum.valueOf(request.getParameter("bottompattern")));
            bean.setBottomSize(SizeEnum.valueOf(request.getParameter("bottomsize")));
        }
        else if (selecteduc.getCategory().getJouge() == JougeEnum.下) {
            bean.setTopCategory(CategoryEnum.valueOf(request.getParameter("topcategory")));
            bean.setTopColor(ColorEnum.valueOf(request.getParameter("topcolor")));
            bean.setTopPattern(PatternEnum.valueOf(request.getParameter("toppattern")));
            bean.setTopSize(SizeEnum.valueOf(request.getParameter("topsize")));
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

        //jspに遷移
        request.setAttribute( "bean", bean );
        RequestDispatcher disp = request.getRequestDispatcher( "/saleclothdisplay.jsp" );
        disp.forward( request, response );
        doGet( request, response );
    }

}

