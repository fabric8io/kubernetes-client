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

import io.fabric8.kubernetes.api.model.authorization.v1.DoneableLocalSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1.DoneableSelfSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1.DoneableSelfSubjectRulesReview;
import io.fabric8.kubernetes.api.model.authorization.v1.DoneableSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1.LocalSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectRulesReview;
import io.fabric8.kubernetes.api.model.authorization.v1.SubjectAccessReview;
import io.fabric8.kubernetes.client.dsl.internal.LocalSubjectAccessReviewOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.SubjectAccessOperationsImpl;
import io.fabric8.kubernetes.client.utils.Utils;
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
  public SubjectAccessOperations<SelfSubjectAccessReview, DoneableSelfSubjectAccessReview> selfSubjectAccessReview() {
    return new SubjectAccessOperationsImpl<>(getHttpClient(), getConfiguration(), AUTHORIZATION_APIGROUP, AUTHORIZATION_APIVERSION, Utils.getPluralFromKind(io.fabric8.kubernetes.api.model.authorization.v1beta1.SelfSubjectAccessReview.class.getSimpleName()), SelfSubjectAccessReview.class);
  }

  @Override
  public SubjectAccessOperations<SubjectAccessReview, DoneableSubjectAccessReview> subjectAccessReview() {
    return new SubjectAccessOperationsImpl<>(getHttpClient(), getConfiguration(), AUTHORIZATION_APIGROUP, AUTHORIZATION_APIVERSION, Utils.getPluralFromKind(io.fabric8.kubernetes.api.model.authorization.v1beta1.SubjectAccessReview.class.getSimpleName()), SubjectAccessReview.class);
  }

  @Override
  public LocalSubjectAccessReviewOperationsImpl<LocalSubjectAccessReview, DoneableLocalSubjectAccessReview> localSubjectAccessReview() {
    return new LocalSubjectAccessReviewOperationsImpl<>(getHttpClient(), getConfiguration(), AUTHORIZATION_APIGROUP, AUTHORIZATION_APIVERSION, Utils.getPluralFromKind(io.fabric8.kubernetes.api.model.authorization.v1beta1.LocalSubjectAccessReview.class.getSimpleName()), LocalSubjectAccessReview.class);
  }

  @Override
  public SubjectAccessOperations<SelfSubjectRulesReview, DoneableSelfSubjectRulesReview> selfSubjectRulesReview() {
    return new SubjectAccessOperationsImpl<>(getHttpClient(), getConfiguration(), AUTHORIZATION_APIGROUP, AUTHORIZATION_APIVERSION,  Utils.getPluralFromKind(io.fabric8.kubernetes.api.model.authorization.v1beta1.SelfSubjectRulesReview.class.getSimpleName()), SelfSubjectRulesReview.class);
  }
}
