package aes.factory;

import aes.api.AesEncryptionService;
import aes.service.AesEncryptionServiceImpl;

public class AesEncryptionServiceFactory {

    public static AesEncryptionService getAesEncryptionService() {
        return new AesEncryptionServiceImpl();
    }
}
