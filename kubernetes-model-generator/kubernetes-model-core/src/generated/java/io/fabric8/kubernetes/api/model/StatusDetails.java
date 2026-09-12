
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "causes",
    "group",
    "name",
    "retryAfterSeconds",
    "uid"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class StatusDetails implements Editable<StatusDetailsBuilder>, KubernetesResource
{

    @JsonProperty("causes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StatusCause> causes = new ArrayList<>();
    @JsonProperty("group")
    private String group;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("name")
    private String name;
    @JsonProperty("retryAfterSeconds")
    private Integer retryAfterSeconds;
    @JsonProperty("uid")
    private String uid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StatusDetails() {
    }

    public StatusDetails(List<StatusCause> causes, String group, String kind, String name, Integer retryAfterSeconds, String uid) {
        super();
        this.causes = causes;
        this.group = group;
        this.kind = kind;
        this.name = name;
        this.retryAfterSeconds = retryAfterSeconds;
        this.uid = uid;
    }

    @JsonProperty("causes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<StatusCause> getCauses() {
        return causes;
    }

    @JsonProperty("causes")
    public void setCauses(List<StatusCause> causes) {
        this.causes = causes;
    }

    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("retryAfterSeconds")
    public Integer getRetryAfterSeconds() {
        return retryAfterSeconds;
    }

    @JsonProperty("retryAfterSeconds")
    public void setRetryAfterSeconds(Integer retryAfterSeconds) {
        this.retryAfterSeconds = retryAfterSeconds;
    }

    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    @JsonIgnore
    public StatusDetailsBuilder edit() {
        return new StatusDetailsBuilder(this);
    }

    @JsonIgnore
    public StatusDetailsBuilder toBuilder() {
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
        if (!(o instanceof StatusDetails)) {
            return false;
        }
        StatusDetails other = (StatusDetails) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$causes = this.getCauses();
        Object other$causes = other.getCauses();
        if (this$causes == null ? other$causes != null : !this$causes.equals(other$causes)) {
            return false;
        }
        Object this$group = this.getGroup();
        Object other$group = other.getGroup();
        if (this$group == null ? other$group != null : !this$group.equals(other$group)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$retryAfterSeconds = this.getRetryAfterSeconds();
        Object other$retryAfterSeconds = other.getRetryAfterSeconds();
        if (this$retryAfterSeconds == null ? other$retryAfterSeconds != null : !this$retryAfterSeconds.equals(other$retryAfterSeconds)) {
            return false;
        }
        Object this$uid = this.getUid();
        Object other$uid = other.getUid();
        if (this$uid == null ? other$uid != null : !this$uid.equals(other$uid)) {
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
        return other instanceof StatusDetails;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $causes = this.getCauses();
        result = result * prime + ($causes == null ? 43 : $causes.hashCode());
        Object $group = this.getGroup();
        result = result * prime + ($group == null ? 43 : $group.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $retryAfterSeconds = this.getRetryAfterSeconds();
        result = result * prime + ($retryAfterSeconds == null ? 43 : $retryAfterSeconds.hashCode());
        Object $uid = this.getUid();
        result = result * prime + ($uid == null ? 43 : $uid.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "StatusDetails(" + "causes=" + this.getCauses() + ", group=" + this.getGroup() + ", kind=" + this.getKind() + ", name=" + this.getName() + ", retryAfterSeconds=" + this.getRetryAfterSeconds() + ", uid=" + this.getUid() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
