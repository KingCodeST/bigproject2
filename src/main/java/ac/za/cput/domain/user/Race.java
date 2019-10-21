package ac.za.cput.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Race {

    @Id
    private String id;
    @Column(name= "description")
 //   @OneToMany()

    private String desc;

    private Race(){}

    public  Race(Builder builder)
    {
        this.id = builder.id;
        this.desc =builder.desc;
    }

    public String getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public static class Builder{
        private String id;
        private String desc;

        public Builder setId(String id)
        {
            this.id =id;
            return this;
        }

        public Builder setDesc(String desc)
        {
            this.desc =desc;
            return this;
        }

        public Builder copy(Race gender)
        {
            this.id =gender.id;
            this.desc =gender.desc;
            return this;
        }

        public Race build()
        {
            return new Race(this);
        }


    }


    @Override
    public String toString() {
        return "Race{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
