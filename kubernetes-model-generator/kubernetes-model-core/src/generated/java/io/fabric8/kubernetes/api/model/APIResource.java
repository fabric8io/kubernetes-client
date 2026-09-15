
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
 * APIResource specifies the name of a resource and whether it is namespaced.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "categories",
    "group",
    "name",
    "namespaced",
    "shortNames",
    "singularName",
    "storageVersionHash",
    "verbs",
    "version"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class APIResource implements Editable<APIResourceBuilder>, KubernetesResource
{

    @JsonProperty("categories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> categories = new ArrayList<>();
    @JsonProperty("group")
    private String group;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("name")
    private String name;
    @JsonProperty("namespaced")
    private Boolean namespaced;
    @JsonProperty("shortNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> shortNames = new ArrayList<>();
    @JsonProperty("singularName")
    private String singularName;
    @JsonProperty("storageVersionHash")
    private String storageVersionHash;
    @JsonProperty("verbs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> verbs = new ArrayList<>();
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public APIResource() {
    }

    public APIResource(List<String> categories, String group, String kind, String name, Boolean namespaced, List<String> shortNames, String singularName, String storageVersionHash, List<String> verbs, String version) {
        super();
        this.categories = categories;
        this.group = group;
        this.kind = kind;
        this.name = name;
        this.namespaced = namespaced;
        this.shortNames = shortNames;
        this.singularName = singularName;
        this.storageVersionHash = storageVersionHash;
        this.verbs = verbs;
        this.version = version;
    }

    /**
     * categories is a list of the grouped resources this resource belongs to (e.g. 'all')
     */
    @JsonProperty("categories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCategories() {
        return categories;
    }

    /**
     * categories is a list of the grouped resources this resource belongs to (e.g. 'all')
     */
    @JsonProperty("categories")
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    /**
     * group is the preferred group of the resource.  Empty implies the group of the containing resource list. For subresources, this may have a different value, for example: Scale".
     */
    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    /**
     * group is the preferred group of the resource.  Empty implies the group of the containing resource list. For subresources, this may have a different value, for example: Scale".
     */
    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * kind is the kind for the resource (e.g. 'Foo' is the kind for a resource 'foo')
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * kind is the kind for the resource (e.g. 'Foo' is the kind for a resource 'foo')
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * name is the plural name of the resource.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is the plural name of the resource.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * namespaced indicates if a resource is namespaced or not.
     */
    @JsonProperty("namespaced")
    public Boolean getNamespaced() {
        return namespaced;
    }

    /**
     * namespaced indicates if a resource is namespaced or not.
     */
    @JsonProperty("namespaced")
    public void setNamespaced(Boolean namespaced) {
        this.namespaced = namespaced;
    }

    /**
     * shortNames is a list of suggested short names of the resource.
     */
    @JsonProperty("shortNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getShortNames() {
        return shortNames;
    }

    /**
     * shortNames is a list of suggested short names of the resource.
     */
    @JsonProperty("shortNames")
    public void setShortNames(List<String> shortNames) {
        this.shortNames = shortNames;
    }

    /**
     * singularName is the singular name of the resource.  This allows clients to handle plural and singular opaquely. The singularName is more correct for reporting status on a single item and both singular and plural are allowed from the kubectl CLI interface.
     */
    @JsonProperty("singularName")
    public String getSingularName() {
        return singularName;
    }

    /**
     * singularName is the singular name of the resource.  This allows clients to handle plural and singular opaquely. The singularName is more correct for reporting status on a single item and both singular and plural are allowed from the kubectl CLI interface.
     */
    @JsonProperty("singularName")
    public void setSingularName(String singularName) {
        this.singularName = singularName;
    }

    /**
     * The hash value of the storage version, the version this resource is converted to when written to the data store. Value must be treated as opaque by clients. Only equality comparison on the value is valid. This is an alpha feature and may change or be removed in the future. The field is populated by the apiserver only if the StorageVersionHash feature gate is enabled. This field will remain optional even if it graduates.
     */
    @JsonProperty("storageVersionHash")
    public String getStorageVersionHash() {
        return storageVersionHash;
    }

    /**
     * The hash value of the storage version, the version this resource is converted to when written to the data store. Value must be treated as opaque by clients. Only equality comparison on the value is valid. This is an alpha feature and may change or be removed in the future. The field is populated by the apiserver only if the StorageVersionHash feature gate is enabled. This field will remain optional even if it graduates.
     */
    @JsonProperty("storageVersionHash")
    public void setStorageVersionHash(String storageVersionHash) {
        this.storageVersionHash = storageVersionHash;
    }

    /**
     * verbs is a list of supported kube verbs (this includes get, list, watch, create, update, patch, delete, deletecollection, and proxy)
     */
    @JsonProperty("verbs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getVerbs() {
        return verbs;
    }

    /**
     * verbs is a list of supported kube verbs (this includes get, list, watch, create, update, patch, delete, deletecollection, and proxy)
     */
    @JsonProperty("verbs")
    public void setVerbs(List<String> verbs) {
        this.verbs = verbs;
    }

    /**
     * version is the preferred version of the resource.  Empty implies the version of the containing resource list For subresources, this may have a different value, for example: v1 (while inside a v1beta1 version of the core resource's group)".
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * version is the preferred version of the resource.  Empty implies the version of the containing resource list For subresources, this may have a different value, for example: v1 (while inside a v1beta1 version of the core resource's group)".
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public APIResourceBuilder edit() {
        return new APIResourceBuilder(this);
    }

    @JsonIgnore
    public APIResourceBuilder toBuilder() {
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
        if (!(o instanceof APIResource)) {
            return false;
        }
        APIResource other = (APIResource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$categories = this.getCategories();
        Object other$categories = other.getCategories();
        if (this$categories == null ? other$categories != null : !this$categories.equals(other$categories)) {
            return false;
        }
        Object this$group = this.getGroup();
        Object other$group = other.getGroup();
        if (this$group == null ? other$group != null : !this$group.equals(other$group)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$namespaced = this.getNamespaced();
        Object other$namespaced = other.getNamespaced();
        if (this$namespaced == null ? other$namespaced != null : !this$namespaced.equals(other$namespaced)) {
            return false;
        }
        Object this$shortNames = this.getShortNames();
        Object other$shortNames = other.getShortNames();
        if (this$shortNames == null ? other$shortNames != null : !this$shortNames.equals(other$shortNames)) {
            return false;
        }
        Object this$singularName = this.getSingularName();
        Object other$singularName = other.getSingularName();
        if (this$singularName == null ? other$singularName != null : !this$singularName.equals(other$singularName)) {
            return false;
        }
        Object this$storageVersionHash = this.getStorageVersionHash();
        Object other$storageVersionHash = other.getStorageVersionHash();
        if (this$storageVersionHash == null ? other$storageVersionHash != null : !this$storageVersionHash.equals(other$storageVersionHash)) {
            return false;
        }
        Object this$verbs = this.getVerbs();
        Object other$verbs = other.getVerbs();
        if (this$verbs == null ? other$verbs != null : !this$verbs.equals(other$verbs)) {
            return false;
        }
        Object this$version = this.getVersion();
        Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
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
        return other instanceof APIResource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $categories = this.getCategories();
        result = result * prime + ($categories == null ? 43 : $categories.hashCode());
        Object $group = this.getGroup();
        result = result * prime + ($group == null ? 43 : $group.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $namespaced = this.getNamespaced();
        result = result * prime + ($namespaced == null ? 43 : $namespaced.hashCode());
        Object $shortNames = this.getShortNames();
        result = result * prime + ($shortNames == null ? 43 : $shortNames.hashCode());
        Object $singularName = this.getSingularName();
        result = result * prime + ($singularName == null ? 43 : $singularName.hashCode());
        Object $storageVersionHash = this.getStorageVersionHash();
        result = result * prime + ($storageVersionHash == null ? 43 : $storageVersionHash.hashCode());
        Object $verbs = this.getVerbs();
        result = result * prime + ($verbs == null ? 43 : $verbs.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "APIResource(" + "categories=" + this.getCategories() + ", group=" + this.getGroup() + ", kind=" + this.getKind() + ", name=" + this.getName() + ", namespaced=" + this.getNamespaced() + ", shortNames=" + this.getShortNames() + ", singularName=" + this.getSingularName() + ", storageVersionHash=" + this.getStorageVersionHash() + ", verbs=" + this.getVerbs() + ", version=" + this.getVersion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
