
package io.fabric8.openclustermanagement.api.model.operator.v1;

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
import io.fabric8.kubernetes.api.model.Toleration;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * MultiClusterHubSpec defines the desired state of MultiClusterHub
 */
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
    "localClusterName",
    "nodeSelector",
    "overrides",
    "separateCertificateManagement",
    "tolerations"
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
    @JsonProperty("localClusterName")
    private String localClusterName;
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

    public MultiClusterHubSpec(String availabilityConfig, String customCAConfigmap, Boolean disableHubSelfManagement, Boolean disableUpdateClusterImageSets, Boolean enableClusterBackup, Boolean enableClusterProxyAddon, HiveConfigSpec hive, String imagePullSecret, IngressSpec ingress, String localClusterName, Map<String, String> nodeSelector, Overrides overrides, Boolean separateCertificateManagement, List<Toleration> tolerations) {
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
        this.localClusterName = localClusterName;
        this.nodeSelector = nodeSelector;
        this.overrides = overrides;
        this.separateCertificateManagement = separateCertificateManagement;
        this.tolerations = tolerations;
    }

    /**
     * Specifies deployment replication for improved availability. Options are: Basic and High (default)
     */
    @JsonProperty("availabilityConfig")
    public String getAvailabilityConfig() {
        return availabilityConfig;
    }

    /**
     * Specifies deployment replication for improved availability. Options are: Basic and High (default)
     */
    @JsonProperty("availabilityConfig")
    public void setAvailabilityConfig(String availabilityConfig) {
        this.availabilityConfig = availabilityConfig;
    }

    /**
     * (Deprecated) Provide the customized OpenShift default ingress CA certificate to RHACM
     */
    @JsonProperty("customCAConfigmap")
    public String getCustomCAConfigmap() {
        return customCAConfigmap;
    }

    /**
     * (Deprecated) Provide the customized OpenShift default ingress CA certificate to RHACM
     */
    @JsonProperty("customCAConfigmap")
    public void setCustomCAConfigmap(String customCAConfigmap) {
        this.customCAConfigmap = customCAConfigmap;
    }

    /**
     * Disable automatic import of the hub cluster as a managed cluster
     */
    @JsonProperty("disableHubSelfManagement")
    public Boolean getDisableHubSelfManagement() {
        return disableHubSelfManagement;
    }

    /**
     * Disable automatic import of the hub cluster as a managed cluster
     */
    @JsonProperty("disableHubSelfManagement")
    public void setDisableHubSelfManagement(Boolean disableHubSelfManagement) {
        this.disableHubSelfManagement = disableHubSelfManagement;
    }

    /**
     * Disable automatic update of ClusterImageSets
     */
    @JsonProperty("disableUpdateClusterImageSets")
    public Boolean getDisableUpdateClusterImageSets() {
        return disableUpdateClusterImageSets;
    }

    /**
     * Disable automatic update of ClusterImageSets
     */
    @JsonProperty("disableUpdateClusterImageSets")
    public void setDisableUpdateClusterImageSets(Boolean disableUpdateClusterImageSets) {
        this.disableUpdateClusterImageSets = disableUpdateClusterImageSets;
    }

    /**
     * (Deprecated) Enable cluster backup
     */
    @JsonProperty("enableClusterBackup")
    public Boolean getEnableClusterBackup() {
        return enableClusterBackup;
    }

    /**
     * (Deprecated) Enable cluster backup
     */
    @JsonProperty("enableClusterBackup")
    public void setEnableClusterBackup(Boolean enableClusterBackup) {
        this.enableClusterBackup = enableClusterBackup;
    }

    /**
     * (Deprecated) Enable cluster proxy addon
     */
    @JsonProperty("enableClusterProxyAddon")
    public Boolean getEnableClusterProxyAddon() {
        return enableClusterProxyAddon;
    }

    /**
     * (Deprecated) Enable cluster proxy addon
     */
    @JsonProperty("enableClusterProxyAddon")
    public void setEnableClusterProxyAddon(Boolean enableClusterProxyAddon) {
        this.enableClusterProxyAddon = enableClusterProxyAddon;
    }

    /**
     * MultiClusterHubSpec defines the desired state of MultiClusterHub
     */
    @JsonProperty("hive")
    public HiveConfigSpec getHive() {
        return hive;
    }

    /**
     * MultiClusterHubSpec defines the desired state of MultiClusterHub
     */
    @JsonProperty("hive")
    public void setHive(HiveConfigSpec hive) {
        this.hive = hive;
    }

    /**
     * Override pull secret for accessing MultiClusterHub operand and endpoint images
     */
    @JsonProperty("imagePullSecret")
    public String getImagePullSecret() {
        return imagePullSecret;
    }

    /**
     * Override pull secret for accessing MultiClusterHub operand and endpoint images
     */
    @JsonProperty("imagePullSecret")
    public void setImagePullSecret(String imagePullSecret) {
        this.imagePullSecret = imagePullSecret;
    }

    /**
     * MultiClusterHubSpec defines the desired state of MultiClusterHub
     */
    @JsonProperty("ingress")
    public IngressSpec getIngress() {
        return ingress;
    }

    /**
     * MultiClusterHubSpec defines the desired state of MultiClusterHub
     */
    @JsonProperty("ingress")
    public void setIngress(IngressSpec ingress) {
        this.ingress = ingress;
    }

    /**
     * The name of the local-cluster resource
     */
    @JsonProperty("localClusterName")
    public String getLocalClusterName() {
        return localClusterName;
    }

    /**
     * The name of the local-cluster resource
     */
    @JsonProperty("localClusterName")
    public void setLocalClusterName(String localClusterName) {
        this.localClusterName = localClusterName;
    }

    /**
     * Set the nodeselectors
     */
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    /**
     * Set the nodeselectors
     */
    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    /**
     * MultiClusterHubSpec defines the desired state of MultiClusterHub
     */
    @JsonProperty("overrides")
    public Overrides getOverrides() {
        return overrides;
    }

    /**
     * MultiClusterHubSpec defines the desired state of MultiClusterHub
     */
    @JsonProperty("overrides")
    public void setOverrides(Overrides overrides) {
        this.overrides = overrides;
    }

    /**
     * (Deprecated) Install cert-manager into its own namespace
     */
    @JsonProperty("separateCertificateManagement")
    public Boolean getSeparateCertificateManagement() {
        return separateCertificateManagement;
    }

    /**
     * (Deprecated) Install cert-manager into its own namespace
     */
    @JsonProperty("separateCertificateManagement")
    public void setSeparateCertificateManagement(Boolean separateCertificateManagement) {
        this.separateCertificateManagement = separateCertificateManagement;
    }

    /**
     * Tolerations causes all components to tolerate any taints.
     */
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Toleration> getTolerations() {
        return tolerations;
    }

    /**
     * Tolerations causes all components to tolerate any taints.
     */
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
        if (!(o instanceof MultiClusterHubSpec)) {
            return false;
        }
        MultiClusterHubSpec other = (MultiClusterHubSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$availabilityConfig = this.getAvailabilityConfig();
        Object other$availabilityConfig = other.getAvailabilityConfig();
        if (this$availabilityConfig == null ? other$availabilityConfig != null : !this$availabilityConfig.equals(other$availabilityConfig)) {
            return false;
        }
        Object this$customCAConfigmap = this.getCustomCAConfigmap();
        Object other$customCAConfigmap = other.getCustomCAConfigmap();
        if (this$customCAConfigmap == null ? other$customCAConfigmap != null : !this$customCAConfigmap.equals(other$customCAConfigmap)) {
            return false;
        }
        Object this$disableHubSelfManagement = this.getDisableHubSelfManagement();
        Object other$disableHubSelfManagement = other.getDisableHubSelfManagement();
        if (this$disableHubSelfManagement == null ? other$disableHubSelfManagement != null : !this$disableHubSelfManagement.equals(other$disableHubSelfManagement)) {
            return false;
        }
        Object this$disableUpdateClusterImageSets = this.getDisableUpdateClusterImageSets();
        Object other$disableUpdateClusterImageSets = other.getDisableUpdateClusterImageSets();
        if (this$disableUpdateClusterImageSets == null ? other$disableUpdateClusterImageSets != null : !this$disableUpdateClusterImageSets.equals(other$disableUpdateClusterImageSets)) {
            return false;
        }
        Object this$enableClusterBackup = this.getEnableClusterBackup();
        Object other$enableClusterBackup = other.getEnableClusterBackup();
        if (this$enableClusterBackup == null ? other$enableClusterBackup != null : !this$enableClusterBackup.equals(other$enableClusterBackup)) {
            return false;
        }
        Object this$enableClusterProxyAddon = this.getEnableClusterProxyAddon();
        Object other$enableClusterProxyAddon = other.getEnableClusterProxyAddon();
        if (this$enableClusterProxyAddon == null ? other$enableClusterProxyAddon != null : !this$enableClusterProxyAddon.equals(other$enableClusterProxyAddon)) {
            return false;
        }
        Object this$hive = this.getHive();
        Object other$hive = other.getHive();
        if (this$hive == null ? other$hive != null : !this$hive.equals(other$hive)) {
            return false;
        }
        Object this$imagePullSecret = this.getImagePullSecret();
        Object other$imagePullSecret = other.getImagePullSecret();
        if (this$imagePullSecret == null ? other$imagePullSecret != null : !this$imagePullSecret.equals(other$imagePullSecret)) {
            return false;
        }
        Object this$ingress = this.getIngress();
        Object other$ingress = other.getIngress();
        if (this$ingress == null ? other$ingress != null : !this$ingress.equals(other$ingress)) {
            return false;
        }
        Object this$localClusterName = this.getLocalClusterName();
        Object other$localClusterName = other.getLocalClusterName();
        if (this$localClusterName == null ? other$localClusterName != null : !this$localClusterName.equals(other$localClusterName)) {
            return false;
        }
        Object this$nodeSelector = this.getNodeSelector();
        Object other$nodeSelector = other.getNodeSelector();
        if (this$nodeSelector == null ? other$nodeSelector != null : !this$nodeSelector.equals(other$nodeSelector)) {
            return false;
        }
        Object this$overrides = this.getOverrides();
        Object other$overrides = other.getOverrides();
        if (this$overrides == null ? other$overrides != null : !this$overrides.equals(other$overrides)) {
            return false;
        }
        Object this$separateCertificateManagement = this.getSeparateCertificateManagement();
        Object other$separateCertificateManagement = other.getSeparateCertificateManagement();
        if (this$separateCertificateManagement == null ? other$separateCertificateManagement != null : !this$separateCertificateManagement.equals(other$separateCertificateManagement)) {
            return false;
        }
        Object this$tolerations = this.getTolerations();
        Object other$tolerations = other.getTolerations();
        if (this$tolerations == null ? other$tolerations != null : !this$tolerations.equals(other$tolerations)) {
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
        return other instanceof MultiClusterHubSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $availabilityConfig = this.getAvailabilityConfig();
        result = result * prime + ($availabilityConfig == null ? 43 : $availabilityConfig.hashCode());
        Object $customCAConfigmap = this.getCustomCAConfigmap();
        result = result * prime + ($customCAConfigmap == null ? 43 : $customCAConfigmap.hashCode());
        Object $disableHubSelfManagement = this.getDisableHubSelfManagement();
        result = result * prime + ($disableHubSelfManagement == null ? 43 : $disableHubSelfManagement.hashCode());
        Object $disableUpdateClusterImageSets = this.getDisableUpdateClusterImageSets();
        result = result * prime + ($disableUpdateClusterImageSets == null ? 43 : $disableUpdateClusterImageSets.hashCode());
        Object $enableClusterBackup = this.getEnableClusterBackup();
        result = result * prime + ($enableClusterBackup == null ? 43 : $enableClusterBackup.hashCode());
        Object $enableClusterProxyAddon = this.getEnableClusterProxyAddon();
        result = result * prime + ($enableClusterProxyAddon == null ? 43 : $enableClusterProxyAddon.hashCode());
        Object $hive = this.getHive();
        result = result * prime + ($hive == null ? 43 : $hive.hashCode());
        Object $imagePullSecret = this.getImagePullSecret();
        result = result * prime + ($imagePullSecret == null ? 43 : $imagePullSecret.hashCode());
        Object $ingress = this.getIngress();
        result = result * prime + ($ingress == null ? 43 : $ingress.hashCode());
        Object $localClusterName = this.getLocalClusterName();
        result = result * prime + ($localClusterName == null ? 43 : $localClusterName.hashCode());
        Object $nodeSelector = this.getNodeSelector();
        result = result * prime + ($nodeSelector == null ? 43 : $nodeSelector.hashCode());
        Object $overrides = this.getOverrides();
        result = result * prime + ($overrides == null ? 43 : $overrides.hashCode());
        Object $separateCertificateManagement = this.getSeparateCertificateManagement();
        result = result * prime + ($separateCertificateManagement == null ? 43 : $separateCertificateManagement.hashCode());
        Object $tolerations = this.getTolerations();
        result = result * prime + ($tolerations == null ? 43 : $tolerations.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MultiClusterHubSpec(" + "availabilityConfig=" + this.getAvailabilityConfig() + ", customCAConfigmap=" + this.getCustomCAConfigmap() + ", disableHubSelfManagement=" + this.getDisableHubSelfManagement() + ", disableUpdateClusterImageSets=" + this.getDisableUpdateClusterImageSets() + ", enableClusterBackup=" + this.getEnableClusterBackup() + ", enableClusterProxyAddon=" + this.getEnableClusterProxyAddon() + ", hive=" + this.getHive() + ", imagePullSecret=" + this.getImagePullSecret() + ", ingress=" + this.getIngress() + ", localClusterName=" + this.getLocalClusterName() + ", nodeSelector=" + this.getNodeSelector() + ", overrides=" + this.getOverrides() + ", separateCertificateManagement=" + this.getSeparateCertificateManagement() + ", tolerations=" + this.getTolerations() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
