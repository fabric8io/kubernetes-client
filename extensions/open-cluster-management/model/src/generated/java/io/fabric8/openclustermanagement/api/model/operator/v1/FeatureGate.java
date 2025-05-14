
package io.fabric8.openclustermanagement.api.model.operator.v1;

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
    "feature",
    "mode"
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
public class FeatureGate implements Editable<FeatureGateBuilder>, KubernetesResource
{

    @JsonProperty("feature")
    private String feature;
    @JsonProperty("mode")
    private String mode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FeatureGate() {
    }

    public FeatureGate(String feature, String mode) {
        super();
        this.feature = feature;
        this.mode = mode;
    }

    /**
     * Feature is the key of feature gate. e.g. featuregate/Foo.
     */
    @JsonProperty("feature")
    public String getFeature() {
        return feature;
    }

    /**
     * Feature is the key of feature gate. e.g. featuregate/Foo.
     */
    @JsonProperty("feature")
    public void setFeature(String feature) {
        this.feature = feature;
    }

    /**
     * Mode is either Enable, Disable, "" where "" is Disable by default. In Enable mode, a valid feature gate `featuregate/Foo` will be set to "--featuregate/Foo=true". In Disable mode, a valid feature gate `featuregate/Foo` will be set to "--featuregate/Foo=false".
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * Mode is either Enable, Disable, "" where "" is Disable by default. In Enable mode, a valid feature gate `featuregate/Foo` will be set to "--featuregate/Foo=true". In Disable mode, a valid feature gate `featuregate/Foo` will be set to "--featuregate/Foo=false".
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonIgnore
    public FeatureGateBuilder edit() {
        return new FeatureGateBuilder(this);
    }

    @JsonIgnore
    public FeatureGateBuilder toBuilder() {
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
