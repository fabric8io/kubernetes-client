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
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.api.model.AuthProviderConfig;
import io.fabric8.kubernetes.api.model.NamedAuthInfo;
import io.fabric8.kubernetes.api.model.NamedAuthInfoBuilder;
import io.fabric8.kubernetes.api.model.NamedClusterBuilder;
import io.fabric8.kubernetes.api.model.NamedContextBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.http.TestStandardHttpClient;
import io.fabric8.kubernetes.client.http.TestStandardHttpClientBuilder;
import io.fabric8.kubernetes.client.http.TestStandardHttpClientFactory;
import io.fabric8.kubernetes.client.internal.KubeConfigUtils;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.X509ExtendedTrustManager;

import static io.fabric8.kubernetes.client.http.TestStandardHttpClientFactory.Mode.SINGLETON;
import static io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils.persistOAuthToken;
import static io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils.resolveOIDCTokenFromAuthConfig;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.data.MapEntry.entry;

class OpenIDConnectionUtilsBehaviorTest {

  @TempDir
  Path tempDir;
  private TestStandardHttpClientFactory httpClientFactory;
  private TestStandardHttpClientBuilder httpClientBuilder;
  private PrintStream originalSystemErrStream;
  private ByteArrayOutputStream systemErr;
  private Config originalConfig;
  private Map<String, String> authProviderConfig;

  @BeforeEach
  void setUp() throws Exception {
    httpClientFactory = new TestStandardHttpClientFactory(SINGLETON);
    httpClientBuilder = httpClientFactory.newBuilder();
    // Log capture
    originalSystemErrStream = System.err;
    systemErr = new ByteArrayOutputStream();
    System.setErr(new PrintStream(systemErr));
    // Valid self-signed certificate
    final KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
    final X509CertificateHolder cert = new JcaX509v3CertificateBuilder(
        new X500Name("o=Fabric8"), BigInteger.ONE, new Date(), new Date(new Date().getTime() + 1000L),
        new X500Name("cn=auth.fabric8.example.com"), keyPair.getPublic())
        .build(new JcaContentSignerBuilder("SHA256WithRSA").build(keyPair.getPrivate()));
    final Path validCert = tempDir.resolve("valid.crt");
    Files.write(validCert, Base64.getEncoder().encode(cert.getEncoded()));
    // Original configuration (valid)
    final Path kubeConfigFile = tempDir.resolve("kube-config");
    final io.fabric8.kubernetes.api.model.Config kubeConfig = new io.fabric8.kubernetes.api.model.ConfigBuilder()
        .addToClusters(new NamedClusterBuilder()
            .withName("default-cluster")
            .withNewCluster().withServer("https://cluster.example.com")
            .withCertificateAuthority(validCert.toFile().getAbsolutePath()).endCluster()
            .build())
        .addToUsers(new NamedAuthInfoBuilder()
            .withName("default-user")
            .withNewUser().withAuthProvider(new AuthProviderConfig()).endUser()
            .build())
        .addToContexts(new NamedContextBuilder()
            .withName("default").withNewContext().withCluster("default-cluster").withUser("default-user").endContext()
            .build())
        .withCurrentContext("default")
        .build();
    Files.write(kubeConfigFile, Serialization.asYaml(kubeConfig).getBytes(StandardCharsets.UTF_8));
    originalConfig = new ConfigBuilder(Config.empty())
        .withFile(tempDir.resolve("kube-config").toFile())
        .build()
        .refresh();
    // Auth provider configuration (minimal)
    authProviderConfig = new HashMap<>();
    authProviderConfig.put("id-token", "original-token");
    authProviderConfig.put("idp-issuer-url", "https://auth.fabric8.example.com");
    authProviderConfig.put("client-id", "id-of-test-client");
    authProviderConfig.put("client-secret", "secret-of-test-client");
  }

  @AfterEach
  void tearDown() {
    System.setErr(originalSystemErrStream);
  }

  @Test
  @DisplayName("Unsupported token refresh, resolves token from auth provider config")
  void withUnsupportedTokenRefresh() throws Exception {
    final String result = resolveOIDCTokenFromAuthConfig(originalConfig, authProviderConfig, httpClientBuilder)
        .get(10, TimeUnit.SECONDS);
    assertThat(result).isEqualTo("original-token");
  }

