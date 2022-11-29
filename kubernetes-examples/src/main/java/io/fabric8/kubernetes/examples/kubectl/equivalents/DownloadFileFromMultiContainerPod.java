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
package io.fabric8.kubernetes.examples.kubectl.equivalents;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;

import java.io.File;
import java.nio.file.Path;

/**
 * Downloading a file from a Pod with multiple containers. Equivalent to
 * `kubectl cp my-pod:/tmp/foo -c c1 /tmp/bar`
 */
public class DownloadFileFromMultiContainerPod {
  public static void main(String[] args) {
    try (KubernetesClient client = new KubernetesClientBuilder().build()) {
      // Path Where to copy file to local storage
      Path downloadToPath = new File("/tmp/docker-entrypoint.sh").toPath();
      // Using Kubernetes Client to copy file from pod
      client.pods()
          .inNamespace("default") // <- Namespace of pod
          .withName("multi-container-pod") // <- Name of pod
          .inContainer("c1") // <- Container from which file has to be downloaded
          .file("/docker-entrypoint.sh") // <- Path of file inside pod
          .copy(downloadToPath); // <- Local path where to copy downloaded file
    }
  }
}
