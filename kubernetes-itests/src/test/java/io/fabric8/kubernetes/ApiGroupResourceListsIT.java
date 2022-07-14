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

package io.fabric8.kubernetes;

import io.fabric8.kubernetes.api.model.APIGroup;
import io.fabric8.kubernetes.api.model.APIGroupList;
import io.fabric8.kubernetes.api.model.APIResource;
import io.fabric8.kubernetes.api.model.APIResourceList;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceList;
import io.fabric8.kubernetes.client.ApiVisitor;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApiGroupResourceListsIT {

  KubernetesClient client;

  @Test
  void testApiGroups() {
    APIGroupList list = client.getApiGroups();

    assertTrue(list.getGroups().stream().anyMatch(g -> "apps".equals(g.getName())));
  }

  @Test
  void testApiGroup() {
    APIGroup group = client.getApiGroup("apps");

    assertNotNull(group);

    group = client.getApiGroup("apps-that-wont-exist");

    assertNull(group);
  }

  @Test
  void testApiResources() {
    APIResourceList list = client.getApiResources("apps/v1");

    assertTrue(list.getResources().stream().anyMatch(r -> "deployments".equals(r.getName())));

    list = client.getApiResources("v1");

    assertTrue(list.getResources().stream().anyMatch(r -> "configmaps".equals(r.getName())));
  }

  @Test
  void testApiVisiting() {
    APIGroupList list = client.getApiGroups();

    AtomicInteger groupCount = new AtomicInteger();

    client.visitResources(new ApiVisitor() {

      @Override
      public ApiVisitResult visitApi(String api) {
        groupCount.incrementAndGet();
        return ApiVisitResult.CONTINUE;
      }

      @Override
      public ApiVisitResult visitResources(String apiVersion, APIResource apiResource,
          MixedOperation<GenericKubernetesResource, GenericKubernetesResourceList, Resource<GenericKubernetesResource>> mixedOperation) {
        return ApiVisitResult.CONTINUE;
      }

    });

    // visit all groups + the core group
    assertEquals(list.getGroups().size() + 1, groupCount.get());

    // visit again to make sure we terminate as expected 
    CompletableFuture<Boolean> done = new CompletableFuture<>();
    client.visitResources(new ApiVisitor() {

      @Override
      public ApiVisitResult visitApi(String api) {
        if (api.isEmpty()) {
          return ApiVisitResult.CONTINUE;
        }
        return ApiVisitResult.TERMINATE;
      }

      @Override
      public ApiVisitResult visitResources(String apiVersion, APIResource apiResource,
          MixedOperation<GenericKubernetesResource, GenericKubernetesResourceList, Resource<GenericKubernetesResource>> operation) {
        assertFalse(done.isDone());
        if (apiResource.getName().equals("configmaps")) {
          done.complete(!operation.inAnyNamespace().list().getItems().isEmpty());
          return ApiVisitResult.TERMINATE;
        }
        return ApiVisitResult.CONTINUE;
      }

    });

    assertTrue(done.join());
  }
}
