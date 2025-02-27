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
package io.fabric8.kubeapitest.binary;

import io.fabric8.kubeapitest.binary.repo.ArchiveDescriptor;
import io.fabric8.kubeapitest.binary.repo.BinaryRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BinaryDownloaderTest {

  public static final String VERSION = "1.23.1";
  BinaryRepo mockBinaryRepo = mock(BinaryRepo.class);
  OSInfo mockOsInfo = Mockito.mock(OSInfo.class);
  BinaryDownloader binaryDownloader = new BinaryDownloader("target", mockBinaryRepo, mockOsInfo);

  @Test
  void findsLatestBinary() {
    when(mockOsInfo.getOSName()).thenReturn("linux");
    when(mockOsInfo.getOSArch()).thenReturn("amd64");

    when(mockBinaryRepo.listObjectNames()).thenReturn(List.of(
        new ArchiveDescriptor("1.17.9", "amd64", "linux"),
        new ArchiveDescriptor("1.26.1", "amd64", "darwin"),
        new ArchiveDescriptor(VERSION, "amd64", "linux"))
        .stream());

    var latest = binaryDownloader.findLatestVersion();

    assertThat(latest).isEqualTo(VERSION);
  }

}
