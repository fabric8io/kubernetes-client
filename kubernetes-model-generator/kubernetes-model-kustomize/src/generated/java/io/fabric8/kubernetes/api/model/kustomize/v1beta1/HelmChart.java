
package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

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
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.sundr.builder.annotations.Buildable;
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
    "additionalValuesFiles",
    "apiVersions",
    "includeCRDs",
    "name",
    "nameTemplate",
    "namespace",
    "releaseName",
    "repo",
    "skipHooks",
    "skipTests",
    "valuesFile",
    "valuesInline",
    "valuesMerge",
    "version"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class HelmChart implements KubernetesResource
{

    @JsonProperty("additionalValuesFiles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> additionalValuesFiles = new ArrayList<java.lang.String>();
    @JsonProperty("apiVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> apiVersions = new ArrayList<java.lang.String>();
    @JsonProperty("includeCRDs")
    private Boolean includeCRDs;
    @JsonProperty("name")
    private java.lang.String name;
    @JsonProperty("nameTemplate")
    private java.lang.String nameTemplate;
    @JsonProperty("namespace")
    private java.lang.String namespace;
    @JsonProperty("releaseName")
    private java.lang.String releaseName;
    @JsonProperty("repo")
    private java.lang.String repo;
    @JsonProperty("skipHooks")
    private Boolean skipHooks;
    @JsonProperty("skipTests")
    private Boolean skipTests;
    @JsonProperty("valuesFile")
    private java.lang.String valuesFile;
    @JsonProperty("valuesInline")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> valuesInline = new LinkedHashMap<String, Object>();
    @JsonProperty("valuesMerge")
    private java.lang.String valuesMerge;
    @JsonProperty("version")
    private java.lang.String version;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public HelmChart() {
    }

    public HelmChart(List<java.lang.String> additionalValuesFiles, List<java.lang.String> apiVersions, Boolean includeCRDs, java.lang.String name, java.lang.String nameTemplate, java.lang.String namespace, java.lang.String releaseName, java.lang.String repo, Boolean skipHooks, Boolean skipTests, java.lang.String valuesFile, Map<String, Object> valuesInline, java.lang.String valuesMerge, java.lang.String version) {
        super();
        this.additionalValuesFiles = additionalValuesFiles;
        this.apiVersions = apiVersions;
        this.includeCRDs = includeCRDs;
        this.name = name;
        this.nameTemplate = nameTemplate;
        this.namespace = namespace;
        this.releaseName = releaseName;
        this.repo = repo;
        this.skipHooks = skipHooks;
        this.skipTests = skipTests;
        this.valuesFile = valuesFile;
        this.valuesInline = valuesInline;
        this.valuesMerge = valuesMerge;
        this.version = version;
    }

    @JsonProperty("additionalValuesFiles")
    public List<java.lang.String> getAdditionalValuesFiles() {
        return additionalValuesFiles;
    }

    @JsonProperty("additionalValuesFiles")
    public void setAdditionalValuesFiles(List<java.lang.String> additionalValuesFiles) {
        this.additionalValuesFiles = additionalValuesFiles;
    }

    @JsonProperty("apiVersions")
    public List<java.lang.String> getApiVersions() {
        return apiVersions;
    }

    @JsonProperty("apiVersions")
    public void setApiVersions(List<java.lang.String> apiVersions) {
        this.apiVersions = apiVersions;
    }

    @JsonProperty("includeCRDs")
    public Boolean getIncludeCRDs() {
        return includeCRDs;
    }

    @JsonProperty("includeCRDs")
    public void setIncludeCRDs(Boolean includeCRDs) {
        this.includeCRDs = includeCRDs;
    }

    @JsonProperty("name")
    public java.lang.String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(java.lang.String name) {
        this.name = name;
    }

    @JsonProperty("nameTemplate")
    public java.lang.String getNameTemplate() {
        return nameTemplate;
    }

    @JsonProperty("nameTemplate")
    public void setNameTemplate(java.lang.String nameTemplate) {
        this.nameTemplate = nameTemplate;
    }

    @JsonProperty("namespace")
    public java.lang.String getNamespace() {
        return namespace;
    }

    @JsonProperty("namespace")
    public void setNamespace(java.lang.String namespace) {
        this.namespace = namespace;
    }

    @JsonProperty("releaseName")
    public java.lang.String getReleaseName() {
        return releaseName;
    }

    @JsonProperty("releaseName")
    public void setReleaseName(java.lang.String releaseName) {
        this.releaseName = releaseName;
    }

    @JsonProperty("repo")
    public java.lang.String getRepo() {
        return repo;
    }

    @JsonProperty("repo")
    public void setRepo(java.lang.String repo) {
        this.repo = repo;
    }

    @JsonProperty("skipHooks")
    public Boolean getSkipHooks() {
        return skipHooks;
    }

    @JsonProperty("skipHooks")
    public void setSkipHooks(Boolean skipHooks) {
        this.skipHooks = skipHooks;
    }

    @JsonProperty("skipTests")
    public Boolean getSkipTests() {
        return skipTests;
    }

    @JsonProperty("skipTests")
    public void setSkipTests(Boolean skipTests) {
        this.skipTests = skipTests;
    }

    @JsonProperty("valuesFile")
    public java.lang.String getValuesFile() {
        return valuesFile;
    }

    @JsonProperty("valuesFile")
    public void setValuesFile(java.lang.String valuesFile) {
        this.valuesFile = valuesFile;
    }

    @JsonProperty("valuesInline")
    public Map<String, Object> getValuesInline() {
        return valuesInline;
    }

    @JsonProperty("valuesInline")
    public void setValuesInline(Map<String, Object> valuesInline) {
        this.valuesInline = valuesInline;
    }

    @JsonProperty("valuesMerge")
    public java.lang.String getValuesMerge() {
        return valuesMerge;
    }

    @JsonProperty("valuesMerge")
    public void setValuesMerge(java.lang.String valuesMerge) {
        this.valuesMerge = valuesMerge;
    }

    @JsonProperty("version")
    public java.lang.String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(java.lang.String version) {
        this.version = version;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
