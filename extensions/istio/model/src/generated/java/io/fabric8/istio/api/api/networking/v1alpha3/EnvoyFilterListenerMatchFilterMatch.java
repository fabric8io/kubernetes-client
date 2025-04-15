
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
 * Conditions to match a specific filter within a filter chain.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "subFilter"
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
public class EnvoyFilterListenerMatchFilterMatch implements Editable<EnvoyFilterListenerMatchFilterMatchBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("subFilter")
    private EnvoyFilterListenerMatchSubFilterMatch subFilter;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EnvoyFilterListenerMatchFilterMatch() {
    }

    public EnvoyFilterListenerMatchFilterMatch(String name, EnvoyFilterListenerMatchSubFilterMatch subFilter) {
        super();
        this.name = name;
        this.subFilter = subFilter;
    }

    /**
     * The filter name to match on. For standard Envoy filters, [canonical filter](https://www.envoyproxy.io/docs/envoy/latest/version_history/v1.14.0#deprecated) names should be used.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * The filter name to match on. For standard Envoy filters, [canonical filter](https://www.envoyproxy.io/docs/envoy/latest/version_history/v1.14.0#deprecated) names should be used.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Conditions to match a specific filter within a filter chain.
     */
    @JsonProperty("subFilter")
    public EnvoyFilterListenerMatchSubFilterMatch getSubFilter() {
        return subFilter;
    }

    /**
     * Conditions to match a specific filter within a filter chain.
     */
    @JsonProperty("subFilter")
    public void setSubFilter(EnvoyFilterListenerMatchSubFilterMatch subFilter) {
        this.subFilter = subFilter;
    }

    @JsonIgnore
    public EnvoyFilterListenerMatchFilterMatchBuilder edit() {
        return new EnvoyFilterListenerMatchFilterMatchBuilder(this);
    }

    @JsonIgnore
    public EnvoyFilterListenerMatchFilterMatchBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
