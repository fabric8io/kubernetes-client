
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
 * ClusterDeprovisionSpec defines the desired state of ClusterDeprovision
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "baseDomain",
    "clusterID",
    "clusterName",
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
public class ClusterDeprovisionSpec implements Editable<ClusterDeprovisionSpecBuilder>, KubernetesResource
{

    @JsonProperty("baseDomain")
    private String baseDomain;
    @JsonProperty("clusterID")
    private String clusterID;
    @JsonProperty("clusterName")
    private String clusterName;
    @JsonProperty("infraID")
    private String infraID;
    @JsonProperty("platform")
    private ClusterDeprovisionPlatform platform;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterDeprovisionSpec() {
    }

    public ClusterDeprovisionSpec(String baseDomain, String clusterID, String clusterName, String infraID, ClusterDeprovisionPlatform platform) {
        super();
        this.baseDomain = baseDomain;
        this.clusterID = clusterID;
        this.clusterName = clusterName;
        this.infraID = infraID;
        this.platform = platform;
    }

    /**
     * BaseDomain is the DNS base domain.
     */
    @JsonProperty("baseDomain")
    public String getBaseDomain() {
        return baseDomain;
    }

    /**
     * BaseDomain is the DNS base domain.
     */
    @JsonProperty("baseDomain")
    public void setBaseDomain(String baseDomain) {
        this.baseDomain = baseDomain;
    }

    /**
     * ClusterID is a globally unique identifier for the cluster to deprovision. It will be used if specified.
     */
    @JsonProperty("clusterID")
    public String getClusterID() {
        return clusterID;
    }

    /**
     * ClusterID is a globally unique identifier for the cluster to deprovision. It will be used if specified.
     */
    @JsonProperty("clusterID")
    public void setClusterID(String clusterID) {
        this.clusterID = clusterID;
    }

    /**
     * ClusterName is the friendly name of the cluster. It is used for subdomains, some resource tagging, and other instances where a friendly name for the cluster is useful.
     */
    @JsonProperty("clusterName")
    public String getClusterName() {
        return clusterName;
    }

    /**
     * ClusterName is the friendly name of the cluster. It is used for subdomains, some resource tagging, and other instances where a friendly name for the cluster is useful.
     */
    @JsonProperty("clusterName")
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    /**
     * InfraID is the identifier generated during installation for a cluster. It is used for tagging/naming resources in cloud providers.
     */
    @JsonProperty("infraID")
    public String getInfraID() {
        return infraID;
    }

    /**
     * InfraID is the identifier generated during installation for a cluster. It is used for tagging/naming resources in cloud providers.
     */
    @JsonProperty("infraID")
    public void setInfraID(String infraID) {
        this.infraID = infraID;
    }

    /**
     * ClusterDeprovisionSpec defines the desired state of ClusterDeprovision
     */
    @JsonProperty("platform")
    public ClusterDeprovisionPlatform getPlatform() {
        return platform;
    }

    /**
     * ClusterDeprovisionSpec defines the desired state of ClusterDeprovision
     */
    @JsonProperty("platform")
    public void setPlatform(ClusterDeprovisionPlatform platform) {
        this.platform = platform;
    }

    @JsonIgnore
    public ClusterDeprovisionSpecBuilder edit() {
        return new ClusterDeprovisionSpecBuilder(this);
    }

    @JsonIgnore
    public ClusterDeprovisionSpecBuilder toBuilder() {
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
        if (!(o instanceof ClusterDeprovisionSpec)) {
            return false;
        }
        ClusterDeprovisionSpec other = (ClusterDeprovisionSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$baseDomain = this.getBaseDomain();
        Object other$baseDomain = other.getBaseDomain();
        if (this$baseDomain == null ? other$baseDomain != null : !this$baseDomain.equals(other$baseDomain)) {
            return false;
        }
        Object this$clusterID = this.getClusterID();
        Object other$clusterID = other.getClusterID();
        if (this$clusterID == null ? other$clusterID != null : !this$clusterID.equals(other$clusterID)) {
            return false;
        }
        Object this$clusterName = this.getClusterName();
        Object other$clusterName = other.getClusterName();
        if (this$clusterName == null ? other$clusterName != null : !this$clusterName.equals(other$clusterName)) {
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
        return other instanceof ClusterDeprovisionSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $baseDomain = this.getBaseDomain();
        result = result * prime + ($baseDomain == null ? 43 : $baseDomain.hashCode());
        Object $clusterID = this.getClusterID();
        result = result * prime + ($clusterID == null ? 43 : $clusterID.hashCode());
        Object $clusterName = this.getClusterName();
        result = result * prime + ($clusterName == null ? 43 : $clusterName.hashCode());
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
        return "ClusterDeprovisionSpec(" + "baseDomain=" + this.getBaseDomain() + ", clusterID=" + this.getClusterID() + ", clusterName=" + this.getClusterName() + ", infraID=" + this.getInfraID() + ", platform=" + this.getPlatform() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
