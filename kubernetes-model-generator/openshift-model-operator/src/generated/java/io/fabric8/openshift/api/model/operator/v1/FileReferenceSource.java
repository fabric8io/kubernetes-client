
package io.fabric8.openshift.api.model.operator.v1;

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
 * FileReferenceSource is used by the console to locate the specified file containing a custom logo.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configMap",
    "from"
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
public class FileReferenceSource implements Editable<FileReferenceSourceBuilder>, KubernetesResource
{

    @JsonProperty("configMap")
    private ConfigMapFileReference configMap;
    @JsonProperty("from")
    private String from;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FileReferenceSource() {
    }

    public FileReferenceSource(ConfigMapFileReference configMap, String from) {
        super();
        this.configMap = configMap;
        this.from = from;
    }

    /**
     * FileReferenceSource is used by the console to locate the specified file containing a custom logo.
     */
    @JsonProperty("configMap")
    public ConfigMapFileReference getConfigMap() {
        return configMap;
    }

    /**
     * FileReferenceSource is used by the console to locate the specified file containing a custom logo.
     */
    @JsonProperty("configMap")
    public void setConfigMap(ConfigMapFileReference configMap) {
        this.configMap = configMap;
    }

    /**
     * from is a required field to specify the source type of the file reference. Allowed values are ConfigMap. When set to ConfigMap, the file will be sourced from a ConfigMap in the openshift-config namespace. The configMap field must be set when from is set to ConfigMap.<br><p> <br><p> Possible enum values:<br><p>  - `"ConfigMap"` represents a ConfigMap source.
     */
    @JsonProperty("from")
    public String getFrom() {
        return from;
    }

    /**
     * from is a required field to specify the source type of the file reference. Allowed values are ConfigMap. When set to ConfigMap, the file will be sourced from a ConfigMap in the openshift-config namespace. The configMap field must be set when from is set to ConfigMap.<br><p> <br><p> Possible enum values:<br><p>  - `"ConfigMap"` represents a ConfigMap source.
     */
    @JsonProperty("from")
    public void setFrom(String from) {
        this.from = from;
    }

    @JsonIgnore
    public FileReferenceSourceBuilder edit() {
        return new FileReferenceSourceBuilder(this);
    }

    @JsonIgnore
    public FileReferenceSourceBuilder toBuilder() {
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

}
