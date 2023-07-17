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

import io.fabric8.kubernetes.api.model.authentication.v1beta1.SelfSubjectReview;
import io.fabric8.kubernetes.client.Client;

public interface V1Beta1AuthenticationAPIGroupDSL extends Client {
  /**
   * API for creating authentication.k8s.io/v1beta1 SelfSubjectReview.
   * <br>
   * SelfSubjectReview contains the user information that the kube-apiserver has about the user making this request.
   * When using impersonation, users will receive the user info of the user being impersonated. If impersonation or
   * request header authentication is used, any extra keys will have their case ignored and returned as lowercase.
   *
   * @return InOutCreateable instance for creating SelfSubjectReview object
   */
  InOutCreateable<SelfSubjectReview, SelfSubjectReview> selfSubjectReview();
}
