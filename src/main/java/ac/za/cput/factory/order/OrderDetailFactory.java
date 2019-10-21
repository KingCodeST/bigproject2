package ac.za.cput.factory.order;

import ac.za.cput.domain.order.OrderDetail;
import ac.za.cput.util.Misc;

public class OrderDetailFactory {

    public static OrderDetail GenerateBuilder(int qty,String status)
    {
        return new OrderDetail.Builder()
                              .setOrderDetailId(Misc.generatedId())
                              .setQty(qty)
                              .setTaxStatus(status)
                              .build();

    }


}
