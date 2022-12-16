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
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.BasicBuilder;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpHeaders;
import io.fabric8.kubernetes.client.http.Interceptor;
import io.fabric8.kubernetes.client.internal.SSLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;

public class HttpClientUtils {

  private static final class HeaderInterceptor implements Interceptor {
    private final Config config;

    private HeaderInterceptor(Config config) {
      this.config = config;
    }

    @Override
    public Interceptor withConfig(Config config) {
      return new HeaderInterceptor(config);
    }

    @Override
    public void before(BasicBuilder builder, HttpHeaders headers) {
      if (Utils.isNotNullOrEmpty(config.getUsername()) && Utils.isNotNullOrEmpty(config.getPassword())) {
        builder.header("Authorization", basicCredentials(config.getUsername(), config.getPassword()));
      } else if (Utils.isNotNullOrEmpty(config.getOauthToken())) {
        builder.header("Authorization", "Bearer " + config.getOauthToken());
      }
      if (config.getCustomHeaders() != null && !config.getCustomHeaders().isEmpty()) {
        for (Map.Entry<String, String> entry : config.getCustomHeaders().entrySet()) {
          builder.header(entry.getKey(), entry.getValue());
        }
      }
      if (config.getUserAgent() != null && !config.getUserAgent().isEmpty()) {
        builder.setHeader("User-Agent", config.getUserAgent());
      }
    }
  }

