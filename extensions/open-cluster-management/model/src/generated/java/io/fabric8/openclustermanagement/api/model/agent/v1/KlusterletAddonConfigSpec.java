
package io.fabric8.openclustermanagement.api.model.agent.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
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
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class KlusterletAddonConfigSpec implements Editable<KlusterletAddonConfigSpecBuilder>, KubernetesResource
{

    @JsonProperty("applicationManager")
    private KlusterletAddonAgentConfigSpec applicationManager;
    @JsonProperty("certPolicyController")
    private KlusterletAddonAgentConfigSpec certPolicyController;
    @JsonProperty("clusterLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> clusterLabels = new LinkedHashMap<>();
    @JsonProperty("clusterName")
    private String clusterName;
    @JsonProperty("clusterNamespace")
    private String clusterNamespace;
    @JsonProperty("iamPolicyController")
    private KlusterletAddonAgentConfigSpec iamPolicyController;
    @JsonProperty("policyController")
    private KlusterletAddonAgentConfigSpec policyController;
    @JsonProperty("proxyConfig")
    private ProxyConfig proxyConfig;
    @JsonProperty("searchCollector")
    private KlusterletAddonAgentConfigSpec searchCollector;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KlusterletAddonConfigSpec() {
    }

    public KlusterletAddonConfigSpec(KlusterletAddonAgentConfigSpec applicationManager, KlusterletAddonAgentConfigSpec certPolicyController, Map<String, String> clusterLabels, String clusterName, String clusterNamespace, KlusterletAddonAgentConfigSpec iamPolicyController, KlusterletAddonAgentConfigSpec policyController, ProxyConfig proxyConfig, KlusterletAddonAgentConfigSpec searchCollector, String version) {
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getClusterLabels() {
        return clusterLabels;
    }

    @JsonProperty("clusterLabels")
    public void setClusterLabels(Map<String, String> clusterLabels) {
        this.clusterLabels = clusterLabels;
    }

    @JsonProperty("clusterName")
    public String getClusterName() {
        return clusterName;
    }

    @JsonProperty("clusterName")
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    @JsonProperty("clusterNamespace")
    public String getClusterNamespace() {
        return clusterNamespace;
    }

    @JsonProperty("clusterNamespace")
    public void setClusterNamespace(String clusterNamespace) {
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
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public KlusterletAddonConfigSpecBuilder edit() {
        return new KlusterletAddonConfigSpecBuilder(this);
    }

    @JsonIgnore
    public KlusterletAddonConfigSpecBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
