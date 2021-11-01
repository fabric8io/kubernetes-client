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
import io.fabric8.kubernetes.client.internal.okhttp.OkHttpClientFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class HttpClientUtils {
  
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
            return new URL(proxy);
        }
        return null;
    }

    private static boolean isIpAddress(String ipAddress) {
        Matcher ipMatcher = VALID_IPV4_PATTERN.matcher(ipAddress);
        return ipMatcher.matches();
    }

  public static Map<String, io.fabric8.kubernetes.client.http.Interceptor> createApplicableInterceptors(Config config) {
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
    interceptors.put("IMPERSONATOR", new ImpersonatorInterceptor(config));
    // Token Refresh Interceptor
    interceptors.put(TokenRefreshInterceptor.NAME, new TokenRefreshInterceptor(config));
    // Backwards Compatibility Interceptor
    String shouldDisableBackwardsCompatibilityInterceptor = Utils.getSystemPropertyOrEnvVar(KUBERNETES_BACKWARDS_COMPATIBILITY_INTERCEPTOR_DISABLE, "false");
    if (!Boolean.parseBoolean(shouldDisableBackwardsCompatibilityInterceptor)) {
      interceptors.put("BACKWARDS", new BackwardsCompatibilityInterceptor());
    }

    return interceptors;
  }
  
  public static String basicCredentials(String username, String password) {
    String usernameAndPassword = username + ":" + password;
    String encoded = Base64.getEncoder().encodeToString(usernameAndPassword.getBytes(StandardCharsets.ISO_8859_1));
    return "Basic " + encoded;
  }

  public static HttpClient createHttpClient(Config config) {
    // TODO: replace with reflection / service load and factory interface
    return OkHttpClientFactory.createHttpClient(config, builder -> {});
  }
}
