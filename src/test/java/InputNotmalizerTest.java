import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * Created by JAT on 30/06/2016.
 */
public class InputNotmalizerTest {
    private InputNormalizer input;

    @Before
    public void setUp(){
        input = new InputNormalizer();
    }

    @Test
    public void TestDopinfExplog10To20(){
        assertThat(input.dopingExp(10), is(Math.log10(10)));
        assertThat(input.dopingExp(15), is(Math.log10(15)));
        assertThat(input.dopingExp(20), is(Math.log10(20)));
    }

    @Test
    public void TestDopinfMantLog3To9(){
        assertThat(input.dopingMant(3), is(Math.log10(3)));
        assertThat(input.dopingMant(6), is(Math.log10(6)));
        assertThat(input.dopingMant(9), is(Math.log10(9)));
    }

    @Test
    public void TestTemperatureInputs100To500(){
        double[] results = {1.0/3.0, 2.0/3.0, 1.0, 4.0/3.0, 5.0/3.0};
        assertThat(input.TemperatureNormalizer(100), is(results[0]));
        assertThat(input.TemperatureNormalizer(200), is(results[1]));
        assertThat(input.TemperatureNormalizer(300), is(results[2]));
        assertThat(input.TemperatureNormalizer(400), is(results[3]));
        assertThat(input.TemperatureNormalizer(500), is(results[4]));
    }
}
