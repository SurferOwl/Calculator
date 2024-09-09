import java.util.Map;
import java.util.TreeMap;

interface PoliController {

    public static PoliModel addition(PoliModel a, PoliModel b) {

        Map<Integer,Float> c = new TreeMap<>();

        PoliModel result;

        int deg = a.getDeg() < b.getDeg() ? b.getDeg() : a.getDeg();

        for(int i=0;i<=deg;i++){
            if(a.getC().get(i)==null&&b.getC().get(i)!=null)
                c.put(  i,b.getC().get(i));

            else if(b.getC().get(i)==null&&a.getC().get(i)!=null)
                c.put(i,a.getC().get(i));

            else if(a.getC().get(i)!=null&&b.getC().get(i)!=null)
                c.put(i,a.getC().get(i)+b.getC().get(i));

        }

        result = new PoliModel(c,deg);

        return result;

    }

    public static PoliModel substraction(PoliModel a, PoliModel b) {

        Map<Integer,Float> c = new TreeMap<>();

        PoliModel result;

        int deg = a.getDeg() < b.getDeg() ? b.getDeg() : a.getDeg();

        for(int i=0;i<=deg;i++){
            if(a.getC().get(i)==null&&b.getC().get(i)!=null)
                c.put(i,(-1)*b.getC().get(i));

            else if(b.getC().get(i)==null&&a.getC().get(i)!=null)
                c.put(i,a.getC().get(i));

            else if(a.getC().get(i)!=null&&b.getC().get(i)!=null)
                c.put(i,a.getC().get(i)-b.getC().get(i));

        }

        result = new PoliModel(c,deg);

        return result;

    }

    public static PoliModel multiply(PoliModel a, PoliModel b) {

        int d = a.getDeg() + b.getDeg() ;

        Map<Integer,Float> coef = new TreeMap<>();

        for(int i=0;i<=d;i++)
            coef.put(i,0f);

        for (Integer i:a.getC().keySet())
            for(Integer j:b.getC().keySet()){
                coef.put(i+j,coef.get(i+j)+a.getC().get(i)*b.getC().get(j));
            }


        PoliModel c = new PoliModel(coef,d);

        return c;

    }

    public static PoliModel derivation(PoliModel a){

        PoliModel b;

        Map<Integer,Float> coef = new TreeMap<>();

        for (Integer i:a.getC().keySet()){
            coef.put(i-1,a.getC().get(i)*i);}

        b = new PoliModel(coef,a.getDeg()-1);

        return b;
    }

    public static PoliModel integration(PoliModel a){

        PoliModel b;

        Integer y = -1;

        Map<Integer,Float> coef = new TreeMap<>();

        for (Integer i:a.getC().keySet()){
            if(!i.equals(y))
                coef.put(i+1,a.getC().get(i)/(i+1));}

        b = new PoliModel(coef,a.getDeg()+1);

        return b;
    }

}
