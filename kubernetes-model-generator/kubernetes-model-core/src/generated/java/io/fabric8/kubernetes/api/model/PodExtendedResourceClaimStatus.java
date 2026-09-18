
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
 * PodExtendedResourceClaimStatus is stored in the PodStatus for the extended resource requests backed by DRA. It stores the generated name for the corresponding special ResourceClaim created by the scheduler.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "requestMappings",
    "resourceClaimName"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PodExtendedResourceClaimStatus implements Editable<PodExtendedResourceClaimStatusBuilder>, KubernetesResource
{

    @JsonProperty("requestMappings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ContainerExtendedResourceRequest> requestMappings = new ArrayList<>();
    @JsonProperty("resourceClaimName")
    private String resourceClaimName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodExtendedResourceClaimStatus() {
    }

    public PodExtendedResourceClaimStatus(List<ContainerExtendedResourceRequest> requestMappings, String resourceClaimName) {
        super();
        this.requestMappings = requestMappings;
        this.resourceClaimName = resourceClaimName;
    }

    /**
     * RequestMappings identifies the mapping of &lt;container, extended resource backed by DRA&gt; to  device request in the generated ResourceClaim.
     */
    @JsonProperty("requestMappings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ContainerExtendedResourceRequest> getRequestMappings() {
        return requestMappings;
    }

    /**
     * RequestMappings identifies the mapping of &lt;container, extended resource backed by DRA&gt; to  device request in the generated ResourceClaim.
     */
    @JsonProperty("requestMappings")
    public void setRequestMappings(List<ContainerExtendedResourceRequest> requestMappings) {
        this.requestMappings = requestMappings;
    }

    /**
     * ResourceClaimName is the name of the ResourceClaim that was generated for the Pod in the namespace of the Pod.
     */
    @JsonProperty("resourceClaimName")
    public String getResourceClaimName() {
        return resourceClaimName;
    }

    /**
     * ResourceClaimName is the name of the ResourceClaim that was generated for the Pod in the namespace of the Pod.
     */
    @JsonProperty("resourceClaimName")
    public void setResourceClaimName(String resourceClaimName) {
        this.resourceClaimName = resourceClaimName;
    }

    @JsonIgnore
    public PodExtendedResourceClaimStatusBuilder edit() {
        return new PodExtendedResourceClaimStatusBuilder(this);
    }

    @JsonIgnore
    public PodExtendedResourceClaimStatusBuilder toBuilder() {
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
        if (!(o instanceof PodExtendedResourceClaimStatus)) {
            return false;
        }
        PodExtendedResourceClaimStatus other = (PodExtendedResourceClaimStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$requestMappings = this.getRequestMappings();
        Object other$requestMappings = other.getRequestMappings();
        if (this$requestMappings == null ? other$requestMappings != null : !this$requestMappings.equals(other$requestMappings)) {
            return false;
        }
        Object this$resourceClaimName = this.getResourceClaimName();
        Object other$resourceClaimName = other.getResourceClaimName();
        if (this$resourceClaimName == null ? other$resourceClaimName != null : !this$resourceClaimName.equals(other$resourceClaimName)) {
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
        return other instanceof PodExtendedResourceClaimStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $requestMappings = this.getRequestMappings();
        result = result * prime + ($requestMappings == null ? 43 : $requestMappings.hashCode());
        Object $resourceClaimName = this.getResourceClaimName();
        result = result * prime + ($resourceClaimName == null ? 43 : $resourceClaimName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PodExtendedResourceClaimStatus(" + "requestMappings=" + this.getRequestMappings() + ", resourceClaimName=" + this.getResourceClaimName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
