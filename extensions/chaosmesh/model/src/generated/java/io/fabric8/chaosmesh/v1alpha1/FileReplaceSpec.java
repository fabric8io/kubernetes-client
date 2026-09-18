
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
    "dest-string",
    "file-name",
    "line",
    "origin-string"
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
public class FileReplaceSpec implements Editable<FileReplaceSpecBuilder>, KubernetesResource
{

    @JsonProperty("dest-string")
    private String destString;
    @JsonProperty("file-name")
    private String fileName;
    @JsonProperty("line")
    private Integer line;
    @JsonProperty("origin-string")
    private String originString;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FileReplaceSpec() {
    }

    public FileReplaceSpec(String destString, String fileName, Integer line, String originString) {
        super();
        this.destString = destString;
        this.fileName = fileName;
        this.line = line;
        this.originString = originString;
    }

    /**
     * DestStr is the destination string of the file.
     */
    @JsonProperty("dest-string")
    public String getDestString() {
        return destString;
    }

    /**
     * DestStr is the destination string of the file.
     */
    @JsonProperty("dest-string")
    public void setDestString(String destString) {
        this.destString = destString;
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

    /**
     * Line is the line number of the file to be replaced.
     */
    @JsonProperty("line")
    public Integer getLine() {
        return line;
    }

    /**
     * Line is the line number of the file to be replaced.
     */
    @JsonProperty("line")
    public void setLine(Integer line) {
        this.line = line;
    }

    /**
     * OriginStr is the origin string of the file.
     */
    @JsonProperty("origin-string")
    public String getOriginString() {
        return originString;
    }

    /**
     * OriginStr is the origin string of the file.
     */
    @JsonProperty("origin-string")
    public void setOriginString(String originString) {
        this.originString = originString;
    }

    @JsonIgnore
    public FileReplaceSpecBuilder edit() {
        return new FileReplaceSpecBuilder(this);
    }

    @JsonIgnore
    public FileReplaceSpecBuilder toBuilder() {
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
        if (!(o instanceof FileReplaceSpec)) {
            return false;
        }
        FileReplaceSpec other = (FileReplaceSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$destString = this.getDestString();
        Object other$destString = other.getDestString();
        if (this$destString == null ? other$destString != null : !this$destString.equals(other$destString)) {
            return false;
        }
        Object this$fileName = this.getFileName();
        Object other$fileName = other.getFileName();
        if (this$fileName == null ? other$fileName != null : !this$fileName.equals(other$fileName)) {
            return false;
        }
        Object this$line = this.getLine();
        Object other$line = other.getLine();
        if (this$line == null ? other$line != null : !this$line.equals(other$line)) {
            return false;
        }
        Object this$originString = this.getOriginString();
        Object other$originString = other.getOriginString();
        if (this$originString == null ? other$originString != null : !this$originString.equals(other$originString)) {
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
        return other instanceof FileReplaceSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $destString = this.getDestString();
        result = result * prime + ($destString == null ? 43 : $destString.hashCode());
        Object $fileName = this.getFileName();
        result = result * prime + ($fileName == null ? 43 : $fileName.hashCode());
        Object $line = this.getLine();
        result = result * prime + ($line == null ? 43 : $line.hashCode());
        Object $originString = this.getOriginString();
        result = result * prime + ($originString == null ? 43 : $originString.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "FileReplaceSpec(" + "destString=" + this.getDestString() + ", fileName=" + this.getFileName() + ", line=" + this.getLine() + ", originString=" + this.getOriginString() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
