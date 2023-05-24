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
package io.fabric8.tekton.client.dsl;

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.tekton.resolution.v1alpha1.ResolutionRequest;
import io.fabric8.tekton.resolution.v1alpha1.ResolutionRequestList;
import io.fabric8.tekton.triggers.v1alpha1.*;

public interface V1alpha1APIGroupDSL extends Client {
  /**
   * API entrypoint for TriggerTemplate(triggers.tekton.dev/v1alpha1)
   *
   * @return MixedOperation for TriggerTemplate class
   */
  MixedOperation<TriggerTemplate, TriggerTemplateList, Resource<TriggerTemplate>> triggerTemplates();

  /**
   * API entrypoint for TriggerBinding(triggers.tekton.dev/v1alpha1)
   *
   * @return MixedOperation for TriggerBinding class
   */
  MixedOperation<TriggerBinding, TriggerBindingList, Resource<TriggerBinding>> triggerBindings();

  /**
   * API entrypoint for Trigger(triggers.tekton.dev/v1alpha1)
   *
   * @return MixedOperation for Trigger class
   */
  MixedOperation<Trigger, TriggerList, Resource<Trigger>> triggers();

  /**
   * API entrypoint for EventListener(triggers.tekton.dev/v1alpha1)
   *
   * @return MixedOperation for EventListener class
   */
  MixedOperation<EventListener, EventListenerList, Resource<EventListener>> eventListeners();

  /**
   * API entrypoint for ClusterTriggerBinding(triggers.tekton.dev/v1alpha1)
   *
   * @return MixedOperation for ClusterTriggerBinding class
   */
  NonNamespaceOperation<ClusterTriggerBinding, ClusterTriggerBindingList, Resource<ClusterTriggerBinding>> clusterTriggerBindings();

  /**
   * API entrypoint for ClusterInterceptor(triggers.tekton.dev/v1alpha1)
   *
   * @return MixedOperation for ClusterInterceptor class
   */
  NonNamespaceOperation<ClusterInterceptor, ClusterInterceptorList, Resource<ClusterInterceptor>> clusterInterceptors();

  /**
   * API entrypoint for Interceptor(triggers.tekton.dev/v1alpha1)
   *
   * @return MixedOperation for Interceptor class
   */
  MixedOperation<Interceptor, InterceptorList, Resource<Interceptor>> interceptors();

  /**
   * API entrypoint for ResolutionRequest(resolution.tekton.dev/v1alpha1)
   *
   * @return MixedOperation for ResolutionRequest class
   */
  MixedOperation<ResolutionRequest, ResolutionRequestList, Resource<ResolutionRequest>> resolutionRequests();
}
