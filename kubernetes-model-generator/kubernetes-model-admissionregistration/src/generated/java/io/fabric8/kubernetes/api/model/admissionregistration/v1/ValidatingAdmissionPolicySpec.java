
package io.fabric8.kubernetes.api.model.admissionregistration.v1;

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
    "auditAnnotations",
    "failurePolicy",
    "matchConditions",
    "matchConstraints",
    "paramKind",
    "validations",
    "variables"
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
public class ValidatingAdmissionPolicySpec implements Editable<ValidatingAdmissionPolicySpecBuilder> , KubernetesResource
{

    @JsonProperty("auditAnnotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AuditAnnotation> auditAnnotations = new ArrayList<>();
    @JsonProperty("failurePolicy")
    private String failurePolicy;
    @JsonProperty("matchConditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MatchCondition> matchConditions = new ArrayList<>();
    @JsonProperty("matchConstraints")
    private MatchResources matchConstraints;
    @JsonProperty("paramKind")
    private ParamKind paramKind;
    @JsonProperty("validations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Validation> validations = new ArrayList<>();
    @JsonProperty("variables")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Variable> variables = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidatingAdmissionPolicySpec() {
    }

    public ValidatingAdmissionPolicySpec(List<AuditAnnotation> auditAnnotations, String failurePolicy, List<MatchCondition> matchConditions, MatchResources matchConstraints, ParamKind paramKind, List<Validation> validations, List<Variable> variables) {
        super();
        this.auditAnnotations = auditAnnotations;
        this.failurePolicy = failurePolicy;
        this.matchConditions = matchConditions;
        this.matchConstraints = matchConstraints;
        this.paramKind = paramKind;
        this.validations = validations;
        this.variables = variables;
    }

    @JsonProperty("auditAnnotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Validation> getValidations() {
        return validations;
    }

    @JsonProperty("validations")
    public void setValidations(List<Validation> validations) {
        this.validations = validations;
    }

    @JsonProperty("variables")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Variable> getVariables() {
        return variables;
    }

    @JsonProperty("variables")
    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }

    @JsonIgnore
    public ValidatingAdmissionPolicySpecBuilder edit() {
        return new ValidatingAdmissionPolicySpecBuilder(this);
    }

    @JsonIgnore
    public ValidatingAdmissionPolicySpecBuilder toBuilder() {
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
