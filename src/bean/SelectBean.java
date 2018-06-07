package bean;

import java.util.ArrayList;
import java.util.List;

import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;

public class SelectBean
{
    private CategoryEnum topCategory;
    private ColorEnum topColor;
    private PatternEnum topPattern;
    private SizeEnum topSize;

    private CategoryEnum bottomCategory;
    private ColorEnum bottomColor;
    private PatternEnum bottomPattern;
    private SizeEnum bottomSize;

    private List<SelectLineBean> Userlist =new ArrayList<>();
    private List<SelectLineBean> Salelist =new ArrayList<>();


    public SelectBean()
    {

    }

    public CategoryEnum getTopCategory()
    {
        return topCategory;
    }

    public void setTopCategory(CategoryEnum topCategory)
    {
        this.topCategory = topCategory;
    }

    public ColorEnum getTopColor()
    {
        return topColor;
    }

    public void setTopColor(ColorEnum topColor)
    {
        this.topColor = topColor;
    }

    public PatternEnum getTopPattern()
    {
        return topPattern;
    }

    public void setTopPattern(PatternEnum topPattern)
    {
        this.topPattern = topPattern;
    }

    public SizeEnum getTopSize()
    {
        return topSize;
    }

    public void setTopSize(SizeEnum topSize)
    {
        this.topSize = topSize;
    }

    public CategoryEnum getBottomCategory()
    {
        return bottomCategory;
    }

    public void setBottomCategory(CategoryEnum bottomCategory)
    {
        this.bottomCategory = bottomCategory;
    }

    public ColorEnum getBottomColor()
    {
        return bottomColor;
    }

    public void setBottomColor(ColorEnum bottomColor)
    {
        this.bottomColor = bottomColor;
    }

    public PatternEnum getBottomPattern()
    {
        return bottomPattern;
    }

    public void setBottomPattern(PatternEnum bottomPattern)
    {
        this.bottomPattern = bottomPattern;
    }

    public SizeEnum getBottomSize()
    {
        return bottomSize;
    }

    public void setBottomSize(SizeEnum bottomSize)
    {
        this.bottomSize = bottomSize;
    }

    public List<SelectLineBean> getUserlist()
    {
        return Userlist;
    }

    public void setUserlist(List<SelectLineBean> userlist)
    {
        Userlist = userlist;
    }

    public List<SelectLineBean> getSalelist()
    {
        return Salelist;
    }

    public void setSalelist(List<SelectLineBean> salelist)
    {
        Salelist = salelist;
    }




}
