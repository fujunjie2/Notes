package rabbit;

public enum EnumExchangeType {

    FANOUT("fanout");

    private String exchangeTypeName;

    EnumExchangeType(String exchangeTypeName) {
        this.exchangeTypeName = exchangeTypeName;
    }

    public String getExchangeTypeName() {
        return exchangeTypeName;
    }

}
