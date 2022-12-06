package Utils;

public class Env extends PropertyReader {
    private static volatile Env instance;
    private Env() {
        super("env.properties");
    }

    public static Env getInstance() {
        if (instance == null) {
            instance = new Env();
        }
        return null;
    }
}

