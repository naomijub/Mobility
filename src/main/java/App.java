/**
 * Created by JAT on 28/06/2016.
 */
public class App {
    /*
    * If you want to solve this Neural Network in less then a week you should
     * use Linux, with at least 16 GB RAM, and no other programs running
    */

    public static void main(String[] args) {
        InputNormalizer input = new InputNormalizer();
        OutputNormalizer output = new OutputNormalizer();
        Neuron[] in = {new Neuron(1), new Neuron(1)};
        Neuron[] hid = {new Neuron(in.length), new Neuron(in.length), new Neuron(in.length)};
        hid[0].defineWeights();
        hid[1].defineWeights();
        hid[2].defineWeights();
        Neuron[] out = {new Neuron(hid.length)};
        out[0].defineWeights();
        Think think = new Think(in, hid, out);

        Learn learn = new Learn(0.7, new double[][]{{input.dopingMant(1), input.dopingExp(17)},
                {input.dopingMant(5), input.dopingExp(17)}, {input.dopingMant(1), input.dopingExp(18)},
                {input.dopingMant(5), input.dopingExp(18)}, {input.dopingMant(1), input.dopingExp(19)},
                {input.dopingMant(5), input.dopingExp(19)}, {input.dopingMant(1), input.dopingExp(20)}},
                new double[]{output.mobilityNorm(1350, 687), output.mobilityNorm(1350, 436), output.mobilityNorm(1350, 357),
                        output.mobilityNorm(1350, 237), output.mobilityNorm(1350, 213), output.mobilityNorm(1350, 208),
                        output.mobilityNorm(1350, 200)});
        learn.train(in, hid, out, 0.001);


        double[] inputs = {input.dopingMant(5), input.dopingExp(17)};
        think.thinking(inputs);

        System.out.println();
        System.out.println(" 5E17 " + think.getOutputs()[0]);

        double[] inputs2 = {input.dopingMant(7.5), input.dopingExp(18)};
        think.thinking(inputs2);

        System.out.println();
        System.out.println(" 7.5E18 " + think.getOutputs()[0]);

    }
}
