
package io.fabric8.chaosmesh.v1alpha1;

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
    "addr",
    "cacheSize",
    "password",
    "percent"
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
public class RedisCacheLimitSpec implements Editable<RedisCacheLimitSpecBuilder>, KubernetesResource
{

    @JsonProperty("addr")
    private String addr;
    @JsonProperty("cacheSize")
    private String cacheSize;
    @JsonProperty("password")
    private String password;
    @JsonProperty("percent")
    private String percent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RedisCacheLimitSpec() {
    }

    public RedisCacheLimitSpec(String addr, String cacheSize, String password, String percent) {
        super();
        this.addr = addr;
        this.cacheSize = cacheSize;
        this.password = password;
        this.percent = percent;
    }

    /**
     * The adress of Redis server
     */
    @JsonProperty("addr")
    public String getAddr() {
        return addr;
    }

    /**
     * The adress of Redis server
     */
    @JsonProperty("addr")
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * The size of `maxmemory`
     */
    @JsonProperty("cacheSize")
    public String getCacheSize() {
        return cacheSize;
    }

    /**
     * The size of `maxmemory`
     */
    @JsonProperty("cacheSize")
    public void setCacheSize(String cacheSize) {
        this.cacheSize = cacheSize;
    }

    /**
     * The password of Redis server
     */
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    /**
     * The password of Redis server
     */
    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Specifies maxmemory as a percentage of the original value
     */
    @JsonProperty("percent")
    public String getPercent() {
        return percent;
    }

    /**
     * Specifies maxmemory as a percentage of the original value
     */
    @JsonProperty("percent")
    public void setPercent(String percent) {
        this.percent = percent;
    }

    @JsonIgnore
    public RedisCacheLimitSpecBuilder edit() {
        return new RedisCacheLimitSpecBuilder(this);
    }

    @JsonIgnore
    public RedisCacheLimitSpecBuilder toBuilder() {
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
        if (!(o instanceof RedisCacheLimitSpec)) {
            return false;
        }
        RedisCacheLimitSpec other = (RedisCacheLimitSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$addr = this.getAddr();
        Object other$addr = other.getAddr();
        if (this$addr == null ? other$addr != null : !this$addr.equals(other$addr)) {
            return false;
        }
        Object this$cacheSize = this.getCacheSize();
        Object other$cacheSize = other.getCacheSize();
        if (this$cacheSize == null ? other$cacheSize != null : !this$cacheSize.equals(other$cacheSize)) {
            return false;
        }
        Object this$password = this.getPassword();
        Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) {
            return false;
        }
        Object this$percent = this.getPercent();
        Object other$percent = other.getPercent();
        if (this$percent == null ? other$percent != null : !this$percent.equals(other$percent)) {
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
        return other instanceof RedisCacheLimitSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $addr = this.getAddr();
        result = result * prime + ($addr == null ? 43 : $addr.hashCode());
        Object $cacheSize = this.getCacheSize();
        result = result * prime + ($cacheSize == null ? 43 : $cacheSize.hashCode());
        Object $password = this.getPassword();
        result = result * prime + ($password == null ? 43 : $password.hashCode());
        Object $percent = this.getPercent();
        result = result * prime + ($percent == null ? 43 : $percent.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RedisCacheLimitSpec(" + "addr=" + this.getAddr() + ", cacheSize=" + this.getCacheSize() + ", password=" + this.getPassword() + ", percent=" + this.getPercent() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
