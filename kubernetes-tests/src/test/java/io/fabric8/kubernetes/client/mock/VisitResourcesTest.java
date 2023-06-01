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

package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.APIResource;
import io.fabric8.kubernetes.api.model.APIResourceListBuilder;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceList;
import io.fabric8.kubernetes.client.ApiVisitor;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@EnableKubernetesMockClient
class VisitResourcesTest {
  private KubernetesMockServer server;
  private KubernetesClient client;

  @Test
  void testMissingApiResourcesAndGroups() {
    // api/v1 is missing
    // apis is missing
    // the following should still succeed
    client.visitResources(new ApiVisitor() {

      @Override
      public ApiVisitResult visitResource(String group, String version, APIResource apiResource,
          MixedOperation<GenericKubernetesResource, GenericKubernetesResourceList, Resource<GenericKubernetesResource>> operation) {
        throw new AssertionError();
      }
    });
  }

  @Test
  void testVisitResource() throws Exception {
    CompletableFuture<APIResource> visited = new CompletableFuture<>();
    server.expect().withPath("/api/v1").andReturn(200, new APIResourceListBuilder().addNewResource()
        .withName("something")
        .endResource().build()).always();
    // the following should still succeed
    client.visitResources(new ApiVisitor() {

      @Override
      public ApiVisitResult visitResource(String group, String version, APIResource apiResource,
          MixedOperation<GenericKubernetesResource, GenericKubernetesResourceList, Resource<GenericKubernetesResource>> operation) {
        visited.complete(apiResource);
        return ApiVisitResult.CONTINUE;
      }
    });

    assertEquals("something", visited.get(0, TimeUnit.MILLISECONDS).getName());
  }
}
