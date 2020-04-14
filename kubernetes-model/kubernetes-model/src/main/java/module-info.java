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
module io.fabric8.kubernetes.model {
  requires io.fabric8.kubernetes.model.common;
  requires java.annotation;
  requires static lombok;
  requires builder.annotations;
  requires transform.annotations;
  requires com.fasterxml.jackson.core;
  requires com.fasterxml.jackson.databind;
  requires com.fasterxml.jackson.annotation;
  exports io.fabric8.openshift.api.model;
  exports io.fabric8.kubernetes.api.model;
  exports io.fabric8.kubernetes.internal;
  exports io.fabric8.kubernetes.api.builder;
}
