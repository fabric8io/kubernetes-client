
package io.fabric8.openshift.api.model.machine.v1;

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
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * NutanixMachineProviderConfig is the Schema for the nutanixmachineproviderconfigs API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "bootType",
    "categories",
    "cluster",
    "credentialsSecret",
    "dataDisks",
    "failureDomain",
    "gpus",
    "image",
    "memorySize",
    "project",
    "subnets",
    "systemDiskSize",
    "userDataSecret",
    "vcpuSockets",
    "vcpusPerSocket"
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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1")
@Group("machine.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NutanixMachineProviderConfig implements Editable<NutanixMachineProviderConfigBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "machine.openshift.io/v1";
    @JsonProperty("bootType")
    private String bootType;
    @JsonProperty("categories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NutanixCategory> categories = new ArrayList<>();
    @JsonProperty("cluster")
    private NutanixResourceIdentifier cluster;
    @JsonProperty("credentialsSecret")
    private LocalObjectReference credentialsSecret;
    @JsonProperty("dataDisks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NutanixVMDisk> dataDisks = new ArrayList<>();
    @JsonProperty("failureDomain")
    private NutanixFailureDomainReference failureDomain;
    @JsonProperty("gpus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NutanixGPU> gpus = new ArrayList<>();
    @JsonProperty("image")
    private NutanixResourceIdentifier image;
    @JsonProperty("kind")
    private String kind = "NutanixMachineProviderConfig";
    @JsonProperty("memorySize")
    private Quantity memorySize;
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("project")
    private NutanixResourceIdentifier project;
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NutanixResourceIdentifier> subnets = new ArrayList<>();
    @JsonProperty("systemDiskSize")
    private Quantity systemDiskSize;
    @JsonProperty("userDataSecret")
    private LocalObjectReference userDataSecret;
    @JsonProperty("vcpuSockets")
    private Integer vcpuSockets;
    @JsonProperty("vcpusPerSocket")
    private Integer vcpusPerSocket;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NutanixMachineProviderConfig() {
    }

    public NutanixMachineProviderConfig(String apiVersion, String bootType, List<NutanixCategory> categories, NutanixResourceIdentifier cluster, LocalObjectReference credentialsSecret, List<NutanixVMDisk> dataDisks, NutanixFailureDomainReference failureDomain, List<NutanixGPU> gpus, NutanixResourceIdentifier image, String kind, Quantity memorySize, ObjectMeta metadata, NutanixResourceIdentifier project, List<NutanixResourceIdentifier> subnets, Quantity systemDiskSize, LocalObjectReference userDataSecret, Integer vcpuSockets, Integer vcpusPerSocket) {
        super();
        this.apiVersion = apiVersion;
        this.bootType = bootType;
        this.categories = categories;
        this.cluster = cluster;
        this.credentialsSecret = credentialsSecret;
        this.dataDisks = dataDisks;
        this.failureDomain = failureDomain;
        this.gpus = gpus;
        this.image = image;
        this.kind = kind;
        this.memorySize = memorySize;
        this.metadata = metadata;
        this.project = project;
        this.subnets = subnets;
        this.systemDiskSize = systemDiskSize;
        this.userDataSecret = userDataSecret;
        this.vcpuSockets = vcpuSockets;
        this.vcpusPerSocket = vcpusPerSocket;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * bootType indicates the boot type (Legacy, UEFI or SecureBoot) the Machine's VM uses to boot. If this field is empty or omitted, the VM will use the default boot type "Legacy" to boot. "SecureBoot" depends on "UEFI" boot, i.e., enabling "SecureBoot" means that "UEFI" boot is also enabled.
     */
    @JsonProperty("bootType")
    public String getBootType() {
        return bootType;
    }

    /**
     * bootType indicates the boot type (Legacy, UEFI or SecureBoot) the Machine's VM uses to boot. If this field is empty or omitted, the VM will use the default boot type "Legacy" to boot. "SecureBoot" depends on "UEFI" boot, i.e., enabling "SecureBoot" means that "UEFI" boot is also enabled.
     */
    @JsonProperty("bootType")
    public void setBootType(String bootType) {
        this.bootType = bootType;
    }

    /**
     * categories optionally adds one or more prism categories (each with key and value) for the Machine's VM to associate with. All the category key and value pairs specified must already exist in the prism central.
     */
    @JsonProperty("categories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NutanixCategory> getCategories() {
        return categories;
    }

    /**
     * categories optionally adds one or more prism categories (each with key and value) for the Machine's VM to associate with. All the category key and value pairs specified must already exist in the prism central.
     */
    @JsonProperty("categories")
    public void setCategories(List<NutanixCategory> categories) {
        this.categories = categories;
    }

    /**
     * NutanixMachineProviderConfig is the Schema for the nutanixmachineproviderconfigs API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("cluster")
    public NutanixResourceIdentifier getCluster() {
        return cluster;
    }

    /**
     * NutanixMachineProviderConfig is the Schema for the nutanixmachineproviderconfigs API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("cluster")
    public void setCluster(NutanixResourceIdentifier cluster) {
        this.cluster = cluster;
    }

    /**
     * NutanixMachineProviderConfig is the Schema for the nutanixmachineproviderconfigs API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("credentialsSecret")
    public LocalObjectReference getCredentialsSecret() {
        return credentialsSecret;
    }

    /**
     * NutanixMachineProviderConfig is the Schema for the nutanixmachineproviderconfigs API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("credentialsSecret")
    public void setCredentialsSecret(LocalObjectReference credentialsSecret) {
        this.credentialsSecret = credentialsSecret;
    }

    /**
     * dataDisks holds information of the data disks to attach to the Machine's VM
     */
    @JsonProperty("dataDisks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NutanixVMDisk> getDataDisks() {
        return dataDisks;
    }

    /**
     * dataDisks holds information of the data disks to attach to the Machine's VM
     */
    @JsonProperty("dataDisks")
    public void setDataDisks(List<NutanixVMDisk> dataDisks) {
        this.dataDisks = dataDisks;
    }

    /**
     * NutanixMachineProviderConfig is the Schema for the nutanixmachineproviderconfigs API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("failureDomain")
    public NutanixFailureDomainReference getFailureDomain() {
        return failureDomain;
    }

    /**
     * NutanixMachineProviderConfig is the Schema for the nutanixmachineproviderconfigs API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("failureDomain")
    public void setFailureDomain(NutanixFailureDomainReference failureDomain) {
        this.failureDomain = failureDomain;
    }

    /**
     * gpus is a list of GPU devices to attach to the machine's VM. The GPU devices should already exist in Prism Central and associated with one of the Prism Element's hosts and available for the VM to attach (in "UNUSED" status).
     */
    @JsonProperty("gpus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NutanixGPU> getGpus() {
        return gpus;
    }

    /**
     * gpus is a list of GPU devices to attach to the machine's VM. The GPU devices should already exist in Prism Central and associated with one of the Prism Element's hosts and available for the VM to attach (in "UNUSED" status).
     */
    @JsonProperty("gpus")
    public void setGpus(List<NutanixGPU> gpus) {
        this.gpus = gpus;
    }

    /**
     * NutanixMachineProviderConfig is the Schema for the nutanixmachineproviderconfigs API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("image")
    public NutanixResourceIdentifier getImage() {
        return image;
    }

    /**
     * NutanixMachineProviderConfig is the Schema for the nutanixmachineproviderconfigs API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("image")
    public void setImage(NutanixResourceIdentifier image) {
        this.image = image;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * NutanixMachineProviderConfig is the Schema for the nutanixmachineproviderconfigs API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("memorySize")
    public Quantity getMemorySize() {
        return memorySize;
    }

    /**
     * NutanixMachineProviderConfig is the Schema for the nutanixmachineproviderconfigs API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("memorySize")
    public void setMemorySize(Quantity memorySize) {
        this.memorySize = memorySize;
    }

    /**
     * NutanixMachineProviderConfig is the Schema for the nutanixmachineproviderconfigs API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * NutanixMachineProviderConfig is the Schema for the nutanixmachineproviderconfigs API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * NutanixMachineProviderConfig is the Schema for the nutanixmachineproviderconfigs API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("project")
    public NutanixResourceIdentifier getProject() {
        return project;
    }

    /**
     * NutanixMachineProviderConfig is the Schema for the nutanixmachineproviderconfigs API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("project")
    public void setProject(NutanixResourceIdentifier project) {
        this.project = project;
    }

    /**
     * subnets holds a list of identifiers (one or more) of the cluster's network subnets for the Machine's VM to connect to. The subnet identifiers (uuid or name) can be obtained from the Prism Central console or using the prism_central API.
     */
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NutanixResourceIdentifier> getSubnets() {
        return subnets;
    }

    /**
     * subnets holds a list of identifiers (one or more) of the cluster's network subnets for the Machine's VM to connect to. The subnet identifiers (uuid or name) can be obtained from the Prism Central console or using the prism_central API.
     */
    @JsonProperty("subnets")
    public void setSubnets(List<NutanixResourceIdentifier> subnets) {
        this.subnets = subnets;
    }

    /**
     * NutanixMachineProviderConfig is the Schema for the nutanixmachineproviderconfigs API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("systemDiskSize")
    public Quantity getSystemDiskSize() {
        return systemDiskSize;
    }

    /**
     * NutanixMachineProviderConfig is the Schema for the nutanixmachineproviderconfigs API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("systemDiskSize")
    public void setSystemDiskSize(Quantity systemDiskSize) {
        this.systemDiskSize = systemDiskSize;
    }

    /**
     * NutanixMachineProviderConfig is the Schema for the nutanixmachineproviderconfigs API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("userDataSecret")
    public LocalObjectReference getUserDataSecret() {
        return userDataSecret;
    }

    /**
     * NutanixMachineProviderConfig is the Schema for the nutanixmachineproviderconfigs API Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("userDataSecret")
    public void setUserDataSecret(LocalObjectReference userDataSecret) {
        this.userDataSecret = userDataSecret;
    }

    /**
     * vcpuSockets is the number of vCPU sockets of the VM
     */
    @JsonProperty("vcpuSockets")
    public Integer getVcpuSockets() {
        return vcpuSockets;
    }

    /**
     * vcpuSockets is the number of vCPU sockets of the VM
     */
    @JsonProperty("vcpuSockets")
    public void setVcpuSockets(Integer vcpuSockets) {
        this.vcpuSockets = vcpuSockets;
    }

    /**
     * vcpusPerSocket is the number of vCPUs per socket of the VM
     */
    @JsonProperty("vcpusPerSocket")
    public Integer getVcpusPerSocket() {
        return vcpusPerSocket;
    }

    /**
     * vcpusPerSocket is the number of vCPUs per socket of the VM
     */
    @JsonProperty("vcpusPerSocket")
    public void setVcpusPerSocket(Integer vcpusPerSocket) {
        this.vcpusPerSocket = vcpusPerSocket;
    }

    @JsonIgnore
    public NutanixMachineProviderConfigBuilder edit() {
        return new NutanixMachineProviderConfigBuilder(this);
    }

    @JsonIgnore
    public NutanixMachineProviderConfigBuilder toBuilder() {
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
