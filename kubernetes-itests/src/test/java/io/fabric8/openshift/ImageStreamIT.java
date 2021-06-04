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

import io.fabric8.commons.ClusterEntity;
import io.fabric8.commons.ReadyEntity;
import io.fabric8.openshift.api.model.ImageStream;
import io.fabric8.openshift.api.model.ImageStreamBuilder;
import io.fabric8.openshift.api.model.ImageStreamList;
import io.fabric8.openshift.client.OpenShiftClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.openshift.impl.requirement.RequiresOpenshift;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresOpenshift
public class ImageStreamIT {
  @ArquillianResource
  OpenShiftClient client;

  @ArquillianResource
  Session session;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(ImageStreamIT.class.getResourceAsStream("/imagestream-it.yml"));
  }

  @Test
  public void load() {
    ImageStream aImageStream = client.imageStreams().inNamespace(session.getNamespace())
      .load(getClass().getResourceAsStream("/test-imagestream.yml")).get();
    assertThat(aImageStream).isNotNull();
    assertEquals("my-ruby", aImageStream.getMetadata().getName());
  }

  @Test
  public void get() {
    assertNotNull(client.imageStreams().inNamespace(session.getNamespace()).withName("is-get").get());
  }

  @Test
  public void list() {
    ImageStreamList aImageStreamList = client.imageStreams().inNamespace(session.getNamespace()).list();
    assertThat(aImageStreamList).isNotNull();
    assertTrue(aImageStreamList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    ReadyEntity<ImageStream> imageStreamReady = new ReadyEntity<>(ImageStream.class, client, "is-update", this.session.getNamespace());
    await().atMost(30, TimeUnit.SECONDS).until(imageStreamReady);
    ImageStream imageStream1 = client.imageStreams().inNamespace(session.getNamespace()).withName("is-update").edit(i -> new ImageStreamBuilder(i)
      .editSpec().withDockerImageRepository("fabric8/s2i-java").endSpec()
      .build());
    assertThat(imageStream1).isNotNull();
    assertEquals("fabric8/s2i-java", imageStream1.getSpec().getDockerImageRepository());
  }

  @Test
  public void delete() {
    ReadyEntity<ImageStream> imageStreamReady = new ReadyEntity<>(ImageStream.class, client, "is-delete", this.session.getNamespace());
    await().atMost(30, TimeUnit.SECONDS).until(imageStreamReady);
    boolean bDeleted = client.imageStreams().inNamespace(session.getNamespace()).withName("is-delete").delete();
    assertTrue(bDeleted);
  }

  @Test
  public void createOrReplace() {
    // Given
    ImageStream imageStream = client.imageStreams().inNamespace(session.getNamespace()).withName("is-createorreplace").get();

    // When
    imageStream.getSpec().setDockerImageRepository("docker.io/openshift/ruby-centos-2");
    imageStream = client.imageStreams().inNamespace(session.getNamespace()).createOrReplace(imageStream);

    // Then
    assertNotNull(imageStream);
    assertEquals("is-createorreplace", imageStream.getMetadata().getName());
    assertEquals("docker.io/openshift/ruby-centos-2", imageStream.getSpec().getDockerImageRepository());
  }

}
