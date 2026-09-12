
package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

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
 * OpenTelemetryCollectionSpec defines the spec for the addon to collect and forward observability signals from user workloads hosted on fleet managed clusters using the OpenTelemetryCollector with or without instrumentation.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "collector",
    "instrumentation"
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
public class OpenTelemetryCollectionSpec implements Editable<OpenTelemetryCollectionSpecBuilder>, KubernetesResource
{

    @JsonProperty("collector")
    private OpenTelemetryCollectorSpec collector;
    @JsonProperty("instrumentation")
    private InstrumentationSpec instrumentation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OpenTelemetryCollectionSpec() {
    }

    public OpenTelemetryCollectionSpec(OpenTelemetryCollectorSpec collector, InstrumentationSpec instrumentation) {
        super();
        this.collector = collector;
        this.instrumentation = instrumentation;
    }

    /**
     * OpenTelemetryCollectionSpec defines the spec for the addon to collect and forward observability signals from user workloads hosted on fleet managed clusters using the OpenTelemetryCollector with or without instrumentation.
     */
    @JsonProperty("collector")
    public OpenTelemetryCollectorSpec getCollector() {
        return collector;
    }

    /**
     * OpenTelemetryCollectionSpec defines the spec for the addon to collect and forward observability signals from user workloads hosted on fleet managed clusters using the OpenTelemetryCollector with or without instrumentation.
     */
    @JsonProperty("collector")
    public void setCollector(OpenTelemetryCollectorSpec collector) {
        this.collector = collector;
    }

    /**
     * OpenTelemetryCollectionSpec defines the spec for the addon to collect and forward observability signals from user workloads hosted on fleet managed clusters using the OpenTelemetryCollector with or without instrumentation.
     */
    @JsonProperty("instrumentation")
    public InstrumentationSpec getInstrumentation() {
        return instrumentation;
    }

    /**
     * OpenTelemetryCollectionSpec defines the spec for the addon to collect and forward observability signals from user workloads hosted on fleet managed clusters using the OpenTelemetryCollector with or without instrumentation.
     */
    @JsonProperty("instrumentation")
    public void setInstrumentation(InstrumentationSpec instrumentation) {
        this.instrumentation = instrumentation;
    }

    @JsonIgnore
    public OpenTelemetryCollectionSpecBuilder edit() {
        return new OpenTelemetryCollectionSpecBuilder(this);
    }

    @JsonIgnore
    public OpenTelemetryCollectionSpecBuilder toBuilder() {
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
        if (!(o instanceof OpenTelemetryCollectionSpec)) {
            return false;
        }
        OpenTelemetryCollectionSpec other = (OpenTelemetryCollectionSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$collector = this.getCollector();
        Object other$collector = other.getCollector();
        if (this$collector == null ? other$collector != null : !this$collector.equals(other$collector)) {
            return false;
        }
        Object this$instrumentation = this.getInstrumentation();
        Object other$instrumentation = other.getInstrumentation();
        if (this$instrumentation == null ? other$instrumentation != null : !this$instrumentation.equals(other$instrumentation)) {
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
        return other instanceof OpenTelemetryCollectionSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $collector = this.getCollector();
        result = result * prime + ($collector == null ? 43 : $collector.hashCode());
        Object $instrumentation = this.getInstrumentation();
        result = result * prime + ($instrumentation == null ? 43 : $instrumentation.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OpenTelemetryCollectionSpec(" + "collector=" + this.getCollector() + ", instrumentation=" + this.getInstrumentation() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
