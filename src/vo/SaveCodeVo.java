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
    private ColorEnum botomsscolor;
    private CategoryEnum topscategory;
    private CategoryEnum botomscategory;
    private PatternEnum topspttern;
    private PatternEnum botomspttern;
    private SizeEnum topssize;
    private SizeEnum botomssize;

    public SaveCodeVo() {

    }

    public SaveCodeVo(int codenum,
            String userid,
            ColorEnum topscolor,
            ColorEnum botomsscolor,
            CategoryEnum topscategory,
            CategoryEnum botomscategory,
            PatternEnum topspttern,
            PatternEnum botomspttern,
            SizeEnum topssize,
            SizeEnum botomssize)
    {
        this.codenum = codenum;
        this.userid = userid;
        this.topscolor = topscolor;
        this.botomsscolor = botomsscolor;
        this.topscategory = topscategory;
        this.botomscategory = botomscategory;
        this.topspttern = topspttern;
        this.botomspttern = botomspttern;
        this.topssize = topssize;
        this.botomssize = botomssize;
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

    public ColorEnum getBotomsscolor() {
        return botomsscolor;
    }

    public void setBotomsscolor(ColorEnum botomsscolor) {
        this.botomsscolor = botomsscolor;
    }

    public PatternEnum getTopspttern() {
        return topspttern;
    }

    public void setTopspttern(PatternEnum topspttern) {
        this.topspttern = topspttern;
    }

    public PatternEnum getBotomspttern() {
        return botomspttern;
    }

    public void setBotomspttern(PatternEnum botomspttern) {
        this.botomspttern = botomspttern;
    }

    public CategoryEnum getTopscategory() {
        return topscategory;
    }

    public void setTopscategory(CategoryEnum topscategory) {
        this.topscategory = topscategory;
    }

    public CategoryEnum getBotomscategory() {
        return botomscategory;
    }

    public void setBotomscategory(CategoryEnum botomscategory) {
        this.botomscategory = botomscategory;
    }

    public SizeEnum getTopssize() {
        return topssize;
    }

    public void setTopssize(SizeEnum topssize) {
        this.topssize = topssize;
    }

    public SizeEnum getBotomssize() {
        return botomssize;
    }

    public void setBotomssize(SizeEnum botomssize) {
        this.botomssize = botomssize;
    }

}
