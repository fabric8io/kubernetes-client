
package io.fabric8.openshift.api.model.operator.v1;

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
 * AWSNetworkLoadBalancerParameters holds configuration parameters for an AWS Network load balancer. For Example: Setting AWS EIPs https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/elastic-ip-addresses-eip.html
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "eipAllocations",
    "subnets"
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
public class AWSNetworkLoadBalancerParameters implements Editable<AWSNetworkLoadBalancerParametersBuilder>, KubernetesResource
{

    @JsonProperty("eipAllocations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> eipAllocations = new ArrayList<>();
    @JsonProperty("subnets")
    private AWSSubnets subnets;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSNetworkLoadBalancerParameters() {
    }

    public AWSNetworkLoadBalancerParameters(List<String> eipAllocations, AWSSubnets subnets) {
        super();
        this.eipAllocations = eipAllocations;
        this.subnets = subnets;
    }

    /**
     * eipAllocations is a list of IDs for Elastic IP (EIP) addresses that are assigned to the Network Load Balancer. The following restrictions apply:<br><p> <br><p> eipAllocations can only be used with external scope, not internal. An EIP can be allocated to only a single IngressController. The number of EIP allocations must match the number of subnets that are used for the load balancer. Each EIP allocation must be unique. A maximum of 10 EIP allocations are permitted.<br><p> <br><p> See https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/elastic-ip-addresses-eip.html for general information about configuration, characteristics, and limitations of Elastic IP addresses.
     */
    @JsonProperty("eipAllocations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEipAllocations() {
        return eipAllocations;
    }

    /**
     * eipAllocations is a list of IDs for Elastic IP (EIP) addresses that are assigned to the Network Load Balancer. The following restrictions apply:<br><p> <br><p> eipAllocations can only be used with external scope, not internal. An EIP can be allocated to only a single IngressController. The number of EIP allocations must match the number of subnets that are used for the load balancer. Each EIP allocation must be unique. A maximum of 10 EIP allocations are permitted.<br><p> <br><p> See https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/elastic-ip-addresses-eip.html for general information about configuration, characteristics, and limitations of Elastic IP addresses.
     */
    @JsonProperty("eipAllocations")
    public void setEipAllocations(List<String> eipAllocations) {
        this.eipAllocations = eipAllocations;
    }

    /**
     * AWSNetworkLoadBalancerParameters holds configuration parameters for an AWS Network load balancer. For Example: Setting AWS EIPs https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/elastic-ip-addresses-eip.html
     */
    @JsonProperty("subnets")
    public AWSSubnets getSubnets() {
        return subnets;
    }

    /**
     * AWSNetworkLoadBalancerParameters holds configuration parameters for an AWS Network load balancer. For Example: Setting AWS EIPs https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/elastic-ip-addresses-eip.html
     */
    @JsonProperty("subnets")
    public void setSubnets(AWSSubnets subnets) {
        this.subnets = subnets;
    }

    @JsonIgnore
    public AWSNetworkLoadBalancerParametersBuilder edit() {
        return new AWSNetworkLoadBalancerParametersBuilder(this);
    }

    @JsonIgnore
    public AWSNetworkLoadBalancerParametersBuilder toBuilder() {
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
