package aes.model;

import java.util.HashMap;
import java.util.Map;

public class AesKey {

    private static final Map<Integer, Integer> KEY_LENGTH_TO_ROUND = new HashMap<>();

    static {
        KEY_LENGTH_TO_ROUND.put(128, 10);
        KEY_LENGTH_TO_ROUND.put(192, 12);
        KEY_LENGTH_TO_ROUND.put(256, 14);
    }

    private final int length;

    public AesKey(final int length) {
        if (!validateLength(length)) {
            // throw new AesKeyInitializationException();
        }
        this.length = length;
    }


    public int getRounds() {
        return KEY_LENGTH_TO_ROUND.get(this.length);
    }

    private boolean validateLength(final int length) {
        return length == 128 || length == 192 || length == 256;
    }
}
