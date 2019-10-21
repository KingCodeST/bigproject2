package ac.za.cput.domain.customer;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    private String customerId;
    private String fname;
    private String lname;
    private String deliveryAddress;
    private String contact;
    private boolean active;


    private Customer(){}

    private Customer(Builder builder)
    {
        this.customerId=builder.customerId;
        this.fname =builder.fname;
        this.lname =builder.lname;
        this.deliveryAddress =builder.deliveryAddress;
        this.contact =builder.contact;
        this.active =builder.active;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getContact() {
        return contact;
    }

    public String getCustomerId() {
        return customerId;
    }

    public boolean isActive() {
        return active;
    }

    public static class Builder{

        private String customerId;
        private String fname;
        private String lname;
        private String deliveryAddress;
        private String contact;
        private boolean active;

        public Builder setFname(String fname)
        {
            this.fname = fname;
            return this;
        }
        public Builder setCustomerId(String customerId)
        {
            this.customerId = customerId;
            return this;
        }


        public Builder setLname(String lname)
        {
            this.lname = lname;
            return this;
        }

        public Builder setDeliveryAddress(String deliveryAddress)
        {
            this.deliveryAddress =deliveryAddress;
            return this;
        }

        public Builder setContact(String contact)
        {
            this.contact =contact;
            return this;
        }

        public Builder setActive(boolean active)
        {
            this.active =active;
            return this;
        }

        public Builder copy(Customer customer)
        {
            this.contact =customer.contact;
            this.deliveryAddress =customer.deliveryAddress;
            this.active =customer.active;
            this.lname =customer.lname;
            this.fname =customer.fname;
            this.customerId =customer.customerId;
            return this;
        }


        public Customer build()
        {
            return new Customer(this);
        }



        @Override
        public String toString() {
            return "Builder{" +
                    "fname='" + fname + '\'' +
                    ", lname='" + lname + '\'' +
                    ", deliveryAddress='" + deliveryAddress + '\'' +
                    ", contact='" + contact + '\'' +
                    ", active=" + active +
                    '}';
        }
    }

}
