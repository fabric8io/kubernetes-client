package io.fabric8.crd.generator.apt;

import com.google.testing.compile.Compilation;
import com.google.testing.compile.JavaFileObjects;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static com.google.testing.compile.Compiler.javac;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CRDGeneratorPropertiesTest {

  private static final String TEST_CLASS_CONTENT = "import io.fabric8.kubernetes.api.model.Namespaced;\n"
      + "import io.fabric8.kubernetes.client.CustomResource;\n"
      + "import io.fabric8.kubernetes.model.annotation.Group;\n"
      + "import io.fabric8.kubernetes.model.annotation.Version;"
      + "@Group(\"samples.javaoperatorsdk.io\")\n"
      + "@Version(\"v1alpha1\")"
      + "class Test extends CustomResource<Void, Void> implements Namespaced {}";

  @Test
  public void testPropertiesLoading() {
    List<String> classpaths = ClassPathUtils
        .getClassPathsAndReplace("test-classes", "properties");

    List<File> classpathFiles = classpaths.stream()
        .map(File::new).collect(Collectors.toList());

    Compilation compilation = javac()
        .withClasspath(classpathFiles)
        .withProcessors(new CustomResourceAnnotationProcessor())
        .compile(JavaFileObjects.forSourceLines("abc.Test", TEST_CLASS_CONTENT));

    compilation.diagnostics().forEach(d -> System.out.println(d.toString()));

    assertEquals(compilation.status(), Compilation.Status.SUCCESS);
    assertTrue(compilation.notes().stream()
        .anyMatch(diagnostic -> "Found crd-generator.properties".equals(diagnostic.getMessage(Locale.US))));
  }

}
