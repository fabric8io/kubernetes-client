package io.fabric8.kubernetes.client.extended.run;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.Quantity;
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
public class RunConfigFluent<A extends io.fabric8.kubernetes.client.extended.run.RunConfigFluent<A>> extends BaseFluent<A>{

  private List<String> args;
  private String command;
  private Map<String,String> env;
  private String image;
  private String imagePullPolicy;
  private Map<String,String> labels;
  private Map<String,Quantity> limits;
  private String name;
  private int port;
  private Map<String,Quantity> requests;
  private String restartPolicy;
  private String serviceAccount;

  public RunConfigFluent() {
  }
  
  public RunConfigFluent(RunConfig instance) {
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
  
  public A addToEnv(Map<String,String> map) {
    if (this.env == null && map != null) {
      this.env = new LinkedHashMap();
    }
    if (map != null) {
      this.env.putAll(map);
    }
    return (A) this;
  }
  
  public A addToEnv(String key,String value) {
    if (this.env == null && key != null && value != null) {
      this.env = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.env.put(key, value);
    }
    return (A) this;
  }
  
  public A addToLabels(Map<String,String> map) {
    if (this.labels == null && map != null) {
      this.labels = new LinkedHashMap();
    }
    if (map != null) {
      this.labels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToLabels(String key,String value) {
    if (this.labels == null && key != null && value != null) {
      this.labels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.labels.put(key, value);
    }
    return (A) this;
  }
  
  public A addToLimits(Map<String,Quantity> map) {
    if (this.limits == null && map != null) {
      this.limits = new LinkedHashMap();
    }
    if (map != null) {
      this.limits.putAll(map);
    }
    return (A) this;
  }
  
  public A addToLimits(String key,Quantity value) {
    if (this.limits == null && key != null && value != null) {
      this.limits = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.limits.put(key, value);
    }
    return (A) this;
  }
  
  public A addToRequests(Map<String,Quantity> map) {
    if (this.requests == null && map != null) {
      this.requests = new LinkedHashMap();
    }
    if (map != null) {
      this.requests.putAll(map);
    }
    return (A) this;
  }
  
  public A addToRequests(String key,Quantity value) {
    if (this.requests == null && key != null && value != null) {
      this.requests = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.requests.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(RunConfig instance) {
    if (instance != null) {
        this.withName(instance.getName());
        this.withImage(instance.getImage());
        this.withImagePullPolicy(instance.getImagePullPolicy());
        this.withCommand(instance.getCommand());
        this.withArgs(instance.getArgs());
        this.withRestartPolicy(instance.getRestartPolicy());
        this.withServiceAccount(instance.getServiceAccount());
        this.withLabels(instance.getLabels());
        this.withEnv(instance.getEnv());
        this.withLimits(instance.getLimits());
        this.withRequests(instance.getRequests());
        this.withPort(instance.getPort());
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
    RunConfigFluent that = (RunConfigFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(image, that.image))) {
      return false;
    }
    if (!(Objects.equals(imagePullPolicy, that.imagePullPolicy))) {
      return false;
    }
    if (!(Objects.equals(command, that.command))) {
      return false;
    }
    if (!(Objects.equals(args, that.args))) {
      return false;
    }
    if (!(Objects.equals(restartPolicy, that.restartPolicy))) {
      return false;
    }
    if (!(Objects.equals(serviceAccount, that.serviceAccount))) {
      return false;
    }
    if (!(Objects.equals(labels, that.labels))) {
      return false;
    }
    if (!(Objects.equals(env, that.env))) {
      return false;
    }
    if (!(Objects.equals(limits, that.limits))) {
      return false;
    }
    if (!(Objects.equals(requests, that.requests))) {
      return false;
    }
    if (port != that.port) {
      return false;
    }
    return true;
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
  
  public Map<String,String> getEnv() {
    return this.env;
  }
  
  public String getFirstArg() {
    return this.args.get(0);
  }
  
  public String getImage() {
    return this.image;
  }
  
  public String getImagePullPolicy() {
    return this.imagePullPolicy;
  }
  
  public Map<String,String> getLabels() {
    return this.labels;
  }
  
  public String getLastArg() {
    return this.args.get(args.size() - 1);
  }
  
  public Map<String,Quantity> getLimits() {
    return this.limits;
  }
  
  public String getMatchingArg(Predicate<String> predicate) {
      for (String item : args) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public int getPort() {
    return this.port;
  }
  
  public Map<String,Quantity> getRequests() {
    return this.requests;
  }
  
  public String getRestartPolicy() {
    return this.restartPolicy;
  }
  
  public String getServiceAccount() {
    return this.serviceAccount;
  }
  
  public boolean hasArgs() {
    return this.args != null && !(this.args.isEmpty());
  }
  
  public boolean hasCommand() {
    return this.command != null;
  }
  
  public boolean hasEnv() {
    return this.env != null;
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasImagePullPolicy() {
    return this.imagePullPolicy != null;
  }
  
  public boolean hasLabels() {
    return this.labels != null;
  }
  
  public boolean hasLimits() {
    return this.limits != null;
  }
  
  public boolean hasMatchingArg(Predicate<String> predicate) {
      for (String item : args) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPort() {
    return true;
  }
  
  public boolean hasRequests() {
    return this.requests != null;
  }
  
  public boolean hasRestartPolicy() {
    return this.restartPolicy != null;
  }
  
  public boolean hasServiceAccount() {
    return this.serviceAccount != null;
  }
  
  public int hashCode() {
    return Objects.hash(name, image, imagePullPolicy, command, args, restartPolicy, serviceAccount, labels, env, limits, requests, port);
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
  
  public A removeFromArgs(String... items) {
    if (this.args == null) {
      return (A) this;
    }
    for (String item : items) {
      this.args.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromEnv(String key) {
    if (this.env == null) {
      return (A) this;
    }
    if (key != null && this.env != null) {
      this.env.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromEnv(Map<String,String> map) {
    if (this.env == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.env != null) {
          this.env.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromLabels(String key) {
    if (this.labels == null) {
      return (A) this;
    }
    if (key != null && this.labels != null) {
      this.labels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromLabels(Map<String,String> map) {
    if (this.labels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.labels != null) {
          this.labels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromLimits(String key) {
    if (this.limits == null) {
      return (A) this;
    }
    if (key != null && this.limits != null) {
      this.limits.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromLimits(Map<String,Quantity> map) {
    if (this.limits == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.limits != null) {
          this.limits.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromRequests(String key) {
    if (this.requests == null) {
      return (A) this;
    }
    if (key != null && this.requests != null) {
      this.requests.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromRequests(Map<String,Quantity> map) {
    if (this.requests == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.requests != null) {
          this.requests.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A setToArgs(int index,String item) {
    if (this.args == null) {
      this.args = new ArrayList();
    }
    this.args.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
        sb.append(",");
    }
    if (!(imagePullPolicy == null)) {
        sb.append("imagePullPolicy:");
        sb.append(imagePullPolicy);
        sb.append(",");
    }
    if (!(command == null)) {
        sb.append("command:");
        sb.append(command);
        sb.append(",");
    }
    if (!(args == null) && !(args.isEmpty())) {
        sb.append("args:");
        sb.append(args);
        sb.append(",");
    }
    if (!(restartPolicy == null)) {
        sb.append("restartPolicy:");
        sb.append(restartPolicy);
        sb.append(",");
    }
    if (!(serviceAccount == null)) {
        sb.append("serviceAccount:");
        sb.append(serviceAccount);
        sb.append(",");
    }
    if (!(labels == null) && !(labels.isEmpty())) {
        sb.append("labels:");
        sb.append(labels);
        sb.append(",");
    }
    if (!(env == null) && !(env.isEmpty())) {
        sb.append("env:");
        sb.append(env);
        sb.append(",");
    }
    if (!(limits == null) && !(limits.isEmpty())) {
        sb.append("limits:");
        sb.append(limits);
        sb.append(",");
    }
    if (!(requests == null) && !(requests.isEmpty())) {
        sb.append("requests:");
        sb.append(requests);
        sb.append(",");
    }
    sb.append("port:");
    sb.append(port);
    sb.append("}");
    return sb.toString();
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
  
  public <K,V>A withEnv(Map<String,String> env) {
    if (env == null) {
      this.env = null;
    } else {
      this.env = new LinkedHashMap(env);
    }
    return (A) this;
  }
  
  public A withImage(String image) {
    this.image = image;
    return (A) this;
  }
  
  public A withImagePullPolicy(String imagePullPolicy) {
    this.imagePullPolicy = imagePullPolicy;
    return (A) this;
  }
  
  public <K,V>A withLabels(Map<String,String> labels) {
    if (labels == null) {
      this.labels = null;
    } else {
      this.labels = new LinkedHashMap(labels);
    }
    return (A) this;
  }
  
  public <K,V>A withLimits(Map<String,Quantity> limits) {
    if (limits == null) {
      this.limits = null;
    } else {
      this.limits = new LinkedHashMap(limits);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withPort(int port) {
    this.port = port;
    return (A) this;
  }
  
  public <K,V>A withRequests(Map<String,Quantity> requests) {
    if (requests == null) {
      this.requests = null;
    } else {
      this.requests = new LinkedHashMap(requests);
    }
    return (A) this;
  }
  
  public A withRestartPolicy(String restartPolicy) {
    this.restartPolicy = restartPolicy;
    return (A) this;
  }
  
  public A withServiceAccount(String serviceAccount) {
    this.serviceAccount = serviceAccount;
    return (A) this;
  }
  
}