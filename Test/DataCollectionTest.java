import org.junit.*;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class DataCollectionTest {

    private DataCollection data;
    private MyReader mockReader;
    private String first = "000000000000000000000010";
    private String second = "000000000000000000000110";
    private String bwand = "000000000000000000000010";
    private String bwor = "000000000000000000000110";


    @Before
    public void setUp() throws Exception {
        mockReader = mock(MyReader.class);
        data = new DataCollection(mockReader);
    }

    @Test
    public void getReader_Returns_CorrectReader() {
        assertThat(data.getReader(), is(mockReader));
    }

    @Test
    public void setReader_Returns_NewReader() {
        MyReader newMockReader = mock(MyReader.class);
        data.setReader(newMockReader);
        assertThat(data.getReader(), is(newMockReader));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setReader_toNull_shouldNotWork() {
        data.setReader(null);
    }

    @Test
    public void readLine_GoodLine_ReturnsCorrectly() {
        when(mockReader.readLine()).thenReturn("2 1 " + first + " " + second);

        assertThat(data.readLine(), is("2 1 " + first + " " + second));
    }

    @Test(expected = IllegalArgumentException.class)
    public void readLine_badLine_shouldResultInException() {
        when(mockReader.readLine()).thenReturn("2 1 " + first);

        data.readLine();
    }

    @Test
    public void readLine_withNullPointer_shouldWork() {
        when(mockReader.readLine()).thenReturn(null);

        assertThat(data.readLine(), nullValue());
    }

    @Test
    public void readFile_Returns_FileCorrectly() {
        when(mockReader.readLine()).thenReturn("2 1 " + first + " " + second);
        when(mockReader.readLine()).thenReturn(null);

        data.readFile();

        assertThat(mockReader.readLine(), nullValue());
    }

    @Test
    public void splitLine_ReturnsLine_Correctly() {
        String[] t = data.splitLine("2 1 " + first + " " + second);

        assertThat(t[0], is("2"));
        assertThat(t[2], is(first));
        assertThat(t[3], is(second));
    }

    @Test
    public void calculate_BWAndAndReturns_Correctly() {
        assertThat(data.calculate("1", first, second), is(bwand));
    }

    @Test
    public void calculate_BWOrAndReturns_Correctly() {
        assertThat(data.calculate("2", first, second), is(bwor));
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculate_withbadBitwise_shouldResultInException() {
        data.calculate("3", first, second);
    }

    @Test
    public void save_withGoodValues_shouldStoreCorrectly() {
        data.save("2 1 " + first + " " + second);

        assertThat(data.getEntry("2").getBitwise(), is("1"));
        assertThat(data.getEntry("2").getFirstString(), is(first));
        assertThat(data.getEntry("2").getSecondString(), is(second));
        assertThat(data.getEntry("2").getBinaryResult(), is(bwand));
        assertThat(data.getEntry("2").getDecimalResult(), is(5));
    }

    @Test
    public void save_withBadBitwise_shouldSaveInErrors() {
        data.save("2 3 " + first + " " + second);
        assertThat(data.getErrors().get(0), is("2 3 " + first + " " + second));
    }

    @Test
    public void save_duplexData_InDuplex() {
        data.save("2 1 " + first + " " + second);
        data.save("2 2 " + second + " " + first);

        assertThat(data.getDuplex().get(0).getBitwise(), is("2"));
        assertThat(data.getDuplex().get(0).getFirstString(), is(second));
        assertThat(data.getDuplex().get(0).getSecondString(), is(first));
        assertThat(data.getDuplex().get(0).getBinaryResult(), is(bwor));
        assertThat(data.getDuplex().get(0).getDecimalResult(), is(35));

    }
}


