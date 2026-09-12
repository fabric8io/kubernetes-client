
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
 * ResourceHealth represents the health of a resource. It has the latest device health information. This is a part of KEP https://kep.k8s.io/4680.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "health",
    "message",
    "resourceID"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ResourceHealth implements Editable<ResourceHealthBuilder>, KubernetesResource
{

    @JsonProperty("health")
    private String health;
    @JsonProperty("message")
    private String message;
    @JsonProperty("resourceID")
    private String resourceID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ResourceHealth() {
    }

    public ResourceHealth(String health, String message, String resourceID) {
        super();
        this.health = health;
        this.message = message;
        this.resourceID = resourceID;
    }

    /**
     * Health of the resource. can be one of:<br><p>  - Healthy: operates as normal<br><p>  - Unhealthy: reported unhealthy. We consider this a temporary health issue<br><p>               since we do not have a mechanism today to distinguish<br><p>               temporary and permanent issues.<br><p>  - Unknown: The status cannot be determined.<br><p>             For example, Device Plugin got unregistered and hasn't been re-registered since.<br><p> <br><p> In future we may want to introduce the PermanentlyUnhealthy Status.
     */
    @JsonProperty("health")
    public String getHealth() {
        return health;
    }

    /**
     * Health of the resource. can be one of:<br><p>  - Healthy: operates as normal<br><p>  - Unhealthy: reported unhealthy. We consider this a temporary health issue<br><p>               since we do not have a mechanism today to distinguish<br><p>               temporary and permanent issues.<br><p>  - Unknown: The status cannot be determined.<br><p>             For example, Device Plugin got unregistered and hasn't been re-registered since.<br><p> <br><p> In future we may want to introduce the PermanentlyUnhealthy Status.
     */
    @JsonProperty("health")
    public void setHealth(String health) {
        this.health = health;
    }

    /**
     * Message provides human-readable context for Health (e.g. "ECC error count exceeded threshold"). This field is populated by the kubelet when ResourceHealthStatusMessage is enabled if the DRA plugin returns a message, and is null otherwise.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * Message provides human-readable context for Health (e.g. "ECC error count exceeded threshold"). This field is populated by the kubelet when ResourceHealthStatusMessage is enabled if the DRA plugin returns a message, and is null otherwise.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * ResourceID is the unique identifier of the resource. See the ResourceID type for more information.
     */
    @JsonProperty("resourceID")
    public String getResourceID() {
        return resourceID;
    }

    /**
     * ResourceID is the unique identifier of the resource. See the ResourceID type for more information.
     */
    @JsonProperty("resourceID")
    public void setResourceID(String resourceID) {
        this.resourceID = resourceID;
    }

    @JsonIgnore
    public ResourceHealthBuilder edit() {
        return new ResourceHealthBuilder(this);
    }

    @JsonIgnore
    public ResourceHealthBuilder toBuilder() {
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
        if (!(o instanceof ResourceHealth)) {
            return false;
        }
        ResourceHealth other = (ResourceHealth) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$health = this.getHealth();
        Object other$health = other.getHealth();
        if (this$health == null ? other$health != null : !this$health.equals(other$health)) {
            return false;
        }
        Object this$message = this.getMessage();
        Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) {
            return false;
        }
        Object this$resourceID = this.getResourceID();
        Object other$resourceID = other.getResourceID();
        if (this$resourceID == null ? other$resourceID != null : !this$resourceID.equals(other$resourceID)) {
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
        return other instanceof ResourceHealth;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $health = this.getHealth();
        result = result * prime + ($health == null ? 43 : $health.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $resourceID = this.getResourceID();
        result = result * prime + ($resourceID == null ? 43 : $resourceID.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ResourceHealth(" + "health=" + this.getHealth() + ", message=" + this.getMessage() + ", resourceID=" + this.getResourceID() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
