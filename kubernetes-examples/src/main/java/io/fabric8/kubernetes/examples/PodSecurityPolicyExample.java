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

import io.fabric8.kubernetes.api.model.extensions.PodSecurityPolicy;
import io.fabric8.kubernetes.api.model.extensions.PodSecurityPolicyBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;

import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PodSecurityPolicyExample {

    //You need to be login as admin on OpenShift for this Example
    //command for that is
    //oc login -u system:admin

    private static final Logger logger = Logger.getLogger(PodSecurityPolicyExample.class.getName());

    public static void main(String args[]) throws InterruptedException {

        String sample = System.getProperty("user.dir") + "/kubernetes-examples/src/main/resources/PodSecurityPolicy.yml";

        try {
            final KubernetesClient client = new DefaultKubernetesClient();

            //Creating PodSecurityPolicy from Yaml file

            logger.log(Level.INFO, "Loading File : " + sample);
            PodSecurityPolicy podSecurityPolicy = client.podSecurityPolicies().load(new FileInputStream(sample)).get();
            client.podSecurityPolicies().create(podSecurityPolicy);
            logger.log(Level.INFO, "PodSecurityPolicy created with Name : "
                  + podSecurityPolicy.getMetadata().getName());

            //Creating PodSecurityPolicy from Builder

            logger.log(Level.INFO, "Starting creating PodSecurityPolicy from Builder ");

            PodSecurityPolicy podSecurityPolicy1 = new PodSecurityPolicyBuilder().withNewMetadata()
                    .withName("example2")
                    .endMetadata()
                    .withNewSpec()
                    .withPrivileged(false)
                    .withNewRunAsUser().withRule("RunAsAny").endRunAsUser()
                    .withNewFsGroup().withRule("RunAsAny").endFsGroup()
                    .withNewSeLinux().withRule("RunAsAny").endSeLinux()
                    .withNewSupplementalGroups().withRule("RunAsAny").endSupplementalGroups()
                    .endSpec()
                    .build();

            client.podSecurityPolicies().create(podSecurityPolicy1);
            logger.log(Level.INFO, "PodSecurityPolicy created with Name : "
                    + podSecurityPolicy1.getMetadata().getName());

            client.close();

        } catch (KubernetesClientException ClientException) {
            logger.log(Level.SEVERE, "Problem encountered with Kubernetes client!!");
            ClientException.printStackTrace();

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception encountered : " + e.getMessage());
        }


    }
}
