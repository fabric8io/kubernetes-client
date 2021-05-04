
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "baseImage",
    "grpcServerTlsConfig",
    "image",
    "listenLocal",
    "logFormat",
    "logLevel",
    "minTime",
    "objectStorageConfig",
    "resources",
    "sha",
    "tag",
    "tracingConfig",
    "version"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class ThanosSpec implements KubernetesResource
{

    @JsonProperty("baseImage")
    private String baseImage;
    @JsonProperty("grpcServerTlsConfig")
    private TLSConfig grpcServerTlsConfig;
    @JsonProperty("image")
    private String image;
    @JsonProperty("listenLocal")
    private Boolean listenLocal;
    @JsonProperty("logFormat")
    private String logFormat;
    @JsonProperty("logLevel")
    private String logLevel;
    @JsonProperty("minTime")
    private String minTime;
    @JsonProperty("objectStorageConfig")
    private SecretKeySelector objectStorageConfig;
    @JsonProperty("resources")
    private io.fabric8.kubernetes.api.model.ResourceRequirements resources;
    @JsonProperty("sha")
    private String sha;
    @JsonProperty("tag")
    private String tag;
    @JsonProperty("tracingConfig")
    private SecretKeySelector tracingConfig;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ThanosSpec() {
    }

    /**
     * 
     * @param image
     * @param tracingConfig
     * @param baseImage
     * @param resources
     * @param listenLocal
     * @param grpcServerTlsConfig
     * @param sha
     * @param version
     * @param logFormat
     * @param objectStorageConfig
     * @param logLevel
     * @param minTime
     * @param tag
     */
    public ThanosSpec(String baseImage, TLSConfig grpcServerTlsConfig, String image, Boolean listenLocal, String logFormat, String logLevel, String minTime, SecretKeySelector objectStorageConfig, io.fabric8.kubernetes.api.model.ResourceRequirements resources, String sha, String tag, SecretKeySelector tracingConfig, String version) {
        super();
        this.baseImage = baseImage;
        this.grpcServerTlsConfig = grpcServerTlsConfig;
        this.image = image;
        this.listenLocal = listenLocal;
        this.logFormat = logFormat;
        this.logLevel = logLevel;
        this.minTime = minTime;
        this.objectStorageConfig = objectStorageConfig;
        this.resources = resources;
        this.sha = sha;
        this.tag = tag;
        this.tracingConfig = tracingConfig;
        this.version = version;
    }

    @JsonProperty("baseImage")
    public String getBaseImage() {
        return baseImage;
    }

    @JsonProperty("baseImage")
    public void setBaseImage(String baseImage) {
        this.baseImage = baseImage;
    }

    @JsonProperty("grpcServerTlsConfig")
    public TLSConfig getGrpcServerTlsConfig() {
        return grpcServerTlsConfig;
    }

    @JsonProperty("grpcServerTlsConfig")
    public void setGrpcServerTlsConfig(TLSConfig grpcServerTlsConfig) {
        this.grpcServerTlsConfig = grpcServerTlsConfig;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("listenLocal")
    public Boolean getListenLocal() {
        return listenLocal;
    }

    @JsonProperty("listenLocal")
    public void setListenLocal(Boolean listenLocal) {
        this.listenLocal = listenLocal;
    }

    @JsonProperty("logFormat")
    public String getLogFormat() {
        return logFormat;
    }

    @JsonProperty("logFormat")
    public void setLogFormat(String logFormat) {
        this.logFormat = logFormat;
    }

    @JsonProperty("logLevel")
    public String getLogLevel() {
        return logLevel;
    }

    @JsonProperty("logLevel")
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    @JsonProperty("minTime")
    public String getMinTime() {
        return minTime;
    }

    @JsonProperty("minTime")
    public void setMinTime(String minTime) {
        this.minTime = minTime;
    }

    @JsonProperty("objectStorageConfig")
    public SecretKeySelector getObjectStorageConfig() {
        return objectStorageConfig;
    }

    @JsonProperty("objectStorageConfig")
    public void setObjectStorageConfig(SecretKeySelector objectStorageConfig) {
        this.objectStorageConfig = objectStorageConfig;
    }

    @JsonProperty("resources")
    public io.fabric8.kubernetes.api.model.ResourceRequirements getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(io.fabric8.kubernetes.api.model.ResourceRequirements resources) {
        this.resources = resources;
    }

    @JsonProperty("sha")
    public String getSha() {
        return sha;
    }

    @JsonProperty("sha")
    public void setSha(String sha) {
        this.sha = sha;
    }

    @JsonProperty("tag")
    public String getTag() {
        return tag;
    }

    @JsonProperty("tag")
    public void setTag(String tag) {
        this.tag = tag;
    }

    @JsonProperty("tracingConfig")
    public SecretKeySelector getTracingConfig() {
        return tracingConfig;
    }

    @JsonProperty("tracingConfig")
    public void setTracingConfig(SecretKeySelector tracingConfig) {
        this.tracingConfig = tracingConfig;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
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
