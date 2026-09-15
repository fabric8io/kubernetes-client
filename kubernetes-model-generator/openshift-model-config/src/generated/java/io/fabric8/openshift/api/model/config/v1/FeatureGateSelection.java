
package io.fabric8.openshift.api.model.config.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "customNoUpgrade",
    "featureSet"
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
public class FeatureGateSelection implements Editable<FeatureGateSelectionBuilder>, KubernetesResource
{

    @JsonProperty("customNoUpgrade")
    private CustomFeatureGates customNoUpgrade;
    @JsonProperty("featureSet")
    private String featureSet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FeatureGateSelection() {
    }

    public FeatureGateSelection(CustomFeatureGates customNoUpgrade, String featureSet) {
        super();
        this.customNoUpgrade = customNoUpgrade;
        this.featureSet = featureSet;
    }

    @JsonProperty("customNoUpgrade")
    public CustomFeatureGates getCustomNoUpgrade() {
        return customNoUpgrade;
    }

    @JsonProperty("customNoUpgrade")
    public void setCustomNoUpgrade(CustomFeatureGates customNoUpgrade) {
        this.customNoUpgrade = customNoUpgrade;
    }

    /**
     * featureSet changes the list of features in the cluster.  The default is empty.  Be very careful adjusting this setting. Turning on or off features may cause irreversible changes in your cluster which cannot be undone.
     */
    @JsonProperty("featureSet")
    public String getFeatureSet() {
        return featureSet;
    }

    /**
     * featureSet changes the list of features in the cluster.  The default is empty.  Be very careful adjusting this setting. Turning on or off features may cause irreversible changes in your cluster which cannot be undone.
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof FeatureGateSelection)) {
            return false;
        }
        FeatureGateSelection other = (FeatureGateSelection) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$customNoUpgrade = this.getCustomNoUpgrade();
        Object other$customNoUpgrade = other.getCustomNoUpgrade();
        if (this$customNoUpgrade == null ? other$customNoUpgrade != null : !this$customNoUpgrade.equals(other$customNoUpgrade)) {
            return false;
        }
        Object this$featureSet = this.getFeatureSet();
        Object other$featureSet = other.getFeatureSet();
        if (this$featureSet == null ? other$featureSet != null : !this$featureSet.equals(other$featureSet)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof FeatureGateSelection;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $customNoUpgrade = this.getCustomNoUpgrade();
        result = result * prime + ($customNoUpgrade == null ? 43 : $customNoUpgrade.hashCode());
        Object $featureSet = this.getFeatureSet();
        result = result * prime + ($featureSet == null ? 43 : $featureSet.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "FeatureGateSelection(" + "customNoUpgrade=" + this.getCustomNoUpgrade() + ", featureSet=" + this.getFeatureSet() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
