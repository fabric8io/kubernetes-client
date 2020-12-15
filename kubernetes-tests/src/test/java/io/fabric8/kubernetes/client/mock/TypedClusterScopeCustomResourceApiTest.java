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

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.mock.crd.Star;
import io.fabric8.kubernetes.client.mock.crd.StarList;
import io.fabric8.kubernetes.client.mock.crd.StarSpec;
import io.fabric8.kubernetes.client.mock.crd.StarStatus;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.net.HttpURLConnection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@EnableRuleMigrationSupport
class TypedClusterScopeCustomResourceApiTest {
    @Rule
    public KubernetesServer server = new KubernetesServer();

    private MixedOperation<Star, StarList, Resource<Star>> starClient;
    
    private CustomResourceDefinitionContext crdContext;

    @BeforeEach
    void setupCrd() {
      crdContext = CustomResourceDefinitionContext.fromCustomResourceType(Star.class);
    }

    @Test
    void create() {
      server.expect().post().withPath("/apis/example.crd.com/v1alpha1/stars").andReturn(200, getStar()).once();

      starClient = server.getClient().customResources(crdContext, Star.class, StarList.class);

      Star returnedStar = starClient.inNamespace("test").create(getStar());
      assertNotNull(returnedStar);
      assertEquals("sun", returnedStar.getMetadata().getName());
    }

    @Test
    void list() {
      StarList starList = new StarList();
      starList.setItems(Collections.singletonList(getStar()));
      server.expect().get().withPath("/apis/example.crd.com/v1alpha1/stars").andReturn(200, starList).once();
      starClient = server.getClient().customResources(crdContext, Star.class, StarList.class);

      starList = starClient.inNamespace("test").list();
      assertNotNull(starList);
      assertEquals(1, starList.getItems().size());
      assertEquals("sun", starList.getItems().get(0).getMetadata().getName());
    }

    @Test
    void createOrReplace() {
      server.expect().get().withPath("/apis/example.crd.com/v1alpha1/stars/sun").andReturn(HttpURLConnection.HTTP_OK, getStar()).times(2);
      server.expect().post().withPath("/apis/example.crd.com/v1alpha1/stars").andReturn(HttpURLConnection.HTTP_CONFLICT, getStar()).times(2);
      server.expect().put().withPath("/apis/example.crd.com/v1alpha1/stars/sun").andReturn(HttpURLConnection.HTTP_OK, getStar()).once();

      starClient = server.getClient().customResources(crdContext, Star.class, StarList.class);
      Star returnedStar = starClient.inNamespace("test").createOrReplace(getStar());

      assertNotNull(returnedStar);
      assertEquals("sun", returnedStar.getMetadata().getName());
    }

    @Test
    void delete() {
      server.expect().delete().withPath("/apis/example.crd.com/v1alpha1/stars/sun").andReturn(200, getStar()).once();

      starClient = server.getClient().customResources(crdContext, Star.class, StarList.class);

      boolean isDeleted = starClient.inNamespace("test").withName("sun").delete();
      assertTrue(isDeleted);
    }

    @Test
    void testCascadingDeletion() throws InterruptedException {
      server.expect().delete().withPath("/apis/example.crd.com/v1alpha1/stars/sun").andReturn(200, getStar()).once();

      starClient = server.getClient().customResources(crdContext, Star.class, StarList.class);

      boolean isDeleted = starClient.inNamespace("test").withName("sun").cascading(true).delete();
      assertTrue(isDeleted);

      RecordedRequest recordedRequest = server.getLastRequest();
      assertEquals("DELETE", recordedRequest.getMethod());
      assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"orphanDependents\":false}", recordedRequest.getBody().readUtf8());
    }

    @Test
    void testPropagationPolicyDeletion() throws InterruptedException {
      server.expect().delete().withPath("/apis/example.crd.com/v1alpha1/stars/sun").andReturn(200, getStar()).once();

      starClient = server.getClient().customResources(crdContext, Star.class, StarList.class);

      boolean isDeleted = starClient.inNamespace("test").withName("sun").withPropagationPolicy(DeletionPropagation.ORPHAN).delete();
      assertTrue(isDeleted);

      RecordedRequest recordedRequest = server.getLastRequest();
      assertEquals("DELETE", recordedRequest.getMethod());
      assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Orphan\"}", recordedRequest.getBody().readUtf8());
    }

    @Test
    void testStatusUpdate() throws InterruptedException {
      Star updatedStar = getStar();
      StarStatus starStatus = new StarStatus();
      starStatus.setLocation("M");
      updatedStar.setStatus(starStatus);

      server.expect().put().withPath("/apis/example.crd.com/v1alpha1/stars/sun/status").andReturn(200, updatedStar).once();
      starClient = server.getClient().customResources(crdContext, Star.class, StarList.class);

      starClient.inNamespace("test").updateStatus(updatedStar);
      RecordedRequest recordedRequest = server.getLastRequest();
      assertEquals("PUT", recordedRequest.getMethod());
      assertEquals("{\"apiVersion\":\"example.crd.com/v1alpha1\",\"kind\":\"Star\",\"metadata\":{\"name\":\"sun\"},\"spec\":{\"type\":\"G\",\"location\":\"Galaxy\"},\"status\":{\"location\":\"M\"}}", recordedRequest.getBody().readUtf8());
      System.out.println(recordedRequest.getBody().readUtf8());
    }

    private Star getStar() {
      StarSpec starSpec = new StarSpec();
      starSpec.setType("G");
      starSpec.setLocation("Galaxy");

      Star star = new Star();
      star.setApiVersion("example.crd.com/v1alpha1");
      star.setMetadata(new ObjectMetaBuilder().withName("sun").build());
      star.setSpec(starSpec);
      return star;
    }
}
