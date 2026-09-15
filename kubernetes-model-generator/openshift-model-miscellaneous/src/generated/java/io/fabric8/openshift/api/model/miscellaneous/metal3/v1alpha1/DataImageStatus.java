
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
 * DataImageStatus defines the observed state of DataImage.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attachedImage",
    "error",
    "lastReconciled"
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
public class DataImageStatus implements Editable<DataImageStatusBuilder>, KubernetesResource
{

    @JsonProperty("attachedImage")
    private AttachedImageReference attachedImage;
    @JsonProperty("error")
    private DataImageError error;
    @JsonProperty("lastReconciled")
    private String lastReconciled;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DataImageStatus() {
    }

    public DataImageStatus(AttachedImageReference attachedImage, DataImageError error, String lastReconciled) {
        super();
        this.attachedImage = attachedImage;
        this.error = error;
        this.lastReconciled = lastReconciled;
    }

    /**
     * DataImageStatus defines the observed state of DataImage.
     */
    @JsonProperty("attachedImage")
    public AttachedImageReference getAttachedImage() {
        return attachedImage;
    }

    /**
     * DataImageStatus defines the observed state of DataImage.
     */
    @JsonProperty("attachedImage")
    public void setAttachedImage(AttachedImageReference attachedImage) {
        this.attachedImage = attachedImage;
    }

    /**
     * DataImageStatus defines the observed state of DataImage.
     */
    @JsonProperty("error")
    public DataImageError getError() {
        return error;
    }

    /**
     * DataImageStatus defines the observed state of DataImage.
     */
    @JsonProperty("error")
    public void setError(DataImageError error) {
        this.error = error;
    }

    /**
     * DataImageStatus defines the observed state of DataImage.
     */
    @JsonProperty("lastReconciled")
    public String getLastReconciled() {
        return lastReconciled;
    }

    /**
     * DataImageStatus defines the observed state of DataImage.
     */
    @JsonProperty("lastReconciled")
    public void setLastReconciled(String lastReconciled) {
        this.lastReconciled = lastReconciled;
    }

    @JsonIgnore
    public DataImageStatusBuilder edit() {
        return new DataImageStatusBuilder(this);
    }

    @JsonIgnore
    public DataImageStatusBuilder toBuilder() {
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
        if (!(o instanceof DataImageStatus)) {
            return false;
        }
        DataImageStatus other = (DataImageStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$attachedImage = this.getAttachedImage();
        Object other$attachedImage = other.getAttachedImage();
        if (this$attachedImage == null ? other$attachedImage != null : !this$attachedImage.equals(other$attachedImage)) {
            return false;
        }
        Object this$error = this.getError();
        Object other$error = other.getError();
        if (this$error == null ? other$error != null : !this$error.equals(other$error)) {
            return false;
        }
        Object this$lastReconciled = this.getLastReconciled();
        Object other$lastReconciled = other.getLastReconciled();
        if (this$lastReconciled == null ? other$lastReconciled != null : !this$lastReconciled.equals(other$lastReconciled)) {
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
        return other instanceof DataImageStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $attachedImage = this.getAttachedImage();
        result = result * prime + ($attachedImage == null ? 43 : $attachedImage.hashCode());
        Object $error = this.getError();
        result = result * prime + ($error == null ? 43 : $error.hashCode());
        Object $lastReconciled = this.getLastReconciled();
        result = result * prime + ($lastReconciled == null ? 43 : $lastReconciled.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DataImageStatus(" + "attachedImage=" + this.getAttachedImage() + ", error=" + this.getError() + ", lastReconciled=" + this.getLastReconciled() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
