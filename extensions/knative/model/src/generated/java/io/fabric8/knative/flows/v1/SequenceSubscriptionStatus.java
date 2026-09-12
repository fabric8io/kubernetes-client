
package io.fabric8.knative.flows.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ready",
    "subscription"
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
public class SequenceSubscriptionStatus implements Editable<SequenceSubscriptionStatusBuilder>, KubernetesResource
{

    @JsonProperty("ready")
    private Condition ready;
    @JsonProperty("subscription")
    private ObjectReference subscription;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SequenceSubscriptionStatus() {
    }

    public SequenceSubscriptionStatus(Condition ready, ObjectReference subscription) {
        super();
        this.ready = ready;
        this.subscription = subscription;
    }

    @JsonProperty("ready")
    public Condition getReady() {
        return ready;
    }

    @JsonProperty("ready")
    public void setReady(Condition ready) {
        this.ready = ready;
    }

    @JsonProperty("subscription")
    public ObjectReference getSubscription() {
        return subscription;
    }

    @JsonProperty("subscription")
    public void setSubscription(ObjectReference subscription) {
        this.subscription = subscription;
    }

    @JsonIgnore
    public SequenceSubscriptionStatusBuilder edit() {
        return new SequenceSubscriptionStatusBuilder(this);
    }

    @JsonIgnore
    public SequenceSubscriptionStatusBuilder toBuilder() {
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
        if (!(o instanceof SequenceSubscriptionStatus)) {
            return false;
        }
        SequenceSubscriptionStatus other = (SequenceSubscriptionStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ready = this.getReady();
        Object other$ready = other.getReady();
        if (this$ready == null ? other$ready != null : !this$ready.equals(other$ready)) {
            return false;
        }
        Object this$subscription = this.getSubscription();
        Object other$subscription = other.getSubscription();
        if (this$subscription == null ? other$subscription != null : !this$subscription.equals(other$subscription)) {
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
        return other instanceof SequenceSubscriptionStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $ready = this.getReady();
        result = result * prime + ($ready == null ? 43 : $ready.hashCode());
        Object $subscription = this.getSubscription();
        result = result * prime + ($subscription == null ? 43 : $subscription.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SequenceSubscriptionStatus(" + "ready=" + this.getReady() + ", subscription=" + this.getSubscription() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
