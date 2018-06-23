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

import io.fabric8.kubernetes.api.model.storage.StorageClassList;
import io.fabric8.kubernetes.client.*;
import org.slf4j.*;

public class ListStorageClassExample {

  private static final Logger logger = LoggerFactory.getLogger(ListStorageClassExample.class);

  public static void main(String[] args) {

    String master = "http://localhost:8080/";

    if (args.length == 1) {
      master = args[0];
    }

    io.fabric8.kubernetes.client.Config config = new io.fabric8.kubernetes.client.ConfigBuilder().withMasterUrl(master).build();

    try (final KubernetesClient client = new DefaultKubernetesClient(config)) {

      StorageClassList storageClassList = client.storage().storageClasses().list();

      logger.info(storageClassList.toString());

    } catch (KubernetesClientException e) {
      logger.error(e.getMessage(), e);
    }

  }
}
