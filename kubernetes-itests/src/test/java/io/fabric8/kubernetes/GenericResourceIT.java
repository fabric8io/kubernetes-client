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

package io.fabric8.kubernetes;

import io.fabric8.commons.AssumingK8sVersionAtLeast;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceList;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.Resource;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class GenericResourceIT {

  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @ClassRule
  public static final AssumingK8sVersionAtLeast assumingK8sVersion =
    new AssumingK8sVersionAtLeast("1", "16");

  @Test
  public void testGenericBuiltinResourceWithoutMetadata() {
    GenericKubernetesResource configMap = new GenericKubernetesResource();
    configMap.setKind("ConfigMap");
    configMap.setApiVersion("v1");
    configMap.setMetadata(new ObjectMetaBuilder().withName("my-map").build());
    NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<GenericKubernetesResource> resource = client.resource(configMap);
    GenericKubernetesResource result = resource.createOrReplace();
    assertNotNull(result);

    MixedOperation<GenericKubernetesResource, GenericKubernetesResourceList, Resource<GenericKubernetesResource>> resources =
        client.genericKubernetesResources("v1", "ConfigMap");
    assertTrue(!resources.list().getItems().isEmpty());
  }

  @Test
  public void testGenericCustomResourceWithoutMetadata() {
    CustomResourceDefinition crd1 = client.apiextensions().v1().customResourceDefinitions().createOrReplace(CustomResourceDefinitionIT.createCRD());

    assertThat(crd1).isNotNull();

    GenericKubernetesResource itest = new GenericKubernetesResource();
    itest.setKind("Itest");
    itest.setApiVersion("examples.fabric8.io/v1");
    itest.setMetadata(new ObjectMetaBuilder().withName("my-itest").build());

    NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<GenericKubernetesResource> resource = client.resource(itest);

    GenericKubernetesResource result = resource.createOrReplace();
    assertNotNull(result);
  }

}
