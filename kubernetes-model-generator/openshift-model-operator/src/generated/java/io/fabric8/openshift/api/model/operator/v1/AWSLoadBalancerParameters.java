
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
 * AWSLoadBalancerParameters provides configuration settings that are specific to AWS load balancers.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "classicLoadBalancer",
    "networkLoadBalancer",
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
public class AWSLoadBalancerParameters implements Editable<AWSLoadBalancerParametersBuilder>, KubernetesResource
{

    @JsonProperty("classicLoadBalancer")
    private AWSClassicLoadBalancerParameters classicLoadBalancer;
    @JsonProperty("networkLoadBalancer")
    private AWSNetworkLoadBalancerParameters networkLoadBalancer;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSLoadBalancerParameters() {
    }

    public AWSLoadBalancerParameters(AWSClassicLoadBalancerParameters classicLoadBalancer, AWSNetworkLoadBalancerParameters networkLoadBalancer, String type) {
        super();
        this.classicLoadBalancer = classicLoadBalancer;
        this.networkLoadBalancer = networkLoadBalancer;
        this.type = type;
    }

    /**
     * AWSLoadBalancerParameters provides configuration settings that are specific to AWS load balancers.
     */
    @JsonProperty("classicLoadBalancer")
    public AWSClassicLoadBalancerParameters getClassicLoadBalancer() {
        return classicLoadBalancer;
    }

    /**
     * AWSLoadBalancerParameters provides configuration settings that are specific to AWS load balancers.
     */
    @JsonProperty("classicLoadBalancer")
    public void setClassicLoadBalancer(AWSClassicLoadBalancerParameters classicLoadBalancer) {
        this.classicLoadBalancer = classicLoadBalancer;
    }

    /**
     * AWSLoadBalancerParameters provides configuration settings that are specific to AWS load balancers.
     */
    @JsonProperty("networkLoadBalancer")
    public AWSNetworkLoadBalancerParameters getNetworkLoadBalancer() {
        return networkLoadBalancer;
    }

    /**
     * AWSLoadBalancerParameters provides configuration settings that are specific to AWS load balancers.
     */
    @JsonProperty("networkLoadBalancer")
    public void setNetworkLoadBalancer(AWSNetworkLoadBalancerParameters networkLoadBalancer) {
        this.networkLoadBalancer = networkLoadBalancer;
    }

    /**
     * type is the type of AWS load balancer to instantiate for an ingresscontroller.<br><p> <br><p> Valid values are:<br><p> <br><p> &#42; "Classic": A Classic Load Balancer that makes routing decisions at either<br><p>   the transport layer (TCP/SSL) or the application layer (HTTP/HTTPS). See<br><p>   the following for additional details:<br><p> <br><p>     https://docs.aws.amazon.com/AmazonECS/latest/developerguide/load-balancer-types.html#clb<br><p> <br><p> &#42; "NLB": A Network Load Balancer that makes routing decisions at the<br><p>   transport layer (TCP/SSL). See the following for additional details:<br><p> <br><p>     https://docs.aws.amazon.com/AmazonECS/latest/developerguide/load-balancer-types.html#nlb
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is the type of AWS load balancer to instantiate for an ingresscontroller.<br><p> <br><p> Valid values are:<br><p> <br><p> &#42; "Classic": A Classic Load Balancer that makes routing decisions at either<br><p>   the transport layer (TCP/SSL) or the application layer (HTTP/HTTPS). See<br><p>   the following for additional details:<br><p> <br><p>     https://docs.aws.amazon.com/AmazonECS/latest/developerguide/load-balancer-types.html#clb<br><p> <br><p> &#42; "NLB": A Network Load Balancer that makes routing decisions at the<br><p>   transport layer (TCP/SSL). See the following for additional details:<br><p> <br><p>     https://docs.aws.amazon.com/AmazonECS/latest/developerguide/load-balancer-types.html#nlb
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public AWSLoadBalancerParametersBuilder edit() {
        return new AWSLoadBalancerParametersBuilder(this);
    }

    @JsonIgnore
    public AWSLoadBalancerParametersBuilder toBuilder() {
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
