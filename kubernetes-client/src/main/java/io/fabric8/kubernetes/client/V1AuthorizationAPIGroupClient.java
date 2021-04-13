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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.authorization.v1.LocalSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectRulesReview;
import io.fabric8.kubernetes.api.model.authorization.v1.SubjectAccessReview;
import io.fabric8.kubernetes.client.dsl.Createable;
import io.fabric8.kubernetes.client.dsl.internal.CreateOnlyResourceOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.LocalCreateOnlyResourceReviewOperationsImpl;
import okhttp3.OkHttpClient;

public class V1AuthorizationAPIGroupClient extends BaseClient implements V1AuthorizationAPIGroupDSL {
  public static final String AUTHORIZATION_APIGROUP = "authorization.k8s.io";
  public static final String AUTHORIZATION_APIVERSION = "v1";

  public V1AuthorizationAPIGroupClient() {
    super();
  }

  public V1AuthorizationAPIGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public Createable<SelfSubjectAccessReview> selfSubjectAccessReview() {
    return new CreateOnlyResourceOperationsImpl<>(getHttpClient(), getConfiguration(), AUTHORIZATION_APIGROUP, AUTHORIZATION_APIVERSION, HasMetadata.getPlural(SelfSubjectAccessReview.class), SelfSubjectAccessReview.class);
  }

  @Override
  public Createable<SubjectAccessReview> subjectAccessReview() {
    return new CreateOnlyResourceOperationsImpl<>(getHttpClient(), getConfiguration(), AUTHORIZATION_APIGROUP, AUTHORIZATION_APIVERSION, HasMetadata.getPlural(SubjectAccessReview.class), SubjectAccessReview.class);
  }

  @Override
  public LocalCreateOnlyResourceReviewOperationsImpl<LocalSubjectAccessReview> localSubjectAccessReview() {
    return new LocalCreateOnlyResourceReviewOperationsImpl<>(getHttpClient(), getConfiguration(), AUTHORIZATION_APIGROUP, AUTHORIZATION_APIVERSION, HasMetadata.getPlural(LocalSubjectAccessReview.class), LocalSubjectAccessReview.class);
  }

  @Override
  public Createable<SelfSubjectRulesReview> selfSubjectRulesReview() {
    return new CreateOnlyResourceOperationsImpl<>(getHttpClient(), getConfiguration(), AUTHORIZATION_APIGROUP, AUTHORIZATION_APIVERSION,  HasMetadata.getPlural(SelfSubjectRulesReview.class), SelfSubjectRulesReview.class);
  }
}
