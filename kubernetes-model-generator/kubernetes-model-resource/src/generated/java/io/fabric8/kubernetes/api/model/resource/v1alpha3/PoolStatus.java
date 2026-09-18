
package io.fabric8.kubernetes.api.model.resource.v1alpha3;

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
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * PoolStatus contains status information for a single resource pool.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allocatedDevices",
    "availableDevices",
    "driver",
    "generation",
    "nodeName",
    "partitionSummary",
    "poolName",
    "resourceSliceCount",
    "shareableSummary",
    "totalDevices",
    "unavailableDevices",
    "validationError"
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
public class PoolStatus implements Editable<PoolStatusBuilder>, KubernetesResource
{

    @JsonProperty("allocatedDevices")
    private Integer allocatedDevices;
    @JsonProperty("availableDevices")
    private Integer availableDevices;
    @JsonProperty("driver")
    private String driver;
    @JsonProperty("generation")
    private Long generation;
    @JsonProperty("nodeName")
    private String nodeName;
    @JsonProperty("partitionSummary")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PartitionTypeStatus> partitionSummary = new ArrayList<>();
    @JsonProperty("poolName")
    private String poolName;
    @JsonProperty("resourceSliceCount")
    private Integer resourceSliceCount;
    @JsonProperty("shareableSummary")
    private ShareableSummaryStatus shareableSummary;
    @JsonProperty("totalDevices")
    private Integer totalDevices;
    @JsonProperty("unavailableDevices")
    private Integer unavailableDevices;
    @JsonProperty("validationError")
    private String validationError;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PoolStatus() {
    }

    public PoolStatus(Integer allocatedDevices, Integer availableDevices, String driver, Long generation, String nodeName, List<PartitionTypeStatus> partitionSummary, String poolName, Integer resourceSliceCount, ShareableSummaryStatus shareableSummary, Integer totalDevices, Integer unavailableDevices, String validationError) {
        super();
        this.allocatedDevices = allocatedDevices;
        this.availableDevices = availableDevices;
        this.driver = driver;
        this.generation = generation;
        this.nodeName = nodeName;
        this.partitionSummary = partitionSummary;
        this.poolName = poolName;
        this.resourceSliceCount = resourceSliceCount;
        this.shareableSummary = shareableSummary;
        this.totalDevices = totalDevices;
        this.unavailableDevices = unavailableDevices;
        this.validationError = validationError;
    }

    /**
     * AllocatedDevices is the number of devices currently allocated to claims. A value of 0 means no devices are allocated. May be unset when validationError is set.
     */
    @JsonProperty("allocatedDevices")
    public Integer getAllocatedDevices() {
        return allocatedDevices;
    }

    /**
     * AllocatedDevices is the number of devices currently allocated to claims. A value of 0 means no devices are allocated. May be unset when validationError is set.
     */
    @JsonProperty("allocatedDevices")
    public void setAllocatedDevices(Integer allocatedDevices) {
        this.allocatedDevices = allocatedDevices;
    }

    /**
     * AvailableDevices is the number of devices available for allocation. This equals TotalDevices - AllocatedDevices - UnavailableDevices. A value of 0 means no devices are currently available. May be unset when validationError is set.
     */
    @JsonProperty("availableDevices")
    public Integer getAvailableDevices() {
        return availableDevices;
    }

    /**
     * AvailableDevices is the number of devices available for allocation. This equals TotalDevices - AllocatedDevices - UnavailableDevices. A value of 0 means no devices are currently available. May be unset when validationError is set.
     */
    @JsonProperty("availableDevices")
    public void setAvailableDevices(Integer availableDevices) {
        this.availableDevices = availableDevices;
    }

    /**
     * Driver is the DRA driver name for this pool. Must be a DNS subdomain (e.g., "gpu.example.com").
     */
    @JsonProperty("driver")
    public String getDriver() {
        return driver;
    }

    /**
     * Driver is the DRA driver name for this pool. Must be a DNS subdomain (e.g., "gpu.example.com").
     */
    @JsonProperty("driver")
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * Generation is the pool generation observed across all ResourceSlices in this pool. Only the latest generation is reported. During a generation rollout, if not all slices at the latest generation have been published, the pool is included with a validationError and device counts unset.
     */
    @JsonProperty("generation")
    public Long getGeneration() {
        return generation;
    }

    /**
     * Generation is the pool generation observed across all ResourceSlices in this pool. Only the latest generation is reported. During a generation rollout, if not all slices at the latest generation have been published, the pool is included with a validationError and device counts unset.
     */
    @JsonProperty("generation")
    public void setGeneration(Long generation) {
        this.generation = generation;
    }

    /**
     * NodeName is the node this pool is associated with. When omitted, the pool is not associated with a specific node. Must be a valid DNS subdomain name (RFC1123).
     */
    @JsonProperty("nodeName")
    public String getNodeName() {
        return nodeName;
    }

