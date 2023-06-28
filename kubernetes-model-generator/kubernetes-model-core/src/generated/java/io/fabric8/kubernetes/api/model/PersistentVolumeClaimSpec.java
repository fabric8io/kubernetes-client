
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;
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
    "accessModes",
    "dataSource",
    "dataSourceRef",
    "resources",
    "selector",
    "storageClassName",
    "volumeMode",
    "volumeName"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class PersistentVolumeClaimSpec implements KubernetesResource
{

    @JsonProperty("accessModes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> accessModes = new ArrayList<String>();
    @JsonProperty("dataSource")
    private TypedLocalObjectReference dataSource;
    @JsonProperty("dataSourceRef")
    private TypedObjectReference dataSourceRef;
    @JsonProperty("resources")
    private ResourceRequirements resources;
    @JsonProperty("selector")
    private LabelSelector selector;
    @JsonProperty("storageClassName")
    private String storageClassName;
    @JsonProperty("volumeMode")
    private String volumeMode;
    @JsonProperty("volumeName")
    private String volumeName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PersistentVolumeClaimSpec() {
    }

    public PersistentVolumeClaimSpec(List<String> accessModes, TypedLocalObjectReference dataSource, TypedObjectReference dataSourceRef, ResourceRequirements resources, LabelSelector selector, String storageClassName, String volumeMode, String volumeName) {
        super();
        this.accessModes = accessModes;
        this.dataSource = dataSource;
        this.dataSourceRef = dataSourceRef;
        this.resources = resources;
        this.selector = selector;
        this.storageClassName = storageClassName;
        this.volumeMode = volumeMode;
        this.volumeName = volumeName;
    }

    @JsonProperty("accessModes")
    public List<String> getAccessModes() {
        return accessModes;
    }

    @JsonProperty("accessModes")
    public void setAccessModes(List<String> accessModes) {
        this.accessModes = accessModes;
    }

    @JsonProperty("dataSource")
    public TypedLocalObjectReference getDataSource() {
        return dataSource;
    }

    @JsonProperty("dataSource")
    public void setDataSource(TypedLocalObjectReference dataSource) {
        this.dataSource = dataSource;
    }

    @JsonProperty("dataSourceRef")
    public TypedObjectReference getDataSourceRef() {
        return dataSourceRef;
    }

    @JsonProperty("dataSourceRef")
    public void setDataSourceRef(TypedObjectReference dataSourceRef) {
        this.dataSourceRef = dataSourceRef;
    }

    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
        this.resources = resources;
    }

    @JsonProperty("selector")
    public LabelSelector getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(LabelSelector selector) {
        this.selector = selector;
    }

    @JsonProperty("storageClassName")
    public String getStorageClassName() {
        return storageClassName;
    }

    @JsonProperty("storageClassName")
    public void setStorageClassName(String storageClassName) {
        this.storageClassName = storageClassName;
    }

    @JsonProperty("volumeMode")
    public String getVolumeMode() {
        return volumeMode;
    }

    @JsonProperty("volumeMode")
    public void setVolumeMode(String volumeMode) {
        this.volumeMode = volumeMode;
    }

    @JsonProperty("volumeName")
    public String getVolumeName() {
        return volumeName;
    }

    @JsonProperty("volumeName")
    public void setVolumeName(String volumeName) {
        this.volumeName = volumeName;
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
