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

import io.fabric8.commons.ClusterEntity;
import io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequest;
import io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestBuilder;
import io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(ArquillianConditionalRunner.class)
@Ignore
@RequiresKubernetes
public class CertificateSigningRequestIT {
  @ArquillianResource
  KubernetesClient client;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(CertificateSigningRequestIT.class.getResourceAsStream("/certificatesigningrequest-it.yml"));
  }

  @Test
  public void get() {
    CertificateSigningRequest certificateSigningRequest = client.certificates().v1beta1().certificateSigningRequests().withName("csr-get").get();
    assertThat(certificateSigningRequest).isNotNull();
  }

  @Test
  public void list() {
    CertificateSigningRequestList certificateSigningRequestList = client.certificates().v1beta1().certificateSigningRequests().list();
    assertNotNull(certificateSigningRequestList);
    assertTrue(certificateSigningRequestList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    CertificateSigningRequest certificateSigningRequest = client.certificates().v1beta1().certificateSigningRequests().withName("csr-update").edit(c -> new CertificateSigningRequestBuilder(c)
      .editOrNewMetadata().addToAnnotations("foo", "bar").endMetadata().build());

    assertNotNull(certificateSigningRequest);
    assertEquals("bar", certificateSigningRequest.getMetadata().getAnnotations().get("foo"));
  }

  @Test
  public void delete() {
    assertTrue(client.certificates().v1beta1().certificateSigningRequests().withName("csr-delete").delete());
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(CertificateSigningRequestIT.class.getResourceAsStream("/certificatesigningrequest-it.yml"));
  }
}
