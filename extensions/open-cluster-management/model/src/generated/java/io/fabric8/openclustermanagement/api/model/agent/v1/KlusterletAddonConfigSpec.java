
package io.fabric8.openclustermanagement.api.model.agent.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
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

/**
 * KlusterletAddonConfigSpec defines the desired state of KlusterletAddonConfig
 */
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

    /**
     * KlusterletAddonConfigSpec defines the desired state of KlusterletAddonConfig
     */
    @JsonProperty("applicationManager")
    public KlusterletAddonAgentConfigSpec getApplicationManager() {
        return applicationManager;
    }

    /**
     * KlusterletAddonConfigSpec defines the desired state of KlusterletAddonConfig
     */
    @JsonProperty("applicationManager")
    public void setApplicationManager(KlusterletAddonAgentConfigSpec applicationManager) {
        this.applicationManager = applicationManager;
    }

    /**
     * KlusterletAddonConfigSpec defines the desired state of KlusterletAddonConfig
     */
    @JsonProperty("certPolicyController")
    public KlusterletAddonAgentConfigSpec getCertPolicyController() {
        return certPolicyController;
    }

    /**
     * KlusterletAddonConfigSpec defines the desired state of KlusterletAddonConfig
     */
    @JsonProperty("certPolicyController")
    public void setCertPolicyController(KlusterletAddonAgentConfigSpec certPolicyController) {
        this.certPolicyController = certPolicyController;
    }

    /**
     * DEPRECATED in release 2.4 and will be removed in the future since not used anymore.
     */
    @JsonProperty("clusterLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getClusterLabels() {
        return clusterLabels;
    }

    /**
     * DEPRECATED in release 2.4 and will be removed in the future since not used anymore.
     */
    @JsonProperty("clusterLabels")
    public void setClusterLabels(Map<String, String> clusterLabels) {
        this.clusterLabels = clusterLabels;
    }

    /**
     * DEPRECATED in release 2.4 and will be removed in the future since not used anymore.
     */
    @JsonProperty("clusterName")
    public String getClusterName() {
        return clusterName;
    }

    /**
     * DEPRECATED in release 2.4 and will be removed in the future since not used anymore.
     */
    @JsonProperty("clusterName")
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    /**
     * DEPRECATED in release 2.4 and will be removed in the future since not used anymore.
     */
    @JsonProperty("clusterNamespace")
    public String getClusterNamespace() {
        return clusterNamespace;
    }

    /**
     * DEPRECATED in release 2.4 and will be removed in the future since not used anymore.
     */
    @JsonProperty("clusterNamespace")
    public void setClusterNamespace(String clusterNamespace) {
        this.clusterNamespace = clusterNamespace;
    }

    /**
     * KlusterletAddonConfigSpec defines the desired state of KlusterletAddonConfig
     */
    @JsonProperty("iamPolicyController")
    public KlusterletAddonAgentConfigSpec getIamPolicyController() {
        return iamPolicyController;
    }

    /**
     * KlusterletAddonConfigSpec defines the desired state of KlusterletAddonConfig
     */
    @JsonProperty("iamPolicyController")
    public void setIamPolicyController(KlusterletAddonAgentConfigSpec iamPolicyController) {
        this.iamPolicyController = iamPolicyController;
    }

    /**
     * KlusterletAddonConfigSpec defines the desired state of KlusterletAddonConfig
     */
    @JsonProperty("policyController")
    public KlusterletAddonAgentConfigSpec getPolicyController() {
        return policyController;
    }

    /**
     * KlusterletAddonConfigSpec defines the desired state of KlusterletAddonConfig
     */
    @JsonProperty("policyController")
    public void setPolicyController(KlusterletAddonAgentConfigSpec policyController) {
        this.policyController = policyController;
    }

    /**
     * KlusterletAddonConfigSpec defines the desired state of KlusterletAddonConfig
     */
    @JsonProperty("proxyConfig")
    public ProxyConfig getProxyConfig() {
        return proxyConfig;
    }

    /**
     * KlusterletAddonConfigSpec defines the desired state of KlusterletAddonConfig
     */
    @JsonProperty("proxyConfig")
    public void setProxyConfig(ProxyConfig proxyConfig) {
        this.proxyConfig = proxyConfig;
    }

    /**
     * KlusterletAddonConfigSpec defines the desired state of KlusterletAddonConfig
     */
    @JsonProperty("searchCollector")
    public KlusterletAddonAgentConfigSpec getSearchCollector() {
        return searchCollector;
    }

    /**
     * KlusterletAddonConfigSpec defines the desired state of KlusterletAddonConfig
     */
    @JsonProperty("searchCollector")
    public void setSearchCollector(KlusterletAddonAgentConfigSpec searchCollector) {
        this.searchCollector = searchCollector;
    }

    /**
     * DEPRECATED in release 2.4 and will be removed in the future since not used anymore.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * DEPRECATED in release 2.4 and will be removed in the future since not used anymore.
     */
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
    @JsonIgnore
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof KlusterletAddonConfigSpec)) {
            return false;
        }
        KlusterletAddonConfigSpec other = (KlusterletAddonConfigSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$applicationManager = this.getApplicationManager();
        Object other$applicationManager = other.getApplicationManager();
        if (this$applicationManager == null ? other$applicationManager != null : !this$applicationManager.equals(other$applicationManager)) {
            return false;
        }
        Object this$certPolicyController = this.getCertPolicyController();
        Object other$certPolicyController = other.getCertPolicyController();
        if (this$certPolicyController == null ? other$certPolicyController != null : !this$certPolicyController.equals(other$certPolicyController)) {
            return false;
        }
        Object this$clusterLabels = this.getClusterLabels();
        Object other$clusterLabels = other.getClusterLabels();
        if (this$clusterLabels == null ? other$clusterLabels != null : !this$clusterLabels.equals(other$clusterLabels)) {
            return false;
        }
        Object this$clusterName = this.getClusterName();
        Object other$clusterName = other.getClusterName();
        if (this$clusterName == null ? other$clusterName != null : !this$clusterName.equals(other$clusterName)) {
            return false;
        }
        Object this$clusterNamespace = this.getClusterNamespace();
        Object other$clusterNamespace = other.getClusterNamespace();
        if (this$clusterNamespace == null ? other$clusterNamespace != null : !this$clusterNamespace.equals(other$clusterNamespace)) {
            return false;
        }
        Object this$iamPolicyController = this.getIamPolicyController();
        Object other$iamPolicyController = other.getIamPolicyController();
        if (this$iamPolicyController == null ? other$iamPolicyController != null : !this$iamPolicyController.equals(other$iamPolicyController)) {
            return false;
        }
        Object this$policyController = this.getPolicyController();
        Object other$policyController = other.getPolicyController();
        if (this$policyController == null ? other$policyController != null : !this$policyController.equals(other$policyController)) {
            return false;
        }
        Object this$proxyConfig = this.getProxyConfig();
        Object other$proxyConfig = other.getProxyConfig();
        if (this$proxyConfig == null ? other$proxyConfig != null : !this$proxyConfig.equals(other$proxyConfig)) {
            return false;
        }
        Object this$searchCollector = this.getSearchCollector();
        Object other$searchCollector = other.getSearchCollector();
        if (this$searchCollector == null ? other$searchCollector != null : !this$searchCollector.equals(other$searchCollector)) {
            return false;
        }
        Object this$version = this.getVersion();
        Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof KlusterletAddonConfigSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $applicationManager = this.getApplicationManager();
        result = result * prime + ($applicationManager == null ? 43 : $applicationManager.hashCode());
        Object $certPolicyController = this.getCertPolicyController();
        result = result * prime + ($certPolicyController == null ? 43 : $certPolicyController.hashCode());
        Object $clusterLabels = this.getClusterLabels();
        result = result * prime + ($clusterLabels == null ? 43 : $clusterLabels.hashCode());
        Object $clusterName = this.getClusterName();
        result = result * prime + ($clusterName == null ? 43 : $clusterName.hashCode());
        Object $clusterNamespace = this.getClusterNamespace();
        result = result * prime + ($clusterNamespace == null ? 43 : $clusterNamespace.hashCode());
        Object $iamPolicyController = this.getIamPolicyController();
        result = result * prime + ($iamPolicyController == null ? 43 : $iamPolicyController.hashCode());
        Object $policyController = this.getPolicyController();
        result = result * prime + ($policyController == null ? 43 : $policyController.hashCode());
        Object $proxyConfig = this.getProxyConfig();
        result = result * prime + ($proxyConfig == null ? 43 : $proxyConfig.hashCode());
        Object $searchCollector = this.getSearchCollector();
        result = result * prime + ($searchCollector == null ? 43 : $searchCollector.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "KlusterletAddonConfigSpec(" + "applicationManager=" + this.getApplicationManager() + ", certPolicyController=" + this.getCertPolicyController() + ", clusterLabels=" + this.getClusterLabels() + ", clusterName=" + this.getClusterName() + ", clusterNamespace=" + this.getClusterNamespace() + ", iamPolicyController=" + this.getIamPolicyController() + ", policyController=" + this.getPolicyController() + ", proxyConfig=" + this.getProxyConfig() + ", searchCollector=" + this.getSearchCollector() + ", version=" + this.getVersion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
