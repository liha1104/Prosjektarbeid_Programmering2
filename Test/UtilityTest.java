import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class UtilityTest {

	@Test
	public void nullLengthTest() {
		assertThat(Utility.bitToInt(""), is(0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void tooLongLengthTest() {
		Utility.bitToInt("1111111111111111111111111111111111111111111111111111111111111111");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void StringContainsSomethingOtherThan1or0Test() {
		Utility.bitToInt("23456");
	}
	
	@Test
	public void intToBit_Returns_Correctly() {
		assertThat(Utility.bitToInt("00001010"), is(10));
	}
	
}
