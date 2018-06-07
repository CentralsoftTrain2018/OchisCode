package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;
import vo.UserSaleClothVo;

public class UserSalesDao extends Dao
    {
        public UserSalesDao(Connection con)
        {
            super( con );
        }
        //販売服のSQL
        private static final String SALECLOTHLIST_SQL =
                "select "
                +" size"
                +" ,color "
                +" ,pattern "
                +" , category "
                +"   from   "
                +"   sale_cloth ";

        //販売服一覧を取得する
        public List<UserSaleClothVo>getSaleCloth()throws SQLException
        {
            List<UserSaleClothVo> list = new ArrayList<>();

            ResultSet rset = null;

                /* Statementの作成 */
          try(
            PreparedStatement stmt = con.prepareStatement(SALECLOTHLIST_SQL);
                        )
            {
                rset = stmt.executeQuery();

                while(rset.next())
                {
                    UserSaleClothVo recomvo = new UserSaleClothVo(
                            CategoryEnum.valueOf(rset.getString(1)),
                            ColorEnum.valueOf(rset.getString(2)),
                            PatternEnum.valueOf(rset.getString(3)),
                            SizeEnum.valueOf(rset.getString(4)),
                            true
                            );
                    list.add(recomvo);
                }

        }
             catch (SQLException e)
            {
                throw e;
            }
            return list;
        }

        //持ち服取得のSQL
        private static final String LISTUSERCLOTHES_SQL = "select"
                + "   category "
                + "  ,color "
                + "  ,pattern "
                + "  ,size "
                + " from   "
                + " user_cloth "
                + " where"
                + " user_cloth.userid = ? ";

        //持ち服一覧を取得
        public List<UserSaleClothVo>getUserCloth(int id)throws SQLException
        {
            List<UserSaleClothVo> list = new ArrayList<>();

            ResultSet rset = null;

                /* Statementの作成 */
          try(
            PreparedStatement stmt = con.prepareStatement( LISTUSERCLOTHES_SQL);
                        )
            {
              stmt.setInt( 1, id );
                rset = stmt.executeQuery();

                while(rset.next())
                {
                    UserSaleClothVo recomvo = new UserSaleClothVo(
                            CategoryEnum.valueOf(rset.getString(1)),
                            ColorEnum.valueOf(rset.getString(2)),
                            PatternEnum.valueOf(rset.getString(3)),
                            SizeEnum.valueOf(rset.getString(4)),
                            false
                            );
                    list.add(recomvo);
                }

        }
             catch (SQLException e)
            {
                throw e;
            }
            return list;
        }

    }


