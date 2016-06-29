import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by JAT on 28/06/2016.
 */
public class NeuronTest {
    private Neuron neuron;

    @Before
    public void setUp() throws Exception {
        neuron = new Neuron(2);
    }

    @Test
    public void testNeuronSizeEqual2(){
        assertThat(neuron.getInput().length, is(2));
        assertThat(neuron.getWeight().length, is(2));
    }

    //@Test
    //public void testTanhIfInputsAreZeroEqualZero(){
    //    assertThat(neuron.math(), is(0.0));
    //}

    @Test
    public void IsWeightsInRange(){
        neuron.defineWeights();
        Assert.assertTrue(neuron.getWeight()[0] >= -1);
        Assert.assertTrue(neuron.getWeight()[1] >= -1);
        Assert.assertTrue(neuron.getWeight()[0] <= 1);
        Assert.assertTrue(neuron.getWeight()[1] <= 1);
    }

    @Test
    public void checkIfAllInputsAreZeroOutputIsZero(){
        neuron.defineWeights();
        neuron.setInputI(0, 0);
        neuron.setInputI(1, 0);
        neuron.tanh();
        assertThat(neuron.getOutput(), is(0.0));
    }

    @Test
    public void checkIfOutputIsGreaterThanZero(){
        neuron.defineWeights();
        neuron.setInputI(0, 1);
        neuron.setInputI(1, 1);
        neuron.tanh();
        Assert.assertTrue(neuron.getOutput() >= 0);
    }
}
