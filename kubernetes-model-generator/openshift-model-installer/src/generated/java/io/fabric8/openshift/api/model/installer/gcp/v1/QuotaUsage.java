
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * QuotaUsage identifies a quota metric and records the usage
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "amount",
    "dimensions",
    "limit",
    "service"
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
public class QuotaUsage implements Editable<QuotaUsageBuilder>, KubernetesResource
{

    @JsonProperty("amount")
    private Long amount;
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
    public QuotaUsage() {
    }

    public QuotaUsage(Long amount, Map<String, String> dimensions, String limit, String service) {
        super();
        this.amount = amount;
        this.dimensions = dimensions;
        this.limit = limit;
        this.service = service;
    }

    /**
     * Amount is the amount of the quota being used
     */
    @JsonProperty("amount")
    public Long getAmount() {
        return amount;
    }

    /**
     * Amount is the amount of the quota being used
     */
    @JsonProperty("amount")
    public void setAmount(Long amount) {
        this.amount = amount;
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
    public QuotaUsageBuilder edit() {
        return new QuotaUsageBuilder(this);
    }

    @JsonIgnore
    public QuotaUsageBuilder toBuilder() {
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
