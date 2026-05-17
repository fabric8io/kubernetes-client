/*
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubeapitest.process;

import io.fabric8.kubeapitest.KubeAPIServerConfig;
import io.fabric8.kubeapitest.KubeAPITestException;
import io.fabric8.kubeapitest.binary.BinaryManager;
import io.fabric8.kubeapitest.cert.CertManager;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.function.BooleanSupplier;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;

import static io.fabric8.kubeapitest.process.KubeAPIServerProcess.KUBE_API_SERVER;

public class ProcessReadinessChecker {

  private static final Logger logger = LoggerFactory.getLogger(ProcessReadinessChecker.class);

  public static final int POLLING_INTERVAL = 200;

  private static final char[] EMPTY_PASSWORD = new char[0];

  public void waitUntilDefaultNamespaceAvailable(int apiServerPort, BinaryManager binaryManager,
      CertManager certManager, KubeAPIServerConfig config, int timeoutMillis) {
    pollWithTimeout(() -> defaultNamespaceExists(apiServerPort, binaryManager, certManager, config),
        KUBE_API_SERVER, timeoutMillis);
  }

  private boolean defaultNamespaceExists(int apiServerPort, BinaryManager binaryManager,
      CertManager certManager, KubeAPIServerConfig config) {
    try {
      ProcessBuilder processBuilder = new ProcessBuilder(binaryManager.binaries().getKubectl().getPath(),
          "--client-certificate=" + certManager.getClientCertPath(),
          "--client-key=" + certManager.getClientKeyPath(),
          "--certificate-authority=" + certManager.getAPIServerCertPath(),
          "--server=https://127.0.0.1:" + apiServerPort,
          "--request-timeout=5s",
          "get", "ns", "default");

      // Point KUBECONFIG at a non-existent file so kubectl ignores whatever
      // kubeconfig the user (or this framework) has at $HOME/.kube/config.
      // Without this, kubectl merges the on-disk kubeconfig with the explicit
      // --client-certificate/--client-key flags and errors out with "specify
      // only one of certificate file path or data, not both" whenever the
      // kubeconfig stores cert content inline (e.g. via --embed-certs from
      // KubeConfig.updateKubeConfig — see #7804 — or the user's own setup).
      // --kubeconfig= can't be used because kubectl rejects a non-existent
      // path, but KUBECONFIG via env tolerates it.
      Map<String, String> env = processBuilder.environment();
      env.put("KUBECONFIG", config.getKubeAPITestDir() + "/.kubeconfig");

      Process process = processBuilder.start();
      return process.waitFor() == 0;
    } catch (IOException e) {
      throw new KubeAPITestException(e);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new KubeAPITestException(e);
    }
  }

  public void waitUntilReady(int port, String readyCheckPath, String processName,
      boolean useTLS, int timeoutMillis) {
    waitUntilReady(port, readyCheckPath, processName, useTLS, timeoutMillis, null);
  }

  /**
   * Same as {@link #waitUntilReady(int, String, String, boolean, int)}, but uses the supplied
   * {@link CertManager}'s client certificate to authenticate the readiness probe. Required when
   * polling {@code /readyz} on kube-apiserver: with RBAC enabled, the unauthenticated probe is
   * rejected with 403 until the post-start hook seeds the {@code system:public-info-viewer}
   * binding, a window that can easily exceed the startup timeout on contended CI runners
   * (see #7800).
   */
  public void waitUntilReady(int port, String readyCheckPath, String processName,
      boolean useTLS, int timeoutMillis, CertManager certManager) {
    HttpClient client = getHttpClient(certManager);
    HttpRequest request = getHttpRequest(useTLS, readyCheckPath, port);
    pollWithTimeout(() -> ready(client, request, processName, port), processName, timeoutMillis);
  }

  private static void pollWithTimeout(BooleanSupplier predicate, String processName,
      int timeoutMillis) {
    try {
      LocalTime startedAt = LocalTime.now();
      while (true) {
        if (predicate.getAsBoolean()) {
          return;
        }
        if (LocalTime.now().isAfter(startedAt.plus(timeoutMillis, ChronoUnit.MILLIS))) {
          throw new KubeAPITestException(processName + " did not start properly");
        }
        Thread.sleep(POLLING_INTERVAL);
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new KubeAPITestException(e);
    }
  }

  private boolean ready(HttpClient client, HttpRequest request, String processName, int port) {
    try {
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      logger.debug("Ready Response message:{} code: {} for {} on Port: {}", response.body(),
          response.statusCode(), processName,
          port);
      return response.statusCode() == 200;
      // It has been reported that in rare circumstances this call might
      // result in a javax.net.ssl.SSLException: Unrecognized SSL message
      // in that case we still want to retry, assuming this error goes away.
    } catch (ConnectException | SSLException e) {
      // still want to retry
      logger.debug("Cannot connect to the server", e);
      return false;
    } catch (IOException e) {
      throw new KubeAPITestException(e);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new KubeAPITestException(e);
    }
  }

  private HttpRequest getHttpRequest(boolean useTLS, String readyCheckPath, int port) {
    try {
      return HttpRequest.newBuilder()
          .uri(new URI((useTLS ? "https" : "http") + "://127.0.0.1:" + port + "/" + readyCheckPath))
          .GET()
          .build();
    } catch (URISyntaxException e) {
      throw new KubeAPITestException(e);
    }
  }

  private static HttpClient getHttpClient() {
    return getHttpClient(null);
  }

  private static HttpClient getHttpClient(CertManager certManager) {
    try {
      SSLContext sslContext = SSLContext.getInstance("TLS");
      KeyManager[] keyManagers = certManager != null ? loadClientKeyManagers(certManager) : null;
      sslContext.init(
          keyManagers,
          new TrustManager[] {
              new X509ExtendedTrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType,
                    Socket socket) throws CertificateException {

                }

                public X509Certificate[] getAcceptedIssuers() {
                  return null;
                }

                public void checkClientTrusted(
                    final X509Certificate[] a_certificates,
                    final String a_auth_type) {
                }

                public void checkServerTrusted(
                    final X509Certificate[] a_certificates,
                    final String a_auth_type) {
                }

                public void checkServerTrusted(
                    final X509Certificate[] a_certificates,
                    final String a_auth_type,
                    final Socket a_socket) {
                }

                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType,
                    SSLEngine engine) {

                }

                public void checkServerTrusted(
                    final X509Certificate[] a_certificates,
                    final String a_auth_type,
                    final SSLEngine a_engine) {
                }
              }
          },
          null);
      // HTTP/1.1 keeps the unauthenticated path safe under the
      // UnauthenticatedHTTP2DOSMitigation feature gate (K8s >= 1.29); retained for the
      // authenticated path for parity.
      return HttpClient.newBuilder()
          .sslContext(sslContext)
          .version(HttpClient.Version.HTTP_1_1)
          .build();
    } catch (NoSuchAlgorithmException | KeyManagementException e) {
      throw new KubeAPITestException(e);
    }
  }

  private static KeyManager[] loadClientKeyManagers(CertManager certManager) {
    try {
      X509Certificate cert;
      try (PEMParser p = new PEMParser(new FileReader(certManager.getClientCertPath(), StandardCharsets.US_ASCII))) {
        cert = new JcaX509CertificateConverter().getCertificate((X509CertificateHolder) p.readObject());
      }
      PrivateKey privateKey;
      try (PEMParser p = new PEMParser(new FileReader(certManager.getClientKeyPath(), StandardCharsets.US_ASCII))) {
        Object obj = p.readObject();
        PrivateKeyInfo keyInfo = (obj instanceof PEMKeyPair)
            ? ((PEMKeyPair) obj).getPrivateKeyInfo()
            : (PrivateKeyInfo) obj;
        privateKey = new JcaPEMKeyConverter().getPrivateKey(keyInfo);
      }
      KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
      ks.load(null, null);
      ks.setKeyEntry("client", privateKey, EMPTY_PASSWORD, new Certificate[] { cert });
      KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
      kmf.init(ks, EMPTY_PASSWORD);
      return kmf.getKeyManagers();
    } catch (IOException | KeyStoreException | NoSuchAlgorithmException
        | CertificateException | UnrecoverableKeyException e) {
      throw new KubeAPITestException(
          "Failed to load client cert/key from " + certManager.getClientCertPath()
              + " and " + certManager.getClientKeyPath(),
          e);
    }
  }
}
