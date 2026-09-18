
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
 * PolicyStatus reports the observed status of the policy resulting from its policy templates.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "compliant",
    "details",
    "placement",
    "status"
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
public class PolicyStatus implements Editable<PolicyStatusBuilder>, KubernetesResource
{

    @JsonProperty("compliant")
    private String compliant;
    @JsonProperty("details")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DetailsPerTemplate> details = new ArrayList<>();
    @JsonProperty("placement")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Placement> placement = new ArrayList<>();
    @JsonProperty("status")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CompliancePerClusterStatus> status = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PolicyStatus() {
    }

    public PolicyStatus(String compliant, List<DetailsPerTemplate> details, List<Placement> placement, List<CompliancePerClusterStatus> status) {
        super();
        this.compliant = compliant;
        this.details = details;
        this.placement = placement;
        this.status = status;
    }

    /**
     * ComplianceState reports the observed status resulting from the definitions of this policy. This status field is only used in the replicated policy in the managed cluster namespace.
     */
    @JsonProperty("compliant")
    public String getCompliant() {
        return compliant;
    }

    /**
     * ComplianceState reports the observed status resulting from the definitions of this policy. This status field is only used in the replicated policy in the managed cluster namespace.
     */
    @JsonProperty("compliant")
    public void setCompliant(String compliant) {
        this.compliant = compliant;
    }

    /**
     * Details is the list of compliance details for each policy template definition. This status field is only used in the replicated policy in the managed cluster namespace.
     */
    @JsonProperty("details")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DetailsPerTemplate> getDetails() {
        return details;
    }

    /**
     * Details is the list of compliance details for each policy template definition. This status field is only used in the replicated policy in the managed cluster namespace.
     */
    @JsonProperty("details")
    public void setDetails(List<DetailsPerTemplate> details) {
        this.details = details;
    }

    /**
     * Placement is a list of managed cluster placement resources bound to the policy. This status field is only used in the root policy on the hub cluster.
     */
    @JsonProperty("placement")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Placement> getPlacement() {
        return placement;
    }

    /**
     * Placement is a list of managed cluster placement resources bound to the policy. This status field is only used in the root policy on the hub cluster.
     */
    @JsonProperty("placement")
    public void setPlacement(List<Placement> placement) {
        this.placement = placement;
    }

    /**
     * Status is a list of managed clusters and the current compliance state of each one. This status field is only used in the root policy on the hub cluster.
     */
    @JsonProperty("status")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CompliancePerClusterStatus> getStatus() {
        return status;
    }

    /**
     * Status is a list of managed clusters and the current compliance state of each one. This status field is only used in the root policy on the hub cluster.
     */
    @JsonProperty("status")
    public void setStatus(List<CompliancePerClusterStatus> status) {
        this.status = status;
    }

    @JsonIgnore
    public PolicyStatusBuilder edit() {
        return new PolicyStatusBuilder(this);
    }

    @JsonIgnore
    public PolicyStatusBuilder toBuilder() {
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
        if (!(o instanceof PolicyStatus)) {
            return false;
        }
        PolicyStatus other = (PolicyStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$compliant = this.getCompliant();
        Object other$compliant = other.getCompliant();
        if (this$compliant == null ? other$compliant != null : !this$compliant.equals(other$compliant)) {
            return false;
        }
        Object this$details = this.getDetails();
        Object other$details = other.getDetails();
        if (this$details == null ? other$details != null : !this$details.equals(other$details)) {
            return false;
        }
        Object this$placement = this.getPlacement();
        Object other$placement = other.getPlacement();
        if (this$placement == null ? other$placement != null : !this$placement.equals(other$placement)) {
            return false;
        }
        Object this$status = this.getStatus();
        Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
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
        return other instanceof PolicyStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $compliant = this.getCompliant();
        result = result * prime + ($compliant == null ? 43 : $compliant.hashCode());
        Object $details = this.getDetails();
        result = result * prime + ($details == null ? 43 : $details.hashCode());
        Object $placement = this.getPlacement();
        result = result * prime + ($placement == null ? 43 : $placement.hashCode());
        Object $status = this.getStatus();
        result = result * prime + ($status == null ? 43 : $status.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PolicyStatus(" + "compliant=" + this.getCompliant() + ", details=" + this.getDetails() + ", placement=" + this.getPlacement() + ", status=" + this.getStatus() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