    /**
     * NodeName is the node this pool is associated with. When omitted, the pool is not associated with a specific node. Must be a valid DNS subdomain name (RFC1123).
     */
    @JsonProperty("nodeName")
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * PartitionSummary reports allocatability per (attribute, partition type) for a partitionable pool that publishes SharedCounters. Each entry names the grouping attribute it was resolved from: the PartitionTypeAttribute declared by a device's own slice, or for devices whose slice declares none, the default named in the request. A pool that mixes partitions declared under different attributes reports each independently. When no slice declares an attribute and the request names no default, the pool reports no partition summary.
     */
    @JsonProperty("partitionSummary")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PartitionTypeStatus> getPartitionSummary() {
        return partitionSummary;
    }

    /**
     * PartitionSummary reports allocatability per (attribute, partition type) for a partitionable pool that publishes SharedCounters. Each entry names the grouping attribute it was resolved from: the PartitionTypeAttribute declared by a device's own slice, or for devices whose slice declares none, the default named in the request. A pool that mixes partitions declared under different attributes reports each independently. When no slice declares an attribute and the request names no default, the pool reports no partition summary.
     */
    @JsonProperty("partitionSummary")
    public void setPartitionSummary(List<PartitionTypeStatus> partitionSummary) {
        this.partitionSummary = partitionSummary;
    }

    /**
     * PoolName is the name of the pool. Must be a valid resource pool name (DNS subdomains separated by "/").
     */
    @JsonProperty("poolName")
    public String getPoolName() {
        return poolName;
    }

    /**
     * PoolName is the name of the pool. Must be a valid resource pool name (DNS subdomains separated by "/").
     */
    @JsonProperty("poolName")
    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    /**
     * ResourceSliceCount is the number of ResourceSlices that make up this pool. May be unset when validationError is set.
     */
    @JsonProperty("resourceSliceCount")
    public Integer getResourceSliceCount() {
        return resourceSliceCount;
    }

    /**
     * ResourceSliceCount is the number of ResourceSlices that make up this pool. May be unset when validationError is set.
     */
    @JsonProperty("resourceSliceCount")
    public void setResourceSliceCount(Integer resourceSliceCount) {
        this.resourceSliceCount = resourceSliceCount;
    }

    /**
     * PoolStatus contains status information for a single resource pool.
     */
    @JsonProperty("shareableSummary")
    public ShareableSummaryStatus getShareableSummary() {
        return shareableSummary;
    }

    /**
     * PoolStatus contains status information for a single resource pool.
     */
    @JsonProperty("shareableSummary")
    public void setShareableSummary(ShareableSummaryStatus shareableSummary) {
        this.shareableSummary = shareableSummary;
    }

    /**
     * TotalDevices is the total number of devices in the pool across all slices. A value of 0 means the pool has no devices. May be unset when validationError is set.
     */
    @JsonProperty("totalDevices")
    public Integer getTotalDevices() {
        return totalDevices;
    }

    /**
     * TotalDevices is the total number of devices in the pool across all slices. A value of 0 means the pool has no devices. May be unset when validationError is set.
     */
    @JsonProperty("totalDevices")
    public void setTotalDevices(Integer totalDevices) {
        this.totalDevices = totalDevices;
    }

    /**
     * UnavailableDevices is the number of devices that are not available due to taints or other conditions, but are not allocated. A value of 0 means all unallocated devices are available. May be unset when validationError is set.
     */
    @JsonProperty("unavailableDevices")
    public Integer getUnavailableDevices() {
        return unavailableDevices;
    }

    /**
     * UnavailableDevices is the number of devices that are not available due to taints or other conditions, but are not allocated. A value of 0 means all unallocated devices are available. May be unset when validationError is set.
     */
    @JsonProperty("unavailableDevices")
    public void setUnavailableDevices(Integer unavailableDevices) {
        this.unavailableDevices = unavailableDevices;
    }

    /**
     * ValidationError is set when the pool's data could not be fully validated (e.g., incomplete slice publication). When set, device count fields and ResourceSliceCount may be unset.
     */
    @JsonProperty("validationError")
    public String getValidationError() {
        return validationError;
    }

    /**
     * ValidationError is set when the pool's data could not be fully validated (e.g., incomplete slice publication). When set, device count fields and ResourceSliceCount may be unset.
     */
    @JsonProperty("validationError")
    public void setValidationError(String validationError) {
        this.validationError = validationError;
    }

    @JsonIgnore
    public PoolStatusBuilder edit() {
        return new PoolStatusBuilder(this);
    }

