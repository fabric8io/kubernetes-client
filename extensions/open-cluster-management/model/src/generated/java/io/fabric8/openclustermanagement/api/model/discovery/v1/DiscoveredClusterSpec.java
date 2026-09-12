
package io.fabric8.openclustermanagement.api.model.discovery.v1;

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
    "importAsManagedCluster",
    "isManagedCluster",
    "name",
    "ocpClusterId",
    "openshiftVersion",
    "owner",
    "region",
    "rhocmClusterId",
    "status",
    "type"
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
    @JsonProperty("importAsManagedCluster")
    private Boolean importAsManagedCluster;
    @JsonProperty("isManagedCluster")
    private Boolean isManagedCluster;
    @JsonProperty("name")
    private String name;
    @JsonProperty("ocpClusterId")
    private String ocpClusterId;
    @JsonProperty("openshiftVersion")
    private String openshiftVersion;
    @JsonProperty("owner")
    private String owner;
    @JsonProperty("region")
    private String region;
    @JsonProperty("rhocmClusterId")
    private String rhocmClusterId;
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

    public DiscoveredClusterSpec(String activityTimestamp, String apiUrl, String cloudProvider, String console, String creationTimestamp, ObjectReference credential, String displayName, Boolean importAsManagedCluster, Boolean isManagedCluster, String name, String ocpClusterId, String openshiftVersion, String owner, String region, String rhocmClusterId, String status, String type) {
        super();
        this.activityTimestamp = activityTimestamp;
        this.apiUrl = apiUrl;
        this.cloudProvider = cloudProvider;
        this.console = console;
        this.creationTimestamp = creationTimestamp;
        this.credential = credential;
        this.displayName = displayName;
        this.importAsManagedCluster = importAsManagedCluster;
        this.isManagedCluster = isManagedCluster;
        this.name = name;
        this.ocpClusterId = ocpClusterId;
        this.openshiftVersion = openshiftVersion;
        this.owner = owner;
        this.region = region;
        this.rhocmClusterId = rhocmClusterId;
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
     * APIURL is the endpoint used to access the cluster's API server.
     */
    @JsonProperty("apiUrl")
    public String getApiUrl() {
        return apiUrl;
    }

    /**
     * APIURL is the endpoint used to access the cluster's API server.
     */
    @JsonProperty("apiUrl")
    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    /**
     * CloudProvider specifies the cloud provider where the cluster is hosted (e.g., AWS, Azure, GCP).
     */
    @JsonProperty("cloudProvider")
    public String getCloudProvider() {
        return cloudProvider;
    }

    /**
     * CloudProvider specifies the cloud provider where the cluster is hosted (e.g., AWS, Azure, GCP).
     */
    @JsonProperty("cloudProvider")
    public void setCloudProvider(String cloudProvider) {
        this.cloudProvider = cloudProvider;
    }

    /**
     * Console provides the URL of the cluster's web-based console.
     */
    @JsonProperty("console")
    public String getConsole() {
        return console;
    }

    /**
     * Console provides the URL of the cluster's web-based console.
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
     * DisplayName is a human-readable name assigned to the cluster.
     */
    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * DisplayName is a human-readable name assigned to the cluster.
     */
    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * ImportAsManagedCluster determines whether the discovered cluster should be automatically imported as a managed cluster.
     */
    @JsonProperty("importAsManagedCluster")
    public Boolean getImportAsManagedCluster() {
        return importAsManagedCluster;
    }

    /**
     * ImportAsManagedCluster determines whether the discovered cluster should be automatically imported as a managed cluster.
     */
    @JsonProperty("importAsManagedCluster")
    public void setImportAsManagedCluster(Boolean importAsManagedCluster) {
        this.importAsManagedCluster = importAsManagedCluster;
    }

    /**
     * IsManagedCluster indicates whether the cluster is currently managed.
     */
    @JsonProperty("isManagedCluster")
    public Boolean getIsManagedCluster() {
        return isManagedCluster;
    }

    /**
     * IsManagedCluster indicates whether the cluster is currently managed.
     */
    @JsonProperty("isManagedCluster")
    public void setIsManagedCluster(Boolean isManagedCluster) {
        this.isManagedCluster = isManagedCluster;
    }

    /**
     * Name represents the unique identifier of the discovered cluster.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name represents the unique identifier of the discovered cluster.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * OCPClusterID contains the unique identifier assigned by OpenShift to the cluster.
     */
    @JsonProperty("ocpClusterId")
    public String getOcpClusterId() {
        return ocpClusterId;
    }

    /**
     * OCPClusterID contains the unique identifier assigned by OpenShift to the cluster.
     */
    @JsonProperty("ocpClusterId")
    public void setOcpClusterId(String ocpClusterId) {
        this.ocpClusterId = ocpClusterId;
    }

    /**
     * OpenshiftVersion specifies the OpenShift version running on the cluster.
     */
    @JsonProperty("openshiftVersion")
    public String getOpenshiftVersion() {
        return openshiftVersion;
    }

    /**
     * OpenshiftVersion specifies the OpenShift version running on the cluster.
     */
    @JsonProperty("openshiftVersion")
    public void setOpenshiftVersion(String openshiftVersion) {
        this.openshiftVersion = openshiftVersion;
    }

    /**
     * Owner identifies the owner or organization responsible for the cluster.
     */
    @JsonProperty("owner")
    public String getOwner() {
        return owner;
    }

    /**
     * Owner identifies the owner or organization responsible for the cluster.
     */
    @JsonProperty("owner")
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Region specifies the geographical region where the cluster is deployed.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * Region specifies the geographical region where the cluster is deployed.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * RHOCMClusterID contains the cluster ID from Red Hat OpenShift Cluster Manager.
     */
    @JsonProperty("rhocmClusterId")
    public String getRhocmClusterId() {
        return rhocmClusterId;
    }

    /**
     * RHOCMClusterID contains the cluster ID from Red Hat OpenShift Cluster Manager.
     */
    @JsonProperty("rhocmClusterId")
    public void setRhocmClusterId(String rhocmClusterId) {
        this.rhocmClusterId = rhocmClusterId;
    }

    /**
     * Status represents the current state of the discovered cluster (e.g Active, Stale).
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * Status represents the current state of the discovered cluster (e.g Active, Stale).
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Type defines the type of cluster, such as OpenShift, Kubernetes, or a specific managed service type.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type defines the type of cluster, such as OpenShift, Kubernetes, or a specific managed service type.
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
        if (!(o instanceof DiscoveredClusterSpec)) {
            return false;
        }
        DiscoveredClusterSpec other = (DiscoveredClusterSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$activityTimestamp = this.getActivityTimestamp();
        Object other$activityTimestamp = other.getActivityTimestamp();
        if (this$activityTimestamp == null ? other$activityTimestamp != null : !this$activityTimestamp.equals(other$activityTimestamp)) {
            return false;
        }
        Object this$apiUrl = this.getApiUrl();
        Object other$apiUrl = other.getApiUrl();
        if (this$apiUrl == null ? other$apiUrl != null : !this$apiUrl.equals(other$apiUrl)) {
            return false;
        }
        Object this$cloudProvider = this.getCloudProvider();
        Object other$cloudProvider = other.getCloudProvider();
        if (this$cloudProvider == null ? other$cloudProvider != null : !this$cloudProvider.equals(other$cloudProvider)) {
            return false;
        }
        Object this$console = this.getConsole();
        Object other$console = other.getConsole();
        if (this$console == null ? other$console != null : !this$console.equals(other$console)) {
            return false;
        }
        Object this$creationTimestamp = this.getCreationTimestamp();
        Object other$creationTimestamp = other.getCreationTimestamp();
        if (this$creationTimestamp == null ? other$creationTimestamp != null : !this$creationTimestamp.equals(other$creationTimestamp)) {
            return false;
        }
        Object this$credential = this.getCredential();
        Object other$credential = other.getCredential();
        if (this$credential == null ? other$credential != null : !this$credential.equals(other$credential)) {
            return false;
        }
        Object this$displayName = this.getDisplayName();
        Object other$displayName = other.getDisplayName();
        if (this$displayName == null ? other$displayName != null : !this$displayName.equals(other$displayName)) {
            return false;
        }
        Object this$importAsManagedCluster = this.getImportAsManagedCluster();
        Object other$importAsManagedCluster = other.getImportAsManagedCluster();
        if (this$importAsManagedCluster == null ? other$importAsManagedCluster != null : !this$importAsManagedCluster.equals(other$importAsManagedCluster)) {
            return false;
        }
        Object this$isManagedCluster = this.getIsManagedCluster();
        Object other$isManagedCluster = other.getIsManagedCluster();
        if (this$isManagedCluster == null ? other$isManagedCluster != null : !this$isManagedCluster.equals(other$isManagedCluster)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$ocpClusterId = this.getOcpClusterId();
        Object other$ocpClusterId = other.getOcpClusterId();
        if (this$ocpClusterId == null ? other$ocpClusterId != null : !this$ocpClusterId.equals(other$ocpClusterId)) {
            return false;
        }
        Object this$openshiftVersion = this.getOpenshiftVersion();
        Object other$openshiftVersion = other.getOpenshiftVersion();
        if (this$openshiftVersion == null ? other$openshiftVersion != null : !this$openshiftVersion.equals(other$openshiftVersion)) {
            return false;
        }
        Object this$owner = this.getOwner();
        Object other$owner = other.getOwner();
        if (this$owner == null ? other$owner != null : !this$owner.equals(other$owner)) {
            return false;
        }
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
            return false;
        }
        Object this$rhocmClusterId = this.getRhocmClusterId();
        Object other$rhocmClusterId = other.getRhocmClusterId();
        if (this$rhocmClusterId == null ? other$rhocmClusterId != null : !this$rhocmClusterId.equals(other$rhocmClusterId)) {
            return false;
        }
        Object this$status = this.getStatus();
        Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof DiscoveredClusterSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $activityTimestamp = this.getActivityTimestamp();
        result = result * prime + ($activityTimestamp == null ? 43 : $activityTimestamp.hashCode());
        Object $apiUrl = this.getApiUrl();
        result = result * prime + ($apiUrl == null ? 43 : $apiUrl.hashCode());
        Object $cloudProvider = this.getCloudProvider();
        result = result * prime + ($cloudProvider == null ? 43 : $cloudProvider.hashCode());
        Object $console = this.getConsole();
        result = result * prime + ($console == null ? 43 : $console.hashCode());
        Object $creationTimestamp = this.getCreationTimestamp();
        result = result * prime + ($creationTimestamp == null ? 43 : $creationTimestamp.hashCode());
        Object $credential = this.getCredential();
        result = result * prime + ($credential == null ? 43 : $credential.hashCode());
        Object $displayName = this.getDisplayName();
        result = result * prime + ($displayName == null ? 43 : $displayName.hashCode());
        Object $importAsManagedCluster = this.getImportAsManagedCluster();
        result = result * prime + ($importAsManagedCluster == null ? 43 : $importAsManagedCluster.hashCode());
        Object $isManagedCluster = this.getIsManagedCluster();
        result = result * prime + ($isManagedCluster == null ? 43 : $isManagedCluster.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $ocpClusterId = this.getOcpClusterId();
        result = result * prime + ($ocpClusterId == null ? 43 : $ocpClusterId.hashCode());
        Object $openshiftVersion = this.getOpenshiftVersion();
        result = result * prime + ($openshiftVersion == null ? 43 : $openshiftVersion.hashCode());
        Object $owner = this.getOwner();
        result = result * prime + ($owner == null ? 43 : $owner.hashCode());
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $rhocmClusterId = this.getRhocmClusterId();
        result = result * prime + ($rhocmClusterId == null ? 43 : $rhocmClusterId.hashCode());
        Object $status = this.getStatus();
        result = result * prime + ($status == null ? 43 : $status.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DiscoveredClusterSpec(" + "activityTimestamp=" + this.getActivityTimestamp() + ", apiUrl=" + this.getApiUrl() + ", cloudProvider=" + this.getCloudProvider() + ", console=" + this.getConsole() + ", creationTimestamp=" + this.getCreationTimestamp() + ", credential=" + this.getCredential() + ", displayName=" + this.getDisplayName() + ", importAsManagedCluster=" + this.getImportAsManagedCluster() + ", isManagedCluster=" + this.getIsManagedCluster() + ", name=" + this.getName() + ", ocpClusterId=" + this.getOcpClusterId() + ", openshiftVersion=" + this.getOpenshiftVersion() + ", owner=" + this.getOwner() + ", region=" + this.getRegion() + ", rhocmClusterId=" + this.getRhocmClusterId() + ", status=" + this.getStatus() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
