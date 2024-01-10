package io.javaoperatorsdk.jenvtest.kubeconfig;

import org.junit.jupiter.api.Test;

import io.javaoperatorsdk.jenvtest.cert.CertManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class KubeConfigTest {

  public static final String API_CERT_PATH = "~/.jenvtest/certpath";
  public static final String CLIENT_KEY_PATH = "~/.jenvtest/clientcertkey";
  public static final String CLIENT_CERT_PATH = "~/.jenvtest/clientcertpath";
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