    @JsonIgnore
    public PoolStatusBuilder toBuilder() {
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
        if (!(o instanceof PoolStatus)) {
            return false;
        }
        PoolStatus other = (PoolStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allocatedDevices = this.getAllocatedDevices();
        Object other$allocatedDevices = other.getAllocatedDevices();
        if (this$allocatedDevices == null ? other$allocatedDevices != null : !this$allocatedDevices.equals(other$allocatedDevices)) {
            return false;
        }
        Object this$availableDevices = this.getAvailableDevices();
        Object other$availableDevices = other.getAvailableDevices();
        if (this$availableDevices == null ? other$availableDevices != null : !this$availableDevices.equals(other$availableDevices)) {
            return false;
        }
        Object this$driver = this.getDriver();
        Object other$driver = other.getDriver();
        if (this$driver == null ? other$driver != null : !this$driver.equals(other$driver)) {
            return false;
        }
        Object this$generation = this.getGeneration();
        Object other$generation = other.getGeneration();
        if (this$generation == null ? other$generation != null : !this$generation.equals(other$generation)) {
            return false;
        }
        Object this$nodeName = this.getNodeName();
        Object other$nodeName = other.getNodeName();
        if (this$nodeName == null ? other$nodeName != null : !this$nodeName.equals(other$nodeName)) {
            return false;
        }
        Object this$partitionSummary = this.getPartitionSummary();
        Object other$partitionSummary = other.getPartitionSummary();
        if (this$partitionSummary == null ? other$partitionSummary != null : !this$partitionSummary.equals(other$partitionSummary)) {
            return false;
        }
        Object this$poolName = this.getPoolName();
        Object other$poolName = other.getPoolName();
        if (this$poolName == null ? other$poolName != null : !this$poolName.equals(other$poolName)) {
            return false;
        }
        Object this$resourceSliceCount = this.getResourceSliceCount();
        Object other$resourceSliceCount = other.getResourceSliceCount();
        if (this$resourceSliceCount == null ? other$resourceSliceCount != null : !this$resourceSliceCount.equals(other$resourceSliceCount)) {
            return false;
        }
        Object this$shareableSummary = this.getShareableSummary();
        Object other$shareableSummary = other.getShareableSummary();
        if (this$shareableSummary == null ? other$shareableSummary != null : !this$shareableSummary.equals(other$shareableSummary)) {
            return false;
        }
        Object this$totalDevices = this.getTotalDevices();
        Object other$totalDevices = other.getTotalDevices();
        if (this$totalDevices == null ? other$totalDevices != null : !this$totalDevices.equals(other$totalDevices)) {
            return false;
        }
        Object this$unavailableDevices = this.getUnavailableDevices();
        Object other$unavailableDevices = other.getUnavailableDevices();
        if (this$unavailableDevices == null ? other$unavailableDevices != null : !this$unavailableDevices.equals(other$unavailableDevices)) {
            return false;
        }
        Object this$validationError = this.getValidationError();
        Object other$validationError = other.getValidationError();
        if (this$validationError == null ? other$validationError != null : !this$validationError.equals(other$validationError)) {
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
        return other instanceof PoolStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allocatedDevices = this.getAllocatedDevices();
        result = result * prime + ($allocatedDevices == null ? 43 : $allocatedDevices.hashCode());
        Object $availableDevices = this.getAvailableDevices();
        result = result * prime + ($availableDevices == null ? 43 : $availableDevices.hashCode());
        Object $driver = this.getDriver();
        result = result * prime + ($driver == null ? 43 : $driver.hashCode());
        Object $generation = this.getGeneration();
        result = result * prime + ($generation == null ? 43 : $generation.hashCode());
        Object $nodeName = this.getNodeName();
        result = result * prime + ($nodeName == null ? 43 : $nodeName.hashCode());
        Object $partitionSummary = this.getPartitionSummary();
        result = result * prime + ($partitionSummary == null ? 43 : $partitionSummary.hashCode());
        Object $poolName = this.getPoolName();
        result = result * prime + ($poolName == null ? 43 : $poolName.hashCode());
        Object $resourceSliceCount = this.getResourceSliceCount();
        result = result * prime + ($resourceSliceCount == null ? 43 : $resourceSliceCount.hashCode());
        Object $shareableSummary = this.getShareableSummary();
        result = result * prime + ($shareableSummary == null ? 43 : $shareableSummary.hashCode());
        Object $totalDevices = this.getTotalDevices();
        result = result * prime + ($totalDevices == null ? 43 : $totalDevices.hashCode());
        Object $unavailableDevices = this.getUnavailableDevices();
        result = result * prime + ($unavailableDevices == null ? 43 : $unavailableDevices.hashCode());
        Object $validationError = this.getValidationError();
        result = result * prime + ($validationError == null ? 43 : $validationError.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PoolStatus(" + "allocatedDevices=" + this.getAllocatedDevices() + ", availableDevices=" + this.getAvailableDevices() + ", driver=" + this.getDriver() + ", generation=" + this.getGeneration() + ", nodeName=" + this.getNodeName() + ", partitionSummary=" + this.getPartitionSummary() + ", poolName=" + this.getPoolName() + ", resourceSliceCount=" + this.getResourceSliceCount() + ", shareableSummary=" + this.getShareableSummary() + ", totalDevices=" + this.getTotalDevices() + ", unavailableDevices=" + this.getUnavailableDevices() + ", validationError=" + this.getValidationError() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