  @Nested
  @DisplayName("With support for token refresh")
  class WithRefreshToken {

    @BeforeEach
    void setUp() {
      authProviderConfig.put("refresh-token", "original-refresh-token");
    }

    @Test
    @DisplayName("With invalid cert data in original config, throws certificate exception")
    void withInvalidCertDataInConfig() {
      originalConfig = new ConfigBuilder(originalConfig)
          .withCaCertData(Base64.getEncoder().encodeToString(new byte[] { 48, -17, -65, -67, 3, 6 }))
          .withCaCertFile(null)
          .build();
      assertThatThrownBy(() -> resolveOIDCTokenFromAuthConfig(originalConfig, authProviderConfig, httpClientBuilder))
          .isInstanceOf(RuntimeException.class)
          .hasMessage("Could not import idp certificate")
          .cause()
          .isInstanceOf(CertificateException.class);
    }

    @Test
    @DisplayName("With invalid cert data in provided auth config, throws certificate exception")
    void withInvalidCertDataInAuthProviderConfig() {
      authProviderConfig.put("idp-certificate-authority-data",
          Base64.getEncoder().encodeToString(new byte[] { 48, -17, -65, -67, 3, 6 }));
      assertThatThrownBy(() -> resolveOIDCTokenFromAuthConfig(originalConfig, authProviderConfig, httpClientBuilder))
          .isInstanceOf(RuntimeException.class)
          .hasMessage("Could not import idp certificate")
          .cause()
          .isInstanceOf(CertificateException.class);
    }

    @Test
    @DisplayName("With invalid cert file in original config, throws certificate exception")
    void withInvalidCertFileInConfig() throws IOException {
      final Path invalidCert = tempDir.resolve("invalid.crt");
      Files.write(invalidCert, new byte[] { 48, -17, -65, -67, 3, 6 });
      originalConfig = new ConfigBuilder(originalConfig)
          .withCaCertFile(invalidCert.toFile().getAbsolutePath())
          .build();
      assertThatThrownBy(() -> resolveOIDCTokenFromAuthConfig(originalConfig, authProviderConfig, httpClientBuilder))
          .isInstanceOf(RuntimeException.class)
          .hasMessage("Could not import idp certificate")
          .cause()
          .isInstanceOf(CertificateException.class);
    }

    @Test
    @DisplayName("With missing cert file in original config, throws NPE")
    // TODO: improve handling for missing or invalid content
    void withMissingCertFileInConfig() {
      final Path missingCert = tempDir.resolve("missing.crt");
      originalConfig = new ConfigBuilder(originalConfig)
          .withCaCertFile(missingCert.toFile().getAbsolutePath())
          .build();
      assertThatThrownBy(() -> resolveOIDCTokenFromAuthConfig(originalConfig, authProviderConfig, httpClientBuilder))
          .isInstanceOf(NullPointerException.class);
    }

    @Nested
    @DisplayName("With 404 OpenID Connect Discovery response")
    class WithNotFoundOpenIDConnectDiscovery {

      private String result;

      @BeforeEach
      void setUp() throws Exception {
        httpClientFactory.expect("/.well-known/openid-configuration",
            404, "Not Found /.well-known/openid-configuration");
        result = resolveOIDCTokenFromAuthConfig(originalConfig, authProviderConfig, httpClientBuilder)
            .get(10, TimeUnit.SECONDS);
      }

      @Test
      @DisplayName("Resolves token from auth provider config (fallback)")
      void fallbacksToOriginalToken() {
        assertThat(result).isEqualTo("original-token");
      }

      @Test
      @DisplayName("Logs OpenID Connect Discovery fallback warning")
      void logsTokenFallbackWarning() {
        assertThat(systemErr.toString())
            .contains("oidc: failed to query metadata endpoint: 404 Not Found /.well-known/openid-configuration");
      }
    }

    @Nested
    @DisplayName("With malformed OpenID Connect Discovery response")
    class WithMalformedOpenIDConnectDiscoveryResponse {

      private String result;

      @BeforeEach
      void setUp() throws Exception {
        httpClientFactory.expect("/.well-known/openid-configuration",
            200, "this-is-not-json");
        result = resolveOIDCTokenFromAuthConfig(originalConfig, authProviderConfig, httpClientBuilder)
            .get(10, TimeUnit.SECONDS);
      }

