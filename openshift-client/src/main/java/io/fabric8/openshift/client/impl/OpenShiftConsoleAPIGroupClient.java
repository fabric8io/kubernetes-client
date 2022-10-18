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
package io.fabric8.openshift.client.impl;

import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;
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

public class OpenShiftConsoleAPIGroupClient extends ClientAdapter<OpenShiftConsoleAPIGroupClient>
    implements OpenShiftConsoleAPIGroupDSL {

  @Override
  public NonNamespaceOperation<ConsoleCLIDownload, ConsoleCLIDownloadList, Resource<ConsoleCLIDownload>> consoleCLIDownloads() {
    return resources(ConsoleCLIDownload.class, ConsoleCLIDownloadList.class);
  }

  @Override
  public NonNamespaceOperation<ConsoleExternalLogLink, ConsoleExternalLogLinkList, Resource<ConsoleExternalLogLink>> consoleExternalLogLinks() {
    return resources(ConsoleExternalLogLink.class, ConsoleExternalLogLinkList.class);
  }

  @Override
  public NonNamespaceOperation<ConsoleLink, ConsoleLinkList, Resource<ConsoleLink>> consoleLinks() {
    return resources(ConsoleLink.class, ConsoleLinkList.class);
  }

  @Override
  public NonNamespaceOperation<ConsoleNotification, ConsoleNotificationList, Resource<ConsoleNotification>> consoleNotifications() {
    return resources(ConsoleNotification.class, ConsoleNotificationList.class);
  }

  @Override
  public NonNamespaceOperation<ConsoleYAMLSample, ConsoleYAMLSampleList, Resource<ConsoleYAMLSample>> consoleYAMLSamples() {
    return resources(ConsoleYAMLSample.class, ConsoleYAMLSampleList.class);
  }

  @Override
  public NonNamespaceOperation<ConsoleQuickStart, ConsoleQuickStartList, Resource<ConsoleQuickStart>> consoleQuickStarts() {
    return resources(ConsoleQuickStart.class, ConsoleQuickStartList.class);
  }

  @Override
  public NonNamespaceOperation<ConsolePlugin, ConsolePluginList, Resource<ConsolePlugin>> consolePlugins() {
    return resources(ConsolePlugin.class, ConsolePluginList.class);
  }

  @Override
  public OpenShiftConsoleAPIGroupClient newInstance() {
    return new OpenShiftConsoleAPIGroupClient();
  }

}
