
package io.fabric8.istio.api.api.telemetry.v1alpha1;

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
import io.fabric8.istio.api.api.type.v1beta1.PolicyTargetReference;
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelector;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accessLogging",
    "metrics",
    "selector",
    "targetRef",
    "targetRefs",
    "tracing"
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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1alpha1")
@Group("")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Telemetry implements Editable<TelemetryBuilder>, KubernetesResource, Namespaced
{

    @JsonProperty("accessLogging")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AccessLogging> accessLogging = new ArrayList<>();
    @JsonProperty("metrics")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Metrics> metrics = new ArrayList<>();
    @JsonProperty("selector")
    private WorkloadSelector selector;
    @JsonProperty("targetRef")
    private PolicyTargetReference targetRef;
    @JsonProperty("targetRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PolicyTargetReference> targetRefs = new ArrayList<>();
    @JsonProperty("tracing")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Tracing> tracing = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Telemetry() {
    }

    public Telemetry(List<AccessLogging> accessLogging, List<Metrics> metrics, WorkloadSelector selector, PolicyTargetReference targetRef, List<PolicyTargetReference> targetRefs, List<Tracing> tracing) {
        super();
        this.accessLogging = accessLogging;
        this.metrics = metrics;
        this.selector = selector;
        this.targetRef = targetRef;
        this.targetRefs = targetRefs;
        this.tracing = tracing;
    }

    @JsonProperty("accessLogging")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AccessLogging> getAccessLogging() {
        return accessLogging;
    }

    @JsonProperty("accessLogging")
    public void setAccessLogging(List<AccessLogging> accessLogging) {
        this.accessLogging = accessLogging;
    }

    @JsonProperty("metrics")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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

    @JsonProperty("targetRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PolicyTargetReference> getTargetRefs() {
        return targetRefs;
    }

    @JsonProperty("targetRefs")
    public void setTargetRefs(List<PolicyTargetReference> targetRefs) {
        this.targetRefs = targetRefs;
    }

    @JsonProperty("tracing")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Tracing> getTracing() {
        return tracing;
    }

    @JsonProperty("tracing")
    public void setTracing(List<Tracing> tracing) {
        this.tracing = tracing;
    }

    @JsonIgnore
    public TelemetryBuilder edit() {
        return new TelemetryBuilder(this);
    }

    @JsonIgnore
    public TelemetryBuilder toBuilder() {
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
