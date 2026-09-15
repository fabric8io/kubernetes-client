
package io.fabric8.kubernetes.api.model.networking.v1;

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
 * IngressLoadBalancerStatus represents the status of a load-balancer.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ingress"
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
public class IngressLoadBalancerStatus implements Editable<IngressLoadBalancerStatusBuilder>, KubernetesResource
{

    @JsonProperty("ingress")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IngressLoadBalancerIngress> ingress = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IngressLoadBalancerStatus() {
    }

    public IngressLoadBalancerStatus(List<IngressLoadBalancerIngress> ingress) {
        super();
        this.ingress = ingress;
    }

    /**
     * ingress is a list containing ingress points for the load-balancer.
     */
    @JsonProperty("ingress")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IngressLoadBalancerIngress> getIngress() {
        return ingress;
    }

    /**
     * ingress is a list containing ingress points for the load-balancer.
     */
    @JsonProperty("ingress")
    public void setIngress(List<IngressLoadBalancerIngress> ingress) {
        this.ingress = ingress;
    }

    @JsonIgnore
    public IngressLoadBalancerStatusBuilder edit() {
        return new IngressLoadBalancerStatusBuilder(this);
    }

    @JsonIgnore
    public IngressLoadBalancerStatusBuilder toBuilder() {
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
        if (!(o instanceof IngressLoadBalancerStatus)) {
            return false;
        }
        IngressLoadBalancerStatus other = (IngressLoadBalancerStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ingress = this.getIngress();
        Object other$ingress = other.getIngress();
        if (this$ingress == null ? other$ingress != null : !this$ingress.equals(other$ingress)) {
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
        return other instanceof IngressLoadBalancerStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $ingress = this.getIngress();
        result = result * prime + ($ingress == null ? 43 : $ingress.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "IngressLoadBalancerStatus(" + "ingress=" + this.getIngress() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
