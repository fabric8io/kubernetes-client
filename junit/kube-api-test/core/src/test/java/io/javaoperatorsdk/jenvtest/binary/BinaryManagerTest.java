package io.javaoperatorsdk.jenvtest.binary;

import org.junit.jupiter.api.Test;

import io.javaoperatorsdk.jenvtest.JenvtestException;
import io.javaoperatorsdk.jenvtest.KubeAPIServerConfigBuilder;

import static org.junit.jupiter.api.Assertions.*;

class BinaryManagerTest {

  @Test
  void throwsExceptionIfBinaryNotPresentAndInOfflineMode() {
    BinaryManager binaryManager = new BinaryManager(KubeAPIServerConfigBuilder.anAPIServerConfig()
        .withOfflineMode(true)
        .withApiServerVersion("1.0.1")
        .build());
    assertThrows(JenvtestException.class, binaryManager::initAndDownloadIfRequired);
  }

}
