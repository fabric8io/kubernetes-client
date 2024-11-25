
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "fieldsType",
    "fieldsV1",
    "manager",
    "operation",
    "subresource",
    "time"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ManagedFieldsEntry implements Editable<ManagedFieldsEntryBuilder>, KubernetesResource
{

    @JsonProperty("apiVersion")
    private String apiVersion;
    @JsonProperty("fieldsType")
    private String fieldsType;
    @JsonProperty("fieldsV1")
    private FieldsV1 fieldsV1;
    @JsonProperty("manager")
    private String manager;
    @JsonProperty("operation")
    private String operation;
    @JsonProperty("subresource")
    private String subresource;
    @JsonProperty("time")
    private String time;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ManagedFieldsEntry() {
    }

    public ManagedFieldsEntry(String apiVersion, String fieldsType, FieldsV1 fieldsV1, String manager, String operation, String subresource, String time) {
        super();
        this.apiVersion = apiVersion;
        this.fieldsType = fieldsType;
        this.fieldsV1 = fieldsV1;
        this.manager = manager;
        this.operation = operation;
        this.subresource = subresource;
        this.time = time;
    }

    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("fieldsType")
    public String getFieldsType() {
        return fieldsType;
    }

    @JsonProperty("fieldsType")
    public void setFieldsType(String fieldsType) {
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
    public String getManager() {
        return manager;
    }

    @JsonProperty("manager")
    public void setManager(String manager) {
        this.manager = manager;
    }

    @JsonProperty("operation")
    public String getOperation() {
        return operation;
    }

    @JsonProperty("operation")
    public void setOperation(String operation) {
        this.operation = operation;
    }

    @JsonProperty("subresource")
    public String getSubresource() {
        return subresource;
    }

    @JsonProperty("subresource")
    public void setSubresource(String subresource) {
        this.subresource = subresource;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonIgnore
    public ManagedFieldsEntryBuilder edit() {
        return new ManagedFieldsEntryBuilder(this);
    }

    @JsonIgnore
    public ManagedFieldsEntryBuilder toBuilder() {
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
