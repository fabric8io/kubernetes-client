
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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

}
