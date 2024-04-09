package org.example.milk_farm;

public class Orders {

    public Orders(Double volume, String animal_kind, String date) {
        this.volume = volume;
        this.animal_kind = animal_kind;
        this.date = date;
    }

    public Orders() {

    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getAnimal_kind() {
        return animal_kind;
    }

    public void setAnimal_kind(String animal_kind) {
        this.animal_kind = animal_kind;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private Double volume;
    private String animal_kind;
    private String date;

}


