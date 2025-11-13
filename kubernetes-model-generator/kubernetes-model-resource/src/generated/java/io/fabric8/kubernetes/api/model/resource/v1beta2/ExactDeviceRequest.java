
package io.fabric8.kubernetes.api.model.resource.v1beta2;

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
 * ExactDeviceRequest is a request for one or more identical devices.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "adminAccess",
    "allocationMode",
    "capacity",
    "count",
    "deviceClassName",
    "selectors",
    "tolerations"
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
public class ExactDeviceRequest implements Editable<ExactDeviceRequestBuilder>, KubernetesResource
{

    @JsonProperty("adminAccess")
    private Boolean adminAccess;
    @JsonProperty("allocationMode")
    private String allocationMode;
    @JsonProperty("capacity")
    private CapacityRequirements capacity;
    @JsonProperty("count")
    private Long count;
    @JsonProperty("deviceClassName")
    private String deviceClassName;
    @JsonProperty("selectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeviceSelector> selectors = new ArrayList<>();
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeviceToleration> tolerations = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ExactDeviceRequest() {
    }

    public ExactDeviceRequest(Boolean adminAccess, String allocationMode, CapacityRequirements capacity, Long count, String deviceClassName, List<DeviceSelector> selectors, List<DeviceToleration> tolerations) {
        super();
        this.adminAccess = adminAccess;
        this.allocationMode = allocationMode;
        this.capacity = capacity;
        this.count = count;
        this.deviceClassName = deviceClassName;
        this.selectors = selectors;
        this.tolerations = tolerations;
    }

    /**
     * AdminAccess indicates that this is a claim for administrative access to the device(s). Claims with AdminAccess are expected to be used for monitoring or other management services for a device.  They ignore all ordinary claims to the device with respect to access modes and any resource allocations.<br><p> <br><p> This is an alpha field and requires enabling the DRAAdminAccess feature gate. Admin access is disabled if this field is unset or set to false, otherwise it is enabled.
     */
    @JsonProperty("adminAccess")
    public Boolean getAdminAccess() {
        return adminAccess;
    }

    /**
     * AdminAccess indicates that this is a claim for administrative access to the device(s). Claims with AdminAccess are expected to be used for monitoring or other management services for a device.  They ignore all ordinary claims to the device with respect to access modes and any resource allocations.<br><p> <br><p> This is an alpha field and requires enabling the DRAAdminAccess feature gate. Admin access is disabled if this field is unset or set to false, otherwise it is enabled.
     */
    @JsonProperty("adminAccess")
    public void setAdminAccess(Boolean adminAccess) {
        this.adminAccess = adminAccess;
    }

    /**
     * AllocationMode and its related fields define how devices are allocated to satisfy this request. Supported values are:<br><p> <br><p> - ExactCount: This request is for a specific number of devices.<br><p>   This is the default. The exact number is provided in the<br><p>   count field.<br><p> <br><p> - All: This request is for all of the matching devices in a pool.<br><p>   At least one device must exist on the node for the allocation to succeed.<br><p>   Allocation will fail if some devices are already allocated,<br><p>   unless adminAccess is requested.<br><p> <br><p> If AllocationMode is not specified, the default mode is ExactCount. If the mode is ExactCount and count is not specified, the default count is one. Any other requests must specify this field.<br><p> <br><p> More modes may get added in the future. Clients must refuse to handle requests with unknown modes.
     */
    @JsonProperty("allocationMode")
    public String getAllocationMode() {
        return allocationMode;
    }

    /**
     * AllocationMode and its related fields define how devices are allocated to satisfy this request. Supported values are:<br><p> <br><p> - ExactCount: This request is for a specific number of devices.<br><p>   This is the default. The exact number is provided in the<br><p>   count field.<br><p> <br><p> - All: This request is for all of the matching devices in a pool.<br><p>   At least one device must exist on the node for the allocation to succeed.<br><p>   Allocation will fail if some devices are already allocated,<br><p>   unless adminAccess is requested.<br><p> <br><p> If AllocationMode is not specified, the default mode is ExactCount. If the mode is ExactCount and count is not specified, the default count is one. Any other requests must specify this field.<br><p> <br><p> More modes may get added in the future. Clients must refuse to handle requests with unknown modes.
     */
    @JsonProperty("allocationMode")
    public void setAllocationMode(String allocationMode) {
        this.allocationMode = allocationMode;
    }

    /**
     * ExactDeviceRequest is a request for one or more identical devices.
     */
    @JsonProperty("capacity")
    public CapacityRequirements getCapacity() {
        return capacity;
    }

    /**
     * ExactDeviceRequest is a request for one or more identical devices.
     */
    @JsonProperty("capacity")
    public void setCapacity(CapacityRequirements capacity) {
        this.capacity = capacity;
    }

    /**
     * Count is used only when the count mode is "ExactCount". Must be greater than zero. If AllocationMode is ExactCount and this field is not specified, the default is one.
     */
    @JsonProperty("count")
    public Long getCount() {
        return count;
    }

    /**
     * Count is used only when the count mode is "ExactCount". Must be greater than zero. If AllocationMode is ExactCount and this field is not specified, the default is one.
     */
    @JsonProperty("count")
    public void setCount(Long count) {
        this.count = count;
    }

    /**
     * DeviceClassName references a specific DeviceClass, which can define additional configuration and selectors to be inherited by this request.<br><p> <br><p> A DeviceClassName is required.<br><p> <br><p> Administrators may use this to restrict which devices may get requested by only installing classes with selectors for permitted devices. If users are free to request anything without restrictions, then administrators can create an empty DeviceClass for users to reference.
     */
    @JsonProperty("deviceClassName")
    public String getDeviceClassName() {
        return deviceClassName;
    }

    /**
     * DeviceClassName references a specific DeviceClass, which can define additional configuration and selectors to be inherited by this request.<br><p> <br><p> A DeviceClassName is required.<br><p> <br><p> Administrators may use this to restrict which devices may get requested by only installing classes with selectors for permitted devices. If users are free to request anything without restrictions, then administrators can create an empty DeviceClass for users to reference.
     */
    @JsonProperty("deviceClassName")
    public void setDeviceClassName(String deviceClassName) {
        this.deviceClassName = deviceClassName;
    }

    /**
     * Selectors define criteria which must be satisfied by a specific device in order for that device to be considered for this request. All selectors must be satisfied for a device to be considered.
     */
    @JsonProperty("selectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DeviceSelector> getSelectors() {
        return selectors;
    }

    /**
     * Selectors define criteria which must be satisfied by a specific device in order for that device to be considered for this request. All selectors must be satisfied for a device to be considered.
     */
    @JsonProperty("selectors")
    public void setSelectors(List<DeviceSelector> selectors) {
        this.selectors = selectors;
    }

    /**
     * If specified, the request's tolerations.<br><p> <br><p> Tolerations for NoSchedule are required to allocate a device which has a taint with that effect. The same applies to NoExecute.<br><p> <br><p> In addition, should any of the allocated devices get tainted with NoExecute after allocation and that effect is not tolerated, then all pods consuming the ResourceClaim get deleted to evict them. The scheduler will not let new pods reserve the claim while it has these tainted devices. Once all pods are evicted, the claim will get deallocated.<br><p> <br><p> The maximum number of tolerations is 16.<br><p> <br><p> This is an alpha field and requires enabling the DRADeviceTaints feature gate.
     */
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DeviceToleration> getTolerations() {
        return tolerations;
    }

    /**
     * If specified, the request's tolerations.<br><p> <br><p> Tolerations for NoSchedule are required to allocate a device which has a taint with that effect. The same applies to NoExecute.<br><p> <br><p> In addition, should any of the allocated devices get tainted with NoExecute after allocation and that effect is not tolerated, then all pods consuming the ResourceClaim get deleted to evict them. The scheduler will not let new pods reserve the claim while it has these tainted devices. Once all pods are evicted, the claim will get deallocated.<br><p> <br><p> The maximum number of tolerations is 16.<br><p> <br><p> This is an alpha field and requires enabling the DRADeviceTaints feature gate.
     */
    @JsonProperty("tolerations")
    public void setTolerations(List<DeviceToleration> tolerations) {
        this.tolerations = tolerations;
    }

    @JsonIgnore
    public ExactDeviceRequestBuilder edit() {
        return new ExactDeviceRequestBuilder(this);
    }

    @JsonIgnore
    public ExactDeviceRequestBuilder toBuilder() {
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
