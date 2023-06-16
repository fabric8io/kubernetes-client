
package io.fabric8.kubernetes.api.model.admissionregistration.v1alpha1;

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
    "auditAnnotations",
    "failurePolicy",
    "matchConditions",
    "matchConstraints",
    "paramKind",
    "validations"
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
public class ValidatingAdmissionPolicySpec implements KubernetesResource
{

    @JsonProperty("auditAnnotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AuditAnnotation> auditAnnotations = new ArrayList<AuditAnnotation>();
    @JsonProperty("failurePolicy")
    private String failurePolicy;
    @JsonProperty("matchConditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MatchCondition> matchConditions = new ArrayList<MatchCondition>();
    @JsonProperty("matchConstraints")
    private MatchResources matchConstraints;
    @JsonProperty("paramKind")
    private ParamKind paramKind;
    @JsonProperty("validations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Validation> validations = new ArrayList<Validation>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidatingAdmissionPolicySpec() {
    }

    public ValidatingAdmissionPolicySpec(List<AuditAnnotation> auditAnnotations, String failurePolicy, List<MatchCondition> matchConditions, MatchResources matchConstraints, ParamKind paramKind, List<Validation> validations) {
        super();
        this.auditAnnotations = auditAnnotations;
        this.failurePolicy = failurePolicy;
        this.matchConditions = matchConditions;
        this.matchConstraints = matchConstraints;
        this.paramKind = paramKind;
        this.validations = validations;
    }

    @JsonProperty("auditAnnotations")
    public List<AuditAnnotation> getAuditAnnotations() {
        return auditAnnotations;
    }

    @JsonProperty("auditAnnotations")
    public void setAuditAnnotations(List<AuditAnnotation> auditAnnotations) {
        this.auditAnnotations = auditAnnotations;
    }

    @JsonProperty("failurePolicy")
    public String getFailurePolicy() {
        return failurePolicy;
    }

    @JsonProperty("failurePolicy")
    public void setFailurePolicy(String failurePolicy) {
        this.failurePolicy = failurePolicy;
    }

    @JsonProperty("matchConditions")
    public List<MatchCondition> getMatchConditions() {
        return matchConditions;
    }

    @JsonProperty("matchConditions")
    public void setMatchConditions(List<MatchCondition> matchConditions) {
        this.matchConditions = matchConditions;
    }

    @JsonProperty("matchConstraints")
    public MatchResources getMatchConstraints() {
        return matchConstraints;
    }

    @JsonProperty("matchConstraints")
    public void setMatchConstraints(MatchResources matchConstraints) {
        this.matchConstraints = matchConstraints;
    }

    @JsonProperty("paramKind")
    public ParamKind getParamKind() {
        return paramKind;
    }

    @JsonProperty("paramKind")
    public void setParamKind(ParamKind paramKind) {
        this.paramKind = paramKind;
    }

    @JsonProperty("validations")
    public List<Validation> getValidations() {
        return validations;
    }

    @JsonProperty("validations")
    public void setValidations(List<Validation> validations) {
        this.validations = validations;
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
