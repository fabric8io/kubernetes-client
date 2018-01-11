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

import io.fabric8.openshift.api.model.SecurityContextConstraints;
import io.fabric8.openshift.api.model.SecurityContextConstraintsBuilder;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;

public class SecurityContextConstraintExample {

    //You need to be login as admin on Openshift for this Example
    //command for that is
    //oc login -u system:admin

    public static void main(String args[]) {

        OpenShiftClient client = new DefaultOpenShiftClient();

        SecurityContextConstraints scc = new SecurityContextConstraintsBuilder()
            .withNewMetadata().withName("scc").endMetadata()
            .withAllowPrivilegedContainer(true)
            .withNewRunAsUser()
            .withType("RunAsAny")
            .endRunAsUser()
            .withNewSeLinuxContext()
            .withType("RunAsAny")
            .endSeLinuxContext()
            .withNewFsGroup()
            .withType("RunAsAny")
            .endFsGroup()
            .withNewSupplementalGroups()
            .withType("RunAsAny")
            .endSupplementalGroups()
            .addToUsers("admin")
            .addToGroups("admin-group")
            .build();

        client.securityContextConstraints().create(scc);

        client.close();
    }
}
