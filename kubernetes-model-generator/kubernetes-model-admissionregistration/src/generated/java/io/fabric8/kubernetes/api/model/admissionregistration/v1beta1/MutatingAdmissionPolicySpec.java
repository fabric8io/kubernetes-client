
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
 * MutatingAdmissionPolicySpec is the specification of the desired behavior of the admission policy.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "failurePolicy",
    "matchConditions",
    "matchConstraints",
    "mutations",
    "paramKind",
    "reinvocationPolicy",
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
public class MutatingAdmissionPolicySpec implements Editable<MutatingAdmissionPolicySpecBuilder>, KubernetesResource
{

    @JsonProperty("failurePolicy")
    private String failurePolicy;
    @JsonProperty("matchConditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MatchCondition> matchConditions = new ArrayList<>();
    @JsonProperty("matchConstraints")
    private MatchResources matchConstraints;
    @JsonProperty("mutations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Mutation> mutations = new ArrayList<>();
    @JsonProperty("paramKind")
    private ParamKind paramKind;
    @JsonProperty("reinvocationPolicy")
    private String reinvocationPolicy;
    @JsonProperty("variables")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Variable> variables = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MutatingAdmissionPolicySpec() {
    }

    public MutatingAdmissionPolicySpec(String failurePolicy, List<MatchCondition> matchConditions, MatchResources matchConstraints, List<Mutation> mutations, ParamKind paramKind, String reinvocationPolicy, List<Variable> variables) {
        super();
        this.failurePolicy = failurePolicy;
        this.matchConditions = matchConditions;
        this.matchConstraints = matchConstraints;
        this.mutations = mutations;
        this.paramKind = paramKind;
        this.reinvocationPolicy = reinvocationPolicy;
        this.variables = variables;
    }

    /**
     * failurePolicy defines how to handle failures for the admission policy. Failures can occur from CEL expression parse errors, type check errors, runtime errors and invalid or mis-configured policy definitions or bindings.<br><p> <br><p> A policy is invalid if paramKind refers to a non-existent Kind. A binding is invalid if paramRef.name refers to a non-existent resource.<br><p> <br><p> failurePolicy does not define how validations that evaluate to false are handled.<br><p> <br><p> Allowed values are Ignore or Fail. Defaults to Fail.
     */
    @JsonProperty("failurePolicy")
    public String getFailurePolicy() {
        return failurePolicy;
    }

    /**
     * failurePolicy defines how to handle failures for the admission policy. Failures can occur from CEL expression parse errors, type check errors, runtime errors and invalid or mis-configured policy definitions or bindings.<br><p> <br><p> A policy is invalid if paramKind refers to a non-existent Kind. A binding is invalid if paramRef.name refers to a non-existent resource.<br><p> <br><p> failurePolicy does not define how validations that evaluate to false are handled.<br><p> <br><p> Allowed values are Ignore or Fail. Defaults to Fail.
     */
    @JsonProperty("failurePolicy")
    public void setFailurePolicy(String failurePolicy) {
        this.failurePolicy = failurePolicy;
    }

    /**
     * matchConditions is a list of conditions that must be met for a request to be validated. Match conditions filter requests that have already been matched by the matchConstraints. An empty list of matchConditions matches all requests. There are a maximum of 64 match conditions allowed.<br><p> <br><p> If a parameter object is provided, it can be accessed via the `params` handle in the same manner as validation expressions.<br><p> <br><p> The exact matching logic is (in order):<br><p>   1. If ANY matchCondition evaluates to FALSE, the policy is skipped.<br><p>   2. If ALL matchConditions evaluate to TRUE, the policy is evaluated.<br><p>   3. If any matchCondition evaluates to an error (but none are FALSE):<br><p>      - If failurePolicy=Fail, reject the request<br><p>      - If failurePolicy=Ignore, the policy is skipped
     */
    @JsonProperty("matchConditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MatchCondition> getMatchConditions() {
        return matchConditions;
    }

    /**
     * matchConditions is a list of conditions that must be met for a request to be validated. Match conditions filter requests that have already been matched by the matchConstraints. An empty list of matchConditions matches all requests. There are a maximum of 64 match conditions allowed.<br><p> <br><p> If a parameter object is provided, it can be accessed via the `params` handle in the same manner as validation expressions.<br><p> <br><p> The exact matching logic is (in order):<br><p>   1. If ANY matchCondition evaluates to FALSE, the policy is skipped.<br><p>   2. If ALL matchConditions evaluate to TRUE, the policy is evaluated.<br><p>   3. If any matchCondition evaluates to an error (but none are FALSE):<br><p>      - If failurePolicy=Fail, reject the request<br><p>      - If failurePolicy=Ignore, the policy is skipped
     */
    @JsonProperty("matchConditions")
    public void setMatchConditions(List<MatchCondition> matchConditions) {
        this.matchConditions = matchConditions;
    }

    /**
     * MutatingAdmissionPolicySpec is the specification of the desired behavior of the admission policy.
     */
    @JsonProperty("matchConstraints")
    public MatchResources getMatchConstraints() {
        return matchConstraints;
    }

    /**
     * MutatingAdmissionPolicySpec is the specification of the desired behavior of the admission policy.
     */
    @JsonProperty("matchConstraints")
    public void setMatchConstraints(MatchResources matchConstraints) {
        this.matchConstraints = matchConstraints;
    }

    /**
     * mutations contain operations to perform on matching objects. mutations may not be empty; a minimum of one mutation is required. mutations are evaluated in order, and are reinvoked according to the reinvocationPolicy. The mutations of a policy are invoked for each binding of this policy and reinvocation of mutations occurs on a per binding basis.
     */
    @JsonProperty("mutations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Mutation> getMutations() {
        return mutations;
    }

    /**
     * mutations contain operations to perform on matching objects. mutations may not be empty; a minimum of one mutation is required. mutations are evaluated in order, and are reinvoked according to the reinvocationPolicy. The mutations of a policy are invoked for each binding of this policy and reinvocation of mutations occurs on a per binding basis.
     */
    @JsonProperty("mutations")
    public void setMutations(List<Mutation> mutations) {
        this.mutations = mutations;
    }

    /**
     * MutatingAdmissionPolicySpec is the specification of the desired behavior of the admission policy.
     */
    @JsonProperty("paramKind")
    public ParamKind getParamKind() {
        return paramKind;
    }

    /**
     * MutatingAdmissionPolicySpec is the specification of the desired behavior of the admission policy.
     */
    @JsonProperty("paramKind")
    public void setParamKind(ParamKind paramKind) {
        this.paramKind = paramKind;
    }

    /**
     * reinvocationPolicy indicates whether mutations may be called multiple times per MutatingAdmissionPolicyBinding as part of a single admission evaluation. Allowed values are "Never" and "IfNeeded".<br><p> <br><p> Never: These mutations will not be called more than once per binding in a single admission evaluation.<br><p> <br><p> IfNeeded: These mutations may be invoked more than once per binding for a single admission request and there is no guarantee of order with respect to other admission plugins, admission webhooks, bindings of this policy and admission policies.  Mutations are only reinvoked when mutations change the object after this mutation is invoked. Required.
     */
    @JsonProperty("reinvocationPolicy")
    public String getReinvocationPolicy() {
        return reinvocationPolicy;
    }

    /**
     * reinvocationPolicy indicates whether mutations may be called multiple times per MutatingAdmissionPolicyBinding as part of a single admission evaluation. Allowed values are "Never" and "IfNeeded".<br><p> <br><p> Never: These mutations will not be called more than once per binding in a single admission evaluation.<br><p> <br><p> IfNeeded: These mutations may be invoked more than once per binding for a single admission request and there is no guarantee of order with respect to other admission plugins, admission webhooks, bindings of this policy and admission policies.  Mutations are only reinvoked when mutations change the object after this mutation is invoked. Required.
     */
    @JsonProperty("reinvocationPolicy")
    public void setReinvocationPolicy(String reinvocationPolicy) {
        this.reinvocationPolicy = reinvocationPolicy;
    }

    /**
     * variables contain definitions of variables that can be used in composition of other expressions. Each variable is defined as a named CEL expression. The variables defined here will be available under `variables` in other expressions of the policy except matchConditions because matchConditions are evaluated before the rest of the policy.<br><p> <br><p> The expression of a variable can refer to other variables defined earlier in the list but not those after. Thus, variables must be sorted by the order of first appearance and acyclic.
     */
    @JsonProperty("variables")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Variable> getVariables() {
        return variables;
    }

    /**
     * variables contain definitions of variables that can be used in composition of other expressions. Each variable is defined as a named CEL expression. The variables defined here will be available under `variables` in other expressions of the policy except matchConditions because matchConditions are evaluated before the rest of the policy.<br><p> <br><p> The expression of a variable can refer to other variables defined earlier in the list but not those after. Thus, variables must be sorted by the order of first appearance and acyclic.
     */
    @JsonProperty("variables")
    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }

    @JsonIgnore
    public MutatingAdmissionPolicySpecBuilder edit() {
        return new MutatingAdmissionPolicySpecBuilder(this);
    }

    @JsonIgnore
    public MutatingAdmissionPolicySpecBuilder toBuilder() {
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
