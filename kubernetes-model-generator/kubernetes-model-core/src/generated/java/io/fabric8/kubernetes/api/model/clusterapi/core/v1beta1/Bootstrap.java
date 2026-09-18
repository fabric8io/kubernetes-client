
package io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1;

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
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.sundr.builder.annotations.Buildable;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configRef",
    "dataSecretName"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Bootstrap implements Editable<BootstrapBuilder>, KubernetesResource
{

    @JsonProperty("configRef")
    private ObjectReference configRef;
    @JsonProperty("dataSecretName")
    private String dataSecretName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Bootstrap() {
    }

    public Bootstrap(ObjectReference configRef, String dataSecretName) {
        super();
        this.configRef = configRef;
        this.dataSecretName = dataSecretName;
    }

    @JsonProperty("configRef")
    public ObjectReference getConfigRef() {
        return configRef;
    }

    @JsonProperty("configRef")
    public void setConfigRef(ObjectReference configRef) {
        this.configRef = configRef;
    }

    @JsonProperty("dataSecretName")
    public String getDataSecretName() {
        return dataSecretName;
    }

    @JsonProperty("dataSecretName")
    public void setDataSecretName(String dataSecretName) {
        this.dataSecretName = dataSecretName;
    }

    @JsonIgnore
    public BootstrapBuilder edit() {
        return new BootstrapBuilder(this);
    }

    @JsonIgnore
    public BootstrapBuilder toBuilder() {
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
        if (!(o instanceof Bootstrap)) {
            return false;
        }
        Bootstrap other = (Bootstrap) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$configRef = this.getConfigRef();
        Object other$configRef = other.getConfigRef();
        if (this$configRef == null ? other$configRef != null : !this$configRef.equals(other$configRef)) {
            return false;
        }
        Object this$dataSecretName = this.getDataSecretName();
        Object other$dataSecretName = other.getDataSecretName();
        if (this$dataSecretName == null ? other$dataSecretName != null : !this$dataSecretName.equals(other$dataSecretName)) {
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
        return other instanceof Bootstrap;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $configRef = this.getConfigRef();
        result = result * prime + ($configRef == null ? 43 : $configRef.hashCode());
        Object $dataSecretName = this.getDataSecretName();
        result = result * prime + ($dataSecretName == null ? 43 : $dataSecretName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Bootstrap(" + "configRef=" + this.getConfigRef() + ", dataSecretName=" + this.getDataSecretName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
