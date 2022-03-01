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
package io.fabric8.kubernetes.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;

import io.fabric8.kubernetes.model.annotation.Generated;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "apiVersion",
        "kind",
        "metadata",
        "items",
})
@JsonDeserialize(using = JsonDeserializer.None.class)
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage=true, builderPackage = "io.fabric8.kubernetes.api.builder")
public class KubernetesList extends BaseKubernetesList implements KubernetesResource {

    /**
     * No args constructor for use in serialization
     */
    public KubernetesList() {
        super();
    }

    public KubernetesList(String apiVersion,
                          List<HasMetadata> items,
                          String kind,
                          ListMeta metadata) {
        super(apiVersion, items, kind, metadata);
    }

    //Let's just override those, cause some IDEs can't handle extending a generated class and can't see those and get crazy.
    @Override
    public String getKind() {
      return super.getKind();
    }

    @Override
    public String getApiVersion() {
      return super.getApiVersion();
    }

    @Override
    public List<HasMetadata> getItems() {
      return super.getItems();
    }
}
