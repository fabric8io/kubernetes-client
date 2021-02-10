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
import io.fabric8.kubernetes.client.ConfigBuilder;
import okhttp3.Interceptor;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.fabric8.kubernetes.client.utils.HttpClientUtils.KUBERNETES_BACKWARDS_COMPATIBILITY_INTERCEPTOR_DISABLE;
import static org.assertj.core.api.Assertions.assertThat;

class HttpClientUtilsTest {
  @Test
  void testCreateApplicableInterceptors() {
    // Given
    Config config = new ConfigBuilder().build();

    // When
    List<Interceptor> interceptorList = HttpClientUtils.createApplicableInterceptors(config);

    // Then
    assertThat(interceptorList)
      .isNotNull()
      .hasSize(4)
      .hasAtLeastOneElementOfType(BackwardsCompatibilityInterceptor.class)
      .hasAtLeastOneElementOfType(ImpersonatorInterceptor.class)
      .hasAtLeastOneElementOfType(TokenRefreshInterceptor.class);
  }

  @Test
  void testCreateApplicableInterceptorsWithBackwardsCompatibilityDisabled() {
    // Given
    Config config = new ConfigBuilder().build();
    System.setProperty(KUBERNETES_BACKWARDS_COMPATIBILITY_INTERCEPTOR_DISABLE, "true");

    // When
    List<Interceptor> interceptorList = HttpClientUtils.createApplicableInterceptors(config);

    // Then
    assertThat(interceptorList)
      .isNotNull()
      .hasSize(3)
      .noneMatch(i -> i instanceof BackwardsCompatibilityInterceptor)
      .hasAtLeastOneElementOfType(ImpersonatorInterceptor.class)
      .hasAtLeastOneElementOfType(TokenRefreshInterceptor.class);
    System.clearProperty(KUBERNETES_BACKWARDS_COMPATIBILITY_INTERCEPTOR_DISABLE);
  }
}
