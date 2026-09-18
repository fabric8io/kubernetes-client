
package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

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
 * CustomResourceDefinitionSpec describes how a user wants their resource to appear
 */
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
public class CustomResourceDefinitionSpec implements Editable<CustomResourceDefinitionSpecBuilder>, KubernetesResource
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

    /**
     * additionalPrinterColumns specifies additional columns returned in Table output. See https://kubernetes.io/docs/reference/using-api/api-concepts/#receiving-resources-as-tables for details. If present, this field configures columns for all versions. Top-level and per-version columns are mutually exclusive. If no top-level or per-version columns are specified, a single column displaying the age of the custom resource is used.
     */
    @JsonProperty("additionalPrinterColumns")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CustomResourceColumnDefinition> getAdditionalPrinterColumns() {
        return additionalPrinterColumns;
    }

    /**
     * additionalPrinterColumns specifies additional columns returned in Table output. See https://kubernetes.io/docs/reference/using-api/api-concepts/#receiving-resources-as-tables for details. If present, this field configures columns for all versions. Top-level and per-version columns are mutually exclusive. If no top-level or per-version columns are specified, a single column displaying the age of the custom resource is used.
     */
    @JsonProperty("additionalPrinterColumns")
    public void setAdditionalPrinterColumns(List<CustomResourceColumnDefinition> additionalPrinterColumns) {
        this.additionalPrinterColumns = additionalPrinterColumns;
    }

    /**
     * CustomResourceDefinitionSpec describes how a user wants their resource to appear
     */
    @JsonProperty("conversion")
    public CustomResourceConversion getConversion() {
        return conversion;
    }

    /**
     * CustomResourceDefinitionSpec describes how a user wants their resource to appear
     */
    @JsonProperty("conversion")
    public void setConversion(CustomResourceConversion conversion) {
        this.conversion = conversion;
    }

    /**
     * group is the API group of the defined custom resource. The custom resources are served under `/apis/&lt;group&gt;/...`. Must match the name of the CustomResourceDefinition (in the form `&lt;names.plural&gt;.&lt;group&gt;`).
     */
    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    /**
     * group is the API group of the defined custom resource. The custom resources are served under `/apis/&lt;group&gt;/...`. Must match the name of the CustomResourceDefinition (in the form `&lt;names.plural&gt;.&lt;group&gt;`).
     */
    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * CustomResourceDefinitionSpec describes how a user wants their resource to appear
     */
    @JsonProperty("names")
    public CustomResourceDefinitionNames getNames() {
        return names;
    }

    /**
     * CustomResourceDefinitionSpec describes how a user wants their resource to appear
     */
    @JsonProperty("names")
    public void setNames(CustomResourceDefinitionNames names) {
        this.names = names;
    }

    /**
     * preserveUnknownFields indicates that object fields which are not specified in the OpenAPI schema should be preserved when persisting to storage. apiVersion, kind, metadata and known fields inside metadata are always preserved. If false, schemas must be defined for all versions. Defaults to true in v1beta for backwards compatibility. Deprecated: will be required to be false in v1. Preservation of unknown fields can be specified in the validation schema using the `x-kubernetes-preserve-unknown-fields: true` extension. See https://kubernetes.io/docs/tasks/access-kubernetes-api/custom-resources/custom-resource-definitions/#pruning-versus-preserving-unknown-fields for details.
     */
    @JsonProperty("preserveUnknownFields")
    public Boolean getPreserveUnknownFields() {
        return preserveUnknownFields;
    }

    /**
     * preserveUnknownFields indicates that object fields which are not specified in the OpenAPI schema should be preserved when persisting to storage. apiVersion, kind, metadata and known fields inside metadata are always preserved. If false, schemas must be defined for all versions. Defaults to true in v1beta for backwards compatibility. Deprecated: will be required to be false in v1. Preservation of unknown fields can be specified in the validation schema using the `x-kubernetes-preserve-unknown-fields: true` extension. See https://kubernetes.io/docs/tasks/access-kubernetes-api/custom-resources/custom-resource-definitions/#pruning-versus-preserving-unknown-fields for details.
     */
    @JsonProperty("preserveUnknownFields")
    public void setPreserveUnknownFields(Boolean preserveUnknownFields) {
        this.preserveUnknownFields = preserveUnknownFields;
    }

    /**
     * scope indicates whether the defined custom resource is cluster- or namespace-scoped. Allowed values are `Cluster` and `Namespaced`. Default is `Namespaced`.
     */
    @JsonProperty("scope")
    public String getScope() {
        return scope;
    }

    /**
     * scope indicates whether the defined custom resource is cluster- or namespace-scoped. Allowed values are `Cluster` and `Namespaced`. Default is `Namespaced`.
     */
    @JsonProperty("scope")
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * CustomResourceDefinitionSpec describes how a user wants their resource to appear
     */
    @JsonProperty("subresources")
    public CustomResourceSubresources getSubresources() {
        return subresources;
    }

    /**
     * CustomResourceDefinitionSpec describes how a user wants their resource to appear
     */
    @JsonProperty("subresources")
    public void setSubresources(CustomResourceSubresources subresources) {
        this.subresources = subresources;
    }

    /**
     * CustomResourceDefinitionSpec describes how a user wants their resource to appear
     */
    @JsonProperty("validation")
    public CustomResourceValidation getValidation() {
        return validation;
    }

    /**
     * CustomResourceDefinitionSpec describes how a user wants their resource to appear
     */
    @JsonProperty("validation")
    public void setValidation(CustomResourceValidation validation) {
        this.validation = validation;
    }

    /**
     * version is the API version of the defined custom resource. The custom resources are served under `/apis/&lt;group&gt;/&lt;version&gt;/...`. Must match the name of the first item in the `versions` list if `version` and `versions` are both specified. Optional if `versions` is specified. Deprecated: use `versions` instead.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * version is the API version of the defined custom resource. The custom resources are served under `/apis/&lt;group&gt;/&lt;version&gt;/...`. Must match the name of the first item in the `versions` list if `version` and `versions` are both specified. Optional if `versions` is specified. Deprecated: use `versions` instead.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * versions is the list of all API versions of the defined custom resource. Optional if `version` is specified. The name of the first item in the `versions` list must match the `version` field if `version` and `versions` are both specified. Version names are used to compute the order in which served versions are listed in API discovery. If the version string is "kube-like", it will sort above non "kube-like" version strings, which are ordered lexicographically. "Kube-like" versions start with a "v", then are followed by a number (the major version), then optionally the string "alpha" or "beta" and another number (the minor version). These are sorted first by GA &gt; beta &gt; alpha (where GA is a version with no suffix such as beta or alpha), and then by comparing major version, then minor version. An example sorted list of versions: v10, v2, v1, v11beta2, v10beta3, v3beta1, v12alpha1, v11alpha2, foo1, foo10.
     */
    @JsonProperty("versions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CustomResourceDefinitionVersion> getVersions() {
        return versions;
    }

    /**
     * versions is the list of all API versions of the defined custom resource. Optional if `version` is specified. The name of the first item in the `versions` list must match the `version` field if `version` and `versions` are both specified. Version names are used to compute the order in which served versions are listed in API discovery. If the version string is "kube-like", it will sort above non "kube-like" version strings, which are ordered lexicographically. "Kube-like" versions start with a "v", then are followed by a number (the major version), then optionally the string "alpha" or "beta" and another number (the minor version). These are sorted first by GA &gt; beta &gt; alpha (where GA is a version with no suffix such as beta or alpha), and then by comparing major version, then minor version. An example sorted list of versions: v10, v2, v1, v11beta2, v10beta3, v3beta1, v12alpha1, v11alpha2, foo1, foo10.
     */
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
        if (!(o instanceof CustomResourceDefinitionSpec)) {
            return false;
        }
        CustomResourceDefinitionSpec other = (CustomResourceDefinitionSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$additionalPrinterColumns = this.getAdditionalPrinterColumns();
        Object other$additionalPrinterColumns = other.getAdditionalPrinterColumns();
        if (this$additionalPrinterColumns == null ? other$additionalPrinterColumns != null : !this$additionalPrinterColumns.equals(other$additionalPrinterColumns)) {
            return false;
        }
        Object this$conversion = this.getConversion();
        Object other$conversion = other.getConversion();
        if (this$conversion == null ? other$conversion != null : !this$conversion.equals(other$conversion)) {
            return false;
        }
        Object this$group = this.getGroup();
        Object other$group = other.getGroup();
        if (this$group == null ? other$group != null : !this$group.equals(other$group)) {
            return false;
        }
        Object this$names = this.getNames();
        Object other$names = other.getNames();
        if (this$names == null ? other$names != null : !this$names.equals(other$names)) {
            return false;
        }
        Object this$preserveUnknownFields = this.getPreserveUnknownFields();
        Object other$preserveUnknownFields = other.getPreserveUnknownFields();
        if (this$preserveUnknownFields == null ? other$preserveUnknownFields != null : !this$preserveUnknownFields.equals(other$preserveUnknownFields)) {
            return false;
        }
        Object this$scope = this.getScope();
        Object other$scope = other.getScope();
        if (this$scope == null ? other$scope != null : !this$scope.equals(other$scope)) {
            return false;
        }
        Object this$subresources = this.getSubresources();
        Object other$subresources = other.getSubresources();
        if (this$subresources == null ? other$subresources != null : !this$subresources.equals(other$subresources)) {
            return false;
        }
        Object this$validation = this.getValidation();
        Object other$validation = other.getValidation();
        if (this$validation == null ? other$validation != null : !this$validation.equals(other$validation)) {
            return false;
        }
        Object this$version = this.getVersion();
        Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
            return false;
        }
        Object this$versions = this.getVersions();
        Object other$versions = other.getVersions();
        if (this$versions == null ? other$versions != null : !this$versions.equals(other$versions)) {
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
        return other instanceof CustomResourceDefinitionSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $additionalPrinterColumns = this.getAdditionalPrinterColumns();
        result = result * prime + ($additionalPrinterColumns == null ? 43 : $additionalPrinterColumns.hashCode());
        Object $conversion = this.getConversion();
        result = result * prime + ($conversion == null ? 43 : $conversion.hashCode());
        Object $group = this.getGroup();
        result = result * prime + ($group == null ? 43 : $group.hashCode());
        Object $names = this.getNames();
        result = result * prime + ($names == null ? 43 : $names.hashCode());
        Object $preserveUnknownFields = this.getPreserveUnknownFields();
        result = result * prime + ($preserveUnknownFields == null ? 43 : $preserveUnknownFields.hashCode());
        Object $scope = this.getScope();
        result = result * prime + ($scope == null ? 43 : $scope.hashCode());
        Object $subresources = this.getSubresources();
        result = result * prime + ($subresources == null ? 43 : $subresources.hashCode());
        Object $validation = this.getValidation();
        result = result * prime + ($validation == null ? 43 : $validation.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $versions = this.getVersions();
        result = result * prime + ($versions == null ? 43 : $versions.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CustomResourceDefinitionSpec(" + "additionalPrinterColumns=" + this.getAdditionalPrinterColumns() + ", conversion=" + this.getConversion() + ", group=" + this.getGroup() + ", names=" + this.getNames() + ", preserveUnknownFields=" + this.getPreserveUnknownFields() + ", scope=" + this.getScope() + ", subresources=" + this.getSubresources() + ", validation=" + this.getValidation() + ", version=" + this.getVersion() + ", versions=" + this.getVersions() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
