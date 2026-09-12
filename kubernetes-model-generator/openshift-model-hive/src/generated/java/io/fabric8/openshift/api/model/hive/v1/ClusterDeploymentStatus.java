
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ClusterDeploymentStatus)) {
            return false;
        }
        ClusterDeploymentStatus other = (ClusterDeploymentStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiURL = this.getApiURL();
        Object other$apiURL = other.getApiURL();
        if (this$apiURL == null ? other$apiURL != null : !this$apiURL.equals(other$apiURL)) {
            return false;
        }
        Object this$certificateBundles = this.getCertificateBundles();
        Object other$certificateBundles = other.getCertificateBundles();
        if (this$certificateBundles == null ? other$certificateBundles != null : !this$certificateBundles.equals(other$certificateBundles)) {
            return false;
        }
        Object this$cliImage = this.getCliImage();
        Object other$cliImage = other.getCliImage();
        if (this$cliImage == null ? other$cliImage != null : !this$cliImage.equals(other$cliImage)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$installRestarts = this.getInstallRestarts();
        Object other$installRestarts = other.getInstallRestarts();
        if (this$installRestarts == null ? other$installRestarts != null : !this$installRestarts.equals(other$installRestarts)) {
            return false;
        }
        Object this$installStartedTimestamp = this.getInstallStartedTimestamp();
        Object other$installStartedTimestamp = other.getInstallStartedTimestamp();
        if (this$installStartedTimestamp == null ? other$installStartedTimestamp != null : !this$installStartedTimestamp.equals(other$installStartedTimestamp)) {
            return false;
        }
        Object this$installVersion = this.getInstallVersion();
        Object other$installVersion = other.getInstallVersion();
        if (this$installVersion == null ? other$installVersion != null : !this$installVersion.equals(other$installVersion)) {
            return false;
        }
        Object this$installedTimestamp = this.getInstalledTimestamp();
        Object other$installedTimestamp = other.getInstalledTimestamp();
        if (this$installedTimestamp == null ? other$installedTimestamp != null : !this$installedTimestamp.equals(other$installedTimestamp)) {
            return false;
        }
        Object this$installerImage = this.getInstallerImage();
        Object other$installerImage = other.getInstallerImage();
        if (this$installerImage == null ? other$installerImage != null : !this$installerImage.equals(other$installerImage)) {
            return false;
        }
        Object this$platformStatus = this.getPlatformStatus();
        Object other$platformStatus = other.getPlatformStatus();
        if (this$platformStatus == null ? other$platformStatus != null : !this$platformStatus.equals(other$platformStatus)) {
            return false;
        }
        Object this$powerState = this.getPowerState();
        Object other$powerState = other.getPowerState();
        if (this$powerState == null ? other$powerState != null : !this$powerState.equals(other$powerState)) {
            return false;
        }
        Object this$provisionRef = this.getProvisionRef();
        Object other$provisionRef = other.getProvisionRef();
        if (this$provisionRef == null ? other$provisionRef != null : !this$provisionRef.equals(other$provisionRef)) {
            return false;
        }
        Object this$webConsoleURL = this.getWebConsoleURL();
        Object other$webConsoleURL = other.getWebConsoleURL();
        if (this$webConsoleURL == null ? other$webConsoleURL != null : !this$webConsoleURL.equals(other$webConsoleURL)) {
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
        return other instanceof ClusterDeploymentStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiURL = this.getApiURL();
        result = result * prime + ($apiURL == null ? 43 : $apiURL.hashCode());
        Object $certificateBundles = this.getCertificateBundles();
        result = result * prime + ($certificateBundles == null ? 43 : $certificateBundles.hashCode());
        Object $cliImage = this.getCliImage();
        result = result * prime + ($cliImage == null ? 43 : $cliImage.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $installRestarts = this.getInstallRestarts();
        result = result * prime + ($installRestarts == null ? 43 : $installRestarts.hashCode());
        Object $installStartedTimestamp = this.getInstallStartedTimestamp();
        result = result * prime + ($installStartedTimestamp == null ? 43 : $installStartedTimestamp.hashCode());
        Object $installVersion = this.getInstallVersion();
        result = result * prime + ($installVersion == null ? 43 : $installVersion.hashCode());
        Object $installedTimestamp = this.getInstalledTimestamp();
        result = result * prime + ($installedTimestamp == null ? 43 : $installedTimestamp.hashCode());
        Object $installerImage = this.getInstallerImage();
        result = result * prime + ($installerImage == null ? 43 : $installerImage.hashCode());
        Object $platformStatus = this.getPlatformStatus();
        result = result * prime + ($platformStatus == null ? 43 : $platformStatus.hashCode());
        Object $powerState = this.getPowerState();
        result = result * prime + ($powerState == null ? 43 : $powerState.hashCode());
        Object $provisionRef = this.getProvisionRef();
        result = result * prime + ($provisionRef == null ? 43 : $provisionRef.hashCode());
        Object $webConsoleURL = this.getWebConsoleURL();
        result = result * prime + ($webConsoleURL == null ? 43 : $webConsoleURL.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterDeploymentStatus(" + "apiURL=" + this.getApiURL() + ", certificateBundles=" + this.getCertificateBundles() + ", cliImage=" + this.getCliImage() + ", conditions=" + this.getConditions() + ", installRestarts=" + this.getInstallRestarts() + ", installStartedTimestamp=" + this.getInstallStartedTimestamp() + ", installVersion=" + this.getInstallVersion() + ", installedTimestamp=" + this.getInstalledTimestamp() + ", installerImage=" + this.getInstallerImage() + ", platformStatus=" + this.getPlatformStatus() + ", powerState=" + this.getPowerState() + ", provisionRef=" + this.getProvisionRef() + ", webConsoleURL=" + this.getWebConsoleURL() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
