
package io.fabric8.chaosmesh.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * JVMParameter represents the detail about jvm chaos action definition
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "class",
    "cpuCount",
    "database",
    "exception",
    "latency",
    "memType",
    "method",
    "mysqlConnectorVersion",
    "name",
    "pid",
    "port",
    "returnValue",
    "ruleData",
    "sqlType",
    "table"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class JVMParameter implements Editable<JVMParameterBuilder>, KubernetesResource
{

    @JsonProperty("class")
    private String className;
    @JsonProperty("cpuCount")
    private Integer cpuCount;
    @JsonProperty("database")
    private String database;
    @JsonProperty("exception")
    private String exception;
    @JsonProperty("latency")
    private Integer latency;
    @JsonProperty("memType")
    private String memType;
    @JsonProperty("method")
    private String method;
    @JsonProperty("mysqlConnectorVersion")
    private String mysqlConnectorVersion;
    @JsonProperty("name")
    private String name;
    @JsonProperty("pid")
    private Integer pid;
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("returnValue")
    private String returnValue;
    @JsonProperty("ruleData")
    private String ruleData;
    @JsonProperty("sqlType")
    private String sqlType;
    @JsonProperty("table")
    private String table;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public JVMParameter() {
    }

    public JVMParameter(String className, Integer cpuCount, String database, String exception, Integer latency, String memType, String method, String mysqlConnectorVersion, String name, Integer pid, Integer port, String returnValue, String ruleData, String sqlType, String table) {
        super();
        this.className = className;
        this.cpuCount = cpuCount;
        this.database = database;
        this.exception = exception;
        this.latency = latency;
        this.memType = memType;
        this.method = method;
        this.mysqlConnectorVersion = mysqlConnectorVersion;
        this.name = name;
        this.pid = pid;
        this.port = port;
        this.returnValue = returnValue;
        this.ruleData = ruleData;
        this.sqlType = sqlType;
        this.table = table;
    }

    /**
     * Java class
     */
    @JsonProperty("class")
    public String getClassName() {
        return className;
    }

    /**
     * Java class
     */
    @JsonProperty("class")
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * the CPU core number needs to use, only set it when action is stress
     */
    @JsonProperty("cpuCount")
    public Integer getCpuCount() {
        return cpuCount;
    }

    /**
     * the CPU core number needs to use, only set it when action is stress
     */
    @JsonProperty("cpuCount")
    public void setCpuCount(Integer cpuCount) {
        this.cpuCount = cpuCount;
    }

    /**
     * the match database default value is "", means match all database
     */
    @JsonProperty("database")
    public String getDatabase() {
        return database;
    }

    /**
     * the match database default value is "", means match all database
     */
    @JsonProperty("database")
    public void setDatabase(String database) {
        this.database = database;
    }

    /**
     * the exception which needs to throw for action `exception` or the exception message needs to throw in action `mysql`
     */
    @JsonProperty("exception")
    public String getException() {
        return exception;
    }

    /**
     * the exception which needs to throw for action `exception` or the exception message needs to throw in action `mysql`
     */
    @JsonProperty("exception")
    public void setException(String exception) {
        this.exception = exception;
    }

    /**
     * the latency duration for action 'latency', unit ms or the latency duration in action `mysql`
     */
    @JsonProperty("latency")
    public Integer getLatency() {
        return latency;
    }

    /**
     * the latency duration for action 'latency', unit ms or the latency duration in action `mysql`
     */
    @JsonProperty("latency")
    public void setLatency(Integer latency) {
        this.latency = latency;
    }

    /**
     * the memory type needs to locate, only set it when action is stress, the value can be 'stack' or 'heap'
     */
    @JsonProperty("memType")
    public String getMemType() {
        return memType;
    }

    /**
     * the memory type needs to locate, only set it when action is stress, the value can be 'stack' or 'heap'
     */
    @JsonProperty("memType")
    public void setMemType(String memType) {
        this.memType = memType;
    }

    /**
     * the method in Java class
     */
    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    /**
     * the method in Java class
     */
    @JsonProperty("method")
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * the version of mysql-connector-java, only support 5.X.X(set to "5") and 8.X.X(set to "8") now
     */
    @JsonProperty("mysqlConnectorVersion")
    public String getMysqlConnectorVersion() {
        return mysqlConnectorVersion;
    }

    /**
     * the version of mysql-connector-java, only support 5.X.X(set to "5") and 8.X.X(set to "8") now
     */
    @JsonProperty("mysqlConnectorVersion")
    public void setMysqlConnectorVersion(String mysqlConnectorVersion) {
        this.mysqlConnectorVersion = mysqlConnectorVersion;
    }

    /**
     * byteman rule name, should be unique, and will generate one if not set
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * byteman rule name, should be unique, and will generate one if not set
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * the pid of Java process which needs to attach
     */
    @JsonProperty("pid")
    public Integer getPid() {
        return pid;
    }

    /**
     * the pid of Java process which needs to attach
     */
    @JsonProperty("pid")
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * the port of agent server, default 9277
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * the port of agent server, default 9277
     */
    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * the return value for action 'return'
     */
    @JsonProperty("returnValue")
    public String getReturnValue() {
        return returnValue;
    }

    /**
     * the return value for action 'return'
     */
    @JsonProperty("returnValue")
    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }

    /**
     * the byteman rule's data for action 'ruleData'
     */
    @JsonProperty("ruleData")
    public String getRuleData() {
        return ruleData;
    }

    /**
     * the byteman rule's data for action 'ruleData'
     */
    @JsonProperty("ruleData")
    public void setRuleData(String ruleData) {
        this.ruleData = ruleData;
    }

    /**
     * the match sql type default value is "", means match all SQL type. The value can be 'select', 'insert', 'update', 'delete', 'replace'.
     */
    @JsonProperty("sqlType")
    public String getSqlType() {
        return sqlType;
    }

    /**
     * the match sql type default value is "", means match all SQL type. The value can be 'select', 'insert', 'update', 'delete', 'replace'.
     */
    @JsonProperty("sqlType")
    public void setSqlType(String sqlType) {
        this.sqlType = sqlType;
    }

    /**
     * the match table default value is "", means match all table
     */
    @JsonProperty("table")
    public String getTable() {
        return table;
    }

    /**
     * the match table default value is "", means match all table
     */
    @JsonProperty("table")
    public void setTable(String table) {
        this.table = table;
    }

    @JsonIgnore
    public JVMParameterBuilder edit() {
        return new JVMParameterBuilder(this);
    }

    @JsonIgnore
    public JVMParameterBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
