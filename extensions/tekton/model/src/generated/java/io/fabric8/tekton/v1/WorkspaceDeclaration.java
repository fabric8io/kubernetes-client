
package io.fabric8.tekton.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * WorkspaceDeclaration is a declaration of a volume that a Task requires.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "description",
    "mountPath",
    "name",
    "optional",
    "readOnly"
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
public class WorkspaceDeclaration implements Editable<WorkspaceDeclarationBuilder>, KubernetesResource
{

    @JsonProperty("description")
    private String description;
    @JsonProperty("mountPath")
    private String mountPath;
    @JsonProperty("name")
    private String name;
    @JsonProperty("optional")
    private Boolean optional;
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WorkspaceDeclaration() {
    }

    public WorkspaceDeclaration(String description, String mountPath, String name, Boolean optional, Boolean readOnly) {
        super();
        this.description = description;
        this.mountPath = mountPath;
        this.name = name;
        this.optional = optional;
        this.readOnly = readOnly;
    }

    /**
     * Description is an optional human readable description of this volume.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Description is an optional human readable description of this volume.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * MountPath overrides the directory that the volume will be made available at.
     */
    @JsonProperty("mountPath")
    public String getMountPath() {
        return mountPath;
    }

    /**
     * MountPath overrides the directory that the volume will be made available at.
     */
    @JsonProperty("mountPath")
    public void setMountPath(String mountPath) {
        this.mountPath = mountPath;
    }

    /**
     * Name is the name by which you can bind the volume at runtime.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name by which you can bind the volume at runtime.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Optional marks a Workspace as not being required in TaskRuns. By default this field is false and so declared workspaces are required.
     */
    @JsonProperty("optional")
    public Boolean getOptional() {
        return optional;
    }

    /**
     * Optional marks a Workspace as not being required in TaskRuns. By default this field is false and so declared workspaces are required.
     */
    @JsonProperty("optional")
    public void setOptional(Boolean optional) {
        this.optional = optional;
    }

    /**
     * ReadOnly dictates whether a mounted volume is writable. By default this field is false and so mounted volumes are writable.
     */
    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    /**
     * ReadOnly dictates whether a mounted volume is writable. By default this field is false and so mounted volumes are writable.
     */
    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    @JsonIgnore
    public WorkspaceDeclarationBuilder edit() {
        return new WorkspaceDeclarationBuilder(this);
    }

    @JsonIgnore
    public WorkspaceDeclarationBuilder toBuilder() {
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

}
