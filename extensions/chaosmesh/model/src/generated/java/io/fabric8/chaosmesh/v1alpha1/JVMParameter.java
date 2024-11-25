
package io.fabric8.chaosmesh.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
     * 
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

    @JsonProperty("class")
    public String getClassName() {
        return className;
    }

    @JsonProperty("class")
    public void setClassName(String className) {
        this.className = className;
    }

    @JsonProperty("cpuCount")
    public Integer getCpuCount() {
        return cpuCount;
    }

    @JsonProperty("cpuCount")
    public void setCpuCount(Integer cpuCount) {
        this.cpuCount = cpuCount;
    }

    @JsonProperty("database")
    public String getDatabase() {
        return database;
    }

    @JsonProperty("database")
    public void setDatabase(String database) {
        this.database = database;
    }

    @JsonProperty("exception")
    public String getException() {
        return exception;
    }

    @JsonProperty("exception")
    public void setException(String exception) {
        this.exception = exception;
    }

    @JsonProperty("latency")
    public Integer getLatency() {
        return latency;
    }

    @JsonProperty("latency")
    public void setLatency(Integer latency) {
        this.latency = latency;
    }

    @JsonProperty("memType")
    public String getMemType() {
        return memType;
    }

    @JsonProperty("memType")
    public void setMemType(String memType) {
        this.memType = memType;
    }

    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    @JsonProperty("method")
    public void setMethod(String method) {
        this.method = method;
    }

    @JsonProperty("mysqlConnectorVersion")
    public String getMysqlConnectorVersion() {
        return mysqlConnectorVersion;
    }

    @JsonProperty("mysqlConnectorVersion")
    public void setMysqlConnectorVersion(String mysqlConnectorVersion) {
        this.mysqlConnectorVersion = mysqlConnectorVersion;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("pid")
    public Integer getPid() {
        return pid;
    }

    @JsonProperty("pid")
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    @JsonProperty("returnValue")
    public String getReturnValue() {
        return returnValue;
    }

    @JsonProperty("returnValue")
    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }

    @JsonProperty("ruleData")
    public String getRuleData() {
        return ruleData;
    }

    @JsonProperty("ruleData")
    public void setRuleData(String ruleData) {
        this.ruleData = ruleData;
    }

    @JsonProperty("sqlType")
    public String getSqlType() {
        return sqlType;
    }

    @JsonProperty("sqlType")
    public void setSqlType(String sqlType) {
        this.sqlType = sqlType;
    }

    @JsonProperty("table")
    public String getTable() {
        return table;
    }

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
