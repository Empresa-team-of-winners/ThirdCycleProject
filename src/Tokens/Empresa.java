package Tokens;

public class Empresa {
    /*Instance variables: states of Empresa
     */
    private String nombreEmpresa;
    private int nitEmpresa;
    private String direccioEmpresa;
    private String telefonoEmpresa;

    public Empresa(String nombreEmpresa, String direccioEmpresa, String telefonoEmpresa, int nitEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.direccioEmpresa = direccioEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.nitEmpresa = nitEmpresa;
    }

    //System.out.println("Hola compañero, debemos Modelar una empresa como clase java");

    public String getNombreEmpresa() {

        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {

        this.nombreEmpresa = nombreEmpresa;
    }

    public int getNitEmpresa() {

        return nitEmpresa;
    }

    public void setNitEmpresa(int nitEmpresa) {

        this.nitEmpresa = nitEmpresa;
    }

    public String getDireccioEmpresa() {

        return direccioEmpresa;
    }

    public void setDireccioEmpresa(String direccioEmpresa) {

        this.direccioEmpresa = direccioEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }
}