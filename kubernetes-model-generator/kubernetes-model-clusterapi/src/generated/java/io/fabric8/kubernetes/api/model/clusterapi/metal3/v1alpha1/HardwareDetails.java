
package io.fabric8.kubernetes.api.model.clusterapi.metal3.v1alpha1;

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
 * HardwareDetails collects all of the information about hardware discovered on the host.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cpu",
    "firmware",
    "hostname",
    "nics",
    "ramMebibytes",
    "storage",
    "systemVendor"
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
public class HardwareDetails implements Editable<HardwareDetailsBuilder>, KubernetesResource
{

    @JsonProperty("cpu")
    private CPU cpu;
    @JsonProperty("firmware")
    private Firmware firmware;
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("nics")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NIC> nics = new ArrayList<>();
    @JsonProperty("ramMebibytes")
    private Integer ramMebibytes;
    @JsonProperty("storage")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Storage> storage = new ArrayList<>();
    @JsonProperty("systemVendor")
    private HardwareSystemVendor systemVendor;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HardwareDetails() {
    }

    public HardwareDetails(CPU cpu, Firmware firmware, String hostname, List<NIC> nics, Integer ramMebibytes, List<Storage> storage, HardwareSystemVendor systemVendor) {
        super();
        this.cpu = cpu;
        this.firmware = firmware;
        this.hostname = hostname;
        this.nics = nics;
        this.ramMebibytes = ramMebibytes;
        this.storage = storage;
        this.systemVendor = systemVendor;
    }

    /**
     * HardwareDetails collects all of the information about hardware discovered on the host.
     */
    @JsonProperty("cpu")
    public CPU getCpu() {
        return cpu;
    }

    /**
     * HardwareDetails collects all of the information about hardware discovered on the host.
     */
    @JsonProperty("cpu")
    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    /**
     * HardwareDetails collects all of the information about hardware discovered on the host.
     */
    @JsonProperty("firmware")
    public Firmware getFirmware() {
        return firmware;
    }

    /**
     * HardwareDetails collects all of the information about hardware discovered on the host.
     */
    @JsonProperty("firmware")
    public void setFirmware(Firmware firmware) {
        this.firmware = firmware;
    }

    /**
     * HardwareDetails collects all of the information about hardware discovered on the host.
     */
    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    /**
     * HardwareDetails collects all of the information about hardware discovered on the host.
     */
    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * List of network interfaces for the host.
     */
    @JsonProperty("nics")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NIC> getNics() {
        return nics;
    }

    /**
     * List of network interfaces for the host.
     */
    @JsonProperty("nics")
    public void setNics(List<NIC> nics) {
        this.nics = nics;
    }

    /**
     * The host's amount of memory in Mebibytes.
     */
    @JsonProperty("ramMebibytes")
    public Integer getRamMebibytes() {
        return ramMebibytes;
    }

    /**
     * The host's amount of memory in Mebibytes.
     */
    @JsonProperty("ramMebibytes")
    public void setRamMebibytes(Integer ramMebibytes) {
        this.ramMebibytes = ramMebibytes;
    }

    /**
     * List of storage (disk, SSD, etc.) available to the host.
     */
    @JsonProperty("storage")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Storage> getStorage() {
        return storage;
    }

    /**
     * List of storage (disk, SSD, etc.) available to the host.
     */
    @JsonProperty("storage")
    public void setStorage(List<Storage> storage) {
        this.storage = storage;
    }

    /**
     * HardwareDetails collects all of the information about hardware discovered on the host.
     */
    @JsonProperty("systemVendor")
    public HardwareSystemVendor getSystemVendor() {
        return systemVendor;
    }

    /**
     * HardwareDetails collects all of the information about hardware discovered on the host.
     */
    @JsonProperty("systemVendor")
    public void setSystemVendor(HardwareSystemVendor systemVendor) {
        this.systemVendor = systemVendor;
    }

    @JsonIgnore
    public HardwareDetailsBuilder edit() {
        return new HardwareDetailsBuilder(this);
    }

    @JsonIgnore
    public HardwareDetailsBuilder toBuilder() {
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
