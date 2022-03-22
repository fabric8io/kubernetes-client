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
package io.fabric8.volumesnapshot.examples;

import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.volumesnapshot.client.VolumeSnapshotClient;

public class ClientFactory {
  private ClientFactory() {
  }

  public static VolumeSnapshotClient newClient(String[] args) {
    ConfigBuilder config = new ConfigBuilder();
    for (int i = 0; i < args.length - 1; i++) {

      String key = args[i];
      String value = args[i + 1];

      if (key.equals("--api-server")) {
        config = config.withMasterUrl(value);
      }

      if (key.equals("--token")) {
        config = config.withOauthToken(value);
      }

      if (key.equals("--username")) {
        config = config.withUsername(value);
      }

      if (key.equals("--password")) {
        config = config.withPassword(value);
      }
      if (key.equals("--namespace")) {
        config = config.withNamespace(value);
      }
    }
    return new KubernetesClientBuilder().withConfig(config.build()).build().adapt(VolumeSnapshotClient.class);
  }

  public static String getOptions(String[] args, String name, String defaultValue) {
    for (int i = 0; i < args.length - 1; i++) {
      String key = args[i];
      String value = args[i + 1];
      if (key.equals(name)) {
        return value;
      }
    }
    return defaultValue;
  }
}
