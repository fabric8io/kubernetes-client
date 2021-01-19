package io.dekorate.crd.adapter;

import java.util.List;
import java.util.Map;

import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;

import io.dekorate.crd.annotation.Crd;
import io.dekorate.crd.config.CustomResourceConfig;
import io.dekorate.crd.config.CustomResourceConfigBuilder;
import io.dekorate.crd.config.Scale;
import io.dekorate.crd.config.Scope;

public class CustomResourceConfigAdapter {

    public static CustomResourceConfigBuilder newBuilder(Crd instance) {
        return new CustomResourceConfigBuilder(new io.dekorate.crd.config.CustomResourceConfig(null,
            null,
            instance.group(),
            instance.kind(),
            instance.name(),
            instance.plural(),
            instance.shortName(),
            instance.version(),
            instance.served(),
            instance.storage(),
            instance.scope(),
            new Scale(instance.scale().specReplicasPath(),
            instance.scale().statusReplicasPath(),
            instance.scale().labalSelectorPath()),
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
               (boolean)(map instanceof Map ? ((Map)map).getOrDefault("served", true) : true),
               (boolean)(map instanceof Map ? ((Map)map).getOrDefault("storage", false) : false),
               Scope.valueOf(String.valueOf(map instanceof Map ? ((Map)map).getOrDefault("scope","Namespaced") : "Namespaced")),
               new Scale(
                   (String)(((Map)(map instanceof Map ? ((Map)map).get("scale") : null)) instanceof Map ? ((Map)((Map)(map instanceof Map ? ((Map)map).get("scale") : null))).getOrDefault("specReplicasPath", ".spec.replicas") : null),
                   (String)(((Map)(map instanceof Map ? ((Map)map).get("scale") : null)) instanceof Map ? ((Map)((Map)(map instanceof Map ? ((Map)map).get("scale") : null))).getOrDefault("statusReplicasPath", ".status.replicas") : null),
                   (String)(((Map)(map instanceof Map ? ((Map)map).get("scale") : null)) instanceof Map ? ((Map)((Map)(map instanceof Map ? ((Map)map).get("scale") : null))).getOrDefault("labalSelectorPath", ".status.labelSelector") : null)),
               (String)(map instanceof Map ? toStatusClassName(((Map)map).getOrDefault("status", CustomResourceConfig.AUTODETECT)) : CustomResourceConfig.AUTODETECT));
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
               (boolean)(map instanceof Map ? ((Map)map).getOrDefault("served", true) : true),
               (boolean)(map instanceof Map ? ((Map)map).getOrDefault("storage", false) : false),
               Scope.valueOf(String.valueOf(map instanceof Map ? ((Map)map).getOrDefault("scope","Namespaced") : "Namespaced")),
               new Scale(
                   (String)(((Map)(map instanceof Map ? ((Map)map).get("scale") : null)) instanceof Map ? ((Map)((Map)(map instanceof Map ? ((Map)map).get("scale") : null))).getOrDefault("specReplicasPath", ".spec.replicas") : null),
                   (String)(((Map)(map instanceof Map ? ((Map)map).get("scale") : null)) instanceof Map ? ((Map)((Map)(map instanceof Map ? ((Map)map).get("scale") : null))).getOrDefault("statusReplicasPath", ".status.replicas") : null),
                   (String)(((Map)(map instanceof Map ? ((Map)map).get("scale") : null)) instanceof Map ? ((Map)((Map)(map instanceof Map ? ((Map)map).get("scale") : null))).getOrDefault("labalSelectorPath", ".status.labelSelector") : null)),
               (String)(map instanceof Map ? toStatusClassName(((Map)map).getOrDefault("status", CustomResourceConfig.AUTODETECT)) : CustomResourceConfig.AUTODETECT)));
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
      return CustomResourceConfig.AUTODETECT;
    } else if (obj instanceof String) {
      return (String) obj;
    } else if (obj instanceof TypeMirror) {
      return ((TypeMirror)obj).toString();
    } else if (obj instanceof Crd) {
      try {
        return ((Crd)obj).status().getCanonicalName();
      } catch (MirroredTypeException e) {
        return e.getTypeMirror().toString();
      }
    }
    throw new IllegalArgumentException("Cannot extract status class name from object:" + obj + ".");
  }
}
