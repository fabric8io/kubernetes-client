
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
import io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.FlowSchema;
import io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.FlowSchemaList;
import io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.PriorityLevelConfiguration;
import io.fabric8.kubernetes.api.model.flowcontrol.v1beta1.PriorityLevelConfigurationList;
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
    "V1beta1PriorityLevelConfigurationList"
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
public class ValidationSchema {

    @JsonProperty("V1beta1FlowSchema")
    private FlowSchema v1beta1FlowSchema;
    @JsonProperty("V1beta1FlowSchemaList")
    private FlowSchemaList v1beta1FlowSchemaList;
    @JsonProperty("V1beta1PriorityLevelConfiguration")
    private PriorityLevelConfiguration v1beta1PriorityLevelConfiguration;
    @JsonProperty("V1beta1PriorityLevelConfigurationList")
    private PriorityLevelConfigurationList v1beta1PriorityLevelConfigurationList;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidationSchema() {
    }

    /**
     * 
     * @param v1beta1FlowSchemaList
     * @param v1beta1PriorityLevelConfigurationList
     * @param v1beta1FlowSchema
     * @param v1beta1PriorityLevelConfiguration
     */
    public ValidationSchema(FlowSchema v1beta1FlowSchema, FlowSchemaList v1beta1FlowSchemaList, PriorityLevelConfiguration v1beta1PriorityLevelConfiguration, PriorityLevelConfigurationList v1beta1PriorityLevelConfigurationList) {
        super();
        this.v1beta1FlowSchema = v1beta1FlowSchema;
        this.v1beta1FlowSchemaList = v1beta1FlowSchemaList;
        this.v1beta1PriorityLevelConfiguration = v1beta1PriorityLevelConfiguration;
        this.v1beta1PriorityLevelConfigurationList = v1beta1PriorityLevelConfigurationList;
    }

    @JsonProperty("V1beta1FlowSchema")
    public FlowSchema getV1beta1FlowSchema() {
        return v1beta1FlowSchema;
    }

    @JsonProperty("V1beta1FlowSchema")
    public void setV1beta1FlowSchema(FlowSchema v1beta1FlowSchema) {
        this.v1beta1FlowSchema = v1beta1FlowSchema;
    }

    @JsonProperty("V1beta1FlowSchemaList")
    public FlowSchemaList getV1beta1FlowSchemaList() {
        return v1beta1FlowSchemaList;
    }

    @JsonProperty("V1beta1FlowSchemaList")
    public void setV1beta1FlowSchemaList(FlowSchemaList v1beta1FlowSchemaList) {
        this.v1beta1FlowSchemaList = v1beta1FlowSchemaList;
    }

    @JsonProperty("V1beta1PriorityLevelConfiguration")
    public PriorityLevelConfiguration getV1beta1PriorityLevelConfiguration() {
        return v1beta1PriorityLevelConfiguration;
    }

    @JsonProperty("V1beta1PriorityLevelConfiguration")
    public void setV1beta1PriorityLevelConfiguration(PriorityLevelConfiguration v1beta1PriorityLevelConfiguration) {
        this.v1beta1PriorityLevelConfiguration = v1beta1PriorityLevelConfiguration;
    }

    @JsonProperty("V1beta1PriorityLevelConfigurationList")
    public PriorityLevelConfigurationList getV1beta1PriorityLevelConfigurationList() {
        return v1beta1PriorityLevelConfigurationList;
    }

    @JsonProperty("V1beta1PriorityLevelConfigurationList")
    public void setV1beta1PriorityLevelConfigurationList(PriorityLevelConfigurationList v1beta1PriorityLevelConfigurationList) {
        this.v1beta1PriorityLevelConfigurationList = v1beta1PriorityLevelConfigurationList;
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
