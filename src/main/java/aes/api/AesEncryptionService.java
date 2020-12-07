package aes.api;

import aes.model.AesKey;

public interface AesEncryptionService {

    public byte[] encrypt(final byte[] plain, final AesKey aesKey);

    public byte[] decrypt(final byte[] ciphertext, final AesKey aesKey);

}
