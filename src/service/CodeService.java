package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import bean.CoordinateBean;
import dao.Dao;
import dao.SaveCodeDao;
import vo.SaveCodeVo;

//コーデ(取り出し・登録)のService
public class CodeService
{
    //コーデの情報取得
    //作成者<野間>
    public  List<CoordinateBean> coordinateDisplay()
    {
        CoordinateBean bean;
       // List<CoordinateBean>  listbean;
        try (
                Connection con = Dao.getConnection();
            )
        {
            SaveCodeDao scdao = new SaveCodeDao(con);
             Collection<SaveCodeVo> list = scdao.getCodeCloth();

            List<CoordinateBean> codelist = new ArrayList<CoordinateBean>();
            for (SaveCodeVo scvo : list)
            {
                bean = new CoordinateBean();
                bean.setTopColor(scvo.getTopscolor());
                bean.setTopCategory(scvo.getTopscategory());
                bean.setTopPattern(scvo.getTopspattern());
                bean.setTopSize(scvo.getTopssize());
                bean.setBottomColor(scvo.getTopscolor());
                bean.setBottomCategory(scvo.getBottomscategory());
                bean.setBottomPattern(scvo.getTopspattern());
                bean.setBottomSize(scvo.getTopssize());

                codelist.add(bean);
            }
            //listbean.setList( codelist );

            return codelist;

        } catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }

    }
}

