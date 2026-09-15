
package io.fabric8.volcano.api.model.nodeinfo.v1alpha1;

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
 * CPUInfo is the cpu topology detail
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "core",
    "numa",
    "socket"
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
public class CPUInfo implements Editable<CPUInfoBuilder>, KubernetesResource
{

    @JsonProperty("core")
    private Integer core;
    @JsonProperty("numa")
    private Integer numa;
    @JsonProperty("socket")
    private Integer socket;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CPUInfo() {
    }

    public CPUInfo(Integer core, Integer numa, Integer socket) {
        super();
        this.core = core;
        this.numa = numa;
        this.socket = socket;
    }

    /**
     * CPUInfo is the cpu topology detail
     */
    @JsonProperty("core")
    public Integer getCore() {
        return core;
    }

    /**
     * CPUInfo is the cpu topology detail
     */
    @JsonProperty("core")
    public void setCore(Integer core) {
        this.core = core;
    }

    /**
     * CPUInfo is the cpu topology detail
     */
    @JsonProperty("numa")
    public Integer getNuma() {
        return numa;
    }

    /**
     * CPUInfo is the cpu topology detail
     */
    @JsonProperty("numa")
    public void setNuma(Integer numa) {
        this.numa = numa;
    }

    /**
     * CPUInfo is the cpu topology detail
     */
    @JsonProperty("socket")
    public Integer getSocket() {
        return socket;
    }

    /**
     * CPUInfo is the cpu topology detail
     */
    @JsonProperty("socket")
    public void setSocket(Integer socket) {
        this.socket = socket;
    }

    @JsonIgnore
    public CPUInfoBuilder edit() {
        return new CPUInfoBuilder(this);
    }

    @JsonIgnore
    public CPUInfoBuilder toBuilder() {
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
        if (!(o instanceof CPUInfo)) {
            return false;
        }
        CPUInfo other = (CPUInfo) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$core = this.getCore();
        Object other$core = other.getCore();
        if (this$core == null ? other$core != null : !this$core.equals(other$core)) {
            return false;
        }
        Object this$numa = this.getNuma();
        Object other$numa = other.getNuma();
        if (this$numa == null ? other$numa != null : !this$numa.equals(other$numa)) {
            return false;
        }
        Object this$socket = this.getSocket();
        Object other$socket = other.getSocket();
        if (this$socket == null ? other$socket != null : !this$socket.equals(other$socket)) {
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
        return other instanceof CPUInfo;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $core = this.getCore();
        result = result * prime + ($core == null ? 43 : $core.hashCode());
        Object $numa = this.getNuma();
        result = result * prime + ($numa == null ? 43 : $numa.hashCode());
        Object $socket = this.getSocket();
        result = result * prime + ($socket == null ? 43 : $socket.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CPUInfo(" + "core=" + this.getCore() + ", numa=" + this.getNuma() + ", socket=" + this.getSocket() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
