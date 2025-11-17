
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
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

/**
 * FrontendTLSConfig specifies frontend tls configuration for gateway.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "default",
    "perPort"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class FrontendTLSConfig implements Editable<FrontendTLSConfigBuilder>, KubernetesResource
{

    @JsonProperty("default")
    private TLSConfig _default;
    @JsonProperty("perPort")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TLSPortConfig> perPort = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FrontendTLSConfig() {
    }

    public FrontendTLSConfig(TLSConfig _default, List<TLSPortConfig> perPort) {
        super();
        this._default = _default;
        this.perPort = perPort;
    }

    /**
     * FrontendTLSConfig specifies frontend tls configuration for gateway.
     */
    @JsonProperty("default")
    public TLSConfig getDefault() {
        return _default;
    }

    /**
     * FrontendTLSConfig specifies frontend tls configuration for gateway.
     */
    @JsonProperty("default")
    public void setDefault(TLSConfig _default) {
        this._default = _default;
    }

    /**
     * PerPort specifies tls configuration assigned per port. Per port configuration is optional. Once set this configuration overrides the default configuration for all Listeners handling HTTPS traffic that match this port. Each override port requires a unique TLS configuration.<br><p> <br><p> support: Core<br><p> <br><p> &lt;gateway:experimental&gt;
     */
    @JsonProperty("perPort")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TLSPortConfig> getPerPort() {
        return perPort;
    }

    /**
     * PerPort specifies tls configuration assigned per port. Per port configuration is optional. Once set this configuration overrides the default configuration for all Listeners handling HTTPS traffic that match this port. Each override port requires a unique TLS configuration.<br><p> <br><p> support: Core<br><p> <br><p> &lt;gateway:experimental&gt;
     */
    @JsonProperty("perPort")
    public void setPerPort(List<TLSPortConfig> perPort) {
        this.perPort = perPort;
    }

    @JsonIgnore
    public FrontendTLSConfigBuilder edit() {
        return new FrontendTLSConfigBuilder(this);
    }

    @JsonIgnore
    public FrontendTLSConfigBuilder toBuilder() {
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
