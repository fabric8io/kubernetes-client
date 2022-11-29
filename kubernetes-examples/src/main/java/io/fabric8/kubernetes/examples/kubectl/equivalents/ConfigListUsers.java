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

import io.fabric8.kubernetes.api.model.Config;
import io.fabric8.kubernetes.api.model.NamedAuthInfo;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Java equivalent to `kubectl config view -o jsonpath='{.users[*].name}'`. Gets a list of users
 * found in KubeConfig
 */
public class ConfigListUsers {
  private static final Logger logger = LoggerFactory.getLogger(ConfigListUsers.class);

  public static void main(String[] args) throws FileNotFoundException {
    // Gets KubeConfig via reading KubeConfig environment variable or ~/.kube/config
    String kubeConfigFileName = io.fabric8.kubernetes.client.Config.getKubeconfigFilename();
    if (kubeConfigFileName != null) {
      File kubeConfigFile = new File(kubeConfigFileName);
      Config kubeConfigObj = Serialization.unmarshal(new FileInputStream(kubeConfigFile), Config.class);

      // Print users
      kubeConfigObj.getUsers().stream()
          .map(NamedAuthInfo::getName)
          .forEach(logger::info);
    }
  }
}
