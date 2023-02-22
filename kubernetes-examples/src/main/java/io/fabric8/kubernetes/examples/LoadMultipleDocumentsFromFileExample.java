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

import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class LoadMultipleDocumentsFromFileExample {
  private static final Logger logger = LoggerFactory.getLogger(LoadMultipleDocumentsFromFileExample.class);

  @SuppressWarnings("java:S1604")
  public static void main(String[] args) {
    final ConfigBuilder configBuilder = new ConfigBuilder();
    if (args.length > 0) {
      configBuilder.withMasterUrl(args[0]);
    }
    try (KubernetesClient client = new KubernetesClientBuilder().withConfig(configBuilder.build()).build()) {
      List<HasMetadata> list = client
          .load(LoadMultipleDocumentsFromFileExample.class.getResourceAsStream("/multiple-document-template.yml")).items();
      logger.info("Found in file: {} items.", list.size());
      for (HasMetadata meta : list) {
        logger.info(display(meta));
      }

      //noinspection Convert2Lambda
      list = client.load(LoadMultipleDocumentsFromFileExample.class.getResourceAsStream("/multiple-document-template.yml"))
          .items();
      KubernetesListBuilder kubernetesListBuilder = new KubernetesListBuilder();
      kubernetesListBuilder.addAllToItems(list);
      kubernetesListBuilder.accept(new Visitor<ObjectMetaBuilder>() {
        @Override
        public void visit(ObjectMetaBuilder item) {
          item.addToLabels("visitorkey", "visitorvalue");
        }
      });

      logger.info("Visited: {} items.", list.size());
      for (HasMetadata meta : list) {
        logger.info(display(meta));
      }
    }
  }

  private static String display(HasMetadata item) {
    StringBuilder sb = new StringBuilder();
    sb.append("[ ");
    if (Utils.isNotNullOrEmpty(item.getKind())) {
      sb.append(" Kind:").append(item.getKind());
    }
    if (Utils.isNotNullOrEmpty(item.getMetadata().getName())) {
      sb.append(" Name:").append(item.getMetadata().getName());
    }

    if (item.getMetadata().getLabels() != null && !item.getMetadata().getLabels().isEmpty()) {
      sb.append(" Lables: [ ");
      for (Map.Entry<String, String> entry : item.getMetadata().getLabels().entrySet()) {
        sb.append(entry.getKey()).append(":").append(entry.getValue()).append(" ");
      }
      sb.append("]");
    }
    sb.append(" ]");
    return sb.toString();
  }
}
