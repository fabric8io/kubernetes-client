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
import io.fabric8.commons.DeleteEntity;
import io.fabric8.commons.ReadyEntity;
import io.fabric8.openshift.api.model.*;
import io.fabric8.openshift.api.model.ImageStreamTagBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.openshift.impl.requirement.RequiresOpenshift;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.junit.Assert.*;

@RunWith(ArquillianConditionalRunner.class)
@RequiresOpenshift
public class ImageStreamTagIT {

  @ArquillianResource
  OpenShiftClient client;

  @ArquillianResource
  Session session;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(ImageStreamTagIT.class.getResourceAsStream("/imagestreamtag-it.yml"));
  }

  @Test
  public void load() {
    ImageStreamTag loadedIST = client.imageStreamTags()
      .load(getClass().getResourceAsStream("/test-ist.yml")).get();

    assertNotNull(loadedIST);
    assertEquals("bar1:1.0.12", loadedIST.getMetadata().getName());
    assertEquals("DockerImage", loadedIST.getTag().getFrom().getKind());
    assertEquals("openshift/wildfly-81-centos7:latest", loadedIST.getTag().getFrom().getName());
  }

  @Test
  public void get() {

    ReadyEntity<ImageStreamTag> imageStreamTagReadyEntity = new ReadyEntity<>(ImageStreamTag.class, client, "get:1.0.12", session.getNamespace());
    await().atMost(30, TimeUnit.SECONDS).until(imageStreamTagReadyEntity);
    ImageStreamTag getIST = client.imageStreamTags().inNamespace(session.getNamespace())
      .withName("get:1.0.12").get();

    assertNotNull(getIST);
    assertEquals("get:1.0.12", getIST.getMetadata().getName());
    assertEquals("DockerImage", getIST.getTag().getFrom().getKind());
    assertEquals("busybox:latest", getIST.getTag().getFrom().getName());

  }

  @Test
  public void list() {

    ImageStreamTagList istagList = client.imageStreamTags().inNamespace(session.getNamespace()).list();

    assertNotNull(istagList);
    assertTrue(istagList.getItems().size() >= 1);
    Optional<ImageStreamTag> imageStreamTag = istagList.getItems().stream().filter(i -> i.getMetadata().getName().equalsIgnoreCase("list:1.0.12")).findFirst();
    assertTrue(imageStreamTag.isPresent());
    assertEquals("list:1.0.12", imageStreamTag.get().getMetadata().getName());
    assertEquals("DockerImage", imageStreamTag.get().getTag().getFrom().getKind());
    assertEquals("busybox:latest", imageStreamTag.get().getTag().getFrom().getName());
  }

  @Test
  public void update() {

    ReadyEntity<ImageStreamTag> imageStreamTagReadyEntity = new ReadyEntity<>(ImageStreamTag.class, client, "update:1.0.12", session.getNamespace());
    await().atMost(30, TimeUnit.SECONDS).until(imageStreamTagReadyEntity);
    ImageStreamTag istag2 = new ImageStreamTagBuilder().withNewMetadata().withName("update:1.0.12").endMetadata()
      .withNewTag()
      .withNewFrom()
      .withKind("DockerImage")
      .withName("busybox:latest")
      .endFrom()
      .endTag()
      .build();
    ImageStreamTag istag = client.imageStreamTags().inNamespace(session.getNamespace()).withName("update:1.0.12").patch(istag2);

    assertNotNull(istag);
    assertEquals("update:1.0.12", istag.getMetadata().getName());
    assertEquals("DockerImage", istag.getTag().getFrom().getKind());
    assertEquals("busybox:latest", istag.getTag().getFrom().getName());
  }

  @Test
  public void delete() {
    ReadyEntity<ImageStreamTag> imageStreamTagReadyEntity = new ReadyEntity<>(ImageStreamTag.class, client, "delete:1.0.12", session.getNamespace());
    await().atMost(30, TimeUnit.SECONDS).until(imageStreamTagReadyEntity);
    ImageStreamTagList imageStreamTagListOld = client.imageStreamTags().inNamespace(session.getNamespace()).list();
    boolean deleted = client.imageStreamTags().inNamespace(session.getNamespace()).withName("delete:1.0.12").delete();
    assertTrue(deleted);
    DeleteEntity<ImageStreamTag> deleteEntity = new DeleteEntity<>(ImageStreamTag.class, client, "delete:1.0.12", session.getNamespace());
    await().atMost(30, TimeUnit.SECONDS).until(deleteEntity);
  }

}
