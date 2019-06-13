package online.simplefoodsolutions.api.utility;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1Hasher
{
    public static String sha1Hasher(String input)
    {
        String sha1 = null;
        try
        {
            MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
            msdDigest.update(input.getBytes(StandardCharsets.UTF_8), 0, input.length());
            sha1 = DatatypeConverter.printHexBinary(msdDigest.digest());
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return sha1;
    }
}
