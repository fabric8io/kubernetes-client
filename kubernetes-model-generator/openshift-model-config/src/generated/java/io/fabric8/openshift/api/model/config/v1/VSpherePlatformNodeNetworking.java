
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * VSpherePlatformNodeNetworking holds the external and internal node networking spec.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "external",
    "internal"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class VSpherePlatformNodeNetworking implements Editable<VSpherePlatformNodeNetworkingBuilder>, KubernetesResource
{

    @JsonProperty("external")
    private VSpherePlatformNodeNetworkingSpec external;
    @JsonProperty("internal")
    private VSpherePlatformNodeNetworkingSpec internal;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VSpherePlatformNodeNetworking() {
    }

    public VSpherePlatformNodeNetworking(VSpherePlatformNodeNetworkingSpec external, VSpherePlatformNodeNetworkingSpec internal) {
        super();
        this.external = external;
        this.internal = internal;
    }

    /**
     * VSpherePlatformNodeNetworking holds the external and internal node networking spec.
     */
    @JsonProperty("external")
    public VSpherePlatformNodeNetworkingSpec getExternal() {
        return external;
    }

    /**
     * VSpherePlatformNodeNetworking holds the external and internal node networking spec.
     */
    @JsonProperty("external")
    public void setExternal(VSpherePlatformNodeNetworkingSpec external) {
        this.external = external;
    }

    /**
     * VSpherePlatformNodeNetworking holds the external and internal node networking spec.
     */
    @JsonProperty("internal")
    public VSpherePlatformNodeNetworkingSpec getInternal() {
        return internal;
    }

    /**
     * VSpherePlatformNodeNetworking holds the external and internal node networking spec.
     */
    @JsonProperty("internal")
    public void setInternal(VSpherePlatformNodeNetworkingSpec internal) {
        this.internal = internal;
    }

    @JsonIgnore
    public VSpherePlatformNodeNetworkingBuilder edit() {
        return new VSpherePlatformNodeNetworkingBuilder(this);
    }

    @JsonIgnore
    public VSpherePlatformNodeNetworkingBuilder toBuilder() {
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
        if (!(o instanceof VSpherePlatformNodeNetworking)) {
            return false;
        }
        VSpherePlatformNodeNetworking other = (VSpherePlatformNodeNetworking) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$external = this.getExternal();
        Object other$external = other.getExternal();
        if (this$external == null ? other$external != null : !this$external.equals(other$external)) {
            return false;
        }
        Object this$internal = this.getInternal();
        Object other$internal = other.getInternal();
        if (this$internal == null ? other$internal != null : !this$internal.equals(other$internal)) {
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
        return other instanceof VSpherePlatformNodeNetworking;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $external = this.getExternal();
        result = result * prime + ($external == null ? 43 : $external.hashCode());
        Object $internal = this.getInternal();
        result = result * prime + ($internal == null ? 43 : $internal.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VSpherePlatformNodeNetworking(" + "external=" + this.getExternal() + ", internal=" + this.getInternal() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
