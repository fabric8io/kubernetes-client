
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * ChunkEncodingSpec configures per-chunk-type encoding overrides.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "floats"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ChunkEncodingSpec implements Editable<ChunkEncodingSpecBuilder>, KubernetesResource
{

    @JsonProperty("floats")
    private String floats;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ChunkEncodingSpec() {
    }

    public ChunkEncodingSpec(String floats) {
        super();
        this.floats = floats;
    }

    /**
     * floats selects the encoding used for float chunks. Valid values are "Xor" and "Xor2".<br><p> <br><p> Notice:<br><p>  &#42; Setting "Xor" is incompatible with --enable-feature=st-storage<br><p> (XOR chunks do not store start timestamps).<br><p>  &#42; Setting "Xor2" automatically adds the `xor2-encoding` feature flag.<br><p> <br><p> It requires Prometheus &gt;= v3.13.0.
     */
    @JsonProperty("floats")
    public String getFloats() {
        return floats;
    }

    /**
     * floats selects the encoding used for float chunks. Valid values are "Xor" and "Xor2".<br><p> <br><p> Notice:<br><p>  &#42; Setting "Xor" is incompatible with --enable-feature=st-storage<br><p> (XOR chunks do not store start timestamps).<br><p>  &#42; Setting "Xor2" automatically adds the `xor2-encoding` feature flag.<br><p> <br><p> It requires Prometheus &gt;= v3.13.0.
     */
    @JsonProperty("floats")
    public void setFloats(String floats) {
        this.floats = floats;
    }

    @JsonIgnore
    public ChunkEncodingSpecBuilder edit() {
        return new ChunkEncodingSpecBuilder(this);
    }

    @JsonIgnore
    public ChunkEncodingSpecBuilder toBuilder() {
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
        if (!(o instanceof ChunkEncodingSpec)) {
            return false;
        }
        ChunkEncodingSpec other = (ChunkEncodingSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$floats = this.getFloats();
        Object other$floats = other.getFloats();
        if (this$floats == null ? other$floats != null : !this$floats.equals(other$floats)) {
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
        return other instanceof ChunkEncodingSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $floats = this.getFloats();
        result = result * prime + ($floats == null ? 43 : $floats.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ChunkEncodingSpec(" + "floats=" + this.getFloats() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
