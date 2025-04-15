
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * CustomResourceDefinitionVersion describes a version for CRD.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalPrinterColumns",
    "deprecated",
    "deprecationWarning",
    "name",
    "schema",
    "selectableFields",
    "served",
    "storage",
    "subresources"
})
@ToString
@EqualsAndHashCode
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class CustomResourceDefinitionVersion implements Editable<CustomResourceDefinitionVersionBuilder>, KubernetesResource
{

    @JsonProperty("additionalPrinterColumns")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CustomResourceColumnDefinition> additionalPrinterColumns = new ArrayList<>();
    @JsonProperty("deprecated")
    private Boolean deprecated;
    @JsonProperty("deprecationWarning")
    private String deprecationWarning;
    @JsonProperty("name")
    private String name;
    @JsonProperty("schema")
    private CustomResourceValidation schema;
    @JsonProperty("selectableFields")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SelectableField> selectableFields = new ArrayList<>();
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
     */
    public CustomResourceDefinitionVersion() {
    }

    public CustomResourceDefinitionVersion(List<CustomResourceColumnDefinition> additionalPrinterColumns, Boolean deprecated, String deprecationWarning, String name, CustomResourceValidation schema, List<SelectableField> selectableFields, Boolean served, Boolean storage, CustomResourceSubresources subresources) {
        super();
        this.additionalPrinterColumns = additionalPrinterColumns;
        this.deprecated = deprecated;
        this.deprecationWarning = deprecationWarning;
        this.name = name;
        this.schema = schema;
        this.selectableFields = selectableFields;
        this.served = served;
        this.storage = storage;
        this.subresources = subresources;
    }

    /**
     * additionalPrinterColumns specifies additional columns returned in Table output. See https://kubernetes.io/docs/reference/using-api/api-concepts/#receiving-resources-as-tables for details. If no columns are specified, a single column displaying the age of the custom resource is used.
     */
    @JsonProperty("additionalPrinterColumns")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CustomResourceColumnDefinition> getAdditionalPrinterColumns() {
        return additionalPrinterColumns;
    }

    /**
     * additionalPrinterColumns specifies additional columns returned in Table output. See https://kubernetes.io/docs/reference/using-api/api-concepts/#receiving-resources-as-tables for details. If no columns are specified, a single column displaying the age of the custom resource is used.
     */
    @JsonProperty("additionalPrinterColumns")
    public void setAdditionalPrinterColumns(List<CustomResourceColumnDefinition> additionalPrinterColumns) {
        this.additionalPrinterColumns = additionalPrinterColumns;
    }

    /**
     * deprecated indicates this version of the custom resource API is deprecated. When set to true, API requests to this version receive a warning header in the server response. Defaults to false.
     */
    @JsonProperty("deprecated")
    public Boolean getDeprecated() {
        return deprecated;
    }

    /**
     * deprecated indicates this version of the custom resource API is deprecated. When set to true, API requests to this version receive a warning header in the server response. Defaults to false.
     */
    @JsonProperty("deprecated")
    public void setDeprecated(Boolean deprecated) {
        this.deprecated = deprecated;
    }

    /**
     * deprecationWarning overrides the default warning returned to API clients. May only be set when `deprecated` is true. The default warning indicates this version is deprecated and recommends use of the newest served version of equal or greater stability, if one exists.
     */
    @JsonProperty("deprecationWarning")
    public String getDeprecationWarning() {
        return deprecationWarning;
    }

    /**
     * deprecationWarning overrides the default warning returned to API clients. May only be set when `deprecated` is true. The default warning indicates this version is deprecated and recommends use of the newest served version of equal or greater stability, if one exists.
     */
    @JsonProperty("deprecationWarning")
    public void setDeprecationWarning(String deprecationWarning) {
        this.deprecationWarning = deprecationWarning;
    }

    /**
     * name is the version name, e.g. "v1", "v2beta1", etc. The custom resources are served under this version at `/apis/&lt;group&gt;/&lt;version&gt;/...` if `served` is true.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is the version name, e.g. "v1", "v2beta1", etc. The custom resources are served under this version at `/apis/&lt;group&gt;/&lt;version&gt;/...` if `served` is true.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * CustomResourceDefinitionVersion describes a version for CRD.
     */
    @JsonProperty("schema")
    public CustomResourceValidation getSchema() {
        return schema;
    }

    /**
     * CustomResourceDefinitionVersion describes a version for CRD.
     */
    @JsonProperty("schema")
    public void setSchema(CustomResourceValidation schema) {
        this.schema = schema;
    }

    /**
     * selectableFields specifies paths to fields that may be used as field selectors. A maximum of 8 selectable fields are allowed. See https://kubernetes.io/docs/concepts/overview/working-with-objects/field-selectors
     */
    @JsonProperty("selectableFields")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SelectableField> getSelectableFields() {
        return selectableFields;
    }

    /**
     * selectableFields specifies paths to fields that may be used as field selectors. A maximum of 8 selectable fields are allowed. See https://kubernetes.io/docs/concepts/overview/working-with-objects/field-selectors
     */
    @JsonProperty("selectableFields")
    public void setSelectableFields(List<SelectableField> selectableFields) {
        this.selectableFields = selectableFields;
    }

    /**
     * served is a flag enabling/disabling this version from being served via REST APIs
     */
    @JsonProperty("served")
    public Boolean getServed() {
        return served;
    }

    /**
     * served is a flag enabling/disabling this version from being served via REST APIs
     */
    @JsonProperty("served")
    public void setServed(Boolean served) {
        this.served = served;
    }

    /**
     * storage indicates this version should be used when persisting custom resources to storage. There must be exactly one version with storage=true.
     */
    @JsonProperty("storage")
    public Boolean getStorage() {
        return storage;
    }

    /**
     * storage indicates this version should be used when persisting custom resources to storage. There must be exactly one version with storage=true.
     */
    @JsonProperty("storage")
    public void setStorage(Boolean storage) {
        this.storage = storage;
    }

    /**
     * CustomResourceDefinitionVersion describes a version for CRD.
     */
    @JsonProperty("subresources")
    public CustomResourceSubresources getSubresources() {
        return subresources;
    }

    /**
     * CustomResourceDefinitionVersion describes a version for CRD.
     */
    @JsonProperty("subresources")
    public void setSubresources(CustomResourceSubresources subresources) {
        this.subresources = subresources;
    }

    @JsonIgnore
    public CustomResourceDefinitionVersionBuilder edit() {
        return new CustomResourceDefinitionVersionBuilder(this);
    }

    @JsonIgnore
    public CustomResourceDefinitionVersionBuilder toBuilder() {
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
