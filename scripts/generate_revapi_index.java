/// usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 11+

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Generate an enhanced index for all Revapi reports with categorization.
 */
public class generate_revapi_index {

  static class Module implements Comparable<Module> {
    final String path;
    final String name;
    final Category category;

    Module(String path, String name) {
      this.path = path;
      this.name = name;
      this.category = categorize(path);
    }

    @Override
    public int compareTo(Module other) {
      return this.name.compareToIgnoreCase(other.name);
    }
  }

  enum Category {
    CORE("🎯 Core Modules"),
    MODEL("📦 Kubernetes Model Modules"),
    EXTENSION("🔌 Extensions"),
    TEST("🧪 Testing & Utilities"),
    OTHER("🔧 Other Modules");

    final String title;

    Category(String title) {
      this.title = title;
    }
  }

  static Category categorize(String path) {
    // Core modules
    if (path.matches("^(kubernetes-client-api|kubernetes-client|openshift-client-api|openshift-client|zjsonpatch|httpclient-).*") ||
      path.equals("kubernetes-client") || path.equals("kubernetes-client-api") ||
      path.equals("openshift-client") || path.equals("openshift-client-api") ||
      path.equals("zjsonpatch") || path.startsWith("httpclient-")) {
      return Category.CORE;
    }
    // Model modules
    if (path.contains("kubernetes-model-") || path.contains("openshift-model")) {
      return Category.MODEL;
    }
    // Extensions
    if (path.startsWith("extensions/")) {
      return Category.EXTENSION;
    }
    // Test modules
    if (path.contains("junit/") || path.contains("test") ||
      path.contains("examples") || path.contains("itests")) {
      return Category.TEST;
    }
    return Category.OTHER;
  }

  static List<Module> findRevapiReports(Path stagingDir) throws IOException {
    return Files.walk(stagingDir)
      .filter(p -> p.getFileName().toString().equals("revapi-report.html"))
      .map(p -> {
        Path modulePath = stagingDir.relativize(p.getParent());
        String name = modulePath.getFileName().toString();
        return new Module(modulePath.toString(), name);
      })
      .collect(Collectors.toList());
  }

  static String renderModuleList(List<Module> modules) {
    if (modules.isEmpty()) {
      return "      <p style=\"color: #999; font-style: italic;\">No modules in this category</p>\n";
    }

    StringBuilder sb = new StringBuilder();
    for (Module module : modules) {
      sb.append(String.format("""
          <div class="module-item">
            <a href="%s/revapi-report.html">%s</a>
            <div class="module-path">%s</div>
          </div>
        """, module.path, module.name, module.path));
    }
    return sb.toString();
  }

