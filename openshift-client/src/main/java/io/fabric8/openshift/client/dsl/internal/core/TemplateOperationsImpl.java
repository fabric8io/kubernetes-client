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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.extension.ExtensibleResourceAdapter;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.api.model.Parameter;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.client.ParameterValue;
import io.fabric8.openshift.client.dsl.TemplateResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TemplateOperationsImpl
    extends ExtensibleResourceAdapter<Template>
    implements TemplateResource {

  private static final Logger logger = LoggerFactory.getLogger(TemplateOperationsImpl.class);
  private static final String EXPRESSION = "expression";
  private static final TypeReference<HashMap<String, String>> MAPS_REFERENCE = new TypeReference<HashMap<String, String>>() {
  };

  @Override
  public ExtensibleResourceAdapter<Template> newInstance() {
    return new TemplateOperationsImpl();
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
    return process(Serialization.unmarshal(is, MAPS_REFERENCE));
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

      t = this.operation(Scope.NAMESPACE, "processedtemplates", "POST", t, Template.class);
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
    return processLocally(Serialization.unmarshal(is, MAPS_REFERENCE));
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
  public KubernetesList processLocally(Map<String, String> valuesMap) {
    Template t = get();

    List<Parameter> parameters = t != null ? t.getParameters() : null;
    KubernetesList list = new KubernetesListBuilder()
        .withItems(t != null && t.getObjects() != null ? t.getObjects() : Collections.<HasMetadata> emptyList())
        .build();

    String json = Serialization.asJson(list);
    String last = null;

    if (parameters != null && !parameters.isEmpty()) {
      while (!Objects.equals(last, json)) {
        last = json;
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

    return Serialization.unmarshal(json, KubernetesList.class);
  }

}
