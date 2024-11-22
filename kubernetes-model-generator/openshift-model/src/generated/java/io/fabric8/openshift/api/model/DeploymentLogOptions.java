
package io.fabric8.openshift.api.model;

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
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "container",
    "follow",
    "limitBytes",
    "nowait",
    "previous",
    "sinceSeconds",
    "sinceTime",
    "tailLines",
    "timestamps",
    "version"
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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1")
@Group("apps.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class DeploymentLogOptions implements Editable<DeploymentLogOptionsBuilder> , KubernetesResource, Namespaced
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private String apiVersion = "apps.openshift.io/v1";
    @JsonProperty("container")
    private String container;
    @JsonProperty("follow")
    private Boolean follow;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private String kind = "DeploymentLogOptions";
    @JsonProperty("limitBytes")
    private Long limitBytes;
    @JsonProperty("nowait")
    private Boolean nowait;
    @JsonProperty("previous")
    private Boolean previous;
    @JsonProperty("sinceSeconds")
    private Long sinceSeconds;
    @JsonProperty("sinceTime")
    private String sinceTime;
    @JsonProperty("tailLines")
    private Long tailLines;
    @JsonProperty("timestamps")
    private Boolean timestamps;
    @JsonProperty("version")
    private Long version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DeploymentLogOptions() {
    }

    public DeploymentLogOptions(String apiVersion, String container, Boolean follow, String kind, Long limitBytes, Boolean nowait, Boolean previous, Long sinceSeconds, String sinceTime, Long tailLines, Boolean timestamps, Long version) {
        super();
        this.apiVersion = apiVersion;
        this.container = container;
        this.follow = follow;
        this.kind = kind;
        this.limitBytes = limitBytes;
        this.nowait = nowait;
        this.previous = previous;
        this.sinceSeconds = sinceSeconds;
        this.sinceTime = sinceTime;
        this.tailLines = tailLines;
        this.timestamps = timestamps;
        this.version = version;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("container")
    public String getContainer() {
        return container;
    }

    @JsonProperty("container")
    public void setContainer(String container) {
        this.container = container;
    }

    @JsonProperty("follow")
    public Boolean getFollow() {
        return follow;
    }

    @JsonProperty("follow")
    public void setFollow(Boolean follow) {
        this.follow = follow;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("limitBytes")
    public Long getLimitBytes() {
        return limitBytes;
    }

    @JsonProperty("limitBytes")
    public void setLimitBytes(Long limitBytes) {
        this.limitBytes = limitBytes;
    }

    @JsonProperty("nowait")
    public Boolean getNowait() {
        return nowait;
    }

    @JsonProperty("nowait")
    public void setNowait(Boolean nowait) {
        this.nowait = nowait;
    }

    @JsonProperty("previous")
    public Boolean getPrevious() {
        return previous;
    }

    @JsonProperty("previous")
    public void setPrevious(Boolean previous) {
        this.previous = previous;
    }

    @JsonProperty("sinceSeconds")
    public Long getSinceSeconds() {
        return sinceSeconds;
    }

    @JsonProperty("sinceSeconds")
    public void setSinceSeconds(Long sinceSeconds) {
        this.sinceSeconds = sinceSeconds;
    }

    @JsonProperty("sinceTime")
    public String getSinceTime() {
        return sinceTime;
    }

    @JsonProperty("sinceTime")
    public void setSinceTime(String sinceTime) {
        this.sinceTime = sinceTime;
    }

    @JsonProperty("tailLines")
    public Long getTailLines() {
        return tailLines;
    }

    @JsonProperty("tailLines")
    public void setTailLines(Long tailLines) {
        this.tailLines = tailLines;
    }

    @JsonProperty("timestamps")
    public Boolean getTimestamps() {
        return timestamps;
    }

    @JsonProperty("timestamps")
    public void setTimestamps(Boolean timestamps) {
        this.timestamps = timestamps;
    }

    @JsonProperty("version")
    public Long getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Long version) {
        this.version = version;
    }

    @JsonIgnore
    public DeploymentLogOptionsBuilder edit() {
        return new DeploymentLogOptionsBuilder(this);
    }

    @JsonIgnore
    public DeploymentLogOptionsBuilder toBuilder() {
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
