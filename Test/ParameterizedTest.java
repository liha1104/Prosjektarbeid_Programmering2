import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(org.junit.runners.Parameterized.class)
public class ParameterizedTest {
    private int dec;
    private String binary;

    public ParameterizedTest(String binary, String dec) {
        this.dec = Integer.parseInt(dec);
        this.binary = binary;
    }

    @Parameterized.Parameters
    public static java.util.Collection<String[]> input() {
        return java.util.Arrays.asList(new String[][]{
                {"000000000000000000000001", "1"},
                {"000000000000000000000010", "2"},
                {"00000000000000000000011", "3"},
                {"000000000000000000000100", "4"},
        });
    }

    @Test
    public void testBinaryToIntConversion() {
        assertThat(Utility.binaryToInt(binary), is(dec));
    }
}