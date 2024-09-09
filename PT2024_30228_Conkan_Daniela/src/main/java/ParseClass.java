import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ParseClass {
    public static PoliModel createPolynom(String input) {
        String pattern = "([-+])?([0-9]*\\.?[0-9]+)?(x\\^?([0-9]+)?)?";
        Pattern pPoly = Pattern.compile(pattern);
        Matcher mPoly = pPoly.matcher(input);

        Map<Integer, Float> polynom = new TreeMap<>();

        while (mPoly.find()) {
            String coef = mPoly.group(2);
            String pow = mPoly.group(3);

            if (coef != null && pow == null)
                pow = "0";

            else if(coef==null && pow != null){
                coef = "1";}

            if(pow!=null)
                if(pow.equals("x")){
                    pow = "x^1";

                    if(coef == null)
                      coef = "1";}



            if (coef != null && pow != null) {
                Float coefFloat = Float.parseFloat(coef);

                if(mPoly.group(1) != null)
                    if (mPoly.group(1).charAt(0) == '-')
                        coefFloat *= -1;

                Integer powInt = Integer.parseInt(pow.length() >= 2 ? pow.substring(2) : "0");
                polynom.put(powInt, coefFloat);
            }
        }

        int deg=0;

        for(Integer c:polynom.keySet())
            if(deg<c)
                deg=c;

        PoliModel p = new PoliModel(polynom,deg);

        return p;
    }
}
