package aes.service;

import aes.api.AesEncryptionService;
import aes.model.AesKey;

import java.util.Objects;

public class AesEncryptionServiceImpl implements AesEncryptionService {

    /**
     * The encrypt method receives 128-bit chunks of data and encrypts them with the secret key
     *
     * @param plain
     * @param aesKey
     * @return encrypted byte[] chunk
     */
    @Override
    public byte[] encrypt(final byte[] plain, final AesKey aesKey) {
        Objects.requireNonNull(plain);
        Objects.requireNonNull(aesKey);

        if (!isCorrectChunkSize(plain)) {
            // throw new AesEncryptionServiceException;
        }

        byte[][] state = loadState(plain);

        addRoundKey(state, aesKey);
        for (int i = 0; i < aesKey.getRounds() - 1; i++) {
            subBytes(state);
            shiftRows(state);
            mixColumns(state);
            addRoundKey(state, aesKey);
        }

        subBytes(state);
        shiftRows(state);
        addRoundKey(state, aesKey);

        return unloadState(state);
    }

    @Override
    public byte[] decrypt(byte[] ciphertext, AesKey aesKey) {
        return new byte[0];
    }

    private void subBytes(final byte[][] state) {
        //TODO
    }

    private void shiftRows(final byte[][] state) {
        //TODO
    }

    private void mixColumns(final byte[][] state) {
        //TODO
    }

    private void addRoundKey(final byte[][] state, final AesKey aesKey) {
        //TODO
    }

    public static byte[] unloadState(final byte[][] state) {
        byte[] plain = new byte[16];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int offset = i * 4;
                plain[offset + j] = state[i][j];
            }
        }

        return plain;
    }

    public static byte[][] loadState(final byte[] input) {
        byte[][] state = new byte[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int offset = i + j;
                state[i][j] = input[offset];
            }
        }

        return state;
    }

    private boolean isCorrectChunkSize(byte[] plain) {
        return plain.length == 16;
    }

}
