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
package io.fabric8.kudo.client;

import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kudo.v1beta1.*;
import io.fabric8.kudo.v1beta1.DoneableInstance;
import io.fabric8.kudo.v1beta1.DoneableOperator;
import io.fabric8.kudo.v1beta1.DoneableOperatorVersion;

import java.util.Map;

/**
 * Main interface for kudo client library.
 * @author pangms
 * @date 2020/4/20
 */
public interface KudoClient {
  MixedOperation<Operator, OperatorList, DoneableOperator, Resource<Operator, DoneableOperator>> operators();

  MixedOperation<Instance, InstanceList, DoneableInstance, Resource<Instance, DoneableInstance>> instances();

  MixedOperation<OperatorVersion, OperatorVersionList, DoneableOperatorVersion, Resource<OperatorVersion, DoneableOperatorVersion>> operatorVersion();

  void close();
}
