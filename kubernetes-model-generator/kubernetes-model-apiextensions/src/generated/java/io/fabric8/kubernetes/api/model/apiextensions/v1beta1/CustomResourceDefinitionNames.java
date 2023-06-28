
package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
    "categories",
    "listKind",
    "plural",
    "shortNames",
    "singular"
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
public class CustomResourceDefinitionNames implements KubernetesResource
{

    @JsonProperty("categories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> categories = new ArrayList<String>();
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("listKind")
    private String listKind;
    @JsonProperty("plural")
    private String plural;
    @JsonProperty("shortNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> shortNames = new ArrayList<String>();
    @JsonProperty("singular")
    private String singular;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
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

    @JsonProperty("categories")
    public List<String> getCategories() {
        return categories;
    }

    @JsonProperty("categories")
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("listKind")
    public String getListKind() {
        return listKind;
    }

    @JsonProperty("listKind")
    public void setListKind(String listKind) {
        this.listKind = listKind;
    }

    @JsonProperty("plural")
    public String getPlural() {
        return plural;
    }

    @JsonProperty("plural")
    public void setPlural(String plural) {
        this.plural = plural;
    }

    @JsonProperty("shortNames")
    public List<String> getShortNames() {
        return shortNames;
    }

    @JsonProperty("shortNames")
    public void setShortNames(List<String> shortNames) {
        this.shortNames = shortNames;
    }

    @JsonProperty("singular")
    public String getSingular() {
        return singular;
    }

    @JsonProperty("singular")
    public void setSingular(String singular) {
        this.singular = singular;
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
