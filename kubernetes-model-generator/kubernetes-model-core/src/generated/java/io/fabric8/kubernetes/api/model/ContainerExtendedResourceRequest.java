
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
 * ContainerExtendedResourceRequest has the mapping of container name, extended resource name to the device request name.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "containerName",
    "requestName",
    "resourceName"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ContainerExtendedResourceRequest implements Editable<ContainerExtendedResourceRequestBuilder>, KubernetesResource
{

    @JsonProperty("containerName")
    private String containerName;
    @JsonProperty("requestName")
    private String requestName;
    @JsonProperty("resourceName")
    private String resourceName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ContainerExtendedResourceRequest() {
    }

    public ContainerExtendedResourceRequest(String containerName, String requestName, String resourceName) {
        super();
        this.containerName = containerName;
        this.requestName = requestName;
        this.resourceName = resourceName;
    }

    /**
     * The name of the container requesting resources.
     */
    @JsonProperty("containerName")
    public String getContainerName() {
        return containerName;
    }

    /**
     * The name of the container requesting resources.
     */
    @JsonProperty("containerName")
    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    /**
     * The name of the request in the special ResourceClaim which corresponds to the extended resource.
     */
    @JsonProperty("requestName")
    public String getRequestName() {
        return requestName;
    }

    /**
     * The name of the request in the special ResourceClaim which corresponds to the extended resource.
     */
    @JsonProperty("requestName")
    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    /**
     * The name of the extended resource in that container which gets backed by DRA.
     */
    @JsonProperty("resourceName")
    public String getResourceName() {
        return resourceName;
    }

    /**
     * The name of the extended resource in that container which gets backed by DRA.
     */
    @JsonProperty("resourceName")
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @JsonIgnore
    public ContainerExtendedResourceRequestBuilder edit() {
        return new ContainerExtendedResourceRequestBuilder(this);
    }

    @JsonIgnore
    public ContainerExtendedResourceRequestBuilder toBuilder() {
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
