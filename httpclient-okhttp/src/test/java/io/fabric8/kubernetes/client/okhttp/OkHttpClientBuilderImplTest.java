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
package io.fabric8.kubernetes.client.okhttp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class OkHttpClientBuilderImplTest {

  @Test
  @DisplayName("S2637: build should not throw NPE when sslContext is set but trustManagers is null")
  void build_shouldNotThrowNpeWhenTrustManagersIsNull() throws NoSuchAlgorithmException {
    OkHttpClientBuilderImpl builder = new OkHttpClientBuilderImpl(
        new OkHttpClientFactory(), new okhttp3.OkHttpClient.Builder());
    builder.sslContext(null, (TrustManager[]) null);
    assertThatCode(builder::build).doesNotThrowAnyException();
  }

  @Test
  @DisplayName("S2637: build should skip non-X509 entries and pick the first X509TrustManager from the array")
  void build_shouldPickFirstX509TrustManagerSkippingNonX509() throws NoSuchAlgorithmException {
    TrustManager nonX509 = new TrustManager() {
    };
    X509TrustManager firstX509 = noopX509TrustManager();
    X509TrustManager secondX509 = noopX509TrustManager();
    OkHttpClientBuilderImpl builder = new OkHttpClientBuilderImpl(
        new OkHttpClientFactory(), new okhttp3.OkHttpClient.Builder());
    builder.sslContext(null, new TrustManager[] { nonX509, firstX509, secondX509 });

    OkHttpClientImpl client = builder.build();

    assertThat(client.getOkHttpClient().x509TrustManager())
        .as("should pick the first X509TrustManager from the array, skipping non-X509 entries")
        .isSameAs(firstX509);
  }

  private static X509TrustManager noopX509TrustManager() {
    return new X509TrustManager() {
      @Override
      public void checkClientTrusted(X509Certificate[] chain, String authType) {
      }

      @Override
      public void checkServerTrusted(X509Certificate[] chain, String authType) {
      }

      @Override
      public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
      }
    };
  }
}
