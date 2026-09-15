
package io.fabric8.openshift.api.model.operator.v1;

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

/**
 * DeveloperConsoleCatalogCategory for the developer console catalog.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "label",
    "subcategories",
    "tags"
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
public class DeveloperConsoleCatalogCategory implements Editable<DeveloperConsoleCatalogCategoryBuilder>, KubernetesResource
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("label")
    private String label;
    @JsonProperty("subcategories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeveloperConsoleCatalogCategoryMeta> subcategories = new ArrayList<>();
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> tags = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DeveloperConsoleCatalogCategory() {
    }

    public DeveloperConsoleCatalogCategory(String id, String label, List<DeveloperConsoleCatalogCategoryMeta> subcategories, List<String> tags) {
        super();
        this.id = id;
        this.label = label;
        this.subcategories = subcategories;
        this.tags = tags;
    }

    /**
     * id is an identifier used in the URL to enable deep linking in console. ID is required and must have 1-32 URL safe (A-Z, a-z, 0-9, - and _) characters.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * id is an identifier used in the URL to enable deep linking in console. ID is required and must have 1-32 URL safe (A-Z, a-z, 0-9, - and _) characters.
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * label defines a category display label. It is required and must have 1-64 characters.
     */
    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    /**
     * label defines a category display label. It is required and must have 1-64 characters.
     */
    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * subcategories defines a list of child categories.
     */
    @JsonProperty("subcategories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DeveloperConsoleCatalogCategoryMeta> getSubcategories() {
        return subcategories;
    }

    /**
     * subcategories defines a list of child categories.
     */
    @JsonProperty("subcategories")
    public void setSubcategories(List<DeveloperConsoleCatalogCategoryMeta> subcategories) {
        this.subcategories = subcategories;
    }

    /**
     * tags is a list of strings that will match the category. A selected category show all items which has at least one overlapping tag between category and item.
     */
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTags() {
        return tags;
    }

    /**
     * tags is a list of strings that will match the category. A selected category show all items which has at least one overlapping tag between category and item.
     */
    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonIgnore
    public DeveloperConsoleCatalogCategoryBuilder edit() {
        return new DeveloperConsoleCatalogCategoryBuilder(this);
    }

    @JsonIgnore
    public DeveloperConsoleCatalogCategoryBuilder toBuilder() {
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
        if (!(o instanceof DeveloperConsoleCatalogCategory)) {
            return false;
        }
        DeveloperConsoleCatalogCategory other = (DeveloperConsoleCatalogCategory) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$id = this.getId();
        Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
            return false;
        }
        Object this$label = this.getLabel();
        Object other$label = other.getLabel();
        if (this$label == null ? other$label != null : !this$label.equals(other$label)) {
            return false;
        }
        Object this$subcategories = this.getSubcategories();
        Object other$subcategories = other.getSubcategories();
        if (this$subcategories == null ? other$subcategories != null : !this$subcategories.equals(other$subcategories)) {
            return false;
        }
        Object this$tags = this.getTags();
        Object other$tags = other.getTags();
        if (this$tags == null ? other$tags != null : !this$tags.equals(other$tags)) {
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
        return other instanceof DeveloperConsoleCatalogCategory;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $id = this.getId();
        result = result * prime + ($id == null ? 43 : $id.hashCode());
        Object $label = this.getLabel();
        result = result * prime + ($label == null ? 43 : $label.hashCode());
        Object $subcategories = this.getSubcategories();
        result = result * prime + ($subcategories == null ? 43 : $subcategories.hashCode());
        Object $tags = this.getTags();
        result = result * prime + ($tags == null ? 43 : $tags.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DeveloperConsoleCatalogCategory(" + "id=" + this.getId() + ", label=" + this.getLabel() + ", subcategories=" + this.getSubcategories() + ", tags=" + this.getTags() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
