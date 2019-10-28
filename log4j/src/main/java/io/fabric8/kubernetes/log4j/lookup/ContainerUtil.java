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
package io.fabric8.kubernetes.log4j.lookup;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.status.StatusLogger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

/**
 * Locate the current docker container.
 */
final class ContainerUtil {

  private static final Logger LOGGER = StatusLogger.getLogger();
  private static final int MAXLENGTH = 65;

  /**
   * Returns the container id when running in a Docker container.
   *
   * This inspects /proc/self/cgroup looking for a Kubernetes Control Group. Once it finds one it attempts
   * to isolate just the docker container id. There doesn't appear to be a standard way to do this, but
   * it seems to be the only way to determine what the current container is in a multi-container pod. It would have
   * been much nicer if Kubernetes would just put the container id in a standard environment variable.
   *
   * @see <a href="http://stackoverflow.com/a/25729598/12916">Stackoverflow</a> for a discussion on retrieving the containerId.
   * @see <a href=
   *      "https://github.com/jenkinsci/docker-workflow-plugin/blob/master/src/main/java/org/jenkinsci/plugins/docker/workflow/client/ControlGroup.java">ControlGroup</a>
   *      for the original version of this. Not much is actually left but it provided good inspiration.
   * @return The container id.
   */
  public static String getContainerId() {
    try {
      final File file = new File("/proc/self/cgroup");
      if (file.exists()) {
        final Path path = file.toPath();
        final String id = Files.lines(path)
            .map(ContainerUtil::getContainerId)
            .filter(Objects::nonNull)
            .findFirst()
            .orElse(null);
        LOGGER.debug("Found container id {}", id);
        return id;
      }
      LOGGER.warn("Unable to access container information");
    } catch (IOException ioe) {
      LOGGER.warn("Error obtaining container id: {}", ioe.getMessage());
    }
    return null;
  }

  private static String getContainerId(String line) {
    // Every control group in Kubernetes will use
    if (line.contains("/kubepods")) {
      // Strip off everything up to the last slash.
      int i = line.lastIndexOf('/');
      if (i < 0) {
        return null;
      }
      // If the remainder has a period then take everything up to it.
      line = line.substring(i + 1);
      i = line.lastIndexOf('.');
      if (i > 0) {
        line = line.substring(0, i);
      }
      // Everything ending with a '/' has already been stripped but the remainder might start with "docker-"
      if (line.contains("docker-")) {
        // 8:cpuset:/kubepods.slice/kubepods-pod9c26dfb6_b9c9_11e7_bfb9_02c6c1fc4861.slice/docker-3dd988081e7149463c043b5d9c57d7309e079c5e9290f91feba1cc45a04d6a5b.scope
        i = line.lastIndexOf("docker-");
        line = line.substring(i + 7);
      }
      return line.length() <= MAXLENGTH ? line : line.substring(0, MAXLENGTH);
    }

    return null;
  }
}
