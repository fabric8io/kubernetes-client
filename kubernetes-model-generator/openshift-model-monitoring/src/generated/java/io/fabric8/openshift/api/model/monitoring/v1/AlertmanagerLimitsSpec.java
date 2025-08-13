
package io.fabric8.openshift.api.model.monitoring.v1;

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
 * AlertmanagerLimitsSpec defines the limits command line flags when starting Alertmanager.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "maxPerSilenceBytes",
    "maxSilences"
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
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AlertmanagerLimitsSpec implements Editable<AlertmanagerLimitsSpecBuilder>, KubernetesResource
{

    @JsonProperty("maxPerSilenceBytes")
    private String maxPerSilenceBytes;
    @JsonProperty("maxSilences")
    private Integer maxSilences;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AlertmanagerLimitsSpec() {
    }

    public AlertmanagerLimitsSpec(String maxPerSilenceBytes, Integer maxSilences) {
        super();
        this.maxPerSilenceBytes = maxPerSilenceBytes;
        this.maxSilences = maxSilences;
    }

    /**
     * The maximum size of an individual silence as stored on disk. This corresponds to the Alertmanager's `--silences.max-per-silence-bytes` flag. It requires Alertmanager &gt;= v0.28.0.
     */
    @JsonProperty("maxPerSilenceBytes")
    public String getMaxPerSilenceBytes() {
        return maxPerSilenceBytes;
    }

    /**
     * The maximum size of an individual silence as stored on disk. This corresponds to the Alertmanager's `--silences.max-per-silence-bytes` flag. It requires Alertmanager &gt;= v0.28.0.
     */
    @JsonProperty("maxPerSilenceBytes")
    public void setMaxPerSilenceBytes(String maxPerSilenceBytes) {
        this.maxPerSilenceBytes = maxPerSilenceBytes;
    }

    /**
     * The maximum number active and pending silences. This corresponds to the Alertmanager's `--silences.max-silences` flag. It requires Alertmanager &gt;= v0.28.0.
     */
    @JsonProperty("maxSilences")
    public Integer getMaxSilences() {
        return maxSilences;
    }

    /**
     * The maximum number active and pending silences. This corresponds to the Alertmanager's `--silences.max-silences` flag. It requires Alertmanager &gt;= v0.28.0.
     */
    @JsonProperty("maxSilences")
    public void setMaxSilences(Integer maxSilences) {
        this.maxSilences = maxSilences;
    }

    @JsonIgnore
    public AlertmanagerLimitsSpecBuilder edit() {
        return new AlertmanagerLimitsSpecBuilder(this);
    }

    @JsonIgnore
    public AlertmanagerLimitsSpecBuilder toBuilder() {
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
