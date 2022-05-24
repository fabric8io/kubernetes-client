
package io.fabric8.openclustermanagement.api.model.agent.v1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
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
    "applicationManager",
    "certPolicyController",
    "clusterLabels",
    "clusterName",
    "clusterNamespace",
    "iamPolicyController",
    "policyController",
    "proxyConfig",
    "searchCollector",
    "version"
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
public class KlusterletAddonConfigSpec implements KubernetesResource
{

    @JsonProperty("applicationManager")
    private KlusterletAddonAgentConfigSpec applicationManager;
    @JsonProperty("certPolicyController")
    private KlusterletAddonAgentConfigSpec certPolicyController;
    @JsonProperty("clusterLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> clusterLabels = new LinkedHashMap<String, String>();
    @JsonProperty("clusterName")
    private java.lang.String clusterName;
    @JsonProperty("clusterNamespace")
    private java.lang.String clusterNamespace;
    @JsonProperty("iamPolicyController")
    private KlusterletAddonAgentConfigSpec iamPolicyController;
    @JsonProperty("policyController")
    private KlusterletAddonAgentConfigSpec policyController;
    @JsonProperty("proxyConfig")
    private ProxyConfig proxyConfig;
    @JsonProperty("searchCollector")
    private KlusterletAddonAgentConfigSpec searchCollector;
    @JsonProperty("version")
    private java.lang.String version;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KlusterletAddonConfigSpec() {
    }

    /**
     * 
     * @param policyController
     * @param applicationManager
     * @param certPolicyController
     * @param proxyConfig
     * @param clusterNamespace
     * @param clusterName
     * @param searchCollector
     * @param clusterLabels
     * @param iamPolicyController
     * @param version
     */
    public KlusterletAddonConfigSpec(KlusterletAddonAgentConfigSpec applicationManager, KlusterletAddonAgentConfigSpec certPolicyController, Map<String, String> clusterLabels, java.lang.String clusterName, java.lang.String clusterNamespace, KlusterletAddonAgentConfigSpec iamPolicyController, KlusterletAddonAgentConfigSpec policyController, ProxyConfig proxyConfig, KlusterletAddonAgentConfigSpec searchCollector, java.lang.String version) {
        super();
        this.applicationManager = applicationManager;
        this.certPolicyController = certPolicyController;
        this.clusterLabels = clusterLabels;
        this.clusterName = clusterName;
        this.clusterNamespace = clusterNamespace;
        this.iamPolicyController = iamPolicyController;
        this.policyController = policyController;
        this.proxyConfig = proxyConfig;
        this.searchCollector = searchCollector;
        this.version = version;
    }

    @JsonProperty("applicationManager")
    public KlusterletAddonAgentConfigSpec getApplicationManager() {
        return applicationManager;
    }

    @JsonProperty("applicationManager")
    public void setApplicationManager(KlusterletAddonAgentConfigSpec applicationManager) {
        this.applicationManager = applicationManager;
    }

    @JsonProperty("certPolicyController")
    public KlusterletAddonAgentConfigSpec getCertPolicyController() {
        return certPolicyController;
    }

    @JsonProperty("certPolicyController")
    public void setCertPolicyController(KlusterletAddonAgentConfigSpec certPolicyController) {
        this.certPolicyController = certPolicyController;
    }

    @JsonProperty("clusterLabels")
    public Map<String, String> getClusterLabels() {
        return clusterLabels;
    }

    @JsonProperty("clusterLabels")
    public void setClusterLabels(Map<String, String> clusterLabels) {
        this.clusterLabels = clusterLabels;
    }

    @JsonProperty("clusterName")
    public java.lang.String getClusterName() {
        return clusterName;
    }

    @JsonProperty("clusterName")
    public void setClusterName(java.lang.String clusterName) {
        this.clusterName = clusterName;
    }

    @JsonProperty("clusterNamespace")
    public java.lang.String getClusterNamespace() {
        return clusterNamespace;
    }

    @JsonProperty("clusterNamespace")
    public void setClusterNamespace(java.lang.String clusterNamespace) {
        this.clusterNamespace = clusterNamespace;
    }

    @JsonProperty("iamPolicyController")
    public KlusterletAddonAgentConfigSpec getIamPolicyController() {
        return iamPolicyController;
    }

    @JsonProperty("iamPolicyController")
    public void setIamPolicyController(KlusterletAddonAgentConfigSpec iamPolicyController) {
        this.iamPolicyController = iamPolicyController;
    }

    @JsonProperty("policyController")
    public KlusterletAddonAgentConfigSpec getPolicyController() {
        return policyController;
    }

    @JsonProperty("policyController")
    public void setPolicyController(KlusterletAddonAgentConfigSpec policyController) {
        this.policyController = policyController;
    }

    @JsonProperty("proxyConfig")
    public ProxyConfig getProxyConfig() {
        return proxyConfig;
    }

    @JsonProperty("proxyConfig")
    public void setProxyConfig(ProxyConfig proxyConfig) {
        this.proxyConfig = proxyConfig;
    }

    @JsonProperty("searchCollector")
    public KlusterletAddonAgentConfigSpec getSearchCollector() {
        return searchCollector;
    }

    @JsonProperty("searchCollector")
    public void setSearchCollector(KlusterletAddonAgentConfigSpec searchCollector) {
        this.searchCollector = searchCollector;
    }

    @JsonProperty("version")
    public java.lang.String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(java.lang.String version) {
        this.version = version;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
