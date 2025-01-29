
package io.fabric8.chaosmesh.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dest-string",
    "file-name",
    "line",
    "origin-string"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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

}
