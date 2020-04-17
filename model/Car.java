package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private int number;

    @Column(name = "series")
    private int series;


    public Car(String name, int series){
        this.name = name;
        this.series = series;
    }

    public Car() { }

    public Car(int number, int series){
        this.number = number;
        this.series = series;
    }


    public Car(long id){
        this.id = id;
    }

    public Car(long id, String name, int number, int series){
        this.id = id;
        this.name = name;
        this.number = number;
        this.series = series;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() { return number; }

    public void setNumber(int number) { this.number = number; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
