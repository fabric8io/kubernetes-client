
package io.fabric8.kubernetes.api.model.ovn.v1;

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
 * DynamicHop defines the configuration for a dynamic external gateway interface. These interfaces are wrapped around a pod object that resides inside the cluster. The field NetworkAttachmentName captures the name of the multus network name to use when retrieving the gateway IP to use. The PodSelector and the NamespaceSelector are mandatory fields.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bfdEnabled",
    "namespaceSelector",
    "networkAttachmentName",
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
public class DynamicHop implements Editable<DynamicHopBuilder>, KubernetesResource
{

    @JsonProperty("bfdEnabled")
    private Boolean bfdEnabled;
    @JsonProperty("namespaceSelector")
    private LabelSelector namespaceSelector;
    @JsonProperty("networkAttachmentName")
    private String networkAttachmentName;
    @JsonProperty("podSelector")
    private LabelSelector podSelector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DynamicHop() {
    }

    public DynamicHop(Boolean bfdEnabled, LabelSelector namespaceSelector, String networkAttachmentName, LabelSelector podSelector) {
        super();
        this.bfdEnabled = bfdEnabled;
        this.namespaceSelector = namespaceSelector;
        this.networkAttachmentName = networkAttachmentName;
        this.podSelector = podSelector;
    }

    /**
     * BFDEnabled determines if the interface implements the Bidirectional Forward Detection protocol. Defaults to false.
     */
    @JsonProperty("bfdEnabled")
    public Boolean getBfdEnabled() {
        return bfdEnabled;
    }

    /**
     * BFDEnabled determines if the interface implements the Bidirectional Forward Detection protocol. Defaults to false.
     */
    @JsonProperty("bfdEnabled")
    public void setBfdEnabled(Boolean bfdEnabled) {
        this.bfdEnabled = bfdEnabled;
    }

    /**
     * DynamicHop defines the configuration for a dynamic external gateway interface. These interfaces are wrapped around a pod object that resides inside the cluster. The field NetworkAttachmentName captures the name of the multus network name to use when retrieving the gateway IP to use. The PodSelector and the NamespaceSelector are mandatory fields.
     */
    @JsonProperty("namespaceSelector")
    public LabelSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    /**
     * DynamicHop defines the configuration for a dynamic external gateway interface. These interfaces are wrapped around a pod object that resides inside the cluster. The field NetworkAttachmentName captures the name of the multus network name to use when retrieving the gateway IP to use. The PodSelector and the NamespaceSelector are mandatory fields.
     */
    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(LabelSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    /**
     * NetworkAttachmentName determines the multus network name to use when retrieving the pod IPs that will be used as the gateway IP. When this field is empty, the logic assumes that the pod is configured with HostNetwork and is using the node's IP as gateway.
     */
    @JsonProperty("networkAttachmentName")
    public String getNetworkAttachmentName() {
        return networkAttachmentName;
    }

    /**
     * NetworkAttachmentName determines the multus network name to use when retrieving the pod IPs that will be used as the gateway IP. When this field is empty, the logic assumes that the pod is configured with HostNetwork and is using the node's IP as gateway.
     */
    @JsonProperty("networkAttachmentName")
    public void setNetworkAttachmentName(String networkAttachmentName) {
        this.networkAttachmentName = networkAttachmentName;
    }

    /**
     * DynamicHop defines the configuration for a dynamic external gateway interface. These interfaces are wrapped around a pod object that resides inside the cluster. The field NetworkAttachmentName captures the name of the multus network name to use when retrieving the gateway IP to use. The PodSelector and the NamespaceSelector are mandatory fields.
     */
    @JsonProperty("podSelector")
    public LabelSelector getPodSelector() {
        return podSelector;
    }

    /**
     * DynamicHop defines the configuration for a dynamic external gateway interface. These interfaces are wrapped around a pod object that resides inside the cluster. The field NetworkAttachmentName captures the name of the multus network name to use when retrieving the gateway IP to use. The PodSelector and the NamespaceSelector are mandatory fields.
     */
    @JsonProperty("podSelector")
    public void setPodSelector(LabelSelector podSelector) {
        this.podSelector = podSelector;
    }

    @JsonIgnore
    public DynamicHopBuilder edit() {
        return new DynamicHopBuilder(this);
    }

    @JsonIgnore
    public DynamicHopBuilder toBuilder() {
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
        if (!(o instanceof DynamicHop)) {
            return false;
        }
        DynamicHop other = (DynamicHop) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$bfdEnabled = this.getBfdEnabled();
        Object other$bfdEnabled = other.getBfdEnabled();
        if (this$bfdEnabled == null ? other$bfdEnabled != null : !this$bfdEnabled.equals(other$bfdEnabled)) {
            return false;
        }
        Object this$namespaceSelector = this.getNamespaceSelector();
        Object other$namespaceSelector = other.getNamespaceSelector();
        if (this$namespaceSelector == null ? other$namespaceSelector != null : !this$namespaceSelector.equals(other$namespaceSelector)) {
            return false;
        }
        Object this$networkAttachmentName = this.getNetworkAttachmentName();
        Object other$networkAttachmentName = other.getNetworkAttachmentName();
        if (this$networkAttachmentName == null ? other$networkAttachmentName != null : !this$networkAttachmentName.equals(other$networkAttachmentName)) {
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
        return other instanceof DynamicHop;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bfdEnabled = this.getBfdEnabled();
        result = result * prime + ($bfdEnabled == null ? 43 : $bfdEnabled.hashCode());
        Object $namespaceSelector = this.getNamespaceSelector();
        result = result * prime + ($namespaceSelector == null ? 43 : $namespaceSelector.hashCode());
        Object $networkAttachmentName = this.getNetworkAttachmentName();
        result = result * prime + ($networkAttachmentName == null ? 43 : $networkAttachmentName.hashCode());
        Object $podSelector = this.getPodSelector();
        result = result * prime + ($podSelector == null ? 43 : $podSelector.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DynamicHop(" + "bfdEnabled=" + this.getBfdEnabled() + ", namespaceSelector=" + this.getNamespaceSelector() + ", networkAttachmentName=" + this.getNetworkAttachmentName() + ", podSelector=" + this.getPodSelector() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
