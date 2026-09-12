
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;

/**
 * ContainerRestartRuleOnExitCodes describes the condition for handling an exited container based on its exit codes.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "operator",
    "values"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ContainerRestartRuleOnExitCodes implements Editable<ContainerRestartRuleOnExitCodesBuilder>, KubernetesResource
{

    @JsonProperty("operator")
    private String operator;
    @JsonProperty("values")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Integer> values = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ContainerRestartRuleOnExitCodes() {
    }

    public ContainerRestartRuleOnExitCodes(String operator, List<Integer> values) {
        super();
        this.operator = operator;
        this.values = values;
    }

    /**
     * Represents the relationship between the container exit code(s) and the specified values. Possible values are: - In: the requirement is satisfied if the container exit code is in the<br><p>   set of specified values.<br><p> - NotIn: the requirement is satisfied if the container exit code is<br><p>   not in the set of specified values.
     */
    @JsonProperty("operator")
    public String getOperator() {
        return operator;
    }

    /**
     * Represents the relationship between the container exit code(s) and the specified values. Possible values are: - In: the requirement is satisfied if the container exit code is in the<br><p>   set of specified values.<br><p> - NotIn: the requirement is satisfied if the container exit code is<br><p>   not in the set of specified values.
     */
    @JsonProperty("operator")
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * Specifies the set of values to check for container exit codes. At most 255 elements are allowed.
     */
    @JsonProperty("values")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Integer> getValues() {
        return values;
    }

    /**
     * Specifies the set of values to check for container exit codes. At most 255 elements are allowed.
     */
    @JsonProperty("values")
    public void setValues(List<Integer> values) {
        this.values = values;
    }

    @JsonIgnore
    public ContainerRestartRuleOnExitCodesBuilder edit() {
        return new ContainerRestartRuleOnExitCodesBuilder(this);
    }

    @JsonIgnore
    public ContainerRestartRuleOnExitCodesBuilder toBuilder() {
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
        if (!(o instanceof ContainerRestartRuleOnExitCodes)) {
            return false;
        }
        ContainerRestartRuleOnExitCodes other = (ContainerRestartRuleOnExitCodes) o;
        if (!other.canEqual(this)) {
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
        return other instanceof ContainerRestartRuleOnExitCodes;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
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
        return "ContainerRestartRuleOnExitCodes(" + "operator=" + this.getOperator() + ", values=" + this.getValues() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
