package ac.za.cput.domain.order;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Item {

        @Id
        private String itemId;
        private int weight;
        private String description;

    private Item(){}

    private Item(Builder builder){
        this.itemId =builder.itemId;
        this.description=builder.description;
        this.weight =builder.weight;
    }

    public String getItemId() {
        return itemId;
    }

    public int getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder{

        private String itemId;
        private int weight;
        private String description;

        public  Builder setItemId(String itemId)
        {
            this.itemId =itemId;
            return this;
        }

        public Builder setWeight(Integer weight)
        {
            this.weight =weight;
            return this;
        }

        public Builder setDescription(String desc)
        {
            this.description = desc;
            return this;
        }

        public Builder copy(Item item)
        {
            this.description =item.description;
            this.weight =item.weight;
            this.itemId =item.itemId;
            return this;
        }

        public Item build()
        {
            return new Item(this);
        }



    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Builder builder = (Builder) o;
        return weight == builder.weight &&
                itemId.equals(builder.itemId) &&
                Objects.equals(description, builder.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }

    @Override
    public String toString() {
        return "Builder{" +
                "itemId='" + itemId + '\'' +
                ", weight=" + weight +
                ", description='" + description + '\'' +
                '}';
    }

}
