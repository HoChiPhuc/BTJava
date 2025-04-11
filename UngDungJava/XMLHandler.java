package bài1;

public class XMLHandler {
    private String filePath;

    public XMLHandler(String filePath) {
        this.filePath = filePath;
    }

    public void addElement(String name) {
        FileManager.writeToXML(filePath, new ElementModel(name));
    }

    public String readXML() {
        return FileManager.readFromXML(filePath);
    }
}