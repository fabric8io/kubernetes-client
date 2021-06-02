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
package io.fabric8.openshift.client;

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openshift.api.model.console.v1.ConsoleCLIDownload;
import io.fabric8.openshift.api.model.console.v1.ConsoleCLIDownloadList;
import io.fabric8.openshift.api.model.console.v1.ConsoleExternalLogLink;
import io.fabric8.openshift.api.model.console.v1.ConsoleExternalLogLinkList;
import io.fabric8.openshift.api.model.console.v1.ConsoleLink;
import io.fabric8.openshift.api.model.console.v1.ConsoleLinkList;
import io.fabric8.openshift.api.model.console.v1.ConsoleNotification;
import io.fabric8.openshift.api.model.console.v1.ConsoleNotificationList;
import io.fabric8.openshift.api.model.console.v1.ConsoleQuickStart;
import io.fabric8.openshift.api.model.console.v1.ConsoleQuickStartList;
import io.fabric8.openshift.api.model.console.v1.ConsoleYAMLSample;
import io.fabric8.openshift.api.model.console.v1.ConsoleYAMLSampleList;
import io.fabric8.openshift.api.model.console.v1alpha1.ConsolePlugin;
import io.fabric8.openshift.api.model.console.v1alpha1.ConsolePluginList;
import io.fabric8.openshift.client.dsl.OpenShiftConsoleAPIGroupDSL;
import io.fabric8.openshift.client.dsl.internal.console.ConsoleCLIDownloadOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.console.ConsoleExternalLogLinkOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.console.ConsoleLinkOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.console.ConsoleNotificationOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.console.ConsolePluginOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.console.ConsoleQuickStartOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.console.ConsoleYAMLSampleOperationsImpl;
import okhttp3.OkHttpClient;

public class OpenShiftConsoleAPIGroupClient extends BaseClient implements OpenShiftConsoleAPIGroupDSL {
  public OpenShiftConsoleAPIGroupClient() {
    super();
  }

  public OpenShiftConsoleAPIGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public NonNamespaceOperation<ConsoleCLIDownload, ConsoleCLIDownloadList, Resource<ConsoleCLIDownload>> consoleCLIDownloads() {
    return new ConsoleCLIDownloadOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<ConsoleExternalLogLink, ConsoleExternalLogLinkList, Resource<ConsoleExternalLogLink>> consoleExternalLogLinks() {
    return new ConsoleExternalLogLinkOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<ConsoleLink, ConsoleLinkList, Resource<ConsoleLink>> consoleLinks() {
    return new ConsoleLinkOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<ConsoleNotification, ConsoleNotificationList, Resource<ConsoleNotification>> consoleNotifications() {
    return new ConsoleNotificationOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<ConsoleYAMLSample, ConsoleYAMLSampleList, Resource<ConsoleYAMLSample>> consoleYAMLSamples() {
    return new ConsoleYAMLSampleOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<ConsoleQuickStart, ConsoleQuickStartList, Resource<ConsoleQuickStart>> consoleQuickStarts() {
    return new ConsoleQuickStartOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<ConsolePlugin, ConsolePluginList, Resource<ConsolePlugin>> consolePlugins() {
    return new ConsolePluginOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }
}
