package io.fabric8.kubeapitest.kubeconfig;

import org.junit.jupiter.api.Test;

import io.fabric8.kubeapitest.cert.CertManager;

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
