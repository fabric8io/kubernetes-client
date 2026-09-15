
package io.fabric8.openshift.api.model;

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
 * ImageChangeCause contains information about the image that triggered a build
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fromRef",
    "imageID"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ImageChangeCause implements Editable<ImageChangeCauseBuilder>, KubernetesResource
{

    @JsonProperty("fromRef")
    private ObjectReference fromRef;
    @JsonProperty("imageID")
    private String imageID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageChangeCause() {
    }

    public ImageChangeCause(ObjectReference fromRef, String imageID) {
        super();
        this.fromRef = fromRef;
        this.imageID = imageID;
    }

    /**
     * ImageChangeCause contains information about the image that triggered a build
     */
    @JsonProperty("fromRef")
    public ObjectReference getFromRef() {
        return fromRef;
    }

    /**
     * ImageChangeCause contains information about the image that triggered a build
     */
    @JsonProperty("fromRef")
    public void setFromRef(ObjectReference fromRef) {
        this.fromRef = fromRef;
    }

    /**
     * imageID is the ID of the image that triggered a new build.
     */
    @JsonProperty("imageID")
    public String getImageID() {
        return imageID;
    }

    /**
     * imageID is the ID of the image that triggered a new build.
     */
    @JsonProperty("imageID")
    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    @JsonIgnore
    public ImageChangeCauseBuilder edit() {
        return new ImageChangeCauseBuilder(this);
    }

    @JsonIgnore
    public ImageChangeCauseBuilder toBuilder() {
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
        if (!(o instanceof ImageChangeCause)) {
            return false;
        }
        ImageChangeCause other = (ImageChangeCause) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$fromRef = this.getFromRef();
        Object other$fromRef = other.getFromRef();
        if (this$fromRef == null ? other$fromRef != null : !this$fromRef.equals(other$fromRef)) {
            return false;
        }
        Object this$imageID = this.getImageID();
        Object other$imageID = other.getImageID();
        if (this$imageID == null ? other$imageID != null : !this$imageID.equals(other$imageID)) {
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
        return other instanceof ImageChangeCause;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $fromRef = this.getFromRef();
        result = result * prime + ($fromRef == null ? 43 : $fromRef.hashCode());
        Object $imageID = this.getImageID();
        result = result * prime + ($imageID == null ? 43 : $imageID.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ImageChangeCause(" + "fromRef=" + this.getFromRef() + ", imageID=" + this.getImageID() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
