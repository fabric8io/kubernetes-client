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

package io.fabric8.openshift.examples;

import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.VersionInfo;
import io.fabric8.openshift.client.OpenShiftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenShiftVersionExample {
  private static final Logger logger = LoggerFactory.getLogger(OpenShiftVersionExample.class);

  public static void main(String[] args) {
    final ConfigBuilder configBuilder = new ConfigBuilder();
    if (args.length > 0) {
      configBuilder.withMasterUrl(args[0]);
    }
    try (OpenShiftClient client = new KubernetesClientBuilder()
        .withConfig(configBuilder.build()).build().adapt(OpenShiftClient.class)) {
      VersionInfo openShiftVersionInfo = client.getOpenShiftV3Version();

      logger.info("Version details of this OpenShift cluster :-");
      logger.info("Major        : {}", openShiftVersionInfo.getMajor());
      logger.info("Minor        : {}", openShiftVersionInfo.getMinor());
      logger.info("GitVersion   : {}", openShiftVersionInfo.getGitVersion());
      logger.info("BuildDate    : {}", openShiftVersionInfo.getBuildDate());
      logger.info("GitTreeState : {}", openShiftVersionInfo.getGitTreeState());
      logger.info("Platform     : {}", openShiftVersionInfo.getPlatform());
      logger.info("GitVersion   : {}", openShiftVersionInfo.getGitVersion());
      logger.info("GoVersion    : {}", openShiftVersionInfo.getGoVersion());
      logger.info("GitCommit    : {}", openShiftVersionInfo.getGitCommit());
    }
  }
}
