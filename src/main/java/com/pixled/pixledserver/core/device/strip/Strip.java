package com.pixled.pixledserver.core.device.strip;

import com.pixled.pixledserver.core.device.base.Device;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Strip extends Device {

    @Column
    private Integer length;

    public Strip(){
        super();
    }

    public Strip(Integer length) {
        super();
        this.length = length;
    }

    public Strip(StripDto stripDto) {
        super(stripDto);
        length = stripDto.getLength();
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

}
