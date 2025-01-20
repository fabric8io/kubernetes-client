
package io.fabric8.kubernetes.api.model.resource.v1beta1;

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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "adminAccess",
    "allocationMode",
    "count",
    "deviceClassName",
    "name",
    "selectors"
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
public class DeviceRequest implements Editable<DeviceRequestBuilder>, KubernetesResource
{

    @JsonProperty("adminAccess")
    private Boolean adminAccess;
    @JsonProperty("allocationMode")
    private String allocationMode;
    @JsonProperty("count")
    private Long count;
    @JsonProperty("deviceClassName")
    private String deviceClassName;
    @JsonProperty("name")
    private String name;
    @JsonProperty("selectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeviceSelector> selectors = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DeviceRequest() {
    }

    public DeviceRequest(Boolean adminAccess, String allocationMode, Long count, String deviceClassName, String name, List<DeviceSelector> selectors) {
        super();
        this.adminAccess = adminAccess;
        this.allocationMode = allocationMode;
        this.count = count;
        this.deviceClassName = deviceClassName;
        this.name = name;
        this.selectors = selectors;
    }

    @JsonProperty("adminAccess")
    public Boolean getAdminAccess() {
        return adminAccess;
    }

    @JsonProperty("adminAccess")
    public void setAdminAccess(Boolean adminAccess) {
        this.adminAccess = adminAccess;
    }

    @JsonProperty("allocationMode")
    public String getAllocationMode() {
        return allocationMode;
    }

    @JsonProperty("allocationMode")
    public void setAllocationMode(String allocationMode) {
        this.allocationMode = allocationMode;
    }

    @JsonProperty("count")
    public Long getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Long count) {
        this.count = count;
    }

    @JsonProperty("deviceClassName")
    public String getDeviceClassName() {
        return deviceClassName;
    }

    @JsonProperty("deviceClassName")
    public void setDeviceClassName(String deviceClassName) {
        this.deviceClassName = deviceClassName;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("selectors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DeviceSelector> getSelectors() {
        return selectors;
    }

    @JsonProperty("selectors")
    public void setSelectors(List<DeviceSelector> selectors) {
        this.selectors = selectors;
    }

    @JsonIgnore
    public DeviceRequestBuilder edit() {
        return new DeviceRequestBuilder(this);
    }

    @JsonIgnore
    public DeviceRequestBuilder toBuilder() {
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
