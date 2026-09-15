
package io.fabric8.kubernetes.api.model.admissionregistration.v1;

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
 * ExpressionWarning is a warning information that targets a specific expression.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fieldRef",
    "warning"
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
public class ExpressionWarning implements Editable<ExpressionWarningBuilder>, KubernetesResource
{

    @JsonProperty("fieldRef")
    private String fieldRef;
    @JsonProperty("warning")
    private String warning;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ExpressionWarning() {
    }

    public ExpressionWarning(String fieldRef, String warning) {
        super();
        this.fieldRef = fieldRef;
        this.warning = warning;
    }

    /**
     * fieldRef is the path to the field that refers to the expression. For example, the reference to the expression of the first item of validations is "spec.validations[0].expression"
     */
    @JsonProperty("fieldRef")
    public String getFieldRef() {
        return fieldRef;
    }

    /**
     * fieldRef is the path to the field that refers to the expression. For example, the reference to the expression of the first item of validations is "spec.validations[0].expression"
     */
    @JsonProperty("fieldRef")
    public void setFieldRef(String fieldRef) {
        this.fieldRef = fieldRef;
    }

    /**
     * warning contains the content of type checking information in a human-readable form. Each line of the warning contains the type that the expression is checked against, followed by the type check error from the compiler.
     */
    @JsonProperty("warning")
    public String getWarning() {
        return warning;
    }

    /**
     * warning contains the content of type checking information in a human-readable form. Each line of the warning contains the type that the expression is checked against, followed by the type check error from the compiler.
     */
    @JsonProperty("warning")
    public void setWarning(String warning) {
        this.warning = warning;
    }

    @JsonIgnore
    public ExpressionWarningBuilder edit() {
        return new ExpressionWarningBuilder(this);
    }

    @JsonIgnore
    public ExpressionWarningBuilder toBuilder() {
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
        if (!(o instanceof ExpressionWarning)) {
            return false;
        }
        ExpressionWarning other = (ExpressionWarning) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$fieldRef = this.getFieldRef();
        Object other$fieldRef = other.getFieldRef();
        if (this$fieldRef == null ? other$fieldRef != null : !this$fieldRef.equals(other$fieldRef)) {
            return false;
        }
        Object this$warning = this.getWarning();
        Object other$warning = other.getWarning();
        if (this$warning == null ? other$warning != null : !this$warning.equals(other$warning)) {
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
        return other instanceof ExpressionWarning;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $fieldRef = this.getFieldRef();
        result = result * prime + ($fieldRef == null ? 43 : $fieldRef.hashCode());
        Object $warning = this.getWarning();
        result = result * prime + ($warning == null ? 43 : $warning.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ExpressionWarning(" + "fieldRef=" + this.getFieldRef() + ", warning=" + this.getWarning() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
