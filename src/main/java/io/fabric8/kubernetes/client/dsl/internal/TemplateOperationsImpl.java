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
package io.fabric8.kubernetes.client.dsl.internal;

import com.ning.http.client.AsyncHttpClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ProcessableResource;
import io.fabric8.openshift.api.model.DoneableTemplate;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateList;

import java.net.MalformedURLException;
import java.net.URL;

public class TemplateOperationsImpl extends BaseProcessableOperation<Template, TemplateList, DoneableTemplate, ProcessableResource<Template, DoneableTemplate>> {

  public TemplateOperationsImpl(AsyncHttpClient httpClient, URL rootUrl) {
    super(httpClient, rootUrl, "templates", null, null, Template.class, TemplateList.class, DoneableTemplate.class);
  }

  public TemplateOperationsImpl(AsyncHttpClient httpClient, URL rootUrl, String namespace, String name) {
    super(httpClient, rootUrl, "templates", namespace, name);
  }

  @Override
  public Template process(Template item) {
    AsyncHttpClient.BoundRequestBuilder requestBuilder = null;
    try {
      requestBuilder = getHttpClient().preparePost(getProcessUrl().toString());

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
    requestUrl = new URL(requestUrl,  "processedtemplates/");
    return requestUrl;
  }
}
