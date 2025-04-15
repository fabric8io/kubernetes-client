
package io.fabric8.knative.duck.v1beta1;

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
import io.fabric8.knative.duck.v1.Destination;
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
 * DeliverySpec contains the delivery options for event senders, such as channelable and source.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "backoffDelay",
    "backoffPolicy",
    "deadLetterSink",
    "retry",
    "timeout"
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
public class DeliverySpec implements Editable<DeliverySpecBuilder>, KubernetesResource
{

    @JsonProperty("backoffDelay")
    private String backoffDelay;
    @JsonProperty("backoffPolicy")
    private String backoffPolicy;
    @JsonProperty("deadLetterSink")
    private Destination deadLetterSink;
    @JsonProperty("retry")
    private Integer retry;
    @JsonProperty("timeout")
    private String timeout;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DeliverySpec() {
    }

    public DeliverySpec(String backoffDelay, String backoffPolicy, Destination deadLetterSink, Integer retry, String timeout) {
        super();
        this.backoffDelay = backoffDelay;
        this.backoffPolicy = backoffPolicy;
        this.deadLetterSink = deadLetterSink;
        this.retry = retry;
        this.timeout = timeout;
    }

    /**
     * BackoffDelay is the delay before retrying. More information on Duration format:<br><p>  - https://www.iso.org/iso-8601-date-and-time-format.html<br><p>  - https://en.wikipedia.org/wiki/ISO_8601<br><p> <br><p> For linear policy, backoff delay is backoffDelay&#42;&lt;numberOfRetries&gt;. For exponential policy, backoff delay is backoffDelay&#42;2^&lt;numberOfRetries&gt;.
     */
    @JsonProperty("backoffDelay")
    public String getBackoffDelay() {
        return backoffDelay;
    }

    /**
     * BackoffDelay is the delay before retrying. More information on Duration format:<br><p>  - https://www.iso.org/iso-8601-date-and-time-format.html<br><p>  - https://en.wikipedia.org/wiki/ISO_8601<br><p> <br><p> For linear policy, backoff delay is backoffDelay&#42;&lt;numberOfRetries&gt;. For exponential policy, backoff delay is backoffDelay&#42;2^&lt;numberOfRetries&gt;.
     */
    @JsonProperty("backoffDelay")
    public void setBackoffDelay(String backoffDelay) {
        this.backoffDelay = backoffDelay;
    }

    /**
     * BackoffPolicy is the retry backoff policy (linear, exponential).
     */
    @JsonProperty("backoffPolicy")
    public String getBackoffPolicy() {
        return backoffPolicy;
    }

    /**
     * BackoffPolicy is the retry backoff policy (linear, exponential).
     */
    @JsonProperty("backoffPolicy")
    public void setBackoffPolicy(String backoffPolicy) {
        this.backoffPolicy = backoffPolicy;
    }

    /**
     * DeliverySpec contains the delivery options for event senders, such as channelable and source.
     */
    @JsonProperty("deadLetterSink")
    public Destination getDeadLetterSink() {
        return deadLetterSink;
    }

    /**
     * DeliverySpec contains the delivery options for event senders, such as channelable and source.
     */
    @JsonProperty("deadLetterSink")
    public void setDeadLetterSink(Destination deadLetterSink) {
        this.deadLetterSink = deadLetterSink;
    }

    /**
     * Retry is the minimum number of retries the sender should attempt when sending an event before moving it to the dead letter sink.
     */
    @JsonProperty("retry")
    public Integer getRetry() {
        return retry;
    }

    /**
     * Retry is the minimum number of retries the sender should attempt when sending an event before moving it to the dead letter sink.
     */
    @JsonProperty("retry")
    public void setRetry(Integer retry) {
        this.retry = retry;
    }

    /**
     * Timeout is the timeout of each single request. More information on Duration format:<br><p>  - https://www.iso.org/iso-8601-date-and-time-format.html<br><p>  - https://en.wikipedia.org/wiki/ISO_8601
     */
    @JsonProperty("timeout")
    public String getTimeout() {
        return timeout;
    }

    /**
     * Timeout is the timeout of each single request. More information on Duration format:<br><p>  - https://www.iso.org/iso-8601-date-and-time-format.html<br><p>  - https://en.wikipedia.org/wiki/ISO_8601
     */
    @JsonProperty("timeout")
    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    @JsonIgnore
    public DeliverySpecBuilder edit() {
        return new DeliverySpecBuilder(this);
    }

    @JsonIgnore
    public DeliverySpecBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
