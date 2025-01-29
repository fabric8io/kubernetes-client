
package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import io.fabric8.openclustermanagement.api.model.shared.PreConfiguredStorage;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * StorageConfig is the spec of object storage.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "alertmanagerStorageSize",
    "compactStorageSize",
    "metricObjectStorage",
    "receiveStorageSize",
    "ruleStorageSize",
    "storageClass",
    "storeStorageSize",
    "writeStorage"
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
public class StorageConfig implements Editable<StorageConfigBuilder>, KubernetesResource
{

    @JsonProperty("alertmanagerStorageSize")
    private String alertmanagerStorageSize;
    @JsonProperty("compactStorageSize")
    private String compactStorageSize;
    @JsonProperty("metricObjectStorage")
    private PreConfiguredStorage metricObjectStorage;
    @JsonProperty("receiveStorageSize")
    private String receiveStorageSize;
    @JsonProperty("ruleStorageSize")
    private String ruleStorageSize;
    @JsonProperty("storageClass")
    private String storageClass;
    @JsonProperty("storeStorageSize")
    private String storeStorageSize;
    @JsonProperty("writeStorage")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PreConfiguredStorage> writeStorage = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StorageConfig() {
    }

    public StorageConfig(String alertmanagerStorageSize, String compactStorageSize, PreConfiguredStorage metricObjectStorage, String receiveStorageSize, String ruleStorageSize, String storageClass, String storeStorageSize, List<PreConfiguredStorage> writeStorage) {
        super();
        this.alertmanagerStorageSize = alertmanagerStorageSize;
        this.compactStorageSize = compactStorageSize;
        this.metricObjectStorage = metricObjectStorage;
        this.receiveStorageSize = receiveStorageSize;
        this.ruleStorageSize = ruleStorageSize;
        this.storageClass = storageClass;
        this.storeStorageSize = storeStorageSize;
        this.writeStorage = writeStorage;
    }

    /**
     * The amount of storage applied to alertmanager stateful sets,
     */
    @JsonProperty("alertmanagerStorageSize")
    public String getAlertmanagerStorageSize() {
        return alertmanagerStorageSize;
    }

    /**
     * The amount of storage applied to alertmanager stateful sets,
     */
    @JsonProperty("alertmanagerStorageSize")
    public void setAlertmanagerStorageSize(String alertmanagerStorageSize) {
        this.alertmanagerStorageSize = alertmanagerStorageSize;
    }

    /**
     * The amount of storage applied to thanos compact stateful sets,
     */
    @JsonProperty("compactStorageSize")
    public String getCompactStorageSize() {
        return compactStorageSize;
    }

    /**
     * The amount of storage applied to thanos compact stateful sets,
     */
    @JsonProperty("compactStorageSize")
    public void setCompactStorageSize(String compactStorageSize) {
        this.compactStorageSize = compactStorageSize;
    }

    /**
     * StorageConfig is the spec of object storage.
     */
    @JsonProperty("metricObjectStorage")
    public PreConfiguredStorage getMetricObjectStorage() {
        return metricObjectStorage;
    }

    /**
     * StorageConfig is the spec of object storage.
     */
    @JsonProperty("metricObjectStorage")
    public void setMetricObjectStorage(PreConfiguredStorage metricObjectStorage) {
        this.metricObjectStorage = metricObjectStorage;
    }

    /**
     * The amount of storage applied to thanos receive stateful sets,
     */
    @JsonProperty("receiveStorageSize")
    public String getReceiveStorageSize() {
        return receiveStorageSize;
    }

    /**
     * The amount of storage applied to thanos receive stateful sets,
     */
    @JsonProperty("receiveStorageSize")
    public void setReceiveStorageSize(String receiveStorageSize) {
        this.receiveStorageSize = receiveStorageSize;
    }

    /**
     * The amount of storage applied to thanos rule stateful sets,
     */
    @JsonProperty("ruleStorageSize")
    public String getRuleStorageSize() {
        return ruleStorageSize;
    }

    /**
     * The amount of storage applied to thanos rule stateful sets,
     */
    @JsonProperty("ruleStorageSize")
    public void setRuleStorageSize(String ruleStorageSize) {
        this.ruleStorageSize = ruleStorageSize;
    }

    /**
     * Specify the storageClass Stateful Sets. This storage class will also be used for Object Storage if MetricObjectStorage was configured for the system to create the storage.
     */
    @JsonProperty("storageClass")
    public String getStorageClass() {
        return storageClass;
    }

    /**
     * Specify the storageClass Stateful Sets. This storage class will also be used for Object Storage if MetricObjectStorage was configured for the system to create the storage.
     */
    @JsonProperty("storageClass")
    public void setStorageClass(String storageClass) {
        this.storageClass = storageClass;
    }

    /**
     * The amount of storage applied to thanos store stateful sets,
     */
    @JsonProperty("storeStorageSize")
    public String getStoreStorageSize() {
        return storeStorageSize;
    }

    /**
     * The amount of storage applied to thanos store stateful sets,
     */
    @JsonProperty("storeStorageSize")
    public void setStoreStorageSize(String storeStorageSize) {
        this.storeStorageSize = storeStorageSize;
    }

    /**
     * WriteStorage storage config secret list for metrics
     */
    @JsonProperty("writeStorage")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PreConfiguredStorage> getWriteStorage() {
        return writeStorage;
    }

    /**
     * WriteStorage storage config secret list for metrics
     */
    @JsonProperty("writeStorage")
    public void setWriteStorage(List<PreConfiguredStorage> writeStorage) {
        this.writeStorage = writeStorage;
    }

    @JsonIgnore
    public StorageConfigBuilder edit() {
        return new StorageConfigBuilder(this);
    }

    @JsonIgnore
    public StorageConfigBuilder toBuilder() {
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
