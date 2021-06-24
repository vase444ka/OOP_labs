package app.entities;

import java.sql.Timestamp;

public class Flight {
    private Long id;
    private String origin, destination;
    private Timestamp date;
    private Integer duration;
    private Integer capacity;
    private Integer basePrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Integer basePrice) {
        this.basePrice = basePrice;
    }

    public Flight(String origin, String destination, Timestamp date, Integer duration, Integer capacity, Integer basePrice) {
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.duration = duration;
        this.capacity = capacity;
        this.basePrice = basePrice;
    }

    public Flight(Long id, String origin, String destination, Timestamp date, Integer duration, Integer capacity, Integer basePrice) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.duration = duration;
        this.capacity = capacity;
        this.basePrice = basePrice;
    }

    @Override
    public String toString(){
        return "Lowcost flight from " + origin + " to " + destination;
    }
}
