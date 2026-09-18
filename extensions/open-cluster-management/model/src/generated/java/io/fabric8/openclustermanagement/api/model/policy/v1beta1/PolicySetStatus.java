
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
 * PolicySetStatus reports the observed status of the policy set resulting from its policies.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "compliant",
    "placement",
    "statusMessage"
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
public class PolicySetStatus implements Editable<PolicySetStatusBuilder>, KubernetesResource
{

    @JsonProperty("compliant")
    private String compliant;
    @JsonProperty("placement")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PolicySetStatusPlacement> placement = new ArrayList<>();
    @JsonProperty("statusMessage")
    private String statusMessage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PolicySetStatus() {
    }

    public PolicySetStatus(String compliant, List<PolicySetStatusPlacement> placement, String statusMessage) {
        super();
        this.compliant = compliant;
        this.placement = placement;
        this.statusMessage = statusMessage;
    }

    /**
     * Compliant reports the observed status resulting from the compliance of the policies within.
     */
    @JsonProperty("compliant")
    public String getCompliant() {
        return compliant;
    }

    /**
     * Compliant reports the observed status resulting from the compliance of the policies within.
     */
    @JsonProperty("compliant")
    public void setCompliant(String compliant) {
        this.compliant = compliant;
    }

    /**
     * PolicySetStatus reports the observed status of the policy set resulting from its policies.
     */
    @JsonProperty("placement")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PolicySetStatusPlacement> getPlacement() {
        return placement;
    }

    /**
     * PolicySetStatus reports the observed status of the policy set resulting from its policies.
     */
    @JsonProperty("placement")
    public void setPlacement(List<PolicySetStatusPlacement> placement) {
        this.placement = placement;
    }

    /**
     * StatusMessge reports the current state while determining the compliance of the policy set.
     */
    @JsonProperty("statusMessage")
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * StatusMessge reports the current state while determining the compliance of the policy set.
     */
    @JsonProperty("statusMessage")
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    @JsonIgnore
    public PolicySetStatusBuilder edit() {
        return new PolicySetStatusBuilder(this);
    }

    @JsonIgnore
    public PolicySetStatusBuilder toBuilder() {
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
        if (!(o instanceof PolicySetStatus)) {
            return false;
        }
        PolicySetStatus other = (PolicySetStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$compliant = this.getCompliant();
        Object other$compliant = other.getCompliant();
        if (this$compliant == null ? other$compliant != null : !this$compliant.equals(other$compliant)) {
            return false;
        }
        Object this$placement = this.getPlacement();
        Object other$placement = other.getPlacement();
        if (this$placement == null ? other$placement != null : !this$placement.equals(other$placement)) {
            return false;
        }
        Object this$statusMessage = this.getStatusMessage();
        Object other$statusMessage = other.getStatusMessage();
        if (this$statusMessage == null ? other$statusMessage != null : !this$statusMessage.equals(other$statusMessage)) {
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
        return other instanceof PolicySetStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $compliant = this.getCompliant();
        result = result * prime + ($compliant == null ? 43 : $compliant.hashCode());
        Object $placement = this.getPlacement();
        result = result * prime + ($placement == null ? 43 : $placement.hashCode());
        Object $statusMessage = this.getStatusMessage();
        result = result * prime + ($statusMessage == null ? 43 : $statusMessage.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PolicySetStatus(" + "compliant=" + this.getCompliant() + ", placement=" + this.getPlacement() + ", statusMessage=" + this.getStatusMessage() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
