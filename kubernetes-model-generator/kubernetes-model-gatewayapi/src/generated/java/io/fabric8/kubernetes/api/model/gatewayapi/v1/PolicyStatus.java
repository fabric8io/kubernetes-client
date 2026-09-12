
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * PolicyStatus defines the common attributes that all Policies should include within their status.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ancestors"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PolicyStatus implements Editable<PolicyStatusBuilder>, KubernetesResource
{

    @JsonProperty("ancestors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PolicyAncestorStatus> ancestors = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PolicyStatus() {
    }

    public PolicyStatus(List<PolicyAncestorStatus> ancestors) {
        super();
        this.ancestors = ancestors;
    }

    /**
     * Ancestors is a list of ancestor resources (usually Gateways) that are associated with the policy, and the status of the policy with respect to each ancestor. When this policy attaches to a parent, the controller that manages the parent and the ancestors MUST add an entry to this list when the controller first sees the policy and SHOULD update the entry as appropriate when the relevant ancestor is modified.<br><p> <br><p> Note that choosing the relevant ancestor is left to the Policy designers; an important part of Policy design is designing the right object level at which to namespace this status.<br><p> <br><p> Note also that implementations MUST ONLY populate ancestor status for the Ancestor resources they are responsible for. Implementations MUST use the ControllerName field to uniquely identify the entries in this list that they are responsible for.<br><p> <br><p> Note that to achieve this, the list of PolicyAncestorStatus structs MUST be treated as a map with a composite key, made up of the AncestorRef and ControllerName fields combined.<br><p> <br><p> A maximum of 16 ancestors will be represented in this list. An empty list means the Policy is not relevant for any ancestors.<br><p> <br><p> If this slice is full, implementations MUST NOT add further entries. Instead they MUST consider the policy unimplementable and signal that on any related resources such as the ancestor that would be referenced here. For example, if this list was full on BackendTLSPolicy, no additional Gateways would be able to reference the Service targeted by the BackendTLSPolicy.
     */
    @JsonProperty("ancestors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PolicyAncestorStatus> getAncestors() {
        return ancestors;
    }

    /**
     * Ancestors is a list of ancestor resources (usually Gateways) that are associated with the policy, and the status of the policy with respect to each ancestor. When this policy attaches to a parent, the controller that manages the parent and the ancestors MUST add an entry to this list when the controller first sees the policy and SHOULD update the entry as appropriate when the relevant ancestor is modified.<br><p> <br><p> Note that choosing the relevant ancestor is left to the Policy designers; an important part of Policy design is designing the right object level at which to namespace this status.<br><p> <br><p> Note also that implementations MUST ONLY populate ancestor status for the Ancestor resources they are responsible for. Implementations MUST use the ControllerName field to uniquely identify the entries in this list that they are responsible for.<br><p> <br><p> Note that to achieve this, the list of PolicyAncestorStatus structs MUST be treated as a map with a composite key, made up of the AncestorRef and ControllerName fields combined.<br><p> <br><p> A maximum of 16 ancestors will be represented in this list. An empty list means the Policy is not relevant for any ancestors.<br><p> <br><p> If this slice is full, implementations MUST NOT add further entries. Instead they MUST consider the policy unimplementable and signal that on any related resources such as the ancestor that would be referenced here. For example, if this list was full on BackendTLSPolicy, no additional Gateways would be able to reference the Service targeted by the BackendTLSPolicy.
     */
    @JsonProperty("ancestors")
    public void setAncestors(List<PolicyAncestorStatus> ancestors) {
        this.ancestors = ancestors;
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
        Object this$ancestors = this.getAncestors();
        Object other$ancestors = other.getAncestors();
        if (this$ancestors == null ? other$ancestors != null : !this$ancestors.equals(other$ancestors)) {
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
        Object $ancestors = this.getAncestors();
        result = result * prime + ($ancestors == null ? 43 : $ancestors.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PolicyStatus(" + "ancestors=" + this.getAncestors() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
