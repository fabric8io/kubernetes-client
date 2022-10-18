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

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.extension.ExtensionAdapter;
import io.fabric8.kubernetes.client.impl.Handlers;
import io.fabric8.kubernetes.client.impl.InternalExtensionAdapter;
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.Project;
import io.fabric8.openshift.api.model.RoleBinding;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.dsl.MachineConfigurationAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftClusterAutoscalingAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftConfigAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftConsoleAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftHiveAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftMachineAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftMonitoringAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftOperatorAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftOperatorHubAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftQuotaAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftStorageVersionMigratorApiGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftTunedAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftWhereaboutsAPIGroupDSL;
import io.fabric8.openshift.client.dsl.V1ClusterAutoscalingAPIGroupDSL;
import io.fabric8.openshift.client.dsl.V1beta1ClusterAutoscalingAPIGroupDSL;
import io.fabric8.openshift.client.dsl.internal.apps.DeploymentConfigOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.authorization.RoleBindingOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.build.BuildConfigOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.build.BuildOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.core.TemplateOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.project.ProjectOperationsImpl;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

@Component
@Service
public class OpenShiftExtensionAdapter implements ExtensionAdapter<OpenShiftClient>, InternalExtensionAdapter {

  @Override
  public Class<OpenShiftClient> getExtensionType() {
    return OpenShiftClient.class;
  }

  @Override
  public OpenShiftClient adapt(Client client) {
    return new OpenShiftClientImpl(client);
  }

  @Override
  public void registerHandlers(Handlers handlers) {
    handlers.register(BuildConfig.class, BuildConfigOperationsImpl::new);
    handlers.register(Build.class, BuildOperationsImpl::new);
    handlers.register(DeploymentConfig.class, DeploymentConfigOperationsImpl::new);
    handlers.register(RoleBinding.class, RoleBindingOperationsImpl::new);
    handlers.register(Template.class, TemplateOperationsImpl::new);
    handlers.register(Project.class, ProjectOperationsImpl::new);
  }

  @Override
  public void registerClients(ClientFactory factory) {
    factory.register(OpenShiftConfigAPIGroupDSL.class, new OpenShiftConfigAPIGroupClient());
    factory.register(OpenShiftClusterAutoscalingAPIGroupDSL.class, new OpenShiftClusterAutoscalingAPIGroupClient());
    factory.register(OpenShiftHiveAPIGroupDSL.class, new OpenShiftHiveAPIGroupClient());
    factory.register(V1beta1ClusterAutoscalingAPIGroupDSL.class,
        new V1beta1OpenShiftClusterAutoscalingAPIGroupClient());
    factory.register(V1ClusterAutoscalingAPIGroupDSL.class, new V1OpenShiftClusterAutoscalingAPIGroupClient());
    factory.register(OpenShiftConsoleAPIGroupDSL.class, new OpenShiftConsoleAPIGroupClient());
    factory.register(OpenShiftOperatorAPIGroupDSL.class, new OpenShiftOperatorAPIGroupClient());
    factory.register(OpenShiftOperatorHubAPIGroupDSL.class, new OpenShiftOperatorHubAPIGroupClient());
    factory.register(MachineConfigurationAPIGroupDSL.class, new OpenShiftMachineConfigurationAPIGroupClient());
    factory.register(OpenShiftMachineAPIGroupDSL.class, new OpenShiftMachineAPIGroupClient());
    factory.register(OpenShiftMonitoringAPIGroupDSL.class, new OpenShiftMonitoringAPIGroupClient());
    factory.register(OpenShiftTunedAPIGroupDSL.class, new OpenShiftTunedAPIGroupClient());
    factory.register(OpenShiftQuotaAPIGroupDSL.class, new OpenShiftQuotaAPIGroupClient());
    factory.register(OpenShiftWhereaboutsAPIGroupDSL.class, new OpenShiftWhereaboutsAPIGroupClient());
    factory.register(OpenShiftStorageVersionMigratorApiGroupDSL.class, new OpenShiftStorageVersionMigratorApiGroupClient());
  }

}
