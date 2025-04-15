
package io.fabric8.openshift.api.model.hive.v1;

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
 * ClusterPoolSpec defines the desired state of the ClusterPool.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "annotations",
    "baseDomain",
    "claimLifetime",
    "hibernateAfter",
    "hibernationConfig",
    "imageSetRef",
    "installAttemptsLimit",
    "installConfigSecretTemplateRef",
    "installerEnv",
    "inventory",
    "labels",
    "maxConcurrent",
    "maxSize",
    "platform",
    "pullSecretRef",
    "runningCount",
    "size",
    "skipMachinePools"
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
public class ClusterPoolSpec implements Editable<ClusterPoolSpecBuilder>, KubernetesResource
{

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<>();
    @JsonProperty("baseDomain")
    private String baseDomain;
    @JsonProperty("claimLifetime")
    private ClusterPoolClaimLifetime claimLifetime;
    @JsonProperty("hibernateAfter")
    private String hibernateAfter;
    @JsonProperty("hibernationConfig")
    private HibernationConfig hibernationConfig;
    @JsonProperty("imageSetRef")
    private ClusterImageSetReference imageSetRef;
    @JsonProperty("installAttemptsLimit")
    private Integer installAttemptsLimit;
    @JsonProperty("installConfigSecretTemplateRef")
    private LocalObjectReference installConfigSecretTemplateRef;
    @JsonProperty("installerEnv")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvVar> installerEnv = new ArrayList<>();
    @JsonProperty("inventory")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<InventoryEntry> inventory = new ArrayList<>();
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labels = new LinkedHashMap<>();
    @JsonProperty("maxConcurrent")
    private Integer maxConcurrent;
    @JsonProperty("maxSize")
    private Integer maxSize;
    @JsonProperty("platform")
    private Platform platform;
    @JsonProperty("pullSecretRef")
    private LocalObjectReference pullSecretRef;
    @JsonProperty("runningCount")
    private Integer runningCount;
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("skipMachinePools")
    private Boolean skipMachinePools;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterPoolSpec() {
    }

    public ClusterPoolSpec(Map<String, String> annotations, String baseDomain, ClusterPoolClaimLifetime claimLifetime, String hibernateAfter, HibernationConfig hibernationConfig, ClusterImageSetReference imageSetRef, Integer installAttemptsLimit, LocalObjectReference installConfigSecretTemplateRef, List<EnvVar> installerEnv, List<InventoryEntry> inventory, Map<String, String> labels, Integer maxConcurrent, Integer maxSize, Platform platform, LocalObjectReference pullSecretRef, Integer runningCount, Integer size, Boolean skipMachinePools) {
        super();
        this.annotations = annotations;
        this.baseDomain = baseDomain;
        this.claimLifetime = claimLifetime;
        this.hibernateAfter = hibernateAfter;
        this.hibernationConfig = hibernationConfig;
        this.imageSetRef = imageSetRef;
        this.installAttemptsLimit = installAttemptsLimit;
        this.installConfigSecretTemplateRef = installConfigSecretTemplateRef;
        this.installerEnv = installerEnv;
        this.inventory = inventory;
        this.labels = labels;
        this.maxConcurrent = maxConcurrent;
        this.maxSize = maxSize;
        this.platform = platform;
        this.pullSecretRef = pullSecretRef;
        this.runningCount = runningCount;
        this.size = size;
        this.skipMachinePools = skipMachinePools;
    }

    /**
     * Annotations to be applied to new ClusterDeployments created for the pool. ClusterDeployments that have already been claimed will not be affected when this value is modified.
     */
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    /**
     * Annotations to be applied to new ClusterDeployments created for the pool. ClusterDeployments that have already been claimed will not be affected when this value is modified.
     */
    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    /**
     * BaseDomain is the base domain to use for all clusters created in this pool.
     */
    @JsonProperty("baseDomain")
    public String getBaseDomain() {
        return baseDomain;
    }

