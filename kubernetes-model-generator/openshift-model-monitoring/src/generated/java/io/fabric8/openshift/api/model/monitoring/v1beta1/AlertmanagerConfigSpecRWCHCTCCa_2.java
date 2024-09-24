
package io.fabric8.openshift.api.model.monitoring.v1beta1;

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
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configMap",
    "secret"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class AlertmanagerConfigSpecRWCHCTCCa_2 implements Editable<AlertmanagerConfigSpecRWCHCTCCa_2Builder> , KubernetesResource
{

    @JsonProperty("configMap")
    private AlertmanagerConfigSpecRWCHCTCCConfigMap_4 configMap;
    @JsonProperty("secret")
    private AlertmanagerConfigSpecRWCHCTCCSecret_4 secret;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AlertmanagerConfigSpecRWCHCTCCa_2() {
    }

    public AlertmanagerConfigSpecRWCHCTCCa_2(AlertmanagerConfigSpecRWCHCTCCConfigMap_4 configMap, AlertmanagerConfigSpecRWCHCTCCSecret_4 secret) {
        super();
        this.configMap = configMap;
        this.secret = secret;
    }

    @JsonProperty("configMap")
    public AlertmanagerConfigSpecRWCHCTCCConfigMap_4 getConfigMap() {
        return configMap;
    }

    @JsonProperty("configMap")
    public void setConfigMap(AlertmanagerConfigSpecRWCHCTCCConfigMap_4 configMap) {
        this.configMap = configMap;
    }

    @JsonProperty("secret")
    public AlertmanagerConfigSpecRWCHCTCCSecret_4 getSecret() {
        return secret;
    }

    @JsonProperty("secret")
    public void setSecret(AlertmanagerConfigSpecRWCHCTCCSecret_4 secret) {
        this.secret = secret;
    }

    @JsonIgnore
    public AlertmanagerConfigSpecRWCHCTCCa_2Builder edit() {
        return new AlertmanagerConfigSpecRWCHCTCCa_2Builder(this);
    }

    @JsonIgnore
    public AlertmanagerConfigSpecRWCHCTCCa_2Builder toBuilder() {
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
