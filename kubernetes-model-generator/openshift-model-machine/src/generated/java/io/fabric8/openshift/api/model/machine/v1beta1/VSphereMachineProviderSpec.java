
package io.fabric8.openshift.api.model.machine.v1beta1;

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
 * VSphereMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an VSphere virtual machine. It is used by the vSphere machine actuator to create a single Machine. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "cloneMode",
    "credentialsSecret",
    "diskGiB",
    "memoryMiB",
    "network",
    "numCPUs",
    "numCoresPerSocket",
    "snapshot",
    "tagIDs",
    "template",
    "userDataSecret",
    "workspace"
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
@Version("v1beta1")
@Group("machine.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class VSphereMachineProviderSpec implements Editable<VSphereMachineProviderSpecBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "machine.openshift.io/v1beta1";
    @JsonProperty("cloneMode")
    private String cloneMode;
    @JsonProperty("credentialsSecret")
    private LocalObjectReference credentialsSecret;
    @JsonProperty("diskGiB")
    private Integer diskGiB;
    @JsonProperty("kind")
    private String kind = "VSphereMachineProviderSpec";
    @JsonProperty("memoryMiB")
    private Long memoryMiB;
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("network")
    private NetworkSpec network;
    @JsonProperty("numCPUs")
    private Integer numCPUs;
    @JsonProperty("numCoresPerSocket")
    private Integer numCoresPerSocket;
    @JsonProperty("snapshot")
    private String snapshot;
    @JsonProperty("tagIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> tagIDs = new ArrayList<>();
    @JsonProperty("template")
    private String template;
    @JsonProperty("userDataSecret")
    private LocalObjectReference userDataSecret;
    @JsonProperty("workspace")
    private Workspace workspace;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VSphereMachineProviderSpec() {
    }

    public VSphereMachineProviderSpec(String apiVersion, String cloneMode, LocalObjectReference credentialsSecret, Integer diskGiB, String kind, Long memoryMiB, ObjectMeta metadata, NetworkSpec network, Integer numCPUs, Integer numCoresPerSocket, String snapshot, List<String> tagIDs, String template, LocalObjectReference userDataSecret, Workspace workspace) {
        super();
        this.apiVersion = apiVersion;
        this.cloneMode = cloneMode;
        this.credentialsSecret = credentialsSecret;
        this.diskGiB = diskGiB;
        this.kind = kind;
        this.memoryMiB = memoryMiB;
        this.metadata = metadata;
        this.network = network;
        this.numCPUs = numCPUs;
        this.numCoresPerSocket = numCoresPerSocket;
        this.snapshot = snapshot;
        this.tagIDs = tagIDs;
        this.template = template;
        this.userDataSecret = userDataSecret;
        this.workspace = workspace;
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
     * CloneMode specifies the type of clone operation. The LinkedClone mode is only support for templates that have at least one snapshot. If the template has no snapshots, then CloneMode defaults to FullClone. When LinkedClone mode is enabled the DiskGiB field is ignored as it is not possible to expand disks of linked clones. Defaults to FullClone. When using LinkedClone, if no snapshots exist for the source template, falls back to FullClone.
     */
    @JsonProperty("cloneMode")
    public String getCloneMode() {
        return cloneMode;
    }

    /**
     * CloneMode specifies the type of clone operation. The LinkedClone mode is only support for templates that have at least one snapshot. If the template has no snapshots, then CloneMode defaults to FullClone. When LinkedClone mode is enabled the DiskGiB field is ignored as it is not possible to expand disks of linked clones. Defaults to FullClone. When using LinkedClone, if no snapshots exist for the source template, falls back to FullClone.
     */
    @JsonProperty("cloneMode")
    public void setCloneMode(String cloneMode) {
        this.cloneMode = cloneMode;
    }

    /**
     * VSphereMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an VSphere virtual machine. It is used by the vSphere machine actuator to create a single Machine. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("credentialsSecret")
    public LocalObjectReference getCredentialsSecret() {
        return credentialsSecret;
    }

    /**
     * VSphereMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an VSphere virtual machine. It is used by the vSphere machine actuator to create a single Machine. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("credentialsSecret")
    public void setCredentialsSecret(LocalObjectReference credentialsSecret) {
        this.credentialsSecret = credentialsSecret;
    }

    /**
     * DiskGiB is the size of a virtual machine's disk, in GiB. Defaults to the analogue property value in the template from which this machine is cloned. This parameter will be ignored if 'LinkedClone' CloneMode is set.
     */
    @JsonProperty("diskGiB")
    public Integer getDiskGiB() {
        return diskGiB;
    }

    /**
     * DiskGiB is the size of a virtual machine's disk, in GiB. Defaults to the analogue property value in the template from which this machine is cloned. This parameter will be ignored if 'LinkedClone' CloneMode is set.
     */
    @JsonProperty("diskGiB")
    public void setDiskGiB(Integer diskGiB) {
        this.diskGiB = diskGiB;
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
     * MemoryMiB is the size of a virtual machine's memory, in MiB. Defaults to the analogue property value in the template from which this machine is cloned.
     */
    @JsonProperty("memoryMiB")
    public Long getMemoryMiB() {
        return memoryMiB;
    }

    /**
     * MemoryMiB is the size of a virtual machine's memory, in MiB. Defaults to the analogue property value in the template from which this machine is cloned.
     */
    @JsonProperty("memoryMiB")
    public void setMemoryMiB(Long memoryMiB) {
        this.memoryMiB = memoryMiB;
    }

    /**
     * VSphereMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an VSphere virtual machine. It is used by the vSphere machine actuator to create a single Machine. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * VSphereMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an VSphere virtual machine. It is used by the vSphere machine actuator to create a single Machine. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * VSphereMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an VSphere virtual machine. It is used by the vSphere machine actuator to create a single Machine. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("network")
    public NetworkSpec getNetwork() {
        return network;
    }

    /**
     * VSphereMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an VSphere virtual machine. It is used by the vSphere machine actuator to create a single Machine. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("network")
    public void setNetwork(NetworkSpec network) {
        this.network = network;
    }

    /**
     * NumCPUs is the number of virtual processors in a virtual machine. Defaults to the analogue property value in the template from which this machine is cloned.
     */
    @JsonProperty("numCPUs")
    public Integer getNumCPUs() {
        return numCPUs;
    }

    /**
     * NumCPUs is the number of virtual processors in a virtual machine. Defaults to the analogue property value in the template from which this machine is cloned.
     */
    @JsonProperty("numCPUs")
    public void setNumCPUs(Integer numCPUs) {
        this.numCPUs = numCPUs;
    }

    /**
     * NumCPUs is the number of cores among which to distribute CPUs in this virtual machine. Defaults to the analogue property value in the template from which this machine is cloned.
     */
    @JsonProperty("numCoresPerSocket")
    public Integer getNumCoresPerSocket() {
        return numCoresPerSocket;
    }

    /**
     * NumCPUs is the number of cores among which to distribute CPUs in this virtual machine. Defaults to the analogue property value in the template from which this machine is cloned.
     */
    @JsonProperty("numCoresPerSocket")
    public void setNumCoresPerSocket(Integer numCoresPerSocket) {
        this.numCoresPerSocket = numCoresPerSocket;
    }

    /**
     * Snapshot is the name of the snapshot from which the VM was cloned
     */
    @JsonProperty("snapshot")
    public String getSnapshot() {
        return snapshot;
    }

    /**
     * Snapshot is the name of the snapshot from which the VM was cloned
     */
    @JsonProperty("snapshot")
    public void setSnapshot(String snapshot) {
        this.snapshot = snapshot;
    }

    /**
     * tagIDs is an optional set of tags to add to an instance. Specified tagIDs must use URN-notation instead of display names. A maximum of 10 tag IDs may be specified.
     */
    @JsonProperty("tagIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTagIDs() {
        return tagIDs;
    }

    /**
     * tagIDs is an optional set of tags to add to an instance. Specified tagIDs must use URN-notation instead of display names. A maximum of 10 tag IDs may be specified.
     */
    @JsonProperty("tagIDs")
    public void setTagIDs(List<String> tagIDs) {
        this.tagIDs = tagIDs;
    }

    /**
     * Template is the name, inventory path, or instance UUID of the template used to clone new machines.
     */
    @JsonProperty("template")
    public String getTemplate() {
        return template;
    }

    /**
     * Template is the name, inventory path, or instance UUID of the template used to clone new machines.
     */
    @JsonProperty("template")
    public void setTemplate(String template) {
        this.template = template;
    }

    /**
     * VSphereMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an VSphere virtual machine. It is used by the vSphere machine actuator to create a single Machine. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("userDataSecret")
    public LocalObjectReference getUserDataSecret() {
        return userDataSecret;
    }

    /**
     * VSphereMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an VSphere virtual machine. It is used by the vSphere machine actuator to create a single Machine. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("userDataSecret")
    public void setUserDataSecret(LocalObjectReference userDataSecret) {
        this.userDataSecret = userDataSecret;
    }

    /**
     * VSphereMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an VSphere virtual machine. It is used by the vSphere machine actuator to create a single Machine. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("workspace")
    public Workspace getWorkspace() {
        return workspace;
    }

    /**
     * VSphereMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an VSphere virtual machine. It is used by the vSphere machine actuator to create a single Machine. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("workspace")
    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }

    @JsonIgnore
    public VSphereMachineProviderSpecBuilder edit() {
        return new VSphereMachineProviderSpecBuilder(this);
    }

    @JsonIgnore
    public VSphereMachineProviderSpecBuilder toBuilder() {
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
