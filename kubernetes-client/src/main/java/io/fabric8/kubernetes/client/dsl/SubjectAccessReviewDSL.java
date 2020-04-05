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
package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.authorization.SubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.LocalSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.SelfSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.SelfSubjectRulesReview;
import io.fabric8.kubernetes.api.model.authorization.DoneableLocalSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.DoneableSelfSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.DoneableSelfSubjectRulesReview;
import io.fabric8.kubernetes.api.model.authorization.DoneableSubjectAccessReview;

public interface SubjectAccessReviewDSL extends
  Createable<SubjectAccessReview, SubjectAccessReview, DoneableSubjectAccessReview>,
  Namespaceable<Createable<LocalSubjectAccessReview, LocalSubjectAccessReview, DoneableLocalSubjectAccessReview>>,
  AnyNamespaceable<Createable<SelfSubjectAccessReview, SelfSubjectAccessReview, DoneableSelfSubjectAccessReview>>,
  Listable<Createable<SelfSubjectRulesReview, SelfSubjectRulesReview, DoneableSelfSubjectRulesReview>> {
}
