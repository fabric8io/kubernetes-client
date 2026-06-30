package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class ExecConfigFluent<A extends io.fabric8.kubernetes.api.model.ExecConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private List<String> args = new ArrayList<String>();
  private String command;
  private ArrayList<ExecEnvVarBuilder> env = new ArrayList<ExecEnvVarBuilder>();
  private String installHint;
  private String interactiveMode;
  private Boolean provideClusterInfo;

  public ExecConfigFluent() {
  }
  
  public ExecConfigFluent(ExecConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToArgs(Collection<String> items) {
    if (this.args == null) {
      this.args = new ArrayList();
    }
    for (String item : items) {
      this.args.add(item);
    }
    return (A) this;
  }
  
  public A addAllToEnv(Collection<ExecEnvVar> items) {
    if (this.env == null) {
      this.env = new ArrayList();
    }
    for (ExecEnvVar item : items) {
        ExecEnvVarBuilder builder = new ExecEnvVarBuilder(item);
        _visitables.get("env").add(builder);
        this.env.add(builder);
    }
    return (A) this;
  }
  
  public EnvNested<A> addNewEnv() {
    return new EnvNested(-1, null);
  }
  
  public A addNewEnv(String name,String value) {
    return (A) this.addToEnv(new ExecEnvVar(name, value));
  }
  
  public EnvNested<A> addNewEnvLike(ExecEnvVar item) {
    return new EnvNested(-1, item);
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
  
  public A addToArgs(String... items) {
    if (this.args == null) {
      this.args = new ArrayList();
    }
    for (String item : items) {
      this.args.add(item);
    }
    return (A) this;
  }
  
  public A addToArgs(int index,String item) {
    if (this.args == null) {
      this.args = new ArrayList();
    }
    this.args.add(index, item);
    return (A) this;
  }
  
  public A addToEnv(ExecEnvVar... items) {
    if (this.env == null) {
      this.env = new ArrayList();
    }
    for (ExecEnvVar item : items) {
        ExecEnvVarBuilder builder = new ExecEnvVarBuilder(item);
        _visitables.get("env").add(builder);
        this.env.add(builder);
    }
    return (A) this;
  }
  
  public A addToEnv(int index,ExecEnvVar item) {
    if (this.env == null) {
      this.env = new ArrayList();
    }
    ExecEnvVarBuilder builder = new ExecEnvVarBuilder(item);
    if (index < 0 || index >= env.size()) {
        _visitables.get("env").add(builder);
        env.add(builder);
    } else {
        _visitables.get("env").add(builder);
        env.add(index, builder);
    }
    return (A) this;
  }
  
  public List<ExecEnvVar> buildEnv() {
    return this.env != null ? build(env) : null;
  }
  
  public ExecEnvVar buildEnv(int index) {
    return this.env.get(index).build();
  }
  
  public ExecEnvVar buildFirstEnv() {
    return this.env.get(0).build();
  }
  
  public ExecEnvVar buildLastEnv() {
    return this.env.get(env.size() - 1).build();
  }
  
  public ExecEnvVar buildMatchingEnv(Predicate<ExecEnvVarBuilder> predicate) {
      for (ExecEnvVarBuilder item : env) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ExecConfig instance) {
    instance = instance != null ? instance : new ExecConfig();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withArgs(instance.getArgs());
        this.withCommand(instance.getCommand());
        this.withEnv(instance.getEnv());
        this.withInstallHint(instance.getInstallHint());
        this.withInteractiveMode(instance.getInteractiveMode());
        this.withProvideClusterInfo(instance.getProvideClusterInfo());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EnvNested<A> editEnv(int index) {
    if (env.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "env"));
    }
    return this.setNewEnvLike(index, this.buildEnv(index));
  }
  
  public EnvNested<A> editFirstEnv() {
    if (env.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "env"));
    }
    return this.setNewEnvLike(0, this.buildEnv(0));
  }
  
  public EnvNested<A> editLastEnv() {
    int index = env.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "env"));
    }
    return this.setNewEnvLike(index, this.buildEnv(index));
  }
  
  public EnvNested<A> editMatchingEnv(Predicate<ExecEnvVarBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < env.size();i++) {
      if (predicate.test(env.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "env"));
    }
    return this.setNewEnvLike(index, this.buildEnv(index));
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
    ExecConfigFluent that = (ExecConfigFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(args, that.args))) {
      return false;
    }
    if (!(Objects.equals(command, that.command))) {
      return false;
    }
    if (!(Objects.equals(env, that.env))) {
      return false;
    }
    if (!(Objects.equals(installHint, that.installHint))) {
      return false;
    }
    if (!(Objects.equals(interactiveMode, that.interactiveMode))) {
      return false;
    }
    if (!(Objects.equals(provideClusterInfo, that.provideClusterInfo))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getArg(int index) {
    return this.args.get(index);
  }
  
  public List<String> getArgs() {
    return this.args;
  }
  
  public String getCommand() {
    return this.command;
  }
  
  public String getFirstArg() {
    return this.args.get(0);
  }
  
  public String getInstallHint() {
    return this.installHint;
  }
  
  public String getInteractiveMode() {
    return this.interactiveMode;
  }
  
  public String getLastArg() {
    return this.args.get(args.size() - 1);
  }
  
  public String getMatchingArg(Predicate<String> predicate) {
      for (String item : args) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Boolean getProvideClusterInfo() {
    return this.provideClusterInfo;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasArgs() {
    return this.args != null && !(this.args.isEmpty());
  }
  
  public boolean hasCommand() {
    return this.command != null;
  }
  
  public boolean hasEnv() {
    return this.env != null && !(this.env.isEmpty());
  }
  
  public boolean hasInstallHint() {
    return this.installHint != null;
  }
  
  public boolean hasInteractiveMode() {
    return this.interactiveMode != null;
  }
  
  public boolean hasMatchingArg(Predicate<String> predicate) {
      for (String item : args) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingEnv(Predicate<ExecEnvVarBuilder> predicate) {
      for (ExecEnvVarBuilder item : env) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasProvideClusterInfo() {
    return this.provideClusterInfo != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, args, command, env, installHint, interactiveMode, provideClusterInfo, additionalProperties);
  }
  
  public A removeAllFromArgs(Collection<String> items) {
    if (this.args == null) {
      return (A) this;
    }
    for (String item : items) {
      this.args.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromEnv(Collection<ExecEnvVar> items) {
    if (this.env == null) {
      return (A) this;
    }
    for (ExecEnvVar item : items) {
        ExecEnvVarBuilder builder = new ExecEnvVarBuilder(item);
        _visitables.get("env").remove(builder);
        this.env.remove(builder);
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
  
  public A removeFromArgs(String... items) {
    if (this.args == null) {
      return (A) this;
    }
    for (String item : items) {
      this.args.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromEnv(ExecEnvVar... items) {
    if (this.env == null) {
      return (A) this;
    }
    for (ExecEnvVar item : items) {
        ExecEnvVarBuilder builder = new ExecEnvVarBuilder(item);
        _visitables.get("env").remove(builder);
        this.env.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromEnv(Predicate<ExecEnvVarBuilder> predicate) {
    if (env == null) {
      return (A) this;
    }
    Iterator<ExecEnvVarBuilder> each = env.iterator();
    List visitables = _visitables.get("env");
    while (each.hasNext()) {
        ExecEnvVarBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public EnvNested<A> setNewEnvLike(int index,ExecEnvVar item) {
    return new EnvNested(index, item);
  }
  
  public A setToArgs(int index,String item) {
    if (this.args == null) {
      this.args = new ArrayList();
    }
    this.args.set(index, item);
    return (A) this;
  }
  
  public A setToEnv(int index,ExecEnvVar item) {
    if (this.env == null) {
      this.env = new ArrayList();
    }
    ExecEnvVarBuilder builder = new ExecEnvVarBuilder(item);
    if (index < 0 || index >= env.size()) {
        _visitables.get("env").add(builder);
        env.add(builder);
    } else {
        _visitables.get("env").add(builder);
        env.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(args == null) && !(args.isEmpty())) {
        sb.append("args:");
        sb.append(args);
        sb.append(",");
    }
    if (!(command == null)) {
        sb.append("command:");
        sb.append(command);
        sb.append(",");
    }
    if (!(env == null) && !(env.isEmpty())) {
        sb.append("env:");
        sb.append(env);
        sb.append(",");
    }
    if (!(installHint == null)) {
        sb.append("installHint:");
        sb.append(installHint);
        sb.append(",");
    }
    if (!(interactiveMode == null)) {
        sb.append("interactiveMode:");
        sb.append(interactiveMode);
        sb.append(",");
    }
    if (!(provideClusterInfo == null)) {
        sb.append("provideClusterInfo:");
        sb.append(provideClusterInfo);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withArgs(List<String> args) {
    if (args != null) {
        this.args = new ArrayList();
        for (String item : args) {
          this.addToArgs(item);
        }
    } else {
      this.args = null;
    }
    return (A) this;
  }
  
  public A withArgs(String... args) {
    if (this.args != null) {
        this.args.clear();
        _visitables.remove("args");
    }
    if (args != null) {
      for (String item : args) {
        this.addToArgs(item);
      }
    }
    return (A) this;
  }
  
  public A withCommand(String command) {
    this.command = command;
    return (A) this;
  }
  
  public A withEnv(List<ExecEnvVar> env) {
    if (this.env != null) {
      this._visitables.get("env").clear();
    }
    if (env != null) {
        this.env = new ArrayList();
        for (ExecEnvVar item : env) {
          this.addToEnv(item);
        }
    } else {
      this.env = null;
    }
    return (A) this;
  }
  
  public A withEnv(ExecEnvVar... env) {
    if (this.env != null) {
        this.env.clear();
        _visitables.remove("env");
    }
    if (env != null) {
      for (ExecEnvVar item : env) {
        this.addToEnv(item);
      }
    }
    return (A) this;
  }
  
  public A withInstallHint(String installHint) {
    this.installHint = installHint;
    return (A) this;
  }
  
  public A withInteractiveMode(String interactiveMode) {
    this.interactiveMode = interactiveMode;
    return (A) this;
  }
  
  public A withProvideClusterInfo() {
    return withProvideClusterInfo(true);
  }
  
  public A withProvideClusterInfo(Boolean provideClusterInfo) {
    this.provideClusterInfo = provideClusterInfo;
    return (A) this;
  }
  public class EnvNested<N> extends ExecEnvVarFluent<EnvNested<N>> implements Nested<N>{
  
    ExecEnvVarBuilder builder;
    int index;
  
    EnvNested(int index,ExecEnvVar item) {
      this.index = index;
      this.builder = new ExecEnvVarBuilder(this, item);
    }
  
    public N and() {
      return (N) ExecConfigFluent.this.setToEnv(index, builder.build());
    }
    
    public N endEnv() {
      return and();
    }
    
  }
}