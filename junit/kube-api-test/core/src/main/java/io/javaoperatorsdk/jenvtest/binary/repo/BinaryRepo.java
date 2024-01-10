package io.javaoperatorsdk.jenvtest.binary.repo;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.javaoperatorsdk.jenvtest.JenvtestException;
import io.javaoperatorsdk.jenvtest.binary.OSInfo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

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
      FileUtils.copyURLToFile(new URL(url), tempFile);
      return tempFile;
    } catch (IOException e) {
      throw new JenvtestException(e);
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
        ObjectMapper mapper =
            new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ObjectList objectList = mapper.readValue(response, ObjectList.class);
        objectNames = objectList.getItems().stream().map(ObjectListItem::getName)
            .collect(Collectors.toList());
      }
      return objectNames.stream();
    } catch (IOException e) {
      throw new JenvtestException(e);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new JenvtestException(e);
    } finally {
      downloadLock.unlock();
    }
  }


}
