
package io.fabric8.openshift.api.model.machine.v1beta1;

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
 * GCPMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an GCP virtual machine. It is used by the GCP machine actuator to create a single Machine. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "canIPForward",
    "confidentialCompute",
    "credentialsSecret",
    "deletionProtection",
    "disks",
    "gcpMetadata",
    "gpus",
    "labels",
    "machineType",
    "networkInterfaces",
    "onHostMaintenance",
    "preemptible",
    "projectID",
    "region",
    "resourceManagerTags",
    "restartPolicy",
    "serviceAccounts",
    "shieldedInstanceConfig",
    "tags",
    "targetPools",
    "userDataSecret",
    "zone"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class GCPMachineProviderSpec implements Editable<GCPMachineProviderSpecBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "machine.openshift.io/v1beta1";
    @JsonProperty("canIPForward")
    private Boolean canIPForward;
    @JsonProperty("confidentialCompute")
    private String confidentialCompute;
    @JsonProperty("credentialsSecret")
    private LocalObjectReference credentialsSecret;
    @JsonProperty("deletionProtection")
    private Boolean deletionProtection;
    @JsonProperty("disks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GCPDisk> disks = new ArrayList<>();
    @JsonProperty("gcpMetadata")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GCPMetadata> gcpMetadata = new ArrayList<>();
    @JsonProperty("gpus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GCPGPUConfig> gpus = new ArrayList<>();
    @JsonProperty("kind")
    private String kind = "GCPMachineProviderSpec";
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labels = new LinkedHashMap<>();
    @JsonProperty("machineType")
    private String machineType;
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("networkInterfaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GCPNetworkInterface> networkInterfaces = new ArrayList<>();
    @JsonProperty("onHostMaintenance")
    private String onHostMaintenance;
    @JsonProperty("preemptible")
    private Boolean preemptible;
    @JsonProperty("projectID")
    private String projectID;
    @JsonProperty("region")
    private String region;
    @JsonProperty("resourceManagerTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ResourceManagerTag> resourceManagerTags = new ArrayList<>();
    @JsonProperty("restartPolicy")
    private String restartPolicy;
    @JsonProperty("serviceAccounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GCPServiceAccount> serviceAccounts = new ArrayList<>();
    @JsonProperty("shieldedInstanceConfig")
    private GCPShieldedInstanceConfig shieldedInstanceConfig;
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> tags = new ArrayList<>();
    @JsonProperty("targetPools")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> targetPools = new ArrayList<>();
    @JsonProperty("userDataSecret")
    private LocalObjectReference userDataSecret;
    @JsonProperty("zone")
    private String zone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GCPMachineProviderSpec() {
    }

    public GCPMachineProviderSpec(String apiVersion, Boolean canIPForward, String confidentialCompute, LocalObjectReference credentialsSecret, Boolean deletionProtection, List<GCPDisk> disks, List<GCPMetadata> gcpMetadata, List<GCPGPUConfig> gpus, String kind, Map<String, String> labels, String machineType, ObjectMeta metadata, List<GCPNetworkInterface> networkInterfaces, String onHostMaintenance, Boolean preemptible, String projectID, String region, List<ResourceManagerTag> resourceManagerTags, String restartPolicy, List<GCPServiceAccount> serviceAccounts, GCPShieldedInstanceConfig shieldedInstanceConfig, List<String> tags, List<String> targetPools, LocalObjectReference userDataSecret, String zone) {
        super();
        this.apiVersion = apiVersion;
        this.canIPForward = canIPForward;
        this.confidentialCompute = confidentialCompute;
        this.credentialsSecret = credentialsSecret;
        this.deletionProtection = deletionProtection;
        this.disks = disks;
        this.gcpMetadata = gcpMetadata;
        this.gpus = gpus;
        this.kind = kind;
        this.labels = labels;
        this.machineType = machineType;
        this.metadata = metadata;
        this.networkInterfaces = networkInterfaces;
        this.onHostMaintenance = onHostMaintenance;
        this.preemptible = preemptible;
        this.projectID = projectID;
        this.region = region;
        this.resourceManagerTags = resourceManagerTags;
        this.restartPolicy = restartPolicy;
        this.serviceAccounts = serviceAccounts;
        this.shieldedInstanceConfig = shieldedInstanceConfig;
        this.tags = tags;
        this.targetPools = targetPools;
        this.userDataSecret = userDataSecret;
        this.zone = zone;
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
     * canIPForward Allows this instance to send and receive packets with non-matching destination or source IPs. This is required if you plan to use this instance to forward routes.
     */
    @JsonProperty("canIPForward")
    public Boolean getCanIPForward() {
        return canIPForward;
    }

    /**
     * canIPForward Allows this instance to send and receive packets with non-matching destination or source IPs. This is required if you plan to use this instance to forward routes.
     */
    @JsonProperty("canIPForward")
    public void setCanIPForward(Boolean canIPForward) {
        this.canIPForward = canIPForward;
    }

    /**
     * confidentialCompute is an optional field defining whether the instance should have confidential compute enabled or not, and the confidential computing technology of choice. Allowed values are omitted, Disabled, Enabled, AMDEncryptedVirtualization, AMDEncryptedVirtualizationNestedPaging, and IntelTrustedDomainExtensions When set to Disabled, the machine will not be configured to be a confidential computing instance. When set to Enabled, the machine will be configured as a confidential computing instance with no preference on the confidential compute policy used. In this mode, the platform chooses a default that is subject to change over time. Currently, the default is to use AMD Secure Encrypted Virtualization. When set to AMDEncryptedVirtualization, the machine will be configured as a confidential computing instance with AMD Secure Encrypted Virtualization (AMD SEV) as the confidential computing technology. When set to AMDEncryptedVirtualizationNestedPaging, the machine will be configured as a confidential computing instance with AMD Secure Encrypted Virtualization Secure Nested Paging (AMD SEV-SNP) as the confidential computing technology. When set to IntelTrustedDomainExtensions, the machine will be configured as a confidential computing instance with Intel Trusted Domain Extensions (Intel TDX) as the confidential computing technology. If any value other than Disabled is set the selected machine type must support that specific confidential computing technology. The machine series supporting confidential computing technologies can be checked at https://cloud.google.com/confidential-computing/confidential-vm/docs/supported-configurations#all-confidential-vm-instances Currently, AMDEncryptedVirtualization is supported in c2d, n2d, and c3d machines. AMDEncryptedVirtualizationNestedPaging is supported in n2d machines. IntelTrustedDomainExtensions is supported in c3 machines. If any value other than Disabled is set, the selected region must support that specific confidential computing technology. The list of regions supporting confidential computing technologies can be checked at https://cloud.google.com/confidential-computing/confidential-vm/docs/supported-configurations#supported-zones If any value other than Disabled is set onHostMaintenance is required to be set to "Terminate". If omitted, the platform chooses a default, which is subject to change over time, currently that default is Disabled.
     */
    @JsonProperty("confidentialCompute")
    public String getConfidentialCompute() {
        return confidentialCompute;
    }

    /**
     * confidentialCompute is an optional field defining whether the instance should have confidential compute enabled or not, and the confidential computing technology of choice. Allowed values are omitted, Disabled, Enabled, AMDEncryptedVirtualization, AMDEncryptedVirtualizationNestedPaging, and IntelTrustedDomainExtensions When set to Disabled, the machine will not be configured to be a confidential computing instance. When set to Enabled, the machine will be configured as a confidential computing instance with no preference on the confidential compute policy used. In this mode, the platform chooses a default that is subject to change over time. Currently, the default is to use AMD Secure Encrypted Virtualization. When set to AMDEncryptedVirtualization, the machine will be configured as a confidential computing instance with AMD Secure Encrypted Virtualization (AMD SEV) as the confidential computing technology. When set to AMDEncryptedVirtualizationNestedPaging, the machine will be configured as a confidential computing instance with AMD Secure Encrypted Virtualization Secure Nested Paging (AMD SEV-SNP) as the confidential computing technology. When set to IntelTrustedDomainExtensions, the machine will be configured as a confidential computing instance with Intel Trusted Domain Extensions (Intel TDX) as the confidential computing technology. If any value other than Disabled is set the selected machine type must support that specific confidential computing technology. The machine series supporting confidential computing technologies can be checked at https://cloud.google.com/confidential-computing/confidential-vm/docs/supported-configurations#all-confidential-vm-instances Currently, AMDEncryptedVirtualization is supported in c2d, n2d, and c3d machines. AMDEncryptedVirtualizationNestedPaging is supported in n2d machines. IntelTrustedDomainExtensions is supported in c3 machines. If any value other than Disabled is set, the selected region must support that specific confidential computing technology. The list of regions supporting confidential computing technologies can be checked at https://cloud.google.com/confidential-computing/confidential-vm/docs/supported-configurations#supported-zones If any value other than Disabled is set onHostMaintenance is required to be set to "Terminate". If omitted, the platform chooses a default, which is subject to change over time, currently that default is Disabled.
     */
    @JsonProperty("confidentialCompute")
    public void setConfidentialCompute(String confidentialCompute) {
        this.confidentialCompute = confidentialCompute;
    }

    /**
     * GCPMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an GCP virtual machine. It is used by the GCP machine actuator to create a single Machine. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("credentialsSecret")
    public LocalObjectReference getCredentialsSecret() {
        return credentialsSecret;
    }

    /**
     * GCPMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an GCP virtual machine. It is used by the GCP machine actuator to create a single Machine. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("credentialsSecret")
    public void setCredentialsSecret(LocalObjectReference credentialsSecret) {
        this.credentialsSecret = credentialsSecret;
    }

    /**
     * deletionProtection whether the resource should be protected against deletion.
     */
    @JsonProperty("deletionProtection")
    public Boolean getDeletionProtection() {
        return deletionProtection;
    }

    /**
     * deletionProtection whether the resource should be protected against deletion.
     */
    @JsonProperty("deletionProtection")
    public void setDeletionProtection(Boolean deletionProtection) {
        this.deletionProtection = deletionProtection;
    }

    /**
     * disks is a list of disks to be attached to the VM.
     */
    @JsonProperty("disks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GCPDisk> getDisks() {
        return disks;
    }

    /**
     * disks is a list of disks to be attached to the VM.
     */
    @JsonProperty("disks")
    public void setDisks(List<GCPDisk> disks) {
        this.disks = disks;
    }

    /**
     * Metadata key/value pairs to apply to the VM.
     */
    @JsonProperty("gcpMetadata")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GCPMetadata> getGcpMetadata() {
        return gcpMetadata;
    }

    /**
     * Metadata key/value pairs to apply to the VM.
     */
    @JsonProperty("gcpMetadata")
    public void setGcpMetadata(List<GCPMetadata> gcpMetadata) {
        this.gcpMetadata = gcpMetadata;
    }

    /**
     * gpus is a list of GPUs to be attached to the VM.
     */
    @JsonProperty("gpus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GCPGPUConfig> getGpus() {
        return gpus;
    }

    /**
     * gpus is a list of GPUs to be attached to the VM.
     */
    @JsonProperty("gpus")
    public void setGpus(List<GCPGPUConfig> gpus) {
        this.gpus = gpus;
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
     * labels list of labels to apply to the VM.
     */
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getLabels() {
        return labels;
    }

    /**
     * labels list of labels to apply to the VM.
     */
    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    /**
     * machineType is the machine type to use for the VM.
     */
    @JsonProperty("machineType")
    public String getMachineType() {
        return machineType;
    }

    /**
     * machineType is the machine type to use for the VM.
     */
    @JsonProperty("machineType")
    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    /**
     * GCPMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an GCP virtual machine. It is used by the GCP machine actuator to create a single Machine. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * GCPMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an GCP virtual machine. It is used by the GCP machine actuator to create a single Machine. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * networkInterfaces is a list of network interfaces to be attached to the VM.
     */
    @JsonProperty("networkInterfaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GCPNetworkInterface> getNetworkInterfaces() {
        return networkInterfaces;
    }

    /**
     * networkInterfaces is a list of network interfaces to be attached to the VM.
     */
    @JsonProperty("networkInterfaces")
    public void setNetworkInterfaces(List<GCPNetworkInterface> networkInterfaces) {
        this.networkInterfaces = networkInterfaces;
    }

    /**
     * onHostMaintenance determines the behavior when a maintenance event occurs that might cause the instance to reboot. This is required to be set to "Terminate" if you want to provision machine with attached GPUs. Otherwise, allowed values are "Migrate" and "Terminate". If omitted, the platform chooses a default, which is subject to change over time, currently that default is "Migrate".
     */
    @JsonProperty("onHostMaintenance")
    public String getOnHostMaintenance() {
        return onHostMaintenance;
    }

    /**
     * onHostMaintenance determines the behavior when a maintenance event occurs that might cause the instance to reboot. This is required to be set to "Terminate" if you want to provision machine with attached GPUs. Otherwise, allowed values are "Migrate" and "Terminate". If omitted, the platform chooses a default, which is subject to change over time, currently that default is "Migrate".
     */
    @JsonProperty("onHostMaintenance")
    public void setOnHostMaintenance(String onHostMaintenance) {
        this.onHostMaintenance = onHostMaintenance;
    }

    /**
     * preemptible indicates if created instance is preemptible.
     */
    @JsonProperty("preemptible")
    public Boolean getPreemptible() {
        return preemptible;
    }

    /**
     * preemptible indicates if created instance is preemptible.
     */
    @JsonProperty("preemptible")
    public void setPreemptible(Boolean preemptible) {
        this.preemptible = preemptible;
    }

    /**
     * projectID is the project in which the GCP machine provider will create the VM.
     */
    @JsonProperty("projectID")
    public String getProjectID() {
        return projectID;
    }

    /**
     * projectID is the project in which the GCP machine provider will create the VM.
     */
    @JsonProperty("projectID")
    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    /**
     * region is the region in which the GCP machine provider will create the VM.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * region is the region in which the GCP machine provider will create the VM.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * resourceManagerTags is an optional list of tags to apply to the GCP resources created for the cluster. See https://cloud.google.com/resource-manager/docs/tags/tags-overview for information on tagging GCP resources. GCP supports a maximum of 50 tags per resource.
     */
    @JsonProperty("resourceManagerTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ResourceManagerTag> getResourceManagerTags() {
        return resourceManagerTags;
    }

    /**
     * resourceManagerTags is an optional list of tags to apply to the GCP resources created for the cluster. See https://cloud.google.com/resource-manager/docs/tags/tags-overview for information on tagging GCP resources. GCP supports a maximum of 50 tags per resource.
     */
    @JsonProperty("resourceManagerTags")
    public void setResourceManagerTags(List<ResourceManagerTag> resourceManagerTags) {
        this.resourceManagerTags = resourceManagerTags;
    }

    /**
     * restartPolicy determines the behavior when an instance crashes or the underlying infrastructure provider stops the instance as part of a maintenance event (default "Always"). Cannot be "Always" with preemptible instances. Otherwise, allowed values are "Always" and "Never". If omitted, the platform chooses a default, which is subject to change over time, currently that default is "Always". RestartPolicy represents AutomaticRestart in GCP compute api
     */
    @JsonProperty("restartPolicy")
    public String getRestartPolicy() {
        return restartPolicy;
    }

    /**
     * restartPolicy determines the behavior when an instance crashes or the underlying infrastructure provider stops the instance as part of a maintenance event (default "Always"). Cannot be "Always" with preemptible instances. Otherwise, allowed values are "Always" and "Never". If omitted, the platform chooses a default, which is subject to change over time, currently that default is "Always". RestartPolicy represents AutomaticRestart in GCP compute api
     */
    @JsonProperty("restartPolicy")
    public void setRestartPolicy(String restartPolicy) {
        this.restartPolicy = restartPolicy;
    }

    /**
     * serviceAccounts is a list of GCP service accounts to be used by the VM.
     */
    @JsonProperty("serviceAccounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GCPServiceAccount> getServiceAccounts() {
        return serviceAccounts;
    }

    /**
     * serviceAccounts is a list of GCP service accounts to be used by the VM.
     */
    @JsonProperty("serviceAccounts")
    public void setServiceAccounts(List<GCPServiceAccount> serviceAccounts) {
        this.serviceAccounts = serviceAccounts;
    }

    /**
     * GCPMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an GCP virtual machine. It is used by the GCP machine actuator to create a single Machine. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("shieldedInstanceConfig")
    public GCPShieldedInstanceConfig getShieldedInstanceConfig() {
        return shieldedInstanceConfig;
    }

    /**
     * GCPMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an GCP virtual machine. It is used by the GCP machine actuator to create a single Machine. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("shieldedInstanceConfig")
    public void setShieldedInstanceConfig(GCPShieldedInstanceConfig shieldedInstanceConfig) {
        this.shieldedInstanceConfig = shieldedInstanceConfig;
    }

    /**
     * tags list of network tags to apply to the VM.
     */
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTags() {
        return tags;
    }

    /**
     * tags list of network tags to apply to the VM.
     */
    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * targetPools are used for network TCP/UDP load balancing. A target pool references member instances, an associated legacy HttpHealthCheck resource, and, optionally, a backup target pool
     */
    @JsonProperty("targetPools")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTargetPools() {
        return targetPools;
    }

    /**
     * targetPools are used for network TCP/UDP load balancing. A target pool references member instances, an associated legacy HttpHealthCheck resource, and, optionally, a backup target pool
     */
    @JsonProperty("targetPools")
    public void setTargetPools(List<String> targetPools) {
        this.targetPools = targetPools;
    }

    /**
     * GCPMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an GCP virtual machine. It is used by the GCP machine actuator to create a single Machine. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("userDataSecret")
    public LocalObjectReference getUserDataSecret() {
        return userDataSecret;
    }

    /**
     * GCPMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an GCP virtual machine. It is used by the GCP machine actuator to create a single Machine. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("userDataSecret")
    public void setUserDataSecret(LocalObjectReference userDataSecret) {
        this.userDataSecret = userDataSecret;
    }

    /**
     * zone is the zone in which the GCP machine provider will create the VM.
     */
    @JsonProperty("zone")
    public String getZone() {
        return zone;
    }

    /**
     * zone is the zone in which the GCP machine provider will create the VM.
     */
    @JsonProperty("zone")
    public void setZone(String zone) {
        this.zone = zone;
    }

    @JsonIgnore
    public GCPMachineProviderSpecBuilder edit() {
        return new GCPMachineProviderSpecBuilder(this);
    }

    @JsonIgnore
    public GCPMachineProviderSpecBuilder toBuilder() {
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
