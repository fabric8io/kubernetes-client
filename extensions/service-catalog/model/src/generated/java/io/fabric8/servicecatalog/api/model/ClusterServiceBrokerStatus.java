
package io.fabric8.servicecatalog.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "conditions",
    "lastCatalogRetrievalTime",
    "operationStartTime",
    "reconciledGeneration"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class ClusterServiceBrokerStatus implements KubernetesResource
{

    @JsonProperty("conditions")
    private List<ServiceBrokerCondition> conditions = new ArrayList<ServiceBrokerCondition>();
    @JsonProperty("lastCatalogRetrievalTime")
    private String lastCatalogRetrievalTime;
    @JsonProperty("operationStartTime")
    private String operationStartTime;
    @JsonProperty("reconciledGeneration")
    private Long reconciledGeneration;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClusterServiceBrokerStatus() {
    }

    /**
     * 
     * @param operationStartTime
     * @param lastCatalogRetrievalTime
     * @param reconciledGeneration
     * @param conditions
     */
    public ClusterServiceBrokerStatus(List<ServiceBrokerCondition> conditions, String lastCatalogRetrievalTime, String operationStartTime, Long reconciledGeneration) {
        super();
        this.conditions = conditions;
        this.lastCatalogRetrievalTime = lastCatalogRetrievalTime;
        this.operationStartTime = operationStartTime;
        this.reconciledGeneration = reconciledGeneration;
    }

    @JsonProperty("conditions")
    public List<ServiceBrokerCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<ServiceBrokerCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("lastCatalogRetrievalTime")
    public String getLastCatalogRetrievalTime() {
        return lastCatalogRetrievalTime;
    }

    @JsonProperty("lastCatalogRetrievalTime")
    public void setLastCatalogRetrievalTime(String lastCatalogRetrievalTime) {
        this.lastCatalogRetrievalTime = lastCatalogRetrievalTime;
    }

    @JsonProperty("operationStartTime")
    public String getOperationStartTime() {
        return operationStartTime;
    }

    @JsonProperty("operationStartTime")
    public void setOperationStartTime(String operationStartTime) {
        this.operationStartTime = operationStartTime;
    }

    @JsonProperty("reconciledGeneration")
    public Long getReconciledGeneration() {
        return reconciledGeneration;
    }

    @JsonProperty("reconciledGeneration")
    public void setReconciledGeneration(Long reconciledGeneration) {
        this.reconciledGeneration = reconciledGeneration;
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
