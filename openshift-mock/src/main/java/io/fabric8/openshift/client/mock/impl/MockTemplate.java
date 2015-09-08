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

package io.fabric8.openshift.client.mock.impl;

import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.client.mock.BaseMockOperation;
import io.fabric8.openshift.api.model.DoneableTemplate;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateList;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.dsl.TemplateClientResource;
import io.fabric8.openshift.client.mock.MockProcessableResource;

public class MockTemplate extends BaseMockOperation<OpenShiftClient, Template, TemplateList, DoneableTemplate,
  TemplateClientResource<Template, KubernetesList, DoneableTemplate>,
  MockProcessableResource<Template, DoneableTemplate, Boolean>> {
}
