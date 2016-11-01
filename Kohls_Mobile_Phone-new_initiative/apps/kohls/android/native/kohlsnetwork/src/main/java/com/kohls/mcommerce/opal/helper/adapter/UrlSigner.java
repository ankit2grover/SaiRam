
package com.kohls.mcommerce.opal.helper.adapter;

import android.util.Base64;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class UrlSigner {

    // Note: Generally, you should store your private key someplace safe
    // and read them into your code

    private static String keyString = "4ApgHQR_Kjz-LlGCi_35fk4H1GE=";

    // This variable stores the binary key, which is computed from the string
    // (Base64) key
    private static byte[] key;

    public static String generateKey(String urltoSign) {

        try {
            // Convert the string to a URL so we can parse it
            URL url = new URL(urltoSign);

            UrlSigner signer = new UrlSigner(keyString);
            String request = signer.signRequest(url.getPath(), url.getQuery());

            return request;
        } catch (InvalidKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "";
    }

    public UrlSigner(String keyString) throws IOException {
        // Convert the key from 'web safe' base 64 to binary
        keyString = keyString.replace('-', '+');
        keyString = keyString.replace('_', '/');
        this.key = Base64.decode(keyString, Base64.DEFAULT);
    }

    public String signRequest(String path,
            String query) throws NoSuchAlgorithmException,
            InvalidKeyException,
            UnsupportedEncodingException,
            URISyntaxException {

        // Retrieve the proper URL components to sign
        String resource = path + '?' + query;

        // Get an HMAC-SHA1 signing key from the raw key bytes
        SecretKeySpec sha1Key = new SecretKeySpec(key, "HmacSHA1");

        // Get an HMAC-SHA1 Mac instance and initialize it with the HMAC-SHA1
        // key
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(sha1Key);

        // compute the binary signature for the request
        byte[] sigBytes = mac.doFinal(resource.getBytes());

        // base 64 encode the binary signature
        String signature = Base64.encodeToString(sigBytes, Base64.DEFAULT);

        // convert the signature to 'web safe' base 64
        signature = signature.replace('+', '-');
        signature = signature.replace('/', '_');

        return signature;
    }
}
