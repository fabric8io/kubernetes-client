
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
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * DeviceRequestAllocationResult contains the allocation result for one request.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "adminAccess",
    "bindingConditions",
    "bindingFailureConditions",
    "consumedCapacity",
    "device",
    "driver",
    "pool",
    "request",
    "shareID",
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
public class DeviceRequestAllocationResult implements Editable<DeviceRequestAllocationResultBuilder>, KubernetesResource
{

    @JsonProperty("adminAccess")
    private Boolean adminAccess;
    @JsonProperty("bindingConditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> bindingConditions = new ArrayList<>();
    @JsonProperty("bindingFailureConditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> bindingFailureConditions = new ArrayList<>();
    @JsonProperty("consumedCapacity")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> consumedCapacity = new LinkedHashMap<>();
    @JsonProperty("device")
    private String device;
    @JsonProperty("driver")
    private String driver;
    @JsonProperty("pool")
    private String pool;
    @JsonProperty("request")
    private String request;
    @JsonProperty("shareID")
    private String shareID;
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeviceToleration> tolerations = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DeviceRequestAllocationResult() {
    }

    public DeviceRequestAllocationResult(Boolean adminAccess, List<String> bindingConditions, List<String> bindingFailureConditions, Map<String, Quantity> consumedCapacity, String device, String driver, String pool, String request, String shareID, List<DeviceToleration> tolerations) {
        super();
        this.adminAccess = adminAccess;
        this.bindingConditions = bindingConditions;
        this.bindingFailureConditions = bindingFailureConditions;
        this.consumedCapacity = consumedCapacity;
        this.device = device;
        this.driver = driver;
        this.pool = pool;
        this.request = request;
        this.shareID = shareID;
        this.tolerations = tolerations;
    }

    /**
     * AdminAccess indicates that this device was allocated for administrative access. See the corresponding request field for a definition of mode.<br><p> <br><p> This is an alpha field and requires enabling the DRAAdminAccess feature gate. Admin access is disabled if this field is unset or set to false, otherwise it is enabled.
     */
    @JsonProperty("adminAccess")
    public Boolean getAdminAccess() {
        return adminAccess;
    }

    /**
     * AdminAccess indicates that this device was allocated for administrative access. See the corresponding request field for a definition of mode.<br><p> <br><p> This is an alpha field and requires enabling the DRAAdminAccess feature gate. Admin access is disabled if this field is unset or set to false, otherwise it is enabled.
     */
    @JsonProperty("adminAccess")
    public void setAdminAccess(Boolean adminAccess) {
        this.adminAccess = adminAccess;
    }

    /**
     * BindingConditions contains a copy of the BindingConditions from the corresponding ResourceSlice at the time of allocation.<br><p> <br><p> This is an alpha field and requires enabling the DRADeviceBindingConditions and DRAResourceClaimDeviceStatus feature gates.
     */
    @JsonProperty("bindingConditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getBindingConditions() {
        return bindingConditions;
    }

    /**
     * BindingConditions contains a copy of the BindingConditions from the corresponding ResourceSlice at the time of allocation.<br><p> <br><p> This is an alpha field and requires enabling the DRADeviceBindingConditions and DRAResourceClaimDeviceStatus feature gates.
     */
    @JsonProperty("bindingConditions")
    public void setBindingConditions(List<String> bindingConditions) {
        this.bindingConditions = bindingConditions;
    }

    /**
     * BindingFailureConditions contains a copy of the BindingFailureConditions from the corresponding ResourceSlice at the time of allocation.<br><p> <br><p> This is an alpha field and requires enabling the DRADeviceBindingConditions and DRAResourceClaimDeviceStatus feature gates.
     */
    @JsonProperty("bindingFailureConditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getBindingFailureConditions() {
        return bindingFailureConditions;
    }

    /**
     * BindingFailureConditions contains a copy of the BindingFailureConditions from the corresponding ResourceSlice at the time of allocation.<br><p> <br><p> This is an alpha field and requires enabling the DRADeviceBindingConditions and DRAResourceClaimDeviceStatus feature gates.
     */
    @JsonProperty("bindingFailureConditions")
    public void setBindingFailureConditions(List<String> bindingFailureConditions) {
        this.bindingFailureConditions = bindingFailureConditions;
    }

    /**
     * ConsumedCapacity tracks the amount of capacity consumed per device as part of the claim request. The consumed amount may differ from the requested amount: it is rounded up to the nearest valid value based on the device’s requestPolicy if applicable (i.e., may not be less than the requested amount).<br><p> <br><p> The total consumed capacity for each device must not exceed the DeviceCapacity's Value.<br><p> <br><p> This field is populated only for devices that allow multiple allocations. All capacity entries are included, even if the consumed amount is zero.
     */
    @JsonProperty("consumedCapacity")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getConsumedCapacity() {
        return consumedCapacity;
    }

    /**
     * ConsumedCapacity tracks the amount of capacity consumed per device as part of the claim request. The consumed amount may differ from the requested amount: it is rounded up to the nearest valid value based on the device’s requestPolicy if applicable (i.e., may not be less than the requested amount).<br><p> <br><p> The total consumed capacity for each device must not exceed the DeviceCapacity's Value.<br><p> <br><p> This field is populated only for devices that allow multiple allocations. All capacity entries are included, even if the consumed amount is zero.
     */
    @JsonProperty("consumedCapacity")
    public void setConsumedCapacity(Map<String, Quantity> consumedCapacity) {
        this.consumedCapacity = consumedCapacity;
    }

    /**
     * Device references one device instance via its name in the driver's resource pool. It must be a DNS label.
     */
    @JsonProperty("device")
    public String getDevice() {
        return device;
    }

    /**
     * Device references one device instance via its name in the driver's resource pool. It must be a DNS label.
     */
    @JsonProperty("device")
    public void setDevice(String device) {
        this.device = device;
    }

    /**
     * Driver specifies the name of the DRA driver whose kubelet plugin should be invoked to process the allocation once the claim is needed on a node.<br><p> <br><p> Must be a DNS subdomain and should end with a DNS domain owned by the vendor of the driver.
     */
    @JsonProperty("driver")
    public String getDriver() {
        return driver;
    }

    /**
     * Driver specifies the name of the DRA driver whose kubelet plugin should be invoked to process the allocation once the claim is needed on a node.<br><p> <br><p> Must be a DNS subdomain and should end with a DNS domain owned by the vendor of the driver.
     */
    @JsonProperty("driver")
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * This name together with the driver name and the device name field identify which device was allocated (`&lt;driver name&gt;/&lt;pool name&gt;/&lt;device name&gt;`).<br><p> <br><p> Must not be longer than 253 characters and may contain one or more DNS sub-domains separated by slashes.
     */
    @JsonProperty("pool")
    public String getPool() {
        return pool;
    }

    /**
     * This name together with the driver name and the device name field identify which device was allocated (`&lt;driver name&gt;/&lt;pool name&gt;/&lt;device name&gt;`).<br><p> <br><p> Must not be longer than 253 characters and may contain one or more DNS sub-domains separated by slashes.
     */
    @JsonProperty("pool")
    public void setPool(String pool) {
        this.pool = pool;
    }

    /**
     * Request is the name of the request in the claim which caused this device to be allocated. If it references a subrequest in the firstAvailable list on a DeviceRequest, this field must include both the name of the main request and the subrequest using the format &lt;main request&gt;/&lt;subrequest&gt;.<br><p> <br><p> Multiple devices may have been allocated per request.
     */
    @JsonProperty("request")
    public String getRequest() {
        return request;
    }

    /**
     * Request is the name of the request in the claim which caused this device to be allocated. If it references a subrequest in the firstAvailable list on a DeviceRequest, this field must include both the name of the main request and the subrequest using the format &lt;main request&gt;/&lt;subrequest&gt;.<br><p> <br><p> Multiple devices may have been allocated per request.
     */
    @JsonProperty("request")
    public void setRequest(String request) {
        this.request = request;
    }

    /**
     * ShareID uniquely identifies an individual allocation share of the device, used when the device supports multiple simultaneous allocations. It serves as an additional map key to differentiate concurrent shares of the same device.
     */
    @JsonProperty("shareID")
    public String getShareID() {
        return shareID;
    }

    /**
     * ShareID uniquely identifies an individual allocation share of the device, used when the device supports multiple simultaneous allocations. It serves as an additional map key to differentiate concurrent shares of the same device.
     */
    @JsonProperty("shareID")
    public void setShareID(String shareID) {
        this.shareID = shareID;
    }

    /**
     * A copy of all tolerations specified in the request at the time when the device got allocated.<br><p> <br><p> The maximum number of tolerations is 16.<br><p> <br><p> This is an alpha field and requires enabling the DRADeviceTaints feature gate.
     */
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DeviceToleration> getTolerations() {
        return tolerations;
    }

    /**
     * A copy of all tolerations specified in the request at the time when the device got allocated.<br><p> <br><p> The maximum number of tolerations is 16.<br><p> <br><p> This is an alpha field and requires enabling the DRADeviceTaints feature gate.
     */
    @JsonProperty("tolerations")
    public void setTolerations(List<DeviceToleration> tolerations) {
        this.tolerations = tolerations;
    }

    @JsonIgnore
    public DeviceRequestAllocationResultBuilder edit() {
        return new DeviceRequestAllocationResultBuilder(this);
    }

    @JsonIgnore
    public DeviceRequestAllocationResultBuilder toBuilder() {
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
