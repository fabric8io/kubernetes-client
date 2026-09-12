
package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

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
        if (!(o instanceof NetworkSelectionElement)) {
            return false;
        }
        NetworkSelectionElement other = (NetworkSelectionElement) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$bandwidth = this.getBandwidth();
        Object other$bandwidth = other.getBandwidth();
        if (this$bandwidth == null ? other$bandwidth != null : !this$bandwidth.equals(other$bandwidth)) {
            return false;
        }
        Object this$cniArgs = this.getCniArgs();
        Object other$cniArgs = other.getCniArgs();
        if (this$cniArgs == null ? other$cniArgs != null : !this$cniArgs.equals(other$cniArgs)) {
            return false;
        }
        Object this$defaultRoute = this.getDefaultRoute();
        Object other$defaultRoute = other.getDefaultRoute();
        if (this$defaultRoute == null ? other$defaultRoute != null : !this$defaultRoute.equals(other$defaultRoute)) {
            return false;
        }
        Object this$infinibandGuid = this.getInfinibandGuid();
        Object other$infinibandGuid = other.getInfinibandGuid();
        if (this$infinibandGuid == null ? other$infinibandGuid != null : !this$infinibandGuid.equals(other$infinibandGuid)) {
            return false;
        }
        Object this$_interface = this.getInterface();
        Object other$_interface = other.getInterface();
        if (this$_interface == null ? other$_interface != null : !this$_interface.equals(other$_interface)) {
            return false;
        }
        Object this$ipamClaimReference = this.getIpamClaimReference();
        Object other$ipamClaimReference = other.getIpamClaimReference();
        if (this$ipamClaimReference == null ? other$ipamClaimReference != null : !this$ipamClaimReference.equals(other$ipamClaimReference)) {
            return false;
        }
        Object this$ips = this.getIps();
        Object other$ips = other.getIps();
        if (this$ips == null ? other$ips != null : !this$ips.equals(other$ips)) {
            return false;
        }
        Object this$mac = this.getMac();
        Object other$mac = other.getMac();
        if (this$mac == null ? other$mac != null : !this$mac.equals(other$mac)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$namespace = this.getNamespace();
        Object other$namespace = other.getNamespace();
        if (this$namespace == null ? other$namespace != null : !this$namespace.equals(other$namespace)) {
            return false;
        }
        Object this$portMappings = this.getPortMappings();
        Object other$portMappings = other.getPortMappings();
        if (this$portMappings == null ? other$portMappings != null : !this$portMappings.equals(other$portMappings)) {
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
        return other instanceof NetworkSelectionElement;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bandwidth = this.getBandwidth();
        result = result * prime + ($bandwidth == null ? 43 : $bandwidth.hashCode());
        Object $cniArgs = this.getCniArgs();
        result = result * prime + ($cniArgs == null ? 43 : $cniArgs.hashCode());
        Object $defaultRoute = this.getDefaultRoute();
        result = result * prime + ($defaultRoute == null ? 43 : $defaultRoute.hashCode());
        Object $infinibandGuid = this.getInfinibandGuid();
        result = result * prime + ($infinibandGuid == null ? 43 : $infinibandGuid.hashCode());
        Object $_interface = this.getInterface();
        result = result * prime + ($_interface == null ? 43 : $_interface.hashCode());
        Object $ipamClaimReference = this.getIpamClaimReference();
        result = result * prime + ($ipamClaimReference == null ? 43 : $ipamClaimReference.hashCode());
        Object $ips = this.getIps();
        result = result * prime + ($ips == null ? 43 : $ips.hashCode());
        Object $mac = this.getMac();
        result = result * prime + ($mac == null ? 43 : $mac.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $namespace = this.getNamespace();
        result = result * prime + ($namespace == null ? 43 : $namespace.hashCode());
        Object $portMappings = this.getPortMappings();
        result = result * prime + ($portMappings == null ? 43 : $portMappings.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NetworkSelectionElement(" + "bandwidth=" + this.getBandwidth() + ", cniArgs=" + this.getCniArgs() + ", defaultRoute=" + this.getDefaultRoute() + ", infinibandGuid=" + this.getInfinibandGuid() + ", _interface=" + this.getInterface() + ", ipamClaimReference=" + this.getIpamClaimReference() + ", ips=" + this.getIps() + ", mac=" + this.getMac() + ", name=" + this.getName() + ", namespace=" + this.getNamespace() + ", portMappings=" + this.getPortMappings() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
