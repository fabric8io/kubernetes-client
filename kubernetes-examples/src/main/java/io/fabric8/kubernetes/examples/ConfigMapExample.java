/**
 * Copyright (C) 2015 Red Hat, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.fabric8.kubernetes.examples;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.DoneableConfigMap;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class ConfigMapExample {
  private static final Logger logger = LoggerFactory.getLogger(ConfigMapExample.class);

  public static void main(String[] args) throws InterruptedException {
    Config config = new ConfigBuilder().build();
    KubernetesClient client = new DefaultKubernetesClient(config);

    String namespace = null;
    if (args.length > 0) {
      namespace = args[0];
    }
    if (namespace == null) {
      namespace = client.getNamespace();
    }
    if (namespace == null) {
      namespace = "default";
    }

    String name = "cheese";
    try {
      Resource<ConfigMap, DoneableConfigMap> configMapResource = client.configMaps().inNamespace(namespace).withName(name);


      ConfigMap configMap = configMapResource.createOrReplace(new ConfigMapBuilder().
          withNewMetadata().withName(name).endMetadata().
          addToData("foo", "" + new Date()).
          addToData("bar", "beer").
          build());

      log("Upserted ConfigMap at " + configMap.getMetadata().getSelfLink() + " data " + configMap.getData());

    } finally {
      client.close();
    }
  }


  private static void log(String action, Object obj) {
    logger.info("{}: {}", action, obj);
  }

  private static void log(String action) {
    logger.info(action);
  }
}
