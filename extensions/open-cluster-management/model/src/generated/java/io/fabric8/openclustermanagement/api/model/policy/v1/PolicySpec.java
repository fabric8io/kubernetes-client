
package io.fabric8.openclustermanagement.api.model.policy.v1;

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
    "copyPolicyMetadata",
    "dependencies",
    "disabled",
    "hubTemplateOptions",
    "policy-templates",
    "remediationAction"
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
public class PolicySpec implements Editable<PolicySpecBuilder>, KubernetesResource
{

    @JsonProperty("copyPolicyMetadata")
    private Boolean copyPolicyMetadata;
    @JsonProperty("dependencies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PolicyDependency> dependencies = new ArrayList<>();
    @JsonProperty("disabled")
    private Boolean disabled;
    @JsonProperty("hubTemplateOptions")
    private HubTemplateOptions hubTemplateOptions;
    @JsonProperty("policy-templates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PolicyTemplate> policyTemplates = new ArrayList<>();
    @JsonProperty("remediationAction")
    private String remediationAction;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PolicySpec() {
    }

    public PolicySpec(Boolean copyPolicyMetadata, List<PolicyDependency> dependencies, Boolean disabled, HubTemplateOptions hubTemplateOptions, List<PolicyTemplate> policyTemplates, String remediationAction) {
        super();
        this.copyPolicyMetadata = copyPolicyMetadata;
        this.dependencies = dependencies;
        this.disabled = disabled;
        this.hubTemplateOptions = hubTemplateOptions;
        this.policyTemplates = policyTemplates;
        this.remediationAction = remediationAction;
    }

    @JsonProperty("copyPolicyMetadata")
    public Boolean getCopyPolicyMetadata() {
        return copyPolicyMetadata;
    }

    @JsonProperty("copyPolicyMetadata")
    public void setCopyPolicyMetadata(Boolean copyPolicyMetadata) {
        this.copyPolicyMetadata = copyPolicyMetadata;
    }

    @JsonProperty("dependencies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PolicyDependency> getDependencies() {
        return dependencies;
    }

    @JsonProperty("dependencies")
    public void setDependencies(List<PolicyDependency> dependencies) {
        this.dependencies = dependencies;
    }

    @JsonProperty("disabled")
    public Boolean getDisabled() {
        return disabled;
    }

    @JsonProperty("disabled")
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    @JsonProperty("hubTemplateOptions")
    public HubTemplateOptions getHubTemplateOptions() {
        return hubTemplateOptions;
    }

    @JsonProperty("hubTemplateOptions")
    public void setHubTemplateOptions(HubTemplateOptions hubTemplateOptions) {
        this.hubTemplateOptions = hubTemplateOptions;
    }

    @JsonProperty("policy-templates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PolicyTemplate> getPolicyTemplates() {
        return policyTemplates;
    }

    @JsonProperty("policy-templates")
    public void setPolicyTemplates(List<PolicyTemplate> policyTemplates) {
        this.policyTemplates = policyTemplates;
    }

    @JsonProperty("remediationAction")
    public String getRemediationAction() {
        return remediationAction;
    }

    @JsonProperty("remediationAction")
    public void setRemediationAction(String remediationAction) {
        this.remediationAction = remediationAction;
    }

    @JsonIgnore
    public PolicySpecBuilder edit() {
        return new PolicySpecBuilder(this);
    }

    @JsonIgnore
    public PolicySpecBuilder toBuilder() {
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
