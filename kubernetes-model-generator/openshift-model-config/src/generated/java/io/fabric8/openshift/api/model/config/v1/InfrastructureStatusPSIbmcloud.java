
package io.fabric8.openshift.api.model.config.v1;

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
    "cisInstanceCRN",
    "dnsInstanceCRN",
    "location",
    "providerType",
    "resourceGroupName",
    "serviceEndpoints"
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
public class InfrastructureStatusPSIbmcloud implements Editable<InfrastructureStatusPSIbmcloudBuilder> , KubernetesResource
{

    @JsonProperty("cisInstanceCRN")
    private String cisInstanceCRN;
    @JsonProperty("dnsInstanceCRN")
    private String dnsInstanceCRN;
    @JsonProperty("location")
    private String location;
    @JsonProperty("providerType")
    private String providerType;
    @JsonProperty("resourceGroupName")
    private String resourceGroupName;
    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<InfrastructureStatusPSIbmcloudServiceEndpoints> serviceEndpoints = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public InfrastructureStatusPSIbmcloud() {
    }

    public InfrastructureStatusPSIbmcloud(String cisInstanceCRN, String dnsInstanceCRN, String location, String providerType, String resourceGroupName, List<InfrastructureStatusPSIbmcloudServiceEndpoints> serviceEndpoints) {
        super();
        this.cisInstanceCRN = cisInstanceCRN;
        this.dnsInstanceCRN = dnsInstanceCRN;
        this.location = location;
        this.providerType = providerType;
        this.resourceGroupName = resourceGroupName;
        this.serviceEndpoints = serviceEndpoints;
    }

    @JsonProperty("cisInstanceCRN")
    public String getCisInstanceCRN() {
        return cisInstanceCRN;
    }

    @JsonProperty("cisInstanceCRN")
    public void setCisInstanceCRN(String cisInstanceCRN) {
        this.cisInstanceCRN = cisInstanceCRN;
    }

    @JsonProperty("dnsInstanceCRN")
    public String getDnsInstanceCRN() {
        return dnsInstanceCRN;
    }

    @JsonProperty("dnsInstanceCRN")
    public void setDnsInstanceCRN(String dnsInstanceCRN) {
        this.dnsInstanceCRN = dnsInstanceCRN;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("providerType")
    public String getProviderType() {
        return providerType;
    }

    @JsonProperty("providerType")
    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }

    @JsonProperty("resourceGroupName")
    public String getResourceGroupName() {
        return resourceGroupName;
    }

    @JsonProperty("resourceGroupName")
    public void setResourceGroupName(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
    }

    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<InfrastructureStatusPSIbmcloudServiceEndpoints> getServiceEndpoints() {
        return serviceEndpoints;
    }

    @JsonProperty("serviceEndpoints")
    public void setServiceEndpoints(List<InfrastructureStatusPSIbmcloudServiceEndpoints> serviceEndpoints) {
        this.serviceEndpoints = serviceEndpoints;
    }

    @JsonIgnore
    public InfrastructureStatusPSIbmcloudBuilder edit() {
        return new InfrastructureStatusPSIbmcloudBuilder(this);
    }

    @JsonIgnore
    public InfrastructureStatusPSIbmcloudBuilder toBuilder() {
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
