
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
import io.fabric8.openclustermanagement.api.model.agent.v1.KlusterletAddonAgentConfigSpec;
import io.fabric8.openclustermanagement.api.model.agent.v1.KlusterletAddonConfig;
import io.fabric8.openclustermanagement.api.model.agent.v1.KlusterletAddonConfigList;
import io.fabric8.openclustermanagement.api.model.agent.v1.KlusterletAddonConfigSpec;
import io.fabric8.openclustermanagement.api.model.agent.v1.KlusterletAddonConfigStatus;
import io.fabric8.openclustermanagement.api.model.agent.v1.ProxyConfig;
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
    "github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_KlusterletAddonAgentConfigSpec",
    "github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_KlusterletAddonConfig",
    "github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_KlusterletAddonConfigList",
    "github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_KlusterletAddonConfigSpec",
    "github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_KlusterletAddonConfigStatus",
    "github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_ProxyConfig"
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
public class OpenClusterManagementAgentSchema {

    @JsonProperty("github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_KlusterletAddonAgentConfigSpec")
    private KlusterletAddonAgentConfigSpec githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonAgentConfigSpec;
    @JsonProperty("github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_KlusterletAddonConfig")
    private KlusterletAddonConfig githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfig;
    @JsonProperty("github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_KlusterletAddonConfigList")
    private KlusterletAddonConfigList githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigList;
    @JsonProperty("github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_KlusterletAddonConfigSpec")
    private KlusterletAddonConfigSpec githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigSpec;
    @JsonProperty("github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_KlusterletAddonConfigStatus")
    private KlusterletAddonConfigStatus githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigStatus;
    @JsonProperty("github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_ProxyConfig")
    private ProxyConfig githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1ProxyConfig;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OpenClusterManagementAgentSchema() {
    }

    /**
     * 
     * @param githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1ProxyConfig
     * @param githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigList
     * @param githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigSpec
     * @param githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigStatus
     * @param githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfig
     * @param githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonAgentConfigSpec
     */
    public OpenClusterManagementAgentSchema(KlusterletAddonAgentConfigSpec githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonAgentConfigSpec, KlusterletAddonConfig githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfig, KlusterletAddonConfigList githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigList, KlusterletAddonConfigSpec githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigSpec, KlusterletAddonConfigStatus githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigStatus, ProxyConfig githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1ProxyConfig) {
        super();
        this.githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonAgentConfigSpec = githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonAgentConfigSpec;
        this.githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfig = githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfig;
        this.githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigList = githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigList;
        this.githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigSpec = githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigSpec;
        this.githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigStatus = githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigStatus;
        this.githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1ProxyConfig = githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1ProxyConfig;
    }

    @JsonProperty("github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_KlusterletAddonAgentConfigSpec")
    public KlusterletAddonAgentConfigSpec getGithubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonAgentConfigSpec() {
        return githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonAgentConfigSpec;
    }

    @JsonProperty("github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_KlusterletAddonAgentConfigSpec")
    public void setGithubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonAgentConfigSpec(KlusterletAddonAgentConfigSpec githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonAgentConfigSpec) {
        this.githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonAgentConfigSpec = githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonAgentConfigSpec;
    }

    @JsonProperty("github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_KlusterletAddonConfig")
    public KlusterletAddonConfig getGithubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfig() {
        return githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfig;
    }

    @JsonProperty("github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_KlusterletAddonConfig")
    public void setGithubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfig(KlusterletAddonConfig githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfig) {
        this.githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfig = githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfig;
    }

    @JsonProperty("github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_KlusterletAddonConfigList")
    public KlusterletAddonConfigList getGithubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigList() {
        return githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigList;
    }

    @JsonProperty("github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_KlusterletAddonConfigList")
    public void setGithubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigList(KlusterletAddonConfigList githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigList) {
        this.githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigList = githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigList;
    }

    @JsonProperty("github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_KlusterletAddonConfigSpec")
    public KlusterletAddonConfigSpec getGithubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigSpec() {
        return githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigSpec;
    }

    @JsonProperty("github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_KlusterletAddonConfigSpec")
    public void setGithubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigSpec(KlusterletAddonConfigSpec githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigSpec) {
        this.githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigSpec = githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigSpec;
    }

    @JsonProperty("github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_KlusterletAddonConfigStatus")
    public KlusterletAddonConfigStatus getGithubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigStatus() {
        return githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigStatus;
    }

    @JsonProperty("github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_KlusterletAddonConfigStatus")
    public void setGithubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigStatus(KlusterletAddonConfigStatus githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigStatus) {
        this.githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigStatus = githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1KlusterletAddonConfigStatus;
    }

    @JsonProperty("github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_ProxyConfig")
    public ProxyConfig getGithubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1ProxyConfig() {
        return githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1ProxyConfig;
    }

    @JsonProperty("github_com_open-cluster-management_klusterlet-addon-controller_pkg_apis_agent_v1_ProxyConfig")
    public void setGithubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1ProxyConfig(ProxyConfig githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1ProxyConfig) {
        this.githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1ProxyConfig = githubComOpenClusterManagementKlusterletAddonControllerPkgApisAgentV1ProxyConfig;
    }

}
