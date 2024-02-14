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
package io.fabric8.kubeapitest;

import io.fabric8.kubeapitest.binary.OSInfo;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Utils {

  public static final String WILDCARD_SUFFIX = ".*";
  private static final Random RANDOM = new Random();

  private Utils() {
  }

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
    // 100 attempts should be enough
    return findFreePort(49152, 65535, 100);
  }

  public static int findFreePort(int min, int max, int attempts) {
    for (int i = 0; i < attempts; i++) {
      int port = min + RANDOM.nextInt(max - min + 1);
      try (ServerSocket ignored = new ServerSocket(port)) {
        return port;
      } catch (Exception e) {
        // NOOP
      }
    }
    throw new IllegalStateException(
        "Cannot find a free random port in the range [" + min + ", " + max + "] after " + attempts + " attempts");
  }

  public static boolean isWildcardVersion(String version) {
    return version.endsWith(WILDCARD_SUFFIX);
  }

  public static String wildcardToPrefix(String wildcardVersion) {
    return wildcardVersion.substring(0, wildcardVersion.lastIndexOf("."));
  }

  public static void deleteDirectory(File file) throws IOException {
    try (var stream = Files.walk(file.toPath())) {
      stream.sorted(Comparator.reverseOrder())
          .map(Path::toFile)
          .forEach(File::delete);
    }
  }

}