    /**
     * BaseDomain is the base domain to use for all clusters created in this pool.
     */
    @JsonProperty("baseDomain")
    public void setBaseDomain(String baseDomain) {
        this.baseDomain = baseDomain;
    }

    /**
     * ClusterPoolSpec defines the desired state of the ClusterPool.
     */
    @JsonProperty("claimLifetime")
    public ClusterPoolClaimLifetime getClaimLifetime() {
        return claimLifetime;
    }

    /**
     * ClusterPoolSpec defines the desired state of the ClusterPool.
     */
    @JsonProperty("claimLifetime")
    public void setClaimLifetime(ClusterPoolClaimLifetime claimLifetime) {
        this.claimLifetime = claimLifetime;
    }

    /**
     * ClusterPoolSpec defines the desired state of the ClusterPool.
     */
    @JsonProperty("hibernateAfter")
    public String getHibernateAfter() {
        return hibernateAfter;
    }

    /**
     * ClusterPoolSpec defines the desired state of the ClusterPool.
     */
    @JsonProperty("hibernateAfter")
    public void setHibernateAfter(String hibernateAfter) {
        this.hibernateAfter = hibernateAfter;
    }

    /**
     * ClusterPoolSpec defines the desired state of the ClusterPool.
     */
    @JsonProperty("hibernationConfig")
    public HibernationConfig getHibernationConfig() {
        return hibernationConfig;
    }

    /**
     * ClusterPoolSpec defines the desired state of the ClusterPool.
     */
    @JsonProperty("hibernationConfig")
    public void setHibernationConfig(HibernationConfig hibernationConfig) {
        this.hibernationConfig = hibernationConfig;
    }

    /**
     * ClusterPoolSpec defines the desired state of the ClusterPool.
     */
    @JsonProperty("imageSetRef")
    public ClusterImageSetReference getImageSetRef() {
        return imageSetRef;
    }

    /**
     * ClusterPoolSpec defines the desired state of the ClusterPool.
     */
    @JsonProperty("imageSetRef")
    public void setImageSetRef(ClusterImageSetReference imageSetRef) {
        this.imageSetRef = imageSetRef;
    }

    /**
     * InstallAttemptsLimit is the maximum number of times Hive will attempt to install the cluster.
     */
    @JsonProperty("installAttemptsLimit")
    public Integer getInstallAttemptsLimit() {
        return installAttemptsLimit;
    }

    /**
     * InstallAttemptsLimit is the maximum number of times Hive will attempt to install the cluster.
     */
    @JsonProperty("installAttemptsLimit")
    public void setInstallAttemptsLimit(Integer installAttemptsLimit) {
        this.installAttemptsLimit = installAttemptsLimit;
    }

    /**
     * ClusterPoolSpec defines the desired state of the ClusterPool.
     */
    @JsonProperty("installConfigSecretTemplateRef")
    public LocalObjectReference getInstallConfigSecretTemplateRef() {
        return installConfigSecretTemplateRef;
    }

    /**
     * ClusterPoolSpec defines the desired state of the ClusterPool.
     */
    @JsonProperty("installConfigSecretTemplateRef")
    public void setInstallConfigSecretTemplateRef(LocalObjectReference installConfigSecretTemplateRef) {
        this.installConfigSecretTemplateRef = installConfigSecretTemplateRef;
    }

    /**
     * InstallerEnv are extra environment variables to pass through to the installer. This may be used to enable additional features of the installer.
     */
    @JsonProperty("installerEnv")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EnvVar> getInstallerEnv() {
        return installerEnv;
    }

    /**
     * InstallerEnv are extra environment variables to pass through to the installer. This may be used to enable additional features of the installer.
     */
    @JsonProperty("installerEnv")
    public void setInstallerEnv(List<EnvVar> installerEnv) {
        this.installerEnv = installerEnv;
    }

    /**
     * Inventory maintains a list of entries consumed by the ClusterPool to customize the default ClusterDeployment.
     */
    @JsonProperty("inventory")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<InventoryEntry> getInventory() {
        return inventory;
    }

