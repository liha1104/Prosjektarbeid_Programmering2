
import java.util.*;

public class DataCollection {

    private List<Entry> duplexList;
    private Map<String, Entry> entryMap;
    private List<String> errors;
    private MyReader reader;

    public DataCollection(MyReader reader) {

        duplexList = new ArrayList<>();
        entryMap = new HashMap<>();
        errors = new ArrayList<>();
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
        private String bitwise, first, second, binary;

        public Entry(String bitwise, String first, String second, String binary, Integer dec) {
            this.bitwise = bitwise;
            this.first = first;
            this.second = second;
            this.binary = binary;
            this.dec = dec;
        }

        public String getBitwise() {
            return bitwise;
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

    public void readFile() {
        String line;

        while ((line = readLine()) != null)
            save(line);
    }

    protected void save(String l) {
        String[] t = splitLine(l);
        String binary = getBinary(l, t);

        if (entryMap.containsKey(t[0]))
            duplexList.add(newEntry(t, binary));
        else if (binary != null)
            saveNormal(t, binary);
    }

    protected String[] splitLine(String line) {
        StringTokenizer tokenizer = new StringTokenizer(line);
        String[] t = new String[4];

        for (int i = 0; tokenizer.hasMoreElements(); i++)
            t[i] = tokenizer.nextToken();

        return t;
    }

    private String getBinary(String l, String[] t) {
        String binary = null;

        try {
            binary = calculate(t[1], t[2], t[3]);
        } catch (IllegalArgumentException e) {
            saveError(l);
        }

        return binary;
    }

    protected String calculate(String bitwise, String first, String second) {
        if (!bitwise.matches("[12]+"))
            throw new IllegalArgumentException("Your line has an illegal operator in it");

        if (bitwise.equals("1"))
            return Utility.bitwiseAnd(first, second);
        else
            return Utility.bitwiseOr(first, second);
    }

    private void saveError(String l) {
        errors.add(l);
    }

    public List<String> getErrors() {
        return errors;
    }

    private void saveNormal(String[] t, String binary) {
        entryMap.put(t[0], newEntry(t, binary));
    }

    public List<Entry> getDuplex() {
        return duplexList;
    }

    private Entry newEntry(String[] t, String binary) {
        return new Entry(t[1], t[2], t[3], binary, Utility.binaryToInt(binary));
    }

    public Entry getEntry(String hex) {
        return entryMap.get(hex);
    }


}
