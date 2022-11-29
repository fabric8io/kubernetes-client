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
package io.fabric8.kubernetes.api.model.batch.v1;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JobTest {
  @Test
  public void testBuilder() {
    final Job job = new JobBuilder()
        .withApiVersion("batch/v1")
        .withNewMetadata()
        .withName("pi")
        .withLabels(Collections.singletonMap("label1", "maximum-length-of-63-characters"))
        .withAnnotations(Collections.singletonMap("annotation1", "some-very-long-annotation"))
        .endMetadata()
        .withNewSpec()
        .withNewTemplate()
        .withNewSpec()
        .addNewContainer()
        .withName("pi")
        .withImage("perl")
        .withArgs("perl", "-Mbignum=bpi", "-wle", "print bpi(2000)")
        .endContainer()
        .withRestartPolicy("Never")
        .endSpec()
        .endTemplate()
        .endSpec()
        .build();

    assertEquals("pi", job.getMetadata().getName());
    assertEquals(1, job.getSpec().getTemplate().getSpec().getContainers().size());
  }
}
