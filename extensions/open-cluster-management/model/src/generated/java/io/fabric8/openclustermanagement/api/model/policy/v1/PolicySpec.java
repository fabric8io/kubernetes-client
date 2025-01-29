
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

/**
 * PolicySpec defines the configurations of the policy engine resources to deliver to the managed clusters.
 */
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

    /**
     * CopyPolicyMetadata specifies whether the labels and annotations of a policy should be copied when replicating the policy to a managed cluster. If set to "true", all of the labels and annotations of the policy are copied to the replicated policy. If set to "false", only the policy framework-specific policy labels and annotations are copied to the replicated policy. This setting is useful if there is tracking for metadata that should only exist on the root policy. It is recommended to set this to "false" when using Argo CD to deploy the policy definition since Argo CD uses metadata for tracking that should not be replicated. The default value is "true".
     */
    @JsonProperty("copyPolicyMetadata")
    public Boolean getCopyPolicyMetadata() {
        return copyPolicyMetadata;
    }

    /**
     * CopyPolicyMetadata specifies whether the labels and annotations of a policy should be copied when replicating the policy to a managed cluster. If set to "true", all of the labels and annotations of the policy are copied to the replicated policy. If set to "false", only the policy framework-specific policy labels and annotations are copied to the replicated policy. This setting is useful if there is tracking for metadata that should only exist on the root policy. It is recommended to set this to "false" when using Argo CD to deploy the policy definition since Argo CD uses metadata for tracking that should not be replicated. The default value is "true".
     */
    @JsonProperty("copyPolicyMetadata")
    public void setCopyPolicyMetadata(Boolean copyPolicyMetadata) {
        this.copyPolicyMetadata = copyPolicyMetadata;
    }

    /**
     * PolicyDependencies is a list of dependency objects detailed with extra considerations for compliance that should be fulfilled before applying the policies to the managed clusters.
     */
    @JsonProperty("dependencies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PolicyDependency> getDependencies() {
        return dependencies;
    }

    /**
     * PolicyDependencies is a list of dependency objects detailed with extra considerations for compliance that should be fulfilled before applying the policies to the managed clusters.
     */
    @JsonProperty("dependencies")
    public void setDependencies(List<PolicyDependency> dependencies) {
        this.dependencies = dependencies;
    }

    /**
     * Disabled is a boolean parameter you can use to enable and disable the policy. When disabled, the policy is removed from managed clusters.
     */
    @JsonProperty("disabled")
    public Boolean getDisabled() {
        return disabled;
    }

    /**
     * Disabled is a boolean parameter you can use to enable and disable the policy. When disabled, the policy is removed from managed clusters.
     */
    @JsonProperty("disabled")
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * PolicySpec defines the configurations of the policy engine resources to deliver to the managed clusters.
     */
    @JsonProperty("hubTemplateOptions")
    public HubTemplateOptions getHubTemplateOptions() {
        return hubTemplateOptions;
    }

    /**
     * PolicySpec defines the configurations of the policy engine resources to deliver to the managed clusters.
     */
    @JsonProperty("hubTemplateOptions")
    public void setHubTemplateOptions(HubTemplateOptions hubTemplateOptions) {
        this.hubTemplateOptions = hubTemplateOptions;
    }

    /**
     * PolicyTemplates is a list of definitions of policy engine resources to apply to managed clusters along with configurations on how it should be applied.
     */
    @JsonProperty("policy-templates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PolicyTemplate> getPolicyTemplates() {
        return policyTemplates;
    }

    /**
     * PolicyTemplates is a list of definitions of policy engine resources to apply to managed clusters along with configurations on how it should be applied.
     */
    @JsonProperty("policy-templates")
    public void setPolicyTemplates(List<PolicyTemplate> policyTemplates) {
        this.policyTemplates = policyTemplates;
    }

    /**
     * RemediationAction specifies the remediation of the policy. The parameter values are "enforce" and "inform". If specified, the value that is defined overrides any remediationAction parameter defined in the child policies in the "policy-templates" section. Important: Not all policy engine kinds support the enforce feature.
     */
    @JsonProperty("remediationAction")
    public String getRemediationAction() {
        return remediationAction;
    }

    /**
     * RemediationAction specifies the remediation of the policy. The parameter values are "enforce" and "inform". If specified, the value that is defined overrides any remediationAction parameter defined in the child policies in the "policy-templates" section. Important: Not all policy engine kinds support the enforce feature.
     */
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
