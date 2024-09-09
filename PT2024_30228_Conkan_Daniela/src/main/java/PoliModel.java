import java.util.*;

public class PoliModel implements PoliController{

    private Map<Integer,Float> c; //coeficienti
    private int deg; //gradul

    public PoliModel(Map<Integer,Float> p, int d) {

        c = p;
        deg = d;

    }

    public void setC(Map<Integer, Float> c) {
        this.c = c;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public Map<Integer, Float> getC() {
        return c;
    }

    public int getDeg() {
        return deg;
    }

    @Override
    public String toString() {
        return "Polynomial{" +
                "c=" + c +
                ", deg=" + deg +
                '}';
    }

   }
