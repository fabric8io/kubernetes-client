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
package io.fabric8.kubernetes.client.impl;

import io.fabric8.kubernetes.api.model.authorization.v1.LocalSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectRulesReview;
import io.fabric8.kubernetes.api.model.authorization.v1.SubjectAccessReview;
import io.fabric8.kubernetes.client.V1AuthorizationAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.InOutCreateable;
import io.fabric8.kubernetes.client.dsl.NamespacedInOutCreateable;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class V1AuthorizationAPIGroupClient extends ClientAdapter<V1AuthorizationAPIGroupClient>
    implements V1AuthorizationAPIGroupDSL {
  public static final String AUTHORIZATION_APIGROUP = "authorization.k8s.io";
  public static final String AUTHORIZATION_APIVERSION = "v1";

  @Override
  public InOutCreateable<SelfSubjectAccessReview, SelfSubjectAccessReview> selfSubjectAccessReview() {
    return getClient().adapt(BaseClient.class).getHandlers().getNonListingOperation(SelfSubjectAccessReview.class, this);
  }

  @Override
  public InOutCreateable<SubjectAccessReview, SubjectAccessReview> subjectAccessReview() {
    return getClient().adapt(BaseClient.class).getHandlers().getNonListingOperation(SubjectAccessReview.class, this);
  }

  @Override
  public NamespacedInOutCreateable<LocalSubjectAccessReview, LocalSubjectAccessReview> localSubjectAccessReview() {
    return getClient().adapt(BaseClient.class).getHandlers()
        .getNamespacedHasMetadataCreateOnlyOperation(LocalSubjectAccessReview.class, this);
  }

  @Override
  public InOutCreateable<SelfSubjectRulesReview, SelfSubjectRulesReview> selfSubjectRulesReview() {
    return getClient().adapt(BaseClient.class).getHandlers().getNonListingOperation(SelfSubjectRulesReview.class, this);
  }

  @Override
  public V1AuthorizationAPIGroupClient newInstance() {
    return new V1AuthorizationAPIGroupClient();
  }
}
