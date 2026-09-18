
package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

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
 * ViolationContext defines the noncompliant replicated policy information that is sent to the AnsibleJob through the extra_vars parameter.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hubCluster",
    "policyName",
    "policyNamespace",
    "policySets",
    "policyViolations",
    "targetClusters"
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
public class ViolationContext implements Editable<ViolationContextBuilder>, KubernetesResource
{

    @JsonProperty("hubCluster")
    private String hubCluster;
    @JsonProperty("policyName")
    private String policyName;
    @JsonProperty("policyNamespace")
    private String policyNamespace;
    @JsonProperty("policySets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> policySets = new ArrayList<>();
    @JsonProperty("policyViolations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, ReplicatedPolicyStatus> policyViolations = new LinkedHashMap<>();
    @JsonProperty("targetClusters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> targetClusters = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ViolationContext() {
    }

    public ViolationContext(String hubCluster, String policyName, String policyNamespace, List<String> policySets, Map<String, ReplicatedPolicyStatus> policyViolations, List<String> targetClusters) {
        super();
        this.hubCluster = hubCluster;
        this.policyName = policyName;
        this.policyNamespace = policyNamespace;
        this.policySets = policySets;
        this.policyViolations = policyViolations;
        this.targetClusters = targetClusters;
    }

    /**
     * ViolationContext defines the noncompliant replicated policy information that is sent to the AnsibleJob through the extra_vars parameter.
     */
    @JsonProperty("hubCluster")
    public String getHubCluster() {
        return hubCluster;
    }

    /**
     * ViolationContext defines the noncompliant replicated policy information that is sent to the AnsibleJob through the extra_vars parameter.
     */
    @JsonProperty("hubCluster")
    public void setHubCluster(String hubCluster) {
        this.hubCluster = hubCluster;
    }

    /**
     * ViolationContext defines the noncompliant replicated policy information that is sent to the AnsibleJob through the extra_vars parameter.
     */
    @JsonProperty("policyName")
    public String getPolicyName() {
        return policyName;
    }

    /**
     * ViolationContext defines the noncompliant replicated policy information that is sent to the AnsibleJob through the extra_vars parameter.
     */
    @JsonProperty("policyName")
    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    /**
     * ViolationContext defines the noncompliant replicated policy information that is sent to the AnsibleJob through the extra_vars parameter.
     */
    @JsonProperty("policyNamespace")
    public String getPolicyNamespace() {
        return policyNamespace;
    }

    /**
     * ViolationContext defines the noncompliant replicated policy information that is sent to the AnsibleJob through the extra_vars parameter.
     */
    @JsonProperty("policyNamespace")
    public void setPolicyNamespace(String policyNamespace) {
        this.policyNamespace = policyNamespace;
    }

    /**
     * ViolationContext defines the noncompliant replicated policy information that is sent to the AnsibleJob through the extra_vars parameter.
     */
    @JsonProperty("policySets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPolicySets() {
        return policySets;
    }

    /**
     * ViolationContext defines the noncompliant replicated policy information that is sent to the AnsibleJob through the extra_vars parameter.
     */
    @JsonProperty("policySets")
    public void setPolicySets(List<String> policySets) {
        this.policySets = policySets;
    }

    /**
     * ViolationContext defines the noncompliant replicated policy information that is sent to the AnsibleJob through the extra_vars parameter.
     */
    @JsonProperty("policyViolations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, ReplicatedPolicyStatus> getPolicyViolations() {
        return policyViolations;
    }

    /**
     * ViolationContext defines the noncompliant replicated policy information that is sent to the AnsibleJob through the extra_vars parameter.
     */
    @JsonProperty("policyViolations")
    public void setPolicyViolations(Map<String, ReplicatedPolicyStatus> policyViolations) {
        this.policyViolations = policyViolations;
    }

    /**
     * ViolationContext defines the noncompliant replicated policy information that is sent to the AnsibleJob through the extra_vars parameter.
     */
    @JsonProperty("targetClusters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTargetClusters() {
        return targetClusters;
    }

    /**
     * ViolationContext defines the noncompliant replicated policy information that is sent to the AnsibleJob through the extra_vars parameter.
     */
    @JsonProperty("targetClusters")
    public void setTargetClusters(List<String> targetClusters) {
        this.targetClusters = targetClusters;
    }

    @JsonIgnore
    public ViolationContextBuilder edit() {
        return new ViolationContextBuilder(this);
    }

    @JsonIgnore
    public ViolationContextBuilder toBuilder() {
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
        if (!(o instanceof ViolationContext)) {
            return false;
        }
        ViolationContext other = (ViolationContext) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$hubCluster = this.getHubCluster();
        Object other$hubCluster = other.getHubCluster();
        if (this$hubCluster == null ? other$hubCluster != null : !this$hubCluster.equals(other$hubCluster)) {
            return false;
        }
        Object this$policyName = this.getPolicyName();
        Object other$policyName = other.getPolicyName();
        if (this$policyName == null ? other$policyName != null : !this$policyName.equals(other$policyName)) {
            return false;
        }
        Object this$policyNamespace = this.getPolicyNamespace();
        Object other$policyNamespace = other.getPolicyNamespace();
        if (this$policyNamespace == null ? other$policyNamespace != null : !this$policyNamespace.equals(other$policyNamespace)) {
            return false;
        }
        Object this$policySets = this.getPolicySets();
        Object other$policySets = other.getPolicySets();
        if (this$policySets == null ? other$policySets != null : !this$policySets.equals(other$policySets)) {
            return false;
        }
        Object this$policyViolations = this.getPolicyViolations();
        Object other$policyViolations = other.getPolicyViolations();
        if (this$policyViolations == null ? other$policyViolations != null : !this$policyViolations.equals(other$policyViolations)) {
            return false;
        }
        Object this$targetClusters = this.getTargetClusters();
        Object other$targetClusters = other.getTargetClusters();
        if (this$targetClusters == null ? other$targetClusters != null : !this$targetClusters.equals(other$targetClusters)) {
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
        return other instanceof ViolationContext;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $hubCluster = this.getHubCluster();
        result = result * prime + ($hubCluster == null ? 43 : $hubCluster.hashCode());
        Object $policyName = this.getPolicyName();
        result = result * prime + ($policyName == null ? 43 : $policyName.hashCode());
        Object $policyNamespace = this.getPolicyNamespace();
        result = result * prime + ($policyNamespace == null ? 43 : $policyNamespace.hashCode());
        Object $policySets = this.getPolicySets();
        result = result * prime + ($policySets == null ? 43 : $policySets.hashCode());
        Object $policyViolations = this.getPolicyViolations();
        result = result * prime + ($policyViolations == null ? 43 : $policyViolations.hashCode());
        Object $targetClusters = this.getTargetClusters();
        result = result * prime + ($targetClusters == null ? 43 : $targetClusters.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ViolationContext(" + "hubCluster=" + this.getHubCluster() + ", policyName=" + this.getPolicyName() + ", policyNamespace=" + this.getPolicyNamespace() + ", policySets=" + this.getPolicySets() + ", policyViolations=" + this.getPolicyViolations() + ", targetClusters=" + this.getTargetClusters() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
