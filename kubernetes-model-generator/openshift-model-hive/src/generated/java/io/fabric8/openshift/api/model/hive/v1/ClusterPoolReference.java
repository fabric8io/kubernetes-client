
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
 * ClusterPoolReference is a reference to a ClusterPool
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "claimName",
    "claimedTimestamp",
    "clusterDeploymentCustomization",
    "namespace",
    "poolName"
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
public class ClusterPoolReference implements Editable<ClusterPoolReferenceBuilder>, KubernetesResource
{

    @JsonProperty("claimName")
    private String claimName;
    @JsonProperty("claimedTimestamp")
    private String claimedTimestamp;
    @JsonProperty("clusterDeploymentCustomization")
    private LocalObjectReference clusterDeploymentCustomization;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("poolName")
    private String poolName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterPoolReference() {
    }

    public ClusterPoolReference(String claimName, String claimedTimestamp, LocalObjectReference clusterDeploymentCustomization, String namespace, String poolName) {
        super();
        this.claimName = claimName;
        this.claimedTimestamp = claimedTimestamp;
        this.clusterDeploymentCustomization = clusterDeploymentCustomization;
        this.namespace = namespace;
        this.poolName = poolName;
    }

    /**
     * ClaimName is the name of the ClusterClaim that claimed the cluster from the pool.
     */
    @JsonProperty("claimName")
    public String getClaimName() {
        return claimName;
    }

    /**
     * ClaimName is the name of the ClusterClaim that claimed the cluster from the pool.
     */
    @JsonProperty("claimName")
    public void setClaimName(String claimName) {
        this.claimName = claimName;
    }

    /**
     * ClusterPoolReference is a reference to a ClusterPool
     */
    @JsonProperty("claimedTimestamp")
    public String getClaimedTimestamp() {
        return claimedTimestamp;
    }

    /**
     * ClusterPoolReference is a reference to a ClusterPool
     */
    @JsonProperty("claimedTimestamp")
    public void setClaimedTimestamp(String claimedTimestamp) {
        this.claimedTimestamp = claimedTimestamp;
    }

    /**
     * ClusterPoolReference is a reference to a ClusterPool
     */
    @JsonProperty("clusterDeploymentCustomization")
    public LocalObjectReference getClusterDeploymentCustomization() {
        return clusterDeploymentCustomization;
    }

    /**
     * ClusterPoolReference is a reference to a ClusterPool
     */
    @JsonProperty("clusterDeploymentCustomization")
    public void setClusterDeploymentCustomization(LocalObjectReference clusterDeploymentCustomization) {
        this.clusterDeploymentCustomization = clusterDeploymentCustomization;
    }

    /**
     * Namespace is the namespace where the ClusterPool resides.
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * Namespace is the namespace where the ClusterPool resides.
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * PoolName is the name of the ClusterPool for which the cluster was created.
     */
    @JsonProperty("poolName")
    public String getPoolName() {
        return poolName;
    }

    /**
     * PoolName is the name of the ClusterPool for which the cluster was created.
     */
    @JsonProperty("poolName")
    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    @JsonIgnore
    public ClusterPoolReferenceBuilder edit() {
        return new ClusterPoolReferenceBuilder(this);
    }

    @JsonIgnore
    public ClusterPoolReferenceBuilder toBuilder() {
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
        if (!(o instanceof ClusterPoolReference)) {
            return false;
        }
        ClusterPoolReference other = (ClusterPoolReference) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$claimName = this.getClaimName();
        Object other$claimName = other.getClaimName();
        if (this$claimName == null ? other$claimName != null : !this$claimName.equals(other$claimName)) {
            return false;
        }
        Object this$claimedTimestamp = this.getClaimedTimestamp();
        Object other$claimedTimestamp = other.getClaimedTimestamp();
        if (this$claimedTimestamp == null ? other$claimedTimestamp != null : !this$claimedTimestamp.equals(other$claimedTimestamp)) {
            return false;
        }
        Object this$clusterDeploymentCustomization = this.getClusterDeploymentCustomization();
        Object other$clusterDeploymentCustomization = other.getClusterDeploymentCustomization();
        if (this$clusterDeploymentCustomization == null ? other$clusterDeploymentCustomization != null : !this$clusterDeploymentCustomization.equals(other$clusterDeploymentCustomization)) {
            return false;
        }
        Object this$namespace = this.getNamespace();
        Object other$namespace = other.getNamespace();
        if (this$namespace == null ? other$namespace != null : !this$namespace.equals(other$namespace)) {
            return false;
        }
        Object this$poolName = this.getPoolName();
        Object other$poolName = other.getPoolName();
        if (this$poolName == null ? other$poolName != null : !this$poolName.equals(other$poolName)) {
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
        return other instanceof ClusterPoolReference;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $claimName = this.getClaimName();
        result = result * prime + ($claimName == null ? 43 : $claimName.hashCode());
        Object $claimedTimestamp = this.getClaimedTimestamp();
        result = result * prime + ($claimedTimestamp == null ? 43 : $claimedTimestamp.hashCode());
        Object $clusterDeploymentCustomization = this.getClusterDeploymentCustomization();
        result = result * prime + ($clusterDeploymentCustomization == null ? 43 : $clusterDeploymentCustomization.hashCode());
        Object $namespace = this.getNamespace();
        result = result * prime + ($namespace == null ? 43 : $namespace.hashCode());
        Object $poolName = this.getPoolName();
        result = result * prime + ($poolName == null ? 43 : $poolName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterPoolReference(" + "claimName=" + this.getClaimName() + ", claimedTimestamp=" + this.getClaimedTimestamp() + ", clusterDeploymentCustomization=" + this.getClusterDeploymentCustomization() + ", namespace=" + this.getNamespace() + ", poolName=" + this.getPoolName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
