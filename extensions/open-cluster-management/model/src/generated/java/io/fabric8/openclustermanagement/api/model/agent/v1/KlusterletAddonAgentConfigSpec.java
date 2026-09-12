
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
 * KlusterletAddonAgentConfigSpec defines configuration for each addon agent.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "enabled",
    "proxyPolicy"
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
public class KlusterletAddonAgentConfigSpec implements Editable<KlusterletAddonAgentConfigSpecBuilder>, KubernetesResource
{

    @JsonProperty("enabled")
    private Boolean enabled;
    @JsonProperty("proxyPolicy")
    private String proxyPolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public KlusterletAddonAgentConfigSpec() {
    }

    public KlusterletAddonAgentConfigSpec(Boolean enabled, String proxyPolicy) {
        super();
        this.enabled = enabled;
        this.proxyPolicy = proxyPolicy;
    }

    /**
     * Enabled is the flag to enable/disable the addon. default is false.
     */
    @JsonProperty("enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * Enabled is the flag to enable/disable the addon. default is false.
     */
    @JsonProperty("enabled")
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * ProxyPolicy defines the policy to set proxy for each addon agent. default is Disabled. Disabled means that the addon agent pods do not configure the proxy env variables. OCPGlobalProxy means that the addon agent pods use the cluster-wide proxy config of OCP cluster provisioned by ACM. CustomProxy means that the addon agent pods use the ProxyConfig specified in KlusterletAddonConfig.
     */
    @JsonProperty("proxyPolicy")
    public String getProxyPolicy() {
        return proxyPolicy;
    }

    /**
     * ProxyPolicy defines the policy to set proxy for each addon agent. default is Disabled. Disabled means that the addon agent pods do not configure the proxy env variables. OCPGlobalProxy means that the addon agent pods use the cluster-wide proxy config of OCP cluster provisioned by ACM. CustomProxy means that the addon agent pods use the ProxyConfig specified in KlusterletAddonConfig.
     */
    @JsonProperty("proxyPolicy")
    public void setProxyPolicy(String proxyPolicy) {
        this.proxyPolicy = proxyPolicy;
    }

    @JsonIgnore
    public KlusterletAddonAgentConfigSpecBuilder edit() {
        return new KlusterletAddonAgentConfigSpecBuilder(this);
    }

    @JsonIgnore
    public KlusterletAddonAgentConfigSpecBuilder toBuilder() {
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
        if (!(o instanceof KlusterletAddonAgentConfigSpec)) {
            return false;
        }
        KlusterletAddonAgentConfigSpec other = (KlusterletAddonAgentConfigSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$enabled = this.getEnabled();
        Object other$enabled = other.getEnabled();
        if (this$enabled == null ? other$enabled != null : !this$enabled.equals(other$enabled)) {
            return false;
        }
        Object this$proxyPolicy = this.getProxyPolicy();
        Object other$proxyPolicy = other.getProxyPolicy();
        if (this$proxyPolicy == null ? other$proxyPolicy != null : !this$proxyPolicy.equals(other$proxyPolicy)) {
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
        return other instanceof KlusterletAddonAgentConfigSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $enabled = this.getEnabled();
        result = result * prime + ($enabled == null ? 43 : $enabled.hashCode());
        Object $proxyPolicy = this.getProxyPolicy();
        result = result * prime + ($proxyPolicy == null ? 43 : $proxyPolicy.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "KlusterletAddonAgentConfigSpec(" + "enabled=" + this.getEnabled() + ", proxyPolicy=" + this.getProxyPolicy() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
