package steelArms;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="steelarm")
@XmlAccessorType(XmlAccessType.FIELD)
public class SteelArm {

    private Handy handy;
    private Type type;
    private String origin;
    private boolean collectible;
    private double bladeLength;
    private double bladeWidth;
    private String material;
    private String handle;
    private boolean bloodFlow;


    public Handy getHandy() {
        return handy;
    }


    public void setHandy(Handy handy) {
        this.handy = handy;
    }

    public Type getType() {
        return type;
    }


    public void setType(Type type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }


    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public boolean isCollectible() {
        return collectible;
    }


    public void setCollectible(boolean collectible) {
        this.collectible = collectible;
    }

    public double getBladeLength() {
        return bladeLength;
    }


    public void setBladeLength(double bladeLength) {
        this.bladeLength = bladeLength;
    }

    public double getBladeWidth() {
        return bladeWidth;
    }


    public void setBladeWidth(double bladeWidth) {
        this.bladeWidth = bladeWidth;
    }

    public String getMaterial() {
        return material;
    }


    public void setMaterial(String material) {
        this.material = material;
    }

    public String getHandle() {
        return handle;
    }


    public void setHandle(String handle) {
        this.handle = handle;
    }

    public boolean isBloodFlow() {
        return bloodFlow;
    }


    public void setBloodFlow(boolean bloodFlow) {
        this.bloodFlow = bloodFlow;
    }


    @Override
    public String toString() {
        return "SteelArm{" +
                "handy=" + handy +
                ", type=" + type +
                ", origin='" + origin + '\'' +
                ", collectible=" + collectible +
                ", bladeLength=" + bladeLength +
                ", bladeWidth=" + bladeWidth +
                ", material='" + material + '\'' +
                ", handle='" + handle + '\'' +
                ", bloodFlow=" + bloodFlow +
                '}';
    }
}
