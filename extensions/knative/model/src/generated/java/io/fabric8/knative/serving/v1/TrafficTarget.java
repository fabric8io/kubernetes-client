
package io.fabric8.knative.serving.v1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "configurationName",
    "latestRevision",
    "percent",
    "revisionName",
    "tag",
    "url"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class TrafficTarget implements KubernetesResource
{

    @JsonProperty("configurationName")
    private String configurationName;
    @JsonProperty("latestRevision")
    private Boolean latestRevision;
    @JsonProperty("percent")
    private Long percent;
    @JsonProperty("revisionName")
    private String revisionName;
    @JsonProperty("tag")
    private String tag;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TrafficTarget() {
    }

    /**
     * 
     * @param revisionName
     * @param configurationName
     * @param tag
     * @param latestRevision
     * @param percent
     * @param url
     */
    public TrafficTarget(String configurationName, Boolean latestRevision, Long percent, String revisionName, String tag, String url) {
        super();
        this.configurationName = configurationName;
        this.latestRevision = latestRevision;
        this.percent = percent;
        this.revisionName = revisionName;
        this.tag = tag;
        this.url = url;
    }

    @JsonProperty("configurationName")
    public String getConfigurationName() {
        return configurationName;
    }

    @JsonProperty("configurationName")
    public void setConfigurationName(String configurationName) {
        this.configurationName = configurationName;
    }

    @JsonProperty("latestRevision")
    public Boolean getLatestRevision() {
        return latestRevision;
    }

    @JsonProperty("latestRevision")
    public void setLatestRevision(Boolean latestRevision) {
        this.latestRevision = latestRevision;
    }

    @JsonProperty("percent")
    public Long getPercent() {
        return percent;
    }

    @JsonProperty("percent")
    public void setPercent(Long percent) {
        this.percent = percent;
    }

    @JsonProperty("revisionName")
    public String getRevisionName() {
        return revisionName;
    }

    @JsonProperty("revisionName")
    public void setRevisionName(String revisionName) {
        this.revisionName = revisionName;
    }

    @JsonProperty("tag")
    public String getTag() {
        return tag;
    }

    @JsonProperty("tag")
    public void setTag(String tag) {
        this.tag = tag;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
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
