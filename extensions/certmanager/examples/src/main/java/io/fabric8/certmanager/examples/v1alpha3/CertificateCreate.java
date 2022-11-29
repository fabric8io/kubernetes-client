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
package io.fabric8.certmanager.examples.v1alpha3;

import io.fabric8.certmanager.api.model.v1alpha3.Certificate;
import io.fabric8.certmanager.api.model.v1alpha3.CertificateBuilder;
import io.fabric8.certmanager.api.model.v1alpha3.CertificateList;
import io.fabric8.certmanager.client.DefaultCertManagerClient;
import io.fabric8.certmanager.client.NamespacedCertManagerClient;

public class CertificateCreate {
  public static void main(String[] args) {
    try (NamespacedCertManagerClient certManagerClient = new DefaultCertManagerClient()) {
      String namespace = "default";

      Certificate certificate = new CertificateBuilder()
          .build();

      // Create Certificate
      certManagerClient.v1alpha3().certificates().inNamespace(namespace).create(certificate);
      System.out.println("Created: " + certificate.getMetadata().getName());

      // List Certificate
      CertificateList certificateList = certManagerClient.v1alpha3().certificates().inNamespace(namespace).list();
      System.out.println("There are " + certificateList.getItems().size() + " TaskRun objects in " + namespace);
    }
  }
}
