package com.usstu.soprmaterial.model;



public class Samples {
    private final Integer id;
    private final Integer id_material;
    private final Integer id_dobavca;
    private final String percent;
    private final String photo_before;
    private final String photo_after_impact_test;
    private final String photo_reverse;

    public Samples(Integer id, Integer id_material, Integer id_dobavca, String percent, String photo_before, String photo_after_impact_test, String photo_reverse) {
        this.id = id;
        this.id_material = id_material;
        this.id_dobavca = id_dobavca;
        this.percent = percent;
        this.photo_before = photo_before;
        this.photo_after_impact_test = photo_after_impact_test;
        this.photo_reverse = photo_reverse;
    }

    public Integer getId() {
        return id;
    }

    public Integer getId_material() {
        return id_material;
    }

    public Integer getId_dobavca() {
        return id_dobavca;
    }

    public String getPercent() {
        return percent;
    }

    public String getPhoto_before() {
        return photo_before;
    }

    public String getPhoto_after_impact_test() {
        return photo_after_impact_test;
    }

    public String getPhoto_reverse() {
        return photo_reverse;
    }
}
