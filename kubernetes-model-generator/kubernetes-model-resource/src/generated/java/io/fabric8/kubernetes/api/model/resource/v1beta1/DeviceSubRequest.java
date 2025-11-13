
package io.fabric8.kubernetes.api.model.resource.v1beta1;

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
 * DeviceSubRequest describes a request for device provided in the claim.spec.devices.requests[].firstAvailable array. Each is typically a request for a single resource like a device, but can also ask for several identical devices.<br><p> <br><p> DeviceSubRequest is similar to Request, but doesn't expose the AdminAccess or FirstAvailable fields, as those can only be set on the top-level request. AdminAccess is not supported for requests with a prioritized list, and recursive FirstAvailable fields are not supported.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allocationMode",
    "capacity",
    "count",
    "deviceClassName",
    "name",
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
public class DeviceSubRequest implements Editable<DeviceSubRequestBuilder>, KubernetesResource
{

    @JsonProperty("allocationMode")
    private String allocationMode;
    @JsonProperty("capacity")
    private CapacityRequirements capacity;
    @JsonProperty("count")
    private Long count;
    @JsonProperty("deviceClassName")
    private String deviceClassName;
    @JsonProperty("name")
    private String name;
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
    public DeviceSubRequest() {
    }

    public DeviceSubRequest(String allocationMode, CapacityRequirements capacity, Long count, String deviceClassName, String name, List<DeviceSelector> selectors, List<DeviceToleration> tolerations) {
        super();
        this.allocationMode = allocationMode;
        this.capacity = capacity;
        this.count = count;
        this.deviceClassName = deviceClassName;
        this.name = name;
        this.selectors = selectors;
        this.tolerations = tolerations;
    }

    /**
     * AllocationMode and its related fields define how devices are allocated to satisfy this subrequest. Supported values are:<br><p> <br><p> - ExactCount: This request is for a specific number of devices.<br><p>   This is the default. The exact number is provided in the<br><p>   count field.<br><p> <br><p> - All: This subrequest is for all of the matching devices in a pool.<br><p>   Allocation will fail if some devices are already allocated,<br><p>   unless adminAccess is requested.<br><p> <br><p> If AllocationMode is not specified, the default mode is ExactCount. If the mode is ExactCount and count is not specified, the default count is one. Any other subrequests must specify this field.<br><p> <br><p> More modes may get added in the future. Clients must refuse to handle requests with unknown modes.
     */
    @JsonProperty("allocationMode")
    public String getAllocationMode() {
        return allocationMode;
    }

    /**
     * AllocationMode and its related fields define how devices are allocated to satisfy this subrequest. Supported values are:<br><p> <br><p> - ExactCount: This request is for a specific number of devices.<br><p>   This is the default. The exact number is provided in the<br><p>   count field.<br><p> <br><p> - All: This subrequest is for all of the matching devices in a pool.<br><p>   Allocation will fail if some devices are already allocated,<br><p>   unless adminAccess is requested.<br><p> <br><p> If AllocationMode is not specified, the default mode is ExactCount. If the mode is ExactCount and count is not specified, the default count is one. Any other subrequests must specify this field.<br><p> <br><p> More modes may get added in the future. Clients must refuse to handle requests with unknown modes.
     */
    @JsonProperty("allocationMode")
    public void setAllocationMode(String allocationMode) {
        this.allocationMode = allocationMode;
    }

    /**
     * DeviceSubRequest describes a request for device provided in the claim.spec.devices.requests[].firstAvailable array. Each is typically a request for a single resource like a device, but can also ask for several identical devices.<br><p> <br><p> DeviceSubRequest is similar to Request, but doesn't expose the AdminAccess or FirstAvailable fields, as those can only be set on the top-level request. AdminAccess is not supported for requests with a prioritized list, and recursive FirstAvailable fields are not supported.
     */
    @JsonProperty("capacity")
    public CapacityRequirements getCapacity() {
        return capacity;
    }

    /**
     * DeviceSubRequest describes a request for device provided in the claim.spec.devices.requests[].firstAvailable array. Each is typically a request for a single resource like a device, but can also ask for several identical devices.<br><p> <br><p> DeviceSubRequest is similar to Request, but doesn't expose the AdminAccess or FirstAvailable fields, as those can only be set on the top-level request. AdminAccess is not supported for requests with a prioritized list, and recursive FirstAvailable fields are not supported.
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
     * DeviceClassName references a specific DeviceClass, which can define additional configuration and selectors to be inherited by this subrequest.<br><p> <br><p> A class is required. Which classes are available depends on the cluster.<br><p> <br><p> Administrators may use this to restrict which devices may get requested by only installing classes with selectors for permitted devices. If users are free to request anything without restrictions, then administrators can create an empty DeviceClass for users to reference.
     */
    @JsonProperty("deviceClassName")
    public String getDeviceClassName() {
        return deviceClassName;
    }

    /**
     * DeviceClassName references a specific DeviceClass, which can define additional configuration and selectors to be inherited by this subrequest.<br><p> <br><p> A class is required. Which classes are available depends on the cluster.<br><p> <br><p> Administrators may use this to restrict which devices may get requested by only installing classes with selectors for permitted devices. If users are free to request anything without restrictions, then administrators can create an empty DeviceClass for users to reference.
     */
    @JsonProperty("deviceClassName")
    public void setDeviceClassName(String deviceClassName) {
        this.deviceClassName = deviceClassName;
    }

    /**
     * Name can be used to reference this subrequest in the list of constraints or the list of configurations for the claim. References must use the format &lt;main request&gt;/&lt;subrequest&gt;.<br><p> <br><p> Must be a DNS label.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name can be used to reference this subrequest in the list of constraints or the list of configurations for the claim. References must use the format &lt;main request&gt;/&lt;subrequest&gt;.<br><p> <br><p> Must be a DNS label.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Selectors define criteria which must be satisfied by a specific device in order for that device to be considered for this subrequest. All selectors must be satisfied for a device to be considered.
     */
    @JsonProperty("selectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DeviceSelector> getSelectors() {
        return selectors;
    }

    /**
     * Selectors define criteria which must be satisfied by a specific device in order for that device to be considered for this subrequest. All selectors must be satisfied for a device to be considered.
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
    public DeviceSubRequestBuilder edit() {
        return new DeviceSubRequestBuilder(this);
    }

    @JsonIgnore
    public DeviceSubRequestBuilder toBuilder() {
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
