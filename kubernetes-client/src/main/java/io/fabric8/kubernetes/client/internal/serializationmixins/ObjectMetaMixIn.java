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
package io.fabric8.kubernetes.client.internal.serializationmixins;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.fabric8.kubernetes.api.model.ObjectMeta;

public abstract class ObjectMetaMixIn extends ObjectMeta {
  @JsonIgnore
  private String creationTimestamp;
  @JsonIgnore
  private String deletionTimestamp;
  @JsonIgnore
  private Long generation;
  @JsonIgnore
  private String resourceVersion;
  @JsonIgnore
  private String selfLink;
  @JsonIgnore
  private String uid;

  @Override
  @JsonIgnore
  public abstract String getCreationTimestamp();
  @Override
  @JsonIgnore
  public abstract String getDeletionTimestamp();
  @Override
  @JsonIgnore
  public abstract Long getGeneration();
  @Override
  @JsonIgnore
  public abstract String getResourceVersion();
  @Override
  @JsonIgnore
  public abstract String getSelfLink();
  @Override
  @JsonIgnore
  public abstract String getUid();
}
