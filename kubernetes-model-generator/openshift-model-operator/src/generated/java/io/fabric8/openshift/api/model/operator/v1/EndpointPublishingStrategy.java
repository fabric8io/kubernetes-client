
package io.fabric8.openshift.api.model.operator.v1;

import java.util.LinkedHashMap;
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
 * EndpointPublishingStrategy is a way to publish the endpoints of an IngressController, and represents the type and any additional configuration for a specific type.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hostNetwork",
    "loadBalancer",
    "nodePort",
    "private",
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
public class EndpointPublishingStrategy implements Editable<EndpointPublishingStrategyBuilder>, KubernetesResource
{

    @JsonProperty("hostNetwork")
    private HostNetworkStrategy hostNetwork;
    @JsonProperty("loadBalancer")
    private LoadBalancerStrategy loadBalancer;
    @JsonProperty("nodePort")
    private NodePortStrategy nodePort;
    @JsonProperty("private")
    private PrivateStrategy _private;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EndpointPublishingStrategy() {
    }

    public EndpointPublishingStrategy(HostNetworkStrategy hostNetwork, LoadBalancerStrategy loadBalancer, NodePortStrategy nodePort, PrivateStrategy _private, String type) {
        super();
        this.hostNetwork = hostNetwork;
        this.loadBalancer = loadBalancer;
        this.nodePort = nodePort;
        this._private = _private;
        this.type = type;
    }

    /**
     * EndpointPublishingStrategy is a way to publish the endpoints of an IngressController, and represents the type and any additional configuration for a specific type.
     */
    @JsonProperty("hostNetwork")
    public HostNetworkStrategy getHostNetwork() {
        return hostNetwork;
    }

    /**
     * EndpointPublishingStrategy is a way to publish the endpoints of an IngressController, and represents the type and any additional configuration for a specific type.
     */
    @JsonProperty("hostNetwork")
    public void setHostNetwork(HostNetworkStrategy hostNetwork) {
        this.hostNetwork = hostNetwork;
    }

    /**
     * EndpointPublishingStrategy is a way to publish the endpoints of an IngressController, and represents the type and any additional configuration for a specific type.
     */
    @JsonProperty("loadBalancer")
    public LoadBalancerStrategy getLoadBalancer() {
        return loadBalancer;
    }

    /**
     * EndpointPublishingStrategy is a way to publish the endpoints of an IngressController, and represents the type and any additional configuration for a specific type.
     */
    @JsonProperty("loadBalancer")
    public void setLoadBalancer(LoadBalancerStrategy loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    /**
     * EndpointPublishingStrategy is a way to publish the endpoints of an IngressController, and represents the type and any additional configuration for a specific type.
     */
    @JsonProperty("nodePort")
    public NodePortStrategy getNodePort() {
        return nodePort;
    }

    /**
     * EndpointPublishingStrategy is a way to publish the endpoints of an IngressController, and represents the type and any additional configuration for a specific type.
     */
    @JsonProperty("nodePort")
    public void setNodePort(NodePortStrategy nodePort) {
        this.nodePort = nodePort;
    }

    /**
     * EndpointPublishingStrategy is a way to publish the endpoints of an IngressController, and represents the type and any additional configuration for a specific type.
     */
    @JsonProperty("private")
    public PrivateStrategy getPrivate() {
        return _private;
    }

    /**
     * EndpointPublishingStrategy is a way to publish the endpoints of an IngressController, and represents the type and any additional configuration for a specific type.
     */
    @JsonProperty("private")
    public void setPrivate(PrivateStrategy _private) {
        this._private = _private;
    }

    /**
     * type is the publishing strategy to use. Valid values are:<br><p> <br><p> &#42; LoadBalancerService<br><p> <br><p> Publishes the ingress controller using a Kubernetes LoadBalancer Service.<br><p> <br><p> In this configuration, the ingress controller deployment uses container networking. A LoadBalancer Service is created to publish the deployment.<br><p> <br><p> See: https://kubernetes.io/docs/concepts/services-networking/service/#loadbalancer<br><p> <br><p> If domain is set, a wildcard DNS record will be managed to point at the LoadBalancer Service's external name. DNS records are managed only in DNS zones defined by dns.config.openshift.io/cluster .spec.publicZone and .spec.privateZone.<br><p> <br><p> Wildcard DNS management is currently supported only on the AWS, Azure, and GCP platforms.<br><p> <br><p> &#42; HostNetwork<br><p> <br><p> Publishes the ingress controller on node ports where the ingress controller is deployed.<br><p> <br><p> In this configuration, the ingress controller deployment uses host networking, bound to node ports 80 and 443. The user is responsible for configuring an external load balancer to publish the ingress controller via the node ports.<br><p> <br><p> &#42; Private<br><p> <br><p> Does not publish the ingress controller.<br><p> <br><p> In this configuration, the ingress controller deployment uses container networking, and is not explicitly published. The user must manually publish the ingress controller.<br><p> <br><p> &#42; NodePortService<br><p> <br><p> Publishes the ingress controller using a Kubernetes NodePort Service.<br><p> <br><p> In this configuration, the ingress controller deployment uses container networking. A NodePort Service is created to publish the deployment. The specific node ports are dynamically allocated by OpenShift; however, to support static port allocations, user changes to the node port field of the managed NodePort Service will preserved.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is the publishing strategy to use. Valid values are:<br><p> <br><p> &#42; LoadBalancerService<br><p> <br><p> Publishes the ingress controller using a Kubernetes LoadBalancer Service.<br><p> <br><p> In this configuration, the ingress controller deployment uses container networking. A LoadBalancer Service is created to publish the deployment.<br><p> <br><p> See: https://kubernetes.io/docs/concepts/services-networking/service/#loadbalancer<br><p> <br><p> If domain is set, a wildcard DNS record will be managed to point at the LoadBalancer Service's external name. DNS records are managed only in DNS zones defined by dns.config.openshift.io/cluster .spec.publicZone and .spec.privateZone.<br><p> <br><p> Wildcard DNS management is currently supported only on the AWS, Azure, and GCP platforms.<br><p> <br><p> &#42; HostNetwork<br><p> <br><p> Publishes the ingress controller on node ports where the ingress controller is deployed.<br><p> <br><p> In this configuration, the ingress controller deployment uses host networking, bound to node ports 80 and 443. The user is responsible for configuring an external load balancer to publish the ingress controller via the node ports.<br><p> <br><p> &#42; Private<br><p> <br><p> Does not publish the ingress controller.<br><p> <br><p> In this configuration, the ingress controller deployment uses container networking, and is not explicitly published. The user must manually publish the ingress controller.<br><p> <br><p> &#42; NodePortService<br><p> <br><p> Publishes the ingress controller using a Kubernetes NodePort Service.<br><p> <br><p> In this configuration, the ingress controller deployment uses container networking. A NodePort Service is created to publish the deployment. The specific node ports are dynamically allocated by OpenShift; however, to support static port allocations, user changes to the node port field of the managed NodePort Service will preserved.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public EndpointPublishingStrategyBuilder edit() {
        return new EndpointPublishingStrategyBuilder(this);
    }

    @JsonIgnore
    public EndpointPublishingStrategyBuilder toBuilder() {
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
