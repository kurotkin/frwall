package com.kurotkin;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="Site")
public class SiteList {
    private List<Site> fasteners = new ArrayList<Site>();

    public List<Site> getFasteners() {
        return fasteners;
    }

    public void setFasteners(List<Site> fasteners) {
        this.fasteners = fasteners;
    }
}
