
package io.fabric8.openshift.api.model.hive.v1;

import java.util.LinkedHashMap;
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
