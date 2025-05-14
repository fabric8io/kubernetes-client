
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
 * CloudLoadBalancerIPs contains the Load Balancer IPs for the cloud's API, API-Int and Ingress Load balancers. They will be populated as soon as the respective Load Balancers have been configured. These values are utilized to configure the DNS solution hosted within the cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiIntLoadBalancerIPs",
    "apiLoadBalancerIPs",
    "ingressLoadBalancerIPs"
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

}
