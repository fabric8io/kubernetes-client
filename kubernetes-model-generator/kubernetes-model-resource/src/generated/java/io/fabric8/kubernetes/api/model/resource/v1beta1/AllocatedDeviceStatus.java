
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
import io.fabric8.kubernetes.api.model.Condition;
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
 * AllocatedDeviceStatus contains the status of an allocated device, if the driver chooses to report it. This may include driver-specific information.<br><p> <br><p> The combination of Driver, Pool, Device, and ShareID must match the corresponding key in Status.Allocation.Devices.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "data",
    "device",
    "driver",
    "networkData",
    "pool",
    "shareID"
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
public class AllocatedDeviceStatus implements Editable<AllocatedDeviceStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("data")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object data;
    @JsonProperty("device")
    private String device;
    @JsonProperty("driver")
    private String driver;
    @JsonProperty("networkData")
    private NetworkDeviceData networkData;
    @JsonProperty("pool")
    private String pool;
    @JsonProperty("shareID")
    private String shareID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AllocatedDeviceStatus() {
    }

    public AllocatedDeviceStatus(List<Condition> conditions, Object data, String device, String driver, NetworkDeviceData networkData, String pool, String shareID) {
        super();
        this.conditions = conditions;
        this.data = data;
        this.device = device;
        this.driver = driver;
        this.networkData = networkData;
        this.pool = pool;
        this.shareID = shareID;
    }

    /**
     * Conditions contains the latest observation of the device's state. If the device has been configured according to the class and claim config references, the `Ready` condition should be True.<br><p> <br><p> Must not contain more than 8 entries.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions contains the latest observation of the device's state. If the device has been configured according to the class and claim config references, the `Ready` condition should be True.<br><p> <br><p> Must not contain more than 8 entries.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * AllocatedDeviceStatus contains the status of an allocated device, if the driver chooses to report it. This may include driver-specific information.<br><p> <br><p> The combination of Driver, Pool, Device, and ShareID must match the corresponding key in Status.Allocation.Devices.
     */
    @JsonProperty("data")
    public Object getData() {
        return data;
    }

    /**
     * AllocatedDeviceStatus contains the status of an allocated device, if the driver chooses to report it. This may include driver-specific information.<br><p> <br><p> The combination of Driver, Pool, Device, and ShareID must match the corresponding key in Status.Allocation.Devices.
     */
    @JsonProperty("data")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setData(Object data) {
        this.data = data;
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
     * AllocatedDeviceStatus contains the status of an allocated device, if the driver chooses to report it. This may include driver-specific information.<br><p> <br><p> The combination of Driver, Pool, Device, and ShareID must match the corresponding key in Status.Allocation.Devices.
     */
    @JsonProperty("networkData")
    public NetworkDeviceData getNetworkData() {
        return networkData;
    }

    /**
     * AllocatedDeviceStatus contains the status of an allocated device, if the driver chooses to report it. This may include driver-specific information.<br><p> <br><p> The combination of Driver, Pool, Device, and ShareID must match the corresponding key in Status.Allocation.Devices.
     */
    @JsonProperty("networkData")
    public void setNetworkData(NetworkDeviceData networkData) {
        this.networkData = networkData;
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
     * ShareID uniquely identifies an individual allocation share of the device.
     */
    @JsonProperty("shareID")
    public String getShareID() {
        return shareID;
    }

    /**
     * ShareID uniquely identifies an individual allocation share of the device.
     */
    @JsonProperty("shareID")
    public void setShareID(String shareID) {
        this.shareID = shareID;
    }

    @JsonIgnore
    public AllocatedDeviceStatusBuilder edit() {
        return new AllocatedDeviceStatusBuilder(this);
    }

    @JsonIgnore
    public AllocatedDeviceStatusBuilder toBuilder() {
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
