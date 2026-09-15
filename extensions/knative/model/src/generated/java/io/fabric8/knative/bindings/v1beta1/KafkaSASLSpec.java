
package io.fabric8.knative.bindings.v1beta1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "enable",
    "password",
    "type",
    "user"
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
public class KafkaSASLSpec implements Editable<KafkaSASLSpecBuilder>, KubernetesResource
{

    @JsonProperty("enable")
    private Boolean enable;
    @JsonProperty("password")
    private SecretValueFromSource password;
    @JsonProperty("type")
    private SecretValueFromSource type;
    @JsonProperty("user")
    private SecretValueFromSource user;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public KafkaSASLSpec() {
    }

    public KafkaSASLSpec(Boolean enable, SecretValueFromSource password, SecretValueFromSource type, SecretValueFromSource user) {
        super();
        this.enable = enable;
        this.password = password;
        this.type = type;
        this.user = user;
    }

    @JsonProperty("enable")
    public Boolean getEnable() {
        return enable;
    }

    @JsonProperty("enable")
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    @JsonProperty("password")
    public SecretValueFromSource getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(SecretValueFromSource password) {
        this.password = password;
    }

    @JsonProperty("type")
    public SecretValueFromSource getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(SecretValueFromSource type) {
        this.type = type;
    }

    @JsonProperty("user")
    public SecretValueFromSource getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(SecretValueFromSource user) {
        this.user = user;
    }

    @JsonIgnore
    public KafkaSASLSpecBuilder edit() {
        return new KafkaSASLSpecBuilder(this);
    }

    @JsonIgnore
    public KafkaSASLSpecBuilder toBuilder() {
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
        if (!(o instanceof KafkaSASLSpec)) {
            return false;
        }
        KafkaSASLSpec other = (KafkaSASLSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$enable = this.getEnable();
        Object other$enable = other.getEnable();
        if (this$enable == null ? other$enable != null : !this$enable.equals(other$enable)) {
            return false;
        }
        Object this$password = this.getPassword();
        Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
            return false;
        }
        Object this$user = this.getUser();
        Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) {
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
        return other instanceof KafkaSASLSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $enable = this.getEnable();
        result = result * prime + ($enable == null ? 43 : $enable.hashCode());
        Object $password = this.getPassword();
        result = result * prime + ($password == null ? 43 : $password.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $user = this.getUser();
        result = result * prime + ($user == null ? 43 : $user.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "KafkaSASLSpec(" + "enable=" + this.getEnable() + ", password=" + this.getPassword() + ", type=" + this.getType() + ", user=" + this.getUser() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
