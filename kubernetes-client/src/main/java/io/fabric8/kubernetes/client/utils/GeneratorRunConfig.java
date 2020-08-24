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
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.api.model.Quantity;
import io.sundr.builder.annotations.Buildable;

import java.util.Map;

/**
 * Configuration for client run
 */
public class GeneratorRunConfig {
  /**
   * Name of resource
   */
  private String name;
  /**
   * Image to use
   */
  private String image;
  /**
   * ImagePullPolicy to be used
   */
  private String imagePullPolicy;
  /**
   * Pod restart policy
   */
  private String restartPolicy;
  /**
   * Service Account name to be used
   */
  private String serviceAccount;
  /**
   * labels to add
   */
  private Map<String, String> labels;
  /**
   * Environment variables to be add
   */
  private Map<String, String> env;
  /**
   * Resource limits
   */
  private Map<String, Quantity> limits;
  /**
   * Resource requests
   */
  private Map<String, Quantity> requests;
  /**
   * replicas
   */
  private int replicas;
  /**
   * Port to use
   */
  private int port;

  @Buildable(builderPackage = "io.fabric8.kubernetes.api.builder")
  public GeneratorRunConfig(String name, String image, String imagePullPolicy, String restartPolicy, String serviceAccount, Map<String, String> labels, Map<String, String> env, Map<String, Quantity> limits, Map<String, Quantity> requests, int replicas, int port) {
    this.name = name;
    this.image = image;
    this.imagePullPolicy = imagePullPolicy;
    this.restartPolicy = restartPolicy;
    this.serviceAccount = serviceAccount;
    this.labels = labels;
    this.env = env;
    this.limits = limits;
    this.requests = requests;
    this.replicas = replicas;
    this.port = port;
  }

  public String getName() { return name; }

  public String getImage() {
    return image;
  }

  public String getImagePullPolicy() {
    return imagePullPolicy;
  }

  public Map<String, String> getLabels() {
    return labels;
  }

  public Map<String, String> getEnv() {
    return env;
  }

  public Map<String, Quantity> getLimits() {
    return limits;
  }

  public Map<String, Quantity> getRequests() {
    return requests;
  }

  public int getReplicas() {
    return replicas;
  }

  public int getPort() {
    return port;
  }

  public String getRestartPolicy() {
    return restartPolicy;
  }

  public String getServiceAccount() {
    return serviceAccount;
  }

  public void setRestartPolicy(String restartPolicy) {
    this.restartPolicy = restartPolicy;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setServiceAccount(String serviceAccount) {
    this.serviceAccount = serviceAccount;
  }
  public void setPort(int port) {
    this.port = port;
  }

  public void setReplicas(int replicas) {
    this.replicas = replicas;
  }

  public void setRequests(Map<String, Quantity> requests) {
    this.requests = requests;
  }

  public void setLimits(Map<String, Quantity> limits) {
    this.limits = limits;
  }

  public void setEnv(Map<String, String> env) {
    this.env = env;
  }

  public void setLabels(Map<String, String> labels) {
    this.labels = labels;
  }

  public void setImagePullPolicy(String imagePullPolicy) {
    this.imagePullPolicy = imagePullPolicy;
  }

  public void setImage(String image) {
    this.image = image;
  }
}