  private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtils.class);
  private static final String HEADER_INTERCEPTOR = "HEADER";
  private static final String KUBERNETES_BACKWARDS_COMPATIBILITY_INTERCEPTOR_DISABLE = "kubernetes.backwardsCompatibilityInterceptor.disable";
  private static final String BACKWARDS_COMPATIBILITY_DISABLE_DEFAULT = "true";
  private static final Pattern IPV4_PATTERN = Pattern.compile(
      "(http://|https://)?(?<ipAddressOrSubnet>(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])(\\/[0-9]\\d|1[0-9]\\d|2[0-9]\\d|3[0-2]\\d)?)");
  private static final Pattern INVALID_HOST_PATTERN = Pattern.compile("[^\\da-zA-Z.\\-/:]+");
  private static final AtomicBoolean MULTIPLE_HTTP_CLIENT_WARNING_LOGGED = new AtomicBoolean();

  private HttpClientUtils() {
  }

  public static URL getProxyUrl(Config config) throws MalformedURLException {
    URL master = new URL(config.getMasterUrl());
    String host = master.getHost();
    if (isHostMatchedByNoProxy(host, config.getNoProxy())) {
      return null;
    }
    String proxy = config.getHttpsProxy();
    if (master.getProtocol().equals("http")) {
      proxy = config.getHttpProxy();
    }
    if (proxy != null) {
      URL proxyUrl = new URL(proxy);
      if (proxyUrl.getPort() < 0) {
        throw new IllegalArgumentException("Failure in creating proxy URL. Proxy port is required!");
      }
      return proxyUrl;
    }
    return null;
  }

  public static Map<String, io.fabric8.kubernetes.client.http.Interceptor> createApplicableInterceptors(Config config,
      HttpClient.Factory factory) {
    Map<String, io.fabric8.kubernetes.client.http.Interceptor> interceptors = new LinkedHashMap<>();

    // Header Interceptor
    interceptors.put(HEADER_INTERCEPTOR, new HeaderInterceptor(config));
    // Impersonator Interceptor
    interceptors.put(ImpersonatorInterceptor.NAME, new ImpersonatorInterceptor(config));
    // Token Refresh Interceptor
    interceptors.put(TokenRefreshInterceptor.NAME, new TokenRefreshInterceptor(config, factory, Instant.now()));
    // Backwards Compatibility Interceptor
    String shouldDisableBackwardsCompatibilityInterceptor = Utils
        .getSystemPropertyOrEnvVar(KUBERNETES_BACKWARDS_COMPATIBILITY_INTERCEPTOR_DISABLE,
            BACKWARDS_COMPATIBILITY_DISABLE_DEFAULT);
    if (!Boolean.parseBoolean(shouldDisableBackwardsCompatibilityInterceptor)) {
      interceptors.put(BackwardsCompatibilityInterceptor.NAME, new BackwardsCompatibilityInterceptor());
    }

    return interceptors;
  }

  public static String basicCredentials(String username, String password) {
    String usernameAndPassword = username + ":" + password;
    String encoded = Base64.getEncoder().encodeToString(usernameAndPassword.getBytes(StandardCharsets.ISO_8859_1));
    return "Basic " + encoded;
  }

  /**
   * @deprecated you should not need to call this method directly. Please create your own HttpClient.Factory
   *             should you need to customize your clients.
   */
  @Deprecated
  public static HttpClient createHttpClient(Config config) {
    HttpClient.Factory factory = getHttpClientFactory();
    return factory.newBuilder(config).build();
  }

  public static HttpClient.Factory getHttpClientFactory() {
    HttpClient.Factory factory = getFactory(
        ServiceLoader.load(HttpClient.Factory.class, Thread.currentThread().getContextClassLoader()));
    if (factory == null) {
      factory = getFactory(ServiceLoader.load(HttpClient.Factory.class, HttpClientUtils.class.getClassLoader()));
      if (factory == null) {
        throw new KubernetesClientException(
            "No httpclient implementations found on the context classloader, please ensure your classpath includes an implementation jar");
      }
    }
    return factory;
  }

  private static HttpClient.Factory getFactory(ServiceLoader<HttpClient.Factory> loader) {
    HttpClient.Factory factory = null;
    for (HttpClient.Factory possible : loader) {
      if (factory != null && MULTIPLE_HTTP_CLIENT_WARNING_LOGGED.compareAndSet(false, true)) {
        LOGGER.warn("There are multiple httpclient implementation in the classpath, "
            + "choosing the first non-default implementation. "
            + "You should exclude dependencies that aren't needed or use an explicit association of the HttpClient.Factory.");
      }
      if (factory == null || (factory.isDefault() && !possible.isDefault())) {
        factory = possible;
      }
    }
    return factory;
  }

  public static void applyCommonConfiguration(Config config, HttpClient.Builder builder, HttpClient.Factory factory) {
    builder.followAllRedirects();

    if (config.getConnectionTimeout() > 0) {
      builder.connectTimeout(config.getConnectionTimeout(), TimeUnit.MILLISECONDS);
    }

    if (config.getRequestTimeout() > 0) {
      builder.readTimeout(config.getRequestTimeout(), TimeUnit.MILLISECONDS);
    }

    if (config.isHttp2Disable()) {
      builder.preferHttp11();
    }

    try {

      // Only check proxy if it's a full URL with protocol
      if (config.getMasterUrl().toLowerCase(Locale.ROOT).startsWith(Config.HTTP_PROTOCOL_PREFIX)
          || config.getMasterUrl().startsWith(Config.HTTPS_PROTOCOL_PREFIX)) {
        try {
          URL proxyUrl = HttpClientUtils.getProxyUrl(config);
          if (proxyUrl != null) {
            builder.proxyAddress(new InetSocketAddress(proxyUrl.getHost(), proxyUrl.getPort()));

            if (config.getProxyUsername() != null) {
              builder.proxyAuthorization(basicCredentials(config.getProxyUsername(), config.getProxyPassword()));
            }
          } else {
            builder.proxyAddress(null);
          }
        } catch (MalformedURLException e) {
          throw new KubernetesClientException("Invalid proxy server configuration", e);
        }
      }

      TrustManager[] trustManagers = SSLUtils.trustManagers(config);
      KeyManager[] keyManagers = SSLUtils.keyManagers(config);

      builder.sslContext(keyManagers, trustManagers);

      if (config.getTlsVersions() != null && config.getTlsVersions().length > 0) {
        builder.tlsVersions(config.getTlsVersions());
      }

    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
    HttpClientUtils.createApplicableInterceptors(config, factory).forEach(builder::addOrReplaceInterceptor);
  }

  private static boolean isHostMatchedByNoProxy(String host, String[] noProxies) throws MalformedURLException {
    for (String noProxy : noProxies == null ? new String[0] : noProxies) {
      if (INVALID_HOST_PATTERN.matcher(noProxy).find()) {
        throw new MalformedURLException("NO_PROXY URL contains invalid entry: '" + noProxy + "'");
      }
      final Optional<String> noProxyIpOrSubnet = extractIpAddressOrSubnet(noProxy);
      if (noProxyIpOrSubnet.isPresent()) {
        if (new IpAddressMatcher(noProxyIpOrSubnet.get()).matches(host)) {
          return true;
        }
      } else {
        if (host.endsWith(noProxy)) {
          return true;
        }
      }
    }
    return false;
  }

  private static Optional<String> extractIpAddressOrSubnet(String ipAddressOrSubnet) {
    final Matcher ipMatcher = IPV4_PATTERN.matcher(ipAddressOrSubnet);
    if (ipMatcher.find()) {
      return Optional.of(ipMatcher.group("ipAddressOrSubnet"));
    }
    return Optional.empty();
  }
}
