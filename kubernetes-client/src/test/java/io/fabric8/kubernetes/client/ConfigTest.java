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

import io.fabric8.kubernetes.client.utils.Serialization;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLDecoder;

import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static okhttp3.TlsVersion.TLS_1_1;
import static okhttp3.TlsVersion.TLS_1_2;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ConfigTest {

  private static final String TEST_KUBECONFIG_FILE = decodeUrl(ConfigTest.class.getResource("/test-kubeconfig").getFile());
  private static final String TEST_NAMESPACE_FILE = decodeUrl(ConfigTest.class.getResource("/test-namespace").getFile());

  private static final String TEST_CONFIG_YML_FILE = decodeUrl(ConfigTest.class.getResource("/test-config.yml").getFile());

  @Before
  public void setUp() {
    System.getProperties().remove(Config.KUBERNETES_MASTER_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_NAMESPACE_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_OAUTH_TOKEN_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_AUTH_BASIC_USERNAME_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_AUTH_BASIC_PASSWORD_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_TRUST_CERT_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY);
    System.getProperties().remove(Config.KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY);
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
  }

  @After
  public void tearDown() {
    setUp();
  }

  @Test
  public void testWithSystemProperties() {
    System.setProperty(Config.KUBERNETES_MASTER_SYSTEM_PROPERTY, "http://somehost:80");
    System.setProperty(Config.KUBERNETES_NAMESPACE_SYSTEM_PROPERTY, "testns");

    System.setProperty(Config.KUBERNETES_OAUTH_TOKEN_SYSTEM_PROPERTY, "token");
    System.setProperty(Config.KUBERNETES_AUTH_BASIC_USERNAME_SYSTEM_PROPERTY, "user");
    System.setProperty(Config.KUBERNETES_AUTH_BASIC_PASSWORD_SYSTEM_PROPERTY, "pass");
    System.setProperty(Config.KUBERNETES_TRUST_CERT_SYSTEM_PROPERTY, "true");
    System.setProperty(Config.KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY, "/path/to/cert");
    System.setProperty(Config.KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY, "cacertdata");
    System.setProperty(Config.KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY, "/path/to/clientcert");
    System.setProperty(Config.KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY, "clientcertdata");
    System.setProperty(Config.KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY, "/path/to/clientkey");
    System.setProperty(Config.KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY, "clientkeydata");
    System.setProperty(Config.KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY, "algo");
    System.setProperty(Config.KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY, "passphrase");
    System.setProperty(Config.KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY, "/path/to/clientkey");
    System.setProperty(Config.KUBERNETES_WATCH_RECONNECT_INTERVAL_SYSTEM_PROPERTY, "5000");
    System.setProperty(Config.KUBERNETES_WATCH_RECONNECT_LIMIT_SYSTEM_PROPERTY, "5");
    System.setProperty(Config.KUBERNETES_REQUEST_TIMEOUT_SYSTEM_PROPERTY, "5000");
    System.setProperty(Config.KUBERNETES_HTTP_PROXY, "httpProxy");

    System.setProperty(Config.KUBERNETES_TLS_VERSIONS, "TLSv1.2,TLSv1.1");

    System.setProperty(Config.KUBERNETES_TRUSTSTORE_FILE_PROPERTY, "/path/to/truststore");
    System.setProperty(Config.KUBERNETES_TRUSTSTORE_PASSPHRASE_PROPERTY, "truststorePassphrase");
    System.setProperty(Config.KUBERNETES_KEYSTORE_FILE_PROPERTY, "/path/to/keystore");
    System.setProperty(Config.KUBERNETES_KEYSTORE_PASSPHRASE_PROPERTY, "keystorePassphrase");

    Config config = new Config();
    assertConfig(config);

    config = new ConfigBuilder().build();
    assertConfig(config);
  }

  @Test
  public void testWithBuilder() {
    Config config = new ConfigBuilder()
      .withMasterUrl("http://somehost:80")
      .withApiVersion("v1")
      .withNamespace("testns")
      .withOauthToken("token")
      .withUsername("user")
      .withPassword("pass")
      .withTrustCerts(true)
      .withCaCertFile("/path/to/cert")
      .withCaCertData("cacertdata")
      .withClientCertFile("/path/to/clientcert")
      .withClientCertData("clientcertdata")
      .withClientKeyFile("/path/to/clientkey")
      .withClientKeyData("clientkeydata")
      .withClientKeyAlgo("algo")
      .withClientKeyPassphrase("passphrase")
      .withWatchReconnectInterval(5000)
      .withWatchReconnectLimit(5)
      .withRequestTimeout(5000)
      .withHttpProxy("httpProxy")
      .withTlsVersions(TLS_1_2, TLS_1_1)
      .withTrustStoreFile("/path/to/truststore")
      .withTrustStorePassphrase("truststorePassphrase")
      .withKeyStoreFile("/path/to/keystore")
      .withKeyStorePassphrase("keystorePassphrase")
      .build();

    assertConfig(config);
  }


  @Test
  public void testWithBuilderAndSystemProperties() {
    System.setProperty(Config.KUBERNETES_MASTER_SYSTEM_PROPERTY, "http://tobeoverriden:80");
    System.setProperty(Config.KUBERNETES_NAMESPACE_SYSTEM_PROPERTY, "tobeoverriden");

    System.setProperty(Config.KUBERNETES_OAUTH_TOKEN_SYSTEM_PROPERTY, "token");
    System.setProperty(Config.KUBERNETES_AUTH_BASIC_USERNAME_SYSTEM_PROPERTY, "user");
    System.setProperty(Config.KUBERNETES_AUTH_BASIC_PASSWORD_SYSTEM_PROPERTY, "pass");
    System.setProperty(Config.KUBERNETES_TRUST_CERT_SYSTEM_PROPERTY, "true");
    System.setProperty(Config.KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY, "/path/to/cert");
    System.setProperty(Config.KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY, "cacertdata");
    System.setProperty(Config.KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY, "/path/to/clientcert");
    System.setProperty(Config.KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY, "clientcertdata");
    System.setProperty(Config.KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY, "/path/to/clientkey");
    System.setProperty(Config.KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY, "clientkeydata");
    System.setProperty(Config.KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY, "algo");
    System.setProperty(Config.KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY, "passphrase");
    System.setProperty(Config.KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY, "/path/to/clientkey");
    System.setProperty(Config.KUBERNETES_WATCH_RECONNECT_INTERVAL_SYSTEM_PROPERTY, "5000");
    System.setProperty(Config.KUBERNETES_WATCH_RECONNECT_LIMIT_SYSTEM_PROPERTY, "5");
    System.setProperty(Config.KUBERNETES_REQUEST_TIMEOUT_SYSTEM_PROPERTY, "5000");
    System.setProperty(Config.KUBERNETES_HTTP_PROXY, "httpProxy");

    System.setProperty(Config.KUBERNETES_TLS_VERSIONS, "TLSv1.2,TLSv1.1");

    System.setProperty(Config.KUBERNETES_TRUSTSTORE_FILE_PROPERTY, "/path/to/truststore");
    System.setProperty(Config.KUBERNETES_TRUSTSTORE_PASSPHRASE_PROPERTY, "truststorePassphrase");
    System.setProperty(Config.KUBERNETES_KEYSTORE_FILE_PROPERTY, "/path/to/keystore");
    System.setProperty(Config.KUBERNETES_KEYSTORE_PASSPHRASE_PROPERTY, "keystorePassphrase");

    Config config = new ConfigBuilder()
      .withMasterUrl("http://somehost:80")
      .withNamespace("testns")
      .build();

    assertConfig(config);
  }

  private static String decodeUrl(String url) {
    try {
      return URLDecoder.decode(url, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void testWithKubeConfig() {

    System.setProperty(Config.KUBERNETES_KUBECONFIG_FILE, TEST_KUBECONFIG_FILE);
    Config config = new Config();
    assertNotNull(config);

    assertEquals("https://172.28.128.4:8443/", config.getMasterUrl());
    assertEquals("testns", config.getNamespace());
    assertEquals("token", config.getOauthToken());
    assertTrue(config.getCaCertFile().endsWith("testns/ca.pem"));
    assertTrue(new File(config.getCaCertFile()).isAbsolute());
  }

  @Test
  public void testWithKubeConfigAndSystemProperties() {
    System.setProperty(Config.KUBERNETES_KUBECONFIG_FILE, TEST_KUBECONFIG_FILE);
    System.setProperty(Config.KUBERNETES_MASTER_SYSTEM_PROPERTY, "http://somehost:80");

    Config config = new Config();
    assertNotNull(config);
    assertEquals("http://somehost:80/", config.getMasterUrl());
    assertEquals("testns", config.getNamespace());
    assertEquals("token", config.getOauthToken());
  }

  @Test
  public void testWithKubeConfigAndSytemPropertiesAndBuilder() {
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
  public void testWithNamespacePath() {
    System.setProperty(Config.KUBERNETES_KUBECONFIG_FILE, "nokubeconfigfile");
    System.setProperty(Config.KUBERNETES_NAMESPACE_FILE, TEST_NAMESPACE_FILE);
    System.setProperty(Config.KUBERNETES_MASTER_SYSTEM_PROPERTY, "http://somehost:80");

    Config config = new Config();
    assertNotNull(config);
    assertEquals("http://somehost:80/", config.getMasterUrl());
    assertEquals("testnsfrompath", config.getNamespace());
  }

  @Test
  public void testWithNonExistingNamespacePath() {
    System.setProperty(Config.KUBERNETES_KUBECONFIG_FILE, "nokubeconfigfile");
    System.setProperty(Config.KUBERNETES_NAMESPACE_FILE, "nonamespace");
    System.setProperty(Config.KUBERNETES_MASTER_SYSTEM_PROPERTY, "http://somehost:80");

    Config config = new Config();
    assertNotNull(config);
    assertEquals("http://somehost:80/", config.getMasterUrl());
    assertEquals(null, config.getNamespace());
  }

  @Test
  public void testWithNamespacePathAndSystemProperties() {
    System.setProperty(Config.KUBERNETES_NAMESPACE_FILE, TEST_NAMESPACE_FILE);
    System.setProperty(Config.KUBERNETES_MASTER_SYSTEM_PROPERTY, "http://somehost:80");
    System.setProperty(Config.KUBERNETES_NAMESPACE_SYSTEM_PROPERTY, "testns");

    Config config = new Config();
    assertNotNull(config);
    assertEquals("http://somehost:80/", config.getMasterUrl());
    assertEquals("testns", config.getNamespace());
  }

  @Test
  public void testWithNamespacePathAndSytemPropertiesAndBuilder() {
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
  public void shouldInstantiateClientUsingYaml() throws MalformedURLException {
    File configYml = new File(TEST_CONFIG_YML_FILE);
    try (InputStream is = new FileInputStream(configYml)){
      KubernetesClient client = DefaultKubernetesClient.fromConfig(is);
      Assert.assertEquals("http://some.url", client.getMasterUrl().toString());
    } catch (Exception e) {
      Assert.fail();
    }
  }

  @Test
  public void shouldInstantiateClientUsingSerializeDeserialize() throws MalformedURLException {
    DefaultKubernetesClient original = new DefaultKubernetesClient();
    String json = Serialization.asJson(original.getConfiguration());
    DefaultKubernetesClient copy = DefaultKubernetesClient.fromConfig(json);

    Assert.assertEquals(original.getConfiguration().getMasterUrl(), copy.getConfiguration().getMasterUrl());
    Assert.assertEquals(original.getConfiguration().getOauthToken(), copy.getConfiguration().getOauthToken());
    Assert.assertEquals(original.getConfiguration().getNamespace(), copy.getConfiguration().getNamespace());
    Assert.assertEquals(original.getConfiguration().getUsername(), copy.getConfiguration().getUsername());
    Assert.assertEquals(original.getConfiguration().getPassword(), copy.getConfiguration().getPassword());
  }

  @Test
  public void shouldRespectMaxRequestsPerHost() {
    Config config = new ConfigBuilder()
      .withMaxConcurrentRequestsPerHost(20)
      .build();

    KubernetesClient client = new DefaultKubernetesClient();
    assertEquals(5, client.adapt(OkHttpClient.class).dispatcher().getMaxRequestsPerHost());

    client = new DefaultKubernetesClient(config);
    assertEquals(20, client.adapt(OkHttpClient.class).dispatcher().getMaxRequestsPerHost());
  }

  private void assertConfig(Config config) {
    assertNotNull(config);
    assertTrue(config.isTrustCerts());
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

    assertArrayEquals(new TlsVersion[]{TLS_1_2, TLS_1_1}, config.getTlsVersions());

    assertEquals("/path/to/truststore", config.getTrustStoreFile());
    assertEquals("truststorePassphrase", config.getTrustStorePassphrase());
    assertEquals("/path/to/keystore", config.getKeyStoreFile());
    assertEquals("keystorePassphrase", config.getKeyStorePassphrase());
  }
}
