
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * ClusterAvailabilityGate contains the type of a Cluster condition to be used as availability gate.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditionType",
    "polarity"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class ClusterAvailabilityGate implements Editable<ClusterAvailabilityGateBuilder>, KubernetesResource
{

    @JsonProperty("conditionType")
    private String conditionType;
    @JsonProperty("polarity")
    private String polarity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterAvailabilityGate() {
    }

    public ClusterAvailabilityGate(String conditionType, String polarity) {
        super();
        this.conditionType = conditionType;
        this.polarity = polarity;
    }

    /**
     * conditionType refers to a condition with matching type in the Cluster's condition list. If the conditions doesn't exist, it will be treated as unknown. Note: Both Cluster API conditions or conditions added by 3rd party controllers can be used as availability gates.
     */
    @JsonProperty("conditionType")
    public String getConditionType() {
        return conditionType;
    }

    /**
     * conditionType refers to a condition with matching type in the Cluster's condition list. If the conditions doesn't exist, it will be treated as unknown. Note: Both Cluster API conditions or conditions added by 3rd party controllers can be used as availability gates.
     */
    @JsonProperty("conditionType")
    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    /**
     * polarity of the conditionType specified in this availabilityGate. Valid values are Positive, Negative and omitted. When omitted, the default behaviour will be Positive. A positive polarity means that the condition should report a true status under normal conditions. A negative polarity means that the condition should report a false status under normal conditions.
     */
    @JsonProperty("polarity")
    public String getPolarity() {
        return polarity;
    }

    /**
     * polarity of the conditionType specified in this availabilityGate. Valid values are Positive, Negative and omitted. When omitted, the default behaviour will be Positive. A positive polarity means that the condition should report a true status under normal conditions. A negative polarity means that the condition should report a false status under normal conditions.
     */
    @JsonProperty("polarity")
    public void setPolarity(String polarity) {
        this.polarity = polarity;
    }

    @JsonIgnore
    public ClusterAvailabilityGateBuilder edit() {
        return new ClusterAvailabilityGateBuilder(this);
    }

    @JsonIgnore
    public ClusterAvailabilityGateBuilder toBuilder() {
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
