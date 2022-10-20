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

public class ListServiceClasses {
  private static final Logger logger = LoggerFactory.getLogger(ListServiceClasses.class.getSimpleName());

  public static void main(String[] args) {
    ServiceCatalogClient client = ClientFactory.newClient(args);
    logger.info("Listing Cluster Service Classes:");
    ClusterServiceClassList list = client.clusterServiceClasses().list();
    list.getItems()
        .forEach(b -> logger.info(b.getSpec().getClusterServiceBrokerName() + "\t\t" + b.getSpec().getExternalName()
            + "\t\t\t\t" + b.getMetadata().getName()));
    logger.info("Done");
  }
}
