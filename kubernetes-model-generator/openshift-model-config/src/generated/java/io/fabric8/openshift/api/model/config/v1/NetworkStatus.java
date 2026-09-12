
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.Condition;
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

/**
 * NetworkStatus is the current network configuration.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterNetwork",
    "clusterNetworkMTU",
    "conditions",
    "migration",
    "networkType",
    "serviceNetwork"
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
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NetworkStatus implements Editable<NetworkStatusBuilder>, KubernetesResource
{

    @JsonProperty("clusterNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterNetworkEntry> clusterNetwork = new ArrayList<>();
    @JsonProperty("clusterNetworkMTU")
    private Integer clusterNetworkMTU;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("migration")
    private NetworkMigration migration;
    @JsonProperty("networkType")
    private String networkType;
    @JsonProperty("serviceNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> serviceNetwork = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkStatus() {
    }

    public NetworkStatus(List<ClusterNetworkEntry> clusterNetwork, Integer clusterNetworkMTU, List<Condition> conditions, NetworkMigration migration, String networkType, List<String> serviceNetwork) {
        super();
        this.clusterNetwork = clusterNetwork;
        this.clusterNetworkMTU = clusterNetworkMTU;
        this.conditions = conditions;
        this.migration = migration;
        this.networkType = networkType;
        this.serviceNetwork = serviceNetwork;
    }

    /**
     * IP address pool to use for pod IPs.
     */
    @JsonProperty("clusterNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterNetworkEntry> getClusterNetwork() {
        return clusterNetwork;
    }

    /**
     * IP address pool to use for pod IPs.
     */
    @JsonProperty("clusterNetwork")
    public void setClusterNetwork(List<ClusterNetworkEntry> clusterNetwork) {
        this.clusterNetwork = clusterNetwork;
    }

    /**
     * clusterNetworkMTU is the MTU for inter-pod networking.
     */
    @JsonProperty("clusterNetworkMTU")
    public Integer getClusterNetworkMTU() {
        return clusterNetworkMTU;
    }

    /**
     * clusterNetworkMTU is the MTU for inter-pod networking.
     */
    @JsonProperty("clusterNetworkMTU")
    public void setClusterNetworkMTU(Integer clusterNetworkMTU) {
        this.clusterNetworkMTU = clusterNetworkMTU;
    }

    /**
     * conditions represents the observations of a network.config current state. Known .status.conditions.type are: "NetworkDiagnosticsAvailable"
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions represents the observations of a network.config current state. Known .status.conditions.type are: "NetworkDiagnosticsAvailable"
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * NetworkStatus is the current network configuration.
     */
    @JsonProperty("migration")
    public NetworkMigration getMigration() {
        return migration;
    }

    /**
     * NetworkStatus is the current network configuration.
     */
    @JsonProperty("migration")
    public void setMigration(NetworkMigration migration) {
        this.migration = migration;
    }

    /**
     * networkType is the plugin that is deployed (e.g. OVNKubernetes).
     */
    @JsonProperty("networkType")
    public String getNetworkType() {
        return networkType;
    }

    /**
     * networkType is the plugin that is deployed (e.g. OVNKubernetes).
     */
    @JsonProperty("networkType")
    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    /**
     * IP address pool for services. Currently, we only support a single entry here.
     */
    @JsonProperty("serviceNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getServiceNetwork() {
        return serviceNetwork;
    }

    /**
     * IP address pool for services. Currently, we only support a single entry here.
     */
    @JsonProperty("serviceNetwork")
    public void setServiceNetwork(List<String> serviceNetwork) {
        this.serviceNetwork = serviceNetwork;
    }

    @JsonIgnore
    public NetworkStatusBuilder edit() {
        return new NetworkStatusBuilder(this);
    }

    @JsonIgnore
    public NetworkStatusBuilder toBuilder() {
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
        if (!(o instanceof NetworkStatus)) {
            return false;
        }
        NetworkStatus other = (NetworkStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clusterNetwork = this.getClusterNetwork();
        Object other$clusterNetwork = other.getClusterNetwork();
        if (this$clusterNetwork == null ? other$clusterNetwork != null : !this$clusterNetwork.equals(other$clusterNetwork)) {
            return false;
        }
        Object this$clusterNetworkMTU = this.getClusterNetworkMTU();
        Object other$clusterNetworkMTU = other.getClusterNetworkMTU();
        if (this$clusterNetworkMTU == null ? other$clusterNetworkMTU != null : !this$clusterNetworkMTU.equals(other$clusterNetworkMTU)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$migration = this.getMigration();
        Object other$migration = other.getMigration();
        if (this$migration == null ? other$migration != null : !this$migration.equals(other$migration)) {
            return false;
        }
        Object this$networkType = this.getNetworkType();
        Object other$networkType = other.getNetworkType();
        if (this$networkType == null ? other$networkType != null : !this$networkType.equals(other$networkType)) {
            return false;
        }
        Object this$serviceNetwork = this.getServiceNetwork();
        Object other$serviceNetwork = other.getServiceNetwork();
        if (this$serviceNetwork == null ? other$serviceNetwork != null : !this$serviceNetwork.equals(other$serviceNetwork)) {
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
        return other instanceof NetworkStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clusterNetwork = this.getClusterNetwork();
        result = result * prime + ($clusterNetwork == null ? 43 : $clusterNetwork.hashCode());
        Object $clusterNetworkMTU = this.getClusterNetworkMTU();
        result = result * prime + ($clusterNetworkMTU == null ? 43 : $clusterNetworkMTU.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $migration = this.getMigration();
        result = result * prime + ($migration == null ? 43 : $migration.hashCode());
        Object $networkType = this.getNetworkType();
        result = result * prime + ($networkType == null ? 43 : $networkType.hashCode());
        Object $serviceNetwork = this.getServiceNetwork();
        result = result * prime + ($serviceNetwork == null ? 43 : $serviceNetwork.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NetworkStatus(" + "clusterNetwork=" + this.getClusterNetwork() + ", clusterNetworkMTU=" + this.getClusterNetworkMTU() + ", conditions=" + this.getConditions() + ", migration=" + this.getMigration() + ", networkType=" + this.getNetworkType() + ", serviceNetwork=" + this.getServiceNetwork() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
