package ac.za.cput.factory.order;

import ac.za.cput.domain.order.Item;
import ac.za.cput.util.Misc;

public class ItemFactory {

    public static Item GenerateBuilder(String desc,int weight){

        return new Item.Builder()
                        .setDescription(desc)
                        .setItemId(Misc.generatedId())
                        .setWeight(weight)
                        .build();

    }


}
