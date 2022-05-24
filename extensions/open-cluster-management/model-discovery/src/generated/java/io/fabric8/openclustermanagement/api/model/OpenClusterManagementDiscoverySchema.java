
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
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveredCluster;
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveredClusterList;
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveredClusterSpec;
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveredClusterStatus;
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveryConfig;
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveryConfigList;
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveryConfigSpec;
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveryConfigStatus;
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.Filter;
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
    "github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveredCluster",
    "github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveredClusterList",
    "github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveredClusterSpec",
    "github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveredClusterStatus",
    "github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveryConfig",
    "github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveryConfigList",
    "github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveryConfigSpec",
    "github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveryConfigStatus",
    "github_com_open-cluster-management_discovery_api_v1alpha1_Filter"
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
public class OpenClusterManagementDiscoverySchema {

    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveredCluster")
    private DiscoveredCluster githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredCluster;
    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveredClusterList")
    private DiscoveredClusterList githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterList;
    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveredClusterSpec")
    private DiscoveredClusterSpec githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterSpec;
    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveredClusterStatus")
    private DiscoveredClusterStatus githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterStatus;
    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveryConfig")
    private DiscoveryConfig githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfig;
    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveryConfigList")
    private DiscoveryConfigList githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigList;
    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveryConfigSpec")
    private DiscoveryConfigSpec githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigSpec;
    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveryConfigStatus")
    private DiscoveryConfigStatus githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigStatus;
    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_Filter")
    private Filter githubComOpenClusterManagementDiscoveryApiV1alpha1Filter;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OpenClusterManagementDiscoverySchema() {
    }

    /**
     * 
     * @param githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterList
     * @param githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigList
     * @param githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterSpec
     * @param githubComOpenClusterManagementDiscoveryApiV1alpha1Filter
     * @param githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterStatus
     * @param githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigSpec
     * @param githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredCluster
     * @param githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigStatus
     * @param githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfig
     */
    public OpenClusterManagementDiscoverySchema(DiscoveredCluster githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredCluster, DiscoveredClusterList githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterList, DiscoveredClusterSpec githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterSpec, DiscoveredClusterStatus githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterStatus, DiscoveryConfig githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfig, DiscoveryConfigList githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigList, DiscoveryConfigSpec githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigSpec, DiscoveryConfigStatus githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigStatus, Filter githubComOpenClusterManagementDiscoveryApiV1alpha1Filter) {
        super();
        this.githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredCluster = githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredCluster;
        this.githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterList = githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterList;
        this.githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterSpec = githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterSpec;
        this.githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterStatus = githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterStatus;
        this.githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfig = githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfig;
        this.githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigList = githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigList;
        this.githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigSpec = githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigSpec;
        this.githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigStatus = githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigStatus;
        this.githubComOpenClusterManagementDiscoveryApiV1alpha1Filter = githubComOpenClusterManagementDiscoveryApiV1alpha1Filter;
    }

    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveredCluster")
    public DiscoveredCluster getGithubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredCluster() {
        return githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredCluster;
    }

    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveredCluster")
    public void setGithubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredCluster(DiscoveredCluster githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredCluster) {
        this.githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredCluster = githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredCluster;
    }

    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveredClusterList")
    public DiscoveredClusterList getGithubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterList() {
        return githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterList;
    }

    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveredClusterList")
    public void setGithubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterList(DiscoveredClusterList githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterList) {
        this.githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterList = githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterList;
    }

    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveredClusterSpec")
    public DiscoveredClusterSpec getGithubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterSpec() {
        return githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterSpec;
    }

    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveredClusterSpec")
    public void setGithubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterSpec(DiscoveredClusterSpec githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterSpec) {
        this.githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterSpec = githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterSpec;
    }

    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveredClusterStatus")
    public DiscoveredClusterStatus getGithubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterStatus() {
        return githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterStatus;
    }

    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveredClusterStatus")
    public void setGithubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterStatus(DiscoveredClusterStatus githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterStatus) {
        this.githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterStatus = githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveredClusterStatus;
    }

    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveryConfig")
    public DiscoveryConfig getGithubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfig() {
        return githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfig;
    }

    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveryConfig")
    public void setGithubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfig(DiscoveryConfig githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfig) {
        this.githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfig = githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfig;
    }

    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveryConfigList")
    public DiscoveryConfigList getGithubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigList() {
        return githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigList;
    }

    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveryConfigList")
    public void setGithubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigList(DiscoveryConfigList githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigList) {
        this.githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigList = githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigList;
    }

    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveryConfigSpec")
    public DiscoveryConfigSpec getGithubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigSpec() {
        return githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigSpec;
    }

    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveryConfigSpec")
    public void setGithubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigSpec(DiscoveryConfigSpec githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigSpec) {
        this.githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigSpec = githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigSpec;
    }

    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveryConfigStatus")
    public DiscoveryConfigStatus getGithubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigStatus() {
        return githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigStatus;
    }

    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_DiscoveryConfigStatus")
    public void setGithubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigStatus(DiscoveryConfigStatus githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigStatus) {
        this.githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigStatus = githubComOpenClusterManagementDiscoveryApiV1alpha1DiscoveryConfigStatus;
    }

    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_Filter")
    public Filter getGithubComOpenClusterManagementDiscoveryApiV1alpha1Filter() {
        return githubComOpenClusterManagementDiscoveryApiV1alpha1Filter;
    }

    @JsonProperty("github_com_open-cluster-management_discovery_api_v1alpha1_Filter")
    public void setGithubComOpenClusterManagementDiscoveryApiV1alpha1Filter(Filter githubComOpenClusterManagementDiscoveryApiV1alpha1Filter) {
        this.githubComOpenClusterManagementDiscoveryApiV1alpha1Filter = githubComOpenClusterManagementDiscoveryApiV1alpha1Filter;
    }

}
