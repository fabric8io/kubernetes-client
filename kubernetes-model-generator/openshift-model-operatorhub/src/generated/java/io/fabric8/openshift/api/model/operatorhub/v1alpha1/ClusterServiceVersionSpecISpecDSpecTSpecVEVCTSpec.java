
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
    "accessModes",
    "dataSource",
    "dataSourceRef",
    "resources",
    "selector",
    "storageClassName",
    "volumeAttributesClassName",
    "volumeMode",
    "volumeName"
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
public class ClusterServiceVersionSpecISpecDSpecTSpecVEVCTSpec implements Editable<ClusterServiceVersionSpecISpecDSpecTSpecVEVCTSpecBuilder> , KubernetesResource
{

    @JsonProperty("accessModes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> accessModes = new ArrayList<>();
    @JsonProperty("dataSource")
    private ClusterServiceVersionSpecISpecDSpecTSpecVEVCTSpecDataSource dataSource;
    @JsonProperty("dataSourceRef")
    private ClusterServiceVersionSpecISpecDSpecTSpecVEVCTSpecDataSourceRef dataSourceRef;
    @JsonProperty("resources")
    private ClusterServiceVersionSpecISpecDSpecTSpecVEVCTSpecResources resources;
    @JsonProperty("selector")
    private ClusterServiceVersionSpecISpecDSpecTSpecVEVCTSpecSelector selector;
    @JsonProperty("storageClassName")
    private String storageClassName;
    @JsonProperty("volumeAttributesClassName")
    private String volumeAttributesClassName;
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
    public ClusterServiceVersionSpecISpecDSpecTSpecVEVCTSpec() {
    }

    public ClusterServiceVersionSpecISpecDSpecTSpecVEVCTSpec(List<String> accessModes, ClusterServiceVersionSpecISpecDSpecTSpecVEVCTSpecDataSource dataSource, ClusterServiceVersionSpecISpecDSpecTSpecVEVCTSpecDataSourceRef dataSourceRef, ClusterServiceVersionSpecISpecDSpecTSpecVEVCTSpecResources resources, ClusterServiceVersionSpecISpecDSpecTSpecVEVCTSpecSelector selector, String storageClassName, String volumeAttributesClassName, String volumeMode, String volumeName) {
        super();
        this.accessModes = accessModes;
        this.dataSource = dataSource;
        this.dataSourceRef = dataSourceRef;
        this.resources = resources;
        this.selector = selector;
        this.storageClassName = storageClassName;
        this.volumeAttributesClassName = volumeAttributesClassName;
        this.volumeMode = volumeMode;
        this.volumeName = volumeName;
    }

    @JsonProperty("accessModes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAccessModes() {
        return accessModes;
    }

    @JsonProperty("accessModes")
    public void setAccessModes(List<String> accessModes) {
        this.accessModes = accessModes;
    }

    @JsonProperty("dataSource")
    public ClusterServiceVersionSpecISpecDSpecTSpecVEVCTSpecDataSource getDataSource() {
        return dataSource;
    }

    @JsonProperty("dataSource")
    public void setDataSource(ClusterServiceVersionSpecISpecDSpecTSpecVEVCTSpecDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @JsonProperty("dataSourceRef")
    public ClusterServiceVersionSpecISpecDSpecTSpecVEVCTSpecDataSourceRef getDataSourceRef() {
        return dataSourceRef;
    }

    @JsonProperty("dataSourceRef")
    public void setDataSourceRef(ClusterServiceVersionSpecISpecDSpecTSpecVEVCTSpecDataSourceRef dataSourceRef) {
        this.dataSourceRef = dataSourceRef;
    }

    @JsonProperty("resources")
    public ClusterServiceVersionSpecISpecDSpecTSpecVEVCTSpecResources getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(ClusterServiceVersionSpecISpecDSpecTSpecVEVCTSpecResources resources) {
        this.resources = resources;
    }

    @JsonProperty("selector")
    public ClusterServiceVersionSpecISpecDSpecTSpecVEVCTSpecSelector getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(ClusterServiceVersionSpecISpecDSpecTSpecVEVCTSpecSelector selector) {
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

    @JsonProperty("volumeAttributesClassName")
    public String getVolumeAttributesClassName() {
        return volumeAttributesClassName;
    }

    @JsonProperty("volumeAttributesClassName")
    public void setVolumeAttributesClassName(String volumeAttributesClassName) {
        this.volumeAttributesClassName = volumeAttributesClassName;
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

    @JsonIgnore
    public ClusterServiceVersionSpecISpecDSpecTSpecVEVCTSpecBuilder edit() {
        return new ClusterServiceVersionSpecISpecDSpecTSpecVEVCTSpecBuilder(this);
    }

    @JsonIgnore
    public ClusterServiceVersionSpecISpecDSpecTSpecVEVCTSpecBuilder toBuilder() {
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
