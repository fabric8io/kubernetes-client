
package io.fabric8.openclustermanagement.api.model.shared;

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
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ObservabilityAddonSpec is the spec of observability addon.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "enableMetrics",
    "interval",
    "resources",
    "scrapeSizeLimitBytes",
    "workers"
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
public class ObservabilityAddonSpec implements Editable<ObservabilityAddonSpecBuilder>, KubernetesResource
{

    @JsonProperty("enableMetrics")
    private Boolean enableMetrics;
    @JsonProperty("interval")
    private Integer interval;
    @JsonProperty("resources")
    private ResourceRequirements resources;
    @JsonProperty("scrapeSizeLimitBytes")
    private Integer scrapeSizeLimitBytes;
    @JsonProperty("workers")
    private Integer workers;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ObservabilityAddonSpec() {
    }

    public ObservabilityAddonSpec(Boolean enableMetrics, Integer interval, ResourceRequirements resources, Integer scrapeSizeLimitBytes, Integer workers) {
        super();
        this.enableMetrics = enableMetrics;
        this.interval = interval;
        this.resources = resources;
        this.scrapeSizeLimitBytes = scrapeSizeLimitBytes;
        this.workers = workers;
    }

    /**
     * EnableMetrics indicates the observability addon push metrics to hub server.
     */
    @JsonProperty("enableMetrics")
    public Boolean getEnableMetrics() {
        return enableMetrics;
    }

    /**
     * EnableMetrics indicates the observability addon push metrics to hub server.
     */
    @JsonProperty("enableMetrics")
    public void setEnableMetrics(Boolean enableMetrics) {
        this.enableMetrics = enableMetrics;
    }

    /**
     * Interval for the observability addon push metrics to hub server.
     */
    @JsonProperty("interval")
    public Integer getInterval() {
        return interval;
    }

    /**
     * Interval for the observability addon push metrics to hub server.
     */
    @JsonProperty("interval")
    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    /**
     * ObservabilityAddonSpec is the spec of observability addon.
     */
    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

    /**
     * ObservabilityAddonSpec is the spec of observability addon.
     */
    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
        this.resources = resources;
    }

    /**
     * ScrapeSizeLimitBytes is the max size in bytes for a single metrics scrape from in-cluster Prometheus. Default is 1 GiB.
     */
    @JsonProperty("scrapeSizeLimitBytes")
    public Integer getScrapeSizeLimitBytes() {
        return scrapeSizeLimitBytes;
    }

    /**
     * ScrapeSizeLimitBytes is the max size in bytes for a single metrics scrape from in-cluster Prometheus. Default is 1 GiB.
     */
    @JsonProperty("scrapeSizeLimitBytes")
    public void setScrapeSizeLimitBytes(Integer scrapeSizeLimitBytes) {
        this.scrapeSizeLimitBytes = scrapeSizeLimitBytes;
    }

    /**
     * Workers is the number of workers in metrics-collector that work in parallel to push metrics to hub server. If set to &gt; 1, metrics-collector will shard /federate calls to Prometheus, based on matcher rules provided by allowlist. Ensure that number of matchers exceeds number of workers.
     */
    @JsonProperty("workers")
    public Integer getWorkers() {
        return workers;
    }

    /**
     * Workers is the number of workers in metrics-collector that work in parallel to push metrics to hub server. If set to &gt; 1, metrics-collector will shard /federate calls to Prometheus, based on matcher rules provided by allowlist. Ensure that number of matchers exceeds number of workers.
     */
    @JsonProperty("workers")
    public void setWorkers(Integer workers) {
        this.workers = workers;
    }

    @JsonIgnore
    public ObservabilityAddonSpecBuilder edit() {
        return new ObservabilityAddonSpecBuilder(this);
    }

    @JsonIgnore
    public ObservabilityAddonSpecBuilder toBuilder() {
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
