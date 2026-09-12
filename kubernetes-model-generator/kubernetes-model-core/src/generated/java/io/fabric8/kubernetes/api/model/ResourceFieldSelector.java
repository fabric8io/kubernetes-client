
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
 * ResourceFieldSelector represents container resources (cpu, memory) and their output format
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "containerName",
    "divisor",
    "resource"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ResourceFieldSelector implements Editable<ResourceFieldSelectorBuilder>, KubernetesResource
{

    @JsonProperty("containerName")
    private String containerName;
    @JsonProperty("divisor")
    private Quantity divisor;
    @JsonProperty("resource")
    private String resource;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ResourceFieldSelector() {
    }

    public ResourceFieldSelector(String containerName, Quantity divisor, String resource) {
        super();
        this.containerName = containerName;
        this.divisor = divisor;
        this.resource = resource;
    }

    /**
     * Container name: required for volumes, optional for env vars
     */
    @JsonProperty("containerName")
    public String getContainerName() {
        return containerName;
    }

    /**
     * Container name: required for volumes, optional for env vars
     */
    @JsonProperty("containerName")
    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    /**
     * ResourceFieldSelector represents container resources (cpu, memory) and their output format
     */
    @JsonProperty("divisor")
    public Quantity getDivisor() {
        return divisor;
    }

    /**
     * ResourceFieldSelector represents container resources (cpu, memory) and their output format
     */
    @JsonProperty("divisor")
    public void setDivisor(Quantity divisor) {
        this.divisor = divisor;
    }

    /**
     * Required: resource to select
     */
    @JsonProperty("resource")
    public String getResource() {
        return resource;
    }

    /**
     * Required: resource to select
     */
    @JsonProperty("resource")
    public void setResource(String resource) {
        this.resource = resource;
    }

    @JsonIgnore
    public ResourceFieldSelectorBuilder edit() {
        return new ResourceFieldSelectorBuilder(this);
    }

    @JsonIgnore
    public ResourceFieldSelectorBuilder toBuilder() {
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
        if (!(o instanceof ResourceFieldSelector)) {
            return false;
        }
        ResourceFieldSelector other = (ResourceFieldSelector) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$containerName = this.getContainerName();
        Object other$containerName = other.getContainerName();
        if (this$containerName == null ? other$containerName != null : !this$containerName.equals(other$containerName)) {
            return false;
        }
        Object this$divisor = this.getDivisor();
        Object other$divisor = other.getDivisor();
        if (this$divisor == null ? other$divisor != null : !this$divisor.equals(other$divisor)) {
            return false;
        }
        Object this$resource = this.getResource();
        Object other$resource = other.getResource();
        if (this$resource == null ? other$resource != null : !this$resource.equals(other$resource)) {
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
        return other instanceof ResourceFieldSelector;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $containerName = this.getContainerName();
        result = result * prime + ($containerName == null ? 43 : $containerName.hashCode());
        Object $divisor = this.getDivisor();
        result = result * prime + ($divisor == null ? 43 : $divisor.hashCode());
        Object $resource = this.getResource();
        result = result * prime + ($resource == null ? 43 : $resource.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ResourceFieldSelector(" + "containerName=" + this.getContainerName() + ", divisor=" + this.getDivisor() + ", resource=" + this.getResource() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
