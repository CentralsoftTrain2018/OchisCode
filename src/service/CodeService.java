package service;

import java.sql.Connection;
import java.sql.SQLException;

import bean.CoordinateDisplayBean;
import dao.Dao;
import dao.SaveCodeDao;
import vo.SaveCodeVo;

//コーデ(取り出し・登録)のService
public class CodeService
{
    //コーデの情報取得
    //作成者<野間>
    public void registCoordinate(String userid, CoordinateDisplayBean bean) {
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

        } catch (SQLException | ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
    /*public CoordinateDisplayBean coordinateDisplay()
    {
        CoordinateDisplayBean bean;
        try (
                Connection con = Dao.getConnection();)
        {
            SaveCodeDao scdao = new SaveCodeDao( con );

            //登録したコーデをDBから取得
            Collection<SaveCodeVo> list = scdao.getCodeCloth();
            bean = new CoordinateDisplayBean();
            //上下で分けて入れるList
            List<CoordinateDisplayBean> topClothList = new ArrayList<CoordinateDisplayBean>();
            List<CoordinateDisplayBean> bottomClothList = new ArrayList<CoordinateDisplayBean>();
        } catch (ClassNotFoundException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        return null;
    }*/
    }
}

