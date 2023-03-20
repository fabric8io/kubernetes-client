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

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.junit.jupiter.api.RequireK8sSupport;
import io.fabric8.openshift.api.model.ImageStreamTag;
import io.fabric8.openshift.api.model.ImageStreamTagBuilder;
import io.fabric8.openshift.api.model.ImageStreamTagList;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequireK8sSupport(ImageStreamTag.class)
@LoadKubernetesManifests("/imagestreamtag-it.yml")
class ImageStreamTagIT {

  OpenShiftClient client;

  @Test
  void load() {
    ImageStreamTag loadedIST = client.imageStreamTags()
        .load(getClass().getResourceAsStream("/test-ist.yml")).item();

    assertNotNull(loadedIST);
    assertEquals("bar1:1.0.12", loadedIST.getMetadata().getName());
    assertEquals("DockerImage", loadedIST.getTag().getFrom().getKind());
    assertEquals("openshift/wildfly-81-centos7:latest", loadedIST.getTag().getFrom().getName());
  }

  @Test
  void get() {
    client.imageStreams().withName("get").waitUntilCondition(is -> is != null && is.getStatus() != null &&
        is.getStatus().getTags().stream().anyMatch(nt -> nt.getTag().equals("1.0.12")),
        30, TimeUnit.SECONDS);
    ImageStreamTag getIST = client.imageStreamTags().withName("get:1.0.12").get();

    assertNotNull(getIST);
    assertEquals("get:1.0.12", getIST.getMetadata().getName());
    assertEquals("DockerImage", getIST.getTag().getFrom().getKind());
    assertEquals("busybox:latest", getIST.getTag().getFrom().getName());
  }

  @Test
  void list() {
    client.imageStreams().withName("list").waitUntilCondition(is -> is != null && is.getStatus() != null &&
        is.getStatus().getTags().stream().anyMatch(nt -> nt.getTag().equals("1.0.12")),
        30, TimeUnit.SECONDS);
    ImageStreamTagList istagList = client.imageStreamTags().list();

    assertNotNull(istagList);
    assertTrue(istagList.getItems().size() >= 1);
    Optional<ImageStreamTag> imageStreamTag = istagList.getItems().stream()
        .filter(i -> i.getMetadata().getName().equalsIgnoreCase("list:1.0.12")).findFirst();
    assertTrue(imageStreamTag.isPresent());
    assertEquals("list:1.0.12", imageStreamTag.get().getMetadata().getName());
    assertEquals("DockerImage", imageStreamTag.get().getTag().getFrom().getKind());
    assertEquals("busybox:latest", imageStreamTag.get().getTag().getFrom().getName());
  }

  @Test
  void update() {
    client.imageStreams().withName("update").waitUntilCondition(is -> is != null && is.getStatus() != null &&
        is.getStatus().getTags().stream().anyMatch(nt -> nt.getTag().equals("1.0.12")),
        30, TimeUnit.SECONDS);
    ImageStreamTag istag2 = new ImageStreamTagBuilder().withNewMetadata().withName("update:1.0.12").endMetadata()
        .withNewTag()
        .withNewFrom()
        .withKind("DockerImage")
        .withName("busybox:latest")
        .endFrom()
        .endTag()
        .build();
    ImageStreamTag istag = client.imageStreamTags().withName("update:1.0.12").patch(istag2);

    assertNotNull(istag);
    assertEquals("update:1.0.12", istag.getMetadata().getName());
    assertEquals("DockerImage", istag.getTag().getFrom().getKind());
    assertEquals("busybox:latest", istag.getTag().getFrom().getName());
  }

  @Test
  void delete() {
    client.imageStreams().withName("delete").waitUntilCondition(is -> is != null && is.getStatus() != null &&
        is.getStatus().getTags().stream().anyMatch(nt -> nt.getTag().equals("1.0.12")),
        30, TimeUnit.SECONDS);
    boolean deleted = client.imageStreamTags().withName("delete:1.0.12").delete().size() == 1;
    assertTrue(deleted);
    client.imageStreamTags().withName("delete:1.0.12")
        .waitUntilCondition(r -> r == null || r.getMetadata().getDeletionTimestamp() != null, 30, TimeUnit.SECONDS);
  }

}
