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

/**
 * Uploading a directory from your local system to a Pod. Equivalent to
 * `kubectl cp /foo_dir my-pod:/bar_dir`
 */
public class UploadDirectoryToPod {
  public static void main(String[] args) {
    try (KubernetesClient k8s = new KubernetesClientBuilder().build()) {
      File fileToUpload = new File("/tmp/test-dir-src");
      k8s.pods().inNamespace("default") // <- Namespace of Pod
          .withName("my-pod") // <- Name of Pod
          .dir("/tmp/test-dir") // <- Path of directory inside Pod
          .upload(fileToUpload.toPath()); // <- Local Path of directory
    }
  }
}
