
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * APIServerEncryption is used to encrypt sensitive resources on the cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kms",
    "type"
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
public class APIServerEncryption implements Editable<APIServerEncryptionBuilder>, KubernetesResource
{

    @JsonProperty("kms")
    private KMSConfig kms;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public APIServerEncryption() {
    }

    public APIServerEncryption(KMSConfig kms, String type) {
        super();
        this.kms = kms;
        this.type = type;
    }

    /**
     * APIServerEncryption is used to encrypt sensitive resources on the cluster.
     */
    @JsonProperty("kms")
    public KMSConfig getKms() {
        return kms;
    }

    /**
     * APIServerEncryption is used to encrypt sensitive resources on the cluster.
     */
    @JsonProperty("kms")
    public void setKms(KMSConfig kms) {
        this.kms = kms;
    }

    /**
     * type defines what encryption type should be used to encrypt resources at the datastore layer. When this field is unset (i.e. when it is set to the empty string), identity is implied. The behavior of unset can and will change over time.  Even if encryption is enabled by default, the meaning of unset may change to a different encryption type based on changes in best practices.<br><p> <br><p> When encryption is enabled, all sensitive resources shipped with the platform are encrypted. This list of sensitive resources can and will change over time.  The current authoritative list is:<br><p> <br><p>   1. secrets<br><p>   2. configmaps<br><p>   3. routes.route.openshift.io<br><p>   4. oauthaccesstokens.oauth.openshift.io<br><p>   5. oauthauthorizetokens.oauth.openshift.io
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type defines what encryption type should be used to encrypt resources at the datastore layer. When this field is unset (i.e. when it is set to the empty string), identity is implied. The behavior of unset can and will change over time.  Even if encryption is enabled by default, the meaning of unset may change to a different encryption type based on changes in best practices.<br><p> <br><p> When encryption is enabled, all sensitive resources shipped with the platform are encrypted. This list of sensitive resources can and will change over time.  The current authoritative list is:<br><p> <br><p>   1. secrets<br><p>   2. configmaps<br><p>   3. routes.route.openshift.io<br><p>   4. oauthaccesstokens.oauth.openshift.io<br><p>   5. oauthauthorizetokens.oauth.openshift.io
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public APIServerEncryptionBuilder edit() {
        return new APIServerEncryptionBuilder(this);
    }

    @JsonIgnore
    public APIServerEncryptionBuilder toBuilder() {
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
        if (!(o instanceof APIServerEncryption)) {
            return false;
        }
        APIServerEncryption other = (APIServerEncryption) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$kms = this.getKms();
        Object other$kms = other.getKms();
        if (this$kms == null ? other$kms != null : !this$kms.equals(other$kms)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof APIServerEncryption;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $kms = this.getKms();
        result = result * prime + ($kms == null ? 43 : $kms.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "APIServerEncryption(" + "kms=" + this.getKms() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
