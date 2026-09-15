
package io.fabric8.certmanager.api.model.v1;

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
 * NameConstraints is a type to represent x509 NameConstraints
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "critical",
    "excluded",
    "permitted"
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
public class NameConstraints implements Editable<NameConstraintsBuilder>, KubernetesResource
{

    @JsonProperty("critical")
    private Boolean critical;
    @JsonProperty("excluded")
    private NameConstraintItem excluded;
    @JsonProperty("permitted")
    private NameConstraintItem permitted;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NameConstraints() {
    }

    public NameConstraints(Boolean critical, NameConstraintItem excluded, NameConstraintItem permitted) {
        super();
        this.critical = critical;
        this.excluded = excluded;
        this.permitted = permitted;
    }

    /**
     * if true then the name constraints are marked critical.
     */
    @JsonProperty("critical")
    public Boolean getCritical() {
        return critical;
    }

    /**
     * if true then the name constraints are marked critical.
     */
    @JsonProperty("critical")
    public void setCritical(Boolean critical) {
        this.critical = critical;
    }

    /**
     * NameConstraints is a type to represent x509 NameConstraints
     */
    @JsonProperty("excluded")
    public NameConstraintItem getExcluded() {
        return excluded;
    }

    /**
     * NameConstraints is a type to represent x509 NameConstraints
     */
    @JsonProperty("excluded")
    public void setExcluded(NameConstraintItem excluded) {
        this.excluded = excluded;
    }

    /**
     * NameConstraints is a type to represent x509 NameConstraints
     */
    @JsonProperty("permitted")
    public NameConstraintItem getPermitted() {
        return permitted;
    }

    /**
     * NameConstraints is a type to represent x509 NameConstraints
     */
    @JsonProperty("permitted")
    public void setPermitted(NameConstraintItem permitted) {
        this.permitted = permitted;
    }

    @JsonIgnore
    public NameConstraintsBuilder edit() {
        return new NameConstraintsBuilder(this);
    }

    @JsonIgnore
    public NameConstraintsBuilder toBuilder() {
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
        if (!(o instanceof NameConstraints)) {
            return false;
        }
        NameConstraints other = (NameConstraints) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$critical = this.getCritical();
        Object other$critical = other.getCritical();
        if (this$critical == null ? other$critical != null : !this$critical.equals(other$critical)) {
            return false;
        }
        Object this$excluded = this.getExcluded();
        Object other$excluded = other.getExcluded();
        if (this$excluded == null ? other$excluded != null : !this$excluded.equals(other$excluded)) {
            return false;
        }
        Object this$permitted = this.getPermitted();
        Object other$permitted = other.getPermitted();
        if (this$permitted == null ? other$permitted != null : !this$permitted.equals(other$permitted)) {
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
        return other instanceof NameConstraints;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $critical = this.getCritical();
        result = result * prime + ($critical == null ? 43 : $critical.hashCode());
        Object $excluded = this.getExcluded();
        result = result * prime + ($excluded == null ? 43 : $excluded.hashCode());
        Object $permitted = this.getPermitted();
        result = result * prime + ($permitted == null ? 43 : $permitted.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NameConstraints(" + "critical=" + this.getCritical() + ", excluded=" + this.getExcluded() + ", permitted=" + this.getPermitted() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
