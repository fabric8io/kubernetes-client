
package io.fabric8.openshift.api.model.installer.azure.v1;

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
import io.fabric8.openshift.api.model.miscellaneous.clusterapi.infrastructure.v1beta1.DataDisk;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * MachinePool stores the configuration for a machine pool installed on Azure.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bootDiagnostics",
    "dataDisks",
    "encryptionAtHost",
    "identity",
    "osDisk",
    "osImage",
    "settings",
    "type",
    "ultraSSDCapability",
    "vmNetworkingType",
    "zones"
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
public class MachinePool implements Editable<MachinePoolBuilder>, KubernetesResource
{

    @JsonProperty("bootDiagnostics")
    private BootDiagnostics bootDiagnostics;
    @JsonProperty("dataDisks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DataDisk> dataDisks = new ArrayList<>();
    @JsonProperty("encryptionAtHost")
    private Boolean encryptionAtHost;
    @JsonProperty("identity")
    private VMIdentity identity;
    @JsonProperty("osDisk")
    private OSDisk osDisk;
    @JsonProperty("osImage")
    private OSImage osImage;
    @JsonProperty("settings")
    private SecuritySettings settings;
    @JsonProperty("type")
    private String type;
    @JsonProperty("ultraSSDCapability")
    private String ultraSSDCapability;
    @JsonProperty("vmNetworkingType")
    private String vmNetworkingType;
    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> zones = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachinePool() {
    }

    public MachinePool(BootDiagnostics bootDiagnostics, List<DataDisk> dataDisks, Boolean encryptionAtHost, VMIdentity identity, OSDisk osDisk, OSImage osImage, SecuritySettings settings, String type, String ultraSSDCapability, String vmNetworkingType, List<String> zones) {
        super();
        this.bootDiagnostics = bootDiagnostics;
        this.dataDisks = dataDisks;
        this.encryptionAtHost = encryptionAtHost;
        this.identity = identity;
        this.osDisk = osDisk;
        this.osImage = osImage;
        this.settings = settings;
        this.type = type;
        this.ultraSSDCapability = ultraSSDCapability;
        this.vmNetworkingType = vmNetworkingType;
        this.zones = zones;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on Azure.
     */
    @JsonProperty("bootDiagnostics")
    public BootDiagnostics getBootDiagnostics() {
        return bootDiagnostics;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on Azure.
     */
    @JsonProperty("bootDiagnostics")
    public void setBootDiagnostics(BootDiagnostics bootDiagnostics) {
        this.bootDiagnostics = bootDiagnostics;
    }

    /**
     * DataDisk specifies the parameters that are used to add one or more data disks to the machine.
     */
    @JsonProperty("dataDisks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DataDisk> getDataDisks() {
        return dataDisks;
    }

    /**
     * DataDisk specifies the parameters that are used to add one or more data disks to the machine.
     */
    @JsonProperty("dataDisks")
    public void setDataDisks(List<DataDisk> dataDisks) {
        this.dataDisks = dataDisks;
    }

    /**
     * EncryptionAtHost enables encryption at the VM host.
     */
    @JsonProperty("encryptionAtHost")
    public Boolean getEncryptionAtHost() {
        return encryptionAtHost;
    }

    /**
     * EncryptionAtHost enables encryption at the VM host.
     */
    @JsonProperty("encryptionAtHost")
    public void setEncryptionAtHost(Boolean encryptionAtHost) {
        this.encryptionAtHost = encryptionAtHost;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on Azure.
     */
    @JsonProperty("identity")
    public VMIdentity getIdentity() {
        return identity;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on Azure.
     */
    @JsonProperty("identity")
    public void setIdentity(VMIdentity identity) {
        this.identity = identity;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on Azure.
     */
    @JsonProperty("osDisk")
    public OSDisk getOsDisk() {
        return osDisk;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on Azure.
     */
    @JsonProperty("osDisk")
    public void setOsDisk(OSDisk osDisk) {
        this.osDisk = osDisk;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on Azure.
     */
    @JsonProperty("osImage")
    public OSImage getOsImage() {
        return osImage;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on Azure.
     */
    @JsonProperty("osImage")
    public void setOsImage(OSImage osImage) {
        this.osImage = osImage;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on Azure.
     */
    @JsonProperty("settings")
    public SecuritySettings getSettings() {
        return settings;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on Azure.
     */
    @JsonProperty("settings")
    public void setSettings(SecuritySettings settings) {
        this.settings = settings;
    }

    /**
     * InstanceType defines the azure instance type. eg. Standard_DS_V2
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * InstanceType defines the azure instance type. eg. Standard_DS_V2
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * ultraSSDCapability defines if the instance should use Ultra SSD disks.
     */
    @JsonProperty("ultraSSDCapability")
    public String getUltraSSDCapability() {
        return ultraSSDCapability;
    }

    /**
     * ultraSSDCapability defines if the instance should use Ultra SSD disks.
     */
    @JsonProperty("ultraSSDCapability")
    public void setUltraSSDCapability(String ultraSSDCapability) {
        this.ultraSSDCapability = ultraSSDCapability;
    }

    /**
     * VMNetworkingType specifies whether to enable accelerated networking. Accelerated networking enables single root I/O virtualization (SR-IOV) to a VM, greatly improving its networking performance. eg. values: "Accelerated", "Basic"
     */
    @JsonProperty("vmNetworkingType")
    public String getVmNetworkingType() {
        return vmNetworkingType;
    }

    /**
     * VMNetworkingType specifies whether to enable accelerated networking. Accelerated networking enables single root I/O virtualization (SR-IOV) to a VM, greatly improving its networking performance. eg. values: "Accelerated", "Basic"
     */
    @JsonProperty("vmNetworkingType")
    public void setVmNetworkingType(String vmNetworkingType) {
        this.vmNetworkingType = vmNetworkingType;
    }

    /**
     * Zones is list of availability zones that can be used. eg. ["1", "2", "3"]
     */
    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getZones() {
        return zones;
    }

    /**
     * Zones is list of availability zones that can be used. eg. ["1", "2", "3"]
     */
    @JsonProperty("zones")
    public void setZones(List<String> zones) {
        this.zones = zones;
    }

    @JsonIgnore
    public MachinePoolBuilder edit() {
        return new MachinePoolBuilder(this);
    }

    @JsonIgnore
    public MachinePoolBuilder toBuilder() {
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
