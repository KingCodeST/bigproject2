package ac.za.cput.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Gender {

    @Id
    private String id;
    @Column(name= "gender_name")
  //  @OneToMany()

    private String desc;

    private Gender(){}

    public  Gender(Builder builder)
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

        public Builder copy(Gender gender)
        {
            this.id =gender.id;
            this.desc =gender.desc;
            return this;
        }

        public Gender build()
        {
            return new Gender(this);
        }


    }


    @Override
    public String toString() {
        return "Gender{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
