
package io.fabric8.knative.internal.autoscaling.v1alpha1;

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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "panicWindow",
    "scrapeTarget",
    "stableWindow"
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
public class MetricSpec implements Editable<MetricSpecBuilder> , KubernetesResource
{

    @JsonProperty("panicWindow")
    private Long panicWindow;
    @JsonProperty("scrapeTarget")
    private String scrapeTarget;
    @JsonProperty("stableWindow")
    private Long stableWindow;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MetricSpec() {
    }

    public MetricSpec(Long panicWindow, String scrapeTarget, Long stableWindow) {
        super();
        this.panicWindow = panicWindow;
        this.scrapeTarget = scrapeTarget;
        this.stableWindow = stableWindow;
    }

    @JsonProperty("panicWindow")
    public Long getPanicWindow() {
        return panicWindow;
    }

    @JsonProperty("panicWindow")
    public void setPanicWindow(Long panicWindow) {
        this.panicWindow = panicWindow;
    }

    @JsonProperty("scrapeTarget")
    public String getScrapeTarget() {
        return scrapeTarget;
    }

    @JsonProperty("scrapeTarget")
    public void setScrapeTarget(String scrapeTarget) {
        this.scrapeTarget = scrapeTarget;
    }

    @JsonProperty("stableWindow")
    public Long getStableWindow() {
        return stableWindow;
    }

    @JsonProperty("stableWindow")
    public void setStableWindow(Long stableWindow) {
        this.stableWindow = stableWindow;
    }

    @JsonIgnore
    public MetricSpecBuilder edit() {
        return new MetricSpecBuilder(this);
    }

    @JsonIgnore
    public MetricSpecBuilder toBuilder() {
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
