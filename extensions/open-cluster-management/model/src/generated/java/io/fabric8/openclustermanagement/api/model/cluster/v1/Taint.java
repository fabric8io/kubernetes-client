
package io.fabric8.openclustermanagement.api.model.cluster.v1;

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
 * The managed cluster this Taint is attached to has the "effect" on any placement that does not tolerate the Taint.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "effect",
    "key",
    "timeAdded",
    "value"
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
public class Taint implements Editable<TaintBuilder>, KubernetesResource
{

    @JsonProperty("effect")
    private String effect;
    @JsonProperty("key")
    private String key;
    @JsonProperty("timeAdded")
    private String timeAdded;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Taint() {
    }

    public Taint(String effect, String key, String timeAdded, String value) {
        super();
        this.effect = effect;
        this.key = key;
        this.timeAdded = timeAdded;
        this.value = value;
    }

    /**
     * Effect indicates the effect of the taint on placements that do not tolerate the taint. Valid effects are NoSelect, PreferNoSelect and NoSelectIfNew.
     */
    @JsonProperty("effect")
    public String getEffect() {
        return effect;
    }

    /**
     * Effect indicates the effect of the taint on placements that do not tolerate the taint. Valid effects are NoSelect, PreferNoSelect and NoSelectIfNew.
     */
    @JsonProperty("effect")
    public void setEffect(String effect) {
        this.effect = effect;
    }

    /**
     * Key is the taint key applied to a cluster. e.g. bar or foo.example.com/bar. The regex it matches is (dns1123SubdomainFmt/)?(qualifiedNameFmt)
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * Key is the taint key applied to a cluster. e.g. bar or foo.example.com/bar. The regex it matches is (dns1123SubdomainFmt/)?(qualifiedNameFmt)
     */
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * The managed cluster this Taint is attached to has the "effect" on any placement that does not tolerate the Taint.
     */
    @JsonProperty("timeAdded")
    public String getTimeAdded() {
        return timeAdded;
    }

    /**
     * The managed cluster this Taint is attached to has the "effect" on any placement that does not tolerate the Taint.
     */
    @JsonProperty("timeAdded")
    public void setTimeAdded(String timeAdded) {
        this.timeAdded = timeAdded;
    }

    /**
     * Value is the taint value corresponding to the taint key.
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * Value is the taint value corresponding to the taint key.
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonIgnore
    public TaintBuilder edit() {
        return new TaintBuilder(this);
    }

    @JsonIgnore
    public TaintBuilder toBuilder() {
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
