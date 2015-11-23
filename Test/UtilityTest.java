import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class UtilityTest {

    @Test
    public void nullBinaryLengthTest() {
        assertThat(Utility.binaryToInt(""), is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void tooLongBinaryLengthTest() {
        Utility.binaryToInt("1111111111111111111111111111111111111111111111111111111111111111");
    }

    @Test(expected = IllegalArgumentException.class)
    public void binaryStringContainsSomethingOtherThan1or0Test() {
        Utility.binaryToInt("23456");
    }

    @Test
    public void BinaryToInt_Returns_Correctly() {
        assertThat(Utility.binaryToInt("00001010"), is(10));
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
    public void IntToHex_Returns_Corectly() {assertThat(Utility.intToHex(2721), is("AA1"));}

    @Test
    public void IntToBinary_Returns_Correctly() {assertThat(Utility.intToBinary(2), is("000000000000000000000010"));}

    @Test
    public void BitwiseAnd_Returns_Correctly() {
        assertThat(Utility.bitwiseAnd("000000000000000000000010", "000000000000000000000010"), is("000000000000000000000010"));
    }

    @Test
    public void BitwiseOr_Returns_Correctly() {
        assertThat(Utility.bitwiseOr("000000000000000000000110", "000000000000000000000010"), is("000000000000000000000110"));
    }

}
