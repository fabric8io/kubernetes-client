
package io.fabric8.openshift.api.model;

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

/**
 * BuildLogOptions is the REST options for a build log<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "container",
    "follow",
    "insecureSkipTLSVerifyBackend",
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
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
@Group("build.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class BuildLogOptions implements Editable<BuildLogOptionsBuilder>, KubernetesResource, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "build.openshift.io/v1";
    @JsonProperty("container")
    private String container;
    @JsonProperty("follow")
    private Boolean follow;
    @JsonProperty("insecureSkipTLSVerifyBackend")
    private Boolean insecureSkipTLSVerifyBackend;
    @JsonProperty("kind")
    private String kind = "BuildLogOptions";
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
     */
    public BuildLogOptions() {
    }

    public BuildLogOptions(String apiVersion, String container, Boolean follow, Boolean insecureSkipTLSVerifyBackend, String kind, Long limitBytes, Boolean nowait, Boolean previous, Long sinceSeconds, String sinceTime, Long tailLines, Boolean timestamps, Long version) {
        super();
        this.apiVersion = apiVersion;
        this.container = container;
        this.follow = follow;
        this.insecureSkipTLSVerifyBackend = insecureSkipTLSVerifyBackend;
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
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * cointainer for which to stream logs. Defaults to only container if there is one container in the pod.
     */
    @JsonProperty("container")
    public String getContainer() {
        return container;
    }

    /**
     * cointainer for which to stream logs. Defaults to only container if there is one container in the pod.
     */
    @JsonProperty("container")
    public void setContainer(String container) {
        this.container = container;
    }

    /**
     * follow if true indicates that the build log should be streamed until the build terminates.
     */
    @JsonProperty("follow")
    public Boolean getFollow() {
        return follow;
    }

    /**
     * follow if true indicates that the build log should be streamed until the build terminates.
     */
    @JsonProperty("follow")
    public void setFollow(Boolean follow) {
        this.follow = follow;
    }

    /**
     * insecureSkipTLSVerifyBackend indicates that the apiserver should not confirm the validity of the serving certificate of the backend it is connecting to.  This will make the HTTPS connection between the apiserver and the backend insecure. This means the apiserver cannot verify the log data it is receiving came from the real kubelet.  If the kubelet is configured to verify the apiserver's TLS credentials, it does not mean the connection to the real kubelet is vulnerable to a man in the middle attack (e.g. an attacker could not intercept the actual log data coming from the real kubelet).
     */
    @JsonProperty("insecureSkipTLSVerifyBackend")
    public Boolean getInsecureSkipTLSVerifyBackend() {
        return insecureSkipTLSVerifyBackend;
    }

    /**
     * insecureSkipTLSVerifyBackend indicates that the apiserver should not confirm the validity of the serving certificate of the backend it is connecting to.  This will make the HTTPS connection between the apiserver and the backend insecure. This means the apiserver cannot verify the log data it is receiving came from the real kubelet.  If the kubelet is configured to verify the apiserver's TLS credentials, it does not mean the connection to the real kubelet is vulnerable to a man in the middle attack (e.g. an attacker could not intercept the actual log data coming from the real kubelet).
     */
    @JsonProperty("insecureSkipTLSVerifyBackend")
    public void setInsecureSkipTLSVerifyBackend(Boolean insecureSkipTLSVerifyBackend) {
        this.insecureSkipTLSVerifyBackend = insecureSkipTLSVerifyBackend;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * limitBytes, If set, is the number of bytes to read from the server before terminating the log output. This may not display a complete final line of logging, and may return slightly more or slightly less than the specified limit.
     */
    @JsonProperty("limitBytes")
    public Long getLimitBytes() {
        return limitBytes;
    }

    /**
     * limitBytes, If set, is the number of bytes to read from the server before terminating the log output. This may not display a complete final line of logging, and may return slightly more or slightly less than the specified limit.
     */
    @JsonProperty("limitBytes")
    public void setLimitBytes(Long limitBytes) {
        this.limitBytes = limitBytes;
    }

    /**
     * noWait if true causes the call to return immediately even if the build is not available yet. Otherwise the server will wait until the build has started.
     */
    @JsonProperty("nowait")
    public Boolean getNowait() {
        return nowait;
    }

    /**
     * noWait if true causes the call to return immediately even if the build is not available yet. Otherwise the server will wait until the build has started.
     */
    @JsonProperty("nowait")
    public void setNowait(Boolean nowait) {
        this.nowait = nowait;
    }

    /**
     * previous returns previous build logs. Defaults to false.
     */
    @JsonProperty("previous")
    public Boolean getPrevious() {
        return previous;
    }

    /**
     * previous returns previous build logs. Defaults to false.
     */
    @JsonProperty("previous")
    public void setPrevious(Boolean previous) {
        this.previous = previous;
    }

    /**
     * sinceSeconds is a relative time in seconds before the current time from which to show logs. If this value precedes the time a pod was started, only logs since the pod start will be returned. If this value is in the future, no logs will be returned. Only one of sinceSeconds or sinceTime may be specified.
     */
    @JsonProperty("sinceSeconds")
    public Long getSinceSeconds() {
        return sinceSeconds;
    }

    /**
     * sinceSeconds is a relative time in seconds before the current time from which to show logs. If this value precedes the time a pod was started, only logs since the pod start will be returned. If this value is in the future, no logs will be returned. Only one of sinceSeconds or sinceTime may be specified.
     */
    @JsonProperty("sinceSeconds")
    public void setSinceSeconds(Long sinceSeconds) {
        this.sinceSeconds = sinceSeconds;
    }

    /**
     * BuildLogOptions is the REST options for a build log<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("sinceTime")
    public String getSinceTime() {
        return sinceTime;
    }

    /**
     * BuildLogOptions is the REST options for a build log<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("sinceTime")
    public void setSinceTime(String sinceTime) {
        this.sinceTime = sinceTime;
    }

    /**
     * tailLines, If set, is the number of lines from the end of the logs to show. If not specified, logs are shown from the creation of the container or sinceSeconds or sinceTime
     */
    @JsonProperty("tailLines")
    public Long getTailLines() {
        return tailLines;
    }

    /**
     * tailLines, If set, is the number of lines from the end of the logs to show. If not specified, logs are shown from the creation of the container or sinceSeconds or sinceTime
     */
    @JsonProperty("tailLines")
    public void setTailLines(Long tailLines) {
        this.tailLines = tailLines;
    }

    /**
     * timestamps, If true, add an RFC3339 or RFC3339Nano timestamp at the beginning of every line of log output. Defaults to false.
     */
    @JsonProperty("timestamps")
    public Boolean getTimestamps() {
        return timestamps;
    }

    /**
     * timestamps, If true, add an RFC3339 or RFC3339Nano timestamp at the beginning of every line of log output. Defaults to false.
     */
    @JsonProperty("timestamps")
    public void setTimestamps(Boolean timestamps) {
        this.timestamps = timestamps;
    }

    /**
     * version of the build for which to view logs.
     */
    @JsonProperty("version")
    public Long getVersion() {
        return version;
    }

    /**
     * version of the build for which to view logs.
     */
    @JsonProperty("version")
    public void setVersion(Long version) {
        this.version = version;
    }

    @JsonIgnore
    public BuildLogOptionsBuilder edit() {
        return new BuildLogOptionsBuilder(this);
    }

    @JsonIgnore
    public BuildLogOptionsBuilder toBuilder() {
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
