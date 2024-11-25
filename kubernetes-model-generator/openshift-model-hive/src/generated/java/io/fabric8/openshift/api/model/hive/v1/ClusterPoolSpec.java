
package io.fabric8.openshift.api.model.hive.v1;

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
     * 
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

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    @JsonProperty("baseDomain")
    public String getBaseDomain() {
        return baseDomain;
    }

    @JsonProperty("baseDomain")
    public void setBaseDomain(String baseDomain) {
        this.baseDomain = baseDomain;
    }

    @JsonProperty("claimLifetime")
    public ClusterPoolClaimLifetime getClaimLifetime() {
        return claimLifetime;
    }

    @JsonProperty("claimLifetime")
    public void setClaimLifetime(ClusterPoolClaimLifetime claimLifetime) {
        this.claimLifetime = claimLifetime;
    }

    @JsonProperty("hibernateAfter")
    public String getHibernateAfter() {
        return hibernateAfter;
    }

    @JsonProperty("hibernateAfter")
    public void setHibernateAfter(String hibernateAfter) {
        this.hibernateAfter = hibernateAfter;
    }

    @JsonProperty("hibernationConfig")
    public HibernationConfig getHibernationConfig() {
        return hibernationConfig;
    }

    @JsonProperty("hibernationConfig")
    public void setHibernationConfig(HibernationConfig hibernationConfig) {
        this.hibernationConfig = hibernationConfig;
    }

    @JsonProperty("imageSetRef")
    public ClusterImageSetReference getImageSetRef() {
        return imageSetRef;
    }

    @JsonProperty("imageSetRef")
    public void setImageSetRef(ClusterImageSetReference imageSetRef) {
        this.imageSetRef = imageSetRef;
    }

    @JsonProperty("installAttemptsLimit")
    public Integer getInstallAttemptsLimit() {
        return installAttemptsLimit;
    }

    @JsonProperty("installAttemptsLimit")
    public void setInstallAttemptsLimit(Integer installAttemptsLimit) {
        this.installAttemptsLimit = installAttemptsLimit;
    }

    @JsonProperty("installConfigSecretTemplateRef")
    public LocalObjectReference getInstallConfigSecretTemplateRef() {
        return installConfigSecretTemplateRef;
    }

    @JsonProperty("installConfigSecretTemplateRef")
    public void setInstallConfigSecretTemplateRef(LocalObjectReference installConfigSecretTemplateRef) {
        this.installConfigSecretTemplateRef = installConfigSecretTemplateRef;
    }

    @JsonProperty("installerEnv")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EnvVar> getInstallerEnv() {
        return installerEnv;
    }

    @JsonProperty("installerEnv")
    public void setInstallerEnv(List<EnvVar> installerEnv) {
        this.installerEnv = installerEnv;
    }

    @JsonProperty("inventory")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<InventoryEntry> getInventory() {
        return inventory;
    }

    @JsonProperty("inventory")
    public void setInventory(List<InventoryEntry> inventory) {
        this.inventory = inventory;
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

    @JsonProperty("maxConcurrent")
    public Integer getMaxConcurrent() {
        return maxConcurrent;
    }

    @JsonProperty("maxConcurrent")
    public void setMaxConcurrent(Integer maxConcurrent) {
        this.maxConcurrent = maxConcurrent;
    }

    @JsonProperty("maxSize")
    public Integer getMaxSize() {
        return maxSize;
    }

    @JsonProperty("maxSize")
    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }

    @JsonProperty("platform")
    public Platform getPlatform() {
        return platform;
    }

    @JsonProperty("platform")
    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    @JsonProperty("pullSecretRef")
    public LocalObjectReference getPullSecretRef() {
        return pullSecretRef;
    }

    @JsonProperty("pullSecretRef")
    public void setPullSecretRef(LocalObjectReference pullSecretRef) {
        this.pullSecretRef = pullSecretRef;
    }

    @JsonProperty("runningCount")
    public Integer getRunningCount() {
        return runningCount;
    }

    @JsonProperty("runningCount")
    public void setRunningCount(Integer runningCount) {
        this.runningCount = runningCount;
    }

    @JsonProperty("size")
    public Integer getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(Integer size) {
        this.size = size;
    }

    @JsonProperty("skipMachinePools")
    public Boolean getSkipMachinePools() {
        return skipMachinePools;
    }

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