      @Test
      @DisplayName("Resolves token from auth provider config (fallback)")
      void fallbacksToOriginalToken() {
        assertThat(result).isEqualTo("original-token");
      }

      @Test
      @DisplayName("Logs OpenID Connect Discovery fallback warning")
      void logsTokenFallbackWarning() {
        assertThat(systemErr.toString())
            .contains("Could not refresh OIDC token, failure in getting refresh URL")
            .contains(
                "Cannot construct instance of `io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils$OpenIdConfiguration`");
      }
    }

    @Nested
    @DisplayName("With valid OpenID Connect Discovery")
    class WithValidOpenIDConnectDiscovery {

      @BeforeEach
      void setUp() {
        httpClientFactory.expect("/.well-known/openid-configuration", 200, "{" +
            "\"issuer\": \"https://auth.fabric8.example.com\"," +
            "\"authorization_endpoint\": \"https://auth.fabric8.example.com/authorize\"," +
            "\"token_endpoint\": \"https://auth.fabric8.example.com/token\"," +
            "\"response_types_supported\": [\"code\",\"id_token\"]" +
            "}");
      }

      @Nested
      @DisplayName("With 404 token response")
      class WithNotFoundTokenResponse {

        private String result;

        @BeforeEach
        void setUp() throws Exception {
          httpClientFactory.expect("/token", 404, "Not Found /token");
          result = resolveOIDCTokenFromAuthConfig(originalConfig, authProviderConfig, httpClientBuilder)
              .get(10, TimeUnit.SECONDS);
        }

        @Test
        @DisplayName("Resolves token from auth provider config (fallback)")
        void fallbacksToOriginalToken() {
          assertThat(result).isEqualTo("original-token");
        }

        @Test
        @DisplayName("Logs refresh token response")
        void logsRefreshTokenResponse() {
          assertThat(systemErr.toString()).contains("Response: Not Found /token");
        }

        @Test
        @DisplayName("Logs token fallback warning")
        void logsTokenFallbackWarning() {
          assertThat(systemErr.toString()).contains(
              "token response did not contain an id_token, either the scope \\\"openid\\\" wasn't requested upon login, or the provider doesn't support id_tokens as part of the refresh response.");
        }
      }

      @Nested
      @DisplayName("With invalid token response body")
      class WithInvalidTokenResponseBody {

        private String result;

        @BeforeEach
        void setUp() throws Exception {
          httpClientFactory.expect("/token", 200, "Not JSON");
          result = resolveOIDCTokenFromAuthConfig(originalConfig, authProviderConfig, httpClientBuilder)
              .get(10, TimeUnit.SECONDS);
        }

        @Test
        @DisplayName("Resolves token from auth provider config (fallback)")
        void fallbacksToOriginalToken() {
          assertThat(result).isEqualTo("original-token");
        }

        @Test
        @DisplayName("Logs JSON parsing error")
        void logsJsonParsingError() {
          assertThat(systemErr.toString())
              .contains("Failure in fetching refresh token:")
              .contains("Cannot construct instance of `io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils$OAuthToken`");
        }

        @Test
        @DisplayName("Logs token fallback warning")
        void logsTokenFallbackWarning() {
          assertThat(systemErr.toString())
              .contains(
                  "token response did not contain an id_token, either the scope \\\"openid\\\" wasn't requested upon login, or the provider doesn't support id_tokens as part of the refresh response.");
        }
      }

      @Test
      @DisplayName("With valid token repsonse and missing kube config, logs warning")
      void withValidTokenResponseAndMissingKubeConfig() throws Exception {
        Files.delete(originalConfig.getFile().toPath());
        httpClientFactory.expect("/token", 200, "{" +
            "\"id_token\": \"new-token\"" +
            "}");
        final String result = resolveOIDCTokenFromAuthConfig(originalConfig, authProviderConfig, httpClientBuilder)
            .get(10, TimeUnit.SECONDS);
        assertThat(result).isEqualTo("new-token");
        assertThat(systemErr.toString())
            .contains("oidc: failure while persisting new tokens into KUBECONFIG");
      }

      @Nested
      @DisplayName("With valid token response")
      class WithValidTokenResponse {

