package io.fabric8.kubeapitest.binary.repo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GitHubBinaryRepoTest {

  @Test
  void downloadsIndex() {
    new GitHubBinaryRepo(null).listObjectNames();
  }

  @Test
  void parsesSelfLinkToArchiveDescriptor() {
    var archiveDescriptor = GitHubBinaryRepo
        .mapSelfLinkToArchiveDescriptor(
            "https://github.com/kubernetes-sigs/controller-tools/releases/download/envtest-v1.28.0/envtest-v1.28.0-linux-arm64.tar.gz");

    assertThat(archiveDescriptor.getOs()).isEqualTo("linux");
    assertThat(archiveDescriptor.getArch()).isEqualTo("arm64");
    assertThat(archiveDescriptor.getVersion()).isEqualTo("1.28.0");
  }

}
