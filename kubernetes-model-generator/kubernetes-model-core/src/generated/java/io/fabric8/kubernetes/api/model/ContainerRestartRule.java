
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ContainerRestartRule describes how a container exit is handled.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "action",
    "exitCodes"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ContainerRestartRule implements Editable<ContainerRestartRuleBuilder>, KubernetesResource
{

    @JsonProperty("action")
    private String action;
    @JsonProperty("exitCodes")
    private ContainerRestartRuleOnExitCodes exitCodes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ContainerRestartRule() {
    }

    public ContainerRestartRule(String action, ContainerRestartRuleOnExitCodes exitCodes) {
        super();
        this.action = action;
        this.exitCodes = exitCodes;
    }

    /**
     * Specifies the action taken on a container exit if the requirements are satisfied. The only possible value is "Restart" to restart the container.
     */
    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    /**
     * Specifies the action taken on a container exit if the requirements are satisfied. The only possible value is "Restart" to restart the container.
     */
    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * ContainerRestartRule describes how a container exit is handled.
     */
    @JsonProperty("exitCodes")
    public ContainerRestartRuleOnExitCodes getExitCodes() {
        return exitCodes;
    }

    /**
     * ContainerRestartRule describes how a container exit is handled.
     */
    @JsonProperty("exitCodes")
    public void setExitCodes(ContainerRestartRuleOnExitCodes exitCodes) {
        this.exitCodes = exitCodes;
    }

    @JsonIgnore
    public ContainerRestartRuleBuilder edit() {
        return new ContainerRestartRuleBuilder(this);
    }

    @JsonIgnore
    public ContainerRestartRuleBuilder toBuilder() {
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
