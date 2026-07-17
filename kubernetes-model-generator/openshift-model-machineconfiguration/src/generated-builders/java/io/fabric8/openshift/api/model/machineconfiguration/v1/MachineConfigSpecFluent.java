package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
public class MachineConfigSpecFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.MachineConfigSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String baseOSExtensionsContainerImage;
  private Object config;
  private List<String> extensions = new ArrayList<String>();
  private Boolean fips;
  private List<String> kernelArguments = new ArrayList<String>();
  private String kernelType;
  private String osImageURL;

  public MachineConfigSpecFluent() {
  }
  
  public MachineConfigSpecFluent(MachineConfigSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToExtensions(Collection<String> items) {
    if (this.extensions == null) {
      this.extensions = new ArrayList();
    }
    for (String item : items) {
      this.extensions.add(item);
    }
    return (A) this;
  }
  
  public A addAllToKernelArguments(Collection<String> items) {
    if (this.kernelArguments == null) {
      this.kernelArguments = new ArrayList();
    }
    for (String item : items) {
      this.kernelArguments.add(item);
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
  
  public A addToExtensions(String... items) {
    if (this.extensions == null) {
      this.extensions = new ArrayList();
    }
    for (String item : items) {
      this.extensions.add(item);
    }
    return (A) this;
  }
  
  public A addToExtensions(int index,String item) {
    if (this.extensions == null) {
      this.extensions = new ArrayList();
    }
    this.extensions.add(index, item);
    return (A) this;
  }
  
  public A addToKernelArguments(String... items) {
    if (this.kernelArguments == null) {
      this.kernelArguments = new ArrayList();
    }
    for (String item : items) {
      this.kernelArguments.add(item);
    }
    return (A) this;
  }
  
  public A addToKernelArguments(int index,String item) {
    if (this.kernelArguments == null) {
      this.kernelArguments = new ArrayList();
    }
    this.kernelArguments.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(MachineConfigSpec instance) {
    instance = instance != null ? instance : new MachineConfigSpec();
    if (instance != null) {
        this.withBaseOSExtensionsContainerImage(instance.getBaseOSExtensionsContainerImage());
        this.withConfig(instance.getConfig());
        this.withExtensions(instance.getExtensions());
        this.withFips(instance.getFips());
        this.withKernelArguments(instance.getKernelArguments());
        this.withKernelType(instance.getKernelType());
        this.withOsImageURL(instance.getOsImageURL());
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
    MachineConfigSpecFluent that = (MachineConfigSpecFluent) o;
    if (!(Objects.equals(baseOSExtensionsContainerImage, that.baseOSExtensionsContainerImage))) {
      return false;
    }
    if (!(Objects.equals(config, that.config))) {
      return false;
    }
    if (!(Objects.equals(extensions, that.extensions))) {
      return false;
    }
    if (!(Objects.equals(fips, that.fips))) {
      return false;
    }
    if (!(Objects.equals(kernelArguments, that.kernelArguments))) {
      return false;
    }
    if (!(Objects.equals(kernelType, that.kernelType))) {
      return false;
    }
    if (!(Objects.equals(osImageURL, that.osImageURL))) {
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
  
  public String getBaseOSExtensionsContainerImage() {
    return this.baseOSExtensionsContainerImage;
  }
  
  public Object getConfig() {
    return this.config;
  }
  
  public String getExtension(int index) {
    return this.extensions.get(index);
  }
  
  public List<String> getExtensions() {
    return this.extensions;
  }
  
  public Boolean getFips() {
    return this.fips;
  }
  
  public String getFirstExtension() {
    return this.extensions.get(0);
  }
  
  public String getFirstKernelArgument() {
    return this.kernelArguments.get(0);
  }
  
  public String getKernelArgument(int index) {
    return this.kernelArguments.get(index);
  }
  
  public List<String> getKernelArguments() {
    return this.kernelArguments;
  }
  
  public String getKernelType() {
    return this.kernelType;
  }
  
  public String getLastExtension() {
    return this.extensions.get(extensions.size() - 1);
  }
  
  public String getLastKernelArgument() {
    return this.kernelArguments.get(kernelArguments.size() - 1);
  }
  
  public String getMatchingExtension(Predicate<String> predicate) {
      for (String item : extensions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingKernelArgument(Predicate<String> predicate) {
      for (String item : kernelArguments) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getOsImageURL() {
    return this.osImageURL;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBaseOSExtensionsContainerImage() {
    return this.baseOSExtensionsContainerImage != null;
  }
  
  public boolean hasConfig() {
    return this.config != null;
  }
  
  public boolean hasExtensions() {
    return this.extensions != null && !(this.extensions.isEmpty());
  }
  
  public boolean hasFips() {
    return this.fips != null;
  }
  
  public boolean hasKernelArguments() {
    return this.kernelArguments != null && !(this.kernelArguments.isEmpty());
  }
  
  public boolean hasKernelType() {
    return this.kernelType != null;
  }
  
  public boolean hasMatchingExtension(Predicate<String> predicate) {
      for (String item : extensions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingKernelArgument(Predicate<String> predicate) {
      for (String item : kernelArguments) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOsImageURL() {
    return this.osImageURL != null;
  }
  
  public int hashCode() {
    return Objects.hash(baseOSExtensionsContainerImage, config, extensions, fips, kernelArguments, kernelType, osImageURL, additionalProperties);
  }
  
  public A removeAllFromExtensions(Collection<String> items) {
    if (this.extensions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.extensions.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromKernelArguments(Collection<String> items) {
    if (this.kernelArguments == null) {
      return (A) this;
    }
    for (String item : items) {
      this.kernelArguments.remove(item);
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
  
  public A removeFromExtensions(String... items) {
    if (this.extensions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.extensions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromKernelArguments(String... items) {
    if (this.kernelArguments == null) {
      return (A) this;
    }
    for (String item : items) {
      this.kernelArguments.remove(item);
    }
    return (A) this;
  }
  
  public A setToExtensions(int index,String item) {
    if (this.extensions == null) {
      this.extensions = new ArrayList();
    }
    this.extensions.set(index, item);
    return (A) this;
  }
  
  public A setToKernelArguments(int index,String item) {
    if (this.kernelArguments == null) {
      this.kernelArguments = new ArrayList();
    }
    this.kernelArguments.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(baseOSExtensionsContainerImage == null)) {
        sb.append("baseOSExtensionsContainerImage:");
        sb.append(baseOSExtensionsContainerImage);
        sb.append(",");
    }
    if (!(config == null)) {
        sb.append("config:");
        sb.append(config);
        sb.append(",");
    }
    if (!(extensions == null) && !(extensions.isEmpty())) {
        sb.append("extensions:");
        sb.append(extensions);
        sb.append(",");
    }
    if (!(fips == null)) {
        sb.append("fips:");
        sb.append(fips);
        sb.append(",");
    }
    if (!(kernelArguments == null) && !(kernelArguments.isEmpty())) {
        sb.append("kernelArguments:");
        sb.append(kernelArguments);
        sb.append(",");
    }
    if (!(kernelType == null)) {
        sb.append("kernelType:");
        sb.append(kernelType);
        sb.append(",");
    }
    if (!(osImageURL == null)) {
        sb.append("osImageURL:");
        sb.append(osImageURL);
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
  
  public A withBaseOSExtensionsContainerImage(String baseOSExtensionsContainerImage) {
    this.baseOSExtensionsContainerImage = baseOSExtensionsContainerImage;
    return (A) this;
  }
  
  public A withConfig(Object config) {
    this.config = config;
    return (A) this;
  }
  
  public A withExtensions(List<String> extensions) {
    if (extensions != null) {
        this.extensions = new ArrayList();
        for (String item : extensions) {
          this.addToExtensions(item);
        }
    } else {
      this.extensions = null;
    }
    return (A) this;
  }
  
  public A withExtensions(String... extensions) {
    if (this.extensions != null) {
        this.extensions.clear();
        _visitables.remove("extensions");
    }
    if (extensions != null) {
      for (String item : extensions) {
        this.addToExtensions(item);
      }
    }
    return (A) this;
  }
  
  public A withFips() {
    return withFips(true);
  }
  
  public A withFips(Boolean fips) {
    this.fips = fips;
    return (A) this;
  }
  
  public A withKernelArguments(List<String> kernelArguments) {
    if (kernelArguments != null) {
        this.kernelArguments = new ArrayList();
        for (String item : kernelArguments) {
          this.addToKernelArguments(item);
        }
    } else {
      this.kernelArguments = null;
    }
    return (A) this;
  }
  
  public A withKernelArguments(String... kernelArguments) {
    if (this.kernelArguments != null) {
        this.kernelArguments.clear();
        _visitables.remove("kernelArguments");
    }
    if (kernelArguments != null) {
      for (String item : kernelArguments) {
        this.addToKernelArguments(item);
      }
    }
    return (A) this;
  }
  
  public A withKernelType(String kernelType) {
    this.kernelType = kernelType;
    return (A) this;
  }
  
  public A withOsImageURL(String osImageURL) {
    this.osImageURL = osImageURL;
    return (A) this;
  }
  
}