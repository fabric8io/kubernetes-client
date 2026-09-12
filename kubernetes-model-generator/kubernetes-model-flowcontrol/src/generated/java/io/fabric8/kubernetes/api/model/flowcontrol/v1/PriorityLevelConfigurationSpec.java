
package io.fabric8.kubernetes.api.model.flowcontrol.v1;

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
 * PriorityLevelConfigurationSpec specifies the configuration of a priority level.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "exempt",
    "limited",
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
public class PriorityLevelConfigurationSpec implements Editable<PriorityLevelConfigurationSpecBuilder>, KubernetesResource
{

    @JsonProperty("exempt")
    private ExemptPriorityLevelConfiguration exempt;
    @JsonProperty("limited")
    private LimitedPriorityLevelConfiguration limited;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PriorityLevelConfigurationSpec() {
    }

    public PriorityLevelConfigurationSpec(ExemptPriorityLevelConfiguration exempt, LimitedPriorityLevelConfiguration limited, String type) {
        super();
        this.exempt = exempt;
        this.limited = limited;
        this.type = type;
    }

    /**
     * PriorityLevelConfigurationSpec specifies the configuration of a priority level.
     */
    @JsonProperty("exempt")
    public ExemptPriorityLevelConfiguration getExempt() {
        return exempt;
    }

    /**
     * PriorityLevelConfigurationSpec specifies the configuration of a priority level.
     */
    @JsonProperty("exempt")
    public void setExempt(ExemptPriorityLevelConfiguration exempt) {
        this.exempt = exempt;
    }

    /**
     * PriorityLevelConfigurationSpec specifies the configuration of a priority level.
     */
    @JsonProperty("limited")
    public LimitedPriorityLevelConfiguration getLimited() {
        return limited;
    }

    /**
     * PriorityLevelConfigurationSpec specifies the configuration of a priority level.
     */
    @JsonProperty("limited")
    public void setLimited(LimitedPriorityLevelConfiguration limited) {
        this.limited = limited;
    }

    /**
     * `type` indicates whether this priority level is subject to limitation on request execution.  A value of `"Exempt"` means that requests of this priority level are not subject to a limit (and thus are never queued) and do not detract from the capacity made available to other priority levels.  A value of `"Limited"` means that (a) requests of this priority level _are_ subject to limits and (b) some of the server's limited capacity is made available exclusively to this priority level. Required.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * `type` indicates whether this priority level is subject to limitation on request execution.  A value of `"Exempt"` means that requests of this priority level are not subject to a limit (and thus are never queued) and do not detract from the capacity made available to other priority levels.  A value of `"Limited"` means that (a) requests of this priority level _are_ subject to limits and (b) some of the server's limited capacity is made available exclusively to this priority level. Required.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public PriorityLevelConfigurationSpecBuilder edit() {
        return new PriorityLevelConfigurationSpecBuilder(this);
    }

    @JsonIgnore
    public PriorityLevelConfigurationSpecBuilder toBuilder() {
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
        if (!(o instanceof PriorityLevelConfigurationSpec)) {
            return false;
        }
        PriorityLevelConfigurationSpec other = (PriorityLevelConfigurationSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$exempt = this.getExempt();
        Object other$exempt = other.getExempt();
        if (this$exempt == null ? other$exempt != null : !this$exempt.equals(other$exempt)) {
            return false;
        }
        Object this$limited = this.getLimited();
        Object other$limited = other.getLimited();
        if (this$limited == null ? other$limited != null : !this$limited.equals(other$limited)) {
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
        return other instanceof PriorityLevelConfigurationSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $exempt = this.getExempt();
        result = result * prime + ($exempt == null ? 43 : $exempt.hashCode());
        Object $limited = this.getLimited();
        result = result * prime + ($limited == null ? 43 : $limited.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PriorityLevelConfigurationSpec(" + "exempt=" + this.getExempt() + ", limited=" + this.getLimited() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
