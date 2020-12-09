import aes.api.AesEncryptionService;
import aes.factory.AesEncryptionServiceFactory;
import aes.model.AesKey;

public class Main {

    public static void main(String... args) {
        final byte[] plain = new byte[32];
        final AesKey aesKey = new AesKey(128);

        // Split chunks
        System.out.println(AesEncryptionServiceFactory.getAesEncryptionService().encrypt(plain, aesKey));
    }
}
