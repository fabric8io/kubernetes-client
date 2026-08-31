
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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

}
