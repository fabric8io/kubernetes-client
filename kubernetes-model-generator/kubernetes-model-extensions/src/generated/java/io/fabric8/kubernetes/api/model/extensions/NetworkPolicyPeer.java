
package io.fabric8.kubernetes.api.model.extensions;

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
 * DEPRECATED 1.9 - This group version of NetworkPolicyPeer is deprecated by networking/v1/NetworkPolicyPeer.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ipBlock",
    "namespaceSelector",
    "podSelector"
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
public class NetworkPolicyPeer implements Editable<NetworkPolicyPeerBuilder>, KubernetesResource
{

    @JsonProperty("ipBlock")
    private IPBlock ipBlock;
    @JsonProperty("namespaceSelector")
    private LabelSelector namespaceSelector;
    @JsonProperty("podSelector")
    private LabelSelector podSelector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkPolicyPeer() {
    }

    public NetworkPolicyPeer(IPBlock ipBlock, LabelSelector namespaceSelector, LabelSelector podSelector) {
        super();
        this.ipBlock = ipBlock;
        this.namespaceSelector = namespaceSelector;
        this.podSelector = podSelector;
    }

    /**
     * DEPRECATED 1.9 - This group version of NetworkPolicyPeer is deprecated by networking/v1/NetworkPolicyPeer.
     */
    @JsonProperty("ipBlock")
    public IPBlock getIpBlock() {
        return ipBlock;
    }

    /**
     * DEPRECATED 1.9 - This group version of NetworkPolicyPeer is deprecated by networking/v1/NetworkPolicyPeer.
     */
    @JsonProperty("ipBlock")
    public void setIpBlock(IPBlock ipBlock) {
        this.ipBlock = ipBlock;
    }

    /**
     * DEPRECATED 1.9 - This group version of NetworkPolicyPeer is deprecated by networking/v1/NetworkPolicyPeer.
     */
    @JsonProperty("namespaceSelector")
    public LabelSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    /**
     * DEPRECATED 1.9 - This group version of NetworkPolicyPeer is deprecated by networking/v1/NetworkPolicyPeer.
     */
    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(LabelSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    /**
     * DEPRECATED 1.9 - This group version of NetworkPolicyPeer is deprecated by networking/v1/NetworkPolicyPeer.
     */
    @JsonProperty("podSelector")
    public LabelSelector getPodSelector() {
        return podSelector;
    }

    /**
     * DEPRECATED 1.9 - This group version of NetworkPolicyPeer is deprecated by networking/v1/NetworkPolicyPeer.
     */
    @JsonProperty("podSelector")
    public void setPodSelector(LabelSelector podSelector) {
        this.podSelector = podSelector;
    }

    @JsonIgnore
    public NetworkPolicyPeerBuilder edit() {
        return new NetworkPolicyPeerBuilder(this);
    }

    @JsonIgnore
    public NetworkPolicyPeerBuilder toBuilder() {
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
        if (!(o instanceof NetworkPolicyPeer)) {
            return false;
        }
        NetworkPolicyPeer other = (NetworkPolicyPeer) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ipBlock = this.getIpBlock();
        Object other$ipBlock = other.getIpBlock();
        if (this$ipBlock == null ? other$ipBlock != null : !this$ipBlock.equals(other$ipBlock)) {
            return false;
        }
        Object this$namespaceSelector = this.getNamespaceSelector();
        Object other$namespaceSelector = other.getNamespaceSelector();
        if (this$namespaceSelector == null ? other$namespaceSelector != null : !this$namespaceSelector.equals(other$namespaceSelector)) {
            return false;
        }
        Object this$podSelector = this.getPodSelector();
        Object other$podSelector = other.getPodSelector();
        if (this$podSelector == null ? other$podSelector != null : !this$podSelector.equals(other$podSelector)) {
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
        return other instanceof NetworkPolicyPeer;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $ipBlock = this.getIpBlock();
        result = result * prime + ($ipBlock == null ? 43 : $ipBlock.hashCode());
        Object $namespaceSelector = this.getNamespaceSelector();
        result = result * prime + ($namespaceSelector == null ? 43 : $namespaceSelector.hashCode());
        Object $podSelector = this.getPodSelector();
        result = result * prime + ($podSelector == null ? 43 : $podSelector.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NetworkPolicyPeer(" + "ipBlock=" + this.getIpBlock() + ", namespaceSelector=" + this.getNamespaceSelector() + ", podSelector=" + this.getPodSelector() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
