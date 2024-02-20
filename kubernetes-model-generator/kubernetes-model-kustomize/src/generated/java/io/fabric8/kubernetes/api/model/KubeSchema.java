
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.kustomize.v1beta1.Kustomization;

@Generated("jsonschema2pojo")
public class KubeSchema {

    private Kustomization kustomization;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KubeSchema() {
    }

    public KubeSchema(Kustomization kustomization) {
        super();
        this.kustomization = kustomization;
    }

    @JsonProperty("Kustomization")
    public Kustomization getKustomization() {
        return kustomization;
    }

    @JsonProperty("Kustomization")
    public void setKustomization(Kustomization kustomization) {
        this.kustomization = kustomization;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
