
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

/**
 * StaticHop defines the configuration of a static IP that acts as an external Gateway Interface. IP field is mandatory.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bfdEnabled",
    "ip"
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
public class StaticHop implements Editable<StaticHopBuilder>, KubernetesResource
{

    @JsonProperty("bfdEnabled")
    private Boolean bfdEnabled;
    @JsonProperty("ip")
    private String ip;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StaticHop() {
    }

    public StaticHop(Boolean bfdEnabled, String ip) {
        super();
        this.bfdEnabled = bfdEnabled;
        this.ip = ip;
    }

    /**
     * BFDEnabled determines if the interface implements the Bidirectional Forward Detection protocol. Defaults to false.
     */
    @JsonProperty("bfdEnabled")
    public Boolean getBfdEnabled() {
        return bfdEnabled;
    }

    /**
     * BFDEnabled determines if the interface implements the Bidirectional Forward Detection protocol. Defaults to false.
     */
    @JsonProperty("bfdEnabled")
    public void setBfdEnabled(Boolean bfdEnabled) {
        this.bfdEnabled = bfdEnabled;
    }

    /**
     * IP defines the static IP to be used for egress traffic. The IP can be either IPv4 or IPv6.
     */
    @JsonProperty("ip")
    public String getIp() {
        return ip;
    }

    /**
     * IP defines the static IP to be used for egress traffic. The IP can be either IPv4 or IPv6.
     */
    @JsonProperty("ip")
    public void setIp(String ip) {
        this.ip = ip;
    }

    @JsonIgnore
    public StaticHopBuilder edit() {
        return new StaticHopBuilder(this);
    }

    @JsonIgnore
    public StaticHopBuilder toBuilder() {
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
        if (!(o instanceof StaticHop)) {
            return false;
        }
        StaticHop other = (StaticHop) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$bfdEnabled = this.getBfdEnabled();
        Object other$bfdEnabled = other.getBfdEnabled();
        if (this$bfdEnabled == null ? other$bfdEnabled != null : !this$bfdEnabled.equals(other$bfdEnabled)) {
            return false;
        }
        Object this$ip = this.getIp();
        Object other$ip = other.getIp();
        if (this$ip == null ? other$ip != null : !this$ip.equals(other$ip)) {
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
        return other instanceof StaticHop;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bfdEnabled = this.getBfdEnabled();
        result = result * prime + ($bfdEnabled == null ? 43 : $bfdEnabled.hashCode());
        Object $ip = this.getIp();
        result = result * prime + ($ip == null ? 43 : $ip.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "StaticHop(" + "bfdEnabled=" + this.getBfdEnabled() + ", ip=" + this.getIp() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
