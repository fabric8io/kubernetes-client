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

package io.fabric8.openshift.client.dsl;

import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.authorization.SelfSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.SelfSubjectRulesReview;
import io.fabric8.kubernetes.client.dsl.AnyNamespaceable;
import io.fabric8.kubernetes.client.dsl.Createable;
import io.fabric8.kubernetes.client.dsl.Listable;
import io.fabric8.kubernetes.client.dsl.Namespaceable;
import io.fabric8.openshift.api.model.*;

public interface SubjectAccessReviewOperation<S extends Doneable<SubjectAccessReviewResponse>, L extends Doneable<SubjectAccessReviewResponse>, M extends Doneable<SubjectAccessReviewResponse>, N extends Doneable<SubjectAccessReviewResponse>> extends
  Createable<SubjectAccessReview, SubjectAccessReviewResponse, S>,
  Namespaceable<Createable<LocalSubjectAccessReview, SubjectAccessReviewResponse, L>>,
  AnyNamespaceable<Createable<SelfSubjectAccessReview, SelfSubjectAccessReview, M>>,
  Listable<Createable<SelfSubjectRulesReview, SelfSubjectRulesReview, N>> {

}
