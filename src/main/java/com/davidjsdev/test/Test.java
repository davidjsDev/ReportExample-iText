package com.davidjsdev.test;

import com.davidjsdev.model.Client;
import com.davidjsdev.model.InfoReport;
import com.davidjsdev.model.ItemSale;
import com.davidjsdev.model.User;
import com.davidjsdev.solutions.Report;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        Client c = new Client();
        InfoReport i = new InfoReport();
        User u = new User();
        ItemSale it;
        List<ItemSale> itemSaleList = new ArrayList<>();

        for (int j = 0; j < 1000 ; j++){
            itemSaleList.add( it = new ItemSale(30, "Mause Logitech", 200));
        }

        //System.out.println(itemSaleList);

        Report.Print( "des",i,c,itemSaleList,u );

    }
}
