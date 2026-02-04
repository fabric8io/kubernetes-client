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
package io.fabric8.kubeapitest.junit;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.admission.v1.AdmissionRequest;
import io.fabric8.kubernetes.api.model.admission.v1.AdmissionReview;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.mockwebserver.MockServerException;
import io.fabric8.mockwebserver.http.MockResponse;
import io.fabric8.mockwebserver.http.RecordedRequest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Objects;

/**
 * Utility methods for webhook testing.
 * These methods help with common webhook operations like parsing requests and creating responses.
 */
public final class WebhookServerUtils {

  private WebhookServerUtils() {
    // Utility class
  }

  /**
   * Creates a JSON MockResponse from an object.
   *
   * @param responseObject the object to serialize as JSON
   * @return a MockResponse with JSON content type and serialized body
   */
  public static MockResponse createJsonResponse(Object responseObject) {
    return new MockResponse()
        .setResponseCode(200)
        .setHeader("Content-Type", "application/json")
        .setBody(Serialization.asJson(responseObject));
  }

  /**
   * Extracts the resource object from an AdmissionRequest, handling DELETE operations.
   *
   * @param admissionRequest the admission request
   * @return the resource object (oldObject for DELETE, object for other operations)
   */
  public static Object getResourceFromAdmissionRequest(AdmissionRequest admissionRequest) {
    return Objects.equals("DELETE", admissionRequest.getOperation())
        ? admissionRequest.getOldObject()
        : admissionRequest.getObject();
  }

  /**
   * Deserializes an AdmissionReview from the request body.
   *
   * @param request the recorded HTTP request
   * @return the deserialized AdmissionReview
   */
  public static AdmissionReview parseAdmissionReview(RecordedRequest request) {
    String body = request.getUtf8Body();
    return Serialization.unmarshal(body, AdmissionReview.class);
  }

  /**
   * Casts a resource to HasMetadata if possible.
   *
   * @param resource the resource object
   * @return the resource as HasMetadata, or null if not applicable
   */
  public static HasMetadata asHasMetadata(Object resource) {
    return resource instanceof HasMetadata ? (HasMetadata) resource : null;
  }

  /**
   * Reads the certificate from file and returns it as a Base64-encoded string
   * suitable for use in webhook configurations.
   *
   * @param certFile the certificate file
   * @return Base64-encoded certificate string
   */
  public static String getEncodedCertificate(File certFile) {
    try {
      String cert = Files.readString(certFile.toPath(), StandardCharsets.UTF_8);
      return Base64.getEncoder().encodeToString(cert.getBytes(StandardCharsets.UTF_8));
    } catch (IOException e) {
      throw new MockServerException("Failed to read certificate file: " + certFile, e);
    }
  }
}
