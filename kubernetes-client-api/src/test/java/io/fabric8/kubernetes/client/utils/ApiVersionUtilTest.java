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

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentSpec;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ApiVersionUtilTest {
  @Test
  void apiGroup() {
    assertThat(ApiVersionUtil.apiGroup(new Deployment(), "apps/v1"))
        .isEqualTo("apps");
    assertThat(ApiVersionUtil.apiGroup(new DeploymentSpec(), "apps/v1"))
        .isEqualTo("apps");
    assertThat(ApiVersionUtil.apiGroup(new Pod(), "v1"))
        .isNull();
    assertThat(ApiVersionUtil.apiGroup(new DeploymentSpec(), ""))
        .isNull();
  }

  @Test
  void apiVersion() {
    assertThat(ApiVersionUtil.apiVersion(new Deployment(), "apps/v1"))
        .isEqualTo("v1");
    assertThat(ApiVersionUtil.apiVersion(new DeploymentSpec(), "apps/v1"))
        .isEqualTo("v1");
    assertThat(ApiVersionUtil.apiVersion(new Pod(), "v1"))
        .isEqualTo("v1");
    assertThat(ApiVersionUtil.apiVersion(new DeploymentSpec(), ""))
        .isNull();
  }

  @Test
  void joinApiGroupAndVersion() {
    assertThat(ApiVersionUtil.joinApiGroupAndVersion("", "v1"))
        .isEqualTo("v1");
    assertThat(ApiVersionUtil.joinApiGroupAndVersion("apps", "v1"))
        .isEqualTo("apps/v1");
  }

  @Test
  void trimVersion() {
    assertThat(ApiVersionUtil.trimVersion("rbac.authorization.k8s.io/v1"))
        .isEqualTo("v1");
    assertThat(ApiVersionUtil.trimVersion("v1"))
        .isEqualTo("v1");
  }

  @Test
  void trimGroup() {
    assertThat(ApiVersionUtil.trimGroup("rbac.authorization.k8s.io/v1"))
        .isEqualTo("rbac.authorization.k8s.io");
    assertThat(ApiVersionUtil.trimGroup("v1"))
        .isEqualTo("v1");
  }
}
