package bean;

import domain.SexEnum;
import domain.SizeEnum;

/**
 * ユーザー情報用のBean
 */
public class UserInfoBean
{
    private String userid;
    private String password;
    private int userheight;
    private SizeEnum size;
    private int budget;
    private SexEnum sex;

    public UserInfoBean()
    {
    }

    public String getUserid()
    {
        return userid;
    }

    public void setUserid(String userid)
    {
        this.userid = userid;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getUserheight()
    {
        return userheight;
    }

    public void setUserheight(int userheight)
    {
        this.userheight = userheight;
    }

    public SizeEnum getSize()
    {
        return size;
    }

    public void setSize(SizeEnum size)
    {
        this.size = size;
    }

    public int getBudget()
    {
        return budget;
    }

    public void setBudget(int budget)
    {
        this.budget = budget;
    }

    public SexEnum getSex()
    {
        return sex;
    }

    public void setSex(SexEnum sex)
    {
        this.sex = sex;
    }
}
