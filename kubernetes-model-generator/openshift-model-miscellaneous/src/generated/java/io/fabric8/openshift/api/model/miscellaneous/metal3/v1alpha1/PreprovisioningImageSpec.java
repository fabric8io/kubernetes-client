
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * PreprovisioningImageSpec defines the desired state of PreprovisioningImage.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "acceptFormats",
    "architecture",
    "networkDataName"
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
public class PreprovisioningImageSpec implements Editable<PreprovisioningImageSpecBuilder>, KubernetesResource
{

    @JsonProperty("acceptFormats")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> acceptFormats = new ArrayList<>();
    @JsonProperty("architecture")
    private String architecture;
    @JsonProperty("networkDataName")
    private String networkDataName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PreprovisioningImageSpec() {
    }

    public PreprovisioningImageSpec(List<String> acceptFormats, String architecture, String networkDataName) {
        super();
        this.acceptFormats = acceptFormats;
        this.architecture = architecture;
        this.networkDataName = networkDataName;
    }

    /**
     * acceptFormats is a list of acceptable image formats.
     */
    @JsonProperty("acceptFormats")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAcceptFormats() {
        return acceptFormats;
    }

    /**
     * acceptFormats is a list of acceptable image formats.
     */
    @JsonProperty("acceptFormats")
    public void setAcceptFormats(List<String> acceptFormats) {
        this.acceptFormats = acceptFormats;
    }

    /**
     * architecture is the processor architecture for which to build the image.
     */
    @JsonProperty("architecture")
    public String getArchitecture() {
        return architecture;
    }

    /**
     * architecture is the processor architecture for which to build the image.
     */
    @JsonProperty("architecture")
    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    /**
     * networkDataName is the name of a Secret in the local namespace that contains network data to build in to the image.
     */
    @JsonProperty("networkDataName")
    public String getNetworkDataName() {
        return networkDataName;
    }

    /**
     * networkDataName is the name of a Secret in the local namespace that contains network data to build in to the image.
     */
    @JsonProperty("networkDataName")
    public void setNetworkDataName(String networkDataName) {
        this.networkDataName = networkDataName;
    }

    @JsonIgnore
    public PreprovisioningImageSpecBuilder edit() {
        return new PreprovisioningImageSpecBuilder(this);
    }

    @JsonIgnore
    public PreprovisioningImageSpecBuilder toBuilder() {
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
        if (!(o instanceof PreprovisioningImageSpec)) {
            return false;
        }
        PreprovisioningImageSpec other = (PreprovisioningImageSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$acceptFormats = this.getAcceptFormats();
        Object other$acceptFormats = other.getAcceptFormats();
        if (this$acceptFormats == null ? other$acceptFormats != null : !this$acceptFormats.equals(other$acceptFormats)) {
            return false;
        }
        Object this$architecture = this.getArchitecture();
        Object other$architecture = other.getArchitecture();
        if (this$architecture == null ? other$architecture != null : !this$architecture.equals(other$architecture)) {
            return false;
        }
        Object this$networkDataName = this.getNetworkDataName();
        Object other$networkDataName = other.getNetworkDataName();
        if (this$networkDataName == null ? other$networkDataName != null : !this$networkDataName.equals(other$networkDataName)) {
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
        return other instanceof PreprovisioningImageSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $acceptFormats = this.getAcceptFormats();
        result = result * prime + ($acceptFormats == null ? 43 : $acceptFormats.hashCode());
        Object $architecture = this.getArchitecture();
        result = result * prime + ($architecture == null ? 43 : $architecture.hashCode());
        Object $networkDataName = this.getNetworkDataName();
        result = result * prime + ($networkDataName == null ? 43 : $networkDataName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PreprovisioningImageSpec(" + "acceptFormats=" + this.getAcceptFormats() + ", architecture=" + this.getArchitecture() + ", networkDataName=" + this.getNetworkDataName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
