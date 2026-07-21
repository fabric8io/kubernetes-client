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
public class PMJVMMySQLSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.PMJVMMySQLSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String database;
  private String exception;
  private Integer latency;
  private String mysqlConnectorVersion;
  private Integer pid;
  private Integer port;
  private String sqlType;
  private String table;

  public PMJVMMySQLSpecFluent() {
  }
  
  public PMJVMMySQLSpecFluent(PMJVMMySQLSpec instance) {
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
  
  protected void copyInstance(PMJVMMySQLSpec instance) {
    instance = instance != null ? instance : new PMJVMMySQLSpec();
    if (instance != null) {
        this.withDatabase(instance.getDatabase());
        this.withException(instance.getException());
        this.withLatency(instance.getLatency());
        this.withMysqlConnectorVersion(instance.getMysqlConnectorVersion());
        this.withPid(instance.getPid());
        this.withPort(instance.getPort());
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
    PMJVMMySQLSpecFluent that = (PMJVMMySQLSpecFluent) o;
    if (!(Objects.equals(database, that.database))) {
      return false;
    }
    if (!(Objects.equals(exception, that.exception))) {
      return false;
    }
    if (!(Objects.equals(latency, that.latency))) {
      return false;
    }
    if (!(Objects.equals(mysqlConnectorVersion, that.mysqlConnectorVersion))) {
      return false;
    }
    if (!(Objects.equals(pid, that.pid))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
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
  
  public String getDatabase() {
    return this.database;
  }
  
  public String getException() {
    return this.exception;
  }
  
  public Integer getLatency() {
    return this.latency;
  }
  
  public String getMysqlConnectorVersion() {
    return this.mysqlConnectorVersion;
  }
  
  public Integer getPid() {
    return this.pid;
  }
  
  public Integer getPort() {
    return this.port;
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
  
  public boolean hasDatabase() {
    return this.database != null;
  }
  
  public boolean hasException() {
    return this.exception != null;
  }
  
  public boolean hasLatency() {
    return this.latency != null;
  }
  
  public boolean hasMysqlConnectorVersion() {
    return this.mysqlConnectorVersion != null;
  }
  
  public boolean hasPid() {
    return this.pid != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public boolean hasSqlType() {
    return this.sqlType != null;
  }
  
  public boolean hasTable() {
    return this.table != null;
  }
  
  public int hashCode() {
    return Objects.hash(database, exception, latency, mysqlConnectorVersion, pid, port, sqlType, table, additionalProperties);
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
    if (!(mysqlConnectorVersion == null)) {
        sb.append("mysqlConnectorVersion:");
        sb.append(mysqlConnectorVersion);
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
  
  public A withMysqlConnectorVersion(String mysqlConnectorVersion) {
    this.mysqlConnectorVersion = mysqlConnectorVersion;
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
  
  public A withSqlType(String sqlType) {
    this.sqlType = sqlType;
    return (A) this;
  }
  
  public A withTable(String table) {
    this.table = table;
    return (A) this;
  }
  
}