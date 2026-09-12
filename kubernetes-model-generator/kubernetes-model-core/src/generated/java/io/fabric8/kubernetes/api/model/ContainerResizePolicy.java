
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

/**
 * ContainerResizePolicy represents resource resize policy for the container.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "resourceName",
    "restartPolicy"
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
        if (!(o instanceof ContainerResizePolicy)) {
            return false;
        }
        ContainerResizePolicy other = (ContainerResizePolicy) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$resourceName = this.getResourceName();
        Object other$resourceName = other.getResourceName();
        if (this$resourceName == null ? other$resourceName != null : !this$resourceName.equals(other$resourceName)) {
            return false;
        }
        Object this$restartPolicy = this.getRestartPolicy();
        Object other$restartPolicy = other.getRestartPolicy();
        if (this$restartPolicy == null ? other$restartPolicy != null : !this$restartPolicy.equals(other$restartPolicy)) {
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
        return other instanceof ContainerResizePolicy;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $resourceName = this.getResourceName();
        result = result * prime + ($resourceName == null ? 43 : $resourceName.hashCode());
        Object $restartPolicy = this.getRestartPolicy();
        result = result * prime + ($restartPolicy == null ? 43 : $restartPolicy.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ContainerResizePolicy(" + "resourceName=" + this.getResourceName() + ", restartPolicy=" + this.getRestartPolicy() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
