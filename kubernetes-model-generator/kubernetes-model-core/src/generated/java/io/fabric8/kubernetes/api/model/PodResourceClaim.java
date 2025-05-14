
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
 * PodResourceClaim references exactly one ResourceClaim, either directly or by naming a ResourceClaimTemplate which is then turned into a ResourceClaim for the pod.<br><p> <br><p> It adds a name to it that uniquely identifies the ResourceClaim inside the Pod. Containers that need access to the ResourceClaim reference it with this name.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "resourceClaimName",
    "resourceClaimTemplateName"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PodResourceClaim implements Editable<PodResourceClaimBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("resourceClaimName")
    private String resourceClaimName;
    @JsonProperty("resourceClaimTemplateName")
    private String resourceClaimTemplateName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodResourceClaim() {
    }

    public PodResourceClaim(String name, String resourceClaimName, String resourceClaimTemplateName) {
        super();
        this.name = name;
        this.resourceClaimName = resourceClaimName;
        this.resourceClaimTemplateName = resourceClaimTemplateName;
    }

    /**
     * Name uniquely identifies this resource claim inside the pod. This must be a DNS_LABEL.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name uniquely identifies this resource claim inside the pod. This must be a DNS_LABEL.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ResourceClaimName is the name of a ResourceClaim object in the same namespace as this pod.<br><p> <br><p> Exactly one of ResourceClaimName and ResourceClaimTemplateName must be set.
     */
    @JsonProperty("resourceClaimName")
    public String getResourceClaimName() {
        return resourceClaimName;
    }

    /**
     * ResourceClaimName is the name of a ResourceClaim object in the same namespace as this pod.<br><p> <br><p> Exactly one of ResourceClaimName and ResourceClaimTemplateName must be set.
     */
    @JsonProperty("resourceClaimName")
    public void setResourceClaimName(String resourceClaimName) {
        this.resourceClaimName = resourceClaimName;
    }

    /**
     * ResourceClaimTemplateName is the name of a ResourceClaimTemplate object in the same namespace as this pod.<br><p> <br><p> The template will be used to create a new ResourceClaim, which will be bound to this pod. When this pod is deleted, the ResourceClaim will also be deleted. The pod name and resource name, along with a generated component, will be used to form a unique name for the ResourceClaim, which will be recorded in pod.status.resourceClaimStatuses.<br><p> <br><p> This field is immutable and no changes will be made to the corresponding ResourceClaim by the control plane after creating the ResourceClaim.<br><p> <br><p> Exactly one of ResourceClaimName and ResourceClaimTemplateName must be set.
     */
    @JsonProperty("resourceClaimTemplateName")
    public String getResourceClaimTemplateName() {
        return resourceClaimTemplateName;
    }

    /**
     * ResourceClaimTemplateName is the name of a ResourceClaimTemplate object in the same namespace as this pod.<br><p> <br><p> The template will be used to create a new ResourceClaim, which will be bound to this pod. When this pod is deleted, the ResourceClaim will also be deleted. The pod name and resource name, along with a generated component, will be used to form a unique name for the ResourceClaim, which will be recorded in pod.status.resourceClaimStatuses.<br><p> <br><p> This field is immutable and no changes will be made to the corresponding ResourceClaim by the control plane after creating the ResourceClaim.<br><p> <br><p> Exactly one of ResourceClaimName and ResourceClaimTemplateName must be set.
     */
    @JsonProperty("resourceClaimTemplateName")
    public void setResourceClaimTemplateName(String resourceClaimTemplateName) {
        this.resourceClaimTemplateName = resourceClaimTemplateName;
    }

    @JsonIgnore
    public PodResourceClaimBuilder edit() {
        return new PodResourceClaimBuilder(this);
    }

    @JsonIgnore
    public PodResourceClaimBuilder toBuilder() {
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
