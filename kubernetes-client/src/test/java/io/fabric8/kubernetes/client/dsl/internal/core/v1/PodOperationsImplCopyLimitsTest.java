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
package io.fabric8.kubernetes.client.dsl.internal.core.v1;

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class PodOperationsImplCopyLimitsTest {

  private static final String SOURCE_DIR = "/var/source-dir";
  private static final int TAR_RECORD_SIZE = 512;
  private static final int CHECKSUM_OFFSET = 148;
  private static final int CHECKSUM_LENGTH = 8;

  @Test
  void copyRejectsSparseTarEntry(@TempDir Path targetDir) {
    PodOperationsImpl operation = podOperation(new ByteArrayInputStream(oldGnuSparseTar()), -1L, -1L);

    KubernetesClientException exception = assertThrows(KubernetesClientException.class, () -> operation.copy(targetDir));

    assertThat(exception).getCause()
        .hasMessage("Refusing to extract sparse tar entry: sparse.bin");
    assertThat(targetDir).isDirectoryNotContaining("glob:**/sparse.bin");
  }

  @Test
  void copyRejectsEntryAboveConfiguredFileLimit(@TempDir Path targetDir) throws Exception {
    PodOperationsImpl operation = podOperation(tarStream(Map.of("artifact.bin", bytes(4))), 3L, -1L);

    KubernetesClientException exception = assertThrows(KubernetesClientException.class, () -> operation.copy(targetDir));

    assertThat(exception).getCause()
        .hasMessage("Tar entry 'artifact.bin' exceeds the configured file copy limit");
    assertThat(targetDir).isDirectoryNotContaining("glob:**/artifact.bin");
  }

  @Test
  void copyRejectsEntryAboveConfiguredTotalLimit(@TempDir Path targetDir) throws Exception {
    Map<String, byte[]> files = new LinkedHashMap<>();
    files.put("first.bin", bytes(3));
    files.put("second.bin", bytes(3));
    PodOperationsImpl operation = podOperation(tarStream(files), -1L, 5L);

    KubernetesClientException exception = assertThrows(KubernetesClientException.class, () -> operation.copy(targetDir));

    assertThat(exception).getCause()
        .hasMessage("Tar entry 'second.bin' exceeds the configured total copy limit");
    assertThat(targetDir).isDirectoryContaining("glob:**/first.bin");
    assertThat(targetDir).isDirectoryNotContaining("glob:**/second.bin");
  }

  @Test
  void copyAllowsEntriesWithinConfiguredLimits(@TempDir Path targetDir) throws Exception {
    Map<String, byte[]> files = new LinkedHashMap<>();
    files.put("first.bin", bytes(3));
    files.put("second.bin", bytes(2));
    PodOperationsImpl operation = podOperation(tarStream(files), 3L, 5L);

    boolean result = operation.copy(targetDir);

    assertThat(result).isTrue();
    assertThat(targetDir).isDirectoryContaining("glob:**/first.bin");
    assertThat(targetDir).isDirectoryContaining("glob:**/second.bin");
  }

  private static PodOperationsImpl podOperation(InputStream tarStream, Long maxFileBytes, Long maxTotalBytes) {
    RequestConfig requestConfig = new RequestConfig(null, null, null, null, null, null, null, null, maxFileBytes,
        maxTotalBytes);
    OperationContext operationContext = new OperationContext().withRequestConfig(requestConfig);
    PodOperationsImpl operation = spy(new PodOperationsImpl(new PodOperationContext().withDir(SOURCE_DIR), operationContext));
    doReturn(tarStream).when(operation).readTar(SOURCE_DIR);
    return operation;
  }

  private static InputStream tarStream(Map<String, byte[]> files) throws IOException {
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    try (TarArchiveOutputStream tar = new TarArchiveOutputStream(output)) {
      for (Map.Entry<String, byte[]> file : files.entrySet()) {
        TarArchiveEntry entry = new TarArchiveEntry(file.getKey());
        entry.setSize(file.getValue().length);
        tar.putArchiveEntry(entry);
        tar.write(file.getValue());
        tar.closeArchiveEntry();
      }
      tar.finish();
    }
    return new ByteArrayInputStream(output.toByteArray());
  }

  private static byte[] oldGnuSparseTar() {
    byte[] header = new byte[TAR_RECORD_SIZE];
    writeAscii(header, 0, "sparse.bin");
    writeOctal(header, 100, 8, 0644);
    writeOctal(header, 108, 8, 0);
    writeOctal(header, 116, 8, 0);
    writeOctal(header, 124, 12, 1);
    writeOctal(header, 136, 12, 0);
    Arrays.fill(header, CHECKSUM_OFFSET, CHECKSUM_OFFSET + CHECKSUM_LENGTH, (byte) ' ');
    header[156] = 'S';
    writeAscii(header, 257, "ustar ");
    header[263] = ' ';
    writeAscii(header, 265, "root");
    writeAscii(header, 297, "root");
    writeOctal(header, 386, 12, 1024);
    writeOctal(header, 398, 12, 1);
    writeOctal(header, 483, 12, 1025);
    writeChecksum(header);

    ByteArrayOutputStream output = new ByteArrayOutputStream();
    output.writeBytes(header);
    output.write('A');
    output.writeBytes(new byte[TAR_RECORD_SIZE - 1]);
    output.writeBytes(new byte[TAR_RECORD_SIZE * 2]);
    return output.toByteArray();
  }

  private static void writeAscii(byte[] buffer, int offset, String value) {
    byte[] raw = value.getBytes(StandardCharsets.US_ASCII);
    System.arraycopy(raw, 0, buffer, offset, raw.length);
  }

  private static void writeOctal(byte[] buffer, int offset, int length, long value) {
    writeAscii(buffer, offset, String.format(Locale.ROOT, "%0" + (length - 1) + "o", value));
    buffer[offset + length - 1] = 0;
  }

  private static void writeChecksum(byte[] header) {
    long checksum = 0;
    for (byte value : header) {
      checksum += Byte.toUnsignedInt(value);
    }
    writeAscii(header, CHECKSUM_OFFSET, String.format(Locale.ROOT, "%06o", checksum));
    header[CHECKSUM_OFFSET + 6] = 0;
    header[CHECKSUM_OFFSET + 7] = ' ';
  }

  private static byte[] bytes(int count) {
    byte[] bytes = new byte[count];
    Arrays.fill(bytes, (byte) 'A');
    return bytes;
  }
}
