
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "clusterNetwork",
    "externalIP",
    "networkType",
    "serviceNetwork",
    "serviceNodePortRange"
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class NetworkSpec implements KubernetesResource
{

    @JsonProperty("clusterNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterNetworkEntry> clusterNetwork = new ArrayList<ClusterNetworkEntry>();
    @JsonProperty("externalIP")
    private ExternalIPConfig externalIP;
    @JsonProperty("networkType")
    private String networkType;
    @JsonProperty("serviceNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> serviceNetwork = new ArrayList<String>();
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

    public NetworkSpec(List<ClusterNetworkEntry> clusterNetwork, ExternalIPConfig externalIP, String networkType, List<String> serviceNetwork, String serviceNodePortRange) {
        super();
        this.clusterNetwork = clusterNetwork;
        this.externalIP = externalIP;
        this.networkType = networkType;
        this.serviceNetwork = serviceNetwork;
        this.serviceNodePortRange = serviceNodePortRange;
    }

    @JsonProperty("clusterNetwork")
    public List<ClusterNetworkEntry> getClusterNetwork() {
        return clusterNetwork;
    }

    @JsonProperty("clusterNetwork")
    public void setClusterNetwork(List<ClusterNetworkEntry> clusterNetwork) {
        this.clusterNetwork = clusterNetwork;
    }

    @JsonProperty("externalIP")
    public ExternalIPConfig getExternalIP() {
        return externalIP;
    }

    @JsonProperty("externalIP")
    public void setExternalIP(ExternalIPConfig externalIP) {
        this.externalIP = externalIP;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
