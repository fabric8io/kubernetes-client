
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
    "baseDomain",
    "boundServiceAccountSigningKeySecretRef",
    "certificateBundles",
    "clusterInstallRef",
    "clusterMetadata",
    "clusterName",
    "clusterPoolRef",
    "controlPlaneConfig",
    "hibernateAfter",
    "ingress",
    "installAttemptsLimit",
    "installed",
    "manageDNS",
    "platform",
    "powerState",
    "preserveOnDelete",
    "provisioning",
    "pullSecretRef"
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
public class ClusterDeploymentSpec implements Editable<ClusterDeploymentSpecBuilder> , KubernetesResource
{

    @JsonProperty("baseDomain")
    private String baseDomain;
    @JsonProperty("boundServiceAccountSigningKeySecretRef")
    private LocalObjectReference boundServiceAccountSigningKeySecretRef;
    @JsonProperty("certificateBundles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CertificateBundleSpec> certificateBundles = new ArrayList<>();
    @JsonProperty("clusterInstallRef")
    private ClusterInstallLocalReference clusterInstallRef;
    @JsonProperty("clusterMetadata")
    private ClusterMetadata clusterMetadata;
    @JsonProperty("clusterName")
    private String clusterName;
    @JsonProperty("clusterPoolRef")
    private ClusterPoolReference clusterPoolRef;
    @JsonProperty("controlPlaneConfig")
    private ControlPlaneConfigSpec controlPlaneConfig;
    @JsonProperty("hibernateAfter")
    private String hibernateAfter;
    @JsonProperty("ingress")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterIngress> ingress = new ArrayList<>();
    @JsonProperty("installAttemptsLimit")
    private Integer installAttemptsLimit;
    @JsonProperty("installed")
    private Boolean installed;
    @JsonProperty("manageDNS")
    private Boolean manageDNS;
    @JsonProperty("platform")
    private Platform platform;
    @JsonProperty("powerState")
    private String powerState;
    @JsonProperty("preserveOnDelete")
    private Boolean preserveOnDelete;
    @JsonProperty("provisioning")
    private Provisioning provisioning;
    @JsonProperty("pullSecretRef")
    private LocalObjectReference pullSecretRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClusterDeploymentSpec() {
    }

    public ClusterDeploymentSpec(String baseDomain, LocalObjectReference boundServiceAccountSigningKeySecretRef, List<CertificateBundleSpec> certificateBundles, ClusterInstallLocalReference clusterInstallRef, ClusterMetadata clusterMetadata, String clusterName, ClusterPoolReference clusterPoolRef, ControlPlaneConfigSpec controlPlaneConfig, String hibernateAfter, List<ClusterIngress> ingress, Integer installAttemptsLimit, Boolean installed, Boolean manageDNS, Platform platform, String powerState, Boolean preserveOnDelete, Provisioning provisioning, LocalObjectReference pullSecretRef) {
        super();
        this.baseDomain = baseDomain;
        this.boundServiceAccountSigningKeySecretRef = boundServiceAccountSigningKeySecretRef;
        this.certificateBundles = certificateBundles;
        this.clusterInstallRef = clusterInstallRef;
        this.clusterMetadata = clusterMetadata;
        this.clusterName = clusterName;
        this.clusterPoolRef = clusterPoolRef;
        this.controlPlaneConfig = controlPlaneConfig;
        this.hibernateAfter = hibernateAfter;
        this.ingress = ingress;
        this.installAttemptsLimit = installAttemptsLimit;
        this.installed = installed;
        this.manageDNS = manageDNS;
        this.platform = platform;
        this.powerState = powerState;
        this.preserveOnDelete = preserveOnDelete;
        this.provisioning = provisioning;
        this.pullSecretRef = pullSecretRef;
    }

    @JsonProperty("baseDomain")
    public String getBaseDomain() {
        return baseDomain;
    }

    @JsonProperty("baseDomain")
    public void setBaseDomain(String baseDomain) {
        this.baseDomain = baseDomain;
    }

    @JsonProperty("boundServiceAccountSigningKeySecretRef")
    public LocalObjectReference getBoundServiceAccountSigningKeySecretRef() {
        return boundServiceAccountSigningKeySecretRef;
    }

    @JsonProperty("boundServiceAccountSigningKeySecretRef")
    public void setBoundServiceAccountSigningKeySecretRef(LocalObjectReference boundServiceAccountSigningKeySecretRef) {
        this.boundServiceAccountSigningKeySecretRef = boundServiceAccountSigningKeySecretRef;
    }

    @JsonProperty("certificateBundles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CertificateBundleSpec> getCertificateBundles() {
        return certificateBundles;
    }

    @JsonProperty("certificateBundles")
    public void setCertificateBundles(List<CertificateBundleSpec> certificateBundles) {
        this.certificateBundles = certificateBundles;
    }

    @JsonProperty("clusterInstallRef")
    public ClusterInstallLocalReference getClusterInstallRef() {
        return clusterInstallRef;
    }

    @JsonProperty("clusterInstallRef")
    public void setClusterInstallRef(ClusterInstallLocalReference clusterInstallRef) {
        this.clusterInstallRef = clusterInstallRef;
    }

    @JsonProperty("clusterMetadata")
    public ClusterMetadata getClusterMetadata() {
        return clusterMetadata;
    }

    @JsonProperty("clusterMetadata")
    public void setClusterMetadata(ClusterMetadata clusterMetadata) {
        this.clusterMetadata = clusterMetadata;
    }

    @JsonProperty("clusterName")
    public String getClusterName() {
        return clusterName;
    }

    @JsonProperty("clusterName")
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    @JsonProperty("clusterPoolRef")
    public ClusterPoolReference getClusterPoolRef() {
        return clusterPoolRef;
    }

    @JsonProperty("clusterPoolRef")
    public void setClusterPoolRef(ClusterPoolReference clusterPoolRef) {
        this.clusterPoolRef = clusterPoolRef;
    }

    @JsonProperty("controlPlaneConfig")
    public ControlPlaneConfigSpec getControlPlaneConfig() {
        return controlPlaneConfig;
    }

    @JsonProperty("controlPlaneConfig")
    public void setControlPlaneConfig(ControlPlaneConfigSpec controlPlaneConfig) {
        this.controlPlaneConfig = controlPlaneConfig;
    }

    @JsonProperty("hibernateAfter")
    public String getHibernateAfter() {
        return hibernateAfter;
    }

    @JsonProperty("hibernateAfter")
    public void setHibernateAfter(String hibernateAfter) {
        this.hibernateAfter = hibernateAfter;
    }

    @JsonProperty("ingress")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterIngress> getIngress() {
        return ingress;
    }

    @JsonProperty("ingress")
    public void setIngress(List<ClusterIngress> ingress) {
        this.ingress = ingress;
    }

    @JsonProperty("installAttemptsLimit")
    public Integer getInstallAttemptsLimit() {
        return installAttemptsLimit;
    }

    @JsonProperty("installAttemptsLimit")
    public void setInstallAttemptsLimit(Integer installAttemptsLimit) {
        this.installAttemptsLimit = installAttemptsLimit;
    }

    @JsonProperty("installed")
    public Boolean getInstalled() {
        return installed;
    }

    @JsonProperty("installed")
    public void setInstalled(Boolean installed) {
        this.installed = installed;
    }

    @JsonProperty("manageDNS")
    public Boolean getManageDNS() {
        return manageDNS;
    }

    @JsonProperty("manageDNS")
    public void setManageDNS(Boolean manageDNS) {
        this.manageDNS = manageDNS;
    }

    @JsonProperty("platform")
    public Platform getPlatform() {
        return platform;
    }

    @JsonProperty("platform")
    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    @JsonProperty("powerState")
    public String getPowerState() {
        return powerState;
    }

    @JsonProperty("powerState")
    public void setPowerState(String powerState) {
        this.powerState = powerState;
    }

    @JsonProperty("preserveOnDelete")
    public Boolean getPreserveOnDelete() {
        return preserveOnDelete;
    }

    @JsonProperty("preserveOnDelete")
    public void setPreserveOnDelete(Boolean preserveOnDelete) {
        this.preserveOnDelete = preserveOnDelete;
    }

    @JsonProperty("provisioning")
    public Provisioning getProvisioning() {
        return provisioning;
    }

    @JsonProperty("provisioning")
    public void setProvisioning(Provisioning provisioning) {
        this.provisioning = provisioning;
    }

    @JsonProperty("pullSecretRef")
    public LocalObjectReference getPullSecretRef() {
        return pullSecretRef;
    }

    @JsonProperty("pullSecretRef")
    public void setPullSecretRef(LocalObjectReference pullSecretRef) {
        this.pullSecretRef = pullSecretRef;
    }

    @JsonIgnore
    public ClusterDeploymentSpecBuilder edit() {
        return new ClusterDeploymentSpecBuilder(this);
    }

    @JsonIgnore
    public ClusterDeploymentSpecBuilder toBuilder() {
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
