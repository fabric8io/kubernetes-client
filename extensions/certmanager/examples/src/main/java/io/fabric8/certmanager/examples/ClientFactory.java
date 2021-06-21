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
package io.fabric8.certmanager.examples;

import io.fabric8.certmanager.client.CertManagerClient;
import io.fabric8.certmanager.client.DefaultCertManagerClient;
import io.fabric8.kubernetes.client.ConfigBuilder;

public class ClientFactory {

  public static CertManagerClient newClient(String[] args) {
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
    return new DefaultCertManagerClient(config.build());
  }

  public static String getOptions(String args[], String name, String defaultValue) {
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

