
package io.fabric8.istio.api.telemetry.v1alpha1;

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
    "customTags",
    "disableSpanReporting",
    "match",
    "providers",
    "randomSamplingPercentage",
    "useRequestIdForTraceSampling"
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
public class Tracing implements Editable<TracingBuilder> , KubernetesResource
{

    @JsonProperty("customTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, TracingCustomTag> customTags = new LinkedHashMap<String, TracingCustomTag>();
    @JsonProperty("disableSpanReporting")
    private Boolean disableSpanReporting;
    @JsonProperty("match")
    private TracingTracingSelector match;
    @JsonProperty("providers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ProviderRef> providers = new ArrayList<ProviderRef>();
    @JsonProperty("randomSamplingPercentage")
    private Double randomSamplingPercentage;
    @JsonProperty("useRequestIdForTraceSampling")
    private Boolean useRequestIdForTraceSampling;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Tracing() {
    }

    public Tracing(Map<String, TracingCustomTag> customTags, Boolean disableSpanReporting, TracingTracingSelector match, List<ProviderRef> providers, Double randomSamplingPercentage, Boolean useRequestIdForTraceSampling) {
        super();
        this.customTags = customTags;
        this.disableSpanReporting = disableSpanReporting;
        this.match = match;
        this.providers = providers;
        this.randomSamplingPercentage = randomSamplingPercentage;
        this.useRequestIdForTraceSampling = useRequestIdForTraceSampling;
    }

    @JsonProperty("customTags")
    public Map<String, TracingCustomTag> getCustomTags() {
        return customTags;
    }

    @JsonProperty("customTags")
    public void setCustomTags(Map<String, TracingCustomTag> customTags) {
        this.customTags = customTags;
    }

    @JsonProperty("disableSpanReporting")
    public Boolean getDisableSpanReporting() {
        return disableSpanReporting;
    }

    @JsonProperty("disableSpanReporting")
    public void setDisableSpanReporting(Boolean disableSpanReporting) {
        this.disableSpanReporting = disableSpanReporting;
    }

    @JsonProperty("match")
    public TracingTracingSelector getMatch() {
        return match;
    }

    @JsonProperty("match")
    public void setMatch(TracingTracingSelector match) {
        this.match = match;
    }

    @JsonProperty("providers")
    public List<ProviderRef> getProviders() {
        return providers;
    }

    @JsonProperty("providers")
    public void setProviders(List<ProviderRef> providers) {
        this.providers = providers;
    }

    @JsonProperty("randomSamplingPercentage")
    public Double getRandomSamplingPercentage() {
        return randomSamplingPercentage;
    }

    @JsonProperty("randomSamplingPercentage")
    public void setRandomSamplingPercentage(Double randomSamplingPercentage) {
        this.randomSamplingPercentage = randomSamplingPercentage;
    }

    @JsonProperty("useRequestIdForTraceSampling")
    public Boolean getUseRequestIdForTraceSampling() {
        return useRequestIdForTraceSampling;
    }

    @JsonProperty("useRequestIdForTraceSampling")
    public void setUseRequestIdForTraceSampling(Boolean useRequestIdForTraceSampling) {
        this.useRequestIdForTraceSampling = useRequestIdForTraceSampling;
    }

    @JsonIgnore
    public TracingBuilder edit() {
        return new TracingBuilder(this);
    }

    @JsonIgnore
    public TracingBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
