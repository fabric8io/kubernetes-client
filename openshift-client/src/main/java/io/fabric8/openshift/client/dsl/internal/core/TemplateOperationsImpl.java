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
package io.fabric8.openshift.client.dsl.internal.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mifmif.common.regex.Generex;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpRequest.Builder;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.api.model.Parameter;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateBuilder;
import io.fabric8.openshift.api.model.TemplateList;
import io.fabric8.openshift.client.OpenshiftClientContext;
import io.fabric8.openshift.client.ParameterValue;
import io.fabric8.openshift.client.dsl.TemplateOperation;
import io.fabric8.openshift.client.dsl.TemplateResource;
import io.fabric8.openshift.client.dsl.internal.OpenShiftOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.TEMPLATE;

public class TemplateOperationsImpl
  extends OpenShiftOperation<Template, TemplateList, TemplateResource<Template, KubernetesList>>
  implements TemplateOperation {

  private static final Logger logger = LoggerFactory.getLogger(TemplateOperationsImpl.class);
  private static final String EXPRESSION = "expression";
  private static final TypeReference<HashMap<String, String>> MAPS_REFERENCE = new TypeReference<HashMap<String, String>>() {
  };

  private final Map<String, String> parameters;

  public TemplateOperationsImpl(OpenshiftClientContext clientContext) {
    this(HasMetadataOperationsImpl.defaultContext(clientContext), null);
  }

  public TemplateOperationsImpl(OperationContext context, Map<String, String> parameters) {
    super(context.withApiGroupName(TEMPLATE)
      .withPlural("templates"), Template.class, TemplateList.class);
    this.parameters = parameters;
  }

  @Override
  public TemplateOperationsImpl newInstance(OperationContext context) {
    return new TemplateOperationsImpl(context, parameters);
  }

  public TemplateOperationsImpl newInstance(OperationContext context, Map<String, String> parameters) {
    return new TemplateOperationsImpl(context, parameters == null ? null : new LinkedHashMap<>(parameters));
  }

  @Override
  public KubernetesList process(File f) {
    try (FileInputStream is = new FileInputStream(f)) {
      return process(is);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("process"), e);
    }
  }

  @Override
  public KubernetesList process(InputStream is) {
    return process(unmarshal(is, MAPS_REFERENCE));
  }

  @Override
  public KubernetesList process(Map<String, String> valuesMap) {
    Template t = get();
    try {
      List<Parameter> parameters = t.getParameters();
      if (parameters != null) {
        for (Parameter p : parameters) {
          String v = valuesMap.get(p.getName());
          if (v != null) {
            p.setGenerate(null);
            p.setValue(v);
          }
        }
      }

      HttpRequest.Builder requestBuilder = this.httpClient.newHttpRequestBuilder().post(JSON, JSON_MAPPER.writeValueAsString(t)).url(getProcessUrl());
      t = handleResponse(requestBuilder);
      KubernetesList l = new KubernetesList();
      l.setItems(t.getObjects());
      return l;
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(forOperationType("process"), e);
    }
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
  public KubernetesList processLocally(File f) {
    try (FileInputStream is = new FileInputStream(f)) {
      return processLocally(is);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("processLocally"), e);
    }
  }

  @Override
  public KubernetesList processLocally(InputStream is) {
    return processLocally(unmarshal(is, MAPS_REFERENCE));
  }

  @Override
  public KubernetesList processLocally(ParameterValue... values) {
    Map<String, String> valuesMap = new HashMap<>(values.length);
    for (ParameterValue pv : values) {
      valuesMap.put(pv.getName(), pv.getValue());
    }
    return processLocally(valuesMap);
  }

  @Override
  public MixedOperation<Template, TemplateList, TemplateResource<Template, KubernetesList>> withParameters(Map<String, String> parameters) {
    return newInstance(context, parameters);
  }

  @Override
  public KubernetesList processLocally(Map<String, String> valuesMap)  {
    String namespace = getItem() != null ? getItem().getMetadata().getNamespace() : getNamespace();
    if (namespace == null) {
      namespace = getConfig().getNamespace();
    }

    String name = getItem() != null ? getItem().getMetadata().getName() : getName();

    Template t = withParameters(valuesMap)
      .inNamespace(namespace)
      .withName(name)
      .get();

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
            String parameterName = parameter.getName();
            String parameterValue;
            if (valuesMap.containsKey(parameterName)) {
              parameterValue = valuesMap.get(parameterName);
            } else if (Utils.isNotNullOrEmpty(parameter.getValue())) {
              parameterValue = parameter.getValue();
            } else if (EXPRESSION.equals(parameter.getGenerate())) {
              Generex generex = new Generex(parameter.getFrom());
              parameterValue = generex.random();
            } else if (parameter.getRequired() == null || !parameter.getRequired()) {
              parameterValue = "";
            } else {
              throw new IllegalArgumentException("No value available for parameter name: " + parameterName);
            }
            if (parameterValue == null) {
              logger.debug("Parameter {} has a null value", parameterName);
              parameterValue = "";
            }
            json = Utils.interpolateString(json, Collections.singletonMap(parameterName, parameterValue));
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

  @Override
  public TemplateResource<Template, KubernetesList> load(InputStream is) {
    String generatedName = Utils.randomString("template-", 10);
    Template template = null;
    Object item = Serialization.unmarshal(is, parameters);
    if (item instanceof Template) {
      template = (Template) item;
    } else if (item instanceof HasMetadata) {
      HasMetadata h = (HasMetadata) item;
      template = new TemplateBuilder()
        .withNewMetadata()
          .withName(generatedName)
          .withNamespace(h.getMetadata() != null ? h.getMetadata().getNamespace() : null)
        .endMetadata()
        .withObjects(h).build();
    } else if (item instanceof KubernetesResourceList) {
      List<HasMetadata> list = ((KubernetesResourceList<HasMetadata>) item).getItems();
      template = new TemplateBuilder()
        .withNewMetadata()
          .withName(generatedName)
        .endMetadata()
        .withObjects(list.toArray(new HasMetadata[list.size()])).build();
    } else if (item instanceof HasMetadata[]) {
      template = new TemplateBuilder()
        .withNewMetadata()
          .withName(generatedName)
        .endMetadata()
        .withObjects((HasMetadata[]) item).build();
    } else if (item instanceof Collection) {
      List<HasMetadata> items = new ArrayList<>();
      for (Object o : (Collection) item) {
        if (o instanceof HasMetadata) {
          items.add((HasMetadata) o);
        }
      }
      template = new TemplateBuilder()
        .withNewMetadata()
          .withName(generatedName)
        .endMetadata()
        .withObjects(items.toArray(new HasMetadata[items.size()])).build();
    }

    return newInstance(context.withItem(template));
  }

  @Override
  protected Template handleGet(URL resourceUrl) throws InterruptedException, IOException {
    return super.handleGet(resourceUrl, getType(), this.parameters);
  }

  @Override
  protected <T> T handleResponse(Builder requestBuilder, Class<T> type)
      throws InterruptedException, IOException {
    return handleResponse(requestBuilder, type, parameters);
  }

  @Override
  protected VisitableBuilder<Template, ?> createVisitableBuilder(Template item) {
    return new TemplateBuilder(item);
  }

}
