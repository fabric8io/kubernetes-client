
package io.fabric8.chaosmesh.v1alpha1;

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
 * RawIptables represents the iptables rules on specific pod
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "device",
    "direction",
    "ipsets",
    "name",
    "source"
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
public class RawIptables implements Editable<RawIptablesBuilder>, KubernetesResource
{

    @JsonProperty("device")
    private String device;
    @JsonProperty("direction")
    private String direction;
    @JsonProperty("ipsets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ipsets = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("source")
    private String source;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RawIptables() {
    }

    public RawIptables(String device, String direction, List<String> ipsets, String name, String source) {
        super();
        this.device = device;
        this.direction = direction;
        this.ipsets = ipsets;
        this.name = name;
        this.source = source;
    }

    /**
     * Device represents the network device to be affected.
     */
    @JsonProperty("device")
    public String getDevice() {
        return device;
    }

    /**
     * Device represents the network device to be affected.
     */
    @JsonProperty("device")
    public void setDevice(String device) {
        this.device = device;
    }

    /**
     * The block direction of this iptables rule
     */
    @JsonProperty("direction")
    public String getDirection() {
        return direction;
    }

    /**
     * The block direction of this iptables rule
     */
    @JsonProperty("direction")
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * The name of related ipset
     */
    @JsonProperty("ipsets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIpsets() {
        return ipsets;
    }

    /**
     * The name of related ipset
     */
    @JsonProperty("ipsets")
    public void setIpsets(List<String> ipsets) {
        this.ipsets = ipsets;
    }

    /**
     * The name of iptables chain
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * The name of iptables chain
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * RawIptables represents the iptables rules on specific pod
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * RawIptables represents the iptables rules on specific pod
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonIgnore
    public RawIptablesBuilder edit() {
        return new RawIptablesBuilder(this);
    }

    @JsonIgnore
    public RawIptablesBuilder toBuilder() {
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
        if (!(o instanceof RawIptables)) {
            return false;
        }
        RawIptables other = (RawIptables) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$device = this.getDevice();
        Object other$device = other.getDevice();
        if (this$device == null ? other$device != null : !this$device.equals(other$device)) {
            return false;
        }
        Object this$direction = this.getDirection();
        Object other$direction = other.getDirection();
        if (this$direction == null ? other$direction != null : !this$direction.equals(other$direction)) {
            return false;
        }
        Object this$ipsets = this.getIpsets();
        Object other$ipsets = other.getIpsets();
        if (this$ipsets == null ? other$ipsets != null : !this$ipsets.equals(other$ipsets)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$source = this.getSource();
        Object other$source = other.getSource();
        if (this$source == null ? other$source != null : !this$source.equals(other$source)) {
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
        return other instanceof RawIptables;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $device = this.getDevice();
        result = result * prime + ($device == null ? 43 : $device.hashCode());
        Object $direction = this.getDirection();
        result = result * prime + ($direction == null ? 43 : $direction.hashCode());
        Object $ipsets = this.getIpsets();
        result = result * prime + ($ipsets == null ? 43 : $ipsets.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $source = this.getSource();
        result = result * prime + ($source == null ? 43 : $source.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RawIptables(" + "device=" + this.getDevice() + ", direction=" + this.getDirection() + ", ipsets=" + this.getIpsets() + ", name=" + this.getName() + ", source=" + this.getSource() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
