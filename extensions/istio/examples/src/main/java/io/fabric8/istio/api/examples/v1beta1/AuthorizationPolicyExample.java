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
package io.fabric8.istio.api.examples.v1beta1;

import io.fabric8.istio.api.security.v1beta1.AuthorizationPolicyAction;
import io.fabric8.istio.api.security.v1beta1.AuthorizationPolicyBuilder;
import io.fabric8.istio.api.security.v1beta1.AuthorizationPolicyList;
import io.fabric8.istio.api.security.v1beta1.ConditionBuilder;
import io.fabric8.istio.api.security.v1beta1.OperationBuilder;
import io.fabric8.istio.api.security.v1beta1.RuleBuilder;
import io.fabric8.istio.api.security.v1beta1.RuleFromBuilder;
import io.fabric8.istio.api.security.v1beta1.RuleToBuilder;
import io.fabric8.istio.api.security.v1beta1.SourceBuilder;
import io.fabric8.istio.api.type.v1beta1.WorkloadSelectorBuilder;
import io.fabric8.istio.client.IstioClient;
import io.fabric8.kubernetes.client.KubernetesClientException;

import java.util.Collections;

public class AuthorizationPolicyExample {
  private static final String NAMESPACE = "test";

  public static void main(String[] args) {
    try {
      IstioClient client = ClientFactory.newClient(args);
      createResource(client);
      System.exit(0);
    } catch (KubernetesClientException ex) {
      System.err.println("Failed with " + ex.getMessage());
      System.exit(1);
    }
  }

  public static void createResource(IstioClient client) {
    System.out.println("Creating a AuthorizationPolicy entry");
    client.v1beta1().authorizationPolicies().inNamespace(NAMESPACE).create(new AuthorizationPolicyBuilder()
        .withNewMetadata()
        .withName("httpbin")
        .endMetadata()
        .withNewSpec()
        .withSelector(new WorkloadSelectorBuilder().withMatchLabels(Collections.singletonMap("app", "httpbin")).build())
        .withAction(AuthorizationPolicyAction.DENY)
        .withRules(new RuleBuilder()
            .withFrom(
                new RuleFromBuilder()
                    .withSource(new SourceBuilder().withPrincipals("cluster.local/ns/default/sa/sleep").build())
                    .build(),
                new RuleFromBuilder().withSource(new SourceBuilder().withNamespaces("dev").build()).build())
            .withTo(new RuleToBuilder().withOperation(new OperationBuilder().withMethods("GET").build()).build())
            .withWhen(
                new ConditionBuilder().withKey("request.auth.claims[iss]").withValues("https://accounts.google.com").build())
            .build())
        .endSpec()
        .build());

    System.out.println("Listing AuthorizationPolicy instances:");
    AuthorizationPolicyList list = client.v1beta1().authorizationPolicies().inNamespace(NAMESPACE).list();
    list.getItems().forEach(b -> System.out.println(b.getMetadata().getName()));
    System.out.println("Done");
  }
}
