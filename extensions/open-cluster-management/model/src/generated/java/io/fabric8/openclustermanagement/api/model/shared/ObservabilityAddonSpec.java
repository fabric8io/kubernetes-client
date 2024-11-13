
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
@Generated("jsonschema2pojo")
public class ObservabilityAddonSpec implements Editable<ObservabilityAddonSpecBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("enableMetrics")
    public Boolean getEnableMetrics() {
        return enableMetrics;
    }

    @JsonProperty("enableMetrics")
    public void setEnableMetrics(Boolean enableMetrics) {
        this.enableMetrics = enableMetrics;
    }

    @JsonProperty("interval")
    public Integer getInterval() {
        return interval;
    }

    @JsonProperty("interval")
    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
        this.resources = resources;
    }

    @JsonProperty("scrapeSizeLimitBytes")
    public Integer getScrapeSizeLimitBytes() {
        return scrapeSizeLimitBytes;
    }

    @JsonProperty("scrapeSizeLimitBytes")
    public void setScrapeSizeLimitBytes(Integer scrapeSizeLimitBytes) {
        this.scrapeSizeLimitBytes = scrapeSizeLimitBytes;
    }

    @JsonProperty("workers")
    public Integer getWorkers() {
        return workers;
    }

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
