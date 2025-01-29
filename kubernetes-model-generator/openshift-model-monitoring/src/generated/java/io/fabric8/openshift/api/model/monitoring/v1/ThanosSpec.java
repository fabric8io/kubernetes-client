
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

/**
 * ThanosSpec defines the configuration of the Thanos sidecar.
 */
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
public class ThanosSpec implements Editable<ThanosSpecBuilder>, KubernetesResource
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

    /**
     * AdditionalArgs allows setting additional arguments for the Thanos container. The arguments are passed as-is to the Thanos container which may cause issues if they are invalid or not supported the given Thanos version. In case of an argument conflict (e.g. an argument which is already set by the operator itself) or when providing an invalid argument, the reconciliation will fail and an error will be logged.
     */
    @JsonProperty("additionalArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Argument> getAdditionalArgs() {
        return additionalArgs;
    }

    /**
     * AdditionalArgs allows setting additional arguments for the Thanos container. The arguments are passed as-is to the Thanos container which may cause issues if they are invalid or not supported the given Thanos version. In case of an argument conflict (e.g. an argument which is already set by the operator itself) or when providing an invalid argument, the reconciliation will fail and an error will be logged.
     */
    @JsonProperty("additionalArgs")
    public void setAdditionalArgs(List<Argument> additionalArgs) {
        this.additionalArgs = additionalArgs;
    }

    /**
     * Deprecated: use 'image' instead.
     */
    @JsonProperty("baseImage")
    public String getBaseImage() {
        return baseImage;
    }

    /**
     * Deprecated: use 'image' instead.
     */
    @JsonProperty("baseImage")
    public void setBaseImage(String baseImage) {
        this.baseImage = baseImage;
    }

    /**
     * BlockDuration controls the size of TSDB blocks produced by Prometheus. The default value is 2h to match the upstream Prometheus defaults.<br><p> <br><p> WARNING: Changing the block duration can impact the performance and efficiency of the entire Prometheus/Thanos stack due to how it interacts with memory and Thanos compactors. It is recommended to keep this value set to a multiple of 120 times your longest scrape or rule interval. For example, 30s &#42; 120 = 1h.
     */
    @JsonProperty("blockSize")
    public String getBlockSize() {
        return blockSize;
    }

    /**
     * BlockDuration controls the size of TSDB blocks produced by Prometheus. The default value is 2h to match the upstream Prometheus defaults.<br><p> <br><p> WARNING: Changing the block duration can impact the performance and efficiency of the entire Prometheus/Thanos stack due to how it interacts with memory and Thanos compactors. It is recommended to keep this value set to a multiple of 120 times your longest scrape or rule interval. For example, 30s &#42; 120 = 1h.
     */
    @JsonProperty("blockSize")
    public void setBlockSize(String blockSize) {
        this.blockSize = blockSize;
    }

    /**
     * How often to retrieve the Prometheus configuration.
     */
    @JsonProperty("getConfigInterval")
    public String getGetConfigInterval() {
        return getConfigInterval;
    }

    /**
     * How often to retrieve the Prometheus configuration.
     */
    @JsonProperty("getConfigInterval")
    public void setGetConfigInterval(String getConfigInterval) {
        this.getConfigInterval = getConfigInterval;
    }

    /**
     * Maximum time to wait when retrieving the Prometheus configuration.
     */
    @JsonProperty("getConfigTimeout")
    public String getGetConfigTimeout() {
        return getConfigTimeout;
    }

    /**
     * Maximum time to wait when retrieving the Prometheus configuration.
     */
    @JsonProperty("getConfigTimeout")
    public void setGetConfigTimeout(String getConfigTimeout) {
        this.getConfigTimeout = getConfigTimeout;
    }

    /**
     * When true, the Thanos sidecar listens on the loopback interface instead of the Pod IP's address for the gRPC endpoints.<br><p> <br><p> It has no effect if `listenLocal` is true.
     */
    @JsonProperty("grpcListenLocal")
    public Boolean getGrpcListenLocal() {
        return grpcListenLocal;
    }

    /**
     * When true, the Thanos sidecar listens on the loopback interface instead of the Pod IP's address for the gRPC endpoints.<br><p> <br><p> It has no effect if `listenLocal` is true.
     */
    @JsonProperty("grpcListenLocal")
    public void setGrpcListenLocal(Boolean grpcListenLocal) {
        this.grpcListenLocal = grpcListenLocal;
    }

    /**
     * ThanosSpec defines the configuration of the Thanos sidecar.
     */
    @JsonProperty("grpcServerTlsConfig")
    public TLSConfig getGrpcServerTlsConfig() {
        return grpcServerTlsConfig;
    }

    /**
     * ThanosSpec defines the configuration of the Thanos sidecar.
     */
    @JsonProperty("grpcServerTlsConfig")
    public void setGrpcServerTlsConfig(TLSConfig grpcServerTlsConfig) {
        this.grpcServerTlsConfig = grpcServerTlsConfig;
    }

    /**
     * When true, the Thanos sidecar listens on the loopback interface instead of the Pod IP's address for the HTTP endpoints.<br><p> <br><p> It has no effect if `listenLocal` is true.
     */
    @JsonProperty("httpListenLocal")
    public Boolean getHttpListenLocal() {
        return httpListenLocal;
    }

    /**
     * When true, the Thanos sidecar listens on the loopback interface instead of the Pod IP's address for the HTTP endpoints.<br><p> <br><p> It has no effect if `listenLocal` is true.
     */
    @JsonProperty("httpListenLocal")
    public void setHttpListenLocal(Boolean httpListenLocal) {
        this.httpListenLocal = httpListenLocal;
    }

    /**
     * Container image name for Thanos. If specified, it takes precedence over the `spec.thanos.baseImage`, `spec.thanos.tag` and `spec.thanos.sha` fields.<br><p> <br><p> Specifying `spec.thanos.version` is still necessary to ensure the Prometheus Operator knows which version of Thanos is being configured.<br><p> <br><p> If neither `spec.thanos.image` nor `spec.thanos.baseImage` are defined, the operator will use the latest upstream version of Thanos available at the time when the operator was released.
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * Container image name for Thanos. If specified, it takes precedence over the `spec.thanos.baseImage`, `spec.thanos.tag` and `spec.thanos.sha` fields.<br><p> <br><p> Specifying `spec.thanos.version` is still necessary to ensure the Prometheus Operator knows which version of Thanos is being configured.<br><p> <br><p> If neither `spec.thanos.image` nor `spec.thanos.baseImage` are defined, the operator will use the latest upstream version of Thanos available at the time when the operator was released.
     */
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Deprecated: use `grpcListenLocal` and `httpListenLocal` instead.
     */
    @JsonProperty("listenLocal")
    public Boolean getListenLocal() {
        return listenLocal;
    }

    /**
     * Deprecated: use `grpcListenLocal` and `httpListenLocal` instead.
     */
    @JsonProperty("listenLocal")
    public void setListenLocal(Boolean listenLocal) {
        this.listenLocal = listenLocal;
    }

    /**
     * Log format for the Thanos sidecar.
     */
    @JsonProperty("logFormat")
    public String getLogFormat() {
        return logFormat;
    }

    /**
     * Log format for the Thanos sidecar.
     */
    @JsonProperty("logFormat")
    public void setLogFormat(String logFormat) {
        this.logFormat = logFormat;
    }

    /**
     * Log level for the Thanos sidecar.
     */
    @JsonProperty("logLevel")
    public String getLogLevel() {
        return logLevel;
    }

    /**
     * Log level for the Thanos sidecar.
     */
    @JsonProperty("logLevel")
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * Defines the start of time range limit served by the Thanos sidecar's StoreAPI. The field's value should be a constant time in RFC3339 format or a time duration relative to current time, such as -1d or 2h45m. Valid duration units are ms, s, m, h, d, w, y.
     */
    @JsonProperty("minTime")
    public String getMinTime() {
        return minTime;
    }

    /**
     * Defines the start of time range limit served by the Thanos sidecar's StoreAPI. The field's value should be a constant time in RFC3339 format or a time duration relative to current time, such as -1d or 2h45m. Valid duration units are ms, s, m, h, d, w, y.
     */
    @JsonProperty("minTime")
    public void setMinTime(String minTime) {
        this.minTime = minTime;
    }

    /**
     * ThanosSpec defines the configuration of the Thanos sidecar.
     */
    @JsonProperty("objectStorageConfig")
    public SecretKeySelector getObjectStorageConfig() {
        return objectStorageConfig;
    }

    /**
     * ThanosSpec defines the configuration of the Thanos sidecar.
     */
    @JsonProperty("objectStorageConfig")
    public void setObjectStorageConfig(SecretKeySelector objectStorageConfig) {
        this.objectStorageConfig = objectStorageConfig;
    }

    /**
     * Defines the Thanos sidecar's configuration file to upload TSDB blocks to object storage.<br><p> <br><p> More info: https://thanos.io/tip/thanos/storage.md/<br><p> <br><p> This field takes precedence over objectStorageConfig.
     */
    @JsonProperty("objectStorageConfigFile")
    public String getObjectStorageConfigFile() {
        return objectStorageConfigFile;
    }

    /**
     * Defines the Thanos sidecar's configuration file to upload TSDB blocks to object storage.<br><p> <br><p> More info: https://thanos.io/tip/thanos/storage.md/<br><p> <br><p> This field takes precedence over objectStorageConfig.
     */
    @JsonProperty("objectStorageConfigFile")
    public void setObjectStorageConfigFile(String objectStorageConfigFile) {
        this.objectStorageConfigFile = objectStorageConfigFile;
    }

    /**
     * ReadyTimeout is the maximum time that the Thanos sidecar will wait for Prometheus to start.
     */
    @JsonProperty("readyTimeout")
    public String getReadyTimeout() {
        return readyTimeout;
    }

    /**
     * ReadyTimeout is the maximum time that the Thanos sidecar will wait for Prometheus to start.
     */
    @JsonProperty("readyTimeout")
    public void setReadyTimeout(String readyTimeout) {
        this.readyTimeout = readyTimeout;
    }

    /**
     * ThanosSpec defines the configuration of the Thanos sidecar.
     */
    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

    /**
     * ThanosSpec defines the configuration of the Thanos sidecar.
     */
    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
        this.resources = resources;
    }

    /**
     * Deprecated: use 'image' instead.  The image digest can be specified as part of the image name.
     */
    @JsonProperty("sha")
    public String getSha() {
        return sha;
    }

    /**
     * Deprecated: use 'image' instead.  The image digest can be specified as part of the image name.
     */
    @JsonProperty("sha")
    public void setSha(String sha) {
        this.sha = sha;
    }

    /**
     * Deprecated: use 'image' instead. The image's tag can be specified as as part of the image name.
     */
    @JsonProperty("tag")
    public String getTag() {
        return tag;
    }

    /**
     * Deprecated: use 'image' instead. The image's tag can be specified as as part of the image name.
     */
    @JsonProperty("tag")
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * ThanosSpec defines the configuration of the Thanos sidecar.
     */
    @JsonProperty("tracingConfig")
    public SecretKeySelector getTracingConfig() {
        return tracingConfig;
    }

    /**
     * ThanosSpec defines the configuration of the Thanos sidecar.
     */
    @JsonProperty("tracingConfig")
    public void setTracingConfig(SecretKeySelector tracingConfig) {
        this.tracingConfig = tracingConfig;
    }

    /**
     * Defines the tracing configuration file for the Thanos sidecar.<br><p> <br><p> This field takes precedence over `tracingConfig`.<br><p> <br><p> More info: https://thanos.io/tip/thanos/tracing.md/<br><p> <br><p> This is an &#42;experimental feature&#42;, it may change in any upcoming release in a breaking way.
     */
    @JsonProperty("tracingConfigFile")
    public String getTracingConfigFile() {
        return tracingConfigFile;
    }

    /**
     * Defines the tracing configuration file for the Thanos sidecar.<br><p> <br><p> This field takes precedence over `tracingConfig`.<br><p> <br><p> More info: https://thanos.io/tip/thanos/tracing.md/<br><p> <br><p> This is an &#42;experimental feature&#42;, it may change in any upcoming release in a breaking way.
     */
    @JsonProperty("tracingConfigFile")
    public void setTracingConfigFile(String tracingConfigFile) {
        this.tracingConfigFile = tracingConfigFile;
    }

    /**
     * Version of Thanos being deployed. The operator uses this information to generate the Prometheus StatefulSet + configuration files.<br><p> <br><p> If not specified, the operator assumes the latest upstream release of Thanos available at the time when the version of the operator was released.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * Version of Thanos being deployed. The operator uses this information to generate the Prometheus StatefulSet + configuration files.<br><p> <br><p> If not specified, the operator assumes the latest upstream release of Thanos available at the time when the version of the operator was released.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * VolumeMounts allows configuration of additional VolumeMounts for Thanos. VolumeMounts specified will be appended to other VolumeMounts in the 'thanos-sidecar' container.
     */
    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VolumeMount> getVolumeMounts() {
        return volumeMounts;
    }

    /**
     * VolumeMounts allows configuration of additional VolumeMounts for Thanos. VolumeMounts specified will be appended to other VolumeMounts in the 'thanos-sidecar' container.
     */
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
