package ac.za.cput.domain.order;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class OrderDetail {

    @Id
    private String orderDetailId;
    private int qty;
    private String taxStatus;

    private OrderDetail(){}

    private OrderDetail(Builder builder)
    {
        this.orderDetailId =builder.orderDetailId;
        this.qty =builder.qty;
        this.taxStatus=builder.taxStatus;
    }

    public String getOrderDetailId() {
        return orderDetailId;
    }

    public int getQty() {
        return qty;
    }

    public String getTaxStatus() {
        return taxStatus;
    }

    public static class Builder{
        private String orderDetailId;
        private int qty;
        private String taxStatus;

        public Builder setOrderDetailId(String orderDetailId)
        {
            this.orderDetailId =orderDetailId;
            return this;
        }

        public Builder setQty(int qty)
        {
            this.qty =qty;
            return this;
        }

        public Builder setTaxStatus(String taxStatus)
        {
            this.taxStatus =taxStatus;
            return this;
        }

        public Builder copy(OrderDetail orderDetail)
        {
            this.taxStatus =orderDetail.taxStatus;
            this.qty =orderDetail.qty;
            this.orderDetailId =orderDetail.orderDetailId;
            return this;
        }

        public OrderDetail build()
        {
            return new OrderDetail(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return qty == builder.qty &&
                    orderDetailId.equals(builder.orderDetailId) &&
                    Objects.equals(taxStatus, builder.taxStatus);
        }

        @Override
        public int hashCode() {
            return Objects.hash(orderDetailId);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "orderDetailId='" + orderDetailId + '\'' +
                    ", qty=" + qty +
                    ", taxStatus='" + taxStatus + '\'' +
                    '}';
        }
    }

}
