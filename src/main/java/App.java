/**
 * Created by JAT on 28/06/2016.
 */
public class App {
    public static void main(String[] args){
        Neuron[] in = {new Neuron(1), new Neuron(1)};
        Neuron[] hid = {new Neuron(in.length), new Neuron(in.length)};
        hid[0].defineWeights();hid[1].defineWeights();
        Neuron[] out = {new Neuron(hid.length)};
        out[0].defineWeights();
        Think think = new Think(in, hid, out);
        double[] inputs = {1.0, 1.0};
        think.thinking(inputs);

        System.out.println(think.getOutputs()[0]);
    }
}
