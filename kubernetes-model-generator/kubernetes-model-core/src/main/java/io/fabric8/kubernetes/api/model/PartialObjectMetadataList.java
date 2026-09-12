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
package io.fabric8.kubernetes.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;

/**
 * PartialObjectMetadataList contains a list of objects containing only their metadata.
 * <p>
 * This is used with the {@code Accept: application/json;as=PartialObjectMetadataList;g=meta.k8s.io;v=v1} header.
 */
@JsonDeserialize
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "apiVersion", "kind", "metadata", "items" })
@Group("meta.k8s.io")
@Version("v1")
public class PartialObjectMetadataList extends DefaultKubernetesResourceList<PartialObjectMetadata> {
  @java.lang.Override
  public java.lang.String toString() {
    return "PartialObjectMetadataList()";
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object o) {
    if (o == this)
      return true;
    if (!(o instanceof PartialObjectMetadataList))
      return false;
    final PartialObjectMetadataList other = (PartialObjectMetadataList) o;
    if (!other.canEqual((java.lang.Object) this))
      return false;
    if (!super.equals(o))
      return false;
    return true;
  }

  protected boolean canEqual(final java.lang.Object other) {
    return other instanceof PartialObjectMetadataList;
  }

  @java.lang.Override
  public int hashCode() {
    final int result = super.hashCode();
    return result;
  }
}
