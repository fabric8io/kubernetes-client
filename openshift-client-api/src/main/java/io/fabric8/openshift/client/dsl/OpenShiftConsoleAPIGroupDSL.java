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
package io.fabric8.openshift.client.dsl;

import io.fabric8.kubernetes.client.Client;
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

public interface OpenShiftConsoleAPIGroupDSL extends Client {
  /**
   * API entrypoint for ConsoleCLIDownload related operations(console.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for ConsoleCLIDownload type
   */
  NonNamespaceOperation<ConsoleCLIDownload, ConsoleCLIDownloadList, Resource<ConsoleCLIDownload>> consoleCLIDownloads();

  /**
   * API entrypoint for ConsoleExternalLogLink related operations(console.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for ConsoleExternalLogLink type
   */
  NonNamespaceOperation<ConsoleExternalLogLink, ConsoleExternalLogLinkList, Resource<ConsoleExternalLogLink>> consoleExternalLogLinks();

  /**
   * API entrypoint for ConsoleLink related operations(console.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for ConsoleLink type
   */
  NonNamespaceOperation<ConsoleLink, ConsoleLinkList, Resource<ConsoleLink>> consoleLinks();

  /**
   * API entrypoint for ConsoleNotification related operations(console.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for ConsoleNotification type
   */
  NonNamespaceOperation<ConsoleNotification, ConsoleNotificationList, Resource<ConsoleNotification>> consoleNotifications();

  /**
   * API entrypoint for ConsoleYAMLSample related operations(console.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for ConsoleYAMLSample type
   */
  NonNamespaceOperation<ConsoleYAMLSample, ConsoleYAMLSampleList, Resource<ConsoleYAMLSample>> consoleYAMLSamples();

  /**
   * DSL entrypoint for ConsoleQuickStart (console.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for ConsoleQuickstart
   */
  NonNamespaceOperation<ConsoleQuickStart, ConsoleQuickStartList, Resource<ConsoleQuickStart>> consoleQuickStarts();

  /**
   * DSL entrypoint for ConsolePlugin (console.openshift.io/v1alpha1
   *
   * @return NonNamespaceOperation object for ConsolePlugin
   */
  NonNamespaceOperation<ConsolePlugin, ConsolePluginList, Resource<ConsolePlugin>> consolePlugins();
}
