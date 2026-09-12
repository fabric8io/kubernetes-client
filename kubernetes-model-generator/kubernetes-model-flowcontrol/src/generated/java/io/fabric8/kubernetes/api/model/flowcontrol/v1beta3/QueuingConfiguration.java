
package io.fabric8.kubernetes.api.model.flowcontrol.v1beta3;

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

/**
 * QueuingConfiguration holds the configuration parameters for queuing
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "handSize",
    "queueLengthLimit",
    "queues"
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
public class QueuingConfiguration implements Editable<QueuingConfigurationBuilder>, KubernetesResource
{

    @JsonProperty("handSize")
    private Integer handSize;
    @JsonProperty("queueLengthLimit")
    private Integer queueLengthLimit;
    @JsonProperty("queues")
    private Integer queues;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public QueuingConfiguration() {
    }

    public QueuingConfiguration(Integer handSize, Integer queueLengthLimit, Integer queues) {
        super();
        this.handSize = handSize;
        this.queueLengthLimit = queueLengthLimit;
        this.queues = queues;
    }

    /**
     * `handSize` is a small positive number that configures the shuffle sharding of requests into queues.  When enqueuing a request at this priority level the request's flow identifier (a string pair) is hashed and the hash value is used to shuffle the list of queues and deal a hand of the size specified here.  The request is put into one of the shortest queues in that hand. `handSize` must be no larger than `queues`, and should be significantly smaller (so that a few heavy flows do not saturate most of the queues).  See the user-facing documentation for more extensive guidance on setting this field.  This field has a default value of 8.
     */
    @JsonProperty("handSize")
    public Integer getHandSize() {
        return handSize;
    }

    /**
     * `handSize` is a small positive number that configures the shuffle sharding of requests into queues.  When enqueuing a request at this priority level the request's flow identifier (a string pair) is hashed and the hash value is used to shuffle the list of queues and deal a hand of the size specified here.  The request is put into one of the shortest queues in that hand. `handSize` must be no larger than `queues`, and should be significantly smaller (so that a few heavy flows do not saturate most of the queues).  See the user-facing documentation for more extensive guidance on setting this field.  This field has a default value of 8.
     */
    @JsonProperty("handSize")
    public void setHandSize(Integer handSize) {
        this.handSize = handSize;
    }

    /**
     * `queueLengthLimit` is the maximum number of requests allowed to be waiting in a given queue of this priority level at a time; excess requests are rejected.  This value must be positive.  If not specified, it will be defaulted to 50.
     */
    @JsonProperty("queueLengthLimit")
    public Integer getQueueLengthLimit() {
        return queueLengthLimit;
    }

    /**
     * `queueLengthLimit` is the maximum number of requests allowed to be waiting in a given queue of this priority level at a time; excess requests are rejected.  This value must be positive.  If not specified, it will be defaulted to 50.
     */
    @JsonProperty("queueLengthLimit")
    public void setQueueLengthLimit(Integer queueLengthLimit) {
        this.queueLengthLimit = queueLengthLimit;
    }

    /**
     * `queues` is the number of queues for this priority level. The queues exist independently at each apiserver. The value must be positive.  Setting it to 1 effectively precludes shufflesharding and thus makes the distinguisher method of associated flow schemas irrelevant.  This field has a default value of 64.
     */
    @JsonProperty("queues")
    public Integer getQueues() {
        return queues;
    }

    /**
     * `queues` is the number of queues for this priority level. The queues exist independently at each apiserver. The value must be positive.  Setting it to 1 effectively precludes shufflesharding and thus makes the distinguisher method of associated flow schemas irrelevant.  This field has a default value of 64.
     */
    @JsonProperty("queues")
    public void setQueues(Integer queues) {
        this.queues = queues;
    }

    @JsonIgnore
    public QueuingConfigurationBuilder edit() {
        return new QueuingConfigurationBuilder(this);
    }

    @JsonIgnore
    public QueuingConfigurationBuilder toBuilder() {
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
        if (!(o instanceof QueuingConfiguration)) {
            return false;
        }
        QueuingConfiguration other = (QueuingConfiguration) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$handSize = this.getHandSize();
        Object other$handSize = other.getHandSize();
        if (this$handSize == null ? other$handSize != null : !this$handSize.equals(other$handSize)) {
            return false;
        }
        Object this$queueLengthLimit = this.getQueueLengthLimit();
        Object other$queueLengthLimit = other.getQueueLengthLimit();
        if (this$queueLengthLimit == null ? other$queueLengthLimit != null : !this$queueLengthLimit.equals(other$queueLengthLimit)) {
            return false;
        }
        Object this$queues = this.getQueues();
        Object other$queues = other.getQueues();
        if (this$queues == null ? other$queues != null : !this$queues.equals(other$queues)) {
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
        return other instanceof QueuingConfiguration;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $handSize = this.getHandSize();
        result = result * prime + ($handSize == null ? 43 : $handSize.hashCode());
        Object $queueLengthLimit = this.getQueueLengthLimit();
        result = result * prime + ($queueLengthLimit == null ? 43 : $queueLengthLimit.hashCode());
        Object $queues = this.getQueues();
        result = result * prime + ($queues == null ? 43 : $queues.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "QueuingConfiguration(" + "handSize=" + this.getHandSize() + ", queueLengthLimit=" + this.getQueueLengthLimit() + ", queues=" + this.getQueues() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
