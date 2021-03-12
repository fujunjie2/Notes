import java.util.HashMap;
import java.util.LinkedHashMap;

public class Test {

    public static void main(String[] args) {
        int hash = "right".hashCode();

        int rh = (hash >>> 16) ^ hash;
        System.out.println(rh & 15);
        System.out.println(rh & 31);
        System.out.println(rh & 63);

    }
}
