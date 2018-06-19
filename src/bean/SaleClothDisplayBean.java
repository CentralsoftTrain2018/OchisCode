package bean;

import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SexEnum;
import domain.SizeEnum;

public class SaleClothDisplayBean
{

    //オススメ服表示画面用Bean
    public SaleClothDisplayBean()
    {
    }

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

    private ListOutUserClothBean userClothList;
    private ListSaleClothBean saleClothList;

    private String clothid;
    private String narrow;
    private String sort;

    //モデルを表示する際の性別
    private SexEnum sex;

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

    public ListOutUserClothBean getUserCloth()
    {
        return userClothList;
    }

    public void setUserCloth(ListOutUserClothBean usercloth)
    {
        this.userClothList = usercloth;
    }

    public ListSaleClothBean getSaleCloth()
    {
        return saleClothList;
    }

    public void setSaleCloth(ListSaleClothBean recomcloth)
    {
        this.saleClothList = recomcloth;
    }

    public String getClothid()
    {
        return clothid;
    }

    public void setClothid(String clothid)
    {
        this.clothid = clothid;
    }

    public String getNarrow()
    {
        return narrow;
    }

    public void setNarrow(String narrow)
    {
        this.narrow = narrow;
    }

    public String getSort()
    {
        return sort;
    }

    public void setSort(String sort)
    {
        this.sort = sort;
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
