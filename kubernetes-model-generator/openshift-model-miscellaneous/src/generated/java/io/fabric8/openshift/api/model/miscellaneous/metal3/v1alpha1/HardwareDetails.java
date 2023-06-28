
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
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
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class HardwareDetails implements KubernetesResource
{

    @JsonProperty("cpu")
    private CPU cpu;
    @JsonProperty("firmware")
    private Firmware firmware;
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("nics")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NIC> nics = new ArrayList<NIC>();
    @JsonProperty("ramMebibytes")
    private Integer ramMebibytes;
    @JsonProperty("storage")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Storage> storage = new ArrayList<Storage>();
    @JsonProperty("systemVendor")
    private HardwareSystemVendor systemVendor;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
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

    @JsonProperty("cpu")
    public CPU getCpu() {
        return cpu;
    }

    @JsonProperty("cpu")
    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    @JsonProperty("firmware")
    public Firmware getFirmware() {
        return firmware;
    }

    @JsonProperty("firmware")
    public void setFirmware(Firmware firmware) {
        this.firmware = firmware;
    }

    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    @JsonProperty("nics")
    public List<NIC> getNics() {
        return nics;
    }

    @JsonProperty("nics")
    public void setNics(List<NIC> nics) {
        this.nics = nics;
    }

    @JsonProperty("ramMebibytes")
    public Integer getRamMebibytes() {
        return ramMebibytes;
    }

    @JsonProperty("ramMebibytes")
    public void setRamMebibytes(Integer ramMebibytes) {
        this.ramMebibytes = ramMebibytes;
    }

    @JsonProperty("storage")
    public List<Storage> getStorage() {
        return storage;
    }

    @JsonProperty("storage")
    public void setStorage(List<Storage> storage) {
        this.storage = storage;
    }

    @JsonProperty("systemVendor")
    public HardwareSystemVendor getSystemVendor() {
        return systemVendor;
    }

    @JsonProperty("systemVendor")
    public void setSystemVendor(HardwareSystemVendor systemVendor) {
        this.systemVendor = systemVendor;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
