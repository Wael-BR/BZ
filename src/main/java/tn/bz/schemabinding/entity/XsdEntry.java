package tn.bz.schemabinding.entity;

public class XsdEntry {
    private final String fileName;
    private final String packageName;
    private final String id;

    public XsdEntry(String fileName) {
        this.fileName = fileName;
        String base = fileName.replace(".xsd", "");
        this.packageName = base.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // valid Java package
        this.id = base.replaceAll("[^a-zA-Z0-9]", "_"); // valid Maven id (no dashes)
    }

    public String getFileName() { return fileName; }
    public String getPackageName() { return packageName; }
    public String getId() { return id; }
}
