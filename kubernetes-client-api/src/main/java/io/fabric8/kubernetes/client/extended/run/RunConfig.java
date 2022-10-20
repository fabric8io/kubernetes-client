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
package io.fabric8.kubernetes.client.extended.run;

import io.fabric8.kubernetes.api.model.Quantity;
import io.sundr.builder.annotations.Buildable;

import java.util.List;
import java.util.Map;

/**
 * Configuration for client run
 */
public class RunConfig {
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
   * Command to use instead of the default
   */
  private String command;
  /**
   * Arguments for the default or provided command.
   *
   * <p>
   * If <code>command</code> is present, these will be used as extra arguments for the command. If not,
   * these will be set in the args container configuration.
   */
  private List<String> args;
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
   * Port to use
   */
  private int port;

  @SuppressWarnings("java:S107")
  @Buildable(builderPackage = "io.fabric8.kubernetes.api.builder")
  public RunConfig(String name, String image, String imagePullPolicy, String command, List<String> args, String restartPolicy,
      String serviceAccount, Map<String, String> labels, Map<String, String> env, Map<String, Quantity> limits,
      Map<String, Quantity> requests, int port) {
    this.name = name;
    this.image = image;
    this.imagePullPolicy = imagePullPolicy;
    this.command = command;
    this.args = args;
    this.restartPolicy = restartPolicy;
    this.serviceAccount = serviceAccount;
    this.labels = labels;
    this.env = env;
    this.limits = limits;
    this.requests = requests;
    this.port = port;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getImagePullPolicy() {
    return imagePullPolicy;
  }

  public void setImagePullPolicy(String imagePullPolicy) {
    this.imagePullPolicy = imagePullPolicy;
  }

  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
  }

  public List<String> getArgs() {
    return args;
  }

  public void setArgs(List<String> args) {
    this.args = args;
  }

  public String getRestartPolicy() {
    return restartPolicy;
  }

  public void setRestartPolicy(String restartPolicy) {
    this.restartPolicy = restartPolicy;
  }

  public String getServiceAccount() {
    return serviceAccount;
  }

  public void setServiceAccount(String serviceAccount) {
    this.serviceAccount = serviceAccount;
  }

  public Map<String, String> getLabels() {
    return labels;
  }

  public void setLabels(Map<String, String> labels) {
    this.labels = labels;
  }

  public Map<String, String> getEnv() {
    return env;
  }

  public void setEnv(Map<String, String> env) {
    this.env = env;
  }

  public Map<String, Quantity> getLimits() {
    return limits;
  }

  public void setLimits(Map<String, Quantity> limits) {
    this.limits = limits;
  }

  public Map<String, Quantity> getRequests() {
    return requests;
  }

  public void setRequests(Map<String, Quantity> requests) {
    this.requests = requests;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }
}
