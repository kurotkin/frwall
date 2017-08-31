package com.kurotkin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

@Entity
@XmlRootElement(name = "Site")
@XmlAccessorType(XmlAccessType.NONE)
public class Site implements Serializable {

    @Id
    @GeneratedValue
    @XmlElement
    private Long id;

    @XmlElement
    private String url;

    @XmlElement
    private int ageRelated;

    @XmlElement
    private String type;

    @XmlElement
    private String userID;

    public Site() {}

    public Site(String url, int ageRelated, String type, String userID) {
        this.url = url;
        this.ageRelated = ageRelated;
        this.type = type;
        this.userID = userID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAgeRelated() {
        return ageRelated;
    }

    public void setAgeRelated(int ageRelated) {
        this.ageRelated = ageRelated;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
