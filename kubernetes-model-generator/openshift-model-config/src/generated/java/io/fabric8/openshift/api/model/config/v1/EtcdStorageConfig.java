
package io.fabric8.openshift.api.model.config.v1;

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
    "ca",
    "certFile",
    "keyFile",
    "storagePrefix",
    "urls"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class EtcdStorageConfig implements Editable<EtcdStorageConfigBuilder>, KubernetesResource
{

    @JsonProperty("ca")
    private String ca;
    @JsonProperty("certFile")
    private String certFile;
    @JsonProperty("keyFile")
    private String keyFile;
    @JsonProperty("storagePrefix")
    private String storagePrefix;
    @JsonProperty("urls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> urls = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EtcdStorageConfig() {
    }

    public EtcdStorageConfig(String ca, String certFile, String keyFile, String storagePrefix, List<String> urls) {
        super();
        this.ca = ca;
        this.certFile = certFile;
        this.keyFile = keyFile;
        this.storagePrefix = storagePrefix;
        this.urls = urls;
    }

    /**
     * ca is a file containing trusted roots for the etcd server certificates
     */
    @JsonProperty("ca")
    public String getCa() {
        return ca;
    }

    /**
     * ca is a file containing trusted roots for the etcd server certificates
     */
    @JsonProperty("ca")
    public void setCa(String ca) {
        this.ca = ca;
    }

    /**
     * certFile is a file containing a PEM-encoded certificate
     */
    @JsonProperty("certFile")
    public String getCertFile() {
        return certFile;
    }

    /**
     * certFile is a file containing a PEM-encoded certificate
     */
    @JsonProperty("certFile")
    public void setCertFile(String certFile) {
        this.certFile = certFile;
    }

    /**
     * keyFile is a file containing a PEM-encoded private key for the certificate specified by CertFile
     */
    @JsonProperty("keyFile")
    public String getKeyFile() {
        return keyFile;
    }

    /**
     * keyFile is a file containing a PEM-encoded private key for the certificate specified by CertFile
     */
    @JsonProperty("keyFile")
    public void setKeyFile(String keyFile) {
        this.keyFile = keyFile;
    }

    /**
     * storagePrefix is the path within etcd that the OpenShift resources will be rooted under. This value, if changed, will mean existing objects in etcd will no longer be located.
     */
    @JsonProperty("storagePrefix")
    public String getStoragePrefix() {
        return storagePrefix;
    }

    /**
     * storagePrefix is the path within etcd that the OpenShift resources will be rooted under. This value, if changed, will mean existing objects in etcd will no longer be located.
     */
    @JsonProperty("storagePrefix")
    public void setStoragePrefix(String storagePrefix) {
        this.storagePrefix = storagePrefix;
    }

    /**
     * urls are the URLs for etcd
     */
    @JsonProperty("urls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getUrls() {
        return urls;
    }

    /**
     * urls are the URLs for etcd
     */
    @JsonProperty("urls")
    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    @JsonIgnore
    public EtcdStorageConfigBuilder edit() {
        return new EtcdStorageConfigBuilder(this);
    }

    @JsonIgnore
    public EtcdStorageConfigBuilder toBuilder() {
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
