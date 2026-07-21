package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class JVMChaosSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.JVMChaosSpecFluent<A>> extends BaseFluent<A>{

  private String action;
  private Map<String,Object> additionalProperties;
  private String className;
  private List<String> containerNames = new ArrayList<String>();
  private Integer cpuCount;
  private String database;
  private String duration;
  private String exception;
  private Integer latency;
  private String memType;
  private String method;
  private String mode;
  private String mysqlConnectorVersion;
  private String name;
  private Integer pid;
  private Integer port;
  private String remoteCluster;
  private String returnValue;
  private String ruleData;
  private PodSelectorSpecBuilder selector;
  private String sqlType;
  private String table;
  private String value;

  public JVMChaosSpecFluent() {
  }
  
  public JVMChaosSpecFluent(JVMChaosSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToContainerNames(Collection<String> items) {
    if (this.containerNames == null) {
      this.containerNames = new ArrayList();
    }
    for (String item : items) {
      this.containerNames.add(item);
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
  
  public A addToContainerNames(String... items) {
    if (this.containerNames == null) {
      this.containerNames = new ArrayList();
    }
    for (String item : items) {
      this.containerNames.add(item);
    }
    return (A) this;
  }
  
  public A addToContainerNames(int index,String item) {
    if (this.containerNames == null) {
      this.containerNames = new ArrayList();
    }
    this.containerNames.add(index, item);
    return (A) this;
  }
  
  public PodSelectorSpec buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  protected void copyInstance(JVMChaosSpec instance) {
    instance = instance != null ? instance : new JVMChaosSpec();
    if (instance != null) {
        this.withAction(instance.getAction());
        this.withClassName(instance.getClassName());
        this.withContainerNames(instance.getContainerNames());
        this.withCpuCount(instance.getCpuCount());
        this.withDatabase(instance.getDatabase());
        this.withDuration(instance.getDuration());
        this.withException(instance.getException());
        this.withLatency(instance.getLatency());
        this.withMemType(instance.getMemType());
        this.withMethod(instance.getMethod());
        this.withMode(instance.getMode());
        this.withMysqlConnectorVersion(instance.getMysqlConnectorVersion());
        this.withName(instance.getName());
        this.withPid(instance.getPid());
        this.withPort(instance.getPort());
        this.withRemoteCluster(instance.getRemoteCluster());
        this.withReturnValue(instance.getReturnValue());
        this.withRuleData(instance.getRuleData());
        this.withSelector(instance.getSelector());
        this.withSqlType(instance.getSqlType());
        this.withTable(instance.getTable());
        this.withValue(instance.getValue());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new PodSelectorSpecBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(PodSelectorSpec item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
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
    JVMChaosSpecFluent that = (JVMChaosSpecFluent) o;
    if (!(Objects.equals(action, that.action))) {
      return false;
    }
    if (!(Objects.equals(className, that.className))) {
      return false;
    }
    if (!(Objects.equals(containerNames, that.containerNames))) {
      return false;
    }
    if (!(Objects.equals(cpuCount, that.cpuCount))) {
      return false;
    }
    if (!(Objects.equals(database, that.database))) {
      return false;
    }
    if (!(Objects.equals(duration, that.duration))) {
      return false;
    }
    if (!(Objects.equals(exception, that.exception))) {
      return false;
    }
    if (!(Objects.equals(latency, that.latency))) {
      return false;
    }
    if (!(Objects.equals(memType, that.memType))) {
      return false;
    }
    if (!(Objects.equals(method, that.method))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
      return false;
    }
    if (!(Objects.equals(mysqlConnectorVersion, that.mysqlConnectorVersion))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(pid, that.pid))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
      return false;
    }
    if (!(Objects.equals(remoteCluster, that.remoteCluster))) {
      return false;
    }
    if (!(Objects.equals(returnValue, that.returnValue))) {
      return false;
    }
    if (!(Objects.equals(ruleData, that.ruleData))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(sqlType, that.sqlType))) {
      return false;
    }
    if (!(Objects.equals(table, that.table))) {
      return false;
    }
    if (!(Objects.equals(value, that.value))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getAction() {
    return this.action;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getClassName() {
    return this.className;
  }
  
  public String getContainerName(int index) {
    return this.containerNames.get(index);
  }
  
  public List<String> getContainerNames() {
    return this.containerNames;
  }
  
  public Integer getCpuCount() {
    return this.cpuCount;
  }
  
  public String getDatabase() {
    return this.database;
  }
  
  public String getDuration() {
    return this.duration;
  }
  
  public String getException() {
    return this.exception;
  }
  
  public String getFirstContainerName() {
    return this.containerNames.get(0);
  }
  
  public String getLastContainerName() {
    return this.containerNames.get(containerNames.size() - 1);
  }
  
  public Integer getLatency() {
    return this.latency;
  }
  
  public String getMatchingContainerName(Predicate<String> predicate) {
      for (String item : containerNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMemType() {
    return this.memType;
  }
  
  public String getMethod() {
    return this.method;
  }
  
  public String getMode() {
    return this.mode;
  }
  
  public String getMysqlConnectorVersion() {
    return this.mysqlConnectorVersion;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Integer getPid() {
    return this.pid;
  }
  
  public Integer getPort() {
    return this.port;
  }
  
  public String getRemoteCluster() {
    return this.remoteCluster;
  }
  
  public String getReturnValue() {
    return this.returnValue;
  }
  
  public String getRuleData() {
    return this.ruleData;
  }
  
  public String getSqlType() {
    return this.sqlType;
  }
  
  public String getTable() {
    return this.table;
  }
  
  public String getValue() {
    return this.value;
  }
  
  public boolean hasAction() {
    return this.action != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClassName() {
    return this.className != null;
  }
  
  public boolean hasContainerNames() {
    return this.containerNames != null && !(this.containerNames.isEmpty());
  }
  
  public boolean hasCpuCount() {
    return this.cpuCount != null;
  }
  
  public boolean hasDatabase() {
    return this.database != null;
  }
  
  public boolean hasDuration() {
    return this.duration != null;
  }
  
  public boolean hasException() {
    return this.exception != null;
  }
  
  public boolean hasLatency() {
    return this.latency != null;
  }
  
  public boolean hasMatchingContainerName(Predicate<String> predicate) {
      for (String item : containerNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMemType() {
    return this.memType != null;
  }
  
  public boolean hasMethod() {
    return this.method != null;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasMysqlConnectorVersion() {
    return this.mysqlConnectorVersion != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPid() {
    return this.pid != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public boolean hasRemoteCluster() {
    return this.remoteCluster != null;
  }
  
  public boolean hasReturnValue() {
    return this.returnValue != null;
  }
  
  public boolean hasRuleData() {
    return this.ruleData != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasSqlType() {
    return this.sqlType != null;
  }
  
  public boolean hasTable() {
    return this.table != null;
  }
  
  public boolean hasValue() {
    return this.value != null;
  }
  
  public int hashCode() {
    return Objects.hash(action, className, containerNames, cpuCount, database, duration, exception, latency, memType, method, mode, mysqlConnectorVersion, name, pid, port, remoteCluster, returnValue, ruleData, selector, sqlType, table, value, additionalProperties);
  }
  
  public A removeAllFromContainerNames(Collection<String> items) {
    if (this.containerNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.containerNames.remove(item);
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
  
  public A removeFromContainerNames(String... items) {
    if (this.containerNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.containerNames.remove(item);
    }
    return (A) this;
  }
  
  public A setToContainerNames(int index,String item) {
    if (this.containerNames == null) {
      this.containerNames = new ArrayList();
    }
    this.containerNames.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(action == null)) {
        sb.append("action:");
        sb.append(action);
        sb.append(",");
    }
    if (!(className == null)) {
        sb.append("className:");
        sb.append(className);
        sb.append(",");
    }
    if (!(containerNames == null) && !(containerNames.isEmpty())) {
        sb.append("containerNames:");
        sb.append(containerNames);
        sb.append(",");
    }
    if (!(cpuCount == null)) {
        sb.append("cpuCount:");
        sb.append(cpuCount);
        sb.append(",");
    }
    if (!(database == null)) {
        sb.append("database:");
        sb.append(database);
        sb.append(",");
    }
    if (!(duration == null)) {
        sb.append("duration:");
        sb.append(duration);
        sb.append(",");
    }
    if (!(exception == null)) {
        sb.append("exception:");
        sb.append(exception);
        sb.append(",");
    }
    if (!(latency == null)) {
        sb.append("latency:");
        sb.append(latency);
        sb.append(",");
    }
    if (!(memType == null)) {
        sb.append("memType:");
        sb.append(memType);
        sb.append(",");
    }
    if (!(method == null)) {
        sb.append("method:");
        sb.append(method);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
        sb.append(",");
    }
    if (!(mysqlConnectorVersion == null)) {
        sb.append("mysqlConnectorVersion:");
        sb.append(mysqlConnectorVersion);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(pid == null)) {
        sb.append("pid:");
        sb.append(pid);
        sb.append(",");
    }
    if (!(port == null)) {
        sb.append("port:");
        sb.append(port);
        sb.append(",");
    }
    if (!(remoteCluster == null)) {
        sb.append("remoteCluster:");
        sb.append(remoteCluster);
        sb.append(",");
    }
    if (!(returnValue == null)) {
        sb.append("returnValue:");
        sb.append(returnValue);
        sb.append(",");
    }
    if (!(ruleData == null)) {
        sb.append("ruleData:");
        sb.append(ruleData);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(sqlType == null)) {
        sb.append("sqlType:");
        sb.append(sqlType);
        sb.append(",");
    }
    if (!(table == null)) {
        sb.append("table:");
        sb.append(table);
        sb.append(",");
    }
    if (!(value == null)) {
        sb.append("value:");
        sb.append(value);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAction(String action) {
    this.action = action;
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withClassName(String className) {
    this.className = className;
    return (A) this;
  }
  
  public A withContainerNames(List<String> containerNames) {
    if (containerNames != null) {
        this.containerNames = new ArrayList();
        for (String item : containerNames) {
          this.addToContainerNames(item);
        }
    } else {
      this.containerNames = null;
    }
    return (A) this;
  }
  
  public A withContainerNames(String... containerNames) {
    if (this.containerNames != null) {
        this.containerNames.clear();
        _visitables.remove("containerNames");
    }
    if (containerNames != null) {
      for (String item : containerNames) {
        this.addToContainerNames(item);
      }
    }
    return (A) this;
  }
  
  public A withCpuCount(Integer cpuCount) {
    this.cpuCount = cpuCount;
    return (A) this;
  }
  
  public A withDatabase(String database) {
    this.database = database;
    return (A) this;
  }
  
  public A withDuration(String duration) {
    this.duration = duration;
    return (A) this;
  }
  
  public A withException(String exception) {
    this.exception = exception;
    return (A) this;
  }
  
  public A withLatency(Integer latency) {
    this.latency = latency;
    return (A) this;
  }
  
  public A withMemType(String memType) {
    this.memType = memType;
    return (A) this;
  }
  
  public A withMethod(String method) {
    this.method = method;
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public A withMysqlConnectorVersion(String mysqlConnectorVersion) {
    this.mysqlConnectorVersion = mysqlConnectorVersion;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(PodSelectorSpec item) {
    return new SelectorNested(item);
  }
  
  public A withPid(Integer pid) {
    this.pid = pid;
    return (A) this;
  }
  
  public A withPort(Integer port) {
    this.port = port;
    return (A) this;
  }
  
  public A withRemoteCluster(String remoteCluster) {
    this.remoteCluster = remoteCluster;
    return (A) this;
  }
  
  public A withReturnValue(String returnValue) {
    this.returnValue = returnValue;
    return (A) this;
  }
  
  public A withRuleData(String ruleData) {
    this.ruleData = ruleData;
    return (A) this;
  }
  
  public A withSelector(PodSelectorSpec selector) {
    this._visitables.remove("selector");
    if (selector != null) {
        this.selector = new PodSelectorSpecBuilder(selector);
        this._visitables.get("selector").add(this.selector);
    } else {
        this.selector = null;
        this._visitables.get("selector").remove(this.selector);
    }
    return (A) this;
  }
  
  public A withSqlType(String sqlType) {
    this.sqlType = sqlType;
    return (A) this;
  }
  
  public A withTable(String table) {
    this.table = table;
    return (A) this;
  }
  
  public A withValue(String value) {
    this.value = value;
    return (A) this;
  }
  public class SelectorNested<N> extends PodSelectorSpecFluent<SelectorNested<N>> implements Nested<N>{
  
    PodSelectorSpecBuilder builder;
  
    SelectorNested(PodSelectorSpec item) {
      this.builder = new PodSelectorSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) JVMChaosSpecFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
}