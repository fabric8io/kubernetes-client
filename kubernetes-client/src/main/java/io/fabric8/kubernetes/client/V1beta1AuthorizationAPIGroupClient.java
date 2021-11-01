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

import io.fabric8.kubernetes.api.model.authorization.v1beta1.LocalSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1beta1.SelfSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1beta1.SelfSubjectRulesReview;
import io.fabric8.kubernetes.api.model.authorization.v1beta1.SubjectAccessReview;
import io.fabric8.kubernetes.client.dsl.InOutCreateable;
import io.fabric8.kubernetes.client.dsl.NamespacedInOutCreateable;
import io.fabric8.kubernetes.client.http.HttpClient;

public class V1beta1AuthorizationAPIGroupClient extends BaseClient implements V1beta1AuthorizationAPIGroupDSL {

  public static final String AUTHORIZATION_APIGROUP = "authorization.k8s.io";
  public static final String AUTHORIZATION_APIVERSION = "v1beta1";

  public V1beta1AuthorizationAPIGroupClient() {
    super();
  }

  public V1beta1AuthorizationAPIGroupClient(HttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public InOutCreateable<SelfSubjectAccessReview, SelfSubjectAccessReview> selfSubjectAccessReview() {
    return Handlers.getNonListingOperation(SelfSubjectAccessReview.class, getHttpClient(), getConfiguration());
  }

  @Override
  public InOutCreateable<SubjectAccessReview, SubjectAccessReview> subjectAccessReview() {
    return Handlers.getNonListingOperation(SubjectAccessReview.class, getHttpClient(), getConfiguration());
  }

  @Override
  public NamespacedInOutCreateable<LocalSubjectAccessReview, LocalSubjectAccessReview> localSubjectAccessReview() {
    return Handlers.getNamespacedHasMetadataCreateOnlyOperation(LocalSubjectAccessReview.class, getHttpClient(), getConfiguration());
  }

  @Override
  public InOutCreateable<SelfSubjectRulesReview, SelfSubjectRulesReview> selfSubjectRulesReview() {
    return Handlers.getNonListingOperation(SelfSubjectRulesReview.class, getHttpClient(), getConfiguration());
  }
}
