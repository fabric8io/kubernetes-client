package io.javaoperatorsdk.jenvtest.binary;

import java.util.List;

import org.junit.jupiter.api.Test;

import io.javaoperatorsdk.jenvtest.binary.repo.BinaryRepo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BinaryDownloaderTest {

  public static final String VERSION = "1.23.1";
  BinaryRepo mockBinaryRepo = mock(BinaryRepo.class);
  OSInfo mockOsInfo = mock(OSInfo.class);
  BinaryDownloader binaryDownloader =
      new BinaryDownloader("target", mockBinaryRepo, mockOsInfo);

  @Test
    void findsLatestBinary() {
        when(mockOsInfo.getOSName()).thenReturn("linux");
        when(mockOsInfo.getOSArch()).thenReturn("amd64");

        when(mockBinaryRepo.listObjectNames()).thenReturn(List.of(
                        "kubebuilder-tools-1.17.9-linux-amd64.tar.gz"
                        ,"kubebuilder-tools-1.26.1-darwin-amd64.tar.gz",
                        "kubebuilder-tools-"+VERSION+"-linux-amd64.tar.gz")
                .stream());

        var latest = binaryDownloader.findLatestVersion();

        assertThat(latest).isEqualTo(VERSION);
    }

}
