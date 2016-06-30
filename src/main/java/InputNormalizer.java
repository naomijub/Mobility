/**
 * Created by JAT on 29/06/2016.
 */
public class InputNormalizer {

    public InputNormalizer(){}

    public double dopingExp(double value){
        return Math.log10(value);
    }

    public double dopingMant(double value){
        return Math.log10(value);
    }

    public double TemperatureNormalizer(double temp){
        return (temp / 300.0);
    }


}
