
package io.fabric8.openclustermanagement.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.Application;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.ApplicationList;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.ApplicationSpec;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.ApplicationStatus;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.Condition;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.ConfigMapKeySelector;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.ContactData;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.Descriptor;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.ImageSpec;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.InfoItem;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.InfoItemSource;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.IngressSelector;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.Link;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.ObjectStatus;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.SecretKeySelector;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.ServiceSelector;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorschannel.apps.v1.Channel;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorschannel.apps.v1.ChannelGate;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorschannel.apps.v1.ChannelList;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorschannel.apps.v1.ChannelSpec;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorschannel.apps.v1.ChannelStatus;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.helmrelease.v1.AltSource;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.helmrelease.v1.Git;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.helmrelease.v1.GitHub;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.helmrelease.v1.HelmAppCondition;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.helmrelease.v1.HelmAppRelease;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.helmrelease.v1.HelmAppStatus;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.helmrelease.v1.HelmRelease;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.helmrelease.v1.HelmReleaseList;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.helmrelease.v1.HelmReleaseRepo;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.helmrelease.v1.HelmRepo;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.helmrelease.v1.Source;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.placementrule.v1.GenericClusterReference;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.placementrule.v1.Placement;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1.AllowDenyItem;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1.AnsibleJobsStatus;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1.ClusterOverride;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1.ClusterOverrides;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1.HourRange;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1.Overrides;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1.PackageFilter;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1.Subscription;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1.SubscriptionList;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1.SubscriptionPerClusterStatus;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1.SubscriptionSpec;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1.SubscriptionStatus;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1.SubscriptionUnitStatus;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1.TimeWindow;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "open-cluster-management_io_multicloud-operators-channel_pkg_apis_apps_v1_Channel",
    "open-cluster-management_io_multicloud-operators-channel_pkg_apis_apps_v1_ChannelGate",
    "open-cluster-management_io_multicloud-operators-channel_pkg_apis_apps_v1_ChannelList",
    "open-cluster-management_io_multicloud-operators-channel_pkg_apis_apps_v1_ChannelSpec",
    "open-cluster-management_io_multicloud-operators-channel_pkg_apis_apps_v1_ChannelStatus",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_AltSource",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_Git",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_GitHub",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmAppCondition",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmAppRelease",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmAppStatus",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmRelease",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmReleaseList",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmReleaseRepo",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmRepo",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_Source",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_placementrule_v1_GenericClusterReference",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_placementrule_v1_Placement",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_AllowDenyItem",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_AnsibleJobsStatus",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_ClusterOverride",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_ClusterOverrides",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_HourRange",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_Overrides",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_PackageFilter",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_Subscription",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_SubscriptionList",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_SubscriptionPerClusterStatus",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_SubscriptionSpec",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_SubscriptionStatus",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_SubscriptionUnitStatus",
    "open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_TimeWindow",
    "sigs_k8s_io_application_api_v1beta1_Application",
    "sigs_k8s_io_application_api_v1beta1_ApplicationList",
    "sigs_k8s_io_application_api_v1beta1_ApplicationSpec",
    "sigs_k8s_io_application_api_v1beta1_ApplicationStatus",
    "sigs_k8s_io_application_api_v1beta1_Condition",
    "sigs_k8s_io_application_api_v1beta1_ConfigMapKeySelector",
    "sigs_k8s_io_application_api_v1beta1_ContactData",
    "sigs_k8s_io_application_api_v1beta1_Descriptor",
    "sigs_k8s_io_application_api_v1beta1_ImageSpec",
    "sigs_k8s_io_application_api_v1beta1_InfoItem",
    "sigs_k8s_io_application_api_v1beta1_InfoItemSource",
    "sigs_k8s_io_application_api_v1beta1_IngressSelector",
    "sigs_k8s_io_application_api_v1beta1_Link",
    "sigs_k8s_io_application_api_v1beta1_ObjectStatus",
    "sigs_k8s_io_application_api_v1beta1_SecretKeySelector",
    "sigs_k8s_io_application_api_v1beta1_ServiceSelector"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class OpenClusterManagementAppsSchema {

    @JsonProperty("open-cluster-management_io_multicloud-operators-channel_pkg_apis_apps_v1_Channel")
    private Channel openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1Channel;
    @JsonProperty("open-cluster-management_io_multicloud-operators-channel_pkg_apis_apps_v1_ChannelGate")
    private ChannelGate openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelGate;
    @JsonProperty("open-cluster-management_io_multicloud-operators-channel_pkg_apis_apps_v1_ChannelList")
    private ChannelList openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelList;
    @JsonProperty("open-cluster-management_io_multicloud-operators-channel_pkg_apis_apps_v1_ChannelSpec")
    private ChannelSpec openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelSpec;
    @JsonProperty("open-cluster-management_io_multicloud-operators-channel_pkg_apis_apps_v1_ChannelStatus")
    private ChannelStatus openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelStatus;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_AltSource")
    private AltSource openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1AltSource;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_Git")
    private Git openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1Git;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_GitHub")
    private GitHub openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1GitHub;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmAppCondition")
    private HelmAppCondition openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppCondition;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmAppRelease")
    private HelmAppRelease openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppRelease;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmAppStatus")
    private HelmAppStatus openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppStatus;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmRelease")
    private HelmRelease openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmRelease;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmReleaseList")
    private HelmReleaseList openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmReleaseList;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmReleaseRepo")
    private HelmReleaseRepo openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmReleaseRepo;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmRepo")
    private HelmRepo openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmRepo;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_Source")
    private Source openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1Source;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_placementrule_v1_GenericClusterReference")
    private GenericClusterReference openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsPlacementruleV1GenericClusterReference;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_placementrule_v1_Placement")
    private Placement openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsPlacementruleV1Placement;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_AllowDenyItem")
    private AllowDenyItem openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1AllowDenyItem;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_AnsibleJobsStatus")
    private AnsibleJobsStatus openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1AnsibleJobsStatus;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_ClusterOverride")
    private ClusterOverride openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1ClusterOverride;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_ClusterOverrides")
    private ClusterOverrides openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1ClusterOverrides;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_HourRange")
    private HourRange openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1HourRange;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_Overrides")
    private Overrides openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1Overrides;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_PackageFilter")
    private PackageFilter openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1PackageFilter;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_Subscription")
    private Subscription openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1Subscription;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_SubscriptionList")
    private SubscriptionList openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionList;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_SubscriptionPerClusterStatus")
    private SubscriptionPerClusterStatus openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionPerClusterStatus;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_SubscriptionSpec")
    private SubscriptionSpec openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionSpec;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_SubscriptionStatus")
    private SubscriptionStatus openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionStatus;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_SubscriptionUnitStatus")
    private SubscriptionUnitStatus openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionUnitStatus;
    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_TimeWindow")
    private TimeWindow openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1TimeWindow;
    @JsonProperty("sigs_k8s_io_application_api_v1beta1_Application")
    private Application sigsK8sIoApplicationApiV1beta1Application;
    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ApplicationList")
    private ApplicationList sigsK8sIoApplicationApiV1beta1ApplicationList;
    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ApplicationSpec")
    private ApplicationSpec sigsK8sIoApplicationApiV1beta1ApplicationSpec;
    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ApplicationStatus")
    private ApplicationStatus sigsK8sIoApplicationApiV1beta1ApplicationStatus;
    @JsonProperty("sigs_k8s_io_application_api_v1beta1_Condition")
    private Condition sigsK8sIoApplicationApiV1beta1Condition;
    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ConfigMapKeySelector")
    private ConfigMapKeySelector sigsK8sIoApplicationApiV1beta1ConfigMapKeySelector;
    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ContactData")
    private ContactData sigsK8sIoApplicationApiV1beta1ContactData;
    @JsonProperty("sigs_k8s_io_application_api_v1beta1_Descriptor")
    private Descriptor sigsK8sIoApplicationApiV1beta1Descriptor;
    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ImageSpec")
    private ImageSpec sigsK8sIoApplicationApiV1beta1ImageSpec;
    @JsonProperty("sigs_k8s_io_application_api_v1beta1_InfoItem")
    private InfoItem sigsK8sIoApplicationApiV1beta1InfoItem;
    @JsonProperty("sigs_k8s_io_application_api_v1beta1_InfoItemSource")
    private InfoItemSource sigsK8sIoApplicationApiV1beta1InfoItemSource;
    @JsonProperty("sigs_k8s_io_application_api_v1beta1_IngressSelector")
    private IngressSelector sigsK8sIoApplicationApiV1beta1IngressSelector;
    @JsonProperty("sigs_k8s_io_application_api_v1beta1_Link")
    private Link sigsK8sIoApplicationApiV1beta1Link;
    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ObjectStatus")
    private ObjectStatus sigsK8sIoApplicationApiV1beta1ObjectStatus;
    @JsonProperty("sigs_k8s_io_application_api_v1beta1_SecretKeySelector")
    private SecretKeySelector sigsK8sIoApplicationApiV1beta1SecretKeySelector;
    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ServiceSelector")
    private ServiceSelector sigsK8sIoApplicationApiV1beta1ServiceSelector;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OpenClusterManagementAppsSchema() {
    }

    /**
     * 
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsPlacementruleV1Placement
     * @param openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelList
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1GitHub
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionStatus
     * @param sigsK8sIoApplicationApiV1beta1ApplicationList
     * @param sigsK8sIoApplicationApiV1beta1SecretKeySelector
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1ClusterOverride
     * @param sigsK8sIoApplicationApiV1beta1ConfigMapKeySelector
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1HourRange
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppRelease
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1Source
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1ClusterOverrides
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmRelease
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionUnitStatus
     * @param sigsK8sIoApplicationApiV1beta1ServiceSelector
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1AltSource
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsPlacementruleV1GenericClusterReference
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionSpec
     * @param sigsK8sIoApplicationApiV1beta1ImageSpec
     * @param openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelGate
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppCondition
     * @param sigsK8sIoApplicationApiV1beta1ApplicationStatus
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmRepo
     * @param sigsK8sIoApplicationApiV1beta1Descriptor
     * @param sigsK8sIoApplicationApiV1beta1ApplicationSpec
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1Git
     * @param sigsK8sIoApplicationApiV1beta1InfoItem
     * @param sigsK8sIoApplicationApiV1beta1InfoItemSource
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmReleaseRepo
     * @param sigsK8sIoApplicationApiV1beta1Application
     * @param openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelStatus
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppStatus
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1Subscription
     * @param sigsK8sIoApplicationApiV1beta1IngressSelector
     * @param sigsK8sIoApplicationApiV1beta1Link
     * @param openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelSpec
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1PackageFilter
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1TimeWindow
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmReleaseList
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1Overrides
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionList
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1AllowDenyItem
     * @param sigsK8sIoApplicationApiV1beta1Condition
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionPerClusterStatus
     * @param sigsK8sIoApplicationApiV1beta1ContactData
     * @param sigsK8sIoApplicationApiV1beta1ObjectStatus
     * @param openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1AnsibleJobsStatus
     * @param openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1Channel
     */
    public OpenClusterManagementAppsSchema(Channel openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1Channel, ChannelGate openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelGate, ChannelList openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelList, ChannelSpec openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelSpec, ChannelStatus openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelStatus, AltSource openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1AltSource, Git openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1Git, GitHub openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1GitHub, HelmAppCondition openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppCondition, HelmAppRelease openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppRelease, HelmAppStatus openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppStatus, HelmRelease openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmRelease, HelmReleaseList openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmReleaseList, HelmReleaseRepo openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmReleaseRepo, HelmRepo openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmRepo, Source openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1Source, GenericClusterReference openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsPlacementruleV1GenericClusterReference, Placement openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsPlacementruleV1Placement, AllowDenyItem openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1AllowDenyItem, AnsibleJobsStatus openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1AnsibleJobsStatus, ClusterOverride openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1ClusterOverride, ClusterOverrides openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1ClusterOverrides, HourRange openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1HourRange, Overrides openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1Overrides, PackageFilter openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1PackageFilter, Subscription openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1Subscription, SubscriptionList openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionList, SubscriptionPerClusterStatus openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionPerClusterStatus, SubscriptionSpec openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionSpec, SubscriptionStatus openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionStatus, SubscriptionUnitStatus openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionUnitStatus, TimeWindow openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1TimeWindow, Application sigsK8sIoApplicationApiV1beta1Application, ApplicationList sigsK8sIoApplicationApiV1beta1ApplicationList, ApplicationSpec sigsK8sIoApplicationApiV1beta1ApplicationSpec, ApplicationStatus sigsK8sIoApplicationApiV1beta1ApplicationStatus, Condition sigsK8sIoApplicationApiV1beta1Condition, ConfigMapKeySelector sigsK8sIoApplicationApiV1beta1ConfigMapKeySelector, ContactData sigsK8sIoApplicationApiV1beta1ContactData, Descriptor sigsK8sIoApplicationApiV1beta1Descriptor, ImageSpec sigsK8sIoApplicationApiV1beta1ImageSpec, InfoItem sigsK8sIoApplicationApiV1beta1InfoItem, InfoItemSource sigsK8sIoApplicationApiV1beta1InfoItemSource, IngressSelector sigsK8sIoApplicationApiV1beta1IngressSelector, Link sigsK8sIoApplicationApiV1beta1Link, ObjectStatus sigsK8sIoApplicationApiV1beta1ObjectStatus, SecretKeySelector sigsK8sIoApplicationApiV1beta1SecretKeySelector, ServiceSelector sigsK8sIoApplicationApiV1beta1ServiceSelector) {
        super();
        this.openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1Channel = openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1Channel;
        this.openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelGate = openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelGate;
        this.openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelList = openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelList;
        this.openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelSpec = openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelSpec;
        this.openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelStatus = openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelStatus;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1AltSource = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1AltSource;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1Git = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1Git;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1GitHub = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1GitHub;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppCondition = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppCondition;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppRelease = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppRelease;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppStatus = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppStatus;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmRelease = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmRelease;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmReleaseList = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmReleaseList;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmReleaseRepo = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmReleaseRepo;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmRepo = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmRepo;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1Source = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1Source;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsPlacementruleV1GenericClusterReference = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsPlacementruleV1GenericClusterReference;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsPlacementruleV1Placement = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsPlacementruleV1Placement;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1AllowDenyItem = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1AllowDenyItem;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1AnsibleJobsStatus = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1AnsibleJobsStatus;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1ClusterOverride = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1ClusterOverride;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1ClusterOverrides = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1ClusterOverrides;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1HourRange = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1HourRange;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1Overrides = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1Overrides;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1PackageFilter = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1PackageFilter;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1Subscription = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1Subscription;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionList = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionList;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionPerClusterStatus = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionPerClusterStatus;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionSpec = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionSpec;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionStatus = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionStatus;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionUnitStatus = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionUnitStatus;
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1TimeWindow = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1TimeWindow;
        this.sigsK8sIoApplicationApiV1beta1Application = sigsK8sIoApplicationApiV1beta1Application;
        this.sigsK8sIoApplicationApiV1beta1ApplicationList = sigsK8sIoApplicationApiV1beta1ApplicationList;
        this.sigsK8sIoApplicationApiV1beta1ApplicationSpec = sigsK8sIoApplicationApiV1beta1ApplicationSpec;
        this.sigsK8sIoApplicationApiV1beta1ApplicationStatus = sigsK8sIoApplicationApiV1beta1ApplicationStatus;
        this.sigsK8sIoApplicationApiV1beta1Condition = sigsK8sIoApplicationApiV1beta1Condition;
        this.sigsK8sIoApplicationApiV1beta1ConfigMapKeySelector = sigsK8sIoApplicationApiV1beta1ConfigMapKeySelector;
        this.sigsK8sIoApplicationApiV1beta1ContactData = sigsK8sIoApplicationApiV1beta1ContactData;
        this.sigsK8sIoApplicationApiV1beta1Descriptor = sigsK8sIoApplicationApiV1beta1Descriptor;
        this.sigsK8sIoApplicationApiV1beta1ImageSpec = sigsK8sIoApplicationApiV1beta1ImageSpec;
        this.sigsK8sIoApplicationApiV1beta1InfoItem = sigsK8sIoApplicationApiV1beta1InfoItem;
        this.sigsK8sIoApplicationApiV1beta1InfoItemSource = sigsK8sIoApplicationApiV1beta1InfoItemSource;
        this.sigsK8sIoApplicationApiV1beta1IngressSelector = sigsK8sIoApplicationApiV1beta1IngressSelector;
        this.sigsK8sIoApplicationApiV1beta1Link = sigsK8sIoApplicationApiV1beta1Link;
        this.sigsK8sIoApplicationApiV1beta1ObjectStatus = sigsK8sIoApplicationApiV1beta1ObjectStatus;
        this.sigsK8sIoApplicationApiV1beta1SecretKeySelector = sigsK8sIoApplicationApiV1beta1SecretKeySelector;
        this.sigsK8sIoApplicationApiV1beta1ServiceSelector = sigsK8sIoApplicationApiV1beta1ServiceSelector;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-channel_pkg_apis_apps_v1_Channel")
    public Channel getOpenClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1Channel() {
        return openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1Channel;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-channel_pkg_apis_apps_v1_Channel")
    public void setOpenClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1Channel(Channel openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1Channel) {
        this.openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1Channel = openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1Channel;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-channel_pkg_apis_apps_v1_ChannelGate")
    public ChannelGate getOpenClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelGate() {
        return openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelGate;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-channel_pkg_apis_apps_v1_ChannelGate")
    public void setOpenClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelGate(ChannelGate openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelGate) {
        this.openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelGate = openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelGate;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-channel_pkg_apis_apps_v1_ChannelList")
    public ChannelList getOpenClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelList() {
        return openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelList;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-channel_pkg_apis_apps_v1_ChannelList")
    public void setOpenClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelList(ChannelList openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelList) {
        this.openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelList = openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelList;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-channel_pkg_apis_apps_v1_ChannelSpec")
    public ChannelSpec getOpenClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelSpec() {
        return openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelSpec;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-channel_pkg_apis_apps_v1_ChannelSpec")
    public void setOpenClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelSpec(ChannelSpec openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelSpec) {
        this.openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelSpec = openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelSpec;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-channel_pkg_apis_apps_v1_ChannelStatus")
    public ChannelStatus getOpenClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelStatus() {
        return openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelStatus;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-channel_pkg_apis_apps_v1_ChannelStatus")
    public void setOpenClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelStatus(ChannelStatus openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelStatus) {
        this.openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelStatus = openClusterManagementIoMulticloudOperatorsChannelPkgApisAppsV1ChannelStatus;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_AltSource")
    public AltSource getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1AltSource() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1AltSource;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_AltSource")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1AltSource(AltSource openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1AltSource) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1AltSource = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1AltSource;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_Git")
    public Git getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1Git() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1Git;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_Git")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1Git(Git openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1Git) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1Git = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1Git;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_GitHub")
    public GitHub getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1GitHub() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1GitHub;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_GitHub")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1GitHub(GitHub openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1GitHub) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1GitHub = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1GitHub;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmAppCondition")
    public HelmAppCondition getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppCondition() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppCondition;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmAppCondition")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppCondition(HelmAppCondition openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppCondition) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppCondition = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppCondition;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmAppRelease")
    public HelmAppRelease getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppRelease() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppRelease;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmAppRelease")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppRelease(HelmAppRelease openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppRelease) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppRelease = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppRelease;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmAppStatus")
    public HelmAppStatus getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppStatus() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppStatus;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmAppStatus")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppStatus(HelmAppStatus openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppStatus) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppStatus = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmAppStatus;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmRelease")
    public HelmRelease getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmRelease() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmRelease;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmRelease")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmRelease(HelmRelease openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmRelease) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmRelease = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmRelease;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmReleaseList")
    public HelmReleaseList getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmReleaseList() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmReleaseList;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmReleaseList")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmReleaseList(HelmReleaseList openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmReleaseList) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmReleaseList = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmReleaseList;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmReleaseRepo")
    public HelmReleaseRepo getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmReleaseRepo() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmReleaseRepo;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmReleaseRepo")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmReleaseRepo(HelmReleaseRepo openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmReleaseRepo) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmReleaseRepo = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmReleaseRepo;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmRepo")
    public HelmRepo getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmRepo() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmRepo;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_HelmRepo")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmRepo(HelmRepo openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmRepo) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmRepo = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1HelmRepo;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_Source")
    public Source getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1Source() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1Source;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_helmrelease_v1_Source")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1Source(Source openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1Source) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1Source = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsHelmreleaseV1Source;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_placementrule_v1_GenericClusterReference")
    public GenericClusterReference getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsPlacementruleV1GenericClusterReference() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsPlacementruleV1GenericClusterReference;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_placementrule_v1_GenericClusterReference")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsPlacementruleV1GenericClusterReference(GenericClusterReference openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsPlacementruleV1GenericClusterReference) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsPlacementruleV1GenericClusterReference = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsPlacementruleV1GenericClusterReference;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_placementrule_v1_Placement")
    public Placement getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsPlacementruleV1Placement() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsPlacementruleV1Placement;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_placementrule_v1_Placement")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsPlacementruleV1Placement(Placement openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsPlacementruleV1Placement) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsPlacementruleV1Placement = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsPlacementruleV1Placement;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_AllowDenyItem")
    public AllowDenyItem getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1AllowDenyItem() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1AllowDenyItem;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_AllowDenyItem")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1AllowDenyItem(AllowDenyItem openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1AllowDenyItem) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1AllowDenyItem = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1AllowDenyItem;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_AnsibleJobsStatus")
    public AnsibleJobsStatus getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1AnsibleJobsStatus() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1AnsibleJobsStatus;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_AnsibleJobsStatus")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1AnsibleJobsStatus(AnsibleJobsStatus openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1AnsibleJobsStatus) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1AnsibleJobsStatus = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1AnsibleJobsStatus;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_ClusterOverride")
    public ClusterOverride getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1ClusterOverride() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1ClusterOverride;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_ClusterOverride")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1ClusterOverride(ClusterOverride openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1ClusterOverride) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1ClusterOverride = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1ClusterOverride;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_ClusterOverrides")
    public ClusterOverrides getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1ClusterOverrides() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1ClusterOverrides;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_ClusterOverrides")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1ClusterOverrides(ClusterOverrides openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1ClusterOverrides) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1ClusterOverrides = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1ClusterOverrides;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_HourRange")
    public HourRange getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1HourRange() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1HourRange;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_HourRange")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1HourRange(HourRange openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1HourRange) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1HourRange = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1HourRange;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_Overrides")
    public Overrides getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1Overrides() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1Overrides;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_Overrides")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1Overrides(Overrides openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1Overrides) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1Overrides = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1Overrides;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_PackageFilter")
    public PackageFilter getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1PackageFilter() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1PackageFilter;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_PackageFilter")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1PackageFilter(PackageFilter openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1PackageFilter) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1PackageFilter = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1PackageFilter;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_Subscription")
    public Subscription getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1Subscription() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1Subscription;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_Subscription")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1Subscription(Subscription openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1Subscription) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1Subscription = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1Subscription;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_SubscriptionList")
    public SubscriptionList getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionList() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionList;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_SubscriptionList")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionList(SubscriptionList openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionList) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionList = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionList;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_SubscriptionPerClusterStatus")
    public SubscriptionPerClusterStatus getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionPerClusterStatus() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionPerClusterStatus;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_SubscriptionPerClusterStatus")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionPerClusterStatus(SubscriptionPerClusterStatus openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionPerClusterStatus) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionPerClusterStatus = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionPerClusterStatus;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_SubscriptionSpec")
    public SubscriptionSpec getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionSpec() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionSpec;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_SubscriptionSpec")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionSpec(SubscriptionSpec openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionSpec) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionSpec = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionSpec;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_SubscriptionStatus")
    public SubscriptionStatus getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionStatus() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionStatus;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_SubscriptionStatus")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionStatus(SubscriptionStatus openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionStatus) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionStatus = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionStatus;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_SubscriptionUnitStatus")
    public SubscriptionUnitStatus getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionUnitStatus() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionUnitStatus;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_SubscriptionUnitStatus")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionUnitStatus(SubscriptionUnitStatus openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionUnitStatus) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionUnitStatus = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1SubscriptionUnitStatus;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_TimeWindow")
    public TimeWindow getOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1TimeWindow() {
        return openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1TimeWindow;
    }

    @JsonProperty("open-cluster-management_io_multicloud-operators-subscription_pkg_apis_apps_v1_TimeWindow")
    public void setOpenClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1TimeWindow(TimeWindow openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1TimeWindow) {
        this.openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1TimeWindow = openClusterManagementIoMulticloudOperatorsSubscriptionPkgApisAppsV1TimeWindow;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_Application")
    public Application getSigsK8sIoApplicationApiV1beta1Application() {
        return sigsK8sIoApplicationApiV1beta1Application;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_Application")
    public void setSigsK8sIoApplicationApiV1beta1Application(Application sigsK8sIoApplicationApiV1beta1Application) {
        this.sigsK8sIoApplicationApiV1beta1Application = sigsK8sIoApplicationApiV1beta1Application;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ApplicationList")
    public ApplicationList getSigsK8sIoApplicationApiV1beta1ApplicationList() {
        return sigsK8sIoApplicationApiV1beta1ApplicationList;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ApplicationList")
    public void setSigsK8sIoApplicationApiV1beta1ApplicationList(ApplicationList sigsK8sIoApplicationApiV1beta1ApplicationList) {
        this.sigsK8sIoApplicationApiV1beta1ApplicationList = sigsK8sIoApplicationApiV1beta1ApplicationList;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ApplicationSpec")
    public ApplicationSpec getSigsK8sIoApplicationApiV1beta1ApplicationSpec() {
        return sigsK8sIoApplicationApiV1beta1ApplicationSpec;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ApplicationSpec")
    public void setSigsK8sIoApplicationApiV1beta1ApplicationSpec(ApplicationSpec sigsK8sIoApplicationApiV1beta1ApplicationSpec) {
        this.sigsK8sIoApplicationApiV1beta1ApplicationSpec = sigsK8sIoApplicationApiV1beta1ApplicationSpec;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ApplicationStatus")
    public ApplicationStatus getSigsK8sIoApplicationApiV1beta1ApplicationStatus() {
        return sigsK8sIoApplicationApiV1beta1ApplicationStatus;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ApplicationStatus")
    public void setSigsK8sIoApplicationApiV1beta1ApplicationStatus(ApplicationStatus sigsK8sIoApplicationApiV1beta1ApplicationStatus) {
        this.sigsK8sIoApplicationApiV1beta1ApplicationStatus = sigsK8sIoApplicationApiV1beta1ApplicationStatus;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_Condition")
    public Condition getSigsK8sIoApplicationApiV1beta1Condition() {
        return sigsK8sIoApplicationApiV1beta1Condition;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_Condition")
    public void setSigsK8sIoApplicationApiV1beta1Condition(Condition sigsK8sIoApplicationApiV1beta1Condition) {
        this.sigsK8sIoApplicationApiV1beta1Condition = sigsK8sIoApplicationApiV1beta1Condition;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ConfigMapKeySelector")
    public ConfigMapKeySelector getSigsK8sIoApplicationApiV1beta1ConfigMapKeySelector() {
        return sigsK8sIoApplicationApiV1beta1ConfigMapKeySelector;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ConfigMapKeySelector")
    public void setSigsK8sIoApplicationApiV1beta1ConfigMapKeySelector(ConfigMapKeySelector sigsK8sIoApplicationApiV1beta1ConfigMapKeySelector) {
        this.sigsK8sIoApplicationApiV1beta1ConfigMapKeySelector = sigsK8sIoApplicationApiV1beta1ConfigMapKeySelector;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ContactData")
    public ContactData getSigsK8sIoApplicationApiV1beta1ContactData() {
        return sigsK8sIoApplicationApiV1beta1ContactData;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ContactData")
    public void setSigsK8sIoApplicationApiV1beta1ContactData(ContactData sigsK8sIoApplicationApiV1beta1ContactData) {
        this.sigsK8sIoApplicationApiV1beta1ContactData = sigsK8sIoApplicationApiV1beta1ContactData;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_Descriptor")
    public Descriptor getSigsK8sIoApplicationApiV1beta1Descriptor() {
        return sigsK8sIoApplicationApiV1beta1Descriptor;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_Descriptor")
    public void setSigsK8sIoApplicationApiV1beta1Descriptor(Descriptor sigsK8sIoApplicationApiV1beta1Descriptor) {
        this.sigsK8sIoApplicationApiV1beta1Descriptor = sigsK8sIoApplicationApiV1beta1Descriptor;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ImageSpec")
    public ImageSpec getSigsK8sIoApplicationApiV1beta1ImageSpec() {
        return sigsK8sIoApplicationApiV1beta1ImageSpec;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ImageSpec")
    public void setSigsK8sIoApplicationApiV1beta1ImageSpec(ImageSpec sigsK8sIoApplicationApiV1beta1ImageSpec) {
        this.sigsK8sIoApplicationApiV1beta1ImageSpec = sigsK8sIoApplicationApiV1beta1ImageSpec;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_InfoItem")
    public InfoItem getSigsK8sIoApplicationApiV1beta1InfoItem() {
        return sigsK8sIoApplicationApiV1beta1InfoItem;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_InfoItem")
    public void setSigsK8sIoApplicationApiV1beta1InfoItem(InfoItem sigsK8sIoApplicationApiV1beta1InfoItem) {
        this.sigsK8sIoApplicationApiV1beta1InfoItem = sigsK8sIoApplicationApiV1beta1InfoItem;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_InfoItemSource")
    public InfoItemSource getSigsK8sIoApplicationApiV1beta1InfoItemSource() {
        return sigsK8sIoApplicationApiV1beta1InfoItemSource;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_InfoItemSource")
    public void setSigsK8sIoApplicationApiV1beta1InfoItemSource(InfoItemSource sigsK8sIoApplicationApiV1beta1InfoItemSource) {
        this.sigsK8sIoApplicationApiV1beta1InfoItemSource = sigsK8sIoApplicationApiV1beta1InfoItemSource;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_IngressSelector")
    public IngressSelector getSigsK8sIoApplicationApiV1beta1IngressSelector() {
        return sigsK8sIoApplicationApiV1beta1IngressSelector;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_IngressSelector")
    public void setSigsK8sIoApplicationApiV1beta1IngressSelector(IngressSelector sigsK8sIoApplicationApiV1beta1IngressSelector) {
        this.sigsK8sIoApplicationApiV1beta1IngressSelector = sigsK8sIoApplicationApiV1beta1IngressSelector;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_Link")
    public Link getSigsK8sIoApplicationApiV1beta1Link() {
        return sigsK8sIoApplicationApiV1beta1Link;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_Link")
    public void setSigsK8sIoApplicationApiV1beta1Link(Link sigsK8sIoApplicationApiV1beta1Link) {
        this.sigsK8sIoApplicationApiV1beta1Link = sigsK8sIoApplicationApiV1beta1Link;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ObjectStatus")
    public ObjectStatus getSigsK8sIoApplicationApiV1beta1ObjectStatus() {
        return sigsK8sIoApplicationApiV1beta1ObjectStatus;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ObjectStatus")
    public void setSigsK8sIoApplicationApiV1beta1ObjectStatus(ObjectStatus sigsK8sIoApplicationApiV1beta1ObjectStatus) {
        this.sigsK8sIoApplicationApiV1beta1ObjectStatus = sigsK8sIoApplicationApiV1beta1ObjectStatus;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_SecretKeySelector")
    public SecretKeySelector getSigsK8sIoApplicationApiV1beta1SecretKeySelector() {
        return sigsK8sIoApplicationApiV1beta1SecretKeySelector;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_SecretKeySelector")
    public void setSigsK8sIoApplicationApiV1beta1SecretKeySelector(SecretKeySelector sigsK8sIoApplicationApiV1beta1SecretKeySelector) {
        this.sigsK8sIoApplicationApiV1beta1SecretKeySelector = sigsK8sIoApplicationApiV1beta1SecretKeySelector;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ServiceSelector")
    public ServiceSelector getSigsK8sIoApplicationApiV1beta1ServiceSelector() {
        return sigsK8sIoApplicationApiV1beta1ServiceSelector;
    }

    @JsonProperty("sigs_k8s_io_application_api_v1beta1_ServiceSelector")
    public void setSigsK8sIoApplicationApiV1beta1ServiceSelector(ServiceSelector sigsK8sIoApplicationApiV1beta1ServiceSelector) {
        this.sigsK8sIoApplicationApiV1beta1ServiceSelector = sigsK8sIoApplicationApiV1beta1ServiceSelector;
    }

}
