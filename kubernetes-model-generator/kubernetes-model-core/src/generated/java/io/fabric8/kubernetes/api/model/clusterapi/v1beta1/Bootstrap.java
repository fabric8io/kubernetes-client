
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configRef",
    "dataSecretName"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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
