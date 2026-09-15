
package io.fabric8.tekton.v1beta1;

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
 * WhenExpression allows a PipelineTask to declare expressions to be evaluated before the Task is run to determine whether the Task should be executed or skipped
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cel",
    "input",
    "operator",
    "values"
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
public class WhenExpression implements Editable<WhenExpressionBuilder>, KubernetesResource
{

    @JsonProperty("cel")
    private String cel;
    @JsonProperty("input")
    private String input;
    @JsonProperty("operator")
    private String operator;
    @JsonProperty("values")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> values = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WhenExpression() {
    }

    public WhenExpression(String cel, String input, String operator, List<String> values) {
        super();
        this.cel = cel;
        this.input = input;
        this.operator = operator;
        this.values = values;
    }

    /**
     * CEL is a string of Common Language Expression, which can be used to conditionally execute the task based on the result of the expression evaluation More info about CEL syntax: https://github.com/google/cel-spec/blob/master/doc/langdef.md
     */
    @JsonProperty("cel")
    public String getCel() {
        return cel;
    }

    /**
     * CEL is a string of Common Language Expression, which can be used to conditionally execute the task based on the result of the expression evaluation More info about CEL syntax: https://github.com/google/cel-spec/blob/master/doc/langdef.md
     */
    @JsonProperty("cel")
    public void setCel(String cel) {
        this.cel = cel;
    }

    /**
     * Input is the string for guard checking which can be a static input or an output from a parent Task
     */
    @JsonProperty("input")
    public String getInput() {
        return input;
    }

    /**
     * Input is the string for guard checking which can be a static input or an output from a parent Task
     */
    @JsonProperty("input")
    public void setInput(String input) {
        this.input = input;
    }

    /**
     * Operator that represents an Input's relationship to the values
     */
    @JsonProperty("operator")
    public String getOperator() {
        return operator;
    }

    /**
     * Operator that represents an Input's relationship to the values
     */
    @JsonProperty("operator")
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * Values is an array of strings, which is compared against the input, for guard checking It must be non-empty
     */
    @JsonProperty("values")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getValues() {
        return values;
    }

    /**
     * Values is an array of strings, which is compared against the input, for guard checking It must be non-empty
     */
    @JsonProperty("values")
    public void setValues(List<String> values) {
        this.values = values;
    }

    @JsonIgnore
    public WhenExpressionBuilder edit() {
        return new WhenExpressionBuilder(this);
    }

    @JsonIgnore
    public WhenExpressionBuilder toBuilder() {
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
        if (!(o instanceof WhenExpression)) {
            return false;
        }
        WhenExpression other = (WhenExpression) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cel = this.getCel();
        Object other$cel = other.getCel();
        if (this$cel == null ? other$cel != null : !this$cel.equals(other$cel)) {
            return false;
        }
        Object this$input = this.getInput();
        Object other$input = other.getInput();
        if (this$input == null ? other$input != null : !this$input.equals(other$input)) {
            return false;
        }
        Object this$operator = this.getOperator();
        Object other$operator = other.getOperator();
        if (this$operator == null ? other$operator != null : !this$operator.equals(other$operator)) {
            return false;
        }
        Object this$values = this.getValues();
        Object other$values = other.getValues();
        if (this$values == null ? other$values != null : !this$values.equals(other$values)) {
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
        return other instanceof WhenExpression;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cel = this.getCel();
        result = result * prime + ($cel == null ? 43 : $cel.hashCode());
        Object $input = this.getInput();
        result = result * prime + ($input == null ? 43 : $input.hashCode());
        Object $operator = this.getOperator();
        result = result * prime + ($operator == null ? 43 : $operator.hashCode());
        Object $values = this.getValues();
        result = result * prime + ($values == null ? 43 : $values.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "WhenExpression(" + "cel=" + this.getCel() + ", input=" + this.getInput() + ", operator=" + this.getOperator() + ", values=" + this.getValues() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
