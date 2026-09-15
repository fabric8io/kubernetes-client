
package io.fabric8.openclustermanagement.api.model.observability.v1beta1;

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
import io.fabric8.openclustermanagement.api.model.shared.PreConfiguredStorage;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * StorageConfigObject is the spec of object storage.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "metricObjectStorage",
    "statefulSetSize",
    "statefulSetStorageClass"
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
public class StorageConfigObject implements Editable<StorageConfigObjectBuilder>, KubernetesResource
{

    @JsonProperty("metricObjectStorage")
    private PreConfiguredStorage metricObjectStorage;
    @JsonProperty("statefulSetSize")
    private String statefulSetSize;
    @JsonProperty("statefulSetStorageClass")
    private String statefulSetStorageClass;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StorageConfigObject() {
    }

    public StorageConfigObject(PreConfiguredStorage metricObjectStorage, String statefulSetSize, String statefulSetStorageClass) {
        super();
        this.metricObjectStorage = metricObjectStorage;
        this.statefulSetSize = statefulSetSize;
        this.statefulSetStorageClass = statefulSetStorageClass;
    }

    /**
     * StorageConfigObject is the spec of object storage.
     */
    @JsonProperty("metricObjectStorage")
    public PreConfiguredStorage getMetricObjectStorage() {
        return metricObjectStorage;
    }

    /**
     * StorageConfigObject is the spec of object storage.
     */
    @JsonProperty("metricObjectStorage")
    public void setMetricObjectStorage(PreConfiguredStorage metricObjectStorage) {
        this.metricObjectStorage = metricObjectStorage;
    }

    /**
     * The amount of storage applied to the Observability stateful sets, i.e. Thanos store, Rule, compact and receiver.
     */
    @JsonProperty("statefulSetSize")
    public String getStatefulSetSize() {
        return statefulSetSize;
    }

    /**
     * The amount of storage applied to the Observability stateful sets, i.e. Thanos store, Rule, compact and receiver.
     */
    @JsonProperty("statefulSetSize")
    public void setStatefulSetSize(String statefulSetSize) {
        this.statefulSetSize = statefulSetSize;
    }

    /**
     * Specify the storageClass Stateful Sets. This storage class will also<br><p> be used for Object Storage if MetricObjectStorage was configured for the system to create the storage.
     */
    @JsonProperty("statefulSetStorageClass")
    public String getStatefulSetStorageClass() {
        return statefulSetStorageClass;
    }

    /**
     * Specify the storageClass Stateful Sets. This storage class will also<br><p> be used for Object Storage if MetricObjectStorage was configured for the system to create the storage.
     */
    @JsonProperty("statefulSetStorageClass")
    public void setStatefulSetStorageClass(String statefulSetStorageClass) {
        this.statefulSetStorageClass = statefulSetStorageClass;
    }

    @JsonIgnore
    public StorageConfigObjectBuilder edit() {
        return new StorageConfigObjectBuilder(this);
    }

    @JsonIgnore
    public StorageConfigObjectBuilder toBuilder() {
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
        if (!(o instanceof StorageConfigObject)) {
            return false;
        }
        StorageConfigObject other = (StorageConfigObject) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$metricObjectStorage = this.getMetricObjectStorage();
        Object other$metricObjectStorage = other.getMetricObjectStorage();
        if (this$metricObjectStorage == null ? other$metricObjectStorage != null : !this$metricObjectStorage.equals(other$metricObjectStorage)) {
            return false;
        }
        Object this$statefulSetSize = this.getStatefulSetSize();
        Object other$statefulSetSize = other.getStatefulSetSize();
        if (this$statefulSetSize == null ? other$statefulSetSize != null : !this$statefulSetSize.equals(other$statefulSetSize)) {
            return false;
        }
        Object this$statefulSetStorageClass = this.getStatefulSetStorageClass();
        Object other$statefulSetStorageClass = other.getStatefulSetStorageClass();
        if (this$statefulSetStorageClass == null ? other$statefulSetStorageClass != null : !this$statefulSetStorageClass.equals(other$statefulSetStorageClass)) {
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
        return other instanceof StorageConfigObject;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $metricObjectStorage = this.getMetricObjectStorage();
        result = result * prime + ($metricObjectStorage == null ? 43 : $metricObjectStorage.hashCode());
        Object $statefulSetSize = this.getStatefulSetSize();
        result = result * prime + ($statefulSetSize == null ? 43 : $statefulSetSize.hashCode());
        Object $statefulSetStorageClass = this.getStatefulSetStorageClass();
        result = result * prime + ($statefulSetStorageClass == null ? 43 : $statefulSetStorageClass.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "StorageConfigObject(" + "metricObjectStorage=" + this.getMetricObjectStorage() + ", statefulSetSize=" + this.getStatefulSetSize() + ", statefulSetStorageClass=" + this.getStatefulSetStorageClass() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
