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
package io.fabric8.openshift.client.internal;

import com.mifmif.common.regex.Generex;
import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.internal.NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.api.model.Parameter;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.client.internal.readiness.OpenShiftReadiness;
import okhttp3.OkHttpClient;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl extends NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl {
  public OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(OkHttpClient client, Config config, String namespace, String explicitNamespace, Boolean fromServer, Boolean deletingExisting, List<Visitor> visitors, InputStream is, Map<String, String> parameters, Boolean cascading, DeletionPropagation propagationPolicy, boolean dryRun) {
    super(client, config, namespace, explicitNamespace, fromServer, deletingExisting, visitors, is, parameters, cascading, propagationPolicy, dryRun);
  }

  public OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(OkHttpClient client, Config config, String namespace, String explicitNamespace, Boolean fromServer, Boolean deletingExisting, List<Visitor> visitors, Object item, Map<String, String> parameters, DeletionPropagation propagationPolicy, Boolean cascading, boolean dryRun) {
    super(client, config, namespace, explicitNamespace, fromServer, deletingExisting, visitors, item, parameters, propagationPolicy, cascading, dryRun);
  }

  public OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(OkHttpClient client, Config config, String namespace, String explicitNamespace, Boolean fromServer, Boolean deletingExisting, List<Visitor> visitors, Object item, InputStream inputStream, Map<String, String> parameters, long gracePeriodSeconds, DeletionPropagation propagationPolicy, Boolean cascading, long watchRetryInitialBackoffMillis, double watchRetryBackoffMultiplier, boolean dryRun) {
    super(client, config, namespace, explicitNamespace, fromServer, deletingExisting, visitors, item, inputStream, parameters, gracePeriodSeconds, propagationPolicy, cascading, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, dryRun);
  }

  @Override
  protected OpenShiftReadiness getReadiness() {
    return OpenShiftReadiness.getInstance();
  }

  @Override
  protected <T> List<HasMetadata> asHasMetadata(T item, Boolean enableProccessing) {
    List<HasMetadata> result = new ArrayList<>();
    if (item instanceof KubernetesList) {
      result.addAll(((KubernetesList) item).getItems());
    } else if (item instanceof Template) {
      result.addAll(processTemplateList((Template)item, enableProccessing));
    } else if (item instanceof KubernetesResourceList) {
      result.addAll(((KubernetesResourceList) item).getItems());
    } else if (item instanceof HasMetadata) {
      result.add((HasMetadata) item);
    } else if (item instanceof String) {
      try (InputStream is = new ByteArrayInputStream(((String) item).getBytes(StandardCharsets.UTF_8))) {
        return asHasMetadata(unmarshal(is), enableProccessing);
      } catch (IOException e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    } else if (item instanceof Collection) {
      for (Object o : (Collection) item) {
        if (o instanceof HasMetadata) {
          result.add((HasMetadata) o);
        }
      }
    }
    return result;
  }

  private static List<HasMetadata> processTemplate(Template template, Boolean failOnMissing) {
    List<Parameter> parameters = template != null ? template.getParameters() : null;
    List<HasMetadata> objects = template != null ? template.getObjects() : Collections.emptyList();
    KubernetesList list = new KubernetesListBuilder()
      .withItems(objects)
      .build();

    try {
      String json = OBJECT_MAPPER.writeValueAsString(list);
      if (parameters != null && !parameters.isEmpty()) {
        // lets make a few passes in case there's expressions in values
        for (int i = 0; i < 5; i++) {
          for (Parameter parameter : parameters) {
            String name = parameter.getName();
            String regex = "${" + name + "}";
            String value;
            if (Utils.isNotNullOrEmpty(parameter.getValue())) {
              value = parameter.getValue();
            } else if (EXPRESSION.equals(parameter.getGenerate())) {
              Generex generex = new Generex(parameter.getFrom());
              value = generex.random();
            } else if (Boolean.TRUE.equals(failOnMissing)) {
              throw new IllegalArgumentException("No value available for parameter name: " + name);
            } else {
              value = "";
            }
            json = json.replace(regex, value);
          }
        }
      }

      list = OBJECT_MAPPER.readValue(json, KubernetesList.class);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
    return list.getItems();
  }

  private static List<HasMetadata> processTemplateList(Template item, Boolean enableProccessing) {
    List<HasMetadata> result = new ArrayList<>();
    if (Boolean.FALSE.equals(enableProccessing)) {
      result.addAll(item.getObjects());
    } else {
      result.addAll(processTemplate(item, false));
    }
    return result;
  }
}
