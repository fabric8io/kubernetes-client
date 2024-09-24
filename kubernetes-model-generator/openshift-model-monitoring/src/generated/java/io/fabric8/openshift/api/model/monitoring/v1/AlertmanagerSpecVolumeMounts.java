
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.LinkedHashMap;
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
    "mountPath",
    "mountPropagation",
    "name",
    "readOnly",
    "subPath",
    "subPathExpr"
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
public class AlertmanagerSpecVolumeMounts implements Editable<AlertmanagerSpecVolumeMountsBuilder> , KubernetesResource
{

    @JsonProperty("mountPath")
    private String mountPath;
    @JsonProperty("mountPropagation")
    private String mountPropagation;
    @JsonProperty("name")
    private String name;
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonProperty("subPath")
    private String subPath;
    @JsonProperty("subPathExpr")
    private String subPathExpr;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AlertmanagerSpecVolumeMounts() {
    }

    public AlertmanagerSpecVolumeMounts(String mountPath, String mountPropagation, String name, Boolean readOnly, String subPath, String subPathExpr) {
        super();
        this.mountPath = mountPath;
        this.mountPropagation = mountPropagation;
        this.name = name;
        this.readOnly = readOnly;
        this.subPath = subPath;
        this.subPathExpr = subPathExpr;
    }

    @JsonProperty("mountPath")
    public String getMountPath() {
        return mountPath;
    }

    @JsonProperty("mountPath")
    public void setMountPath(String mountPath) {
        this.mountPath = mountPath;
    }

    @JsonProperty("mountPropagation")
    public String getMountPropagation() {
        return mountPropagation;
    }

    @JsonProperty("mountPropagation")
    public void setMountPropagation(String mountPropagation) {
        this.mountPropagation = mountPropagation;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    @JsonProperty("subPath")
    public String getSubPath() {
        return subPath;
    }

    @JsonProperty("subPath")
    public void setSubPath(String subPath) {
        this.subPath = subPath;
    }

    @JsonProperty("subPathExpr")
    public String getSubPathExpr() {
        return subPathExpr;
    }

    @JsonProperty("subPathExpr")
    public void setSubPathExpr(String subPathExpr) {
        this.subPathExpr = subPathExpr;
    }

    @JsonIgnore
    public AlertmanagerSpecVolumeMountsBuilder edit() {
        return new AlertmanagerSpecVolumeMountsBuilder(this);
    }

    @JsonIgnore
    public AlertmanagerSpecVolumeMountsBuilder toBuilder() {
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
