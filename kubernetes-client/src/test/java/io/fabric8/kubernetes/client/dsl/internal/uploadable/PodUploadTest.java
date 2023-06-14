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
package io.fabric8.kubernetes.client.dsl.internal.uploadable;

import io.fabric8.kubernetes.client.dsl.TtyExecErrorable;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.PodOperationsImpl;
import io.fabric8.kubernetes.client.utils.InputStreamPumper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PodUploadTest {

  private PodOperationsImpl operation;

  @FunctionalInterface
  public interface PodUploadTester<R> {
    R apply() throws IOException, InterruptedException;
  }

  @BeforeEach
  void setUp() {
    this.operation = Mockito.mock(PodOperationsImpl.class, Mockito.RETURNS_DEEP_STUBS);
  }

  @Test
  @DisplayName("With invalid parameters, should throw exception")
  void uploadInvalidParametersShouldThrowException(@TempDir Path pathToUpload) {
    final Path nonExistentPath = pathToUpload.resolve("non-existent");
    assertThatIllegalArgumentException()
        .isThrownBy(() -> PodUpload.upload(operation, nonExistentPath))
        .withMessage("Provided arguments are not valid (file, directory, path)");
  }

  @Test
  void upload_withFile_shouldUploadFile() throws IOException, InterruptedException {
    final Path toUpload = new File(PodUpload.class.getResource("/upload/upload-sample.txt").getFile())
        .toPath();
    uploadFileAndVerify(() -> PodUpload.upload(operation, toUpload), false, 2560);
  }

  @Test
  void uploadFileData_whenByteArrayInputStreamProvided_shouldUploadFile() throws IOException, InterruptedException {
    InputStream inputStream = new ByteArrayInputStream("test data".getBytes());
    uploadFileAndVerify(() -> PodUpload.uploadFileData(operation, inputStream), true, 9);
  }

  @Test
  void upload_withDirectory_shouldUploadDirectory() throws Exception {
    final Path toUpload = new File(PodUpload.class.getResource("/upload").getFile())
        .toPath();
    uploadDirectoryAndVerify(() -> PodUpload.upload(operation, toUpload), 2560);
  }

  @Test
  void upload_withDirectoryAndLongFileNames_shouldUploadDirectory() throws Exception {
    final Path toUpload = new File(PodUpload.class.getResource("/upload_long").getFile())
        .toPath();
    uploadDirectoryAndVerify(() -> PodUpload.upload(operation, toUpload), 5120);
  }

  @Test
  void transferTo() throws Exception {
    final ByteArrayInputStream input = new ByteArrayInputStream("I'LL BE COPIED".getBytes(Charset.defaultCharset()));
    final AtomicReference<String> copiedStream = new AtomicReference<>();
    final InputStreamPumper.Writable consumer = (bytes, offset, length) -> {
      assertThat(length).isEqualTo(14);
      copiedStream.set(new String(Arrays.copyOf(bytes, 14), Charset.defaultCharset()));
    };
    InputStreamPumper.transferTo(input, consumer);
    assertThat(copiedStream).hasValue("I'LL BE COPIED");
  }

  @Test
  void createExecCommandForUpload_withFileInRootPath_shouldCreateValidExecCommandForUpload() {
    // When
    String result = PodUpload.createExecCommandForUpload("/cp.log");
    // Then
    assertThat(result).isEqualTo("mkdir -p '/' && cat - > '/cp.log'");
  }

  @Test
  void createExecCommandForUpload_withNormalFile_shouldCreateValidExecCommandForUpload() {
    // When
    String result = PodUpload.createExecCommandForUpload("/tmp/foo/cp.log");
    // Then
    assertThat(result).isEqualTo("mkdir -p '/tmp/foo' && cat - > '/tmp/foo/cp.log'");
  }

  @Test
  void createExecCommandForUpload_withSingleQuoteInPath() {
    // When
    String result = PodUpload.createExecCommandForUpload("/tmp/fo'o/cp.log");
    // Then
    assertThat(result).isEqualTo("mkdir -p '/tmp/fo\'\\'\'o' && cat - > '/tmp/fo\'\\'\'o/cp.log'");
  }

  @Test
  void createExecCommandForUpload_withMultipleSingleQuotesInPath() {
    // When
    String result = PodUpload.createExecCommandForUpload("/tmp/f'o'o/c'p.log");
    // Then
    assertThat(result).isEqualTo("mkdir -p '/tmp/f\'\\'\'o\'\\'\'o' && cat - > '/tmp/f\'\\'\'o\'\\'\'o/c\'\\'\'p.log'");
  }

  void uploadFileAndVerify(PodUploadTester<Boolean> fileUploadMethodToTest, boolean stream, long size)
      throws IOException, InterruptedException {
    Mockito.when(this.operation.getContext().getFile()).thenReturn("/mock/file");
    if (!stream) {
      verifyTar(fileUploadMethodToTest, size, "/mock");
      return;
    }
    Mockito.when(this.operation.writingOutput(Mockito.any())).then((Answer<TtyExecErrorable>) invocation -> {
      OutputStream out = invocation.getArgument(0);
      out.write((size + "\n").getBytes(StandardCharsets.UTF_8));
      return operation;
    });
    boolean result = fileUploadMethodToTest.apply();
    assertThat(result).isTrue();

    ArgumentCaptor<String[]> captorUpload = ArgumentCaptor.forClass(String[].class);
    Mockito.verify(operation.redirectingInput().terminateOnError(), Mockito.times(1)).exec(captorUpload.capture());
    assertEquals("mkdir -p '/mock' && cat - > '/mock/file'", captorUpload.getValue()[2]);

    ArgumentCaptor<String[]> captor = ArgumentCaptor.forClass(String[].class);
    Mockito.verify(operation, Mockito.times(1)).exec(captor.capture());
    assertEquals("wc -c < '/mock/file'", captor.getValue()[2]);
  }

  private void uploadDirectoryAndVerify(PodUploadTester<Boolean> directoryUpload, long size)
      throws IOException, InterruptedException {
    Mockito.when(this.operation.getContext().getDir()).thenReturn("/mock/dir");
    verifyTar(directoryUpload, size, "/mock/dir");
  }

  private void verifyTar(PodUploadTester<Boolean> directoryUpload, long size, String dir)
      throws IOException, InterruptedException {
    Mockito.when(this.operation.writingOutput(Mockito.any())).then((Answer<TtyExecErrorable>) invocation -> {
      OutputStream out = invocation.getArgument(0);
      out.write((size + "\n").getBytes(StandardCharsets.UTF_8));
      return operation;
    });
    boolean result = directoryUpload.apply();
    assertThat(result).isTrue();

    ArgumentCaptor<String[]> captorUpload = ArgumentCaptor.forClass(String[].class);
    Mockito.verify(operation.redirectingInput().terminateOnError(), Mockito.times(1)).exec(captorUpload.capture());
    assertTrue(captorUpload.getValue()[2].startsWith("mkdir -p '/tmp' && cat - > '/tmp/fabric8-"));

    ArgumentCaptor<String[]> captorCount = ArgumentCaptor.forClass(String[].class);
    Mockito.verify(operation, Mockito.times(1)).exec(captorCount.capture());
    assertTrue(captorCount.getValue()[2].startsWith("wc -c < '/tmp/fabric8-"));

    ArgumentCaptor<String[]> captorExtract = ArgumentCaptor.forClass(String[].class);
    Mockito.verify(operation.redirectingInput()).exec(captorExtract.capture());

    String extractCommand = captorExtract.getValue()[2];
    assertTrue(extractCommand.startsWith(String.format("mkdir -p '%1$s'; tar -C '%1$s' -xmf /tmp/fabric8-", dir)),
        extractCommand);
  }

}
