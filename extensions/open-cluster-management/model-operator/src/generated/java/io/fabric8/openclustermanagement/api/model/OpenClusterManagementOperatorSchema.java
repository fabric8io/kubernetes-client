
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
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.BackupConfig;
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.ExternalDNSAWSConfig;
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.ExternalDNSConfig;
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.ExternalDNSGCPConfig;
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.FailedProvisionConfig;
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.HiveConfigSpec;
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.HubCondition;
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.IngressSpec;
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.MultiClusterHub;
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.MultiClusterHubList;
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.MultiClusterHubSpec;
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.MultiClusterHubStatus;
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.Overrides;
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.StatusCondition;
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.VeleroBackupConfig;
import io.fabric8.openclustermanagement.api.model.operator.v1.ClusterManager;
import io.fabric8.openclustermanagement.api.model.operator.v1.ClusterManagerList;
import io.fabric8.openclustermanagement.api.model.operator.v1.ClusterManagerSpec;
import io.fabric8.openclustermanagement.api.model.operator.v1.ClusterManagerStatus;
import io.fabric8.openclustermanagement.api.model.operator.v1.GenerationStatus;
import io.fabric8.openclustermanagement.api.model.operator.v1.Klusterlet;
import io.fabric8.openclustermanagement.api.model.operator.v1.KlusterletList;
import io.fabric8.openclustermanagement.api.model.operator.v1.KlusterletSpec;
import io.fabric8.openclustermanagement.api.model.operator.v1.KlusterletStatus;
import io.fabric8.openclustermanagement.api.model.operator.v1.NodePlacement;
import io.fabric8.openclustermanagement.api.model.operator.v1.RelatedResourceMeta;
import io.fabric8.openclustermanagement.api.model.operator.v1.ServerURL;
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
    "github_com_open-cluster-management_multiclusterhub-operator_api_v1_BackupConfig",
    "github_com_open-cluster-management_multiclusterhub-operator_api_v1_ExternalDNSAWSConfig",
    "github_com_open-cluster-management_multiclusterhub-operator_api_v1_ExternalDNSConfig",
    "github_com_open-cluster-management_multiclusterhub-operator_api_v1_ExternalDNSGCPConfig",
    "github_com_open-cluster-management_multiclusterhub-operator_api_v1_FailedProvisionConfig",
    "github_com_open-cluster-management_multiclusterhub-operator_api_v1_HiveConfigSpec",
    "github_com_open-cluster-management_multiclusterhub-operator_api_v1_HubCondition",
    "github_com_open-cluster-management_multiclusterhub-operator_api_v1_IngressSpec",
    "github_com_open-cluster-management_multiclusterhub-operator_api_v1_MultiClusterHub",
    "github_com_open-cluster-management_multiclusterhub-operator_api_v1_MultiClusterHubList",
    "github_com_open-cluster-management_multiclusterhub-operator_api_v1_MultiClusterHubSpec",
    "github_com_open-cluster-management_multiclusterhub-operator_api_v1_MultiClusterHubStatus",
    "github_com_open-cluster-management_multiclusterhub-operator_api_v1_Overrides",
    "github_com_open-cluster-management_multiclusterhub-operator_api_v1_StatusCondition",
    "github_com_open-cluster-management_multiclusterhub-operator_api_v1_VeleroBackupConfig",
    "open-cluster-management_io_api_operator_v1_ClusterManager",
    "open-cluster-management_io_api_operator_v1_ClusterManagerList",
    "open-cluster-management_io_api_operator_v1_ClusterManagerSpec",
    "open-cluster-management_io_api_operator_v1_ClusterManagerStatus",
    "open-cluster-management_io_api_operator_v1_GenerationStatus",
    "open-cluster-management_io_api_operator_v1_Klusterlet",
    "open-cluster-management_io_api_operator_v1_KlusterletList",
    "open-cluster-management_io_api_operator_v1_KlusterletSpec",
    "open-cluster-management_io_api_operator_v1_KlusterletStatus",
    "open-cluster-management_io_api_operator_v1_NodePlacement",
    "open-cluster-management_io_api_operator_v1_RelatedResourceMeta",
    "open-cluster-management_io_api_operator_v1_ServerURL"
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
public class OpenClusterManagementOperatorSchema {

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_BackupConfig")
    private BackupConfig githubComOpenClusterManagementMulticlusterhubOperatorApiV1BackupConfig;
    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_ExternalDNSAWSConfig")
    private ExternalDNSAWSConfig githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSAWSConfig;
    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_ExternalDNSConfig")
    private ExternalDNSConfig githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSConfig;
    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_ExternalDNSGCPConfig")
    private ExternalDNSGCPConfig githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSGCPConfig;
    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_FailedProvisionConfig")
    private FailedProvisionConfig githubComOpenClusterManagementMulticlusterhubOperatorApiV1FailedProvisionConfig;
    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_HiveConfigSpec")
    private HiveConfigSpec githubComOpenClusterManagementMulticlusterhubOperatorApiV1HiveConfigSpec;
    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_HubCondition")
    private HubCondition githubComOpenClusterManagementMulticlusterhubOperatorApiV1HubCondition;
    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_IngressSpec")
    private IngressSpec githubComOpenClusterManagementMulticlusterhubOperatorApiV1IngressSpec;
    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_MultiClusterHub")
    private MultiClusterHub githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHub;
    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_MultiClusterHubList")
    private MultiClusterHubList githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubList;
    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_MultiClusterHubSpec")
    private MultiClusterHubSpec githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubSpec;
    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_MultiClusterHubStatus")
    private MultiClusterHubStatus githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubStatus;
    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_Overrides")
    private Overrides githubComOpenClusterManagementMulticlusterhubOperatorApiV1Overrides;
    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_StatusCondition")
    private StatusCondition githubComOpenClusterManagementMulticlusterhubOperatorApiV1StatusCondition;
    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_VeleroBackupConfig")
    private VeleroBackupConfig githubComOpenClusterManagementMulticlusterhubOperatorApiV1VeleroBackupConfig;
    @JsonProperty("open-cluster-management_io_api_operator_v1_ClusterManager")
    private ClusterManager openClusterManagementIoApiOperatorV1ClusterManager;
    @JsonProperty("open-cluster-management_io_api_operator_v1_ClusterManagerList")
    private ClusterManagerList openClusterManagementIoApiOperatorV1ClusterManagerList;
    @JsonProperty("open-cluster-management_io_api_operator_v1_ClusterManagerSpec")
    private ClusterManagerSpec openClusterManagementIoApiOperatorV1ClusterManagerSpec;
    @JsonProperty("open-cluster-management_io_api_operator_v1_ClusterManagerStatus")
    private ClusterManagerStatus openClusterManagementIoApiOperatorV1ClusterManagerStatus;
    @JsonProperty("open-cluster-management_io_api_operator_v1_GenerationStatus")
    private GenerationStatus openClusterManagementIoApiOperatorV1GenerationStatus;
    @JsonProperty("open-cluster-management_io_api_operator_v1_Klusterlet")
    private Klusterlet openClusterManagementIoApiOperatorV1Klusterlet;
    @JsonProperty("open-cluster-management_io_api_operator_v1_KlusterletList")
    private KlusterletList openClusterManagementIoApiOperatorV1KlusterletList;
    @JsonProperty("open-cluster-management_io_api_operator_v1_KlusterletSpec")
    private KlusterletSpec openClusterManagementIoApiOperatorV1KlusterletSpec;
    @JsonProperty("open-cluster-management_io_api_operator_v1_KlusterletStatus")
    private KlusterletStatus openClusterManagementIoApiOperatorV1KlusterletStatus;
    @JsonProperty("open-cluster-management_io_api_operator_v1_NodePlacement")
    private NodePlacement openClusterManagementIoApiOperatorV1NodePlacement;
    @JsonProperty("open-cluster-management_io_api_operator_v1_RelatedResourceMeta")
    private RelatedResourceMeta openClusterManagementIoApiOperatorV1RelatedResourceMeta;
    @JsonProperty("open-cluster-management_io_api_operator_v1_ServerURL")
    private ServerURL openClusterManagementIoApiOperatorV1ServerURL;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OpenClusterManagementOperatorSchema() {
    }

