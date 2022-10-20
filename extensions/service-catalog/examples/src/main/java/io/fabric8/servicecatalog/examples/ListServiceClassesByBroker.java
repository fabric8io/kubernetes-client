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

package io.fabric8.servicecatalog.examples;

import io.fabric8.servicecatalog.api.model.ClusterServiceClassList;
import io.fabric8.servicecatalog.client.ServiceCatalogClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListServiceClassesByBroker {
  private static final Logger logger = LoggerFactory.getLogger(ListServiceClassesByBroker.class.getSimpleName());

  public static void main(String[] args) {
    ServiceCatalogClient client = ClientFactory.newClient(args);
    String broker = ClientFactory.getOptions(args, "--broker", null);
    if (broker == null || broker.isEmpty()) {
      logger.info("Missing --broker option!");
      System.exit(1);
    }
    logger.info("Listing Cluster Service Classes {} :", broker);
    ClusterServiceClassList list = client.clusterServiceBrokers().withName(broker).listClasses();
    list.getItems()
        .forEach(b -> logger.info(b.getSpec().getExternalName() + "\t\t\t\t" + b.getMetadata().getName()));
    logger.info("Done");
  }
}
