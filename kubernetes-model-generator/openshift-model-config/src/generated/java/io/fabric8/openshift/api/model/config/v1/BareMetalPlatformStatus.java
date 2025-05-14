
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
 * BareMetalPlatformStatus holds the current status of the BareMetal infrastructure provider. For more information about the network architecture used with the BareMetal platform type, see: https://github.com/openshift/installer/blob/master/docs/design/baremetal/networking-infrastructure.md
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiServerInternalIP",
    "apiServerInternalIPs",
    "ingressIP",
    "ingressIPs",
    "loadBalancer",
    "machineNetworks",
    "nodeDNSIP"
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
public class BareMetalPlatformStatus implements Editable<BareMetalPlatformStatusBuilder>, KubernetesResource
{

    @JsonProperty("apiServerInternalIP")
    private String apiServerInternalIP;
    @JsonProperty("apiServerInternalIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> apiServerInternalIPs = new ArrayList<>();
    @JsonProperty("ingressIP")
    private String ingressIP;
    @JsonProperty("ingressIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ingressIPs = new ArrayList<>();
    @JsonProperty("loadBalancer")
    private BareMetalPlatformLoadBalancer loadBalancer;
    @JsonProperty("machineNetworks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> machineNetworks = new ArrayList<>();
    @JsonProperty("nodeDNSIP")
    private String nodeDNSIP;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BareMetalPlatformStatus() {
    }

    public BareMetalPlatformStatus(String apiServerInternalIP, List<String> apiServerInternalIPs, String ingressIP, List<String> ingressIPs, BareMetalPlatformLoadBalancer loadBalancer, List<String> machineNetworks, String nodeDNSIP) {
        super();
        this.apiServerInternalIP = apiServerInternalIP;
        this.apiServerInternalIPs = apiServerInternalIPs;
        this.ingressIP = ingressIP;
        this.ingressIPs = ingressIPs;
        this.loadBalancer = loadBalancer;
        this.machineNetworks = machineNetworks;
        this.nodeDNSIP = nodeDNSIP;
    }

    /**
     * apiServerInternalIP is an IP address to contact the Kubernetes API server that can be used by components inside the cluster, like kubelets using the infrastructure rather than Kubernetes networking. It is the IP that the Infrastructure.status.apiServerInternalURI points to. It is the IP for a self-hosted load balancer in front of the API servers.<br><p> <br><p> Deprecated: Use APIServerInternalIPs instead.
     */
    @JsonProperty("apiServerInternalIP")
    public String getApiServerInternalIP() {
        return apiServerInternalIP;
    }

    /**
     * apiServerInternalIP is an IP address to contact the Kubernetes API server that can be used by components inside the cluster, like kubelets using the infrastructure rather than Kubernetes networking. It is the IP that the Infrastructure.status.apiServerInternalURI points to. It is the IP for a self-hosted load balancer in front of the API servers.<br><p> <br><p> Deprecated: Use APIServerInternalIPs instead.
     */
    @JsonProperty("apiServerInternalIP")
    public void setApiServerInternalIP(String apiServerInternalIP) {
        this.apiServerInternalIP = apiServerInternalIP;
    }

    /**
     * apiServerInternalIPs are the IP addresses to contact the Kubernetes API server that can be used by components inside the cluster, like kubelets using the infrastructure rather than Kubernetes networking. These are the IPs for a self-hosted load balancer in front of the API servers. In dual stack clusters this list contains two IPs otherwise only one.
     */
    @JsonProperty("apiServerInternalIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getApiServerInternalIPs() {
        return apiServerInternalIPs;
    }

    /**
     * apiServerInternalIPs are the IP addresses to contact the Kubernetes API server that can be used by components inside the cluster, like kubelets using the infrastructure rather than Kubernetes networking. These are the IPs for a self-hosted load balancer in front of the API servers. In dual stack clusters this list contains two IPs otherwise only one.
     */
    @JsonProperty("apiServerInternalIPs")
    public void setApiServerInternalIPs(List<String> apiServerInternalIPs) {
        this.apiServerInternalIPs = apiServerInternalIPs;
    }

    /**
     * ingressIP is an external IP which routes to the default ingress controller. The IP is a suitable target of a wildcard DNS record used to resolve default route host names.<br><p> <br><p> Deprecated: Use IngressIPs instead.
     */
    @JsonProperty("ingressIP")
    public String getIngressIP() {
        return ingressIP;
    }

    /**
     * ingressIP is an external IP which routes to the default ingress controller. The IP is a suitable target of a wildcard DNS record used to resolve default route host names.<br><p> <br><p> Deprecated: Use IngressIPs instead.
     */
    @JsonProperty("ingressIP")
    public void setIngressIP(String ingressIP) {
        this.ingressIP = ingressIP;
    }

    /**
     * ingressIPs are the external IPs which route to the default ingress controller. The IPs are suitable targets of a wildcard DNS record used to resolve default route host names. In dual stack clusters this list contains two IPs otherwise only one.
     */
    @JsonProperty("ingressIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIngressIPs() {
        return ingressIPs;
    }

    /**
     * ingressIPs are the external IPs which route to the default ingress controller. The IPs are suitable targets of a wildcard DNS record used to resolve default route host names. In dual stack clusters this list contains two IPs otherwise only one.
     */
    @JsonProperty("ingressIPs")
    public void setIngressIPs(List<String> ingressIPs) {
        this.ingressIPs = ingressIPs;
    }

    /**
     * BareMetalPlatformStatus holds the current status of the BareMetal infrastructure provider. For more information about the network architecture used with the BareMetal platform type, see: https://github.com/openshift/installer/blob/master/docs/design/baremetal/networking-infrastructure.md
     */
    @JsonProperty("loadBalancer")
    public BareMetalPlatformLoadBalancer getLoadBalancer() {
        return loadBalancer;
    }

    /**
     * BareMetalPlatformStatus holds the current status of the BareMetal infrastructure provider. For more information about the network architecture used with the BareMetal platform type, see: https://github.com/openshift/installer/blob/master/docs/design/baremetal/networking-infrastructure.md
     */
    @JsonProperty("loadBalancer")
    public void setLoadBalancer(BareMetalPlatformLoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    /**
     * machineNetworks are IP networks used to connect all the OpenShift cluster nodes.
     */
    @JsonProperty("machineNetworks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMachineNetworks() {
        return machineNetworks;
    }

    /**
     * machineNetworks are IP networks used to connect all the OpenShift cluster nodes.
     */
    @JsonProperty("machineNetworks")
    public void setMachineNetworks(List<String> machineNetworks) {
        this.machineNetworks = machineNetworks;
    }

    /**
     * nodeDNSIP is the IP address for the internal DNS used by the nodes. Unlike the one managed by the DNS operator, `NodeDNSIP` provides name resolution for the nodes themselves. There is no DNS-as-a-service for BareMetal deployments. In order to minimize necessary changes to the datacenter DNS, a DNS service is hosted as a static pod to serve those hostnames to the nodes in the cluster.
     */
    @JsonProperty("nodeDNSIP")
    public String getNodeDNSIP() {
        return nodeDNSIP;
    }

    /**
     * nodeDNSIP is the IP address for the internal DNS used by the nodes. Unlike the one managed by the DNS operator, `NodeDNSIP` provides name resolution for the nodes themselves. There is no DNS-as-a-service for BareMetal deployments. In order to minimize necessary changes to the datacenter DNS, a DNS service is hosted as a static pod to serve those hostnames to the nodes in the cluster.
     */
    @JsonProperty("nodeDNSIP")
    public void setNodeDNSIP(String nodeDNSIP) {
        this.nodeDNSIP = nodeDNSIP;
    }

    @JsonIgnore
    public BareMetalPlatformStatusBuilder edit() {
        return new BareMetalPlatformStatusBuilder(this);
    }

    @JsonIgnore
    public BareMetalPlatformStatusBuilder toBuilder() {
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
