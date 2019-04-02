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

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.authorization.*;
import io.fabric8.kubernetes.api.model.authorization.DoneableLocalSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.DoneableSubjectAccessReview;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Createable;
import io.fabric8.kubernetes.client.dsl.SubjectAccessReviewDSL;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class SubjectAccessReviewDSLImpl extends OperationSupport implements SubjectAccessReviewDSL {

  private static final String AUTHORIZATION = "authorization.k8s.io/v1";
  private static final String SAR_PLURAL = "subjectaccessreviews";
  private static final String LSAR_PLURAL = "localsubjectaccessreviews";

  private boolean isNamespaced = false;

  public SubjectAccessReviewDSLImpl(OperationContext context) {
    super(context.withApiGroupName(AUTHORIZATION).withPlural(SAR_PLURAL));
  }

  private SubjectAccessReviewDSLImpl(OperationContext context, String namespace, String plural, boolean isNamespaced) {
    super(context.withApiGroupName(AUTHORIZATION).withNamespace(namespace).withPlural(plural));
    this.isNamespaced = isNamespaced;
  }

  public SubjectAccessReviewDSLImpl(OkHttpClient client, Config config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  @Override
  public boolean isResourceNamespaced() {
    return isNamespaced;
  }

  @Override
  public SubjectAccessReview create(SubjectAccessReview... resources) {
    return new CreatableSubjectAccessReview().create(resources);
  }

  @Override
  public DoneableSubjectAccessReview createNew() {
    return new CreatableSubjectAccessReview().createNew();
  }

  @Override
  public Createable<LocalSubjectAccessReview, LocalSubjectAccessReview, DoneableLocalSubjectAccessReview> inNamespace(String namespace) {
    //Should we use this namespace to set the metadata namespace and the spec namespace of the LocalSubjectAccessReview object?
    return new SubjectAccessReviewDSLImpl(this.context, namespace, LSAR_PLURAL, true).local(namespace);
  }

  private Createable<LocalSubjectAccessReview, LocalSubjectAccessReview, DoneableLocalSubjectAccessReview> local(String namespace) {
    return new CreatableLocalSubjectAccessReview(namespace);
  }

  private class CreatableLocalSubjectAccessReview implements Createable<LocalSubjectAccessReview, LocalSubjectAccessReview, DoneableLocalSubjectAccessReview> {

    private final String namespace;

    CreatableLocalSubjectAccessReview(String namespace) {
      this.namespace = namespace;
    }

    @Override
    public LocalSubjectAccessReview create(LocalSubjectAccessReview... resources) {
      try {
        if (resources.length > 1) {
          throw new IllegalArgumentException("Too many items to create.");
        } else if (resources.length == 1) {
          setNamespace(resources[0]);
          return handleCreate(resources[0], LocalSubjectAccessReview.class);
        } else {
          throw new IllegalArgumentException("Nothing to create.");
        }
      } catch (InterruptedException | ExecutionException | IOException e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    }

    private void setNamespace(LocalSubjectAccessReview resource) {
      ObjectMeta meta = resource.getMetadata();

      if(meta == null) {
        meta = new ObjectMeta();
        resource.setMetadata(meta);
      }

      if(Utils.isNullOrEmpty(meta.getNamespace())) {
        meta.setNamespace(this.namespace);
      }

      SubjectAccessReviewSpec spec = resource.getSpec();
      if(spec != null) {
        if (spec.getResourceAttributes() != null
          && Utils.isNullOrEmpty(spec.getResourceAttributes().getNamespace())) {
          spec.getResourceAttributes().setNamespace(this.namespace);
        }
      }
    }

    @Override
    public DoneableLocalSubjectAccessReview createNew() {
      return new DoneableLocalSubjectAccessReview(this::create);
    }
  }

  private class CreatableSubjectAccessReview implements Createable<SubjectAccessReview, SubjectAccessReview, DoneableSubjectAccessReview> {

    @Override
    public SubjectAccessReview create(SubjectAccessReview... resources) {
      try {
        if (resources.length > 1) {
          throw new IllegalArgumentException("Too many items to create.");
        } else if (resources.length == 1) {
          return handleCreate(resources[0], SubjectAccessReview.class);
        } else {
          throw new IllegalArgumentException("Nothing to create.");
        }
      } catch (InterruptedException | ExecutionException | IOException e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    }

    @Override
    public DoneableSubjectAccessReview createNew() {
      return new DoneableSubjectAccessReview(this::create);
    }
  }
}

