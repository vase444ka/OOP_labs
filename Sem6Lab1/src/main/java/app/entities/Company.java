package app.entities;

public class Company {
    private static String name;
    private static Integer luggagePrice;
    private static Integer fastLanePrice;
    private static Integer capacityMarkup;
    private static Integer dateMarkup;

    private Company(){}

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Company.name = name;
    }

    public static Integer getLuggagePrice() {
        return luggagePrice;
    }

    public static void setLuggagePrice(Integer luggagePrice) {
        Company.luggagePrice = luggagePrice;
    }

    public static Integer getFastLanePrice() {
        return fastLanePrice;
    }

    public static void setFastLanePrice(Integer fastLanePrice) {
        Company.fastLanePrice = fastLanePrice;
    }

    public static Integer getCapacityMarkup() {
        return capacityMarkup;
    }

    public static void setCapacityMarkup(Integer capacityMarkup) {
        Company.capacityMarkup = capacityMarkup;
    }

    public static Integer getDateMarkup() {
        return dateMarkup;
    }

    public static void setDateMarkup(Integer dateMarkup) {
        Company.dateMarkup = dateMarkup;
    }
}
