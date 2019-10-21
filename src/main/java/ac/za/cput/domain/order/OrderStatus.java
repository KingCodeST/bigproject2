package ac.za.cput.domain.order;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class OrderStatus {

    @Id
    private String ostatusId;
    private String statusname;
    private int create ;
    private int shipping;
    private int delivery;
    private int paid ;

    private OrderStatus(){}

    private OrderStatus(Builder builder)
    {
        this.create =builder.create;
        this.delivery=builder.delivery;
        this.ostatusId=builder.ostatusId;
        this.paid =builder.paid;
        this.shipping =builder.shipping;
        this.statusname=builder.statusname;

    }

    public String getOstatusId() {
        return ostatusId;
    }

    public int getCreate() {
        return create;
    }

    public int getShipping() {
        return shipping;
    }

    public int getDelivery() {
        return delivery;
    }

    public int getPaid() {
        return paid;
    }

    public String getStatusname() {
        return statusname;
    }

    public static class Builder{

        private String ostatusId;
        private int create ;
        private int shipping;
        private int delivery;
        private int paid ;
        private String statusname;

        public Builder setOstatus(String ostatus)
        {
            this.ostatusId =ostatus;
            return this;
        }

        public Builder setStatus(String statusname)
        {
            this.statusname =statusname;
            return this;
        }

        public Builder setCreate(int create)
        {
            this.create =create;
            return this;
        }

        public Builder setShipping(int shipping)
        {
            this.shipping =shipping;
            return this;
        }

        public Builder setDelivery(int delivery)
        {
            this.delivery =delivery;
            return this;
        }

        public Builder setPaid(int paid)
        {
            this.paid =paid;
            return this;
        }

        public Builder copy(OrderStatus orderStatus)
        {
            this.statusname=orderStatus.statusname;
            this.paid =orderStatus.paid;
            this.delivery=orderStatus.delivery;
            this.shipping=orderStatus.shipping;
            this.create =orderStatus.create;
            this.ostatusId =orderStatus.ostatusId;
            return this;
        }

        public OrderStatus build()
        {
            return new OrderStatus(this);
        }


    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Builder builder = (Builder) o;
        return create == builder.create &&
                shipping == builder.shipping &&
                delivery == builder.delivery &&
                paid == builder.paid &&
                ostatusId.equals(builder.ostatusId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ostatusId);
    }

    @Override
    public String toString() {
        return "Builder{" +
                "ostatusId='" + ostatusId + '\'' +
                ", create=" + create +
                ", shipping=" + shipping +
                ", delivery=" + delivery +
                ", paid=" + paid +
                '}';
    }
}
