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
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.HasMetadataVisitiableBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.dsl.*;
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

public class NamespaceVisitFromServerGetDeleteRecreateApplicableImpl extends OperationSupport implements NamespaceVisitFromServerGetDeleteRecreateApplicable<List<HasMetadata>, Boolean> {

    private static final Logger LOGGER = LoggerFactory.getLogger(NamespaceVisitFromServerGetDeleteRecreateApplicableImpl.class);
    private static final String EXPRESSION = "expression";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final String namespace;

    private final Boolean fromServer;
    private final Boolean deletingExisting;
    private final List<Visitor> visitors;
    private final Object item;
    private final ResourceHandler handler;
    private final long gracePeriodSeconds;

    public NamespaceVisitFromServerGetDeleteRecreateApplicableImpl(OkHttpClient client, Config config, String namespace, Boolean fromServer, Boolean deletingExisting, List<Visitor> visitors, InputStream is) {
        this(client, config, namespace, fromServer, deletingExisting, visitors, unmarshal(is), -1);
    }

    public NamespaceVisitFromServerGetDeleteRecreateApplicableImpl(OkHttpClient client, Config config, String namespace, Boolean fromServer, Boolean deletingExisting, List<Visitor> visitors, Object item, long gracePeriodSeconds) {
        super(client, config, null, null, null, null, null);
        this.namespace = namespace;
        this.fromServer = fromServer;
        this.deletingExisting = deletingExisting;
        this.visitors = visitors != null ? visitors : new ArrayList<Visitor>();
        this.item = item;
        this.handler = handlerOf(item);
        if (handler == null) {
            throw new KubernetesClientException("No handler found for object:" + item);
        }
        this.gracePeriodSeconds = gracePeriodSeconds;
    }

    @Override
    public List<HasMetadata> apply() {
        List<HasMetadata> result = new ArrayList<>();
        for (HasMetadata meta : acceptVisitors(asHasMetadata(item, true), visitors)) {
            ResourceHandler<HasMetadata, HasMetadataVisitiableBuilder> h = handlerOf(meta);
            HasMetadata r = h.reload(client, config, namespace, meta);
            if (r == null) {
                HasMetadata created = h.create(client, config, namespace, meta);
                if (created != null) {
                    result.add(created);
                }
            } else if(deletingExisting) {
                Boolean deleted = h.delete(client, config, namespace, meta);
                if (!deleted) {
                    throw new KubernetesClientException("Failed to delete existing item:" + meta);
                }

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
                    HasMetadata edited = reloaded;
                    //Let's apply any visitor that might have been specified.
                    for (Visitor v : visitors) {
                        h.edit(edited).accept(v).build();
                    }
                    result.add(reloaded);
                }
            }
            return result;
        } else {
            return acceptVisitors(asHasMetadata(item, true), visitors);
        }
    }

    private static List<HasMetadata> acceptVisitors(List<HasMetadata> list, List<Visitor> visitors) {
        List<HasMetadata> result = new ArrayList<>();
        for (HasMetadata item : list) {
            ResourceHandler<HasMetadata, HasMetadataVisitiableBuilder> h = handlerOf(item);
            VisitableBuilder<HasMetadata, ?> builder = h.edit(item);

            //Let's apply any visitor that might have been specified.
            for (Visitor v : visitors) {
                builder.accept(v);
            }
            result.add(builder.build());
        }
        return result;
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
    public VisitFromServerGetDeleteRecreateApplicable<List<HasMetadata>, Boolean> inNamespace(String namespace) {
        return new NamespaceVisitFromServerGetDeleteRecreateApplicableImpl(client, config, namespace, fromServer, deletingExisting, visitors, item, gracePeriodSeconds);
    }

    @Override
    public Gettable<List<HasMetadata>> fromServer() {
        return new NamespaceVisitFromServerGetDeleteRecreateApplicableImpl(client, config, namespace, true, deletingExisting, visitors, item, gracePeriodSeconds);
    }

    @Override
    public Applicable<List<HasMetadata>> deletingExisting() {
        return new NamespaceVisitFromServerGetDeleteRecreateApplicableImpl(client, config, namespace, fromServer, true, visitors, item, gracePeriodSeconds);
    }

    @Override
    public VisitFromServerGetDeleteRecreateApplicable<List<HasMetadata>, Boolean> accept(Visitor visitor) {
        List<Visitor> newVisitors = new ArrayList<>(visitors);
        newVisitors.add(visitor);
        return new NamespaceVisitFromServerGetDeleteRecreateApplicableImpl(client, config, namespace, fromServer, true, newVisitors, item, gracePeriodSeconds);
    }

  @Override public Deletable<Boolean> withGracePeriod(long gracePeriodSeconds)
  {
    return new NamespaceVisitFromServerGetDeleteRecreateApplicableImpl(client, config, namespace, fromServer, true, visitors, item, gracePeriodSeconds);
  }
}
