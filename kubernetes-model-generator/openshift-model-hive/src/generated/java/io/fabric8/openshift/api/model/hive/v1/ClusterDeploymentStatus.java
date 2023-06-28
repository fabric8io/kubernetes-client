
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
public class ClusterDeploymentStatus implements KubernetesResource
{

    @JsonProperty("apiURL")
    private java.lang.String apiURL;
    @JsonProperty("certificateBundles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CertificateBundleStatus> certificateBundles = new ArrayList<CertificateBundleStatus>();
    @JsonProperty("cliImage")
    private java.lang.String cliImage;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterDeploymentCondition> conditions = new ArrayList<ClusterDeploymentCondition>();
    @JsonProperty("installRestarts")
    private Integer installRestarts;
    @JsonProperty("installStartedTimestamp")
    private String installStartedTimestamp;
    @JsonProperty("installVersion")
    private java.lang.String installVersion;
    @JsonProperty("installedTimestamp")
    private String installedTimestamp;
    @JsonProperty("installerImage")
    private java.lang.String installerImage;
    @JsonProperty("platformStatus")
    private PlatformStatus platformStatus;
    @JsonProperty("powerState")
    private java.lang.String powerState;
    @JsonProperty("provisionRef")
    private io.fabric8.kubernetes.api.model.LocalObjectReference provisionRef;
    @JsonProperty("webConsoleURL")
    private java.lang.String webConsoleURL;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClusterDeploymentStatus() {
    }

    public ClusterDeploymentStatus(java.lang.String apiURL, List<CertificateBundleStatus> certificateBundles, java.lang.String cliImage, List<ClusterDeploymentCondition> conditions, Integer installRestarts, String installStartedTimestamp, java.lang.String installVersion, String installedTimestamp, java.lang.String installerImage, PlatformStatus platformStatus, java.lang.String powerState, io.fabric8.kubernetes.api.model.LocalObjectReference provisionRef, java.lang.String webConsoleURL) {
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

    @JsonProperty("apiURL")
    public java.lang.String getApiURL() {
        return apiURL;
    }

    @JsonProperty("apiURL")
    public void setApiURL(java.lang.String apiURL) {
        this.apiURL = apiURL;
    }

    @JsonProperty("certificateBundles")
    public List<CertificateBundleStatus> getCertificateBundles() {
        return certificateBundles;
    }

    @JsonProperty("certificateBundles")
    public void setCertificateBundles(List<CertificateBundleStatus> certificateBundles) {
        this.certificateBundles = certificateBundles;
    }

    @JsonProperty("cliImage")
    public java.lang.String getCliImage() {
        return cliImage;
    }

    @JsonProperty("cliImage")
    public void setCliImage(java.lang.String cliImage) {
        this.cliImage = cliImage;
    }

    @JsonProperty("conditions")
    public List<ClusterDeploymentCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<ClusterDeploymentCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("installRestarts")
    public Integer getInstallRestarts() {
        return installRestarts;
    }

    @JsonProperty("installRestarts")
    public void setInstallRestarts(Integer installRestarts) {
        this.installRestarts = installRestarts;
    }

    @JsonProperty("installStartedTimestamp")
    public String getInstallStartedTimestamp() {
        return installStartedTimestamp;
    }

    @JsonProperty("installStartedTimestamp")
    public void setInstallStartedTimestamp(String installStartedTimestamp) {
        this.installStartedTimestamp = installStartedTimestamp;
    }

    @JsonProperty("installVersion")
    public java.lang.String getInstallVersion() {
        return installVersion;
    }

    @JsonProperty("installVersion")
    public void setInstallVersion(java.lang.String installVersion) {
        this.installVersion = installVersion;
    }

    @JsonProperty("installedTimestamp")
    public String getInstalledTimestamp() {
        return installedTimestamp;
    }

    @JsonProperty("installedTimestamp")
    public void setInstalledTimestamp(String installedTimestamp) {
        this.installedTimestamp = installedTimestamp;
    }

    @JsonProperty("installerImage")
    public java.lang.String getInstallerImage() {
        return installerImage;
    }

    @JsonProperty("installerImage")
    public void setInstallerImage(java.lang.String installerImage) {
        this.installerImage = installerImage;
    }

    @JsonProperty("platformStatus")
    public PlatformStatus getPlatformStatus() {
        return platformStatus;
    }

    @JsonProperty("platformStatus")
    public void setPlatformStatus(PlatformStatus platformStatus) {
        this.platformStatus = platformStatus;
    }

    @JsonProperty("powerState")
    public java.lang.String getPowerState() {
        return powerState;
    }

    @JsonProperty("powerState")
    public void setPowerState(java.lang.String powerState) {
        this.powerState = powerState;
    }

    @JsonProperty("provisionRef")
    public io.fabric8.kubernetes.api.model.LocalObjectReference getProvisionRef() {
        return provisionRef;
    }

    @JsonProperty("provisionRef")
    public void setProvisionRef(io.fabric8.kubernetes.api.model.LocalObjectReference provisionRef) {
        this.provisionRef = provisionRef;
    }

    @JsonProperty("webConsoleURL")
    public java.lang.String getWebConsoleURL() {
        return webConsoleURL;
    }

    @JsonProperty("webConsoleURL")
    public void setWebConsoleURL(java.lang.String webConsoleURL) {
        this.webConsoleURL = webConsoleURL;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
