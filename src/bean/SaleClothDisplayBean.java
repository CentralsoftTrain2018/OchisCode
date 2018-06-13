package bean;

public class SaleClothDisplayBean {

    public SaleClothDisplayBean() {

    }

    private ListOutUserClothBean userCloth;
    private ListOutSaleClothBean saleCloth;

    public ListOutUserClothBean getUserCloth() {
        return userCloth;
    }
    public void setUserCloth(ListOutUserClothBean usercloth) {
        this.userCloth = usercloth;
    }
    public ListOutSaleClothBean getSalCloth() {
        return saleCloth;
    }
    public void setSaleCloth(ListOutSaleClothBean recomcloth) {
        this.saleCloth = recomcloth;
    }


}
