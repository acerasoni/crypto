package aes.api;

import aes.model.AesKey;

public interface MathService {
    public byte[] subBytes(final byte[] field);

    public byte[] shiftRows(final byte[] field);

    public byte[] mixCol(final byte[] field);

    public byte[] addKey(final byte[] field, final AesKey aesKey);
}
