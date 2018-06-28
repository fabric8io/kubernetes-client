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

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class URLUtilsTest {


  @Test
  public void shouldJoinUrlWithoutQueryParams() {

    // Given

    String masterUrl = "https://oso-master-url:8888/kubernetes";

    // When

    final String fullUrl = URLUtils.join(masterUrl, "api");

    // Then

    assertThat(fullUrl, is("https://oso-master-url:8888/kubernetes/api"));

  }

  @Test
  public void shouldJoinUrlWithQueryParams() {

    // Given

    String masterUrl = "https://oso-master-url:8888/kubernetes?key=value";

    // When

    final String fullUrl = URLUtils.join(masterUrl, "api");

    // Then

    assertThat(fullUrl, is("https://oso-master-url:8888/kubernetes/api?key=value"));

  }

  @Test
  public void shouldJoinNoneUrl() {

    // Given

    String masterUrl = "images.openshift.io";

    // When

    final String fullUrl = URLUtils.join(masterUrl, "api");

    // Then

    assertThat(fullUrl, is("images.openshift.io/api"));

  }


}
