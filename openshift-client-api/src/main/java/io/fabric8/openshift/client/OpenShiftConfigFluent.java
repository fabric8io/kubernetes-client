/*
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

package io.fabric8.openshift.client;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("unchecked")
public class OpenShiftConfigFluent<A extends OpenShiftConfigFluent<A>> extends SundrioOpenShiftConfigFluent<A> {

  public OpenShiftConfigFluent() {
    super();
  }

  public OpenShiftConfigFluent(OpenShiftConfig instance) {
    super();
    this.copyInstance(instance);
  }

  // no need to override the base logic
  public void copyInstance(OpenShiftConfig instance) {
    super.copyInstance(instance);
  }

}