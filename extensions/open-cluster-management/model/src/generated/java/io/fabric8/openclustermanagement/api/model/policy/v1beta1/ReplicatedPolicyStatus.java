
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
 * ReplicatedPolicyStatus defines the replicated policy status.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "compliant",
    "details",
    "violation_message"
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
public class ReplicatedPolicyStatus implements Editable<ReplicatedPolicyStatusBuilder>, KubernetesResource
{

    @JsonProperty("compliant")
    private String compliant;
    @JsonProperty("details")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ReplicatedDetailsPerTemplate> details = new ArrayList<>();
    @JsonProperty("violation_message")
    private String violationMessage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ReplicatedPolicyStatus() {
    }

    public ReplicatedPolicyStatus(String compliant, List<ReplicatedDetailsPerTemplate> details, String violationMessage) {
        super();
        this.compliant = compliant;
        this.details = details;
        this.violationMessage = violationMessage;
    }

    /**
     * ReplicatedPolicyStatus defines the replicated policy status.
     */
    @JsonProperty("compliant")
    public String getCompliant() {
        return compliant;
    }

    /**
     * ReplicatedPolicyStatus defines the replicated policy status.
     */
    @JsonProperty("compliant")
    public void setCompliant(String compliant) {
        this.compliant = compliant;
    }

    /**
     * used by replicated policy
     */
    @JsonProperty("details")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ReplicatedDetailsPerTemplate> getDetails() {
        return details;
    }

    /**
     * used by replicated policy
     */
    @JsonProperty("details")
    public void setDetails(List<ReplicatedDetailsPerTemplate> details) {
        this.details = details;
    }

    /**
     * used by replicated policy
     */
    @JsonProperty("violation_message")
    public String getViolationMessage() {
        return violationMessage;
    }

    /**
     * used by replicated policy
     */
    @JsonProperty("violation_message")
    public void setViolationMessage(String violationMessage) {
        this.violationMessage = violationMessage;
    }

    @JsonIgnore
    public ReplicatedPolicyStatusBuilder edit() {
        return new ReplicatedPolicyStatusBuilder(this);
    }

    @JsonIgnore
    public ReplicatedPolicyStatusBuilder toBuilder() {
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
        if (!(o instanceof ReplicatedPolicyStatus)) {
            return false;
        }
        ReplicatedPolicyStatus other = (ReplicatedPolicyStatus) o;
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
        Object this$violationMessage = this.getViolationMessage();
        Object other$violationMessage = other.getViolationMessage();
        if (this$violationMessage == null ? other$violationMessage != null : !this$violationMessage.equals(other$violationMessage)) {
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
        return other instanceof ReplicatedPolicyStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $compliant = this.getCompliant();
        result = result * prime + ($compliant == null ? 43 : $compliant.hashCode());
        Object $details = this.getDetails();
        result = result * prime + ($details == null ? 43 : $details.hashCode());
        Object $violationMessage = this.getViolationMessage();
        result = result * prime + ($violationMessage == null ? 43 : $violationMessage.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ReplicatedPolicyStatus(" + "compliant=" + this.getCompliant() + ", details=" + this.getDetails() + ", violationMessage=" + this.getViolationMessage() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
