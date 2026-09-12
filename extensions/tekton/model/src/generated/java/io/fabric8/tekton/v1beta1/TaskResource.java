
package io.fabric8.tekton.v1beta1;

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

/**
 * TaskResource defines an input or output Resource declared as a requirement by a Task. The Name field will be used to refer to these Resources within the Task definition, and when provided as an Input, the Name will be the path to the volume mounted containing this Resource as an input (e.g. an input Resource named `workspace` will be mounted at `/workspace`).<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "description",
    "name",
    "optional",
    "targetPath",
    "type"
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
public class TaskResource implements Editable<TaskResourceBuilder>, KubernetesResource
{

    @JsonProperty("description")
    private String description;
    @JsonProperty("name")
    private String name;
    @JsonProperty("optional")
    private Boolean optional;
    @JsonProperty("targetPath")
    private String targetPath;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TaskResource() {
    }

    public TaskResource(String description, String name, Boolean optional, String targetPath, String type) {
        super();
        this.description = description;
        this.name = name;
        this.optional = optional;
        this.targetPath = targetPath;
        this.type = type;
    }

    /**
     * Description is a user-facing description of the declared resource that may be used to populate a UI.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Description is a user-facing description of the declared resource that may be used to populate a UI.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Name declares the name by which a resource is referenced in the definition. Resources may be referenced by name in the definition of a Task's steps.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name declares the name by which a resource is referenced in the definition. Resources may be referenced by name in the definition of a Task's steps.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Optional declares the resource as optional. By default optional is set to false which makes a resource required. optional: true - the resource is considered optional optional: false - the resource is considered required (equivalent of not specifying it)
     */
    @JsonProperty("optional")
    public Boolean getOptional() {
        return optional;
    }

    /**
     * Optional declares the resource as optional. By default optional is set to false which makes a resource required. optional: true - the resource is considered optional optional: false - the resource is considered required (equivalent of not specifying it)
     */
    @JsonProperty("optional")
    public void setOptional(Boolean optional) {
        this.optional = optional;
    }

    /**
     * TargetPath is the path in workspace directory where the resource will be copied.
     */
    @JsonProperty("targetPath")
    public String getTargetPath() {
        return targetPath;
    }

    /**
     * TargetPath is the path in workspace directory where the resource will be copied.
     */
    @JsonProperty("targetPath")
    public void setTargetPath(String targetPath) {
        this.targetPath = targetPath;
    }

    /**
     * Type is the type of this resource;
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type is the type of this resource;
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public TaskResourceBuilder edit() {
        return new TaskResourceBuilder(this);
    }

    @JsonIgnore
    public TaskResourceBuilder toBuilder() {
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
        if (!(o instanceof TaskResource)) {
            return false;
        }
        TaskResource other = (TaskResource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$description = this.getDescription();
        Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$optional = this.getOptional();
        Object other$optional = other.getOptional();
        if (this$optional == null ? other$optional != null : !this$optional.equals(other$optional)) {
            return false;
        }
        Object this$targetPath = this.getTargetPath();
        Object other$targetPath = other.getTargetPath();
        if (this$targetPath == null ? other$targetPath != null : !this$targetPath.equals(other$targetPath)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof TaskResource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $description = this.getDescription();
        result = result * prime + ($description == null ? 43 : $description.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $optional = this.getOptional();
        result = result * prime + ($optional == null ? 43 : $optional.hashCode());
        Object $targetPath = this.getTargetPath();
        result = result * prime + ($targetPath == null ? 43 : $targetPath.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TaskResource(" + "description=" + this.getDescription() + ", name=" + this.getName() + ", optional=" + this.getOptional() + ", targetPath=" + this.getTargetPath() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
