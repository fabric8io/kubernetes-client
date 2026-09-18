
package io.fabric8.openshift.api.model.config.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import io.fabric8.kubernetes.api.model.Condition;
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
    "conditions",
    "featureGates"
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
public class FeatureGateStatus implements Editable<FeatureGateStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("featureGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FeatureGateDetails> featureGates = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FeatureGateStatus() {
    }

    public FeatureGateStatus(List<Condition> conditions, List<FeatureGateDetails> featureGates) {
        super();
        this.conditions = conditions;
        this.featureGates = featureGates;
    }

    /**
     * conditions represent the observations of the current state. Known .status.conditions.type are: "DeterminationDegraded"
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions represent the observations of the current state. Known .status.conditions.type are: "DeterminationDegraded"
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * featureGates contains a list of enabled and disabled featureGates that are keyed by payloadVersion. Operators other than the CVO and cluster-config-operator, must read the .status.featureGates, locate the version they are managing, find the enabled/disabled featuregates and make the operand and operator match. The enabled/disabled values for a particular version may change during the life of the cluster as various .spec.featureSet values are selected. Operators may choose to restart their processes to pick up these changes, but remembering past enable/disable lists is beyond the scope of this API and is the responsibility of individual operators. Only featureGates with .version in the ClusterVersion.status will be present in this list.
     */
    @JsonProperty("featureGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FeatureGateDetails> getFeatureGates() {
        return featureGates;
    }

    /**
     * featureGates contains a list of enabled and disabled featureGates that are keyed by payloadVersion. Operators other than the CVO and cluster-config-operator, must read the .status.featureGates, locate the version they are managing, find the enabled/disabled featuregates and make the operand and operator match. The enabled/disabled values for a particular version may change during the life of the cluster as various .spec.featureSet values are selected. Operators may choose to restart their processes to pick up these changes, but remembering past enable/disable lists is beyond the scope of this API and is the responsibility of individual operators. Only featureGates with .version in the ClusterVersion.status will be present in this list.
     */
    @JsonProperty("featureGates")
    public void setFeatureGates(List<FeatureGateDetails> featureGates) {
        this.featureGates = featureGates;
    }

    @JsonIgnore
    public FeatureGateStatusBuilder edit() {
        return new FeatureGateStatusBuilder(this);
    }

    @JsonIgnore
    public FeatureGateStatusBuilder toBuilder() {
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
        if (!(o instanceof FeatureGateStatus)) {
            return false;
        }
        FeatureGateStatus other = (FeatureGateStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$featureGates = this.getFeatureGates();
        Object other$featureGates = other.getFeatureGates();
        if (this$featureGates == null ? other$featureGates != null : !this$featureGates.equals(other$featureGates)) {
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
        return other instanceof FeatureGateStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $featureGates = this.getFeatureGates();
        result = result * prime + ($featureGates == null ? 43 : $featureGates.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "FeatureGateStatus(" + "conditions=" + this.getConditions() + ", featureGates=" + this.getFeatureGates() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
