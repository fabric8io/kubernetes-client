
package io.fabric8.openshift.api.model.hive.v1;

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
 * FeatureGateSelection allows selecting feature gates for the controller.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "custom",
    "featureSet"
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
public class FeatureGateSelection implements Editable<FeatureGateSelectionBuilder>, KubernetesResource
{

    @JsonProperty("custom")
    private FeatureGatesEnabled custom;
    @JsonProperty("featureSet")
    private String featureSet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FeatureGateSelection() {
    }

    public FeatureGateSelection(FeatureGatesEnabled custom, String featureSet) {
        super();
        this.custom = custom;
        this.featureSet = featureSet;
    }

    /**
     * FeatureGateSelection allows selecting feature gates for the controller.
     */
    @JsonProperty("custom")
    public FeatureGatesEnabled getCustom() {
        return custom;
    }

    /**
     * FeatureGateSelection allows selecting feature gates for the controller.
     */
    @JsonProperty("custom")
    public void setCustom(FeatureGatesEnabled custom) {
        this.custom = custom;
    }

    /**
     * featureSet changes the list of features in the cluster.  The default is empty.  Be very careful adjusting this setting.
     */
    @JsonProperty("featureSet")
    public String getFeatureSet() {
        return featureSet;
    }

    /**
     * featureSet changes the list of features in the cluster.  The default is empty.  Be very careful adjusting this setting.
     */
    @JsonProperty("featureSet")
    public void setFeatureSet(String featureSet) {
        this.featureSet = featureSet;
    }

    @JsonIgnore
    public FeatureGateSelectionBuilder edit() {
        return new FeatureGateSelectionBuilder(this);
    }

    @JsonIgnore
    public FeatureGateSelectionBuilder toBuilder() {
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
