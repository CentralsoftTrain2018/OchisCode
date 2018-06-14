package vo;

import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;

//コーディネイト取り出し用
//作成者<野間>
public class SaveCodeVo
{
    protected int codenum;
    protected String userid;
    private ColorEnum topscolor;
    private ColorEnum bottomscolor;
    private CategoryEnum topscategory;
    private CategoryEnum bottomscategory;
    private PatternEnum topspattern;
    private PatternEnum bottomspattern;
    private SizeEnum topssize;
    private SizeEnum bottomssize;

    public SaveCodeVo() {

    }

    public SaveCodeVo(int codenum,
            String userid,
            ColorEnum topscolor,
            ColorEnum bottomscolor,
            PatternEnum topspattern,
            PatternEnum bottomspattern,
            CategoryEnum topscategory,
            CategoryEnum bottomscategory,
            SizeEnum topssize,
            SizeEnum bottomssize)
    {
        this.codenum = codenum;
        this.userid = userid;
        this.topscolor = topscolor;
        this.bottomscolor = bottomscolor;
        this.topscategory = topscategory;
        this.bottomscategory = bottomscategory;
        this.topspattern = topspattern;
        this.bottomspattern = bottomspattern;
        this.topssize = topssize;
        this.bottomssize = bottomssize;
    }

    public int getCodenum() {
        return codenum;
    }

    public void setCodenum(int codenum) {
        this.codenum = codenum;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public ColorEnum getTopscolor() {
        return topscolor;
    }

    public void setTopscolor(ColorEnum topscolor) {
        this.topscolor = topscolor;
    }

    public ColorEnum getBottomscolor() {
        return bottomscolor;
    }

    public void setBottomscolor(ColorEnum bottomscolor) {
        this.bottomscolor = bottomscolor;
    }

    public CategoryEnum getTopscategory() {
        return topscategory;
    }

    public void setTopscategory(CategoryEnum topscategory) {
        this.topscategory = topscategory;
    }

    public CategoryEnum getBottomscategory() {
        return bottomscategory;
    }

    public void setBottomscategory(CategoryEnum bottomscategory) {
        this.bottomscategory = bottomscategory;
    }

    public PatternEnum getTopspattern() {
        return topspattern;
    }

    public void setTopspattern(PatternEnum topspattern) {
        this.topspattern = topspattern;
    }

    public PatternEnum getBottomspattern() {
        return bottomspattern;
    }

    public void setBottomspattern(PatternEnum bottomspattern) {
        this.bottomspattern = bottomspattern;
    }

    public SizeEnum getTopssize() {
        return topssize;
    }

    public void setTopssize(SizeEnum topssize) {
        this.topssize = topssize;
    }

    public SizeEnum getBottomssize() {
        return bottomssize;
    }

    public void setBottomssize(SizeEnum bottomssize) {
        this.bottomssize = bottomssize;
    }


}
