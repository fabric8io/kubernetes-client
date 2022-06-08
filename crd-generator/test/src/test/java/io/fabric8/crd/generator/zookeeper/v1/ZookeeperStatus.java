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
package io.fabric8.crd.generator.zookeeper.v1;

import io.fabric8.kubernetes.model.annotation.LabelSelector;
import io.fabric8.kubernetes.model.annotation.PrinterColumn;
import io.fabric8.kubernetes.model.annotation.StatusReplicas;

import java.util.Map;

public class ZookeeperStatus {

  @PrinterColumn
  @StatusReplicas
  private int size;

  @LabelSelector
  private Map<String, String> selector;

  private boolean running;

  @PrinterColumn
  private long uptime;

  public long getUptime() {
    return this.uptime;
  }

  public void setUptime(long uptime) {
    this.uptime = uptime;
  }

  public boolean getRunning() {
    return this.running;
  }

  public void setRunning(boolean running) {
    this.running = running;
  }

  public int getSize() {
    return this.size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public Map<String, String> getSelector() {
    return selector;
  }

  public void setSelector(Map<String, String> selector) {
    this.selector = selector;
  }
}
