
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
import io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedCluster;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * AddonAgentConfig is the configurations for addon agents.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ImagePullPolicy",
    "ImagePullSecret",
    "ImagePullSecretNamespace",
    "KlusterletAddonConfig",
    "ManagedCluster",
    "NodeSelector"
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
public class AddonAgentConfig implements Editable<AddonAgentConfigBuilder>, KubernetesResource
{

    @JsonProperty("ImagePullPolicy")
    private String imagePullPolicy;
    @JsonProperty("ImagePullSecret")
    private String imagePullSecret;
    @JsonProperty("ImagePullSecretNamespace")
    private String imagePullSecretNamespace;
    @JsonProperty("KlusterletAddonConfig")
    private KlusterletAddonConfig klusterletAddonConfig;
    @JsonProperty("ManagedCluster")
    private ManagedCluster managedCluster;
    @JsonProperty("NodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelector = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AddonAgentConfig() {
    }

    public AddonAgentConfig(String imagePullPolicy, String imagePullSecret, String imagePullSecretNamespace, KlusterletAddonConfig klusterletAddonConfig, ManagedCluster managedCluster, Map<String, String> nodeSelector) {
        super();
        this.imagePullPolicy = imagePullPolicy;
        this.imagePullSecret = imagePullSecret;
        this.imagePullSecretNamespace = imagePullSecretNamespace;
        this.klusterletAddonConfig = klusterletAddonConfig;
        this.managedCluster = managedCluster;
        this.nodeSelector = nodeSelector;
    }

    /**
     * AddonAgentConfig is the configurations for addon agents.
     */
    @JsonProperty("ImagePullPolicy")
    public String getImagePullPolicy() {
        return imagePullPolicy;
    }

    /**
     * AddonAgentConfig is the configurations for addon agents.
     */
    @JsonProperty("ImagePullPolicy")
    public void setImagePullPolicy(String imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
    }

    /**
     * AddonAgentConfig is the configurations for addon agents.
     */
    @JsonProperty("ImagePullSecret")
    public String getImagePullSecret() {
        return imagePullSecret;
    }

    /**
     * AddonAgentConfig is the configurations for addon agents.
     */
    @JsonProperty("ImagePullSecret")
    public void setImagePullSecret(String imagePullSecret) {
        this.imagePullSecret = imagePullSecret;
    }

    /**
     * AddonAgentConfig is the configurations for addon agents.
     */
    @JsonProperty("ImagePullSecretNamespace")
    public String getImagePullSecretNamespace() {
        return imagePullSecretNamespace;
    }

    /**
     * AddonAgentConfig is the configurations for addon agents.
     */
    @JsonProperty("ImagePullSecretNamespace")
    public void setImagePullSecretNamespace(String imagePullSecretNamespace) {
        this.imagePullSecretNamespace = imagePullSecretNamespace;
    }

    /**
     * AddonAgentConfig is the configurations for addon agents.
     */
    @JsonProperty("KlusterletAddonConfig")
    public KlusterletAddonConfig getKlusterletAddonConfig() {
        return klusterletAddonConfig;
    }

    /**
     * AddonAgentConfig is the configurations for addon agents.
     */
    @JsonProperty("KlusterletAddonConfig")
    public void setKlusterletAddonConfig(KlusterletAddonConfig klusterletAddonConfig) {
        this.klusterletAddonConfig = klusterletAddonConfig;
    }

    /**
     * AddonAgentConfig is the configurations for addon agents.
     */
    @JsonProperty("ManagedCluster")
    public ManagedCluster getManagedCluster() {
        return managedCluster;
    }

    /**
     * AddonAgentConfig is the configurations for addon agents.
     */
    @JsonProperty("ManagedCluster")
    public void setManagedCluster(ManagedCluster managedCluster) {
        this.managedCluster = managedCluster;
    }

    /**
     * AddonAgentConfig is the configurations for addon agents.
     */
    @JsonProperty("NodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    /**
     * AddonAgentConfig is the configurations for addon agents.
     */
    @JsonProperty("NodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    @JsonIgnore
    public AddonAgentConfigBuilder edit() {
        return new AddonAgentConfigBuilder(this);
    }

    @JsonIgnore
    public AddonAgentConfigBuilder toBuilder() {
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
        if (!(o instanceof AddonAgentConfig)) {
            return false;
        }
        AddonAgentConfig other = (AddonAgentConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$imagePullPolicy = this.getImagePullPolicy();
        Object other$imagePullPolicy = other.getImagePullPolicy();
        if (this$imagePullPolicy == null ? other$imagePullPolicy != null : !this$imagePullPolicy.equals(other$imagePullPolicy)) {
            return false;
        }
        Object this$imagePullSecret = this.getImagePullSecret();
        Object other$imagePullSecret = other.getImagePullSecret();
        if (this$imagePullSecret == null ? other$imagePullSecret != null : !this$imagePullSecret.equals(other$imagePullSecret)) {
            return false;
        }
        Object this$imagePullSecretNamespace = this.getImagePullSecretNamespace();
        Object other$imagePullSecretNamespace = other.getImagePullSecretNamespace();
        if (this$imagePullSecretNamespace == null ? other$imagePullSecretNamespace != null : !this$imagePullSecretNamespace.equals(other$imagePullSecretNamespace)) {
            return false;
        }
        Object this$klusterletAddonConfig = this.getKlusterletAddonConfig();
        Object other$klusterletAddonConfig = other.getKlusterletAddonConfig();
        if (this$klusterletAddonConfig == null ? other$klusterletAddonConfig != null : !this$klusterletAddonConfig.equals(other$klusterletAddonConfig)) {
            return false;
        }
        Object this$managedCluster = this.getManagedCluster();
        Object other$managedCluster = other.getManagedCluster();
        if (this$managedCluster == null ? other$managedCluster != null : !this$managedCluster.equals(other$managedCluster)) {
            return false;
        }
        Object this$nodeSelector = this.getNodeSelector();
        Object other$nodeSelector = other.getNodeSelector();
        if (this$nodeSelector == null ? other$nodeSelector != null : !this$nodeSelector.equals(other$nodeSelector)) {
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
        return other instanceof AddonAgentConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $imagePullPolicy = this.getImagePullPolicy();
        result = result * prime + ($imagePullPolicy == null ? 43 : $imagePullPolicy.hashCode());
        Object $imagePullSecret = this.getImagePullSecret();
        result = result * prime + ($imagePullSecret == null ? 43 : $imagePullSecret.hashCode());
        Object $imagePullSecretNamespace = this.getImagePullSecretNamespace();
        result = result * prime + ($imagePullSecretNamespace == null ? 43 : $imagePullSecretNamespace.hashCode());
        Object $klusterletAddonConfig = this.getKlusterletAddonConfig();
        result = result * prime + ($klusterletAddonConfig == null ? 43 : $klusterletAddonConfig.hashCode());
        Object $managedCluster = this.getManagedCluster();
        result = result * prime + ($managedCluster == null ? 43 : $managedCluster.hashCode());
        Object $nodeSelector = this.getNodeSelector();
        result = result * prime + ($nodeSelector == null ? 43 : $nodeSelector.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AddonAgentConfig(" + "imagePullPolicy=" + this.getImagePullPolicy() + ", imagePullSecret=" + this.getImagePullSecret() + ", imagePullSecretNamespace=" + this.getImagePullSecretNamespace() + ", klusterletAddonConfig=" + this.getKlusterletAddonConfig() + ", managedCluster=" + this.getManagedCluster() + ", nodeSelector=" + this.getNodeSelector() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
