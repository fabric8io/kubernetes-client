
package io.fabric8.kubernetes.api.model.admissionregistration.v1;

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
 * ValidatingAdmissionPolicyBindingSpec is the specification of the ValidatingAdmissionPolicyBinding.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "matchResources",
    "paramRef",
    "policyName",
    "validationActions"
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
public class ValidatingAdmissionPolicyBindingSpec implements Editable<ValidatingAdmissionPolicyBindingSpecBuilder>, KubernetesResource
{

    @JsonProperty("matchResources")
    private MatchResources matchResources;
    @JsonProperty("paramRef")
    private ParamRef paramRef;
    @JsonProperty("policyName")
    private String policyName;
    @JsonProperty("validationActions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> validationActions = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ValidatingAdmissionPolicyBindingSpec() {
    }

    public ValidatingAdmissionPolicyBindingSpec(MatchResources matchResources, ParamRef paramRef, String policyName, List<String> validationActions) {
        super();
        this.matchResources = matchResources;
        this.paramRef = paramRef;
        this.policyName = policyName;
        this.validationActions = validationActions;
    }

    /**
     * ValidatingAdmissionPolicyBindingSpec is the specification of the ValidatingAdmissionPolicyBinding.
     */
    @JsonProperty("matchResources")
    public MatchResources getMatchResources() {
        return matchResources;
    }

    /**
     * ValidatingAdmissionPolicyBindingSpec is the specification of the ValidatingAdmissionPolicyBinding.
     */
    @JsonProperty("matchResources")
    public void setMatchResources(MatchResources matchResources) {
        this.matchResources = matchResources;
    }

    /**
     * ValidatingAdmissionPolicyBindingSpec is the specification of the ValidatingAdmissionPolicyBinding.
     */
    @JsonProperty("paramRef")
    public ParamRef getParamRef() {
        return paramRef;
    }

    /**
     * ValidatingAdmissionPolicyBindingSpec is the specification of the ValidatingAdmissionPolicyBinding.
     */
    @JsonProperty("paramRef")
    public void setParamRef(ParamRef paramRef) {
        this.paramRef = paramRef;
    }

    /**
     * policyName references a ValidatingAdmissionPolicy name which the ValidatingAdmissionPolicyBinding binds to. If the referenced resource does not exist, this binding is considered invalid and will be ignored Required.
     */
    @JsonProperty("policyName")
    public String getPolicyName() {
        return policyName;
    }

    /**
     * policyName references a ValidatingAdmissionPolicy name which the ValidatingAdmissionPolicyBinding binds to. If the referenced resource does not exist, this binding is considered invalid and will be ignored Required.
     */
    @JsonProperty("policyName")
    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    /**
     * validationActions declares how Validations of the referenced ValidatingAdmissionPolicy are enforced. If a validation evaluates to false it is always enforced according to these actions.<br><p> <br><p> Failures defined by the ValidatingAdmissionPolicy's FailurePolicy are enforced according to these actions only if the FailurePolicy is set to Fail, otherwise the failures are ignored. This includes compilation errors, runtime errors and misconfigurations of the policy.<br><p> <br><p> validationActions is declared as a set of action values. Order does not matter. validationActions may not contain duplicates of the same action.<br><p> <br><p> The supported actions values are:<br><p> <br><p> "Deny" specifies that a validation failure results in a denied request.<br><p> <br><p> "Warn" specifies that a validation failure is reported to the request client in HTTP Warning headers, with a warning code of 299. Warnings can be sent both for allowed or denied admission responses.<br><p> <br><p> "Audit" specifies that a validation failure is included in the published audit event for the request. The audit event will contain a `validation.policy.admission.k8s.io/validation_failure` audit annotation with a value containing the details of the validation failures, formatted as a JSON list of objects, each with the following fields: - message: The validation failure message string - policy: The resource name of the ValidatingAdmissionPolicy - binding: The resource name of the ValidatingAdmissionPolicyBinding - expressionIndex: The index of the failed validations in the ValidatingAdmissionPolicy - validationActions: The enforcement actions enacted for the validation failure Example audit annotation: `"validation.policy.admission.k8s.io/validation_failure": "[{\"message\": \"Invalid value\", {\"policy\": \"policy.example.com\", {\"binding\": \"policybinding.example.com\", {\"expressionIndex\": \"1\", {\"validationActions\": [\"Audit\"]}]"`<br><p> <br><p> Clients should expect to handle additional values by ignoring any values not recognized.<br><p> <br><p> "Deny" and "Warn" may not be used together since this combination needlessly duplicates the validation failure both in the API response body and the HTTP warning headers.<br><p> <br><p> Required.
     */
    @JsonProperty("validationActions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getValidationActions() {
        return validationActions;
    }

