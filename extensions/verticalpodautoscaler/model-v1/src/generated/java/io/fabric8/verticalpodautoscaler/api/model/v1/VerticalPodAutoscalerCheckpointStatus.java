
package io.fabric8.verticalpodautoscaler.api.model.v1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
    "cpuHistogram",
    "firstSampleStart",
    "lastSampleStart",
    "lastUpdateTime",
    "memoryHistogram",
    "totalSamplesCount",
    "version"
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
public class VerticalPodAutoscalerCheckpointStatus implements KubernetesResource
{

    @JsonProperty("cpuHistogram")
    private HistogramCheckpoint cpuHistogram;
    @JsonProperty("firstSampleStart")
    private String firstSampleStart;
    @JsonProperty("lastSampleStart")
    private String lastSampleStart;
    @JsonProperty("lastUpdateTime")
    private String lastUpdateTime;
    @JsonProperty("memoryHistogram")
    private HistogramCheckpoint memoryHistogram;
    @JsonProperty("totalSamplesCount")
    private Integer totalSamplesCount;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VerticalPodAutoscalerCheckpointStatus() {
    }

    /**
     * 
     * @param memoryHistogram
     * @param firstSampleStart
     * @param lastSampleStart
     * @param totalSamplesCount
     * @param cpuHistogram
     * @param version
     * @param lastUpdateTime
     */
    public VerticalPodAutoscalerCheckpointStatus(HistogramCheckpoint cpuHistogram, String firstSampleStart, String lastSampleStart, String lastUpdateTime, HistogramCheckpoint memoryHistogram, Integer totalSamplesCount, String version) {
        super();
        this.cpuHistogram = cpuHistogram;
        this.firstSampleStart = firstSampleStart;
        this.lastSampleStart = lastSampleStart;
        this.lastUpdateTime = lastUpdateTime;
        this.memoryHistogram = memoryHistogram;
        this.totalSamplesCount = totalSamplesCount;
        this.version = version;
    }

    @JsonProperty("cpuHistogram")
    public HistogramCheckpoint getCpuHistogram() {
        return cpuHistogram;
    }

    @JsonProperty("cpuHistogram")
    public void setCpuHistogram(HistogramCheckpoint cpuHistogram) {
        this.cpuHistogram = cpuHistogram;
    }

    @JsonProperty("firstSampleStart")
    public String getFirstSampleStart() {
        return firstSampleStart;
    }

    @JsonProperty("firstSampleStart")
    public void setFirstSampleStart(String firstSampleStart) {
        this.firstSampleStart = firstSampleStart;
    }

    @JsonProperty("lastSampleStart")
    public String getLastSampleStart() {
        return lastSampleStart;
    }

    @JsonProperty("lastSampleStart")
    public void setLastSampleStart(String lastSampleStart) {
        this.lastSampleStart = lastSampleStart;
    }

    @JsonProperty("lastUpdateTime")
    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    @JsonProperty("lastUpdateTime")
    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @JsonProperty("memoryHistogram")
    public HistogramCheckpoint getMemoryHistogram() {
        return memoryHistogram;
    }

    @JsonProperty("memoryHistogram")
    public void setMemoryHistogram(HistogramCheckpoint memoryHistogram) {
        this.memoryHistogram = memoryHistogram;
    }

    @JsonProperty("totalSamplesCount")
    public Integer getTotalSamplesCount() {
        return totalSamplesCount;
    }

    @JsonProperty("totalSamplesCount")
    public void setTotalSamplesCount(Integer totalSamplesCount) {
        this.totalSamplesCount = totalSamplesCount;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
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
