package ac.za.cput.factory.order;

import ac.za.cput.domain.order.OrderStatus;
import ac.za.cput.util.Misc;

public class OrderStatusFactory {

    public static OrderStatus GenerateBuilder(String statusname,int create,int delivery,int paid,int shipping)
    {
        return new OrderStatus.Builder()
                                .setStatus(statusname)
                              .setCreate(create)
                              .setDelivery(delivery)
                              .setOstatus(Misc.generatedId())
                              .setPaid(paid)
                              .setShipping(shipping)
                              .build();
    }

}
