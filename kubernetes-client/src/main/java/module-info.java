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

/**
 * Defines Fabric8 Kubernetes Client API for interacting with Kubernetes from Java.
 */
module io.fabric8.kubernetes.client {
  requires io.fabric8.kubernetes.model;
  requires io.fabric8.kubernetes.model.common;
  requires okhttp3;
  requires okhttp3.logging;
  requires org.slf4j;
  requires com.fasterxml.jackson.databind;
  requires com.fasterxml.jackson.datatype.jsr310;
  requires com.fasterxml.jackson.dataformat.yaml;
  requires com.fasterxml.jackson.core;
  requires zjsonpatch;
  requires org.bouncycastle.pkix;
  requires org.apache.commons.codec;
  requires org.apache.commons.compress;
  requires generex;
  requires static lombok;
  requires org.apache.felix.scr.annotations;
  exports io.fabric8.kubernetes.client.dsl.base;
  exports io.fabric8.kubernetes.client.dsl.internal.uploadable;
  exports io.fabric8.kubernetes.client.internal.patchmixins;
  exports io.fabric8.kubernetes.client.internal.readiness;
  exports io.fabric8.kubernetes.client.internal.serializationmixins;
  exports io.fabric8.kubernetes.client.extended.leaderelection.resourcelock;
  exports io.fabric8.kubernetes.client.handlers;
  exports io.fabric8.kubernetes.client.informers.cache;
  exports io.fabric8.kubernetes.client.informers.impl;
  exports io.fabric8.kubernetes.client.osgi;
  exports io.fabric8.kubernetes.client.utils;
}
