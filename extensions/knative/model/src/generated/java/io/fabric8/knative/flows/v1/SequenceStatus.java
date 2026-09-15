
package io.fabric8.knative.flows.v1;

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
import io.fabric8.knative.duck.v1.Addressable;
import io.fabric8.knative.duck.v1.AppliedEventPolicyRef;
import io.fabric8.knative.duck.v1.AuthStatus;
import io.fabric8.knative.pkg.apis.Condition;
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
 * SequenceStatus represents the current state of a Sequence.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address",
    "annotations",
    "auth",
    "channelStatuses",
    "conditions",
    "observedGeneration",
    "policies",
    "subscriptionStatuses"
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
public class SequenceStatus implements Editable<SequenceStatusBuilder>, KubernetesResource
{

    @JsonProperty("address")
    private Addressable address;
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<>();
    @JsonProperty("auth")
    private AuthStatus auth;
    @JsonProperty("channelStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SequenceChannelStatus> channelStatuses = new ArrayList<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("policies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AppliedEventPolicyRef> policies = new ArrayList<>();
    @JsonProperty("subscriptionStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SequenceSubscriptionStatus> subscriptionStatuses = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SequenceStatus() {
    }

    public SequenceStatus(Addressable address, Map<String, String> annotations, AuthStatus auth, List<SequenceChannelStatus> channelStatuses, List<Condition> conditions, Long observedGeneration, List<AppliedEventPolicyRef> policies, List<SequenceSubscriptionStatus> subscriptionStatuses) {
        super();
        this.address = address;
        this.annotations = annotations;
        this.auth = auth;
        this.channelStatuses = channelStatuses;
        this.conditions = conditions;
        this.observedGeneration = observedGeneration;
        this.policies = policies;
        this.subscriptionStatuses = subscriptionStatuses;
    }

    /**
     * SequenceStatus represents the current state of a Sequence.
     */
    @JsonProperty("address")
    public Addressable getAddress() {
        return address;
    }

    /**
     * SequenceStatus represents the current state of a Sequence.
     */
    @JsonProperty("address")
    public void setAddress(Addressable address) {
        this.address = address;
    }

    /**
     * Annotations is additional Status fields for the Resource to save some additional State as well as convey more information to the user. This is roughly akin to Annotations on any k8s resource, just the reconciler conveying richer information outwards.
     */
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    /**
     * Annotations is additional Status fields for the Resource to save some additional State as well as convey more information to the user. This is roughly akin to Annotations on any k8s resource, just the reconciler conveying richer information outwards.
     */
    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    /**
     * SequenceStatus represents the current state of a Sequence.
     */
    @JsonProperty("auth")
    public AuthStatus getAuth() {
        return auth;
    }

    /**
     * SequenceStatus represents the current state of a Sequence.
     */
    @JsonProperty("auth")
    public void setAuth(AuthStatus auth) {
        this.auth = auth;
    }

    /**
     * ChannelStatuses is an array of corresponding Channel statuses. Matches the Spec.Steps array in the order.
     */
    @JsonProperty("channelStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SequenceChannelStatus> getChannelStatuses() {
        return channelStatuses;
    }

    /**
     * ChannelStatuses is an array of corresponding Channel statuses. Matches the Spec.Steps array in the order.
     */
    @JsonProperty("channelStatuses")
    public void setChannelStatuses(List<SequenceChannelStatus> channelStatuses) {
        this.channelStatuses = channelStatuses;
    }

    /**
     * Conditions the latest available observations of a resource's current state.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions the latest available observations of a resource's current state.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * ObservedGeneration is the 'Generation' of the Service that was last processed by the controller.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * ObservedGeneration is the 'Generation' of the Service that was last processed by the controller.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * Policies holds the list of applied EventPolicies
     */
    @JsonProperty("policies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AppliedEventPolicyRef> getPolicies() {
        return policies;
    }

    /**
     * Policies holds the list of applied EventPolicies
     */
    @JsonProperty("policies")
    public void setPolicies(List<AppliedEventPolicyRef> policies) {
        this.policies = policies;
    }

    /**
     * SubscriptionStatuses is an array of corresponding Subscription statuses. Matches the Spec.Steps array in the order.
     */
    @JsonProperty("subscriptionStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SequenceSubscriptionStatus> getSubscriptionStatuses() {
        return subscriptionStatuses;
    }

    /**
     * SubscriptionStatuses is an array of corresponding Subscription statuses. Matches the Spec.Steps array in the order.
     */
    @JsonProperty("subscriptionStatuses")
    public void setSubscriptionStatuses(List<SequenceSubscriptionStatus> subscriptionStatuses) {
        this.subscriptionStatuses = subscriptionStatuses;
    }

    @JsonIgnore
    public SequenceStatusBuilder edit() {
        return new SequenceStatusBuilder(this);
    }

    @JsonIgnore
    public SequenceStatusBuilder toBuilder() {
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
        if (!(o instanceof SequenceStatus)) {
            return false;
        }
        SequenceStatus other = (SequenceStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$address = this.getAddress();
        Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) {
            return false;
        }
        Object this$annotations = this.getAnnotations();
        Object other$annotations = other.getAnnotations();
        if (this$annotations == null ? other$annotations != null : !this$annotations.equals(other$annotations)) {
            return false;
        }
        Object this$auth = this.getAuth();
        Object other$auth = other.getAuth();
        if (this$auth == null ? other$auth != null : !this$auth.equals(other$auth)) {
            return false;
        }
        Object this$channelStatuses = this.getChannelStatuses();
        Object other$channelStatuses = other.getChannelStatuses();
        if (this$channelStatuses == null ? other$channelStatuses != null : !this$channelStatuses.equals(other$channelStatuses)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
            return false;
        }
        Object this$policies = this.getPolicies();
        Object other$policies = other.getPolicies();
        if (this$policies == null ? other$policies != null : !this$policies.equals(other$policies)) {
            return false;
        }
        Object this$subscriptionStatuses = this.getSubscriptionStatuses();
        Object other$subscriptionStatuses = other.getSubscriptionStatuses();
        if (this$subscriptionStatuses == null ? other$subscriptionStatuses != null : !this$subscriptionStatuses.equals(other$subscriptionStatuses)) {
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
        return other instanceof SequenceStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $address = this.getAddress();
        result = result * prime + ($address == null ? 43 : $address.hashCode());
        Object $annotations = this.getAnnotations();
        result = result * prime + ($annotations == null ? 43 : $annotations.hashCode());
        Object $auth = this.getAuth();
        result = result * prime + ($auth == null ? 43 : $auth.hashCode());
        Object $channelStatuses = this.getChannelStatuses();
        result = result * prime + ($channelStatuses == null ? 43 : $channelStatuses.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $policies = this.getPolicies();
        result = result * prime + ($policies == null ? 43 : $policies.hashCode());
        Object $subscriptionStatuses = this.getSubscriptionStatuses();
        result = result * prime + ($subscriptionStatuses == null ? 43 : $subscriptionStatuses.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SequenceStatus(" + "address=" + this.getAddress() + ", annotations=" + this.getAnnotations() + ", auth=" + this.getAuth() + ", channelStatuses=" + this.getChannelStatuses() + ", conditions=" + this.getConditions() + ", observedGeneration=" + this.getObservedGeneration() + ", policies=" + this.getPolicies() + ", subscriptionStatuses=" + this.getSubscriptionStatuses() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
