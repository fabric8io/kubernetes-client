
package io.fabric8.openclustermanagement.api.model.discovery.v1alpha1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
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
    "activityTimestamp",
    "apiUrl",
    "cloudProvider",
    "console",
    "creationTimestamp",
    "credential",
    "displayName",
    "isManagedCluster",
    "name",
    "openshiftVersion",
    "status",
    "type"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class DiscoveredClusterSpec implements KubernetesResource
{

    @JsonProperty("activityTimestamp")
    private String activityTimestamp;
    @JsonProperty("apiUrl")
    private String apiUrl;
    @JsonProperty("cloudProvider")
    private String cloudProvider;
    @JsonProperty("console")
    private String console;
    @JsonProperty("creationTimestamp")
    private String creationTimestamp;
    @JsonProperty("credential")
    private io.fabric8.kubernetes.api.model.ObjectReference credential;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("isManagedCluster")
    private Boolean isManagedCluster;
    @JsonProperty("name")
    private String name;
    @JsonProperty("openshiftVersion")
    private String openshiftVersion;
    @JsonProperty("status")
    private String status;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DiscoveredClusterSpec() {
    }

    /**
     * 
     * @param console
     * @param apiUrl
     * @param credential
     * @param displayName
     * @param cloudProvider
     * @param isManagedCluster
     * @param creationTimestamp
     * @param name
     * @param activityTimestamp
     * @param openshiftVersion
     * @param type
     * @param status
     */
    public DiscoveredClusterSpec(String activityTimestamp, String apiUrl, String cloudProvider, String console, String creationTimestamp, io.fabric8.kubernetes.api.model.ObjectReference credential, String displayName, Boolean isManagedCluster, String name, String openshiftVersion, String status, String type) {
        super();
        this.activityTimestamp = activityTimestamp;
        this.apiUrl = apiUrl;
        this.cloudProvider = cloudProvider;
        this.console = console;
        this.creationTimestamp = creationTimestamp;
        this.credential = credential;
        this.displayName = displayName;
        this.isManagedCluster = isManagedCluster;
        this.name = name;
        this.openshiftVersion = openshiftVersion;
        this.status = status;
        this.type = type;
    }

    @JsonProperty("activityTimestamp")
    public String getActivityTimestamp() {
        return activityTimestamp;
    }

    @JsonProperty("activityTimestamp")
    public void setActivityTimestamp(String activityTimestamp) {
        this.activityTimestamp = activityTimestamp;
    }

    @JsonProperty("apiUrl")
    public String getApiUrl() {
        return apiUrl;
    }

    @JsonProperty("apiUrl")
    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    @JsonProperty("cloudProvider")
    public String getCloudProvider() {
        return cloudProvider;
    }

    @JsonProperty("cloudProvider")
    public void setCloudProvider(String cloudProvider) {
        this.cloudProvider = cloudProvider;
    }

    @JsonProperty("console")
    public String getConsole() {
        return console;
    }

    @JsonProperty("console")
    public void setConsole(String console) {
        this.console = console;
    }

    @JsonProperty("creationTimestamp")
    public String getCreationTimestamp() {
        return creationTimestamp;
    }

    @JsonProperty("creationTimestamp")
    public void setCreationTimestamp(String creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    @JsonProperty("credential")
    public io.fabric8.kubernetes.api.model.ObjectReference getCredential() {
        return credential;
    }

    @JsonProperty("credential")
    public void setCredential(io.fabric8.kubernetes.api.model.ObjectReference credential) {
        this.credential = credential;
    }

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("isManagedCluster")
    public Boolean getIsManagedCluster() {
        return isManagedCluster;
    }

    @JsonProperty("isManagedCluster")
    public void setIsManagedCluster(Boolean isManagedCluster) {
        this.isManagedCluster = isManagedCluster;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("openshiftVersion")
    public String getOpenshiftVersion() {
        return openshiftVersion;
    }

    @JsonProperty("openshiftVersion")
    public void setOpenshiftVersion(String openshiftVersion) {
        this.openshiftVersion = openshiftVersion;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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
