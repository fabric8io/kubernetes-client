
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
 * DeviceTaintSelector defines which device(s) a DeviceTaintRule applies to. The empty selector matches all devices. Without a selector, no devices are matched.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "device",
    "deviceClassName",
    "driver",
    "pool",
    "selectors"
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
public class DeviceTaintSelector implements Editable<DeviceTaintSelectorBuilder>, KubernetesResource
{

    @JsonProperty("device")
    private String device;
    @JsonProperty("deviceClassName")
    private String deviceClassName;
    @JsonProperty("driver")
    private String driver;
    @JsonProperty("pool")
    private String pool;
    @JsonProperty("selectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeviceSelector> selectors = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DeviceTaintSelector() {
    }

    public DeviceTaintSelector(String device, String deviceClassName, String driver, String pool, List<DeviceSelector> selectors) {
        super();
        this.device = device;
        this.deviceClassName = deviceClassName;
        this.driver = driver;
        this.pool = pool;
        this.selectors = selectors;
    }

    /**
     * If device is set, only devices with that name are selected. This field corresponds to slice.spec.devices[].name.<br><p> <br><p> Setting also driver and pool may be required to avoid ambiguity, but is not required.
     */
    @JsonProperty("device")
    public String getDevice() {
        return device;
    }

    /**
     * If device is set, only devices with that name are selected. This field corresponds to slice.spec.devices[].name.<br><p> <br><p> Setting also driver and pool may be required to avoid ambiguity, but is not required.
     */
    @JsonProperty("device")
    public void setDevice(String device) {
        this.device = device;
    }

    /**
     * If DeviceClassName is set, the selectors defined there must be satisfied by a device to be selected. This field corresponds to class.metadata.name.
     */
    @JsonProperty("deviceClassName")
    public String getDeviceClassName() {
        return deviceClassName;
    }

    /**
     * If DeviceClassName is set, the selectors defined there must be satisfied by a device to be selected. This field corresponds to class.metadata.name.
     */
    @JsonProperty("deviceClassName")
    public void setDeviceClassName(String deviceClassName) {
        this.deviceClassName = deviceClassName;
    }

    /**
     * If driver is set, only devices from that driver are selected. This fields corresponds to slice.spec.driver.
     */
    @JsonProperty("driver")
    public String getDriver() {
        return driver;
    }

    /**
     * If driver is set, only devices from that driver are selected. This fields corresponds to slice.spec.driver.
     */
    @JsonProperty("driver")
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * If pool is set, only devices in that pool are selected.<br><p> <br><p> Also setting the driver name may be useful to avoid ambiguity when different drivers use the same pool name, but this is not required because selecting pools from different drivers may also be useful, for example when drivers with node-local devices use the node name as their pool name.
     */
    @JsonProperty("pool")
    public String getPool() {
        return pool;
    }

    /**
     * If pool is set, only devices in that pool are selected.<br><p> <br><p> Also setting the driver name may be useful to avoid ambiguity when different drivers use the same pool name, but this is not required because selecting pools from different drivers may also be useful, for example when drivers with node-local devices use the node name as their pool name.
     */
    @JsonProperty("pool")
    public void setPool(String pool) {
        this.pool = pool;
    }

    /**
     * Selectors contains the same selection criteria as a ResourceClaim. Currently, CEL expressions are supported. All of these selectors must be satisfied.
     */
    @JsonProperty("selectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DeviceSelector> getSelectors() {
        return selectors;
    }

    /**
     * Selectors contains the same selection criteria as a ResourceClaim. Currently, CEL expressions are supported. All of these selectors must be satisfied.
     */
    @JsonProperty("selectors")
    public void setSelectors(List<DeviceSelector> selectors) {
        this.selectors = selectors;
    }

    @JsonIgnore
    public DeviceTaintSelectorBuilder edit() {
        return new DeviceTaintSelectorBuilder(this);
    }

    @JsonIgnore
    public DeviceTaintSelectorBuilder toBuilder() {
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
