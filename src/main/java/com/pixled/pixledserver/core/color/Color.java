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
        argb = colorDto.getArgb();
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
        convertToArbg();
    }

    public Float getSaturation() {
        return saturation;
    }

    public void setSaturation(Float saturation) {
        this.saturation = saturation;
        convertToArbg();
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
        convertToArbg();
    }

    public Integer getArgb() {
        return argb;
    }

//    public void setArgb(Integer argb) {
//        this.argb = argb;
//    }

    private void convertToArbg() {
        int h = (int)(hue / 60);
        float f = hue / 60 - h;
        float p = value * (1 - saturation);
        float q = value * (1 - f * saturation);
        float t = value * (1 - (1 - f) * saturation);

        switch (h) {
            case 0: argb = rgbToInt(value, t, p); break;
            case 1: argb = rgbToInt(q, value, p); break;
            case 2: argb = rgbToInt(p, value, t); break;
            case 3: argb = rgbToInt(p, q, value); break;
            case 4: argb = rgbToInt(t, p, value); break;
            case 5: argb = rgbToInt(value, p, q); break;
            default: throw new RuntimeException("Something went wrong when converting from HSV to RGB. Input was " + hue + ", " + saturation + ", " + value);
        }
    }

    private static int rgbToInt(float red, float green, float blue) {
        int r = (int)(red * 255);
        int g = (int)(green * 255);
        int b = (int)(blue * 255);
        return (0xff) << 24 | (r & 0xff) << 16 | (g & 0xff) << 8 | (b & 0xff);
    }
}
