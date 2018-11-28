package steelArms;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "steelarms")
@XmlAccessorType (XmlAccessType.FIELD)
public class SteelArms {

    @XmlElement(name="steelarm")
    private List<SteelArm> weapons=null;

    public List<SteelArm> getArr() {
        return weapons;
    }

    public void setArr(List<SteelArm> weapons) {
        this.weapons = weapons;
    }
}
