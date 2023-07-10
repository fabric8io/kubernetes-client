
package io.fabric8.kubernetes.api.model.authorization.v1beta1;

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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "evaluationError",
    "incomplete",
    "nonResourceRules",
    "resourceRules"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class SubjectRulesReviewStatus implements KubernetesResource
{

    @JsonProperty("evaluationError")
    private String evaluationError;
    @JsonProperty("incomplete")
    private Boolean incomplete;
    @JsonProperty("nonResourceRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NonResourceRule> nonResourceRules = new ArrayList<NonResourceRule>();
    @JsonProperty("resourceRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ResourceRule> resourceRules = new ArrayList<ResourceRule>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SubjectRulesReviewStatus() {
    }

    public SubjectRulesReviewStatus(String evaluationError, Boolean incomplete, List<NonResourceRule> nonResourceRules, List<ResourceRule> resourceRules) {
        super();
        this.evaluationError = evaluationError;
        this.incomplete = incomplete;
        this.nonResourceRules = nonResourceRules;
        this.resourceRules = resourceRules;
    }

    @JsonProperty("evaluationError")
    public String getEvaluationError() {
        return evaluationError;
    }

    @JsonProperty("evaluationError")
    public void setEvaluationError(String evaluationError) {
        this.evaluationError = evaluationError;
    }

    @JsonProperty("incomplete")
    public Boolean getIncomplete() {
        return incomplete;
    }

    @JsonProperty("incomplete")
    public void setIncomplete(Boolean incomplete) {
        this.incomplete = incomplete;
    }

    @JsonProperty("nonResourceRules")
    public List<NonResourceRule> getNonResourceRules() {
        return nonResourceRules;
    }

    @JsonProperty("nonResourceRules")
    public void setNonResourceRules(List<NonResourceRule> nonResourceRules) {
        this.nonResourceRules = nonResourceRules;
    }

    @JsonProperty("resourceRules")
    public List<ResourceRule> getResourceRules() {
        return resourceRules;
    }

    @JsonProperty("resourceRules")
    public void setResourceRules(List<ResourceRule> resourceRules) {
        this.resourceRules = resourceRules;
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
