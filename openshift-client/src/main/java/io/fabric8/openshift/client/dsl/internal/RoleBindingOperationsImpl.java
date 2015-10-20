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
package io.fabric8.openshift.client.dsl.internal;

import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.openshift.api.model.DoneableRoleBinding;
import io.fabric8.openshift.api.model.RoleBinding;
import io.fabric8.openshift.api.model.RoleBindingList;
import io.fabric8.openshift.client.OpenShiftClient;

public class RoleBindingOperationsImpl extends OpenShiftOperation<OpenShiftClient, RoleBinding, RoleBindingList, DoneableRoleBinding, ClientResource<RoleBinding, DoneableRoleBinding>> {
  public RoleBindingOperationsImpl(OpenShiftClient client) {
    this(client, client.getNamespace(), null, true, null);
  }

  public RoleBindingOperationsImpl(OpenShiftClient client, String namespace, String name, Boolean cascading, RoleBinding item) {
    super(client, "rolebindings", namespace, name, cascading, item);
  }
}
