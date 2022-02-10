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

import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Kind;
import io.fabric8.kubernetes.model.annotation.Plural;
import io.fabric8.kubernetes.model.annotation.Singular;
import io.fabric8.kubernetes.model.annotation.Version;

@Version(value = Custom.VERSION, storage = false, served = false)
@Group(Custom.GROUP)
@Singular(Custom.SINGULAR)
@Plural(Custom.PLURAL)
@Kind(Custom.KIND)
public
class Custom extends CustomResource {
  public static final String VERSION = "v1beta1";
  public static final String GROUP = "sample.fabric8.io";
  public static final String SINGULAR = "foo";
  public static final String PLURAL = "fooes";
  public static final String KIND = "CustomCR";
}
