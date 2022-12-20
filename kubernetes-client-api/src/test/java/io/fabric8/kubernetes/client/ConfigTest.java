/**
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

package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.ExecConfig;
import io.fabric8.kubernetes.api.model.ExecConfigBuilder;
import io.fabric8.kubernetes.client.http.TlsVersion;
import io.fabric8.kubernetes.client.lib.FileSystem;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.condition.OS.WINDOWS;

public class ConfigTest {

  private static final String TEST_KUBECONFIG_FILE = Utils.filePath(ConfigTest.class.getResource("/test-kubeconfig"));
  private static final String TEST_EC_KUBECONFIG_FILE = Utils.filePath(ConfigTest.class.getResource("/test-ec-kubeconfig"));
  private static final String TEST_NAMESPACE_FILE = Utils.filePath(ConfigTest.class.getResource("/test-namespace"));

  private static final String TEST_KUBECONFIG_EXEC_FILE = Utils.filePath(ConfigTest.class.getResource("/test-kubeconfig-exec"));
  private static final String TEST_TOKEN_GENERATOR_FILE = Utils.filePath(ConfigTest.class.getResource("/token-generator"));

  private static final String TEST_KUBECONFIG_EXEC_WIN_FILE = Utils
      .filePath(ConfigTest.class.getResource("/test-kubeconfig-exec-win"));

  private static final String TEST_KUBECONFIG_EXEC_FILE_NULL_ARGS = Utils
      .filePath(ConfigTest.class.getResource("/test-kubeconfig-exec-null-args"));
  private static final String TEST_KUBECONFIG_EXEC_FILE_WIN_NULL_ARGS = Utils
      .filePath(ConfigTest.class.getResource("/test-kubeconfig-exec-win-null-args"));

  private static final String TEST_KUBECONFIG_NO_CURRENT_CONTEXT_FILE = Utils
      .filePath(ConfigTest.class.getResource("/test-kubeconfig-nocurrentctxt.yml"));

  @BeforeEach
  public void setUp() {
    System.getProperties().remove(Config.KUBERNETES_MASTER_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_NAMESPACE_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_OAUTH_TOKEN_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_AUTH_BASIC_USERNAME_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_AUTH_BASIC_PASSWORD_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_TRUST_CERT_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_DISABLE_HOSTNAME_VERIFICATION_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_MAX_CONCURRENT_REQUESTS);
    System.getProperties().remove(Config.KUBERNETES_MAX_CONCURRENT_REQUESTS_PER_HOST);
    System.getProperties().remove(Config.KUBERNETES_WATCH_RECONNECT_INTERVAL_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_WATCH_RECONNECT_LIMIT_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_REQUEST_TIMEOUT_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_HTTP_PROXY);
    System.getProperties().remove(Config.KUBERNETES_KUBECONFIG_FILE);
    System.getProperties().remove(Config.KUBERNETES_NAMESPACE_FILE);
    System.getProperties().remove(Config.KUBERNETES_TLS_VERSIONS);
    System.getProperties().remove(Config.KUBERNETES_TRUSTSTORE_FILE_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_TRUSTSTORE_PASSPHRASE_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_KEYSTORE_FILE_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_KEYSTORE_PASSPHRASE_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_SERVICE_HOST_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_SERVICE_PORT_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_IMPERSONATE_USERNAME);
    System.getProperties().remove(Config.KUBERNETES_IMPERSONATE_GROUP);
  }

  @AfterEach
  public void tearDown() {
    setUp();
  }

  @Test
  void testWithSystemProperties() {
    System.setProperty(Config.KUBERNETES_MASTER_SYSTEM_PROPERTY, "http://somehost:80");
    System.setProperty(Config.KUBERNETES_NAMESPACE_SYSTEM_PROPERTY, "testns");

    System.setProperty(Config.KUBERNETES_OAUTH_TOKEN_SYSTEM_PROPERTY, "token");
    System.setProperty(Config.KUBERNETES_AUTH_BASIC_USERNAME_SYSTEM_PROPERTY, "user");
    System.setProperty(Config.KUBERNETES_AUTH_BASIC_PASSWORD_SYSTEM_PROPERTY, "pass");
    System.setProperty(Config.KUBERNETES_TRUST_CERT_SYSTEM_PROPERTY, "true");
    System.setProperty(Config.KUBERNETES_DISABLE_HOSTNAME_VERIFICATION_SYSTEM_PROPERTY, "true");
    System.setProperty(Config.KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY, "/path/to/cert");
    System.setProperty(Config.KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY, "cacertdata");
    System.setProperty(Config.KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY, "/path/to/clientcert");
    System.setProperty(Config.KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY, "clientcertdata");
    System.setProperty(Config.KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY, "/path/to/clientkey");
    System.setProperty(Config.KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY, "clientkeydata");
    System.setProperty(Config.KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY, "algo");
    System.setProperty(Config.KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY, "passphrase");
    System.setProperty(Config.KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY, "/path/to/clientkey");
    System.setProperty(Config.KUBERNETES_MAX_CONCURRENT_REQUESTS, "120");
    System.setProperty(Config.KUBERNETES_MAX_CONCURRENT_REQUESTS_PER_HOST, "20");
    System.setProperty(Config.KUBERNETES_WATCH_RECONNECT_INTERVAL_SYSTEM_PROPERTY, "5000");
    System.setProperty(Config.KUBERNETES_WATCH_RECONNECT_LIMIT_SYSTEM_PROPERTY, "5");
    System.setProperty(Config.KUBERNETES_REQUEST_TIMEOUT_SYSTEM_PROPERTY, "5000");
    System.setProperty(Config.KUBERNETES_HTTP_PROXY, "httpProxy");

    System.setProperty(Config.KUBERNETES_TLS_VERSIONS, "TLSv1.2,TLSv1.1");

    System.setProperty(Config.KUBERNETES_TRUSTSTORE_FILE_PROPERTY, "/path/to/truststore");
    System.setProperty(Config.KUBERNETES_TRUSTSTORE_PASSPHRASE_PROPERTY, "truststorePassphrase");
    System.setProperty(Config.KUBERNETES_KEYSTORE_FILE_PROPERTY, "/path/to/keystore");
    System.setProperty(Config.KUBERNETES_KEYSTORE_PASSPHRASE_PROPERTY, "keystorePassphrase");

    System.setProperty(Config.KUBERNETES_UPLOAD_CONNECTION_TIMEOUT_SYSTEM_PROPERTY, "60000");
    System.setProperty(Config.KUBERNETES_UPLOAD_REQUEST_TIMEOUT_SYSTEM_PROPERTY, "600000");

    Config config = new Config();
    assertConfig(config);

    config = new ConfigBuilder().build();
    assertConfig(config);
  }

  @Test
  void testWithBuilder() {
    Config config = new ConfigBuilder()
        .withMasterUrl("http://somehost:80")
        .withApiVersion("v1")
        .withNamespace("testns")
        .withOauthToken("token")
        .withUsername("user")
        .withPassword("pass")
        .withTrustCerts(true)
        .withDisableHostnameVerification(true)
        .withCaCertFile("/path/to/cert")
        .withCaCertData("cacertdata")
        .withClientCertFile("/path/to/clientcert")
        .withClientCertData("clientcertdata")
        .withClientKeyFile("/path/to/clientkey")
        .withClientKeyData("clientkeydata")
        .withClientKeyAlgo("algo")
        .withClientKeyPassphrase("passphrase")
        .withMaxConcurrentRequests(120)
        .withMaxConcurrentRequestsPerHost(20)
        .withWatchReconnectInterval(5000)
        .withWatchReconnectLimit(5)
        .withRequestTimeout(5000)
        .withUploadConnectionTimeout(60000)
        .withUploadRequestTimeout(600000)
        .withHttpProxy("httpProxy")
        .withTlsVersions(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1)
        .withTrustStoreFile("/path/to/truststore")
        .withTrustStorePassphrase("truststorePassphrase")
        .withKeyStoreFile("/path/to/keystore")
        .withKeyStorePassphrase("keystorePassphrase")
        .build();

    assertConfig(config);
  }

  @Test
  void testWithBuilderAndSystemProperties() {
    System.setProperty(Config.KUBERNETES_MASTER_SYSTEM_PROPERTY, "http://tobeoverriden:80");
    System.setProperty(Config.KUBERNETES_NAMESPACE_SYSTEM_PROPERTY, "tobeoverriden");

    System.setProperty(Config.KUBERNETES_OAUTH_TOKEN_SYSTEM_PROPERTY, "token");
    System.setProperty(Config.KUBERNETES_AUTH_BASIC_USERNAME_SYSTEM_PROPERTY, "user");
    System.setProperty(Config.KUBERNETES_AUTH_BASIC_PASSWORD_SYSTEM_PROPERTY, "pass");
    System.setProperty(Config.KUBERNETES_TRUST_CERT_SYSTEM_PROPERTY, "true");
    System.setProperty(Config.KUBERNETES_DISABLE_HOSTNAME_VERIFICATION_SYSTEM_PROPERTY, "true");
    System.setProperty(Config.KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY, "/path/to/cert");
    System.setProperty(Config.KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY, "cacertdata");
    System.setProperty(Config.KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY, "/path/to/clientcert");
    System.setProperty(Config.KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY, "clientcertdata");
    System.setProperty(Config.KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY, "/path/to/clientkey");
    System.setProperty(Config.KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY, "clientkeydata");
    System.setProperty(Config.KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY, "algo");
    System.setProperty(Config.KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY, "passphrase");
    System.setProperty(Config.KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY, "/path/to/clientkey");
    System.setProperty(Config.KUBERNETES_MAX_CONCURRENT_REQUESTS, "120");
    System.setProperty(Config.KUBERNETES_MAX_CONCURRENT_REQUESTS_PER_HOST, "20");
    System.setProperty(Config.KUBERNETES_WATCH_RECONNECT_INTERVAL_SYSTEM_PROPERTY, "5000");
    System.setProperty(Config.KUBERNETES_WATCH_RECONNECT_LIMIT_SYSTEM_PROPERTY, "5");
    System.setProperty(Config.KUBERNETES_REQUEST_TIMEOUT_SYSTEM_PROPERTY, "5000");
    System.setProperty(Config.KUBERNETES_HTTP_PROXY, "httpProxy");

    System.setProperty(Config.KUBERNETES_TLS_VERSIONS, "TLSv1.2,TLSv1.1");

    System.setProperty(Config.KUBERNETES_TRUSTSTORE_FILE_PROPERTY, "/path/to/truststore");
    System.setProperty(Config.KUBERNETES_TRUSTSTORE_PASSPHRASE_PROPERTY, "truststorePassphrase");
    System.setProperty(Config.KUBERNETES_KEYSTORE_FILE_PROPERTY, "/path/to/keystore");
    System.setProperty(Config.KUBERNETES_KEYSTORE_PASSPHRASE_PROPERTY, "keystorePassphrase");

    System.setProperty(Config.KUBERNETES_UPLOAD_CONNECTION_TIMEOUT_SYSTEM_PROPERTY, "60000");
    System.setProperty(Config.KUBERNETES_UPLOAD_REQUEST_TIMEOUT_SYSTEM_PROPERTY, "600000");

    Config config = new ConfigBuilder()
        .withMasterUrl("http://somehost:80")
        .withNamespace("testns")
        .build();

    assertConfig(config);
  }

  @Test
  void testMasterUrlWithServiceAccount() {
    System.setProperty(Config.KUBERNETES_KUBECONFIG_FILE, "/dev/null");
    System.setProperty(Config.KUBERNETES_SERVICE_HOST_PROPERTY, "10.0.0.1");
    System.setProperty(Config.KUBERNETES_SERVICE_PORT_PROPERTY, "443");
    Config config = Config.autoConfigure(null);
    assertNotNull(config);
    assertEquals("https://10.0.0.1:443/", config.getMasterUrl());
    assertEquals(null, config.getFile());
  }

  @Test
  void testAutoConfig() {
    System.setProperty(Config.KUBERNETES_KUBECONFIG_FILE, "/dev/null");
    Config config = Config.autoConfigure(null);
    assertNotNull(config);
    assertNull(config.getFile());
    assertTrue(config.getAutoConfigure());

    // ensure that refresh creates a new instance
    Config refresh = config.refresh();
    assertNotSame(config, refresh);
    assertNull(refresh.getFile());
    assertTrue(refresh.getAutoConfigure());
  }

  @Test
  void testMasterUrlWithServiceAccountIPv6() {
    System.setProperty(Config.KUBERNETES_KUBECONFIG_FILE, "/dev/null");
    System.setProperty(Config.KUBERNETES_SERVICE_HOST_PROPERTY, "2001:db8:1f70::999:de8:7648:6e8");
    System.setProperty(Config.KUBERNETES_SERVICE_PORT_PROPERTY, "443");
    Config config = Config.autoConfigure(null);
    assertNotNull(config);
    assertEquals("https://[2001:db8:1f70::999:de8:7648:6e8]:443/", config.getMasterUrl());
    assertEquals(null, config.getFile());
  }

  @Test
  void testWithKubeConfig() {
    System.setProperty(Config.KUBERNETES_KUBECONFIG_FILE, TEST_KUBECONFIG_FILE);
    Config config = new Config();
    assertNotNull(config);

    assertEquals("https://172.28.128.4:8443/", config.getMasterUrl());
    assertEquals("testns", config.getNamespace());
    assertEquals("token", config.getOauthToken());
    assertTrue(config.getCaCertFile().endsWith("testns/ca.pem".replace("/", File.separator)));
    assertTrue(new File(config.getCaCertFile()).isAbsolute());
    assertEquals(new File(TEST_KUBECONFIG_FILE), config.getFile());
  }

  @Test
  void testWithKubeConfigAndOverrideContext() {
    System.setProperty(Config.KUBERNETES_KUBECONFIG_FILE, TEST_KUBECONFIG_FILE);
    Config config = Config.autoConfigure("production/172-28-128-4:8443/root");
    assertNotNull(config);

    assertEquals("https://172.28.128.4:8443/", config.getMasterUrl());
    assertEquals("production", config.getNamespace());
    assertEquals("supertoken", config.getOauthToken());
    assertTrue(config.getCaCertFile().endsWith("testns/ca.pem".replace("/", File.separator)));
    assertTrue(new File(config.getCaCertFile()).isAbsolute());
  }

  @Test
  void testWithMultipleKubeConfigAndOverrideContext() {
    System.setProperty(Config.KUBERNETES_KUBECONFIG_FILE, TEST_KUBECONFIG_FILE + File.pathSeparator + "some-other-file");

    Config config = Config.autoConfigure("production/172-28-128-4:8443/root");
    assertNotNull(config);

    assertEquals("https://172.28.128.4:8443/", config.getMasterUrl());
    assertEquals("production", config.getNamespace());
    assertEquals("supertoken", config.getOauthToken());
    assertTrue(config.getCaCertFile().endsWith("testns/ca.pem".replace("/", File.separator)));
    assertTrue(new File(config.getCaCertFile()).isAbsolute());
  }

  @Test
  void testWithKubeConfigAndSystemProperties() {
    System.setProperty(Config.KUBERNETES_KUBECONFIG_FILE, TEST_KUBECONFIG_FILE);
    System.setProperty(Config.KUBERNETES_MASTER_SYSTEM_PROPERTY, "http://somehost:80");

    Config config = new Config();
    assertNotNull(config);
    assertEquals("http://somehost:80/", config.getMasterUrl());
    assertEquals("testns", config.getNamespace());
    assertEquals("token", config.getOauthToken());
    assertEquals(new File(TEST_KUBECONFIG_FILE), config.getFile());
  }

  @Test
  void testWithKubeConfigAndSytemPropertiesAndBuilder() {
    System.setProperty(Config.KUBERNETES_KUBECONFIG_FILE, TEST_KUBECONFIG_FILE);
    System.setProperty(Config.KUBERNETES_MASTER_SYSTEM_PROPERTY, "http://somehost:80");

    Config config = new ConfigBuilder()
        .withNamespace("testns2")
        .build();

    assertNotNull(config);
    assertEquals("http://somehost:80/", config.getMasterUrl());
    assertEquals("token", config.getOauthToken());
    assertEquals("testns2", config.getNamespace());
  }

  @Test
  void testFromKubeconfigContent() throws IOException {
    File configFile = new File(TEST_KUBECONFIG_FILE);
    final String configYAML = String.join("\n", Files.readAllLines(configFile.toPath()));
    final Config config = Config.fromKubeconfig(configYAML);
    assertEquals("https://172.28.128.4:8443/", config.getMasterUrl());

    assertFalse(config.getAutoConfigure());
    assertNull(config.getFile());
    assertSame(config, config.refresh());
  }

  @Test
  void testFromKubeconfigKeyAlgo() throws IOException {
    File configFile = new File(TEST_EC_KUBECONFIG_FILE);
    final String configYAML = String.join("\n", Files.readAllLines(configFile.toPath()));
    final Config config = Config.fromKubeconfig(configYAML);
    assertEquals("EC", config.getClientKeyAlgo());
  }

  @Test
  void testWithNamespacePath() {
    System.setProperty(Config.KUBERNETES_KUBECONFIG_FILE, "nokubeconfigfile");
    System.setProperty(Config.KUBERNETES_NAMESPACE_FILE, TEST_NAMESPACE_FILE);
    System.setProperty(Config.KUBERNETES_MASTER_SYSTEM_PROPERTY, "http://somehost:80");

    Config config = new Config();
    assertNotNull(config);
    assertEquals("http://somehost:80/", config.getMasterUrl());
    assertEquals("testnsfrompath", config.getNamespace());
  }

  @Test
  void testWithNonExistingNamespacePath() {
    System.setProperty(Config.KUBERNETES_KUBECONFIG_FILE, "nokubeconfigfile");
    System.setProperty(Config.KUBERNETES_NAMESPACE_FILE, "nonamespace");
    System.setProperty(Config.KUBERNETES_MASTER_SYSTEM_PROPERTY, "http://somehost:80");

    Config config = new Config();
    assertNotNull(config);
    assertEquals("http://somehost:80/", config.getMasterUrl());
    Assertions.assertNull(config.getNamespace());
  }

  @Test
  void testWithNamespacePathAndSystemProperties() {
    System.setProperty(Config.KUBERNETES_NAMESPACE_FILE, TEST_NAMESPACE_FILE);
    System.setProperty(Config.KUBERNETES_MASTER_SYSTEM_PROPERTY, "http://somehost:80");
    System.setProperty(Config.KUBERNETES_NAMESPACE_SYSTEM_PROPERTY, "testns");

    Config config = new Config();
    assertNotNull(config);
    assertEquals("http://somehost:80/", config.getMasterUrl());
    assertEquals("testns", config.getNamespace());
  }

  @Test
  void testWithKubeConfigAndNoContext() {
    System.setProperty(Config.KUBERNETES_KUBECONFIG_FILE, TEST_KUBECONFIG_NO_CURRENT_CONTEXT_FILE);
    Config config = new Config();
    assertNotNull(config);

    assertNull(config.getCurrentContext());
    assertEquals(3, config.getContexts().size());
    assertEquals(Config.DEFAULT_MASTER_URL + "/", config.getMasterUrl());
    assertNull(config.getNamespace());
  }

  @Test
  void testWithNamespacePathAndSytemPropertiesAndBuilder() {
    System.setProperty(Config.KUBERNETES_NAMESPACE_FILE, TEST_NAMESPACE_FILE);
    System.setProperty(Config.KUBERNETES_MASTER_SYSTEM_PROPERTY, "http://somehost:80");
    System.setProperty(Config.KUBERNETES_NAMESPACE_SYSTEM_PROPERTY, "tobeoverriden");

    Config config = new ConfigBuilder()
        .withNamespace("testns2")
        .build();

    assertNotNull(config);
    assertEquals("http://somehost:80/", config.getMasterUrl());
    assertEquals("testns2", config.getNamespace());
  }

  @Test
  void testWithCustomHeader() {
    Map<String, String> customHeaders = new HashMap<>();
    customHeaders.put("user-id", "test-user");
    customHeaders.put("cluster-id", "test-cluster");
    Config config = new ConfigBuilder()
        .withCustomHeaders(customHeaders)
        .build();

    assertNotNull(config);
    assertNotNull(config.getCustomHeaders());
    assertEquals(2, config.getCustomHeaders().size());
  }

  @Test
  void shouldSetImpersonateUsernameAndGroupFromSystemProperty() {

    System.setProperty(Config.KUBERNETES_IMPERSONATE_USERNAME, "username");
    System.setProperty(Config.KUBERNETES_IMPERSONATE_GROUP, "group");

    final Map<String, List<String>> extras = new HashMap<>();
    extras.put("c", Collections.singletonList("d"));

    final Config config = new ConfigBuilder()
        .withImpersonateUsername("a")
        .withImpersonateExtras(extras)
        .build();

    assertEquals("a", config.getImpersonateUsername());
    assertArrayEquals(new String[] { "group" }, config.getImpersonateGroups());
    assertEquals(Collections.singletonList("d"), config.getImpersonateExtras().get("c"));

  }

  @Test
  void honorClientAuthenticatorCommands() throws Exception {
    switch (FileSystem.getCurrent()) {
      case WINDOWS:
        System.setProperty(Config.KUBERNETES_KUBECONFIG_FILE, TEST_KUBECONFIG_EXEC_WIN_FILE);
        break;
      default:
        Files.setPosixFilePermissions(Paths.get(TEST_TOKEN_GENERATOR_FILE), PosixFilePermissions.fromString("rwxrwxr-x"));
        System.setProperty(Config.KUBERNETES_KUBECONFIG_FILE, TEST_KUBECONFIG_EXEC_FILE);
    }

    Config config = Config.autoConfigure(null);
    assertNotNull(config);
    assertEquals("HELLO WORLD", config.getOauthToken());
  }

  @Test
  void should_accept_client_authentication_commands_with_null_args() throws Exception {
    try {
      if (FileSystem.getCurrent() == FileSystem.WINDOWS) {
        System.setProperty(Config.KUBERNETES_KUBECONFIG_FILE, TEST_KUBECONFIG_EXEC_FILE_WIN_NULL_ARGS);
      } else {
        Files.setPosixFilePermissions(Paths.get(TEST_TOKEN_GENERATOR_FILE), PosixFilePermissions.fromString("rwxrwxr-x"));
        System.setProperty(Config.KUBERNETES_KUBECONFIG_FILE, TEST_KUBECONFIG_EXEC_FILE_NULL_ARGS);
      }

      Config config = Config.autoConfigure(null);
      assertNotNull(config);
      assertEquals("HELLO", config.getOauthToken());
    } finally {
      System.clearProperty(Config.KUBERNETES_KUBECONFIG_FILE);
    }
  }

  @Test
  void shouldBeUsedTokenSuppliedByProvider() {

    Config config = new ConfigBuilder().withOauthToken("oauthToken")
        .withOauthTokenProvider(() -> "PROVIDER_TOKEN")
        .build();

    assertEquals("PROVIDER_TOKEN", config.getOauthToken());
  }

  @Test
  void shouldHonorDefaultWebsocketPingInterval() {
    Config config = new ConfigBuilder().build();

    assertEquals(30000L, config.getWebsocketPingInterval());
  }

  @Test
  void testKubeConfigWithAuthConfigProvider() throws URISyntaxException {
    System.setProperty("kubeconfig", new File(getClass().getResource("/test-kubeconfig").toURI()).getAbsolutePath());
    Config config = Config.autoConfigure("production/172-28-128-4:8443/mmosley");

    assertEquals("https://172.28.128.4:8443/", config.getMasterUrl());
    assertEquals(
        "eyJraWQiOiJDTj1vaWRjaWRwLnRyZW1vbG8ubGFuLCBPVT1EZW1vLCBPPVRybWVvbG8gU2VjdXJpdHksIEw9QXJsaW5ndG9uLCBTVD1WaXJnaW5pYSwgQz1VUy1DTj1rdWJlLWNhLTEyMDIxNDc5MjEwMzYwNzMyMTUyIiwiYWxnIjoiUlMyNTYifQ.eyJpc3MiOiJodHRwczovL29pZGNpZHAudHJlbW9sby5sYW46ODQ0My9hdXRoL2lkcC9PaWRjSWRQIiwiYXVkIjoia3ViZXJuZXRlcyIsImV4cCI6MTQ4MzU0OTUxMSwianRpIjoiMm96US15TXdFcHV4WDlHZUhQdy1hZyIsImlhdCI6MTQ4MzU0OTQ1MSwibmJmIjoxNDgzNTQ5MzMxLCJzdWIiOiI0YWViMzdiYS1iNjQ1LTQ4ZmQtYWIzMC0xYTAxZWU0MWUyMTgifQ.w6p4J_6qQ1HzTG9nrEOrubxIMb9K5hzcMPxc9IxPx2K4xO9l-oFiUw93daH3m5pluP6K7eOE6txBuRVfEcpJSwlelsOsW8gb8VJcnzMS9EnZpeA0tW_p-mnkFc3VcfyXuhe5R3G7aa5d8uHv70yJ9Y3-UhjiN9EhpMdfPAoEB9fYKKkJRzF7utTTIPGrSaSU6d2pcpfYKaxIwePzEkT4DfcQthoZdy9ucNvvLoi1DIC-UocFD8HLs8LYKEqSxQvOcvnThbObJ9af71EwmuE21fO5KzMW20KtAeget1gnldOosPtz1G5EwvaQ401-RPQzPGMVBld0_zMCAwZttJ4knw",
        config.getOauthToken());
  }

  @Test
  void testEmptyConfig() {
    // Given
    Config emptyConfig = null;

    // When
    emptyConfig = Config.empty();

    // Then
    assertNotNull(emptyConfig);
    assertEquals("https://kubernetes.default.svc", emptyConfig.getMasterUrl());
    assertTrue(emptyConfig.getContexts().isEmpty());
    assertNull(emptyConfig.getCurrentContext());
    assertEquals(64, emptyConfig.getMaxConcurrentRequests());
    assertEquals(5, emptyConfig.getMaxConcurrentRequestsPerHost());
    assertFalse(emptyConfig.isTrustCerts());
    assertFalse(emptyConfig.isDisableHostnameVerification());
    assertEquals("RSA", emptyConfig.getClientKeyAlgo());
    assertEquals("changeit", emptyConfig.getClientKeyPassphrase());
    assertEquals(1000, emptyConfig.getWatchReconnectInterval());
    assertEquals(-1, emptyConfig.getWatchReconnectLimit());
    assertEquals(10000, emptyConfig.getConnectionTimeout());
    assertEquals(10000, emptyConfig.getRequestTimeout());
    assertEquals(900000, emptyConfig.getRollingTimeout());
    assertEquals(600000, emptyConfig.getScaleTimeout());
    assertEquals(20000, emptyConfig.getLoggingInterval());
    assertEquals(5000, emptyConfig.getWebsocketTimeout());
    assertEquals(30000, emptyConfig.getWebsocketPingInterval());
    assertEquals(10000, emptyConfig.getUploadConnectionTimeout());
    assertEquals(120000, emptyConfig.getUploadRequestTimeout());
    assertTrue(emptyConfig.getImpersonateExtras().isEmpty());
    assertEquals(0, emptyConfig.getImpersonateGroups().length);
    assertFalse(emptyConfig.isHttp2Disable());
    assertEquals(1, emptyConfig.getTlsVersions().length);
    assertTrue(emptyConfig.getErrorMessages().isEmpty());
    assertNotNull(emptyConfig.getUserAgent());
  }

  private void assertConfig(Config config) {
    assertNotNull(config);
    assertTrue(config.isTrustCerts());
    assertTrue(config.isDisableHostnameVerification());
    assertEquals("http://somehost:80/", config.getMasterUrl());
    assertEquals("testns", config.getNamespace());
    assertEquals("token", config.getOauthToken());
    assertEquals("user", config.getUsername());
    assertEquals("pass", config.getPassword());
    assertEquals("/path/to/cert", config.getCaCertFile());
    assertEquals("cacertdata", config.getCaCertData());
    assertEquals("/path/to/clientcert", config.getClientCertFile());
    assertEquals("clientcertdata", config.getClientCertData());

    assertEquals("/path/to/clientkey", config.getClientKeyFile());
    assertEquals("clientkeydata", config.getClientKeyData());
    assertEquals("algo", config.getClientKeyAlgo());
    assertEquals("passphrase", config.getClientKeyPassphrase());

    assertEquals("httpProxy", config.getHttpProxy());

    assertEquals(5000, config.getWatchReconnectInterval());
    assertEquals(5, config.getWatchReconnectLimit());
    assertEquals(5000, config.getRequestTimeout());
    assertEquals(60000, config.getRequestConfig().getUploadConnectionTimeout());
    assertEquals(600000, config.getRequestConfig().getUploadRequestTimeout());

    assertArrayEquals(new TlsVersion[] { TlsVersion.TLS_1_2, TlsVersion.TLS_1_1 }, config.getTlsVersions());

    assertEquals("/path/to/truststore", config.getTrustStoreFile());
    assertEquals("truststorePassphrase", config.getTrustStorePassphrase());
    assertEquals("/path/to/keystore", config.getKeyStoreFile());
    assertEquals("keystorePassphrase", config.getKeyStorePassphrase());

    assertEquals(120, config.getMaxConcurrentRequests());
    assertEquals(20, config.getMaxConcurrentRequestsPerHost());
  }

  @Test
  void testGetAuthenticatorCommandFromExecConfig() throws IOException {
    // Given
    File commandFolder = Files.createTempDirectory("test").toFile();
    File commandFile = new File(commandFolder, "aws");
    boolean isNewFileCreated = commandFile.createNewFile();
    String systemPathValue = getTestPathValue(commandFolder);
    ExecConfig execConfig = new ExecConfigBuilder()
        .withApiVersion("client.authentication.k8s.io/v1alpha1")
        .addToArgs("--region", "us-west2", "eks", "get-token", "--cluster-name", "api-eks.example.com")
        .withCommand("aws")
        .build();

    // When
    List<String> processBuilderArgs = Config.getAuthenticatorCommandFromExecConfig(execConfig, new File("~/.kube/config"),
        systemPathValue);

    // Then
    assertTrue(isNewFileCreated);
    assertNotNull(processBuilderArgs);
    assertEquals(3, processBuilderArgs.size());
    assertPlatformPrefixes(processBuilderArgs);
    List<String> commandParts = Arrays.asList(processBuilderArgs.get(2).split(" "));
    assertEquals(commandFile.getAbsolutePath(), commandParts.get(0));
    assertEquals("--region", commandParts.get(1));
    assertEquals("us-west2", commandParts.get(2));
    assertEquals("eks", commandParts.get(3));
    assertEquals("get-token", commandParts.get(4));
    assertEquals("--cluster-name", commandParts.get(5));
    assertEquals("api-eks.example.com", commandParts.get(6));
  }

  @Test
  void testGetAuthenticatorCommandFromExecConfigNullArgs() throws IOException {
    // Given
    File commandFolder = Files.createTempDirectory("test").toFile();
    File commandFile = new File(commandFolder, "gke-gcloud-auth-plugin");
    String systemPathValue = getTestPathValue(commandFolder);
    ExecConfig execConfigNoArgs = new ExecConfigBuilder()
        .withApiVersion("client.authentication.k8s.io/v1alpha1")
        .withCommand(commandFile.getPath())
        .build();
    // Simulate "user.exec.args: null" like e.g. in the configuration for the gke-gcloud-auth-plugin.
    execConfigNoArgs.setArgs(null);

    // When
    List<String> processBuilderArgs = Config.getAuthenticatorCommandFromExecConfig(
        execConfigNoArgs, null, systemPathValue);

    // Then
    assertNotNull(processBuilderArgs);
    assertEquals(3, processBuilderArgs.size());
    assertPlatformPrefixes(processBuilderArgs);
    assertEquals(commandFile.getPath(), processBuilderArgs.get(2));
  }

  private void assertPlatformPrefixes(List<String> processBuilderArgs) {
    List<String> platformArgsExpected = Utils.getCommandPlatformPrefix();
    assertEquals(platformArgsExpected.get(0), processBuilderArgs.get(0));
    assertEquals(platformArgsExpected.get(1), processBuilderArgs.get(1));
  }

  private String getTestPathValue(File commandFolder) {
    if (Utils.isWindowsOperatingSystem()) {
      return "C:\\Program Files\\Java\\jdk14.0_23\\bin" + File.pathSeparator +
          commandFolder.getAbsolutePath() + File.pathSeparator +
          "C:\\Program Files\\Apache Software Foundation\\apache-maven-3.3.1";
    } else {
      return "/usr/java/jdk-14.0.1/bin" + File.pathSeparator +
          commandFolder.getAbsolutePath() + File.pathSeparator +
          "/opt/apache-maven/bin";
    }
  }

  @Test
  void getHomeDir_shouldUseHomedriveHomepathOnWindows_WhenHomeEnvVariableIsNotSet() {
    String osNamePropToRestore = System.getProperty("os.name");
    try {

      System.setProperty("os.name", "Windows");

      Map<String, String> envVars = new HashMap<String, String>();
      envVars.put("HOMEDRIVE", "C:\\Users\\");
      envVars.put("HOMEPATH", "user");
      envVars.put("USERPROFILE", "C:\\Users\\user\\workspace\\myworkspace\\tools\\cygwin\\");

      assertEquals("C:\\Users\\user", Config.getHomeDir(f -> true, envVars::get));

    } finally {
      System.setProperty("os.name", osNamePropToRestore);
    }
  }

  @Test
  void getHomeDir_shouldUseUserprofileOnWindows_WhenHomeHomedriveHomepathEnvVariablesAreNotSet() {
    String osNamePropToRestore = System.getProperty("os.name");
    try {

      System.setProperty("os.name", "Windows");

      Map<String, String> envVars = new HashMap<String, String>();
      envVars.put("USERPROFILE", "C:\\Users\\user\\workspace\\myworkspace\\tools\\cygwin\\");

      assertEquals("C:\\Users\\user\\workspace\\myworkspace\\tools\\cygwin\\",
          Config.getHomeDir(f -> true, envVars::get));

    } finally {
      System.setProperty("os.name", osNamePropToRestore);
    }
  }

  @Test
  void getHomeDir_shouldUseHomeEnvVariableOnWindows_WhenHomeEnvVariableIsSet() {
    String osNamePropToRestore = System.getProperty("os.name");
    try {

      System.setProperty("os.name", "Windows");

      Map<String, String> envVars = new HashMap<String, String>();
      envVars.put("HOMEDRIVE", "C:\\Users\\");
      envVars.put("HOMEPATH", "user");
      envVars.put("HOME", "C:\\Users\\user\\workspace\\myworkspace\\tools\\cygwin\\");

      assertEquals("C:\\Users\\user\\workspace\\myworkspace\\tools\\cygwin\\",
          Config.getHomeDir(f -> true, envVars::get));

    } finally {
      System.setProperty("os.name", osNamePropToRestore);
    }
  }

  @Test
  @EnabledOnOs({ WINDOWS })
  void getHomeDir_shouldUseHomeEnvVariable_WhenEnabledOnWindows_WhenHomeEnvVariableIsSet() {

    Map<String, String> envVars = new HashMap<String, String>();
    envVars.put("HOMEDRIVE", "C:\\Users\\");
    envVars.put("HOMEPATH", "user");
    envVars.put("HOME", "C:\\Users\\user\\workspace\\myworkspace\\tools\\cygwin\\");

    assertEquals("C:\\Users\\user\\workspace\\myworkspace\\tools\\cygwin\\",
        Config.getHomeDir(f -> true, envVars::get));

  }

  @Test
  void getHomeDir_shouldReturnUserHomeProp_WhenHomeEnvVariablesAreNotSet() {
    String userHomePropToRestore = System.getProperty("user.home");
    try {

      System.setProperty("user.home", "/home/user");

      Map<String, String> emptyEnvVars = Collections.emptyMap();

      assertEquals("/home/user", Config.getHomeDir(f -> true, emptyEnvVars::get));

    } finally {
      System.setProperty("user.home", userHomePropToRestore);
    }
  }
}
