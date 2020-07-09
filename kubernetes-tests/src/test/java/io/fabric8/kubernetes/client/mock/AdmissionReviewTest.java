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

import io.fabric8.kubernetes.api.model.PodExecOptions;
import io.fabric8.kubernetes.api.model.admission.AdmissionReview;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdmissionReviewTest {
  @Test
  @DisplayName("Should be able to deserialize from AdmissionRequest option set to CreateOption")
  void testJacksonParsingWithCreateOptions() {
    InputStream jsonStream = getClass().getResourceAsStream("/admissionreview.json");
    AdmissionReview admissionReview = Serialization.unmarshal(jsonStream, AdmissionReview.class);
    assertEquals("CREATE", admissionReview.getRequest().getOperation());
    assertRequest(admissionReview);
  }

  @Test
  @DisplayName("Should be able to deserialize from AdmissionRequest option set to UpdateOption")
  void testJacksonParsingWithUpdateOptions() {
    InputStream jsonStream = getClass().getResourceAsStream("/admissionreview-withupdateoptions.json");
    AdmissionReview admissionReview = Serialization.unmarshal(jsonStream, AdmissionReview.class);
    assertEquals("UPDATE", admissionReview.getRequest().getOperation());
    assertRequest(admissionReview);
  }

  @Test
  @DisplayName("Should be able to deserialize from AdmissionRequest option set to PatchOption")
  void testJacksonParsingWithPathOptions() {
    InputStream jsonStream = getClass().getResourceAsStream("/admissionreview-withpatchoptions.json");
    AdmissionReview admissionReview = Serialization.unmarshal(jsonStream, AdmissionReview.class);
    assertEquals("PATCH", admissionReview.getRequest().getOperation());
    assertRequest(admissionReview);
  }

  @Test
  @DisplayName("Should be able to deserialize from AdmissionRequest object set to PodExecOptions")
  void testJacksonParsingWithPodExecOptions() {
    InputStream jsonStream = getClass().getResourceAsStream("/admissionreview-withconnectexec.json");
    AdmissionReview admissionReview = Serialization.unmarshal(jsonStream, AdmissionReview.class);
    assertEquals("CONNECT", admissionReview.getRequest().getOperation());
    PodExecOptions podExecOptions = (PodExecOptions) admissionReview.getRequest().getObject();
    assertEquals("PodExecOptions", podExecOptions.getKind());
    assertEquals("myContainer", podExecOptions.getContainer());
    assertRequest(admissionReview);
  }

  private void assertRequest(AdmissionReview admissionReview) {
    assertEquals("myNamespace", admissionReview.getRequest().getNamespace());
    assertEquals("66105089-3471-46ff-b4c8-293546c2aa6c", admissionReview.getRequest().getUid());
    assertEquals("III#John.Doe@something.com", admissionReview.getRequest().getUserInfo().getUsername());
    assertEquals(Collections.singletonList("Group2"), admissionReview.getRequest().getUserInfo().getGroups());
  }
}
