
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

/**
 * DeviceInfo contains the information of the device associated with this network (if any)
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "memif",
    "pci",
    "type",
    "vdpa",
    "version",
    "vhost-user"
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
public class DeviceInfo implements Editable<DeviceInfoBuilder>, KubernetesResource
{

    @JsonProperty("memif")
    private MemifDevice memif;
    @JsonProperty("pci")
    private PciDevice pci;
    @JsonProperty("type")
    private String type;
    @JsonProperty("vdpa")
    private VdpaDevice vdpa;
    @JsonProperty("version")
    private String version;
    @JsonProperty("vhost-user")
    private VhostDevice vhostUser;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DeviceInfo() {
    }

    public DeviceInfo(MemifDevice memif, PciDevice pci, String type, VdpaDevice vdpa, String version, VhostDevice vhostUser) {
        super();
        this.memif = memif;
        this.pci = pci;
        this.type = type;
        this.vdpa = vdpa;
        this.version = version;
        this.vhostUser = vhostUser;
    }

    /**
     * DeviceInfo contains the information of the device associated with this network (if any)
     */
    @JsonProperty("memif")
    public MemifDevice getMemif() {
        return memif;
    }

    /**
     * DeviceInfo contains the information of the device associated with this network (if any)
     */
    @JsonProperty("memif")
    public void setMemif(MemifDevice memif) {
        this.memif = memif;
    }

    /**
     * DeviceInfo contains the information of the device associated with this network (if any)
     */
    @JsonProperty("pci")
    public PciDevice getPci() {
        return pci;
    }

    /**
     * DeviceInfo contains the information of the device associated with this network (if any)
     */
    @JsonProperty("pci")
    public void setPci(PciDevice pci) {
        this.pci = pci;
    }

    /**
     * DeviceInfo contains the information of the device associated with this network (if any)
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * DeviceInfo contains the information of the device associated with this network (if any)
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * DeviceInfo contains the information of the device associated with this network (if any)
     */
    @JsonProperty("vdpa")
    public VdpaDevice getVdpa() {
        return vdpa;
    }

    /**
     * DeviceInfo contains the information of the device associated with this network (if any)
     */
    @JsonProperty("vdpa")
    public void setVdpa(VdpaDevice vdpa) {
        this.vdpa = vdpa;
    }

    /**
     * DeviceInfo contains the information of the device associated with this network (if any)
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * DeviceInfo contains the information of the device associated with this network (if any)
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * DeviceInfo contains the information of the device associated with this network (if any)
     */
    @JsonProperty("vhost-user")
    public VhostDevice getVhostUser() {
        return vhostUser;
    }

    /**
     * DeviceInfo contains the information of the device associated with this network (if any)
     */
    @JsonProperty("vhost-user")
    public void setVhostUser(VhostDevice vhostUser) {
        this.vhostUser = vhostUser;
    }

    @JsonIgnore
    public DeviceInfoBuilder edit() {
        return new DeviceInfoBuilder(this);
    }

    @JsonIgnore
    public DeviceInfoBuilder toBuilder() {
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
