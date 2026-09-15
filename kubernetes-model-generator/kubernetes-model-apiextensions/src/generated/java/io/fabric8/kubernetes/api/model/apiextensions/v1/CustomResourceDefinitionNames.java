
package io.fabric8.kubernetes.api.model.apiextensions.v1;

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
 * CustomResourceDefinitionNames indicates the names to serve this CustomResourceDefinition
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "categories",
    "listKind",
    "plural",
    "shortNames",
    "singular"
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
public class CustomResourceDefinitionNames implements Editable<CustomResourceDefinitionNamesBuilder>, KubernetesResource
{

    @JsonProperty("categories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> categories = new ArrayList<>();
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("listKind")
    private String listKind;
    @JsonProperty("plural")
    private String plural;
    @JsonProperty("shortNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> shortNames = new ArrayList<>();
    @JsonProperty("singular")
    private String singular;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CustomResourceDefinitionNames() {
    }

    public CustomResourceDefinitionNames(List<String> categories, String kind, String listKind, String plural, List<String> shortNames, String singular) {
        super();
        this.categories = categories;
        this.kind = kind;
        this.listKind = listKind;
        this.plural = plural;
        this.shortNames = shortNames;
        this.singular = singular;
    }

    /**
     * categories is a list of grouped resources this custom resource belongs to (e.g. 'all'). This is published in API discovery documents, and used by clients to support invocations like `kubectl get all`.
     */
    @JsonProperty("categories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCategories() {
        return categories;
    }

    /**
     * categories is a list of grouped resources this custom resource belongs to (e.g. 'all'). This is published in API discovery documents, and used by clients to support invocations like `kubectl get all`.
     */
    @JsonProperty("categories")
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    /**
     * kind is the serialized kind of the resource. It is normally CamelCase and singular. Custom resource instances will use this value as the `kind` attribute in API calls.
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * kind is the serialized kind of the resource. It is normally CamelCase and singular. Custom resource instances will use this value as the `kind` attribute in API calls.
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * listKind is the serialized kind of the list for this resource. Defaults to "`kind`List".
     */
    @JsonProperty("listKind")
    public String getListKind() {
        return listKind;
    }

    /**
     * listKind is the serialized kind of the list for this resource. Defaults to "`kind`List".
     */
    @JsonProperty("listKind")
    public void setListKind(String listKind) {
        this.listKind = listKind;
    }

    /**
     * plural is the plural name of the resource to serve. The custom resources are served under `/apis/&lt;group&gt;/&lt;version&gt;/.../&lt;plural&gt;`. Must match the name of the CustomResourceDefinition (in the form `&lt;names.plural&gt;.&lt;group&gt;`). Must be all lowercase.
     */
    @JsonProperty("plural")
    public String getPlural() {
        return plural;
    }

    /**
     * plural is the plural name of the resource to serve. The custom resources are served under `/apis/&lt;group&gt;/&lt;version&gt;/.../&lt;plural&gt;`. Must match the name of the CustomResourceDefinition (in the form `&lt;names.plural&gt;.&lt;group&gt;`). Must be all lowercase.
     */
    @JsonProperty("plural")
    public void setPlural(String plural) {
        this.plural = plural;
    }

    /**
     * shortNames are short names for the resource, exposed in API discovery documents, and used by clients to support invocations like `kubectl get &lt;shortname&gt;`. It must be all lowercase.
     */
    @JsonProperty("shortNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getShortNames() {
        return shortNames;
    }

    /**
     * shortNames are short names for the resource, exposed in API discovery documents, and used by clients to support invocations like `kubectl get &lt;shortname&gt;`. It must be all lowercase.
     */
    @JsonProperty("shortNames")
    public void setShortNames(List<String> shortNames) {
        this.shortNames = shortNames;
    }

    /**
     * singular is the singular name of the resource. It must be all lowercase. Defaults to lowercased `kind`.
     */
    @JsonProperty("singular")
    public String getSingular() {
        return singular;
    }

    /**
     * singular is the singular name of the resource. It must be all lowercase. Defaults to lowercased `kind`.
     */
    @JsonProperty("singular")
    public void setSingular(String singular) {
        this.singular = singular;
    }

    @JsonIgnore
    public CustomResourceDefinitionNamesBuilder edit() {
        return new CustomResourceDefinitionNamesBuilder(this);
    }

    @JsonIgnore
    public CustomResourceDefinitionNamesBuilder toBuilder() {
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
        if (!(o instanceof CustomResourceDefinitionNames)) {
            return false;
        }
        CustomResourceDefinitionNames other = (CustomResourceDefinitionNames) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$categories = this.getCategories();
        Object other$categories = other.getCategories();
        if (this$categories == null ? other$categories != null : !this$categories.equals(other$categories)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$listKind = this.getListKind();
        Object other$listKind = other.getListKind();
        if (this$listKind == null ? other$listKind != null : !this$listKind.equals(other$listKind)) {
            return false;
        }
        Object this$plural = this.getPlural();
        Object other$plural = other.getPlural();
        if (this$plural == null ? other$plural != null : !this$plural.equals(other$plural)) {
            return false;
        }
        Object this$shortNames = this.getShortNames();
        Object other$shortNames = other.getShortNames();
        if (this$shortNames == null ? other$shortNames != null : !this$shortNames.equals(other$shortNames)) {
            return false;
        }
        Object this$singular = this.getSingular();
        Object other$singular = other.getSingular();
        if (this$singular == null ? other$singular != null : !this$singular.equals(other$singular)) {
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
        return other instanceof CustomResourceDefinitionNames;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $categories = this.getCategories();
        result = result * prime + ($categories == null ? 43 : $categories.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $listKind = this.getListKind();
        result = result * prime + ($listKind == null ? 43 : $listKind.hashCode());
        Object $plural = this.getPlural();
        result = result * prime + ($plural == null ? 43 : $plural.hashCode());
        Object $shortNames = this.getShortNames();
        result = result * prime + ($shortNames == null ? 43 : $shortNames.hashCode());
        Object $singular = this.getSingular();
        result = result * prime + ($singular == null ? 43 : $singular.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CustomResourceDefinitionNames(" + "categories=" + this.getCategories() + ", kind=" + this.getKind() + ", listKind=" + this.getListKind() + ", plural=" + this.getPlural() + ", shortNames=" + this.getShortNames() + ", singular=" + this.getSingular() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
