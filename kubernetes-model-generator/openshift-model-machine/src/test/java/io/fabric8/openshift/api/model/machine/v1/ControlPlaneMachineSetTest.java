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
package io.fabric8.openshift.api.model.machine.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.model.util.Helper;
import io.fabric8.openshift.api.model.machine.v1alpha1.OpenstackProviderSpec;
import io.fabric8.openshift.api.model.machine.v1alpha1.OpenstackProviderSpecBuilder;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineSpec;
import io.fabric8.openshift.api.model.machine.v1beta1.ProviderSpec;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ControlPlaneMachineSetTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void isNamespaceScoped() {
    assertThat(Namespaced.class.isAssignableFrom(ControlPlaneMachineSet.class)).isTrue();
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    final String originalJson = Helper.loadJson("/test-controlplanemachineset.json");
    // When
    final ControlPlaneMachineSet controlPlaneMachineSet = mapper.readValue(originalJson, ControlPlaneMachineSet.class);
    final String serializedJson = mapper.writeValueAsString(controlPlaneMachineSet);
    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(controlPlaneMachineSet)
        .hasFieldOrPropertyWithValue("metadata.name", "cluster")
        .extracting(ControlPlaneMachineSet::getSpec)
        .hasFieldOrPropertyWithValue("replicas", 3)
        .hasFieldOrPropertyWithValue("selector.matchLabels",
            Collections.singletonMap("machine.openshift.io/cluster-api-machine-type", "master"))
        .hasFieldOrPropertyWithValue("state", "Active")
        .extracting(ControlPlaneMachineSetSpec::getTemplate)
        .hasFieldOrPropertyWithValue("machineType", "machines_v1beta1_machine_openshift_io")
        .extracting(ControlPlaneMachineSetTemplate::getMachines_v1beta1_machine_openshift_io)
        .hasFieldOrPropertyWithValue("failureDomains.openstack",
            Collections.singletonList(new OpenStackFailureDomainBuilder()
                .withAvailabilityZone("nova-one")
                .withNewRootVolume()
                .withAvailabilityZone("cinder-one")
                .endRootVolume()
                .build()))
        .hasFieldOrPropertyWithValue("metadata.labels",
            Collections.singletonMap("machine.openshift.io/cluster-api-machine-type", "master"))
        .extracting(OpenShiftMachineV1Beta1MachineTemplate::getSpec)
        .extracting(MachineSpec::getProviderSpec)
        .extracting(ProviderSpec::getValue)
        .hasFieldOrPropertyWithValue("apiVersion",
            "machine.openshift.io/v1alpha1")
        .hasFieldOrPropertyWithValue("kind",
            "OpenstackProviderSpec")
        .hasFieldOrPropertyWithValue("cloudName",
            "openstack")
        .hasFieldOrPropertyWithValue("cloudsSecret.name",
            "openstack-cloud-credentials")
        .hasFieldOrPropertyWithValue(
            "cloudsSecret.namespace",
            "openshift-machine-api")
        .hasFieldOrPropertyWithValue("flavor", "m1.xlarge")
        .hasFieldOrPropertyWithValue("rootVolume.diskSize", 30)
        .hasFieldOrPropertyWithValue("rootVolume.volumeType", "performance")
        .hasFieldOrPropertyWithValue("serverGroupName", "ocp1-2g2xs-master")
        .hasFieldOrPropertyWithValue("tags",
            Collections.singletonList("openshiftClusterID=ocp1-2g2xs"))
        .hasFieldOrPropertyWithValue("trunk", true)
        .hasFieldOrPropertyWithValue("userDataSecret.name", "master-user-data")
        .satisfies(v -> assertThat(v)
            .extracting("securityGroups")
            .asInstanceOf(InstanceOfAssertFactories.list(String.class))
            .hasSize(1))
        .satisfies(v -> assertThat(v)
            .extracting("networks")
            .asInstanceOf(InstanceOfAssertFactories.list(String.class))
            .hasSize(1));
  }

  @Test
  void builder() {
    // Given
    Map<String, String> matchLabels = new HashMap<>();
    matchLabels.put("machine.openshift.io/cluster-api-machine-role", "master");
    matchLabels.put("machine.openshift.io/cluster-api-machine-type", "master");
    matchLabels.put("machine.openshift.io/cluster-api-cluster", "cluster");
    OpenstackProviderSpec openstackProviderSpec = new OpenstackProviderSpecBuilder()
        .withCloudName("openstack")
        .withFlavor("m1.xlarge")
        .withImage("ocp1-2g2xs-rhcos")
        .withNewCloudsSecret("openstack-cloud-credentials", "openshift-machine-api")
        .addNewNetwork()
        .addNewSubnet()
        .withNewFilter()
        .withName("ocp1-2g2xs-nodes")
        .withTags("openshiftClusterID=ocp1-2g2xs")
        .endFilter()
        .endSubnet()
        .endNetwork()
        .withNewRootVolume()
        .withDiskSize(30)
        .withVolumeType("performance")
        .endRootVolume()
        .addNewSecurityGroup()
        .withName("ocp1-2g2xs-master")
        .endSecurityGroup()
        .withServerGroupName("ocp1-2g2xs-master")
        .addToServerMetadata("ocp1-2g2xs-master", "ocp1-2g2xs")
        .withTags("openshiftClusterID=ocp1-2g2xs")
        .withTrunk(true)
        .withNewUserDataSecret("master-user-data", "test")
        .build();
    //    Map<String, Object> providerValue = mapper.convertValue(openstackProviderSpec, Map.class);
    ControlPlaneMachineSetBuilder controlPlaneMachineSetBuilder = new ControlPlaneMachineSetBuilder()
        .withNewMetadata()
        .withName("cluster")
        .endMetadata()
        .withNewSpec()
        .withReplicas(3)
        .withNewSelector()
        .withMatchLabels(matchLabels)
        .endSelector()
        .withState("Active")
        .withNewTemplate()
        .withMachineType("machines_v1beta1_machine_openshift_io")
        .withNewMachinesV1beta1MachineOpenshiftIo()
        .withNewFailureDomains()
        .addNewOpenstack()
        .withAvailabilityZone("nova-one")
        .withNewRootVolume().withAvailabilityZone("cinder-one").endRootVolume()
        .endOpenstack()
        .withPlatform("OpenStack")
        .endFailureDomains()
        .withNewMetadata()
        .addToLabels(matchLabels)
        .endMetadata()
        .withNewSpec()
        .withNewProviderSpec()
        .withValue(openstackProviderSpec)
        .endProviderSpec()
        .endSpec()
        .endMachinesV1beta1MachineOpenshiftIo()
        .endTemplate()
        .endSpec();
    // When
    ControlPlaneMachineSet controlPlaneMachineSet = controlPlaneMachineSetBuilder.build();
    // Then
    assertThat(controlPlaneMachineSet)
        .hasFieldOrPropertyWithValue("metadata.name", "cluster")
        .extracting(ControlPlaneMachineSet::getSpec)
        .hasFieldOrPropertyWithValue("replicas", 3)
        .hasFieldOrPropertyWithValue("selector.matchLabels", matchLabels)
        .hasFieldOrPropertyWithValue("state", "Active")
        .hasFieldOrPropertyWithValue("template.machineType", "machines_v1beta1_machine_openshift_io")
        .extracting(ControlPlaneMachineSetSpec::getTemplate)
        .extracting(ControlPlaneMachineSetTemplate::getMachines_v1beta1_machine_openshift_io)
        .hasFieldOrPropertyWithValue("failureDomains.openstack",
            Collections.singletonList(new OpenStackFailureDomainBuilder()
                .withAvailabilityZone("nova-one")
                .withNewRootVolume()
                .withAvailabilityZone("cinder-one")
                .endRootVolume()
                .build()))
        .hasFieldOrPropertyWithValue("metadata.labels", matchLabels)
        .extracting(OpenShiftMachineV1Beta1MachineTemplate::getSpec)
        .extracting(MachineSpec::getProviderSpec)
        .extracting(ProviderSpec::getValue)
        .hasFieldOrPropertyWithValue("apiVersion",
            "machine.openshift.io/v1alpha1")
        .hasFieldOrPropertyWithValue("kind", "OpenstackProviderSpec")
        .hasFieldOrPropertyWithValue("cloudName", "openstack")
        .hasFieldOrPropertyWithValue("cloudsSecret.name", "openstack-cloud-credentials")
        .hasFieldOrPropertyWithValue("cloudsSecret.namespace", "openshift-machine-api")
        .hasFieldOrPropertyWithValue("flavor", "m1.xlarge")
        .hasFieldOrPropertyWithValue("rootVolume.diskSize", 30)
        .hasFieldOrPropertyWithValue("rootVolume.volumeType", "performance")
        .hasFieldOrPropertyWithValue("serverGroupName", "ocp1-2g2xs-master")
        .hasFieldOrPropertyWithValue("tags", Collections.singletonList("openshiftClusterID=ocp1-2g2xs"))
        .hasFieldOrPropertyWithValue("trunk", true)
        .hasFieldOrPropertyWithValue("userDataSecret.name",
            "master-user-data")
        .satisfies(v -> assertThat(v)
            .extracting("securityGroups")
            .asInstanceOf(InstanceOfAssertFactories.list(String.class))
            .hasSize(1))
        .satisfies(v -> assertThat(v)
            .extracting("networks")
            .asInstanceOf(InstanceOfAssertFactories.list(String.class))
            .hasSize(1));
  }
}
