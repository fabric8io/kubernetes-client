package io.fabric8.openshift.examples;

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

import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.openshift.api.model.Parameter;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class TemplateExample {
  private static final Logger logger = LoggerFactory.getLogger(TemplateExample.class);

  public static void main(String[] args) throws IOException {
    try (OpenShiftClient client = new DefaultOpenShiftClient()) {
      try {
        client.namespaces().createNew().withNewMetadata().withName("thisisatest").endMetadata().done();

        Template t = client.templates().load(TemplateExample.class.getResourceAsStream("/test-template.yml")).get();
        for (Parameter p : t.getParameters()) {
          System.out.println(p.getName());
        }

        t = client.templates().load(TemplateExample.class.getResourceAsStream("/test-template.yml")).get();
        t = client.templates().inNamespace("thisisatest").load(TemplateExample.class.getResourceAsStream("/test-template.yml")).create();
        t = client.templates().inNamespace("thisisatest").withName("eap6-basic-sti").get();
        System.out.println(t.getMetadata().getName());

        KubernetesList l = client.templates().inNamespace("thisisatest").withName("eap6-basic-sti").process();
        System.out.println(l.getItems().size());

        l = client.lists().load(TemplateExample.class.getResourceAsStream("/test-list.yml")).get();
        System.out.println(l.getItems().size());

        l = client.lists().inNamespace("thisisatest").load(TemplateExample.class.getResourceAsStream("/test-list.yml")).create();
      } finally {
        // And finally clean up the namespace
        client.namespaces().withName("thisisatest").delete();
        logger.info("Deleted namespace");
      }
    }
  }
}
