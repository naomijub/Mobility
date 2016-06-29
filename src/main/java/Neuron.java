import java.util.Random;

/**
 * Created by JAT on 28/06/2016.
 */
public class Neuron {
    private double[] input;
    private double[] weight;
    private double output;
    private int n;
    static Random rg;

    public Neuron(int n){
        input = new double[n];
        weight = new double[n];
        this.n = n;
        rg = new Random();
        allOneWeights();
    }

    public void allOneWeights(){
        for(int i = 0;i < n;i++){
            weight[i] = 1;
        }
    }

    public double[] getInput(){
        return input;
    }

    public double[] getWeight(){
        return weight;
    }

    public double getOutput(){
        return output;
    }

    public void setInputI(int i, double inValue){
        if(i >= 0 && i < n){
            input[i] = inValue;
        }
    }

    public void defineWeights(){
        for(int i = 0; i < n;i++){
            weight[i] = (rg.nextInt(9) - 4.0) / 4.0;

            System.out.println(weight[i]);
        }
    }

    private double math(){
        double sum = 0;
        for(int i = 0;i < n;i++){
            sum += input[i] * weight[i];
        }
        return sum;
    }

    public void tanh(){
        output = Math.tanh(math());
    }
}
