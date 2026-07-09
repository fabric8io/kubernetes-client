package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class HelmChartFluent<A extends io.fabric8.kubernetes.api.model.kustomize.v1beta1.HelmChartFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> additionalValuesFiles = new ArrayList<String>();
  private List<String> apiVersions = new ArrayList<String>();
  private Boolean debug;
  private Boolean devel;
  private Boolean includeCRDs;
  private String kubeVersion;
  private String name;
  private String nameTemplate;
  private String namespace;
  private String releaseName;
  private String repo;
  private Boolean skipHooks;
  private Boolean skipTests;
  private String valuesFile;
  private Map<String,Object> valuesInline;
  private String valuesMerge;
  private String version;

  public HelmChartFluent() {
  }
  
  public HelmChartFluent(HelmChart instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdditionalValuesFiles(Collection<String> items) {
    if (this.additionalValuesFiles == null) {
      this.additionalValuesFiles = new ArrayList();
    }
    for (String item : items) {
      this.additionalValuesFiles.add(item);
    }
    return (A) this;
  }
  
  public A addAllToApiVersions(Collection<String> items) {
    if (this.apiVersions == null) {
      this.apiVersions = new ArrayList();
    }
    for (String item : items) {
      this.apiVersions.add(item);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public A addToAdditionalValuesFiles(String... items) {
    if (this.additionalValuesFiles == null) {
      this.additionalValuesFiles = new ArrayList();
    }
    for (String item : items) {
      this.additionalValuesFiles.add(item);
    }
    return (A) this;
  }
  
  public A addToAdditionalValuesFiles(int index,String item) {
    if (this.additionalValuesFiles == null) {
      this.additionalValuesFiles = new ArrayList();
    }
    this.additionalValuesFiles.add(index, item);
    return (A) this;
  }
  
  public A addToApiVersions(String... items) {
    if (this.apiVersions == null) {
      this.apiVersions = new ArrayList();
    }
    for (String item : items) {
      this.apiVersions.add(item);
    }
    return (A) this;
  }
  
  public A addToApiVersions(int index,String item) {
    if (this.apiVersions == null) {
      this.apiVersions = new ArrayList();
    }
    this.apiVersions.add(index, item);
    return (A) this;
  }
  
  public A addToValuesInline(Map<String,Object> map) {
    if (this.valuesInline == null && map != null) {
      this.valuesInline = new LinkedHashMap();
    }
    if (map != null) {
      this.valuesInline.putAll(map);
    }
    return (A) this;
  }
  
  public A addToValuesInline(String key,Object value) {
    if (this.valuesInline == null && key != null && value != null) {
      this.valuesInline = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.valuesInline.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(HelmChart instance) {
    instance = instance != null ? instance : new HelmChart();
    if (instance != null) {
        this.withAdditionalValuesFiles(instance.getAdditionalValuesFiles());
        this.withApiVersions(instance.getApiVersions());
        this.withDebug(instance.getDebug());
        this.withDevel(instance.getDevel());
        this.withIncludeCRDs(instance.getIncludeCRDs());
        this.withKubeVersion(instance.getKubeVersion());
        this.withName(instance.getName());
        this.withNameTemplate(instance.getNameTemplate());
        this.withNamespace(instance.getNamespace());
        this.withReleaseName(instance.getReleaseName());
        this.withRepo(instance.getRepo());
        this.withSkipHooks(instance.getSkipHooks());
        this.withSkipTests(instance.getSkipTests());
        this.withValuesFile(instance.getValuesFile());
        this.withValuesInline(instance.getValuesInline());
        this.withValuesMerge(instance.getValuesMerge());
        this.withVersion(instance.getVersion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    HelmChartFluent that = (HelmChartFluent) o;
    if (!(Objects.equals(additionalValuesFiles, that.additionalValuesFiles))) {
      return false;
    }
    if (!(Objects.equals(apiVersions, that.apiVersions))) {
      return false;
    }
    if (!(Objects.equals(debug, that.debug))) {
      return false;
    }
    if (!(Objects.equals(devel, that.devel))) {
      return false;
    }
    if (!(Objects.equals(includeCRDs, that.includeCRDs))) {
      return false;
    }
    if (!(Objects.equals(kubeVersion, that.kubeVersion))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(nameTemplate, that.nameTemplate))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(releaseName, that.releaseName))) {
      return false;
    }
    if (!(Objects.equals(repo, that.repo))) {
      return false;
    }
    if (!(Objects.equals(skipHooks, that.skipHooks))) {
      return false;
    }
    if (!(Objects.equals(skipTests, that.skipTests))) {
      return false;
    }
    if (!(Objects.equals(valuesFile, that.valuesFile))) {
      return false;
    }
    if (!(Objects.equals(valuesInline, that.valuesInline))) {
      return false;
    }
    if (!(Objects.equals(valuesMerge, that.valuesMerge))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getAdditionalValuesFile(int index) {
    return this.additionalValuesFiles.get(index);
  }
  
  public List<String> getAdditionalValuesFiles() {
    return this.additionalValuesFiles;
  }
  
  public String getApiVersion(int index) {
    return this.apiVersions.get(index);
  }
  
  public List<String> getApiVersions() {
    return this.apiVersions;
  }
  
  public Boolean getDebug() {
    return this.debug;
  }
  
  public Boolean getDevel() {
    return this.devel;
  }
  
  public String getFirstAdditionalValuesFile() {
    return this.additionalValuesFiles.get(0);
  }
  
  public String getFirstApiVersion() {
    return this.apiVersions.get(0);
  }
  
  public Boolean getIncludeCRDs() {
    return this.includeCRDs;
  }
  
  public String getKubeVersion() {
    return this.kubeVersion;
  }
  
  public String getLastAdditionalValuesFile() {
    return this.additionalValuesFiles.get(additionalValuesFiles.size() - 1);
  }
  
  public String getLastApiVersion() {
    return this.apiVersions.get(apiVersions.size() - 1);
  }
  
  public String getMatchingAdditionalValuesFile(Predicate<String> predicate) {
      for (String item : additionalValuesFiles) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingApiVersion(Predicate<String> predicate) {
      for (String item : apiVersions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getNameTemplate() {
    return this.nameTemplate;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public String getReleaseName() {
    return this.releaseName;
  }
  
  public String getRepo() {
    return this.repo;
  }
  
  public Boolean getSkipHooks() {
    return this.skipHooks;
  }
  
  public Boolean getSkipTests() {
    return this.skipTests;
  }
  
  public String getValuesFile() {
    return this.valuesFile;
  }
  
  public Map<String,Object> getValuesInline() {
    return this.valuesInline;
  }
  
  public String getValuesMerge() {
    return this.valuesMerge;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAdditionalValuesFiles() {
    return this.additionalValuesFiles != null && !(this.additionalValuesFiles.isEmpty());
  }
  
  public boolean hasApiVersions() {
    return this.apiVersions != null && !(this.apiVersions.isEmpty());
  }
  
  public boolean hasDebug() {
    return this.debug != null;
  }
  
  public boolean hasDevel() {
    return this.devel != null;
  }
  
  public boolean hasIncludeCRDs() {
    return this.includeCRDs != null;
  }
  
  public boolean hasKubeVersion() {
    return this.kubeVersion != null;
  }
  
  public boolean hasMatchingAdditionalValuesFile(Predicate<String> predicate) {
      for (String item : additionalValuesFiles) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingApiVersion(Predicate<String> predicate) {
      for (String item : apiVersions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNameTemplate() {
    return this.nameTemplate != null;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasReleaseName() {
    return this.releaseName != null;
  }
  
  public boolean hasRepo() {
    return this.repo != null;
  }
  
  public boolean hasSkipHooks() {
    return this.skipHooks != null;
  }
  
  public boolean hasSkipTests() {
    return this.skipTests != null;
  }
  
  public boolean hasValuesFile() {
    return this.valuesFile != null;
  }
  
  public boolean hasValuesInline() {
    return this.valuesInline != null;
  }
  
  public boolean hasValuesMerge() {
    return this.valuesMerge != null;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public int hashCode() {
    return Objects.hash(additionalValuesFiles, apiVersions, debug, devel, includeCRDs, kubeVersion, name, nameTemplate, namespace, releaseName, repo, skipHooks, skipTests, valuesFile, valuesInline, valuesMerge, version, additionalProperties);
  }
  
  public A removeAllFromAdditionalValuesFiles(Collection<String> items) {
    if (this.additionalValuesFiles == null) {
      return (A) this;
    }
    for (String item : items) {
      this.additionalValuesFiles.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromApiVersions(Collection<String> items) {
    if (this.apiVersions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.apiVersions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromAdditionalValuesFiles(String... items) {
    if (this.additionalValuesFiles == null) {
      return (A) this;
    }
    for (String item : items) {
      this.additionalValuesFiles.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromApiVersions(String... items) {
    if (this.apiVersions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.apiVersions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromValuesInline(String key) {
    if (this.valuesInline == null) {
      return (A) this;
    }
    if (key != null && this.valuesInline != null) {
      this.valuesInline.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromValuesInline(Map<String,Object> map) {
    if (this.valuesInline == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.valuesInline != null) {
          this.valuesInline.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A setToAdditionalValuesFiles(int index,String item) {
    if (this.additionalValuesFiles == null) {
      this.additionalValuesFiles = new ArrayList();
    }
    this.additionalValuesFiles.set(index, item);
    return (A) this;
  }
  
  public A setToApiVersions(int index,String item) {
    if (this.apiVersions == null) {
      this.apiVersions = new ArrayList();
    }
    this.apiVersions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(additionalValuesFiles == null) && !(additionalValuesFiles.isEmpty())) {
        sb.append("additionalValuesFiles:");
        sb.append(additionalValuesFiles);
        sb.append(",");
    }
    if (!(apiVersions == null) && !(apiVersions.isEmpty())) {
        sb.append("apiVersions:");
        sb.append(apiVersions);
        sb.append(",");
    }
    if (!(debug == null)) {
        sb.append("debug:");
        sb.append(debug);
        sb.append(",");
    }
    if (!(devel == null)) {
        sb.append("devel:");
        sb.append(devel);
        sb.append(",");
    }
    if (!(includeCRDs == null)) {
        sb.append("includeCRDs:");
        sb.append(includeCRDs);
        sb.append(",");
    }
    if (!(kubeVersion == null)) {
        sb.append("kubeVersion:");
        sb.append(kubeVersion);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(nameTemplate == null)) {
        sb.append("nameTemplate:");
        sb.append(nameTemplate);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(releaseName == null)) {
        sb.append("releaseName:");
        sb.append(releaseName);
        sb.append(",");
    }
    if (!(repo == null)) {
        sb.append("repo:");
        sb.append(repo);
        sb.append(",");
    }
    if (!(skipHooks == null)) {
        sb.append("skipHooks:");
        sb.append(skipHooks);
        sb.append(",");
    }
    if (!(skipTests == null)) {
        sb.append("skipTests:");
        sb.append(skipTests);
        sb.append(",");
    }
    if (!(valuesFile == null)) {
        sb.append("valuesFile:");
        sb.append(valuesFile);
        sb.append(",");
    }
    if (!(valuesInline == null) && !(valuesInline.isEmpty())) {
        sb.append("valuesInline:");
        sb.append(valuesInline);
        sb.append(",");
    }
    if (!(valuesMerge == null)) {
        sb.append("valuesMerge:");
        sb.append(valuesMerge);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withAdditionalValuesFiles(List<String> additionalValuesFiles) {
    if (additionalValuesFiles != null) {
        this.additionalValuesFiles = new ArrayList();
        for (String item : additionalValuesFiles) {
          this.addToAdditionalValuesFiles(item);
        }
    } else {
      this.additionalValuesFiles = null;
    }
    return (A) this;
  }
  
  public A withAdditionalValuesFiles(String... additionalValuesFiles) {
    if (this.additionalValuesFiles != null) {
        this.additionalValuesFiles.clear();
        _visitables.remove("additionalValuesFiles");
    }
    if (additionalValuesFiles != null) {
      for (String item : additionalValuesFiles) {
        this.addToAdditionalValuesFiles(item);
      }
    }
    return (A) this;
  }
  
  public A withApiVersions(List<String> apiVersions) {
    if (apiVersions != null) {
        this.apiVersions = new ArrayList();
        for (String item : apiVersions) {
          this.addToApiVersions(item);
        }
    } else {
      this.apiVersions = null;
    }
    return (A) this;
  }
  
  public A withApiVersions(String... apiVersions) {
    if (this.apiVersions != null) {
        this.apiVersions.clear();
        _visitables.remove("apiVersions");
    }
    if (apiVersions != null) {
      for (String item : apiVersions) {
        this.addToApiVersions(item);
      }
    }
    return (A) this;
  }
  
  public A withDebug() {
    return withDebug(true);
  }
  
  public A withDebug(Boolean debug) {
    this.debug = debug;
    return (A) this;
  }
  
  public A withDevel() {
    return withDevel(true);
  }
  
  public A withDevel(Boolean devel) {
    this.devel = devel;
    return (A) this;
  }
  
  public A withIncludeCRDs() {
    return withIncludeCRDs(true);
  }
  
  public A withIncludeCRDs(Boolean includeCRDs) {
    this.includeCRDs = includeCRDs;
    return (A) this;
  }
  
  public A withKubeVersion(String kubeVersion) {
    this.kubeVersion = kubeVersion;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNameTemplate(String nameTemplate) {
    this.nameTemplate = nameTemplate;
    return (A) this;
  }
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public A withReleaseName(String releaseName) {
    this.releaseName = releaseName;
    return (A) this;
  }
  
  public A withRepo(String repo) {
    this.repo = repo;
    return (A) this;
  }
  
  public A withSkipHooks() {
    return withSkipHooks(true);
  }
  
  public A withSkipHooks(Boolean skipHooks) {
    this.skipHooks = skipHooks;
    return (A) this;
  }
  
  public A withSkipTests() {
    return withSkipTests(true);
  }
  
  public A withSkipTests(Boolean skipTests) {
    this.skipTests = skipTests;
    return (A) this;
  }
  
  public A withValuesFile(String valuesFile) {
    this.valuesFile = valuesFile;
    return (A) this;
  }
  
  public <K,V>A withValuesInline(Map<String,Object> valuesInline) {
    if (valuesInline == null) {
      this.valuesInline = null;
    } else {
      this.valuesInline = new LinkedHashMap(valuesInline);
    }
    return (A) this;
  }
  
  public A withValuesMerge(String valuesMerge) {
    this.valuesMerge = valuesMerge;
    return (A) this;
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  
}