
package io.fabric8.chaosmesh.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bandwidth",
    "corrupt",
    "delay",
    "duplicate",
    "loss",
    "rate"
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
public class TcParameter implements Editable<TcParameterBuilder>, KubernetesResource
{

    @JsonProperty("bandwidth")
    private BandwidthSpec bandwidth;
    @JsonProperty("corrupt")
    private CorruptSpec corrupt;
    @JsonProperty("delay")
    private DelaySpec delay;
    @JsonProperty("duplicate")
    private DuplicateSpec duplicate;
    @JsonProperty("loss")
    private LossSpec loss;
    @JsonProperty("rate")
    private RateSpec rate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TcParameter() {
    }

    public TcParameter(BandwidthSpec bandwidth, CorruptSpec corrupt, DelaySpec delay, DuplicateSpec duplicate, LossSpec loss, RateSpec rate) {
        super();
        this.bandwidth = bandwidth;
        this.corrupt = corrupt;
        this.delay = delay;
        this.duplicate = duplicate;
        this.loss = loss;
        this.rate = rate;
    }

    @JsonProperty("bandwidth")
    public BandwidthSpec getBandwidth() {
        return bandwidth;
    }

    @JsonProperty("bandwidth")
    public void setBandwidth(BandwidthSpec bandwidth) {
        this.bandwidth = bandwidth;
    }

    @JsonProperty("corrupt")
    public CorruptSpec getCorrupt() {
        return corrupt;
    }

    @JsonProperty("corrupt")
    public void setCorrupt(CorruptSpec corrupt) {
        this.corrupt = corrupt;
    }

    @JsonProperty("delay")
    public DelaySpec getDelay() {
        return delay;
    }

    @JsonProperty("delay")
    public void setDelay(DelaySpec delay) {
        this.delay = delay;
    }

    @JsonProperty("duplicate")
    public DuplicateSpec getDuplicate() {
        return duplicate;
    }

    @JsonProperty("duplicate")
    public void setDuplicate(DuplicateSpec duplicate) {
        this.duplicate = duplicate;
    }

    @JsonProperty("loss")
    public LossSpec getLoss() {
        return loss;
    }

    @JsonProperty("loss")
    public void setLoss(LossSpec loss) {
        this.loss = loss;
    }

    @JsonProperty("rate")
    public RateSpec getRate() {
        return rate;
    }

    @JsonProperty("rate")
    public void setRate(RateSpec rate) {
        this.rate = rate;
    }

    @JsonIgnore
    public TcParameterBuilder edit() {
        return new TcParameterBuilder(this);
    }

    @JsonIgnore
    public TcParameterBuilder toBuilder() {
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
