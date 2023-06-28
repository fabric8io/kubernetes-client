
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
    "additionalPrinterColumns",
    "deprecated",
    "deprecationWarning",
    "name",
    "schema",
    "served",
    "storage",
    "subresources"
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
public class CustomResourceDefinitionVersion implements KubernetesResource
{

    @JsonProperty("additionalPrinterColumns")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CustomResourceColumnDefinition> additionalPrinterColumns = new ArrayList<CustomResourceColumnDefinition>();
    @JsonProperty("deprecated")
    private Boolean deprecated;
    @JsonProperty("deprecationWarning")
    private String deprecationWarning;
    @JsonProperty("name")
    private String name;
    @JsonProperty("schema")
    private CustomResourceValidation schema;
    @JsonProperty("served")
    private Boolean served;
    @JsonProperty("storage")
    private Boolean storage;
    @JsonProperty("subresources")
    private CustomResourceSubresources subresources;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CustomResourceDefinitionVersion() {
    }

    public CustomResourceDefinitionVersion(List<CustomResourceColumnDefinition> additionalPrinterColumns, Boolean deprecated, String deprecationWarning, String name, CustomResourceValidation schema, Boolean served, Boolean storage, CustomResourceSubresources subresources) {
        super();
        this.additionalPrinterColumns = additionalPrinterColumns;
        this.deprecated = deprecated;
        this.deprecationWarning = deprecationWarning;
        this.name = name;
        this.schema = schema;
        this.served = served;
        this.storage = storage;
        this.subresources = subresources;
    }

    @JsonProperty("additionalPrinterColumns")
    public List<CustomResourceColumnDefinition> getAdditionalPrinterColumns() {
        return additionalPrinterColumns;
    }

    @JsonProperty("additionalPrinterColumns")
    public void setAdditionalPrinterColumns(List<CustomResourceColumnDefinition> additionalPrinterColumns) {
        this.additionalPrinterColumns = additionalPrinterColumns;
    }

    @JsonProperty("deprecated")
    public Boolean getDeprecated() {
        return deprecated;
    }

    @JsonProperty("deprecated")
    public void setDeprecated(Boolean deprecated) {
        this.deprecated = deprecated;
    }

    @JsonProperty("deprecationWarning")
    public String getDeprecationWarning() {
        return deprecationWarning;
    }

    @JsonProperty("deprecationWarning")
    public void setDeprecationWarning(String deprecationWarning) {
        this.deprecationWarning = deprecationWarning;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("schema")
    public CustomResourceValidation getSchema() {
        return schema;
    }

    @JsonProperty("schema")
    public void setSchema(CustomResourceValidation schema) {
        this.schema = schema;
    }

    @JsonProperty("served")
    public Boolean getServed() {
        return served;
    }

    @JsonProperty("served")
    public void setServed(Boolean served) {
        this.served = served;
    }

    @JsonProperty("storage")
    public Boolean getStorage() {
        return storage;
    }

    @JsonProperty("storage")
    public void setStorage(Boolean storage) {
        this.storage = storage;
    }

    @JsonProperty("subresources")
    public CustomResourceSubresources getSubresources() {
        return subresources;
    }

    @JsonProperty("subresources")
    public void setSubresources(CustomResourceSubresources subresources) {
        this.subresources = subresources;
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
