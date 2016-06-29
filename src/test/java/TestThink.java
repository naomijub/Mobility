import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * Created by JAT on 29/06/2016.
 */
public class TestThink {
   private Think think;

    @Before
    public void setUp(){
        Neuron[] in = {new Neuron(1), new Neuron(1)};
        Neuron[] hid = {new Neuron(in.length), new Neuron(in.length)};
        hid[0].defineWeights();hid[1].defineWeights();
        Neuron[] out = {new Neuron(hid.length)};
        out[0].defineWeights();
        think = new Think(in, hid, out);
    }

    @Test
    public void checkIfOutputIsInNormalRange(){
        double[] inputs = {1.0, 1.0};
        think.thinking(inputs);
        Assert.assertTrue(think.getOutputs()[0] >= -2 && think.getOutputs()[0] <= 2);
    }
}
