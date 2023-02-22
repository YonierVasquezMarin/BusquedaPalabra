package archivo;

public enum ExtensionesDeArchivoPermitidas {
    TXT("txt"),
    XML("xml"),
    JSON("json"),
    CSV("csv");

    private String extension;

    ExtensionesDeArchivoPermitidas(String extension) {
        this.extension = extension;
    }

    public String toString() {
        return this.extension;
    }
}
