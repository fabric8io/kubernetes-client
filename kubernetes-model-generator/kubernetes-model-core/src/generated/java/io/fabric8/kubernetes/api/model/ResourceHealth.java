
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
 * ResourceHealth represents the health of a resource. It has the latest device health information. This is a part of KEP https://kep.k8s.io/4680.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "health",
    "resourceID"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ResourceHealth implements Editable<ResourceHealthBuilder>, KubernetesResource
{

    @JsonProperty("health")
    private String health;
    @JsonProperty("resourceID")
    private String resourceID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ResourceHealth() {
    }

    public ResourceHealth(String health, String resourceID) {
        super();
        this.health = health;
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
