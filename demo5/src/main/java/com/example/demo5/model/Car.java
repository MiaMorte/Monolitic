package com.example.demo5.model;

import com.example.demo5.enums.CarOption;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "car_table")
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "made_year")
    private String madeYear;
    @Column(name = "car_options")
    private CarOption carOption;

    @OneToMany(mappedBy = "car")
    private Collection<Person> persons;

    public Car(){}


    public long getId() {
        return id;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMadeYear() {
        return madeYear;
    }

    public void setMadeYear(String madeYear) {
        this.madeYear = madeYear;
    }

    public CarOption getCarOption() {
        return carOption;
    }

    public void setCarOption(CarOption carOption) {
        this.carOption = carOption;
    }

    public Collection<Person> persons() {
        return persons;
    }

    public void setPersons(Collection<Person> persons) {
        this.persons = persons;
    }
}
