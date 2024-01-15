package io.fabric8.kubeapitest.binary;

import org.junit.jupiter.api.Test;

import io.fabric8.kubeapitest.KubeAPITestException;
import io.fabric8.kubeapitest.KubeAPIServerConfigBuilder;

import static org.junit.jupiter.api.Assertions.*;

class BinaryManagerTest {

  @Test
  void throwsExceptionIfBinaryNotPresentAndInOfflineMode() {
    BinaryManager binaryManager = new BinaryManager(KubeAPIServerConfigBuilder.anAPIServerConfig()
        .withOfflineMode(true)
        .withApiServerVersion("1.0.1")
        .build());
    assertThrows(KubeAPITestException.class, binaryManager::initAndDownloadIfRequired);
  }

}
