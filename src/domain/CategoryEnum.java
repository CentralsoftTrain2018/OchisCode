package domain;

public enum CategoryEnum
{
    Tシャツ("上"), 半ズボン("下");
    private String jouge;

    private CategoryEnum(String jouge)
    {
        this.jouge = jouge;
    }

    public String getJouge()
    {
        return this.jouge;
    }
}
