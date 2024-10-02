
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
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1beta1")
@Group("machine.openshift.io")
@Generated("jsonschema2pojo")
public class GCPMachineProviderSpec implements Editable<GCPMachineProviderSpecBuilder> , HasMetadata, Namespaced
{

    /**
     * 
     * (Required)
     * 
     */
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
    /**
     * 
     * (Required)
     * 
     */
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
     * 
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
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("canIPForward")
    public Boolean getCanIPForward() {
        return canIPForward;
    }

    @JsonProperty("canIPForward")
    public void setCanIPForward(Boolean canIPForward) {
        this.canIPForward = canIPForward;
    }

    @JsonProperty("confidentialCompute")
    public String getConfidentialCompute() {
        return confidentialCompute;
    }

    @JsonProperty("confidentialCompute")
    public void setConfidentialCompute(String confidentialCompute) {
        this.confidentialCompute = confidentialCompute;
    }

    @JsonProperty("credentialsSecret")
    public LocalObjectReference getCredentialsSecret() {
        return credentialsSecret;
    }

    @JsonProperty("credentialsSecret")
    public void setCredentialsSecret(LocalObjectReference credentialsSecret) {
        this.credentialsSecret = credentialsSecret;
    }

    @JsonProperty("deletionProtection")
    public Boolean getDeletionProtection() {
        return deletionProtection;
    }

    @JsonProperty("deletionProtection")
    public void setDeletionProtection(Boolean deletionProtection) {
        this.deletionProtection = deletionProtection;
    }

    @JsonProperty("disks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GCPDisk> getDisks() {
        return disks;
    }

    @JsonProperty("disks")
    public void setDisks(List<GCPDisk> disks) {
        this.disks = disks;
    }

    @JsonProperty("gcpMetadata")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GCPMetadata> getGcpMetadata() {
        return gcpMetadata;
    }

    @JsonProperty("gcpMetadata")
    public void setGcpMetadata(List<GCPMetadata> gcpMetadata) {
        this.gcpMetadata = gcpMetadata;
    }

    @JsonProperty("gpus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GCPGPUConfig> getGpus() {
        return gpus;
    }

    @JsonProperty("gpus")
    public void setGpus(List<GCPGPUConfig> gpus) {
        this.gpus = gpus;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    @JsonProperty("machineType")
    public String getMachineType() {
        return machineType;
    }

    @JsonProperty("machineType")
    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("networkInterfaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GCPNetworkInterface> getNetworkInterfaces() {
        return networkInterfaces;
    }

    @JsonProperty("networkInterfaces")
    public void setNetworkInterfaces(List<GCPNetworkInterface> networkInterfaces) {
        this.networkInterfaces = networkInterfaces;
    }

    @JsonProperty("onHostMaintenance")
    public String getOnHostMaintenance() {
        return onHostMaintenance;
    }

    @JsonProperty("onHostMaintenance")
    public void setOnHostMaintenance(String onHostMaintenance) {
        this.onHostMaintenance = onHostMaintenance;
    }

    @JsonProperty("preemptible")
    public Boolean getPreemptible() {
        return preemptible;
    }

    @JsonProperty("preemptible")
    public void setPreemptible(Boolean preemptible) {
        this.preemptible = preemptible;
    }

    @JsonProperty("projectID")
    public String getProjectID() {
        return projectID;
    }

    @JsonProperty("projectID")
    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("resourceManagerTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ResourceManagerTag> getResourceManagerTags() {
        return resourceManagerTags;
    }

    @JsonProperty("resourceManagerTags")
    public void setResourceManagerTags(List<ResourceManagerTag> resourceManagerTags) {
        this.resourceManagerTags = resourceManagerTags;
    }

    @JsonProperty("restartPolicy")
    public String getRestartPolicy() {
        return restartPolicy;
    }

    @JsonProperty("restartPolicy")
    public void setRestartPolicy(String restartPolicy) {
        this.restartPolicy = restartPolicy;
    }

    @JsonProperty("serviceAccounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GCPServiceAccount> getServiceAccounts() {
        return serviceAccounts;
    }

    @JsonProperty("serviceAccounts")
    public void setServiceAccounts(List<GCPServiceAccount> serviceAccounts) {
        this.serviceAccounts = serviceAccounts;
    }

    @JsonProperty("shieldedInstanceConfig")
    public GCPShieldedInstanceConfig getShieldedInstanceConfig() {
        return shieldedInstanceConfig;
    }

    @JsonProperty("shieldedInstanceConfig")
    public void setShieldedInstanceConfig(GCPShieldedInstanceConfig shieldedInstanceConfig) {
        this.shieldedInstanceConfig = shieldedInstanceConfig;
    }

    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonProperty("targetPools")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTargetPools() {
        return targetPools;
    }

    @JsonProperty("targetPools")
    public void setTargetPools(List<String> targetPools) {
        this.targetPools = targetPools;
    }

    @JsonProperty("userDataSecret")
    public LocalObjectReference getUserDataSecret() {
        return userDataSecret;
    }

    @JsonProperty("userDataSecret")
    public void setUserDataSecret(LocalObjectReference userDataSecret) {
        this.userDataSecret = userDataSecret;
    }

    @JsonProperty("zone")
    public String getZone() {
        return zone;
    }

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
