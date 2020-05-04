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
package io.fabric8.kubernetes.client.dsl.internal.policy.v1beta1;

import io.fabric8.kubernetes.api.model.policy.DoneablePodSecurityPolicy;
import io.fabric8.kubernetes.api.model.policy.PodSecurityPolicy;
import io.fabric8.kubernetes.api.model.policy.PodSecurityPolicyList;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;

public class PodSecurityPolicyOperationsImpl extends HasMetadataOperation<PodSecurityPolicy, PodSecurityPolicyList, DoneablePodSecurityPolicy, Resource<PodSecurityPolicy, DoneablePodSecurityPolicy>>{

  public PodSecurityPolicyOperationsImpl(OkHttpClient client, Config config) {
    this(client, config, null);
  }

  public PodSecurityPolicyOperationsImpl(OkHttpClient client, Config config, String namespace) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config).withNamespace(namespace).withPropagationPolicy(DEFAULT_PROPAGATION_POLICY));
  }

  public PodSecurityPolicyOperationsImpl(OperationContext context) {
    super(context.withApiGroupName("policy")
      .withApiGroupVersion("v1beta1")
      .withPlural("podsecuritypolicies"));
    this.type = PodSecurityPolicy.class;
    this.listType = PodSecurityPolicyList.class;
    this.doneableType = DoneablePodSecurityPolicy.class;
  }

  @Override
  public PodSecurityPolicyOperationsImpl newInstance(OperationContext context) {
    return new PodSecurityPolicyOperationsImpl(context);
  }

  @Override
  public boolean isResourceNamespaced() {
    return false;
  }

}
