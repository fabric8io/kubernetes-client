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
package io.fabric8.kubernetes.log4j.lookup;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.status.StatusLogger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Locate the current docker container.
 */
final class ContainerUtil {

  private static final Logger LOGGER = StatusLogger.getLogger();
  private static final Pattern DOCKER_ID_PATTERN = Pattern.compile("[0-9a-fA-F]{64}");
  static final Path CGROUP_PATH = Paths.get("/proc/self/cgroup");

  private ContainerUtil() {
  }

  /**
   * Returns the container id when running in a Docker container.
   * <p>
   * This inspects /proc/self/cgroup looking for a Kubernetes Control Group. Once it finds one it attempts
   * to isolate just the docker container id. There doesn't appear to be a standard way to do this, but
   * it seems to be the only way to determine what the current container is in a multi-container pod. It would have
   * been much nicer if Kubernetes would just put the container id in a standard environment variable.
   * </p>
   * 
   * @param path Path to a {@code /proc/pid/cgroup} file.
   * @return A container id or {@code null} if not found.
   */
  public static String getContainerId(Path path) {
    try {
      if (Files.exists(path)) {
        try (final Stream<String> lines = Files.lines(path)) {
          final String id = lines
              .map(ContainerUtil::getContainerId)
              .filter(Objects::nonNull)
              .findFirst()
              .orElse(null);
          LOGGER.debug("Found container id {}", id);
          return id;
        }
      }
      LOGGER.warn("Unable to access container information");
    } catch (IOException ioe) {
      LOGGER.warn("Error obtaining container id: {}", ioe.getMessage());
    }
    return null;
  }

  private static String getContainerId(String line) {
    return Optional.ofNullable(getCGroupPath(line))
        .map(ContainerUtil::getDockerId)
        .orElse(null);
  }

  /**
   * Retrieves a container id from a hierarchy of CGroups
   * <p>
   * Based on
   * <a href=
   * "https://github.com/jenkinsci/docker-workflow-plugin/blob/master/src/main/java/org/jenkinsci/plugins/docker/workflow/client/ControlGroup.java">ControlGroup.java</a>
   * </p>
   * 
   * @param cgroupPath a slash-separated hierarchy of CGroups.
   * @return a Docker ID
   */
  private static String getDockerId(String cgroupPath) {
    String[] elements = cgroupPath.split("/", -1);
    String dockerId = null;
    for (String element : elements) {
      Matcher matcher = DOCKER_ID_PATTERN.matcher(element);
      if (matcher.find()) {
        dockerId = matcher.group();
      }
    }
    return dockerId;
  }

  /**
   * Retrieves the full hierarchy of CGroups the process belongs
   * <p>
   * See <a href="https://man7.org/linux/man-pages/man7/cgroups.7.html">/proc/pid/cgroups</a>
   * </p>
   * 
   * @param line A line from a {@code /proc/pid/cgroups} file
   */
  private static String getCGroupPath(String line) {
    String[] fields = line.split(":", -1);
    return fields.length > 2 ? fields[2] : null;
  }
}
