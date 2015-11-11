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
	public void intToBit_Returns_Correctly() {
		assertThat(Utility.bitToInt("00001010"), is(10));
	}




    @Test
    public void nullHexLengthTest() {
        assertThat(Utility.bitToInt(""), is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void tooLongHexLengthTest() {
        Utility.bitToInt("123456789");
    }

    @Test(expected = IllegalArgumentException.class)
    public void HexStringContainsSomethingWrongTest() {
        Utility.bitToInt("something wrong");
    }

    @Test
    public void intToHex_Returns_Correctly() {
        assertThat(Utility.bitToInt("111D7A"), is(1121658));
    }

}
