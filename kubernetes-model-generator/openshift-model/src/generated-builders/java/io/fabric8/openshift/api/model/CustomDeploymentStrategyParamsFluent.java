package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.EnvVarBuilder;
import io.fabric8.kubernetes.api.model.EnvVarFluent;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class CustomDeploymentStrategyParamsFluent<A extends io.fabric8.openshift.api.model.CustomDeploymentStrategyParamsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> command = new ArrayList<String>();
  private ArrayList<EnvVarBuilder> environment = new ArrayList<EnvVarBuilder>();
  private String image;

  public CustomDeploymentStrategyParamsFluent() {
  }
  
  public CustomDeploymentStrategyParamsFluent(CustomDeploymentStrategyParams instance) {
    this.copyInstance(instance);
  }

  public A addAllToCommand(Collection<String> items) {
    if (this.command == null) {
      this.command = new ArrayList();
    }
    for (String item : items) {
      this.command.add(item);
    }
    return (A) this;
  }
  
  public A addAllToEnvironment(Collection<EnvVar> items) {
    if (this.environment == null) {
      this.environment = new ArrayList();
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("environment").add(builder);
        this.environment.add(builder);
    }
    return (A) this;
  }
  
  public EnvironmentNested<A> addNewEnvironment() {
    return new EnvironmentNested(-1, null);
  }
  
  public EnvironmentNested<A> addNewEnvironmentLike(EnvVar item) {
    return new EnvironmentNested(-1, item);
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
  
  public A addToCommand(String... items) {
    if (this.command == null) {
      this.command = new ArrayList();
    }
    for (String item : items) {
      this.command.add(item);
    }
    return (A) this;
  }
  
  public A addToCommand(int index,String item) {
    if (this.command == null) {
      this.command = new ArrayList();
    }
    this.command.add(index, item);
    return (A) this;
  }
  
  public A addToEnvironment(EnvVar... items) {
    if (this.environment == null) {
      this.environment = new ArrayList();
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("environment").add(builder);
        this.environment.add(builder);
    }
    return (A) this;
  }
  
  public A addToEnvironment(int index,EnvVar item) {
    if (this.environment == null) {
      this.environment = new ArrayList();
    }
    EnvVarBuilder builder = new EnvVarBuilder(item);
    if (index < 0 || index >= environment.size()) {
        _visitables.get("environment").add(builder);
        environment.add(builder);
    } else {
        _visitables.get("environment").add(builder);
        environment.add(index, builder);
    }
    return (A) this;
  }
  
  public List<EnvVar> buildEnvironment() {
    return this.environment != null ? build(environment) : null;
  }
  
  public EnvVar buildEnvironment(int index) {
    return this.environment.get(index).build();
  }
  
  public EnvVar buildFirstEnvironment() {
    return this.environment.get(0).build();
  }
  
  public EnvVar buildLastEnvironment() {
    return this.environment.get(environment.size() - 1).build();
  }
  
  public EnvVar buildMatchingEnvironment(Predicate<EnvVarBuilder> predicate) {
      for (EnvVarBuilder item : environment) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(CustomDeploymentStrategyParams instance) {
    instance = instance != null ? instance : new CustomDeploymentStrategyParams();
    if (instance != null) {
        this.withCommand(instance.getCommand());
        this.withEnvironment(instance.getEnvironment());
        this.withImage(instance.getImage());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EnvironmentNested<A> editEnvironment(int index) {
    if (environment.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "environment"));
    }
    return this.setNewEnvironmentLike(index, this.buildEnvironment(index));
  }
  
  public EnvironmentNested<A> editFirstEnvironment() {
    if (environment.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "environment"));
    }
    return this.setNewEnvironmentLike(0, this.buildEnvironment(0));
  }
  
  public EnvironmentNested<A> editLastEnvironment() {
    int index = environment.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "environment"));
    }
    return this.setNewEnvironmentLike(index, this.buildEnvironment(index));
  }
  
  public EnvironmentNested<A> editMatchingEnvironment(Predicate<EnvVarBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < environment.size();i++) {
      if (predicate.test(environment.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "environment"));
    }
    return this.setNewEnvironmentLike(index, this.buildEnvironment(index));
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
    CustomDeploymentStrategyParamsFluent that = (CustomDeploymentStrategyParamsFluent) o;
    if (!(Objects.equals(command, that.command))) {
      return false;
    }
    if (!(Objects.equals(environment, that.environment))) {
      return false;
    }
    if (!(Objects.equals(image, that.image))) {
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
  
  public List<String> getCommand() {
    return this.command;
  }
  
  public String getCommand(int index) {
    return this.command.get(index);
  }
  
  public String getFirstCommand() {
    return this.command.get(0);
  }
  
  public String getImage() {
    return this.image;
  }
  
  public String getLastCommand() {
    return this.command.get(command.size() - 1);
  }
  
  public String getMatchingCommand(Predicate<String> predicate) {
      for (String item : command) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCommand() {
    return this.command != null && !(this.command.isEmpty());
  }
  
  public boolean hasEnvironment() {
    return this.environment != null && !(this.environment.isEmpty());
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasMatchingCommand(Predicate<String> predicate) {
      for (String item : command) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingEnvironment(Predicate<EnvVarBuilder> predicate) {
      for (EnvVarBuilder item : environment) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(command, environment, image, additionalProperties);
  }
  
  public A removeAllFromCommand(Collection<String> items) {
    if (this.command == null) {
      return (A) this;
    }
    for (String item : items) {
      this.command.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromEnvironment(Collection<EnvVar> items) {
    if (this.environment == null) {
      return (A) this;
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("environment").remove(builder);
        this.environment.remove(builder);
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
  
  public A removeFromCommand(String... items) {
    if (this.command == null) {
      return (A) this;
    }
    for (String item : items) {
      this.command.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromEnvironment(EnvVar... items) {
    if (this.environment == null) {
      return (A) this;
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("environment").remove(builder);
        this.environment.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromEnvironment(Predicate<EnvVarBuilder> predicate) {
    if (environment == null) {
      return (A) this;
    }
    Iterator<EnvVarBuilder> each = environment.iterator();
    List visitables = _visitables.get("environment");
    while (each.hasNext()) {
        EnvVarBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public EnvironmentNested<A> setNewEnvironmentLike(int index,EnvVar item) {
    return new EnvironmentNested(index, item);
  }
  
  public A setToCommand(int index,String item) {
    if (this.command == null) {
      this.command = new ArrayList();
    }
    this.command.set(index, item);
    return (A) this;
  }
  
  public A setToEnvironment(int index,EnvVar item) {
    if (this.environment == null) {
      this.environment = new ArrayList();
    }
    EnvVarBuilder builder = new EnvVarBuilder(item);
    if (index < 0 || index >= environment.size()) {
        _visitables.get("environment").add(builder);
        environment.add(builder);
    } else {
        _visitables.get("environment").add(builder);
        environment.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(command == null) && !(command.isEmpty())) {
        sb.append("command:");
        sb.append(command);
        sb.append(",");
    }
    if (!(environment == null) && !(environment.isEmpty())) {
        sb.append("environment:");
        sb.append(environment);
        sb.append(",");
    }
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
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
  
  public A withCommand(List<String> command) {
    if (command != null) {
        this.command = new ArrayList();
        for (String item : command) {
          this.addToCommand(item);
        }
    } else {
      this.command = null;
    }
    return (A) this;
  }
  
  public A withCommand(String... command) {
    if (this.command != null) {
        this.command.clear();
        _visitables.remove("command");
    }
    if (command != null) {
      for (String item : command) {
        this.addToCommand(item);
      }
    }
    return (A) this;
  }
  
  public A withEnvironment(List<EnvVar> environment) {
    if (this.environment != null) {
      this._visitables.get("environment").clear();
    }
    if (environment != null) {
        this.environment = new ArrayList();
        for (EnvVar item : environment) {
          this.addToEnvironment(item);
        }
    } else {
      this.environment = null;
    }
    return (A) this;
  }
  
  public A withEnvironment(EnvVar... environment) {
    if (this.environment != null) {
        this.environment.clear();
        _visitables.remove("environment");
    }
    if (environment != null) {
      for (EnvVar item : environment) {
        this.addToEnvironment(item);
      }
    }
    return (A) this;
  }
  
  public A withImage(String image) {
    this.image = image;
    return (A) this;
  }
  public class EnvironmentNested<N> extends EnvVarFluent<EnvironmentNested<N>> implements Nested<N>{
  
    EnvVarBuilder builder;
    int index;
  
    EnvironmentNested(int index,EnvVar item) {
      this.index = index;
      this.builder = new EnvVarBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomDeploymentStrategyParamsFluent.this.setToEnvironment(index, builder.build());
    }
    
    public N endEnvironment() {
      return and();
    }
    
  }
}