package aes.api;

import aes.model.AesKey;

public interface AesEncryptionService {

    byte[] encrypt(final byte[] plain, final AesKey aesKey);

    byte[] decrypt(final byte[] ciphertext, final AesKey aesKey);

}
