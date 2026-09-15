
package io.fabric8.openshift.api.model.machine.v1alpha1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class SecurityGroupFilter implements Editable<SecurityGroupFilterBuilder>, KubernetesResource
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

    /**
     * description filters security groups by description.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * description filters security groups by description.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * id specifies the ID of a security group to use. If set, id will not be validated before use. An invalid id will result in failure to create a server with an appropriate error message.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * id specifies the ID of a security group to use. If set, id will not be validated before use. An invalid id will result in failure to create a server with an appropriate error message.
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Deprecated: limit is silently ignored. It has no replacement.
     */
    @JsonProperty("limit")
    public Integer getLimit() {
        return limit;
    }

    /**
     * Deprecated: limit is silently ignored. It has no replacement.
     */
    @JsonProperty("limit")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * Deprecated: marker is silently ignored. It has no replacement.
     */
    @JsonProperty("marker")
    public String getMarker() {
        return marker;
    }

    /**
     * Deprecated: marker is silently ignored. It has no replacement.
     */
    @JsonProperty("marker")
    public void setMarker(String marker) {
        this.marker = marker;
    }

    /**
     * name filters security groups by name.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name filters security groups by name.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * notTags filters by security groups which don't match all specified tags. NOT (t1 AND t2...) Multiple tags are comma separated.
     */
    @JsonProperty("notTags")
    public String getNotTags() {
        return notTags;
    }

    /**
     * notTags filters by security groups which don't match all specified tags. NOT (t1 AND t2...) Multiple tags are comma separated.
     */
    @JsonProperty("notTags")
    public void setNotTags(String notTags) {
        this.notTags = notTags;
    }

    /**
     * notTagsAny filters by security groups which don't match any specified tags. NOT (t1 OR t2...) Multiple tags are comma separated.
     */
    @JsonProperty("notTagsAny")
    public String getNotTagsAny() {
        return notTagsAny;
    }

    /**
     * notTagsAny filters by security groups which don't match any specified tags. NOT (t1 OR t2...) Multiple tags are comma separated.
     */
    @JsonProperty("notTagsAny")
    public void setNotTagsAny(String notTagsAny) {
        this.notTagsAny = notTagsAny;
    }

    /**
     * projectId filters security groups by project ID.
     */
    @JsonProperty("projectId")
    public String getProjectId() {
        return projectId;
    }

    /**
     * projectId filters security groups by project ID.
     */
    @JsonProperty("projectId")
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * Deprecated: sortDir is silently ignored. It has no replacement.
     */
    @JsonProperty("sortDir")
    public String getSortDir() {
        return sortDir;
    }

    /**
     * Deprecated: sortDir is silently ignored. It has no replacement.
     */
    @JsonProperty("sortDir")
    public void setSortDir(String sortDir) {
        this.sortDir = sortDir;
    }

    /**
     * Deprecated: sortKey is silently ignored. It has no replacement.
     */
    @JsonProperty("sortKey")
    public String getSortKey() {
        return sortKey;
    }

    /**
     * Deprecated: sortKey is silently ignored. It has no replacement.
     */
    @JsonProperty("sortKey")
    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    /**
     * tags filters by security groups containing all specified tags. Multiple tags are comma separated.
     */
    @JsonProperty("tags")
    public String getTags() {
        return tags;
    }

    /**
     * tags filters by security groups containing all specified tags. Multiple tags are comma separated.
     */
    @JsonProperty("tags")
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * tagsAny filters by security groups containing any specified tags. Multiple tags are comma separated.
     */
    @JsonProperty("tagsAny")
    public String getTagsAny() {
        return tagsAny;
    }

    /**
     * tagsAny filters by security groups containing any specified tags. Multiple tags are comma separated.
     */
    @JsonProperty("tagsAny")
    public void setTagsAny(String tagsAny) {
        this.tagsAny = tagsAny;
    }

    /**
     * tenantId filters security groups by tenant ID. Deprecated: use projectId instead. tenantId will be ignored if projectId is set.
     */
    @JsonProperty("tenantId")
    public String getTenantId() {
        return tenantId;
    }

    /**
     * tenantId filters security groups by tenant ID. Deprecated: use projectId instead. tenantId will be ignored if projectId is set.
     */
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
        if (!(o instanceof SecurityGroupFilter)) {
            return false;
        }
        SecurityGroupFilter other = (SecurityGroupFilter) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$description = this.getDescription();
        Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        Object this$id = this.getId();
        Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
            return false;
        }
        Object this$limit = this.getLimit();
        Object other$limit = other.getLimit();
        if (this$limit == null ? other$limit != null : !this$limit.equals(other$limit)) {
            return false;
        }
        Object this$marker = this.getMarker();
        Object other$marker = other.getMarker();
        if (this$marker == null ? other$marker != null : !this$marker.equals(other$marker)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$notTags = this.getNotTags();
        Object other$notTags = other.getNotTags();
        if (this$notTags == null ? other$notTags != null : !this$notTags.equals(other$notTags)) {
            return false;
        }
        Object this$notTagsAny = this.getNotTagsAny();
        Object other$notTagsAny = other.getNotTagsAny();
        if (this$notTagsAny == null ? other$notTagsAny != null : !this$notTagsAny.equals(other$notTagsAny)) {
            return false;
        }
        Object this$projectId = this.getProjectId();
        Object other$projectId = other.getProjectId();
        if (this$projectId == null ? other$projectId != null : !this$projectId.equals(other$projectId)) {
            return false;
        }
        Object this$sortDir = this.getSortDir();
        Object other$sortDir = other.getSortDir();
        if (this$sortDir == null ? other$sortDir != null : !this$sortDir.equals(other$sortDir)) {
            return false;
        }
        Object this$sortKey = this.getSortKey();
        Object other$sortKey = other.getSortKey();
        if (this$sortKey == null ? other$sortKey != null : !this$sortKey.equals(other$sortKey)) {
            return false;
        }
        Object this$tags = this.getTags();
        Object other$tags = other.getTags();
        if (this$tags == null ? other$tags != null : !this$tags.equals(other$tags)) {
            return false;
        }
        Object this$tagsAny = this.getTagsAny();
        Object other$tagsAny = other.getTagsAny();
        if (this$tagsAny == null ? other$tagsAny != null : !this$tagsAny.equals(other$tagsAny)) {
            return false;
        }
        Object this$tenantId = this.getTenantId();
        Object other$tenantId = other.getTenantId();
        if (this$tenantId == null ? other$tenantId != null : !this$tenantId.equals(other$tenantId)) {
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
        return other instanceof SecurityGroupFilter;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $description = this.getDescription();
        result = result * prime + ($description == null ? 43 : $description.hashCode());
        Object $id = this.getId();
        result = result * prime + ($id == null ? 43 : $id.hashCode());
        Object $limit = this.getLimit();
        result = result * prime + ($limit == null ? 43 : $limit.hashCode());
        Object $marker = this.getMarker();
        result = result * prime + ($marker == null ? 43 : $marker.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $notTags = this.getNotTags();
        result = result * prime + ($notTags == null ? 43 : $notTags.hashCode());
        Object $notTagsAny = this.getNotTagsAny();
        result = result * prime + ($notTagsAny == null ? 43 : $notTagsAny.hashCode());
        Object $projectId = this.getProjectId();
        result = result * prime + ($projectId == null ? 43 : $projectId.hashCode());
        Object $sortDir = this.getSortDir();
        result = result * prime + ($sortDir == null ? 43 : $sortDir.hashCode());
        Object $sortKey = this.getSortKey();
        result = result * prime + ($sortKey == null ? 43 : $sortKey.hashCode());
        Object $tags = this.getTags();
        result = result * prime + ($tags == null ? 43 : $tags.hashCode());
        Object $tagsAny = this.getTagsAny();
        result = result * prime + ($tagsAny == null ? 43 : $tagsAny.hashCode());
        Object $tenantId = this.getTenantId();
        result = result * prime + ($tenantId == null ? 43 : $tenantId.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SecurityGroupFilter(" + "description=" + this.getDescription() + ", id=" + this.getId() + ", limit=" + this.getLimit() + ", marker=" + this.getMarker() + ", name=" + this.getName() + ", notTags=" + this.getNotTags() + ", notTagsAny=" + this.getNotTagsAny() + ", projectId=" + this.getProjectId() + ", sortDir=" + this.getSortDir() + ", sortKey=" + this.getSortKey() + ", tags=" + this.getTags() + ", tagsAny=" + this.getTagsAny() + ", tenantId=" + this.getTenantId() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
