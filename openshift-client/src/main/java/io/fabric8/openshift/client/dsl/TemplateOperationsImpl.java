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
package io.fabric8.openshift.client.dsl;

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ProcessableClientResource;
import io.fabric8.kubernetes.client.internal.com.ning.http.client.AsyncHttpClient;
import io.fabric8.openshift.api.model.DoneableTemplate;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateList;
import io.fabric8.openshift.client.OpenShiftClient;

import java.net.MalformedURLException;
import java.net.URL;

public class TemplateOperationsImpl extends OpenshiftOperation<OpenShiftClient, Template, TemplateList, DoneableTemplate, ProcessableClientResource<Template, DoneableTemplate>>
  implements ProcessableClientResource<Template, DoneableTemplate> {

  public TemplateOperationsImpl(OpenShiftClient client) {
    super(client, "templates", null, null, true);
  }

  public TemplateOperationsImpl(OpenShiftClient client, String namespace, String name, Boolean cascading) {
    super(client, "templates", namespace, name, cascading);
  }

  @Override
  public Template process(Template item) {
    AsyncHttpClient.BoundRequestBuilder requestBuilder = null;
    try {
      requestBuilder = getClient().getHttpClient().preparePost(getProcessUrl().toString());

      requestBuilder.setBody(mapper.writer().writeValueAsString(item));
      return handleResponse(requestBuilder, 201);
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  private URL getProcessUrl() throws MalformedURLException {
    URL requestUrl = getRootUrl();
    if (getNamespace() != null) {
      requestUrl = new URL(requestUrl, "namespaces/" + getNamespace() + "/");
    }
    requestUrl = new URL(requestUrl, "processedtemplates/");
    return requestUrl;
  }
}
