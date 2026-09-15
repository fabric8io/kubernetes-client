
package io.fabric8.autoscaling.api.model.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ContainerResourcePolicy controls how autoscaler computes the recommended resources for a specific container.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "containerName",
    "controlledResources",
    "controlledValues",
    "maxAllowed",
    "memoryAggregationIntervalCount",
    "memoryAggregationIntervalSeconds",
    "minAllowed",
    "mode",
    "oomBumpUpRatio",
    "oomMinBumpUp",
    "startupBoost"
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
public class ContainerResourcePolicy implements Editable<ContainerResourcePolicyBuilder>, KubernetesResource
{

    @JsonProperty("containerName")
    private String containerName;
    @JsonProperty("controlledResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> controlledResources = new ArrayList<>();
    @JsonProperty("controlledValues")
    private String controlledValues;
    @JsonProperty("maxAllowed")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> maxAllowed = new LinkedHashMap<>();
    @JsonProperty("memoryAggregationIntervalCount")
    private Long memoryAggregationIntervalCount;
    @JsonProperty("memoryAggregationIntervalSeconds")
    private Integer memoryAggregationIntervalSeconds;
    @JsonProperty("minAllowed")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> minAllowed = new LinkedHashMap<>();
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("oomBumpUpRatio")
    private Quantity oomBumpUpRatio;
    @JsonProperty("oomMinBumpUp")
    private Quantity oomMinBumpUp;
    @JsonProperty("startupBoost")
    private StartupBoost startupBoost;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ContainerResourcePolicy() {
    }

    public ContainerResourcePolicy(String containerName, List<String> controlledResources, String controlledValues, Map<String, Quantity> maxAllowed, Long memoryAggregationIntervalCount, Integer memoryAggregationIntervalSeconds, Map<String, Quantity> minAllowed, String mode, Quantity oomBumpUpRatio, Quantity oomMinBumpUp, StartupBoost startupBoost) {
        super();
        this.containerName = containerName;
        this.controlledResources = controlledResources;
        this.controlledValues = controlledValues;
        this.maxAllowed = maxAllowed;
        this.memoryAggregationIntervalCount = memoryAggregationIntervalCount;
        this.memoryAggregationIntervalSeconds = memoryAggregationIntervalSeconds;
        this.minAllowed = minAllowed;
        this.mode = mode;
        this.oomBumpUpRatio = oomBumpUpRatio;
        this.oomMinBumpUp = oomMinBumpUp;
        this.startupBoost = startupBoost;
    }

    /**
     * Name of the container or DefaultContainerResourcePolicy, in which case the policy is used by the containers that don't have their own policy specified.
     */
    @JsonProperty("containerName")
    public String getContainerName() {
        return containerName;
    }

    /**
     * Name of the container or DefaultContainerResourcePolicy, in which case the policy is used by the containers that don't have their own policy specified.
     */
    @JsonProperty("containerName")
    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    /**
     * Specifies the type of recommendations that will be computed (and possibly applied) by VPA. If not specified, the default of [ResourceCPU, ResourceMemory] will be used.
     */
    @JsonProperty("controlledResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getControlledResources() {
        return controlledResources;
    }

    /**
     * Specifies the type of recommendations that will be computed (and possibly applied) by VPA. If not specified, the default of [ResourceCPU, ResourceMemory] will be used.
     */
    @JsonProperty("controlledResources")
    public void setControlledResources(List<String> controlledResources) {
        this.controlledResources = controlledResources;
    }

    /**
     * Specifies which resource values should be controlled. The default is "RequestsAndLimits".
     */
    @JsonProperty("controlledValues")
    public String getControlledValues() {
        return controlledValues;
    }

    /**
     * Specifies which resource values should be controlled. The default is "RequestsAndLimits".
     */
    @JsonProperty("controlledValues")
    public void setControlledValues(String controlledValues) {
        this.controlledValues = controlledValues;
    }

    /**
     * Specifies the maximum amount of resources that will be recommended for the container. The default is no maximum.
     */
    @JsonProperty("maxAllowed")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getMaxAllowed() {
        return maxAllowed;
    }

    /**
     * Specifies the maximum amount of resources that will be recommended for the container. The default is no maximum.
     */
    @JsonProperty("maxAllowed")
    public void setMaxAllowed(Map<String, Quantity> maxAllowed) {
        this.maxAllowed = maxAllowed;
    }

    /**
     * memoryAggregationIntervalCount is the number of consecutive memoryAggregationIntervals which make up the memory aggregation window. The total window length is: MemoryAggregationIntervalSeconds &#42; MemoryAggregationIntervalCount.
     */
    @JsonProperty("memoryAggregationIntervalCount")
    public Long getMemoryAggregationIntervalCount() {
        return memoryAggregationIntervalCount;
    }

    /**
     * memoryAggregationIntervalCount is the number of consecutive memoryAggregationIntervals which make up the memory aggregation window. The total window length is: MemoryAggregationIntervalSeconds &#42; MemoryAggregationIntervalCount.
     */
    @JsonProperty("memoryAggregationIntervalCount")
    public void setMemoryAggregationIntervalCount(Long memoryAggregationIntervalCount) {
        this.memoryAggregationIntervalCount = memoryAggregationIntervalCount;
    }

    /**
     * memoryAggregationIntervalSeconds is the length of a single interval (in seconds) for which the peak memory usage is computed. Memory usage peaks are aggregated in multiples of this interval. In other words, there is one memory usage sample per interval (the maximum usage over that interval).
     */
    @JsonProperty("memoryAggregationIntervalSeconds")
    public Integer getMemoryAggregationIntervalSeconds() {
        return memoryAggregationIntervalSeconds;
    }

    /**
     * memoryAggregationIntervalSeconds is the length of a single interval (in seconds) for which the peak memory usage is computed. Memory usage peaks are aggregated in multiples of this interval. In other words, there is one memory usage sample per interval (the maximum usage over that interval).
     */
    @JsonProperty("memoryAggregationIntervalSeconds")
    public void setMemoryAggregationIntervalSeconds(Integer memoryAggregationIntervalSeconds) {
        this.memoryAggregationIntervalSeconds = memoryAggregationIntervalSeconds;
    }

    /**
     * Specifies the minimal amount of resources that will be recommended for the container. The default is no minimum.
     */
    @JsonProperty("minAllowed")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getMinAllowed() {
        return minAllowed;
    }

    /**
     * Specifies the minimal amount of resources that will be recommended for the container. The default is no minimum.
     */
    @JsonProperty("minAllowed")
    public void setMinAllowed(Map<String, Quantity> minAllowed) {
        this.minAllowed = minAllowed;
    }

    /**
     * Whether autoscaler is enabled for the container. The default is "Auto".
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * Whether autoscaler is enabled for the container. The default is "Auto".
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * ContainerResourcePolicy controls how autoscaler computes the recommended resources for a specific container.
     */
    @JsonProperty("oomBumpUpRatio")
    public Quantity getOomBumpUpRatio() {
        return oomBumpUpRatio;
    }

    /**
     * ContainerResourcePolicy controls how autoscaler computes the recommended resources for a specific container.
     */
    @JsonProperty("oomBumpUpRatio")
    public void setOomBumpUpRatio(Quantity oomBumpUpRatio) {
        this.oomBumpUpRatio = oomBumpUpRatio;
    }

    /**
     * ContainerResourcePolicy controls how autoscaler computes the recommended resources for a specific container.
     */
    @JsonProperty("oomMinBumpUp")
    public Quantity getOomMinBumpUp() {
        return oomMinBumpUp;
    }

    /**
     * ContainerResourcePolicy controls how autoscaler computes the recommended resources for a specific container.
     */
    @JsonProperty("oomMinBumpUp")
    public void setOomMinBumpUp(Quantity oomMinBumpUp) {
        this.oomMinBumpUp = oomMinBumpUp;
    }

    /**
     * ContainerResourcePolicy controls how autoscaler computes the recommended resources for a specific container.
     */
    @JsonProperty("startupBoost")
    public StartupBoost getStartupBoost() {
        return startupBoost;
    }

    /**
     * ContainerResourcePolicy controls how autoscaler computes the recommended resources for a specific container.
     */
    @JsonProperty("startupBoost")
    public void setStartupBoost(StartupBoost startupBoost) {
        this.startupBoost = startupBoost;
    }

    @JsonIgnore
    public ContainerResourcePolicyBuilder edit() {
        return new ContainerResourcePolicyBuilder(this);
    }

    @JsonIgnore
    public ContainerResourcePolicyBuilder toBuilder() {
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
        if (!(o instanceof ContainerResourcePolicy)) {
            return false;
        }
        ContainerResourcePolicy other = (ContainerResourcePolicy) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$containerName = this.getContainerName();
        Object other$containerName = other.getContainerName();
        if (this$containerName == null ? other$containerName != null : !this$containerName.equals(other$containerName)) {
            return false;
        }
        Object this$controlledResources = this.getControlledResources();
        Object other$controlledResources = other.getControlledResources();
        if (this$controlledResources == null ? other$controlledResources != null : !this$controlledResources.equals(other$controlledResources)) {
            return false;
        }
        Object this$controlledValues = this.getControlledValues();
        Object other$controlledValues = other.getControlledValues();
        if (this$controlledValues == null ? other$controlledValues != null : !this$controlledValues.equals(other$controlledValues)) {
            return false;
        }
        Object this$maxAllowed = this.getMaxAllowed();
        Object other$maxAllowed = other.getMaxAllowed();
        if (this$maxAllowed == null ? other$maxAllowed != null : !this$maxAllowed.equals(other$maxAllowed)) {
            return false;
        }
        Object this$memoryAggregationIntervalCount = this.getMemoryAggregationIntervalCount();
        Object other$memoryAggregationIntervalCount = other.getMemoryAggregationIntervalCount();
        if (this$memoryAggregationIntervalCount == null ? other$memoryAggregationIntervalCount != null : !this$memoryAggregationIntervalCount.equals(other$memoryAggregationIntervalCount)) {
            return false;
        }
        Object this$memoryAggregationIntervalSeconds = this.getMemoryAggregationIntervalSeconds();
        Object other$memoryAggregationIntervalSeconds = other.getMemoryAggregationIntervalSeconds();
        if (this$memoryAggregationIntervalSeconds == null ? other$memoryAggregationIntervalSeconds != null : !this$memoryAggregationIntervalSeconds.equals(other$memoryAggregationIntervalSeconds)) {
            return false;
        }
        Object this$minAllowed = this.getMinAllowed();
        Object other$minAllowed = other.getMinAllowed();
        if (this$minAllowed == null ? other$minAllowed != null : !this$minAllowed.equals(other$minAllowed)) {
            return false;
        }
        Object this$mode = this.getMode();
        Object other$mode = other.getMode();
        if (this$mode == null ? other$mode != null : !this$mode.equals(other$mode)) {
            return false;
        }
        Object this$oomBumpUpRatio = this.getOomBumpUpRatio();
        Object other$oomBumpUpRatio = other.getOomBumpUpRatio();
        if (this$oomBumpUpRatio == null ? other$oomBumpUpRatio != null : !this$oomBumpUpRatio.equals(other$oomBumpUpRatio)) {
            return false;
        }
        Object this$oomMinBumpUp = this.getOomMinBumpUp();
        Object other$oomMinBumpUp = other.getOomMinBumpUp();
        if (this$oomMinBumpUp == null ? other$oomMinBumpUp != null : !this$oomMinBumpUp.equals(other$oomMinBumpUp)) {
            return false;
        }
        Object this$startupBoost = this.getStartupBoost();
        Object other$startupBoost = other.getStartupBoost();
        if (this$startupBoost == null ? other$startupBoost != null : !this$startupBoost.equals(other$startupBoost)) {
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
        return other instanceof ContainerResourcePolicy;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $containerName = this.getContainerName();
        result = result * prime + ($containerName == null ? 43 : $containerName.hashCode());
        Object $controlledResources = this.getControlledResources();
        result = result * prime + ($controlledResources == null ? 43 : $controlledResources.hashCode());
        Object $controlledValues = this.getControlledValues();
        result = result * prime + ($controlledValues == null ? 43 : $controlledValues.hashCode());
        Object $maxAllowed = this.getMaxAllowed();
        result = result * prime + ($maxAllowed == null ? 43 : $maxAllowed.hashCode());
        Object $memoryAggregationIntervalCount = this.getMemoryAggregationIntervalCount();
        result = result * prime + ($memoryAggregationIntervalCount == null ? 43 : $memoryAggregationIntervalCount.hashCode());
        Object $memoryAggregationIntervalSeconds = this.getMemoryAggregationIntervalSeconds();
        result = result * prime + ($memoryAggregationIntervalSeconds == null ? 43 : $memoryAggregationIntervalSeconds.hashCode());
        Object $minAllowed = this.getMinAllowed();
        result = result * prime + ($minAllowed == null ? 43 : $minAllowed.hashCode());
        Object $mode = this.getMode();
        result = result * prime + ($mode == null ? 43 : $mode.hashCode());
        Object $oomBumpUpRatio = this.getOomBumpUpRatio();
        result = result * prime + ($oomBumpUpRatio == null ? 43 : $oomBumpUpRatio.hashCode());
        Object $oomMinBumpUp = this.getOomMinBumpUp();
        result = result * prime + ($oomMinBumpUp == null ? 43 : $oomMinBumpUp.hashCode());
        Object $startupBoost = this.getStartupBoost();
        result = result * prime + ($startupBoost == null ? 43 : $startupBoost.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ContainerResourcePolicy(" + "containerName=" + this.getContainerName() + ", controlledResources=" + this.getControlledResources() + ", controlledValues=" + this.getControlledValues() + ", maxAllowed=" + this.getMaxAllowed() + ", memoryAggregationIntervalCount=" + this.getMemoryAggregationIntervalCount() + ", memoryAggregationIntervalSeconds=" + this.getMemoryAggregationIntervalSeconds() + ", minAllowed=" + this.getMinAllowed() + ", mode=" + this.getMode() + ", oomBumpUpRatio=" + this.getOomBumpUpRatio() + ", oomMinBumpUp=" + this.getOomMinBumpUp() + ", startupBoost=" + this.getStartupBoost() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
