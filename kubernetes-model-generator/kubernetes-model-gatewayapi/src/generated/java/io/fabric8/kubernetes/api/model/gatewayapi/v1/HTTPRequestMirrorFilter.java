
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
 * HTTPRequestMirrorFilter defines configuration for the RequestMirror filter.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "backendRef",
    "fraction",
    "percent"
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
public class HTTPRequestMirrorFilter implements Editable<HTTPRequestMirrorFilterBuilder>, KubernetesResource
{

    @JsonProperty("backendRef")
    private BackendObjectReference backendRef;
    @JsonProperty("fraction")
    private Fraction fraction;
    @JsonProperty("percent")
    private Integer percent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPRequestMirrorFilter() {
    }

    public HTTPRequestMirrorFilter(BackendObjectReference backendRef, Fraction fraction, Integer percent) {
        super();
        this.backendRef = backendRef;
        this.fraction = fraction;
        this.percent = percent;
    }

    /**
     * HTTPRequestMirrorFilter defines configuration for the RequestMirror filter.
     */
    @JsonProperty("backendRef")
    public BackendObjectReference getBackendRef() {
        return backendRef;
    }

    /**
     * HTTPRequestMirrorFilter defines configuration for the RequestMirror filter.
     */
    @JsonProperty("backendRef")
    public void setBackendRef(BackendObjectReference backendRef) {
        this.backendRef = backendRef;
    }

    /**
     * HTTPRequestMirrorFilter defines configuration for the RequestMirror filter.
     */
    @JsonProperty("fraction")
    public Fraction getFraction() {
        return fraction;
    }

    /**
     * HTTPRequestMirrorFilter defines configuration for the RequestMirror filter.
     */
    @JsonProperty("fraction")
    public void setFraction(Fraction fraction) {
        this.fraction = fraction;
    }

    /**
     * Percent represents the percentage of requests that should be mirrored to BackendRef. Its minimum value is 0 (indicating 0% of requests) and its maximum value is 100 (indicating 100% of requests).<br><p> <br><p> Only one of Fraction or Percent may be specified. If neither field is specified, 100% of requests will be mirrored.
     */
    @JsonProperty("percent")
    public Integer getPercent() {
        return percent;
    }

    /**
     * Percent represents the percentage of requests that should be mirrored to BackendRef. Its minimum value is 0 (indicating 0% of requests) and its maximum value is 100 (indicating 100% of requests).<br><p> <br><p> Only one of Fraction or Percent may be specified. If neither field is specified, 100% of requests will be mirrored.
     */
    @JsonProperty("percent")
    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    @JsonIgnore
    public HTTPRequestMirrorFilterBuilder edit() {
        return new HTTPRequestMirrorFilterBuilder(this);
    }

    @JsonIgnore
    public HTTPRequestMirrorFilterBuilder toBuilder() {
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
