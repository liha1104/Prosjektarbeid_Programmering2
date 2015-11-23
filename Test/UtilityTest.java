import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class UtilityTest {

    @Test
    public void nullBitLengthTest() {
        assertThat(Utility.bitToInt(""), is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void tooLongBitLengthTest() {
        Utility.bitToInt("1111111111111111111111111111111111111111111111111111111111111111");
    }

    @Test(expected = IllegalArgumentException.class)
    public void bitStringContainsSomethingOtherThan1or0Test() {
        Utility.bitToInt("23456");
    }

    @Test
    public void BitToInt_Returns_Correctly() {
        assertThat(Utility.bitToInt("00001010"), is(10));
    }

    @Test
    public void nullHexLengthTest() {
        assertThat(Utility.hexToInt(""), is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void tooLongHexLengthTest() {
        Utility.hexToInt("123456789");
    }

    @Test(expected = IllegalArgumentException.class)
    public void HexStringContainsSomethingWrongTest() {
        Utility.hexToInt("HG14A");
    }

    @Test
    public void HexToInt_Returns_Correctly() {
        assertThat(Utility.hexToInt("a"), is(10));
    }

    @Test
    public void BitToInt_Returns_Corectly() {assertThat(Utility.intToHex(2721), is("AA1"));}

}
