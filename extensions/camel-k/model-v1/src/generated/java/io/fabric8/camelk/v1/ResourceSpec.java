
package io.fabric8.camelk.v1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "compression",
    "content",
    "contentKey",
    "contentRef",
    "contentType",
    "mountPath",
    "name",
    "path",
    "rawContent",
    "type"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class ResourceSpec implements KubernetesResource
{

    @JsonProperty("compression")
    private Boolean compression;
    @JsonProperty("content")
    private String content;
    @JsonProperty("contentKey")
    private String contentKey;
    @JsonProperty("contentRef")
    private String contentRef;
    @JsonProperty("contentType")
    private String contentType;
    @JsonProperty("mountPath")
    private String mountPath;
    @JsonProperty("name")
    private String name;
    @JsonProperty("path")
    private String path;
    @JsonProperty("rawContent")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String rawContent;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResourceSpec() {
    }

    /**
     * 
     * @param path
     * @param contentKey
     * @param mountPath
     * @param name
     * @param compression
     * @param type
     * @param contentType
     * @param content
     * @param contentRef
     * @param rawContent
     */
    public ResourceSpec(Boolean compression, String content, String contentKey, String contentRef, String contentType, String mountPath, String name, String path, String rawContent, String type) {
        super();
        this.compression = compression;
        this.content = content;
        this.contentKey = contentKey;
        this.contentRef = contentRef;
        this.contentType = contentType;
        this.mountPath = mountPath;
        this.name = name;
        this.path = path;
        this.rawContent = rawContent;
        this.type = type;
    }

    @JsonProperty("compression")
    public Boolean getCompression() {
        return compression;
    }

    @JsonProperty("compression")
    public void setCompression(Boolean compression) {
        this.compression = compression;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("contentKey")
    public String getContentKey() {
        return contentKey;
    }

    @JsonProperty("contentKey")
    public void setContentKey(String contentKey) {
        this.contentKey = contentKey;
    }

    @JsonProperty("contentRef")
    public String getContentRef() {
        return contentRef;
    }

    @JsonProperty("contentRef")
    public void setContentRef(String contentRef) {
        this.contentRef = contentRef;
    }

    @JsonProperty("contentType")
    public String getContentType() {
        return contentType;
    }

    @JsonProperty("contentType")
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @JsonProperty("mountPath")
    public String getMountPath() {
        return mountPath;
    }

    @JsonProperty("mountPath")
    public void setMountPath(String mountPath) {
        this.mountPath = mountPath;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("rawContent")
    public String getRawContent() {
        return rawContent;
    }

    @JsonProperty("rawContent")
    public void setRawContent(String rawContent) {
        this.rawContent = rawContent;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
