package com.spitter.app;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.Date;

public class Spittle {

    private final long id;
    private final Date time;
    private Double latitude;
    private Double longitude;
    private String message;

    public Spittle(String message, Date time) {
        this(message, time, null, null);
    }

    public Spittle(
            String message, Date time, Double longitude, Double latitude){
        this.id = 0L;
        this.message = message;
        this.time = time;
        this.longitude = longitude;
        this.latitude = latitude;

    }
    public long getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        return (int) id;
    }

    @Override
    public boolean equals(Object obj) {
        Spittle spittleObj = (Spittle) obj;
        return (this.id==spittleObj.id
                && this.time.equals(spittleObj.time));
    }
}
