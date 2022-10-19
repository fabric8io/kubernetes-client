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

package io.fabric8.crd.generator.zookeeper.v1alpha1;

import io.fabric8.crd.generator.annotation.Annotations;
import io.fabric8.crd.generator.annotation.Labels;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;

@Version(value = "v1alpha1", storage = false)
@Group("io.zookeeper")
@Annotations({ "one=1", "two=2" })
@Labels({ "three=3", "four=4=4", "five=====>" })
public class Zookeeper extends CustomResource<ZookeeperSpec, ZookeeperStatus> implements Namespaced {
  private ZookeeperSpec spec;
  private ZookeeperStatus status;
}
