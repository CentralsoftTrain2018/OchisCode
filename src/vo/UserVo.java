package vo;

import domain.SexEnum;
import domain.SizeEnum;

//ユーザー用Vo
//作成：功刀
public class UserVo
{
    private String userId;
    private String password;
    private int userHeight;
    private SizeEnum size;
    private int budget;
    private SexEnum sex;

    public UserVo(String userId, String password, int userHeight, SizeEnum size, int budget, SexEnum sex)
    {
        super();
        this.userId = userId;
        this.password = password;
        this.userHeight = userHeight;
        this.size = size;
        this.budget = budget;
        this.sex = sex;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getUserHeight()
    {
        return userHeight;
    }

    public void setUserHeight(int userHeight)
    {
        this.userHeight = userHeight;
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
