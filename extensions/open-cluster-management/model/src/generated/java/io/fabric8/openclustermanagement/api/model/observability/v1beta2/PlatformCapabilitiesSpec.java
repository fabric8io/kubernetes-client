
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
 * PlatformCapabilitiesSpec defines the observability capabilities managed by the addon for platform components.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "analytics",
    "logs",
    "metrics"
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
public class PlatformCapabilitiesSpec implements Editable<PlatformCapabilitiesSpecBuilder>, KubernetesResource
{

    @JsonProperty("analytics")
    private PlatformAnalyticsSpec analytics;
    @JsonProperty("logs")
    private PlatformLogsSpec logs;
    @JsonProperty("metrics")
    private PlatformMetricsSpec metrics;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PlatformCapabilitiesSpec() {
    }

    public PlatformCapabilitiesSpec(PlatformAnalyticsSpec analytics, PlatformLogsSpec logs, PlatformMetricsSpec metrics) {
        super();
        this.analytics = analytics;
        this.logs = logs;
        this.metrics = metrics;
    }

    /**
     * PlatformCapabilitiesSpec defines the observability capabilities managed by the addon for platform components.
     */
    @JsonProperty("analytics")
    public PlatformAnalyticsSpec getAnalytics() {
        return analytics;
    }

    /**
     * PlatformCapabilitiesSpec defines the observability capabilities managed by the addon for platform components.
     */
    @JsonProperty("analytics")
    public void setAnalytics(PlatformAnalyticsSpec analytics) {
        this.analytics = analytics;
    }

    /**
     * PlatformCapabilitiesSpec defines the observability capabilities managed by the addon for platform components.
     */
    @JsonProperty("logs")
    public PlatformLogsSpec getLogs() {
        return logs;
    }

    /**
     * PlatformCapabilitiesSpec defines the observability capabilities managed by the addon for platform components.
     */
    @JsonProperty("logs")
    public void setLogs(PlatformLogsSpec logs) {
        this.logs = logs;
    }

    /**
     * PlatformCapabilitiesSpec defines the observability capabilities managed by the addon for platform components.
     */
    @JsonProperty("metrics")
    public PlatformMetricsSpec getMetrics() {
        return metrics;
    }

    /**
     * PlatformCapabilitiesSpec defines the observability capabilities managed by the addon for platform components.
     */
    @JsonProperty("metrics")
    public void setMetrics(PlatformMetricsSpec metrics) {
        this.metrics = metrics;
    }

    @JsonIgnore
    public PlatformCapabilitiesSpecBuilder edit() {
        return new PlatformCapabilitiesSpecBuilder(this);
    }

    @JsonIgnore
    public PlatformCapabilitiesSpecBuilder toBuilder() {
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
        if (!(o instanceof PlatformCapabilitiesSpec)) {
            return false;
        }
        PlatformCapabilitiesSpec other = (PlatformCapabilitiesSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$analytics = this.getAnalytics();
        Object other$analytics = other.getAnalytics();
        if (this$analytics == null ? other$analytics != null : !this$analytics.equals(other$analytics)) {
            return false;
        }
        Object this$logs = this.getLogs();
        Object other$logs = other.getLogs();
        if (this$logs == null ? other$logs != null : !this$logs.equals(other$logs)) {
            return false;
        }
        Object this$metrics = this.getMetrics();
        Object other$metrics = other.getMetrics();
        if (this$metrics == null ? other$metrics != null : !this$metrics.equals(other$metrics)) {
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
        return other instanceof PlatformCapabilitiesSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $analytics = this.getAnalytics();
        result = result * prime + ($analytics == null ? 43 : $analytics.hashCode());
        Object $logs = this.getLogs();
        result = result * prime + ($logs == null ? 43 : $logs.hashCode());
        Object $metrics = this.getMetrics();
        result = result * prime + ($metrics == null ? 43 : $metrics.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PlatformCapabilitiesSpec(" + "analytics=" + this.getAnalytics() + ", logs=" + this.getLogs() + ", metrics=" + this.getMetrics() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
