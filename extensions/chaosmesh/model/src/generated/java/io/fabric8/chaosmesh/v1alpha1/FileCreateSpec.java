
package io.fabric8.chaosmesh.v1alpha1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dir-name",
    "file-name"
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
public class FileCreateSpec implements Editable<FileCreateSpecBuilder>, KubernetesResource
{

    @JsonProperty("dir-name")
    private String dirName;
    @JsonProperty("file-name")
    private String fileName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FileCreateSpec() {
    }

    public FileCreateSpec(String dirName, String fileName) {
        super();
        this.dirName = dirName;
        this.fileName = fileName;
    }

    /**
     * DirName is the directory name to create or delete.
     */
    @JsonProperty("dir-name")
    public String getDirName() {
        return dirName;
    }

    /**
     * DirName is the directory name to create or delete.
     */
    @JsonProperty("dir-name")
    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    /**
     * FileName is the name of the file to be created, modified, deleted, renamed, or appended.
     */
    @JsonProperty("file-name")
    public String getFileName() {
        return fileName;
    }

    /**
     * FileName is the name of the file to be created, modified, deleted, renamed, or appended.
     */
    @JsonProperty("file-name")
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @JsonIgnore
    public FileCreateSpecBuilder edit() {
        return new FileCreateSpecBuilder(this);
    }

    @JsonIgnore
    public FileCreateSpecBuilder toBuilder() {
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
        if (!(o instanceof FileCreateSpec)) {
            return false;
        }
        FileCreateSpec other = (FileCreateSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$dirName = this.getDirName();
        Object other$dirName = other.getDirName();
        if (this$dirName == null ? other$dirName != null : !this$dirName.equals(other$dirName)) {
            return false;
        }
        Object this$fileName = this.getFileName();
        Object other$fileName = other.getFileName();
        if (this$fileName == null ? other$fileName != null : !this$fileName.equals(other$fileName)) {
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
        return other instanceof FileCreateSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $dirName = this.getDirName();
        result = result * prime + ($dirName == null ? 43 : $dirName.hashCode());
        Object $fileName = this.getFileName();
        result = result * prime + ($fileName == null ? 43 : $fileName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "FileCreateSpec(" + "dirName=" + this.getDirName() + ", fileName=" + this.getFileName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
