
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
import io.fabric8.openshift.api.model.hive.metricsconfig.v1.MetricsConfig;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * HiveConfigSpec defines the desired state of Hive
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalCertificateAuthoritiesSecretRef",
    "argoCDConfig",
    "awsPrivateLink",
    "backup",
    "clusterVersionPollInterval",
    "controllersConfig",
    "deleteProtection",
    "deploymentConfig",
    "deprovisionsDisabled",
    "disabledControllers",
    "exportMetrics",
    "failedProvisionConfig",
    "featureGates",
    "globalPullSecretRef",
    "logLevel",
    "machinePoolPollInterval",
    "maintenanceMode",
    "managedDomains",
    "metricsConfig",
    "privateLink",
    "releaseImageVerificationConfigMapRef",
    "serviceProviderCredentialsConfig",
    "syncSetReapplyInterval",
    "targetNamespace"
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
public class HiveConfigSpec implements Editable<HiveConfigSpecBuilder>, KubernetesResource
{

    @JsonProperty("additionalCertificateAuthoritiesSecretRef")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LocalObjectReference> additionalCertificateAuthoritiesSecretRef = new ArrayList<>();
    @JsonProperty("argoCDConfig")
    private ArgoCDConfig argoCDConfig;
    @JsonProperty("awsPrivateLink")
    private AWSPrivateLinkConfig awsPrivateLink;
    @JsonProperty("backup")
    private BackupConfig backup;
    @JsonProperty("clusterVersionPollInterval")
    private String clusterVersionPollInterval;
    @JsonProperty("controllersConfig")
    private ControllersConfig controllersConfig;
    @JsonProperty("deleteProtection")
    private String deleteProtection;
    @JsonProperty("deploymentConfig")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeploymentConfig> deploymentConfig = new ArrayList<>();
    @JsonProperty("deprovisionsDisabled")
    private Boolean deprovisionsDisabled;
    @JsonProperty("disabledControllers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> disabledControllers = new ArrayList<>();
    @JsonProperty("exportMetrics")
    private Boolean exportMetrics;
    @JsonProperty("failedProvisionConfig")
    private FailedProvisionConfig failedProvisionConfig;
    @JsonProperty("featureGates")
    private FeatureGateSelection featureGates;
    @JsonProperty("globalPullSecretRef")
    private LocalObjectReference globalPullSecretRef;
    @JsonProperty("logLevel")
    private String logLevel;
    @JsonProperty("machinePoolPollInterval")
    private String machinePoolPollInterval;
    @JsonProperty("maintenanceMode")
    private Boolean maintenanceMode;
    @JsonProperty("managedDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ManageDNSConfig> managedDomains = new ArrayList<>();
    @JsonProperty("metricsConfig")
    private MetricsConfig metricsConfig;
    @JsonProperty("privateLink")
    private PrivateLinkConfig privateLink;
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
     */
    public HiveConfigSpec() {
    }

    public HiveConfigSpec(List<LocalObjectReference> additionalCertificateAuthoritiesSecretRef, ArgoCDConfig argoCDConfig, AWSPrivateLinkConfig awsPrivateLink, BackupConfig backup, String clusterVersionPollInterval, ControllersConfig controllersConfig, String deleteProtection, List<DeploymentConfig> deploymentConfig, Boolean deprovisionsDisabled, List<String> disabledControllers, Boolean exportMetrics, FailedProvisionConfig failedProvisionConfig, FeatureGateSelection featureGates, LocalObjectReference globalPullSecretRef, String logLevel, String machinePoolPollInterval, Boolean maintenanceMode, List<ManageDNSConfig> managedDomains, MetricsConfig metricsConfig, PrivateLinkConfig privateLink, ReleaseImageVerificationConfigMapReference releaseImageVerificationConfigMapRef, ServiceProviderCredentials serviceProviderCredentialsConfig, String syncSetReapplyInterval, String targetNamespace) {
        super();
        this.additionalCertificateAuthoritiesSecretRef = additionalCertificateAuthoritiesSecretRef;
        this.argoCDConfig = argoCDConfig;
        this.awsPrivateLink = awsPrivateLink;
        this.backup = backup;
        this.clusterVersionPollInterval = clusterVersionPollInterval;
        this.controllersConfig = controllersConfig;
        this.deleteProtection = deleteProtection;
        this.deploymentConfig = deploymentConfig;
        this.deprovisionsDisabled = deprovisionsDisabled;
        this.disabledControllers = disabledControllers;
        this.exportMetrics = exportMetrics;
        this.failedProvisionConfig = failedProvisionConfig;
        this.featureGates = featureGates;
        this.globalPullSecretRef = globalPullSecretRef;
        this.logLevel = logLevel;
        this.machinePoolPollInterval = machinePoolPollInterval;
        this.maintenanceMode = maintenanceMode;
        this.managedDomains = managedDomains;
        this.metricsConfig = metricsConfig;
        this.privateLink = privateLink;
        this.releaseImageVerificationConfigMapRef = releaseImageVerificationConfigMapRef;
        this.serviceProviderCredentialsConfig = serviceProviderCredentialsConfig;
        this.syncSetReapplyInterval = syncSetReapplyInterval;
        this.targetNamespace = targetNamespace;
    }

    /**
     * AdditionalCertificateAuthoritiesSecretRef is a list of references to secrets in the TargetNamespace that contain an additional Certificate Authority to use when communicating with target clusters. These certificate authorities will be used in addition to any self-signed CA generated by each cluster on installation. The cert data should be stored in the Secret key named 'ca.crt'.
     */
    @JsonProperty("additionalCertificateAuthoritiesSecretRef")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LocalObjectReference> getAdditionalCertificateAuthoritiesSecretRef() {
        return additionalCertificateAuthoritiesSecretRef;
    }

    /**
     * AdditionalCertificateAuthoritiesSecretRef is a list of references to secrets in the TargetNamespace that contain an additional Certificate Authority to use when communicating with target clusters. These certificate authorities will be used in addition to any self-signed CA generated by each cluster on installation. The cert data should be stored in the Secret key named 'ca.crt'.
     */
    @JsonProperty("additionalCertificateAuthoritiesSecretRef")
    public void setAdditionalCertificateAuthoritiesSecretRef(List<LocalObjectReference> additionalCertificateAuthoritiesSecretRef) {
        this.additionalCertificateAuthoritiesSecretRef = additionalCertificateAuthoritiesSecretRef;
    }

    /**
     * HiveConfigSpec defines the desired state of Hive
     */
    @JsonProperty("argoCDConfig")
    public ArgoCDConfig getArgoCDConfig() {
        return argoCDConfig;
    }

    /**
     * HiveConfigSpec defines the desired state of Hive
     */
    @JsonProperty("argoCDConfig")
    public void setArgoCDConfig(ArgoCDConfig argoCDConfig) {
        this.argoCDConfig = argoCDConfig;
    }

    /**
     * HiveConfigSpec defines the desired state of Hive
     */
    @JsonProperty("awsPrivateLink")
    public AWSPrivateLinkConfig getAwsPrivateLink() {
        return awsPrivateLink;
    }

    /**
     * HiveConfigSpec defines the desired state of Hive
     */
    @JsonProperty("awsPrivateLink")
    public void setAwsPrivateLink(AWSPrivateLinkConfig awsPrivateLink) {
        this.awsPrivateLink = awsPrivateLink;
    }

    /**
     * HiveConfigSpec defines the desired state of Hive
     */
    @JsonProperty("backup")
    public BackupConfig getBackup() {
        return backup;
    }

    /**
     * HiveConfigSpec defines the desired state of Hive
     */
    @JsonProperty("backup")
    public void setBackup(BackupConfig backup) {
        this.backup = backup;
    }

    /**
     * ClusterVersionPollInterval is a string duration indicating how much time must pass before checking whether we need to update the hive.openshift.io/version&#42; labels on ClusterDeployment. If zero or unset, we'll only reconcile when the ClusterDeployment changes.
     */
    @JsonProperty("clusterVersionPollInterval")
    public String getClusterVersionPollInterval() {
        return clusterVersionPollInterval;
    }

    /**
     * ClusterVersionPollInterval is a string duration indicating how much time must pass before checking whether we need to update the hive.openshift.io/version&#42; labels on ClusterDeployment. If zero or unset, we'll only reconcile when the ClusterDeployment changes.
     */
    @JsonProperty("clusterVersionPollInterval")
    public void setClusterVersionPollInterval(String clusterVersionPollInterval) {
        this.clusterVersionPollInterval = clusterVersionPollInterval;
    }

    /**
     * HiveConfigSpec defines the desired state of Hive
     */
    @JsonProperty("controllersConfig")
    public ControllersConfig getControllersConfig() {
        return controllersConfig;
    }

    /**
     * HiveConfigSpec defines the desired state of Hive
     */
    @JsonProperty("controllersConfig")
    public void setControllersConfig(ControllersConfig controllersConfig) {
        this.controllersConfig = controllersConfig;
    }

    /**
     * DeleteProtection can be set to "enabled" to turn on automatic delete protection for ClusterDeployments. When enabled, Hive will add the "hive.openshift.io/protected-delete" annotation to new ClusterDeployments. Once a ClusterDeployment has been installed, a user must remove the annotation from a ClusterDeployment prior to deleting it.
     */
    @JsonProperty("deleteProtection")
    public String getDeleteProtection() {
        return deleteProtection;
    }

    /**
     * DeleteProtection can be set to "enabled" to turn on automatic delete protection for ClusterDeployments. When enabled, Hive will add the "hive.openshift.io/protected-delete" annotation to new ClusterDeployments. Once a ClusterDeployment has been installed, a user must remove the annotation from a ClusterDeployment prior to deleting it.
     */
    @JsonProperty("deleteProtection")
    public void setDeleteProtection(String deleteProtection) {
        this.deleteProtection = deleteProtection;
    }

    /**
     * DeploymentConfig is used to configure (pods/containers of) the Deployments generated by hive-operator.
     */
    @JsonProperty("deploymentConfig")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DeploymentConfig> getDeploymentConfig() {
        return deploymentConfig;
    }

    /**
     * DeploymentConfig is used to configure (pods/containers of) the Deployments generated by hive-operator.
     */
    @JsonProperty("deploymentConfig")
    public void setDeploymentConfig(List<DeploymentConfig> deploymentConfig) {
        this.deploymentConfig = deploymentConfig;
    }

    /**
     * DeprovisionsDisabled can be set to true to block deprovision jobs from running.
     */
    @JsonProperty("deprovisionsDisabled")
    public Boolean getDeprovisionsDisabled() {
        return deprovisionsDisabled;
    }

    /**
     * DeprovisionsDisabled can be set to true to block deprovision jobs from running.
     */
    @JsonProperty("deprovisionsDisabled")
    public void setDeprovisionsDisabled(Boolean deprovisionsDisabled) {
        this.deprovisionsDisabled = deprovisionsDisabled;
    }

    /**
     * DisabledControllers allows selectively disabling Hive controllers by name. The name of an individual controller matches the name of the controller as seen in the Hive logging output.
     */
    @JsonProperty("disabledControllers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDisabledControllers() {
        return disabledControllers;
    }

    /**
     * DisabledControllers allows selectively disabling Hive controllers by name. The name of an individual controller matches the name of the controller as seen in the Hive logging output.
     */
    @JsonProperty("disabledControllers")
    public void setDisabledControllers(List<String> disabledControllers) {
        this.disabledControllers = disabledControllers;
    }

    /**
     * ExportMetrics has been disabled and has no effect. If upgrading from a version where it was active, please be aware of the following in your HiveConfig.Spec.TargetNamespace (default `hive` if unset): 1) ServiceMonitors named hive-controllers and hive-clustersync; 2) Role and RoleBinding named prometheus-k8s; 3) The `openshift.io/cluster-monitoring` metadata.label on the Namespace itself. You may wish to delete these resources. Or you may wish to continue using them to enable monitoring in your environment; but be aware that hive will no longer reconcile them.
     */
    @JsonProperty("exportMetrics")
    public Boolean getExportMetrics() {
        return exportMetrics;
    }

    /**
     * ExportMetrics has been disabled and has no effect. If upgrading from a version where it was active, please be aware of the following in your HiveConfig.Spec.TargetNamespace (default `hive` if unset): 1) ServiceMonitors named hive-controllers and hive-clustersync; 2) Role and RoleBinding named prometheus-k8s; 3) The `openshift.io/cluster-monitoring` metadata.label on the Namespace itself. You may wish to delete these resources. Or you may wish to continue using them to enable monitoring in your environment; but be aware that hive will no longer reconcile them.
     */
    @JsonProperty("exportMetrics")
    public void setExportMetrics(Boolean exportMetrics) {
        this.exportMetrics = exportMetrics;
    }

    /**
     * HiveConfigSpec defines the desired state of Hive
     */
    @JsonProperty("failedProvisionConfig")
    public FailedProvisionConfig getFailedProvisionConfig() {
        return failedProvisionConfig;
    }

    /**
     * HiveConfigSpec defines the desired state of Hive
     */
    @JsonProperty("failedProvisionConfig")
    public void setFailedProvisionConfig(FailedProvisionConfig failedProvisionConfig) {
        this.failedProvisionConfig = failedProvisionConfig;
    }

    /**
     * HiveConfigSpec defines the desired state of Hive
     */
    @JsonProperty("featureGates")
    public FeatureGateSelection getFeatureGates() {
        return featureGates;
    }

    /**
     * HiveConfigSpec defines the desired state of Hive
     */
    @JsonProperty("featureGates")
    public void setFeatureGates(FeatureGateSelection featureGates) {
        this.featureGates = featureGates;
    }

    /**
     * HiveConfigSpec defines the desired state of Hive
     */
    @JsonProperty("globalPullSecretRef")
    public LocalObjectReference getGlobalPullSecretRef() {
        return globalPullSecretRef;
    }

    /**
     * HiveConfigSpec defines the desired state of Hive
     */
    @JsonProperty("globalPullSecretRef")
    public void setGlobalPullSecretRef(LocalObjectReference globalPullSecretRef) {
        this.globalPullSecretRef = globalPullSecretRef;
    }

    /**
     * LogLevel is the level of logging to use for the Hive controllers. Acceptable levels, from coarsest to finest, are panic, fatal, error, warn, info, debug, and trace. The default level is info.
     */
    @JsonProperty("logLevel")
    public String getLogLevel() {
        return logLevel;
    }

    /**
     * LogLevel is the level of logging to use for the Hive controllers. Acceptable levels, from coarsest to finest, are panic, fatal, error, warn, info, debug, and trace. The default level is info.
     */
    @JsonProperty("logLevel")
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * MachinePoolPollInterval is a string duration indicating how much time must pass before checking whether remote resources related to MachinePools need to be reapplied. Set to zero to disable polling -- we'll only reconcile when hub objects change. The default interval is 30m.
     */
    @JsonProperty("machinePoolPollInterval")
    public String getMachinePoolPollInterval() {
        return machinePoolPollInterval;
    }

    /**
     * MachinePoolPollInterval is a string duration indicating how much time must pass before checking whether remote resources related to MachinePools need to be reapplied. Set to zero to disable polling -- we'll only reconcile when hub objects change. The default interval is 30m.
     */
    @JsonProperty("machinePoolPollInterval")
    public void setMachinePoolPollInterval(String machinePoolPollInterval) {
        this.machinePoolPollInterval = machinePoolPollInterval;
    }

    /**
     * MaintenanceMode can be set to true to disable the hive controllers in situations where we need to ensure nothing is running that will add or act upon finalizers on Hive types. This should rarely be needed. Sets replicas to 0 for the hive-controllers deployment to accomplish this.
     */
    @JsonProperty("maintenanceMode")
    public Boolean getMaintenanceMode() {
        return maintenanceMode;
    }

    /**
     * MaintenanceMode can be set to true to disable the hive controllers in situations where we need to ensure nothing is running that will add or act upon finalizers on Hive types. This should rarely be needed. Sets replicas to 0 for the hive-controllers deployment to accomplish this.
     */
    @JsonProperty("maintenanceMode")
    public void setMaintenanceMode(Boolean maintenanceMode) {
        this.maintenanceMode = maintenanceMode;
    }

    /**
     * ManagedDomains is the list of DNS domains that are managed by the Hive cluster When specifying 'manageDNS: true' in a ClusterDeployment, the ClusterDeployment's baseDomain should be a direct child of one of these domains, otherwise the ClusterDeployment creation will result in a validation error.
     */
    @JsonProperty("managedDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ManageDNSConfig> getManagedDomains() {
        return managedDomains;
    }

    /**
     * ManagedDomains is the list of DNS domains that are managed by the Hive cluster When specifying 'manageDNS: true' in a ClusterDeployment, the ClusterDeployment's baseDomain should be a direct child of one of these domains, otherwise the ClusterDeployment creation will result in a validation error.
     */
    @JsonProperty("managedDomains")
    public void setManagedDomains(List<ManageDNSConfig> managedDomains) {
        this.managedDomains = managedDomains;
    }

    /**
     * HiveConfigSpec defines the desired state of Hive
     */
    @JsonProperty("metricsConfig")
    public MetricsConfig getMetricsConfig() {
        return metricsConfig;
    }

    /**
     * HiveConfigSpec defines the desired state of Hive
     */
    @JsonProperty("metricsConfig")
    public void setMetricsConfig(MetricsConfig metricsConfig) {
        this.metricsConfig = metricsConfig;
    }

    /**
     * HiveConfigSpec defines the desired state of Hive
     */
    @JsonProperty("privateLink")
    public PrivateLinkConfig getPrivateLink() {
        return privateLink;
    }

    /**
     * HiveConfigSpec defines the desired state of Hive
     */
    @JsonProperty("privateLink")
    public void setPrivateLink(PrivateLinkConfig privateLink) {
        this.privateLink = privateLink;
    }

    /**
     * HiveConfigSpec defines the desired state of Hive
     */
    @JsonProperty("releaseImageVerificationConfigMapRef")
    public ReleaseImageVerificationConfigMapReference getReleaseImageVerificationConfigMapRef() {
        return releaseImageVerificationConfigMapRef;
    }

    /**
     * HiveConfigSpec defines the desired state of Hive
     */
    @JsonProperty("releaseImageVerificationConfigMapRef")
    public void setReleaseImageVerificationConfigMapRef(ReleaseImageVerificationConfigMapReference releaseImageVerificationConfigMapRef) {
        this.releaseImageVerificationConfigMapRef = releaseImageVerificationConfigMapRef;
    }

    /**
     * HiveConfigSpec defines the desired state of Hive
     */
    @JsonProperty("serviceProviderCredentialsConfig")
    public ServiceProviderCredentials getServiceProviderCredentialsConfig() {
        return serviceProviderCredentialsConfig;
    }

    /**
     * HiveConfigSpec defines the desired state of Hive
     */
    @JsonProperty("serviceProviderCredentialsConfig")
    public void setServiceProviderCredentialsConfig(ServiceProviderCredentials serviceProviderCredentialsConfig) {
        this.serviceProviderCredentialsConfig = serviceProviderCredentialsConfig;
    }

    /**
     * SyncSetReapplyInterval is a string duration indicating how much time must pass before SyncSet resources will be reapplied. The default reapply interval is two hours.
     */
    @JsonProperty("syncSetReapplyInterval")
    public String getSyncSetReapplyInterval() {
        return syncSetReapplyInterval;
    }

    /**
     * SyncSetReapplyInterval is a string duration indicating how much time must pass before SyncSet resources will be reapplied. The default reapply interval is two hours.
     */
    @JsonProperty("syncSetReapplyInterval")
    public void setSyncSetReapplyInterval(String syncSetReapplyInterval) {
        this.syncSetReapplyInterval = syncSetReapplyInterval;
    }

    /**
     * TargetNamespace is the namespace where the core Hive components should be run. Defaults to "hive". Will be created if it does not already exist. All resource references in HiveConfig can be assumed to be in the TargetNamespace. NOTE: Whereas it is possible to edit this value, causing hive to "move" its core components to the new namespace, the old namespace is not deleted, as it will still contain resources created by kubernetes and/or other OpenShift controllers.
     */
    @JsonProperty("targetNamespace")
    public String getTargetNamespace() {
        return targetNamespace;
    }

    /**
     * TargetNamespace is the namespace where the core Hive components should be run. Defaults to "hive". Will be created if it does not already exist. All resource references in HiveConfig can be assumed to be in the TargetNamespace. NOTE: Whereas it is possible to edit this value, causing hive to "move" its core components to the new namespace, the old namespace is not deleted, as it will still contain resources created by kubernetes and/or other OpenShift controllers.
     */
    @JsonProperty("targetNamespace")
    public void setTargetNamespace(String targetNamespace) {
        this.targetNamespace = targetNamespace;
    }

    @JsonIgnore
    public HiveConfigSpecBuilder edit() {
        return new HiveConfigSpecBuilder(this);
    }

    @JsonIgnore
    public HiveConfigSpecBuilder toBuilder() {
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
