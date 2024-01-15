package io.fabric8.kubeapitest;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import io.fabric8.kubeapitest.binary.OSInfo;
import org.slf4j.Logger;

public class Utils {
  public static final String WILDCARD_SUFFIX = ".*";

  private Utils() {}

  public static final SemverComparator SEMVER_COMPARATOR = new SemverComparator();

  public static String getLatestVersion(List<String> versions) {
    versions.sort(SEMVER_COMPARATOR);
    return versions.get(versions.size() - 1);
  }

  private static class SemverComparator implements Comparator<String> {
    @Override
    public int compare(String v1, String v2) {
      String[] thisParts = v1.split("\\.");
      String[] thatParts = v2.split("\\.");
      int length = Math.max(thisParts.length, thatParts.length);
      for (int i = 0; i < length; i++) {
        int thisPart = i < thisParts.length ? Integer.parseInt(thisParts[i]) : 0;
        int thatPart = i < thatParts.length ? Integer.parseInt(thatParts[i]) : 0;
        if (thisPart < thatPart)
          return -1;
        if (thisPart > thatPart)
          return 1;
      }
      return 0;
    }
  }

  public static void redirectProcessOutputToLogger(InputStream outputStream, Logger logger) {
    new Thread(() -> {
      Scanner sc = new Scanner(outputStream);
      while (sc.hasNextLine()) {
        logger.debug(sc.nextLine());
      }
    }).start();
  }

  public static String platformSuffix(OSInfo osInfo) {
    return "-" + osInfo.getOSName() + "-" + osInfo.getOSArch();
  }

  public static int findFreePort() {
    try (ServerSocket socket = new ServerSocket(0)) {
      return socket.getLocalPort();
    } catch (IOException e) {

    }
    return -1;
  }

  public static boolean isWildcardVersion(String version) {
    return version.endsWith(WILDCARD_SUFFIX);
  }

  public static String wildcardToPrefix(String wildcardVersion) {
    return wildcardVersion.substring(0, wildcardVersion.lastIndexOf("."));
  }

}
