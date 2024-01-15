package io.fabric8.kubeapitest.process;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.function.BooleanSupplier;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.fabric8.kubeapitest.KubeAPITestException;
import io.fabric8.kubeapitest.KubeAPIServerConfig;
import io.fabric8.kubeapitest.binary.BinaryManager;
import io.fabric8.kubeapitest.cert.CertManager;

import static io.fabric8.kubeapitest.process.KubeAPIServerProcess.KUBE_API_SERVER;

public class ProcessReadinessChecker {

  private static final Logger log = LoggerFactory.getLogger(ProcessReadinessChecker.class);

  public static final int POLLING_INTERVAL = 200;

  public void waitUntilDefaultNamespaceAvailable(int apiServerPort, BinaryManager binaryManager,
      CertManager certManager, KubeAPIServerConfig config, int timeoutMillis) {
    pollWithTimeout(() -> defaultNamespaceExists(apiServerPort, binaryManager, certManager, config),
        KUBE_API_SERVER, timeoutMillis);
  }

  private boolean defaultNamespaceExists(int apiServerPort, BinaryManager binaryManager,
      CertManager certManager, KubeAPIServerConfig config) {
    try {
      ProcessBuilder processBuilder =
          new ProcessBuilder(binaryManager.binaries().getKubectl().getPath(),
              "--client-certificate=" + certManager.getClientCertPath(),
              "--client-key=" + certManager.getClientKeyPath(),
              "--certificate-authority=" + certManager.getAPIServerCertPath(),
              "--server=https://127.0.0.1:" + apiServerPort,
              "--request-timeout=5s",
              "get", "ns", "default");

      if (!config.isUpdateKubeConfig()) {
        // When the default kubeconfig file contains default context using client-certificate-data
        // or client-key-data, kubectl will fail because it will not know which one to use and the
        // readiness check will never pass. To avoid that, we set the KUBECONFIG environment
        // variable to an non-existent kubeconfig file. This cannot be done using the --kubeconfig
        // option to kubectl, because kubectl will complain if such file does not exist, but when
        // set through KUBECONFIG env. variable, it does not complain.
        Map<String, String> env = processBuilder.environment();
        env.put("KUBECONFIG", config.getJenvtestDir() + "/.kubeconfig");
      }

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
    HttpClient client = getHttpClient();
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
      log.debug("Ready Response message:{} code: {} for {} on Port: {}", response.body(),
          response.statusCode(), processName,
          port);
      return response.statusCode() == 200;
    } catch (ConnectException e) {
      // still want to retry
      log.debug("Cannot connect to the server", e);
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
    try {
      SSLContext sslContext = SSLContext.getInstance("TLS");
      sslContext.init(
          null,
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
                    final String a_auth_type) {}

                public void checkServerTrusted(
                    final X509Certificate[] a_certificates,
                    final String a_auth_type) {}


                public void checkServerTrusted(
                    final X509Certificate[] a_certificates,
                    final String a_auth_type,
                    final Socket a_socket) {}

                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType,
                    SSLEngine engine) {

                }

                public void checkServerTrusted(
                    final X509Certificate[] a_certificates,
                    final String a_auth_type,
                    final SSLEngine a_engine) {}
              }
          },
          null);
      return HttpClient.newBuilder()
          .sslContext(sslContext)
          .build();
    } catch (NoSuchAlgorithmException | KeyManagementException e) {
      throw new KubeAPITestException(e);
    }
  }
}
