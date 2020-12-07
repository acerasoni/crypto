import aes.api.AesEncryptionService;
import aes.factory.AesEncryptionServiceFactory;
import aes.model.AesKey;

public class Main {

    public static void main(String... args) {
        final byte[] plain = new byte[32];
        final AesKey aesKey = new AesKey();
        System.out.println(AesEncryptionServiceFactory.getAesEncryptionService().encrypt(plain, aesKey));
    }
}
