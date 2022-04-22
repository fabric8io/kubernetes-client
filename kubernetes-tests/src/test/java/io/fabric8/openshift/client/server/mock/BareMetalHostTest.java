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

import io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.BareMetalHost;
import io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.BareMetalHostBuilder;
import io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.BareMetalHostList;
import io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.BareMetalHostListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class BareMetalHostTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/metal3.io/v1alpha1/namespaces/ns1/baremetalhosts/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewBareMetalHost("test-get"))
        .once();

    // When
    BareMetalHost networkAttachmentDefinition = client.bareMetalHosts().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(networkAttachmentDefinition)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/metal3.io/v1alpha1/namespaces/ns1/baremetalhosts")
        .andReturn(HttpURLConnection.HTTP_OK, new BareMetalHostListBuilder()
            .addToItems(createNewBareMetalHost("test-list"))
            .build())
        .once();

    // When
    BareMetalHostList networkAttachmentDefinitionList = client.bareMetalHosts().inNamespace("ns1").list();

    // Then
    assertThat(networkAttachmentDefinitionList).isNotNull();
    assertThat(networkAttachmentDefinitionList.getItems()).hasSize(1);
    assertThat(networkAttachmentDefinitionList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/metal3.io/v1alpha1/namespaces/ns1/baremetalhosts/test-delete")
        .andReturn(HttpURLConnection.HTTP_OK, createNewBareMetalHost("test-delete"))
        .once();

    // When
    boolean isDeleted = client.bareMetalHosts().inNamespace("ns1").withName("test-delete").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private BareMetalHost createNewBareMetalHost(String name) {
    return new BareMetalHostBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withOnline(true)
        .withNewBmc()
        .withAddress("ipmi://192.168.122.1:6233")
        .withCredentialsName("example-baremetalhost-secret-no-password")
        .endBmc()
        .withNewConsumerRef()
        .withApiVersion("machine.openshift.io/v1beta1")
        .withKind("Machine")
        .withName("bmo-master")
        .withNamespace("bmo-project")
        .endConsumerRef()
        .withExternallyProvisioned(true)
        .withNewUserData("bmo-master-user-data", "bmo-project")
        .withNewNetworkData("bmo-master-network-data", "bmo-project")
        .withNewMetaData("bmo-master-meta-data", "bmo-project")
        .withNewRaid()
        .addNewHardwareRAIDVolume()
        .withLevel("1")
        .withSizeGibibytes(200)
        .withRotational(true)
        .endHardwareRAIDVolume()
        .endRaid()
        .withBootMACAddress("98:03:9b:61:80:48")
        .withExternallyProvisioned(true)
        .withHardwareProfile("default")
        .withNewImage()
        .withChecksum("https://172.16.1.100/images/myOSv1/myOS.qcow2.md5sum")
        .withUrl("https://172.16.1.100/images/myOSv1/myOS.qcow2")
        .endImage()
        .endSpec()
        .build();
  }
}
