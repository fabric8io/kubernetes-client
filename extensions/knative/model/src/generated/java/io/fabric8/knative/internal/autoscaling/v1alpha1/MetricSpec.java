
package io.fabric8.knative.internal.autoscaling.v1alpha1;

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
 * MetricSpec contains all values a metric collector needs to operate.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "panicWindow",
    "scrapeTarget",
    "stableWindow"
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
public class MetricSpec implements Editable<MetricSpecBuilder>, KubernetesResource
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
     */
    public MetricSpec() {
    }

    public MetricSpec(Long panicWindow, String scrapeTarget, Long stableWindow) {
        super();
        this.panicWindow = panicWindow;
        this.scrapeTarget = scrapeTarget;
        this.stableWindow = stableWindow;
    }

    /**
     * PanicWindow is the aggregation window for metrics where quick reactions are needed.
     */
    @JsonProperty("panicWindow")
    public Long getPanicWindow() {
        return panicWindow;
    }

    /**
     * PanicWindow is the aggregation window for metrics where quick reactions are needed.
     */
    @JsonProperty("panicWindow")
    public void setPanicWindow(Long panicWindow) {
        this.panicWindow = panicWindow;
    }

    /**
     * ScrapeTarget is the K8s service that publishes the metric endpoint.
     */
    @JsonProperty("scrapeTarget")
    public String getScrapeTarget() {
        return scrapeTarget;
    }

    /**
     * ScrapeTarget is the K8s service that publishes the metric endpoint.
     */
    @JsonProperty("scrapeTarget")
    public void setScrapeTarget(String scrapeTarget) {
        this.scrapeTarget = scrapeTarget;
    }

    /**
     * StableWindow is the aggregation window for metrics in a stable state.
     */
    @JsonProperty("stableWindow")
    public Long getStableWindow() {
        return stableWindow;
    }

    /**
     * StableWindow is the aggregation window for metrics in a stable state.
     */
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
        if (!(o instanceof MetricSpec)) {
            return false;
        }
        MetricSpec other = (MetricSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$panicWindow = this.getPanicWindow();
        Object other$panicWindow = other.getPanicWindow();
        if (this$panicWindow == null ? other$panicWindow != null : !this$panicWindow.equals(other$panicWindow)) {
            return false;
        }
        Object this$scrapeTarget = this.getScrapeTarget();
        Object other$scrapeTarget = other.getScrapeTarget();
        if (this$scrapeTarget == null ? other$scrapeTarget != null : !this$scrapeTarget.equals(other$scrapeTarget)) {
            return false;
        }
        Object this$stableWindow = this.getStableWindow();
        Object other$stableWindow = other.getStableWindow();
        if (this$stableWindow == null ? other$stableWindow != null : !this$stableWindow.equals(other$stableWindow)) {
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
        return other instanceof MetricSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $panicWindow = this.getPanicWindow();
        result = result * prime + ($panicWindow == null ? 43 : $panicWindow.hashCode());
        Object $scrapeTarget = this.getScrapeTarget();
        result = result * prime + ($scrapeTarget == null ? 43 : $scrapeTarget.hashCode());
        Object $stableWindow = this.getStableWindow();
        result = result * prime + ($stableWindow == null ? 43 : $stableWindow.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MetricSpec(" + "panicWindow=" + this.getPanicWindow() + ", scrapeTarget=" + this.getScrapeTarget() + ", stableWindow=" + this.getStableWindow() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
