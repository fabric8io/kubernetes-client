
package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

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
 * CompositeDisruptionMode defines how individual entities within a composite pod group can be disrupted. Exactly one mode must be set.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "all",
    "single"
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
public class CompositeDisruptionMode implements Editable<CompositeDisruptionModeBuilder>, KubernetesResource
{

    @JsonProperty("all")
    private AllCompositeDisruptionMode all;
    @JsonProperty("single")
    private SingleCompositeDisruptionMode single;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CompositeDisruptionMode() {
    }

    public CompositeDisruptionMode(AllCompositeDisruptionMode all, SingleCompositeDisruptionMode single) {
        super();
        this.all = all;
        this.single = single;
    }

    /**
     * CompositeDisruptionMode defines how individual entities within a composite pod group can be disrupted. Exactly one mode must be set.
     */
    @JsonProperty("all")
    public AllCompositeDisruptionMode getAll() {
        return all;
    }

    /**
     * CompositeDisruptionMode defines how individual entities within a composite pod group can be disrupted. Exactly one mode must be set.
     */
    @JsonProperty("all")
    public void setAll(AllCompositeDisruptionMode all) {
        this.all = all;
    }

    /**
     * CompositeDisruptionMode defines how individual entities within a composite pod group can be disrupted. Exactly one mode must be set.
     */
    @JsonProperty("single")
    public SingleCompositeDisruptionMode getSingle() {
        return single;
    }

    /**
     * CompositeDisruptionMode defines how individual entities within a composite pod group can be disrupted. Exactly one mode must be set.
     */
    @JsonProperty("single")
    public void setSingle(SingleCompositeDisruptionMode single) {
        this.single = single;
    }

    @JsonIgnore
    public CompositeDisruptionModeBuilder edit() {
        return new CompositeDisruptionModeBuilder(this);
    }

    @JsonIgnore
    public CompositeDisruptionModeBuilder toBuilder() {
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
