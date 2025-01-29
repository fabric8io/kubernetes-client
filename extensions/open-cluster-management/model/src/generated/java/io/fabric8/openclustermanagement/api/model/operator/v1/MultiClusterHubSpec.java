
package io.fabric8.openclustermanagement.api.model.operator.v1;

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
import io.fabric8.kubernetes.api.model.Toleration;
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
    "availabilityConfig",
    "customCAConfigmap",
    "disableHubSelfManagement",
    "disableUpdateClusterImageSets",
    "enableClusterBackup",
    "enableClusterProxyAddon",
    "hive",
    "imagePullSecret",
    "ingress",
    "nodeSelector",
    "overrides",
    "separateCertificateManagement",
    "tolerations"
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
public class MultiClusterHubSpec implements Editable<MultiClusterHubSpecBuilder>, KubernetesResource
{

    @JsonProperty("availabilityConfig")
    private String availabilityConfig;
    @JsonProperty("customCAConfigmap")
    private String customCAConfigmap;
    @JsonProperty("disableHubSelfManagement")
    private Boolean disableHubSelfManagement;
    @JsonProperty("disableUpdateClusterImageSets")
    private Boolean disableUpdateClusterImageSets;
    @JsonProperty("enableClusterBackup")
    private Boolean enableClusterBackup;
    @JsonProperty("enableClusterProxyAddon")
    private Boolean enableClusterProxyAddon;
    @JsonProperty("hive")
    private HiveConfigSpec hive;
    @JsonProperty("imagePullSecret")
    private String imagePullSecret;
    @JsonProperty("ingress")
    private IngressSpec ingress;
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelector = new LinkedHashMap<>();
    @JsonProperty("overrides")
    private Overrides overrides;
    @JsonProperty("separateCertificateManagement")
    private Boolean separateCertificateManagement;
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Toleration> tolerations = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MultiClusterHubSpec() {
    }

    public MultiClusterHubSpec(String availabilityConfig, String customCAConfigmap, Boolean disableHubSelfManagement, Boolean disableUpdateClusterImageSets, Boolean enableClusterBackup, Boolean enableClusterProxyAddon, HiveConfigSpec hive, String imagePullSecret, IngressSpec ingress, Map<String, String> nodeSelector, Overrides overrides, Boolean separateCertificateManagement, List<Toleration> tolerations) {
        super();
        this.availabilityConfig = availabilityConfig;
        this.customCAConfigmap = customCAConfigmap;
        this.disableHubSelfManagement = disableHubSelfManagement;
        this.disableUpdateClusterImageSets = disableUpdateClusterImageSets;
        this.enableClusterBackup = enableClusterBackup;
        this.enableClusterProxyAddon = enableClusterProxyAddon;
        this.hive = hive;
        this.imagePullSecret = imagePullSecret;
        this.ingress = ingress;
        this.nodeSelector = nodeSelector;
        this.overrides = overrides;
        this.separateCertificateManagement = separateCertificateManagement;
        this.tolerations = tolerations;
    }

    @JsonProperty("availabilityConfig")
    public String getAvailabilityConfig() {
        return availabilityConfig;
    }

    @JsonProperty("availabilityConfig")
    public void setAvailabilityConfig(String availabilityConfig) {
        this.availabilityConfig = availabilityConfig;
    }

    @JsonProperty("customCAConfigmap")
    public String getCustomCAConfigmap() {
        return customCAConfigmap;
    }

    @JsonProperty("customCAConfigmap")
    public void setCustomCAConfigmap(String customCAConfigmap) {
        this.customCAConfigmap = customCAConfigmap;
    }

    @JsonProperty("disableHubSelfManagement")
    public Boolean getDisableHubSelfManagement() {
        return disableHubSelfManagement;
    }

    @JsonProperty("disableHubSelfManagement")
    public void setDisableHubSelfManagement(Boolean disableHubSelfManagement) {
        this.disableHubSelfManagement = disableHubSelfManagement;
    }

    @JsonProperty("disableUpdateClusterImageSets")
    public Boolean getDisableUpdateClusterImageSets() {
        return disableUpdateClusterImageSets;
    }

    @JsonProperty("disableUpdateClusterImageSets")
    public void setDisableUpdateClusterImageSets(Boolean disableUpdateClusterImageSets) {
        this.disableUpdateClusterImageSets = disableUpdateClusterImageSets;
    }

    @JsonProperty("enableClusterBackup")
    public Boolean getEnableClusterBackup() {
        return enableClusterBackup;
    }

    @JsonProperty("enableClusterBackup")
    public void setEnableClusterBackup(Boolean enableClusterBackup) {
        this.enableClusterBackup = enableClusterBackup;
    }

    @JsonProperty("enableClusterProxyAddon")
    public Boolean getEnableClusterProxyAddon() {
        return enableClusterProxyAddon;
    }

    @JsonProperty("enableClusterProxyAddon")
    public void setEnableClusterProxyAddon(Boolean enableClusterProxyAddon) {
        this.enableClusterProxyAddon = enableClusterProxyAddon;
    }

    @JsonProperty("hive")
    public HiveConfigSpec getHive() {
        return hive;
    }

    @JsonProperty("hive")
    public void setHive(HiveConfigSpec hive) {
        this.hive = hive;
    }

    @JsonProperty("imagePullSecret")
    public String getImagePullSecret() {
        return imagePullSecret;
    }

    @JsonProperty("imagePullSecret")
    public void setImagePullSecret(String imagePullSecret) {
        this.imagePullSecret = imagePullSecret;
    }

    @JsonProperty("ingress")
    public IngressSpec getIngress() {
        return ingress;
    }

    @JsonProperty("ingress")
    public void setIngress(IngressSpec ingress) {
        this.ingress = ingress;
    }

    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    @JsonProperty("overrides")
    public Overrides getOverrides() {
        return overrides;
    }

    @JsonProperty("overrides")
    public void setOverrides(Overrides overrides) {
        this.overrides = overrides;
    }

    @JsonProperty("separateCertificateManagement")
    public Boolean getSeparateCertificateManagement() {
        return separateCertificateManagement;
    }

    @JsonProperty("separateCertificateManagement")
    public void setSeparateCertificateManagement(Boolean separateCertificateManagement) {
        this.separateCertificateManagement = separateCertificateManagement;
    }

    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Toleration> getTolerations() {
        return tolerations;
    }

    @JsonProperty("tolerations")
    public void setTolerations(List<Toleration> tolerations) {
        this.tolerations = tolerations;
    }

    @JsonIgnore
    public MultiClusterHubSpecBuilder edit() {
        return new MultiClusterHubSpecBuilder(this);
    }

    @JsonIgnore
    public MultiClusterHubSpecBuilder toBuilder() {
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
