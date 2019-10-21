package ac.za.cput.domain.payment;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Payment {

    @Id
    private String pymentId;
    private float amount;

    private Payment(){}

    private Payment(Builder builder)
    {
        this.amount =builder.amount;
        this.pymentId=builder.pymentId;
    }

    public String getPymentId() {
        return pymentId;
    }

    public float getAmount() {
        return amount;
    }

    public static class Builder{
        private String pymentId;
        private float amount;

        public Builder setPaymentId(String paymentId)
        {
            this.pymentId =paymentId;
            return this;
        }

        public Builder setAmount(float amount)
        {
            this.amount =amount;
            return this;
        }

        public Builder copy(Payment payment)
        {
            this.amount =payment.amount;
            this.pymentId=payment.pymentId;
            return this;
        }

        public Payment build()
        {
            return new Payment(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return Float.compare(builder.amount, amount) == 0 &&
                    pymentId.equals(builder.pymentId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(pymentId);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "pymentId='" + pymentId + '\'' +
                    ", amount=" + amount +
                    '}';
        }
    }

}
