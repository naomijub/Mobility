import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * Created by JAT on 30/06/2016.
 */
public class OutpurNormalizerTest {
    private OutputNormalizer output;

    @Before
    public void setUp(){
        output = new OutputNormalizer();
    }

    @Test
    public void TestMobilitiesOfIntrinsic436And208(){
        assertThat(output.mobilityNorm(1350, 1350), is(1.0));
        assertThat(output.mobilityNorm(1350, 436), is(0.32296296296296295));
        assertThat(output.mobilityNorm(1350, 208), is(0.15407407407407409));
    }
}
