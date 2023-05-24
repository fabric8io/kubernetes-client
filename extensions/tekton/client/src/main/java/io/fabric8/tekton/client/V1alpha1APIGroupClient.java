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
package io.fabric8.tekton.client;

import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;
import io.fabric8.tekton.client.dsl.V1alpha1APIGroupDSL;
import io.fabric8.tekton.resolution.v1alpha1.ResolutionRequest;
import io.fabric8.tekton.resolution.v1alpha1.ResolutionRequestList;
import io.fabric8.tekton.triggers.v1alpha1.ClusterInterceptor;
import io.fabric8.tekton.triggers.v1alpha1.ClusterInterceptorList;
import io.fabric8.tekton.triggers.v1alpha1.ClusterTriggerBinding;
import io.fabric8.tekton.triggers.v1alpha1.ClusterTriggerBindingList;
import io.fabric8.tekton.triggers.v1alpha1.EventListener;
import io.fabric8.tekton.triggers.v1alpha1.EventListenerList;
import io.fabric8.tekton.triggers.v1alpha1.Interceptor;
import io.fabric8.tekton.triggers.v1alpha1.InterceptorList;
import io.fabric8.tekton.triggers.v1alpha1.Trigger;
import io.fabric8.tekton.triggers.v1alpha1.TriggerBinding;
import io.fabric8.tekton.triggers.v1alpha1.TriggerBindingList;
import io.fabric8.tekton.triggers.v1alpha1.TriggerList;
import io.fabric8.tekton.triggers.v1alpha1.TriggerTemplate;
import io.fabric8.tekton.triggers.v1alpha1.TriggerTemplateList;

public class V1alpha1APIGroupClient extends ClientAdapter<V1alpha1APIGroupClient> implements V1alpha1APIGroupDSL {

  @Override
  public V1alpha1APIGroupClient newInstance() {
    return new V1alpha1APIGroupClient();
  }

  @Override
  public MixedOperation<TriggerTemplate, TriggerTemplateList, Resource<TriggerTemplate>> triggerTemplates() {
    return resources(TriggerTemplate.class, TriggerTemplateList.class);
  }

  @Override
  public MixedOperation<TriggerBinding, TriggerBindingList, Resource<TriggerBinding>> triggerBindings() {
    return resources(TriggerBinding.class, TriggerBindingList.class);
  }

  @Override
  public MixedOperation<Trigger, TriggerList, Resource<Trigger>> triggers() {
    return resources(Trigger.class, TriggerList.class);
  }

  @Override
  public MixedOperation<EventListener, EventListenerList, Resource<EventListener>> eventListeners() {
    return resources(EventListener.class, EventListenerList.class);
  }

  @Override
  public NonNamespaceOperation<ClusterTriggerBinding, ClusterTriggerBindingList, Resource<ClusterTriggerBinding>> clusterTriggerBindings() {
    return resources(ClusterTriggerBinding.class, ClusterTriggerBindingList.class);
  }

  @Override
  public NonNamespaceOperation<ClusterInterceptor, ClusterInterceptorList, Resource<ClusterInterceptor>> clusterInterceptors() {
    return resources(ClusterInterceptor.class, ClusterInterceptorList.class);
  }

  @Override
  public MixedOperation<Interceptor, InterceptorList, Resource<Interceptor>> interceptors() {
    return resources(Interceptor.class, InterceptorList.class);
  }

  @Override
  public MixedOperation<ResolutionRequest, ResolutionRequestList, Resource<ResolutionRequest>> resolutionRequests() {
    return resources(ResolutionRequest.class, ResolutionRequestList.class);
  }
}
