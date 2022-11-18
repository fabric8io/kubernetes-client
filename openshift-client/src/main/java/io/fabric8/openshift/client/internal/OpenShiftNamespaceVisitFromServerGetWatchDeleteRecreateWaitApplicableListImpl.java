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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.internal.NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.api.model.Parameter;
import io.fabric8.openshift.api.model.Template;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl
    extends NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl {

  public OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(Client client, Object item) {
    super(client, item);
  }

  public OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(OperationContext context) {
    super(context);
  }

  @Override
  protected List<HasMetadata> asHasMetadata(Object item) {
    if (item instanceof Template) {
      return processTemplateList((Template) item, true);
    }
    return super.asHasMetadata(item);
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

  @Override
  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl newInstance(OperationContext context) {
    return new OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(context);
  }
}
