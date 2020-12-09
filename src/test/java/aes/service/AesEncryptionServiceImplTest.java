package aes.service;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AesEncryptionServiceImplTest {

    private static final byte[] EXPECTED_CHUNK = new byte[16];
    private static final byte[][] EXPECTED_STATE = new byte[4][4];

    @BeforeAll
    public static void setup() {
        for (int i = 0; i < EXPECTED_CHUNK.length; i++) {
            EXPECTED_CHUNK[i] = 0x11;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                EXPECTED_STATE[i][j] = 0x11;
            }
        }
    }

    @Test
    public void checkStateLoadsCorrectly() {
        byte[][] state = AesEncryptionServiceImpl.loadState(EXPECTED_CHUNK);
        assertArrayEquals(state, EXPECTED_STATE);
    }

    @Test
    public void checkStateUnloadsCorrectly() {
        byte[] plain = AesEncryptionServiceImpl.unloadState(EXPECTED_STATE);
        assertArrayEquals(EXPECTED_CHUNK, plain);
    }
}
