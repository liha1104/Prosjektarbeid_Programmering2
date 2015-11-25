import java.io.Reader;
import java.util.*;

public class DataCollection {

    private Map<String, Entry> entryMap;
    private List<Entry> duplexList;
    private List<String> errors;
    private MyReader reader;

    public DataCollection(MyReader reader) {
        this.reader = reader;
    }

    public MyReader getReader() {
        return reader;
    }

    public void setReader(MyReader reader) {
        if (reader == null)
            throw new IllegalArgumentException("Reader cannot be null");
        this.reader = reader;
    }

    protected String readLine() {
        String line = reader.readLine();
        if (line != null && line.length() != 58)
            throw new IllegalArgumentException("Line is not up to standards");
        return line;
    }

    class Entry {

        private Integer dec;
        private String operator, first, second, binary;

        public Entry(String operator, String first, String second, String binary, Integer dec) {
            this.operator = operator;
            this.first = first;
            this.second = second;
            this.binary = binary;
            this.dec = dec;
        }

        public String getOperator() {
            return operator;
        }

        public String getFirstString() {
            return first;
        }

        public String getSecondString() {
            return second;
        }

        public String getBinaryResult() {
            return binary;
        }

        public Integer getDecimalResult() {
            return dec;
        }
    }


}
