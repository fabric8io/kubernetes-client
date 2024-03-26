/*
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
package io.fabric8.crd.generator;

import io.fabric8.crd.example.k8svalidation.K8sValidation;
import io.fabric8.crd.example.multiple.v2.MultipleSpec;
import io.fabric8.crd.example.nonconversion.NoneConversionExample;
import io.fabric8.crd.example.webhookconversion.v1.WebhookConversionExample;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import org.junit.jupiter.api.Test;

import static io.fabric8.crd.generator.CRDGeneratorAssertions.assertCRDOutputEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CRDGeneratorExamplesTest {

  protected boolean parallelCRDGeneration;

  @Test
  void multiple() {
    assertCRDOutputEquals(newCRDGenerator(),
        io.fabric8.crd.example.multiple.v1.Multiple.class, io.fabric8.crd.example.multiple.v2.Multiple.class);
  }

  @Group("sample.fabric8.io")
  @Version(value = "v3")
  public static class Multiple extends CustomResource<MultipleSpec, Void> {
  }

  @Test
  void multipleStorage_thenFail() {
    CRDGenerator crdGenerator = newCRDGenerator();
    assertThrows(IllegalStateException.class, () -> assertCRDOutputEquals(crdGenerator,
        io.fabric8.crd.example.multiple.v2.Multiple.class, Multiple.class));
  }

  @Test
  void k8sValidation() {
    assertCRDOutputEquals(newCRDGenerator(), K8sValidation.class);
  }

  @Test
  void webhookConversion() {
    assertCRDOutputEquals(newCRDGenerator(),
        WebhookConversionExample.class, io.fabric8.crd.example.webhookconversion.v2.WebhookConversionExample.class);
  }

  @Test
  void noneConversion() {
    assertCRDOutputEquals(newCRDGenerator(), NoneConversionExample.class);
  }

  private CRDGenerator newCRDGenerator() {
    return new CRDGenerator()
        .withParallelGenerationEnabled(parallelCRDGeneration);
  }

}
