/**
 * Created by JAT on 30/06/2016.
 */
public class Learn {

    /*
    * Known Algorithm - no TDD
    */

    private double learnCoef;
    private double[][] training;
    //1 result only (xor or mobility)
    private double[] expectedResults;

    public Learn(double learnCoef, double[][] training, double[] expectedResults){
        this.learnCoef = learnCoef;
        this.training = training;
        this.expectedResults = expectedResults;
    }

    //for the first block the training will be little skewed
    public void train(Neuron[] in, Neuron[] hid, Neuron[] out, double error){
        double currentError = 10000;
        long count = 0;
        Think think;
        while(currentError > error){
            double errorStep = 0;
            for(int i = 0; i < training.length;i++){
                double result = 0;
                think = new Think(in, hid, out);
                think.thinking(training[i]);
                result = expectedResults[i] - think.getOutputs()[0];
                errorStep += Math.pow(result, 2.0);
                double outError = outError(out, hid, expectedResults[i], think.getOutputs()[0]);
                hidError(in, hid, out, outError);
            }
            currentError = errorStep / expectedResults.length;
            if(count % 100000 == 0) System.out.println(count + " current error: " + currentError);
            count++;
        }
    }

    //out will be only [1]
    public double outError(Neuron[] out, Neuron[] hid, double expected, double actual){
        double error = actual * (1 - actual) * (expected - actual);
        for(int i = 0;i < hid.length;i++){
            double auxWeight = out[0].getWeight()[i] + (learnCoef * error * hid[i].getOutput());
            out[0].setWeightI(i, auxWeight);
        }
        return error;
    }

    public void hidError(Neuron[] in, Neuron[] hid, Neuron[] out, double errorOut) {
        for (int iHid = 0; iHid < hid.length; iHid++) {
            double output = hid[iHid].getOutput();
            for (int iIn = 0; iIn < in.length; iIn++) {
                double error = output * (1 - output) * errorOut * (out[0].getWeight()[iHid] * in[iIn].getOutput());
                double partialWeight = hid[iHid].getWeight()[iIn] + (learnCoef * error * in[iIn].getOutput());
                hid[iHid].setWeightI(iIn, partialWeight);
            }
        }
    }
}
