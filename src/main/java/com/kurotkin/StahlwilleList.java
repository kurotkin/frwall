package com.kurotkin;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="Stahlwille")
public class StahlwilleList {
    private List<Stahlwille> fasteners = new ArrayList<Stahlwille>();

    public List<Stahlwille> getFasteners() {
        return fasteners;
    }

    public void setFasteners(List<Stahlwille> fasteners) {
        this.fasteners = fasteners;
    }
}
