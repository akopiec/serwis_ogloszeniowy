package app.entity;


import javax.persistence.*;

@Entity
@Table(name="motorization")
public class Motorization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int price;
    @Column
    private int year;
    @Column
    private String color;
    @Column
    private String brand;
    @Column
    private String type;
    @Column
    private String description;
    @Column
    private String title;
    @ManyToOne
    @JoinColumn(name="username")
    private User user;


    public Motorization(){
    }

    public Motorization(int price, int year, String color, String brand,String type, String description,String title) {

        this.price = price;

        this.year = year;

        this.color = color;

        this.brand = brand;

        this.type = type;

        this.description = description;

        this.title = title;
    }

    public Motorization(int price, int year, String color, String brand,String type, String description,String title,User user) {

        this.price = price;

        this.year = year;

        this.color = color;

        this.brand = brand;

        this.type=type;

        this.description = description;

        this.title=title;

        this.user=user;
    }


    public Long getId() {

        return id;
    }

    public int getPrice() {

        return price;
    }

    public int getYear() {

        return year;
    }

    public String getColor() {

        return color;
    }

    public String getBrand() {

        return brand;
    }
    public String getType(){

        return type;
    }

    public String getDescription() {

        return description;
    }
    public String getTitle(){
        return title;
    }


    public User getUser() {

        return user;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public void setPrice(int price) {

        this.price = price;
    }

    public void setYear(int year) {

        this.year = year;
    }

    public void setColor(String color) {

        this.color = color;
    }

    public void setBrand(String brand) {

        this.brand = brand;
    }

    public void setType(String type){

        this.type=type;
    }

    public void setDescription(String description) {

        this.description = description;
    }
    public void setTitle(String title){

        this.title=title;
    }

    public void setUser(User user) {

        this.user = user;
    }
}


