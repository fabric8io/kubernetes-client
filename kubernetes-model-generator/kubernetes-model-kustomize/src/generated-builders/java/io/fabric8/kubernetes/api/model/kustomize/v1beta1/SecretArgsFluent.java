package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class SecretArgsFluent<A extends io.fabric8.kubernetes.api.model.kustomize.v1beta1.SecretArgsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String behavior;
  private String env;
  private List<String> envs = new ArrayList<String>();
  private List<String> files = new ArrayList<String>();
  private List<String> literals = new ArrayList<String>();
  private String name;
  private String namespace;
  private GeneratorOptionsBuilder options;
  private String type;

  public SecretArgsFluent() {
  }
  
  public SecretArgsFluent(SecretArgs instance) {
    this.copyInstance(instance);
  }

  public A addAllToEnvs(Collection<String> items) {
    if (this.envs == null) {
      this.envs = new ArrayList();
    }
    for (String item : items) {
      this.envs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToFiles(Collection<String> items) {
    if (this.files == null) {
      this.files = new ArrayList();
    }
    for (String item : items) {
      this.files.add(item);
    }
    return (A) this;
  }
  
  public A addAllToLiterals(Collection<String> items) {
    if (this.literals == null) {
      this.literals = new ArrayList();
    }
    for (String item : items) {
      this.literals.add(item);
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
  
  public A addToEnvs(String... items) {
    if (this.envs == null) {
      this.envs = new ArrayList();
    }
    for (String item : items) {
      this.envs.add(item);
    }
    return (A) this;
  }
  
  public A addToEnvs(int index,String item) {
    if (this.envs == null) {
      this.envs = new ArrayList();
    }
    this.envs.add(index, item);
    return (A) this;
  }
  
  public A addToFiles(String... items) {
    if (this.files == null) {
      this.files = new ArrayList();
    }
    for (String item : items) {
      this.files.add(item);
    }
    return (A) this;
  }
  
  public A addToFiles(int index,String item) {
    if (this.files == null) {
      this.files = new ArrayList();
    }
    this.files.add(index, item);
    return (A) this;
  }
  
  public A addToLiterals(String... items) {
    if (this.literals == null) {
      this.literals = new ArrayList();
    }
    for (String item : items) {
      this.literals.add(item);
    }
    return (A) this;
  }
  
  public A addToLiterals(int index,String item) {
    if (this.literals == null) {
      this.literals = new ArrayList();
    }
    this.literals.add(index, item);
    return (A) this;
  }
  
  public GeneratorOptions buildOptions() {
    return this.options != null ? this.options.build() : null;
  }
  
  protected void copyInstance(SecretArgs instance) {
    instance = instance != null ? instance : new SecretArgs();
    if (instance != null) {
        this.withBehavior(instance.getBehavior());
        this.withEnv(instance.getEnv());
        this.withEnvs(instance.getEnvs());
        this.withFiles(instance.getFiles());
        this.withLiterals(instance.getLiterals());
        this.withName(instance.getName());
        this.withNamespace(instance.getNamespace());
        this.withOptions(instance.getOptions());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public OptionsNested<A> editOptions() {
    return this.withNewOptionsLike(Optional.ofNullable(this.buildOptions()).orElse(null));
  }
  
  public OptionsNested<A> editOrNewOptions() {
    return this.withNewOptionsLike(Optional.ofNullable(this.buildOptions()).orElse(new GeneratorOptionsBuilder().build()));
  }
  
  public OptionsNested<A> editOrNewOptionsLike(GeneratorOptions item) {
    return this.withNewOptionsLike(Optional.ofNullable(this.buildOptions()).orElse(item));
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
    SecretArgsFluent that = (SecretArgsFluent) o;
    if (!(Objects.equals(behavior, that.behavior))) {
      return false;
    }
    if (!(Objects.equals(env, that.env))) {
      return false;
    }
    if (!(Objects.equals(envs, that.envs))) {
      return false;
    }
    if (!(Objects.equals(files, that.files))) {
      return false;
    }
    if (!(Objects.equals(literals, that.literals))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(options, that.options))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getBehavior() {
    return this.behavior;
  }
  
  public String getEnv() {
    return this.env;
  }
  
  public String getEnv(int index) {
    return this.envs.get(index);
  }
  
  public List<String> getEnvs() {
    return this.envs;
  }
  
  public String getFile(int index) {
    return this.files.get(index);
  }
  
  public List<String> getFiles() {
    return this.files;
  }
  
  public String getFirstEnv() {
    return this.envs.get(0);
  }
  
  public String getFirstFile() {
    return this.files.get(0);
  }
  
  public String getFirstLiteral() {
    return this.literals.get(0);
  }
  
  public String getLastEnv() {
    return this.envs.get(envs.size() - 1);
  }
  
  public String getLastFile() {
    return this.files.get(files.size() - 1);
  }
  
  public String getLastLiteral() {
    return this.literals.get(literals.size() - 1);
  }
  
  public String getLiteral(int index) {
    return this.literals.get(index);
  }
  
  public List<String> getLiterals() {
    return this.literals;
  }
  
  public String getMatchingEnv(Predicate<String> predicate) {
      for (String item : envs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingFile(Predicate<String> predicate) {
      for (String item : files) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingLiteral(Predicate<String> predicate) {
      for (String item : literals) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBehavior() {
    return this.behavior != null;
  }
  
  public boolean hasEnv() {
    return this.env != null;
  }
  
  public boolean hasEnvs() {
    return this.envs != null && !(this.envs.isEmpty());
  }
  
  public boolean hasFiles() {
    return this.files != null && !(this.files.isEmpty());
  }
  
  public boolean hasLiterals() {
    return this.literals != null && !(this.literals.isEmpty());
  }
  
  public boolean hasMatchingEnv(Predicate<String> predicate) {
      for (String item : envs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFile(Predicate<String> predicate) {
      for (String item : files) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingLiteral(Predicate<String> predicate) {
      for (String item : literals) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasOptions() {
    return this.options != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(behavior, env, envs, files, literals, name, namespace, options, type, additionalProperties);
  }
  
  public A removeAllFromEnvs(Collection<String> items) {
    if (this.envs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.envs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromFiles(Collection<String> items) {
    if (this.files == null) {
      return (A) this;
    }
    for (String item : items) {
      this.files.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromLiterals(Collection<String> items) {
    if (this.literals == null) {
      return (A) this;
    }
    for (String item : items) {
      this.literals.remove(item);
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
  
  public A removeFromEnvs(String... items) {
    if (this.envs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.envs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromFiles(String... items) {
    if (this.files == null) {
      return (A) this;
    }
    for (String item : items) {
      this.files.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromLiterals(String... items) {
    if (this.literals == null) {
      return (A) this;
    }
    for (String item : items) {
      this.literals.remove(item);
    }
    return (A) this;
  }
  
  public A setToEnvs(int index,String item) {
    if (this.envs == null) {
      this.envs = new ArrayList();
    }
    this.envs.set(index, item);
    return (A) this;
  }
  
  public A setToFiles(int index,String item) {
    if (this.files == null) {
      this.files = new ArrayList();
    }
    this.files.set(index, item);
    return (A) this;
  }
  
  public A setToLiterals(int index,String item) {
    if (this.literals == null) {
      this.literals = new ArrayList();
    }
    this.literals.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(behavior == null)) {
        sb.append("behavior:");
        sb.append(behavior);
        sb.append(",");
    }
    if (!(env == null)) {
        sb.append("env:");
        sb.append(env);
        sb.append(",");
    }
    if (!(envs == null) && !(envs.isEmpty())) {
        sb.append("envs:");
        sb.append(envs);
        sb.append(",");
    }
    if (!(files == null) && !(files.isEmpty())) {
        sb.append("files:");
        sb.append(files);
        sb.append(",");
    }
    if (!(literals == null) && !(literals.isEmpty())) {
        sb.append("literals:");
        sb.append(literals);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(options == null)) {
        sb.append("options:");
        sb.append(options);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withBehavior(String behavior) {
    this.behavior = behavior;
    return (A) this;
  }
  
  public A withEnv(String env) {
    this.env = env;
    return (A) this;
  }
  
  public A withEnvs(List<String> envs) {
    if (envs != null) {
        this.envs = new ArrayList();
        for (String item : envs) {
          this.addToEnvs(item);
        }
    } else {
      this.envs = null;
    }
    return (A) this;
  }
  
  public A withEnvs(String... envs) {
    if (this.envs != null) {
        this.envs.clear();
        _visitables.remove("envs");
    }
    if (envs != null) {
      for (String item : envs) {
        this.addToEnvs(item);
      }
    }
    return (A) this;
  }
  
  public A withFiles(List<String> files) {
    if (files != null) {
        this.files = new ArrayList();
        for (String item : files) {
          this.addToFiles(item);
        }
    } else {
      this.files = null;
    }
    return (A) this;
  }
  
  public A withFiles(String... files) {
    if (this.files != null) {
        this.files.clear();
        _visitables.remove("files");
    }
    if (files != null) {
      for (String item : files) {
        this.addToFiles(item);
      }
    }
    return (A) this;
  }
  
  public A withLiterals(List<String> literals) {
    if (literals != null) {
        this.literals = new ArrayList();
        for (String item : literals) {
          this.addToLiterals(item);
        }
    } else {
      this.literals = null;
    }
    return (A) this;
  }
  
  public A withLiterals(String... literals) {
    if (this.literals != null) {
        this.literals.clear();
        _visitables.remove("literals");
    }
    if (literals != null) {
      for (String item : literals) {
        this.addToLiterals(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public OptionsNested<A> withNewOptions() {
    return new OptionsNested(null);
  }
  
  public OptionsNested<A> withNewOptionsLike(GeneratorOptions item) {
    return new OptionsNested(item);
  }
  
  public A withOptions(GeneratorOptions options) {
    this._visitables.remove("options");
    if (options != null) {
        this.options = new GeneratorOptionsBuilder(options);
        this._visitables.get("options").add(this.options);
    } else {
        this.options = null;
        this._visitables.get("options").remove(this.options);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class OptionsNested<N> extends GeneratorOptionsFluent<OptionsNested<N>> implements Nested<N>{
  
    GeneratorOptionsBuilder builder;
  
    OptionsNested(GeneratorOptions item) {
      this.builder = new GeneratorOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) SecretArgsFluent.this.withOptions(builder.build());
    }
    
    public N endOptions() {
      return and();
    }
    
  }
}