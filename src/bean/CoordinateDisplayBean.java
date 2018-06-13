package bean;

import java.util.ArrayList;
import java.util.List;

import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;

//コーディネイト画面用Bean
public class CoordinateDisplayBean
{
    //上の服の情報
    private CategoryEnum topCategory;
    private ColorEnum topColor;
    private PatternEnum topPattern;
    private SizeEnum topSize;

    //下の服の情報
    private CategoryEnum bottomCategory;
    private ColorEnum bottomColor;
    private PatternEnum bottomPattern;
    private SizeEnum bottomSize;

    private  List<CoordinateBean> list =new ArrayList<CoordinateBean>();

    public List<CoordinateBean> getList() {
        return list;
    }

    public void setList(List<CoordinateBean> list) {
        this.list = list;
    }

    private UserSaleClothBean uscbean;

    public CoordinateDisplayBean()
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

    public UserSaleClothBean getUscbean()
    {
        return uscbean;
    }

    public void setUscbean(UserSaleClothBean uscbean)
    {
        this.uscbean = uscbean;
    }
}
