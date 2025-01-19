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
package io.fabric8.kubeapitest.kubeconfig;

import io.fabric8.kubeapitest.cert.CertManager;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class KubeConfigTest {

  public static final String API_CERT_PATH = "~/.kubeapitest/certpath";
  public static final String CLIENT_KEY_PATH = "~/.kubeapitest/clientcertkey";
  public static final String CLIENT_CERT_PATH = "~/.kubeapitest/clientcertpath";
  public static final int API_SERVER_PORT = 32101;

  CertManager certManagerMock = mock(CertManager.class);
  KubeConfig kubeConfig = new KubeConfig(certManagerMock, null);

  @Test
    void generatesConfigYaml() {
        when(certManagerMock.getAPIServerCertPath()).thenReturn(API_CERT_PATH);
        when(certManagerMock.getClientCertPath()).thenReturn(CLIENT_KEY_PATH);
        when(certManagerMock.getClientKeyPath()).thenReturn(CLIENT_CERT_PATH);

        String yaml = kubeConfig.generateKubeConfigYaml(API_SERVER_PORT);

        assertThat(yaml)
                .contains(""+API_SERVER_PORT)
                .contains(API_CERT_PATH)
                .contains(CLIENT_CERT_PATH)
                .contains(CLIENT_KEY_PATH);
    }

}
