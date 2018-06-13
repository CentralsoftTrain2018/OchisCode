package bean;

public class SaleClothDisplayBean {

    public SaleClothDisplayBean() {

    }

    private ListOutUserClothBean usercloth;
    private ListOutSaleClothBean recomcloth;

    public ListOutUserClothBean getUsercloth() {
        return usercloth;
    }
    public void setUsercloth(ListOutUserClothBean usercloth) {
        this.usercloth = usercloth;
    }
    public ListOutSaleClothBean getRecomcloth() {
        return recomcloth;
    }
    public void setRecomcloth(ListOutSaleClothBean recomcloth) {
        this.recomcloth = recomcloth;
    }


}
