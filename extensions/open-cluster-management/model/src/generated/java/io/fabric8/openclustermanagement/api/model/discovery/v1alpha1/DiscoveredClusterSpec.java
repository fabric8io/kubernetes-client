
package io.fabric8.openclustermanagement.api.model.discovery.v1alpha1;

import java.util.LinkedHashMap;
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
 * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
public class DiscoveredClusterSpec implements Editable<DiscoveredClusterSpecBuilder>, KubernetesResource
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
    private ObjectReference credential;
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
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DiscoveredClusterSpec() {
    }

    public DiscoveredClusterSpec(String activityTimestamp, String apiUrl, String cloudProvider, String console, String creationTimestamp, ObjectReference credential, String displayName, Boolean isManagedCluster, String name, String openshiftVersion, String status, String type) {
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

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("activityTimestamp")
    public String getActivityTimestamp() {
        return activityTimestamp;
    }

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("activityTimestamp")
    public void setActivityTimestamp(String activityTimestamp) {
        this.activityTimestamp = activityTimestamp;
    }

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("apiUrl")
    public String getApiUrl() {
        return apiUrl;
    }

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("apiUrl")
    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("cloudProvider")
    public String getCloudProvider() {
        return cloudProvider;
    }

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("cloudProvider")
    public void setCloudProvider(String cloudProvider) {
        this.cloudProvider = cloudProvider;
    }

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("console")
    public String getConsole() {
        return console;
    }

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("console")
    public void setConsole(String console) {
        this.console = console;
    }

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("creationTimestamp")
    public String getCreationTimestamp() {
        return creationTimestamp;
    }

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("creationTimestamp")
    public void setCreationTimestamp(String creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("credential")
    public ObjectReference getCredential() {
        return credential;
    }

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("credential")
    public void setCredential(ObjectReference credential) {
        this.credential = credential;
    }

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("isManagedCluster")
    public Boolean getIsManagedCluster() {
        return isManagedCluster;
    }

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("isManagedCluster")
    public void setIsManagedCluster(Boolean isManagedCluster) {
        this.isManagedCluster = isManagedCluster;
    }

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("openshiftVersion")
    public String getOpenshiftVersion() {
        return openshiftVersion;
    }

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("openshiftVersion")
    public void setOpenshiftVersion(String openshiftVersion) {
        this.openshiftVersion = openshiftVersion;
    }

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * DiscoveredClusterSpec defines the desired state of DiscoveredCluster
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public DiscoveredClusterSpecBuilder edit() {
        return new DiscoveredClusterSpecBuilder(this);
    }

    @JsonIgnore
    public DiscoveredClusterSpecBuilder toBuilder() {
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
