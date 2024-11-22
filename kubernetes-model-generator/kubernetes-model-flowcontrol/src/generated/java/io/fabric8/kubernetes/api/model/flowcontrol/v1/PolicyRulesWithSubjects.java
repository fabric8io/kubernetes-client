
package io.fabric8.kubernetes.api.model.flowcontrol.v1;

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
    "nonResourceRules",
    "resourceRules",
    "subjects"
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
public class PolicyRulesWithSubjects implements Editable<PolicyRulesWithSubjectsBuilder> , KubernetesResource
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
     * 
     */
    public PolicyRulesWithSubjects() {
    }

    public PolicyRulesWithSubjects(List<NonResourcePolicyRule> nonResourceRules, List<ResourcePolicyRule> resourceRules, List<Subject> subjects) {
        super();
        this.nonResourceRules = nonResourceRules;
        this.resourceRules = resourceRules;
        this.subjects = subjects;
    }

    @JsonProperty("nonResourceRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NonResourcePolicyRule> getNonResourceRules() {
        return nonResourceRules;
    }

    @JsonProperty("nonResourceRules")
    public void setNonResourceRules(List<NonResourcePolicyRule> nonResourceRules) {
        this.nonResourceRules = nonResourceRules;
    }

    @JsonProperty("resourceRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ResourcePolicyRule> getResourceRules() {
        return resourceRules;
    }

    @JsonProperty("resourceRules")
    public void setResourceRules(List<ResourcePolicyRule> resourceRules) {
        this.resourceRules = resourceRules;
    }

    @JsonProperty("subjects")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Subject> getSubjects() {
        return subjects;
    }

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
