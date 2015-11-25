import org.junit.*;

import java.io.Reader;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertThat;
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
    public void readLine_Returns_Line() {
        when(mockReader.readLine()).thenReturn("2 1 " + first + " " + second);

        assertThat(data.readLine(), is("2 1 " + first + " " + second));
    }


}