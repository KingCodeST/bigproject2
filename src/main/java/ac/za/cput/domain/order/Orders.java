package ac.za.cput.domain.order;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Orders {

    @Id
    private String orderId;
    private Date createDate;
    private String desc;

    private Orders(){}

    private Orders(Builder builder)
    {
        this.createDate =builder.createDate;
        this.orderId =builder.orderId;
        this.desc =builder.desc;
    }

    public String getOrderId() {
        return orderId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getDesc() {
        return desc;
    }

    public static class Builder{
        private String orderId;
        private Date createDate;
        private String desc;

        public  Builder setOrderId(String orderId)
        {
            this.orderId =orderId;
            return this;
        }

        public Builder setDescption(String desc){
            this.desc =desc;
            return this;
        }

        public  Builder setCreateDate(Date createDate)
        {
            this.createDate =createDate;
            return this;
        }

        public Builder copy(Orders orders)
        {
            this.createDate = orders.createDate;
            this.orderId = orders.orderId;
            this.desc =orders.desc;
            return this;
        }

        public Orders build()
        {
            return new Orders(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return orderId.equals(builder.orderId) &&
                    Objects.equals(createDate, builder.createDate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(orderId);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "orderId='" + orderId + '\'' +
                    ", createDate=" + createDate +
                    '}';
        }
    }

}
