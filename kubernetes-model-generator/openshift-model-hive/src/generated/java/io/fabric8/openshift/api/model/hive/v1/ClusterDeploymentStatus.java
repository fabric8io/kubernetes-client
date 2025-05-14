
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
 * ClusterDeploymentStatus defines the observed state of ClusterDeployment
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiURL",
    "certificateBundles",
    "cliImage",
    "conditions",
    "installRestarts",
    "installStartedTimestamp",
    "installVersion",
    "installedTimestamp",
    "installerImage",
    "platformStatus",
    "powerState",
    "provisionRef",
    "webConsoleURL"
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
public class ClusterDeploymentStatus implements Editable<ClusterDeploymentStatusBuilder>, KubernetesResource
{

    @JsonProperty("apiURL")
    private String apiURL;
    @JsonProperty("certificateBundles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CertificateBundleStatus> certificateBundles = new ArrayList<>();
    @JsonProperty("cliImage")
    private String cliImage;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterDeploymentCondition> conditions = new ArrayList<>();
    @JsonProperty("installRestarts")
    private Integer installRestarts;
    @JsonProperty("installStartedTimestamp")
    private String installStartedTimestamp;
    @JsonProperty("installVersion")
    private String installVersion;
    @JsonProperty("installedTimestamp")
    private String installedTimestamp;
    @JsonProperty("installerImage")
    private String installerImage;
    @JsonProperty("platformStatus")
    private PlatformStatus platformStatus;
    @JsonProperty("powerState")
    private String powerState;
    @JsonProperty("provisionRef")
    private LocalObjectReference provisionRef;
    @JsonProperty("webConsoleURL")
    private String webConsoleURL;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterDeploymentStatus() {
    }

    public ClusterDeploymentStatus(String apiURL, List<CertificateBundleStatus> certificateBundles, String cliImage, List<ClusterDeploymentCondition> conditions, Integer installRestarts, String installStartedTimestamp, String installVersion, String installedTimestamp, String installerImage, PlatformStatus platformStatus, String powerState, LocalObjectReference provisionRef, String webConsoleURL) {
        super();
        this.apiURL = apiURL;
        this.certificateBundles = certificateBundles;
        this.cliImage = cliImage;
        this.conditions = conditions;
        this.installRestarts = installRestarts;
        this.installStartedTimestamp = installStartedTimestamp;
        this.installVersion = installVersion;
        this.installedTimestamp = installedTimestamp;
        this.installerImage = installerImage;
        this.platformStatus = platformStatus;
        this.powerState = powerState;
        this.provisionRef = provisionRef;
        this.webConsoleURL = webConsoleURL;
    }

    /**
     * APIURL is the URL where the cluster's API can be accessed.
     */
    @JsonProperty("apiURL")
    public String getApiURL() {
        return apiURL;
    }

    /**
     * APIURL is the URL where the cluster's API can be accessed.
     */
    @JsonProperty("apiURL")
    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    /**
     * CertificateBundles contains of the status of the certificate bundles associated with this cluster deployment.
     */
    @JsonProperty("certificateBundles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CertificateBundleStatus> getCertificateBundles() {
        return certificateBundles;
    }

    /**
     * CertificateBundles contains of the status of the certificate bundles associated with this cluster deployment.
     */
    @JsonProperty("certificateBundles")
    public void setCertificateBundles(List<CertificateBundleStatus> certificateBundles) {
        this.certificateBundles = certificateBundles;
    }

    /**
     * CLIImage is the name of the oc cli image to use when installing the target cluster
     */
    @JsonProperty("cliImage")
    public String getCliImage() {
        return cliImage;
    }

    /**
     * CLIImage is the name of the oc cli image to use when installing the target cluster
     */
    @JsonProperty("cliImage")
    public void setCliImage(String cliImage) {
        this.cliImage = cliImage;
    }

    /**
     * Conditions includes more detailed status for the cluster deployment
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterDeploymentCondition> getConditions() {
        return conditions;
    }

    /**
     * Conditions includes more detailed status for the cluster deployment
     */
    @JsonProperty("conditions")
    public void setConditions(List<ClusterDeploymentCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * InstallRestarts is the total count of container restarts on the clusters install job.
     */
    @JsonProperty("installRestarts")
    public Integer getInstallRestarts() {
        return installRestarts;
    }

    /**
     * InstallRestarts is the total count of container restarts on the clusters install job.
     */
    @JsonProperty("installRestarts")
    public void setInstallRestarts(Integer installRestarts) {
        this.installRestarts = installRestarts;
    }

    /**
     * ClusterDeploymentStatus defines the observed state of ClusterDeployment
     */
    @JsonProperty("installStartedTimestamp")
    public String getInstallStartedTimestamp() {
        return installStartedTimestamp;
    }

    /**
     * ClusterDeploymentStatus defines the observed state of ClusterDeployment
     */
    @JsonProperty("installStartedTimestamp")
    public void setInstallStartedTimestamp(String installStartedTimestamp) {
        this.installStartedTimestamp = installStartedTimestamp;
    }

    /**
     * InstallVersion is the version of OpenShift as reported by the release image resolved for the installation.
     */
    @JsonProperty("installVersion")
    public String getInstallVersion() {
        return installVersion;
    }

    /**
     * InstallVersion is the version of OpenShift as reported by the release image resolved for the installation.
     */
    @JsonProperty("installVersion")
    public void setInstallVersion(String installVersion) {
        this.installVersion = installVersion;
    }

    /**
     * ClusterDeploymentStatus defines the observed state of ClusterDeployment
     */
    @JsonProperty("installedTimestamp")
    public String getInstalledTimestamp() {
        return installedTimestamp;
    }

    /**
     * ClusterDeploymentStatus defines the observed state of ClusterDeployment
     */
    @JsonProperty("installedTimestamp")
    public void setInstalledTimestamp(String installedTimestamp) {
        this.installedTimestamp = installedTimestamp;
    }

    /**
     * InstallerImage is the name of the installer image to use when installing the target cluster
     */
    @JsonProperty("installerImage")
    public String getInstallerImage() {
        return installerImage;
    }

    /**
     * InstallerImage is the name of the installer image to use when installing the target cluster
     */
    @JsonProperty("installerImage")
    public void setInstallerImage(String installerImage) {
        this.installerImage = installerImage;
    }

    /**
     * ClusterDeploymentStatus defines the observed state of ClusterDeployment
     */
    @JsonProperty("platformStatus")
    public PlatformStatus getPlatformStatus() {
        return platformStatus;
    }

    /**
     * ClusterDeploymentStatus defines the observed state of ClusterDeployment
     */
    @JsonProperty("platformStatus")
    public void setPlatformStatus(PlatformStatus platformStatus) {
        this.platformStatus = platformStatus;
    }

    /**
     * PowerState indicates the powerstate of cluster
     */
    @JsonProperty("powerState")
    public String getPowerState() {
        return powerState;
    }

    /**
     * PowerState indicates the powerstate of cluster
     */
    @JsonProperty("powerState")
    public void setPowerState(String powerState) {
        this.powerState = powerState;
    }

    /**
     * ClusterDeploymentStatus defines the observed state of ClusterDeployment
     */
    @JsonProperty("provisionRef")
    public LocalObjectReference getProvisionRef() {
        return provisionRef;
    }

    /**
     * ClusterDeploymentStatus defines the observed state of ClusterDeployment
     */
    @JsonProperty("provisionRef")
    public void setProvisionRef(LocalObjectReference provisionRef) {
        this.provisionRef = provisionRef;
    }

    /**
     * WebConsoleURL is the URL for the cluster's web console UI.
     */
    @JsonProperty("webConsoleURL")
    public String getWebConsoleURL() {
        return webConsoleURL;
    }

    /**
     * WebConsoleURL is the URL for the cluster's web console UI.
     */
    @JsonProperty("webConsoleURL")
    public void setWebConsoleURL(String webConsoleURL) {
        this.webConsoleURL = webConsoleURL;
    }

    @JsonIgnore
    public ClusterDeploymentStatusBuilder edit() {
        return new ClusterDeploymentStatusBuilder(this);
    }

    @JsonIgnore
    public ClusterDeploymentStatusBuilder toBuilder() {
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
