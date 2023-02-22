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

package io.fabric8.kubernetes.examples;

import io.fabric8.kubernetes.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KubernetesVersionExample {
  private static final Logger logger = LoggerFactory.getLogger(KubernetesVersionExample.class);

  public static void main(String[] args) {
    final ConfigBuilder configBuilder = new ConfigBuilder();
    if (args.length > 0) {
      configBuilder.withMasterUrl(args[0]);
    }
    try (KubernetesClient client = new KubernetesClientBuilder().withConfig(configBuilder.build()).build()) {
      VersionInfo versionInfo = client.getKubernetesVersion();

      logger.info("Version details of this Kubernetes cluster :-");
      logger.info("Major        : {}", versionInfo.getMajor());
      logger.info("Minor        : {}", versionInfo.getMinor());
      logger.info("GitVersion   : {}", versionInfo.getGitVersion());
      logger.info("BuildDate    : {}", versionInfo.getBuildDate());
      logger.info("GitTreeState : {}", versionInfo.getGitTreeState());
      logger.info("Platform     : {}", versionInfo.getPlatform());
      logger.info("GitVersion   : {}", versionInfo.getGitVersion());
      logger.info("GoVersion    : {}", versionInfo.getGoVersion());
      logger.info("GitCommit    : {}", versionInfo.getGitCommit());
    }
  }
}
