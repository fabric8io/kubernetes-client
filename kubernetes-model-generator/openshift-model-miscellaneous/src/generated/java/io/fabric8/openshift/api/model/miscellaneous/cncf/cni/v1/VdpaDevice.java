
package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

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
    "driver",
    "parent-device",
    "path",
    "pci-address",
    "pf-pci-address",
    "representor-device"
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
public class VdpaDevice implements Editable<VdpaDeviceBuilder>, KubernetesResource
{

    @JsonProperty("driver")
    private String driver;
    @JsonProperty("parent-device")
    private String parentDevice;
    @JsonProperty("path")
    private String path;
    @JsonProperty("pci-address")
    private String pciAddress;
    @JsonProperty("pf-pci-address")
    private String pfPciAddress;
    @JsonProperty("representor-device")
    private String representorDevice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VdpaDevice() {
    }

    public VdpaDevice(String driver, String parentDevice, String path, String pciAddress, String pfPciAddress, String representorDevice) {
        super();
        this.driver = driver;
        this.parentDevice = parentDevice;
        this.path = path;
        this.pciAddress = pciAddress;
        this.pfPciAddress = pfPciAddress;
        this.representorDevice = representorDevice;
    }

    @JsonProperty("driver")
    public String getDriver() {
        return driver;
    }

    @JsonProperty("driver")
    public void setDriver(String driver) {
        this.driver = driver;
    }

    @JsonProperty("parent-device")
    public String getParentDevice() {
        return parentDevice;
    }

    @JsonProperty("parent-device")
    public void setParentDevice(String parentDevice) {
        this.parentDevice = parentDevice;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("pci-address")
    public String getPciAddress() {
        return pciAddress;
    }

    @JsonProperty("pci-address")
    public void setPciAddress(String pciAddress) {
        this.pciAddress = pciAddress;
    }

    @JsonProperty("pf-pci-address")
    public String getPfPciAddress() {
        return pfPciAddress;
    }

    @JsonProperty("pf-pci-address")
    public void setPfPciAddress(String pfPciAddress) {
        this.pfPciAddress = pfPciAddress;
    }

    @JsonProperty("representor-device")
    public String getRepresentorDevice() {
        return representorDevice;
    }

    @JsonProperty("representor-device")
    public void setRepresentorDevice(String representorDevice) {
        this.representorDevice = representorDevice;
    }

    @JsonIgnore
    public VdpaDeviceBuilder edit() {
        return new VdpaDeviceBuilder(this);
    }

    @JsonIgnore
    public VdpaDeviceBuilder toBuilder() {
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
