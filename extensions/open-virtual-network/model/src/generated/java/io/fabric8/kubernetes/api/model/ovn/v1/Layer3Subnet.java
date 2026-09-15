
package io.fabric8.kubernetes.api.model.ovn.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cidr",
    "hostSubnet"
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
public class Layer3Subnet implements Editable<Layer3SubnetBuilder>, KubernetesResource
{

    @JsonProperty("cidr")
    private String cidr;
    @JsonProperty("hostSubnet")
    private Integer hostSubnet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Layer3Subnet() {
    }

    public Layer3Subnet(String cidr, Integer hostSubnet) {
        super();
        this.cidr = cidr;
        this.hostSubnet = hostSubnet;
    }

    /**
     * CIDR specifies L3Subnet, which is split into smaller subnets for every node.
     */
    @JsonProperty("cidr")
    public String getCidr() {
        return cidr;
    }

    /**
     * CIDR specifies L3Subnet, which is split into smaller subnets for every node.
     */
    @JsonProperty("cidr")
    public void setCidr(String cidr) {
        this.cidr = cidr;
    }

    /**
     * HostSubnet specifies the subnet size for every node.<br><p> <br><p> When not set, it will be assigned automatically.
     */
    @JsonProperty("hostSubnet")
    public Integer getHostSubnet() {
        return hostSubnet;
    }

    /**
     * HostSubnet specifies the subnet size for every node.<br><p> <br><p> When not set, it will be assigned automatically.
     */
    @JsonProperty("hostSubnet")
    public void setHostSubnet(Integer hostSubnet) {
        this.hostSubnet = hostSubnet;
    }

    @JsonIgnore
    public Layer3SubnetBuilder edit() {
        return new Layer3SubnetBuilder(this);
    }

    @JsonIgnore
    public Layer3SubnetBuilder toBuilder() {
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
        if (!(o instanceof Layer3Subnet)) {
            return false;
        }
        Layer3Subnet other = (Layer3Subnet) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cidr = this.getCidr();
        Object other$cidr = other.getCidr();
        if (this$cidr == null ? other$cidr != null : !this$cidr.equals(other$cidr)) {
            return false;
        }
        Object this$hostSubnet = this.getHostSubnet();
        Object other$hostSubnet = other.getHostSubnet();
        if (this$hostSubnet == null ? other$hostSubnet != null : !this$hostSubnet.equals(other$hostSubnet)) {
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
        return other instanceof Layer3Subnet;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cidr = this.getCidr();
        result = result * prime + ($cidr == null ? 43 : $cidr.hashCode());
        Object $hostSubnet = this.getHostSubnet();
        result = result * prime + ($hostSubnet == null ? 43 : $hostSubnet.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Layer3Subnet(" + "cidr=" + this.getCidr() + ", hostSubnet=" + this.getHostSubnet() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
