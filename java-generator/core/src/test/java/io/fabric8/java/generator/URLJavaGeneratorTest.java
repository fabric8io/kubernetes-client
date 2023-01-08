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
package io.fabric8.java.generator;

import io.fabric8.java.generator.exceptions.JavaGeneratorException;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.mockwebserver.DefaultMockServer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class URLJavaGeneratorTest {

  @TempDir
  private File downloadLocation;
  @TempDir
  private File outputLocation;

  @Test
  void nullUrlsThrowsException() {
    final URLJavaGenerator generator = new URLJavaGenerator(new Config(), null, downloadLocation);
    assertThatThrownBy(() -> generator.run(outputLocation))
        .isInstanceOf(JavaGeneratorException.class)
        .hasMessage("No URLs provided");
  }

  @Test
  void emptyUrlsThrowsException() {
    final URLJavaGenerator generator = new URLJavaGenerator(new Config(), Collections.emptyList(), downloadLocation);
    assertThatThrownBy(() -> generator.run(outputLocation))
        .isInstanceOf(JavaGeneratorException.class)
        .hasMessage("No URLs provided");
  }

  @Test
  void nullDirectoryThrowsException() throws IOException {
    final List<URL> urls = Collections.singletonList(new URL("https://www.example.com"));
    final URLJavaGenerator generator = new URLJavaGenerator(new Config(), urls, null);
    assertThatThrownBy(() -> generator.run(outputLocation))
        .isInstanceOf(JavaGeneratorException.class)
        .hasMessage("Download directory is required");
  }

  @Test
  void directoryIsInvalidThrowsException() throws IOException {
    final File invalidDirectory = Files.createTempFile(downloadLocation.toPath(), "invalid", "file")
        .toFile();
    final List<URL> urls = Collections.singletonList(new URL("https://www.example.com"));
    final URLJavaGenerator generator = new URLJavaGenerator(new Config(), urls, invalidDirectory);
    assertThatThrownBy(() -> generator.run(outputLocation))
        .isInstanceOf(JavaGeneratorException.class)
        .hasMessageStartingWith("Download directory")
        .hasMessageEndingWith("file is not a valid directory");
  }

  @Test
  void downloadsFileAndGeneratesJavaClasses() throws IOException {
    final DefaultMockServer server = new DefaultMockServer();
    try {
      server.start();
      server.expect().withPath("/cert-manager-crd.yml")
          .andReturn(200, Serialization.unmarshal(URLJavaGeneratorTest.class.getResourceAsStream("/cert-manager-crd.yml")))
          .always();
      final URLJavaGenerator generator = new URLJavaGenerator(new Config(),
          Collections.singletonList(new URL(server.url("/cert-manager-crd.yml"))), downloadLocation);
      generator.run(outputLocation);
      assertThat(new File(downloadLocation, "cert-manager-crd.yml"))
          .isFile().exists().isNotEmpty();
      assertThat(outputLocation.toPath().resolve("io").resolve("cert_manager").resolve("v1").resolve("CertificateRequest.java"))
          .exists()
          .isNotEmptyFile();
    } finally {
      server.shutdown();
    }
  }
}
