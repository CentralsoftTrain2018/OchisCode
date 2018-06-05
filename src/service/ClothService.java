package service;

import java.util.ArrayList;
import java.util.List;

import bean.ListOutUserClothBean;

public class ClothService
{


    public  ListOutUserClothBean  UserCloth()//持ち服を表示するやつ
    {
        //コネクションの取得



//とりあえず直書き   本来はDBから取り出したデータ
      ListOutUserClothBean bean =new ListOutUserClothBean();
      List <String> list =new ArrayList<String>();

      list.add("白-無地-Tシャツ-M");
      list.add("白-水玉-半ズボン-S");
      list.add("黒-無地-Tシャツ-L");
      bean.setList( list );


      //クローズ処理など

      return bean;
    }


}
