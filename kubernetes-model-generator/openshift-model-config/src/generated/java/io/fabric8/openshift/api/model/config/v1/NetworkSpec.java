
package io.fabric8.openshift.api.model.config.v1;

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
    "clusterNetwork",
    "externalIP",
    "networkDiagnostics",
    "networkType",
    "serviceNetwork",
    "serviceNodePortRange"
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
public class NetworkSpec implements Editable<NetworkSpecBuilder> , KubernetesResource
{

    @JsonProperty("clusterNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkSpecClusterNetwork> clusterNetwork = new ArrayList<>();
    @JsonProperty("externalIP")
    private NetworkSpecExternalIP externalIP;
    @JsonProperty("networkDiagnostics")
    private NetworkSpecNetworkDiagnostics networkDiagnostics;
    @JsonProperty("networkType")
    private String networkType;
    @JsonProperty("serviceNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> serviceNetwork = new ArrayList<>();
    @JsonProperty("serviceNodePortRange")
    private String serviceNodePortRange;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public NetworkSpec() {
    }

    public NetworkSpec(List<NetworkSpecClusterNetwork> clusterNetwork, NetworkSpecExternalIP externalIP, NetworkSpecNetworkDiagnostics networkDiagnostics, String networkType, List<String> serviceNetwork, String serviceNodePortRange) {
        super();
        this.clusterNetwork = clusterNetwork;
        this.externalIP = externalIP;
        this.networkDiagnostics = networkDiagnostics;
        this.networkType = networkType;
        this.serviceNetwork = serviceNetwork;
        this.serviceNodePortRange = serviceNodePortRange;
    }

    @JsonProperty("clusterNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NetworkSpecClusterNetwork> getClusterNetwork() {
        return clusterNetwork;
    }

    @JsonProperty("clusterNetwork")
    public void setClusterNetwork(List<NetworkSpecClusterNetwork> clusterNetwork) {
        this.clusterNetwork = clusterNetwork;
    }

    @JsonProperty("externalIP")
    public NetworkSpecExternalIP getExternalIP() {
        return externalIP;
    }

    @JsonProperty("externalIP")
    public void setExternalIP(NetworkSpecExternalIP externalIP) {
        this.externalIP = externalIP;
    }

    @JsonProperty("networkDiagnostics")
    public NetworkSpecNetworkDiagnostics getNetworkDiagnostics() {
        return networkDiagnostics;
    }

    @JsonProperty("networkDiagnostics")
    public void setNetworkDiagnostics(NetworkSpecNetworkDiagnostics networkDiagnostics) {
        this.networkDiagnostics = networkDiagnostics;
    }

    @JsonProperty("networkType")
    public String getNetworkType() {
        return networkType;
    }

    @JsonProperty("networkType")
    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    @JsonProperty("serviceNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getServiceNetwork() {
        return serviceNetwork;
    }

    @JsonProperty("serviceNetwork")
    public void setServiceNetwork(List<String> serviceNetwork) {
        this.serviceNetwork = serviceNetwork;
    }

    @JsonProperty("serviceNodePortRange")
    public String getServiceNodePortRange() {
        return serviceNodePortRange;
    }

    @JsonProperty("serviceNodePortRange")
    public void setServiceNodePortRange(String serviceNodePortRange) {
        this.serviceNodePortRange = serviceNodePortRange;
    }

    @JsonIgnore
    public NetworkSpecBuilder edit() {
        return new NetworkSpecBuilder(this);
    }

    @JsonIgnore
    public NetworkSpecBuilder toBuilder() {
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