    /**
     * Inventory maintains a list of entries consumed by the ClusterPool to customize the default ClusterDeployment.
     */
    @JsonProperty("inventory")
    public void setInventory(List<InventoryEntry> inventory) {
        this.inventory = inventory;
    }

    /**
     * Labels to be applied to new ClusterDeployments created for the pool. ClusterDeployments that have already been claimed will not be affected when this value is modified.
     */
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getLabels() {
        return labels;
    }

    /**
     * Labels to be applied to new ClusterDeployments created for the pool. ClusterDeployments that have already been claimed will not be affected when this value is modified.
     */
    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    /**
     * MaxConcurrent is the maximum number of clusters that will be provisioned or deprovisioned at an time. This includes the claimed clusters being deprovisioned. By default there is no limit.
     */
    @JsonProperty("maxConcurrent")
    public Integer getMaxConcurrent() {
        return maxConcurrent;
    }

    /**
     * MaxConcurrent is the maximum number of clusters that will be provisioned or deprovisioned at an time. This includes the claimed clusters being deprovisioned. By default there is no limit.
     */
    @JsonProperty("maxConcurrent")
    public void setMaxConcurrent(Integer maxConcurrent) {
        this.maxConcurrent = maxConcurrent;
    }

    /**
     * MaxSize is the maximum number of clusters that will be provisioned including clusters that have been claimed and ones waiting to be used. By default there is no limit.
     */
    @JsonProperty("maxSize")
    public Integer getMaxSize() {
        return maxSize;
    }

    /**
     * MaxSize is the maximum number of clusters that will be provisioned including clusters that have been claimed and ones waiting to be used. By default there is no limit.
     */
    @JsonProperty("maxSize")
    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * ClusterPoolSpec defines the desired state of the ClusterPool.
     */
    @JsonProperty("platform")
    public Platform getPlatform() {
        return platform;
    }

    /**
     * ClusterPoolSpec defines the desired state of the ClusterPool.
     */
    @JsonProperty("platform")
    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    /**
     * ClusterPoolSpec defines the desired state of the ClusterPool.
     */
    @JsonProperty("pullSecretRef")
    public LocalObjectReference getPullSecretRef() {
        return pullSecretRef;
    }

    /**
     * ClusterPoolSpec defines the desired state of the ClusterPool.
     */
    @JsonProperty("pullSecretRef")
    public void setPullSecretRef(LocalObjectReference pullSecretRef) {
        this.pullSecretRef = pullSecretRef;
    }

    /**
     * RunningCount is the number of clusters we should keep running. The remainder will be kept hibernated until claimed. By default no clusters will be kept running (all will be hibernated).
     */
    @JsonProperty("runningCount")
    public Integer getRunningCount() {
        return runningCount;
    }

    /**
     * RunningCount is the number of clusters we should keep running. The remainder will be kept hibernated until claimed. By default no clusters will be kept running (all will be hibernated).
     */
    @JsonProperty("runningCount")
    public void setRunningCount(Integer runningCount) {
        this.runningCount = runningCount;
    }

    /**
     * Size is the default number of clusters that we should keep provisioned and waiting for use.
     */
    @JsonProperty("size")
    public Integer getSize() {
        return size;
    }

    /**
     * Size is the default number of clusters that we should keep provisioned and waiting for use.
     */
    @JsonProperty("size")
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * SkipMachinePools allows creating clusterpools where the machinepools are not managed by hive after cluster creation
     */
    @JsonProperty("skipMachinePools")
    public Boolean getSkipMachinePools() {
        return skipMachinePools;
    }

    /**
     * SkipMachinePools allows creating clusterpools where the machinepools are not managed by hive after cluster creation
     */
    @JsonProperty("skipMachinePools")
    public void setSkipMachinePools(Boolean skipMachinePools) {
        this.skipMachinePools = skipMachinePools;
    }

    @JsonIgnore
    public ClusterPoolSpecBuilder edit() {
        return new ClusterPoolSpecBuilder(this);
    }

    @JsonIgnore
    public ClusterPoolSpecBuilder toBuilder() {
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
