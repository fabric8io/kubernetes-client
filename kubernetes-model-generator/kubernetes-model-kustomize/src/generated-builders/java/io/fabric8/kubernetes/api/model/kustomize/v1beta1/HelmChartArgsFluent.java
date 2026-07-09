package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class HelmChartArgsFluent<A extends io.fabric8.kubernetes.api.model.kustomize.v1beta1.HelmChartArgsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String chartHome;
  private String chartName;
  private String chartRepoName;
  private String chartRepoUrl;
  private String chartVersion;
  private List<String> extraArgs = new ArrayList<String>();
  private String helmBin;
  private String helmHome;
  private String releaseName;
  private String releaseNamespace;
  private String values;
  private Map<String,Object> valuesLocal;
  private String valuesMerge;

  public HelmChartArgsFluent() {
  }
  
  public HelmChartArgsFluent(HelmChartArgs instance) {
    this.copyInstance(instance);
  }

  public A addAllToExtraArgs(Collection<String> items) {
    if (this.extraArgs == null) {
      this.extraArgs = new ArrayList();
    }
    for (String item : items) {
      this.extraArgs.add(item);
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
  
  public A addToExtraArgs(String... items) {
    if (this.extraArgs == null) {
      this.extraArgs = new ArrayList();
    }
    for (String item : items) {
      this.extraArgs.add(item);
    }
    return (A) this;
  }
  
  public A addToExtraArgs(int index,String item) {
    if (this.extraArgs == null) {
      this.extraArgs = new ArrayList();
    }
    this.extraArgs.add(index, item);
    return (A) this;
  }
  
  public A addToValuesLocal(Map<String,Object> map) {
    if (this.valuesLocal == null && map != null) {
      this.valuesLocal = new LinkedHashMap();
    }
    if (map != null) {
      this.valuesLocal.putAll(map);
    }
    return (A) this;
  }
  
  public A addToValuesLocal(String key,Object value) {
    if (this.valuesLocal == null && key != null && value != null) {
      this.valuesLocal = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.valuesLocal.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(HelmChartArgs instance) {
    instance = instance != null ? instance : new HelmChartArgs();
    if (instance != null) {
        this.withChartHome(instance.getChartHome());
        this.withChartName(instance.getChartName());
        this.withChartRepoName(instance.getChartRepoName());
        this.withChartRepoUrl(instance.getChartRepoUrl());
        this.withChartVersion(instance.getChartVersion());
        this.withExtraArgs(instance.getExtraArgs());
        this.withHelmBin(instance.getHelmBin());
        this.withHelmHome(instance.getHelmHome());
        this.withReleaseName(instance.getReleaseName());
        this.withReleaseNamespace(instance.getReleaseNamespace());
        this.withValues(instance.getValues());
        this.withValuesLocal(instance.getValuesLocal());
        this.withValuesMerge(instance.getValuesMerge());
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
    HelmChartArgsFluent that = (HelmChartArgsFluent) o;
    if (!(Objects.equals(chartHome, that.chartHome))) {
      return false;
    }
    if (!(Objects.equals(chartName, that.chartName))) {
      return false;
    }
    if (!(Objects.equals(chartRepoName, that.chartRepoName))) {
      return false;
    }
    if (!(Objects.equals(chartRepoUrl, that.chartRepoUrl))) {
      return false;
    }
    if (!(Objects.equals(chartVersion, that.chartVersion))) {
      return false;
    }
    if (!(Objects.equals(extraArgs, that.extraArgs))) {
      return false;
    }
    if (!(Objects.equals(helmBin, that.helmBin))) {
      return false;
    }
    if (!(Objects.equals(helmHome, that.helmHome))) {
      return false;
    }
    if (!(Objects.equals(releaseName, that.releaseName))) {
      return false;
    }
    if (!(Objects.equals(releaseNamespace, that.releaseNamespace))) {
      return false;
    }
    if (!(Objects.equals(values, that.values))) {
      return false;
    }
    if (!(Objects.equals(valuesLocal, that.valuesLocal))) {
      return false;
    }
    if (!(Objects.equals(valuesMerge, that.valuesMerge))) {
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
  
  public String getChartHome() {
    return this.chartHome;
  }
  
  public String getChartName() {
    return this.chartName;
  }
  
  public String getChartRepoName() {
    return this.chartRepoName;
  }
  
  public String getChartRepoUrl() {
    return this.chartRepoUrl;
  }
  
  public String getChartVersion() {
    return this.chartVersion;
  }
  
  public String getExtraArg(int index) {
    return this.extraArgs.get(index);
  }
  
  public List<String> getExtraArgs() {
    return this.extraArgs;
  }
  
  public String getFirstExtraArg() {
    return this.extraArgs.get(0);
  }
  
  public String getHelmBin() {
    return this.helmBin;
  }
  
  public String getHelmHome() {
    return this.helmHome;
  }
  
  public String getLastExtraArg() {
    return this.extraArgs.get(extraArgs.size() - 1);
  }
  
  public String getMatchingExtraArg(Predicate<String> predicate) {
      for (String item : extraArgs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getReleaseName() {
    return this.releaseName;
  }
  
  public String getReleaseNamespace() {
    return this.releaseNamespace;
  }
  
  public String getValues() {
    return this.values;
  }
  
  public Map<String,Object> getValuesLocal() {
    return this.valuesLocal;
  }
  
  public String getValuesMerge() {
    return this.valuesMerge;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasChartHome() {
    return this.chartHome != null;
  }
  
  public boolean hasChartName() {
    return this.chartName != null;
  }
  
  public boolean hasChartRepoName() {
    return this.chartRepoName != null;
  }
  
  public boolean hasChartRepoUrl() {
    return this.chartRepoUrl != null;
  }
  
  public boolean hasChartVersion() {
    return this.chartVersion != null;
  }
  
  public boolean hasExtraArgs() {
    return this.extraArgs != null && !(this.extraArgs.isEmpty());
  }
  
  public boolean hasHelmBin() {
    return this.helmBin != null;
  }
  
  public boolean hasHelmHome() {
    return this.helmHome != null;
  }
  
  public boolean hasMatchingExtraArg(Predicate<String> predicate) {
      for (String item : extraArgs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasReleaseName() {
    return this.releaseName != null;
  }
  
  public boolean hasReleaseNamespace() {
    return this.releaseNamespace != null;
  }
  
  public boolean hasValues() {
    return this.values != null;
  }
  
  public boolean hasValuesLocal() {
    return this.valuesLocal != null;
  }
  
  public boolean hasValuesMerge() {
    return this.valuesMerge != null;
  }
  
  public int hashCode() {
    return Objects.hash(chartHome, chartName, chartRepoName, chartRepoUrl, chartVersion, extraArgs, helmBin, helmHome, releaseName, releaseNamespace, values, valuesLocal, valuesMerge, additionalProperties);
  }
  
  public A removeAllFromExtraArgs(Collection<String> items) {
    if (this.extraArgs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.extraArgs.remove(item);
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
  
  public A removeFromExtraArgs(String... items) {
    if (this.extraArgs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.extraArgs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromValuesLocal(String key) {
    if (this.valuesLocal == null) {
      return (A) this;
    }
    if (key != null && this.valuesLocal != null) {
      this.valuesLocal.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromValuesLocal(Map<String,Object> map) {
    if (this.valuesLocal == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.valuesLocal != null) {
          this.valuesLocal.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A setToExtraArgs(int index,String item) {
    if (this.extraArgs == null) {
      this.extraArgs = new ArrayList();
    }
    this.extraArgs.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(chartHome == null)) {
        sb.append("chartHome:");
        sb.append(chartHome);
        sb.append(",");
    }
    if (!(chartName == null)) {
        sb.append("chartName:");
        sb.append(chartName);
        sb.append(",");
    }
    if (!(chartRepoName == null)) {
        sb.append("chartRepoName:");
        sb.append(chartRepoName);
        sb.append(",");
    }
    if (!(chartRepoUrl == null)) {
        sb.append("chartRepoUrl:");
        sb.append(chartRepoUrl);
        sb.append(",");
    }
    if (!(chartVersion == null)) {
        sb.append("chartVersion:");
        sb.append(chartVersion);
        sb.append(",");
    }
    if (!(extraArgs == null) && !(extraArgs.isEmpty())) {
        sb.append("extraArgs:");
        sb.append(extraArgs);
        sb.append(",");
    }
    if (!(helmBin == null)) {
        sb.append("helmBin:");
        sb.append(helmBin);
        sb.append(",");
    }
    if (!(helmHome == null)) {
        sb.append("helmHome:");
        sb.append(helmHome);
        sb.append(",");
    }
    if (!(releaseName == null)) {
        sb.append("releaseName:");
        sb.append(releaseName);
        sb.append(",");
    }
    if (!(releaseNamespace == null)) {
        sb.append("releaseNamespace:");
        sb.append(releaseNamespace);
        sb.append(",");
    }
    if (!(values == null)) {
        sb.append("values:");
        sb.append(values);
        sb.append(",");
    }
    if (!(valuesLocal == null) && !(valuesLocal.isEmpty())) {
        sb.append("valuesLocal:");
        sb.append(valuesLocal);
        sb.append(",");
    }
    if (!(valuesMerge == null)) {
        sb.append("valuesMerge:");
        sb.append(valuesMerge);
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
  
  public A withChartHome(String chartHome) {
    this.chartHome = chartHome;
    return (A) this;
  }
  
  public A withChartName(String chartName) {
    this.chartName = chartName;
    return (A) this;
  }
  
  public A withChartRepoName(String chartRepoName) {
    this.chartRepoName = chartRepoName;
    return (A) this;
  }
  
  public A withChartRepoUrl(String chartRepoUrl) {
    this.chartRepoUrl = chartRepoUrl;
    return (A) this;
  }
  
  public A withChartVersion(String chartVersion) {
    this.chartVersion = chartVersion;
    return (A) this;
  }
  
  public A withExtraArgs(List<String> extraArgs) {
    if (extraArgs != null) {
        this.extraArgs = new ArrayList();
        for (String item : extraArgs) {
          this.addToExtraArgs(item);
        }
    } else {
      this.extraArgs = null;
    }
    return (A) this;
  }
  
  public A withExtraArgs(String... extraArgs) {
    if (this.extraArgs != null) {
        this.extraArgs.clear();
        _visitables.remove("extraArgs");
    }
    if (extraArgs != null) {
      for (String item : extraArgs) {
        this.addToExtraArgs(item);
      }
    }
    return (A) this;
  }
  
  public A withHelmBin(String helmBin) {
    this.helmBin = helmBin;
    return (A) this;
  }
  
  public A withHelmHome(String helmHome) {
    this.helmHome = helmHome;
    return (A) this;
  }
  
  public A withReleaseName(String releaseName) {
    this.releaseName = releaseName;
    return (A) this;
  }
  
  public A withReleaseNamespace(String releaseNamespace) {
    this.releaseNamespace = releaseNamespace;
    return (A) this;
  }
  
  public A withValues(String values) {
    this.values = values;
    return (A) this;
  }
  
  public <K,V>A withValuesLocal(Map<String,Object> valuesLocal) {
    if (valuesLocal == null) {
      this.valuesLocal = null;
    } else {
      this.valuesLocal = new LinkedHashMap(valuesLocal);
    }
    return (A) this;
  }
  
  public A withValuesMerge(String valuesMerge) {
    this.valuesMerge = valuesMerge;
    return (A) this;
  }
  
}