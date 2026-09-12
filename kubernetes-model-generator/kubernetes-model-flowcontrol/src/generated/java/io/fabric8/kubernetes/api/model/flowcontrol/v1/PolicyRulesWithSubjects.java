
package io.fabric8.kubernetes.api.model.flowcontrol.v1;

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
 * PolicyRulesWithSubjects prescribes a test that applies to a request to an apiserver. The test considers the subject making the request, the verb being requested, and the resource to be acted upon. This PolicyRulesWithSubjects matches a request if and only if both (a) at least one member of subjects matches the request and (b) at least one member of resourceRules or nonResourceRules matches the request.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nonResourceRules",
    "resourceRules",
    "subjects"
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
public class PolicyRulesWithSubjects implements Editable<PolicyRulesWithSubjectsBuilder>, KubernetesResource
{

    @JsonProperty("nonResourceRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NonResourcePolicyRule> nonResourceRules = new ArrayList<>();
    @JsonProperty("resourceRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ResourcePolicyRule> resourceRules = new ArrayList<>();
    @JsonProperty("subjects")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Subject> subjects = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PolicyRulesWithSubjects() {
    }

    public PolicyRulesWithSubjects(List<NonResourcePolicyRule> nonResourceRules, List<ResourcePolicyRule> resourceRules, List<Subject> subjects) {
        super();
        this.nonResourceRules = nonResourceRules;
        this.resourceRules = resourceRules;
        this.subjects = subjects;
    }

    /**
     * `nonResourceRules` is a list of NonResourcePolicyRules that identify matching requests according to their verb and the target non-resource URL.
     */
    @JsonProperty("nonResourceRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NonResourcePolicyRule> getNonResourceRules() {
        return nonResourceRules;
    }

    /**
     * `nonResourceRules` is a list of NonResourcePolicyRules that identify matching requests according to their verb and the target non-resource URL.
     */
    @JsonProperty("nonResourceRules")
    public void setNonResourceRules(List<NonResourcePolicyRule> nonResourceRules) {
        this.nonResourceRules = nonResourceRules;
    }

    /**
     * `resourceRules` is a slice of ResourcePolicyRules that identify matching requests according to their verb and the target resource. At least one of `resourceRules` and `nonResourceRules` has to be non-empty.
     */
    @JsonProperty("resourceRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ResourcePolicyRule> getResourceRules() {
        return resourceRules;
    }

    /**
     * `resourceRules` is a slice of ResourcePolicyRules that identify matching requests according to their verb and the target resource. At least one of `resourceRules` and `nonResourceRules` has to be non-empty.
     */
    @JsonProperty("resourceRules")
    public void setResourceRules(List<ResourcePolicyRule> resourceRules) {
        this.resourceRules = resourceRules;
    }

    /**
     * subjects is the list of normal user, serviceaccount, or group that this rule cares about. There must be at least one member in this slice. A slice that includes both the system:authenticated and system:unauthenticated user groups matches every request. Required.
     */
    @JsonProperty("subjects")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Subject> getSubjects() {
        return subjects;
    }

    /**
     * subjects is the list of normal user, serviceaccount, or group that this rule cares about. There must be at least one member in this slice. A slice that includes both the system:authenticated and system:unauthenticated user groups matches every request. Required.
     */
    @JsonProperty("subjects")
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @JsonIgnore
    public PolicyRulesWithSubjectsBuilder edit() {
        return new PolicyRulesWithSubjectsBuilder(this);
    }

    @JsonIgnore
    public PolicyRulesWithSubjectsBuilder toBuilder() {
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
        if (!(o instanceof PolicyRulesWithSubjects)) {
            return false;
        }
        PolicyRulesWithSubjects other = (PolicyRulesWithSubjects) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$nonResourceRules = this.getNonResourceRules();
        Object other$nonResourceRules = other.getNonResourceRules();
        if (this$nonResourceRules == null ? other$nonResourceRules != null : !this$nonResourceRules.equals(other$nonResourceRules)) {
            return false;
        }
        Object this$resourceRules = this.getResourceRules();
        Object other$resourceRules = other.getResourceRules();
        if (this$resourceRules == null ? other$resourceRules != null : !this$resourceRules.equals(other$resourceRules)) {
            return false;
        }
        Object this$subjects = this.getSubjects();
        Object other$subjects = other.getSubjects();
        if (this$subjects == null ? other$subjects != null : !this$subjects.equals(other$subjects)) {
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
        return other instanceof PolicyRulesWithSubjects;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $nonResourceRules = this.getNonResourceRules();
        result = result * prime + ($nonResourceRules == null ? 43 : $nonResourceRules.hashCode());
        Object $resourceRules = this.getResourceRules();
        result = result * prime + ($resourceRules == null ? 43 : $resourceRules.hashCode());
        Object $subjects = this.getSubjects();
        result = result * prime + ($subjects == null ? 43 : $subjects.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PolicyRulesWithSubjects(" + "nonResourceRules=" + this.getNonResourceRules() + ", resourceRules=" + this.getResourceRules() + ", subjects=" + this.getSubjects() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
