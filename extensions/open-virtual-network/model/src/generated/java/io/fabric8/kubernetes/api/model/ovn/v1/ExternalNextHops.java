
package io.fabric8.kubernetes.api.model.ovn.v1;

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
 * ExternalNextHops contains slices of StaticHops and DynamicHops structures. Minimum is one StaticHop or one DynamicHop.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dynamic",
    "static"
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
public class ExternalNextHops implements Editable<ExternalNextHopsBuilder>, KubernetesResource
{

    @JsonProperty("dynamic")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DynamicHop> dynamic = new ArrayList<>();
    @JsonProperty("static")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StaticHop> _static = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ExternalNextHops() {
    }

    public ExternalNextHops(List<DynamicHop> dynamic, List<StaticHop> _static) {
        super();
        this.dynamic = dynamic;
        this._static = _static;
    }

    /**
     * DynamicHops defines a slices of DynamicHop. This field is optional.
     */
    @JsonProperty("dynamic")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DynamicHop> getDynamic() {
        return dynamic;
    }

    /**
     * DynamicHops defines a slices of DynamicHop. This field is optional.
     */
    @JsonProperty("dynamic")
    public void setDynamic(List<DynamicHop> dynamic) {
        this.dynamic = dynamic;
    }

    /**
     * StaticHops defines a slice of StaticHop. This field is optional.
     */
    @JsonProperty("static")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<StaticHop> getStatic() {
        return _static;
    }

    /**
     * StaticHops defines a slice of StaticHop. This field is optional.
     */
    @JsonProperty("static")
    public void setStatic(List<StaticHop> _static) {
        this._static = _static;
    }

    @JsonIgnore
    public ExternalNextHopsBuilder edit() {
        return new ExternalNextHopsBuilder(this);
    }

    @JsonIgnore
    public ExternalNextHopsBuilder toBuilder() {
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
