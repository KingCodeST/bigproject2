package ac.za.cput.factory.order;

import ac.za.cput.domain.order.Orders;
import ac.za.cput.util.Misc;

import java.util.Date;

public class OrdersFactory {

    public static Orders GenerateBuilder(Date date,String desc)
    {
        return new Orders.Builder()
                        .setCreateDate(date)
                        .setDescption(desc)
                        .setOrderId(Misc.generatedId())
                        .build();

    }


}
