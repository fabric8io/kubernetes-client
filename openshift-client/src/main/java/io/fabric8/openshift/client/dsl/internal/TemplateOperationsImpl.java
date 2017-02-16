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

import com.mifmif.common.regex.Generex;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.openshift.api.model.DoneableTemplate;
import io.fabric8.openshift.api.model.Parameter;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateList;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.ParameterValue;
import io.fabric8.openshift.client.dsl.TemplateResource;
import io.fabric8.openshift.client.dsl.TemplateOperation;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TemplateOperationsImpl
  extends OpenShiftOperation<Template, TemplateList, DoneableTemplate, TemplateResource>
  implements TemplateOperation {

  private static final String EXPRESSION = "expression";

  public TemplateOperationsImpl(OkHttpClient client, OpenShiftConfig config, String namespace) {
    this(client, config, null, namespace, null, true, null, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>());
  }

  public TemplateOperationsImpl(OkHttpClient client, OpenShiftConfig config, String apiVersion, String namespace, String name, Boolean cascading, Template item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
    super(client, config, null, apiVersion, "templates", namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields);
  }

  @Override
  public KubernetesList process(ParameterValue... values) {
    Map<String, String> valuesMap = new HashMap<>(values.length);
    for (ParameterValue pv : values) {
      valuesMap.put(pv.getName(), pv.getValue());
    }
    return process(valuesMap);
  }

  @Override
  public KubernetesList process(Map<String, String> valuesMap) {
    Template t = get();
    try {
      for (Parameter p : t.getParameters()) {
        String v = valuesMap.get(p.getName());
        if (v != null) {
          p.setGenerate(null);
          p.setValue(v);
        }
      }

      RequestBody body = RequestBody.create(JSON, JSON_MAPPER.writeValueAsString(t));
      Request.Builder requestBuilder = new Request.Builder().post(body).url(getProcessUrl());
      t = handleResponse(requestBuilder);
      KubernetesList l = new KubernetesList();
      l.setItems(t.getObjects());
      return l;
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public KubernetesList processLocally(ParameterValue... values) {
    Map<String, String> valuesMap = new HashMap<>(values.length);
    for (ParameterValue pv : values) {
      valuesMap.put(pv.getName(), pv.getValue());
    }
    return processLocally(valuesMap);
  }

  public KubernetesList processLocally(Map<String, String> valuesMap)  {
    Template t = get();

    List<Parameter> parameters = t != null ? t.getParameters() : null;
    KubernetesList list = new KubernetesListBuilder()
      .withItems(t != null && t.getObjects() != null ? t.getObjects() : Collections.<HasMetadata>emptyList())
      .build();

    try {
      String json = JSON_MAPPER.writeValueAsString(list);
      if (parameters != null && !parameters.isEmpty()) {
        // lets make a few passes in case there's expressions in values
        for (int i = 0; i < 5; i++) {
          for (Parameter parameter : parameters) {
            String name = parameter.getName();
            String regex = "${" + name + "}";
            String value;
            if (valuesMap.containsKey(name)) {
              value = valuesMap.get(name);
            } else if (EXPRESSION.equals(parameter.getGenerate())) {
              Generex generex = new Generex(parameter.getFrom());
              value = generex.random();
            } else {
              throw new IllegalArgumentException("No value available for parameter name: " + name);
            }
            json = json.replace(regex, value);
          }
        }
      }

      list = JSON_MAPPER.readValue(json, KubernetesList.class);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
    return list;
  }

  private URL getProcessUrl() throws MalformedURLException {
    URL requestUrl = getRootUrl();
    if (getNamespace() != null) {
      requestUrl = new URL(URLUtils.join(requestUrl.toString(), "namespaces" , getNamespace()));
    }
    requestUrl = new URL(URLUtils.join(requestUrl.toString(), "processedtemplates"));
    return requestUrl;
  }
}
