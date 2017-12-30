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
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.openshift.impl.requirement.RequiresOpenshift;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresOpenshift
public class ImageStreamIT {
  @ArquillianResource
  OpenShiftClient client;

  @ArquillianResource
  Session session;

  @Test
  public void testLoad() {
    String currentNamespace = session.getNamespace();
    ImageStream aImageStream = client.imageStreams().inNamespace(currentNamespace)
      .load(getClass().getResourceAsStream("/test-imagestream.yml")).get();
    assertThat(aImageStream).isNotNull();
    assertEquals("my-ruby", aImageStream.getMetadata().getName());
  }

  @Test
  public void testCrud() {
    String currentNamespace = session.getNamespace();
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
