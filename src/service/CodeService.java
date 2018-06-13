package service;

import java.sql.Connection;
import java.sql.SQLException;

import bean.CoordinateDisplayBean;
import dao.Dao;
import dao.SaveCodeDao;
import vo.SaveCodeVo;

//コーデ(取り出し・登録)のService

//作成者<野間>
public class CodeService {

    public void registCoordinate(String userid, CoordinateDisplayBean bean) {
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

        } catch (SQLException | ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
}