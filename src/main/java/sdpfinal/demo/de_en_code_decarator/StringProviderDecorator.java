package sdpfinal.demo.de_en_code_decarator;

public class StringProviderDecorator implements StringProvider {
    private StringProvider delegate;
    public StringProviderDecorator(StringProvider delegate) {
        this.delegate = delegate;
    }
    @Override
    public String getStringValue() {
        return this.delegate.getStringValue();
    }
}