package app.entities;

import java.sql.Timestamp;

public class Ticket {
    private Long id;
    private Long flightId;
    private Long clientId;
    private Boolean luggage;
    private Boolean fastLane;
    private Timestamp datePurchased;
    private Integer price;

    public Ticket() {
    }

    public Ticket(Long flightId, Long clientId, Boolean luggage, Boolean fastLane, Timestamp datePurchased, Integer price) {
        this.flightId = flightId;
        this.clientId = clientId;
        this.luggage = luggage;
        this.fastLane = fastLane;
        this.datePurchased = datePurchased;
        this.price = price;
    }

    public Ticket(Long id, Long flightId, Long clientId, Boolean luggage, Boolean fastLane, Timestamp datePurchased, Integer price) {
        this.id = id;
        this.flightId = flightId;
        this.clientId = clientId;
        this.luggage = luggage;
        this.fastLane = fastLane;
        this.datePurchased = datePurchased;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Boolean getLuggage() {
        return luggage;
    }

    public void setLuggage(Boolean luggage) {
        this.luggage = luggage;
    }

    public Boolean getFastLane() {
        return fastLane;
    }

    public void setFastLane(Boolean fastLane) {
        this.fastLane = fastLane;
    }

    public Timestamp getDatePurchased() {
        return datePurchased;
    }

    public void setDatePurchased(Timestamp datePurchased) {
        this.datePurchased = datePurchased;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
