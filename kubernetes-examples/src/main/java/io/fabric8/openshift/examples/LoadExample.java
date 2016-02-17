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
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.openshift.client.OpenShiftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LoadExample {

    private static final Logger logger = LoggerFactory.getLogger(LoadExample.class);

    public static void main(String[] args) throws InterruptedException {
        String master = "https://localhost:8443/";
        if (args.length == 1) {
            master = args[0];
        }

        Config config = new ConfigBuilder().build();
        KubernetesClient kubernetesClient = new DefaultKubernetesClient(config);
        OpenShiftClient client = kubernetesClient.adapt(OpenShiftClient.class);

        List<HasMetadata> list = client.load(TemplateExample.class.getResourceAsStream("/test-template.yml")).get();
        System.out.println("Found in file:" + list.size() + " items.");
        for (HasMetadata meta : list) {
            System.out.println(meta.getKind() + ":" + meta.getMetadata().getName());
        }


        list = client.load(TemplateExample.class.getResourceAsStream("/test-template.yml")).fromServer().get();
        System.out.println("Found on server:" + list.size() + " items.");
        for (HasMetadata meta : list) {
            System.out.println( meta.getKind() + ":" + meta.getMetadata().getName());
        }

        list = client.load(TemplateExample.class.getResourceAsStream("/test-template.yml"))
                .deletingExisting()
                .apply();

        System.out.println("Applied:" + list.size() + " items.");
        for (HasMetadata meta : list) {
            System.out.println( meta.getKind() + ":" + meta.getMetadata().getName());
        }

        Boolean result = client.load(TemplateExample.class.getResourceAsStream("/test-template.yml")).delete();
        System.out.println("Deleted:" + result);

    }
}
