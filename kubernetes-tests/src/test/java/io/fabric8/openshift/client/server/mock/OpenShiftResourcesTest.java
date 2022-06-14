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
package io.fabric8.openshift.client.server.mock;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.openshift.api.model.AppliedClusterResourceQuota;
import io.fabric8.openshift.api.model.BrokerTemplateInstance;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.ClusterNetwork;
import io.fabric8.openshift.api.model.ClusterResourceQuota;
import io.fabric8.openshift.api.model.ClusterRole;
import io.fabric8.openshift.api.model.ClusterRoleBinding;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.EgressNetworkPolicy;
import io.fabric8.openshift.api.model.Group;
import io.fabric8.openshift.api.model.HelmChartRepository;
import io.fabric8.openshift.api.model.HostSubnet;
import io.fabric8.openshift.api.model.Identity;
import io.fabric8.openshift.api.model.ImageSignature;
import io.fabric8.openshift.api.model.ImageStream;
import io.fabric8.openshift.api.model.ImageStreamImport;
import io.fabric8.openshift.api.model.ImageStreamMapping;
import io.fabric8.openshift.api.model.ImageStreamTag;
import io.fabric8.openshift.api.model.ImageTag;
import io.fabric8.openshift.api.model.NetNamespace;
import io.fabric8.openshift.api.model.OAuthAccessToken;
import io.fabric8.openshift.api.model.OAuthAuthorizeToken;
import io.fabric8.openshift.api.model.OAuthClient;
import io.fabric8.openshift.api.model.OAuthClientAuthorization;
import io.fabric8.openshift.api.model.ProjectRequest;
import io.fabric8.openshift.api.model.RangeAllocation;
import io.fabric8.openshift.api.model.Role;
import io.fabric8.openshift.api.model.RoleBinding;
import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.SecurityContextConstraints;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateInstance;
import io.fabric8.openshift.api.model.User;
import io.fabric8.openshift.api.model.UserOAuthAccessToken;
import io.fabric8.openshift.api.model.clusterautoscaling.v1.ClusterAutoscaler;
import io.fabric8.openshift.api.model.clusterautoscaling.v1beta1.MachineAutoscaler;
import io.fabric8.openshift.api.model.config.v1.APIServer;
import io.fabric8.openshift.api.model.config.v1.Authentication;
import io.fabric8.openshift.api.model.config.v1.Build;
import io.fabric8.openshift.api.model.config.v1.ClusterOperator;
import io.fabric8.openshift.api.model.config.v1.Console;
import io.fabric8.openshift.api.model.config.v1.DNS;
import io.fabric8.openshift.api.model.config.v1.FeatureGate;
import io.fabric8.openshift.api.model.config.v1.Image;
import io.fabric8.openshift.api.model.config.v1.ImageContentPolicy;
import io.fabric8.openshift.api.model.config.v1.Infrastructure;
import io.fabric8.openshift.api.model.config.v1.Ingress;
import io.fabric8.openshift.api.model.config.v1.Network;
import io.fabric8.openshift.api.model.config.v1.OAuth;
import io.fabric8.openshift.api.model.config.v1.OperatorHub;
import io.fabric8.openshift.api.model.config.v1.Project;
import io.fabric8.openshift.api.model.config.v1.Proxy;
import io.fabric8.openshift.api.model.config.v1.Scheduler;
import io.fabric8.openshift.api.model.console.v1.ConsoleExternalLogLink;
import io.fabric8.openshift.api.model.console.v1.ConsoleLink;
import io.fabric8.openshift.api.model.console.v1.ConsoleNotification;
import io.fabric8.openshift.api.model.console.v1.ConsoleQuickStart;
import io.fabric8.openshift.api.model.console.v1.ConsoleYAMLSample;
import io.fabric8.openshift.api.model.console.v1alpha1.ConsolePlugin;
import io.fabric8.openshift.api.model.machine.v1beta1.Machine;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineSet;
import io.fabric8.openshift.api.model.machineconfig.v1.ContainerRuntimeConfig;
import io.fabric8.openshift.api.model.machineconfig.v1.ControllerConfig;
import io.fabric8.openshift.api.model.machineconfig.v1.KubeletConfig;
import io.fabric8.openshift.api.model.machineconfig.v1.MachineConfig;
import io.fabric8.openshift.api.model.machineconfig.v1.MachineConfigPool;
import io.fabric8.openshift.api.model.miscellaneous.apiserver.v1.APIRequestCount;
import io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1.CredentialsRequest;
import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.EgressRouter;
import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.OperatorPKI;
import io.fabric8.openshift.api.model.operator.v1.CSISnapshotController;
import io.fabric8.openshift.api.model.operator.v1.CloudCredential;
import io.fabric8.openshift.api.model.operator.v1.ClusterCSIDriver;
import io.fabric8.openshift.api.model.operator.v1.Config;
import io.fabric8.openshift.api.model.operator.v1.Etcd;
import io.fabric8.openshift.api.model.operator.v1.IngressController;
import io.fabric8.openshift.api.model.operator.v1.KubeAPIServer;
import io.fabric8.openshift.api.model.operator.v1.KubeControllerManager;
import io.fabric8.openshift.api.model.operator.v1.KubeScheduler;
import io.fabric8.openshift.api.model.operator.v1.KubeStorageVersionMigrator;
import io.fabric8.openshift.api.model.operator.v1.OpenShiftAPIServer;
import io.fabric8.openshift.api.model.operator.v1.OpenShiftControllerManager;
import io.fabric8.openshift.api.model.operator.v1.ServiceCA;
import io.fabric8.openshift.api.model.operator.v1.Storage;
import io.fabric8.openshift.api.model.operator.v1alpha1.ImageContentSourcePolicy;
import io.fabric8.openshift.api.model.tuned.v1.Profile;
import io.fabric8.openshift.api.model.tuned.v1.Tuned;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@EnableKubernetesMockClient
class OpenShiftResourcesTest {
  KubernetesMockServer server;
  OpenShiftClient client;

