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
package io.fabric8.kubernetes.karaf.itests;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.features;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class KubernetesDeserializerTest extends TestBase {

  @Inject
  KubernetesClient kubernetesClient;

  @Inject
  OpenShiftClient openShiftClient;

  @Test
  public void canDeserializeModelsFromDifferentKubernetesModules() {
    // When
    final List<HasMetadata> result = kubernetesClient.load(
      KubernetesDeserializerTest.class.getResourceAsStream("/deserializer_test.yaml")
    ).get();
    // Then
    assertEquals(22, result.size());
  }

  @Test
  public void canDeserializeModelsFromDifferentOpenShiftModules() {
    // When
    final List<HasMetadata> result = openShiftClient.load(
      KubernetesDeserializerTest.class.getResourceAsStream("/deserializer_openshift_test.yaml")
    ).get();
    // Then
    assertEquals(8, result.size());
  }

  @Configuration
  public Option[] config() {
    return baseConfiguration(
      features(getFeaturesFile().toURI().toString(), "scr", "openshift-client")
    );
  }
}
