package io.dekorate.crd.adapter;

import java.util.List;
import java.util.Map;

import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;

import io.dekorate.crd.annotation.CustomResource;
import io.dekorate.crd.config.CustomResourceConfig;
import io.dekorate.crd.config.CustomResourceConfigBuilder;
import io.dekorate.crd.config.Scale;
import io.dekorate.crd.config.Scope;

public class CustomResourceConfigAdapter {

    public static CustomResourceConfigBuilder newBuilder(CustomResource instance) {
        return new CustomResourceConfigBuilder(new io.dekorate.crd.config.CustomResourceConfig(null,
            null,
            instance.group(),
            instance.kind(),
            instance.name(),
            instance.plural(),
            instance.shortName(),
            instance.version(),
            instance.scope(),
            instance.scalable(),
            new Scale(instance.scale().specReplicasPath(),
            instance.scale().statusReplicasPath(),
            instance.scale().labelSelectorPath()),
            toStatusClassName(instance)));
    }

    public static CustomResourceConfig adapt(Map map) {
        return new io.dekorate.crd.config.CustomResourceConfig(
null,
null,
               (String)(map instanceof Map ? ((Map)map).getOrDefault("group", "") : ""),
               (String)(map instanceof Map ? ((Map)map).getOrDefault("kind", "") : ""),
               (String)(map instanceof Map ? ((Map)map).getOrDefault("name", "") : ""),
               (String)(map instanceof Map ? ((Map)map).getOrDefault("plural", "") : ""),
               (String)(map instanceof Map ? ((Map)map).getOrDefault("shortName", "") : ""),
               (String)(map instanceof Map ? ((Map)map).getOrDefault("version", "") : ""),
               Scope.valueOf(String.valueOf(map instanceof Map ? ((Map)map).getOrDefault("scope","Namespaced") : "Namespaced")),
               Boolean.parseBoolean(String.valueOf(map instanceof Map ? ((Map)map).getOrDefault("scalable","false") : "false")),
               new Scale(
                   (String)(((Map)(map instanceof Map ? ((Map)map).get("scale") : null)) instanceof Map ? ((Map)((Map)(map instanceof Map ? ((Map)map).get("scale") : null))).getOrDefault("specReplicasPath", ".spec.replicas") : ".spec.replicas"),
                   (String)(((Map)(map instanceof Map ? ((Map)map).get("scale") : null)) instanceof Map ? ((Map)((Map)(map instanceof Map ? ((Map)map).get("scale") : null))).getOrDefault("statusReplicasPath", ".status.replicas") : ".status.replicas"),
                   (String)(((Map)(map instanceof Map ? ((Map)map).get("scale") : null)) instanceof Map ? ((Map)((Map)(map instanceof Map ? ((Map)map).get("scale") : null))).getOrDefault("labelSelectorPath", ".status.labelSelector") : ".status.labelSelector")),
               (String)(map instanceof Map ? toStatusClassName(((Map)map).getOrDefault("status", CustomResourceConfig.VOID)) : CustomResourceConfig.VOID));
    }

    public static CustomResourceConfigBuilder newBuilder(Map map) {
        return new CustomResourceConfigBuilder(new io.dekorate.crd.config.CustomResourceConfig(
null,
null,
               (String)(map instanceof Map ? ((Map)map).getOrDefault("group", "") : ""),
               (String)(map instanceof Map ? ((Map)map).getOrDefault("kind", "") : ""),
               (String)(map instanceof Map ? ((Map)map).getOrDefault("name", "") : ""),
               (String)(map instanceof Map ? ((Map)map).getOrDefault("plural", "") : ""),
               (String)(map instanceof Map ? ((Map)map).getOrDefault("shortName", "") : ""),
               (String)(map instanceof Map ? ((Map)map).getOrDefault("version", "") : ""),
               Scope.valueOf(String.valueOf(map instanceof Map ? ((Map)map).getOrDefault("scope","Namespaced") : "Namespaced")),
                                               //,
               Boolean.parseBoolean(String.valueOf(map instanceof Map ? ((Map)map).getOrDefault("scalable","false") : "false")),
               new Scale(
                   (String)(((Map)(map instanceof Map ? ((Map)map).get("scale") : null)) instanceof Map ? ((Map)((Map)(map instanceof Map ? ((Map)map).get("scale") : null))).getOrDefault("specReplicasPath", ".spec.replicas") : ".spec.replicas"),
                   (String)(((Map)(map instanceof Map ? ((Map)map).get("scale") : null)) instanceof Map ? ((Map)((Map)(map instanceof Map ? ((Map)map).get("scale") : null))).getOrDefault("statusReplicasPath", ".status.replicas") : ".status.replicas"),
                   (String)(((Map)(map instanceof Map ? ((Map)map).get("scale") : null)) instanceof Map ? ((Map)((Map)(map instanceof Map ? ((Map)map).get("scale") : null))).getOrDefault("labelSelectorPath", ".status.labelSelector") : ".status.labelSelector")),
               (String)(map instanceof Map ? toStatusClassName(((Map)map).getOrDefault("status", CustomResourceConfig.VOID)) : CustomResourceConfig.VOID)));
    }

    public static String[] toStringArray(Object o) {
                if (o instanceof String[]) {
          return (String[]) o;
        }
        if (o instanceof String) {
          String s =  (String) o;
          return s.split(",[ ]*");
        }
        else if (o instanceof List) {
          List c = (List) o;
          String[] result = new String[c.size()]; 
          for (int i=0; i <= c.size(); i++) {
            result[i] = String.valueOf(c.get(i));
          }
          return result;
        }
        return new String[0];
    

    }

  private static String toStatusClassName(Object obj) {
    if (obj instanceof Void || Void.class.getName().equals(obj.toString())) {
      return CustomResourceConfig.VOID;
    } else if (obj instanceof String) {
      return (String) obj;
    } else if (obj instanceof TypeMirror) {
      return ((TypeMirror)obj).toString();
    } else if (obj instanceof CustomResource) {
      try {
        return ((CustomResource)obj).status().getCanonicalName();
      } catch (MirroredTypeException e) {
        return e.getTypeMirror().toString();
      }
    }
    throw new IllegalArgumentException("Cannot extract status class name from object:" + obj + ".");
  }
}
