package com.pixled.pixledserver.core.color;

import javax.persistence.*;

@Entity
public class Color {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Float hue;

    @Column
    private Float saturation;

    @Column
    private Float value;

    @Column
    private Integer argb;

    public Color(){

    }

    public Color(Float hue, Float saturation, Float value, Integer argb) {
        this.hue = hue;
        this.saturation = saturation;
        this.value = value;
        this.argb = argb;
    }

    public Color(ColorDto colorDto) {
        hue = colorDto.getHue();
        saturation = colorDto.getSaturation();
        value = colorDto.getValue();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getHue() {
        return hue;
    }

    public void setHue(Float hue) {
        this.hue = hue;
    }

    public Float getSaturation() {
        return saturation;
    }

    public void setSaturation(Float saturation) {
        this.saturation = saturation;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Integer getArgb() {
        return argb;
    }

    public void setArgb(Integer argb) {
        this.argb = argb;
    }
}
