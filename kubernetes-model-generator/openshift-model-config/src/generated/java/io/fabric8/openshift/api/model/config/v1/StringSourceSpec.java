
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
 * StringSourceSpec specifies a string value, or external location
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "env",
    "file",
    "keyFile",
    "value"
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
public class StringSourceSpec implements Editable<StringSourceSpecBuilder>, KubernetesResource
{

    @JsonProperty("env")
    private String env;
    @JsonProperty("file")
    private String file;
    @JsonProperty("keyFile")
    private String keyFile;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StringSourceSpec() {
    }

    public StringSourceSpec(String env, String file, String keyFile, String value) {
        super();
        this.env = env;
        this.file = file;
        this.keyFile = keyFile;
        this.value = value;
    }

    /**
     * env specifies an envvar containing the cleartext value, or an encrypted value if the keyFile is specified.
     */
    @JsonProperty("env")
    public String getEnv() {
        return env;
    }

    /**
     * env specifies an envvar containing the cleartext value, or an encrypted value if the keyFile is specified.
     */
    @JsonProperty("env")
    public void setEnv(String env) {
        this.env = env;
    }

    /**
     * file references a file containing the cleartext value, or an encrypted value if a keyFile is specified.
     */
    @JsonProperty("file")
    public String getFile() {
        return file;
    }

    /**
     * file references a file containing the cleartext value, or an encrypted value if a keyFile is specified.
     */
    @JsonProperty("file")
    public void setFile(String file) {
        this.file = file;
    }

    /**
     * keyFile references a file containing the key to use to decrypt the value.
     */
    @JsonProperty("keyFile")
    public String getKeyFile() {
        return keyFile;
    }

    /**
     * keyFile references a file containing the key to use to decrypt the value.
     */
    @JsonProperty("keyFile")
    public void setKeyFile(String keyFile) {
        this.keyFile = keyFile;
    }

    /**
     * value specifies the cleartext value, or an encrypted value if keyFile is specified.
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * value specifies the cleartext value, or an encrypted value if keyFile is specified.
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonIgnore
    public StringSourceSpecBuilder edit() {
        return new StringSourceSpecBuilder(this);
    }

    @JsonIgnore
    public StringSourceSpecBuilder toBuilder() {
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
        if (!(o instanceof StringSourceSpec)) {
            return false;
        }
        StringSourceSpec other = (StringSourceSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$env = this.getEnv();
        Object other$env = other.getEnv();
        if (this$env == null ? other$env != null : !this$env.equals(other$env)) {
            return false;
        }
        Object this$file = this.getFile();
        Object other$file = other.getFile();
        if (this$file == null ? other$file != null : !this$file.equals(other$file)) {
            return false;
        }
        Object this$keyFile = this.getKeyFile();
        Object other$keyFile = other.getKeyFile();
        if (this$keyFile == null ? other$keyFile != null : !this$keyFile.equals(other$keyFile)) {
            return false;
        }
        Object this$value = this.getValue();
        Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value)) {
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
        return other instanceof StringSourceSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $env = this.getEnv();
        result = result * prime + ($env == null ? 43 : $env.hashCode());
        Object $file = this.getFile();
        result = result * prime + ($file == null ? 43 : $file.hashCode());
        Object $keyFile = this.getKeyFile();
        result = result * prime + ($keyFile == null ? 43 : $keyFile.hashCode());
        Object $value = this.getValue();
        result = result * prime + ($value == null ? 43 : $value.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "StringSourceSpec(" + "env=" + this.getEnv() + ", file=" + this.getFile() + ", keyFile=" + this.getKeyFile() + ", value=" + this.getValue() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
