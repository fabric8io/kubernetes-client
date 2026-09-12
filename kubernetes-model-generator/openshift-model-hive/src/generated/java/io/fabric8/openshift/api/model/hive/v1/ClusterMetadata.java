
package io.fabric8.openshift.api.model.hive.v1;

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
 * ClusterMetadata contains metadata information about the installed cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "adminKubeconfigSecretRef",
    "adminPasswordSecretRef",
    "clusterID",
    "infraID",
    "platform"
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
public class ClusterMetadata implements Editable<ClusterMetadataBuilder>, KubernetesResource
{

    @JsonProperty("adminKubeconfigSecretRef")
    private LocalObjectReference adminKubeconfigSecretRef;
    @JsonProperty("adminPasswordSecretRef")
    private LocalObjectReference adminPasswordSecretRef;
    @JsonProperty("clusterID")
    private String clusterID;
    @JsonProperty("infraID")
    private String infraID;
    @JsonProperty("platform")
    private ClusterPlatformMetadata platform;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterMetadata() {
    }

    public ClusterMetadata(LocalObjectReference adminKubeconfigSecretRef, LocalObjectReference adminPasswordSecretRef, String clusterID, String infraID, ClusterPlatformMetadata platform) {
        super();
        this.adminKubeconfigSecretRef = adminKubeconfigSecretRef;
        this.adminPasswordSecretRef = adminPasswordSecretRef;
        this.clusterID = clusterID;
        this.infraID = infraID;
        this.platform = platform;
    }

    /**
     * ClusterMetadata contains metadata information about the installed cluster.
     */
    @JsonProperty("adminKubeconfigSecretRef")
    public LocalObjectReference getAdminKubeconfigSecretRef() {
        return adminKubeconfigSecretRef;
    }

    /**
     * ClusterMetadata contains metadata information about the installed cluster.
     */
    @JsonProperty("adminKubeconfigSecretRef")
    public void setAdminKubeconfigSecretRef(LocalObjectReference adminKubeconfigSecretRef) {
        this.adminKubeconfigSecretRef = adminKubeconfigSecretRef;
    }

    /**
     * ClusterMetadata contains metadata information about the installed cluster.
     */
    @JsonProperty("adminPasswordSecretRef")
    public LocalObjectReference getAdminPasswordSecretRef() {
        return adminPasswordSecretRef;
    }

    /**
     * ClusterMetadata contains metadata information about the installed cluster.
     */
    @JsonProperty("adminPasswordSecretRef")
    public void setAdminPasswordSecretRef(LocalObjectReference adminPasswordSecretRef) {
        this.adminPasswordSecretRef = adminPasswordSecretRef;
    }

    /**
     * ClusterID is a globally unique identifier for this cluster generated during installation. Used for reporting metrics among other places.
     */
    @JsonProperty("clusterID")
    public String getClusterID() {
        return clusterID;
    }

    /**
     * ClusterID is a globally unique identifier for this cluster generated during installation. Used for reporting metrics among other places.
     */
    @JsonProperty("clusterID")
    public void setClusterID(String clusterID) {
        this.clusterID = clusterID;
    }

    /**
     * InfraID is an identifier for this cluster generated during installation and used for tagging/naming resources in cloud providers.
     */
    @JsonProperty("infraID")
    public String getInfraID() {
        return infraID;
    }

    /**
     * InfraID is an identifier for this cluster generated during installation and used for tagging/naming resources in cloud providers.
     */
    @JsonProperty("infraID")
    public void setInfraID(String infraID) {
        this.infraID = infraID;
    }

    /**
     * ClusterMetadata contains metadata information about the installed cluster.
     */
    @JsonProperty("platform")
    public ClusterPlatformMetadata getPlatform() {
        return platform;
    }

    /**
     * ClusterMetadata contains metadata information about the installed cluster.
     */
    @JsonProperty("platform")
    public void setPlatform(ClusterPlatformMetadata platform) {
        this.platform = platform;
    }

    @JsonIgnore
    public ClusterMetadataBuilder edit() {
        return new ClusterMetadataBuilder(this);
    }

    @JsonIgnore
    public ClusterMetadataBuilder toBuilder() {
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
        if (!(o instanceof ClusterMetadata)) {
            return false;
        }
        ClusterMetadata other = (ClusterMetadata) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$adminKubeconfigSecretRef = this.getAdminKubeconfigSecretRef();
        Object other$adminKubeconfigSecretRef = other.getAdminKubeconfigSecretRef();
        if (this$adminKubeconfigSecretRef == null ? other$adminKubeconfigSecretRef != null : !this$adminKubeconfigSecretRef.equals(other$adminKubeconfigSecretRef)) {
            return false;
        }
        Object this$adminPasswordSecretRef = this.getAdminPasswordSecretRef();
        Object other$adminPasswordSecretRef = other.getAdminPasswordSecretRef();
        if (this$adminPasswordSecretRef == null ? other$adminPasswordSecretRef != null : !this$adminPasswordSecretRef.equals(other$adminPasswordSecretRef)) {
            return false;
        }
        Object this$clusterID = this.getClusterID();
        Object other$clusterID = other.getClusterID();
        if (this$clusterID == null ? other$clusterID != null : !this$clusterID.equals(other$clusterID)) {
            return false;
        }
        Object this$infraID = this.getInfraID();
        Object other$infraID = other.getInfraID();
        if (this$infraID == null ? other$infraID != null : !this$infraID.equals(other$infraID)) {
            return false;
        }
        Object this$platform = this.getPlatform();
        Object other$platform = other.getPlatform();
        if (this$platform == null ? other$platform != null : !this$platform.equals(other$platform)) {
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
        return other instanceof ClusterMetadata;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $adminKubeconfigSecretRef = this.getAdminKubeconfigSecretRef();
        result = result * prime + ($adminKubeconfigSecretRef == null ? 43 : $adminKubeconfigSecretRef.hashCode());
        Object $adminPasswordSecretRef = this.getAdminPasswordSecretRef();
        result = result * prime + ($adminPasswordSecretRef == null ? 43 : $adminPasswordSecretRef.hashCode());
        Object $clusterID = this.getClusterID();
        result = result * prime + ($clusterID == null ? 43 : $clusterID.hashCode());
        Object $infraID = this.getInfraID();
        result = result * prime + ($infraID == null ? 43 : $infraID.hashCode());
        Object $platform = this.getPlatform();
        result = result * prime + ($platform == null ? 43 : $platform.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterMetadata(" + "adminKubeconfigSecretRef=" + this.getAdminKubeconfigSecretRef() + ", adminPasswordSecretRef=" + this.getAdminPasswordSecretRef() + ", clusterID=" + this.getClusterID() + ", infraID=" + this.getInfraID() + ", platform=" + this.getPlatform() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
