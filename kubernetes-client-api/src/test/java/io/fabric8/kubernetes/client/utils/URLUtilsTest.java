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

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class URLUtilsTest {

  @Test
  void shouldJoinUrlWithoutQueryParams() {

    // Given
    String masterUrl = "https://oso-master-url:8888/kubernetes";

    // When
    final String fullUrl = URLUtils.join(masterUrl, "api");

    // Then
    assertThat(fullUrl, is("https://oso-master-url:8888/kubernetes/api"));

  }

  @Test
  void shouldAppendUrlWithQueryParams() {

    // Given
    String masterUrl = "https://oso-master-url:8888/kubernetes?param1=value";

    // When
    final String fullUrl = URLUtils.join(masterUrl, "port?port=port");

    // Then
    assertThat(fullUrl, is("https://oso-master-url:8888/kubernetes/port?port=port&param1=value"));
  }

  @Test
  void shouldAppendUrlWithMultipleQueryParams() {

    // Given
    String masterUrl = "https://oso-master-url:8888/kubernetes?param1=value";

    // When
    final String fullUrl = URLUtils.join(masterUrl, "port?port=port", "host=host");

    // Then
    assertThat(fullUrl, is("https://oso-master-url:8888/kubernetes/port?port=port&host=host&param1=value"));
  }

  @Test
  void shouldJoinUrlWithQueryParams() {

    // Given
    String masterUrl = "https://oso-master-url:8888/kubernetes?key=value";

    // When
    final String fullUrl = URLUtils.join(masterUrl, "api");

    // Then
    assertThat(fullUrl, is("https://oso-master-url:8888/kubernetes/api?key=value"));

  }

  @Test
  void shouldJoinNoneUrl() {

    // Given
    String masterUrl = "images.openshift.io";

    // When
    final String fullUrl = URLUtils.join(masterUrl, "api");

    // Then
    assertThat(fullUrl, is("images.openshift.io/api"));

  }

}
