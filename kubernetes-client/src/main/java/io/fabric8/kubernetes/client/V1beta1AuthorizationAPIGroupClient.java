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
import io.fabric8.kubernetes.api.model.authorization.v1beta1.LocalSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1beta1.SelfSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1beta1.SelfSubjectRulesReview;
import io.fabric8.kubernetes.api.model.authorization.v1beta1.SubjectAccessReview;
import io.fabric8.kubernetes.client.dsl.InOutCreateable;
import io.fabric8.kubernetes.client.dsl.internal.CreateOnlyResourceOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.NamespacedCreateOnlyResourceOperationsImpl;
import okhttp3.OkHttpClient;

public class V1beta1AuthorizationAPIGroupClient extends BaseClient implements V1beta1AuthorizationAPIGroupDSL {

  public static final String AUTHORIZATION_APIGROUP = "authorization.k8s.io";
  public static final String AUTHORIZATION_APIVERSION = "v1beta1";

  public V1beta1AuthorizationAPIGroupClient() {
    super();
  }

  public V1beta1AuthorizationAPIGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public InOutCreateable<SelfSubjectAccessReview, SelfSubjectAccessReview> selfSubjectAccessReview() {
    return new CreateOnlyResourceOperationsImpl<>(getHttpClient(), getConfiguration(), AUTHORIZATION_APIGROUP, AUTHORIZATION_APIVERSION, HasMetadata.getPlural(SelfSubjectAccessReview.class), SelfSubjectAccessReview.class);
  }

  @Override
  public InOutCreateable<SubjectAccessReview, SubjectAccessReview> subjectAccessReview() {
    return new CreateOnlyResourceOperationsImpl<>(getHttpClient(), getConfiguration(), AUTHORIZATION_APIGROUP, AUTHORIZATION_APIVERSION, HasMetadata.getPlural(SubjectAccessReview.class), SubjectAccessReview.class);
  }

  @Override
  public NamespacedCreateOnlyResourceOperationsImpl<LocalSubjectAccessReview, LocalSubjectAccessReview> localSubjectAccessReview() {
    return new NamespacedCreateOnlyResourceOperationsImpl<>(getHttpClient(), getConfiguration(), AUTHORIZATION_APIGROUP, AUTHORIZATION_APIVERSION, HasMetadata.getPlural(LocalSubjectAccessReview.class), LocalSubjectAccessReview.class);
  }

  @Override
  public InOutCreateable<SelfSubjectRulesReview, SelfSubjectRulesReview> selfSubjectRulesReview() {
    return new CreateOnlyResourceOperationsImpl<>(getHttpClient(), getConfiguration(), AUTHORIZATION_APIGROUP, AUTHORIZATION_APIVERSION, HasMetadata.getPlural(SelfSubjectRulesReview.class), SelfSubjectRulesReview.class);
  }
}
