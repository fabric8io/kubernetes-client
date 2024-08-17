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
package io.fabric8.kubeapitest.binary.repo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubeapitest.KubeAPITestException;
import io.fabric8.kubeapitest.binary.OSInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Deprecated
public class BinaryRepo {

  private static final Logger log = LoggerFactory.getLogger(BinaryRepo.class);

  private final OSInfo osInfo;
  private static List<String> objectNames;
  private static final ReentrantLock downloadLock = new ReentrantLock();

  public BinaryRepo(OSInfo osInfo) {
    this.osInfo = osInfo;
  }

  public File downloadVersionToTempFile(String version) {
    try {
      String url = "https://storage.googleapis.com/kubebuilder-tools/kubebuilder-tools-" + version +
          "-" + osInfo.getOSName() + "-" + osInfo.getOSArch() + ".tar.gz";

      File tempFile = File.createTempFile("kubebuilder-tools-" + version, ".tar.gz");
      log.debug("Downloading binary from url: {} to Temp file: {}", url, tempFile.getPath());
      copyURLToFile(url, tempFile);
      return tempFile;
    } catch (IOException e) {
      throw new KubeAPITestException(e);
    }
  }

  private void copyURLToFile(String url, File tempFile) throws IOException {
    try (InputStream in = new URL(url).openStream()) {
      Files.copy(in, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
  }

  public Stream<String> listObjectNames() {
    downloadLock.lock();
    try {
      if (objectNames == null) {
        log.debug("Listing objects from storage");
        var httpClient = HttpClient.newBuilder()
            .build();

        HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(URI.create("https://storage.googleapis.com/storage/v1/b/kubebuilder-tools/o"))
            .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ObjectList objectList = mapper.readValue(response, ObjectList.class);
        objectNames = objectList.getItems().stream().map(ObjectListItem::getName)
            .collect(Collectors.toList());
      }
      return objectNames.stream();
    } catch (IOException e) {
      throw new KubeAPITestException(e);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new KubeAPITestException(e);
    } finally {
      downloadLock.unlock();
    }
  }

}
