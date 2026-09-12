
package io.fabric8.openshift.api.model.installer.nutanix.v1;

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

/**
 * Metadata contains Nutanix metadata (e.g. for uninstalling the cluster).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "password",
    "port",
    "prismCentral",
    "username"
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
public class Metadata implements Editable<MetadataBuilder>, KubernetesResource
{

    @JsonProperty("password")
    private String password;
    @JsonProperty("port")
    private String port;
    @JsonProperty("prismCentral")
    private String prismCentral;
    @JsonProperty("username")
    private String username;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Metadata() {
    }

    public Metadata(String password, String port, String prismCentral, String username) {
        super();
        this.password = password;
        this.port = port;
        this.prismCentral = prismCentral;
        this.username = username;
    }

    /**
     * Password is the password for the user to use to connect to the Prism Central.
     */
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    /**
     * Password is the password for the user to use to connect to the Prism Central.
     */
    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Port is the port used to connect to the Prism Central.
     */
    @JsonProperty("port")
    public String getPort() {
        return port;
    }

    /**
     * Port is the port used to connect to the Prism Central.
     */
    @JsonProperty("port")
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * PrismCentral is the domain name or IP address of the Prism Central.
     */
    @JsonProperty("prismCentral")
    public String getPrismCentral() {
        return prismCentral;
    }

    /**
     * PrismCentral is the domain name or IP address of the Prism Central.
     */
    @JsonProperty("prismCentral")
    public void setPrismCentral(String prismCentral) {
        this.prismCentral = prismCentral;
    }

    /**
     * Username is the name of the user to use to connect to the Prism Central.
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * Username is the name of the user to use to connect to the Prism Central.
     */
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public MetadataBuilder edit() {
        return new MetadataBuilder(this);
    }

    @JsonIgnore
    public MetadataBuilder toBuilder() {
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
        if (!(o instanceof Metadata)) {
            return false;
        }
        Metadata other = (Metadata) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$password = this.getPassword();
        Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) {
            return false;
        }
        Object this$port = this.getPort();
        Object other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
            return false;
        }
        Object this$prismCentral = this.getPrismCentral();
        Object other$prismCentral = other.getPrismCentral();
        if (this$prismCentral == null ? other$prismCentral != null : !this$prismCentral.equals(other$prismCentral)) {
            return false;
        }
        Object this$username = this.getUsername();
        Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) {
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
        return other instanceof Metadata;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $password = this.getPassword();
        result = result * prime + ($password == null ? 43 : $password.hashCode());
        Object $port = this.getPort();
        result = result * prime + ($port == null ? 43 : $port.hashCode());
        Object $prismCentral = this.getPrismCentral();
        result = result * prime + ($prismCentral == null ? 43 : $prismCentral.hashCode());
        Object $username = this.getUsername();
        result = result * prime + ($username == null ? 43 : $username.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Metadata(" + "password=" + this.getPassword() + ", port=" + this.getPort() + ", prismCentral=" + this.getPrismCentral() + ", username=" + this.getUsername() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
