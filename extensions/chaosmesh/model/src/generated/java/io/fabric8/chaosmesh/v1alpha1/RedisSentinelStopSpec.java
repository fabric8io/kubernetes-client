
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
    "conf",
    "flushConfig",
    "password",
    "redisPath"
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
public class RedisSentinelStopSpec implements Editable<RedisSentinelStopSpecBuilder>, KubernetesResource
{

    @JsonProperty("addr")
    private String addr;
    @JsonProperty("conf")
    private String conf;
    @JsonProperty("flushConfig")
    private Boolean flushConfig;
    @JsonProperty("password")
    private String password;
    @JsonProperty("redisPath")
    private Boolean redisPath;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RedisSentinelStopSpec() {
    }

    public RedisSentinelStopSpec(String addr, String conf, Boolean flushConfig, String password, Boolean redisPath) {
        super();
        this.addr = addr;
        this.conf = conf;
        this.flushConfig = flushConfig;
        this.password = password;
        this.redisPath = redisPath;
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
     * The path of Sentinel conf
     */
    @JsonProperty("conf")
    public String getConf() {
        return conf;
    }

    /**
     * The path of Sentinel conf
     */
    @JsonProperty("conf")
    public void setConf(String conf) {
        this.conf = conf;
    }

    /**
     * The control flag determines whether to flush config
     */
    @JsonProperty("flushConfig")
    public Boolean getFlushConfig() {
        return flushConfig;
    }

    /**
     * The control flag determines whether to flush config
     */
    @JsonProperty("flushConfig")
    public void setFlushConfig(Boolean flushConfig) {
        this.flushConfig = flushConfig;
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
     * The path of `redis-server` command-line tool
     */
    @JsonProperty("redisPath")
    public Boolean getRedisPath() {
        return redisPath;
    }

    /**
     * The path of `redis-server` command-line tool
     */
    @JsonProperty("redisPath")
    public void setRedisPath(Boolean redisPath) {
        this.redisPath = redisPath;
    }

    @JsonIgnore
    public RedisSentinelStopSpecBuilder edit() {
        return new RedisSentinelStopSpecBuilder(this);
    }

    @JsonIgnore
    public RedisSentinelStopSpecBuilder toBuilder() {
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
        if (!(o instanceof RedisSentinelStopSpec)) {
            return false;
        }
        RedisSentinelStopSpec other = (RedisSentinelStopSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$addr = this.getAddr();
        Object other$addr = other.getAddr();
        if (this$addr == null ? other$addr != null : !this$addr.equals(other$addr)) {
            return false;
        }
        Object this$conf = this.getConf();
        Object other$conf = other.getConf();
        if (this$conf == null ? other$conf != null : !this$conf.equals(other$conf)) {
            return false;
        }
        Object this$flushConfig = this.getFlushConfig();
        Object other$flushConfig = other.getFlushConfig();
        if (this$flushConfig == null ? other$flushConfig != null : !this$flushConfig.equals(other$flushConfig)) {
            return false;
        }
        Object this$password = this.getPassword();
        Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) {
            return false;
        }
        Object this$redisPath = this.getRedisPath();
        Object other$redisPath = other.getRedisPath();
        if (this$redisPath == null ? other$redisPath != null : !this$redisPath.equals(other$redisPath)) {
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
        return other instanceof RedisSentinelStopSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $addr = this.getAddr();
        result = result * prime + ($addr == null ? 43 : $addr.hashCode());
        Object $conf = this.getConf();
        result = result * prime + ($conf == null ? 43 : $conf.hashCode());
        Object $flushConfig = this.getFlushConfig();
        result = result * prime + ($flushConfig == null ? 43 : $flushConfig.hashCode());
        Object $password = this.getPassword();
        result = result * prime + ($password == null ? 43 : $password.hashCode());
        Object $redisPath = this.getRedisPath();
        result = result * prime + ($redisPath == null ? 43 : $redisPath.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RedisSentinelStopSpec(" + "addr=" + this.getAddr() + ", conf=" + this.getConf() + ", flushConfig=" + this.getFlushConfig() + ", password=" + this.getPassword() + ", redisPath=" + this.getRedisPath() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
