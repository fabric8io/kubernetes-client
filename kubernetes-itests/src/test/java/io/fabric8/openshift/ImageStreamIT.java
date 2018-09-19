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

package io.fabric8.openshift;

import io.fabric8.commons.DeleteEntity;
import io.fabric8.commons.ReadyEntity;
import io.fabric8.openshift.api.model.ImageStream;
import io.fabric8.openshift.api.model.ImageStreamBuilder;
import io.fabric8.openshift.api.model.ImageStreamList;
import io.fabric8.openshift.client.OpenShiftClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.openshift.impl.requirement.RequiresOpenshift;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresOpenshift
public class ImageStreamIT {
  @ArquillianResource
  OpenShiftClient client;

  @ArquillianResource
  Session session;

  private ImageStream imageStream1, imageStream2;

  private String currentNamespace;

  @Before
  public void init() {
    currentNamespace = session.getNamespace();
    imageStream1 = new ImageStreamBuilder()
      .withNewMetadata()
      .withName("example-camel-cdi")
      .endMetadata()
      .withNewSpec()
      .addNewTag()
      .withName("latest")
      .endTag()
      .withDockerImageRepository("fabric8/example-camel-cdi")
      .endSpec()
      .withNewStatus().withDockerImageRepository("").endStatus()
      .build();

    imageStream2 = new ImageStreamBuilder()
      .withNewMetadata()
      .withName("java-sti")
      .endMetadata()
      .withNewSpec()
      .addNewTag()
      .withName("latest")
      .endTag()
      .withDockerImageRepository("fabric8/java-sti")
      .endSpec()
      .withNewStatus().withDockerImageRepository("").endStatus()
      .build();

    client.imageStreams().inNamespace(currentNamespace).createOrReplace(imageStream1);
    client.imageStreams().inNamespace(currentNamespace).createOrReplace(imageStream2);
  }

  @Test
  public void load() {
    ImageStream aImageStream = client.imageStreams().inNamespace(currentNamespace)
      .load(getClass().getResourceAsStream("/test-imagestream.yml")).get();
    assertThat(aImageStream).isNotNull();
    assertEquals("my-ruby", aImageStream.getMetadata().getName());
  }

  @Test
  public void get() {
    assertNotNull(client.imageStreams().inNamespace(currentNamespace).withName("example-camel-cdi").get());
    assertNotNull(client.imageStreams().inNamespace(currentNamespace).withName("java-sti").get());
  }

  @Test
  public void list() {
    ImageStreamList aImageStreamList = client.imageStreams().inNamespace(currentNamespace).list();
    assertThat(aImageStreamList).isNotNull();
    assertEquals(2, aImageStreamList.getItems().size());
  }

  @Test
  public void update() {
    ReadyEntity<ImageStream> imageStreamReady = new ReadyEntity<>(ImageStream.class, client, "java-sti", this.currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(imageStreamReady);
    imageStream1 = client.imageStreams().inNamespace(currentNamespace).withName("java-sti").edit()
      .editSpec().withDockerImageRepository("fabric8/s2i-java").endSpec()
      .done();
    assertThat(imageStream1).isNotNull();
    assertEquals("fabric8/s2i-java", imageStream1.getSpec().getDockerImageRepository());
  }

  @Test
  public void delete() {
    ReadyEntity<ImageStream> imageStreamReady = new ReadyEntity<>(ImageStream.class, client, "example-camel-cdi", this.currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(imageStreamReady);
    boolean bDeleted = client.imageStreams().inNamespace(currentNamespace).withName("example-camel-cdi").delete();
    assertTrue(bDeleted);
  }

  @After
  public void cleanup() throws InterruptedException {
    if (client.imageStreams().inNamespace(currentNamespace).list().getItems().size()!= 0) {
      client.imageStreams().inNamespace(currentNamespace).delete();
    }

    DeleteEntity<ImageStream> imageStream1Delete = new DeleteEntity<>(ImageStream.class, client, "java-sti", this.currentNamespace);
    DeleteEntity<ImageStream> imageStream2Delete = new DeleteEntity<>(ImageStream.class, client, "example-camel-cdi", this.currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(imageStream1Delete);
    await().atMost(30, TimeUnit.SECONDS).until(imageStream2Delete);
  }
}
