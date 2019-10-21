package ac.za.cput.factory.customer;

import ac.za.cput.domain.customer.Customer;
import ac.za.cput.util.Misc;

public class CustomerFactory {

    public static Customer GenerateBuilder(boolean active,String contact,String delivery,String fname,String lastname){

        return new Customer.Builder()
                            .setActive(active)
                            .setCustomerId(Misc.generatedId())
                            .setContact(contact)
                            .setDeliveryAddress(delivery)
                            .setFname(fname)
                            .setLname(lastname)
                            .build();


    }
}
