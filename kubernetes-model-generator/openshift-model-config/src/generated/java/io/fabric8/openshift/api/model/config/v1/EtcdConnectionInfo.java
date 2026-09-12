
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

/**
 * EtcdConnectionInfo holds information necessary for connecting to an etcd server
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ca",
    "certFile",
    "keyFile",
    "urls"
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
public class EtcdConnectionInfo implements Editable<EtcdConnectionInfoBuilder>, KubernetesResource
{

    @JsonProperty("ca")
    private String ca;
    @JsonProperty("certFile")
    private String certFile;
    @JsonProperty("keyFile")
    private String keyFile;
    @JsonProperty("urls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> urls = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EtcdConnectionInfo() {
    }

    public EtcdConnectionInfo(String ca, String certFile, String keyFile, List<String> urls) {
        super();
        this.ca = ca;
        this.certFile = certFile;
        this.keyFile = keyFile;
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
    public EtcdConnectionInfoBuilder edit() {
        return new EtcdConnectionInfoBuilder(this);
    }

    @JsonIgnore
    public EtcdConnectionInfoBuilder toBuilder() {
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
        if (!(o instanceof EtcdConnectionInfo)) {
            return false;
        }
        EtcdConnectionInfo other = (EtcdConnectionInfo) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ca = this.getCa();
        Object other$ca = other.getCa();
        if (this$ca == null ? other$ca != null : !this$ca.equals(other$ca)) {
            return false;
        }
        Object this$certFile = this.getCertFile();
        Object other$certFile = other.getCertFile();
        if (this$certFile == null ? other$certFile != null : !this$certFile.equals(other$certFile)) {
            return false;
        }
        Object this$keyFile = this.getKeyFile();
        Object other$keyFile = other.getKeyFile();
        if (this$keyFile == null ? other$keyFile != null : !this$keyFile.equals(other$keyFile)) {
            return false;
        }
        Object this$urls = this.getUrls();
        Object other$urls = other.getUrls();
        if (this$urls == null ? other$urls != null : !this$urls.equals(other$urls)) {
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
        return other instanceof EtcdConnectionInfo;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $ca = this.getCa();
        result = result * prime + ($ca == null ? 43 : $ca.hashCode());
        Object $certFile = this.getCertFile();
        result = result * prime + ($certFile == null ? 43 : $certFile.hashCode());
        Object $keyFile = this.getKeyFile();
        result = result * prime + ($keyFile == null ? 43 : $keyFile.hashCode());
        Object $urls = this.getUrls();
        result = result * prime + ($urls == null ? 43 : $urls.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EtcdConnectionInfo(" + "ca=" + this.getCa() + ", certFile=" + this.getCertFile() + ", keyFile=" + this.getKeyFile() + ", urls=" + this.getUrls() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
