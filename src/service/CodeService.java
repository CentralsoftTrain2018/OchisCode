package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import bean.CoordinateBean;
import bean.CoordinateDisplayBean;
import dao.Dao;
import dao.SaveCodeDao;
import vo.SaveCodeVo;

//コーデ(取り出し・登録)のService
public class CodeService {

    //作成者：中村
    //引数で渡されたコーデの情報をもとにDBに登録
    public void registCoordinate(String userid, CoordinateDisplayBean bean)
    {
        try (
                Connection con = Dao.getConnection();)
        {
            SaveCodeDao savecodedao = new SaveCodeDao( con );
            SaveCodeVo savecode = new SaveCodeVo();

            savecode.setUserid(userid);
            savecode.setTopscolor(bean.getTopColor());
            savecode.setTopscategory(bean.getTopCategory());
            savecode.setTopspattern(bean.getTopPattern());
            savecode.setTopssize(bean.getTopSize());
            savecode.setBottomscolor(bean.getBottomColor());
            savecode.setBottomscategory(bean.getBottomCategory());
            savecode.setBottomspattern(bean.getBottomPattern());
            savecode.setBottomssize(bean.getBottomSize());

            savecodedao.registCode(savecode);

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    //コーデの情報取得
    //作成者<野間>
    public List<CoordinateBean> coordinateDisplay(String userId) {
        CoordinateBean bean;
        // List<CoordinateBean>  listbean;
        try (
                Connection con = Dao.getConnection();) {
            SaveCodeDao scdao = new SaveCodeDao(con);
            Collection<SaveCodeVo> list = scdao.getCodeCloth(userId);

            List<CoordinateBean> codelist = new ArrayList<CoordinateBean>();
            for (SaveCodeVo scvo : list) {
                bean = new CoordinateBean();
                bean.setTopColor(scvo.getTopscolor());
                bean.setTopCategory(scvo.getTopscategory());
                bean.setTopPattern(scvo.getTopspattern());
                bean.setTopSize(scvo.getTopssize());
                bean.setBottomColor(scvo.getBottomscolor());
                bean.setBottomCategory(scvo.getBottomscategory());
                bean.setBottomPattern(scvo.getBottomspattern());
                bean.setBottomSize(scvo.getBottomssize());
                bean.setCode_num(scvo.getCodenum());

                codelist.add(bean);
            }

            return codelist;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }


    //コーデ情報の削除・
    //作成者<高田>
    public void deleteCoordinate(int code_number)
    {
        try (
                Connection con = Dao.getConnection();
                )
        {

            SaveCodeDao scdao = new SaveCodeDao(con);
            scdao.deleteCode(code_number);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

}




}

