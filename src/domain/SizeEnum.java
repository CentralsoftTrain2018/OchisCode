package domain;

//服のサイズ
//編集:功刀
public enum SizeEnum
{
    S(157, 132), M(175, 147), L(192 ,161 );
    private int width;
    private int height;

    private SizeEnum(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }
}
