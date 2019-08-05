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

import io.fabric8.kubernetes.api.model.authorization.SelfSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.SelfSubjectAccessReviewBuilder;
import io.fabric8.kubernetes.api.model.authorization.SelfSubjectRulesReview;
import io.fabric8.kubernetes.client.dsl.Createable;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.openshift.api.model.*;
import io.fabric8.openshift.api.model.LocalSubjectAccessReviewBuilder;
import io.fabric8.openshift.api.model.SubjectAccessReviewBuilder;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.dsl.*;
import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.client.OpenShiftConfig;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.AUTHORIZATION;

public class SubjectAccessReviewOperationImpl extends OperationSupport implements SubjectAccessReviewOperation<CreateableSubjectAccessReview, CreateableLocalSubjectAccessReview, CreateableSelfSubjectAccessReview, CreateableSelfSubjectRulesReview> {

  public SubjectAccessReviewOperationImpl(OkHttpClient client, OpenShiftConfig config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public SubjectAccessReviewOperationImpl(OperationContext context) {
    super(context.withApiGroupName(AUTHORIZATION)
      .withPlural("subjectaccessreviews"));
  }

  @Override
  public CreateableLocalSubjectAccessReview inNamespace(String namespace) {
    return new SubjectAccessReviewOperationImpl(client, OpenShiftConfig.wrap(getConfig())).local();
  }

  @Override
  public SubjectAccessReviewResponse create(SubjectAccessReview... item) {
    return new CreateableSubjectAccessReviewImpl(client).create(item);
  }

  @Override
  public CreateableSubjectAccessReview createNew() {
    return new CreateableSubjectAccessReviewImpl(client).createNew();
  }

  @Override
  public URL getRootUrl() {
    OpenShiftConfig config = OpenShiftConfig.wrap(context.getConfig());
    OpenShiftClient oc = new DefaultOpenShiftClient(context.getClient(), config);
    if (config.isOpenShiftAPIGroups(oc)) {
      oc.close();
      return super.getRootUrl();
    } else {
      oc.close();
      try {
        return new URL(OpenShiftConfig.wrap(getConfig()).getOpenShiftUrl());
      } catch (MalformedURLException e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    }
  }

  @Override
  public Createable inAnyNamespace() {
    return new SubjectAccessReviewOperationImpl(client, OpenShiftConfig.wrap(getConfig())).self();
  }

  private CreateableSelfSubjectAccessReview self() {
    return new CreateableSelfSubjectAccessReviewImpl(client);
  }

  @Override
  public Createable<SelfSubjectRulesReview, SelfSubjectRulesReview, CreateableSelfSubjectRulesReview> list() {
    // WIP
    return null;
  }

  @Override
  public Createable<SelfSubjectRulesReview, SelfSubjectRulesReview, CreateableSelfSubjectRulesReview> list(Integer limitVal, String continueVal) {
    // WIP
    return null;
  }

  private class CreateableLocalSubjectAccessReviewImpl extends CreateableLocalSubjectAccessReview {
    private final OkHttpClient client;
    private final LocalSubjectAccessReviewBuilder builder;

    private CreateableLocalSubjectAccessReviewImpl(OkHttpClient client) {
      this.client = client;
      this.builder = new LocalSubjectAccessReviewBuilder(CreateableLocalSubjectAccessReviewImpl.this);
    }

    private CreateableLocalSubjectAccessReviewImpl(OkHttpClient client, LocalSubjectAccessReviewBuilder builder) {
      this.client = client;
      this.builder = builder;
    }

    @Override
    public SubjectAccessReviewResponse create(LocalSubjectAccessReview... resources) {
      try {
        if (resources.length > 1) {
          throw new IllegalArgumentException("Too many items to create.");
        } else if (resources.length == 1) {
          return handleCreate(resources[0], SubjectAccessReviewResponse.class);
        } else {
          throw new IllegalArgumentException("Nothing to create.");
        }
      } catch (InterruptedException | ExecutionException | IOException e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    }

    @Override
    public CreateableLocalSubjectAccessReview createNew() {
      return this;
    }

    @Override
    public SubjectAccessReviewResponse done() {
      return create(builder.build());
    }
  }

  private CreateableLocalSubjectAccessReview local() {
    return new CreateableLocalSubjectAccessReviewImpl(client);
  }

  //Subject Access Review is a category on its own so we need to override the default behavior.
  @Override
  protected <T> String checkNamespace(T item) {
    String operationNs = getNamespace();
    String itemNs = (item instanceof HasMetadata && ((HasMetadata)item).getMetadata() != null) ? ((HasMetadata) item).getMetadata().getNamespace() : null;
    if (Utils.isNullOrEmpty(operationNs) && Utils.isNullOrEmpty(itemNs)) {
      return null;
    } else if (Utils.isNullOrEmpty(itemNs)) {
      return operationNs;
    } else if (Utils.isNullOrEmpty(operationNs)) {
      return itemNs;
    } else if (itemNs.equals(operationNs)) {
      return itemNs;
    }
    throw new KubernetesClientException("Namespace mismatch. Item namespace:" + itemNs + ". Operation namespace:" + operationNs + ".");
  }

  private class CreateableSubjectAccessReviewImpl extends CreateableSubjectAccessReview {
    private final OkHttpClient client;
    private final SubjectAccessReviewBuilder builder;

    private CreateableSubjectAccessReviewImpl(OkHttpClient client) {
      this.client = client;
      this.builder = new SubjectAccessReviewBuilder(CreateableSubjectAccessReviewImpl.this);
    }

    private CreateableSubjectAccessReviewImpl(OkHttpClient client, SubjectAccessReviewBuilder builder) {
      this.client = client;
      this.builder = builder;
    }

    @Override
    public SubjectAccessReviewResponse create(SubjectAccessReview... resources) {
      try {
        if (resources.length > 1) {
          throw new IllegalArgumentException("Too many items to create.");
        } else if (resources.length == 1) {
          return handleCreate(resources[0], SubjectAccessReviewResponse.class);
        } else {
          throw new IllegalArgumentException("Nothing to create.");
        }
      } catch (InterruptedException | ExecutionException | IOException e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    }

    @Override
    public CreateableSubjectAccessReview createNew() {
      return this;
    }

    @Override
    public SubjectAccessReviewResponse done() {
      return create(builder.build());
    }
  }

  private class CreateableSelfSubjectAccessReviewImpl extends CreateableSelfSubjectAccessReview {
    private final OkHttpClient client;
    private final SelfSubjectAccessReviewBuilder builder;

    private CreateableSelfSubjectAccessReviewImpl(OkHttpClient client) {
      this.client = client;
      this.builder = new SelfSubjectAccessReviewBuilder(CreateableSelfSubjectAccessReviewImpl.this);
    }

    private CreateableSelfSubjectAccessReviewImpl(OkHttpClient client, SelfSubjectAccessReviewBuilder builder) {
      this.client = client;
      this.builder = builder;
    }

    @Override
    public SubjectAccessReviewResponse create(SelfSubjectAccessReview... resources) {
      try {
        if (resources.length > 1) {
          throw new IllegalArgumentException("Too many items to create.");
        } else if (resources.length == 1) {
          return handleCreate(resources[0], SubjectAccessReviewResponse.class);
        } else {
          throw new IllegalArgumentException("Nothing to create.");
        }
      } catch (InterruptedException | ExecutionException | IOException e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    }

    @Override
    public CreateableSelfSubjectAccessReview createNew() {
      return this;
    }

    @Override
    public SubjectAccessReviewResponse done() {
      return create(builder.build());
    }
  }

}
