
package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

import java.util.LinkedHashMap;
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo other = (DeviceInfo) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$memif = this.getMemif();
        Object other$memif = other.getMemif();
        if (this$memif == null ? other$memif != null : !this$memif.equals(other$memif)) {
            return false;
        }
        Object this$pci = this.getPci();
        Object other$pci = other.getPci();
        if (this$pci == null ? other$pci != null : !this$pci.equals(other$pci)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
            return false;
        }
        Object this$vdpa = this.getVdpa();
        Object other$vdpa = other.getVdpa();
        if (this$vdpa == null ? other$vdpa != null : !this$vdpa.equals(other$vdpa)) {
            return false;
        }
        Object this$version = this.getVersion();
        Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
            return false;
        }
        Object this$vhostUser = this.getVhostUser();
        Object other$vhostUser = other.getVhostUser();
        if (this$vhostUser == null ? other$vhostUser != null : !this$vhostUser.equals(other$vhostUser)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof DeviceInfo;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $memif = this.getMemif();
        result = result * prime + ($memif == null ? 43 : $memif.hashCode());
        Object $pci = this.getPci();
        result = result * prime + ($pci == null ? 43 : $pci.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $vdpa = this.getVdpa();
        result = result * prime + ($vdpa == null ? 43 : $vdpa.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $vhostUser = this.getVhostUser();
        result = result * prime + ($vhostUser == null ? 43 : $vhostUser.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DeviceInfo(" + "memif=" + this.getMemif() + ", pci=" + this.getPci() + ", type=" + this.getType() + ", vdpa=" + this.getVdpa() + ", version=" + this.getVersion() + ", vhostUser=" + this.getVhostUser() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
