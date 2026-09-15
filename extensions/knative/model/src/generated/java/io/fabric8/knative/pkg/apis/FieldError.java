
package io.fabric8.knative.pkg.apis;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * FieldError is used to propagate the context of errors pertaining to specific fields in a manner suitable for use in a recursive walk, so that errors contain the appropriate field context. FieldError methods are non-mutating.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Details",
    "Level",
    "Message",
    "Paths"
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
public class FieldError implements Editable<FieldErrorBuilder>, KubernetesResource
{

    @JsonProperty("Details")
    private String details;
    @JsonProperty("Level")
    private Integer level;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("Paths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> paths = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FieldError() {
    }

    public FieldError(String details, Integer level, String message, List<String> paths) {
        super();
        this.details = details;
        this.level = level;
        this.message = message;
        this.paths = paths;
    }

    /**
     * Details contains an optional longer payload.
     */
    @JsonProperty("Details")
    public String getDetails() {
        return details;
    }

    /**
     * Details contains an optional longer payload.
     */
    @JsonProperty("Details")
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * Level holds the severity of the diagnostic. If empty, this defaults to ErrorLevel.
     */
    @JsonProperty("Level")
    public Integer getLevel() {
        return level;
    }

    /**
     * Level holds the severity of the diagnostic. If empty, this defaults to ErrorLevel.
     */
    @JsonProperty("Level")
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * Message holds the main diagnostic message carried by this FieldError
     */
    @JsonProperty("Message")
    public String getMessage() {
        return message;
    }

    /**
     * Message holds the main diagnostic message carried by this FieldError
     */
    @JsonProperty("Message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Paths holds a list of paths to which this diagnostic pertains
     */
    @JsonProperty("Paths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPaths() {
        return paths;
    }

    /**
     * Paths holds a list of paths to which this diagnostic pertains
     */
    @JsonProperty("Paths")
    public void setPaths(List<String> paths) {
        this.paths = paths;
    }

    @JsonIgnore
    public FieldErrorBuilder edit() {
        return new FieldErrorBuilder(this);
    }

    @JsonIgnore
    public FieldErrorBuilder toBuilder() {
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
        if (!(o instanceof FieldError)) {
            return false;
        }
        FieldError other = (FieldError) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$details = this.getDetails();
        Object other$details = other.getDetails();
        if (this$details == null ? other$details != null : !this$details.equals(other$details)) {
            return false;
        }
        Object this$level = this.getLevel();
        Object other$level = other.getLevel();
        if (this$level == null ? other$level != null : !this$level.equals(other$level)) {
            return false;
        }
        Object this$message = this.getMessage();
        Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) {
            return false;
        }
        Object this$paths = this.getPaths();
        Object other$paths = other.getPaths();
        if (this$paths == null ? other$paths != null : !this$paths.equals(other$paths)) {
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
        return other instanceof FieldError;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $details = this.getDetails();
        result = result * prime + ($details == null ? 43 : $details.hashCode());
        Object $level = this.getLevel();
        result = result * prime + ($level == null ? 43 : $level.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $paths = this.getPaths();
        result = result * prime + ($paths == null ? 43 : $paths.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "FieldError(" + "details=" + this.getDetails() + ", level=" + this.getLevel() + ", message=" + this.getMessage() + ", paths=" + this.getPaths() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
