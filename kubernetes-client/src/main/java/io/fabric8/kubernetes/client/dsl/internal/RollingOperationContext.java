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

import java.util.concurrent.TimeUnit;

public class RollingOperationContext extends PodControllerOperationContext {

  private boolean rolling;
  private long rollingTimeout;
  private TimeUnit rollingTimeUnit;

  public RollingOperationContext() {
  }

  public RollingOperationContext(String containerId, boolean rolling, long rollingTimeout, TimeUnit rollingTimeUnit, Integer logWaitTimeout) {
    super(containerId, logWaitTimeout);
    this.rolling = rolling;
    this.rollingTimeout = rollingTimeout;
    this.rollingTimeUnit = rollingTimeUnit != null ? rollingTimeUnit : TimeUnit.MILLISECONDS;
  }

  public Boolean getRolling() {
    return rolling;
  }

  public long getRollingTimeout() {
    return rollingTimeout;
  }

  public TimeUnit getRollingTimeUnit() {
    return rollingTimeUnit;
  }
  
  public RollingOperationContext withRolling(boolean rolling) {
    return new RollingOperationContext(containerId, rolling, rollingTimeout, rollingTimeUnit, logWaitTimeout);
  }

  public RollingOperationContext withRollingTimeout(long rollingTimeout) {
    return new RollingOperationContext(containerId, rolling, rollingTimeout, rollingTimeUnit, logWaitTimeout);
  }

  public RollingOperationContext withRollingTimeUnit(TimeUnit rollingTimeUnit) {
    return new RollingOperationContext(containerId, rolling, rollingTimeout, rollingTimeUnit, logWaitTimeout);
  }

  @Override
  public RollingOperationContext withContainerId(String containerId) {
    return new RollingOperationContext(containerId, rolling, rollingTimeout, rollingTimeUnit, logWaitTimeout);
  }
  
  @Override
  public RollingOperationContext withLogWaitTimout(Integer logWaitTimeout) {
    return new RollingOperationContext(containerId, rolling, rollingTimeout, rollingTimeUnit, logWaitTimeout);
  }
  
}
