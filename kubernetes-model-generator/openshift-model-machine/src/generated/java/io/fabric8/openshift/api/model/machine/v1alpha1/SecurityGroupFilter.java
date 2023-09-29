
package io.fabric8.openshift.api.model.machine.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "description",
    "id",
    "limit",
    "marker",
    "name",
    "notTags",
    "notTagsAny",
    "projectId",
    "sortDir",
    "sortKey",
    "tags",
    "tagsAny",
    "tenantId"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class SecurityGroupFilter implements Editable<SecurityGroupFilterBuilder> , KubernetesResource
{

    @JsonProperty("description")
    private String description;
    @JsonProperty("id")
    private String id;
    @JsonProperty("limit")
    private Integer limit;
    @JsonProperty("marker")
    private String marker;
    @JsonProperty("name")
    private String name;
    @JsonProperty("notTags")
    private String notTags;
    @JsonProperty("notTagsAny")
    private String notTagsAny;
    @JsonProperty("projectId")
    private String projectId;
    @JsonProperty("sortDir")
    private String sortDir;
    @JsonProperty("sortKey")
    private String sortKey;
    @JsonProperty("tags")
    private String tags;
    @JsonProperty("tagsAny")
    private String tagsAny;
    @JsonProperty("tenantId")
    private String tenantId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SecurityGroupFilter() {
    }

    public SecurityGroupFilter(String description, String id, Integer limit, String marker, String name, String notTags, String notTagsAny, String projectId, String sortDir, String sortKey, String tags, String tagsAny, String tenantId) {
        super();
        this.description = description;
        this.id = id;
        this.limit = limit;
        this.marker = marker;
        this.name = name;
        this.notTags = notTags;
        this.notTagsAny = notTagsAny;
        this.projectId = projectId;
        this.sortDir = sortDir;
        this.sortKey = sortKey;
        this.tags = tags;
        this.tagsAny = tagsAny;
        this.tenantId = tenantId;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("limit")
    public Integer getLimit() {
        return limit;
    }

    @JsonProperty("limit")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @JsonProperty("marker")
    public String getMarker() {
        return marker;
    }

    @JsonProperty("marker")
    public void setMarker(String marker) {
        this.marker = marker;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("notTags")
    public String getNotTags() {
        return notTags;
    }

    @JsonProperty("notTags")
    public void setNotTags(String notTags) {
        this.notTags = notTags;
    }

    @JsonProperty("notTagsAny")
    public String getNotTagsAny() {
        return notTagsAny;
    }

    @JsonProperty("notTagsAny")
    public void setNotTagsAny(String notTagsAny) {
        this.notTagsAny = notTagsAny;
    }

    @JsonProperty("projectId")
    public String getProjectId() {
        return projectId;
    }

    @JsonProperty("projectId")
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @JsonProperty("sortDir")
    public String getSortDir() {
        return sortDir;
    }

    @JsonProperty("sortDir")
    public void setSortDir(String sortDir) {
        this.sortDir = sortDir;
    }

    @JsonProperty("sortKey")
    public String getSortKey() {
        return sortKey;
    }

    @JsonProperty("sortKey")
    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    @JsonProperty("tags")
    public String getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(String tags) {
        this.tags = tags;
    }

    @JsonProperty("tagsAny")
    public String getTagsAny() {
        return tagsAny;
    }

    @JsonProperty("tagsAny")
    public void setTagsAny(String tagsAny) {
        this.tagsAny = tagsAny;
    }

    @JsonProperty("tenantId")
    public String getTenantId() {
        return tenantId;
    }

    @JsonProperty("tenantId")
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @JsonIgnore
    public SecurityGroupFilterBuilder edit() {
        return new SecurityGroupFilterBuilder(this);
    }

    @JsonIgnore
    public SecurityGroupFilterBuilder toBuilder() {
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

}
