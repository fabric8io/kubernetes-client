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

package io.fabric8.openshift.client.server.mock;

import io.fabric8.openshift.api.model.ImageStreamTag;
import io.fabric8.openshift.api.model.ImageStreamTagBuilder;
import io.fabric8.openshift.api.model.ImageStreamTagList;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableOpenShiftMockClient(crud = true)
class ImageStreamTagCrudTest {

  private static final Logger logger = LoggerFactory.getLogger(ImageStreamTagCrudTest.class);

  OpenShiftClient client;

  @Test
  void crudTest() {

    logger.info("Current User " + client.currentUser());

    ImageStreamTag istag = new ImageStreamTagBuilder().withNewMetadata().withName("bar1:1.0.12").endMetadata()
        .withNewTag()
        .withNewFrom()
        .withKind("DockerImage")
        .withName("openshift/wildfly-81-centos7:latest")
        .endFrom()
        .withReference(false)
        .endTag()
        .withGeneration(1L)
        .build();

    //test of Creation
    istag = client.imageStreamTags().create(istag);

    assertNotNull(istag);
    assertEquals("bar1:1.0.12", istag.getMetadata().getName());
    assertEquals("DockerImage", istag.getTag().getFrom().getKind());
    assertEquals("openshift/wildfly-81-centos7:latest", istag.getTag().getFrom().getName());
    assertEquals(false, istag.getTag().getReference());
    assertEquals(1, istag.getGeneration().intValue());

    //test of List
    ImageStreamTagList istagList = client.imageStreamTags().list();

    logger.info(istagList.toString());
    assertNotNull(istagList);
    assertEquals(1, istagList.getItems().size());
    assertEquals("bar1:1.0.12", istagList.getItems().get(0).getMetadata().getName());
    assertEquals("DockerImage", istagList.getItems().get(0).getTag().getFrom().getKind());
    assertEquals("openshift/wildfly-81-centos7:latest", istagList.getItems().get(0).getTag().getFrom().getName());
    assertEquals(false, istagList.getItems().get(0).getTag().getReference());
    assertEquals(1, istagList.getItems().get(0).getGeneration().intValue());

    //test of Updation
    ImageStreamTag istag2 = new ImageStreamTagBuilder().withNewMetadata().withName("bar1:1.0.12").endMetadata()
        .withNewTag()
        .withNewFrom()
        .withKind("DockerImage")
        .withName("openshift/wildfly-81-centos7:latest")
        .endFrom()
        .withReference(false)
        .endTag()
        .withGeneration(2L)
        .build();

    istag = client.imageStreamTags().withName("bar1:1.0.12").patch(istag2);
    logger.info(istag.toString());

    assertNotNull(istag);
    assertEquals("bar1:1.0.12", istag.getMetadata().getName());
    assertEquals("DockerImage", istag.getTag().getFrom().getKind());
    assertEquals("openshift/wildfly-81-centos7:latest", istag.getTag().getFrom().getName());
    assertEquals(false, istag.getTag().getReference());
    assertEquals(2, istag.getGeneration().intValue());

    boolean deleted = client.imageStreamTags().withName("bar1:1.0.12").delete().size() == 1;
    assertTrue(deleted);
    istagList = client.imageStreamTags().list();
    assertEquals(0, istagList.getItems().size());
  }

}
