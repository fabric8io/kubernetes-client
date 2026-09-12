
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

/**
 * JVMMySQLSpec is the specification of MySQL fault injection in JVM only when SQL match the Database, Table and SQLType, JVMChaos mesh will inject fault for examle:<br><p> <br><p> 	SQL is "select &#42; from test.t1",<br><p> 	only when ((Database == "test" || Database == "") &amp;&amp; (Table == "t1" || Table == "") &amp;&amp; (SQLType == "select" || SQLType == "")) is true, JVMChaos will inject fault
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "database",
    "mysqlConnectorVersion",
    "sqlType",
    "table"
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
public class JVMMySQLSpec implements Editable<JVMMySQLSpecBuilder>, KubernetesResource
{

    @JsonProperty("database")
    private String database;
    @JsonProperty("mysqlConnectorVersion")
    private String mysqlConnectorVersion;
    @JsonProperty("sqlType")
    private String sqlType;
    @JsonProperty("table")
    private String table;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public JVMMySQLSpec() {
    }

    public JVMMySQLSpec(String database, String mysqlConnectorVersion, String sqlType, String table) {
        super();
        this.database = database;
        this.mysqlConnectorVersion = mysqlConnectorVersion;
        this.sqlType = sqlType;
        this.table = table;
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
    public JVMMySQLSpecBuilder edit() {
        return new JVMMySQLSpecBuilder(this);
    }

    @JsonIgnore
    public JVMMySQLSpecBuilder toBuilder() {
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
        if (!(o instanceof JVMMySQLSpec)) {
            return false;
        }
        JVMMySQLSpec other = (JVMMySQLSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$database = this.getDatabase();
        Object other$database = other.getDatabase();
        if (this$database == null ? other$database != null : !this$database.equals(other$database)) {
            return false;
        }
        Object this$mysqlConnectorVersion = this.getMysqlConnectorVersion();
        Object other$mysqlConnectorVersion = other.getMysqlConnectorVersion();
        if (this$mysqlConnectorVersion == null ? other$mysqlConnectorVersion != null : !this$mysqlConnectorVersion.equals(other$mysqlConnectorVersion)) {
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
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof JVMMySQLSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $database = this.getDatabase();
        result = result * prime + ($database == null ? 43 : $database.hashCode());
        Object $mysqlConnectorVersion = this.getMysqlConnectorVersion();
        result = result * prime + ($mysqlConnectorVersion == null ? 43 : $mysqlConnectorVersion.hashCode());
        Object $sqlType = this.getSqlType();
        result = result * prime + ($sqlType == null ? 43 : $sqlType.hashCode());
        Object $table = this.getTable();
        result = result * prime + ($table == null ? 43 : $table.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "JVMMySQLSpec(" + "database=" + this.getDatabase() + ", mysqlConnectorVersion=" + this.getMysqlConnectorVersion() + ", sqlType=" + this.getSqlType() + ", table=" + this.getTable() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
