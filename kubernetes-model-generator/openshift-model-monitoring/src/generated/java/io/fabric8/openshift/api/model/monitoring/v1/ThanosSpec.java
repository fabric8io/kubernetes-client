
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

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
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
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
    private GRPCServerTLSConfig grpcServerTlsConfig;
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

    public ThanosSpec(List<Argument> additionalArgs, String baseImage, String blockSize, String getConfigInterval, String getConfigTimeout, Boolean grpcListenLocal, GRPCServerTLSConfig grpcServerTlsConfig, Boolean httpListenLocal, String image, Boolean listenLocal, String logFormat, String logLevel, String minTime, SecretKeySelector objectStorageConfig, String objectStorageConfigFile, String readyTimeout, ResourceRequirements resources, String sha, String tag, SecretKeySelector tracingConfig, String tracingConfigFile, String version, List<VolumeMount> volumeMounts) {
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
     * additionalArgs allows setting additional arguments for the Thanos container. The arguments are passed as-is to the Thanos container which may cause issues if they are invalid or not supported the given Thanos version. In case of an argument conflict (e.g. an argument which is already set by the operator itself) or when providing an invalid argument, the reconciliation will fail and an error will be logged.
     */
    @JsonProperty("additionalArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Argument> getAdditionalArgs() {
        return additionalArgs;
    }

    /**
     * additionalArgs allows setting additional arguments for the Thanos container. The arguments are passed as-is to the Thanos container which may cause issues if they are invalid or not supported the given Thanos version. In case of an argument conflict (e.g. an argument which is already set by the operator itself) or when providing an invalid argument, the reconciliation will fail and an error will be logged.
     */
    @JsonProperty("additionalArgs")
    public void setAdditionalArgs(List<Argument> additionalArgs) {
        this.additionalArgs = additionalArgs;
    }

    /**
     * baseImage is deprecated: use 'image' instead.
     */
    @JsonProperty("baseImage")
    public String getBaseImage() {
        return baseImage;
    }

    /**
     * baseImage is deprecated: use 'image' instead.
     */
    @JsonProperty("baseImage")
    public void setBaseImage(String baseImage) {
        this.baseImage = baseImage;
    }

    /**
     * blockSize controls the size of TSDB blocks produced by Prometheus. The default value is 2h to match the upstream Prometheus defaults.<br><p> <br><p> WARNING: Changing the block duration can impact the performance and efficiency of the entire Prometheus/Thanos stack due to how it interacts with memory and Thanos compactors. It is recommended to keep this value set to a multiple of 120 times your longest scrape or rule interval. For example, 30s &#42; 120 = 1h.
     */
    @JsonProperty("blockSize")
    public String getBlockSize() {
        return blockSize;
    }

    /**
     * blockSize controls the size of TSDB blocks produced by Prometheus. The default value is 2h to match the upstream Prometheus defaults.<br><p> <br><p> WARNING: Changing the block duration can impact the performance and efficiency of the entire Prometheus/Thanos stack due to how it interacts with memory and Thanos compactors. It is recommended to keep this value set to a multiple of 120 times your longest scrape or rule interval. For example, 30s &#42; 120 = 1h.
     */
    @JsonProperty("blockSize")
    public void setBlockSize(String blockSize) {
        this.blockSize = blockSize;
    }

    /**
     * getConfigInterval defines how often to retrieve the Prometheus configuration.
     */
    @JsonProperty("getConfigInterval")
    public String getGetConfigInterval() {
        return getConfigInterval;
    }

    /**
     * getConfigInterval defines how often to retrieve the Prometheus configuration.
     */
    @JsonProperty("getConfigInterval")
    public void setGetConfigInterval(String getConfigInterval) {
        this.getConfigInterval = getConfigInterval;
    }

    /**
     * getConfigTimeout defines the maximum time to wait when retrieving the Prometheus configuration.
     */
    @JsonProperty("getConfigTimeout")
    public String getGetConfigTimeout() {
        return getConfigTimeout;
    }

    /**
     * getConfigTimeout defines the maximum time to wait when retrieving the Prometheus configuration.
     */
    @JsonProperty("getConfigTimeout")
    public void setGetConfigTimeout(String getConfigTimeout) {
        this.getConfigTimeout = getConfigTimeout;
    }

    /**
     * grpcListenLocal defines when true, the Thanos sidecar listens on the loopback interface instead of the Pod IP's address for the gRPC endpoints.<br><p> <br><p> It has no effect if `listenLocal` is true.
     */
    @JsonProperty("grpcListenLocal")
    public Boolean getGrpcListenLocal() {
        return grpcListenLocal;
    }

    /**
     * grpcListenLocal defines when true, the Thanos sidecar listens on the loopback interface instead of the Pod IP's address for the gRPC endpoints.<br><p> <br><p> It has no effect if `listenLocal` is true.
     */
    @JsonProperty("grpcListenLocal")
    public void setGrpcListenLocal(Boolean grpcListenLocal) {
        this.grpcListenLocal = grpcListenLocal;
    }

    /**
     * ThanosSpec defines the configuration of the Thanos sidecar.
     */
    @JsonProperty("grpcServerTlsConfig")
    public GRPCServerTLSConfig getGrpcServerTlsConfig() {
        return grpcServerTlsConfig;
    }

    /**
     * ThanosSpec defines the configuration of the Thanos sidecar.
     */
    @JsonProperty("grpcServerTlsConfig")
    public void setGrpcServerTlsConfig(GRPCServerTLSConfig grpcServerTlsConfig) {
        this.grpcServerTlsConfig = grpcServerTlsConfig;
    }

    /**
     * httpListenLocal when true, the Thanos sidecar listens on the loopback interface instead of the Pod IP's address for the HTTP endpoints.<br><p> <br><p> It has no effect if `listenLocal` is true.
     */
    @JsonProperty("httpListenLocal")
    public Boolean getHttpListenLocal() {
        return httpListenLocal;
    }

    /**
     * httpListenLocal when true, the Thanos sidecar listens on the loopback interface instead of the Pod IP's address for the HTTP endpoints.<br><p> <br><p> It has no effect if `listenLocal` is true.
     */
    @JsonProperty("httpListenLocal")
    public void setHttpListenLocal(Boolean httpListenLocal) {
        this.httpListenLocal = httpListenLocal;
    }

    /**
     * image defines the container image name for Thanos. If specified, it takes precedence over the `spec.thanos.baseImage`, `spec.thanos.tag` and `spec.thanos.sha` fields.<br><p> <br><p> Specifying `spec.thanos.version` is still necessary to ensure the Prometheus Operator knows which version of Thanos is being configured.<br><p> <br><p> If neither `spec.thanos.image` nor `spec.thanos.baseImage` are defined, the operator will use the latest upstream version of Thanos available at the time when the operator was released.
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * image defines the container image name for Thanos. If specified, it takes precedence over the `spec.thanos.baseImage`, `spec.thanos.tag` and `spec.thanos.sha` fields.<br><p> <br><p> Specifying `spec.thanos.version` is still necessary to ensure the Prometheus Operator knows which version of Thanos is being configured.<br><p> <br><p> If neither `spec.thanos.image` nor `spec.thanos.baseImage` are defined, the operator will use the latest upstream version of Thanos available at the time when the operator was released.
     */
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * listenLocal is deprecated: use `grpcListenLocal` and `httpListenLocal` instead.
     */
    @JsonProperty("listenLocal")
    public Boolean getListenLocal() {
        return listenLocal;
    }

    /**
     * listenLocal is deprecated: use `grpcListenLocal` and `httpListenLocal` instead.
     */
    @JsonProperty("listenLocal")
    public void setListenLocal(Boolean listenLocal) {
        this.listenLocal = listenLocal;
    }

    /**
     * logFormat for the Thanos sidecar.
     */
    @JsonProperty("logFormat")
    public String getLogFormat() {
        return logFormat;
    }

    /**
     * logFormat for the Thanos sidecar.
     */
    @JsonProperty("logFormat")
    public void setLogFormat(String logFormat) {
        this.logFormat = logFormat;
    }

    /**
     * logLevel for the Thanos sidecar.
     */
    @JsonProperty("logLevel")
    public String getLogLevel() {
        return logLevel;
    }

    /**
     * logLevel for the Thanos sidecar.
     */
    @JsonProperty("logLevel")
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * minTime defines the start of time range limit served by the Thanos sidecar's StoreAPI. The field's value should be a constant time in RFC3339 format or a time duration relative to current time, such as -1d or 2h45m. Valid duration units are ms, s, m, h, d, w, y.
     */
    @JsonProperty("minTime")
    public String getMinTime() {
        return minTime;
    }

    /**
     * minTime defines the start of time range limit served by the Thanos sidecar's StoreAPI. The field's value should be a constant time in RFC3339 format or a time duration relative to current time, such as -1d or 2h45m. Valid duration units are ms, s, m, h, d, w, y.
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
     * objectStorageConfigFile defines the Thanos sidecar's configuration file to upload TSDB blocks to object storage.<br><p> <br><p> More info: https://thanos.io/tip/thanos/storage.md/<br><p> <br><p> This field takes precedence over objectStorageConfig.
     */
    @JsonProperty("objectStorageConfigFile")
    public String getObjectStorageConfigFile() {
        return objectStorageConfigFile;
    }

    /**
     * objectStorageConfigFile defines the Thanos sidecar's configuration file to upload TSDB blocks to object storage.<br><p> <br><p> More info: https://thanos.io/tip/thanos/storage.md/<br><p> <br><p> This field takes precedence over objectStorageConfig.
     */
    @JsonProperty("objectStorageConfigFile")
    public void setObjectStorageConfigFile(String objectStorageConfigFile) {
        this.objectStorageConfigFile = objectStorageConfigFile;
    }

    /**
     * readyTimeout defines the maximum time that the Thanos sidecar will wait for Prometheus to start.
     */
    @JsonProperty("readyTimeout")
    public String getReadyTimeout() {
        return readyTimeout;
    }

    /**
     * readyTimeout defines the maximum time that the Thanos sidecar will wait for Prometheus to start.
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
     * sha is deprecated: use 'image' instead.  The image digest can be specified as part of the image name.
     */
    @JsonProperty("sha")
    public String getSha() {
        return sha;
    }

    /**
     * sha is deprecated: use 'image' instead.  The image digest can be specified as part of the image name.
     */
    @JsonProperty("sha")
    public void setSha(String sha) {
        this.sha = sha;
    }

    /**
     * tag is deprecated: use 'image' instead. The image's tag can be specified as as part of the image name.
     */
    @JsonProperty("tag")
    public String getTag() {
        return tag;
    }

    /**
     * tag is deprecated: use 'image' instead. The image's tag can be specified as as part of the image name.
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
     * tracingConfigFile defines the tracing configuration file for the Thanos sidecar.<br><p> <br><p> This field takes precedence over `tracingConfig`.<br><p> <br><p> More info: https://thanos.io/tip/thanos/tracing.md/<br><p> <br><p> This is an &#42;experimental feature&#42;, it may change in any upcoming release in a breaking way.
     */
    @JsonProperty("tracingConfigFile")
    public String getTracingConfigFile() {
        return tracingConfigFile;
    }

    /**
     * tracingConfigFile defines the tracing configuration file for the Thanos sidecar.<br><p> <br><p> This field takes precedence over `tracingConfig`.<br><p> <br><p> More info: https://thanos.io/tip/thanos/tracing.md/<br><p> <br><p> This is an &#42;experimental feature&#42;, it may change in any upcoming release in a breaking way.
     */
    @JsonProperty("tracingConfigFile")
    public void setTracingConfigFile(String tracingConfigFile) {
        this.tracingConfigFile = tracingConfigFile;
    }

    /**
     * version of Thanos being deployed. The operator uses this information to generate the Prometheus StatefulSet + configuration files.<br><p> <br><p> If not specified, the operator assumes the latest upstream release of Thanos available at the time when the version of the operator was released.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * version of Thanos being deployed. The operator uses this information to generate the Prometheus StatefulSet + configuration files.<br><p> <br><p> If not specified, the operator assumes the latest upstream release of Thanos available at the time when the version of the operator was released.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * volumeMounts allows configuration of additional VolumeMounts for Thanos. VolumeMounts specified will be appended to other VolumeMounts in the 'thanos-sidecar' container.
     */
    @JsonProperty("volumeMounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VolumeMount> getVolumeMounts() {
        return volumeMounts;
    }

    /**
     * volumeMounts allows configuration of additional VolumeMounts for Thanos. VolumeMounts specified will be appended to other VolumeMounts in the 'thanos-sidecar' container.
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ThanosSpec)) {
            return false;
        }
        ThanosSpec other = (ThanosSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$additionalArgs = this.getAdditionalArgs();
        Object other$additionalArgs = other.getAdditionalArgs();
        if (this$additionalArgs == null ? other$additionalArgs != null : !this$additionalArgs.equals(other$additionalArgs)) {
            return false;
        }
        Object this$baseImage = this.getBaseImage();
        Object other$baseImage = other.getBaseImage();
        if (this$baseImage == null ? other$baseImage != null : !this$baseImage.equals(other$baseImage)) {
            return false;
        }
        Object this$blockSize = this.getBlockSize();
        Object other$blockSize = other.getBlockSize();
        if (this$blockSize == null ? other$blockSize != null : !this$blockSize.equals(other$blockSize)) {
            return false;
        }
        Object this$getConfigInterval = this.getGetConfigInterval();
        Object other$getConfigInterval = other.getGetConfigInterval();
        if (this$getConfigInterval == null ? other$getConfigInterval != null : !this$getConfigInterval.equals(other$getConfigInterval)) {
            return false;
        }
        Object this$getConfigTimeout = this.getGetConfigTimeout();
        Object other$getConfigTimeout = other.getGetConfigTimeout();
        if (this$getConfigTimeout == null ? other$getConfigTimeout != null : !this$getConfigTimeout.equals(other$getConfigTimeout)) {
            return false;
        }
        Object this$grpcListenLocal = this.getGrpcListenLocal();
        Object other$grpcListenLocal = other.getGrpcListenLocal();
        if (this$grpcListenLocal == null ? other$grpcListenLocal != null : !this$grpcListenLocal.equals(other$grpcListenLocal)) {
            return false;
        }
        Object this$grpcServerTlsConfig = this.getGrpcServerTlsConfig();
        Object other$grpcServerTlsConfig = other.getGrpcServerTlsConfig();
        if (this$grpcServerTlsConfig == null ? other$grpcServerTlsConfig != null : !this$grpcServerTlsConfig.equals(other$grpcServerTlsConfig)) {
            return false;
        }
        Object this$httpListenLocal = this.getHttpListenLocal();
        Object other$httpListenLocal = other.getHttpListenLocal();
        if (this$httpListenLocal == null ? other$httpListenLocal != null : !this$httpListenLocal.equals(other$httpListenLocal)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
            return false;
        }
        Object this$listenLocal = this.getListenLocal();
        Object other$listenLocal = other.getListenLocal();
        if (this$listenLocal == null ? other$listenLocal != null : !this$listenLocal.equals(other$listenLocal)) {
            return false;
        }
        Object this$logFormat = this.getLogFormat();
        Object other$logFormat = other.getLogFormat();
        if (this$logFormat == null ? other$logFormat != null : !this$logFormat.equals(other$logFormat)) {
            return false;
        }
        Object this$logLevel = this.getLogLevel();
        Object other$logLevel = other.getLogLevel();
        if (this$logLevel == null ? other$logLevel != null : !this$logLevel.equals(other$logLevel)) {
            return false;
        }
        Object this$minTime = this.getMinTime();
        Object other$minTime = other.getMinTime();
        if (this$minTime == null ? other$minTime != null : !this$minTime.equals(other$minTime)) {
            return false;
        }
        Object this$objectStorageConfig = this.getObjectStorageConfig();
        Object other$objectStorageConfig = other.getObjectStorageConfig();
        if (this$objectStorageConfig == null ? other$objectStorageConfig != null : !this$objectStorageConfig.equals(other$objectStorageConfig)) {
            return false;
        }
        Object this$objectStorageConfigFile = this.getObjectStorageConfigFile();
        Object other$objectStorageConfigFile = other.getObjectStorageConfigFile();
        if (this$objectStorageConfigFile == null ? other$objectStorageConfigFile != null : !this$objectStorageConfigFile.equals(other$objectStorageConfigFile)) {
            return false;
        }
        Object this$readyTimeout = this.getReadyTimeout();
        Object other$readyTimeout = other.getReadyTimeout();
        if (this$readyTimeout == null ? other$readyTimeout != null : !this$readyTimeout.equals(other$readyTimeout)) {
            return false;
        }
        Object this$resources = this.getResources();
        Object other$resources = other.getResources();
        if (this$resources == null ? other$resources != null : !this$resources.equals(other$resources)) {
            return false;
        }
        Object this$sha = this.getSha();
        Object other$sha = other.getSha();
        if (this$sha == null ? other$sha != null : !this$sha.equals(other$sha)) {
            return false;
        }
        Object this$tag = this.getTag();
        Object other$tag = other.getTag();
        if (this$tag == null ? other$tag != null : !this$tag.equals(other$tag)) {
            return false;
        }
        Object this$tracingConfig = this.getTracingConfig();
        Object other$tracingConfig = other.getTracingConfig();
        if (this$tracingConfig == null ? other$tracingConfig != null : !this$tracingConfig.equals(other$tracingConfig)) {
            return false;
        }
        Object this$tracingConfigFile = this.getTracingConfigFile();
        Object other$tracingConfigFile = other.getTracingConfigFile();
        if (this$tracingConfigFile == null ? other$tracingConfigFile != null : !this$tracingConfigFile.equals(other$tracingConfigFile)) {
            return false;
        }
        Object this$version = this.getVersion();
        Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
            return false;
        }
        Object this$volumeMounts = this.getVolumeMounts();
        Object other$volumeMounts = other.getVolumeMounts();
        if (this$volumeMounts == null ? other$volumeMounts != null : !this$volumeMounts.equals(other$volumeMounts)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ThanosSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $additionalArgs = this.getAdditionalArgs();
        result = result * prime + ($additionalArgs == null ? 43 : $additionalArgs.hashCode());
        Object $baseImage = this.getBaseImage();
        result = result * prime + ($baseImage == null ? 43 : $baseImage.hashCode());
        Object $blockSize = this.getBlockSize();
        result = result * prime + ($blockSize == null ? 43 : $blockSize.hashCode());
        Object $getConfigInterval = this.getGetConfigInterval();
        result = result * prime + ($getConfigInterval == null ? 43 : $getConfigInterval.hashCode());
        Object $getConfigTimeout = this.getGetConfigTimeout();
        result = result * prime + ($getConfigTimeout == null ? 43 : $getConfigTimeout.hashCode());
        Object $grpcListenLocal = this.getGrpcListenLocal();
        result = result * prime + ($grpcListenLocal == null ? 43 : $grpcListenLocal.hashCode());
        Object $grpcServerTlsConfig = this.getGrpcServerTlsConfig();
        result = result * prime + ($grpcServerTlsConfig == null ? 43 : $grpcServerTlsConfig.hashCode());
        Object $httpListenLocal = this.getHttpListenLocal();
        result = result * prime + ($httpListenLocal == null ? 43 : $httpListenLocal.hashCode());
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $listenLocal = this.getListenLocal();
        result = result * prime + ($listenLocal == null ? 43 : $listenLocal.hashCode());
        Object $logFormat = this.getLogFormat();
        result = result * prime + ($logFormat == null ? 43 : $logFormat.hashCode());
        Object $logLevel = this.getLogLevel();
        result = result * prime + ($logLevel == null ? 43 : $logLevel.hashCode());
        Object $minTime = this.getMinTime();
        result = result * prime + ($minTime == null ? 43 : $minTime.hashCode());
        Object $objectStorageConfig = this.getObjectStorageConfig();
        result = result * prime + ($objectStorageConfig == null ? 43 : $objectStorageConfig.hashCode());
        Object $objectStorageConfigFile = this.getObjectStorageConfigFile();
        result = result * prime + ($objectStorageConfigFile == null ? 43 : $objectStorageConfigFile.hashCode());
        Object $readyTimeout = this.getReadyTimeout();
        result = result * prime + ($readyTimeout == null ? 43 : $readyTimeout.hashCode());
        Object $resources = this.getResources();
        result = result * prime + ($resources == null ? 43 : $resources.hashCode());
        Object $sha = this.getSha();
        result = result * prime + ($sha == null ? 43 : $sha.hashCode());
        Object $tag = this.getTag();
        result = result * prime + ($tag == null ? 43 : $tag.hashCode());
        Object $tracingConfig = this.getTracingConfig();
        result = result * prime + ($tracingConfig == null ? 43 : $tracingConfig.hashCode());
        Object $tracingConfigFile = this.getTracingConfigFile();
        result = result * prime + ($tracingConfigFile == null ? 43 : $tracingConfigFile.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $volumeMounts = this.getVolumeMounts();
        result = result * prime + ($volumeMounts == null ? 43 : $volumeMounts.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ThanosSpec(" + "additionalArgs=" + this.getAdditionalArgs() + ", baseImage=" + this.getBaseImage() + ", blockSize=" + this.getBlockSize() + ", getConfigInterval=" + this.getGetConfigInterval() + ", getConfigTimeout=" + this.getGetConfigTimeout() + ", grpcListenLocal=" + this.getGrpcListenLocal() + ", grpcServerTlsConfig=" + this.getGrpcServerTlsConfig() + ", httpListenLocal=" + this.getHttpListenLocal() + ", image=" + this.getImage() + ", listenLocal=" + this.getListenLocal() + ", logFormat=" + this.getLogFormat() + ", logLevel=" + this.getLogLevel() + ", minTime=" + this.getMinTime() + ", objectStorageConfig=" + this.getObjectStorageConfig() + ", objectStorageConfigFile=" + this.getObjectStorageConfigFile() + ", readyTimeout=" + this.getReadyTimeout() + ", resources=" + this.getResources() + ", sha=" + this.getSha() + ", tag=" + this.getTag() + ", tracingConfig=" + this.getTracingConfig() + ", tracingConfigFile=" + this.getTracingConfigFile() + ", version=" + this.getVersion() + ", volumeMounts=" + this.getVolumeMounts() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
