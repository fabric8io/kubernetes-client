
package io.fabric8.knative.pkg.apis;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Details",
    "Level",
    "Message",
    "Paths",
    "errors"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class FieldError implements Editable<FieldErrorBuilder> , KubernetesResource
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
    @JsonProperty("errors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.knative.pkg.apis.FieldError> errors = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public FieldError() {
    }

    public FieldError(String details, Integer level, String message, List<String> paths, List<io.fabric8.knative.pkg.apis.FieldError> errors) {
        super();
        this.details = details;
        this.level = level;
        this.message = message;
        this.paths = paths;
        this.errors = errors;
    }

    @JsonProperty("Details")
    public String getDetails() {
        return details;
    }

    @JsonProperty("Details")
    public void setDetails(String details) {
        this.details = details;
    }

    @JsonProperty("Level")
    public Integer getLevel() {
        return level;
    }

    @JsonProperty("Level")
    public void setLevel(Integer level) {
        this.level = level;
    }

    @JsonProperty("Message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("Message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("Paths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPaths() {
        return paths;
    }

    @JsonProperty("Paths")
    public void setPaths(List<String> paths) {
        this.paths = paths;
    }

    @JsonProperty("errors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<io.fabric8.knative.pkg.apis.FieldError> getErrors() {
        return errors;
    }

    @JsonProperty("errors")
    public void setErrors(List<io.fabric8.knative.pkg.apis.FieldError> errors) {
        this.errors = errors;
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
