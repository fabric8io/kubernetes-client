
package io.fabric8.kubernetes.api.model.admissionregistration.v1beta1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ValidatingAdmissionPolicySpec is the specification of the desired behavior of the AdmissionPolicy.
 */
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
public class ValidatingAdmissionPolicySpec implements Editable<ValidatingAdmissionPolicySpecBuilder>, KubernetesResource
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

    /**
     * auditAnnotations contains CEL expressions which are used to produce audit annotations for the audit event of the API request. validations and auditAnnotations may not both be empty; a least one of validations or auditAnnotations is required.
     */
    @JsonProperty("auditAnnotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AuditAnnotation> getAuditAnnotations() {
        return auditAnnotations;
    }

    /**
     * auditAnnotations contains CEL expressions which are used to produce audit annotations for the audit event of the API request. validations and auditAnnotations may not both be empty; a least one of validations or auditAnnotations is required.
     */
    @JsonProperty("auditAnnotations")
    public void setAuditAnnotations(List<AuditAnnotation> auditAnnotations) {
        this.auditAnnotations = auditAnnotations;
    }

    /**
     * failurePolicy defines how to handle failures for the admission policy. Failures can occur from CEL expression parse errors, type check errors, runtime errors and invalid or mis-configured policy definitions or bindings.<br><p> <br><p> A policy is invalid if spec.paramKind refers to a non-existent Kind. A binding is invalid if spec.paramRef.name refers to a non-existent resource.<br><p> <br><p> failurePolicy does not define how validations that evaluate to false are handled.<br><p> <br><p> When failurePolicy is set to Fail, ValidatingAdmissionPolicyBinding validationActions define how failures are enforced.<br><p> <br><p> Allowed values are Ignore or Fail. Defaults to Fail.
     */
    @JsonProperty("failurePolicy")
    public String getFailurePolicy() {
        return failurePolicy;
    }

    /**
     * failurePolicy defines how to handle failures for the admission policy. Failures can occur from CEL expression parse errors, type check errors, runtime errors and invalid or mis-configured policy definitions or bindings.<br><p> <br><p> A policy is invalid if spec.paramKind refers to a non-existent Kind. A binding is invalid if spec.paramRef.name refers to a non-existent resource.<br><p> <br><p> failurePolicy does not define how validations that evaluate to false are handled.<br><p> <br><p> When failurePolicy is set to Fail, ValidatingAdmissionPolicyBinding validationActions define how failures are enforced.<br><p> <br><p> Allowed values are Ignore or Fail. Defaults to Fail.
     */
    @JsonProperty("failurePolicy")
    public void setFailurePolicy(String failurePolicy) {
        this.failurePolicy = failurePolicy;
    }

    /**
     * MatchConditions is a list of conditions that must be met for a request to be validated. Match conditions filter requests that have already been matched by the rules, namespaceSelector, and objectSelector. An empty list of matchConditions matches all requests. There are a maximum of 64 match conditions allowed.<br><p> <br><p> If a parameter object is provided, it can be accessed via the `params` handle in the same manner as validation expressions.<br><p> <br><p> The exact matching logic is (in order):<br><p>   1. If ANY matchCondition evaluates to FALSE, the policy is skipped.<br><p>   2. If ALL matchConditions evaluate to TRUE, the policy is evaluated.<br><p>   3. If any matchCondition evaluates to an error (but none are FALSE):<br><p>      - If failurePolicy=Fail, reject the request<br><p>      - If failurePolicy=Ignore, the policy is skipped
     */
    @JsonProperty("matchConditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MatchCondition> getMatchConditions() {
        return matchConditions;
    }

    /**
     * MatchConditions is a list of conditions that must be met for a request to be validated. Match conditions filter requests that have already been matched by the rules, namespaceSelector, and objectSelector. An empty list of matchConditions matches all requests. There are a maximum of 64 match conditions allowed.<br><p> <br><p> If a parameter object is provided, it can be accessed via the `params` handle in the same manner as validation expressions.<br><p> <br><p> The exact matching logic is (in order):<br><p>   1. If ANY matchCondition evaluates to FALSE, the policy is skipped.<br><p>   2. If ALL matchConditions evaluate to TRUE, the policy is evaluated.<br><p>   3. If any matchCondition evaluates to an error (but none are FALSE):<br><p>      - If failurePolicy=Fail, reject the request<br><p>      - If failurePolicy=Ignore, the policy is skipped
     */
    @JsonProperty("matchConditions")
    public void setMatchConditions(List<MatchCondition> matchConditions) {
        this.matchConditions = matchConditions;
    }

    /**
     * ValidatingAdmissionPolicySpec is the specification of the desired behavior of the AdmissionPolicy.
     */
    @JsonProperty("matchConstraints")
    public MatchResources getMatchConstraints() {
        return matchConstraints;
    }

    /**
     * ValidatingAdmissionPolicySpec is the specification of the desired behavior of the AdmissionPolicy.
     */
    @JsonProperty("matchConstraints")
    public void setMatchConstraints(MatchResources matchConstraints) {
        this.matchConstraints = matchConstraints;
    }

    /**
     * ValidatingAdmissionPolicySpec is the specification of the desired behavior of the AdmissionPolicy.
     */
    @JsonProperty("paramKind")
    public ParamKind getParamKind() {
        return paramKind;
    }

    /**
     * ValidatingAdmissionPolicySpec is the specification of the desired behavior of the AdmissionPolicy.
     */
    @JsonProperty("paramKind")
    public void setParamKind(ParamKind paramKind) {
        this.paramKind = paramKind;
    }

    /**
     * Validations contain CEL expressions which is used to apply the validation. Validations and AuditAnnotations may not both be empty; a minimum of one Validations or AuditAnnotations is required.
     */
    @JsonProperty("validations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Validation> getValidations() {
        return validations;
    }

    /**
     * Validations contain CEL expressions which is used to apply the validation. Validations and AuditAnnotations may not both be empty; a minimum of one Validations or AuditAnnotations is required.
     */
    @JsonProperty("validations")
    public void setValidations(List<Validation> validations) {
        this.validations = validations;
    }

    /**
     * Variables contain definitions of variables that can be used in composition of other expressions. Each variable is defined as a named CEL expression. The variables defined here will be available under `variables` in other expressions of the policy except MatchConditions because MatchConditions are evaluated before the rest of the policy.<br><p> <br><p> The expression of a variable can refer to other variables defined earlier in the list but not those after. Thus, Variables must be sorted by the order of first appearance and acyclic.
     */
    @JsonProperty("variables")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Variable> getVariables() {
        return variables;
    }

    /**
     * Variables contain definitions of variables that can be used in composition of other expressions. Each variable is defined as a named CEL expression. The variables defined here will be available under `variables` in other expressions of the policy except MatchConditions because MatchConditions are evaluated before the rest of the policy.<br><p> <br><p> The expression of a variable can refer to other variables defined earlier in the list but not those after. Thus, Variables must be sorted by the order of first appearance and acyclic.
     */
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
