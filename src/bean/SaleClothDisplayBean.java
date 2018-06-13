package bean;

public class SaleClothDisplayBean {

    //オススメ服表示画面用Bean
    public SaleClothDisplayBean() {
    }

    private ListOutUserClothBean userCloth;
    private ListSaleClothBean saleCloth;

    public ListOutUserClothBean getUserCloth() {
        return userCloth;
    }
    public void setUserCloth(ListOutUserClothBean usercloth) {
        this.userCloth = usercloth;
    }
    public ListSaleClothBean getSaleCloth() {
        return saleCloth;
    }
    public void setSaleCloth(ListSaleClothBean recomcloth) {
        this.saleCloth = recomcloth;
    }


}
