
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
 * TagOverride specifies an operation to perform on a metric dimension (also known as a `label`). Tags may be added, removed, or have their default values overridden.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "operation",
    "value"
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
public class MetricsOverridesTagOverride implements Editable<MetricsOverridesTagOverrideBuilder>, KubernetesResource
{

    @JsonProperty("operation")
    private MetricsOverridesTagOverrideOperation operation;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MetricsOverridesTagOverride() {
    }

    public MetricsOverridesTagOverride(MetricsOverridesTagOverrideOperation operation, String value) {
        super();
        this.operation = operation;
        this.value = value;
    }

    /**
     * TagOverride specifies an operation to perform on a metric dimension (also known as a `label`). Tags may be added, removed, or have their default values overridden.
     */
    @JsonProperty("operation")
    public MetricsOverridesTagOverrideOperation getOperation() {
        return operation;
    }

    /**
     * TagOverride specifies an operation to perform on a metric dimension (also known as a `label`). Tags may be added, removed, or have their default values overridden.
     */
    @JsonProperty("operation")
    public void setOperation(MetricsOverridesTagOverrideOperation operation) {
        this.operation = operation;
    }

    /**
     * Value is only considered if the operation is `UPSERT`. Values are [CEL expressions](https://opensource.google/projects/cel) over attributes. Examples include: `string(destination.port)` and `request.host`. Istio exposes all standard [Envoy attributes](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/advanced/attributes). Additionally, Istio exposes node metadata as attributes. More information is provided in the [customization docs](https://istio.io/latest/docs/tasks/observability/metrics/customize-metrics/#use-expressions-for-values).
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * Value is only considered if the operation is `UPSERT`. Values are [CEL expressions](https://opensource.google/projects/cel) over attributes. Examples include: `string(destination.port)` and `request.host`. Istio exposes all standard [Envoy attributes](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/advanced/attributes). Additionally, Istio exposes node metadata as attributes. More information is provided in the [customization docs](https://istio.io/latest/docs/tasks/observability/metrics/customize-metrics/#use-expressions-for-values).
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonIgnore
    public MetricsOverridesTagOverrideBuilder edit() {
        return new MetricsOverridesTagOverrideBuilder(this);
    }

    @JsonIgnore
    public MetricsOverridesTagOverrideBuilder toBuilder() {
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
