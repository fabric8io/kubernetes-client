
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
    "apiVersion",
    "alertRelabelings",
    "authorization",
    "basicAuth",
    "bearerTokenFile",
    "enableHttp2",
    "name",
    "namespace",
    "pathPrefix",
    "port",
    "relabelings",
    "scheme",
    "sigv4",
    "timeout",
    "tlsConfig"
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
public class AlertmanagerEndpoints implements Editable<AlertmanagerEndpointsBuilder>, KubernetesResource
{

    @JsonProperty("alertRelabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RelabelConfig> alertRelabelings = new ArrayList<>();
    @JsonProperty("apiVersion")
    private String apiVersion;
    @JsonProperty("authorization")
    private SafeAuthorization authorization;
    @JsonProperty("basicAuth")
    private BasicAuth basicAuth;
    @JsonProperty("bearerTokenFile")
    private String bearerTokenFile;
    @JsonProperty("enableHttp2")
    private Boolean enableHttp2;
    @JsonProperty("name")
    private String name;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("pathPrefix")
    private String pathPrefix;
    @JsonProperty("port")
    private IntOrString port;
    @JsonProperty("relabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RelabelConfig> relabelings = new ArrayList<>();
    @JsonProperty("scheme")
    private String scheme;
    @JsonProperty("sigv4")
    private Sigv4 sigv4;
    @JsonProperty("timeout")
    private String timeout;
    @JsonProperty("tlsConfig")
    private TLSConfig tlsConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AlertmanagerEndpoints() {
    }

    public AlertmanagerEndpoints(List<RelabelConfig> alertRelabelings, String apiVersion, SafeAuthorization authorization, BasicAuth basicAuth, String bearerTokenFile, Boolean enableHttp2, String name, String namespace, String pathPrefix, IntOrString port, List<RelabelConfig> relabelings, String scheme, Sigv4 sigv4, String timeout, TLSConfig tlsConfig) {
        super();
        this.alertRelabelings = alertRelabelings;
        this.apiVersion = apiVersion;
        this.authorization = authorization;
        this.basicAuth = basicAuth;
        this.bearerTokenFile = bearerTokenFile;
        this.enableHttp2 = enableHttp2;
        this.name = name;
        this.namespace = namespace;
        this.pathPrefix = pathPrefix;
        this.port = port;
        this.relabelings = relabelings;
        this.scheme = scheme;
        this.sigv4 = sigv4;
        this.timeout = timeout;
        this.tlsConfig = tlsConfig;
    }

    @JsonProperty("alertRelabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RelabelConfig> getAlertRelabelings() {
        return alertRelabelings;
    }

    @JsonProperty("alertRelabelings")
    public void setAlertRelabelings(List<RelabelConfig> alertRelabelings) {
        this.alertRelabelings = alertRelabelings;
    }

    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("authorization")
    public SafeAuthorization getAuthorization() {
        return authorization;
    }

    @JsonProperty("authorization")
    public void setAuthorization(SafeAuthorization authorization) {
        this.authorization = authorization;
    }

    @JsonProperty("basicAuth")
    public BasicAuth getBasicAuth() {
        return basicAuth;
    }

    @JsonProperty("basicAuth")
    public void setBasicAuth(BasicAuth basicAuth) {
        this.basicAuth = basicAuth;
    }

    @JsonProperty("bearerTokenFile")
    public String getBearerTokenFile() {
        return bearerTokenFile;
    }

    @JsonProperty("bearerTokenFile")
    public void setBearerTokenFile(String bearerTokenFile) {
        this.bearerTokenFile = bearerTokenFile;
    }

    @JsonProperty("enableHttp2")
    public Boolean getEnableHttp2() {
        return enableHttp2;
    }

    @JsonProperty("enableHttp2")
    public void setEnableHttp2(Boolean enableHttp2) {
        this.enableHttp2 = enableHttp2;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    @JsonProperty("pathPrefix")
    public String getPathPrefix() {
        return pathPrefix;
    }

    @JsonProperty("pathPrefix")
    public void setPathPrefix(String pathPrefix) {
        this.pathPrefix = pathPrefix;
    }

    @JsonProperty("port")
    public IntOrString getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(IntOrString port) {
        this.port = port;
    }

    @JsonProperty("relabelings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RelabelConfig> getRelabelings() {
        return relabelings;
    }

    @JsonProperty("relabelings")
    public void setRelabelings(List<RelabelConfig> relabelings) {
        this.relabelings = relabelings;
    }

    @JsonProperty("scheme")
    public String getScheme() {
        return scheme;
    }

    @JsonProperty("scheme")
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    @JsonProperty("sigv4")
    public Sigv4 getSigv4() {
        return sigv4;
    }

    @JsonProperty("sigv4")
    public void setSigv4(Sigv4 sigv4) {
        this.sigv4 = sigv4;
    }

    @JsonProperty("timeout")
    public String getTimeout() {
        return timeout;
    }

    @JsonProperty("timeout")
    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    @JsonProperty("tlsConfig")
    public TLSConfig getTlsConfig() {
        return tlsConfig;
    }

    @JsonProperty("tlsConfig")
    public void setTlsConfig(TLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    @JsonIgnore
    public AlertmanagerEndpointsBuilder edit() {
        return new AlertmanagerEndpointsBuilder(this);
    }

    @JsonIgnore
    public AlertmanagerEndpointsBuilder toBuilder() {
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
