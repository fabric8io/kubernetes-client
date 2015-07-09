package io.fabric8.kubernetes;

import com.ning.http.util.Base64;
import net.oauth.signature.pem.PEMReader;
import net.oauth.signature.pem.PKCS1EncodedKeySpec;

import java.io.*;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAPrivateCrtKeySpec;

public class Utils {

    public static String getSystemPropertyOrEnvVar(String systemPropertyName, String envVarName, String defaultValue) {
        String answer = System.getProperty(systemPropertyName);
        if (answer != null) {
            return answer;
        }

        answer = System.getenv(envVarName);
        if (answer != null) {
            return answer;
        }

        return defaultValue;
    }

    public static String convertSystemPropertyNameToEnvVar(String systemPropertyName) {
        return systemPropertyName.toUpperCase().replace("[.-]", "_");
    }

    public static String getSystemPropertyOrEnvVar(String systemPropertyName, String defaultValue) {
        return getSystemPropertyOrEnvVar(systemPropertyName, convertSystemPropertyNameToEnvVar(systemPropertyName), defaultValue);
    }

    public static String getSystemPropertyOrEnvVar(String systemPropertyName) {
        return getSystemPropertyOrEnvVar(systemPropertyName, (String) null);
    }

    public static Number getSystemPropertyOrEnvVar(String systemPropertyName, Number defaultValue) {
        String result = getSystemPropertyOrEnvVar(systemPropertyName, defaultValue.toString());
        return Integer.parseInt(result);
    }

    public static Boolean getSystemPropertyOrEnvVar(String systemPropertyName, Boolean defaultValue) {
        String result = getSystemPropertyOrEnvVar(systemPropertyName, defaultValue.toString());
        return Boolean.parseBoolean(result);
    }

    public static InputStream getInputStreamFromDataOrFile(String data, String file) throws FileNotFoundException {
        if (data != null) {
            return new ByteArrayInputStream(Base64.decode(data));
        }
        if (file != null) {
            return new FileInputStream(file);
        }
        return null;
    }

    public static KeyStore createTrustStore(String caCertData, String caCertFile) throws Exception {
        try (InputStream pemInputStream = getInputStreamFromDataOrFile(caCertData, caCertFile)) {
            CertificateFactory certFactory = CertificateFactory.getInstance("X509");
            X509Certificate cert = (X509Certificate) certFactory.generateCertificate(pemInputStream);

            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(null);

            String alias = cert.getSubjectX500Principal().getName();
            trustStore.setCertificateEntry(alias, cert);

            return trustStore;
        }
    }

    public static KeyStore createKeyStore(String clientCertData, String clientCertFile, String clientKeyData, String clientKeyFile, String clientKeyAlgo, char[] clientKeyPassphrase) throws Exception {
        try (InputStream certInputStream = getInputStreamFromDataOrFile(clientCertData, clientCertFile)) {
            CertificateFactory certFactory = CertificateFactory.getInstance("X509");
            X509Certificate cert = (X509Certificate) certFactory.generateCertificate(certInputStream);

            InputStream keyInputStream = getInputStreamFromDataOrFile(clientKeyData, clientKeyFile);
            PEMReader reader = new PEMReader(keyInputStream);
            RSAPrivateCrtKeySpec keySpec = new PKCS1EncodedKeySpec(reader.getDerBytes()).getKeySpec();
            KeyFactory kf = KeyFactory.getInstance(clientKeyAlgo);
            RSAPrivateKey privKey = (RSAPrivateKey) kf.generatePrivate(keySpec);

            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(null, clientKeyPassphrase);

            String alias = cert.getSubjectX500Principal().getName();
            keyStore.setKeyEntry(alias, privKey, clientKeyPassphrase, new Certificate[]{cert});

            return keyStore;
        }
    }

}
