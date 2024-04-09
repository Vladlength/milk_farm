package org.example.milk_farm;

public class Options {
    private Double volume;
    private String animal_kind;
    private Double animal_num;
    private Integer personalNumber;
    private String date;

    public Options(Double volume, String animal_kind, Double animal_num, Integer personalNumber, String date) {
        this.volume = volume;
        this.animal_kind = animal_kind;
        this.animal_num = animal_num;
        this.personalNumber = personalNumber;
        this.date = date;
    }

    public Options() {

    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = Double.valueOf(volume);
    }

    public String getAnimal_kind() {
        return animal_kind;
    }

    public void setAnimal_kind(String animal_kind) {
        this.animal_kind = animal_kind;
    }

    public Double getAnimal_num() {
        return Double.valueOf(animal_num);
    }

    public void setAnimal_num(Double animal_num) {
        this.animal_num = animal_num;
    }

    public Integer getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(Integer personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
