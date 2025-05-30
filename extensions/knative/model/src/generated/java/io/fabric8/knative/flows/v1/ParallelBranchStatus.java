
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
 * ParallelBranchStatus represents the current state of a Parallel branch
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "filterChannelStatus",
    "filterSubscriptionStatus",
    "subscriberSubscriptionStatus"
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
public class ParallelBranchStatus implements Editable<ParallelBranchStatusBuilder>, KubernetesResource
{

    @JsonProperty("filterChannelStatus")
    private ParallelChannelStatus filterChannelStatus;
    @JsonProperty("filterSubscriptionStatus")
    private ParallelSubscriptionStatus filterSubscriptionStatus;
    @JsonProperty("subscriberSubscriptionStatus")
    private ParallelSubscriptionStatus subscriberSubscriptionStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ParallelBranchStatus() {
    }

    public ParallelBranchStatus(ParallelChannelStatus filterChannelStatus, ParallelSubscriptionStatus filterSubscriptionStatus, ParallelSubscriptionStatus subscriberSubscriptionStatus) {
        super();
        this.filterChannelStatus = filterChannelStatus;
        this.filterSubscriptionStatus = filterSubscriptionStatus;
        this.subscriberSubscriptionStatus = subscriberSubscriptionStatus;
    }

    /**
     * ParallelBranchStatus represents the current state of a Parallel branch
     */
    @JsonProperty("filterChannelStatus")
    public ParallelChannelStatus getFilterChannelStatus() {
        return filterChannelStatus;
    }

    /**
     * ParallelBranchStatus represents the current state of a Parallel branch
     */
    @JsonProperty("filterChannelStatus")
    public void setFilterChannelStatus(ParallelChannelStatus filterChannelStatus) {
        this.filterChannelStatus = filterChannelStatus;
    }

    /**
     * ParallelBranchStatus represents the current state of a Parallel branch
     */
    @JsonProperty("filterSubscriptionStatus")
    public ParallelSubscriptionStatus getFilterSubscriptionStatus() {
        return filterSubscriptionStatus;
    }

    /**
     * ParallelBranchStatus represents the current state of a Parallel branch
     */
    @JsonProperty("filterSubscriptionStatus")
    public void setFilterSubscriptionStatus(ParallelSubscriptionStatus filterSubscriptionStatus) {
        this.filterSubscriptionStatus = filterSubscriptionStatus;
    }

    /**
     * ParallelBranchStatus represents the current state of a Parallel branch
     */
    @JsonProperty("subscriberSubscriptionStatus")
    public ParallelSubscriptionStatus getSubscriberSubscriptionStatus() {
        return subscriberSubscriptionStatus;
    }

    /**
     * ParallelBranchStatus represents the current state of a Parallel branch
     */
    @JsonProperty("subscriberSubscriptionStatus")
    public void setSubscriberSubscriptionStatus(ParallelSubscriptionStatus subscriberSubscriptionStatus) {
        this.subscriberSubscriptionStatus = subscriberSubscriptionStatus;
    }

    @JsonIgnore
    public ParallelBranchStatusBuilder edit() {
        return new ParallelBranchStatusBuilder(this);
    }

    @JsonIgnore
    public ParallelBranchStatusBuilder toBuilder() {
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

}
