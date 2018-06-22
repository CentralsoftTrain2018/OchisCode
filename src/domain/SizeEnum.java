package domain;

//服のサイズ
//編集:功刀
public enum SizeEnum
{
    S(160,80), M(180, 90), L(200, 100);
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
