
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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "V1beta1FlowSchema",
    "V1beta1FlowSchemaList",
    "V1beta1PriorityLevelConfiguration",
    "V1beta1PriorityLevelConfigurationList",
    "V1beta2FlowSchema",
    "V1beta2FlowSchemaList",
    "V1beta2PriorityLevelConfiguration",
    "V1beta2PriorityLevelConfigurationList"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
public class KubeSchema {

    @JsonProperty("V1beta1FlowSchema")
    private io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.FlowSchema v1beta1FlowSchema;
    @JsonProperty("V1beta1FlowSchemaList")
    private io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.FlowSchemaList v1beta1FlowSchemaList;
    @JsonProperty("V1beta1PriorityLevelConfiguration")
    private io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.PriorityLevelConfiguration v1beta1PriorityLevelConfiguration;
    @JsonProperty("V1beta1PriorityLevelConfigurationList")
    private io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.PriorityLevelConfigurationList v1beta1PriorityLevelConfigurationList;
    @JsonProperty("V1beta2FlowSchema")
    private io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.FlowSchema v1beta2FlowSchema;
    @JsonProperty("V1beta2FlowSchemaList")
    private io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.FlowSchemaList v1beta2FlowSchemaList;
    @JsonProperty("V1beta2PriorityLevelConfiguration")
    private io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.PriorityLevelConfiguration v1beta2PriorityLevelConfiguration;
    @JsonProperty("V1beta2PriorityLevelConfigurationList")
    private io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.PriorityLevelConfigurationList v1beta2PriorityLevelConfigurationList;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KubeSchema() {
    }

    /**
     * 
     * @param v1beta1FlowSchemaList
     * @param v1beta2FlowSchema
     * @param v1beta1PriorityLevelConfigurationList
     * @param v1beta1FlowSchema
     * @param v1beta2FlowSchemaList
     * @param v1beta1PriorityLevelConfiguration
     * @param v1beta2PriorityLevelConfigurationList
     * @param v1beta2PriorityLevelConfiguration
     */
    public KubeSchema(io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.FlowSchema v1beta1FlowSchema, io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.FlowSchemaList v1beta1FlowSchemaList, io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.PriorityLevelConfiguration v1beta1PriorityLevelConfiguration, io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.PriorityLevelConfigurationList v1beta1PriorityLevelConfigurationList, io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.FlowSchema v1beta2FlowSchema, io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.FlowSchemaList v1beta2FlowSchemaList, io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.PriorityLevelConfiguration v1beta2PriorityLevelConfiguration, io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.PriorityLevelConfigurationList v1beta2PriorityLevelConfigurationList) {
        super();
        this.v1beta1FlowSchema = v1beta1FlowSchema;
        this.v1beta1FlowSchemaList = v1beta1FlowSchemaList;
        this.v1beta1PriorityLevelConfiguration = v1beta1PriorityLevelConfiguration;
        this.v1beta1PriorityLevelConfigurationList = v1beta1PriorityLevelConfigurationList;
        this.v1beta2FlowSchema = v1beta2FlowSchema;
        this.v1beta2FlowSchemaList = v1beta2FlowSchemaList;
        this.v1beta2PriorityLevelConfiguration = v1beta2PriorityLevelConfiguration;
        this.v1beta2PriorityLevelConfigurationList = v1beta2PriorityLevelConfigurationList;
    }

    @JsonProperty("V1beta1FlowSchema")
    public io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.FlowSchema getV1beta1FlowSchema() {
        return v1beta1FlowSchema;
    }

    @JsonProperty("V1beta1FlowSchema")
    public void setV1beta1FlowSchema(io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.FlowSchema v1beta1FlowSchema) {
        this.v1beta1FlowSchema = v1beta1FlowSchema;
    }

    @JsonProperty("V1beta1FlowSchemaList")
    public io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.FlowSchemaList getV1beta1FlowSchemaList() {
        return v1beta1FlowSchemaList;
    }

    @JsonProperty("V1beta1FlowSchemaList")
    public void setV1beta1FlowSchemaList(io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.FlowSchemaList v1beta1FlowSchemaList) {
        this.v1beta1FlowSchemaList = v1beta1FlowSchemaList;
    }

    @JsonProperty("V1beta1PriorityLevelConfiguration")
    public io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.PriorityLevelConfiguration getV1beta1PriorityLevelConfiguration() {
        return v1beta1PriorityLevelConfiguration;
    }

    @JsonProperty("V1beta1PriorityLevelConfiguration")
    public void setV1beta1PriorityLevelConfiguration(io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.PriorityLevelConfiguration v1beta1PriorityLevelConfiguration) {
        this.v1beta1PriorityLevelConfiguration = v1beta1PriorityLevelConfiguration;
    }

    @JsonProperty("V1beta1PriorityLevelConfigurationList")
    public io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.PriorityLevelConfigurationList getV1beta1PriorityLevelConfigurationList() {
        return v1beta1PriorityLevelConfigurationList;
    }

    @JsonProperty("V1beta1PriorityLevelConfigurationList")
    public void setV1beta1PriorityLevelConfigurationList(io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.PriorityLevelConfigurationList v1beta1PriorityLevelConfigurationList) {
        this.v1beta1PriorityLevelConfigurationList = v1beta1PriorityLevelConfigurationList;
    }

    @JsonProperty("V1beta2FlowSchema")
    public io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.FlowSchema getV1beta2FlowSchema() {
        return v1beta2FlowSchema;
    }

    @JsonProperty("V1beta2FlowSchema")
    public void setV1beta2FlowSchema(io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.FlowSchema v1beta2FlowSchema) {
        this.v1beta2FlowSchema = v1beta2FlowSchema;
    }

    @JsonProperty("V1beta2FlowSchemaList")
    public io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.FlowSchemaList getV1beta2FlowSchemaList() {
        return v1beta2FlowSchemaList;
    }

    @JsonProperty("V1beta2FlowSchemaList")
    public void setV1beta2FlowSchemaList(io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.FlowSchemaList v1beta2FlowSchemaList) {
        this.v1beta2FlowSchemaList = v1beta2FlowSchemaList;
    }

    @JsonProperty("V1beta2PriorityLevelConfiguration")
    public io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.PriorityLevelConfiguration getV1beta2PriorityLevelConfiguration() {
        return v1beta2PriorityLevelConfiguration;
    }

    @JsonProperty("V1beta2PriorityLevelConfiguration")
    public void setV1beta2PriorityLevelConfiguration(io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.PriorityLevelConfiguration v1beta2PriorityLevelConfiguration) {
        this.v1beta2PriorityLevelConfiguration = v1beta2PriorityLevelConfiguration;
    }

    @JsonProperty("V1beta2PriorityLevelConfigurationList")
    public io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.PriorityLevelConfigurationList getV1beta2PriorityLevelConfigurationList() {
        return v1beta2PriorityLevelConfigurationList;
    }

    @JsonProperty("V1beta2PriorityLevelConfigurationList")
    public void setV1beta2PriorityLevelConfigurationList(io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.PriorityLevelConfigurationList v1beta2PriorityLevelConfigurationList) {
        this.v1beta2PriorityLevelConfigurationList = v1beta2PriorityLevelConfigurationList;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
