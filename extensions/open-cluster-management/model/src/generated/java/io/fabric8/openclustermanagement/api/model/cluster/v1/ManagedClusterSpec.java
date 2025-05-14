
package io.fabric8.openclustermanagement.api.model.cluster.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ManagedClusterSpec provides the information to securely connect to a remote server and verify its identity.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hubAcceptsClient",
    "leaseDurationSeconds",
    "managedClusterClientConfigs",
    "taints"
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
public class ManagedClusterSpec implements Editable<ManagedClusterSpecBuilder>, KubernetesResource
{

    @JsonProperty("hubAcceptsClient")
    private Boolean hubAcceptsClient;
    @JsonProperty("leaseDurationSeconds")
    private Integer leaseDurationSeconds;
    @JsonProperty("managedClusterClientConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClientConfig> managedClusterClientConfigs = new ArrayList<>();
    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Taint> taints = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ManagedClusterSpec() {
    }

    public ManagedClusterSpec(Boolean hubAcceptsClient, Integer leaseDurationSeconds, List<ClientConfig> managedClusterClientConfigs, List<Taint> taints) {
        super();
        this.hubAcceptsClient = hubAcceptsClient;
        this.leaseDurationSeconds = leaseDurationSeconds;
        this.managedClusterClientConfigs = managedClusterClientConfigs;
        this.taints = taints;
    }

    /**
     * hubAcceptsClient represents that hub accepts the joining of Klusterlet agent on the managed cluster with the hub. The default value is false, and can only be set true when the user on hub has an RBAC rule to UPDATE on the virtual subresource of managedclusters/accept. When the value is set true, a namespace whose name is the same as the name of ManagedCluster is created on the hub. This namespace represents the managed cluster, also role/rolebinding is created on the namespace to grant the permision of access from the agent on the managed cluster. When the value is set to false, the namespace representing the managed cluster is deleted.
     */
    @JsonProperty("hubAcceptsClient")
    public Boolean getHubAcceptsClient() {
        return hubAcceptsClient;
    }

    /**
     * hubAcceptsClient represents that hub accepts the joining of Klusterlet agent on the managed cluster with the hub. The default value is false, and can only be set true when the user on hub has an RBAC rule to UPDATE on the virtual subresource of managedclusters/accept. When the value is set true, a namespace whose name is the same as the name of ManagedCluster is created on the hub. This namespace represents the managed cluster, also role/rolebinding is created on the namespace to grant the permision of access from the agent on the managed cluster. When the value is set to false, the namespace representing the managed cluster is deleted.
     */
    @JsonProperty("hubAcceptsClient")
    public void setHubAcceptsClient(Boolean hubAcceptsClient) {
        this.hubAcceptsClient = hubAcceptsClient;
    }

    /**
     * LeaseDurationSeconds is used to coordinate the lease update time of Klusterlet agents on the managed cluster. If its value is zero, the Klusterlet agent will update its lease every 60 seconds by default
     */
    @JsonProperty("leaseDurationSeconds")
    public Integer getLeaseDurationSeconds() {
        return leaseDurationSeconds;
    }

    /**
     * LeaseDurationSeconds is used to coordinate the lease update time of Klusterlet agents on the managed cluster. If its value is zero, the Klusterlet agent will update its lease every 60 seconds by default
     */
    @JsonProperty("leaseDurationSeconds")
    public void setLeaseDurationSeconds(Integer leaseDurationSeconds) {
        this.leaseDurationSeconds = leaseDurationSeconds;
    }

    /**
     * ManagedClusterClientConfigs represents a list of the apiserver address of the managed cluster. If it is empty, the managed cluster has no accessible address for the hub to connect with it.
     */
    @JsonProperty("managedClusterClientConfigs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClientConfig> getManagedClusterClientConfigs() {
        return managedClusterClientConfigs;
    }

    /**
     * ManagedClusterClientConfigs represents a list of the apiserver address of the managed cluster. If it is empty, the managed cluster has no accessible address for the hub to connect with it.
     */
    @JsonProperty("managedClusterClientConfigs")
    public void setManagedClusterClientConfigs(List<ClientConfig> managedClusterClientConfigs) {
        this.managedClusterClientConfigs = managedClusterClientConfigs;
    }

    /**
     * Taints is a property of managed cluster that allow the cluster to be repelled when scheduling. Taints, including 'ManagedClusterUnavailable' and 'ManagedClusterUnreachable', can not be added/removed by agent running on the managed cluster; while it's fine to add/remove other taints from either hub cluser or managed cluster.
     */
    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Taint> getTaints() {
        return taints;
    }

    /**
     * Taints is a property of managed cluster that allow the cluster to be repelled when scheduling. Taints, including 'ManagedClusterUnavailable' and 'ManagedClusterUnreachable', can not be added/removed by agent running on the managed cluster; while it's fine to add/remove other taints from either hub cluser or managed cluster.
     */
    @JsonProperty("taints")
    public void setTaints(List<Taint> taints) {
        this.taints = taints;
    }

    @JsonIgnore
    public ManagedClusterSpecBuilder edit() {
        return new ManagedClusterSpecBuilder(this);
    }

    @JsonIgnore
    public ManagedClusterSpecBuilder toBuilder() {
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

}
