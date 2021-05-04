
package io.fabric8.kubernetes.api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "fieldsType",
    "fieldsV1",
    "manager",
    "operation",
    "time"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class ManagedFieldsEntry implements KubernetesResource
{

    @JsonProperty("apiVersion")
    private java.lang.String apiVersion;
    @JsonProperty("fieldsType")
    private java.lang.String fieldsType;
    @JsonProperty("fieldsV1")
    private FieldsV1 fieldsV1;
    @JsonProperty("manager")
    private java.lang.String manager;
    @JsonProperty("operation")
    private java.lang.String operation;
    @JsonProperty("time")
    private String time;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ManagedFieldsEntry() {
    }

    /**
     * 
     * @param apiVersion
     * @param fieldsV1
     * @param manager
     * @param time
     * @param operation
     * @param fieldsType
     */
    public ManagedFieldsEntry(java.lang.String apiVersion, java.lang.String fieldsType, FieldsV1 fieldsV1, java.lang.String manager, java.lang.String operation, String time) {
        super();
        this.apiVersion = apiVersion;
        this.fieldsType = fieldsType;
        this.fieldsV1 = fieldsV1;
        this.manager = manager;
        this.operation = operation;
        this.time = time;
    }

    @JsonProperty("apiVersion")
    public java.lang.String getApiVersion() {
        return apiVersion;
    }

    @JsonProperty("apiVersion")
    public void setApiVersion(java.lang.String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("fieldsType")
    public java.lang.String getFieldsType() {
        return fieldsType;
    }

    @JsonProperty("fieldsType")
    public void setFieldsType(java.lang.String fieldsType) {
        this.fieldsType = fieldsType;
    }

    @JsonProperty("fieldsV1")
    public FieldsV1 getFieldsV1() {
        return fieldsV1;
    }

    @JsonProperty("fieldsV1")
    public void setFieldsV1(FieldsV1 fieldsV1) {
        this.fieldsV1 = fieldsV1;
    }

    @JsonProperty("manager")
    public java.lang.String getManager() {
        return manager;
    }

    @JsonProperty("manager")
    public void setManager(java.lang.String manager) {
        this.manager = manager;
    }

    @JsonProperty("operation")
    public java.lang.String getOperation() {
        return operation;
    }

    @JsonProperty("operation")
    public void setOperation(java.lang.String operation) {
        this.operation = operation;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
