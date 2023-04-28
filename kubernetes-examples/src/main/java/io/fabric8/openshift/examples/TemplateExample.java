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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.openshift.api.model.Parameter;
import io.fabric8.openshift.api.model.ProjectRequestBuilder;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.client.OpenShiftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

public class TemplateExample {
  private static final Logger logger = LoggerFactory.getLogger(TemplateExample.class);

  private static final String NAMESPACE = "template-example-ns";
  private static final String TEST_TEMPLATE_RESOURCE = "/test-template.yml";
  private static final String DEFAULT_NAME_OF_TEMPLATE = "eap6-basic-sti";

  public static void main(String[] args) {
    try (OpenShiftClient client = new KubernetesClientBuilder().build().adapt(OpenShiftClient.class)) {
      try {
        logger.info("Creating temporary project '{}' for example", NAMESPACE);
        client.projectrequests().create(
            new ProjectRequestBuilder()
                .withNewMetadata()
                .withName(NAMESPACE)
                .endMetadata()
                .build());
        logger.info("Created project: {}", NAMESPACE);

        final Template loadedTemplate = client.templates()
            .load(TemplateExample.class.getResourceAsStream(TEST_TEMPLATE_RESOURCE)).item();
        for (Parameter p : loadedTemplate.getParameters()) {
          final String required = Boolean.TRUE.equals(p.getRequired()) ? "*" : "";
          logger.info("Loaded parameter from template: {}{} - '{}' ({})",
              p.getName(), required, p.getValue(), p.getGenerate());
        }

        final Template serverUploadedTemplate = client.templates()
            .inNamespace(NAMESPACE)
            .load(TemplateExample.class.getResourceAsStream(TEST_TEMPLATE_RESOURCE))
            .create();
        logger.info("Template {} successfully created on server", serverUploadedTemplate.getMetadata().getName());
        final Template serverDownloadedTemplate = client.templates().inNamespace(NAMESPACE).withName(DEFAULT_NAME_OF_TEMPLATE)
            .get();
        logger.info("Template {} successfully downloaded from server", serverDownloadedTemplate.getMetadata().getName());

        final KubernetesList processedTemplateWithDefaultParameters = client.templates()
            .inNamespace(NAMESPACE).withName(DEFAULT_NAME_OF_TEMPLATE).process();
        logger.info("Template {} successfully processed to list with {} items, and requiredBoolean = {}",
            processedTemplateWithDefaultParameters.getItems().get(0).getMetadata().getLabels().get("template"),
            processedTemplateWithDefaultParameters.getItems().size(),
            processedTemplateWithDefaultParameters.getItems().get(0).getMetadata().getLabels().get("requiredBoolean"));

        final KubernetesList processedTemplateWithCustomParameters = client.templates()
            .inNamespace(NAMESPACE).withName(DEFAULT_NAME_OF_TEMPLATE)
            .process(Collections.singletonMap("REQUIRED_BOOLEAN", "true"));
        logger.info("Template {} successfully processed to list with {} items, and requiredBoolean = {}",
            processedTemplateWithCustomParameters.getItems().get(0).getMetadata().getLabels().get("template"),
            processedTemplateWithCustomParameters.getItems().size(),
            processedTemplateWithCustomParameters.getItems().get(0).getMetadata().getLabels().get("requiredBoolean"));

        List<HasMetadata> l = client.load(TemplateExample.class.getResourceAsStream("/test-list.yml")).items();
        logger.info("{}", l.size());

        final boolean templateDeleted = client.templates().inNamespace(NAMESPACE).withName(DEFAULT_NAME_OF_TEMPLATE).delete()
            .size() == 1;
        logger.info("Template {} was {}deleted", DEFAULT_NAME_OF_TEMPLATE, templateDeleted ? "" : "**NOT** ");
        client.load(TemplateExample.class.getResourceAsStream("/test-list.yml")).inNamespace(NAMESPACE).create();
      } finally {
        // And finally clean up the namespace
        client.projects().withName(NAMESPACE).delete();
        logger.info("Deleted project {}", NAMESPACE);
      }
    }
  }
}
