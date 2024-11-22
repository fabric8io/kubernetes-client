
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.SecretKeySelector;
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
    "additionalArgs",
    "baseImage",
    "blockSize",
    "getConfigInterval",
    "getConfigTimeout",
    "grpcListenLocal",
    "grpcServerTlsConfig",
    "httpListenLocal",
    "image",
    "listenLocal",
    "logFormat",
    "logLevel",
    "minTime",
    "objectStorageConfig",
    "objectStorageConfigFile",
    "readyTimeout",
    "resources",
    "sha",
    "tag",
    "tracingConfig",
    "tracingConfigFile",
    "version",
    "volumeMounts"
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
public class ThanosSpec implements Editable<ThanosSpecBuilder> , KubernetesResource
{

    @JsonProperty("additionalArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Argument> additionalArgs = new ArrayList<>();
    @JsonProperty("baseImage")
    private String baseImage;
    @JsonProperty("blockSize")
    private String blockSize;
    @JsonProperty("getConfigInterval")
    private String getConfigInterval;
    @JsonProperty("getConfigTimeout")
    private String getConfigTimeout;
    @JsonProperty("grpcListenLocal")
    private Boolean grpcListenLocal;
    @JsonProperty("grpcServerTlsConfig")
    private TLSConfig grpcServerTlsConfig;
    @JsonProperty("httpListenLocal")
    private Boolean httpListenLocal;
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
    @JsonProperty("objectStorageConfigFile")
    private String objectStorageConfigFile;
    @JsonProperty("readyTimeout")
    private String readyTimeout;
    @JsonProperty("resources")
    private ResourceRequirements resources;
    @JsonProperty("sha")
    private String sha;
    @JsonProperty("tag")
    private String tag;
    @JsonProperty("tracingConfig")
    private SecretKeySelector tracingConfig;
    @JsonProperty("tracingConfigFile")
    private String tracingConfigFile;
    @JsonProperty("version")
    private String version;
    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VolumeMount> volumeMounts = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ThanosSpec() {
    }

    public ThanosSpec(List<Argument> additionalArgs, String baseImage, String blockSize, String getConfigInterval, String getConfigTimeout, Boolean grpcListenLocal, TLSConfig grpcServerTlsConfig, Boolean httpListenLocal, String image, Boolean listenLocal, String logFormat, String logLevel, String minTime, SecretKeySelector objectStorageConfig, String objectStorageConfigFile, String readyTimeout, ResourceRequirements resources, String sha, String tag, SecretKeySelector tracingConfig, String tracingConfigFile, String version, List<VolumeMount> volumeMounts) {
        super();
        this.additionalArgs = additionalArgs;
        this.baseImage = baseImage;
        this.blockSize = blockSize;
        this.getConfigInterval = getConfigInterval;
        this.getConfigTimeout = getConfigTimeout;
        this.grpcListenLocal = grpcListenLocal;
        this.grpcServerTlsConfig = grpcServerTlsConfig;
        this.httpListenLocal = httpListenLocal;
        this.image = image;
        this.listenLocal = listenLocal;
        this.logFormat = logFormat;
        this.logLevel = logLevel;
        this.minTime = minTime;
        this.objectStorageConfig = objectStorageConfig;
        this.objectStorageConfigFile = objectStorageConfigFile;
        this.readyTimeout = readyTimeout;
        this.resources = resources;
        this.sha = sha;
        this.tag = tag;
        this.tracingConfig = tracingConfig;
        this.tracingConfigFile = tracingConfigFile;
        this.version = version;
        this.volumeMounts = volumeMounts;
    }

    @JsonProperty("additionalArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Argument> getAdditionalArgs() {
        return additionalArgs;
    }

    @JsonProperty("additionalArgs")
    public void setAdditionalArgs(List<Argument> additionalArgs) {
        this.additionalArgs = additionalArgs;
    }

    @JsonProperty("baseImage")
    public String getBaseImage() {
        return baseImage;
    }

    @JsonProperty("baseImage")
    public void setBaseImage(String baseImage) {
        this.baseImage = baseImage;
    }

    @JsonProperty("blockSize")
    public String getBlockSize() {
        return blockSize;
    }

    @JsonProperty("blockSize")
    public void setBlockSize(String blockSize) {
        this.blockSize = blockSize;
    }

    @JsonProperty("getConfigInterval")
    public String getGetConfigInterval() {
        return getConfigInterval;
    }

    @JsonProperty("getConfigInterval")
    public void setGetConfigInterval(String getConfigInterval) {
        this.getConfigInterval = getConfigInterval;
    }

    @JsonProperty("getConfigTimeout")
    public String getGetConfigTimeout() {
        return getConfigTimeout;
    }

    @JsonProperty("getConfigTimeout")
    public void setGetConfigTimeout(String getConfigTimeout) {
        this.getConfigTimeout = getConfigTimeout;
    }

    @JsonProperty("grpcListenLocal")
    public Boolean getGrpcListenLocal() {
        return grpcListenLocal;
    }

    @JsonProperty("grpcListenLocal")
    public void setGrpcListenLocal(Boolean grpcListenLocal) {
        this.grpcListenLocal = grpcListenLocal;
    }

    @JsonProperty("grpcServerTlsConfig")
    public TLSConfig getGrpcServerTlsConfig() {
        return grpcServerTlsConfig;
    }

    @JsonProperty("grpcServerTlsConfig")
    public void setGrpcServerTlsConfig(TLSConfig grpcServerTlsConfig) {
        this.grpcServerTlsConfig = grpcServerTlsConfig;
    }

    @JsonProperty("httpListenLocal")
    public Boolean getHttpListenLocal() {
        return httpListenLocal;
    }

    @JsonProperty("httpListenLocal")
    public void setHttpListenLocal(Boolean httpListenLocal) {
        this.httpListenLocal = httpListenLocal;
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

    @JsonProperty("objectStorageConfigFile")
    public String getObjectStorageConfigFile() {
        return objectStorageConfigFile;
    }

    @JsonProperty("objectStorageConfigFile")
    public void setObjectStorageConfigFile(String objectStorageConfigFile) {
        this.objectStorageConfigFile = objectStorageConfigFile;
    }

    @JsonProperty("readyTimeout")
    public String getReadyTimeout() {
        return readyTimeout;
    }

    @JsonProperty("readyTimeout")
    public void setReadyTimeout(String readyTimeout) {
        this.readyTimeout = readyTimeout;
    }

    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
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

    @JsonProperty("tracingConfigFile")
    public String getTracingConfigFile() {
        return tracingConfigFile;
    }

    @JsonProperty("tracingConfigFile")
    public void setTracingConfigFile(String tracingConfigFile) {
        this.tracingConfigFile = tracingConfigFile;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VolumeMount> getVolumeMounts() {
        return volumeMounts;
    }

    @JsonProperty("volumeMounts")
    public void setVolumeMounts(List<VolumeMount> volumeMounts) {
        this.volumeMounts = volumeMounts;
    }

    @JsonIgnore
    public ThanosSpecBuilder edit() {
        return new ThanosSpecBuilder(this);
    }

    @JsonIgnore
    public ThanosSpecBuilder toBuilder() {
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
