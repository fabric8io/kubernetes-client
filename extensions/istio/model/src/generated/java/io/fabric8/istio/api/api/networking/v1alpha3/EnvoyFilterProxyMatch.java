
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * One or more properties of the proxy to match on.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "metadata",
    "proxyVersion"
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
public class EnvoyFilterProxyMatch implements Editable<EnvoyFilterProxyMatchBuilder>, KubernetesResource
{

    @JsonProperty("metadata")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> metadata = new LinkedHashMap<>();
    @JsonProperty("proxyVersion")
    private String proxyVersion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EnvoyFilterProxyMatch() {
    }

    public EnvoyFilterProxyMatch(Map<String, String> metadata, String proxyVersion) {
        super();
        this.metadata = metadata;
        this.proxyVersion = proxyVersion;
    }

    /**
     * Match on the node metadata supplied by a proxy when connecting to istiod. Note that while Envoy's node metadata is of type Struct, only string key-value pairs are processed by istiod. All keys specified in the metadata must match with exact values. The match will fail if any of the specified keys are absent or the values fail to match.
     */
    @JsonProperty("metadata")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getMetadata() {
        return metadata;
    }

    /**
     * Match on the node metadata supplied by a proxy when connecting to istiod. Note that while Envoy's node metadata is of type Struct, only string key-value pairs are processed by istiod. All keys specified in the metadata must match with exact values. The match will fail if any of the specified keys are absent or the values fail to match.
     */
    @JsonProperty("metadata")
    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    /**
     * A regular expression in golang regex format (RE2) that can be used to select proxies using a specific version of istio proxy. The Istio version for a given proxy is obtained from the node metadata field `ISTIO_VERSION` supplied by the proxy when connecting to istiod. This value is embedded as an environment variable (`ISTIO_META_ISTIO_VERSION`) in the Istio proxy docker image. Custom proxy implementations should provide this metadata variable to take advantage of the Istio version check option.
     */
    @JsonProperty("proxyVersion")
    public String getProxyVersion() {
        return proxyVersion;
    }

    /**
     * A regular expression in golang regex format (RE2) that can be used to select proxies using a specific version of istio proxy. The Istio version for a given proxy is obtained from the node metadata field `ISTIO_VERSION` supplied by the proxy when connecting to istiod. This value is embedded as an environment variable (`ISTIO_META_ISTIO_VERSION`) in the Istio proxy docker image. Custom proxy implementations should provide this metadata variable to take advantage of the Istio version check option.
     */
    @JsonProperty("proxyVersion")
    public void setProxyVersion(String proxyVersion) {
        this.proxyVersion = proxyVersion;
    }

    @JsonIgnore
    public EnvoyFilterProxyMatchBuilder edit() {
        return new EnvoyFilterProxyMatchBuilder(this);
    }

    @JsonIgnore
    public EnvoyFilterProxyMatchBuilder toBuilder() {
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
