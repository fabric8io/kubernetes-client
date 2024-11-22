
package io.fabric8.certmanager.api.model.v1;

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
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
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
    "auth",
    "caBundle",
    "caBundleSecretRef",
    "clientCertSecretRef",
    "clientKeySecretRef",
    "namespace",
    "path",
    "server"
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
public class VaultIssuer implements Editable<VaultIssuerBuilder> , KubernetesResource
{

    @JsonProperty("auth")
    private VaultAuth auth;
    @JsonProperty("caBundle")
    private String caBundle;
    @JsonProperty("caBundleSecretRef")
    private SecretKeySelector caBundleSecretRef;
    @JsonProperty("clientCertSecretRef")
    private SecretKeySelector clientCertSecretRef;
    @JsonProperty("clientKeySecretRef")
    private SecretKeySelector clientKeySecretRef;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("path")
    private String path;
    @JsonProperty("server")
    private String server;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VaultIssuer() {
    }

    public VaultIssuer(VaultAuth auth, String caBundle, SecretKeySelector caBundleSecretRef, SecretKeySelector clientCertSecretRef, SecretKeySelector clientKeySecretRef, String namespace, String path, String server) {
        super();
        this.auth = auth;
        this.caBundle = caBundle;
        this.caBundleSecretRef = caBundleSecretRef;
        this.clientCertSecretRef = clientCertSecretRef;
        this.clientKeySecretRef = clientKeySecretRef;
        this.namespace = namespace;
        this.path = path;
        this.server = server;
    }

    @JsonProperty("auth")
    public VaultAuth getAuth() {
        return auth;
    }

    @JsonProperty("auth")
    public void setAuth(VaultAuth auth) {
        this.auth = auth;
    }

    @JsonProperty("caBundle")
    public String getCaBundle() {
        return caBundle;
    }

    @JsonProperty("caBundle")
    public void setCaBundle(String caBundle) {
        this.caBundle = caBundle;
    }

    @JsonProperty("caBundleSecretRef")
    public SecretKeySelector getCaBundleSecretRef() {
        return caBundleSecretRef;
    }

    @JsonProperty("caBundleSecretRef")
    public void setCaBundleSecretRef(SecretKeySelector caBundleSecretRef) {
        this.caBundleSecretRef = caBundleSecretRef;
    }

    @JsonProperty("clientCertSecretRef")
    public SecretKeySelector getClientCertSecretRef() {
        return clientCertSecretRef;
    }

    @JsonProperty("clientCertSecretRef")
    public void setClientCertSecretRef(SecretKeySelector clientCertSecretRef) {
        this.clientCertSecretRef = clientCertSecretRef;
    }

    @JsonProperty("clientKeySecretRef")
    public SecretKeySelector getClientKeySecretRef() {
        return clientKeySecretRef;
    }

    @JsonProperty("clientKeySecretRef")
    public void setClientKeySecretRef(SecretKeySelector clientKeySecretRef) {
        this.clientKeySecretRef = clientKeySecretRef;
    }

    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("server")
    public String getServer() {
        return server;
    }

    @JsonProperty("server")
    public void setServer(String server) {
        this.server = server;
    }

    @JsonIgnore
    public VaultIssuerBuilder edit() {
        return new VaultIssuerBuilder(this);
    }

    @JsonIgnore
    public VaultIssuerBuilder toBuilder() {
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
