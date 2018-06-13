package service;

import java.sql.Connection;
import java.sql.SQLException;

import bean.CoordinateBean;
import dao.Dao;
import dao.SaveCodeDao;
import vo.SaveCodeVo;

//コーデ(取り出し・登録)のService
//作成者<野間>
public class CodeService {

    public void registCoordinate(String userid, CoordinateBean bean) {
        try (
                Connection con = Dao.getConnection();)
        {
            SaveCodeDao savecodedao = new SaveCodeDao( con );
            SaveCodeVo savecode = new SaveCodeVo();

            savecode.setUserid(userid);
            savecode.setTopscolor(bean.getTopColor());
            savecode.setTopscategory(bean.getTopCategory());
            savecode.setTopspttern(bean.getTopPattern());
            savecode.setTopssize(bean.getTopSize());
            savecode.setBotomsscolor(bean.getBottomColor());
            savecode.setBotomscategory(bean.getTopCategory());
            savecode.setBotomspttern(bean.getTopPattern());
            savecode.setBotomssize(bean.getTopSize());

            //savecodedao.doRegist(savecode);

        } catch (SQLException | ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
}
