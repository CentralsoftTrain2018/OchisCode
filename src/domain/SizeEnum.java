package domain;

public enum SizeEnum
{
    S(65, 75), M(75, 85), L(85, 95);
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
