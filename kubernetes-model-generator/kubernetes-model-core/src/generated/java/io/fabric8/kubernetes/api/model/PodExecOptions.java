
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
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "command",
    "container",
    "stderr",
    "stdin",
    "stdout",
    "tty"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Version("v1")
@Group("")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PodExecOptions implements Editable<PodExecOptionsBuilder>, KubernetesResource
{

    @JsonProperty("apiVersion")
    private String apiVersion = "v1";
    @JsonProperty("command")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> command = new ArrayList<>();
    @JsonProperty("container")
    private String container;
    @JsonProperty("kind")
    private String kind = "PodExecOptions";
    @JsonProperty("stderr")
    private Boolean stderr;
    @JsonProperty("stdin")
    private Boolean stdin;
    @JsonProperty("stdout")
    private Boolean stdout;
    @JsonProperty("tty")
    private Boolean tty;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodExecOptions() {
    }

    public PodExecOptions(String apiVersion, List<String> command, String container, String kind, Boolean stderr, Boolean stdin, Boolean stdout, Boolean tty) {
        super();
        this.apiVersion = apiVersion;
        this.command = command;
        this.container = container;
        this.kind = kind;
        this.stderr = stderr;
        this.stdin = stdin;
        this.stdout = stdout;
        this.tty = tty;
    }

    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("command")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCommand() {
        return command;
    }

    @JsonProperty("command")
    public void setCommand(List<String> command) {
        this.command = command;
    }

    @JsonProperty("container")
    public String getContainer() {
        return container;
    }

    @JsonProperty("container")
    public void setContainer(String container) {
        this.container = container;
    }

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("stderr")
    public Boolean getStderr() {
        return stderr;
    }

    @JsonProperty("stderr")
    public void setStderr(Boolean stderr) {
        this.stderr = stderr;
    }

    @JsonProperty("stdin")
    public Boolean getStdin() {
        return stdin;
    }

    @JsonProperty("stdin")
    public void setStdin(Boolean stdin) {
        this.stdin = stdin;
    }

    @JsonProperty("stdout")
    public Boolean getStdout() {
        return stdout;
    }

    @JsonProperty("stdout")
    public void setStdout(Boolean stdout) {
        this.stdout = stdout;
    }

    @JsonProperty("tty")
    public Boolean getTty() {
        return tty;
    }

    @JsonProperty("tty")
    public void setTty(Boolean tty) {
        this.tty = tty;
    }

    @JsonIgnore
    public PodExecOptionsBuilder edit() {
        return new PodExecOptionsBuilder(this);
    }

    @JsonIgnore
    public PodExecOptionsBuilder toBuilder() {
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
        if (!(o instanceof PodExecOptions)) {
            return false;
        }
        PodExecOptions other = (PodExecOptions) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$command = this.getCommand();
        Object other$command = other.getCommand();
        if (this$command == null ? other$command != null : !this$command.equals(other$command)) {
            return false;
        }
        Object this$container = this.getContainer();
        Object other$container = other.getContainer();
        if (this$container == null ? other$container != null : !this$container.equals(other$container)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$stderr = this.getStderr();
        Object other$stderr = other.getStderr();
        if (this$stderr == null ? other$stderr != null : !this$stderr.equals(other$stderr)) {
            return false;
        }
        Object this$stdin = this.getStdin();
        Object other$stdin = other.getStdin();
        if (this$stdin == null ? other$stdin != null : !this$stdin.equals(other$stdin)) {
            return false;
        }
        Object this$stdout = this.getStdout();
        Object other$stdout = other.getStdout();
        if (this$stdout == null ? other$stdout != null : !this$stdout.equals(other$stdout)) {
            return false;
        }
        Object this$tty = this.getTty();
        Object other$tty = other.getTty();
        if (this$tty == null ? other$tty != null : !this$tty.equals(other$tty)) {
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
        return other instanceof PodExecOptions;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $command = this.getCommand();
        result = result * prime + ($command == null ? 43 : $command.hashCode());
        Object $container = this.getContainer();
        result = result * prime + ($container == null ? 43 : $container.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $stderr = this.getStderr();
        result = result * prime + ($stderr == null ? 43 : $stderr.hashCode());
        Object $stdin = this.getStdin();
        result = result * prime + ($stdin == null ? 43 : $stdin.hashCode());
        Object $stdout = this.getStdout();
        result = result * prime + ($stdout == null ? 43 : $stdout.hashCode());
        Object $tty = this.getTty();
        result = result * prime + ($tty == null ? 43 : $tty.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PodExecOptions(" + "apiVersion=" + this.getApiVersion() + ", command=" + this.getCommand() + ", container=" + this.getContainer() + ", kind=" + this.getKind() + ", stderr=" + this.getStderr() + ", stdin=" + this.getStdin() + ", stdout=" + this.getStdout() + ", tty=" + this.getTty() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
