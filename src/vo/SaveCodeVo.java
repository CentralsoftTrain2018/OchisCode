package vo;

import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;

//コーディネイト取り出し用
//作成者<野間>
public class SaveCodeVo extends ClothVo
{
    protected int codenum;
    protected String userid;

    public SaveCodeVo(CategoryEnum category, ColorEnum color, PatternEnum pattern, SizeEnum size, int codenum, String userid)
    {
        super(category, color, pattern, size);
        this.codenum=codenum;
        this.userid=userid;
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

}
