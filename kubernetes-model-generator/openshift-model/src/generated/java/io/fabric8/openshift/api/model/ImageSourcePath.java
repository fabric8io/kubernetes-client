
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
 * ImageSourcePath describes a path to be copied from a source image and its destination within the build directory.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "destinationDir",
    "sourcePath"
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
public class ImageSourcePath implements Editable<ImageSourcePathBuilder>, KubernetesResource
{

    @JsonProperty("destinationDir")
    private String destinationDir;
    @JsonProperty("sourcePath")
    private String sourcePath;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageSourcePath() {
    }

    public ImageSourcePath(String destinationDir, String sourcePath) {
        super();
        this.destinationDir = destinationDir;
        this.sourcePath = sourcePath;
    }

    /**
     * destinationDir is the relative directory within the build directory where files copied from the image are placed.
     */
    @JsonProperty("destinationDir")
    public String getDestinationDir() {
        return destinationDir;
    }

    /**
     * destinationDir is the relative directory within the build directory where files copied from the image are placed.
     */
    @JsonProperty("destinationDir")
    public void setDestinationDir(String destinationDir) {
        this.destinationDir = destinationDir;
    }

    /**
     * sourcePath is the absolute path of the file or directory inside the image to copy to the build directory.  If the source path ends in /. then the content of the directory will be copied, but the directory itself will not be created at the destination.
     */
    @JsonProperty("sourcePath")
    public String getSourcePath() {
        return sourcePath;
    }

    /**
     * sourcePath is the absolute path of the file or directory inside the image to copy to the build directory.  If the source path ends in /. then the content of the directory will be copied, but the directory itself will not be created at the destination.
     */
    @JsonProperty("sourcePath")
    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    @JsonIgnore
    public ImageSourcePathBuilder edit() {
        return new ImageSourcePathBuilder(this);
    }

    @JsonIgnore
    public ImageSourcePathBuilder toBuilder() {
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
        if (!(o instanceof ImageSourcePath)) {
            return false;
        }
        ImageSourcePath other = (ImageSourcePath) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$destinationDir = this.getDestinationDir();
        Object other$destinationDir = other.getDestinationDir();
        if (this$destinationDir == null ? other$destinationDir != null : !this$destinationDir.equals(other$destinationDir)) {
            return false;
        }
        Object this$sourcePath = this.getSourcePath();
        Object other$sourcePath = other.getSourcePath();
        if (this$sourcePath == null ? other$sourcePath != null : !this$sourcePath.equals(other$sourcePath)) {
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
        return other instanceof ImageSourcePath;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $destinationDir = this.getDestinationDir();
        result = result * prime + ($destinationDir == null ? 43 : $destinationDir.hashCode());
        Object $sourcePath = this.getSourcePath();
        result = result * prime + ($sourcePath == null ? 43 : $sourcePath.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ImageSourcePath(" + "destinationDir=" + this.getDestinationDir() + ", sourcePath=" + this.getSourcePath() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
