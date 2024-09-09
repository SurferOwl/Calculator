import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class Tests {

        @Test
        public void testAddition() {
            PoliModel a = new PoliModel(new TreeMap<>(Map.of(0, 1.0f, 1, 2.0f,2,1.0f)), 2);
            PoliModel b = new PoliModel(new TreeMap<>(Map.of(0, 3.0f, 1, 2.0f)), 1);

            PoliModel result = PoliController.addition(a, b);

            assertEquals(2, result.getDeg());
            assertEquals(4.0f, result.getC().get(0));
            assertEquals(4.0f, result.getC().get(1));
            assertEquals(1.0f, result.getC().get(2));
        }

        @Test
        public void testSubtraction() {
            PoliModel a = new PoliModel(new TreeMap<>(Map.of(0, 1.0f, 1, 2.0f,2,2.0f)), 2);
            PoliModel b = new PoliModel(new TreeMap<>(Map.of(0, 3.0f, 1, 1.0f,2,1.0f)), 2);

            PoliModel result = PoliController.substraction(a, b);

            assertEquals(2, result.getDeg());
            assertEquals(-2.0f, result.getC().get(0));
            assertEquals(1.0f, result.getC().get(1));
            assertEquals(1.0f, result.getC().get(2));
        }

        @Test
        public void testMultiply() {
            PoliModel a = new PoliModel(new TreeMap<>(Map.of(0, -1.0f, 1, 1.0f)), 1);
            PoliModel b = new PoliModel(new TreeMap<>(Map.of(0, 1.0f, 1, 1.0f)), 1);

            PoliModel result = PoliController.multiply(a, b);

            assertEquals(2, result.getDeg());
            assertEquals(-1.0f, result.getC().get(0));
            assertEquals(0.0f, result.getC().get(1));
            assertEquals(1.0f, result.getC().get(2));
        }

        @Test
        public void testDerivation() {
            PoliModel a = new PoliModel(new TreeMap<>(Map.of(0, 2.0f, 1, 33.0f, 2, 1.0f,4,7.0f)), 4);

            PoliModel result = PoliController.derivation(a);

            assertEquals(3, result.getDeg());
            assertEquals(33.0f, result.getC().get(0));
            assertEquals(2.0f, result.getC().get(1));
            assertEquals(null, result.getC().get(2));
            assertEquals(28.0f, result.getC().get(3));
        }

        @Test
        public void testIntegration() {
            PoliModel a = new PoliModel(new TreeMap<>(Map.of(0, 2.0f, 1, 3.0f)), 1);

            PoliModel result = PoliController.integration(a);

            assertEquals(2, result.getDeg());
            assertEquals(null, result.getC().get(0));
            assertEquals(2.0f, result.getC().get(1));
            assertEquals(1.5f, result.getC().get(2));
        }

    }
