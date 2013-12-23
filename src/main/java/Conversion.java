import com.google.common.collect.ImmutableList;


public class Conversion {

    public static final int Ten = 10;

    public static String arabicToRoman(int grade) {
        ImmutableList<String> ones = ImmutableList.of("","I","II","III","IV","V","VI","VII","VIII","IX");
        ImmutableList<String> tens = ImmutableList.of("","X","XX","XXX","XL","L","LX","LXX","LXXX","XC");
        return tens.get(grade / Ten) + ones.get(grade % Ten);
    }
}
