/**
 * Created by JAT on 29/06/2016.
 */
public class Think {
    private Neuron[] in;
    private Neuron[] hid;
    private Neuron[] out;

    public Think(Neuron[] in, Neuron[] hid, Neuron[] out){
        this.in = in;
        this.hid = hid;
        this.out = out;
    }

    public void thinking(double[] inputs){
        if(inputs.length == in.length){
            thinkInNeuron(inputs);
            thinkHidNeuron();
            thinkOutNeuron();
        }
    }

    private void thinkOutNeuron(){
        for(int i = 0; i < out.length;i++){
            for(int k = 0;k  < hid.length;k++){
                out[i].setInputI(k, hid[k].getOutput());
            }
            out[i].tanh();
        }
    }

    private void thinkHidNeuron(){
        for(int i = 0; i < hid.length;i++){
            for(int k = 0;k  < in.length;k++){
                hid[i].setInputI(k, in[k].getOutput());
            }
            hid[i].tanh();
        }
    }

    private void thinkInNeuron(double[] inputs){
        for(int i = 0; i < in.length;i++){
            in[i].setInputI(0, inputs[i]);
            in[i].tanh();
        }
    }

    public double[] getOutputs(){
        double[] outputs = new double[out.length];
        for(int i = 0;i < out.length;i++){
            outputs[i] = out[i].getOutput();
        }
        return outputs;
    }
}
