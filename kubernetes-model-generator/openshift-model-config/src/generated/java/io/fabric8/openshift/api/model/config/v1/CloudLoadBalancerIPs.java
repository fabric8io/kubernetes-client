
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
 * CloudLoadBalancerIPs contains the Load Balancer IPs for the cloud's API, API-Int and Ingress Load balancers. They will be populated as soon as the respective Load Balancers have been configured. These values are utilized to configure the DNS solution hosted within the cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiIntLoadBalancerIPs",
    "apiLoadBalancerIPs",
    "ingressLoadBalancerIPs"
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
public class CloudLoadBalancerIPs implements Editable<CloudLoadBalancerIPsBuilder>, KubernetesResource
{

    @JsonProperty("apiIntLoadBalancerIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> apiIntLoadBalancerIPs = new ArrayList<>();
    @JsonProperty("apiLoadBalancerIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> apiLoadBalancerIPs = new ArrayList<>();
    @JsonProperty("ingressLoadBalancerIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ingressLoadBalancerIPs = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CloudLoadBalancerIPs() {
    }

    public CloudLoadBalancerIPs(List<String> apiIntLoadBalancerIPs, List<String> apiLoadBalancerIPs, List<String> ingressLoadBalancerIPs) {
        super();
        this.apiIntLoadBalancerIPs = apiIntLoadBalancerIPs;
        this.apiLoadBalancerIPs = apiLoadBalancerIPs;
        this.ingressLoadBalancerIPs = ingressLoadBalancerIPs;
    }

    /**
     * apiIntLoadBalancerIPs holds Load Balancer IPs for the internal API service. These Load Balancer IP addresses can be IPv4 and/or IPv6 addresses. Entries in the apiIntLoadBalancerIPs must be unique. A maximum of 16 IP addresses are permitted.
     */
    @JsonProperty("apiIntLoadBalancerIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getApiIntLoadBalancerIPs() {
        return apiIntLoadBalancerIPs;
    }

    /**
     * apiIntLoadBalancerIPs holds Load Balancer IPs for the internal API service. These Load Balancer IP addresses can be IPv4 and/or IPv6 addresses. Entries in the apiIntLoadBalancerIPs must be unique. A maximum of 16 IP addresses are permitted.
     */
    @JsonProperty("apiIntLoadBalancerIPs")
    public void setApiIntLoadBalancerIPs(List<String> apiIntLoadBalancerIPs) {
        this.apiIntLoadBalancerIPs = apiIntLoadBalancerIPs;
    }

    /**
     * apiLoadBalancerIPs holds Load Balancer IPs for the API service. These Load Balancer IP addresses can be IPv4 and/or IPv6 addresses. Could be empty for private clusters. Entries in the apiLoadBalancerIPs must be unique. A maximum of 16 IP addresses are permitted.
     */
    @JsonProperty("apiLoadBalancerIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getApiLoadBalancerIPs() {
        return apiLoadBalancerIPs;
    }

    /**
     * apiLoadBalancerIPs holds Load Balancer IPs for the API service. These Load Balancer IP addresses can be IPv4 and/or IPv6 addresses. Could be empty for private clusters. Entries in the apiLoadBalancerIPs must be unique. A maximum of 16 IP addresses are permitted.
     */
    @JsonProperty("apiLoadBalancerIPs")
    public void setApiLoadBalancerIPs(List<String> apiLoadBalancerIPs) {
        this.apiLoadBalancerIPs = apiLoadBalancerIPs;
    }

    /**
     * ingressLoadBalancerIPs holds IPs for Ingress Load Balancers. These Load Balancer IP addresses can be IPv4 and/or IPv6 addresses. Entries in the ingressLoadBalancerIPs must be unique. A maximum of 16 IP addresses are permitted.
     */
    @JsonProperty("ingressLoadBalancerIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIngressLoadBalancerIPs() {
        return ingressLoadBalancerIPs;
    }

    /**
     * ingressLoadBalancerIPs holds IPs for Ingress Load Balancers. These Load Balancer IP addresses can be IPv4 and/or IPv6 addresses. Entries in the ingressLoadBalancerIPs must be unique. A maximum of 16 IP addresses are permitted.
     */
    @JsonProperty("ingressLoadBalancerIPs")
    public void setIngressLoadBalancerIPs(List<String> ingressLoadBalancerIPs) {
        this.ingressLoadBalancerIPs = ingressLoadBalancerIPs;
    }

    @JsonIgnore
    public CloudLoadBalancerIPsBuilder edit() {
        return new CloudLoadBalancerIPsBuilder(this);
    }

    @JsonIgnore
    public CloudLoadBalancerIPsBuilder toBuilder() {
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
        if (!(o instanceof CloudLoadBalancerIPs)) {
            return false;
        }
        CloudLoadBalancerIPs other = (CloudLoadBalancerIPs) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiIntLoadBalancerIPs = this.getApiIntLoadBalancerIPs();
        Object other$apiIntLoadBalancerIPs = other.getApiIntLoadBalancerIPs();
        if (this$apiIntLoadBalancerIPs == null ? other$apiIntLoadBalancerIPs != null : !this$apiIntLoadBalancerIPs.equals(other$apiIntLoadBalancerIPs)) {
            return false;
        }
        Object this$apiLoadBalancerIPs = this.getApiLoadBalancerIPs();
        Object other$apiLoadBalancerIPs = other.getApiLoadBalancerIPs();
        if (this$apiLoadBalancerIPs == null ? other$apiLoadBalancerIPs != null : !this$apiLoadBalancerIPs.equals(other$apiLoadBalancerIPs)) {
            return false;
        }
        Object this$ingressLoadBalancerIPs = this.getIngressLoadBalancerIPs();
        Object other$ingressLoadBalancerIPs = other.getIngressLoadBalancerIPs();
        if (this$ingressLoadBalancerIPs == null ? other$ingressLoadBalancerIPs != null : !this$ingressLoadBalancerIPs.equals(other$ingressLoadBalancerIPs)) {
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
        return other instanceof CloudLoadBalancerIPs;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiIntLoadBalancerIPs = this.getApiIntLoadBalancerIPs();
        result = result * prime + ($apiIntLoadBalancerIPs == null ? 43 : $apiIntLoadBalancerIPs.hashCode());
        Object $apiLoadBalancerIPs = this.getApiLoadBalancerIPs();
        result = result * prime + ($apiLoadBalancerIPs == null ? 43 : $apiLoadBalancerIPs.hashCode());
        Object $ingressLoadBalancerIPs = this.getIngressLoadBalancerIPs();
        result = result * prime + ($ingressLoadBalancerIPs == null ? 43 : $ingressLoadBalancerIPs.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CloudLoadBalancerIPs(" + "apiIntLoadBalancerIPs=" + this.getApiIntLoadBalancerIPs() + ", apiLoadBalancerIPs=" + this.getApiLoadBalancerIPs() + ", ingressLoadBalancerIPs=" + this.getIngressLoadBalancerIPs() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