        private String result;

        @BeforeEach
        void setUp() throws Exception {
          httpClientFactory.expect("/token", 200, "{" +
              "\"id_token\": \"new-token\"," +
              "\"refresh_token\": \"new-refresh-token\"" +
              "}");
          result = resolveOIDCTokenFromAuthConfig(originalConfig, authProviderConfig, httpClientBuilder)
              .get(10, TimeUnit.SECONDS);
        }

        @Test
        @DisplayName("Resolves token from token endpoint")
        void resolvesTokenFromTokenEndpoint() {
          assertThat(result).isEqualTo("new-token");
        }

        @Test
        @DisplayName("Updates current config auth provider config with new token")
        void updatesCurrentConfigAuthProviderConfigWithNewToken() {
          assertThat(originalConfig)
              .extracting(Config::getAuthProvider)
              .extracting(AuthProviderConfig::getConfig)
              .asInstanceOf(InstanceOfAssertFactories.map(String.class, String.class))
              .containsEntry("id-token", "new-token")
              .containsEntry("refresh-token", "new-refresh-token");
        }

        @Test
        @DisplayName("Updates current config auth provider config with new token in file")
        void updatesCurrentConfigAuthProviderConfigWithNewTokenInFile() throws Exception {
          assertThat(
              Serialization.unmarshal(new String(Files.readAllBytes(originalConfig.getFile().toPath()), StandardCharsets.UTF_8),
                  io.fabric8.kubernetes.api.model.Config.class))
              .extracting(io.fabric8.kubernetes.api.model.Config::getUsers)
              .asInstanceOf(InstanceOfAssertFactories.list(NamedAuthInfo.class))
              .singleElement()
              .extracting("user.authProvider.config")
              .asInstanceOf(InstanceOfAssertFactories.map(String.class, String.class))
              .containsEntry("id-token", "new-token")
              .containsEntry("refresh-token", "new-refresh-token");
        }

        @Test
        @DisplayName("Certificate is loaded into HttpClient trust manager")
        void certificateIsLoadedIntoHttpClientTrustManager() {
          assertThat(httpClientBuilder.getTrustManagers())
              .singleElement()
              .asInstanceOf(InstanceOfAssertFactories.type(X509ExtendedTrustManager.class))
              .extracting(X509ExtendedTrustManager::getAcceptedIssuers)
              .asInstanceOf(InstanceOfAssertFactories.array(X509Certificate[].class))
              .extracting(X509Certificate::getSubjectDN)
              .extracting(Principal::getName)
              .contains("CN=auth.fabric8.example.com");
        }

        @Test
        @DisplayName("Token refresh request contains valid auth and form data")
        void tokenRefreshRequestContainsValidFormData() {
          assertThat(httpClientBuilder.build().getRecordedConsumeBytesDirects())
              .filteredOn(r -> r.getRequest().uri().getPath().equals("/token"))
              .singleElement()
              .extracting(TestStandardHttpClient.RecordedConsumeBytesDirect::getRequest)
              .hasFieldOrPropertyWithValue("method", "POST")
              .hasFieldOrPropertyWithValue("contentType", "application/x-www-form-urlencoded")
              .hasFieldOrPropertyWithValue("bodyString",
                  "refresh_token=original-refresh-token&grant_type=refresh_token&client_id=id-of-test-client&client_secret=secret-of-test-client")
              .returns("Basic aWQtb2YtdGVzdC1jbGllbnQ6c2VjcmV0LW9mLXRlc3QtY2xpZW50", r -> r.header("Authorization"));
        }
      }
    }
  }

  @Nested
  @DisplayName("persistOAuthToken()")
  class PersistOAuthToken {

    @TempDir
    private Path tempDir;
    private File kubeConfig;
    private Config originalConfig;
    private OpenIDConnectionUtils.OAuthToken oAuthTokenResponse;

    @BeforeEach
    void setUp() {
      kubeConfig = tempDir.resolve("kubeconfig").toFile();
      originalConfig = Config.empty();
      oAuthTokenResponse = new OpenIDConnectionUtils.OAuthToken();
      oAuthTokenResponse.setIdToken("new-token");
      oAuthTokenResponse.setRefreshToken("new-refresh-token");
    }

