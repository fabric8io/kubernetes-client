
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addr",
    "expiration",
    "key",
    "option",
    "password"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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
public class RedisExpirationSpec implements Editable<RedisExpirationSpecBuilder>, KubernetesResource
{

    @JsonProperty("addr")
    private String addr;
    @JsonProperty("expiration")
    private String expiration;
    @JsonProperty("key")
    private String key;
    @JsonProperty("option")
    private String option;
    @JsonProperty("password")
    private String password;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RedisExpirationSpec() {
    }

    public RedisExpirationSpec(String addr, String expiration, String key, String option, String password) {
        super();
        this.addr = addr;
        this.expiration = expiration;
        this.key = key;
        this.option = option;
        this.password = password;
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
     * The expiration of the keys
     */
    @JsonProperty("expiration")
    public String getExpiration() {
        return expiration;
    }

    /**
     * The expiration of the keys
     */
    @JsonProperty("expiration")
    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    /**
     * The keys to be expired
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * The keys to be expired
     */
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Additional options for `expiration`
     */
    @JsonProperty("option")
    public String getOption() {
        return option;
    }

    /**
     * Additional options for `expiration`
     */
    @JsonProperty("option")
    public void setOption(String option) {
        this.option = option;
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

    @JsonIgnore
    public RedisExpirationSpecBuilder edit() {
        return new RedisExpirationSpecBuilder(this);
    }

    @JsonIgnore
    public RedisExpirationSpecBuilder toBuilder() {
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

}
