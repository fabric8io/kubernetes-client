
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
import io.fabric8.kubernetes.api.builder.Editable;
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
import lombok.ToString;
import lombok.experimental.Accessors;

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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class HardwareDataSpecHardware implements Editable<HardwareDataSpecHardwareBuilder> , KubernetesResource
{

    @JsonProperty("cpu")
    private HardwareDataSpecHCpu cpu;
    @JsonProperty("firmware")
    private HardwareDataSpecHFirmware firmware;
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("nics")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HardwareDataSpecHNics> nics = new ArrayList<>();
    @JsonProperty("ramMebibytes")
    private Integer ramMebibytes;
    @JsonProperty("storage")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HardwareDataSpecHStorage> storage = new ArrayList<>();
    @JsonProperty("systemVendor")
    private HardwareDataSpecHSystemVendor systemVendor;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public HardwareDataSpecHardware() {
    }

    public HardwareDataSpecHardware(HardwareDataSpecHCpu cpu, HardwareDataSpecHFirmware firmware, String hostname, List<HardwareDataSpecHNics> nics, Integer ramMebibytes, List<HardwareDataSpecHStorage> storage, HardwareDataSpecHSystemVendor systemVendor) {
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
    public HardwareDataSpecHCpu getCpu() {
        return cpu;
    }

    @JsonProperty("cpu")
    public void setCpu(HardwareDataSpecHCpu cpu) {
        this.cpu = cpu;
    }

    @JsonProperty("firmware")
    public HardwareDataSpecHFirmware getFirmware() {
        return firmware;
    }

    @JsonProperty("firmware")
    public void setFirmware(HardwareDataSpecHFirmware firmware) {
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HardwareDataSpecHNics> getNics() {
        return nics;
    }

    @JsonProperty("nics")
    public void setNics(List<HardwareDataSpecHNics> nics) {
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HardwareDataSpecHStorage> getStorage() {
        return storage;
    }

    @JsonProperty("storage")
    public void setStorage(List<HardwareDataSpecHStorage> storage) {
        this.storage = storage;
    }

    @JsonProperty("systemVendor")
    public HardwareDataSpecHSystemVendor getSystemVendor() {
        return systemVendor;
    }

    @JsonProperty("systemVendor")
    public void setSystemVendor(HardwareDataSpecHSystemVendor systemVendor) {
        this.systemVendor = systemVendor;
    }

    @JsonIgnore
    public HardwareDataSpecHardwareBuilder edit() {
        return new HardwareDataSpecHardwareBuilder(this);
    }

    @JsonIgnore
    public HardwareDataSpecHardwareBuilder toBuilder() {
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
