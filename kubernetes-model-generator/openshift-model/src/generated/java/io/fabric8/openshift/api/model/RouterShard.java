
package io.fabric8.openshift.api.model;

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
 * RouterShard has information of a routing shard and is used to generate host names and routing table entries when a routing shard is allocated for a specific route. Caveat: This is WIP and will likely undergo modifications when sharding support is added.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dnsSuffix",
    "shardName"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class RouterShard implements Editable<RouterShardBuilder>, KubernetesResource
{

    @JsonProperty("dnsSuffix")
    private String dnsSuffix;
    @JsonProperty("shardName")
    private String shardName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RouterShard() {
    }

    public RouterShard(String dnsSuffix, String shardName) {
        super();
        this.dnsSuffix = dnsSuffix;
        this.shardName = shardName;
    }

    /**
     * dnsSuffix for the shard ala: shard-1.v3.openshift.com
     */
    @JsonProperty("dnsSuffix")
    public String getDnsSuffix() {
        return dnsSuffix;
    }

    /**
     * dnsSuffix for the shard ala: shard-1.v3.openshift.com
     */
    @JsonProperty("dnsSuffix")
    public void setDnsSuffix(String dnsSuffix) {
        this.dnsSuffix = dnsSuffix;
    }

    /**
     * shardName uniquely identifies a router shard in the "set" of routers used for routing traffic to the services.
     */
    @JsonProperty("shardName")
    public String getShardName() {
        return shardName;
    }

    /**
     * shardName uniquely identifies a router shard in the "set" of routers used for routing traffic to the services.
     */
    @JsonProperty("shardName")
    public void setShardName(String shardName) {
        this.shardName = shardName;
    }

    @JsonIgnore
    public RouterShardBuilder edit() {
        return new RouterShardBuilder(this);
    }

    @JsonIgnore
    public RouterShardBuilder toBuilder() {
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
        if (!(o instanceof RouterShard)) {
            return false;
        }
        RouterShard other = (RouterShard) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$dnsSuffix = this.getDnsSuffix();
        Object other$dnsSuffix = other.getDnsSuffix();
        if (this$dnsSuffix == null ? other$dnsSuffix != null : !this$dnsSuffix.equals(other$dnsSuffix)) {
            return false;
        }
        Object this$shardName = this.getShardName();
        Object other$shardName = other.getShardName();
        if (this$shardName == null ? other$shardName != null : !this$shardName.equals(other$shardName)) {
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
        return other instanceof RouterShard;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $dnsSuffix = this.getDnsSuffix();
        result = result * prime + ($dnsSuffix == null ? 43 : $dnsSuffix.hashCode());
        Object $shardName = this.getShardName();
        result = result * prime + ($shardName == null ? 43 : $shardName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RouterShard(" + "dnsSuffix=" + this.getDnsSuffix() + ", shardName=" + this.getShardName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
