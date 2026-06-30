package io.fabric8.kubernetes.api.model;

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
public class PodExecOptionsFluent<A extends io.fabric8.kubernetes.api.model.PodExecOptionsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private List<String> command = new ArrayList<String>();
  private String container;
  private String kind;
  private Boolean stderr;
  private Boolean stdin;
  private Boolean stdout;
  private Boolean tty;

  public PodExecOptionsFluent() {
  }
  
  public PodExecOptionsFluent(PodExecOptions instance) {
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
  
  protected void copyInstance(PodExecOptions instance) {
    instance = instance != null ? instance : new PodExecOptions();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withCommand(instance.getCommand());
        this.withContainer(instance.getContainer());
        this.withKind(instance.getKind());
        this.withStderr(instance.getStderr());
        this.withStdin(instance.getStdin());
        this.withStdout(instance.getStdout());
        this.withTty(instance.getTty());
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
    PodExecOptionsFluent that = (PodExecOptionsFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(command, that.command))) {
      return false;
    }
    if (!(Objects.equals(container, that.container))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(stderr, that.stderr))) {
      return false;
    }
    if (!(Objects.equals(stdin, that.stdin))) {
      return false;
    }
    if (!(Objects.equals(stdout, that.stdout))) {
      return false;
    }
    if (!(Objects.equals(tty, that.tty))) {
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
  
  public List<String> getCommand() {
    return this.command;
  }
  
  public String getCommand(int index) {
    return this.command.get(index);
  }
  
  public String getContainer() {
    return this.container;
  }
  
  public String getFirstCommand() {
    return this.command.get(0);
  }
  
  public String getKind() {
    return this.kind;
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
  
  public Boolean getStderr() {
    return this.stderr;
  }
  
  public Boolean getStdin() {
    return this.stdin;
  }
  
  public Boolean getStdout() {
    return this.stdout;
  }
  
  public Boolean getTty() {
    return this.tty;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasCommand() {
    return this.command != null && !(this.command.isEmpty());
  }
  
  public boolean hasContainer() {
    return this.container != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingCommand(Predicate<String> predicate) {
      for (String item : command) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasStderr() {
    return this.stderr != null;
  }
  
  public boolean hasStdin() {
    return this.stdin != null;
  }
  
  public boolean hasStdout() {
    return this.stdout != null;
  }
  
  public boolean hasTty() {
    return this.tty != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, command, container, kind, stderr, stdin, stdout, tty, additionalProperties);
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
  
  public A setToCommand(int index,String item) {
    if (this.command == null) {
      this.command = new ArrayList();
    }
    this.command.set(index, item);
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
    if (!(command == null) && !(command.isEmpty())) {
        sb.append("command:");
        sb.append(command);
        sb.append(",");
    }
    if (!(container == null)) {
        sb.append("container:");
        sb.append(container);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(stderr == null)) {
        sb.append("stderr:");
        sb.append(stderr);
        sb.append(",");
    }
    if (!(stdin == null)) {
        sb.append("stdin:");
        sb.append(stdin);
        sb.append(",");
    }
    if (!(stdout == null)) {
        sb.append("stdout:");
        sb.append(stdout);
        sb.append(",");
    }
    if (!(tty == null)) {
        sb.append("tty:");
        sb.append(tty);
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
  
  public A withContainer(String container) {
    this.container = container;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withStderr() {
    return withStderr(true);
  }
  
  public A withStderr(Boolean stderr) {
    this.stderr = stderr;
    return (A) this;
  }
  
  public A withStdin() {
    return withStdin(true);
  }
  
  public A withStdin(Boolean stdin) {
    this.stdin = stdin;
    return (A) this;
  }
  
  public A withStdout() {
    return withStdout(true);
  }
  
  public A withStdout(Boolean stdout) {
    this.stdout = stdout;
    return (A) this;
  }
  
  public A withTty() {
    return withTty(true);
  }
  
  public A withTty(Boolean tty) {
    this.tty = tty;
    return (A) this;
  }
  
}