
package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

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

/**
 * NetworkSelectionElement represents one element of the JSON format Network Attachment Selection Annotation as described in section 4.1.2 of the CRD specification.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bandwidth",
    "cni-args",
    "default-route",
    "infiniband-guid",
    "interface",
    "ipam-claim-reference",
    "ips",
    "mac",
    "name",
    "namespace",
    "portMappings"
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
public class NetworkSelectionElement implements Editable<NetworkSelectionElementBuilder>, KubernetesResource
{

    @JsonProperty("bandwidth")
    private BandwidthEntry bandwidth;
    @JsonProperty("cni-args")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializerForMap.class)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> cniArgs = new LinkedHashMap<>();
    @JsonProperty("default-route")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> defaultRoute = new ArrayList<>();
    @JsonProperty("infiniband-guid")
    private String infinibandGuid;
    @JsonProperty("interface")
    private String _interface;
    @JsonProperty("ipam-claim-reference")
    private String ipamClaimReference;
    @JsonProperty("ips")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ips = new ArrayList<>();
    @JsonProperty("mac")
    private String mac;
    @JsonProperty("name")
    private String name;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("portMappings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PortMapEntry> portMappings = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkSelectionElement() {
    }

    public NetworkSelectionElement(BandwidthEntry bandwidth, Map<String, Object> cniArgs, List<String> defaultRoute, String infinibandGuid, String _interface, String ipamClaimReference, List<String> ips, String mac, String name, String namespace, List<PortMapEntry> portMappings) {
        super();
        this.bandwidth = bandwidth;
        this.cniArgs = cniArgs;
        this.defaultRoute = defaultRoute;
        this.infinibandGuid = infinibandGuid;
        this._interface = _interface;
        this.ipamClaimReference = ipamClaimReference;
        this.ips = ips;
        this.mac = mac;
        this.name = name;
        this.namespace = namespace;
        this.portMappings = portMappings;
    }

    /**
     * NetworkSelectionElement represents one element of the JSON format Network Attachment Selection Annotation as described in section 4.1.2 of the CRD specification.
     */
    @JsonProperty("bandwidth")
    public BandwidthEntry getBandwidth() {
        return bandwidth;
    }

    /**
     * NetworkSelectionElement represents one element of the JSON format Network Attachment Selection Annotation as described in section 4.1.2 of the CRD specification.
     */
    @JsonProperty("bandwidth")
    public void setBandwidth(BandwidthEntry bandwidth) {
        this.bandwidth = bandwidth;
    }

    /**
     * CNIArgs contains additional CNI arguments for the network interface
     */
    @JsonProperty("cni-args")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Object> getCniArgs() {
        return cniArgs;
    }

    /**
     * CNIArgs contains additional CNI arguments for the network interface
     */
    @JsonProperty("cni-args")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializerForMap.class)
    public void setCniArgs(Map<String, Object> cniArgs) {
        this.cniArgs = cniArgs;
    }

    /**
     * GatewayRequest contains default route IP address for the pod
     */
    @JsonProperty("default-route")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDefaultRoute() {
        return defaultRoute;
    }

    /**
     * GatewayRequest contains default route IP address for the pod
     */
    @JsonProperty("default-route")
    public void setDefaultRoute(List<String> defaultRoute) {
        this.defaultRoute = defaultRoute;
    }

    /**
     * InfinibandGUIDRequest contains an optional requested Infiniband GUID address for this network attachment
     */
    @JsonProperty("infiniband-guid")
    public String getInfinibandGuid() {
        return infinibandGuid;
    }

    /**
     * InfinibandGUIDRequest contains an optional requested Infiniband GUID address for this network attachment
     */
    @JsonProperty("infiniband-guid")
    public void setInfinibandGuid(String infinibandGuid) {
        this.infinibandGuid = infinibandGuid;
    }

    /**
     * InterfaceRequest contains an optional requested name for the network interface this attachment will create in the container
     */
    @JsonProperty("interface")
    public String getInterface() {
        return _interface;
    }

    /**
     * InterfaceRequest contains an optional requested name for the network interface this attachment will create in the container
     */
    @JsonProperty("interface")
    public void setInterface(String _interface) {
        this._interface = _interface;
    }

    /**
     * IPAMClaimReference container the IPAMClaim name where the IPs for this attachment will be located.
     */
    @JsonProperty("ipam-claim-reference")
    public String getIpamClaimReference() {
        return ipamClaimReference;
    }

    /**
     * IPAMClaimReference container the IPAMClaim name where the IPs for this attachment will be located.
     */
    @JsonProperty("ipam-claim-reference")
    public void setIpamClaimReference(String ipamClaimReference) {
        this.ipamClaimReference = ipamClaimReference;
    }

    /**
     * IPRequest contains an optional requested IP addresses for this network attachment
     */
    @JsonProperty("ips")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIps() {
        return ips;
    }

    /**
     * IPRequest contains an optional requested IP addresses for this network attachment
     */
    @JsonProperty("ips")
    public void setIps(List<String> ips) {
        this.ips = ips;
    }

    /**
     * MacRequest contains an optional requested MAC address for this network attachment
     */
    @JsonProperty("mac")
    public String getMac() {
        return mac;
    }

    /**
     * MacRequest contains an optional requested MAC address for this network attachment
     */
    @JsonProperty("mac")
    public void setMac(String mac) {
        this.mac = mac;
    }

    /**
     * Name contains the name of the Network object this element selects
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name contains the name of the Network object this element selects
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Namespace contains the optional namespace that the network referenced by Name exists in
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * Namespace contains the optional namespace that the network referenced by Name exists in
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * PortMappingsRequest contains an optional requested port mapping for the network
     */
    @JsonProperty("portMappings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PortMapEntry> getPortMappings() {
        return portMappings;
    }

    /**
     * PortMappingsRequest contains an optional requested port mapping for the network
     */
    @JsonProperty("portMappings")
    public void setPortMappings(List<PortMapEntry> portMappings) {
        this.portMappings = portMappings;
    }

    @JsonIgnore
    public NetworkSelectionElementBuilder edit() {
        return new NetworkSelectionElementBuilder(this);
    }

    @JsonIgnore
    public NetworkSelectionElementBuilder toBuilder() {
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
