
package io.fabric8.istio.api.api.networking.v1alpha3;

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
 * Describes how traffic originating in the 'from' zone or sub-zone is distributed over a set of 'to' zones. Syntax for specifying a zone is {region}/{zone}/{sub-zone} and terminal wildcards are allowed on any segment of the specification. Examples:<br><p> <br><p> `&#42;` - matches all localities<br><p> <br><p> `us-west/&#42;` - all zones and sub-zones within the us-west region<br><p> <br><p> `us-west/zone-1/&#42;` - all sub-zones within us-west/zone-1
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "from",
    "to"
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
public class LocalityLoadBalancerSettingDistribute implements Editable<LocalityLoadBalancerSettingDistributeBuilder>, KubernetesResource
{

    @JsonProperty("from")
    private String from;
    @JsonProperty("to")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Long> to = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LocalityLoadBalancerSettingDistribute() {
    }

    public LocalityLoadBalancerSettingDistribute(String from, Map<String, Long> to) {
        super();
        this.from = from;
        this.to = to;
    }

    /**
     * Originating locality, '/' separated, e.g. 'region/zone/sub_zone'.
     */
    @JsonProperty("from")
    public String getFrom() {
        return from;
    }

    /**
     * Originating locality, '/' separated, e.g. 'region/zone/sub_zone'.
     */
    @JsonProperty("from")
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Map of upstream localities to traffic distribution weights. The sum of all weights should be 100. Any locality not present will receive no traffic.
     */
    @JsonProperty("to")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Long> getTo() {
        return to;
    }

    /**
     * Map of upstream localities to traffic distribution weights. The sum of all weights should be 100. Any locality not present will receive no traffic.
     */
    @JsonProperty("to")
    public void setTo(Map<String, Long> to) {
        this.to = to;
    }

    @JsonIgnore
    public LocalityLoadBalancerSettingDistributeBuilder edit() {
        return new LocalityLoadBalancerSettingDistributeBuilder(this);
    }

    @JsonIgnore
    public LocalityLoadBalancerSettingDistributeBuilder toBuilder() {
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
        if (!(o instanceof LocalityLoadBalancerSettingDistribute)) {
            return false;
        }
        LocalityLoadBalancerSettingDistribute other = (LocalityLoadBalancerSettingDistribute) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$from = this.getFrom();
        Object other$from = other.getFrom();
        if (this$from == null ? other$from != null : !this$from.equals(other$from)) {
            return false;
        }
        Object this$to = this.getTo();
        Object other$to = other.getTo();
        if (this$to == null ? other$to != null : !this$to.equals(other$to)) {
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
        return other instanceof LocalityLoadBalancerSettingDistribute;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $from = this.getFrom();
        result = result * prime + ($from == null ? 43 : $from.hashCode());
        Object $to = this.getTo();
        result = result * prime + ($to == null ? 43 : $to.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "LocalityLoadBalancerSettingDistribute(" + "from=" + this.getFrom() + ", to=" + this.getTo() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
