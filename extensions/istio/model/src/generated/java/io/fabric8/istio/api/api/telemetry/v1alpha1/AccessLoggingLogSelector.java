
package io.fabric8.istio.api.api.telemetry.v1alpha1;

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
 * LogSelector provides a coarse-grained ability to configure logging behavior based on certain traffic metadata (such as traffic direction). LogSelector applies to traffic metadata which is not represented in the attribute set currently supported by [filters](https://istio.io/latest/docs/reference/config/telemetry/#AccessLogging-Filter). It allows control planes to limit the configuration sent to individual workloads. Finer-grained logging behavior can be further configured via `filter`.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mode"
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
public class AccessLoggingLogSelector implements Editable<AccessLoggingLogSelectorBuilder>, KubernetesResource
{

    @JsonProperty("mode")
    private WorkloadMode mode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AccessLoggingLogSelector() {
    }

    public AccessLoggingLogSelector(WorkloadMode mode) {
        super();
        this.mode = mode;
    }

    /**
     * LogSelector provides a coarse-grained ability to configure logging behavior based on certain traffic metadata (such as traffic direction). LogSelector applies to traffic metadata which is not represented in the attribute set currently supported by [filters](https://istio.io/latest/docs/reference/config/telemetry/#AccessLogging-Filter). It allows control planes to limit the configuration sent to individual workloads. Finer-grained logging behavior can be further configured via `filter`.
     */
    @JsonProperty("mode")
    public WorkloadMode getMode() {
        return mode;
    }

    /**
     * LogSelector provides a coarse-grained ability to configure logging behavior based on certain traffic metadata (such as traffic direction). LogSelector applies to traffic metadata which is not represented in the attribute set currently supported by [filters](https://istio.io/latest/docs/reference/config/telemetry/#AccessLogging-Filter). It allows control planes to limit the configuration sent to individual workloads. Finer-grained logging behavior can be further configured via `filter`.
     */
    @JsonProperty("mode")
    public void setMode(WorkloadMode mode) {
        this.mode = mode;
    }

    @JsonIgnore
    public AccessLoggingLogSelectorBuilder edit() {
        return new AccessLoggingLogSelectorBuilder(this);
    }

    @JsonIgnore
    public AccessLoggingLogSelectorBuilder toBuilder() {
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
