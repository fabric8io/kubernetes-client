
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalPrinterColumns",
    "conversion",
    "group",
    "names",
    "preserveUnknownFields",
    "scope",
    "subresources",
    "validation",
    "version",
    "versions"
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
public class CustomResourceDefinitionSpec implements Editable<CustomResourceDefinitionSpecBuilder> , KubernetesResource
{

    @JsonProperty("additionalPrinterColumns")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CustomResourceColumnDefinition> additionalPrinterColumns = new ArrayList<>();
    @JsonProperty("conversion")
    private CustomResourceConversion conversion;
    @JsonProperty("group")
    private String group;
    @JsonProperty("names")
    private CustomResourceDefinitionNames names;
    @JsonProperty("preserveUnknownFields")
    private Boolean preserveUnknownFields;
    @JsonProperty("scope")
    private String scope;
    @JsonProperty("subresources")
    private CustomResourceSubresources subresources;
    @JsonProperty("validation")
    private CustomResourceValidation validation;
    @JsonProperty("version")
    private String version;
    @JsonProperty("versions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CustomResourceDefinitionVersion> versions = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CustomResourceDefinitionSpec() {
    }

    public CustomResourceDefinitionSpec(List<CustomResourceColumnDefinition> additionalPrinterColumns, CustomResourceConversion conversion, String group, CustomResourceDefinitionNames names, Boolean preserveUnknownFields, String scope, CustomResourceSubresources subresources, CustomResourceValidation validation, String version, List<CustomResourceDefinitionVersion> versions) {
        super();
        this.additionalPrinterColumns = additionalPrinterColumns;
        this.conversion = conversion;
        this.group = group;
        this.names = names;
        this.preserveUnknownFields = preserveUnknownFields;
        this.scope = scope;
        this.subresources = subresources;
        this.validation = validation;
        this.version = version;
        this.versions = versions;
    }

    @JsonProperty("additionalPrinterColumns")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CustomResourceColumnDefinition> getAdditionalPrinterColumns() {
        return additionalPrinterColumns;
    }

    @JsonProperty("additionalPrinterColumns")
    public void setAdditionalPrinterColumns(List<CustomResourceColumnDefinition> additionalPrinterColumns) {
        this.additionalPrinterColumns = additionalPrinterColumns;
    }

    @JsonProperty("conversion")
    public CustomResourceConversion getConversion() {
        return conversion;
    }

    @JsonProperty("conversion")
    public void setConversion(CustomResourceConversion conversion) {
        this.conversion = conversion;
    }

    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    @JsonProperty("names")
    public CustomResourceDefinitionNames getNames() {
        return names;
    }

    @JsonProperty("names")
    public void setNames(CustomResourceDefinitionNames names) {
        this.names = names;
    }

    @JsonProperty("preserveUnknownFields")
    public Boolean getPreserveUnknownFields() {
        return preserveUnknownFields;
    }

    @JsonProperty("preserveUnknownFields")
    public void setPreserveUnknownFields(Boolean preserveUnknownFields) {
        this.preserveUnknownFields = preserveUnknownFields;
    }

    @JsonProperty("scope")
    public String getScope() {
        return scope;
    }

    @JsonProperty("scope")
    public void setScope(String scope) {
        this.scope = scope;
    }

    @JsonProperty("subresources")
    public CustomResourceSubresources getSubresources() {
        return subresources;
    }

    @JsonProperty("subresources")
    public void setSubresources(CustomResourceSubresources subresources) {
        this.subresources = subresources;
    }

    @JsonProperty("validation")
    public CustomResourceValidation getValidation() {
        return validation;
    }

    @JsonProperty("validation")
    public void setValidation(CustomResourceValidation validation) {
        this.validation = validation;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("versions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CustomResourceDefinitionVersion> getVersions() {
        return versions;
    }

    @JsonProperty("versions")
    public void setVersions(List<CustomResourceDefinitionVersion> versions) {
        this.versions = versions;
    }

    @JsonIgnore
    public CustomResourceDefinitionSpecBuilder edit() {
        return new CustomResourceDefinitionSpecBuilder(this);
    }

    @JsonIgnore
    public CustomResourceDefinitionSpecBuilder toBuilder() {
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
