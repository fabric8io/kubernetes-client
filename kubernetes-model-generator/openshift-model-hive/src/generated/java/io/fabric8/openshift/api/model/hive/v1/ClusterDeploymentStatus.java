
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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ClusterDeploymentStatus implements Editable<ClusterDeploymentStatusBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("apiURL")
    public String getApiURL() {
        return apiURL;
    }

    @JsonProperty("apiURL")
    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    @JsonProperty("certificateBundles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CertificateBundleStatus> getCertificateBundles() {
        return certificateBundles;
    }

    @JsonProperty("certificateBundles")
    public void setCertificateBundles(List<CertificateBundleStatus> certificateBundles) {
        this.certificateBundles = certificateBundles;
    }

    @JsonProperty("cliImage")
    public String getCliImage() {
        return cliImage;
    }

    @JsonProperty("cliImage")
    public void setCliImage(String cliImage) {
        this.cliImage = cliImage;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    public String getInstallVersion() {
        return installVersion;
    }

    @JsonProperty("installVersion")
    public void setInstallVersion(String installVersion) {
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
    public String getInstallerImage() {
        return installerImage;
    }

    @JsonProperty("installerImage")
    public void setInstallerImage(String installerImage) {
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
    public String getPowerState() {
        return powerState;
    }

    @JsonProperty("powerState")
    public void setPowerState(String powerState) {
        this.powerState = powerState;
    }

    @JsonProperty("provisionRef")
    public LocalObjectReference getProvisionRef() {
        return provisionRef;
    }

    @JsonProperty("provisionRef")
    public void setProvisionRef(LocalObjectReference provisionRef) {
        this.provisionRef = provisionRef;
    }

    @JsonProperty("webConsoleURL")
    public String getWebConsoleURL() {
        return webConsoleURL;
    }

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
