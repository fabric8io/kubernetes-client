
package io.fabric8.openshift.api.model.miscellaneous.network.v1;

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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ClusterNetwork was used by OpenShift SDN. DEPRECATED: OpenShift SDN is no longer supported and this object is no longer used in any way by OpenShift.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "clusterNetworks",
    "hostsubnetlength",
    "mtu",
    "network",
    "pluginName",
    "serviceNetwork",
    "vxlanPort"
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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1")
@Group("network.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ClusterNetwork implements Editable<ClusterNetworkBuilder>, HasMetadata
{

    @JsonProperty("apiVersion")
    private String apiVersion = "network.openshift.io/v1";
    @JsonProperty("clusterNetworks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterNetworkEntry> clusterNetworks = new ArrayList<>();
    @JsonProperty("hostsubnetlength")
    private Long hostsubnetlength;
    @JsonProperty("kind")
    private String kind = "ClusterNetwork";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("mtu")
    private Long mtu;
    @JsonProperty("network")
    private String network;
    @JsonProperty("pluginName")
    private String pluginName;
    @JsonProperty("serviceNetwork")
    private String serviceNetwork;
    @JsonProperty("vxlanPort")
    private Long vxlanPort;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterNetwork() {
    }

    public ClusterNetwork(String apiVersion, List<ClusterNetworkEntry> clusterNetworks, Long hostsubnetlength, String kind, ObjectMeta metadata, Long mtu, String network, String pluginName, String serviceNetwork, Long vxlanPort) {
        super();
        this.apiVersion = apiVersion;
        this.clusterNetworks = clusterNetworks;
        this.hostsubnetlength = hostsubnetlength;
        this.kind = kind;
        this.metadata = metadata;
        this.mtu = mtu;
        this.network = network;
        this.pluginName = pluginName;
        this.serviceNetwork = serviceNetwork;
        this.vxlanPort = vxlanPort;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * clusterNetworks is a list of ClusterNetwork objects that defines the global overlay network's L3 space by specifying a set of CIDR and netmasks that the SDN can allocate addresses from.
     */
    @JsonProperty("clusterNetworks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterNetworkEntry> getClusterNetworks() {
        return clusterNetworks;
    }

    /**
     * clusterNetworks is a list of ClusterNetwork objects that defines the global overlay network's L3 space by specifying a set of CIDR and netmasks that the SDN can allocate addresses from.
     */
    @JsonProperty("clusterNetworks")
    public void setClusterNetworks(List<ClusterNetworkEntry> clusterNetworks) {
        this.clusterNetworks = clusterNetworks;
    }

    /**
     * hostsubnetlength is the number of bits of network to allocate to each node. eg, 8 would mean that each node would have a /24 slice of the overlay network for its pods
     */
    @JsonProperty("hostsubnetlength")
    public Long getHostsubnetlength() {
        return hostsubnetlength;
    }

    /**
     * hostsubnetlength is the number of bits of network to allocate to each node. eg, 8 would mean that each node would have a /24 slice of the overlay network for its pods
     */
    @JsonProperty("hostsubnetlength")
    public void setHostsubnetlength(Long hostsubnetlength) {
        this.hostsubnetlength = hostsubnetlength;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * ClusterNetwork was used by OpenShift SDN. DEPRECATED: OpenShift SDN is no longer supported and this object is no longer used in any way by OpenShift.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * ClusterNetwork was used by OpenShift SDN. DEPRECATED: OpenShift SDN is no longer supported and this object is no longer used in any way by OpenShift.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * mtu is the MTU for the overlay network. This should be 50 less than the MTU of the network connecting the nodes. It is normally autodetected by the cluster network operator.
     */
    @JsonProperty("mtu")
    public Long getMtu() {
        return mtu;
    }

    /**
     * mtu is the MTU for the overlay network. This should be 50 less than the MTU of the network connecting the nodes. It is normally autodetected by the cluster network operator.
     */
    @JsonProperty("mtu")
    public void setMtu(Long mtu) {
        this.mtu = mtu;
    }

    /**
     * network is a CIDR string specifying the global overlay network's L3 space
     */
    @JsonProperty("network")
    public String getNetwork() {
        return network;
    }

    /**
     * network is a CIDR string specifying the global overlay network's L3 space
     */
    @JsonProperty("network")
    public void setNetwork(String network) {
        this.network = network;
    }

    /**
     * pluginName is the name of the network plugin being used
     */
    @JsonProperty("pluginName")
    public String getPluginName() {
        return pluginName;
    }

    /**
     * pluginName is the name of the network plugin being used
     */
    @JsonProperty("pluginName")
    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

    /**
     * serviceNetwork is the CIDR range that Service IP addresses are allocated from
     */
    @JsonProperty("serviceNetwork")
    public String getServiceNetwork() {
        return serviceNetwork;
    }

    /**
     * serviceNetwork is the CIDR range that Service IP addresses are allocated from
     */
    @JsonProperty("serviceNetwork")
    public void setServiceNetwork(String serviceNetwork) {
        this.serviceNetwork = serviceNetwork;
    }

    /**
     * vxlanPort sets the VXLAN destination port used by the cluster. It is set by the master configuration file on startup and cannot be edited manually. Valid values for VXLANPort are integers 1-65535 inclusive and if unset defaults to 4789. Changing VXLANPort allows users to resolve issues between openshift SDN and other software trying to use the same VXLAN destination port.
     */
    @JsonProperty("vxlanPort")
    public Long getVxlanPort() {
        return vxlanPort;
    }

    /**
     * vxlanPort sets the VXLAN destination port used by the cluster. It is set by the master configuration file on startup and cannot be edited manually. Valid values for VXLANPort are integers 1-65535 inclusive and if unset defaults to 4789. Changing VXLANPort allows users to resolve issues between openshift SDN and other software trying to use the same VXLAN destination port.
     */
    @JsonProperty("vxlanPort")
    public void setVxlanPort(Long vxlanPort) {
        this.vxlanPort = vxlanPort;
    }

    @JsonIgnore
    public ClusterNetworkBuilder edit() {
        return new ClusterNetworkBuilder(this);
    }

    @JsonIgnore
    public ClusterNetworkBuilder toBuilder() {
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
