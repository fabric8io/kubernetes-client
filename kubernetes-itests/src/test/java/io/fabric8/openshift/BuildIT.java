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

package io.fabric8.openshift;

import io.fabric8.junit.jupiter.api.KubernetesTest;
import io.fabric8.junit.jupiter.api.RequireK8sSupport;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigBuilder;
import io.fabric8.openshift.api.model.BuildOutputBuilder;
import io.fabric8.openshift.api.model.BuildStrategyBuilder;
import io.fabric8.openshift.api.model.ImageStream;
import io.fabric8.openshift.api.model.ImageStreamBuilder;
import io.fabric8.openshift.api.model.SourceBuildStrategyBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@KubernetesTest(createEphemeralNamespace = false)
@RequireK8sSupport(Build.class)
class BuildIT {

  @TempDir
  private Path tempDir;
  private String imageStreamName;
  private String imageStreamTag;
  private String buildConfigName;
  private String buildName;
  OpenShiftClient client;

  @BeforeEach
  void setUp() {
    final String id = UUID.randomUUID().toString().replace("-", "");
    imageStreamName = id + "-is";
    imageStreamTag = imageStreamName + ":latest";
    buildConfigName = id + "-bc";
    buildName = id + "-s2i";
  }

  @AfterEach
  void tearDown() {
    client.builds().withName(buildName).withGracePeriod(0L).delete();
    client.buildConfigs().withName(buildConfigName).withGracePeriod(0L).delete();
    client.imageStreams().withName(imageStreamName).withGracePeriod(0L).delete();
  }

  @ParameterizedTest(name = "OpenShift build from file of size {0} bytes builds ImageStream")
  @ValueSource(ints = {
      1024,
      10485760//, 314572800 // Big file to test-drive upload timeout (disabled for CI)
  })
  void buildImage(int archiveSize) throws IOException {
    // Given
    final BuildConfig buildConfig = new BuildConfigBuilder()
        .withNewMetadata().withName(buildConfigName).endMetadata()
        .withNewSpec()
        .withNewSource().withType("Binary").endSource()
        .withStrategy(new BuildStrategyBuilder()
            .withType("Source")
            .withSourceStrategy(new SourceBuildStrategyBuilder()
                .withFrom(new ObjectReferenceBuilder()
                    .withKind("DockerImage")
                    .withName("quay.io/jkube/jkube-java:0.0.17")
                    .build())
                .build())
            .build())
        .withOutput(new BuildOutputBuilder()
            .withTo(new ObjectReferenceBuilder()
                .withKind("ImageStreamTag")
                .withName(imageStreamTag)
                .build())
            .build())
        .endSpec().build();
    final ImageStream is = new ImageStreamBuilder()
        .withNewMetadata().withName(imageStreamName).endMetadata()
        .withNewSpec().withNewLookupPolicy().withLocal(true).endLookupPolicy().endSpec()
        .build();
    client.resourceList(buildConfig, is).create();
    // When
    final Build build = client.buildConfigs().withName(buildConfigName).instantiateBinary()
        .fromFile(prepareTarFile(archiveSize));
    // Then
    client.pods().withName(build.getMetadata().getName() + "-build")
        .waitUntilReady(60, TimeUnit.SECONDS);
    final Pod buildPod = client.pods()
        .waitUntilCondition(pod -> !pod.getStatus().getPhase().equals("Running"), 60, TimeUnit.SECONDS);
    assertThat(buildPod)
        .hasFieldOrPropertyWithValue("status.phase", "Succeeded");
  }

  private File prepareTarFile(int size) throws IOException {
    final File tarFile = tempDir.resolve("test-" + size + ".tar").toFile();
    try (FileOutputStream fos = new FileOutputStream(tarFile);
        TarArchiveOutputStream tarArchiveOutputStream = new TarArchiveOutputStream(fos)) {
      tarArchiveOutputStream.setBigNumberMode(TarArchiveOutputStream.BIGNUMBER_POSIX);
      tarArchiveOutputStream.setLongFileMode(TarArchiveOutputStream.LONGFILE_POSIX);
      final TarArchiveEntry file = new TarArchiveEntry("deployments/file.txt");
      file.setMode(TarArchiveEntry.DEFAULT_FILE_MODE);
      file.setSize(size);
      tarArchiveOutputStream.putArchiveEntry(file);
      tarArchiveOutputStream.write(new byte[(int) size]);
      tarArchiveOutputStream.closeArchiveEntry();

    }
    return tarFile;
  }
}
