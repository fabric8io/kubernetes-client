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
package io.fabric8.kubernetes.client.mock.crd;

public class CronTabSpec {
  public String getCronSpec() {
    return cronSpec;
  }

  public void setCronSpec(String cronSpec) {
    this.cronSpec = cronSpec;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public int getReplicas() {
    return replicas;
  }

  public void setReplicas(int replicas) {
    this.replicas = replicas;
  }

  private String cronSpec;
  private String image;
  private int replicas;

  @Override
  public String toString() {
    return "CronTabSpec{" +
        "replicas=" + replicas +
        ", cronSpec='" + cronSpec + "'" +
        ", image='" + image + "'" +
        "}";
  }
}
