/// usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 11+
//SOURCES generate_revapi_index.java

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Aggregate Revapi reports from all modules into a consolidated staging directory.
 */
public class aggregate_revapi_reports {

  static final String REDIRECT_HTML = """
    <!DOCTYPE html>
    <html>
    <head>
      <meta charset="UTF-8">
      <meta http-equiv="refresh" content="0; url=revapi-report.html">
      <title>Redirecting to Revapi Report</title>
    </head>
    <body>
      <p>Redirecting to <a href="revapi-report.html">Revapi Report</a>...</p>
    </body>
    </html>
    """;

  static class ModuleSite {
    final Path sourcePath;
    final String modulePath;

    ModuleSite(Path sourcePath, String modulePath) {
      this.sourcePath = sourcePath;
      this.modulePath = modulePath;
    }
  }

  public static void main(String[] args) throws IOException {
    System.out.println("Aggregating Revapi reports into target/staging...");

    Path rootDir = Paths.get(".");
    Path stagingDir = rootDir.resolve("target/staging");

    // Create staging directory
    Files.createDirectories(stagingDir);

    // Copy root project site if it exists
    Path rootSite = rootDir.resolve("target/site");
    if (Files.exists(rootSite)) {
      System.out.println("Copying root site...");
      copyDirectory(rootSite, stagingDir);
    }

    // Find all module sites with revapi-report.html
    List<ModuleSite> moduleSites = findModuleSites(rootDir);

    System.out.println("Found " + moduleSites.size() + " modules with Revapi reports");

    // Process each module
    for (ModuleSite site : moduleSites) {
      System.out.println("Processing module: " + site.modulePath);

      Path targetDir = stagingDir.resolve(site.modulePath);
      Files.createDirectories(targetDir);

      // Copy all site files
      copyDirectory(site.sourcePath, targetDir);

      // Create index.html redirect if it doesn't exist
      Path indexFile = targetDir.resolve("index.html");
      if (!Files.exists(indexFile)) {
        Files.writeString(indexFile, REDIRECT_HTML);
      }
    }

    System.out.println();
    System.out.println("✓ Aggregation complete!");
    System.out.println("✓ Total Revapi reports: " + moduleSites.size());

    // Generate enhanced index
    System.out.println("Generating enhanced index...");
    generate_revapi_index.main(new String[0]);

    System.out.println("✓ Open: target/staging/index.html");
    System.out.println("✓ Or view all modules: target/staging/revapi-index.html");
  }

  static List<ModuleSite> findModuleSites(Path rootDir) throws IOException {
    List<ModuleSite> sites = new ArrayList<>();

    Files.walkFileTree(rootDir, new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        // Skip target/staging to avoid recursion
        if (dir.endsWith("target/staging")) {
          return FileVisitResult.SKIP_SUBTREE;
        }
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (file.getFileName().toString().equals("revapi-report.html")) {
          Path siteDir = file.getParent();

          // Verify this is a target/site directory
          if (siteDir.endsWith("site") && siteDir.getParent().endsWith("target")) {
            // Extract module path relative to root
            Path moduleDir = siteDir.getParent().getParent();
            Path relativePath = rootDir.toAbsolutePath().normalize()
              .relativize(moduleDir.toAbsolutePath().normalize());

            sites.add(new ModuleSite(siteDir, relativePath.toString()));
          }
        }
        return FileVisitResult.CONTINUE;
      }
    });

    return sites;
  }

  static void copyDirectory(Path source, Path target) throws IOException {
    Files.walkFileTree(source, new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
        throws IOException {
        Path targetDir = target.resolve(source.relativize(dir));
        Files.createDirectories(targetDir);
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
        throws IOException {
        Path targetFile = target.resolve(source.relativize(file));
        Files.copy(file, targetFile, StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
      }
    });
  }
}
