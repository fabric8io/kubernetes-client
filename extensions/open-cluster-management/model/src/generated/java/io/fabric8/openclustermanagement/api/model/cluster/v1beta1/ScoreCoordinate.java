
package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

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

/**
 * ScoreCoordinate represents the configuration of the score type and score source
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addOn",
    "builtIn",
    "type"
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
public class ScoreCoordinate implements Editable<ScoreCoordinateBuilder>, KubernetesResource
{

    @JsonProperty("addOn")
    private AddOnScore addOn;
    @JsonProperty("builtIn")
    private String builtIn;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ScoreCoordinate() {
    }

    public ScoreCoordinate(AddOnScore addOn, String builtIn, String type) {
        super();
        this.addOn = addOn;
        this.builtIn = builtIn;
        this.type = type;
    }

    /**
     * ScoreCoordinate represents the configuration of the score type and score source
     */
    @JsonProperty("addOn")
    public AddOnScore getAddOn() {
        return addOn;
    }

    /**
     * ScoreCoordinate represents the configuration of the score type and score source
     */
    @JsonProperty("addOn")
    public void setAddOn(AddOnScore addOn) {
        this.addOn = addOn;
    }

    /**
     * BuiltIn defines the name of a BuiltIn prioritizer. Below are the valid BuiltIn prioritizer names. 1) Balance: balance the decisions among the clusters. 2) Steady: ensure the existing decision is stabilized. 3) ResourceAllocatableCPU &amp; ResourceAllocatableMemory: sort clusters based on the allocatable. 4) Spread: spread the workload evenly to topologies.
     */
    @JsonProperty("builtIn")
    public String getBuiltIn() {
        return builtIn;
    }

    /**
     * BuiltIn defines the name of a BuiltIn prioritizer. Below are the valid BuiltIn prioritizer names. 1) Balance: balance the decisions among the clusters. 2) Steady: ensure the existing decision is stabilized. 3) ResourceAllocatableCPU &amp; ResourceAllocatableMemory: sort clusters based on the allocatable. 4) Spread: spread the workload evenly to topologies.
     */
    @JsonProperty("builtIn")
    public void setBuiltIn(String builtIn) {
        this.builtIn = builtIn;
    }

    /**
     * type defines the type of the prioritizer score. Type is either "BuiltIn", "AddOn" or "", where "" is "BuiltIn" by default. When the type is "BuiltIn", need to specify a BuiltIn prioritizer name in BuiltIn. When the type is "AddOn", need to configure the score source in AddOn.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type defines the type of the prioritizer score. Type is either "BuiltIn", "AddOn" or "", where "" is "BuiltIn" by default. When the type is "BuiltIn", need to specify a BuiltIn prioritizer name in BuiltIn. When the type is "AddOn", need to configure the score source in AddOn.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public ScoreCoordinateBuilder edit() {
        return new ScoreCoordinateBuilder(this);
    }

    @JsonIgnore
    public ScoreCoordinateBuilder toBuilder() {
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
        if (!(o instanceof ScoreCoordinate)) {
            return false;
        }
        ScoreCoordinate other = (ScoreCoordinate) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$addOn = this.getAddOn();
        Object other$addOn = other.getAddOn();
        if (this$addOn == null ? other$addOn != null : !this$addOn.equals(other$addOn)) {
            return false;
        }
        Object this$builtIn = this.getBuiltIn();
        Object other$builtIn = other.getBuiltIn();
        if (this$builtIn == null ? other$builtIn != null : !this$builtIn.equals(other$builtIn)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof ScoreCoordinate;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $addOn = this.getAddOn();
        result = result * prime + ($addOn == null ? 43 : $addOn.hashCode());
        Object $builtIn = this.getBuiltIn();
        result = result * prime + ($builtIn == null ? 43 : $builtIn.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ScoreCoordinate(" + "addOn=" + this.getAddOn() + ", builtIn=" + this.getBuiltIn() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
