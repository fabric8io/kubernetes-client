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
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ImageStreamTest {
  public static OpenShiftClient client;

  public static String currentNamespace;

  @BeforeClass
  public static void init() {
    client = new DefaultOpenShiftClient();
    currentNamespace = "rt-" + RandomStringUtils.randomAlphanumeric(6).toLowerCase();
    ProjectRequest proj = new ProjectRequestBuilder().withNewMetadata().withName(currentNamespace).endMetadata().build();
    client.projectrequests().create(proj);
  }

  @AfterClass
  public static void cleanup() {
    client.projects().withName(currentNamespace).delete();
    client.close();
  }

  @Test
  public void testLoad() {
    ImageStream aImageStream = client.imageStreams().inNamespace(currentNamespace)
      .load(getClass().getResourceAsStream("/test-imagestream.yml")).get();
    assertThat(aImageStream).isNotNull();
    assertEquals("my-ruby", aImageStream.getMetadata().getName());
  }

  @Test
  public void testCrud() {
    ImageStream imageStream1 = new ImageStreamBuilder()
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

    ImageStream imageStream2 = new ImageStreamBuilder()
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

    client.imageStreams().inNamespace(currentNamespace).create(imageStream1);
    client.imageStreams().inNamespace(currentNamespace).create(imageStream2);

    ImageStreamList aImageStreamList = client.imageStreams().inNamespace(currentNamespace).list();
    assertThat(aImageStreamList).isNotNull();
    assertEquals(2, aImageStreamList.getItems().size());

    imageStream1 = client.imageStreams().inNamespace(currentNamespace).withName("java-sti").edit()
      .editSpec().withDockerImageRepository("fabric8/s2i-java").endSpec()
      .done();
    assertThat(imageStream1).isNotNull();
    assertEquals("fabric8/s2i-java", imageStream1.getSpec().getDockerImageRepository());

    boolean bDeleted = client.imageStreams().inNamespace(currentNamespace).withName("example-camel-cdi").delete();
    assertTrue(bDeleted);
  }
}
