
package io.fabric8.openshift.api.model.machineconfiguration.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * MachineConfigNodeStatusConfigImage holds the observed state of the image on the node, including both the image targeted for an update and the image currently applied. This allows for monitoring the progress of the layering rollout. If Image Mode is enabled, desiredImage must be defined.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currentImage",
    "desiredImage"
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
public class MachineConfigNodeStatusConfigImage implements Editable<MachineConfigNodeStatusConfigImageBuilder>, KubernetesResource
{

    @JsonProperty("currentImage")
    private String currentImage;
    @JsonProperty("desiredImage")
    private String desiredImage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineConfigNodeStatusConfigImage() {
    }

    public MachineConfigNodeStatusConfigImage(String currentImage, String desiredImage) {
        super();
        this.currentImage = currentImage;
        this.desiredImage = desiredImage;
    }

    /**
     * currentImage is an optional field that represents the current image that is applied to the node. When omitted, this means that no image updates have been applied to the node and it will be up to date with the specific current rendered config version. When specified, this means that the node is currently using this image. currentImage must be a fully qualified OCI image pull spec of the format host[:port][/namespace]/name@sha256:, where the digest must be exactly 64 characters in length and consist only of lowercase hexadecimal characters, a-f and 0-9. currentImage must not be an empty string and must not exceed 447 characters in length.
     */
    @JsonProperty("currentImage")
    public String getCurrentImage() {
        return currentImage;
    }

    /**
     * currentImage is an optional field that represents the current image that is applied to the node. When omitted, this means that no image updates have been applied to the node and it will be up to date with the specific current rendered config version. When specified, this means that the node is currently using this image. currentImage must be a fully qualified OCI image pull spec of the format host[:port][/namespace]/name@sha256:, where the digest must be exactly 64 characters in length and consist only of lowercase hexadecimal characters, a-f and 0-9. currentImage must not be an empty string and must not exceed 447 characters in length.
     */
    @JsonProperty("currentImage")
    public void setCurrentImage(String currentImage) {
        this.currentImage = currentImage;
    }

    /**
     * desiredImage is an optional field that represents the currently observed state of image that the node should be updated to use. When not specified, this means that Image Mode has been disabled and the node will up to date with the specific current rendered config version. When specified, this means that Image Mode has been enabled and the node is actively progressing to update the node to this image. If currentImage and desiredImage match, the node has been successfully updated to use the desired image. desiredImage must be a fully qualified OCI image pull spec of the format host[:port][/namespace]/name@sha256:, where the digest must be exactly 64 characters in length and consist only of lowercase hexadecimal characters, a-f and 0-9. desiredImage must not be an empty string and must not exceed 447 characters in length.
     */
    @JsonProperty("desiredImage")
    public String getDesiredImage() {
        return desiredImage;
    }

    /**
     * desiredImage is an optional field that represents the currently observed state of image that the node should be updated to use. When not specified, this means that Image Mode has been disabled and the node will up to date with the specific current rendered config version. When specified, this means that Image Mode has been enabled and the node is actively progressing to update the node to this image. If currentImage and desiredImage match, the node has been successfully updated to use the desired image. desiredImage must be a fully qualified OCI image pull spec of the format host[:port][/namespace]/name@sha256:, where the digest must be exactly 64 characters in length and consist only of lowercase hexadecimal characters, a-f and 0-9. desiredImage must not be an empty string and must not exceed 447 characters in length.
     */
    @JsonProperty("desiredImage")
    public void setDesiredImage(String desiredImage) {
        this.desiredImage = desiredImage;
    }

    @JsonIgnore
    public MachineConfigNodeStatusConfigImageBuilder edit() {
        return new MachineConfigNodeStatusConfigImageBuilder(this);
    }

    @JsonIgnore
    public MachineConfigNodeStatusConfigImageBuilder toBuilder() {
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
        if (!(o instanceof MachineConfigNodeStatusConfigImage)) {
            return false;
        }
        MachineConfigNodeStatusConfigImage other = (MachineConfigNodeStatusConfigImage) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$currentImage = this.getCurrentImage();
        Object other$currentImage = other.getCurrentImage();
        if (this$currentImage == null ? other$currentImage != null : !this$currentImage.equals(other$currentImage)) {
            return false;
        }
        Object this$desiredImage = this.getDesiredImage();
        Object other$desiredImage = other.getDesiredImage();
        if (this$desiredImage == null ? other$desiredImage != null : !this$desiredImage.equals(other$desiredImage)) {
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
        return other instanceof MachineConfigNodeStatusConfigImage;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $currentImage = this.getCurrentImage();
        result = result * prime + ($currentImage == null ? 43 : $currentImage.hashCode());
        Object $desiredImage = this.getDesiredImage();
        result = result * prime + ($desiredImage == null ? 43 : $desiredImage.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachineConfigNodeStatusConfigImage(" + "currentImage=" + this.getCurrentImage() + ", desiredImage=" + this.getDesiredImage() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