    /**
     * validationActions declares how Validations of the referenced ValidatingAdmissionPolicy are enforced. If a validation evaluates to false it is always enforced according to these actions.<br><p> <br><p> Failures defined by the ValidatingAdmissionPolicy's FailurePolicy are enforced according to these actions only if the FailurePolicy is set to Fail, otherwise the failures are ignored. This includes compilation errors, runtime errors and misconfigurations of the policy.<br><p> <br><p> validationActions is declared as a set of action values. Order does not matter. validationActions may not contain duplicates of the same action.<br><p> <br><p> The supported actions values are:<br><p> <br><p> "Deny" specifies that a validation failure results in a denied request.<br><p> <br><p> "Warn" specifies that a validation failure is reported to the request client in HTTP Warning headers, with a warning code of 299. Warnings can be sent both for allowed or denied admission responses.<br><p> <br><p> "Audit" specifies that a validation failure is included in the published audit event for the request. The audit event will contain a `validation.policy.admission.k8s.io/validation_failure` audit annotation with a value containing the details of the validation failures, formatted as a JSON list of objects, each with the following fields: - message: The validation failure message string - policy: The resource name of the ValidatingAdmissionPolicy - binding: The resource name of the ValidatingAdmissionPolicyBinding - expressionIndex: The index of the failed validations in the ValidatingAdmissionPolicy - validationActions: The enforcement actions enacted for the validation failure Example audit annotation: `"validation.policy.admission.k8s.io/validation_failure": "[{\"message\": \"Invalid value\", {\"policy\": \"policy.example.com\", {\"binding\": \"policybinding.example.com\", {\"expressionIndex\": \"1\", {\"validationActions\": [\"Audit\"]}]"`<br><p> <br><p> Clients should expect to handle additional values by ignoring any values not recognized.<br><p> <br><p> "Deny" and "Warn" may not be used together since this combination needlessly duplicates the validation failure both in the API response body and the HTTP warning headers.<br><p> <br><p> Required.
     */
    @JsonProperty("validationActions")
    public void setValidationActions(List<String> validationActions) {
        this.validationActions = validationActions;
    }

    @JsonIgnore
    public ValidatingAdmissionPolicyBindingSpecBuilder edit() {
        return new ValidatingAdmissionPolicyBindingSpecBuilder(this);
    }

    @JsonIgnore
    public ValidatingAdmissionPolicyBindingSpecBuilder toBuilder() {
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
        if (!(o instanceof ValidatingAdmissionPolicyBindingSpec)) {
            return false;
        }
        ValidatingAdmissionPolicyBindingSpec other = (ValidatingAdmissionPolicyBindingSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$matchResources = this.getMatchResources();
        Object other$matchResources = other.getMatchResources();
        if (this$matchResources == null ? other$matchResources != null : !this$matchResources.equals(other$matchResources)) {
            return false;
        }
        Object this$paramRef = this.getParamRef();
        Object other$paramRef = other.getParamRef();
        if (this$paramRef == null ? other$paramRef != null : !this$paramRef.equals(other$paramRef)) {
            return false;
        }
        Object this$policyName = this.getPolicyName();
        Object other$policyName = other.getPolicyName();
        if (this$policyName == null ? other$policyName != null : !this$policyName.equals(other$policyName)) {
            return false;
        }
        Object this$validationActions = this.getValidationActions();
        Object other$validationActions = other.getValidationActions();
        if (this$validationActions == null ? other$validationActions != null : !this$validationActions.equals(other$validationActions)) {
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
        return other instanceof ValidatingAdmissionPolicyBindingSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $matchResources = this.getMatchResources();
        result = result * prime + ($matchResources == null ? 43 : $matchResources.hashCode());
        Object $paramRef = this.getParamRef();
        result = result * prime + ($paramRef == null ? 43 : $paramRef.hashCode());
        Object $policyName = this.getPolicyName();
        result = result * prime + ($policyName == null ? 43 : $policyName.hashCode());
        Object $validationActions = this.getValidationActions();
        result = result * prime + ($validationActions == null ? 43 : $validationActions.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ValidatingAdmissionPolicyBindingSpec(" + "matchResources=" + this.getMatchResources() + ", paramRef=" + this.getParamRef() + ", policyName=" + this.getPolicyName() + ", validationActions=" + this.getValidationActions() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
