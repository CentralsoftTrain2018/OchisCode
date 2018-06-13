package bean;

public class SaleClothDisplayBean {

    //オススメ服表示画面用Bean
    public SaleClothDisplayBean() {
    }

    private ListOutUserClothBean userClothList;
    private ListSaleClothBean saleClothList;

    public ListOutUserClothBean getUserCloth() {
        return userClothList;
    }
    public void setUserCloth(ListOutUserClothBean usercloth) {
        this.userClothList = usercloth;
    }
    public ListSaleClothBean getSaleCloth() {
        return saleClothList;
    }
    public void setSaleCloth(ListSaleClothBean recomcloth) {
        this.saleClothList = recomcloth;
    }
}
