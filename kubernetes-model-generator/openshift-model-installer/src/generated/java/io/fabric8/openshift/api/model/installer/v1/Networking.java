
package io.fabric8.openshift.api.model.installer.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterNetwork",
    "clusterNetworkMTU",
    "clusterNetworks",
    "machineCIDR",
    "machineNetwork",
    "networkType",
    "serviceCIDR",
    "serviceNetwork",
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
public class Networking implements Editable<NetworkingBuilder> , KubernetesResource
{

    @JsonProperty("clusterNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterNetworkEntry> clusterNetwork = new ArrayList<>();
    @JsonProperty("clusterNetworkMTU")
    private Long clusterNetworkMTU;
    @JsonProperty("clusterNetworks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterNetworkEntry> clusterNetworkList = new ArrayList<>();
    @JsonProperty("machineCIDR")
    private String machineCIDR;
    @JsonProperty("machineNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachineNetworkEntry> machineNetwork = new ArrayList<>();
    @JsonProperty("networkType")
    private String networkType;
    @JsonProperty("serviceCIDR")
    private String serviceCIDR;
    @JsonProperty("serviceNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> serviceNetwork = new ArrayList<>();
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Networking() {
    }

    public Networking(List<ClusterNetworkEntry> clusterNetwork, Long clusterNetworkMTU, List<ClusterNetworkEntry> clusterNetworkList, String machineCIDR, List<MachineNetworkEntry> machineNetwork, String networkType, String serviceCIDR, List<String> serviceNetwork, String type) {
        super();
        this.clusterNetwork = clusterNetwork;
        this.clusterNetworkMTU = clusterNetworkMTU;
        this.clusterNetworkList = clusterNetworkList;
        this.machineCIDR = machineCIDR;
        this.machineNetwork = machineNetwork;
        this.networkType = networkType;
        this.serviceCIDR = serviceCIDR;
        this.serviceNetwork = serviceNetwork;
        this.type = type;
    }

    @JsonProperty("clusterNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterNetworkEntry> getClusterNetwork() {
        return clusterNetwork;
    }

    @JsonProperty("clusterNetwork")
    public void setClusterNetwork(List<ClusterNetworkEntry> clusterNetwork) {
        this.clusterNetwork = clusterNetwork;
    }

    @JsonProperty("clusterNetworkMTU")
    public Long getClusterNetworkMTU() {
        return clusterNetworkMTU;
    }

    @JsonProperty("clusterNetworkMTU")
    public void setClusterNetworkMTU(Long clusterNetworkMTU) {
        this.clusterNetworkMTU = clusterNetworkMTU;
    }

    @JsonProperty("clusterNetworks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterNetworkEntry> getClusterNetworks() {
        return clusterNetworkList;
    }

    @JsonProperty("clusterNetworks")
    public void setClusterNetworks(List<ClusterNetworkEntry> clusterNetworkList) {
        this.clusterNetworkList = clusterNetworkList;
    }

    @JsonProperty("machineCIDR")
    public String getMachineCIDR() {
        return machineCIDR;
    }

    @JsonProperty("machineCIDR")
    public void setMachineCIDR(String machineCIDR) {
        this.machineCIDR = machineCIDR;
    }

    @JsonProperty("machineNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachineNetworkEntry> getMachineNetwork() {
        return machineNetwork;
    }

    @JsonProperty("machineNetwork")
    public void setMachineNetwork(List<MachineNetworkEntry> machineNetwork) {
        this.machineNetwork = machineNetwork;
    }

    @JsonProperty("networkType")
    public String getNetworkType() {
        return networkType;
    }

    @JsonProperty("networkType")
    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    @JsonProperty("serviceCIDR")
    public String getServiceCIDR() {
        return serviceCIDR;
    }

    @JsonProperty("serviceCIDR")
    public void setServiceCIDR(String serviceCIDR) {
        this.serviceCIDR = serviceCIDR;
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

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public NetworkingBuilder edit() {
        return new NetworkingBuilder(this);
    }

    @JsonIgnore
    public NetworkingBuilder toBuilder() {
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