  private static Stream<Arguments> argumentProvider() {
    return Stream.of(
        Arguments.of(APIRequestCount.class, false, "apiserver.openshift.io", "v1", "apirequestcounts"),
        Arguments.of(DeploymentConfig.class, true, "apps.openshift.io", "v1", "deploymentconfigs"),
        Arguments.of(ClusterRoleBinding.class, false, "authorization.openshift.io", "v1", "clusterrolebindings"),
        Arguments.of(ClusterRole.class, false, "authorization.openshift.io", "v1", "clusterroles"),
        Arguments.of(RoleBinding.class, true, "authorization.openshift.io", "v1", "rolebindings"),
        Arguments.of(Role.class, true, "authorization.openshift.io", "v1", "roles"),
        Arguments.of(ClusterAutoscaler.class, false, "autoscaling.openshift.io", "v1", "clusterautoscalers"),
        Arguments.of(MachineAutoscaler.class, true, "autoscaling.openshift.io", "v1beta1", "machineautoscalers"),
        Arguments.of(BuildConfig.class, true, "build.openshift.io", "v1", "buildconfigs"),
        Arguments.of(io.fabric8.openshift.api.model.Build.class, true, "build.openshift.io", "v1", "builds"),
        Arguments.of(CredentialsRequest.class, true, "cloudcredential.openshift.io", "v1", "credentialsrequests"),
        Arguments.of(ConsoleExternalLogLink.class, false, "console.openshift.io", "v1", "consoleexternalloglinks"),
        Arguments.of(ConsoleLink.class, false, "console.openshift.io", "v1", "consolelinks"),
        Arguments.of(ConsoleNotification.class, false, "console.openshift.io", "v1", "consolenotifications"),
        Arguments.of(ConsolePlugin.class, false, "console.openshift.io", "v1alpha1", "consoleplugins"),
        Arguments.of(ConsoleQuickStart.class, false, "console.openshift.io", "v1", "consolequickstarts"),
        Arguments.of(ConsoleYAMLSample.class, false, "console.openshift.io", "v1", "consoleyamlsamples"),
        Arguments.of(APIServer.class, false, "config.openshift.io", "v1", "apiservers"),
        Arguments.of(Authentication.class, false, "config.openshift.io", "v1", "authentications"),
        Arguments.of(Build.class, false, "config.openshift.io", "v1", "builds"),
        Arguments.of(ClusterOperator.class, false, "config.openshift.io", "v1", "clusteroperators"),
        Arguments.of(Console.class, false, "config.openshift.io", "v1", "consoles"),
        Arguments.of(DNS.class, false, "config.openshift.io", "v1", "dnses"),
        Arguments.of(FeatureGate.class, false, "config.openshift.io", "v1", "featuregates"),
        Arguments.of(ImageContentPolicy.class, false, "config.openshift.io", "v1", "imagecontentpolicies"),
        Arguments.of(Image.class, false, "config.openshift.io", "v1", "images"),
        Arguments.of(Infrastructure.class, false, "config.openshift.io", "v1", "infrastructures"),
        Arguments.of(Ingress.class, false, "config.openshift.io", "v1", "ingresses"),
        Arguments.of(Network.class, false, "config.openshift.io", "v1", "networks"),
        Arguments.of(OAuth.class, false, "config.openshift.io", "v1", "oauths"),
        Arguments.of(OperatorHub.class, false, "config.openshift.io", "v1", "operatorhubs"),
        Arguments.of(Project.class, false, "config.openshift.io", "v1", "projects"),
        Arguments.of(Proxy.class, false, "config.openshift.io", "v1", "proxies"),
        Arguments.of(Scheduler.class, false, "config.openshift.io", "v1", "schedulers"),
        Arguments.of(HelmChartRepository.class, false, "helm.openshift.io", "v1beta1", "helmchartrepositories"),
        Arguments.of(io.fabric8.openshift.api.model.Image.class, false, "image.openshift.io", "v1", "images"),
        Arguments.of(ImageSignature.class, false, "image.openshift.io", "v1", "imagesignatures"),
        Arguments.of(ImageStreamImport.class, true, "image.openshift.io", "v1", "imagestreamimports"),
        Arguments.of(ImageStreamMapping.class, true, "image.openshift.io", "v1", "imagestreammappings"),
        Arguments.of(ImageStream.class, true, "image.openshift.io", "v1", "imagestreams"),
        Arguments.of(ImageStreamTag.class, true, "image.openshift.io", "v1", "imagestreamtags"),
        Arguments.of(ImageTag.class, true, "image.openshift.io", "v1", "imagetags"),
        Arguments.of(Machine.class, true, "machine.openshift.io", "v1beta1", "machines"),
        Arguments.of(MachineSet.class, true, "machine.openshift.io", "v1beta1", "machinesets"),
        Arguments.of(ContainerRuntimeConfig.class, false, "machineconfiguration.openshift.io", "v1", "containerruntimeconfigs"),
        Arguments.of(ControllerConfig.class, false, "machineconfiguration.openshift.io", "v1", "controllerconfigs"),
        Arguments.of(KubeletConfig.class, false, "machineconfiguration.openshift.io", "v1", "kubeletconfigs"),
        Arguments.of(MachineConfigPool.class, false, "machineconfiguration.openshift.io", "v1", "machineconfigpools"),
        Arguments.of(MachineConfig.class, false, "machineconfiguration.openshift.io", "v1", "machineconfigs"),
        Arguments.of(ClusterNetwork.class, false, "network.openshift.io", "v1", "clusternetworks"),
        Arguments.of(EgressNetworkPolicy.class, true, "network.openshift.io", "v1", "egressnetworkpolicies"),
        Arguments.of(HostSubnet.class, false, "network.openshift.io", "v1", "hostsubnets"),
        Arguments.of(NetNamespace.class, false, "network.openshift.io", "v1", "netnamespaces"),
        Arguments.of(EgressRouter.class, true, "network.operator.openshift.io", "v1", "egressrouters"),
        Arguments.of(OperatorPKI.class, true, "network.operator.openshift.io", "v1", "operatorpkis"),
        Arguments.of(OAuthAccessToken.class, false, "oauth.openshift.io", "v1", "oauthaccesstokens"),
        Arguments.of(OAuthAuthorizeToken.class, false, "oauth.openshift.io", "v1", "oauthauthorizetokens"),
        Arguments.of(OAuthClientAuthorization.class, false, "oauth.openshift.io", "v1", "oauthclientauthorizations"),
        Arguments.of(OAuthClient.class, false, "oauth.openshift.io", "v1", "oauthclients"),
        Arguments.of(UserOAuthAccessToken.class, false, "oauth.openshift.io", "v1", "useroauthaccesstokens"),
        Arguments.of(io.fabric8.openshift.api.model.operator.v1.Authentication.class, false, "operator.openshift.io", "v1",
            "authentications"),
        Arguments.of(CloudCredential.class, false, "operator.openshift.io", "v1", "cloudcredentials"),
        Arguments.of(ClusterCSIDriver.class, false, "operator.openshift.io", "v1", "clustercsidrivers"),
        Arguments.of(Config.class, false, "operator.openshift.io", "v1", "configs"),
        Arguments.of(io.fabric8.openshift.api.model.operator.v1.Console.class, false, "operator.openshift.io", "v1",
            "consoles"),
        Arguments.of(io.fabric8.openshift.api.model.operator.v1.Authentication.class, false, "operator.openshift.io", "v1",
            "authentications"),
        Arguments.of(CSISnapshotController.class, false, "operator.openshift.io", "v1", "csisnapshotcontrollers"),
        Arguments.of(io.fabric8.openshift.api.model.operator.v1.DNS.class, false, "operator.openshift.io", "v1", "dnses"),
        Arguments.of(Etcd.class, false, "operator.openshift.io", "v1", "etcds"),
        Arguments.of(ImageContentSourcePolicy.class, false, "operator.openshift.io", "v1alpha1", "imagecontentsourcepolicies"),
        Arguments.of(IngressController.class, true, "operator.openshift.io", "v1", "ingresscontrollers"),
        Arguments.of(KubeAPIServer.class, false, "operator.openshift.io", "v1", "kubeapiservers"),
        Arguments.of(KubeControllerManager.class, false, "operator.openshift.io", "v1", "kubecontrollermanagers"),
        Arguments.of(KubeScheduler.class, false, "operator.openshift.io", "v1", "kubeschedulers"),
        Arguments.of(KubeStorageVersionMigrator.class, false, "operator.openshift.io", "v1", "kubestorageversionmigrators"),
        Arguments.of(io.fabric8.openshift.api.model.operator.v1.Network.class, false, "operator.openshift.io", "v1",
            "networks"),
        Arguments.of(OpenShiftAPIServer.class, false, "operator.openshift.io", "v1", "openshiftapiservers"),
        Arguments.of(OpenShiftControllerManager.class, false, "operator.openshift.io", "v1", "openshiftcontrollermanagers"),
        Arguments.of(ServiceCA.class, false, "operator.openshift.io", "v1", "servicecas"),
        Arguments.of(Storage.class, false, "operator.openshift.io", "v1", "storages"),
        Arguments.of(ProjectRequest.class, false, "project.openshift.io", "v1", "projectrequests"),
        Arguments.of(io.fabric8.openshift.api.model.Project.class, false, "project.openshift.io", "v1", "projects"),
        Arguments.of(AppliedClusterResourceQuota.class, true, "quota.openshift.io", "v1", "appliedclusterresourcequotas"),
        Arguments.of(ClusterResourceQuota.class, false, "quota.openshift.io", "v1", "clusterresourcequotas"),
        Arguments.of(Route.class, true, "route.openshift.io", "v1", "routes"),
        Arguments.of(RangeAllocation.class, false, "security.openshift.io", "v1", "rangeallocations"),
        Arguments.of(SecurityContextConstraints.class, false, "security.openshift.io", "v1", "securitycontextconstraints"),
        Arguments.of(BrokerTemplateInstance.class, false, "template.openshift.io", "v1", "brokertemplateinstances"),
        Arguments.of(TemplateInstance.class, true, "template.openshift.io", "v1", "templateinstances"),
        Arguments.of(Template.class, true, "template.openshift.io", "v1", "templates"),
        Arguments.of(Profile.class, true, "tuned.openshift.io", "v1", "profiles"),
        Arguments.of(Tuned.class, true, "tuned.openshift.io", "v1", "tuneds"),
        Arguments.of(Group.class, false, "user.openshift.io", "v1", "groups"),
        Arguments.of(Identity.class, false, "user.openshift.io", "v1", "identities"),
        Arguments.of(User.class, false, "user.openshift.io", "v1", "users"));
  }

  @ParameterizedTest
  @MethodSource("argumentProvider")
  void resource_whenDelete_shouldSendHttpDeleteRequestToApiServer(Class<? extends HasMetadata> resourceClass,
      boolean isNamespaced, String group, String version, String plural) {
    // Given
    server.expect().delete()
        .withPath(createResourceUrl(isNamespaced, group, version, plural))
        .andReturn(HTTP_OK, new StatusBuilder().withStatus("success").build())
        .once();

    // When
    boolean resourceDeleted = client.resources(resourceClass).withName("foo").delete().size() == 1;

    // Then
    assertThat(resourceDeleted).isTrue();
  }

  private String createResourceUrl(boolean isNamespaced, String group, String version, String plural) {
    StringBuilder urlBuilder = new StringBuilder();
    urlBuilder.append("/apis/")
        .append(group)
        .append("/")
        .append(version);
    if (isNamespaced) {
      urlBuilder.append("/namespaces/test");
    }
    urlBuilder.append("/").append(plural).append("/foo");
    return urlBuilder.toString();
  }
}
