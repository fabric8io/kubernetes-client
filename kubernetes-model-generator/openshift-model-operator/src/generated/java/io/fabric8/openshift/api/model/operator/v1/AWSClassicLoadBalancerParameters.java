
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

/**
 * AWSClassicLoadBalancerParameters holds configuration parameters for an AWS Classic load balancer.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "connectionIdleTimeout",
    "subnets"
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
public class AWSClassicLoadBalancerParameters implements Editable<AWSClassicLoadBalancerParametersBuilder>, KubernetesResource
{

    @JsonProperty("connectionIdleTimeout")
    private String connectionIdleTimeout;
    @JsonProperty("subnets")
    private AWSSubnets subnets;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSClassicLoadBalancerParameters() {
    }

    public AWSClassicLoadBalancerParameters(String connectionIdleTimeout, AWSSubnets subnets) {
        super();
        this.connectionIdleTimeout = connectionIdleTimeout;
        this.subnets = subnets;
    }

    /**
     * AWSClassicLoadBalancerParameters holds configuration parameters for an AWS Classic load balancer.
     */
    @JsonProperty("connectionIdleTimeout")
    public String getConnectionIdleTimeout() {
        return connectionIdleTimeout;
    }

    /**
     * AWSClassicLoadBalancerParameters holds configuration parameters for an AWS Classic load balancer.
     */
    @JsonProperty("connectionIdleTimeout")
    public void setConnectionIdleTimeout(String connectionIdleTimeout) {
        this.connectionIdleTimeout = connectionIdleTimeout;
    }

    /**
     * AWSClassicLoadBalancerParameters holds configuration parameters for an AWS Classic load balancer.
     */
    @JsonProperty("subnets")
    public AWSSubnets getSubnets() {
        return subnets;
    }

    /**
     * AWSClassicLoadBalancerParameters holds configuration parameters for an AWS Classic load balancer.
     */
    @JsonProperty("subnets")
    public void setSubnets(AWSSubnets subnets) {
        this.subnets = subnets;
    }

    @JsonIgnore
    public AWSClassicLoadBalancerParametersBuilder edit() {
        return new AWSClassicLoadBalancerParametersBuilder(this);
    }

    @JsonIgnore
    public AWSClassicLoadBalancerParametersBuilder toBuilder() {
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
        if (!(o instanceof AWSClassicLoadBalancerParameters)) {
            return false;
        }
        AWSClassicLoadBalancerParameters other = (AWSClassicLoadBalancerParameters) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$connectionIdleTimeout = this.getConnectionIdleTimeout();
        Object other$connectionIdleTimeout = other.getConnectionIdleTimeout();
        if (this$connectionIdleTimeout == null ? other$connectionIdleTimeout != null : !this$connectionIdleTimeout.equals(other$connectionIdleTimeout)) {
            return false;
        }
        Object this$subnets = this.getSubnets();
        Object other$subnets = other.getSubnets();
        if (this$subnets == null ? other$subnets != null : !this$subnets.equals(other$subnets)) {
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
        return other instanceof AWSClassicLoadBalancerParameters;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $connectionIdleTimeout = this.getConnectionIdleTimeout();
        result = result * prime + ($connectionIdleTimeout == null ? 43 : $connectionIdleTimeout.hashCode());
        Object $subnets = this.getSubnets();
        result = result * prime + ($subnets == null ? 43 : $subnets.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AWSClassicLoadBalancerParameters(" + "connectionIdleTimeout=" + this.getConnectionIdleTimeout() + ", subnets=" + this.getSubnets() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
