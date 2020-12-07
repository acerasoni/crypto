package aes.service;

import aes.api.AesEncryptionService;
import aes.model.AesKey;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Assumptions: input is a factor of 128 bits
 */
public class AesEncryptionServiceImpl<T> implements AesEncryptionService {

    private final byte[][] state = new byte[4][4];
    private List<byte[]> blocks;

            /*
            1. Split input into 128 bit chunks
            2. Write to state
            3. Read from state
             */

    public byte[] encrypt(final byte[] plain, final AesKey aesKey) {
        blocks = castFromGenericListToByteList(splitArray(castFromByteArrayToGenericArray(plain), 16));

        return (byte[]) ((Object) mergeArrays(castFromByteListToGenericList(blocks)));
    }

    @Override
    public byte[] decrypt(byte[] ciphertext, AesKey aesKey) {
        return new byte[0];
    }

    private T[] castFromByteArrayToGenericArray(final byte[] plain) {
        return (T[]) Array.newInstance(plain);
    }

    private List<byte[]> castFromGenericListToByteList(final List<T[]> plain) {
        return (List<byte[]>) ((Object) plain);
    }

    private List<T[]> castFromByteListToGenericList(final List<byte[]> plain) {
        return (List<T[]>) ((Object) plain);
    }

    private List<T[]> splitArray(final T[] input, final int chunkSize) {
        final List<T[]> blocks = new ArrayList<>();
        final int size = input.length % chunkSize;
        for (int i = 0; i < size; i++) {
            blocks.add(Arrays.copyOfRange(input, i * chunkSize, i * chunkSize + chunkSize));
        }
        return blocks;
    }

    private T[] mergeArrays(final List<T[]> input) {
        T[] mergeTarget = null;
        for (T[] array : input) {
            mergeTarget = (T[]) ArrayUtils.add(mergeTarget, array);
        }

        return mergeTarget;
    }

}
