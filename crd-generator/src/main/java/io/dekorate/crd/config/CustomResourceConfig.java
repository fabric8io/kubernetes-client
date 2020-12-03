package io.dekorate.crd.config;

import io.dekorate.project.Project;
import io.dekorate.crd.annotation.Autodetect;
import io.dekorate.kubernetes.config.ConfigKey;
import io.dekorate.kubernetes.config.Configuration;
import java.lang.Object;
import java.lang.String;
import java.util.Map;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

@Buildable(builderPackage = "io.fabric8.kubernetes.api.builder", refs={@BuildableReference(Configuration.class)})
public class CustomResourceConfig extends Configuration {

    public static final String AUTODETECT = Autodetect.class.getName();

    private String group = "";
    private String kind = "";
    private String name = "";
    private String plural = "";
    private String shortName = "";
    private String version = "";
    private Scope scope = io.dekorate.crd.config.Scope.Namespaced;
    private Scale scale = null;
    private String statusClassName = AUTODETECT;

    public CustomResourceConfig() { 
    }


  public CustomResourceConfig(Project project,Map<ConfigKey,Object> attributes,String group,String kind,String name,String plural,String shortName,String version,Scope scope,Scale scale ,String statusClassName) { 
        super(project, attributes);
        this.group = group != null ? group : "";
        this.kind = kind != null ? kind : "";
        this.name = name != null ? name : "";
        this.plural = plural != null ? plural : "";
        this.shortName = shortName != null ? shortName : "";
        this.version = version != null ? version : "";
        this.scope = scope != null ? scope : Scope.Namespaced;
        this.scale = scale != null ? scale : null;
        this.statusClassName = statusClassName != null ? statusClassName : AUTODETECT;
    }


    public String getGroup() {
        return this.group;
    }

    public String getKind() {
        return this.kind;
    }

    public String getName() {
        return this.name;
    }

    public String getPlural() {
        return this.plural;
    }

    public String getShortName() {
        return this.shortName;
    }

    public String getVersion() {
        return this.version;
    }

    public Scope getScope() {
        return this.scope;
    }


    public Scale getScale() {
        return this.scale;
    }

    public String getStatusClassName() {
        return this.statusClassName;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CustomResourceConfig that = (CustomResourceConfig) o;
        if (group != null ? !group.equals(that.group) :that.group != null) return false;
        if (kind != null ? !kind.equals(that.kind) :that.kind != null) return false;
        if (name != null ? !name.equals(that.name) :that.name != null) return false;
        if (plural != null ? !plural.equals(that.plural) :that.plural != null) return false;
        if (shortName != null ? !shortName.equals(that.shortName) :that.shortName != null) return false;
        if (version != null ? !version.equals(that.version) :that.version != null) return false;
        if (scope != null ? !scope.equals(that.scope) :that.scope != null) return false;
        if (scale != null ? !scale.equals(that.scale) :that.scale != null) return false;
        if (statusClassName != null ? !statusClassName.equals(that.statusClassName) :that.statusClassName != null) return false;
        return true;
    }

    public int hashCode() {
      return java.util.Objects.hash(group,  kind,  name,  plural,  shortName,  version,  scope, scale,  statusClassName, super.hashCode());
    }

}
