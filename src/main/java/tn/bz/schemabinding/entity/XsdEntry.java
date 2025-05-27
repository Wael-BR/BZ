package tn.bz.schemabinding.entity;

public class XsdEntry {
    private final String fileName;
    private final String packageName;
    private final String id;

    public XsdEntry(String fileName) {
        this.fileName = fileName;
        String base = fileName.replace(".xsd", "");
        this.packageName = base.replace("_", ".");
        this.id = base.replace("_", "-");
    }

    public String getFileName() { return fileName; }
    public String getPackageName() { return packageName; }
    public String getId() { return id; }
}


