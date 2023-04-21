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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequest;
import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestBuilder;
import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestList;
import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestListBuilder;
import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestStatus;
import io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestStatusBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableKubernetesMockClient
class V1CertificateSigningRequestTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void testLoad() {
    // When
    List<HasMetadata> resources = client.load(getClass().getResourceAsStream("/test-v1-csr.yml")).items();

    // Then
    assertThat(resources).hasSize(1);
    assertThat(resources.get(0)).isInstanceOf(CertificateSigningRequest.class);
  }

  @Test
  void testCreate() {
    // Given
    String name = "test-k8s-csr";
    CertificateSigningRequest csr = getCertificateSigningRequest(name);
    server.expect().post().withPath("/apis/certificates.k8s.io/v1/certificatesigningrequests")
        .andReturn(HttpURLConnection.HTTP_OK, csr)
        .once();

    // When
    csr = client.certificates().v1().certificateSigningRequests().create(csr);

    // Then
    assertThat(csr).isNotNull();
    assertThat(csr.getMetadata().getName()).isEqualTo(name);
  }

  private CertificateSigningRequest getCertificateSigningRequest(String name) {
    return new CertificateSigningRequestBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .addToGroups("system:authenticated")
        .withRequest(
            "RSBSRVFVRVNULS0tLS0KTUlJRWJqQ0NBbFlDQVFBd0tURVBNQTBHQTFVRUF3d0dhMmxrYjI1bk1SWXdGQVlEVlFRS0RBMWtZWFJoTFdWdQpaMmx1WldWeU1JSUNJakFOQmdrcWhraUc5dzBCQVFFRkFBT0NBZzhBTUlJQ0NnS0NBZ0VBc2dVZXl0S0F6ZDkyClN1S2pZL1RqbmRsZ0lkSFVVYWFxbHJIVW1nbTloKzY2RTJCNGs0TSt6Q0tOQmovemlMdWV6NFNUeHJ6SFk3RlUKNGUxWElBU3lMS0dmRGNPaks5NThURThwcXBRM21VdlpWMmxnK25BTVF5dlZUYWdZSmFId2JWUzVlNHgvRmpKcQoxTWpQZ1VoSGFXeEdIYTQrQnZYQU9Kdk5BdnV4alpZaVJET251dGxHVzloQkRKRlhoUk5jOGFKNnFiZWVBWnNiCmozWUFMaUcydWp1VmhoTUVRNEJxdFVHVGZCMzBQNGhRK2t2bWVKc2ZUU3Vsb2xiWFdIdVZGWnh1d0FJek5RbmQKMTd4VHd2cU04OGZFb3ZJazBJV0ZCWTk2aHRvaUVNdThZUms4SEZ6QkJralhsZGlkbVNNSHkwK0plcFRONmdQTQpEYVVsd1cxS0lCcW9TbnZNcjY4cFRVWEVhZVRjc040anMxTUIwK3FwR0JBS1puWWVxM0JmMkxVVFBNaG1VZ2VVCmFUTFlqODI2WVorZjJrOWJ1cngwK1NOSmVZbWoxVTl0N3A2YWM0dDIzZHVYQ1BzYkNrUFNKeGtrU3dudUlVVzkKdmJVVGtJNGtVMlFVMnE0NzRaMW1uMlkvejF2TEdQdEpsTDFYUVFVNEdsb2hrQkVkM1BsUTRtOGU1WGZSRkV6ZgpYZnhMRXFRczFTeEg1ekhjcnVaOWxJdnBkeEw5Tkc5WlR6M0tmT0tIbCtSUzdxMGdKaExac0RubUJKNXZab3p4CldXci9IRW9PamFYbGh0VitDN3M4TUg5Y0lKZENZNnpjcFVrZis1NmZ0Z1FuN0YrT1RYdDI0UVJQYWNFZnRFOTkKVERPb2luTGtOMm1kckxiMTgxQUZNUWJ0bTFLc1k2MENBd0VBQWFBQU1BMEdDU3FHU0liM0RRRUJDd1VBQTRJQwpBUUNQYU1WdDd4YWhkZlF1L1BySFVTTW5LK2I0SlJScEdEYlpWUXk4aUtkSmdHM0VrYnNBZ21qQmN4Q1IvL2t1CkVhU0plSGNWK20xVlFUTEp1ZFU3ZHFUeFBLOVFCNlB2aHlBbCttNnFaQkt1Q25VM1BKc2k5azBYSE5GWXBqRmYKVFNwTlpJSnRuanVEQWVtT05kcjJYMm1rODZmSmpWTEUvYnA1KzM5dFBkN0xjL3dZR2JoRU0xcExtUGpQK0Z6eQpzZnBiYW5PcmZFSG5NMmlsRFpGZURVSEpYL3F5Ykt1RC9BRmdoZk1Ua0x3ODNLNkNRdCtDQm05djRCeEtCS2xqCkdBWEQyUEhUTWlzektUbGpBM3czYUphanZzU0FwQXFCWnFocjB3QzdOb1dYM1h6S0p3ck9MaWVxemo3SXlpUGEKTEI5SmJveFpOQTdBSU5ucEdsa1hDZlRGT2RManZtQkVRQXV5Ym9wLzdqV2RiSzJHRkZKS2UwdlVlbWNUeGdHVwp5c0ZyV2pqMUlvdVBVNFZ6ck82QVBVQnZCZUFtdU1Bbm9yVng5emc4akhlT1pkd2RWdFRnOUwrK0VnWjlxK0htCjVtUlJGVHlZOWo4WVVvd2J6TzRlRUZnaVN0di84T1p0YmtOeDFROWFQWHJ3VUV1Q1I0SUthWG0wNlJUYXJOYXUKTWFsbk5oZm9WYi9Bc1R5d1ArNlc1dGErcTBpckR5cnVkZk5pRkFWbkRMZEU5a2hWZzVrU0lPRzhYbEZUMklwSQpkdVNpcUl0NlNUTlY3UmdaRzBGTFN5akxoc3laWnY2bitpUzl3Ky9OOFpoUzgvalViUUVidG1VTnNJU3Z5WS9JCmZqcHNZQUdleExvVW5mN2pDaUhkbTVhSnJ5SU1kdmZ2akJsMDhIVk5nWG1McVE9PQotLS0tLUVORCBDRVJUSUZJQ0FURSBSRVFVRVNULS0tLS0K")
        .addToUsages("client auth")
        .endSpec()
        .build();
  }

  @Test
  void get() {
    // Given
    String name = "test-k8s-csr";
    CertificateSigningRequest csr = getCertificateSigningRequest(name);
    server.expect().get().withPath("/apis/certificates.k8s.io/v1/certificatesigningrequests/" + name)
        .andReturn(HttpURLConnection.HTTP_OK, csr)
        .once();

    // When
    csr = client.certificates().v1().certificateSigningRequests().withName(name).get();

    // Then
    assertThat(csr).isNotNull();
    assertThat(csr.getMetadata().getName()).isEqualTo(name);
  }

  @Test
  void list() {
    // Given
    String name = "test-k8s-csr";
    server.expect().get().withPath("/apis/certificates.k8s.io/v1/certificatesigningrequests")
        .andReturn(HttpURLConnection.HTTP_OK,
            new CertificateSigningRequestListBuilder().withItems(getCertificateSigningRequest(name)).build())
        .once();

    // When
    CertificateSigningRequestList csrList = client.certificates().v1().certificateSigningRequests().list();

    // Then
    assertThat(csrList).isNotNull();
    assertThat(csrList.getItems()).hasSize(1);
    assertThat(csrList.getItems().get(0).getMetadata().getName()).isEqualTo(name);
  }

  @Test
  void delete() {
    // Given
    String name = "test-k8s-csr";
    CertificateSigningRequest csr = getCertificateSigningRequest(name);
    server.expect().delete().withPath("/apis/certificates.k8s.io/v1/certificatesigningrequests/" + name)
        .andReturn(HttpURLConnection.HTTP_OK, csr)
        .once();

    // When
    boolean isDeleted = client.certificates().v1().certificateSigningRequests().withName(name).delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  @Test
  void testApprove() {
    // Given
    server.expect().get().withPath("/apis/certificates.k8s.io/v1/certificatesigningrequests/my-cert")
        .andReturn(HttpURLConnection.HTTP_OK, createCertificateSigningRequest().build())
        .once();

    server.expect().put().withPath("/apis/certificates.k8s.io/v1/certificatesigningrequests/my-cert/approval")
        .andReturn(HttpURLConnection.HTTP_OK, createCertificateSigningRequest()
            .withStatus(createCertificateSigninigRequestStatus("Approved")).build())
        .once();

    // When
    CertificateSigningRequest updatedCsr = client.certificates().v1().certificateSigningRequests().withName("my-cert")
        .approve();

    // Then
    assertNotNull(updatedCsr);
    assertFalse(updatedCsr.getStatus().getConditions().isEmpty());
    assertEquals("Approved", updatedCsr.getStatus().getConditions().get(0).getType());
  }

  @Test
  void testDeny() {
    // Given
    server.expect().get().withPath("/apis/certificates.k8s.io/v1/certificatesigningrequests/my-cert")
        .andReturn(HttpURLConnection.HTTP_OK, createCertificateSigningRequest().build())
        .once();

    server.expect().put().withPath("/apis/certificates.k8s.io/v1/certificatesigningrequests/my-cert/approval")
        .andReturn(HttpURLConnection.HTTP_OK,
            createCertificateSigningRequest().withStatus(createCertificateSigninigRequestStatus("Denied")).build())
        .once();

    // When
    CertificateSigningRequest updatedCsr = client.certificates().v1().certificateSigningRequests().withName("my-cert").deny();

    // Then
    assertNotNull(updatedCsr);
    assertFalse(updatedCsr.getStatus().getConditions().isEmpty());
    assertEquals("Denied", updatedCsr.getStatus().getConditions().get(0).getType());
  }

  private CertificateSigningRequestBuilder createCertificateSigningRequest() {
    return new CertificateSigningRequestBuilder()
        .withNewMetadata().withName("my-cert").withResourceVersion("1").endMetadata()
        .withNewSpec()
        .withSignerName("fabric8io.com/kubernetes-java-client")
        .addToGroups("system:authenticated")
        .withRequest(
            "LS0tLS1CRUdJTiBDRVJUSUZJQ0FURSBSRVFVRVNULS0tLS0KTUlJRWJqQ0NBbFlDQVFBd0tURVBNQTBHQTFVRUF3d0dhMmxrYjI1bk1SWXdGQVlEVlFRS0RBMWtZWFJoTFdWdQpaMmx1WldWeU1JSUNJakFOQmdrcWhraUc5dzBCQVFFRkFBT0NBZzhBTUlJQ0NnS0NBZ0VBc2dVZXl0S0F6ZDkyClN1S2pZL1RqbmRsZ0lkSFVVYWFxbHJIVW1nbTloKzY2RTJCNGs0TSt6Q0tOQmovemlMdWV6NFNUeHJ6SFk3RlUKNGUxWElBU3lMS0dmRGNPaks5NThURThwcXBRM21VdlpWMmxnK25BTVF5dlZUYWdZSmFId2JWUzVlNHgvRmpKcQoxTWpQZ1VoSGFXeEdIYTQrQnZYQU9Kdk5BdnV4alpZaVJET251dGxHVzloQkRKRlhoUk5jOGFKNnFiZWVBWnNiCmozWUFMaUcydWp1VmhoTUVRNEJxdFVHVGZCMzBQNGhRK2t2bWVKc2ZUU3Vsb2xiWFdIdVZGWnh1d0FJek5RbmQKMTd4VHd2cU04OGZFb3ZJazBJV0ZCWTk2aHRvaUVNdThZUms4SEZ6QkJralhsZGlkbVNNSHkwK0plcFRONmdQTQpEYVVsd1cxS0lCcW9TbnZNcjY4cFRVWEVhZVRjc040anMxTUIwK3FwR0JBS1puWWVxM0JmMkxVVFBNaG1VZ2VVCmFUTFlqODI2WVorZjJrOWJ1cngwK1NOSmVZbWoxVTl0N3A2YWM0dDIzZHVYQ1BzYkNrUFNKeGtrU3dudUlVVzkKdmJVVGtJNGtVMlFVMnE0NzRaMW1uMlkvejF2TEdQdEpsTDFYUVFVNEdsb2hrQkVkM1BsUTRtOGU1WGZSRkV6ZgpYZnhMRXFRczFTeEg1ekhjcnVaOWxJdnBkeEw5Tkc5WlR6M0tmT0tIbCtSUzdxMGdKaExac0RubUJKNXZab3p4CldXci9IRW9PamFYbGh0VitDN3M4TUg5Y0lKZENZNnpjcFVrZis1NmZ0Z1FuN0YrT1RYdDI0UVJQYWNFZnRFOTkKVERPb2luTGtOMm1kckxiMTgxQUZNUWJ0bTFLc1k2MENBd0VBQWFBQU1BMEdDU3FHU0liM0RRRUJDd1VBQTRJQwpBUUNQYU1WdDd4YWhkZlF1L1BySFVTTW5LK2I0SlJScEdEYlpWUXk4aUtkSmdHM0VrYnNBZ21qQmN4Q1IvL2t1CkVhU0plSGNWK20xVlFUTEp1ZFU3ZHFUeFBLOVFCNlB2aHlBbCttNnFaQkt1Q25VM1BKc2k5azBYSE5GWXBqRmYKVFNwTlpJSnRuanVEQWVtT05kcjJYMm1rODZmSmpWTEUvYnA1KzM5dFBkN0xjL3dZR2JoRU0xcExtUGpQK0Z6eQpzZnBiYW5PcmZFSG5NMmlsRFpGZURVSEpYL3F5Ykt1RC9BRmdoZk1Ua0x3ODNLNkNRdCtDQm05djRCeEtCS2xqCkdBWEQyUEhUTWlzektUbGpBM3czYUphanZzU0FwQXFCWnFocjB3QzdOb1dYM1h6S0p3ck9MaWVxemo3SXlpUGEKTEI5SmJveFpOQTdBSU5ucEdsa1hDZlRGT2RManZtQkVRQXV5Ym9wLzdqV2RiSzJHRkZKS2UwdlVlbWNUeGdHVwp5c0ZyV2pqMUlvdVBVNFZ6ck82QVBVQnZCZUFtdU1Bbm9yVng5emc4akhlT1pkd2RWdFRnOUwrK0VnWjlxK0htCjVtUlJGVHlZOWo4WVVvd2J6TzRlRUZnaVN0di84T1p0YmtOeDFROWFQWHJ3VUV1Q1I0SUthWG0wNlJUYXJOYXUKTWFsbk5oZm9WYi9Bc1R5d1ArNlc1dGErcTBpckR5cnVkZk5pRkFWbkRMZEU5a2hWZzVrU0lPRzhYbEZUMklwSQpkdVNpcUl0NlNUTlY3UmdaRzBGTFN5akxoc3laWnY2bitpUzl3Ky9OOFpoUzgvalViUUVidG1VTnNJU3Z5WS9JCmZqcHNZQUdleExvVW5mN2pDaUhkbTVhSnJ5SU1kdmZ2akJsMDhIVk5nWG1McVE9PQotLS0tLUVORCBDRVJUSUZJQ0FURSBSRVFVRVNULS0tLS0K")
        .withExpirationSeconds(86400)
        .addToUsages("client auth")
        .endSpec();
  }

  private CertificateSigningRequestStatus createCertificateSigninigRequestStatus(String type) {
    return new CertificateSigningRequestStatusBuilder()
        .addNewCondition()
        .withType(type)
        .withStatus("True")
        .withReason(type + "ViaRESTApi")
        .withMessage("This CSR was denied by REST API /approval endpoint.")
        .endCondition()
        .build();
  }
}
