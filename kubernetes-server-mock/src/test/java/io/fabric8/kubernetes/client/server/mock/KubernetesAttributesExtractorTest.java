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
package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.mockwebserver.crud.Attribute;
import io.fabric8.mockwebserver.crud.AttributeSet;
import org.junit.Assert;
import org.junit.Test;


public class KubernetesAttributesExtractorTest {

  @Test
  public void shouldHandleNamespacedPath() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    AttributeSet attributes = extractor.extract("/api/v1/namespaces/myns/pods/mypod");

    AttributeSet expected = new AttributeSet();
    expected.add(new Attribute("kind", "pod"));
    expected.add(new Attribute("namespace", "myns"));
    expected.add(new Attribute("name", "mypod"));
    Assert.assertTrue(attributes.matches(expected));
  }

  @Test
  public void shouldHandleNonNamespacedPath() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    AttributeSet attributes = extractor.extract("/api/v1/nodes/mynode");

    AttributeSet expected = new AttributeSet();
    expected.add(new Attribute("kind", "node"));
    expected.add(new Attribute("name", "mynode"));
    Assert.assertTrue(attributes.matches(expected));
  }



  @Test
  public void shouldHandleResource() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    Pod pod = new PodBuilder().withNewMetadata().withName("mypod").withNamespace("myns").endMetadata().build();

    AttributeSet attributes = extractor.extract(pod);

    AttributeSet expected = new AttributeSet();
    expected.add(new Attribute("kind", "pod"));
    expected.add(new Attribute("namespace", "myns"));
    expected.add(new Attribute("name", "mypod"));
    Assert.assertTrue(attributes.matches(expected));

  }
}
