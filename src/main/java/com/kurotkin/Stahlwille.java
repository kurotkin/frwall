package com.kurotkin;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "Stahlwille")
@XmlAccessorType(XmlAccessType.NONE)
public class Stahlwille implements Serializable {
    @XmlAttribute
    private Integer w;

    @XmlElement
    private Integer id;

    @XmlElement
    private String time;

    @XmlElement
    private double torque;


    @XmlElement
    private String serno;

    @XmlElement
    private String name;

    public Stahlwille(Integer w, Integer id, double torque, String time, String serno, String name) {
        super();
        this.w = w;
        this.id = id;
        this.time = time;
        this.torque = torque;
        this.serno = serno;
        this.name = name;
    }

    public Stahlwille() {

    }
}
