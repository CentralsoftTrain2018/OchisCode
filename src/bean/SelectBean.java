package bean;

import java.util.ArrayList;
import java.util.List;

import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;

public class SelectBean
{
    private List <ColorEnum> colorlist =new ArrayList<ColorEnum>();
    private List <PatternEnum> patternlist =new ArrayList<PatternEnum>();
    private List <CategoryEnum> categorylist =new ArrayList<CategoryEnum>();
    private List <SizeEnum> sizelist =new ArrayList<SizeEnum>();

    public SelectBean()
    {

    }

    public List<ColorEnum> getColorlist()
    {
        return colorlist;
    }

    public void setColorlist(List<ColorEnum> colorlist)
    {
        this.colorlist = colorlist;
    }

    public List<PatternEnum> getPatternlist()
    {
        return patternlist;
    }

    public void setPatternlist(List<PatternEnum> patternlist)
    {
        this.patternlist = patternlist;
    }

    public List<CategoryEnum> getCategorylist()
    {
        return categorylist;
    }

    public void setCategorylist(List<CategoryEnum> categorylist)
    {
        this.categorylist = categorylist;
    }

    public List<SizeEnum> getSizelist()
    {
        return sizelist;
    }

    public void setSizelist(List<SizeEnum> sizelist)
    {
        this.sizelist = sizelist;
    }



}
