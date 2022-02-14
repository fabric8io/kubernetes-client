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

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class HttpClientUtils {

  private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtils.class);

  public static final String HEADER_INTERCEPTOR = "HEADER";

  private HttpClientUtils() { }

  private static Pattern VALID_IPV4_PATTERN = null;
  public static final String ipv4Pattern = "(http:\\/\\/|https:\\/\\/)?(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])(\\/[0-9]\\d|1[0-9]\\d|2[0-9]\\d|3[0-2]\\d)?";
  protected static final String KUBERNETES_BACKWARDS_COMPATIBILITY_INTERCEPTOR_DISABLE = "kubernetes.backwardsCompatibilityInterceptor.disable";

  static {
    try {
      VALID_IPV4_PATTERN = Pattern.compile(ipv4Pattern, Pattern.CASE_INSENSITIVE);
    } catch (PatternSyntaxException e) {
      throw KubernetesClientException.launderThrowable("Unable to compile ipv4address pattern.", e);
    }
  }

    public static URL getProxyUrl(Config config) throws MalformedURLException {
        URL master = new URL(config.getMasterUrl());
        String host = master.getHost();
        if (config.getNoProxy() != null) {
	        for (String noProxy : config.getNoProxy()) {
            if (isIpAddress(noProxy)) {
              if (new IpAddressMatcher(noProxy).matches(host)) {
                return null;
              }
            } else {
              if (host.contains(noProxy)) {
                return null;
              }
            }
	        }
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

    private static boolean isIpAddress(String ipAddress) {
        Matcher ipMatcher = VALID_IPV4_PATTERN.matcher(ipAddress);
        return ipMatcher.matches();
    }

  public static Map<String, io.fabric8.kubernetes.client.http.Interceptor> createApplicableInterceptors(Config config, HttpClient.Factory factory) {
    Map<String, io.fabric8.kubernetes.client.http.Interceptor> interceptors = new LinkedHashMap<>();

    // Header Interceptor
    interceptors.put(HEADER_INTERCEPTOR, new Interceptor() {

      @Override
      public void before(BasicBuilder builder, HttpHeaders headers) {
        if (Utils.isNotNullOrEmpty(config.getUsername()) && Utils.isNotNullOrEmpty(config.getPassword())) {
          builder.header("Authorization", basicCredentials(config.getUsername(), config.getPassword()));
        } else if (Utils.isNotNullOrEmpty(config.getOauthToken())) {
          builder.header("Authorization", "Bearer " + config.getOauthToken());
        }
        if (config.getCustomHeaders() != null && !config.getCustomHeaders().isEmpty()) {
          for (Map.Entry<String, String> entry : config.getCustomHeaders().entrySet()) {
            builder.header(entry.getKey(),entry.getValue());
          }
        }
        if (config.getUserAgent() != null && !config.getUserAgent().isEmpty()) {
          builder.setHeader("User-Agent", config.getUserAgent());
        }
      }
    });
    // Impersonator Interceptor
    interceptors.put(ImpersonatorInterceptor.NAME, new ImpersonatorInterceptor(config));
    // Token Refresh Interceptor
    interceptors.put(TokenRefreshInterceptor.NAME, new TokenRefreshInterceptor(config, factory));
    // Backwards Compatibility Interceptor
    String shouldDisableBackwardsCompatibilityInterceptor = Utils.getSystemPropertyOrEnvVar(KUBERNETES_BACKWARDS_COMPATIBILITY_INTERCEPTOR_DISABLE, "false");
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

  private static final AtomicBoolean WARNED = new AtomicBoolean();

  public static HttpClient createHttpClient(Config config) {
    ServiceLoader<HttpClient.Factory> loader = ServiceLoader.load(HttpClient.Factory.class);
    HttpClient.Factory factory = null;
    for (Iterator<HttpClient.Factory> iter = loader.iterator(); iter.hasNext();) {
      HttpClient.Factory possible = iter.next();
      if (factory != null && WARNED.compareAndSet(false, true)) {
        LOGGER.warn("There are multiple httpclient implementation in the classpath, "
            + "choosing the first non-okhttp implementation. "
            + "You should exclude dependencies that aren't needed or use an explicit association of the HttpClient.Factory.");
      }
      if (factory == null || !possible.getClass().getName().equals("io.fabric8.kubernetes.client.okhttp.OkHttpClientFactory")) {
        factory = possible;
      }
    }
    if (factory == null) {
      throw new KubernetesClientException("No httpclient implementations found on the context classloader, please ensure your classpath includes an implementation jar");
    }
    return factory.createHttpClient(config);
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

      SSLContext sslContext = SSLUtils.sslContext(keyManagers, trustManagers);
      builder.sslContext(sslContext, trustManagers);

      if (config.getTlsVersions() != null && config.getTlsVersions().length > 0) {
        builder.tlsVersions(config.getTlsVersions());
      }

    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
    HttpClientUtils.createApplicableInterceptors(config, factory).forEach(builder::addOrReplaceInterceptor);
  }

}
