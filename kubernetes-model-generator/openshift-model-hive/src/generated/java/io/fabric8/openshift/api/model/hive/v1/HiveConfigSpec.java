
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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "additionalCertificateAuthoritiesSecretRef",
    "argoCDConfig",
    "awsPrivateLink",
    "backup",
    "controllersConfig",
    "deleteProtection",
    "deprovisionsDisabled",
    "disabledControllers",
    "exportMetrics",
    "failedProvisionConfig",
    "featureGates",
    "globalPullSecretRef",
    "logLevel",
    "maintenanceMode",
    "managedDomains",
    "releaseImageVerificationConfigMapRef",
    "serviceProviderCredentialsConfig",
    "syncSetReapplyInterval",
    "targetNamespace"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class HiveConfigSpec implements KubernetesResource
{

    @JsonProperty("additionalCertificateAuthoritiesSecretRef")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.LocalObjectReference> additionalCertificateAuthoritiesSecretRef = new ArrayList<io.fabric8.kubernetes.api.model.LocalObjectReference>();
    @JsonProperty("argoCDConfig")
    private ArgoCDConfig argoCDConfig;
    @JsonProperty("awsPrivateLink")
    private AWSPrivateLinkConfig awsPrivateLink;
    @JsonProperty("backup")
    private BackupConfig backup;
    @JsonProperty("controllersConfig")
    private ControllersConfig controllersConfig;
    @JsonProperty("deleteProtection")
    private String deleteProtection;
    @JsonProperty("deprovisionsDisabled")
    private Boolean deprovisionsDisabled;
    @JsonProperty("disabledControllers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> disabledControllers = new ArrayList<String>();
    @JsonProperty("exportMetrics")
    private Boolean exportMetrics;
    @JsonProperty("failedProvisionConfig")
    private FailedProvisionConfig failedProvisionConfig;
    @JsonProperty("featureGates")
    private FeatureGateSelection featureGates;
    @JsonProperty("globalPullSecretRef")
    private io.fabric8.kubernetes.api.model.LocalObjectReference globalPullSecretRef;
    @JsonProperty("logLevel")
    private String logLevel;
    @JsonProperty("maintenanceMode")
    private Boolean maintenanceMode;
    @JsonProperty("managedDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ManageDNSConfig> managedDomains = new ArrayList<ManageDNSConfig>();
    @JsonProperty("releaseImageVerificationConfigMapRef")
    private ReleaseImageVerificationConfigMapReference releaseImageVerificationConfigMapRef;
    @JsonProperty("serviceProviderCredentialsConfig")
    private ServiceProviderCredentials serviceProviderCredentialsConfig;
    @JsonProperty("syncSetReapplyInterval")
    private String syncSetReapplyInterval;
    @JsonProperty("targetNamespace")
    private String targetNamespace;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public HiveConfigSpec() {
    }

    public HiveConfigSpec(List<io.fabric8.kubernetes.api.model.LocalObjectReference> additionalCertificateAuthoritiesSecretRef, ArgoCDConfig argoCDConfig, AWSPrivateLinkConfig awsPrivateLink, BackupConfig backup, ControllersConfig controllersConfig, String deleteProtection, Boolean deprovisionsDisabled, List<String> disabledControllers, Boolean exportMetrics, FailedProvisionConfig failedProvisionConfig, FeatureGateSelection featureGates, io.fabric8.kubernetes.api.model.LocalObjectReference globalPullSecretRef, String logLevel, Boolean maintenanceMode, List<ManageDNSConfig> managedDomains, ReleaseImageVerificationConfigMapReference releaseImageVerificationConfigMapRef, ServiceProviderCredentials serviceProviderCredentialsConfig, String syncSetReapplyInterval, String targetNamespace) {
        super();
        this.additionalCertificateAuthoritiesSecretRef = additionalCertificateAuthoritiesSecretRef;
        this.argoCDConfig = argoCDConfig;
        this.awsPrivateLink = awsPrivateLink;
        this.backup = backup;
        this.controllersConfig = controllersConfig;
        this.deleteProtection = deleteProtection;
        this.deprovisionsDisabled = deprovisionsDisabled;
        this.disabledControllers = disabledControllers;
        this.exportMetrics = exportMetrics;
        this.failedProvisionConfig = failedProvisionConfig;
        this.featureGates = featureGates;
        this.globalPullSecretRef = globalPullSecretRef;
        this.logLevel = logLevel;
        this.maintenanceMode = maintenanceMode;
        this.managedDomains = managedDomains;
        this.releaseImageVerificationConfigMapRef = releaseImageVerificationConfigMapRef;
        this.serviceProviderCredentialsConfig = serviceProviderCredentialsConfig;
        this.syncSetReapplyInterval = syncSetReapplyInterval;
        this.targetNamespace = targetNamespace;
    }

    @JsonProperty("additionalCertificateAuthoritiesSecretRef")
    public List<io.fabric8.kubernetes.api.model.LocalObjectReference> getAdditionalCertificateAuthoritiesSecretRef() {
        return additionalCertificateAuthoritiesSecretRef;
    }

    @JsonProperty("additionalCertificateAuthoritiesSecretRef")
    public void setAdditionalCertificateAuthoritiesSecretRef(List<io.fabric8.kubernetes.api.model.LocalObjectReference> additionalCertificateAuthoritiesSecretRef) {
        this.additionalCertificateAuthoritiesSecretRef = additionalCertificateAuthoritiesSecretRef;
    }

    @JsonProperty("argoCDConfig")
    public ArgoCDConfig getArgoCDConfig() {
        return argoCDConfig;
    }

    @JsonProperty("argoCDConfig")
    public void setArgoCDConfig(ArgoCDConfig argoCDConfig) {
        this.argoCDConfig = argoCDConfig;
    }

    @JsonProperty("awsPrivateLink")
    public AWSPrivateLinkConfig getAwsPrivateLink() {
        return awsPrivateLink;
    }

    @JsonProperty("awsPrivateLink")
    public void setAwsPrivateLink(AWSPrivateLinkConfig awsPrivateLink) {
        this.awsPrivateLink = awsPrivateLink;
    }

    @JsonProperty("backup")
    public BackupConfig getBackup() {
        return backup;
    }

    @JsonProperty("backup")
    public void setBackup(BackupConfig backup) {
        this.backup = backup;
    }

    @JsonProperty("controllersConfig")
    public ControllersConfig getControllersConfig() {
        return controllersConfig;
    }

    @JsonProperty("controllersConfig")
    public void setControllersConfig(ControllersConfig controllersConfig) {
        this.controllersConfig = controllersConfig;
    }

    @JsonProperty("deleteProtection")
    public String getDeleteProtection() {
        return deleteProtection;
    }

    @JsonProperty("deleteProtection")
    public void setDeleteProtection(String deleteProtection) {
        this.deleteProtection = deleteProtection;
    }

    @JsonProperty("deprovisionsDisabled")
    public Boolean getDeprovisionsDisabled() {
        return deprovisionsDisabled;
    }

    @JsonProperty("deprovisionsDisabled")
    public void setDeprovisionsDisabled(Boolean deprovisionsDisabled) {
        this.deprovisionsDisabled = deprovisionsDisabled;
    }

    @JsonProperty("disabledControllers")
    public List<String> getDisabledControllers() {
        return disabledControllers;
    }

    @JsonProperty("disabledControllers")
    public void setDisabledControllers(List<String> disabledControllers) {
        this.disabledControllers = disabledControllers;
    }

    @JsonProperty("exportMetrics")
    public Boolean getExportMetrics() {
        return exportMetrics;
    }

    @JsonProperty("exportMetrics")
    public void setExportMetrics(Boolean exportMetrics) {
        this.exportMetrics = exportMetrics;
    }

    @JsonProperty("failedProvisionConfig")
    public FailedProvisionConfig getFailedProvisionConfig() {
        return failedProvisionConfig;
    }

    @JsonProperty("failedProvisionConfig")
    public void setFailedProvisionConfig(FailedProvisionConfig failedProvisionConfig) {
        this.failedProvisionConfig = failedProvisionConfig;
    }

    @JsonProperty("featureGates")
    public FeatureGateSelection getFeatureGates() {
        return featureGates;
    }

    @JsonProperty("featureGates")
    public void setFeatureGates(FeatureGateSelection featureGates) {
        this.featureGates = featureGates;
    }

    @JsonProperty("globalPullSecretRef")
    public io.fabric8.kubernetes.api.model.LocalObjectReference getGlobalPullSecretRef() {
        return globalPullSecretRef;
    }

    @JsonProperty("globalPullSecretRef")
    public void setGlobalPullSecretRef(io.fabric8.kubernetes.api.model.LocalObjectReference globalPullSecretRef) {
        this.globalPullSecretRef = globalPullSecretRef;
    }

    @JsonProperty("logLevel")
    public String getLogLevel() {
        return logLevel;
    }

    @JsonProperty("logLevel")
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    @JsonProperty("maintenanceMode")
    public Boolean getMaintenanceMode() {
        return maintenanceMode;
    }

    @JsonProperty("maintenanceMode")
    public void setMaintenanceMode(Boolean maintenanceMode) {
        this.maintenanceMode = maintenanceMode;
    }

    @JsonProperty("managedDomains")
    public List<ManageDNSConfig> getManagedDomains() {
        return managedDomains;
    }

    @JsonProperty("managedDomains")
    public void setManagedDomains(List<ManageDNSConfig> managedDomains) {
        this.managedDomains = managedDomains;
    }

    @JsonProperty("releaseImageVerificationConfigMapRef")
    public ReleaseImageVerificationConfigMapReference getReleaseImageVerificationConfigMapRef() {
        return releaseImageVerificationConfigMapRef;
    }

    @JsonProperty("releaseImageVerificationConfigMapRef")
    public void setReleaseImageVerificationConfigMapRef(ReleaseImageVerificationConfigMapReference releaseImageVerificationConfigMapRef) {
        this.releaseImageVerificationConfigMapRef = releaseImageVerificationConfigMapRef;
    }

    @JsonProperty("serviceProviderCredentialsConfig")
    public ServiceProviderCredentials getServiceProviderCredentialsConfig() {
        return serviceProviderCredentialsConfig;
    }

    @JsonProperty("serviceProviderCredentialsConfig")
    public void setServiceProviderCredentialsConfig(ServiceProviderCredentials serviceProviderCredentialsConfig) {
        this.serviceProviderCredentialsConfig = serviceProviderCredentialsConfig;
    }

    @JsonProperty("syncSetReapplyInterval")
    public String getSyncSetReapplyInterval() {
        return syncSetReapplyInterval;
    }

    @JsonProperty("syncSetReapplyInterval")
    public void setSyncSetReapplyInterval(String syncSetReapplyInterval) {
        this.syncSetReapplyInterval = syncSetReapplyInterval;
    }

    @JsonProperty("targetNamespace")
    public String getTargetNamespace() {
        return targetNamespace;
    }

    @JsonProperty("targetNamespace")
    public void setTargetNamespace(String targetNamespace) {
        this.targetNamespace = targetNamespace;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
