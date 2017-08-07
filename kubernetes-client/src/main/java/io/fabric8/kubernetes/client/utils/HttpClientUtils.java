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
import io.fabric8.kubernetes.client.internal.SSLUtils;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static io.fabric8.kubernetes.client.utils.Utils.isNotNullOrEmpty;
import static okhttp3.ConnectionSpec.CLEARTEXT;

public class HttpClientUtils {

    public static OkHttpClient createHttpClient(final Config config) {
        try {
            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

            // Follow any redirects
            httpClientBuilder.followRedirects(true);
            httpClientBuilder.followSslRedirects(true);

            if (config.isTrustCerts()) {
                httpClientBuilder.hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String s, SSLSession sslSession) {
                        return true;
                    }
                });
            }

            TrustManager[] trustManagers = SSLUtils.trustManagers(config);
            KeyManager[] keyManagers = SSLUtils.keyManagers(config);

            if (keyManagers != null || trustManagers != null || config.isTrustCerts()) {
                X509TrustManager trustManager = null;
                if (trustManagers != null && trustManagers.length == 1) {
                  trustManager = (X509TrustManager) trustManagers[0];
                }

                try {
                    SSLContext sslContext = SSLUtils.sslContext(keyManagers, trustManagers, config.isTrustCerts());
                    httpClientBuilder.sslSocketFactory(sslContext.getSocketFactory(), trustManager);
                } catch (GeneralSecurityException e) {
                    throw new AssertionError(); // The system has no TLS. Just give up.
                }
            } else {
              SSLContext context = SSLContext.getInstance("TLSv1.2");
              context.init(keyManagers, trustManagers, null);
              httpClientBuilder.sslSocketFactory(context.getSocketFactory(), (X509TrustManager) trustManagers[0]);
            }

          httpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
              Request request = chain.request();
              if (isNotNullOrEmpty(config.getUsername()) && isNotNullOrEmpty(config.getPassword())) {
                Request authReq = chain.request().newBuilder().addHeader("Authorization", Credentials.basic(config.getUsername(), config.getPassword())).build();
                return chain.proceed(authReq);
              } else if (isNotNullOrEmpty(config.getOauthToken())) {
                Request authReq = chain.request().newBuilder().addHeader("Authorization", "Bearer " + config.getOauthToken()).build();
                return chain.proceed(authReq);
              }
              return chain.proceed(request);
            }
          });

            Logger reqLogger = LoggerFactory.getLogger(HttpLoggingInterceptor.class);
            if (reqLogger.isTraceEnabled()) {
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                httpClientBuilder.addNetworkInterceptor(loggingInterceptor);
            }

            if (config.getConnectionTimeout() > 0) {
                httpClientBuilder.connectTimeout(config.getConnectionTimeout(), TimeUnit.MILLISECONDS);
            }

            if (config.getRequestTimeout() > 0) {
                httpClientBuilder.readTimeout(config.getRequestTimeout(), TimeUnit.MILLISECONDS);
            }

            if (config.getWebsocketPingInterval() > 0) {
              httpClientBuilder.pingInterval(config.getWebsocketPingInterval(), TimeUnit.MILLISECONDS);
            }

            if (config.getMaxConcurrentRequestsPerHost() > 0) {
              Dispatcher dispatcher = new Dispatcher();
              dispatcher.setMaxRequestsPerHost(config.getMaxConcurrentRequestsPerHost());
              httpClientBuilder.dispatcher(dispatcher);
            }

            // Only check proxy if it's a full URL with protocol
            if (config.getMasterUrl().toLowerCase().startsWith(Config.HTTP_PROTOCOL_PREFIX) || config.getMasterUrl().startsWith(Config.HTTPS_PROTOCOL_PREFIX)) {
                try {
                    URL proxyUrl = getProxyUrl(config);
                    if (proxyUrl != null) {
                        httpClientBuilder.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyUrl.getHost(), proxyUrl.getPort())));

                        if (config.getProxyUsername() != null) {
                          httpClientBuilder.proxyAuthenticator(new Authenticator() {
                            @Override
                            public Request authenticate(Route route, Response response) throws IOException {

                              String credential = Credentials.basic(config.getProxyUsername(), config.getProxyPassword());
                              return response.request().newBuilder().header("Proxy-Authorization", credential).build();
                            }
                          });
                        }
                    }

                } catch (MalformedURLException e) {
                    throw new KubernetesClientException("Invalid proxy server configuration", e);
                }
            }

            if (config.getUserAgent() != null && !config.getUserAgent().isEmpty()) {
                httpClientBuilder.addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request agent = chain.request().newBuilder().header("User-Agent", config.getUserAgent()).build();
                        return chain.proceed(agent);
                    }
                });
            }

            if (config.getTlsVersions() != null && config.getTlsVersions().length > 0) {
              ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                .tlsVersions(config.getTlsVersions())
                .build();
              httpClientBuilder.connectionSpecs(Arrays.asList(spec, CLEARTEXT));
            }

            return httpClientBuilder.build();
        } catch (Exception e) {
            throw KubernetesClientException.launderThrowable(e);
        }
    }

    private static URL getProxyUrl(Config config) throws MalformedURLException {
        URL master = new URL(config.getMasterUrl());
        String host = master.getHost();
        if (config.getNoProxy() != null) {
	        for (String noProxy : config.getNoProxy()) {
	            if (host.endsWith(noProxy)) {
	                return null;
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
}
