package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;


@Entity
public class HomeReq {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Integer id;

    @Basic
    @JsonProperty("location")
    private String location;

    @Basic
    @JsonProperty("fromDate")
    private Date fromDate;

    @Basic
    @JsonProperty("toDate")
    private Date toDate;

    @Basic
    @JsonProperty("guestCount")
    private Integer guestCount;

    public HomeReq(){

    }

    public HomeReq(Integer id, String location, Date fromDate, Date toDate, Integer guestCount) {
        this.id = id;
        this.location = location;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.guestCount = guestCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Integer getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(Integer guestCount) {
        this.guestCount = guestCount;
    }
}
