
package io.fabric8.openshift.api.model.operator.imageregistry.v1;

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
 * AzureNetworkAccess defines the network access properties for the storage account.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "internal",
    "type"
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
public class AzureNetworkAccess implements Editable<AzureNetworkAccessBuilder>, KubernetesResource
{

    @JsonProperty("internal")
    private AzureNetworkAccessInternal internal;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureNetworkAccess() {
    }

    public AzureNetworkAccess(AzureNetworkAccessInternal internal, String type) {
        super();
        this.internal = internal;
        this.type = type;
    }

    /**
     * AzureNetworkAccess defines the network access properties for the storage account.
     */
    @JsonProperty("internal")
    public AzureNetworkAccessInternal getInternal() {
        return internal;
    }

    /**
     * AzureNetworkAccess defines the network access properties for the storage account.
     */
    @JsonProperty("internal")
    public void setInternal(AzureNetworkAccessInternal internal) {
        this.internal = internal;
    }

    /**
     * type is the network access level to be used for the storage account. type: Internal means the storage account will be private, type: External means the storage account will be publicly accessible. Internal storage accounts are only exposed within the cluster's vnet. External storage accounts are publicly exposed on the internet. When type: Internal is used, a vnetName, subNetName and privateEndpointName may optionally be specified. If unspecificed, the image registry operator will discover vnet and subnet names, and generate a privateEndpointName. Defaults to "External".
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is the network access level to be used for the storage account. type: Internal means the storage account will be private, type: External means the storage account will be publicly accessible. Internal storage accounts are only exposed within the cluster's vnet. External storage accounts are publicly exposed on the internet. When type: Internal is used, a vnetName, subNetName and privateEndpointName may optionally be specified. If unspecificed, the image registry operator will discover vnet and subnet names, and generate a privateEndpointName. Defaults to "External".
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public AzureNetworkAccessBuilder edit() {
        return new AzureNetworkAccessBuilder(this);
    }

    @JsonIgnore
    public AzureNetworkAccessBuilder toBuilder() {
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
        if (!(o instanceof AzureNetworkAccess)) {
            return false;
        }
        AzureNetworkAccess other = (AzureNetworkAccess) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$internal = this.getInternal();
        Object other$internal = other.getInternal();
        if (this$internal == null ? other$internal != null : !this$internal.equals(other$internal)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof AzureNetworkAccess;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $internal = this.getInternal();
        result = result * prime + ($internal == null ? 43 : $internal.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AzureNetworkAccess(" + "internal=" + this.getInternal() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
