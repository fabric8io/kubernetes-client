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
import io.fabric8.kubernetes.api.builder.TypedVisitor;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.KubernetesClientTimeoutException;
import io.fabric8.kubernetes.client.internal.SerializationUtils;
import io.fabric8.kubernetes.client.internal.readiness.Readiness;
import io.fabric8.kubernetes.client.utils.Serialization;
import okhttp3.OkHttpClient;
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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static io.fabric8.kubernetes.client.utils.Utils.isNotNullOrEmpty;
import static io.fabric8.kubernetes.client.utils.Utils.isNullOrEmpty;

public class NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl extends OperationSupport implements ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean>,
Waitable<List<HasMetadata>>, Readiable {

    private static final Logger LOGGER = LoggerFactory.getLogger(NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl.class);
    private static final String EXPRESSION = "expression";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final String fallbackNamespace;
    private final String explicitNamespace;

    private final Boolean fromServer;
    private final Boolean deletingExisting;
    private final List<Visitor> visitors;
    private final Object item;
    private final InputStream inputStream;

    private final long gracePeriodSeconds;
    private final Boolean cascading;

  @Override
  public List<HasMetadata> waitUntilReady(final long amount, final TimeUnit timeUnit) throws InterruptedException {
    List<HasMetadata> items = acceptVisitors(asHasMetadata(item, true), visitors);
    if (items.size() == 0) {
      return Collections.emptyList();
    }

    final List<HasMetadata> result = new ArrayList<>();
    final List<HasMetadata> notReady = new ArrayList<>(items);
    final int size = items.size();
    final AtomicInteger ready = new AtomicInteger(0);
    ExecutorService executor = Executors.newFixedThreadPool(size);

      try {
        final CountDownLatch latch = new CountDownLatch(size);
        for (final HasMetadata meta : items) {
          final ResourceHandler<HasMetadata, HasMetadataVisitiableBuilder> h = handlerOf(meta);
          executor.submit(new Runnable() {
            @Override
            public void run() {
              try {
                result.add(h.waitUntilReady(client, config, meta.getMetadata().getNamespace(), meta, amount, timeUnit));
                ready.incrementAndGet();
                notReady.remove(meta);
              } catch (Throwable t) {
                //consider all errors as not ready.
              } finally {
                //We don't want to wait for items that will never become ready
                latch.countDown();
              }
            }
          });
        }
        if(checkReady(latch, size, ready, amount, timeUnit)) {
          return result;
        } else {
          throw new KubernetesClientTimeoutException(notReady, amount, timeUnit);
        }
      } finally {
        executor.shutdown();
      }
  }

  @Override
  public Boolean isReady() {
    for (final HasMetadata meta : acceptVisitors(get(), visitors)) {
      if (!Readiness.isReady(meta)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean> withParameters(Map<String, String> parameters) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(client, config, namespace, explicitNamespace, fromServer, deletingExisting, visitors, null, inputStream, parameters, -1, cascading);
  }

  /**
     * We need to be able to either use an explicit namespace or fallback to the client default.
     * Either-way we need to update the object itself or the client will complain about a mismatch.
     * And this is how we its done.
     */
    private class ChangeNamespace extends TypedVisitor<ObjectMetaBuilder> {

        private final String explicitNamespace;
        private final String fallbackNamespace;

        private ChangeNamespace(String explicitNamespace, String fallbackNamespace) {
            this.explicitNamespace = explicitNamespace;
            this.fallbackNamespace = fallbackNamespace;
        }

        @Override
        public void visit(ObjectMetaBuilder builder) {
            if (isNotNullOrEmpty(explicitNamespace)) {
                builder.withNamespace(explicitNamespace);
            } else if (isNullOrEmpty(builder.getNamespace())) {
                builder.withNamespace(fallbackNamespace);
            }
        }
    }

    public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(OkHttpClient client, Config config, String namespace, String explicitNamespace, Boolean fromServer, Boolean deletingExisting, List<Visitor> visitors, InputStream is, Map<String, String> parameters, Boolean cascading) {
        this(client, config, namespace, explicitNamespace, fromServer, deletingExisting, visitors, null, is, parameters, -1, cascading);
    }

    public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(OkHttpClient client, Config config, String namespace, String explicitNamespace, Boolean fromServer, Boolean deletingExisting, List<Visitor> visitors, Object item, InputStream inputStream, Map<String, String> parameters, long gracePeriodSeconds, Boolean cascading) {
        super(client, config, null, null, null, null, null);
        this.fallbackNamespace = namespace;
        this.explicitNamespace = explicitNamespace;
        this.fromServer = fromServer;
        this.deletingExisting = deletingExisting;
        this.visitors = visitors != null ? new ArrayList<>(visitors) : new ArrayList<Visitor>();

        if (item != null) {
          this.item = item;
        } else if (inputStream != null) {
          this.item = Serialization.unmarshal(inputStream, parameters);
        } else {
          throw new IllegalArgumentException("Need to either specify an Object or an InputStream.");
        }

        this.inputStream = inputStream;
        this.cascading = cascading;
        this.gracePeriodSeconds = gracePeriodSeconds;
        this.visitors.add(new ChangeNamespace(explicitNamespace, fallbackNamespace));
    }

    @Override
    public List<HasMetadata> apply() {
       return createOrReplace();
    }

  @Override
  public List<HasMetadata> createOrReplace() {
    List<HasMetadata> result = new ArrayList<>();
    for (HasMetadata meta : acceptVisitors(asHasMetadata(item, true), visitors)) {
      ResourceHandler<HasMetadata, HasMetadataVisitiableBuilder> h = handlerOf(meta);
      HasMetadata r = h.reload(client, config, meta.getMetadata().getNamespace(), meta);
      String namespaceToUse =  meta.getMetadata().getNamespace();

      if (r == null) {
        HasMetadata created = h.create(client, config, namespaceToUse, meta);
        if (created != null) {
          result.add(created);
        }
      } else if(deletingExisting) {
        Boolean deleted = h.delete(client, config, namespaceToUse, meta);
        if (!deleted) {
          throw new KubernetesClientException("Failed to delete existing item:" + meta);
        }

        HasMetadata created = h.create(client, config, namespaceToUse, meta);
        if (created != null) {
          result.add(created);
        }
      } else if (ResourceCompare.equals(r, meta)) {
        LOGGER.debug("Item has not changed. Skipping");
      } else {
        HasMetadata replaced = h.replace(client, config, namespaceToUse, meta);
        if (replaced != null) {
          result.add(replaced);
        }
      }
    }
    return result;
  }

  @Override
  public Waitable<List<HasMetadata>> createOrReplaceAnd() {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, deletingExisting, visitors, createOrReplace(), inputStream, null, gracePeriodSeconds, cascading);
  }


  @Override
    public Boolean delete() {
        //First pass check before deleting
        for (HasMetadata meta : acceptVisitors(asHasMetadata(item, true), visitors)) {
            if (handlerOf(meta) == null) {
                return false;
            }
        }

        //Second pass do delete
        for (HasMetadata meta :  acceptVisitors(asHasMetadata(item, true), visitors)) {
            ResourceHandler<HasMetadata, HasMetadataVisitiableBuilder> h = handlerOf(meta);
            if (!h.delete(client, config, meta.getMetadata().getNamespace(), meta)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<HasMetadata> get() {
        if (fromServer) {
            List<HasMetadata> result = new ArrayList<>();
            for (HasMetadata meta : acceptVisitors(asHasMetadata(item, true), visitors)) {
                ResourceHandler<HasMetadata, HasMetadataVisitiableBuilder> h = handlerOf(meta);
                HasMetadata reloaded = h.reload(client, config, meta.getMetadata().getNamespace(), meta);
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


    @Override
    public ListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean> inNamespace(String explicitNamespace) {
        return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, deletingExisting, visitors, item, null, null, gracePeriodSeconds, cascading);
    }

    @Override
    public Gettable<List<HasMetadata>> fromServer() {
        return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(client, config, fallbackNamespace, explicitNamespace, true, deletingExisting, visitors, item, null, null, gracePeriodSeconds, cascading);
    }

    @Override
    public Applicable<List<HasMetadata>> deletingExisting() {
        return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, true, visitors, item, null, null, gracePeriodSeconds, cascading);
    }

    @Override
    public ListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean> accept(Visitor visitor) {
        List<Visitor> newVisitors = new ArrayList<>(visitors);
        newVisitors.add(visitor);
        return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, true, newVisitors, item, null, null, gracePeriodSeconds, cascading);
    }

  @Override public CascadingDeletable<Boolean> withGracePeriod(long gracePeriodSeconds)
  {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, true, visitors, item, null, null, gracePeriodSeconds, cascading);
  }


  @Override
  public Deletable<Boolean> cascading(boolean cascading) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, true, visitors, item, null, null, gracePeriodSeconds, cascading);
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
    } else if (item instanceof KubernetesResourceList) {
      result.addAll(((KubernetesResourceList) item).getItems());
    } else if (item instanceof HasMetadata) {
      result.add((HasMetadata) item);
    }  else if (item instanceof String) {
      try (InputStream is = new ByteArrayInputStream(((String)item).getBytes(StandardCharsets.UTF_8))) {
        return asHasMetadata(unmarshal(is), enableProccessing);
      } catch (IOException e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    } else if (item instanceof Collection) {
      for (Object o : (Collection)item) {
        if (o instanceof HasMetadata) {
          result.add((HasMetadata) o);
        }
      }
    }
    return result;
  }

  private static <T> ResourceHandler handlerOf(T item) {
    if (item instanceof HasMetadata) {
      return Handlers.<HasMetadata, HasMetadataVisitiableBuilder>get(((HasMetadata) item).getKind());
    } else if (item instanceof KubernetesList) {
      return new KubernetesListHandler();
    }  else {
      throw new IllegalArgumentException("Could not find a registered handler for item: [" + item + "].");
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

  /**
   * Waits until the latch reaches to zero and then checks if the expected result
   * @param latch       The latch.
   * @param expected    The expected number.
   * @param actual      The actual number.
   * @param amount      The amount of time to wait.
   * @param timeUnit    The timeUnit.
   * @return
   */
  private static boolean checkReady(CountDownLatch latch, int expected, AtomicInteger actual, long amount, TimeUnit timeUnit) {
    try {
      if (latch.await(amount, timeUnit)) {
        return actual.intValue() == expected;
      }
      return false;
    } catch (InterruptedException e) {
      return false;
    }
  }

}