    @Test
    void skipsInMemoryWhenNoOAuthToken() {
      persistOAuthToken(originalConfig, null, "fake.token");
      assertThat(originalConfig)
          .returns(null, Config::getAuthProvider);
    }

    @Test
    void skipsInMemoryWhenOriginalConfigHasNoAuthProvider() {
      persistOAuthToken(originalConfig, oAuthTokenResponse, "fake.token");
      assertThat(originalConfig)
          .returns(null, Config::getAuthProvider);
    }

    @Test
    void updatesInMemory() {
      originalConfig = new ConfigBuilder(originalConfig).withAuthProvider(new AuthProviderConfig()).build();
      persistOAuthToken(originalConfig, oAuthTokenResponse, "fake.token");
      assertThat(originalConfig)
          .extracting(c -> c.getAuthProvider().getConfig())
          .asInstanceOf(InstanceOfAssertFactories.map(String.class, String.class))
          .containsOnly(
              entry("id-token", "new-token"),
              entry("refresh-token", "new-refresh-token"));
    }

    @Test
    void skipsInFileWhenOriginalConfigHasNoFile() {
      persistOAuthToken(originalConfig, oAuthTokenResponse, "fake.token");
      assertThat(kubeConfig).doesNotExist();
    }

    @Test
    void skipsInFileWhenOriginalConfigHasNoCurrentContext() {
      originalConfig.setFile(kubeConfig);
      persistOAuthToken(originalConfig, oAuthTokenResponse, "fake.token");
      assertThat(kubeConfig).doesNotExist();
    }

    @Test
    void logsWarningIfReferencedFileIsMissing() {
      originalConfig.setFile(kubeConfig);
      originalConfig = new ConfigBuilder(originalConfig)
          .withCurrentContext(new NamedContextBuilder().withName("context").build()).build();
      persistOAuthToken(originalConfig, oAuthTokenResponse, "fake.token");
      assertThat(systemErr.toString())
          .contains("oidc: failure while persisting new tokens into KUBECONFIG")
          .contains("FileNotFoundException");
    }

    @Nested
    @DisplayName("With valid kube config")
    class WithValidKubeConfig {
      @BeforeEach
      void setUp() throws IOException {
        Files.write(kubeConfig.toPath(), ("---" +
            "users:\n" +
            "- name: user\n").getBytes(StandardCharsets.UTF_8));
      }

      @Test
      void persistsTokenInFile() throws IOException {
        originalConfig.setFile(kubeConfig);
        originalConfig = new ConfigBuilder(originalConfig)
            .withCurrentContext(new NamedContextBuilder()
                .withName("context")
                .withNewContext().withUser("user").endContext().build())
            .build();
        persistOAuthToken(originalConfig, oAuthTokenResponse, "fake.token");
        assertThat(KubeConfigUtils.parseConfig(kubeConfig))
            .returns("fake.token", c -> c.getUsers().iterator().next().getUser().getToken());
      }

      @Test
      void skipsTokenInFileIfNull() throws IOException {
        originalConfig.setFile(kubeConfig);
        originalConfig = new ConfigBuilder(originalConfig)
            .withCurrentContext(new NamedContextBuilder()
                .withName("context")
                .withNewContext().withUser("user").endContext().build())
            .build();
        persistOAuthToken(originalConfig, oAuthTokenResponse, null);
        assertThat(KubeConfigUtils.parseConfig(kubeConfig))
            .returns(null, c -> c.getUsers().iterator().next().getUser().getToken());
      }

      @Test
      void persistsOAuthTokenInFile() throws IOException {
        originalConfig.setFile(kubeConfig);
        originalConfig = new ConfigBuilder(originalConfig)
            .withCurrentContext(new NamedContextBuilder()
                .withName("context")
                .withNewContext().withUser("user").endContext().build())
            .build();
        persistOAuthToken(originalConfig, oAuthTokenResponse, "fake.token");
        assertThat(KubeConfigUtils.parseConfig(kubeConfig))
            .extracting(c -> c.getUsers().iterator().next().getUser().getAuthProvider().getConfig())
            .asInstanceOf(InstanceOfAssertFactories.map(String.class, String.class))
            .containsOnly(
                entry("id-token", "new-token"),
                entry("refresh-token", "new-refresh-token"));
      }
    }

  }
}
