
package io.fabric8.openshift.api.model.installer.gcp.v1;

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
 * Metric identify a quota. Service/Label matches the Google Quota API names for quota metrics
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dimensions",
    "limit",
    "service"
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
public class Metric implements Editable<MetricBuilder>, KubernetesResource
{

    @JsonProperty("dimensions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> dimensions = new LinkedHashMap<>();
    @JsonProperty("limit")
    private String limit;
    @JsonProperty("service")
    private String service;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Metric() {
    }

    public Metric(Map<String, String> dimensions, String limit, String service) {
        super();
        this.dimensions = dimensions;
        this.limit = limit;
        this.service = service;
    }

    /**
     * Dimensions are unique axes on which this Limit is applied (e.g. region: us-central-1)
     */
    @JsonProperty("dimensions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getDimensions() {
        return dimensions;
    }

    /**
     * Dimensions are unique axes on which this Limit is applied (e.g. region: us-central-1)
     */
    @JsonProperty("dimensions")
    public void setDimensions(Map<String, String> dimensions) {
        this.dimensions = dimensions;
    }

    /**
     * Limit is the name of the item that's limited (e.g. cpus)
     */
    @JsonProperty("limit")
    public String getLimit() {
        return limit;
    }

    /**
     * Limit is the name of the item that's limited (e.g. cpus)
     */
    @JsonProperty("limit")
    public void setLimit(String limit) {
        this.limit = limit;
    }

    /**
     * Service is the Google Cloud Service to which this quota belongs (e.g. compute.googleapis.com)
     */
    @JsonProperty("service")
    public String getService() {
        return service;
    }

    /**
     * Service is the Google Cloud Service to which this quota belongs (e.g. compute.googleapis.com)
     */
    @JsonProperty("service")
    public void setService(String service) {
        this.service = service;
    }

    @JsonIgnore
    public MetricBuilder edit() {
        return new MetricBuilder(this);
    }

    @JsonIgnore
    public MetricBuilder toBuilder() {
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
        if (!(o instanceof Metric)) {
            return false;
        }
        Metric other = (Metric) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$dimensions = this.getDimensions();
        Object other$dimensions = other.getDimensions();
        if (this$dimensions == null ? other$dimensions != null : !this$dimensions.equals(other$dimensions)) {
            return false;
        }
        Object this$limit = this.getLimit();
        Object other$limit = other.getLimit();
        if (this$limit == null ? other$limit != null : !this$limit.equals(other$limit)) {
            return false;
        }
        Object this$service = this.getService();
        Object other$service = other.getService();
        if (this$service == null ? other$service != null : !this$service.equals(other$service)) {
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
        return other instanceof Metric;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $dimensions = this.getDimensions();
        result = result * prime + ($dimensions == null ? 43 : $dimensions.hashCode());
        Object $limit = this.getLimit();
        result = result * prime + ($limit == null ? 43 : $limit.hashCode());
        Object $service = this.getService();
        result = result * prime + ($service == null ? 43 : $service.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Metric(" + "dimensions=" + this.getDimensions() + ", limit=" + this.getLimit() + ", service=" + this.getService() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
