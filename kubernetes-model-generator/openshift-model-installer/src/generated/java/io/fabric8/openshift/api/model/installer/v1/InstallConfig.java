
package io.fabric8.openshift.api.model.installer.v1;

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
 * InstallConfig is the configuration for an OpenShift install.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "additionalTrustBundle",
    "additionalTrustBundlePolicy",
    "arbiter",
    "baseDomain",
    "bootstrapInPlace",
    "capabilities",
    "compute",
    "controlPlane",
    "cpuPartitioningMode",
    "credentialsMode",
    "featureGates",
    "featureSet",
    "fips",
    "imageContentSources",
    "imageDigestSources",
    "networking",
    "operatorPublishingStrategy",
    "platform",
    "proxy",
    "publish",
    "pullSecret",
    "sshKey"
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
@Version("v1")
@Group("install.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class InstallConfig implements Editable<InstallConfigBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("additionalTrustBundle")
    private String additionalTrustBundle;
    @JsonProperty("additionalTrustBundlePolicy")
    private String additionalTrustBundlePolicy;
    @JsonProperty("apiVersion")
    private String apiVersion = "install.openshift.io/v1";
    @JsonProperty("arbiter")
    private MachinePool arbiter;
    @JsonProperty("baseDomain")
    private String baseDomain;
    @JsonProperty("bootstrapInPlace")
    private BootstrapInPlace bootstrapInPlace;
    @JsonProperty("capabilities")
    private Capabilities capabilities;
    @JsonProperty("compute")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachinePool> compute = new ArrayList<>();
    @JsonProperty("controlPlane")
    private MachinePool controlPlane;
    @JsonProperty("cpuPartitioningMode")
    private String cpuPartitioningMode;
    @JsonProperty("credentialsMode")
    private String credentialsMode;
    @JsonProperty("featureGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> featureGates = new ArrayList<>();
    @JsonProperty("featureSet")
    private String featureSet;
    @JsonProperty("fips")
    private Boolean fips;
    @JsonProperty("imageContentSources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageContentSource> imageContentSources = new ArrayList<>();
    @JsonProperty("imageDigestSources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageDigestSource> imageDigestSources = new ArrayList<>();
    @JsonProperty("kind")
    private String kind = "InstallConfig";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("networking")
    private Networking networking;
    @JsonProperty("operatorPublishingStrategy")
    private OperatorPublishingStrategy operatorPublishingStrategy;
    @JsonProperty("platform")
    private Platform platform;
    @JsonProperty("proxy")
    private Proxy proxy;
    @JsonProperty("publish")
    private String publish;
    @JsonProperty("pullSecret")
    private String pullSecret;
    @JsonProperty("sshKey")
    private String sshKey;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public InstallConfig() {
    }

    public InstallConfig(String additionalTrustBundle, String additionalTrustBundlePolicy, String apiVersion, MachinePool arbiter, String baseDomain, BootstrapInPlace bootstrapInPlace, Capabilities capabilities, List<MachinePool> compute, MachinePool controlPlane, String cpuPartitioningMode, String credentialsMode, List<String> featureGates, String featureSet, Boolean fips, List<ImageContentSource> imageContentSources, List<ImageDigestSource> imageDigestSources, String kind, ObjectMeta metadata, Networking networking, OperatorPublishingStrategy operatorPublishingStrategy, Platform platform, Proxy proxy, String publish, String pullSecret, String sshKey) {
        super();
        this.additionalTrustBundle = additionalTrustBundle;
        this.additionalTrustBundlePolicy = additionalTrustBundlePolicy;
        this.apiVersion = apiVersion;
        this.arbiter = arbiter;
        this.baseDomain = baseDomain;
        this.bootstrapInPlace = bootstrapInPlace;
        this.capabilities = capabilities;
        this.compute = compute;
        this.controlPlane = controlPlane;
        this.cpuPartitioningMode = cpuPartitioningMode;
        this.credentialsMode = credentialsMode;
        this.featureGates = featureGates;
        this.featureSet = featureSet;
        this.fips = fips;
        this.imageContentSources = imageContentSources;
        this.imageDigestSources = imageDigestSources;
        this.kind = kind;
        this.metadata = metadata;
        this.networking = networking;
        this.operatorPublishingStrategy = operatorPublishingStrategy;
        this.platform = platform;
        this.proxy = proxy;
        this.publish = publish;
        this.pullSecret = pullSecret;
        this.sshKey = sshKey;
    }

    /**
     * AdditionalTrustBundle is a PEM-encoded X.509 certificate bundle that will be added to the nodes' trusted certificate store.
     */
    @JsonProperty("additionalTrustBundle")
    public String getAdditionalTrustBundle() {
        return additionalTrustBundle;
    }

    /**
     * AdditionalTrustBundle is a PEM-encoded X.509 certificate bundle that will be added to the nodes' trusted certificate store.
     */
    @JsonProperty("additionalTrustBundle")
    public void setAdditionalTrustBundle(String additionalTrustBundle) {
        this.additionalTrustBundle = additionalTrustBundle;
    }

    /**
     * AdditionalTrustBundlePolicy determines when to add the AdditionalTrustBundle to the nodes' trusted certificate store. "Proxyonly" is the default. The field can be set to following specified values. "Proxyonly" : adds the AdditionalTrustBundle to nodes when http/https proxy is configured. "Always" : always adds AdditionalTrustBundle.
     */
    @JsonProperty("additionalTrustBundlePolicy")
    public String getAdditionalTrustBundlePolicy() {
        return additionalTrustBundlePolicy;
    }

    /**
     * AdditionalTrustBundlePolicy determines when to add the AdditionalTrustBundle to the nodes' trusted certificate store. "Proxyonly" is the default. The field can be set to following specified values. "Proxyonly" : adds the AdditionalTrustBundle to nodes when http/https proxy is configured. "Always" : always adds AdditionalTrustBundle.
     */
    @JsonProperty("additionalTrustBundlePolicy")
    public void setAdditionalTrustBundlePolicy(String additionalTrustBundlePolicy) {
        this.additionalTrustBundlePolicy = additionalTrustBundlePolicy;
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
     * InstallConfig is the configuration for an OpenShift install.
     */
    @JsonProperty("arbiter")
    public MachinePool getArbiter() {
        return arbiter;
    }

    /**
     * InstallConfig is the configuration for an OpenShift install.
     */
    @JsonProperty("arbiter")
    public void setArbiter(MachinePool arbiter) {
        this.arbiter = arbiter;
    }

    /**
     * BaseDomain is the base domain to which the cluster should belong.
     */
    @JsonProperty("baseDomain")
    public String getBaseDomain() {
        return baseDomain;
    }

    /**
     * BaseDomain is the base domain to which the cluster should belong.
     */
    @JsonProperty("baseDomain")
    public void setBaseDomain(String baseDomain) {
        this.baseDomain = baseDomain;
    }

    /**
     * InstallConfig is the configuration for an OpenShift install.
     */
    @JsonProperty("bootstrapInPlace")
    public BootstrapInPlace getBootstrapInPlace() {
        return bootstrapInPlace;
    }

    /**
     * InstallConfig is the configuration for an OpenShift install.
     */
    @JsonProperty("bootstrapInPlace")
    public void setBootstrapInPlace(BootstrapInPlace bootstrapInPlace) {
        this.bootstrapInPlace = bootstrapInPlace;
    }

    /**
     * InstallConfig is the configuration for an OpenShift install.
     */
    @JsonProperty("capabilities")
    public Capabilities getCapabilities() {
        return capabilities;
    }

    /**
     * InstallConfig is the configuration for an OpenShift install.
     */
    @JsonProperty("capabilities")
    public void setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
    }

    /**
     * Compute is the configuration for the machines that comprise the compute nodes.
     */
    @JsonProperty("compute")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachinePool> getCompute() {
        return compute;
    }

    /**
     * Compute is the configuration for the machines that comprise the compute nodes.
     */
    @JsonProperty("compute")
    public void setCompute(List<MachinePool> compute) {
        this.compute = compute;
    }

    /**
     * InstallConfig is the configuration for an OpenShift install.
     */
    @JsonProperty("controlPlane")
    public MachinePool getControlPlane() {
        return controlPlane;
    }

    /**
     * InstallConfig is the configuration for an OpenShift install.
     */
    @JsonProperty("controlPlane")
    public void setControlPlane(MachinePool controlPlane) {
        this.controlPlane = controlPlane;
    }

    /**
     * CPUPartitioning determines if a cluster should be setup for CPU workload partitioning at install time. When this field is set the cluster will be flagged for CPU Partitioning allowing users to segregate workloads to specific CPU Sets. This does not make any decisions on workloads it only configures the nodes to allow CPU Partitioning. The "AllNodes" value will setup all nodes for CPU Partitioning, the default is "None".
     */
    @JsonProperty("cpuPartitioningMode")
    public String getCpuPartitioningMode() {
        return cpuPartitioningMode;
    }

    /**
     * CPUPartitioning determines if a cluster should be setup for CPU workload partitioning at install time. When this field is set the cluster will be flagged for CPU Partitioning allowing users to segregate workloads to specific CPU Sets. This does not make any decisions on workloads it only configures the nodes to allow CPU Partitioning. The "AllNodes" value will setup all nodes for CPU Partitioning, the default is "None".
     */
    @JsonProperty("cpuPartitioningMode")
    public void setCpuPartitioningMode(String cpuPartitioningMode) {
        this.cpuPartitioningMode = cpuPartitioningMode;
    }

    /**
     * CredentialsMode is used to explicitly set the mode with which CredentialRequests are satisfied.<br><p> <br><p> If this field is set, then the installer will not attempt to query the cloud permissions before attempting installation. If the field is not set or empty, then the installer will perform its normal verification that the credentials provided are sufficient to perform an installation.<br><p> <br><p> There are three possible values for this field, but the valid values are dependent upon the platform being used. "Mint": create new credentials with a subset of the overall permissions for each CredentialsRequest "Passthrough": copy the credentials with all of the overall permissions for each CredentialsRequest "Manual": CredentialsRequests must be handled manually by the user<br><p> <br><p> For each of the following platforms, the field can be set to the specified values. For all other platforms, the field must not be set. AWS: "Mint", "Passthrough", "Manual" Azure: "Passthrough", "Manual" AzureStack: "Manual" GCP: "Mint", "Passthrough", "Manual" IBMCloud: "Manual" OpenStack: "Passthrough" PowerVC: "Passthrough" PowerVS: "Manual" Nutanix: "Manual"
     */
    @JsonProperty("credentialsMode")
    public String getCredentialsMode() {
        return credentialsMode;
    }

    /**
     * CredentialsMode is used to explicitly set the mode with which CredentialRequests are satisfied.<br><p> <br><p> If this field is set, then the installer will not attempt to query the cloud permissions before attempting installation. If the field is not set or empty, then the installer will perform its normal verification that the credentials provided are sufficient to perform an installation.<br><p> <br><p> There are three possible values for this field, but the valid values are dependent upon the platform being used. "Mint": create new credentials with a subset of the overall permissions for each CredentialsRequest "Passthrough": copy the credentials with all of the overall permissions for each CredentialsRequest "Manual": CredentialsRequests must be handled manually by the user<br><p> <br><p> For each of the following platforms, the field can be set to the specified values. For all other platforms, the field must not be set. AWS: "Mint", "Passthrough", "Manual" Azure: "Passthrough", "Manual" AzureStack: "Manual" GCP: "Mint", "Passthrough", "Manual" IBMCloud: "Manual" OpenStack: "Passthrough" PowerVC: "Passthrough" PowerVS: "Manual" Nutanix: "Manual"
     */
    @JsonProperty("credentialsMode")
    public void setCredentialsMode(String credentialsMode) {
        this.credentialsMode = credentialsMode;
    }

    /**
     * FeatureGates enables a set of custom feature gates. May only be used in conjunction with FeatureSet "CustomNoUpgrade". Features may be enabled or disabled by providing a true or false value for the feature gate. E.g. "featureGates": ["FeatureGate1=true", "FeatureGate2=false"].
     */
    @JsonProperty("featureGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getFeatureGates() {
        return featureGates;
    }

    /**
     * FeatureGates enables a set of custom feature gates. May only be used in conjunction with FeatureSet "CustomNoUpgrade". Features may be enabled or disabled by providing a true or false value for the feature gate. E.g. "featureGates": ["FeatureGate1=true", "FeatureGate2=false"].
     */
    @JsonProperty("featureGates")
    public void setFeatureGates(List<String> featureGates) {
        this.featureGates = featureGates;
    }

    /**
     * FeatureSet enables features that are not part of the default feature set. Valid values are "Default", "TechPreviewNoUpgrade" and "CustomNoUpgrade". When omitted, the "Default" feature set is used.
     */
    @JsonProperty("featureSet")
    public String getFeatureSet() {
        return featureSet;
    }

    /**
     * FeatureSet enables features that are not part of the default feature set. Valid values are "Default", "TechPreviewNoUpgrade" and "CustomNoUpgrade". When omitted, the "Default" feature set is used.
     */
    @JsonProperty("featureSet")
    public void setFeatureSet(String featureSet) {
        this.featureSet = featureSet;
    }

    /**
     * FIPS configures https://www.nist.gov/itl/fips-general-information
     */
    @JsonProperty("fips")
    public Boolean getFips() {
        return fips;
    }

    /**
     * FIPS configures https://www.nist.gov/itl/fips-general-information
     */
    @JsonProperty("fips")
    public void setFips(Boolean fips) {
        this.fips = fips;
    }

    /**
     * ImageContentSources lists sources/repositories for the release-image content. The field is deprecated. Please use imageDigestSources.
     */
    @JsonProperty("imageContentSources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ImageContentSource> getImageContentSources() {
        return imageContentSources;
    }

    /**
     * ImageContentSources lists sources/repositories for the release-image content. The field is deprecated. Please use imageDigestSources.
     */
    @JsonProperty("imageContentSources")
    public void setImageContentSources(List<ImageContentSource> imageContentSources) {
        this.imageContentSources = imageContentSources;
    }

    /**
     * ImageDigestSources lists sources/repositories for the release-image content.
     */
    @JsonProperty("imageDigestSources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ImageDigestSource> getImageDigestSources() {
        return imageDigestSources;
    }

    /**
     * ImageDigestSources lists sources/repositories for the release-image content.
     */
    @JsonProperty("imageDigestSources")
    public void setImageDigestSources(List<ImageDigestSource> imageDigestSources) {
        this.imageDigestSources = imageDigestSources;
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
     * InstallConfig is the configuration for an OpenShift install.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * InstallConfig is the configuration for an OpenShift install.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * InstallConfig is the configuration for an OpenShift install.
     */
    @JsonProperty("networking")
    public Networking getNetworking() {
        return networking;
    }

    /**
     * InstallConfig is the configuration for an OpenShift install.
     */
    @JsonProperty("networking")
    public void setNetworking(Networking networking) {
        this.networking = networking;
    }

    /**
     * InstallConfig is the configuration for an OpenShift install.
     */
    @JsonProperty("operatorPublishingStrategy")
    public OperatorPublishingStrategy getOperatorPublishingStrategy() {
        return operatorPublishingStrategy;
    }

    /**
     * InstallConfig is the configuration for an OpenShift install.
     */
    @JsonProperty("operatorPublishingStrategy")
    public void setOperatorPublishingStrategy(OperatorPublishingStrategy operatorPublishingStrategy) {
        this.operatorPublishingStrategy = operatorPublishingStrategy;
    }

    /**
     * InstallConfig is the configuration for an OpenShift install.
     */
    @JsonProperty("platform")
    public Platform getPlatform() {
        return platform;
    }

    /**
     * InstallConfig is the configuration for an OpenShift install.
     */
    @JsonProperty("platform")
    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    /**
     * InstallConfig is the configuration for an OpenShift install.
     */
    @JsonProperty("proxy")
    public Proxy getProxy() {
        return proxy;
    }

    /**
     * InstallConfig is the configuration for an OpenShift install.
     */
    @JsonProperty("proxy")
    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    /**
     * Publish controls how the user facing endpoints of the cluster like the Kubernetes API, OpenShift routes etc. are exposed. A "Mixed" strategy only applies to the "azure" platform, and requires "operatorPublishingStrategy" to be configured. When no strategy is specified, the strategy is "External".
     */
    @JsonProperty("publish")
    public String getPublish() {
        return publish;
    }

    /**
     * Publish controls how the user facing endpoints of the cluster like the Kubernetes API, OpenShift routes etc. are exposed. A "Mixed" strategy only applies to the "azure" platform, and requires "operatorPublishingStrategy" to be configured. When no strategy is specified, the strategy is "External".
     */
    @JsonProperty("publish")
    public void setPublish(String publish) {
        this.publish = publish;
    }

    /**
     * PullSecret is the secret to use when pulling images.
     */
    @JsonProperty("pullSecret")
    public String getPullSecret() {
        return pullSecret;
    }

    /**
     * PullSecret is the secret to use when pulling images.
     */
    @JsonProperty("pullSecret")
    public void setPullSecret(String pullSecret) {
        this.pullSecret = pullSecret;
    }

    /**
     * SSHKey is the public Secure Shell (SSH) key to provide access to instances.
     */
    @JsonProperty("sshKey")
    public String getSshKey() {
        return sshKey;
    }

    /**
     * SSHKey is the public Secure Shell (SSH) key to provide access to instances.
     */
    @JsonProperty("sshKey")
    public void setSshKey(String sshKey) {
        this.sshKey = sshKey;
    }

    @JsonIgnore
    public InstallConfigBuilder edit() {
        return new InstallConfigBuilder(this);
    }

    @JsonIgnore
    public InstallConfigBuilder toBuilder() {
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
