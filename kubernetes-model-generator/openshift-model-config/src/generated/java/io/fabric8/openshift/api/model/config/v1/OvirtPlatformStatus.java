
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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * OvirtPlatformStatus holds the current status of the  oVirt infrastructure provider.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiServerInternalIP",
    "apiServerInternalIPs",
    "ingressIP",
    "ingressIPs",
    "loadBalancer",
    "nodeDNSIP"
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
public class OvirtPlatformStatus implements Editable<OvirtPlatformStatusBuilder>, KubernetesResource
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
    private OvirtPlatformLoadBalancer loadBalancer;
    @JsonProperty("nodeDNSIP")
    private String nodeDNSIP;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OvirtPlatformStatus() {
    }

    public OvirtPlatformStatus(String apiServerInternalIP, List<String> apiServerInternalIPs, String ingressIP, List<String> ingressIPs, OvirtPlatformLoadBalancer loadBalancer, String nodeDNSIP) {
        super();
        this.apiServerInternalIP = apiServerInternalIP;
        this.apiServerInternalIPs = apiServerInternalIPs;
        this.ingressIP = ingressIP;
        this.ingressIPs = ingressIPs;
        this.loadBalancer = loadBalancer;
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
     * OvirtPlatformStatus holds the current status of the  oVirt infrastructure provider.
     */
    @JsonProperty("loadBalancer")
    public OvirtPlatformLoadBalancer getLoadBalancer() {
        return loadBalancer;
    }

    /**
     * OvirtPlatformStatus holds the current status of the  oVirt infrastructure provider.
     */
    @JsonProperty("loadBalancer")
    public void setLoadBalancer(OvirtPlatformLoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    /**
     * deprecated: as of 4.6, this field is no longer set or honored.  It will be removed in a future release.
     */
    @JsonProperty("nodeDNSIP")
    public String getNodeDNSIP() {
        return nodeDNSIP;
    }

    /**
     * deprecated: as of 4.6, this field is no longer set or honored.  It will be removed in a future release.
     */
    @JsonProperty("nodeDNSIP")
    public void setNodeDNSIP(String nodeDNSIP) {
        this.nodeDNSIP = nodeDNSIP;
    }

    @JsonIgnore
    public OvirtPlatformStatusBuilder edit() {
        return new OvirtPlatformStatusBuilder(this);
    }

    @JsonIgnore
    public OvirtPlatformStatusBuilder toBuilder() {
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
        if (!(o instanceof OvirtPlatformStatus)) {
            return false;
        }
        OvirtPlatformStatus other = (OvirtPlatformStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiServerInternalIP = this.getApiServerInternalIP();
        Object other$apiServerInternalIP = other.getApiServerInternalIP();
        if (this$apiServerInternalIP == null ? other$apiServerInternalIP != null : !this$apiServerInternalIP.equals(other$apiServerInternalIP)) {
            return false;
        }
        Object this$apiServerInternalIPs = this.getApiServerInternalIPs();
        Object other$apiServerInternalIPs = other.getApiServerInternalIPs();
        if (this$apiServerInternalIPs == null ? other$apiServerInternalIPs != null : !this$apiServerInternalIPs.equals(other$apiServerInternalIPs)) {
            return false;
        }
        Object this$ingressIP = this.getIngressIP();
        Object other$ingressIP = other.getIngressIP();
        if (this$ingressIP == null ? other$ingressIP != null : !this$ingressIP.equals(other$ingressIP)) {
            return false;
        }
        Object this$ingressIPs = this.getIngressIPs();
        Object other$ingressIPs = other.getIngressIPs();
        if (this$ingressIPs == null ? other$ingressIPs != null : !this$ingressIPs.equals(other$ingressIPs)) {
            return false;
        }
        Object this$loadBalancer = this.getLoadBalancer();
        Object other$loadBalancer = other.getLoadBalancer();
        if (this$loadBalancer == null ? other$loadBalancer != null : !this$loadBalancer.equals(other$loadBalancer)) {
            return false;
        }
        Object this$nodeDNSIP = this.getNodeDNSIP();
        Object other$nodeDNSIP = other.getNodeDNSIP();
        if (this$nodeDNSIP == null ? other$nodeDNSIP != null : !this$nodeDNSIP.equals(other$nodeDNSIP)) {
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
        return other instanceof OvirtPlatformStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiServerInternalIP = this.getApiServerInternalIP();
        result = result * prime + ($apiServerInternalIP == null ? 43 : $apiServerInternalIP.hashCode());
        Object $apiServerInternalIPs = this.getApiServerInternalIPs();
        result = result * prime + ($apiServerInternalIPs == null ? 43 : $apiServerInternalIPs.hashCode());
        Object $ingressIP = this.getIngressIP();
        result = result * prime + ($ingressIP == null ? 43 : $ingressIP.hashCode());
        Object $ingressIPs = this.getIngressIPs();
        result = result * prime + ($ingressIPs == null ? 43 : $ingressIPs.hashCode());
        Object $loadBalancer = this.getLoadBalancer();
        result = result * prime + ($loadBalancer == null ? 43 : $loadBalancer.hashCode());
        Object $nodeDNSIP = this.getNodeDNSIP();
        result = result * prime + ($nodeDNSIP == null ? 43 : $nodeDNSIP.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OvirtPlatformStatus(" + "apiServerInternalIP=" + this.getApiServerInternalIP() + ", apiServerInternalIPs=" + this.getApiServerInternalIPs() + ", ingressIP=" + this.getIngressIP() + ", ingressIPs=" + this.getIngressIPs() + ", loadBalancer=" + this.getLoadBalancer() + ", nodeDNSIP=" + this.getNodeDNSIP() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
