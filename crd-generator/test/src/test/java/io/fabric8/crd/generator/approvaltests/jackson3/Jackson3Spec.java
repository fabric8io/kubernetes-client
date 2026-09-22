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
package io.fabric8.crd.generator.approvaltests.jackson3;

import io.fabric8.generator.annotation.Required;

import java.time.Instant;

public class Jackson3Spec {

  @Required
  private String zebra;
  @Required
  private String alpha;
  private ToStringEnum status;
  private Instant createdAt;

  public String getZebra() {
    return zebra;
  }

  public void setZebra(String zebra) {
    this.zebra = zebra;
  }

  public String getAlpha() {
    return alpha;
  }

  public void setAlpha(String alpha) {
    this.alpha = alpha;
  }

  public ToStringEnum getStatus() {
    return status;
  }

  public void setStatus(ToStringEnum status) {
    this.status = status;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public enum ToStringEnum {
    ACTIVE("active"),
    INACTIVE("inactive");

    private final String displayName;

    ToStringEnum(String displayName) {
      this.displayName = displayName;
    }

    @Override
    public String toString() {
      return displayName;
    }
  }
}
