package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class JVMParameterFluent<A extends io.fabric8.chaosmesh.v1alpha1.JVMParameterFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String className;
  private Integer cpuCount;
  private String database;
  private String exception;
  private Integer latency;
  private String memType;
  private String method;
  private String mysqlConnectorVersion;
  private String name;
  private Integer pid;
  private Integer port;
  private String returnValue;
  private String ruleData;
  private String sqlType;
  private String table;

  public JVMParameterFluent() {
  }
  
  public JVMParameterFluent(JVMParameter instance) {
    this.copyInstance(instance);
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
  
  protected void copyInstance(JVMParameter instance) {
    instance = instance != null ? instance : new JVMParameter();
    if (instance != null) {
        this.withClassName(instance.getClassName());
        this.withCpuCount(instance.getCpuCount());
        this.withDatabase(instance.getDatabase());
        this.withException(instance.getException());
        this.withLatency(instance.getLatency());
        this.withMemType(instance.getMemType());
        this.withMethod(instance.getMethod());
        this.withMysqlConnectorVersion(instance.getMysqlConnectorVersion());
        this.withName(instance.getName());
        this.withPid(instance.getPid());
        this.withPort(instance.getPort());
        this.withReturnValue(instance.getReturnValue());
        this.withRuleData(instance.getRuleData());
        this.withSqlType(instance.getSqlType());
        this.withTable(instance.getTable());
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
    JVMParameterFluent that = (JVMParameterFluent) o;
    if (!(Objects.equals(className, that.className))) {
      return false;
    }
    if (!(Objects.equals(cpuCount, that.cpuCount))) {
      return false;
    }
    if (!(Objects.equals(database, that.database))) {
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
    if (!(Objects.equals(returnValue, that.returnValue))) {
      return false;
    }
    if (!(Objects.equals(ruleData, that.ruleData))) {
      return false;
    }
    if (!(Objects.equals(sqlType, that.sqlType))) {
      return false;
    }
    if (!(Objects.equals(table, that.table))) {
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
  
  public String getClassName() {
    return this.className;
  }
  
  public Integer getCpuCount() {
    return this.cpuCount;
  }
  
  public String getDatabase() {
    return this.database;
  }
  
  public String getException() {
    return this.exception;
  }
  
  public Integer getLatency() {
    return this.latency;
  }
  
  public String getMemType() {
    return this.memType;
  }
  
  public String getMethod() {
    return this.method;
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClassName() {
    return this.className != null;
  }
  
  public boolean hasCpuCount() {
    return this.cpuCount != null;
  }
  
  public boolean hasDatabase() {
    return this.database != null;
  }
  
  public boolean hasException() {
    return this.exception != null;
  }
  
  public boolean hasLatency() {
    return this.latency != null;
  }
  
  public boolean hasMemType() {
    return this.memType != null;
  }
  
  public boolean hasMethod() {
    return this.method != null;
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
  
  public boolean hasReturnValue() {
    return this.returnValue != null;
  }
  
  public boolean hasRuleData() {
    return this.ruleData != null;
  }
  
  public boolean hasSqlType() {
    return this.sqlType != null;
  }
  
  public boolean hasTable() {
    return this.table != null;
  }
  
  public int hashCode() {
    return Objects.hash(className, cpuCount, database, exception, latency, memType, method, mysqlConnectorVersion, name, pid, port, returnValue, ruleData, sqlType, table, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(className == null)) {
        sb.append("className:");
        sb.append(className);
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
  
  public A withClassName(String className) {
    this.className = className;
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
  
  public A withMysqlConnectorVersion(String mysqlConnectorVersion) {
    this.mysqlConnectorVersion = mysqlConnectorVersion;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withPid(Integer pid) {
    this.pid = pid;
    return (A) this;
  }
  
  public A withPort(Integer port) {
    this.port = port;
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
  
  public A withSqlType(String sqlType) {
    this.sqlType = sqlType;
    return (A) this;
  }
  
  public A withTable(String table) {
    this.table = table;
    return (A) this;
  }
  
}