  static String generateHtml(List<Module> allModules) {
    Map<Category, List<Module>> byCategory = allModules.stream()
      .sorted()
      .collect(Collectors.groupingBy(m -> m.category,
        () -> new EnumMap<>(Category.class),
        Collectors.toList()));

    int coreCount = byCategory.getOrDefault(Category.CORE, List.of()).size();
    int modelCount = byCategory.getOrDefault(Category.MODEL, List.of()).size();
    int extensionCount = byCategory.getOrDefault(Category.EXTENSION, List.of()).size();
    int testCount = byCategory.getOrDefault(Category.TEST, List.of()).size();
    int otherCount = byCategory.getOrDefault(Category.OTHER, List.of()).size();

    StringBuilder html = new StringBuilder();

    // Header
    html.append("""
      <!DOCTYPE html>
      <html lang="en">
      <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Revapi API Compatibility Reports</title>
        <link rel="stylesheet" href="css/maven-base.css">
        <link rel="stylesheet" href="css/maven-theme.css">
        <style>
          body {
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
            line-height: 1.6;
            max-width: 1400px;
            margin: 0 auto;
            padding: 20px;
            background: #f5f5f5;
          }
          .container {
            background: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
          }
          h1 {
            color: #333;
            border-bottom: 3px solid #4CAF50;
            padding-bottom: 10px;
            margin-top: 0;
          }
          h2 {
            color: #555;
            margin-top: 30px;
            border-bottom: 2px solid #ddd;
            padding-bottom: 5px;
          }
          .stats {
            background: #e8f5e9;
            padding: 15px;
            border-radius: 5px;
            margin: 20px 0;
            border-left: 4px solid #4CAF50;
          }
          .module-list {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(350px, 1fr));
            gap: 12px;
            margin-top: 15px;
          }
          .module-item {
            background: #fafafa;
            border: 1px solid #e0e0e0;
            border-radius: 6px;
            padding: 12px 16px;
            transition: all 0.2s;
          }
          .module-item:hover {
            border-color: #4CAF50;
            box-shadow: 0 3px 8px rgba(0,0,0,0.15);
            background: white;
          }
          .module-item a {
            color: #1976d2;
            text-decoration: none;
            font-weight: 500;
            font-size: 0.95em;
          }
          .module-item a:hover {
            text-decoration: underline;
          }
          .module-path {
            font-size: 0.8em;
            color: #757575;
            font-family: 'Monaco', 'Menlo', 'Ubuntu Mono', monospace;
            margin-top: 4px;
          }
          .back-link {
            display: inline-block;
            margin-bottom: 20px;
            padding: 10px 20px;
            background: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-weight: 500;
          }
          .back-link:hover {
            background: #45a049;
          }
          .category-count {
            color: #757575;
            font-size: 0.9em;
            font-weight: normal;
          }
          .stat-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 15px;
            margin: 25px 0;
          }
          .stat-box {
            background: linear-gradient(135deg, #667eea 0%%, #764ba2 100%%);
            color: white;
            padding: 20px;
            border-radius: 8px;
            text-align: center;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
          }
          .stat-box.core {
            background: linear-gradient(135deg, #4CAF50 0%%, #45a049 100%%);
          }
          .stat-box.models {
            background: linear-gradient(135deg, #2196F3 0%%, #1976d2 100%%);
          }
          .stat-box.extensions {
            background: linear-gradient(135deg, #FF9800 0%%, #F57C00 100%%);
          }
          .stat-box.testing {
            background: linear-gradient(135deg, #9C27B0 0%%, #7B1FA2 100%%);
          }
          .stat-number {
            font-size: 2.5em;
            font-weight: bold;
            line-height: 1;
            margin-bottom: 5px;
          }
          .stat-label {
            font-size: 0.9em;
            opacity: 0.9;
            text-transform: uppercase;
            letter-spacing: 1px;
          }
          .intro {
            background: #f9f9f9;
            border-left: 4px solid #4CAF50;
            padding: 20px;
            margin: 20px 0;
            border-radius: 4px;
          }
          .intro p {
            margin: 8px 0;
            color: #555;
          }
        </style>
      </head>
      <body>
        <div class="container">
          <h1>Revapi API Compatibility Reports</h1>

          <div class="intro">
            <p><strong>Binary API Compatibility Analysis</strong> - Compare bytecode-level API changes between versions</p>
            <p>These reports identify breaking changes that would cause runtime errors (NoSuchMethodError, NoClassDefFoundError, etc.) when upgrading library versions without recompiling dependent code.</p>
          </div>

          <div class="stats">
            <h2 style="margin-top: 0;">📊 Overview Statistics</h2>
            <div class="stat-grid">
              <div class="stat-box">
                <div class="stat-number">%d</div>
                <div class="stat-label">Total Modules</div>
              </div>
              <div class="stat-box core">
                <div class="stat-number">%d</div>
                <div class="stat-label">Core Modules</div>
              </div>
              <div class="stat-box models">
                <div class="stat-number">%d</div>
                <div class="stat-label">Model Modules</div>
              </div>
              <div class="stat-box extensions">
                <div class="stat-number">%d</div>
                <div class="stat-label">Extensions</div>
              </div>
              <div class="stat-box testing">
                <div class="stat-number">%d</div>
                <div class="stat-label">Testing & Other</div>
              </div>
            </div>
          </div>
      """.formatted(allModules.size(), coreCount, modelCount, extensionCount, testCount + otherCount));

    // Render each category
    for (Category category : Category.values()) {
      List<Module> modules = byCategory.getOrDefault(category, List.of());
      html.append(String.format("""
            <h2>%s <span class="category-count">(%d)</span></h2>
            <div class="module-list">
        %s    </div>
        """, category.title, modules.size(), renderModuleList(modules)));
    }

    // Footer
    html.append("""
        </div>
      </body>
      </html>
      """);

    return html.toString();
  }

  public static void main(String[] args) throws IOException {
    System.out.println("Generating enhanced Revapi index...");

    Path stagingDir = Paths.get("target/staging");
    if (!Files.exists(stagingDir)) {
      System.err.println("Error: target/staging does not exist");
      System.exit(1);
    }

    // Find all modules with Revapi reports
    List<Module> modules = findRevapiReports(stagingDir);

    // Generate HTML
    String html = generateHtml(modules);

    // Write to file
    Path outputFile = stagingDir.resolve("revapi-index.html");
    Files.writeString(outputFile, html);

    System.out.println("✓ Enhanced index created at: " + outputFile);
    System.out.println("✓ Found " + modules.size() + " modules with Revapi reports");
  }
}
