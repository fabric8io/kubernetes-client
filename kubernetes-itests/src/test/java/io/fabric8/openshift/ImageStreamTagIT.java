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

import io.fabric8.openshift.api.model.*;
import io.fabric8.openshift.client.OpenShiftClient;
import org.arquillian.cube.openshift.impl.requirement.RequiresOpenshift;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(ArquillianConditionalRunner.class)
@RequiresOpenshift
public class ImageStreamTagIT {

  @ArquillianResource
  OpenShiftClient client;

  @Before
  public void init() throws InterruptedException {

    ImageStreamTag istag = new ImageStreamTagBuilder().withNewMetadata().withName("bar1:1.0.12").endMetadata()
      .withNewTag()
      .withNewFrom()
      .withKind("DockerImage")
      .withName("openshift/wildfly-81-centos7:latest")
      .endFrom()
      .endTag()
      .build();

    client.imageStreamTags().create(istag);

    Thread.sleep(20000);

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

    ImageStreamTag getIST = client.imageStreamTags()
      .withName("bar1:1.0.12").get();

    assertNotNull(getIST);
    assertEquals("bar1:1.0.12", getIST.getMetadata().getName());
    assertEquals("DockerImage", getIST.getTag().getFrom().getKind());
    assertEquals("openshift/wildfly-81-centos7:latest", getIST.getTag().getFrom().getName());

  }

  @Test
  public void list() {

    ImageStreamTagList istagList = client.imageStreamTags().list();

    assertNotNull(istagList);
    assertEquals(1,istagList.getItems().size());
    assertEquals("bar1:1.0.12", istagList.getItems().get(0).getMetadata().getName());
    assertEquals("DockerImage", istagList.getItems().get(0).getTag().getFrom().getKind());
    assertEquals("openshift/wildfly-81-centos7:latest", istagList.getItems().get(0).getTag().getFrom().getName());
  }

  @Test
  public void update(){

    ImageStreamTag istag2 = new ImageStreamTagBuilder().withNewMetadata().withName("bar1:1.0.12").endMetadata()
      .withNewTag()
      .withNewFrom()
      .withKind("DockerImage")
      .withName("openshift/wildfly-81-centos:latest")
      .endFrom()
      .endTag()
      .build();
    ImageStreamTag istag = client.imageStreamTags().withName("bar1:1.0.12").patch(istag2);

    assertNotNull(istag);
    assertEquals("bar1:1.0.12", istag.getMetadata().getName());
    assertEquals("DockerImage", istag.getTag().getFrom().getKind());
    assertEquals("openshift/wildfly-81-centos:latest", istag.getTag().getFrom().getName());
  }

  @Test
  public void delete(){

    boolean deleted = client.imageStreamTags().withName("bar1:1.0.12").delete();
    assertTrue(deleted);
    ImageStreamTagList istagList = client.imageStreamTags().list();
    assertEquals(0, istagList.getItems().size());
  }


  @After
  public void cleanup() {

    client.imageStreamTags().withName("bar1:1.0.12").delete();
  }

}
