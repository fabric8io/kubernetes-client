
package io.fabric8.chaosmesh.v1alpha1;

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
 * BlockDelaySpec describes the block delay specification
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "correlation",
    "jitter",
    "latency"
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
public class BlockDelaySpec implements Editable<BlockDelaySpecBuilder>, KubernetesResource
{

    @JsonProperty("correlation")
    private String correlation;
    @JsonProperty("jitter")
    private String jitter;
    @JsonProperty("latency")
    private String latency;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BlockDelaySpec() {
    }

    public BlockDelaySpec(String correlation, String jitter, String latency) {
        super();
        this.correlation = correlation;
        this.jitter = jitter;
        this.latency = latency;
    }

    /**
     * BlockDelaySpec describes the block delay specification
     */
    @JsonProperty("correlation")
    public String getCorrelation() {
        return correlation;
    }

    /**
     * BlockDelaySpec describes the block delay specification
     */
    @JsonProperty("correlation")
    public void setCorrelation(String correlation) {
        this.correlation = correlation;
    }

    /**
     * BlockDelaySpec describes the block delay specification
     */
    @JsonProperty("jitter")
    public String getJitter() {
        return jitter;
    }

    /**
     * BlockDelaySpec describes the block delay specification
     */
    @JsonProperty("jitter")
    public void setJitter(String jitter) {
        this.jitter = jitter;
    }

    /**
     * Latency defines the latency of every io request.
     */
    @JsonProperty("latency")
    public String getLatency() {
        return latency;
    }

    /**
     * Latency defines the latency of every io request.
     */
    @JsonProperty("latency")
    public void setLatency(String latency) {
        this.latency = latency;
    }

    @JsonIgnore
    public BlockDelaySpecBuilder edit() {
        return new BlockDelaySpecBuilder(this);
    }

    @JsonIgnore
    public BlockDelaySpecBuilder toBuilder() {
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
        if (!(o instanceof BlockDelaySpec)) {
            return false;
        }
        BlockDelaySpec other = (BlockDelaySpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$correlation = this.getCorrelation();
        Object other$correlation = other.getCorrelation();
        if (this$correlation == null ? other$correlation != null : !this$correlation.equals(other$correlation)) {
            return false;
        }
        Object this$jitter = this.getJitter();
        Object other$jitter = other.getJitter();
        if (this$jitter == null ? other$jitter != null : !this$jitter.equals(other$jitter)) {
            return false;
        }
        Object this$latency = this.getLatency();
        Object other$latency = other.getLatency();
        if (this$latency == null ? other$latency != null : !this$latency.equals(other$latency)) {
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
        return other instanceof BlockDelaySpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $correlation = this.getCorrelation();
        result = result * prime + ($correlation == null ? 43 : $correlation.hashCode());
        Object $jitter = this.getJitter();
        result = result * prime + ($jitter == null ? 43 : $jitter.hashCode());
        Object $latency = this.getLatency();
        result = result * prime + ($latency == null ? 43 : $latency.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BlockDelaySpec(" + "correlation=" + this.getCorrelation() + ", jitter=" + this.getJitter() + ", latency=" + this.getLatency() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
