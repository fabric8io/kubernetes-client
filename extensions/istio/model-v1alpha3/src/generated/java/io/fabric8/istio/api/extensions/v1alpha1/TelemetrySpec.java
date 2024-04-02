
package io.fabric8.istio.api.extensions.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.istio.api.networking.v1beta1.PolicyTargetReference;
import io.fabric8.istio.api.networking.v1beta1.WorkloadSelector;
import io.fabric8.istio.api.telemetry.v1alpha1.AccessLogging;
import io.fabric8.istio.api.telemetry.v1alpha1.Metrics;
import io.fabric8.istio.api.telemetry.v1alpha1.Tracing;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "accessLogging",
    "metrics",
    "selector",
    "targetRef",
    "tracing"
})
@ToString
@EqualsAndHashCode
@Setter
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
@Generated("jsonschema2pojo")
public class TelemetrySpec implements Editable<TelemetrySpecBuilder> , KubernetesResource
{

    @JsonProperty("accessLogging")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AccessLogging> accessLogging = new ArrayList<AccessLogging>();
    @JsonProperty("metrics")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Metrics> metrics = new ArrayList<Metrics>();
    @JsonProperty("selector")
    private WorkloadSelector selector;
    @JsonProperty("targetRef")
    private PolicyTargetReference targetRef;
    @JsonProperty("tracing")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Tracing> tracing = new ArrayList<Tracing>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TelemetrySpec() {
    }

    public TelemetrySpec(List<AccessLogging> accessLogging, List<Metrics> metrics, WorkloadSelector selector, PolicyTargetReference targetRef, List<Tracing> tracing) {
        super();
        this.accessLogging = accessLogging;
        this.metrics = metrics;
        this.selector = selector;
        this.targetRef = targetRef;
        this.tracing = tracing;
    }

    @JsonProperty("accessLogging")
    public List<AccessLogging> getAccessLogging() {
        return accessLogging;
    }

    @JsonProperty("accessLogging")
    public void setAccessLogging(List<AccessLogging> accessLogging) {
        this.accessLogging = accessLogging;
    }

    @JsonProperty("metrics")
    public List<Metrics> getMetrics() {
        return metrics;
    }

    @JsonProperty("metrics")
    public void setMetrics(List<Metrics> metrics) {
        this.metrics = metrics;
    }

    @JsonProperty("selector")
    public WorkloadSelector getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(WorkloadSelector selector) {
        this.selector = selector;
    }

    @JsonProperty("targetRef")
    public PolicyTargetReference getTargetRef() {
        return targetRef;
    }

    @JsonProperty("targetRef")
    public void setTargetRef(PolicyTargetReference targetRef) {
        this.targetRef = targetRef;
    }

    @JsonProperty("tracing")
    public List<Tracing> getTracing() {
        return tracing;
    }

    @JsonProperty("tracing")
    public void setTracing(List<Tracing> tracing) {
        this.tracing = tracing;
    }

    @JsonIgnore
    public TelemetrySpecBuilder edit() {
        return new TelemetrySpecBuilder(this);
    }

    @JsonIgnore
    public TelemetrySpecBuilder toBuilder() {
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

}
