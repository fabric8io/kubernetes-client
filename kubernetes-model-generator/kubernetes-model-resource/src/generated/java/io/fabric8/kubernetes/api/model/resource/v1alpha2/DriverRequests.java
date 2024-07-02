
package io.fabric8.kubernetes.api.model.resource.v1alpha2;

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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
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
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "driverName",
    "requests",
    "vendorParameters"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class DriverRequests implements Editable<DriverRequestsBuilder> , KubernetesResource
{

    @JsonProperty("driverName")
    private java.lang.String driverName;
    @JsonProperty("requests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ResourceRequest> requests = new ArrayList<ResourceRequest>();
    @JsonProperty("vendorParameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> vendorParameters = new LinkedHashMap<String, Object>();
    @JsonIgnore
    private Map<java.lang.String, java.lang.Object> additionalProperties = new LinkedHashMap<java.lang.String, java.lang.Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DriverRequests() {
    }

    public DriverRequests(java.lang.String driverName, List<ResourceRequest> requests, Map<String, Object> vendorParameters) {
        super();
        this.driverName = driverName;
        this.requests = requests;
        this.vendorParameters = vendorParameters;
    }

    @JsonProperty("driverName")
    public java.lang.String getDriverName() {
        return driverName;
    }

    @JsonProperty("driverName")
    public void setDriverName(java.lang.String driverName) {
        this.driverName = driverName;
    }

    @JsonProperty("requests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ResourceRequest> getRequests() {
        return requests;
    }

    @JsonProperty("requests")
    public void setRequests(List<ResourceRequest> requests) {
        this.requests = requests;
    }

    @JsonProperty("vendorParameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Object> getVendorParameters() {
        return vendorParameters;
    }

    @JsonProperty("vendorParameters")
    public void setVendorParameters(Map<String, Object> vendorParameters) {
        this.vendorParameters = vendorParameters;
    }

    @JsonIgnore
    public DriverRequestsBuilder edit() {
        return new DriverRequestsBuilder(this);
    }

    @JsonIgnore
    public DriverRequestsBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    public Map<java.lang.String, java.lang.Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, java.lang.Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<java.lang.String, java.lang.Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
