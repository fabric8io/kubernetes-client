
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
 * OTLPConfig is the configuration for writing to the OTLP endpoint.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "promoteResourceAttributes",
    "translationStrategy"
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
public class OTLPConfig implements Editable<OTLPConfigBuilder>, KubernetesResource
{

    @JsonProperty("promoteResourceAttributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> promoteResourceAttributes = new ArrayList<>();
    @JsonProperty("translationStrategy")
    private String translationStrategy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OTLPConfig() {
    }

    public OTLPConfig(List<String> promoteResourceAttributes, String translationStrategy) {
        super();
        this.promoteResourceAttributes = promoteResourceAttributes;
        this.translationStrategy = translationStrategy;
    }

    /**
     * List of OpenTelemetry Attributes that should be promoted to metric labels, defaults to none.
     */
    @JsonProperty("promoteResourceAttributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPromoteResourceAttributes() {
        return promoteResourceAttributes;
    }

    /**
     * List of OpenTelemetry Attributes that should be promoted to metric labels, defaults to none.
     */
    @JsonProperty("promoteResourceAttributes")
    public void setPromoteResourceAttributes(List<String> promoteResourceAttributes) {
        this.promoteResourceAttributes = promoteResourceAttributes;
    }

    /**
     * Configures how the OTLP receiver endpoint translates the incoming metrics. If unset, Prometheus uses its default value.<br><p> <br><p> It requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("translationStrategy")
    public String getTranslationStrategy() {
        return translationStrategy;
    }

    /**
     * Configures how the OTLP receiver endpoint translates the incoming metrics. If unset, Prometheus uses its default value.<br><p> <br><p> It requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("translationStrategy")
    public void setTranslationStrategy(String translationStrategy) {
        this.translationStrategy = translationStrategy;
    }

    @JsonIgnore
    public OTLPConfigBuilder edit() {
        return new OTLPConfigBuilder(this);
    }

    @JsonIgnore
    public OTLPConfigBuilder toBuilder() {
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
