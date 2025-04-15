
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
 * ContainerResizePolicy represents resource resize policy for the container.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "resourceName",
    "restartPolicy"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ContainerResizePolicy implements Editable<ContainerResizePolicyBuilder>, KubernetesResource
{

    @JsonProperty("resourceName")
    private String resourceName;
    @JsonProperty("restartPolicy")
    private String restartPolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ContainerResizePolicy() {
    }

    public ContainerResizePolicy(String resourceName, String restartPolicy) {
        super();
        this.resourceName = resourceName;
        this.restartPolicy = restartPolicy;
    }

    /**
     * Name of the resource to which this resource resize policy applies. Supported values: cpu, memory.
     */
    @JsonProperty("resourceName")
    public String getResourceName() {
        return resourceName;
    }

    /**
     * Name of the resource to which this resource resize policy applies. Supported values: cpu, memory.
     */
    @JsonProperty("resourceName")
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * Restart policy to apply when specified resource is resized. If not specified, it defaults to NotRequired.
     */
    @JsonProperty("restartPolicy")
    public String getRestartPolicy() {
        return restartPolicy;
    }

    /**
     * Restart policy to apply when specified resource is resized. If not specified, it defaults to NotRequired.
     */
    @JsonProperty("restartPolicy")
    public void setRestartPolicy(String restartPolicy) {
        this.restartPolicy = restartPolicy;
    }

    @JsonIgnore
    public ContainerResizePolicyBuilder edit() {
        return new ContainerResizePolicyBuilder(this);
    }

    @JsonIgnore
    public ContainerResizePolicyBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
