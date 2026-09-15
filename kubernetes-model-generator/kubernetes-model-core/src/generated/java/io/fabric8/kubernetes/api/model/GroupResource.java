
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
 * GroupResource specifies a Group and a Resource, but does not force a version.  This is useful for identifying concepts during lookup stages without having partially valid types
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "group",
    "resource"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class GroupResource implements Editable<GroupResourceBuilder>, KubernetesResource
{

    @JsonProperty("group")
    private String group;
    @JsonProperty("resource")
    private String resource;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GroupResource() {
    }

    public GroupResource(String group, String resource) {
        super();
        this.group = group;
        this.resource = resource;
    }

    /**
     * GroupResource specifies a Group and a Resource, but does not force a version.  This is useful for identifying concepts during lookup stages without having partially valid types
     */
    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    /**
     * GroupResource specifies a Group and a Resource, but does not force a version.  This is useful for identifying concepts during lookup stages without having partially valid types
     */
    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * GroupResource specifies a Group and a Resource, but does not force a version.  This is useful for identifying concepts during lookup stages without having partially valid types
     */
    @JsonProperty("resource")
    public String getResource() {
        return resource;
    }

    /**
     * GroupResource specifies a Group and a Resource, but does not force a version.  This is useful for identifying concepts during lookup stages without having partially valid types
     */
    @JsonProperty("resource")
    public void setResource(String resource) {
        this.resource = resource;
    }

    @JsonIgnore
    public GroupResourceBuilder edit() {
        return new GroupResourceBuilder(this);
    }

    @JsonIgnore
    public GroupResourceBuilder toBuilder() {
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
        if (!(o instanceof GroupResource)) {
            return false;
        }
        GroupResource other = (GroupResource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$group = this.getGroup();
        Object other$group = other.getGroup();
        if (this$group == null ? other$group != null : !this$group.equals(other$group)) {
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
        return other instanceof GroupResource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $group = this.getGroup();
        result = result * prime + ($group == null ? 43 : $group.hashCode());
        Object $resource = this.getResource();
        result = result * prime + ($resource == null ? 43 : $resource.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GroupResource(" + "group=" + this.getGroup() + ", resource=" + this.getResource() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
