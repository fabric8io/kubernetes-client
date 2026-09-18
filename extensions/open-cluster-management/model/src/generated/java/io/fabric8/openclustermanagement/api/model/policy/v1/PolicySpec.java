
package io.fabric8.openclustermanagement.api.model.policy.v1;

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
        if (!(o instanceof PolicySpec)) {
            return false;
        }
        PolicySpec other = (PolicySpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$copyPolicyMetadata = this.getCopyPolicyMetadata();
        Object other$copyPolicyMetadata = other.getCopyPolicyMetadata();
        if (this$copyPolicyMetadata == null ? other$copyPolicyMetadata != null : !this$copyPolicyMetadata.equals(other$copyPolicyMetadata)) {
            return false;
        }
        Object this$dependencies = this.getDependencies();
        Object other$dependencies = other.getDependencies();
        if (this$dependencies == null ? other$dependencies != null : !this$dependencies.equals(other$dependencies)) {
            return false;
        }
        Object this$disabled = this.getDisabled();
        Object other$disabled = other.getDisabled();
        if (this$disabled == null ? other$disabled != null : !this$disabled.equals(other$disabled)) {
            return false;
        }
        Object this$hubTemplateOptions = this.getHubTemplateOptions();
        Object other$hubTemplateOptions = other.getHubTemplateOptions();
        if (this$hubTemplateOptions == null ? other$hubTemplateOptions != null : !this$hubTemplateOptions.equals(other$hubTemplateOptions)) {
            return false;
        }
        Object this$policyTemplates = this.getPolicyTemplates();
        Object other$policyTemplates = other.getPolicyTemplates();
        if (this$policyTemplates == null ? other$policyTemplates != null : !this$policyTemplates.equals(other$policyTemplates)) {
            return false;
        }
        Object this$remediationAction = this.getRemediationAction();
        Object other$remediationAction = other.getRemediationAction();
        if (this$remediationAction == null ? other$remediationAction != null : !this$remediationAction.equals(other$remediationAction)) {
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
        return other instanceof PolicySpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $copyPolicyMetadata = this.getCopyPolicyMetadata();
        result = result * prime + ($copyPolicyMetadata == null ? 43 : $copyPolicyMetadata.hashCode());
        Object $dependencies = this.getDependencies();
        result = result * prime + ($dependencies == null ? 43 : $dependencies.hashCode());
        Object $disabled = this.getDisabled();
        result = result * prime + ($disabled == null ? 43 : $disabled.hashCode());
        Object $hubTemplateOptions = this.getHubTemplateOptions();
        result = result * prime + ($hubTemplateOptions == null ? 43 : $hubTemplateOptions.hashCode());
        Object $policyTemplates = this.getPolicyTemplates();
        result = result * prime + ($policyTemplates == null ? 43 : $policyTemplates.hashCode());
        Object $remediationAction = this.getRemediationAction();
        result = result * prime + ($remediationAction == null ? 43 : $remediationAction.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PolicySpec(" + "copyPolicyMetadata=" + this.getCopyPolicyMetadata() + ", dependencies=" + this.getDependencies() + ", disabled=" + this.getDisabled() + ", hubTemplateOptions=" + this.getHubTemplateOptions() + ", policyTemplates=" + this.getPolicyTemplates() + ", remediationAction=" + this.getRemediationAction() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