    /**
     * 
     * @param githubComOpenClusterManagementMulticlusterhubOperatorApiV1FailedProvisionConfig
     * @param githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSConfig
     * @param githubComOpenClusterManagementMulticlusterhubOperatorApiV1HiveConfigSpec
     * @param githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSAWSConfig
     * @param openClusterManagementIoApiOperatorV1NodePlacement
     * @param openClusterManagementIoApiOperatorV1ClusterManagerSpec
     * @param openClusterManagementIoApiOperatorV1Klusterlet
     * @param openClusterManagementIoApiOperatorV1KlusterletSpec
     * @param openClusterManagementIoApiOperatorV1GenerationStatus
     * @param openClusterManagementIoApiOperatorV1ClusterManagerList
     * @param githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHub
     * @param openClusterManagementIoApiOperatorV1ClusterManager
     * @param githubComOpenClusterManagementMulticlusterhubOperatorApiV1StatusCondition
     * @param githubComOpenClusterManagementMulticlusterhubOperatorApiV1Overrides
     * @param githubComOpenClusterManagementMulticlusterhubOperatorApiV1VeleroBackupConfig
     * @param openClusterManagementIoApiOperatorV1ClusterManagerStatus
     * @param githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubSpec
     * @param openClusterManagementIoApiOperatorV1RelatedResourceMeta
     * @param githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubList
     * @param githubComOpenClusterManagementMulticlusterhubOperatorApiV1IngressSpec
     * @param openClusterManagementIoApiOperatorV1ServerURL
     * @param githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubStatus
     * @param githubComOpenClusterManagementMulticlusterhubOperatorApiV1BackupConfig
     * @param githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSGCPConfig
     * @param openClusterManagementIoApiOperatorV1KlusterletStatus
     * @param githubComOpenClusterManagementMulticlusterhubOperatorApiV1HubCondition
     * @param openClusterManagementIoApiOperatorV1KlusterletList
     */
    public OpenClusterManagementOperatorSchema(BackupConfig githubComOpenClusterManagementMulticlusterhubOperatorApiV1BackupConfig, ExternalDNSAWSConfig githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSAWSConfig, ExternalDNSConfig githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSConfig, ExternalDNSGCPConfig githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSGCPConfig, FailedProvisionConfig githubComOpenClusterManagementMulticlusterhubOperatorApiV1FailedProvisionConfig, HiveConfigSpec githubComOpenClusterManagementMulticlusterhubOperatorApiV1HiveConfigSpec, HubCondition githubComOpenClusterManagementMulticlusterhubOperatorApiV1HubCondition, IngressSpec githubComOpenClusterManagementMulticlusterhubOperatorApiV1IngressSpec, MultiClusterHub githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHub, MultiClusterHubList githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubList, MultiClusterHubSpec githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubSpec, MultiClusterHubStatus githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubStatus, Overrides githubComOpenClusterManagementMulticlusterhubOperatorApiV1Overrides, StatusCondition githubComOpenClusterManagementMulticlusterhubOperatorApiV1StatusCondition, VeleroBackupConfig githubComOpenClusterManagementMulticlusterhubOperatorApiV1VeleroBackupConfig, ClusterManager openClusterManagementIoApiOperatorV1ClusterManager, ClusterManagerList openClusterManagementIoApiOperatorV1ClusterManagerList, ClusterManagerSpec openClusterManagementIoApiOperatorV1ClusterManagerSpec, ClusterManagerStatus openClusterManagementIoApiOperatorV1ClusterManagerStatus, GenerationStatus openClusterManagementIoApiOperatorV1GenerationStatus, Klusterlet openClusterManagementIoApiOperatorV1Klusterlet, KlusterletList openClusterManagementIoApiOperatorV1KlusterletList, KlusterletSpec openClusterManagementIoApiOperatorV1KlusterletSpec, KlusterletStatus openClusterManagementIoApiOperatorV1KlusterletStatus, NodePlacement openClusterManagementIoApiOperatorV1NodePlacement, RelatedResourceMeta openClusterManagementIoApiOperatorV1RelatedResourceMeta, ServerURL openClusterManagementIoApiOperatorV1ServerURL) {
        super();
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1BackupConfig = githubComOpenClusterManagementMulticlusterhubOperatorApiV1BackupConfig;
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSAWSConfig = githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSAWSConfig;
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSConfig = githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSConfig;
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSGCPConfig = githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSGCPConfig;
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1FailedProvisionConfig = githubComOpenClusterManagementMulticlusterhubOperatorApiV1FailedProvisionConfig;
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1HiveConfigSpec = githubComOpenClusterManagementMulticlusterhubOperatorApiV1HiveConfigSpec;
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1HubCondition = githubComOpenClusterManagementMulticlusterhubOperatorApiV1HubCondition;
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1IngressSpec = githubComOpenClusterManagementMulticlusterhubOperatorApiV1IngressSpec;
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHub = githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHub;
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubList = githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubList;
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubSpec = githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubSpec;
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubStatus = githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubStatus;
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1Overrides = githubComOpenClusterManagementMulticlusterhubOperatorApiV1Overrides;
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1StatusCondition = githubComOpenClusterManagementMulticlusterhubOperatorApiV1StatusCondition;
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1VeleroBackupConfig = githubComOpenClusterManagementMulticlusterhubOperatorApiV1VeleroBackupConfig;
        this.openClusterManagementIoApiOperatorV1ClusterManager = openClusterManagementIoApiOperatorV1ClusterManager;
        this.openClusterManagementIoApiOperatorV1ClusterManagerList = openClusterManagementIoApiOperatorV1ClusterManagerList;
        this.openClusterManagementIoApiOperatorV1ClusterManagerSpec = openClusterManagementIoApiOperatorV1ClusterManagerSpec;
        this.openClusterManagementIoApiOperatorV1ClusterManagerStatus = openClusterManagementIoApiOperatorV1ClusterManagerStatus;
        this.openClusterManagementIoApiOperatorV1GenerationStatus = openClusterManagementIoApiOperatorV1GenerationStatus;
        this.openClusterManagementIoApiOperatorV1Klusterlet = openClusterManagementIoApiOperatorV1Klusterlet;
        this.openClusterManagementIoApiOperatorV1KlusterletList = openClusterManagementIoApiOperatorV1KlusterletList;
        this.openClusterManagementIoApiOperatorV1KlusterletSpec = openClusterManagementIoApiOperatorV1KlusterletSpec;
        this.openClusterManagementIoApiOperatorV1KlusterletStatus = openClusterManagementIoApiOperatorV1KlusterletStatus;
        this.openClusterManagementIoApiOperatorV1NodePlacement = openClusterManagementIoApiOperatorV1NodePlacement;
        this.openClusterManagementIoApiOperatorV1RelatedResourceMeta = openClusterManagementIoApiOperatorV1RelatedResourceMeta;
        this.openClusterManagementIoApiOperatorV1ServerURL = openClusterManagementIoApiOperatorV1ServerURL;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_BackupConfig")
    public BackupConfig getGithubComOpenClusterManagementMulticlusterhubOperatorApiV1BackupConfig() {
        return githubComOpenClusterManagementMulticlusterhubOperatorApiV1BackupConfig;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_BackupConfig")
    public void setGithubComOpenClusterManagementMulticlusterhubOperatorApiV1BackupConfig(BackupConfig githubComOpenClusterManagementMulticlusterhubOperatorApiV1BackupConfig) {
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1BackupConfig = githubComOpenClusterManagementMulticlusterhubOperatorApiV1BackupConfig;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_ExternalDNSAWSConfig")
    public ExternalDNSAWSConfig getGithubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSAWSConfig() {
        return githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSAWSConfig;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_ExternalDNSAWSConfig")
    public void setGithubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSAWSConfig(ExternalDNSAWSConfig githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSAWSConfig) {
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSAWSConfig = githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSAWSConfig;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_ExternalDNSConfig")
    public ExternalDNSConfig getGithubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSConfig() {
        return githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSConfig;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_ExternalDNSConfig")
    public void setGithubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSConfig(ExternalDNSConfig githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSConfig) {
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSConfig = githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSConfig;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_ExternalDNSGCPConfig")
    public ExternalDNSGCPConfig getGithubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSGCPConfig() {
        return githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSGCPConfig;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_ExternalDNSGCPConfig")
    public void setGithubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSGCPConfig(ExternalDNSGCPConfig githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSGCPConfig) {
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSGCPConfig = githubComOpenClusterManagementMulticlusterhubOperatorApiV1ExternalDNSGCPConfig;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_FailedProvisionConfig")
    public FailedProvisionConfig getGithubComOpenClusterManagementMulticlusterhubOperatorApiV1FailedProvisionConfig() {
        return githubComOpenClusterManagementMulticlusterhubOperatorApiV1FailedProvisionConfig;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_FailedProvisionConfig")
    public void setGithubComOpenClusterManagementMulticlusterhubOperatorApiV1FailedProvisionConfig(FailedProvisionConfig githubComOpenClusterManagementMulticlusterhubOperatorApiV1FailedProvisionConfig) {
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1FailedProvisionConfig = githubComOpenClusterManagementMulticlusterhubOperatorApiV1FailedProvisionConfig;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_HiveConfigSpec")
    public HiveConfigSpec getGithubComOpenClusterManagementMulticlusterhubOperatorApiV1HiveConfigSpec() {
        return githubComOpenClusterManagementMulticlusterhubOperatorApiV1HiveConfigSpec;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_HiveConfigSpec")
    public void setGithubComOpenClusterManagementMulticlusterhubOperatorApiV1HiveConfigSpec(HiveConfigSpec githubComOpenClusterManagementMulticlusterhubOperatorApiV1HiveConfigSpec) {
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1HiveConfigSpec = githubComOpenClusterManagementMulticlusterhubOperatorApiV1HiveConfigSpec;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_HubCondition")
    public HubCondition getGithubComOpenClusterManagementMulticlusterhubOperatorApiV1HubCondition() {
        return githubComOpenClusterManagementMulticlusterhubOperatorApiV1HubCondition;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_HubCondition")
    public void setGithubComOpenClusterManagementMulticlusterhubOperatorApiV1HubCondition(HubCondition githubComOpenClusterManagementMulticlusterhubOperatorApiV1HubCondition) {
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1HubCondition = githubComOpenClusterManagementMulticlusterhubOperatorApiV1HubCondition;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_IngressSpec")
    public IngressSpec getGithubComOpenClusterManagementMulticlusterhubOperatorApiV1IngressSpec() {
        return githubComOpenClusterManagementMulticlusterhubOperatorApiV1IngressSpec;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_IngressSpec")
    public void setGithubComOpenClusterManagementMulticlusterhubOperatorApiV1IngressSpec(IngressSpec githubComOpenClusterManagementMulticlusterhubOperatorApiV1IngressSpec) {
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1IngressSpec = githubComOpenClusterManagementMulticlusterhubOperatorApiV1IngressSpec;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_MultiClusterHub")
    public MultiClusterHub getGithubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHub() {
        return githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHub;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_MultiClusterHub")
    public void setGithubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHub(MultiClusterHub githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHub) {
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHub = githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHub;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_MultiClusterHubList")
    public MultiClusterHubList getGithubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubList() {
        return githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubList;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_MultiClusterHubList")
    public void setGithubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubList(MultiClusterHubList githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubList) {
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubList = githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubList;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_MultiClusterHubSpec")
    public MultiClusterHubSpec getGithubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubSpec() {
        return githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubSpec;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_MultiClusterHubSpec")
    public void setGithubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubSpec(MultiClusterHubSpec githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubSpec) {
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubSpec = githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubSpec;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_MultiClusterHubStatus")
    public MultiClusterHubStatus getGithubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubStatus() {
        return githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubStatus;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_MultiClusterHubStatus")
    public void setGithubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubStatus(MultiClusterHubStatus githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubStatus) {
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubStatus = githubComOpenClusterManagementMulticlusterhubOperatorApiV1MultiClusterHubStatus;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_Overrides")
    public Overrides getGithubComOpenClusterManagementMulticlusterhubOperatorApiV1Overrides() {
        return githubComOpenClusterManagementMulticlusterhubOperatorApiV1Overrides;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_Overrides")
    public void setGithubComOpenClusterManagementMulticlusterhubOperatorApiV1Overrides(Overrides githubComOpenClusterManagementMulticlusterhubOperatorApiV1Overrides) {
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1Overrides = githubComOpenClusterManagementMulticlusterhubOperatorApiV1Overrides;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_StatusCondition")
    public StatusCondition getGithubComOpenClusterManagementMulticlusterhubOperatorApiV1StatusCondition() {
        return githubComOpenClusterManagementMulticlusterhubOperatorApiV1StatusCondition;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_StatusCondition")
    public void setGithubComOpenClusterManagementMulticlusterhubOperatorApiV1StatusCondition(StatusCondition githubComOpenClusterManagementMulticlusterhubOperatorApiV1StatusCondition) {
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1StatusCondition = githubComOpenClusterManagementMulticlusterhubOperatorApiV1StatusCondition;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_VeleroBackupConfig")
    public VeleroBackupConfig getGithubComOpenClusterManagementMulticlusterhubOperatorApiV1VeleroBackupConfig() {
        return githubComOpenClusterManagementMulticlusterhubOperatorApiV1VeleroBackupConfig;
    }

    @JsonProperty("github_com_open-cluster-management_multiclusterhub-operator_api_v1_VeleroBackupConfig")
    public void setGithubComOpenClusterManagementMulticlusterhubOperatorApiV1VeleroBackupConfig(VeleroBackupConfig githubComOpenClusterManagementMulticlusterhubOperatorApiV1VeleroBackupConfig) {
        this.githubComOpenClusterManagementMulticlusterhubOperatorApiV1VeleroBackupConfig = githubComOpenClusterManagementMulticlusterhubOperatorApiV1VeleroBackupConfig;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_ClusterManager")
    public ClusterManager getOpenClusterManagementIoApiOperatorV1ClusterManager() {
        return openClusterManagementIoApiOperatorV1ClusterManager;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_ClusterManager")
    public void setOpenClusterManagementIoApiOperatorV1ClusterManager(ClusterManager openClusterManagementIoApiOperatorV1ClusterManager) {
        this.openClusterManagementIoApiOperatorV1ClusterManager = openClusterManagementIoApiOperatorV1ClusterManager;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_ClusterManagerList")
    public ClusterManagerList getOpenClusterManagementIoApiOperatorV1ClusterManagerList() {
        return openClusterManagementIoApiOperatorV1ClusterManagerList;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_ClusterManagerList")
    public void setOpenClusterManagementIoApiOperatorV1ClusterManagerList(ClusterManagerList openClusterManagementIoApiOperatorV1ClusterManagerList) {
        this.openClusterManagementIoApiOperatorV1ClusterManagerList = openClusterManagementIoApiOperatorV1ClusterManagerList;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_ClusterManagerSpec")
    public ClusterManagerSpec getOpenClusterManagementIoApiOperatorV1ClusterManagerSpec() {
        return openClusterManagementIoApiOperatorV1ClusterManagerSpec;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_ClusterManagerSpec")
    public void setOpenClusterManagementIoApiOperatorV1ClusterManagerSpec(ClusterManagerSpec openClusterManagementIoApiOperatorV1ClusterManagerSpec) {
        this.openClusterManagementIoApiOperatorV1ClusterManagerSpec = openClusterManagementIoApiOperatorV1ClusterManagerSpec;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_ClusterManagerStatus")
    public ClusterManagerStatus getOpenClusterManagementIoApiOperatorV1ClusterManagerStatus() {
        return openClusterManagementIoApiOperatorV1ClusterManagerStatus;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_ClusterManagerStatus")
    public void setOpenClusterManagementIoApiOperatorV1ClusterManagerStatus(ClusterManagerStatus openClusterManagementIoApiOperatorV1ClusterManagerStatus) {
        this.openClusterManagementIoApiOperatorV1ClusterManagerStatus = openClusterManagementIoApiOperatorV1ClusterManagerStatus;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_GenerationStatus")
    public GenerationStatus getOpenClusterManagementIoApiOperatorV1GenerationStatus() {
        return openClusterManagementIoApiOperatorV1GenerationStatus;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_GenerationStatus")
    public void setOpenClusterManagementIoApiOperatorV1GenerationStatus(GenerationStatus openClusterManagementIoApiOperatorV1GenerationStatus) {
        this.openClusterManagementIoApiOperatorV1GenerationStatus = openClusterManagementIoApiOperatorV1GenerationStatus;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_Klusterlet")
    public Klusterlet getOpenClusterManagementIoApiOperatorV1Klusterlet() {
        return openClusterManagementIoApiOperatorV1Klusterlet;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_Klusterlet")
    public void setOpenClusterManagementIoApiOperatorV1Klusterlet(Klusterlet openClusterManagementIoApiOperatorV1Klusterlet) {
        this.openClusterManagementIoApiOperatorV1Klusterlet = openClusterManagementIoApiOperatorV1Klusterlet;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_KlusterletList")
    public KlusterletList getOpenClusterManagementIoApiOperatorV1KlusterletList() {
        return openClusterManagementIoApiOperatorV1KlusterletList;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_KlusterletList")
    public void setOpenClusterManagementIoApiOperatorV1KlusterletList(KlusterletList openClusterManagementIoApiOperatorV1KlusterletList) {
        this.openClusterManagementIoApiOperatorV1KlusterletList = openClusterManagementIoApiOperatorV1KlusterletList;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_KlusterletSpec")
    public KlusterletSpec getOpenClusterManagementIoApiOperatorV1KlusterletSpec() {
        return openClusterManagementIoApiOperatorV1KlusterletSpec;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_KlusterletSpec")
    public void setOpenClusterManagementIoApiOperatorV1KlusterletSpec(KlusterletSpec openClusterManagementIoApiOperatorV1KlusterletSpec) {
        this.openClusterManagementIoApiOperatorV1KlusterletSpec = openClusterManagementIoApiOperatorV1KlusterletSpec;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_KlusterletStatus")
    public KlusterletStatus getOpenClusterManagementIoApiOperatorV1KlusterletStatus() {
        return openClusterManagementIoApiOperatorV1KlusterletStatus;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_KlusterletStatus")
    public void setOpenClusterManagementIoApiOperatorV1KlusterletStatus(KlusterletStatus openClusterManagementIoApiOperatorV1KlusterletStatus) {
        this.openClusterManagementIoApiOperatorV1KlusterletStatus = openClusterManagementIoApiOperatorV1KlusterletStatus;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_NodePlacement")
    public NodePlacement getOpenClusterManagementIoApiOperatorV1NodePlacement() {
        return openClusterManagementIoApiOperatorV1NodePlacement;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_NodePlacement")
    public void setOpenClusterManagementIoApiOperatorV1NodePlacement(NodePlacement openClusterManagementIoApiOperatorV1NodePlacement) {
        this.openClusterManagementIoApiOperatorV1NodePlacement = openClusterManagementIoApiOperatorV1NodePlacement;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_RelatedResourceMeta")
    public RelatedResourceMeta getOpenClusterManagementIoApiOperatorV1RelatedResourceMeta() {
        return openClusterManagementIoApiOperatorV1RelatedResourceMeta;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_RelatedResourceMeta")
    public void setOpenClusterManagementIoApiOperatorV1RelatedResourceMeta(RelatedResourceMeta openClusterManagementIoApiOperatorV1RelatedResourceMeta) {
        this.openClusterManagementIoApiOperatorV1RelatedResourceMeta = openClusterManagementIoApiOperatorV1RelatedResourceMeta;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_ServerURL")
    public ServerURL getOpenClusterManagementIoApiOperatorV1ServerURL() {
        return openClusterManagementIoApiOperatorV1ServerURL;
    }

    @JsonProperty("open-cluster-management_io_api_operator_v1_ServerURL")
    public void setOpenClusterManagementIoApiOperatorV1ServerURL(ServerURL openClusterManagementIoApiOperatorV1ServerURL) {
        this.openClusterManagementIoApiOperatorV1ServerURL = openClusterManagementIoApiOperatorV1ServerURL;
    }

}
