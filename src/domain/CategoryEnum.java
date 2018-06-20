package domain;

public enum CategoryEnum
{
    Tシャツ(JougeEnum.上), 半ズボン(JougeEnum.下),
    セーター(JougeEnum.上),長ズボン(JougeEnum.下),
    ロングシャツ(JougeEnum.上),ロングスカート(JougeEnum.下),
    ミニスカート(JougeEnum.下);
    private JougeEnum jouge;

    private CategoryEnum(JougeEnum jouge)
    {
        this.jouge = jouge;
    }

    public JougeEnum getJouge()
    {
        return jouge;
    }
}
