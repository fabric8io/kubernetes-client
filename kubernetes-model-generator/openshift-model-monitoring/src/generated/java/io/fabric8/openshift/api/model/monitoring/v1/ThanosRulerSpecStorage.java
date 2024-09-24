
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
    "disableMountSubPath",
    "emptyDir",
    "ephemeral",
    "volumeClaimTemplate"
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
public class ThanosRulerSpecStorage implements Editable<ThanosRulerSpecStorageBuilder> , KubernetesResource
{

    @JsonProperty("disableMountSubPath")
    private Boolean disableMountSubPath;
    @JsonProperty("emptyDir")
    private ThanosRulerSpecSEmptyDir emptyDir;
    @JsonProperty("ephemeral")
    private ThanosRulerSpecSEphemeral ephemeral;
    @JsonProperty("volumeClaimTemplate")
    private ThanosRulerSpecSVolumeClaimTemplate volumeClaimTemplate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ThanosRulerSpecStorage() {
    }

    public ThanosRulerSpecStorage(Boolean disableMountSubPath, ThanosRulerSpecSEmptyDir emptyDir, ThanosRulerSpecSEphemeral ephemeral, ThanosRulerSpecSVolumeClaimTemplate volumeClaimTemplate) {
        super();
        this.disableMountSubPath = disableMountSubPath;
        this.emptyDir = emptyDir;
        this.ephemeral = ephemeral;
        this.volumeClaimTemplate = volumeClaimTemplate;
    }

    @JsonProperty("disableMountSubPath")
    public Boolean getDisableMountSubPath() {
        return disableMountSubPath;
    }

    @JsonProperty("disableMountSubPath")
    public void setDisableMountSubPath(Boolean disableMountSubPath) {
        this.disableMountSubPath = disableMountSubPath;
    }

    @JsonProperty("emptyDir")
    public ThanosRulerSpecSEmptyDir getEmptyDir() {
        return emptyDir;
    }

    @JsonProperty("emptyDir")
    public void setEmptyDir(ThanosRulerSpecSEmptyDir emptyDir) {
        this.emptyDir = emptyDir;
    }

    @JsonProperty("ephemeral")
    public ThanosRulerSpecSEphemeral getEphemeral() {
        return ephemeral;
    }

    @JsonProperty("ephemeral")
    public void setEphemeral(ThanosRulerSpecSEphemeral ephemeral) {
        this.ephemeral = ephemeral;
    }

    @JsonProperty("volumeClaimTemplate")
    public ThanosRulerSpecSVolumeClaimTemplate getVolumeClaimTemplate() {
        return volumeClaimTemplate;
    }

    @JsonProperty("volumeClaimTemplate")
    public void setVolumeClaimTemplate(ThanosRulerSpecSVolumeClaimTemplate volumeClaimTemplate) {
        this.volumeClaimTemplate = volumeClaimTemplate;
    }

    @JsonIgnore
    public ThanosRulerSpecStorageBuilder edit() {
        return new ThanosRulerSpecStorageBuilder(this);
    }

    @JsonIgnore
    public ThanosRulerSpecStorageBuilder toBuilder() {
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
