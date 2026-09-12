
package io.fabric8.chaosmesh.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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

/**
 * JVMChaosSpec defines the desired state of JVMChaos
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "action",
    "class",
    "containerNames",
    "cpuCount",
    "database",
    "duration",
    "exception",
    "latency",
    "memType",
    "method",
    "mode",
    "mysqlConnectorVersion",
    "name",
    "pid",
    "port",
    "remoteCluster",
    "returnValue",
    "ruleData",
    "selector",
    "sqlType",
    "table",
    "value"
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
public class JVMChaosSpec implements Editable<JVMChaosSpecBuilder>, KubernetesResource
{

    @JsonProperty("action")
    private String action;
    @JsonProperty("class")
    private String className;
    @JsonProperty("containerNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> containerNames = new ArrayList<>();
    @JsonProperty("cpuCount")
    private Integer cpuCount;
    @JsonProperty("database")
    private String database;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("exception")
    private String exception;
    @JsonProperty("latency")
    private Integer latency;
    @JsonProperty("memType")
    private String memType;
    @JsonProperty("method")
    private String method;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("mysqlConnectorVersion")
    private String mysqlConnectorVersion;
    @JsonProperty("name")
    private String name;
    @JsonProperty("pid")
    private Integer pid;
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("remoteCluster")
    private String remoteCluster;
    @JsonProperty("returnValue")
    private String returnValue;
    @JsonProperty("ruleData")
    private String ruleData;
    @JsonProperty("selector")
    private PodSelectorSpec selector;
    @JsonProperty("sqlType")
    private String sqlType;
    @JsonProperty("table")
    private String table;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public JVMChaosSpec() {
    }

    public JVMChaosSpec(String action, String className, List<String> containerNames, Integer cpuCount, String database, String duration, String exception, Integer latency, String memType, String method, String mode, String mysqlConnectorVersion, String name, Integer pid, Integer port, String remoteCluster, String returnValue, String ruleData, PodSelectorSpec selector, String sqlType, String table, String value) {
        super();
        this.action = action;
        this.className = className;
        this.containerNames = containerNames;
        this.cpuCount = cpuCount;
        this.database = database;
        this.duration = duration;
        this.exception = exception;
        this.latency = latency;
        this.memType = memType;
        this.method = method;
        this.mode = mode;
        this.mysqlConnectorVersion = mysqlConnectorVersion;
        this.name = name;
        this.pid = pid;
        this.port = port;
        this.remoteCluster = remoteCluster;
        this.returnValue = returnValue;
        this.ruleData = ruleData;
        this.selector = selector;
        this.sqlType = sqlType;
        this.table = table;
        this.value = value;
    }

    /**
     * Action defines the specific jvm chaos action. Supported action: latency;return;exception;stress;gc;ruleData
     */
    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    /**
     * Action defines the specific jvm chaos action. Supported action: latency;return;exception;stress;gc;ruleData
     */
    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
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
     * ContainerNames indicates list of the name of affected container. If not set, the first container will be injected
     */
    @JsonProperty("containerNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getContainerNames() {
        return containerNames;
    }

    /**
     * ContainerNames indicates list of the name of affected container. If not set, the first container will be injected
     */
    @JsonProperty("containerNames")
    public void setContainerNames(List<String> containerNames) {
        this.containerNames = containerNames;
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
     * Duration represents the duration of the chaos action
     */
    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    /**
     * Duration represents the duration of the chaos action
     */
    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
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
     * Mode defines the mode to run chaos action. Supported mode: one / all / fixed / fixed-percent / random-max-percent
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * Mode defines the mode to run chaos action. Supported mode: one / all / fixed / fixed-percent / random-max-percent
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
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
     * RemoteCluster represents the remote cluster where the chaos will be deployed
     */
    @JsonProperty("remoteCluster")
    public String getRemoteCluster() {
        return remoteCluster;
    }

    /**
     * RemoteCluster represents the remote cluster where the chaos will be deployed
     */
    @JsonProperty("remoteCluster")
    public void setRemoteCluster(String remoteCluster) {
        this.remoteCluster = remoteCluster;
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
     * JVMChaosSpec defines the desired state of JVMChaos
     */
    @JsonProperty("selector")
    public PodSelectorSpec getSelector() {
        return selector;
    }

    /**
     * JVMChaosSpec defines the desired state of JVMChaos
     */
    @JsonProperty("selector")
    public void setSelector(PodSelectorSpec selector) {
        this.selector = selector;
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

    /**
     * Value is required when the mode is set to `FixedMode` / `FixedPercentMode` / `RandomMaxPercentMode`. If `FixedMode`, provide an integer of pods to do chaos action. If `FixedPercentMode`, provide a number from 0-100 to specify the percent of pods the server can do chaos action. IF `RandomMaxPercentMode`,  provide a number from 0-100 to specify the max percent of pods to do chaos action
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * Value is required when the mode is set to `FixedMode` / `FixedPercentMode` / `RandomMaxPercentMode`. If `FixedMode`, provide an integer of pods to do chaos action. If `FixedPercentMode`, provide a number from 0-100 to specify the percent of pods the server can do chaos action. IF `RandomMaxPercentMode`,  provide a number from 0-100 to specify the max percent of pods to do chaos action
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonIgnore
    public JVMChaosSpecBuilder edit() {
        return new JVMChaosSpecBuilder(this);
    }

    @JsonIgnore
    public JVMChaosSpecBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof JVMChaosSpec)) {
            return false;
        }
        JVMChaosSpec other = (JVMChaosSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$action = this.getAction();
        Object other$action = other.getAction();
        if (this$action == null ? other$action != null : !this$action.equals(other$action)) {
            return false;
        }
        Object this$className = this.getClassName();
        Object other$className = other.getClassName();
        if (this$className == null ? other$className != null : !this$className.equals(other$className)) {
            return false;
        }
        Object this$containerNames = this.getContainerNames();
        Object other$containerNames = other.getContainerNames();
        if (this$containerNames == null ? other$containerNames != null : !this$containerNames.equals(other$containerNames)) {
            return false;
        }
        Object this$cpuCount = this.getCpuCount();
        Object other$cpuCount = other.getCpuCount();
        if (this$cpuCount == null ? other$cpuCount != null : !this$cpuCount.equals(other$cpuCount)) {
            return false;
        }
        Object this$database = this.getDatabase();
        Object other$database = other.getDatabase();
        if (this$database == null ? other$database != null : !this$database.equals(other$database)) {
            return false;
        }
        Object this$duration = this.getDuration();
        Object other$duration = other.getDuration();
        if (this$duration == null ? other$duration != null : !this$duration.equals(other$duration)) {
            return false;
        }
        Object this$exception = this.getException();
        Object other$exception = other.getException();
        if (this$exception == null ? other$exception != null : !this$exception.equals(other$exception)) {
            return false;
        }
        Object this$latency = this.getLatency();
        Object other$latency = other.getLatency();
        if (this$latency == null ? other$latency != null : !this$latency.equals(other$latency)) {
            return false;
        }
        Object this$memType = this.getMemType();
        Object other$memType = other.getMemType();
        if (this$memType == null ? other$memType != null : !this$memType.equals(other$memType)) {
            return false;
        }
        Object this$method = this.getMethod();
        Object other$method = other.getMethod();
        if (this$method == null ? other$method != null : !this$method.equals(other$method)) {
            return false;
        }
        Object this$mode = this.getMode();
        Object other$mode = other.getMode();
        if (this$mode == null ? other$mode != null : !this$mode.equals(other$mode)) {
            return false;
        }
        Object this$mysqlConnectorVersion = this.getMysqlConnectorVersion();
        Object other$mysqlConnectorVersion = other.getMysqlConnectorVersion();
        if (this$mysqlConnectorVersion == null ? other$mysqlConnectorVersion != null : !this$mysqlConnectorVersion.equals(other$mysqlConnectorVersion)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$pid = this.getPid();
        Object other$pid = other.getPid();
        if (this$pid == null ? other$pid != null : !this$pid.equals(other$pid)) {
            return false;
        }
        Object this$port = this.getPort();
        Object other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
            return false;
        }
        Object this$remoteCluster = this.getRemoteCluster();
        Object other$remoteCluster = other.getRemoteCluster();
        if (this$remoteCluster == null ? other$remoteCluster != null : !this$remoteCluster.equals(other$remoteCluster)) {
            return false;
        }
        Object this$returnValue = this.getReturnValue();
        Object other$returnValue = other.getReturnValue();
        if (this$returnValue == null ? other$returnValue != null : !this$returnValue.equals(other$returnValue)) {
            return false;
        }
        Object this$ruleData = this.getRuleData();
        Object other$ruleData = other.getRuleData();
        if (this$ruleData == null ? other$ruleData != null : !this$ruleData.equals(other$ruleData)) {
            return false;
        }
        Object this$selector = this.getSelector();
        Object other$selector = other.getSelector();
        if (this$selector == null ? other$selector != null : !this$selector.equals(other$selector)) {
            return false;
        }
        Object this$sqlType = this.getSqlType();
        Object other$sqlType = other.getSqlType();
        if (this$sqlType == null ? other$sqlType != null : !this$sqlType.equals(other$sqlType)) {
            return false;
        }
        Object this$table = this.getTable();
        Object other$table = other.getTable();
        if (this$table == null ? other$table != null : !this$table.equals(other$table)) {
            return false;
        }
        Object this$value = this.getValue();
        Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof JVMChaosSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $action = this.getAction();
        result = result * prime + ($action == null ? 43 : $action.hashCode());
        Object $className = this.getClassName();
        result = result * prime + ($className == null ? 43 : $className.hashCode());
        Object $containerNames = this.getContainerNames();
        result = result * prime + ($containerNames == null ? 43 : $containerNames.hashCode());
        Object $cpuCount = this.getCpuCount();
        result = result * prime + ($cpuCount == null ? 43 : $cpuCount.hashCode());
        Object $database = this.getDatabase();
        result = result * prime + ($database == null ? 43 : $database.hashCode());
        Object $duration = this.getDuration();
        result = result * prime + ($duration == null ? 43 : $duration.hashCode());
        Object $exception = this.getException();
        result = result * prime + ($exception == null ? 43 : $exception.hashCode());
        Object $latency = this.getLatency();
        result = result * prime + ($latency == null ? 43 : $latency.hashCode());
        Object $memType = this.getMemType();
        result = result * prime + ($memType == null ? 43 : $memType.hashCode());
        Object $method = this.getMethod();
        result = result * prime + ($method == null ? 43 : $method.hashCode());
        Object $mode = this.getMode();
        result = result * prime + ($mode == null ? 43 : $mode.hashCode());
        Object $mysqlConnectorVersion = this.getMysqlConnectorVersion();
        result = result * prime + ($mysqlConnectorVersion == null ? 43 : $mysqlConnectorVersion.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $pid = this.getPid();
        result = result * prime + ($pid == null ? 43 : $pid.hashCode());
        Object $port = this.getPort();
        result = result * prime + ($port == null ? 43 : $port.hashCode());
        Object $remoteCluster = this.getRemoteCluster();
        result = result * prime + ($remoteCluster == null ? 43 : $remoteCluster.hashCode());
        Object $returnValue = this.getReturnValue();
        result = result * prime + ($returnValue == null ? 43 : $returnValue.hashCode());
        Object $ruleData = this.getRuleData();
        result = result * prime + ($ruleData == null ? 43 : $ruleData.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $sqlType = this.getSqlType();
        result = result * prime + ($sqlType == null ? 43 : $sqlType.hashCode());
        Object $table = this.getTable();
        result = result * prime + ($table == null ? 43 : $table.hashCode());
        Object $value = this.getValue();
        result = result * prime + ($value == null ? 43 : $value.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "JVMChaosSpec(" + "action=" + this.getAction() + ", className=" + this.getClassName() + ", containerNames=" + this.getContainerNames() + ", cpuCount=" + this.getCpuCount() + ", database=" + this.getDatabase() + ", duration=" + this.getDuration() + ", exception=" + this.getException() + ", latency=" + this.getLatency() + ", memType=" + this.getMemType() + ", method=" + this.getMethod() + ", mode=" + this.getMode() + ", mysqlConnectorVersion=" + this.getMysqlConnectorVersion() + ", name=" + this.getName() + ", pid=" + this.getPid() + ", port=" + this.getPort() + ", remoteCluster=" + this.getRemoteCluster() + ", returnValue=" + this.getReturnValue() + ", ruleData=" + this.getRuleData() + ", selector=" + this.getSelector() + ", sqlType=" + this.getSqlType() + ", table=" + this.getTable() + ", value=" + this.getValue() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
