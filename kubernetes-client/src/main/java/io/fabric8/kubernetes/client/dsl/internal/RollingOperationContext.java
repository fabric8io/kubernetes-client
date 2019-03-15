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

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import okhttp3.OkHttpClient;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RollingOperationContext extends OperationContext {

 private boolean rolling;
 private long rollingTimeout;
 private TimeUnit rollingTimeUnit;

  public RollingOperationContext() {
  }

  public RollingOperationContext(OkHttpClient client, Config config, String plural, String namespace, String name, String apiGroupName, String apiGroupVersion, boolean cascading, Object item, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields, String resourceVersion, boolean reloadingFromServer, long gracePeriodSeconds, boolean rolling, long rollingTimeout, TimeUnit rollingTimeUnit) {
    super(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading, item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds);
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

  public RollingOperationContext withOkhttpClient(OkHttpClient client) {
    return new RollingOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, rolling, rollingTimeout, rollingTimeUnit);
  }

  public RollingOperationContext withConfig(Config config) {
    return new RollingOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, rolling, rollingTimeout, rollingTimeUnit);
  }

  public RollingOperationContext withPlural(String plural) {
    return new RollingOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, rolling, rollingTimeout, rollingTimeUnit);
  }

  public RollingOperationContext withNamespace(String namespace) {
    return new RollingOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, rolling, rollingTimeout, rollingTimeUnit);
  }

  public RollingOperationContext withName(String name) {
    return new RollingOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, rolling, rollingTimeout, rollingTimeUnit);
  }

  public RollingOperationContext withApiGroupName(String apiGroupName) {
    return new RollingOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, rolling, rollingTimeout, rollingTimeUnit);
  }

  public RollingOperationContext withApiGroupVersion(String apiGroupVersion) {
    return new RollingOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, rolling, rollingTimeout, rollingTimeUnit);
  }

  @Override
  public RollingOperationContext withItem(Object item) {
    return new RollingOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, rolling, rollingTimeout, rollingTimeUnit);
  }

  public RollingOperationContext withCascading(boolean cascading) {
    return new RollingOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, rolling, rollingTimeout, rollingTimeUnit);
  }

  public RollingOperationContext withLabels(Map<String, String> labels) {
    return new RollingOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, rolling, rollingTimeout, rollingTimeUnit);
  }

  public RollingOperationContext withLabelsIn(Map<String, String[]> labelsIn) {
    return new RollingOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, rolling, rollingTimeout, rollingTimeUnit);
  }

  public RollingOperationContext withLabelsNot(Map<String, String> labelsNot) {
    return new RollingOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, rolling, rollingTimeout, rollingTimeUnit);
  }

  public RollingOperationContext withLabelsNotIn(Map<String, String[]> labelsNotIn) {
    return new RollingOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, rolling, rollingTimeout, rollingTimeUnit);
  }

  public RollingOperationContext withFields(Map<String, String> fields) {
    return new RollingOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, rolling, rollingTimeout, rollingTimeUnit);
  }

  public RollingOperationContext withResourceVersion(String resourceVersion) {
    return new RollingOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, rolling, rollingTimeout, rollingTimeUnit);
  }

  public RollingOperationContext withReloadingFromServer(boolean reloadingFromServer) {
    return new RollingOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, rolling, rollingTimeout, rollingTimeUnit);
  }

  public RollingOperationContext withGracePeriodSeconds(long gracePeriodSeconds) {
    return new RollingOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, rolling, rollingTimeout, rollingTimeUnit);
  }

  public RollingOperationContext withRolling(boolean rolling) {
    return new RollingOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, rolling, rollingTimeout, rollingTimeUnit);
  }

  public RollingOperationContext withRollingTimeout(long rollingTimeout) {
    return new RollingOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, rolling, rollingTimeout, rollingTimeUnit);
  }

  public RollingOperationContext withRollingTimeUnit(TimeUnit rollingTimeUnit) {
    return new RollingOperationContext(client, config, plural, namespace, name, apiGroupName, apiGroupVersion, cascading,item, labels, labelsNot, labelsIn, labelsNotIn, fields, resourceVersion, reloadingFromServer, gracePeriodSeconds, rolling, rollingTimeout, rollingTimeUnit);
  }
}
