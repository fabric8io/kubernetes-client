
package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalValuesFiles",
    "apiVersions",
    "debug",
    "devel",
    "includeCRDs",
    "kubeVersion",
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
public class HelmChart implements Editable<HelmChartBuilder>, KubernetesResource
{

    @JsonProperty("additionalValuesFiles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> additionalValuesFiles = new ArrayList<>();
    @JsonProperty("apiVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> apiVersions = new ArrayList<>();
    @JsonProperty("debug")
    private Boolean debug;
    @JsonProperty("devel")
    private Boolean devel;
    @JsonProperty("includeCRDs")
    private Boolean includeCRDs;
    @JsonProperty("kubeVersion")
    private String kubeVersion;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nameTemplate")
    private String nameTemplate;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("releaseName")
    private String releaseName;
    @JsonProperty("repo")
    private String repo;
    @JsonProperty("skipHooks")
    private Boolean skipHooks;
    @JsonProperty("skipTests")
    private Boolean skipTests;
    @JsonProperty("valuesFile")
    private String valuesFile;
    @JsonProperty("valuesInline")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializerForMap.class)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> valuesInline = new LinkedHashMap<>();
    @JsonProperty("valuesMerge")
    private String valuesMerge;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HelmChart() {
    }

    public HelmChart(List<String> additionalValuesFiles, List<String> apiVersions, Boolean debug, Boolean devel, Boolean includeCRDs, String kubeVersion, String name, String nameTemplate, String namespace, String releaseName, String repo, Boolean skipHooks, Boolean skipTests, String valuesFile, Map<String, Object> valuesInline, String valuesMerge, String version) {
        super();
        this.additionalValuesFiles = additionalValuesFiles;
        this.apiVersions = apiVersions;
        this.debug = debug;
        this.devel = devel;
        this.includeCRDs = includeCRDs;
        this.kubeVersion = kubeVersion;
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAdditionalValuesFiles() {
        return additionalValuesFiles;
    }

    @JsonProperty("additionalValuesFiles")
    public void setAdditionalValuesFiles(List<String> additionalValuesFiles) {
        this.additionalValuesFiles = additionalValuesFiles;
    }

    @JsonProperty("apiVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getApiVersions() {
        return apiVersions;
    }

    @JsonProperty("apiVersions")
    public void setApiVersions(List<String> apiVersions) {
        this.apiVersions = apiVersions;
    }

    @JsonProperty("debug")
    public Boolean getDebug() {
        return debug;
    }

    @JsonProperty("debug")
    public void setDebug(Boolean debug) {
        this.debug = debug;
    }

    @JsonProperty("devel")
    public Boolean getDevel() {
        return devel;
    }

    @JsonProperty("devel")
    public void setDevel(Boolean devel) {
        this.devel = devel;
    }

    @JsonProperty("includeCRDs")
    public Boolean getIncludeCRDs() {
        return includeCRDs;
    }

    @JsonProperty("includeCRDs")
    public void setIncludeCRDs(Boolean includeCRDs) {
        this.includeCRDs = includeCRDs;
    }

    @JsonProperty("kubeVersion")
    public String getKubeVersion() {
        return kubeVersion;
    }

    @JsonProperty("kubeVersion")
    public void setKubeVersion(String kubeVersion) {
        this.kubeVersion = kubeVersion;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("nameTemplate")
    public String getNameTemplate() {
        return nameTemplate;
    }

    @JsonProperty("nameTemplate")
    public void setNameTemplate(String nameTemplate) {
        this.nameTemplate = nameTemplate;
    }

    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    @JsonProperty("releaseName")
    public String getReleaseName() {
        return releaseName;
    }

    @JsonProperty("releaseName")
    public void setReleaseName(String releaseName) {
        this.releaseName = releaseName;
    }

    @JsonProperty("repo")
    public String getRepo() {
        return repo;
    }

    @JsonProperty("repo")
    public void setRepo(String repo) {
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
    public String getValuesFile() {
        return valuesFile;
    }

    @JsonProperty("valuesFile")
    public void setValuesFile(String valuesFile) {
        this.valuesFile = valuesFile;
    }

    @JsonProperty("valuesInline")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Object> getValuesInline() {
        return valuesInline;
    }

    @JsonProperty("valuesInline")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializerForMap.class)
    public void setValuesInline(Map<String, Object> valuesInline) {
        this.valuesInline = valuesInline;
    }

    @JsonProperty("valuesMerge")
    public String getValuesMerge() {
        return valuesMerge;
    }

    @JsonProperty("valuesMerge")
    public void setValuesMerge(String valuesMerge) {
        this.valuesMerge = valuesMerge;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public HelmChartBuilder edit() {
        return new HelmChartBuilder(this);
    }

    @JsonIgnore
    public HelmChartBuilder toBuilder() {
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
        if (!(o instanceof HelmChart)) {
            return false;
        }
        HelmChart other = (HelmChart) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$additionalValuesFiles = this.getAdditionalValuesFiles();
        Object other$additionalValuesFiles = other.getAdditionalValuesFiles();
        if (this$additionalValuesFiles == null ? other$additionalValuesFiles != null : !this$additionalValuesFiles.equals(other$additionalValuesFiles)) {
            return false;
        }
        Object this$apiVersions = this.getApiVersions();
        Object other$apiVersions = other.getApiVersions();
        if (this$apiVersions == null ? other$apiVersions != null : !this$apiVersions.equals(other$apiVersions)) {
            return false;
        }
        Object this$debug = this.getDebug();
        Object other$debug = other.getDebug();
        if (this$debug == null ? other$debug != null : !this$debug.equals(other$debug)) {
            return false;
        }
        Object this$devel = this.getDevel();
        Object other$devel = other.getDevel();
        if (this$devel == null ? other$devel != null : !this$devel.equals(other$devel)) {
            return false;
        }
        Object this$includeCRDs = this.getIncludeCRDs();
        Object other$includeCRDs = other.getIncludeCRDs();
        if (this$includeCRDs == null ? other$includeCRDs != null : !this$includeCRDs.equals(other$includeCRDs)) {
            return false;
        }
        Object this$kubeVersion = this.getKubeVersion();
        Object other$kubeVersion = other.getKubeVersion();
        if (this$kubeVersion == null ? other$kubeVersion != null : !this$kubeVersion.equals(other$kubeVersion)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$nameTemplate = this.getNameTemplate();
        Object other$nameTemplate = other.getNameTemplate();
        if (this$nameTemplate == null ? other$nameTemplate != null : !this$nameTemplate.equals(other$nameTemplate)) {
            return false;
        }
        Object this$namespace = this.getNamespace();
        Object other$namespace = other.getNamespace();
        if (this$namespace == null ? other$namespace != null : !this$namespace.equals(other$namespace)) {
            return false;
        }
        Object this$releaseName = this.getReleaseName();
        Object other$releaseName = other.getReleaseName();
        if (this$releaseName == null ? other$releaseName != null : !this$releaseName.equals(other$releaseName)) {
            return false;
        }
        Object this$repo = this.getRepo();
        Object other$repo = other.getRepo();
        if (this$repo == null ? other$repo != null : !this$repo.equals(other$repo)) {
            return false;
        }
        Object this$skipHooks = this.getSkipHooks();
        Object other$skipHooks = other.getSkipHooks();
        if (this$skipHooks == null ? other$skipHooks != null : !this$skipHooks.equals(other$skipHooks)) {
            return false;
        }
        Object this$skipTests = this.getSkipTests();
        Object other$skipTests = other.getSkipTests();
        if (this$skipTests == null ? other$skipTests != null : !this$skipTests.equals(other$skipTests)) {
            return false;
        }
        Object this$valuesFile = this.getValuesFile();
        Object other$valuesFile = other.getValuesFile();
        if (this$valuesFile == null ? other$valuesFile != null : !this$valuesFile.equals(other$valuesFile)) {
            return false;
        }
        Object this$valuesInline = this.getValuesInline();
        Object other$valuesInline = other.getValuesInline();
        if (this$valuesInline == null ? other$valuesInline != null : !this$valuesInline.equals(other$valuesInline)) {
            return false;
        }
        Object this$valuesMerge = this.getValuesMerge();
        Object other$valuesMerge = other.getValuesMerge();
        if (this$valuesMerge == null ? other$valuesMerge != null : !this$valuesMerge.equals(other$valuesMerge)) {
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
        return other instanceof HelmChart;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $additionalValuesFiles = this.getAdditionalValuesFiles();
        result = result * prime + ($additionalValuesFiles == null ? 43 : $additionalValuesFiles.hashCode());
        Object $apiVersions = this.getApiVersions();
        result = result * prime + ($apiVersions == null ? 43 : $apiVersions.hashCode());
        Object $debug = this.getDebug();
        result = result * prime + ($debug == null ? 43 : $debug.hashCode());
        Object $devel = this.getDevel();
        result = result * prime + ($devel == null ? 43 : $devel.hashCode());
        Object $includeCRDs = this.getIncludeCRDs();
        result = result * prime + ($includeCRDs == null ? 43 : $includeCRDs.hashCode());
        Object $kubeVersion = this.getKubeVersion();
        result = result * prime + ($kubeVersion == null ? 43 : $kubeVersion.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $nameTemplate = this.getNameTemplate();
        result = result * prime + ($nameTemplate == null ? 43 : $nameTemplate.hashCode());
        Object $namespace = this.getNamespace();
        result = result * prime + ($namespace == null ? 43 : $namespace.hashCode());
        Object $releaseName = this.getReleaseName();
        result = result * prime + ($releaseName == null ? 43 : $releaseName.hashCode());
        Object $repo = this.getRepo();
        result = result * prime + ($repo == null ? 43 : $repo.hashCode());
        Object $skipHooks = this.getSkipHooks();
        result = result * prime + ($skipHooks == null ? 43 : $skipHooks.hashCode());
        Object $skipTests = this.getSkipTests();
        result = result * prime + ($skipTests == null ? 43 : $skipTests.hashCode());
        Object $valuesFile = this.getValuesFile();
        result = result * prime + ($valuesFile == null ? 43 : $valuesFile.hashCode());
        Object $valuesInline = this.getValuesInline();
        result = result * prime + ($valuesInline == null ? 43 : $valuesInline.hashCode());
        Object $valuesMerge = this.getValuesMerge();
        result = result * prime + ($valuesMerge == null ? 43 : $valuesMerge.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HelmChart(" + "additionalValuesFiles=" + this.getAdditionalValuesFiles() + ", apiVersions=" + this.getApiVersions() + ", debug=" + this.getDebug() + ", devel=" + this.getDevel() + ", includeCRDs=" + this.getIncludeCRDs() + ", kubeVersion=" + this.getKubeVersion() + ", name=" + this.getName() + ", nameTemplate=" + this.getNameTemplate() + ", namespace=" + this.getNamespace() + ", releaseName=" + this.getReleaseName() + ", repo=" + this.getRepo() + ", skipHooks=" + this.getSkipHooks() + ", skipTests=" + this.getSkipTests() + ", valuesFile=" + this.getValuesFile() + ", valuesInline=" + this.getValuesInline() + ", valuesMerge=" + this.getValuesMerge() + ", version=" + this.getVersion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
