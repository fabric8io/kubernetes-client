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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mifmif.common.regex.Generex;
import com.squareup.okhttp.OkHttpClient;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.HasMetadataVisitiableBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.dsl.GetApplyDeletable;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.NamespaceGetApplyDeletable;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.handlers.KubernetesListHandler;
import io.fabric8.kubernetes.client.utils.ResourceCompare;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.api.model.Parameter;
import io.fabric8.openshift.api.model.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class NamespaceGetApplyDeletableImpl extends OperationSupport implements NamespaceGetApplyDeletable<List<HasMetadata>, Boolean> {

    private static final Logger LOGGER = LoggerFactory.getLogger(NamespaceGetApplyDeletableImpl.class);
    private static final String EXPRESSION = "expression";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final String namespace;
    private final Boolean fromServer;
    private final Object item;
    private final ResourceHandler hanlder;

    public NamespaceGetApplyDeletableImpl(OkHttpClient client, Config config, String namespace, Boolean fromServer, InputStream is) {
        this(client, config, namespace, fromServer, unmarshal(is));
    }

    public NamespaceGetApplyDeletableImpl(OkHttpClient client, Config config, String namespace, Boolean fromServer, Object item) {
        super(client, config, null, null, null, null, null);
        this.namespace = namespace;
        this.fromServer = fromServer;
        this.item = item;
        this.hanlder = handlerOf(item);
        if (hanlder == null) {
            throw new KubernetesClientException("No handler found for object:" + item);
        }
    }

    @Override
    public List<HasMetadata> apply() {
        List<HasMetadata> result = new ArrayList<>();
        for (HasMetadata meta : asHasMetadata(item, true)) {
            ResourceHandler<HasMetadata, HasMetadataVisitiableBuilder> h = handlerOf(meta);
            HasMetadata r = h.reload(client, config, namespace, meta);
            if (r == null) {
                HasMetadata created = h.create(client, config, namespace, meta);
                if (created != null) {
                    result.add(created);
                }
            } else if (ResourceCompare.equals(r, meta)) {
                LOGGER.debug("Item has not changed. Skipping");
            } else {
                HasMetadata replaced = h.replace(client, config, namespace, meta);
                if (replaced != null) {
                    result.add(replaced);
                }
            }
        }
        return result;
    }

    @Override
    public Boolean delete() {
        //First pass check before deleting
        for (HasMetadata meta : asHasMetadata(item, false)) {
            if (handlerOf(meta) == null) {
                return false;
            }
        }

        //Second pass do delete
        for (HasMetadata meta : asHasMetadata(item, true)) {
            ResourceHandler<HasMetadata, HasMetadataVisitiableBuilder> h = handlerOf(meta);
            if (!h.delete(client, config, namespace != null ? namespace : namespaceOf(meta), meta)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<HasMetadata> get() {
        if (fromServer) {
            List<HasMetadata> result = new ArrayList<>();
            for (HasMetadata meta : asHasMetadata(item, false)) {
                ResourceHandler<HasMetadata, HasMetadataVisitiableBuilder> h = handlerOf(meta);
                HasMetadata reloaded = h.reload(client, config, namespace, meta);
                if (reloaded != null) {
                    result.add(reloaded);
                }
            }
            return result;
        } else {
            return asHasMetadata(item, false);
        }
    }


    private static <T> List<HasMetadata> asHasMetadata(T item, Boolean enableProccessing) {
        List<HasMetadata> result = new ArrayList<>();
        if (item instanceof KubernetesList) {
            result.addAll(((KubernetesList) item).getItems());
        } else if (item instanceof Template) {
            
            if (!enableProccessing) {
                result.addAll(((Template) item).getObjects());
            } else {
                result.addAll(processTemplate((Template)item, false));
            }
        } else if (item instanceof HasMetadata) {
            result.add((HasMetadata) item);
        }
        return result;
    }

    private static <T> String nameOf(T item) {
        if (item instanceof HasMetadata) {
            return ((HasMetadata) item).getMetadata().getName();
        } else {
            return null;
        }
    }

    private static <T> String namespaceOf(T item) {
        if (item instanceof HasMetadata) {
            return ((HasMetadata) item).getMetadata().getNamespace();
        } else {
            return null;
        }
    }

    private static <T> ResourceHandler handlerOf(T item) {
        if (item instanceof HasMetadata) {
            return Handlers.<HasMetadata, HasMetadataVisitiableBuilder>get(((HasMetadata) item).getKind());
        } else if (item instanceof KubernetesList) {
            return new KubernetesListHandler();
        } else {
            return null;
        }
    }
    
    private static List<HasMetadata> processTemplate(Template template, Boolean failOnMissing)  {
        List<Parameter> parameters = template != null ? template.getParameters() : null;
        KubernetesList list = new KubernetesListBuilder()
                .withItems(template.getObjects())
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
                        } else if (failOnMissing) {
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

    @Override
    public GetApplyDeletable<List<HasMetadata>, Boolean> inNamespace(String namespace) {
        return new NamespaceGetApplyDeletableImpl(client, config, namespace, fromServer, item);
    }

    @Override
    public Gettable<List<HasMetadata>> fromServer() {
        return new NamespaceGetApplyDeletableImpl(client, config, namespace, true, item);
    }
}
