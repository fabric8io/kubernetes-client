package io.fabric8.kubeapitest.cert;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CertManagerTest {

  File certsDir = new File("target", "certs");
  CertManager certManager = new CertManager(certsDir.getPath());

  @BeforeEach
  void cleanup() throws IOException {
    if (!certsDir.mkdirs()) {
      throw new IllegalStateException("Cannot create test dir");
    }
    if (certsDir.exists()) {
      FileUtils.cleanDirectory(certsDir);
    }
  }

  @Test
  void generatesCertificates() throws IOException {

    certManager.createCertificatesIfNeeded();

    var files = List.of(certsDir.list());
    assertThat(files.size()).isEqualTo(4);
  }

}
