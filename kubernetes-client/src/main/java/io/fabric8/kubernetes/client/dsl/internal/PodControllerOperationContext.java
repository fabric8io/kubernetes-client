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
package io.fabric8.kubernetes.client.dsl.internal;

public class PodControllerOperationContext {
  protected String containerId;
  protected Integer logWaitTimeout;

  public PodControllerOperationContext() { }

  public PodControllerOperationContext(String containerId, Integer logWaitTimeout) {
    this.containerId = containerId;
    this.logWaitTimeout = logWaitTimeout;
  }
  
  public Integer getLogWaitTimeout() {
    return logWaitTimeout;
  }

  public String getContainerId() {
    return containerId;
  }

  public PodControllerOperationContext withContainerId(String containerId) {
    return new PodControllerOperationContext(containerId, logWaitTimeout);
  }

  public PodControllerOperationContext withLogWaitTimout(Integer logWaitTimeout) {
    return new PodControllerOperationContext(containerId, logWaitTimeout);
  }

}
