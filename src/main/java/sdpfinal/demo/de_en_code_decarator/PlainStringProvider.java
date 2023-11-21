package sdpfinal.demo.de_en_code_decarator;

public class PlainStringProvider implements StringProvider {
    private String stringValue;
    public PlainStringProvider(String stringValue) {
        this.stringValue = stringValue;
    }
    @Override
    public String getStringValue() {
        return this.stringValue;
    }
}